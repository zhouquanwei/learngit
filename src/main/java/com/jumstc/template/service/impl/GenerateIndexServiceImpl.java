package com.jumstc.template.service.impl;

import com.jumstc.template.domain.entity.TAwsAccountFlow;
import com.jumstc.template.domain.mapper.TAwsAccountFlowDao;
import com.jumstc.template.service.GenerateIndexService;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 *
 *
 * @author EDZ
 * @version 1.0
 * @date 2022/6/8 16:14
 */
@Service
@Slf4j
public class GenerateIndexServiceImpl implements GenerateIndexService {

    @Resource
    private TAwsAccountFlowDao tAwsAccountFlowDao;
    /**
     * 导入lucene 生成索引文件
     */
    @Override
    public void syncLucene() throws Exception {
            List<TAwsAccountFlow> list= tAwsAccountFlowDao.selectByPageSize(0,50);
            createIndex(list);
    }




    public void createIndex(List<TAwsAccountFlow> list) throws Exception{
        for (TAwsAccountFlow item : list) {
            //1 创建文档对象
            Document document = new Document();
            // 创建并添加字段信息。参数：字段的名称、字段的值、是否存储，这里选Store.YES代表存储到文档列表。Store.NO代表不存储
            document.add(new LongField("id", item.getFlowId(), Field.Store.YES));
            // 这里我们title字段需要用TextField，即创建索引又会被分词。
            document.add(new TextField("pay_part_name", item.getReceivePartName(), Field.Store.YES));

            //2 索引目录类,指定索引在硬盘中的位置
            Directory directory = FSDirectory.open(new File("d:\\indexDir"));
            //3 创建分词器对象
            Analyzer analyzer = new StandardAnalyzer();
            //4 索引写出工具的配置对象
            IndexWriterConfig conf = new IndexWriterConfig(Version.LATEST, analyzer);
            //5 创建索引的写出工具类。参数：索引的目录和配置信息
            IndexWriter indexWriter = new IndexWriter(directory, conf);

            //6 把文档交给IndexWriter
            indexWriter.addDocument(document);
            //7 提交
            indexWriter.commit();
            //8 关闭
            indexWriter.close();
        }
    }

}

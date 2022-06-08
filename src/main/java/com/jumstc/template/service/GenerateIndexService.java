package com.jumstc.template.service;

/**
 *
 *
 * @author EDZ
 * @version 1.0
 * @date 2022/6/8 16:09
 */
public interface GenerateIndexService {
    /**
     * 导入lucene 生成索引文件
     */
    void syncLucene() throws Exception;
}

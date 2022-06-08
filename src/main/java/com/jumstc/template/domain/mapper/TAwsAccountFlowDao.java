package com.jumstc.template.domain.mapper;


import com.jumstc.template.domain.entity.TAwsAccountFlow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TAwsAccountFlowDao {
    int deleteByPrimaryKey(Long flowId);

    int insert(TAwsAccountFlow record);

    int insertSelective(TAwsAccountFlow record);

    List<TAwsAccountFlow> selectByPrimaryKey(@Param("page") Integer page, @Param("pageSize") Integer pageSize);


    List<TAwsAccountFlow> selectByPageSize(@Param("page") Integer page, @Param("pageSize") Integer pageSize);

    int updateByPrimaryKeySelective(TAwsAccountFlow record);

    int updateByPrimaryKey(TAwsAccountFlow record);
}
package com.sl.common;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisPagingItemReader;

import java.util.HashMap;
import java.util.Map;

/**
 * 分区读取数据库
 * @author shuliangzhao
 * @Title: CommonMybatisItemReader
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/15 20:14
 */
public class CommonPartitionMybatisItemReader<T> extends MyBatisPagingItemReader<T> {

    public CommonPartitionMybatisItemReader(SqlSessionFactory sqlSessionFactory, String name,String fromId,String toId) {
        setSqlSessionFactory(sqlSessionFactory);
        setQueryId("com.sl.entity."+name+".selectPartitionList");
        Map<String,Object> parameterValues = new HashMap<>();
        parameterValues.put("fromId", fromId);
        parameterValues.put("toId", toId);
        setParameterValues(parameterValues);
        setPageSize(100);
    }
}

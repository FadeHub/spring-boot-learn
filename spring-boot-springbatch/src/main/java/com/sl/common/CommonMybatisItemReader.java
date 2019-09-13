package com.sl.common;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisPagingItemReader;

/**
 * @author shuliangzhao
 * @Title: CommonMybatisItemReader
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/8 14:14
 */
public class CommonMybatisItemReader<T> extends MyBatisPagingItemReader<T> {

    public CommonMybatisItemReader(SqlSessionFactory sqlSessionFactory,String name) {
        setSqlSessionFactory(sqlSessionFactory);
        setQueryId("com.sl.entity."+name+".selectList");
        setPageSize(100);
    }
}

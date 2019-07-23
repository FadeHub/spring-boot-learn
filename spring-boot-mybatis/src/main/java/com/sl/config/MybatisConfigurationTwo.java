package com.sl.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author shuliangzhao
 * @Title: MybatisConfiguration
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/23 22:52
 */
@Configuration
@MapperScan(value = "com.sl.mapper2",sqlSessionFactoryRef = "sqlSessionFactoryBean2")
public class MybatisConfigurationTwo {

    @Resource(name = "dataSourceTwo")
    private DataSource dataSource;

    @Bean("sqlSessionFactoryBean2")
    public SqlSessionFactory sqlSessionFactoryBean2() throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean("sqlSessionTemplate2")
    public SqlSessionTemplate sqlSessionTemplate2() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryBean2());
    }
}

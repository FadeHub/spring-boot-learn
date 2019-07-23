package com.sl.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 加载多数据源
 * @author shuliangzhao
 * @Title: DataSourceConfig
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/23 22:04
 */
@Configuration
public class DataSourceConfig {

    @Bean("dataSourceOne")
    @ConfigurationProperties("spring.datasource.one")
    @Primary
    public DataSource dataSourceOne() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("dataSourceTwo")
    @ConfigurationProperties("spring.datasource.two")
    public DataSource dataSourceTwo() {
        return DruidDataSourceBuilder.create().build();
    }
}

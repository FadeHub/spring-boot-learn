package com.sl.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 根据不同数据源生成jdbcTemplate
 * @author shuliangzhao
 * @Title: JdbcConfiguration
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/23 22:07
 */
@Configuration
public class JdbcConfiguration {

    @Bean("jdbcTemplateOne")
    public JdbcTemplate jdbcTemplateOne(@Qualifier("dataSourceOne") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean("jdbcTemplateTwo")
    public JdbcTemplate jdbcTemplateTwo(@Qualifier("dataSourceTwo") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}

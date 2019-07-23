package com.sl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author shuliangzhao
 * @Title: JpaConfigurationOne
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/23 23:25
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.sl.dao1",
entityManagerFactoryRef = "entityManagerFactoryBeanOne",
transactionManagerRef = "platformTransactionManagerOne")
public class JpaConfigurationOne {

    @Resource(name = "dataSourceOne")
    private DataSource dataSource;

    @Autowired
    private JpaProperties jpaProperties;

    @Bean("entityManagerFactoryBeanOne")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBeanOne(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSource)
                .properties(jpaProperties.getProperties())
                .packages("com.sl.entity")
                .persistenceUnit("pu1")
                .build();
    }

    @Bean("platformTransactionManagerOne")
    @Primary
    public PlatformTransactionManager platformTransactionManagerOne(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryBeanOne(builder).getObject());
    }
}

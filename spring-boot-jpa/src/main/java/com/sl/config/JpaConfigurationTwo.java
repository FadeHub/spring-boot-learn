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
@EnableJpaRepositories(basePackages = "com.sl.dao2",
entityManagerFactoryRef = "entityManagerFactoryBeanTwo",
transactionManagerRef = "platformTransactionManagerTwo")
public class JpaConfigurationTwo {

    @Resource(name = "dataSourceTwo")
    private DataSource dataSource;

    @Autowired
    private JpaProperties jpaProperties;

    @Bean("entityManagerFactoryBeanTwo")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBeanTwo(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSource)
                .properties(jpaProperties.getProperties())
                .packages("com.sl.entity")
                .persistenceUnit("pu2")
                .build();
    }

    @Bean("platformTransactionManagerTwo")
    public PlatformTransactionManager platformTransactionManagerTwo(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryBeanTwo(builder).getObject());
    }
}

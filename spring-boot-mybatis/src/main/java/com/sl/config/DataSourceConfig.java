package com.sl.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public DataSource dataSourceOne() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("dataSourceTwo")
    @ConfigurationProperties("spring.datasource.two")
    public DataSource dataSourceTwo() {
        return DruidDataSourceBuilder.create().build();
    }

    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSourceOne());
        sqlSessionFactoryBean.setMapperLocations(resolveMapperLocations());
        return sqlSessionFactoryBean.getObject();
    }

    public Resource[] resolveMapperLocations() {
        ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        List<String> mapperLocations = new ArrayList<>();
        mapperLocations.add("classpath*:com/pab/cc/fas/mapper/*Mapper*.xml");
        mapperLocations.add("classpath*:com/pab/cc/ces/mapper/*Mapper*.xml");
        mapperLocations.add("classpath*:com/pab/cc/ams/mapper/*Mapper*.xml");
        List<Resource> resources = new ArrayList();
        if (mapperLocations != null) {
            for (String mapperLocation : mapperLocations) {
                try {
                    Resource[] mappers = resourceResolver.getResources(mapperLocation);
                    resources.addAll(Arrays.asList(mappers));
                } catch (IOException e) {
                    // ignore
                }
            }
        }
        return resources.toArray(new Resource[resources.size()]);
    }
}

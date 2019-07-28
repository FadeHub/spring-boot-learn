package com.sl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

/**
 * @author shuliangzhao
 * @Title: RestConfig
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/28 18:16
 */
@Configuration
public class RestConfig extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.setDefaultPageSize(2)
                .setPageParamName("page")
                .setLimitParamName("size")
                .setSortParamName("sort")
                .setBasePath("/api")
                .setReturnBodyOnCreate(true)
                .setReturnBodyOnCreate(true);
    }
}

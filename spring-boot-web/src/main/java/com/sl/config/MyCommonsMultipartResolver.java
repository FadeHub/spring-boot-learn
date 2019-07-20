package com.sl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @author shuliangzhao
 * @Title: MyCommonsMultipartResolver
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/20 11:16
 */
/*@Configuration
public class MyCommonsMultipartResolver {

    @Bean
    public CommonsMultipartResolver commonsMultipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setResolveLazily(true);//resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
        commonsMultipartResolver.setMaxUploadSize(1024);
        commonsMultipartResolver.setDefaultEncoding("UTF-8");
        return commonsMultipartResolver;
    }
}*/

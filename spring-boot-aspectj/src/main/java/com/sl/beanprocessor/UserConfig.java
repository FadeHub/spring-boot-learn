package com.sl.beanprocessor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shuliangzhao
 * @Title: UserConfig
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/10/22 19:50
 */
@Configuration
public class UserConfig {

    @Bean(initMethod = "initUser",destroyMethod = "destroyUser")
    public User user() {
         return new User();
    }

    @Bean
    public UserPostProcessor userPostProcessor() {
         return new UserPostProcessor();
    }
}

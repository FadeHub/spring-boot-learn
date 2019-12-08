package com.sl.learn.config;

import com.sl.learn.service.StaterService;
import com.sl.learn.starter.StaterProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shuliangzhao
 * @Title: StaterAutoConfiguration
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/12/5 20:39
 */
@Configuration
@EnableConfigurationProperties(StaterProperties.class)
public class StaterAutoConfiguration {

    @Bean
    @ConditionalOnBean
    public StaterService staterService() {
        return new StaterService();
    }
}

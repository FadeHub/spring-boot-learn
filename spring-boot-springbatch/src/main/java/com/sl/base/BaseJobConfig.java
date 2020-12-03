package com.sl.base;

import org.springframework.batch.core.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shuliangzhao
 * @Title: BaseJobConfig
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/1 20:23
 */
@Configuration
public class BaseJobConfig {

    @Autowired
    private BaseJobFactory baseJobFactory;

    @Autowired
    private BaseTasklet baseTasklet;

    @Bean
    public Step initBaseStep() {
        return baseJobFactory.createTasketStep("initBaseStep",baseTasklet);
    }
}

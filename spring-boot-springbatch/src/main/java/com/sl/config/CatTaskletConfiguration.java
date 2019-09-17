package com.sl.config;

import com.sl.tasklet.CatTasklet;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shuliangzhao
 * @Title: CatTaskletConfiguration
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/16 20:22
 */
@Configuration
@EnableBatchProcessing
public class CatTaskletConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private CatTasklet catTasklet;

    @Bean
    public Job catTaskletJob() {
        return jobBuilderFactory.get("catTaskletJob")
                .start(catTaskletStep())
                .build();
    }

    @Bean
    public Step catTaskletStep() {
        return stepBuilderFactory.get("catTaskletStep")
                .tasklet(catTasklet)
                .build();
    }

}

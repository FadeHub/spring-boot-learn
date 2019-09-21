package com.sl.config;

import com.sl.common.CommonConstants;
import com.sl.common.CustomItemReader;
import com.sl.common.CustomRestaItemReader;
import com.sl.listener.CustomJobListener;
import com.sl.writer.CustomItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义重启reader
 * @author shuliangzhao
 * @Title: CustomConfiguration
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/21 14:55
 */
@Configuration
@EnableBatchProcessing
public class CustomConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private CustomJobListener customJobListener;

    @Autowired
    private CustomItemWriter customItemWriter;

    @Bean
    public Job customJob() {
         return jobBuilderFactory.get("customJob")
                 .listener(customJobListener)
                 .start(customStep())
                 .build();
    }

    @Bean
    public Step customStep() {
        return stepBuilderFactory.get("customStep")
                .<String,String>chunk(10)
                .reader(customItemReader())
                .writer(customItemWriter)
                .build();
    }

    /*@Bean
    @StepScope
    public CustomItemReader<String> customItemReader() {
        return new CustomItemReader(CommonConstants.getList());
    }*/

    @Bean
    @StepScope
    public CustomRestaItemReader<String> customItemReader() {
        return new CustomRestaItemReader(CommonConstants.getList());
    }
}

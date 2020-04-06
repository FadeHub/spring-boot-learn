package com.sl.config;

import com.sl.common.CommonFileItemReader;
import com.sl.common.CommonMybatisItemWriter;
import com.sl.entity.CafeCat;
import com.sl.entity.Cat;
import com.sl.processor.CatProcessor;
import com.sl.processor.CustomCatProcessor;
import com.sl.reader.CustomFileItemReader;
import org.apache.ibatis.session.SqlSessionFactory;
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
 * @author shuliangzhao
 * @Title: CafeCatConfiguration
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/10 19:31
 */
@Configuration
@EnableBatchProcessing
public class CustomCafeCatConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private CustomCatProcessor customCatProcessor;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private CustomFileItemReader customFileItemReader;

    @Bean
    public Job customCafeCatJob() {
        return jobBuilderFactory.get("customCafeCatJob")
                .start(customCafeCatStep())
                .build();
    }

    @Bean
    public Step customCafeCatStep() {
        return stepBuilderFactory.get("customCafeCatStep")
                .<String, Cat>chunk(10)
                .reader(customFileItemReader)
                .processor(customCatProcessor)
                .writer(catCommonMybatisItemWriter1())
                .build();
    }


    @Bean
    @StepScope
    public CommonMybatisItemWriter<Cat> catCommonMybatisItemWriter1() {
         return new CommonMybatisItemWriter<>(sqlSessionFactory,Cat.class.getSimpleName());
    }
}

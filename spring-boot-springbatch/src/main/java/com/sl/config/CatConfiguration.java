package com.sl.config;

import com.sl.common.CommonFileItemWriter;
import com.sl.common.CommonMybatisItemReader;
import com.sl.entity.CafeCat;
import com.sl.entity.Cat;
import com.sl.listener.CatChunkListener;
import com.sl.listener.CatJobListener;
import com.sl.listener.CatStepListener;
import com.sl.processor.CafeCatProcessor;
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
import org.springframework.dao.DuplicateKeyException;

/**
 * @author shuliangzhao
 * @Title: UserConfiguration
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/7 17:06
 */
@Configuration
@EnableBatchProcessing
public class CatConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private CafeCatProcessor cafeCatProcessor;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private CatJobListener catJobListener;

    @Autowired
    private CatStepListener catStepListener;

    @Autowired
    private CatChunkListener catChunkListener;

    @Bean
    public Job catJob() {
         return jobBuilderFactory.get("catJob")
                 .start(catStep())
                 .listener(catJobListener)
                 .build();
    }

    @Bean
    public Step catStep() {
        return stepBuilderFactory.get("catStep")
                 .listener(catStepListener)
                .listener(catChunkListener)
                .<Cat, CafeCat>chunk(10)
                .reader(catCommonMybatisItemReader())
                .processor(cafeCatProcessor)
                .writer(cafeCatCommonFileItemWriter())
                .faultTolerant()
                .skip(DuplicateKeyException.class)
                .skipLimit(Integer.MAX_VALUE)
                .build();
    }

    @Bean
    @StepScope
    public CommonMybatisItemReader<Cat> catCommonMybatisItemReader() {
        return new CommonMybatisItemReader(sqlSessionFactory,Cat.class.getSimpleName());
    }

    @Bean
    @StepScope
    public CommonFileItemWriter<CafeCat> cafeCatCommonFileItemWriter() {
        return new CommonFileItemWriter<>(CafeCat.class);
    }

}

package com.sl.composite;

import com.sl.common.CommonFileItemWriter;
import com.sl.common.CommonMybatisItemReader;
import com.sl.entity.CafeCat;
import com.sl.entity.Cat;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author shuliangzhao
 * @Title: CompositeConfiguration
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/4/21 10:31
 */
@Configuration
@EnableBatchProcessing
public class CompositeConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private CatNameUpperProcessor catNameUpperProcessor;

    @Autowired
    private CatAddressUpperProcessor catAddressUpperProcessor;

    @Bean
    public Job compositeJob() {
       return jobBuilderFactory.get("compositeJob").start(compositeStep()).build();
    }

    @Bean
    public Step compositeStep() {
         return stepBuilderFactory.get("compositeStep").<Cat,CafeCat>chunk(10)
                 .reader(catCompositeCommonMybatisItemReader())
                 .processor(compositeItemProcessor())
                 .writer(cafeCatCompositeCommonFileItemWriter())
                 .build();
    }

    @Bean
    public CompositeItemProcessor<Cat,CafeCat> compositeItemProcessor() {
        CompositeItemProcessor compositeItemProcessor = new CompositeItemProcessor();
        compositeItemProcessor.setDelegates(Arrays.asList(catNameUpperProcessor,catAddressUpperProcessor));
        return compositeItemProcessor;
    }


    @Bean
    @StepScope
    public CommonFileItemWriter<CafeCat> cafeCatCompositeCommonFileItemWriter() {
        return new CommonFileItemWriter<>(CafeCat.class);
    }

    @Bean
    @StepScope
    public CommonMybatisItemReader<Cat> catCompositeCommonMybatisItemReader() {
        return new CommonMybatisItemReader(sqlSessionFactory,Cat.class.getSimpleName());
    }

}

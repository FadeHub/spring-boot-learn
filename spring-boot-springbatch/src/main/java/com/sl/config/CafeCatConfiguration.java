package com.sl.config;

import com.sl.common.CommonFileItemReader;
import com.sl.common.CommonMybatisItemWriter;
import com.sl.entity.CafeCat;
import com.sl.entity.Cat;
import com.sl.processor.CatProcessor;
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
public class CafeCatConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private CatProcessor catProcessor;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Bean
    public Job cafeCatJob() {
        return jobBuilderFactory.get("cafeCatJob")
                .start(cafeCatStep())
                .build();
    }

    @Bean
    public Step cafeCatStep() {
        return stepBuilderFactory.get("cafeCatStep")
                .<CafeCat, Cat>chunk(10)
                .reader(cafeCatCommonFileItemReader())
                .processor(catProcessor)
                .writer(catCommonMybatisItemWriter())
                .build();
    }

    @Bean
    @StepScope
    public CommonFileItemReader<CafeCat> cafeCatCommonFileItemReader() {
        return new CommonFileItemReader<>(CafeCat.class);
    }


    @Bean
    @StepScope
    public CommonMybatisItemWriter<Cat> catCommonMybatisItemWriter() {
         return new CommonMybatisItemWriter<>(sqlSessionFactory,Cat.class.getSimpleName());
    }
}

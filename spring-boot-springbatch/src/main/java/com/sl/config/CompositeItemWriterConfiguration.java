package com.sl.config;

import com.sl.common.CommonFileItemReader;
import com.sl.common.CommonFileItemWriter;
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
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @package: com.sl.config
 * @author: shuliangzhao
 * @description: 组合写
 * @date 2021/12/19 15:46
 */
@Configuration
@EnableBatchProcessing
public class CompositeItemWriterConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private CatProcessor catProcessor;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Bean
    public Job compositeWriterJob() {
        return jobBuilderFactory.get("compositeWriterJob")
                .start(compositeWriterStep())
                .build();
    }

    @Bean
    public Step compositeWriterStep() {
        return stepBuilderFactory.get("compositeWriterStep")
                .<CafeCat, Cat>chunk(10)
                .reader(compositeItemWriterCommonFileItemReader())
                .processor(catProcessor)
                .writer(catCompositeItemWriter())
                .build();
    }

    @Bean
    @StepScope
    public CommonFileItemReader<CafeCat> compositeItemWriterCommonFileItemReader() {
        return new CommonFileItemReader<>(CafeCat.class);
    }

    @Bean
    @StepScope
    public CompositeItemWriter<Cat> catCompositeItemWriter() {
        CompositeItemWriter<Cat> catCompositeItemWriter = new CompositeItemWriter<>();
        catCompositeItemWriter.setDelegates(Arrays.asList(compositeFileItemWriter(),compositeMybatisItemWriter()));
        return catCompositeItemWriter;
    }

    @Bean
    @StepScope
    public CommonFileItemWriter<Cat> compositeFileItemWriter() {
        return new CommonFileItemWriter<>(Cat.class);
    }

    @Bean
    @StepScope
    public CommonMybatisItemWriter<Cat> compositeMybatisItemWriter() {
        return new CommonMybatisItemWriter<>(sqlSessionFactory,Cat.class.getSimpleName());
    }
}

package com.sl.classifier;

import com.sl.common.CommonFileItemWriter;
import com.sl.common.CommonMybatisItemReader;
import com.sl.entity.Cat;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.support.ClassifierCompositeItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shuliangzhao
 * @Title: ClassifierConfiguration
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/4/21 14:00
 */
@Configuration
@EnableBatchProcessing
public class ClassifierConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private CatClassifierNameUpperProcessor catClassifierNameUpperProcessor;

    @Autowired
    private CatClassifierAddressUpperProcessor catClassifierAddressUpperProcessor;

    @Bean
    public Job classifierJob() {
        return jobBuilderFactory.get("classifierJob")
                .start(classifierStep())
                .build();
    }

    @Bean
    public Step classifierStep() {
        return stepBuilderFactory.get("classifierStep")
                .<Cat, Cat>chunk(10)
                .reader(catClassifierCommonMybatisItemReader())
                .processor(classifierCompositeItemProcessor())
                .writer(cafeCatClassifierCommonFileItemWriter())
                .build();
    }

    @Bean
    public ClassifierCompositeItemProcessor<Cat,Cat> classifierCompositeItemProcessor() {
        ClassifierCompositeItemProcessor classifierCompositeItemProcessor = new ClassifierCompositeItemProcessor();
        classifierCompositeItemProcessor.setClassifier(new CatClassifier(catClassifierNameUpperProcessor,catClassifierAddressUpperProcessor));
        return classifierCompositeItemProcessor;
    }

    @Bean
    @StepScope
    public CommonMybatisItemReader<Cat> catClassifierCommonMybatisItemReader() {
        return new CommonMybatisItemReader(sqlSessionFactory,Cat.class.getSimpleName());
    }

    @Bean
    @StepScope
    public CommonFileItemWriter<Cat> cafeCatClassifierCommonFileItemWriter() {
        return new CommonFileItemWriter<>(Cat.class);
    }

}

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
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.dao.DuplicateKeyException;

/**
 * 配置多线程
 * @author shuliangzhao
 * @Title: UserConfiguration
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/7 17:06
 */
@Configuration
@EnableBatchProcessing
public class CaThreadConfiguration {

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
    public Job catThreadJob() {
         return jobBuilderFactory.get("catThreadJob")
                 .start(catThreadStep())
                 .listener(catJobListener)
                 .build();
    }

    @Bean
    public Step catThreadStep() {
        return stepBuilderFactory.get("catThreadStep")
                // .listener(catStepListener)
                .listener(catChunkListener)
                .<Cat, CafeCat>chunk(10)
                .reader(catThreadCommonMybatisItemReader())
                .processor(cafeCatProcessor)
                .writer(cafeThreadCatCommonFileItemWriter())
                .taskExecutor(taskExecutor())
                .throttleLimit(8)
                .build();
    }

    @Bean
    public TaskExecutor taskExecutor(){
        return new SimpleAsyncTaskExecutor("spring_batch");
    }

    @Bean
    @StepScope
    public CommonMybatisItemReader<Cat> catThreadCommonMybatisItemReader() {
        return new CommonMybatisItemReader(sqlSessionFactory,Cat.class.getSimpleName());
    }

    @Bean
    @StepScope
    public CommonFileItemWriter<CafeCat> cafeThreadCatCommonFileItemWriter() {
        return new CommonFileItemWriter<>(CafeCat.class);
    }

}

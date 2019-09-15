package com.sl.config;

import com.sl.common.CommonFileItemReader;
import com.sl.common.CommonFileItemWriter;
import com.sl.common.CommonMybatisItemReader;
import com.sl.entity.CafeCat;
import com.sl.entity.Cat;
import com.sl.entity.People;
import com.sl.entity.Student;
import com.sl.listener.CatChunkListener;
import com.sl.listener.CatJobListener;
import com.sl.listener.CatStepListener;
import com.sl.processor.CafeCatProcessor;
import com.sl.processor.StudentProcessor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.job.flow.support.SimpleFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

/**
 * job并行执行
 * @author shuliangzhao
 * @Title: CatFlowConfiguration
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/14 20:10
 */
@Configuration
@EnableBatchProcessing
public class CatFlowConfiguration {

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

    @Autowired
    private StudentProcessor studentProcessor;

    @Bean
    public Job catFlowJob() {
         return jobBuilderFactory.get("catFlowJob")
                 .start(splitFlow())
                 .next(catFlowStep())
                 .build()
                 .build();
    }

    @Bean
    public Step catFlowStep() {
        return stepBuilderFactory.get("catFlowStep")
                // .listener(catStepListener)
                .listener(catChunkListener)
                .<Cat, CafeCat>chunk(10)
                .reader(catFlowCommonMybatisItemReader())
                .processor(cafeCatProcessor)
                .writer(cafeCatFlowCommonFileItemWriter())
                .taskExecutor(flowTaskExecutor())
                .throttleLimit(8)
                .build();
    }

    @Bean
    @StepScope
    public CommonMybatisItemReader<Cat> catFlowCommonMybatisItemReader() {
        return new CommonMybatisItemReader(sqlSessionFactory,Cat.class.getSimpleName());
    }

    @Bean
    @StepScope
    public CommonFileItemWriter<CafeCat> cafeCatFlowCommonFileItemWriter() {
        return new CommonFileItemWriter<>(CafeCat.class);
    }

    @Bean
    public Flow splitFlow() {
        return new FlowBuilder<SimpleFlow>("splitFlow")
                .split(flowTaskExecutor())
                .add(flow1(), flow2())
                .build();
    }

    @Bean
    public Flow flow1() {
        return new FlowBuilder<SimpleFlow>("flow1")
                .start(step1())
                .next(step2())
                .build();
    }

    @Bean
    public Flow flow2() {
        return new FlowBuilder<SimpleFlow>("flow2")
                .start(step3())
                .build();
    }

    @Bean
    public Step step3() {
        return stepBuilderFactory.get("step3")
                .<People, Student>chunk(10)
                .reader(step3flow2CommonFileItemReader())
                .processor(studentProcessor)
                .writer(step3flow2CommonFileItemWriter())
                .build();
    }

    @Bean
    @StepScope
    public CommonFileItemReader<People> step3flow2CommonFileItemReader() {
        return new CommonFileItemReader<>(People.class);
    }

    @Bean
    @StepScope
    public CommonFileItemWriter<Student> step3flow2CommonFileItemWriter() {
        return new CommonFileItemWriter<>(Student.class);
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<People, Student>chunk(10)
                .reader(step1flow1CommonFileItemReader())
                .processor(studentProcessor)
                .writer(step1flow1CommonFileItemWriter())
                .build();
    }

    @Bean
    @StepScope
    public CommonFileItemReader<People> step1flow1CommonFileItemReader() {
        return new CommonFileItemReader<>(People.class);
    }

    @Bean
    @StepScope
    public CommonFileItemWriter<Student> step1flow1CommonFileItemWriter() {
        return new CommonFileItemWriter<>(Student.class);
    }

    @Bean
    public Step step2() {
        return stepBuilderFactory.get("step2")
                .<People, Student>chunk(10)
                .reader(step2flow1CommonFileItemReader())
                .processor(studentProcessor)
                .writer(step2flow1CommonFileItemWriter())
                .build();
    }

    @Bean
    @StepScope
    public CommonFileItemReader<People> step2flow1CommonFileItemReader() {
        return new CommonFileItemReader<>(People.class);
    }

    @Bean
    @StepScope
    public CommonFileItemWriter<Student> step2flow1CommonFileItemWriter() {
        return new CommonFileItemWriter<>(Student.class);
    }

    @Bean
    public TaskExecutor flowTaskExecutor(){
        return new SimpleAsyncTaskExecutor("spring_batch");
    }
}

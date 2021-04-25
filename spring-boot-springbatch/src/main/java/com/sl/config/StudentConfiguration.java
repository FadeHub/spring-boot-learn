package com.sl.config;

import com.sl.common.CommonFileItemReader;
import com.sl.common.CommonFileItemWriter;
import com.sl.entity.People;
import com.sl.entity.Student;
import com.sl.processor.StudentProcessor;
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
 * @Title: UserConfiguration
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/7 17:06
 */
@Configuration
@EnableBatchProcessing
public class StudentConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private StudentProcessor studentProcessor;

    @Bean
    public Job studentJob() {
         return jobBuilderFactory.get("studentJob")
                 .start(studentStep())
                 .build();
    }

    @Bean
    public Step studentStep() {
        return stepBuilderFactory.get("studentStep")
                .<People, Student>chunk(10)
                .reader(peopleCommonFileItemReader())
                .processor(studentProcessor)
                .writer(studentCommonFileItemWriter())
                .build();
    }

    @Bean
    @StepScope
    public CommonFileItemReader<People> peopleCommonFileItemReader() {
        return new CommonFileItemReader<>(People.class);
    }

    @Bean
    @StepScope
    public CommonFileItemWriter<Student> studentCommonFileItemWriter() {
        return new CommonFileItemWriter<>(Student.class);
    }
}

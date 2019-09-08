package com.sl.config;

import com.sl.common.CommonFileItemWriter;
import com.sl.common.CommonMultiResourceItemReader;
import com.sl.common.CommonMultiResourceItemWriter;
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
 * @Title: StudentMultiConfiguration
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/8 12:41
 */
@Configuration
@EnableBatchProcessing
public class StudentMultiConfiguration {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private StudentProcessor studentProcessor;

    @Bean
    public Job studentMultiJob() {
        return jobBuilderFactory.get("studentMultiJob")
                .start(studentMulitStep())
                .build();
    }

    @Bean
    public Step studentMulitStep() {
        return stepBuilderFactory.get("studentMulitStep")
                .<People, Student>chunk(10)
                .reader(peopleCommonMultiResourceItemReader())
                .processor(studentProcessor)
                .writer(studentCommonMultiFileItemWriter())
                .build();
    }

    @Bean
    @StepScope
    public CommonMultiResourceItemReader<People> peopleCommonMultiResourceItemReader(){
        return new CommonMultiResourceItemReader<>(People.class);
    }

    @Bean
    @StepScope
    public CommonMultiResourceItemWriter<Student> studentCommonMultiFileItemWriter() {
        return new CommonMultiResourceItemWriter<>(Student.class);
    }
}

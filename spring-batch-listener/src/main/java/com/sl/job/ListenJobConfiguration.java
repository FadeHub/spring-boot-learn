package com.sl.job;

import com.sl.listener.*;
import com.sl.reader.MyItemReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author shuliangzhao
 * @Title: ListenJobConfiguration
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/7/12 14:55
 */
@Configuration
@EnableBatchProcessing
public class ListenJobConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private MyJobExecutionListener myJobExecutionListener;

    @Autowired
    private MyStepExecutionListener myStepExecutionListener;

    @Autowired
    private MyChunkListener myChunkListener;

    @Autowired
    private MyItemReadListener myItemReadListener;

    @Autowired
    private MyItemProcessListener myItemProcessListener;

    @Autowired
    private MyItemWriterListener myItemWriterListener;

    @Autowired
    private MySkipListener mySkipListener;

    @Bean
    public Job listenerJob() {
        return jobBuilderFactory.get("listenerJob")
                .listener(myJobExecutionListener)
                .start(listenerStep())
                .build();
    }

    @Bean
    public Step listenerStep() {
        return stepBuilderFactory.get("listenerStep")
                .listener(myStepExecutionListener)
                .<String,String>chunk(10)
                .faultTolerant()
                .listener(myChunkListener)
                .reader(reader())
                .listener(myItemReadListener)
                .processor(processor())
                .listener(myItemProcessListener)
                .writer(list -> list.forEach(System.out::println))
                .listener(myItemWriterListener)
                .listener(mySkipListener)
                .build();

    }

    @Bean
    @StepScope
    public ItemReader<String> reader() {
        List<String> data = Arrays.asList("java", "c++", "javascript", "python");
        return new MyItemReader(data);
    }

    @Bean
    @StepScope
    public ItemProcessor<String, String> processor() {
        return item -> item + " language";
    }

}

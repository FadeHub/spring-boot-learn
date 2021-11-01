package com.sl.adapter;

import com.sl.entity.People;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.MethodInvokingTaskletAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class TaskletAdapterConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    public PeopleService peopleService;

    @Bean
    public Job taskletAdapterJob() {
        return jobBuilderFactory.get("taskletAdapterJob")
                .start(taskletAdapterStep())
                .build();
    }

    @Bean
    public Step taskletAdapterStep() {
        return stepBuilderFactory.get("taskletAdapterStep")
                .tasklet(methodInvokingTaskletAdapter())
                .build();
    }

    @Bean
    public MethodInvokingTaskletAdapter methodInvokingTaskletAdapter() {
        MethodInvokingTaskletAdapter adapter = new MethodInvokingTaskletAdapter();
        adapter.setTargetObject(peopleService);
        adapter.setTargetMethod("upperCase");
        adapter.setArguments(new Object[]{new People("lee","10","北京","1233")});
        return adapter;
    }

}

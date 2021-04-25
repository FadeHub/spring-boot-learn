package com.sl.adapter;

import com.sl.common.CommonFileItemReader;
import com.sl.common.CommonFileItemWriter;
import com.sl.entity.People;
import com.sl.entity.Student;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.adapter.ItemProcessorAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ItemProcessor 适配器
 * @author shuliangzhao
 * @Title: AdapterProcessorConfiguration
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/4/25 20:11
 */
@Configuration
@EnableBatchProcessing
public class AdapterProcessorConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job peopleAdapterJob() {
        return jobBuilderFactory.get("peopleAdapterJob")
                .start(peopleAdapterStep())
                .build();
    }

    @Bean
    public Step peopleAdapterStep() {
        return stepBuilderFactory.get("peopleAdapterStep")
                .<People, People>chunk(10)
                .reader(peopleCommonFileItemReaderAdapter())
                .processor(peopleItemProcessorAdapter(null))
                .writer(peopleCommonFileItemWriterAdapter())
                .build();
    }

    @Bean
    public ItemProcessorAdapter<People,People> peopleItemProcessorAdapter(PeopleService peopleService) {
        ItemProcessorAdapter<People,People> adapter = new ItemProcessorAdapter<>();
        adapter.setTargetMethod("upperCase");
        adapter.setTargetObject(peopleService);
        return adapter;
    }

    @Bean
    @StepScope
    public CommonFileItemReader<People> peopleCommonFileItemReaderAdapter() {
        return new CommonFileItemReader<>(People.class);
    }

    @Bean
    @StepScope
    public CommonFileItemWriter<People> peopleCommonFileItemWriterAdapter() {
        return new CommonFileItemWriter<>(People.class);
    }
}

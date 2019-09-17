package com.sl.config;

import com.sl.common.CommonFileItemWriter;
import com.sl.common.CommonJsonItemReader;
import com.sl.entity.CafeCat;
import com.sl.entity.Cat;
import com.sl.processor.CatJsonProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

/**
 * json文件处理
 * @author shuliangzhao
 * @Title: CatJsonConfiguration
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/17 19:59
 */
@Configuration
@EnableBatchProcessing
public class CatJsonConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private CatJsonProcessor catJsonProcessor;

    @Bean
    public Job catJsonJob() {
        return jobBuilderFactory.get("catJsonJob")
                .start(catJsonStep())
                .build();
    }

    @Bean
    public Step catJsonStep() {
        return stepBuilderFactory.get("catJsonStep")
                .<Cat, CafeCat>chunk(10)
                .reader(commonJsonItemReader())
                .processor(catJsonProcessor)
                .writer(cafeCatJsonCommonFileItemWriter())
                .build();
    }

    @Bean
    @StepScope
    public CommonJsonItemReader<Cat> commonJsonItemReader() {
        FileSystemResource fileSystemResource = new FileSystemResource("D:\\aplus\\shuqian\\target\\"+Cat.class.getSimpleName()+".json");
         return new CommonJsonItemReader(fileSystemResource,new JacksonJsonObjectReader<>(Cat.class));
    }

    @Bean
    @StepScope
    public CommonFileItemWriter<CafeCat> cafeCatJsonCommonFileItemWriter() {
        return new CommonFileItemWriter<>(CafeCat.class);
    }
}

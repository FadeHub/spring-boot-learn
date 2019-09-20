package com.sl.config;

import com.sl.common.CommonFileItemReader;
import com.sl.common.CommonJsonItemWriter;
import com.sl.entity.CafeCat;
import com.sl.entity.Cat;
import com.sl.processor.CatWriteJsonProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.json.JacksonJsonObjectMarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

/**
 * 读取csv文件，写出json
 * @author shuliangzhao
 * @Title: CatWriteJsonConfiguration
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/18 19:56
 */
@Configuration
@EnableBatchProcessing
public class CatWriteJsonConfiguration {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private CatWriteJsonProcessor catWriteJsonProcessor;

    @Bean
    public Job catWriteJsonJob() {
        return jobBuilderFactory.get("catWriteJsonJob")
                .start(catWriteJsonStep())
                .build();
    }

    @Bean
    public Step catWriteJsonStep() {
        return stepBuilderFactory.get("catWriteJsonStep")
                .<Cat, CafeCat>chunk(10)
                .reader(catReadCsvItemReader())
                .processor(catWriteJsonProcessor)
                .writer(commonJsonItemWriter())
                .build();
    }

    @Bean
    @StepScope
    public CommonFileItemReader<Cat> catReadCsvItemReader() {
         return new CommonFileItemReader<>(Cat.class);
    }

    @Bean
    @StepScope
    public CommonJsonItemWriter commonJsonItemWriter() {
        FileSystemResource fileSystemResource = new FileSystemResource("D:\\aplus\\shuqian\\source\\"+ CafeCat.class.getSimpleName() + ".json");
        return new CommonJsonItemWriter(fileSystemResource,new JacksonJsonObjectMarshaller());
    }
}

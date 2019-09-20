package com.sl.config;

import com.sl.common.CommonFileItemWriter;
import com.sl.common.CommonXmlReader;
import com.sl.entity.CafeCat;
import com.sl.entity.Cat;
import com.sl.processor.CatXmlProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.xstream.XStreamMarshaller;

import java.util.HashMap;
import java.util.Map;

/**
 * xml解析
 * @author shuliangzhao
 * @Title: CatXmlConfiguration
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/19 19:53
 */
@Configuration
@EnableBatchProcessing
public class CatReadXmlConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private CatXmlProcessor catXmlProcessor;

    @Bean
    public Job catReadXmlJob() {
         return jobBuilderFactory.get("catReadXmlJob")
                 .start(catReadXmlStep())
                 .build();
    }

    @Bean
    public Step catReadXmlStep() {
        return stepBuilderFactory.get("catReadXmlStep")
             .<Cat, CafeCat>chunk(10)
             .reader(catCommonXmlReader())
             .processor(catXmlProcessor)
             .writer(cafeCatXmlCommonFileItemWriter())
             .build();
    }

    @Bean
    @StepScope
    public CommonXmlReader<Cat> catCommonXmlReader() {
        CommonXmlReader commonXmlReader = new CommonXmlReader(Cat.class);
        commonXmlReader.setUnmarshaller(tradeMarshaller());
        return commonXmlReader;
    }

    @Bean
    public XStreamMarshaller tradeMarshaller() {
        Map<String, Class> aliases = new HashMap<>();
        aliases.put("cat", Cat.class);
        aliases.put("id", Integer.class);
        aliases.put("catname", String.class);
        aliases.put("catage", String.class);
        aliases.put("cataddress", String.class);

        XStreamMarshaller marshaller = new XStreamMarshaller();

        marshaller.setAliases(aliases);
        return marshaller;
    }

    @Bean
    @StepScope
    public CommonFileItemWriter<CafeCat> cafeCatXmlCommonFileItemWriter() {
        return new CommonFileItemWriter<>(CafeCat.class);
    }

}

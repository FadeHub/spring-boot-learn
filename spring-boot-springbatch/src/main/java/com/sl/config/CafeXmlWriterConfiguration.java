package com.sl.config;

import com.sl.common.CommonFileItemReader;
import com.sl.common.CommonXmlWriter;
import com.sl.entity.CafeCat;
import com.sl.entity.Cat;
import com.sl.processor.CatProcessor;
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
 * 写出xml文件
 * @author shuliangzhao
 * @Title: CafeXmlWriterConfiguration
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/20 18:50
 */
@Configuration
@EnableBatchProcessing
public class CafeXmlWriterConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private CatProcessor catProcessor;

    @Bean
    public Job cafeXmlCatJob() {
        return jobBuilderFactory.get("cafeXmlCatJob")
                .start(cafeXmlCatStep())
                .build();
    }

    @Bean
    public Step cafeXmlCatStep() {
        return stepBuilderFactory.get("cafeXmlCatStep")
                .<CafeCat, Cat>chunk(10)
                .reader(cafeCatXmlCommonFileItemReader())
                .processor(catProcessor)
                .writer(commonXmlWriter())
                .build();
    }

    @Bean
    @StepScope
    public CommonFileItemReader<CafeCat> cafeCatXmlCommonFileItemReader() {
        return new CommonFileItemReader<>(CafeCat.class);
    }

    @Bean
    @StepScope
    public CommonXmlWriter commonXmlWriter() {
        return new CommonXmlWriter(tradeXmlMarshaller(),Cat.class);
    }

    @Bean
    public XStreamMarshaller tradeXmlMarshaller() {
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

}

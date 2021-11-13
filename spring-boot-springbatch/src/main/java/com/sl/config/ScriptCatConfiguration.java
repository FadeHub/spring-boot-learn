package com.sl.config;

import com.sl.common.CommonFileItemReader;
import com.sl.common.CommonMybatisItemWriter;
import com.sl.entity.CafeCat;
import com.sl.entity.Cat;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.support.ScriptItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;


/**
 * 执行脚本语言
 * @author: shuliangzhao
 * @date 2021/11/1311:19
 */
@Configuration
@EnableBatchProcessing
public class ScriptCatConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;



    @Bean
    public Job scriptCafeCatJob() {
        return jobBuilderFactory.get("scriptCafeCatJob")
                .start(scriptCafeCatStep())
                .build();
    }

    @Bean
    public Step scriptCafeCatStep() {
        return stepBuilderFactory.get("scriptCafeCatStep")
                .<CafeCat, Cat>chunk(10)
                .reader(scriptCatCommonFileItemReader())
                .processor(scriptItemProcessor(null))
                .writer(scriptCatCommonMybatisItemWriter())
                .build();
    }

    @Bean
    @StepScope
    public CommonFileItemReader<CafeCat> scriptCatCommonFileItemReader() {
        return new CommonFileItemReader<>(CafeCat.class);
    }

    @Bean
    @StepScope
    public ScriptItemProcessor<CafeCat,Cat> scriptItemProcessor(@Value("#{jobParameters['script']}") String script) {
        ScriptItemProcessor<CafeCat,Cat> scriptItemProcessor = new ScriptItemProcessor<>();
        Resource resource = new FileSystemResource(script);
        scriptItemProcessor.setScript(resource);
        return scriptItemProcessor;
    }

    @Bean
    @StepScope
    public CommonMybatisItemWriter<Cat> scriptCatCommonMybatisItemWriter() {
        return new CommonMybatisItemWriter<>(sqlSessionFactory,Cat.class.getSimpleName());
    }
}

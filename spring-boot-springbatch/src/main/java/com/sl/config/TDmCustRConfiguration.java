package com.sl.config;

import com.sl.common.CommonFileItemReader;
import com.sl.common.CommonFileItemWriter;
import com.sl.common.CommonMybatisItemReader;
import com.sl.common.CommonMybatisItemWriter;
import com.sl.entity.CafeCat;
import com.sl.entity.Cat;
import com.sl.entity.TDmCust;
import com.sl.listener.CatChunkListener;
import com.sl.listener.CatJobListener;
import com.sl.listener.CatStepListener;
import com.sl.processor.TDmCustProcessor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DuplicateKeyException;

/**
 * @author shuliangzhao
 * @Title: UserConfiguration
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/7 17:06
 */
@Configuration
@EnableBatchProcessing
public class TDmCustRConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private TDmCustProcessor tDmCustProcessor;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private CatJobListener catJobListener;

    @Autowired
    private CatStepListener catStepListener;

    @Autowired
    private CatChunkListener catChunkListener;

    @Bean
    public Job tDmCustRJob() {
         return jobBuilderFactory.get("tDmCustRJob")
                 .start(tDmCustRStep())
                 .listener(catJobListener)
                 .build();
    }

    @Bean
    public Step tDmCustRStep() {
        return stepBuilderFactory.get("tDmCustRStep")
                .<TDmCust, TDmCust>chunk(1000)
                .reader(tDmCustommonFileItemReader())
                .processor(tDmCustProcessor)
                .writer(tDmCustCommonMybatisItemWriter())
                .build();
    }

    @Bean
    @StepScope
    public CommonFileItemReader<TDmCust> tDmCustommonFileItemReader() {
        return new CommonFileItemReader<>(TDmCust.class);
    }


    @Bean
    @StepScope
    public CommonMybatisItemWriter<TDmCust> tDmCustCommonMybatisItemWriter() {
        return new CommonMybatisItemWriter<>(sqlSessionFactory,TDmCust.class.getSimpleName());
    }

}

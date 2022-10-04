package com.sl.config;

import com.sl.common.CommonFileItemWriter;
import com.sl.common.CommonMybatisItemReader;
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
public class TDmCustConfiguration {

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
    public Job tDmCustJob() {
         return jobBuilderFactory.get("tDmCustJob")
                 .start(tDmCustStep())
                 .listener(catJobListener)
                 .build();
    }

    @Bean
    public Step tDmCustStep() {
        return stepBuilderFactory.get("tDmCustStep")
                .<TDmCust, TDmCust>chunk(1000)
                .reader(tDmCustCommonMybatisItemReader())
                .processor(tDmCustProcessor)
                .writer(TDmCustCommonFileItemWriter())
                .faultTolerant()
                .skip(DuplicateKeyException.class)
                .skipLimit(Integer.MAX_VALUE)
                .build();
    }

    @Bean
    @StepScope
    public CommonMybatisItemReader<TDmCust> tDmCustCommonMybatisItemReader() {
        return new CommonMybatisItemReader(sqlSessionFactory, TDmCust.class.getSimpleName());
    }

    @Bean
    @StepScope
    public CommonFileItemWriter<TDmCust> TDmCustCommonFileItemWriter() {
        return new CommonFileItemWriter<>(TDmCust.class);
    }

}

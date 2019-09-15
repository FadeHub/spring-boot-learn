package com.sl.config;

import com.sl.common.CommonPartitionFileItemWriter;
import com.sl.common.CommonPartitionMybatisItemReader;
import com.sl.entity.CafeCat;
import com.sl.entity.Cat;
import com.sl.partition.CatPartitioner;
import com.sl.processor.CatPartitionProcessor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.partition.PartitionHandler;
import org.springframework.batch.core.partition.support.TaskExecutorPartitionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

/**
 * 分区job
 * @author shuliangzhao
 * @Title: CatPartitionerJob
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/15 19:56
 */
@Configuration
@EnableBatchProcessing
public class CatMasterPartitionerJob {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private CatPartitioner catPartitioner;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private CatPartitionProcessor catPartitionProcessor;


    @Bean   
    public Job catPartitionerJob() {
         return jobBuilderFactory.get("catPartitionerJob")
                 .start(catMasterStep())
                 .build();
    }

    @Bean
    public Step catMasterStep() {
        return stepBuilderFactory.get("catMasterStep").partitioner(catSlaveStep().getName(),catPartitioner)
                .partitionHandler(catPartitionHandler()).build();
    }

    @Bean
    public PartitionHandler catPartitionHandler() {
        TaskExecutorPartitionHandler handler = new TaskExecutorPartitionHandler();
        handler.setGridSize(10);
        handler.setTaskExecutor(catPartitionHandlerTaskExecutor());
        handler.setStep(catSlaveStep());
        try {
            handler.afterPropertiesSet();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return handler;
    }

    @Bean
    public SimpleAsyncTaskExecutor catPartitionHandlerTaskExecutor() {
        return new SimpleAsyncTaskExecutor();
    }

    @Bean
    public Step catSlaveStep() {
        return stepBuilderFactory.get("catSlaveStep")
                .<Cat, CafeCat>chunk(10)
                .reader(commonPartitionMybatisItemReader(null,null))
                .processor(catPartitionProcessor)
                .writer(commonPartitionFileItemWriter(null,null))
                .build();
    }

    @Bean
    @StepScope
    public CommonPartitionMybatisItemReader commonPartitionMybatisItemReader( @Value("#{stepExecutionContext[fromId]}") final String fromId,
                                                                              @Value("#{stepExecutionContext[toId]}") final String toId) {
        return new CommonPartitionMybatisItemReader(sqlSessionFactory, Cat.class.getSimpleName(),fromId,toId);
    }

    @Bean
    @StepScope
    public CommonPartitionFileItemWriter commonPartitionFileItemWriter(@Value("#{stepExecutionContext[fromId]}") final String fromId,
                                                                       @Value("#{stepExecutionContext[toId]}") final String toId) {
         return new CommonPartitionFileItemWriter(CafeCat.class,fromId,toId);
    }
}

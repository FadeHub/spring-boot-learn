package com.sl.config;

import com.sl.entity.CreditBill;
import com.sl.processor.PartitonMultiFileProcessor;
import com.sl.reader.MulitiLineRecordReader;
import com.sl.writer.PartitionMultiFileWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 读记录跨多行文件
 * @author shuliangzhao
 * @Title: MulitiLineConfiguration
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/6 13:38
 */
@Configuration
@EnableBatchProcessing
public class MulitiLineConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private PartitonMultiFileProcessor partitonMultiFileProcessor;

    @Autowired
    private PartitionMultiFileWriter partitionMultiFileWriter;

    @Bean
    public Job mulitiLineJob() {
       return jobBuilderFactory.get("mulitiLineJob").start(mulitiLineStep()).build();
    }

    @Bean
    public Step mulitiLineStep() {
        return stepBuilderFactory.get("mulitiLineStep")
                .<CreditBill,CreditBill>chunk(12)
                .reader(mulitiLineRecordReader())
                .processor(partitonMultiFileProcessor)
                .writer(partitionMultiFileWriter)
                .build();
    }

    @Bean
    @StepScope
    public MulitiLineRecordReader mulitiLineRecordReader() {
        return new MulitiLineRecordReader(CreditBill.class);
    }
}

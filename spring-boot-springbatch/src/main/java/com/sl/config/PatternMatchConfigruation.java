package com.sl.config;

import com.sl.dto.CreditAndDebitBill;
import com.sl.entity.CreditBill;
import com.sl.entity.DebitBill;
import com.sl.processor.PatternMatchProcessor;
import com.sl.reader.PatternMatchFileReader;
import com.sl.writer.PatternMatchWriter;
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
 * @author shuliangzhao
 * @Title: PatternMatchConfigruation
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/6 14:18
 */
@Configuration
@EnableBatchProcessing
public class PatternMatchConfigruation {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private PatternMatchProcessor patternMatchProcessor;

    @Autowired
    private PatternMatchWriter patternMatchWriter;

    @Bean
    public Job patternMatchJob() {
        return jobBuilderFactory.get("patternMatchJob")
                .start(patternMatchStep())
                .build();
    }

    @Bean
    public Step patternMatchStep() {
        return stepBuilderFactory.get("patternMatchStep")
                .<CreditAndDebitBill,CreditAndDebitBill>chunk(2)
                .reader(patternMatchFileReader())
                .processor(patternMatchProcessor)
                .writer(patternMatchWriter)
                .build();
    }

    @Bean
    @StepScope
    public PatternMatchFileReader patternMatchFileReader() {
        return new PatternMatchFileReader(CreditBill.class, DebitBill.class);
    }
}

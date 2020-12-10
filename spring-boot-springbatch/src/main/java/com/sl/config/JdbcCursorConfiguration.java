package com.sl.config;

import com.sl.common.CommonConstants;
import com.sl.entity.CreditBill;
import com.sl.processor.JdbcCursorProcessor;
import com.sl.reader.CommonJdbcCursorReader;
import com.sl.writer.JdbcCursorWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author shuliangzhao
 * @Title: JdbcCursorConfiguration
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/10 21:41
 */
@Configuration
@EnableBatchProcessing
public class JdbcCursorConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcCursorProcessor jdbcCursorProcessor;

    @Autowired
    private JdbcCursorWriter jdbcCursorWriter;

    @Bean
    public Job jdbcCurSorJob() {
        return jobBuilderFactory.get("jdbcCurSorJob").start(jdbcCurSorStep())
                .build();
    }

    @Bean
    public Step jdbcCurSorStep() {
        return stepBuilderFactory.get("jdbcCurSorStep")
                .<CreditBill,CreditBill>chunk(2)
                .reader(commonJdbcCursorReader())
                .processor(jdbcCursorProcessor)
                .writer(jdbcCursorWriter)
                .build();
    }

    @Bean
    @StepScope
    public CommonJdbcCursorReader commonJdbcCursorReader() {
        return new CommonJdbcCursorReader(CreditBill.class, CommonConstants.JDBC_CUSOR_SQL,dataSource);
    }
}

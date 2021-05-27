package com.sl.config;

import com.sl.common.CommonConstants;
import com.sl.common.CommonMybatisItemWriter;
import com.sl.entity.Cat;
import com.sl.entity.People;
import com.sl.entity.Student;
import com.sl.processor.PeopleProcessor;
import com.sl.processor.StudentDbProcessor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DefaultFieldSetFactory;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

/**
 * @author shuliangzhao
 * @Title: StudentDbConfiguration
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/27 15:05
 */
@Configuration
@EnableBatchProcessing
public class StudentDbConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private StudentDbProcessor studentDbProcessor;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Bean
    public Job studentDbJob() {
        return jobBuilderFactory.get("studentDbJob")
                .start(studentDbStep())
                .build();
    }

    @Bean
    public Step studentDbStep() {
        return stepBuilderFactory.get("studentDbStep")
                .<People, Student>chunk(10)
                .reader(peopleDbFlatFileItemReader())
                .processor(studentDbProcessor)
                .writer(peopleDbItemWriter())
                .build();
    }

    @Bean
    @StepScope
    public CommonMybatisItemWriter<Student> peopleDbItemWriter() {
        return new CommonMybatisItemWriter<>(sqlSessionFactory,Student.class.getSimpleName());
    }
    @Bean
    @StepScope
    public FlatFileItemReader<People> peopleDbFlatFileItemReader() {
        FlatFileItemReaderBuilder<People> builder = new FlatFileItemReaderBuilder<People>();
        BeanWrapperFieldSetMapper fieldSetMapper = new BeanWrapperFieldSetMapper();
        fieldSetMapper.setTargetType(People.class);
        DefaultLineMapper defaultLineMapper = new DefaultLineMapper();
        defaultLineMapper.setFieldSetMapper(fieldSetMapper);
        DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
        delimitedLineTokenizer.setFieldSetFactory(new DefaultFieldSetFactory());
        delimitedLineTokenizer.setNames("name","age","adress","idCard");
        delimitedLineTokenizer.setDelimiter(",");
        defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);
        FlatFileItemReader reader = builder.encoding(CommonConstants.ENCODING_READ)
                .resource(new FileSystemResource("D:\\aplus\\shuqian\\target\\" + "PeoPle" + ".csv"))
                .fieldSetMapper(fieldSetMapper)
                .saveState(true)
                .name("peoPleReader")
                .lineMapper(defaultLineMapper).build();
        return reader;
    }
}

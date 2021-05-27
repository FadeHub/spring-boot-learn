package com.sl.config;

import com.sl.common.CommonConstants;
import com.sl.entity.People;
import com.sl.processor.PeopleProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DefaultFieldSetFactory;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import java.util.Arrays;
import java.util.List;

/**
 * @author shuliangzhao
 * @Title: PeopleConfiguration
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/4/28 16:43
 */
@Configuration
@EnableBatchProcessing
public class PeopleConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private PeopleProcessor peopleProcessor;

    @Bean
    public Job peoPleJob() {
         return jobBuilderFactory.get("peoPleJob")
                 .start(peoPleStep())
                 .build();
    }

    @Bean
    public Step peoPleStep() {
         return stepBuilderFactory.get("peoPleStep")
                 .<People,People>chunk(10)
                 .reader(peopleFlatFileItemReader())
                 .processor(peopleProcessor)
                 .writer(peopleFlatFileItemWriter())
                 .build();
    }

    @Bean
    @StepScope
    public FlatFileItemWriter<People> peopleFlatFileItemWriter() {
        BeanWrapperFieldExtractor beanWrapperFieldExtractor = new BeanWrapperFieldExtractor();
        List<String> list = Arrays.asList("name", "age", "adress", "idCard");
        String[] names = new String[list.size()];
        beanWrapperFieldExtractor.setNames(list.toArray(names));
        beanWrapperFieldExtractor.afterPropertiesSet();
        DelimitedLineAggregator lineAggregator = new DelimitedLineAggregator();
        lineAggregator.setDelimiter(",");
        lineAggregator.setFieldExtractor(beanWrapperFieldExtractor);
        FlatFileItemWriterBuilder<People> builder = new FlatFileItemWriterBuilder<>();
        FlatFileItemWriter fileItemWriter = builder.encoding(CommonConstants.ENCODING_READ)
                .lineAggregator(lineAggregator)
                .resource(new FileSystemResource("D:\\aplus\\shuqian\\source\\" + "People" + ".csv"))
                .name("peoPle").build();
        return fileItemWriter;
    }

    @Bean
    @StepScope
    public FlatFileItemReader<People> peopleFlatFileItemReader() {
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

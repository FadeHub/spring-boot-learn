package com.sl.base;

import com.sl.base.handler.ObjectProcessorHandler;
import com.sl.base.handler.WriterObjectToDbHander;
import com.sl.base.service.CafeCatInsetService;
import com.sl.base.service.CafeService;
import com.sl.entity.CafeCat;
import com.sl.entity.Cat;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shuliangzhao
 * @Title: CatReadConfiguration
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/2 21:03
 */
@Configuration
@EnableBatchProcessing
public class CatReadConfiguration {

    @Autowired
    private BaseJobFactory baseJobFactory;

    @Autowired
    private BaseStepExecutorFactory baseStepExecutorFactory;

    @Bean
    public Job catReadJob(@Qualifier(value = "initBaseStep")Step initBaseStep,@Qualifier(value = "catReadStep")Step catReadStep) {
       return baseJobFactory.createSimpleJob("catReadJob",initBaseStep,catReadStep);
    }

    @Bean
    public Step catReadStep(@Qualifier(value = "catItemReader") ItemReader<Cat> catItemReader,
                            @Qualifier(value = "catReadProcessor") ItemProcessor<Cat, CafeCat> catReadProcessor,
                            @Qualifier(value = "catReadWriter") ItemWriter<CafeCat> catReadWriter) {
        return baseJobFactory.createRpwStep("catReadStep",10,catItemReader,catReadProcessor,catReadWriter);
    }

    @Bean
    @StepScope
    public BaseObjectReader catItemReader() {
       BaseObjectReader.ReaderDefinition<Cat> definition = new BaseObjectReader.ReaderDefinition<>(Cat.class,"catItemReader",
               "com.sl.entity.Cat.selectPageList",50,()->{
           Map<String,Object> map = new HashMap<>();
           map.put("fromId",1);
           map.put("toId",10);
           return map;
       });
       return baseStepExecutorFactory.createDefaultBaseReader(definition);
    }

    @Bean
    @StepScope
    public BaseObjectProcessor catReadProcessor(CafeService cafeService) {
        ObjectProcessorHandler<Cat,CafeCat> handler = (t) -> cafeService.createCafeCat(t);
        return baseStepExecutorFactory.createBaseProcess(handler);
    }

    @Bean
    @StepScope
    public ObjectWriterDbWriter catReadWriter(CafeCatInsetService cafeCatInsetService) {
        WriterObjectToDbHander<CafeCat> writerHandler = cafeCatInsetService::insertCafeCat;
        return baseStepExecutorFactory.createObjectWriterDbWriter(writerHandler);
    }
}

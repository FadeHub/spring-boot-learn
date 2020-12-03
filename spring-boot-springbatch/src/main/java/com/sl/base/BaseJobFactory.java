package com.sl.base;

import com.sl.base.listener.BaseChunkListener;
import com.sl.base.listener.BaseJobListener;
import com.sl.base.listener.BaseStepListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.SimpleJobBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * jop rpw工厂类
 * @author shuliangzhao
 * @Title: BaseJobFactory
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/1 19:20
 */
@Component
public class BaseJobFactory {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Value("${base.chunksize:500}")
    private int chunkSize;

    /**
     * 创建一个简单的tasklet
     * @param stepName
     * @param tasklet
     * @return
     */
    public Step createTasketStep(String stepName, Tasklet tasklet) {
        return stepBuilderFactory.get(stepName).listener(new BaseStepListener()).tasklet(tasklet)
                .listener(new BaseChunkListener()).build();
    }

    /**
     * 创建一个简单的job
     * @param name
     * @param initBaseStep
     * @param steps
     * @return
     */
     public Job createSimpleJob(String name,Step initBaseStep,Step ...steps) {
        SimpleJobBuilder simpleJobBuilder = createBaseJob(name,initBaseStep);
        for (int i = 0;i < steps.length;i++) {
            simpleJobBuilder = simpleJobBuilder.next(steps[i]);
        }
        return simpleJobBuilder.build();
     }

    /**
     *
     * @param jobName
     * @param initBaseStep
     * @return
     */
     public SimpleJobBuilder createBaseJob(String jobName,Step initBaseStep) {
        return jobBuilderFactory.get(jobName).listener(new BaseJobListener()).start(initBaseStep);
     }

    /**
     * 创建一个rpw的step
     * @param stepName
     * @param chunk
     * @param reader
     * @param processor
     * @param writer
     * @param <I>
     * @param <O>
     * @return
     */
     public <I,O> Step createRpwStep(String stepName, int chunk, ItemReader<I> reader, ItemProcessor<I,O> processor, ItemWriter<O> writer) {
         return stepBuilderFactory.get(stepName).listener(new BaseStepListener()).<I,O>chunk(chunk)
                 .reader(reader)
                 .processor(processor)
                 .writer(writer)
                 .build();
     }

    /**
     * 创建一个rw的step
     * @param stepName
     * @param chunk
     * @param reader
     * @param writer
     * @param <I>
     * @param <O>
     * @return
     */
    public <I,O> Step createRwStep(String stepName, int chunk, ItemReader<I> reader,ItemWriter<O> writer) {
        return stepBuilderFactory.get(stepName).listener(new BaseStepListener()).<I,O>chunk(chunk)
                .reader(reader)
                .writer(writer)
                .build();
    }
}

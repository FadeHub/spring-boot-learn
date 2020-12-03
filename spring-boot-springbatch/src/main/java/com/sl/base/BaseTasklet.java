package com.sl.base;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

/**
 * @author shuliangzhao
 * @Title: BaseTasklet
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/1 20:26
 */
@Component
@StepScope
public class BaseTasklet implements Tasklet {
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        //做初始化操作
        return RepeatStatus.FINISHED;
    }
}

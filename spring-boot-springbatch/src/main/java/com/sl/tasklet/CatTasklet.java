package com.sl.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

/**
 * @author shuliangzhao
 * @Title: CatTasklet
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/16 20:02
 */
@Component
@StepScope
public class CatTasklet implements Tasklet {
    
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        //TODO 可以做一些下载文件等之类的动作
        return null;
    }
}

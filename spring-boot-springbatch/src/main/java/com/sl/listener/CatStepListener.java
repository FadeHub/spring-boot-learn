package com.sl.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

/**
 * @author shuliangzhao
 * @Title: CatStepListener
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/11 19:48
 */
@Component
public class CatStepListener implements StepExecutionListener {
    @Override
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("step执行之前");
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println("step执行之后");
        return null;
    }
}

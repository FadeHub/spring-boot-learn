package com.sl.listener;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepListener;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.stereotype.Component;

/**
 * @author shuliangzhao
 * @Title: PersonStepListener
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/11/29 17:33
 */
@Component
public class PersonStepListener implements StepListener {

    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("do something...");
    }

    @AfterStep
    public void AfterStep(StepExecution stepExecution) {
        System.out.println("do something...");
    }

}

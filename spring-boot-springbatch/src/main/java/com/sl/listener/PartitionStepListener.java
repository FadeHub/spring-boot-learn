package com.sl.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

/**
 * @author shuliangzhao
 * @Title: PartitionStepListener
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/5 15:53
 */
@Component
public class PartitionStepListener implements StepExecutionListener {

    private static final Logger logger = LoggerFactory.getLogger(PartitionStepListener.class);

    @Override
    public void beforeStep(StepExecution stepExecution) {
       logger.info("ThreadName={},steName={},FileName={}",Thread.currentThread().getName(),
               stepExecution.getStepName(),stepExecution.getExecutionContext().getString("fileName"));
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }
}

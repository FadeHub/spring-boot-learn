package com.sl.base.listener;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;

/**
 * @author shuliangzhao
 * @Title: BaseStepListener
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/1 19:27
 */
public class BaseStepListener {

    private static final Logger logger = LoggerFactory.getLogger(BaseStepListener.class);

    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        String jobName = stepExecution.getJobExecution().getJobInstance().getJobName();
        String stepName = stepExecution.getStepName();
        logger.info("开始执行job:{},中的step:{},开始时间:{}",jobName,stepName,
                DateFormatUtils.format(stepExecution.getStartTime(),"yyyy-MM-dd HH:mm:ss"));
    }

    @AfterStep
    public void afterStep(StepExecution stepExecution) {
        String jobName = stepExecution.getJobExecution().getJobInstance().getJobName();
        String stepName = stepExecution.getStepName();
        /*logger.info("结束执行job:{},中的step:{},结束时间:{},执行状态:{},共计读取数据次:{},提交次:{},耗时:{}ms",jobName,stepName,
                DateFormatUtils.format(stepExecution.getEndTime(),"yyyy-MM-dd HH:mm:ss"),
                stepExecution.getExitStatus().getExitCode(),stepExecution.getReadCount(),
                stepExecution.getCommitCount(),stepExecution.getEndTime().getTime()-
                stepExecution.getStartTime().getTime());*/
    }
}

package com.sl.base.listener;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * @author shuliangzhao
 * @Title: BaseJobListener
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/1 20:11
 */
public class BaseJobListener implements JobExecutionListener {

    private static final Logger logger = LoggerFactory.getLogger(BaseJobListener.class);

    @Override
    public void beforeJob(JobExecution jobExecution) {
        logger.info("开始执行job:{},实例id:{},执行开始时间:{}",jobExecution.getJobInstance().getJobName(),
                jobExecution.getJobInstance().getInstanceId(), DateFormatUtils.format(jobExecution.getStartTime(),"yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        logger.info("结束执行job:{},实例id:{},执行结束时间:{},状态:{},耗时:{}",jobExecution.getJobInstance().getJobName(),
                jobExecution.getJobInstance().getInstanceId(), DateFormatUtils.format(jobExecution.getStartTime(),"yyyy-MM-dd HH:mm:ss"),
                jobExecution.getExitStatus().getExitCode(),jobExecution.getEndTime().getTime()-jobExecution.getStartTime().getTime());
    }
}

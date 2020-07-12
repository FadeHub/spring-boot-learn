package com.sl.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

/**
 * @author shuliangzhao
 * @Title: JobCommonListener
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/7/12 14:08
 */
@Component
public class MyJobExecutionListener implements JobExecutionListener {
    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("job执行之前做处理...");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.println("job执行之后做处理...");
    }
}

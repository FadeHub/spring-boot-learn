package com.sl.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

/**
 * job监听器
 * @author shuliangzhao
 * @Title: CatJobListener
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/11 19:24
 */
@Component
public class CatJobListener implements JobExecutionListener {
    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("job执行执行做处理");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.println("job执行执行做处理");
    }
}

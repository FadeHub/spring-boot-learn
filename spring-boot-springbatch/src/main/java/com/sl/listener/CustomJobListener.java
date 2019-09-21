package com.sl.listener;

import com.sl.common.CommonConstants;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

/**
 * @author shuliangzhao
 * @Title: CustomJobListener
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/21 14:59
 */
@Component
public class CustomJobListener implements JobExecutionListener {
    @Override
    public void beforeJob(JobExecution jobExecution) {
        CommonConstants.getList().add("hello");
        CommonConstants.getList().add("springbatch");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {

    }
}

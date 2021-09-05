package com.sl.jobexecutor;

import com.sl.thread.JobUtil;
import com.sl.thread.SpringContextUtil;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.batch.core.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sl.service.JobLauncherService;

/**
 * @author shuliangzhao
 * @Title: PatternMatchJobHandler
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/12 19:31
 */

@Component
public class PatternMatchJobHandler {

    @Autowired
    private JobLauncherService jobLauncherService;

    /**
     *
     * @param parameter 前台页面传递来的参数
     * @return
     * @throws Exception
     */
    @XxlJob(value="patternMatchJobHandler")
    public ReturnT<String> execute(String parameter) throws Exception {
        XxlJobLogger.log("parameter is :",parameter);
        return JobUtil.runJob4Executor("studentJob",jobLauncherService,
                SpringContextUtil.getBean("studentJob", Job.class),parameter);
    }
}

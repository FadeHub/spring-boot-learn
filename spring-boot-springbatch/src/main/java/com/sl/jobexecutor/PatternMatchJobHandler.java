package com.sl.jobexecutor;

import com.sl.util.JobUtil;
import com.sl.util.SpringContextUtil;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
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

    @XxlJob(value="patternMatchJobHandler")
    public ReturnT<String> execute(String s) throws Exception {
        return JobUtil.runJob4Executor("patternMatchJob",jobLauncherService,
                SpringContextUtil.getBean("patternMatchJob", Job.class));
    }
}

package com.sl.service;

import cn.hutool.core.collection.CollUtil;
import com.sl.common.LogConstants;
import com.sl.common.SyncConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.Collection;
import java.util.Map;

/**
 * @author shuliangzhao
 * @Title: JobLauncherService
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/12 19:17
 */
@Service
public class JobLauncherService {

    private static final Logger log = LoggerFactory.getLogger(JobLauncherService.class);

    @Autowired
    private JobLauncher jobLauncher;

    public Map<String,Object> startJob(Job job, JobParameters jobParameters) throws Exception {
        Map<String,Object> resultMap = CollUtil.newHashMap();
        //计时
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(job.getName());
        //执行任务
        JobExecution run = jobLauncher.run(job, jobParameters);
        //返回结果
        StringBuffer stringBuffer = new StringBuffer();
        Collection<StepExecution> stepExecutions = run.getStepExecutions();
        stepExecutions.forEach(stepExecution -> {
            stringBuffer.append("readCount:" + stepExecution.getCommitCount() + LogConstants.LOG_STR_COMMA);
            stringBuffer.append("filterCount:" + stepExecution.getFilterCount() + LogConstants.LOG_STR_COMMA);
            stringBuffer.append("commitCount:" + stepExecution.getCommitCount() + LogConstants.LOG_STR_COMMA);
            stringBuffer.append("writeCount:" + stepExecution.getWriteCount());
        });
        stopWatch.stop();
        ExitStatus exitStatus = run.getExitStatus();
        String returnStr = System.lineSeparator() +"resultCount: "+ stringBuffer.toString()
                + System.lineSeparator() +"exitStatus: "+exitStatus
                + System.lineSeparator()+ "timeInfo: "+stopWatch.prettyPrint();
        log.info(returnStr);
        resultMap.put(SyncConstants.STR_RETURN_RESULT,returnStr);
        resultMap.put(SyncConstants.STR_RETURN_EXITSTATUS,exitStatus);
        return resultMap;
    }
}

package com.sl.util;

import com.sl.common.SyncConstants;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.batch.core.*;
import com.sl.service.JobLauncherService;

import java.util.Map;

/**
 * @author shuliangzhao
 * @Title: JobUtil
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/12 19:24
 */
public class JobUtil {

    /**
     * 构建JobParameters
     * @return
     */
    private static JobParameters makeJobParameters() {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time",System.currentTimeMillis())
                .toJobParameters();
        return jobParameters;
    }

    public static ReturnT<String> runJob4Executor(String jobName, JobLauncherService jobLauncherService, Job job) throws Exception {
        XxlJobLogger.log("start sync "+jobName +" data");
        Map<String, Object> resultMap = jobLauncherService.startJob(job, makeJobParameters());
        String resultStr = (String)resultMap.get(SyncConstants.STR_RETURN_RESULT);
        XxlJobLogger.log("end sync "+jobName +" data, result: "+System.lineSeparator()+resultStr);

        ExitStatus exitStatus = (ExitStatus)resultMap.get(SyncConstants.STR_RETURN_EXITSTATUS);
        String exitCode = exitStatus.getExitCode();
        //若成功，返回SUCCESS
        if(ExitStatus.COMPLETED.getExitCode().equals(exitCode)){
            return IJobHandler.SUCCESS;
        }else{
            return IJobHandler.FAIL;
        }
    }
}

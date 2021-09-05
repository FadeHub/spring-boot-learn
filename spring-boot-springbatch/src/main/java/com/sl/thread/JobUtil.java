package com.sl.thread;

import com.sl.common.SyncConstants;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.apache.commons.lang3.StringUtils;
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
     * 参数解析
     * @return
     */
    private static JobParameters makeJobParameters(String parameter) {
        //k=v,k=v
        JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
        if (StringUtils.isNotBlank(parameter)) {
            String[] params = parameter.split(",");
            if (params.length > 0) {
                for (String str:params) {
                    String[] param = str.split("=");
                    jobParametersBuilder.addString(param[0],param[1]);
                }
            }
        }
        jobParametersBuilder.addLong("time",System.currentTimeMillis());
        return jobParametersBuilder.toJobParameters();
    }

    public static ReturnT<String> runJob4Executor(String jobName, JobLauncherService jobLauncherService, Job job,String parameter) throws Exception {
        XxlJobLogger.log("start sync "+jobName +" data");
        Map<String, Object> resultMap = jobLauncherService.startJob(job, makeJobParameters(parameter));
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

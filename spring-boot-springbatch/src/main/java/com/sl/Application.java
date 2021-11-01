package com.sl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;

@SpringBootApplication
@MapperScan(basePackages = "com.sl.mapper")
public class Application {

    @Value("${xxl.job.enable}")
    private boolean enable;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        Application bean = ctx.getBean(Application.class);
        //如果enable为false则为手动触发
        if (!bean.isEnable()) {
            run(ctx);
        }
    }

    private static void run(ApplicationContext ctx) throws Exception{
        JobLauncher jobLauncher = ctx.getBean(JobLauncher.class);
        JobParameters jobParameters = new JobParametersBuilder().addDate("test1", new Date()).toJobParameters();
        JobExecution studentJob = jobLauncher.run(ctx.getBean("taskletAdapterJob", Job.class), jobParameters);
    }

}

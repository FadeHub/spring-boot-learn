package com.sl;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;

@SpringBootApplication
public class SpringBatchListenerApplication {

    public static void main(String[] args) throws Exception {
        ApplicationContext run = SpringApplication.run(SpringBatchListenerApplication.class, args);
        run(run);
    }

    private static void run(ApplicationContext ctx) throws Exception{
        JobLauncher jobLauncher = ctx.getBean(JobLauncher.class);
        JobParameters jobParameters = new JobParametersBuilder().addDate("test", new Date()).toJobParameters();
        JobExecution listenerJob = jobLauncher.run(ctx.getBean("listenerJob", Job.class), jobParameters);
    }
}

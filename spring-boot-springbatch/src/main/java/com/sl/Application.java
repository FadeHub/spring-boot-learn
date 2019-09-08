package com.sl;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        ApplicationContext run = SpringApplication.run(Application.class, args);
        run(run);
    }

    private static void run(ApplicationContext ctx) throws Exception{
        JobLauncher jobLauncher = ctx.getBean(JobLauncher.class);
        JobParameters jobParameters = new JobParametersBuilder().addDate("test", new Date()).toJobParameters();
        JobExecution studentJob = jobLauncher.run(ctx.getBean("studentMultiJob", Job.class), jobParameters);
    }
}

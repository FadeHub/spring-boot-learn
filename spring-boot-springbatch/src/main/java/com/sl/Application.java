package com.sl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;

@SpringBootApplication
@MapperScan(basePackages = "com.sl.mapper")
public class Application {

    public static void main(String[] args) throws Exception {
        ApplicationContext run = SpringApplication.run(Application.class, args);
        //run(run);
    }

    private static void run(ApplicationContext ctx) throws Exception{
        JobLauncher jobLauncher = ctx.getBean(JobLauncher.class);
        JobParameters jobParameters = new JobParametersBuilder().addDate("test1", new Date()).toJobParameters();
        JobExecution studentJob = jobLauncher.run(ctx.getBean("jdbcCurSorJob", Job.class), jobParameters);
    }

}

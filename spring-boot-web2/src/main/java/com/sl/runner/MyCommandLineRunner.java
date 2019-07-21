package com.sl.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * CommandLineRunner 系统启动时加载参数
 * @author shuliangzhao
 * @Title: MyCommandLineRunner
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/21 12:34
 */
@Component
@Order(1)
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Runner>>>" + Arrays.toString(args));
    }
}

package com.sl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootExmpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExmpleApplication.class, args);
        String osName = System.getProperty("os.name");
        System.out.println("当前系统为：" + osName);
        //Car bean = SpringUtil.getBean(Car.class);
        System.out.println(SpringUtil.getBeansOfType(Car.class));
        //System.out.println(SpringUtil.getBean("car2"));
    }
}

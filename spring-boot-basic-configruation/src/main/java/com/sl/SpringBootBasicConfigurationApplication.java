package com.sl;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootBasicConfigurationApplication {

    public static void main(String[] args) {
        //关掉banner
        //SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringBootBasicConfigurationApplication.class);
        //builder.bannerMode(Banner.Mode.OFF).run(args);
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootBasicConfigurationApplication.class, args);
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String str:beanDefinitionNames) {
            System.out.println(str);
        }
    }

}

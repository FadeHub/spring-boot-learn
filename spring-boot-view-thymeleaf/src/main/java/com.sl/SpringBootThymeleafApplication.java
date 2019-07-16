package com.sl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootThymeleafApplication {

    public static void main(String[] args) {
        //关掉banner
        //SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringBootBasicConfigurationApplication.class);
        //builder.bannerMode(Banner.Mode.OFF).run(args);
        SpringApplication.run(SpringBootThymeleafApplication.class, args);
    }

}

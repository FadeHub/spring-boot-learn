package com.sl;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringBootBasicConfigurationApplication {

    public static void main(String[] args) {
        //关掉banner
        //SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringBootBasicConfigurationApplication.class);
        //builder.bannerMode(Banner.Mode.OFF).run(args);
        SpringApplication.run(SpringBootBasicConfigurationApplication.class, args);
    }

}

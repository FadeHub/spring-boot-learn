package com.sl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sl.mapper")
public class SpringBootSecurityImproveApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityImproveApplication.class, args);
    }

}

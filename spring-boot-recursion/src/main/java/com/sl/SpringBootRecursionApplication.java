package com.sl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sl.mapper")
public class SpringBootRecursionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRecursionApplication.class, args);
    }

}

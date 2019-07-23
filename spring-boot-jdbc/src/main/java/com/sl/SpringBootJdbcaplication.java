package com.sl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpringBootJdbcaplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJdbcaplication.class, args);
    }

}

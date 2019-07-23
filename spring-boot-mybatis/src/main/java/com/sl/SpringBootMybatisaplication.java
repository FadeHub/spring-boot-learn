package com.sl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpringBootMybatisaplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisaplication.class, args);
    }

}

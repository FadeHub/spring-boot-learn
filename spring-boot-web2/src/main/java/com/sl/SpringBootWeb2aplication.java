package com.sl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpringBootWeb2aplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWeb2aplication.class, args);
    }

}

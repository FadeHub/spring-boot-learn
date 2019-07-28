package com.sl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * springboot 集成 redis集群
 */
@SpringBootApplication
@EnableCaching //开启使用缓存
public class SpringBootRedisClusterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedisClusterApplication.class, args);
    }

}

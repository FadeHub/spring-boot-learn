package com.sl.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author shuliangzhao
 * @Title: Work
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/3/21 17:13
 */
@Profile("prod")
@ConfigurationProperties(prefix = "person")
@Component
@Data
public class Work implements Person{

    private String name;
    private Integer age;
}

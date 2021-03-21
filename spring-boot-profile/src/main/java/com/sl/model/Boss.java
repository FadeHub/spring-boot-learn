package com.sl.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author shuliangzhao
 * @Title: Boss
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/3/21 17:13
 */
@Profile("dev")
@ConfigurationProperties(prefix = "person")
@Component
@Data
public class Boss  implements Person{

    private String name;
    private Integer age;
}

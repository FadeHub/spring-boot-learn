package com.sl;

import com.sl.config.LinuxCondition;
import com.sl.config.TestCondition;
import com.sl.config.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author shuliangzhao
 * @Title: ConditionConfig
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/11/21 11:10
 */
@Configuration
@Conditional({WindowsCondition.class, TestCondition.class})
public class ConditionConfig {

    @Bean
   // @Conditional({WindowsCondition.class})
    public Car car1() {
        return new Car("red","奥迪");
    }

    @Bean
    //@Conditional({LinuxCondition.class})
    public Car car2() {
        return new Car("blue","宝马");
    }
}

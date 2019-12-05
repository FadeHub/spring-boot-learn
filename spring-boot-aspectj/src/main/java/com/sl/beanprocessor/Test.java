package com.sl.beanprocessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author shuliangzhao
 * @Title: Test
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/10/22 19:54
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(UserConfig.class);
        ((AnnotationConfigApplicationContext) applicationContext).close();
    }
}

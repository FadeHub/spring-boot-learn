package com.sl.controller;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author shuliangzhao
 * @Title: MyLazy
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/10/10 19:27
 */
@Component
@Lazy
public class MyLazy {

    public MyLazy() {
        System.out.println("懒加载...");
    }

    public void say() {
        System.out.println("say...");
    }
}

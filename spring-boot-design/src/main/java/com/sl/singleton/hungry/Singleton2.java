package com.sl.singleton.hungry;

/**
 * 饿汉式
 * 线程安全 但是浪费资源
 * @author shuliangzhao
 * @Title: Singleton1
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/15 21:03
 */
public class Singleton2 {

    private Singleton2() {}

    private static Singleton2 instance;

    static {
        instance = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}

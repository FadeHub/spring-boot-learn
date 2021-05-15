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
public class Singleton1 {

    private Singleton1() {}

    private static final Singleton1 instance = new Singleton1();

    public static Singleton1 getInstance() {
        return instance;
    }
}

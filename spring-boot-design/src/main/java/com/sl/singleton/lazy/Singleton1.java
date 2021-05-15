package com.sl.singleton.lazy;

/**
 * 线程不安全
 * @author shuliangzhao
 * @Title: Singleton1
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/15 21:07
 */
public class Singleton1 {

    private Singleton1(){}

    private static Singleton1 instance;

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }

}

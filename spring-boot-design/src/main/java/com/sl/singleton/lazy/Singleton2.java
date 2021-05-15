package com.sl.singleton.lazy;

/**
 * 线程安全，效率低
 * @author shuliangzhao
 * @Title: Singleton1
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/15 21:07
 */
public class Singleton2 {

    private Singleton2(){}

    private static Singleton2 instance;

    public synchronized static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }

}

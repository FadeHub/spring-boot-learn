package com.sl.singleton.lazy;

/**
 * 双重检查
 * 线程安全，推荐使用
 * @author shuliangzhao
 * @Title: Singleton1
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/15 21:07
 */
public class Singleton3 {

    private Singleton3(){}

    private static volatile Singleton3 instance;

    public static Singleton3 getInstance() {
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }

}

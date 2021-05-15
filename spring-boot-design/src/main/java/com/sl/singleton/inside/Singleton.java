package com.sl.singleton.inside;

/**
 * 静态内部类，线程安全 推荐使用
 * @author shuliangzhao
 * @Title: Singleton
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/15 21:11
 */
public class Singleton {

    private Singleton(){}

    public static class SingletonInstance{

        public static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
         return SingletonInstance.INSTANCE;
    }
}

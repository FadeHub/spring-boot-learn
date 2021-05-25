package com.sl.facade;

/**
 * 爆米花机
 * @author shuliangzhao
 * @Title: Popcorn
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/25 22:41
 */
public class Popcorn {

    private static Popcorn popcorn = new Popcorn();

    public static Popcorn getInstance() {
        return popcorn;
    }

    public void on() {
        System.out.println("Popcorn on...");
    }

    public void off() {
        System.out.println("Popcorn off...");
    }

    public void pop() {
        System.out.println("Popcorn pop...");
    }
}

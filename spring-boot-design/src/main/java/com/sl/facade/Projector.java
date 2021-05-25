package com.sl.facade;

/**
 * 投影仪
 * @author shuliangzhao
 * @Title: Projector
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/25 22:42
 */
public class Projector {

    private static Projector projector = new Projector();

    public static Projector getInstance() {
        return projector;
    }

    public void on() {
        System.out.println("Projector on...");
    }

    public void off() {
        System.out.println("Projector off...");
    }

    public void fouce() {
        System.out.println("Projector fouce...");
    }
}

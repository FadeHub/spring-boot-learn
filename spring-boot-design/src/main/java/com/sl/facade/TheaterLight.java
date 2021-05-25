package com.sl.facade;

/**
 * 灯光
 * @author shuliangzhao
 * @Title: TheaterLight
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/25 22:47
 */
public class TheaterLight {

    private static TheaterLight theaterLight = new TheaterLight();

    public static TheaterLight getInstance() {
        return theaterLight;
    }

    public void on() {
        System.out.println("TheaterLight on...");
    }

    public void off() {
        System.out.println("TheaterLight off...");
    }

    public void dim() {
        System.out.println("TheaterLight dim...");
    }

    public void bright() {
        System.out.println("TheaterLight bright...");
    }
}

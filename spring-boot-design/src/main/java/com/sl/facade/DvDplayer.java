package com.sl.facade;

/**
 * @author shuliangzhao
 * @Title: DvDplayer
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/25 22:39
 */
public class DvDplayer {

    private static DvDplayer dvDplayer = new DvDplayer();

    public static DvDplayer getInstance() {
        return dvDplayer;
    }

    public void on() {
        System.out.println("DvDplayer on...");
    }

    public void off() {
        System.out.println("DvDplayer off...");
    }

    public void play() {
        System.out.println("DvDplayer play...");
    }

    public void pause() {
        System.out.println("DvDplayer pause...");
    }
}

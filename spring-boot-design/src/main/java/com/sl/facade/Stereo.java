package com.sl.facade;

/**
 * 立体声
 * @author shuliangzhao
 * @Title: Stereo
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/25 22:45
 */
public class Stereo {

    private static Stereo stereo = new Stereo();

    public static Stereo getInstance() {
        return stereo;
    }

    public void on() {
        System.out.println("Stereo on...");
    }

    public void off() {
        System.out.println("Stereo off...");
    }

    public void up() {
        System.out.println("Stereo up...");
    }
}

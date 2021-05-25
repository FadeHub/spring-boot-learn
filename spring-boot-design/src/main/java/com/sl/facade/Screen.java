package com.sl.facade;

/**
 * 屏幕
 * @author shuliangzhao
 * @Title: Screen
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/25 22:44
 */
public class Screen {

    private static Screen screen = new Screen();

    public static Screen getInstance() {
        return screen;
    }

    public void up() {
        System.out.println("Screen up...");
    }

    public void down() {
        System.out.println("Screen down...");
    }
}

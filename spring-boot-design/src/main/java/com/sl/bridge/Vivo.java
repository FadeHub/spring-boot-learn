package com.sl.bridge;

/**
 * @author shuliangzhao
 * @Title: Vivo
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/21 22:01
 */
public class Vivo implements Brand{
    @Override
    public void open() {
        System.out.println(" Vivo手机开机");
    }

    @Override
    public void call() {
        System.out.println(" Vivo手机打电话");
    }

    @Override
    public void close() {
        System.out.println(" Vivo手机关机");
    }
}

package com.sl.bridge;

/**
 * @author shuliangzhao
 * @Title: XiaoMi
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/21 22:00
 */
public class XiaoMi implements Brand{
    @Override
    public void open() {
        System.out.println(" 小米手机开机");
    }

    @Override
    public void call() {
        System.out.println(" 小米手机打电话");
    }

    @Override
    public void close() {
        System.out.println(" 小米手机关机");
    }
}

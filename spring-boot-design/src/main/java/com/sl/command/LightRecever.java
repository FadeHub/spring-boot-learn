package com.sl.command;

/**
 * 命令接收者
 * @author shuliangzhao
 * @Title: LightRecever
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/6/3 22:12
 */
public class LightRecever {

    public void on() {
        System.out.println("电灯打开了");
    }

    public void off() {
        System.out.println("电灯关闭了");
    }
}

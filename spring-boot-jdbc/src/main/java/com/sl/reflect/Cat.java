package com.sl.reflect;

/**
 * @author shuliangzhao
 * @Title: Cat
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/4/6 12:02
 */
public class Cat implements Anmail {
    @Override
    public void name() {
        System.out.println("小猫咪");
    }
}

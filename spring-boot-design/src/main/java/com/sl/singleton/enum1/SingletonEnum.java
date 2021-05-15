package com.sl.singleton.enum1;

/**
 * @author shuliangzhao
 * @Title: SingletonEnum
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/15 21:15
 */
public enum SingletonEnum {

    INSTANCE;
    public void say() {
        System.out.println("枚举");
    }
}

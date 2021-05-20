package com.sl.adapter.classadapter;

/**
 * @author shuliangzhao
 * @Title: Client
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/20 21:41
 */
public class Client {

    public static void main(String[] args) {
        Phone phone = new Phone(new VoltageAdapter());
        phone.charing();
    }
}

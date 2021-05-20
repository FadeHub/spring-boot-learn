package com.sl.adapter.objectadapter;

import com.sl.adapter.classadapter.Voltage220;

/**
 * 对象适配器
 * @author shuliangzhao
 * @Title: Client
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/20 21:41
 */
public class Client {

    public static void main(String[] args) {
        Phone phone = new Phone(new VoltageAdapter(new Voltage220()));
        phone.charing();
    }
}

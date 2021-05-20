package com.sl.adapter.objectadapter;

/**
 * 类适配器
 * @author shuliangzhao
 * @Title: Phone
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/20 21:37
 */
public class Phone {

    private VoltageAdapter voltageAdapter;

    public Phone(VoltageAdapter voltageAdapter) {
        this.voltageAdapter = voltageAdapter;
    }

    public void charing() {
        System.out.println(voltageAdapter.voltage5());
    }
}

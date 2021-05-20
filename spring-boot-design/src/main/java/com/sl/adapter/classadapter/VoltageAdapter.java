package com.sl.adapter.classadapter;

/**
 * @author shuliangzhao
 * @Title: VoltageAdapter
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/20 21:35
 */
public class VoltageAdapter extends Voltage220 implements Voltage5{
    @Override
    public int voltage5() {
        int i = voltage220();
        System.out.println("220v 转换成5v");
        return i/44;
    }
}

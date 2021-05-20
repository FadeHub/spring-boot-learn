package com.sl.adapter.objectadapter;

import com.sl.adapter.classadapter.Voltage220;

/**
 * @author shuliangzhao
 * @Title: VoltageAdapter
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/20 21:35
 */
public class VoltageAdapter  implements Voltage5 {

    private Voltage220 voltage220;

    public VoltageAdapter(Voltage220 voltage220) {
        this.voltage220 = voltage220;
    }

    @Override
    public int voltage5() {
        int i = voltage220.voltage220();
        System.out.println("220v 转换成5v");
        return i/44;
    }
}

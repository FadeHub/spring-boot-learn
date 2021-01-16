package com.sl.chapter02.factory.impl;

import com.sl.chapter02.factory.ICacheAdaper;
import com.sl.chapter02.matter.IIR;

import java.util.concurrent.TimeUnit;

/**
 * @author shuliangzhao
 * @Title: IIRCacheAdaper
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/1/16 16:17
 */
public class IIRCacheAdaper implements ICacheAdaper {

    IIR iir = new IIR();

    @Override
    public String get(String key) {
        return iir.get(key);
    }

    @Override
    public void set(String key, String value) {
        iir.set(key,value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        iir.setExpire(key,value,timeout,timeUnit);
    }

    @Override
    public void del(String key) {
        iir.del(key);
    }
}

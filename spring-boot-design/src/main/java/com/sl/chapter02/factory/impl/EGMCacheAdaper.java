package com.sl.chapter02.factory.impl;

import com.sl.chapter02.factory.ICacheAdaper;
import com.sl.chapter02.matter.EGM;

import java.util.concurrent.TimeUnit;

/**
 * @author shuliangzhao
 * @Title: EGMCacheAdaper
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/1/16 16:16
 */
public class EGMCacheAdaper implements ICacheAdaper {

    EGM egm = new EGM();

    @Override
    public String get(String key) {
        System.out.println("使用集群EGM");
        return egm.gain(key);
    }

    @Override
    public void set(String key, String value) {
        egm.set(key,value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
         egm.setEx(key,value,timeout,timeUnit);
    }

    @Override
    public void del(String key) {
         egm.delete(key);
    }
}

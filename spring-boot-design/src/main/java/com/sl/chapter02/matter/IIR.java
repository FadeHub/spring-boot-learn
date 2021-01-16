package com.sl.chapter02.matter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author shuliangzhao
 * @Title: IIR
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/1/16 16:13
 */
public class IIR {
    private Map<String, String> dataMap = new ConcurrentHashMap<>();

    public String get(String key) {
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        dataMap.put(key, value);
    }

    public void setExpire(String key, String value, long timeout, TimeUnit timeUnit) {
        dataMap.put(key, value);
    }

    public void del(String key) {
        dataMap.remove(key);
    }
}

package com.sl.chapter02.matter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author shuliangzhao
 * @Title: EGM
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/1/16 16:14
 */
public class EGM {

    private Map<String, String> dataMap = new ConcurrentHashMap<>();

    public String gain(String key) {
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        dataMap.put(key, value);
    }

    public void setEx(String key, String value, long timeout, TimeUnit timeUnit) {
        dataMap.put(key, value);
    }

    public void delete(String key) {
        dataMap.remove(key);
    }
}

package com.sl.learn.service;

import com.sl.learn.starter.StaterProperties;

/**
 * @author shuliangzhao
 * @Title: StaterService
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/12/5 20:37
 */
public class StaterService {

    private StaterProperties staterProperties;

    public StaterProperties getStaterProperties() {
        return staterProperties;
    }

    public void setStaterProperties(StaterProperties staterProperties) {
        this.staterProperties = staterProperties;
    }

    public String say() {
        return staterProperties.getCode() + "-" + staterProperties.getDesc();
    }
}

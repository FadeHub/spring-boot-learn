package com.sl.learn.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author shuliangzhao
 * @Title: StaterProperties
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/12/5 20:36
 */
@ConfigurationProperties(prefix = "stater")
public class StaterProperties {

    private String code;

    private String desc;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

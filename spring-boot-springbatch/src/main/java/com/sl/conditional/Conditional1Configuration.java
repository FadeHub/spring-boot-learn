package com.sl.conditional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shuliangzhao
 * @Title: TestConfiguration
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/16 19:40
 */
@Configuration
@ConfigurationProperties(prefix = "myapp.mail")
@ConditionalOnProperty(prefix = "myapp.mail",name = "enable",havingValue = "false")
public class Conditional1Configuration {

    private String localPath;

    private Boolean enable;

    @Bean
    public Conditional1 test1() {
       Conditional1 test = new Conditional1();
       test.setEnable(enable);
       test.setUser(localPath);
       return test;
    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}

package com.sl.conditional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shuliangzhao
 * @Title: Test2Configuration
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/16 19:41
 */
@Configuration
@ConfigurationProperties(prefix = "myapp1.mail")
@ConditionalOnProperty(prefix = "myapp.mail",name = "enable",havingValue = "true",matchIfMissing = true)
public class ConditionalConfiguration {

    @Value("${myapp.mail.enable}")
    private Boolean enable;

    private String localPath;

    @Bean
    public Conditional test2() {
        Conditional test = new Conditional();
        test.setEnable(enable);
        test.setUser(localPath);
        return test;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }
}

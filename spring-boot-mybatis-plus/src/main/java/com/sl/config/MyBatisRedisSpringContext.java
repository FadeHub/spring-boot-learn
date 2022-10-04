package com.sl.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @package: com.sl.config
 * @author: shuliangzhao
 * @description:
 * @date 2022/10/4 16:09
 */
@Component
public class MyBatisRedisSpringContext implements ApplicationContextAware, DisposableBean {

   private static ApplicationContext applicationContext = null;

    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        MyBatisRedisSpringContext.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static <T> T getBean(String name) {
        return (T)applicationContext.getBean(name);
    }

    public static <T> T getBean(Class clz) {
        return (T)applicationContext.getBean(clz);
    }

 }

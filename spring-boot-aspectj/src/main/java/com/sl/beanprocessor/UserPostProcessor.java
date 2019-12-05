package com.sl.beanprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author shuliangzhao
 * @Title: UserPostProcessor
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/10/22 19:49
 */
public class UserPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        // 这边只做简单打印   原样返回bean
        System.out.println("postProcessBeforeInitialization===="+beanName);
        return bean;
    }
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        // 这边只做简单打印   原样返回bean
        System.out.println("postProcessAfterInitialization===="+beanName);
        return bean;
    }

}

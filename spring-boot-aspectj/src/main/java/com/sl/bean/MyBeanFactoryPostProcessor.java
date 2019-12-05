package com.sl.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author shuliangzhao
 * @Title: MyBeanFactoryPostProcessor
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/10/20 15:24
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        AbstractBeanDefinition abstractBeanDefinition = (AbstractBeanDefinition) beanFactory.getBeanDefinition("userService");
        MutablePropertyValues pv =  abstractBeanDefinition.getPropertyValues();
        //改变属性的值
        pv.addPropertyValue("desc", "Desc is changed from bean factory post processor");
        abstractBeanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);

    }
}

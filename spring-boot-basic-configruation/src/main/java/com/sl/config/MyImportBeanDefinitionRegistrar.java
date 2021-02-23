package com.sl.config;

import com.sl.entity.Car;
import com.sl.entity.Cat;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author shuliangzhao
 * @Title: MyImportBeanDefinitionRegistrar
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/2/1 18:58
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Car.class);
        registry.registerBeanDefinition("car",rootBeanDefinition);
    }
}

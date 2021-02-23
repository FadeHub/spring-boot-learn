package com.sl.config;

import com.sl.entity.Person;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author shuliangzhao
 * @Title: MyConfig
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/2/1 18:47
 */
@Import({Person.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
@Configuration
public class MyConfig {
}

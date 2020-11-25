package com.sl.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author shuliangzhao
 * @Title: TestCondition
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/11/21 11:55
 */
public class TestCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return true;
    }
}

package com.sl.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author shuliangzhao
 * @Title: AopLog
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/10/13 15:18
 */
@Aspect
@Component
@EnableAspectJAutoProxy
public class AopLog {

    @Pointcut("execution(* com.sl..*.*(..))")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void before() {
        System.out.println("方法执行前...");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("方法执行后...");
    }

    @Around("pointcut()")
    public void around() {
        System.out.println("环绕执行方法...");
    }

    @AfterThrowing("pointcut()")
    public void ffterThrowing() {
        System.out.println("方法执行失败...");
    }
}

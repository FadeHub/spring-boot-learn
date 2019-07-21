package com.sl.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Joinpoint：连接点，类里面可以被增强的方法即为连接点，例如想修改哪个方法的功能，那么这个方法即为连接点
 * Pointcut：切入点，对于Joinpoint进行拦截的定义即为切入点，例如拦截所有的insert
 * Advice：通知，拦截到Joinpoint之后所要做的事就是通知，
 * Aspect：切面，Pointcut和Advice的结合
 * Target：目标对象，要增强类为target
 *
 * @author shuliangzhao
 * @Title: LogAspect
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/21 12:59
 */
@Component
@Aspect
public class LogAspect {

    @Pointcut("execution(* com.sl.service.*.*(..))")
    public void pc() {
    }

    @Before(value = "pc()")
    public void before(JoinPoint jp) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法开始执行...");
    }

    @After(value = "pc()")
    public void after(JoinPoint jp) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法执行结束...");
    }

    @AfterReturning(value = "pc()",returning = "result")
    public void afterReturning(JoinPoint jp,Object result) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法返回值为：" + result);
    }

    @AfterThrowing(value = "pc()",throwing = "e")
    public void afterThrowing(JoinPoint jp,Exception e) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法抛出异常，异常时：" + e);
    }

    @Around("pc()")
    public Object around(ProceedingJoinPoint pj) throws Throwable {
        return pj.proceed();
    }
}

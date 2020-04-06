package com.sl.aspect;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author shuliangzhao
 * @Title: LogAspect
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/4/6 14:25
 */
@Aspect
@Component
public class LogAspect {
    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);
    private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";
    private static final String STRING_START = "\n--------------------------->\n";
    private static final String STRING_END = "\n<----------------------------\n";

    @Pointcut("@annotation(Log)")
    public void logPointCut() {
    }
    
    public Object controllerAround(ProceedingJoinPoint joinPoint) {
        try {
            return printLog(joinPoint);
        } catch (Throwable throwable) {
            log.error(throwable.getMessage(), throwable);
            return true;
        }
    }
    //通知:拦截到连接点之后要执行的代码
    @Around("logPointCut()")
    private Object printLog(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取连接点的方法签名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取方法签名里的方法：方法签名里有两个方法:getReturnType   getMethod
        Method method = signature.getMethod();
        //获取类
        Class<?> targetClass = method.getDeclaringClass();
        StringBuffer classAndMethod = new StringBuffer();

        // 获取目标方法上的Log注解
        Log methodAnnotation = method.getAnnotation(Log.class);

        // 判断是否有LOG注解以及是否带有ignore参数
        if (methodAnnotation != null) {
            classAndMethod.append(methodAnnotation.value());
        }
        //拼接目标切入的类名称和方法名称
        String target = targetClass.getName() + "#" + method.getName();
        // 请求参数转JSON，对日期进行格式转换并打印出所有为null的参数
        String params = JSONObject.toJSONStringWithDateFormat(joinPoint.getArgs(), dateFormat, SerializerFeature.WriteMapNullValue);
        //日志打印拼接的调用信息
        log.info(STRING_START + "{} 开始调用--> {} 参数:{}", classAndMethod.toString(), target, params);

        long start = System.currentTimeMillis();
        //proceed()通过反射执行目标对象的连接点处的方法；
        Object result = joinPoint.proceed();
        long timeConsuming = System.currentTimeMillis() - start;
        if (methodAnnotation != null && methodAnnotation.ignoreReturn()) {
            log.info("\n{} 调用结束<-- {} 耗时:{}ms" + STRING_END, classAndMethod.toString(), target, timeConsuming);
            return result;
        }
        // 响应参数转JSON，对日期进行格式转换并打印出所有为null的参数
        log.info("\n{} 调用结束<-- {} 返回值:{} 耗时:{}ms" + STRING_END, classAndMethod.toString(), target, JSONObject.toJSONStringWithDateFormat(result, dateFormat, SerializerFeature.WriteMapNullValue), timeConsuming);

        return result;
    }

}

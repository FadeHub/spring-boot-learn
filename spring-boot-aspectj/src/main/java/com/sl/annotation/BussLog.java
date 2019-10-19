package com.sl.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author shuliangzhao
 * @Title: BussLog
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/10/14 20:06
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface BussLog {
    /**
     * 业务的名称
     */
    String value() default "";
    

    /**
     * 是否将当前日志记录到数据库中
     */
    boolean save() default true;
}

package com.sl.aspect;

import java.lang.annotation.*;

/**
 * @author shuliangzhao
 * @Title: Log
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/4/6 14:24
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    String value() default ""; //用于描述方法作用

    /**
     * 是否忽略返回值，仅方法上有效
     * @return
     */
    boolean ignoreReturn() default false;

}

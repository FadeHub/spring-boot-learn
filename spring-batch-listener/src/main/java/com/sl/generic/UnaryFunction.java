package com.sl.generic;

/**
 * @author shuliangzhao
 * @Title: UnaryFunction
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/8/2 17:27
 */
public interface UnaryFunction<T> {
    T apply(T t);
}

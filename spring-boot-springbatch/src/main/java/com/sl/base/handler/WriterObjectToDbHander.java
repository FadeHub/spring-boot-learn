package com.sl.base.handler;

import java.util.List;

/**
 * @author shuliangzhao
 * @Title: WriterObjectToDbHander
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/1 22:04
 */
@FunctionalInterface
public interface WriterObjectToDbHander<T> {

    /**
     * 操作对象集合
     * @param items
     */
    void write(List<? extends T> items);
}

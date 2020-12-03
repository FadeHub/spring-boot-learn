package com.sl.base.handler;

/**
 * @author shuliangzhao
 * @Title: ObjectProcessorHandler
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/1 21:59
 */
@FunctionalInterface
public interface ObjectProcessorHandler<I,O> {

    /**
     * 处理reader取出的数据
     * @param i
     * @return
     */
    O process(I i);
}

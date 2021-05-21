package com.sl.bridge;

/**
 * 桥接模式
 * @author shuliangzhao
 * @Title: Brand
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/21 21:59
 */
public interface Brand {

    public void open();

    public void call();

    public void close();
}

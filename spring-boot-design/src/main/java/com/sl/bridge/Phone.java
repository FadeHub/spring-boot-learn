package com.sl.bridge;

/**
 * @author shuliangzhao
 * @Title: Phone
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/21 22:02
 */
public abstract class Phone {

    private Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }

    public void open() {
        this.brand.open();
    }

    public void call() {
        this.brand.call();
    }

    public void close() {
        this.brand.close();
    }
}

package com.sl.bridge;

/**
 * @author shuliangzhao
 * @Title: FoldedPhone
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/21 22:04
 */
public class FoldedPhone extends Phone{

    public FoldedPhone(Brand brand) {
        super(brand);
    }

    @Override
    public void open() {
        super.open();
        System.out.println(" 折叠手机开机");
    }

    @Override
    public void call() {
        super.call();
        System.out.println(" 折叠手机打电话");
    }

    @Override
    public void close() {
        super.close();
        System.out.println(" 折叠手机关机");
    }
}

package com.sl.bridge;

/**
 * @author shuliangzhao
 * @Title: UpRightPhone
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/21 22:06
 */
public class UpRightPhone extends Phone{

    public UpRightPhone(Brand brand) {
        super(brand);
    }

    @Override
    public void open() {
        super.open();
        System.out.println(" 直板手机开机");
    }

    @Override
    public void call() {
        super.call();
        System.out.println(" 直板手机打电话");
    }

    @Override
    public void close() {
        super.close();
        System.out.println(" 直板手机关机");
    }
}

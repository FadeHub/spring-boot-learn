package com.sl.bridge;

/**
 * 桥接模式
 * 要识别出接口和抽象类
 * @author shuliangzhao
 * @Title: Client
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/21 22:08
 */
public class Client {

    public static void main(String[] args) {
        Phone phone = new FoldedPhone(new Vivo());
        phone.open();
        phone.close();
        phone.close();
        System.out.println("++++++++++++++++++++++");
        Phone phone1 = new UpRightPhone(new XiaoMi());
        phone1.open();
        phone1.close();
        phone1.close();
    }
}

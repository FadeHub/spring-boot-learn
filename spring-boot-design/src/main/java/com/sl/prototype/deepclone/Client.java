package com.sl.prototype.deepclone;

/**
 * @author shuliangzhao
 * @Title: Client
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/18 21:11
 */
public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {
        DeepPrototype deepPrototype = new DeepPrototype("钢铁侠",new DeepCloneableTarget("绿巨人","green"));
       // DeepPrototype deepPrototype1 = (DeepPrototype)deepPrototype.clone();
        DeepPrototype deepPrototype1 = (DeepPrototype)deepPrototype.deepClone();
        System.out.println("deepPrototype：" + deepPrototype.getName() + "，hashCode：" + deepPrototype.hashCode());
        System.out.println("deepPrototype1：" + deepPrototype1.getName() + "，hashCode：" + deepPrototype1.hashCode());

    }
}

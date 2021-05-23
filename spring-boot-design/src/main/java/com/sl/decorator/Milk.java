package com.sl.decorator;

/**
 * @author shuliangzhao
 * @Title: Milk
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/23 16:29
 */
public class Milk extends Decorator{
    public Milk(Drink obj) {
        super(obj);
        setDes("牛奶");
        setPrice(1.5);
    }
}

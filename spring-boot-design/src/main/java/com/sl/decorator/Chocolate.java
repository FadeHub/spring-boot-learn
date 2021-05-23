package com.sl.decorator;

/**
 * @author shuliangzhao
 * @Title: Chocolate
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/23 16:30
 */
public class Chocolate extends Decorator{
    public Chocolate(Drink obj) {
        super(obj);
        setDes("巧克力");
        setPrice(5.0);
    }
}

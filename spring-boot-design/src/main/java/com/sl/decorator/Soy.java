package com.sl.decorator;

/**
 * @author shuliangzhao
 * @Title: Soy
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/23 16:31
 */
public class Soy extends Decorator{
    public Soy(Drink obj) {
        super(obj);
        setDes("豆浆");
        setPrice(3.0);
    }
}

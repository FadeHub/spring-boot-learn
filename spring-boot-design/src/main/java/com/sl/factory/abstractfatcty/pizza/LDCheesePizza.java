package com.sl.factory.abstractfatcty.pizza;

/**
 * @author shuliangzhao
 * @Title: BjCheesePizza
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/17 23:49
 */
public class LDCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName(" cheese ");
        System.out.println(" 伦敦的奶酪pizza准备原材料！");
    }
}

package com.sl.decorator;

/**
 * 装饰者模式
 * @author shuliangzhao
 * @Title: CoffeeBar
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/23 16:31
 */
public class CoffeeBar {

    public static void main(String[] args) {
        Drink drink = new LongBlack();
        System.out.println(drink.getDes() + " " + drink.cost());
        drink = new Milk(drink);
        System.out.println(drink.getDes() + " " + drink.cost());
    }
}

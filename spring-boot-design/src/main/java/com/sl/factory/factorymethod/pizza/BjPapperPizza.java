package com.sl.factory.factorymethod.pizza;

/**
 * @author shuliangzhao
 * @Title: BjPapperPizza
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/17 23:51
 */
public class BjPapperPizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println(" 北京的胡椒pizza准备原材料！");
    }
}

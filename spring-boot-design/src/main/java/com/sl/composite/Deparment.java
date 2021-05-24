package com.sl.composite;

/**
 * @author shuliangzhao
 * @Title: Deparment
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/24 22:22
 */
public class Deparment extends OrganizationComponent{

    public Deparment(String name, String desc) {
        super(name, desc);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDesc() {
        return super.getDesc();
    }

    @Override
    protected void print() {
        System.out.println(getName());
    }
}

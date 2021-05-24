package com.sl.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuliangzhao
 * @Title: College
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/24 22:17
 */
public class College extends OrganizationComponent{

    List<OrganizationComponent> organizationComponents = new ArrayList<>();

    public College(String name, String desc) {
        super(name, desc);
    }

    @Override
    public String getDesc() {
        return super.getDesc();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void add(OrganizationComponent organizationComponent) {
        organizationComponents.add(organizationComponent);
    }

    @Override
    public void remove(OrganizationComponent organizationComponent) {
        organizationComponent.remove(organizationComponent);
    }

    @Override
    protected void print() {
        System.out.println("------------"+getName()+"-----------");
        for (OrganizationComponent organizationComponent : organizationComponents) {
            organizationComponent.print();
        }
    }
}

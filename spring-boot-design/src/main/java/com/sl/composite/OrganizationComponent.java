package com.sl.composite;

/**
 * @author shuliangzhao
 * @Title: OrganizationComponent
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/24 22:10
 */
public abstract class OrganizationComponent {

    private String name;

    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public OrganizationComponent(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    //添加
    public void add(OrganizationComponent organizationComponent) {
        throw new UnsupportedOperationException();
    }

    //删除
    public void remove(OrganizationComponent organizationComponent) {
        throw new UnsupportedOperationException();
    }

    protected abstract void print();
}

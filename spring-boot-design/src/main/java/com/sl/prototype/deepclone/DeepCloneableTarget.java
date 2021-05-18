package com.sl.prototype.deepclone;

import java.io.Serializable;

/**
 * @author shuliangzhao
 * @Title: DeepCloneableTarget
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/18 21:05
 */
public class DeepCloneableTarget implements Serializable,Cloneable {

    private String name;

    private String colour;

    public DeepCloneableTarget(String name, String colour) {
        this.name = name;
        this.colour = colour;
    }

    public DeepCloneableTarget() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        DeepCloneableTarget deepCloneableTarget = (DeepCloneableTarget)super.clone();
        return deepCloneableTarget;
    }
}

package com.sl.entity;

/**
 * @package: com.sl
 * @author: shuliangzhao
 * @description:
 * @date 2021/12/12 15:50
 */
public class LimitMesh {

    private int id;

    private String parentNode;

    private String childNode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParentNode() {
        return parentNode;
    }

    public void setParentNode(String parentNode) {
        this.parentNode = parentNode;
    }

    public String getChildNode() {
        return childNode;
    }

    public void setChildNode(String childNode) {
        this.childNode = childNode;
    }
}

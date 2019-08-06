package com.sl.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @author shuliangzhao
 * @Title: Permission
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/8/6 19:22
 */
public class Permission implements Serializable {

    private Integer id;

    private String url;

    private Integer roleId;

    private String permission;

    private List<String> permissions;

    public List<String> getPermissions() {
        return Arrays.asList(this.permission.trim().split(","));
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}

package com.sl.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author shuliangzhao
 * @Title: SysUser
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/20 15:34
 */
@Data
@ToString
public class SysUser {

    private int id;

    private String username;

    private String password;
}

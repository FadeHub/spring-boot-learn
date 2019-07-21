package com.sl.service;

import org.springframework.stereotype.Service;

/**
 * @author shuliangzhao
 * @Title: UserService
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/21 13:36
 */
@Service
public class UserService {

    public String getUser() {
        System.out.println("getUser...");
        return "zhangsan";
    }

    public void deleteUser() {
        System.out.println("deleteUser...");
    }
}

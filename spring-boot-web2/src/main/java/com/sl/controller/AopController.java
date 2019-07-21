package com.sl.controller;

import com.sl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuliangzhao
 * @Title: AopController
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/21 13:35
 */
@RestController
public class AopController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public String getUser() {
        return userService.getUser();
    }

    @GetMapping("/deleteUser")
    public void deleteUser() {
        userService.deleteUser();
    }
}

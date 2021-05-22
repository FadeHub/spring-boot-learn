package com.sl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuliangzhao
 * @Title: LoginController
 * @ProjectName SpringSecurityDemo
 * @Description: TODO
 * @date 2021/5/19 14:04
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello Security";
    }

    @GetMapping("/index")
    public String index() {
        return "Hello index";
    }
}

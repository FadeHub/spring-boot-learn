package com.sl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuliangzhao
 * @Title: Oauth2Controller
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/4 20:46
 *
 */
@RestController
public class Oauth2Controller {

    @GetMapping("/admin/hello")
    public String admin() {
         return  "hello admin";
    }

    @GetMapping("/user/hello")
    public String user() {
        return  "hello user";
    }
    @GetMapping("/hello")
    public String hello() {
        return  "hello";
    }
}

package com.sl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuliangzhao
 * @Title: TestController
 * @ProjectName design-parent
 * @Description: TODO
 * @date 2019/6/20 23:20
 */
@RestController
public class TestController {

    @RequestMapping("/")
    public String home() {
        return "hello world";
    }
}

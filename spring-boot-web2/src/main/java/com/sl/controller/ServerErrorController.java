package com.sl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuliangzhao
 * @Title: TestController
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/20 18:15
 */
@RestController
public class ServerErrorController {

    @GetMapping("/getError")
    public void serverError() {
        int i = 1 /0;
    }
}

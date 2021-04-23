package com.sl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author shuliangzhao
 * @Title: FulxController
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/4/23 16:19
 */
@RestController
public class FulxController {

    @GetMapping("/fulx")
    public Mono<String> fulx() {
      return Mono.just("234");
    }

}

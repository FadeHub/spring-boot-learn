package com.sl.controller;

import org.springframework.web.bind.annotation.*;

/**
 * 跨域
 * @author shuliangzhao
 * @Title: CrosController
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/21 11:03
 */
@RestController
@RequestMapping("/cros")
public class CrosController {


    @PostMapping("/book")
    @CrossOrigin(value = "http://localhost:8081",maxAge = 1800,allowedHeaders = "*")
    public String addBook(String name) {
        return "receive:" + name;
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(value = "http://localhost:8081",maxAge = 1800,allowedHeaders = "*")
    public String deleteBookById(@PathVariable Long id) {
        return String.valueOf(id);
    }
}

package com.sl.controller;

import com.sl.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuliangzhao
 * @Title: ProfileController
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/3/21 16:34
 */
@RestController
public class ProfileController {

    @Autowired
    private Person person;

    @GetMapping("/person")
    public Person person() {
        return person;
    }
}

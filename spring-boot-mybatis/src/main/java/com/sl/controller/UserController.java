package com.sl.controller;

import com.sl.entity.User;
import com.sl.mapper1.BookMapper;
import com.sl.mapper2.BookMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author shuliangzhao
 * @Title: UserController
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/23 23:08
 */
@RestController
public class UserController {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookMapper2 bookMapper2;

    @GetMapping("/get")
    public void getUser() {
        List<User> user = bookMapper.getUser();
        System.out.println("user:" + user);
        List<User> user1 = bookMapper2.getUser();
        System.out.println("user1:" + user1);
    }

    @GetMapping("/save")
    public void save() {
        User user = new User();
        user.setName("张三");
        user.setAge("12");
        bookMapper.insert(user);
    }
}

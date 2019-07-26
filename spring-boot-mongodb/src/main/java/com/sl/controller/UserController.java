package com.sl.controller;

import com.sl.dao.UserDao;
import com.sl.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuliangzhao
 * @Title: UserController
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/26 22:24
 */
@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/save")
    public void save() {
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setId("1");
        user.setName("张三");
        user.setAge("13");
        userList.add(user);
        user = new User();
        user.setId("2");
        user.setName("李四");
        user.setAge("24");
        userList.add(user);
        userDao.save(user);
        User user1 = userDao.findByNameEquals("张三");
        System.out.println(user);
    }
}

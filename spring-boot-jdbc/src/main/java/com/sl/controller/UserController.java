package com.sl.controller;

import com.sl.dao.UserDao;
import com.sl.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuliangzhao
 * @Title: UserController
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/23 22:21
 */
@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/save")
    public void save() {
        User user = new User();
        user.setName("张三");
        user.setAge("20");
        userDao.save(user);
        user = new User();
        user.setName("李四");
        user.setAge("20");
        userDao.save(user);

    }

    @GetMapping("/get")
    public void get() {
       userDao.getList();
    }
}

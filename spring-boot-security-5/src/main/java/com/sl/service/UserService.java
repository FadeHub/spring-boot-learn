package com.sl.service;

import com.sl.dao.UserMapper;
import com.sl.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shuliangzhao
 * @Title: UserService
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/8/3 14:32
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User selectById(Integer id) {
        return  userMapper.selectById(id);
    }

    public User selectByName(String name) {
        return userMapper.selectByName(name);
    }
}


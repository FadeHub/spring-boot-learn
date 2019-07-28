package com.sl.controller;

import com.alibaba.fastjson.JSONObject;
import com.sl.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuliangzhao
 * @Title: UserController
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/28 17:13
 */
@RestController
public class UserController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/save")
    public void save() {
        User user = new User();
        user.setAge("21");
        user.setName("张三");
        redisTemplate.opsForValue().set("clusterUser",user);
    }

    @GetMapping("/get")
    public void get() {
        System.out.println(JSONObject.toJSONString(redisTemplate.opsForValue().get("clusterUser")));
    }
}

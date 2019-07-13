package com.sl.controller;

import com.alibaba.fastjson.JSONObject;
import com.sl.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author shuliangzhao
 * @Title: RedisController
 * @ProjectName design-parent
 * @Description: TODO
 * @date 2019/7/13 17:40
 */
@RestController
public class RedisController {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @RequestMapping("/user/save")
    public void saveUser() {
        User user = new User();
        user.setName("张三");
        user.setAge("18");
        user.setJob("程序员");
        redisTemplate.opsForValue().set("userZhang", JSONObject.toJSONString(user));
    }

    @RequestMapping("/user/get")
    public String getUser() {
        return (String)redisTemplate.opsForValue().get("userZhang");
    }
}

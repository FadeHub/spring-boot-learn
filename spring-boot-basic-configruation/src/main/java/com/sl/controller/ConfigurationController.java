package com.sl.controller;

import com.alibaba.fastjson.JSONObject;
import com.sl.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuliangzhao
 * @Title: ConfigurationController
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/16 0:11
 */
@RestController
public class ConfigurationController {

    @Autowired
    private User user;

    @RequestMapping("/user/get")
    public String getUser() {
        return JSONObject.toJSONString(user);
    }
}

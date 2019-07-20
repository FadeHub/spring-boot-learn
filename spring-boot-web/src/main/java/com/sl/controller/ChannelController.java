package com.sl.controller;

import com.sl.channel.Channel;
import com.sl.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * @author shuliangzhao
 * @Title: ChannelController
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/20 15:07
 */
@RestController
public class ChannelController {

    @Autowired
    private Map<String, Channel> channel;
    @GetMapping("/channel")
    public void channel() {
        System.out.println(channel);
    }

}

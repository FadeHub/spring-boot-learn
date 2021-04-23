package com.sl.controller;

import com.sl.chapter03.ChannelEnum;
import com.sl.chapter03.ChannelFactory;
import com.sl.chapter03.strategy.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuliangzhao
 * @Title: ChannelController
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/4/23 11:28
 */
@RestController
public class ChannelController {

    @Autowired
    private ChannelFactory channelFactory;

    @GetMapping("/consu")
    public void consumption(@RequestParam("type") String type) {
        ChannelEnum channelEnum = ChannelEnum.valueOf(type);
        ChannelService channelService = channelFactory.channelService(channelEnum);
        channelService. refund();
    }
}

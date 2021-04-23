package com.sl.chapter03.impl;

import com.sl.chapter03.ChannelEnum;
import com.sl.chapter03.strategy.ChannelService;
import org.springframework.stereotype.Service;

/**
 * @author shuliangzhao
 * @Title: JcbChannelService
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/4/23 11:19
 */
@Service
public class JcbChannelService implements ChannelService {
    @Override
    public ChannelEnum type() {
        return ChannelEnum.JCB;
    }

    @Override
    public void consumption() {
        System.out.println("use jcb buy some book...");
    }

    @Override
    public void refund() {
        System.out.println("jcb refund..");
    }
}

package com.sl.chapter03.impl;

import com.sl.chapter03.ChannelEnum;
import com.sl.chapter03.strategy.ChannelService;
import org.springframework.stereotype.Service;

/**
 * @author shuliangzhao
 * @Title: CupChannelService
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/4/23 11:17
 */
@Service
public class CupChannelService implements ChannelService {
    @Override
    public ChannelEnum type() {
        return ChannelEnum.CUP;
    }

    @Override
    public void consumption() {
        System.out.println("use cup buy some book...");
    }

    @Override
    public void refund() {
        System.out.println("cup refund..");
    }
}

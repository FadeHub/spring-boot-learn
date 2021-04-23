package com.sl.chapter03.impl;

import com.sl.chapter03.ChannelEnum;
import com.sl.chapter03.strategy.ChannelService;
import org.springframework.stereotype.Service;

/**
 * @author shuliangzhao
 * @Title: VisaChannelService
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/4/23 11:20
 */
@Service
public class VisaChannelService implements ChannelService {
    @Override
    public ChannelEnum type() {
        return ChannelEnum.VISA;
    }

    @Override
    public void consumption() {
        System.out.println("use visa buy some book...");
    }

    @Override
    public void refund() {
        System.out.println("visa refund..");
    }
}

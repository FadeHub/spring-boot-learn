package com.sl.chapter03.strategy;

import com.sl.chapter03.ChannelEnum;

/**
 * @author shuliangzhao
 * @Title: ChannelService
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/4/23 11:07
 */
public interface ChannelService {

    ChannelEnum type();

    /**
     * 消费
     */
    void consumption();

    /**
     * 退款
     */
    void refund();
}

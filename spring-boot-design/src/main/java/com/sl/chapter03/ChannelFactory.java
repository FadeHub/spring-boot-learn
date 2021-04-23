package com.sl.chapter03;

import com.sl.chapter03.strategy.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author shuliangzhao
 * @Title: ChannelFactory
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/4/23 11:23
 */
@Service
public class ChannelFactory {

    @Autowired
    private List<ChannelService> channelServices;

    public ChannelService channelService(ChannelEnum channelEnum) {
        Optional<ChannelService> any = channelServices.stream().filter(channelService -> channelService.type() == channelEnum).findAny();
        return any.orElseThrow(() -> new IllegalArgumentException("暂不支持该渠道"));
    }
}

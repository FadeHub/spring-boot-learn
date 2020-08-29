package com.sl.generic;

import org.springframework.stereotype.Component;

/**
 * @author shuliangzhao
 * @Title: CupChannelProcessor
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/8/27 22:53
 */
@Component
public class CupChannelProcessor implements ChannelProcessor {
    @Override
    public void processor() {
        System.out.println("cup...");
    }
}

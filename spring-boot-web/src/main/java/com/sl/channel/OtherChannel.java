package com.sl.channel;

import org.springframework.stereotype.Component;

/**
 * @author shuliangzhao
 * @Title: OtherChannel
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/20 15:06
 */
@Component
public class OtherChannel implements Channel {
    @Override
    public void channel() {
        System.out.println("other");
    }
}

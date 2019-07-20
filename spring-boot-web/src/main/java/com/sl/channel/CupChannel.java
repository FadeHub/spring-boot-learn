package com.sl.channel;

import org.springframework.stereotype.Component;

/**
 * @author shuliangzhao
 * @Title: CupChannel
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/20 15:06
 */
@Component
public class CupChannel implements Channel {
    @Override
    public void channel() {
        System.out.println("cup");
    }
}

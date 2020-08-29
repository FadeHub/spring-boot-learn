package com.sl.generic;

import org.springframework.stereotype.Component;

/**
 * @author shuliangzhao
 * @Title: JcbChannelProcessor
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/8/27 22:54
 */
@Component
public class JcbChannelProcessor implements ChannelProcessor {
    @Override
    public void processor() {
        System.out.println("jcb...");
    }
}

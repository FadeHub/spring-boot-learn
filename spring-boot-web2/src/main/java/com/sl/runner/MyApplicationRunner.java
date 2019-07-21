package com.sl.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * --name = zhangsan getOptionNames getOptionValues
 * 路遥 平凡的世界 getNonOptionArgs取值
 * @author shuliangzhao
 * @Title: MyApplicationRunner
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/21 12:36
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String> nonOptionArgs = args.getNonOptionArgs();
        System.out.println("nonOptionArgs>>>" + nonOptionArgs);
        Set<String> optionNames = args.getOptionNames();
        for (String optionName:optionNames) {
            System.out.println("key:" + optionName + ";value:" + args.getOptionValues(optionName));
        }
    }
}

package com.sl.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuliangzhao
 * @Title: Test
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/24 19:41
 */
public class Test {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        while (true) {
            list.add(new Test());
        }
    }
}

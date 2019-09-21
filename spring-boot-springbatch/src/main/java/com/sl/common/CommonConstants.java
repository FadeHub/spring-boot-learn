package com.sl.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuliangzhao
 * @Title: CommonConstants
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/7 16:34
 */
public class CommonConstants {

    public static final String ENCODING_READ = "GBK";

    private static final List<String> list = new ArrayList<>();
    public static List<String> getList() {
        return list;
    }
}

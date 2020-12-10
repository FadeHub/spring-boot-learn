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

    public static final String JDBC_CUSOR_SQL = "SELECT acctId,amout,name,date,address FROM credit_bill where id BETWEEN 1 and 5 ";

    private static final List<String> list = new ArrayList<>();
    public static List<String> getList() {
        return list;
    }
}

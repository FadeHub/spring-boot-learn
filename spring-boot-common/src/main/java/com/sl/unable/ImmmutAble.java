package com.sl.unable;

import java.math.BigDecimal;
import java.util.List;

/**
 * @package: com.sl.immutable
 * @author: shuliangzhao
 * @description:
 * @date 2022/2/12 14:59
 */
public class ImmmutAble {

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("200");
        add1(bigDecimal);
        System.out.println(bigDecimal);
        BigDecimal bigDecimal1 = add2(bigDecimal);
        System.out.println(bigDecimal1);
    }

    public static void add1(BigDecimal bigDecimal) {
        bigDecimal.add(new BigDecimal("200"));
    }

    public static BigDecimal add2(BigDecimal bigDecimal) {
       return bigDecimal.add(new BigDecimal("200"));
    }
}

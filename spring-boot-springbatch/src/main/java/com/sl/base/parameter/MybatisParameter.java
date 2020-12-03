package com.sl.base.parameter;

import java.util.Map;

/**
 * @author shuliangzhao
 * @Title: MybatisParameter
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/1 20:49
 */
@FunctionalInterface
public interface MybatisParameter {
    Map<String,Object> parameters();
}

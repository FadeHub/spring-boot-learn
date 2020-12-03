package com.sl.mapper;

import com.sl.entity.CafeCat;

import java.util.List;

/**
 * @author shuliangzhao
 * @Title: CafeCatMapper
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/2 22:01
 */
public interface CafeCatMapper {

    int insert(List<? extends CafeCat> cafeCat);
}

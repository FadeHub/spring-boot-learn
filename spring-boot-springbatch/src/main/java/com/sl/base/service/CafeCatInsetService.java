package com.sl.base.service;

import com.sl.entity.CafeCat;

import java.util.List;

/**
 * @author shuliangzhao
 * @Title: CafeCatInsetService
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/2 22:10
 */
public interface CafeCatInsetService {

    void insertCafeCat(List<? extends CafeCat> list);
}

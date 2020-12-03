package com.sl.base.service;

import com.sl.entity.CafeCat;
import com.sl.entity.Cat;

/**
 * @author shuliangzhao
 * @Title: CafeService
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/2 21:47
 */
public interface CafeService {

    CafeCat createCafeCat(Cat cat);
}

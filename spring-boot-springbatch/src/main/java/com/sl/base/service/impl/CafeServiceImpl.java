package com.sl.base.service.impl;

import com.sl.base.service.CafeService;
import com.sl.entity.CafeCat;
import com.sl.entity.Cat;
import org.springframework.stereotype.Service;

/**
 * @author shuliangzhao
 * @Title: CafeServiceImpl
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/2 21:48
 */
@Service
public class CafeServiceImpl implements CafeService {
    @Override
    public CafeCat createCafeCat(Cat cat) {
        CafeCat o = new CafeCat();
        o.setCataddress(cat.getCataddress());
        o.setCatage(cat.getCatage());
        o.setCatname(cat.getCatname());
        return o;
    }
}

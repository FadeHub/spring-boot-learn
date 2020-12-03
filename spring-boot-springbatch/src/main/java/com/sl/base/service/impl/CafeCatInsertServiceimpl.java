package com.sl.base.service.impl;

import com.sl.base.service.CafeCatInsetService;
import com.sl.entity.CafeCat;
import com.sl.mapper.CafeCatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shuliangzhao
 * @Title: CafeCatInsertServiceimpl
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/2 22:11
 */
@Service
public class CafeCatInsertServiceimpl implements CafeCatInsetService {

    @Autowired
    private CafeCatMapper cafeCatMapper;

    @Override
    public void insertCafeCat(List<? extends CafeCat> list) {
        cafeCatMapper.insert(list);
    }
}

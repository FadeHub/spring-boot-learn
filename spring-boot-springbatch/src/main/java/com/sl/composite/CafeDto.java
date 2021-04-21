package com.sl.composite;

import com.sl.entity.CafeCat;
import com.sl.entity.Cat;

/**
 * @author shuliangzhao
 * @Title: CafeDto
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/4/21 11:15
 */
public class CafeDto {

    private CafeCat cafeCat;

    private Cat cat;

    public CafeCat getCafeCat() {
        return cafeCat;
    }

    public void setCafeCat(CafeCat cafeCat) {
        this.cafeCat = cafeCat;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }
}

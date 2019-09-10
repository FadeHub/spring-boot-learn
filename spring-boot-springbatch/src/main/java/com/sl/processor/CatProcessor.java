package com.sl.processor;

import com.sl.common.CommonProcessor;
import com.sl.entity.CafeCat;
import com.sl.entity.Cat;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.stereotype.Component;

/**
 * @author shuliangzhao
 * @Title: CatProcessor
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/10 20:13
 */
@Component
@StepScope
public class CatProcessor extends CommonProcessor<CafeCat, Cat> {
    @Override
    public void processor(Cat o, CafeCat cafeCat) {
        o.setCataddress(cafeCat.getCataddress());
        o.setCatage(cafeCat.getCatage());
        o.setCatname(cafeCat.getCatname());
    }
}

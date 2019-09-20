package com.sl.processor;

import com.sl.common.CommonProcessor;
import com.sl.entity.CafeCat;
import com.sl.entity.Cat;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.stereotype.Component;

/**
 * @author shuliangzhao
 * @Title: CatWriteJsonProcessor
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/18 20:00
 */
@Component
@StepScope
public class CatWriteJsonProcessor extends CommonProcessor<Cat, CafeCat> {
    @Override
    public void processor(CafeCat o, Cat cat) {
        o.setCatname(cat.getCatname());
        o.setCatage(cat.getCatage());
        o.setCataddress(cat.getCataddress());
    }
}

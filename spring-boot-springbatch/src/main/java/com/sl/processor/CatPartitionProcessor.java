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
 * @date 2019/9/15 20:13
 */
@Component
@StepScope
public class CatPartitionProcessor extends CommonProcessor<Cat, CafeCat> {

    @Override
    public void processor(CafeCat o, Cat cat) {
        o.setCataddress(cat.getCataddress());
        o.setCatage(cat.getCatage());
        o.setCatname(cat.getCatname());
    }
}

package com.sl.processor;

import cn.hutool.core.bean.BeanUtil;
import com.sl.common.CommonProcessor;
import com.sl.entity.CafeCat;
import com.sl.entity.Cat;
import com.sl.entity.TDmCust;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.stereotype.Component;

/**
 * @author shuliangzhao
 * @Title: CafeCatProcessor
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/9/8 14:36
 */
@Component
@StepScope
public class TDmCustProcessor extends CommonProcessor<TDmCust, TDmCust> {

    @Override
    public void processor(TDmCust o, TDmCust tDmCust) {
        BeanUtil.copyProperties(tDmCust,o);
    }
}

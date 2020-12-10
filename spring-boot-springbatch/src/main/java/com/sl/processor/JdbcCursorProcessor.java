package com.sl.processor;

import com.sl.entity.CreditBill;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.converters.SqlDateConverter;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author shuliangzhao
 * @Title: JdbcCursorProcessor
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/10 21:45
 */
@Component
@StepScope
public class JdbcCursorProcessor implements ItemProcessor<CreditBill,CreditBill> {
    @Override
    public CreditBill process(CreditBill item) throws Exception {
        CreditBill creditBill = new CreditBill();
        //解决Bean copy Date类型不能映射问题
        BeanUtilsBean.getInstance().getConvertUtils().register(new SqlDateConverter(null),java.sql.Date.class);
        BeanUtilsBean.getInstance().getConvertUtils().register(new SqlDateConverter(null),java.util.Date.class);
        BeanUtils.copyProperties(item,creditBill);
        return creditBill;
    }
}

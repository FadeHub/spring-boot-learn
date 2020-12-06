package com.sl.processor;

import com.sl.dto.CreditAndDebitBill;
import com.sl.entity.CreditBill;
import com.sl.entity.DebitBill;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author shuliangzhao
 * @Title: PatternMatchProcessor
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/6 14:32
 */
@Component
@StepScope
public class PatternMatchProcessor implements ItemProcessor<CreditAndDebitBill,CreditAndDebitBill> {
    @Override
    public CreditAndDebitBill process(CreditAndDebitBill item) throws Exception {
        CreditAndDebitBill creditAndDebitBill = new CreditAndDebitBill();
        if (item.getCreditBill() != null) {
            CreditBill creditBill = new CreditBill();
            BeanUtils.copyProperties(item.getCreditBill(),creditBill);
            creditAndDebitBill.setCreditBill(creditBill);
        }
        if (item.getDebitBill() != null) {
            DebitBill debitBill = new DebitBill();
            BeanUtils.copyProperties(item.getDebitBill(),debitBill);
            creditAndDebitBill.setDebitBill(debitBill);
        }
        return creditAndDebitBill;
    }
}

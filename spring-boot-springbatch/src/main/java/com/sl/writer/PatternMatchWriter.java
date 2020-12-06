package com.sl.writer;

import com.sl.dto.CreditAndDebitBill;
import com.sl.mapper.CreditBillMapper;
import com.sl.mapper.DebitBillMapper;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author shuliangzhao
 * @Title: PatternMatchWriter
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/6 14:35
 */
@Component
@StepScope
public class PatternMatchWriter implements ItemWriter<CreditAndDebitBill> {

    @Autowired
    private CreditBillMapper creditBillMapper;

    @Autowired
    private DebitBillMapper debitBillMapper;

    @Override
    public void write(List<? extends CreditAndDebitBill> items) throws Exception {
        for (CreditAndDebitBill creditAndDebitBill:items) {
            if (creditAndDebitBill.getDebitBill() != null) {
                debitBillMapper.insert(creditAndDebitBill.getDebitBill());
            }
            if (creditAndDebitBill.getCreditBill() != null) {
                creditBillMapper.insert(creditAndDebitBill.getCreditBill());
            }
        }
    }
}

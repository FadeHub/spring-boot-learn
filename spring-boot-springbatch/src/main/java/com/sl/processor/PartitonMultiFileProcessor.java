package com.sl.processor;

import com.sl.entity.CreditBill;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * @author shuliangzhao
 * @Title: PartitonMultiFileProcessor
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/4 22:11
 */
@Component
@StepScope
public class PartitonMultiFileProcessor implements ItemProcessor<CreditBill,CreditBill> {
    @Override
    public CreditBill process(CreditBill item) throws Exception {
        CreditBill creditBill = new CreditBill();
        creditBill.setAcctid(item.getAcctid());
        creditBill.setAddress(item.getAddress());
        creditBill.setAmout(item.getAmout());
        creditBill.setDate(item.getDate());
        creditBill.setName(item.getName());
        return creditBill;
    }
}

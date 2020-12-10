package com.sl.writer;

import com.sl.entity.CreditBill;
import com.sl.mapper.CreditBillMapper;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author shuliangzhao
 * @Title: JdbcCursorWriter
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/10 21:47
 */
@Component
@StepScope
public class JdbcCursorWriter implements ItemWriter<CreditBill> {

    @Autowired
    private CreditBillMapper creditBillMapper;

    @Override
    public void write(List<? extends CreditBill> items) throws Exception {
        items.forEach(item -> {
            creditBillMapper.insert(item);
        });
    }
}

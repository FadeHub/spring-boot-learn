package com.sl.writer;

import com.sl.entity.CreditBill;
import com.sl.mapper.CreditBillMapper;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuliangzhao
 * @Title: PartitionMultiFileWriter
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/4 22:29
 */
@Component
@StepScope
public class PartitionMultiFileWriter implements ItemWriter<CreditBill> {

    @Autowired
    private CreditBillMapper creditBillMapper;

    @Override
    public void write(List<? extends CreditBill> items) throws Exception {
        if (items != null && items.size() > 0) {
            items.stream().forEach(item -> {
                creditBillMapper.insert(item);
            });
        }
    }
}

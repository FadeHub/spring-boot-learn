package com.sl.fieldsetmpper;

import com.sl.dto.CreditAndDebitBill;
import com.sl.entity.DebitBill;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * @author shuliangzhao
 * @Title: DebitBillFieldSetMapper
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/6 14:26
 */
public class DebitBillFieldSetMapper implements FieldSetMapper<CreditAndDebitBill> {
    @Override
    public CreditAndDebitBill mapFieldSet(FieldSet fieldSet) throws BindException {
        CreditAndDebitBill creditAndDebitBill = new CreditAndDebitBill();
        DebitBill debitBill = new DebitBill();
        debitBill.setAcctid(fieldSet.readString("acctid"));
        debitBill.setAmout(fieldSet.readInt("amout"));
        debitBill.setDate(fieldSet.readDate("date"));
        debitBill.setName(fieldSet.readString("name"));
        creditAndDebitBill.setDebitBill(debitBill);
        return creditAndDebitBill;
    }
}

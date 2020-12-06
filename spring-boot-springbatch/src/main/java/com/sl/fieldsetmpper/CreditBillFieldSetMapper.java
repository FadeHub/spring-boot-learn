package com.sl.fieldsetmpper;

import com.sl.dto.CreditAndDebitBill;
import com.sl.entity.CreditBill;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * @author shuliangzhao
 * @Title: CreaditBillFieldSetMapper
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/6 14:22
 */
public class CreditBillFieldSetMapper implements FieldSetMapper<CreditAndDebitBill> {
    @Override
    public CreditAndDebitBill mapFieldSet(FieldSet fieldSet) throws BindException {
        CreditAndDebitBill creaditAndDebitBill = new CreditAndDebitBill();
        CreditBill creditBill = new CreditBill();
        creditBill.setName(fieldSet.readString("name"));
        creditBill.setDate(fieldSet.readDate("date"));
        creditBill.setAmout(fieldSet.readInt("amout"));
        creditBill.setAddress(fieldSet.readString("address"));
        creditBill.setAcctid(fieldSet.readString("acctid"));
        creaditAndDebitBill.setCreditBill(creditBill);
        return creaditAndDebitBill;
    }
}

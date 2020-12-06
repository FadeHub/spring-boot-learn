package com.sl.dto;

import com.sl.entity.CreditBill;
import com.sl.entity.DebitBill;

/**
 * @author shuliangzhao
 * @Title: CreaditAndDebitBill
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/6 14:22
 */
public class CreditAndDebitBill {

    private CreditBill creditBill;

    private DebitBill debitBill;

    public CreditBill getCreditBill() {
        return creditBill;
    }

    public void setCreditBill(CreditBill creditBill) {
        this.creditBill = creditBill;
    }

    public DebitBill getDebitBill() {
        return debitBill;
    }

    public void setDebitBill(DebitBill debitBill) {
        this.debitBill = debitBill;
    }
}

package com.sl.entity;

import java.util.Date;

public class DebitBill extends BaseEntity {
    private String acctid;

    private Integer amout;

    private String name;

    private Date date;

    public String getAcctid() {
        return acctid;
    }

    public void setAcctid(String acctid) {
        this.acctid = acctid == null ? null : acctid.trim();
    }

    public Integer getAmout() {
        return amout;
    }

    public void setAmout(Integer amout) {
        this.amout = amout;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
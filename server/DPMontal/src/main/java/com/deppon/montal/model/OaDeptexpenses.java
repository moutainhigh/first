package com.deppon.montal.model;

import java.math.BigDecimal;

import com.deppon.montal.conf.F_Constants;

public class OaDeptexpenses {
    private BigDecimal id;

    private BigDecimal processinstid;

    private String dept;

    private String charges;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(BigDecimal processinstid) {
        this.processinstid = processinstid;
    }

    public String getDept() {
        return F_Constants.chageNull(dept);
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getCharges() {
        return F_Constants.chageNull(charges);
    }

    public void setCharges(String charges) {
        this.charges = charges;
    }
}
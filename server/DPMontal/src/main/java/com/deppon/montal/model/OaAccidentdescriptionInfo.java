package com.deppon.montal.model;

import java.math.BigDecimal;

import com.deppon.montal.conf.F_Constants;

public class OaAccidentdescriptionInfo {
    private BigDecimal id;

    private BigDecimal processinstid;

    private String accidenttype;

    private BigDecimal accidentacount;

    private String description;

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

    public String getAccidenttype() {
        return F_Constants.chageNull(accidenttype);
    }

    public void setAccidenttype(String accidenttype) {
        this.accidenttype = accidenttype;
    }

    public BigDecimal getAccidentacount() {
        return accidentacount;
    }

    public void setAccidentacount(BigDecimal accidentacount) {
        this.accidentacount = accidentacount;
    }

    public String getDescription() {
        return F_Constants.chageNull(description);
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
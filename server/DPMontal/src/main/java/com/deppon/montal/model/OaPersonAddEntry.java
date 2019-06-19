package com.deppon.montal.model;

import java.math.BigDecimal;

import com.deppon.montal.conf.F_Constants;
/**
 * @yin 增补员申请详细列表（新）
 *
 */
public class OaPersonAddEntry {
    private BigDecimal id;

    private BigDecimal processinstid;

    private String addposition;

    private String addnumber;

    private String personinfos;

    private String sexrequire;

    private BigDecimal mennumber;

    private BigDecimal womennumber;

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

    public String getAddposition() {
        return F_Constants.chageNull(addposition);
    }

    public void setAddposition(String addposition) {
        this.addposition = addposition;
    }

    public String getAddnumber() {
        return F_Constants.chageNull(addnumber);
    }

    public void setAddnumber(String addnumber) {
        this.addnumber = addnumber;
    }

    public String getPersoninfos() {
        return F_Constants.chageNull(personinfos);
    }

    public void setPersoninfos(String personinfos) {
        this.personinfos = personinfos;
    }

    public String getSexrequire() {
        return F_Constants.chageNull(sexrequire);
    }

    public void setSexrequire(String sexrequire) {
        this.sexrequire = sexrequire;
    }

    public BigDecimal getMennumber() {
        return mennumber;
    }

    public void setMennumber(BigDecimal mennumber) {
        this.mennumber = mennumber;
    }

    public BigDecimal getWomennumber() {
        return womennumber;
    }

    public void setWomennumber(BigDecimal womennumber) {
        this.womennumber = womennumber;
    }
}
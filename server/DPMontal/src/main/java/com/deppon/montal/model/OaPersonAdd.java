package com.deppon.montal.model;

import java.math.BigDecimal;

import com.deppon.montal.conf.F_Constants;
/**
 * 
 * @yin 增补员申请（新）
 *
 */
public class OaPersonAdd {
    private BigDecimal processinstid;

    private String name;

    private BigDecimal empid;

    private String reason;

    private BigDecimal addnum;

    private String position;

    private String sexrequire;

    private String otherrequire;

    private String depttype;

    private String localpersonnel;

    private String servent;

    private String positionproperty;

    private String userid;

    private String addreason;

    private String psdata;

    private String serventfinacode;

    private String jareaselect;

    private String yareaselect;

    public BigDecimal getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(BigDecimal processinstid) {
        this.processinstid = processinstid;
    }

    public String getName() {
        return F_Constants.chageNull(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getEmpid() {
        return empid;
    }

    public void setEmpid(BigDecimal empid) {
        this.empid = empid;
    }

    public String getReason() {
        return F_Constants.chageNull(reason);
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public BigDecimal getAddnum() {
        return addnum;
    }

    public void setAddnum(BigDecimal addnum) {
        this.addnum = addnum;
    }

    public String getPosition() {
        return F_Constants.chageNull(position);
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSexrequire() {
        return F_Constants.chageNull(sexrequire);
    }

    public void setSexrequire(String sexrequire) {
        this.sexrequire = sexrequire;
    }

    public String getOtherrequire() {
        return F_Constants.chageNull(otherrequire);
    }

    public void setOtherrequire(String otherrequire) {
        this.otherrequire = otherrequire;
    }

    public String getDepttype() {
        return F_Constants.chageNull(depttype);
    }

    public void setDepttype(String depttype) {
        this.depttype = depttype;
    }

    public String getLocalpersonnel() {
        return F_Constants.chageNull(localpersonnel);
    }

    public void setLocalpersonnel(String localpersonnel) {
        this.localpersonnel = localpersonnel;
    }

    public String getServent() {
        return F_Constants.chageNull(servent);
    }

    public void setServent(String servent) {
        this.servent = servent;
    }

    public String getPositionproperty() {
        return F_Constants.chageNull(positionproperty);
    }

    public void setPositionproperty(String positionproperty) {
        this.positionproperty = positionproperty;
    }

    public String getUserid() {
        return F_Constants.chageNull(userid);
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getAddreason() {
        return F_Constants.chageNull(addreason);
    }

    public void setAddreason(String addreason) {
        this.addreason = addreason;
    }

    public String getPsdata() {
        return F_Constants.chageNull(psdata);
    }

    public void setPsdata(String psdata) {
        this.psdata = psdata;
    }

    public String getServentfinacode() {
        return F_Constants.chageNull(serventfinacode);
    }

    public void setServentfinacode(String serventfinacode) {
        this.serventfinacode = serventfinacode;
    }

    public String getJareaselect() {
        return F_Constants.chageNull(jareaselect);
    }

    public void setJareaselect(String jareaselect) {
        this.jareaselect = jareaselect;
    }

    public String getYareaselect() {
        return F_Constants.chageNull(yareaselect);
    }

    public void setYareaselect(String yareaselect) {
        this.yareaselect = yareaselect;
    }
}
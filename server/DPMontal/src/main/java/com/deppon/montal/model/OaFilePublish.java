package com.deppon.montal.model;

import java.math.BigDecimal;
import java.util.Date;

import com.deppon.montal.conf.F_Constants;

/**
 * @yin 文件发布申请实体
 *
 */
public class OaFilePublish {
    private BigDecimal processinstid;

    private BigDecimal empid;

    private String name;

    private String applytype;

    private String filetype;

    private String filecode;

    private String filetittle;

    private String fileabstract;

    private Date effectdate;

    private Date expireddate;

    private String appointedtype;

    private String division;

    private String whyapply;

    private String nextapproal;

    private String effectstate;

    private BigDecimal countpage;

    private String respondepart;

    private String responpeople;

    private String scope;

    private Date agreedate;

    public BigDecimal getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(BigDecimal processinstid) {
        this.processinstid = processinstid;
    }

    public BigDecimal getEmpid() {
        return empid;
    }

    public void setEmpid(BigDecimal empid) {
        this.empid = empid;
    }

    public String getName() {
        return F_Constants.chageNull(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApplytype() {
        return F_Constants.chageNull(applytype);
    }

    public void setApplytype(String applytype) {
        this.applytype = applytype;
    }

    public String getFiletype() {
        return F_Constants.chageNull(filetype);
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public String getFilecode() {
        return F_Constants.chageNull(filecode);
    }

    public void setFilecode(String filecode) {
        this.filecode = filecode;
    }

    public String getFiletittle() {
        return F_Constants.chageNull(filetittle);
    }

    public void setFiletittle(String filetittle) {
        this.filetittle = filetittle;
    }

    public String getFileabstract() {
        return F_Constants.chageNull(fileabstract);
    }

    public void setFileabstract(String fileabstract) {
        this.fileabstract = fileabstract;
    }

    public Date getEffectdate() {
        return effectdate;
    }

    public void setEffectdate(Date effectdate) {
        this.effectdate = effectdate;
    }

    public Date getExpireddate() {
        return expireddate;
    }

    public void setExpireddate(Date expireddate) {
        this.expireddate = expireddate;
    }

    public String getAppointedtype() {
        return F_Constants.chageNull(appointedtype);
    }

    public void setAppointedtype(String appointedtype) {
        this.appointedtype = appointedtype;
    }

    public String getDivision() {
        return F_Constants.chageNull(division);
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getWhyapply() {
        return F_Constants.chageNull(whyapply);
    }

    public void setWhyapply(String whyapply) {
        this.whyapply = whyapply;
    }

    public String getNextapproal() {
        return F_Constants.chageNull(nextapproal);
    }

    public void setNextapproal(String nextapproal) {
        this.nextapproal = nextapproal;
    }

    public String getEffectstate() {
        return F_Constants.chageNull(effectstate);
    }

    public void setEffectstate(String effectstate) {
        this.effectstate = effectstate;
    }

    public BigDecimal getCountpage() {
        return countpage;
    }

    public void setCountpage(BigDecimal countpage) {
        this.countpage = countpage;
    }

    public String getRespondepart() {
        return F_Constants.chageNull(respondepart);
    }

    public void setRespondepart(String respondepart) {
        this.respondepart = respondepart;
    }

    public String getResponpeople() {
        return F_Constants.chageNull(responpeople);
    }

    public void setResponpeople(String responpeople) {
        this.responpeople = responpeople;
    }

    public String getScope() {
        return F_Constants.chageNull(scope);
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Date getAgreedate() {
        return agreedate;
    }

    public void setAgreedate(Date agreedate) {
        this.agreedate = agreedate;
    }
}
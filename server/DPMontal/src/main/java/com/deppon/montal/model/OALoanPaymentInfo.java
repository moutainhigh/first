package com.deppon.montal.model;

import java.math.BigDecimal;


   /** 
   * @ClassName: OALoanPaymentInfo 
   * @Description:(借支申请实体类) 
   * @TableName：OA_LOAN_PAYMENT_INFO
   * @author 廖建雄 
   * @date 2013-7-15 下午2:58:28 
   * 
   */
public class OALoanPaymentInfo {
    private BigDecimal processinstid;

    private String applypersoncode;

    private String applypersonname;

    private String applydept;

    private String subsidiary;

    private String loantype;

    private String area;

    private String costtype;

    private String totalmoney;

    private String payee;

    private String depositbank;

    private String subbranchbank;

    private String province;

    private String city;

    private String account;

    private String finalremittance;

    private String invoicetitle;

    private String occurencydate;

    private String payuse;

    private String departmentaization;

    private String mobilephonebysms;

    private String applyreason;

    public BigDecimal getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(BigDecimal processinstid) {
        this.processinstid = processinstid;
    }

    public String getApplypersoncode() {
        return applypersoncode;
    }

    public void setApplypersoncode(String applypersoncode) {
        this.applypersoncode = applypersoncode;
    }

    public String getApplypersonname() {
        return applypersonname;
    }

    public void setApplypersonname(String applypersonname) {
        this.applypersonname = applypersonname;
    }

    public String getApplydept() {
        return applydept;
    }

    public void setApplydept(String applydept) {
        this.applydept = applydept;
    }

    public String getSubsidiary() {
        return subsidiary;
    }

    public void setSubsidiary(String subsidiary) {
        this.subsidiary = subsidiary;
    }

    public String getLoantype() {
        return loantype;
    }

    public void setLoantype(String loantype) {
        this.loantype = loantype;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCosttype() {
        return costtype;
    }

    public void setCosttype(String costtype) {
        this.costtype = costtype;
    }

    public String getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(String totalmoney) {
        this.totalmoney = totalmoney;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getDepositbank() {
        return depositbank;
    }

    public void setDepositbank(String depositbank) {
        this.depositbank = depositbank;
    }

    public String getSubbranchbank() {
        return subbranchbank;
    }

    public void setSubbranchbank(String subbranchbank) {
        this.subbranchbank = subbranchbank;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getFinalremittance() {
        return finalremittance;
    }

    public void setFinalremittance(String finalremittance) {
        this.finalremittance = finalremittance;
    }

    public String getInvoicetitle() {
        return invoicetitle;
    }

    public void setInvoicetitle(String invoicetitle) {
        this.invoicetitle = invoicetitle;
    }

    public String getOccurencydate() {
        return occurencydate;
    }

    public void setOccurencydate(String occurencydate) {
        this.occurencydate = occurencydate;
    }

    public String getPayuse() {
        return payuse;
    }

    public void setPayuse(String payuse) {
        this.payuse = payuse;
    }

    public String getDepartmentaization() {
        return departmentaization;
    }

    public void setDepartmentaization(String departmentaization) {
        this.departmentaization = departmentaization;
    }

    public String getMobilephonebysms() {
        return mobilephonebysms;
    }

    public void setMobilephonebysms(String mobilephonebysms) {
        this.mobilephonebysms = mobilephonebysms;
    }

    public String getApplyreason() {
        return applyreason;
    }

    public void setApplyreason(String applyreason) {
        this.applyreason = applyreason;
    }
}
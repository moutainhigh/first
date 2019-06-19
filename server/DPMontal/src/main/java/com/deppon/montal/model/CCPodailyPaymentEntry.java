package com.deppon.montal.model;

import java.math.BigDecimal;

import com.deppon.montal.conf.F_Constants;


   /** 
   * @ClassName: CCPodailyPaymentEntry 
   * @Description:(日常付款业务实体类)
   * @TableName:CC_PODAILYPAYMENTENTRY
   * @author 廖建雄 
   * @date 2013-5-14 上午9:10:09 
   * 
   */
public class CCPodailyPaymentEntry {
    private String detailid;

    private BigDecimal processinstid;

    private String expensetype;

    private String discription;

    private String bizdate;

    private String amount;

    private String amountapproved;

    private String costdept;

    private String costcompany;

    private String remark;

    private String amountused;

    private String amountbalance;

    private String entryid;

    public String getDetailid() {
        return detailid;
    }

    public void setDetailid(String detailid) {
        this.detailid = detailid;
    }

    public BigDecimal getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(BigDecimal processinstid) {
        this.processinstid = processinstid;
    }

    public String getExpensetype() {
        return expensetype;
    }

    public void setExpensetype(String expensetype) {
        this.expensetype = expensetype;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getBizdate() {
        return bizdate;
    }

    public void setBizdate(String bizdate) {
        this.bizdate = bizdate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmountapproved() {
        return amountapproved;
    }

    public void setAmountapproved(String amountapproved) {
        this.amountapproved = amountapproved;
    }

    public String getCostdept() {
        return costdept;
    }

    public void setCostdept(String costdept) {
        this.costdept = costdept;
    }

    public String getCostcompany() {
        return costcompany;
    }

    public void setCostcompany(String costcompany) {
        this.costcompany = costcompany;
    }

    public String getRemark() {
        return F_Constants.chageNull(remark);
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAmountused() {
        return amountused;
    }

    public void setAmountused(String amountused) {
        this.amountused = amountused;
    }

    public String getAmountbalance() {
        return amountbalance;
    }

    public void setAmountbalance(String amountbalance) {
        this.amountbalance = amountbalance;
    }

    public String getEntryid() {
        return entryid;
    }

    public void setEntryid(String entryid) {
        this.entryid = entryid;
    }
}
package com.deppon.montal.model;

import java.math.BigDecimal;
import java.util.Date;


   /** 
   * @ClassName: TWFSexpensehkSub 
   * @Description:(付款申请（香港）/费用报销申请  详细信息业务类)
   * @TableName:T_WFS_EXPENSEHK_SUB
   * @author yin 
   * @date 2013-7-15 下午2:47:33 
   * 
   */
public class TWFSexpensehkSub {
	
    private BigDecimal id;

    private BigDecimal processinstid;

    private String expensetype;

    private String feedesc;

    private Date bizdate;

    private String amount;

    private String amountapproved;

    private String costdept;

    private String remark;

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

    public String getExpensetype() {
        return expensetype;
    }

    public void setExpensetype(String expensetype) {
        this.expensetype = expensetype;
    }

    public String getFeedesc() {
        return feedesc;
    }

    public void setFeedesc(String feedesc) {
        this.feedesc = feedesc;
    }

    public Date getBizdate() {
        return bizdate;
    }

    public void setBizdate(Date bizdate) {
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
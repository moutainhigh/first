package com.deppon.montal.model;

import java.math.BigDecimal;


   /** 
   * @ClassName: CCwelfareexpenseEntry 
   * @Description:TODO(福利费用业务实体类)
   * @TableName: CC_WELFAREEXPENSEENTRY
   * @author 廖建雄 
   * @date 2013-4-27 上午9:48:06 
   * 
   */
public class CCwelfareexpenseEntry {
    private String id;

    private BigDecimal processinstid;

    private String expensetype;

    private String discription;

    private String bizdate;

    private String amount;

    private String amountapproved;

    private String costdept;

    private String costcompany;

    private String remark;

    private String entryid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getEntryid() {
        return entryid;
    }

    public void setEntryid(String entryid) {
        this.entryid = entryid;
    }
}
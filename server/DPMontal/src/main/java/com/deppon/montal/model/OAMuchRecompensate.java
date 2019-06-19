package com.deppon.montal.model;

import java.math.BigDecimal;


   /** 
   * @ClassName: OAMuchRecompensate 
   * @Description:(多赔实体类) 
   * @TableName: OA_MUCHRECOMPENSATE
   * @author 廖建雄 
   * @date 2013-6-5 下午4:08:51 
   * 
   */
public class OAMuchRecompensate {
    private BigDecimal processinstid;

    private String applypersoncode;

    private String applypersonname;

    private String transportorerrorcode;

    private String recompensiesmoney;

    private String amountintotal;

    private String hasrepaydebt;

    private String deptaccountant;

    private String enterprisedept;

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

    public String getTransportorerrorcode() {
        return transportorerrorcode;
    }

    public void setTransportorerrorcode(String transportorerrorcode) {
        this.transportorerrorcode = transportorerrorcode;
    }

    public String getRecompensiesmoney() {
        return recompensiesmoney;
    }

    public void setRecompensiesmoney(String recompensiesmoney) {
        this.recompensiesmoney = recompensiesmoney;
    }

    public String getAmountintotal() {
        return amountintotal;
    }

    public void setAmountintotal(String amountintotal) {
        this.amountintotal = amountintotal;
    }

    public String getHasrepaydebt() {
        return hasrepaydebt;
    }

    public void setHasrepaydebt(String hasrepaydebt) {
        this.hasrepaydebt = hasrepaydebt;
    }

    public String getDeptaccountant() {
        return deptaccountant;
    }

    public void setDeptaccountant(String deptaccountant) {
        this.deptaccountant = deptaccountant;
    }

    public String getEnterprisedept() {
        return enterprisedept;
    }

    public void setEnterprisedept(String enterprisedept) {
        this.enterprisedept = enterprisedept;
    }

    public String getApplyreason() {
        return applyreason;
    }

    public void setApplyreason(String applyreason) {
        this.applyreason = applyreason;
    }
}
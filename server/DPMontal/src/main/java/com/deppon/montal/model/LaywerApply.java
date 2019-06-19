package com.deppon.montal.model;

import java.math.BigDecimal;


   /** 
   * @ClassName: LaywerApply 
   * @Description:(诉讼案件立案/外请律师实体类) 
   * @TableName:LAYWERAPPLY
   * @author 廖建雄 
   * @date 2013-6-20 上午9:16:43 
   * 
   */
public class LaywerApply {
    private BigDecimal processinstid;

    private BigDecimal empid;

    private String applyname;

    private String category;

    private String name;

    private String org;

    private BigDecimal money;

    private BigDecimal lawsuitmoney;

    private String basicinfo;

    private String applyinfo;

    private String childcompany;

    private String reason;

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

    public String getApplyname() {
        return applyname;
    }

    public void setApplyname(String applyname) {
        this.applyname = applyname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getLawsuitmoney() {
        return lawsuitmoney;
    }

    public void setLawsuitmoney(BigDecimal lawsuitmoney) {
        this.lawsuitmoney = lawsuitmoney;
    }

    public String getBasicinfo() {
        return basicinfo;
    }

    public void setBasicinfo(String basicinfo) {
        this.basicinfo = basicinfo;
    }

    public String getApplyinfo() {
        return applyinfo;
    }

    public void setApplyinfo(String applyinfo) {
        this.applyinfo = applyinfo;
    }

    public String getChildcompany() {
        return childcompany;
    }

    public void setChildcompany(String childcompany) {
        this.childcompany = childcompany;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
package com.deppon.montal.model;

import java.math.BigDecimal;


   /** 
   * @ClassName: OAZonePrice 
   * @Description:(调价申请实体类) 
   * @TableName:OA_ZONEPRICE
   * @author 廖建雄 
   * @date 2013-7-15 下午2:49:47 
   * 
   */
public class OAZonePrice {
    private BigDecimal processinstid;

    private BigDecimal empid;

    private String name;

    private String remark;

    private String regulatepricetype;

    private String regulatepricearea;

    private String isdeptmanager;

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
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRegulatepricetype() {
        return regulatepricetype;
    }

    public void setRegulatepricetype(String regulatepricetype) {
        this.regulatepricetype = regulatepricetype;
    }

    public String getRegulatepricearea() {
        return regulatepricearea;
    }

    public void setRegulatepricearea(String regulatepricearea) {
        this.regulatepricearea = regulatepricearea;
    }

    public String getIsdeptmanager() {
        return isdeptmanager;
    }

    public void setIsdeptmanager(String isdeptmanager) {
        this.isdeptmanager = isdeptmanager;
    }
}
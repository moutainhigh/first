package com.deppon.montal.model;

import java.math.BigDecimal;
import java.util.Date;


   /** 
   * @ClassName: OACarGoTransContract 
   * @Description:(整车货物运输合同实体类)
   * @TableName:oa_cargotranscontract 
   * @author 廖建雄 
   * @date 2013-8-20 下午2:04:28 
   * 
   */
public class OACarGoTransContract {
    private BigDecimal processinstid;

    private String name;

    private BigDecimal empid;

    private String area;

    private String subsidiary;

    private String reason;

    public BigDecimal getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(BigDecimal processinstid) {
        this.processinstid = processinstid;
    }

    public String getName() {
        return name;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSubsidiary() {
        return subsidiary;
    }

    public void setSubsidiary(String subsidiary) {
        this.subsidiary = subsidiary;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
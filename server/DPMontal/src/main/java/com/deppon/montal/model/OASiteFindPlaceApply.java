package com.deppon.montal.model;

import java.math.BigDecimal;

import com.deppon.montal.conf.F_Constants;


   /** 
   * @ClassName: OASiteFindPlaceApply 
   * @Description:(场地找点实体类) 
   * @TableName:OA_SITEFINDPLACEAPPLY
   * @author 廖建雄 
   * @date 2013-8-20 下午2:39:48 
   * 
   */
public class OASiteFindPlaceApply {
    private BigDecimal processinstid;

    private BigDecimal empid;

    private String name;

    private String area;

    private String siterequire;

    private String whyapply;

    private String department;

    private String empcode;

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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSiterequire() {
        return siterequire;
    }

    public void setSiterequire(String siterequire) {
        this.siterequire = siterequire;
    }

    public String getWhyapply() {
        return F_Constants.chageNull(whyapply);
    }

    public void setWhyapply(String whyapply) {
        this.whyapply = whyapply;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmpcode() {
        return empcode;
    }

    public void setEmpcode(String empcode) {
        this.empcode = empcode;
    }
}
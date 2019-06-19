package com.deppon.montal.model;

import java.math.BigDecimal;

import com.deppon.montal.conf.F_Constants;


   /** 
   * @ClassName: OASitedesign 
   * @Description:(场地设计实体类) 
   * @TableName:OA_SITEDESIGN
   * @author 廖建雄 
   * @date 2013-7-15 下午3:01:23 
   * 
   */
public class OASitedesign {
    private BigDecimal processinstid;

    private BigDecimal empid;

    private String name;

    private String remark;

    private String department;

    private String empcode;

    private String matterTeam;

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
        return F_Constants.chageNull(remark);
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getMatterTeam() {
        return F_Constants.chageNull(matterTeam);
    }

    public void setMatterTeam(String matterTeam) {
        this.matterTeam = matterTeam;
    }
}
package com.deppon.montal.model;

import java.math.BigDecimal;


   /** 
   * @ClassName: OAAssessApply 
   * @Description:(考核方案实体类)
   * @TableName：OA_ASSESSAPPLY
   * @author 廖建雄 
   * @date 2013-6-20 下午2:47:19 
   * 
   */
public class OAAssessApply {
    private BigDecimal processinstid;

    private String name;

    private BigDecimal empid;

    private String dept;

    private String deptcode;

    private String year;

    private String season;

    private String reason;

    private String quality;

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

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
}
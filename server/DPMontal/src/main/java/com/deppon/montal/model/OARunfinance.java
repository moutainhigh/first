package com.deppon.montal.model;

import java.math.BigDecimal;

import com.deppon.montal.conf.F_Constants;


   /** 
   * @ClassName: OARunfinance 
   * @Description:(资金运作实体类)
   * @TableName：OA_RUNFINANCE
   * @author 廖建雄 
   * @date 2013-6-20 下午2:53:52 
   * 
   */
public class OARunfinance {
    private BigDecimal processinstid;

    private String applyreason;

    private String empname;

    private String userid;

    private String deptname;

    private String jobname;

    public BigDecimal getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(BigDecimal processinstid) {
        this.processinstid = processinstid;
    }

    public String getApplyreason() {
        return F_Constants.chageNull(applyreason);
    }

    public void setApplyreason(String applyreason) {
        this.applyreason = applyreason;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }
}
package com.deppon.montal.model;

import java.math.BigDecimal;


   /** 
   * @ClassName: OAOvertimeApply 
   * @Description:(加班/加班工资申请实体类)
   * @TableName: OA_OVERTIMEAPPLY
   * @author 廖建雄 
   * @date 2013-6-20 下午2:50:51 
   * 
   */
public class OAOvertimeApply {
    private BigDecimal processinstid;

    private String name;

    private BigDecimal empid;

    private String userid;

    private String applytype;

    private String personneldept;

    private String otapplyno;

    private BigDecimal workdays;

    private BigDecimal holidays;

    private String nbegindate;

    private String nenddate;

    private BigDecimal nightdays;

    private String nwitness;

    private String ottype;

    private String begindate;

    private String enddate;

    private String reason;

    private String dept;

    private String position;

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

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getApplytype() {
        return applytype;
    }

    public void setApplytype(String applytype) {
        this.applytype = applytype;
    }

    public String getPersonneldept() {
        return personneldept;
    }

    public void setPersonneldept(String personneldept) {
        this.personneldept = personneldept;
    }

    public String getOtapplyno() {
        return otapplyno;
    }

    public void setOtapplyno(String otapplyno) {
        this.otapplyno = otapplyno;
    }

    public BigDecimal getWorkdays() {
        return workdays;
    }

    public void setWorkdays(BigDecimal workdays) {
        this.workdays = workdays;
    }

    public BigDecimal getHolidays() {
        return holidays;
    }

    public void setHolidays(BigDecimal holidays) {
        this.holidays = holidays;
    }

    public String getNbegindate() {
        return nbegindate;
    }

    public void setNbegindate(String nbegindate) {
        this.nbegindate = nbegindate;
    }

    public String getNenddate() {
        return nenddate;
    }

    public void setNenddate(String nenddate) {
        this.nenddate = nenddate;
    }

    public BigDecimal getNightdays() {
        return nightdays;
    }

    public void setNightdays(BigDecimal nightdays) {
        this.nightdays = nightdays;
    }

    public String getNwitness() {
        return nwitness;
    }

    public void setNwitness(String nwitness) {
        this.nwitness = nwitness;
    }

    public String getOttype() {
        return ottype;
    }

    public void setOttype(String ottype) {
        this.ottype = ottype;
    }

    public String getBegindate() {
        return begindate;
    }

    public void setBegindate(String begindate) {
        this.begindate = begindate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
package com.deppon.montal.model;

import java.math.BigDecimal;
import java.util.Date;

import com.deppon.montal.conf.F_Constants;

public class OaLeaveApply {
    private BigDecimal processinstid; //流程ID

    private BigDecimal empid; //员工编号

    private String applyname; //申请人姓名

    private String area; //所属区域

    private String applycategory; //申请类别

    private Date datestart; //请假/调休开始日期

    private Date datefinsh; //请假/调休结束日期

    private BigDecimal days; //请假/调休天数

    private String workto; //工作交接人

    private String reason; //申请事由

    private Date employeetime; //入职日期

    private String leavecategory; //请假类别

    private String workflowno; //加班工作流号

    private String overtimedays; //加班天数
    
    private String detailcategory; //是否有薪(1有薪，0无薪)
    private String xiaojia; //销假类别
    private Date xiaojiaemployeetime; //入职日期（销假）
    private String orgname; //所属部门
    private String userid; //员工工号
    private String xiaojiaprocessinstid; //销假工作流号
    private Date datestartxiaojia; //请假/调休开始日期（销假）
    private Date datefinshxiaojia; //请假/调休结束日期（销假）
    private String positionlevel; //直接上级级别
    

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
        return F_Constants.chageNull(applyname);
    }

    public void setApplyname(String applyname) {
        this.applyname = applyname;
    }

    public String getArea() {
        return F_Constants.chageNull(area);
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getApplycategory() {
        return F_Constants.chageNull(applycategory);
    }

    public void setApplycategory(String applycategory) {
        this.applycategory = applycategory;
    }

    public Date getDatestart() {
        return datestart;
    }

    public void setDatestart(Date datestart) {
        this.datestart = datestart;
    }

    public Date getDatefinsh() {
        return datefinsh;
    }

    public void setDatefinsh(Date datefinsh) {
        this.datefinsh = datefinsh;
    }

    public BigDecimal getDays() {
        return days;
    }

    public void setDays(BigDecimal days) {
        this.days = days;
    }

    public String getWorkto() {
        return F_Constants.chageNull(workto);
    }

    public void setWorkto(String workto) {
        this.workto = workto;
    }

    public String getReason() {
        return F_Constants.chageNull(reason);
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getEmployeetime() {
        return employeetime;
    }

    public void setEmployeetime(Date employeetime) {
        this.employeetime = employeetime;
    }

    public String getLeavecategory() {
        return F_Constants.chageNull(leavecategory);
    }

    public void setLeavecategory(String leavecategory) {
        this.leavecategory = leavecategory;
    }

    public String getWorkflowno() {
        return F_Constants.chageNull(workflowno);
    }

    public void setWorkflowno(String workflowno) {
        this.workflowno = workflowno;
    }

    public String getOvertimedays() {
        return F_Constants.chageNull(overtimedays);
    }

    public void setOvertimedays(String overtimedays) {
        this.overtimedays = overtimedays;
    }

    public String getDetailcategory() {
    
        return F_Constants.chageNull(detailcategory);
    }

    public void setDetailcategory(String detailcategory) {
    
        this.detailcategory = detailcategory;
    }

    public String getXiaojia() {
    
        return F_Constants.chageNull(xiaojia);
    }

    public void setXiaojia(String xiaojia) {
    
        this.xiaojia = xiaojia;
    }

    public Date getXiaojiaemployeetime() {
    
        return xiaojiaemployeetime;
    }

    public void setXiaojiaemployeetime(Date xiaojiaemployeetime) {
    
        this.xiaojiaemployeetime = xiaojiaemployeetime;
    }

    public String getOrgname() {
    
        return F_Constants.chageNull(orgname);
    }

    public void setOrgname(String orgname) {
    
        this.orgname = orgname;
    }

    public String getUserid() {
    
        return F_Constants.chageNull(userid);
    }

    public void setUserid(String userid) {
    
        this.userid = userid;
    }

    public String getXiaojiaprocessinstid() {
    
        return F_Constants.chageNull(xiaojiaprocessinstid);
    }

    public void setXiaojiaprocessinstid(String xiaojiaprocessinstid) {
    
        this.xiaojiaprocessinstid = xiaojiaprocessinstid;
    }

    public Date getDatestartxiaojia() {
    
        return datestartxiaojia;
    }

    public void setDatestartxiaojia(Date datestartxiaojia) {
    
        this.datestartxiaojia = datestartxiaojia;
    }

    public Date getDatefinshxiaojia() {
    
        return datefinshxiaojia;
    }

    public void setDatefinshxiaojia(Date datefinshxiaojia) {
    
        this.datefinshxiaojia = datefinshxiaojia;
    }

    public String getPositionlevel() {
    
        return F_Constants.chageNull(positionlevel);
    }

    public void setPositionlevel(String positionlevel) {
    
        this.positionlevel = positionlevel;
    }
    
    
}
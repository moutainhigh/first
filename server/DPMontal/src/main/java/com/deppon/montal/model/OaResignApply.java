package com.deppon.montal.model;

import java.math.BigDecimal;

import com.deppon.montal.conf.F_Constants;

public class OaResignApply {
    private BigDecimal processinstid; //主键

    private String empname; //申请辞职人员

    private BigDecimal empid; //申请辞职人员empid

    private String empuserid;//申请辞职人员工号

    private String resigntype;//辞职类型

    private String errorno;//差错编号

    private String joindate;//入职日期

    private String abc;//辞职人员近6个月ABC

    private String postsort;//辞职人员现任岗位类别

    private String isreserve;//辞职人是否参加储干

    private String reservedate;//第几届储干

    private String reserveno;//储干名次

    private String isgood;//辞职人员是否评优

    private String workyears;//辞职人员工作年限

    private String resignreason;//辞职主要原因

    private String personneldept;//辞职人员所在人事部

    private String applyreason;//申请事由
    private String wagesettlement;//工资结算方式
    private String businessproce;//业务类型
    private String leavebusinessproce;//离职业务类型
    private String leavedate;//计划离职日期
    private String cano;//银行卡号
    private String cabankname;//开户行名称
    private String caholder;//开户人姓名
    private String caprovince;//开户行省份
    private String cacity;//开户行城市
    private String tel;//联系电话
    private String position;//申请人职位
    private String appdept;//所属部门
    

    public BigDecimal getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(BigDecimal processinstid) {
        this.processinstid = processinstid;
    }

    public String getEmpname() {
        return F_Constants.chageNull(empname);
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public BigDecimal getEmpid() {
        return empid;
    }

    public void setEmpid(BigDecimal empid) {
        this.empid = empid;
    }

    public String getEmpuserid() {
        return F_Constants.chageNull(empuserid);
    }

    public void setEmpuserid(String empuserid) {
        this.empuserid = empuserid;
    }

    public String getResigntype() {
        return F_Constants.chageNull(resigntype);
    }

    public void setResigntype(String resigntype) {
        this.resigntype = resigntype;
    }

    public String getErrorno() {
        return F_Constants.chageNull(errorno);
    }

    public void setErrorno(String errorno) {
        this.errorno = errorno;
    }

    public String getJoindate() {
        return F_Constants.chageNull(joindate);
    }

    public void setJoindate(String joindate) {
        this.joindate = joindate;
    }

    public String getAbc() {
        return F_Constants.chageNull(abc);
    }

    public void setAbc(String abc) {
        this.abc = abc;
    }

    public String getPostsort() {
        return F_Constants.chageNull(postsort);
    }

    public void setPostsort(String postsort) {
        this.postsort = postsort;
    }

    public String getIsreserve() {
        return F_Constants.chageNull(isreserve);
    }

    public void setIsreserve(String isreserve) {
        this.isreserve = isreserve;
    }

    public String getReservedate() {
        return F_Constants.chageNull(reservedate);
    }

    public void setReservedate(String reservedate) {
        this.reservedate = reservedate;
    }

    public String getReserveno() {
        return F_Constants.chageNull(reserveno);
    }

    public void setReserveno(String reserveno) {
        this.reserveno = reserveno;
    }

    public String getIsgood() {
        return F_Constants.chageNull(isgood);
    }

    public void setIsgood(String isgood) {
        this.isgood = isgood;
    }

    public String getWorkyears() {
        return F_Constants.chageNull(workyears);
    }

    public void setWorkyears(String workyears) {
        this.workyears = workyears;
    }

    public String getResignreason() {
        return F_Constants.chageNull(resignreason);
    }

    public void setResignreason(String resignreason) {
        this.resignreason = resignreason;
    }

    public String getPersonneldept() {
        return F_Constants.chageNull(personneldept);
    }

    public void setPersonneldept(String personneldept) {
        this.personneldept = personneldept;
    }

    public String getApplyreason() {
        return F_Constants.chageNull(applyreason);
    }

    public void setApplyreason(String applyreason) {
        this.applyreason = applyreason;
    }

    public String getWagesettlement() {
    
        return F_Constants.chageNull(wagesettlement);
    }

    public void setWagesettlement(String wagesettlement) {
    
        this.wagesettlement = wagesettlement;
    }

    public String getBusinessproce() {
    
        return F_Constants.chageNull(businessproce);
    }

    public void setBusinessproce(String businessproce) {
    
        this.businessproce = businessproce;
    }

    public String getLeavebusinessproce() {
    
        return F_Constants.chageNull(leavebusinessproce);
    }

    public void setLeavebusinessproce(String leavebusinessproce) {
    
        this.leavebusinessproce = leavebusinessproce;
    }

    public String getLeavedate() {
    
        return F_Constants.chageNull(leavedate);
    }

    public void setLeavedate(String leavedate) {
    
        this.leavedate = leavedate;
    }

    public String getCano() {
    
        return F_Constants.chageNull(cano);
    }

    public void setCano(String cano) {
    
        this.cano = cano;
    }

    public String getCabankname() {
    
        return F_Constants.chageNull(cabankname);
    }

    public void setCabankname(String cabankname) {
    
        this.cabankname = cabankname;
    }

    public String getCaholder() {
    
        return F_Constants.chageNull(caholder);
    }

    public void setCaholder(String caholder) {
    
        this.caholder = caholder;
    }

    public String getCaprovince() {
    
        return F_Constants.chageNull(caprovince);
    }

    public void setCaprovince(String caprovince) {
    
        this.caprovince = caprovince;
    }

    public String getCacity() {
    
        return F_Constants.chageNull(cacity);
    }

    public void setCacity(String cacity) {
    
        this.cacity = cacity;
    }

    public String getTel() {
    
        return F_Constants.chageNull(tel);
    }

    public void setTel(String tel) {
    
        this.tel = tel;
    }

    public String getPosition() {
    
        return F_Constants.chageNull(position);
    }

    public void setPosition(String position) {
    
        this.position = position;
    }

    public String getAppdept() {
    
        return F_Constants.chageNull(appdept);
    }

    public void setAppdept(String appdept) {
    
        this.appdept = appdept;
    }
    
}
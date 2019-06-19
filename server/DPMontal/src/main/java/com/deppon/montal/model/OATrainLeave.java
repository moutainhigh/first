package com.deppon.montal.model;

import java.math.BigDecimal;
import java.util.Date;

import com.deppon.montal.conf.F_Constants;
/**
 * 
   * @ClassName: OATrainLeave 
   * @Description:(培训请假实体类) 
   * @author yinrongping 
   * @date 2013-8-1 上午9:26:25 
   *
 */
public class OATrainLeave {
    private BigDecimal processinstid;

    private BigDecimal empid;

    private String name;

    private String remark;

    private String area;

    private String trainname;

    private Date startdate;

    private Date enddate;

    private String username;

    private String userid;

    private BigDecimal leaveprocid;

    private String areacode;

    private String deptproperty;

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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTrainname() {
        return trainname;
    }

    public void setTrainname(String trainname) {
        this.trainname = trainname;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public BigDecimal getLeaveprocid() {
        return leaveprocid;
    }

    public void setLeaveprocid(BigDecimal leaveprocid) {
        this.leaveprocid = leaveprocid;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getDeptproperty() {
        return deptproperty;
    }

    public void setDeptproperty(String deptproperty) {
        this.deptproperty = deptproperty;
    }
}
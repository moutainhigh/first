package com.deppon.montal.model;

import java.math.BigDecimal;

import com.deppon.montal.conf.F_Constants;
/**
 * 
   * @ClassName: OATrainLeaveDetail 
   * @Description:(培训请假详情实体类) 
   * @author yinrongping 
   * @date 2013-8-1 上午9:26:45 
   *
 */
public class OATrainLeaveDetail {
    private BigDecimal appid;

    private BigDecimal processinstid;

    private String empid;

    private String name;

    private String remark;

    private String username;

    private String userid;

    private String leaveprocid;

    public BigDecimal getAppid() {
        return appid;
    }

    public void setAppid(BigDecimal appid) {
        this.appid = appid;
    }

    public BigDecimal getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(BigDecimal processinstid) {
        this.processinstid = processinstid;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
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

    public String getUsername() {
        return F_Constants.chageNull(username);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserid() {
        return F_Constants.chageNull(userid);
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getLeaveprocid() {
        return F_Constants.chageNull(leaveprocid);
    }

    public void setLeaveprocid(String leaveprocid) {
        this.leaveprocid = leaveprocid;
    }
}
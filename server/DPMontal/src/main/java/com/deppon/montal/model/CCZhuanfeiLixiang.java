package com.deppon.montal.model;

import com.deppon.montal.conf.F_Constants;


   /** 
   * @ClassName: CCZhuanfeiLixiang 
   * @Description:(专项费用立项实体类) 
   * @TableName：CC_ZHUANFEILIXIANG
   * @author 廖建雄 
   * @date 2013-6-20 上午10:41:28 
   * 
   */
public class CCZhuanfeiLixiang {
    private String processinstid;

    private String subcompany;

    private String area;

    private String reason;

    private String userid;

    private String username;

    private String empid;

    private String applyid;

    private String applyname;

    private String type;

    public String getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(String processinstid) {
        this.processinstid = processinstid;
    }

    public String getSubcompany() {
        return subcompany;
    }

    public void setSubcompany(String subcompany) {
        this.subcompany = subcompany;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getReason() {
        return F_Constants.chageNull(reason);
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getApplyid() {
        return applyid;
    }

    public void setApplyid(String applyid) {
        this.applyid = applyid;
    }

    public String getApplyname() {
        return applyname;
    }

    public void setApplyname(String applyname) {
        this.applyname = applyname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
package com.deppon.montal.model;

import com.deppon.montal.conf.F_Constants;

public class OaLeaveDetail {
    private String processinstid;

    private String userid;

    private String month;

    private String days;

    private String name;

    private String leavecategory;

    private String category;

    private String xiaojiaprocessinstid;

    private String startdate;

    private String finishdate;

    private String detailcategory;

    public String getProcessinstid() {
        return F_Constants.chageNull(processinstid);
    }

    public void setProcessinstid(String processinstid) {
        this.processinstid = processinstid;
    }

    public String getUserid() {
        return F_Constants.chageNull(userid);
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getMonth() {
        return F_Constants.chageNull(month);
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDays() {
        return F_Constants.chageNull(days);
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getName() {
        return F_Constants.chageNull(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeavecategory() {
        return F_Constants.chageNull(leavecategory);
    }

    public void setLeavecategory(String leavecategory) {
        this.leavecategory = leavecategory;
    }

    public String getCategory() {
        return F_Constants.chageNull(category);
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getXiaojiaprocessinstid() {
        return F_Constants.chageNull(xiaojiaprocessinstid);
    }

    public void setXiaojiaprocessinstid(String xiaojiaprocessinstid) {
        this.xiaojiaprocessinstid = xiaojiaprocessinstid;
    }

    public String getStartdate() {
        return F_Constants.chageNull(startdate);
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getFinishdate() {
        return F_Constants.chageNull(finishdate);
    }

    public void setFinishdate(String finishdate) {
        this.finishdate = finishdate;
    }

    public String getDetailcategory() {
        return F_Constants.chageNull(detailcategory);
    }

    public void setDetailcategory(String detailcategory) {
        this.detailcategory = detailcategory;
    }
}
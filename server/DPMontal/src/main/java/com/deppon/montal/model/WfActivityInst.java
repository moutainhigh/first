package com.deppon.montal.model;

import java.math.BigDecimal;
import java.util.Date;

import com.deppon.montal.conf.F_Constants;

public class WfActivityInst {
    private BigDecimal activityinstid;

    private String activityinstname;

    private String activityinstdesc;

    private String activitytype;

    private BigDecimal currentstate;

    private BigDecimal priority;

    private Date createtime;

    private Date starttime;

    private Date endtime;

    private Date finaltime;

    private BigDecimal subprocessid;

    private String activitydefid;

    private BigDecimal processinstid;

    private String rollbackflag;

    private String extend1;

    private String extend2;

    private String extend3;

    private String extend4;

    private String extend5;

    private String extend6;

    private BigDecimal extend7;

    public BigDecimal getActivityinstid() {
        return activityinstid;
    }

    public void setActivityinstid(BigDecimal activityinstid) {
        this.activityinstid = activityinstid;
    }

    public String getActivityinstname() {
        return F_Constants.chageNull(activityinstname);
    }

    public void setActivityinstname(String activityinstname) {
        this.activityinstname = activityinstname;
    }

    public String getActivityinstdesc() {
        return F_Constants.chageNull(activityinstdesc);
    }

    public void setActivityinstdesc(String activityinstdesc) {
        this.activityinstdesc = activityinstdesc;
    }

    public String getActivitytype() {
        return F_Constants.chageNull(activitytype);
    }

    public void setActivitytype(String activitytype) {
        this.activitytype = activitytype;
    }

    public BigDecimal getCurrentstate() {
        return currentstate;
    }

    public void setCurrentstate(BigDecimal currentstate) {
        this.currentstate = currentstate;
    }

    public BigDecimal getPriority() {
        return priority;
    }

    public void setPriority(BigDecimal priority) {
        this.priority = priority;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getFinaltime() {
        return finaltime;
    }

    public void setFinaltime(Date finaltime) {
        this.finaltime = finaltime;
    }

    public BigDecimal getSubprocessid() {
        return subprocessid;
    }

    public void setSubprocessid(BigDecimal subprocessid) {
        this.subprocessid = subprocessid;
    }

    public String getActivitydefid() {
        return F_Constants.chageNull(activitydefid);
    }

    public void setActivitydefid(String activitydefid) {
        this.activitydefid = activitydefid;
    }

    public BigDecimal getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(BigDecimal processinstid) {
        this.processinstid = processinstid;
    }

    public String getRollbackflag() {
        return F_Constants.chageNull(rollbackflag);
    }

    public void setRollbackflag(String rollbackflag) {
        this.rollbackflag = rollbackflag;
    }

    public String getExtend1() {
        return F_Constants.chageNull(extend1);
    }

    public void setExtend1(String extend1) {
        this.extend1 = extend1;
    }

    public String getExtend2() {
        return F_Constants.chageNull(extend2);
    }

    public void setExtend2(String extend2) {
        this.extend2 = extend2;
    }

    public String getExtend3() {
        return F_Constants.chageNull(extend3);
    }

    public void setExtend3(String extend3) {
        this.extend3 = extend3;
    }

    public String getExtend4() {
        return F_Constants.chageNull(extend4);
    }

    public void setExtend4(String extend4) {
        this.extend4 = extend4;
    }

    public String getExtend5() {
        return F_Constants.chageNull(extend5);
    }

    public void setExtend5(String extend5) {
        this.extend5 = extend5;
    }

    public String getExtend6() {
        return F_Constants.chageNull(extend6);
    }

    public void setExtend6(String extend6) {
        this.extend6 = extend6;
    }

    public BigDecimal getExtend7() {
        return extend7;
    }

    public void setExtend7(BigDecimal extend7) {
        this.extend7 = extend7;
    }
}
package com.deppon.montal.model;

import java.math.BigDecimal;
import java.util.Date;

public class WfWorkItem {
    private BigDecimal workitemid;

    private String workitemname;

    private String workitemtype;

    private String workitemdesc;

    private BigDecimal currentstate;

    private String participant;

    private String partiname;

    private BigDecimal priority;

    private String istimeout;

    private BigDecimal limitnum;

    private String limitnumdesc;

    private Date createtime;

    private Date starttime;

    private Date endtime;

    private Date finaltime;

    private Date remindtime;

    private String actionurl;

    private BigDecimal processinstid;

    private BigDecimal activityinstid;

    private String stateslist;

    private BigDecimal timeoutnum;

    private String timeoutnumdesc;

    private String processinstname;

    private String activityinstname;

    private BigDecimal processdefid;

    private String processdefname;

    private String processchname;

    private String activitydefid;

    private String assistant;

    private String assistantname;

    private BigDecimal bizstate;

    private String allowagent;

    private BigDecimal rootprocinstid;

    private String actionmask;

    private String urltype;

    private String extend1;

    private String extend2;

    private String extend3;

    private String extend4;

    private String extend5;

    private String extend6;

    private BigDecimal extend7;
    private BigDecimal applyno;
    private String appler;
    private String apppost;
    private String department;
    private String subcom;
    private String fillman;
    private String appcate;
    private String condition;
    private String applerid;
    private String fillmanid;

    public BigDecimal getWorkitemid() {
        return workitemid;
    }

    public void setWorkitemid(BigDecimal workitemid) {
        this.workitemid = workitemid;
    }

    public String getWorkitemname() {
        return workitemname;
    }

    public void setWorkitemname(String workitemname) {
        this.workitemname = workitemname;
    }

    public String getWorkitemtype() {
        return workitemtype;
    }

    public void setWorkitemtype(String workitemtype) {
        this.workitemtype = workitemtype;
    }

    public String getWorkitemdesc() {
        return workitemdesc;
    }

    public void setWorkitemdesc(String workitemdesc) {
        this.workitemdesc = workitemdesc;
    }

    public BigDecimal getCurrentstate() {
        return currentstate;
    }

    public void setCurrentstate(BigDecimal currentstate) {
        this.currentstate = currentstate;
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public String getPartiname() {
        return partiname;
    }

    public void setPartiname(String partiname) {
        this.partiname = partiname;
    }

    public BigDecimal getPriority() {
        return priority;
    }

    public void setPriority(BigDecimal priority) {
        this.priority = priority;
    }

    public String getIstimeout() {
        return istimeout;
    }

    public void setIstimeout(String istimeout) {
        this.istimeout = istimeout;
    }

    public BigDecimal getLimitnum() {
        return limitnum;
    }

    public void setLimitnum(BigDecimal limitnum) {
        this.limitnum = limitnum;
    }

    public String getLimitnumdesc() {
        return limitnumdesc;
    }

    public void setLimitnumdesc(String limitnumdesc) {
        this.limitnumdesc = limitnumdesc;
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

    public Date getRemindtime() {
        return remindtime;
    }

    public void setRemindtime(Date remindtime) {
        this.remindtime = remindtime;
    }

    public String getActionurl() {
        return actionurl;
    }

    public void setActionurl(String actionurl) {
        this.actionurl = actionurl;
    }

    public BigDecimal getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(BigDecimal processinstid) {
        this.processinstid = processinstid;
    }

    public BigDecimal getActivityinstid() {
        return activityinstid;
    }

    public void setActivityinstid(BigDecimal activityinstid) {
        this.activityinstid = activityinstid;
    }

    public String getStateslist() {
        return stateslist;
    }

    public void setStateslist(String stateslist) {
        this.stateslist = stateslist;
    }

    public BigDecimal getTimeoutnum() {
        return timeoutnum;
    }

    public void setTimeoutnum(BigDecimal timeoutnum) {
        this.timeoutnum = timeoutnum;
    }

    public String getTimeoutnumdesc() {
        return timeoutnumdesc;
    }

    public void setTimeoutnumdesc(String timeoutnumdesc) {
        this.timeoutnumdesc = timeoutnumdesc;
    }

    public String getProcessinstname() {
        return processinstname;
    }

    public void setProcessinstname(String processinstname) {
        this.processinstname = processinstname;
    }

    public String getActivityinstname() {
        return activityinstname;
    }

    public void setActivityinstname(String activityinstname) {
        this.activityinstname = activityinstname;
    }

    public BigDecimal getProcessdefid() {
        return processdefid;
    }

    public void setProcessdefid(BigDecimal processdefid) {
        this.processdefid = processdefid;
    }

    public String getProcessdefname() {
        return processdefname;
    }

    public void setProcessdefname(String processdefname) {
        this.processdefname = processdefname;
    }

    public String getProcesschname() {
        return processchname;
    }

    public void setProcesschname(String processchname) {
        this.processchname = processchname;
    }

    public String getActivitydefid() {
        return activitydefid;
    }

    public void setActivitydefid(String activitydefid) {
        this.activitydefid = activitydefid;
    }

    public String getAssistant() {
        return assistant;
    }

    public void setAssistant(String assistant) {
        this.assistant = assistant;
    }

    public String getAssistantname() {
        return assistantname;
    }

    public void setAssistantname(String assistantname) {
        this.assistantname = assistantname;
    }

    public BigDecimal getBizstate() {
        return bizstate;
    }

    public void setBizstate(BigDecimal bizstate) {
        this.bizstate = bizstate;
    }

    public String getAllowagent() {
        return allowagent;
    }

    public void setAllowagent(String allowagent) {
        this.allowagent = allowagent;
    }

    public BigDecimal getRootprocinstid() {
        return rootprocinstid;
    }

    public void setRootprocinstid(BigDecimal rootprocinstid) {
        this.rootprocinstid = rootprocinstid;
    }

    public String getActionmask() {
        return actionmask;
    }

    public void setActionmask(String actionmask) {
        this.actionmask = actionmask;
    }

    public String getUrltype() {
        return urltype;
    }

    public void setUrltype(String urltype) {
        this.urltype = urltype;
    }

    public String getExtend1() {
        return extend1;
    }

    public void setExtend1(String extend1) {
        this.extend1 = extend1;
    }

    public String getExtend2() {
        return extend2;
    }

    public void setExtend2(String extend2) {
        this.extend2 = extend2;
    }

    public String getExtend3() {
        return extend3;
    }

    public void setExtend3(String extend3) {
        this.extend3 = extend3;
    }

    public String getExtend4() {
        return extend4;
    }

    public void setExtend4(String extend4) {
        this.extend4 = extend4;
    }

    public String getExtend5() {
        return extend5;
    }

    public void setExtend5(String extend5) {
        this.extend5 = extend5;
    }

    public String getExtend6() {
        return extend6;
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

    public BigDecimal getApplyno() {
    
        return applyno;
    }

    public void setApplyno(BigDecimal applyno) {
    
        this.applyno = applyno;
    }

    public String getAppler() {
    
        return appler;
    }

    public void setAppler(String appler) {
    
        this.appler = appler;
    }

    public String getApppost() {
    
        return apppost;
    }

    public void setApppost(String apppost) {
    
        this.apppost = apppost;
    }

    public String getDepartment() {
    
        return department;
    }

    public void setDepartment(String department) {
    
        this.department = department;
    }

    public String getSubcom() {
    
        return subcom;
    }

    public void setSubcom(String subcom) {
    
        this.subcom = subcom;
    }

    public String getFillman() {
    
        return fillman;
    }

    public void setFillman(String fillman) {
    
        this.fillman = fillman;
    }

    public String getAppcate() {
    
        return appcate;
    }

    public void setAppcate(String appcate) {
    
        this.appcate = appcate;
    }

    public String getCondition() {
    
        return condition;
    }

    public void setCondition(String condition) {
    
        this.condition = condition;
    }

    public String getApplerid() {
    
        return applerid;
    }

    public void setApplerid(String applerid) {
    
        this.applerid = applerid;
    }

    public String getFillmanid() {
    
        return fillmanid;
    }

    public void setFillmanid(String fillmanid) {
    
        this.fillmanid = fillmanid;
    }
    
}
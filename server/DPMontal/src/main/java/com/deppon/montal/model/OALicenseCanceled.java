package com.deppon.montal.model;

import java.util.Date;


   /** 
   * @ClassName: OALicenseCanceled 
   * @Description:(分公司证照注销实体类)
   * @TableName:T_WFS_ACMS_SYNDATA
   * @author 廖建雄 
   * @date 2013-8-20 下午2:21:31 
   * 
   */
public class OALicenseCanceled {
    private String workflow;

    private Short transtype;

    private String handleUser;

    private String appuser;

    private String trademanager;

    private String tradename;

    private String belongcomp;

    private String division;

    private String regions;

    private String belongtrade;

    private String compcode;

    private String deptcode;

    private String changetype;

    private String compname;

    private String filltype;

    private String comptype;

    private Date appdate;

    private String changebegin;

    private String changeend;

    public String getWorkflow() {
        return workflow;
    }

    public void setWorkflow(String workflow) {
        this.workflow = workflow;
    }

    public Short getTranstype() {
        return transtype;
    }

    public void setTranstype(Short transtype) {
        this.transtype = transtype;
    }

    public String getHandleUser() {
        return handleUser;
    }

    public void setHandleUser(String handleUser) {
        this.handleUser = handleUser;
    }

    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }

    public String getTrademanager() {
        return trademanager;
    }

    public void setTrademanager(String trademanager) {
        this.trademanager = trademanager;
    }

    public String getTradename() {
        return tradename;
    }

    public void setTradename(String tradename) {
        this.tradename = tradename;
    }

    public String getBelongcomp() {
        return belongcomp;
    }

    public void setBelongcomp(String belongcomp) {
        this.belongcomp = belongcomp;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getRegions() {
        return regions;
    }

    public void setRegions(String regions) {
        this.regions = regions;
    }

    public String getBelongtrade() {
        return belongtrade;
    }

    public void setBelongtrade(String belongtrade) {
        this.belongtrade = belongtrade;
    }

    public String getCompcode() {
        return compcode;
    }

    public void setCompcode(String compcode) {
        this.compcode = compcode;
    }

    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode;
    }

    public String getChangetype() {
        return changetype;
    }

    public void setChangetype(String changetype) {
        this.changetype = changetype;
    }

    public String getCompname() {
        return compname;
    }

    public void setCompname(String compname) {
        this.compname = compname;
    }

    public String getFilltype() {
        return filltype;
    }

    public void setFilltype(String filltype) {
        this.filltype = filltype;
    }

    public String getComptype() {
        return comptype;
    }

    public void setComptype(String comptype) {
        this.comptype = comptype;
    }

    public Date getAppdate() {
        return appdate;
    }

    public void setAppdate(Date appdate) {
        this.appdate = appdate;
    }

    public String getChangebegin() {
        return changebegin;
    }

    public void setChangebegin(String changebegin) {
        this.changebegin = changebegin;
    }

    public String getChangeend() {
        return changeend;
    }

    public void setChangeend(String changeend) {
        this.changeend = changeend;
    }
}
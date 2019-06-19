package com.deppon.montal.model;

import java.math.BigDecimal;
import java.util.Date;

import com.deppon.montal.conf.F_Constants;


   /** 
   * @ClassName: OAMarketingActivities 
   * @Description:(营销活动申请实体类) 
   * @TableName:OA_MARKETINGACTIVITIESAPPLY
   * @author 廖建雄 
   * @date 2013-7-15 下午2:40:00 
   * 
   */
public class OAMarketingActivities {
    private BigDecimal processinstid;

    private String applyer;

    private String userid;

    private String subordinatedivision;

    private BigDecimal usedepartmentnumber;

    private BigDecimal applynumber;

    private String accordingtocrowd;

    private String dockingpeople;

    private String telphone;

    private String designtype;

    private String marketingsubordinatetype;

    private String isredo;

    private String propagandalinetype;

    private String propagandabustype;

    private String propagandaindustrytype;

    private String propagandaairtype;

    private String fromcity;

    private String tocity;

    private String deliverytime;

    private Date activitystarttime;

    private Date activityendtime;

    private String propagandatheme;

    private String firsttarget;

    private String secondtarget;

    private String thirdtarget;

    private String regionin;

    private String conductscommunity;

    private String reason;
    private String markingtype;
    private String currentnode;

    public BigDecimal getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(BigDecimal processinstid) {
        this.processinstid = processinstid;
    }

    public String getApplyer() {
        return applyer;
    }

    public void setApplyer(String applyer) {
        this.applyer = applyer;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getSubordinatedivision() {
        return subordinatedivision;
    }

    public void setSubordinatedivision(String subordinatedivision) {
        this.subordinatedivision = subordinatedivision;
    }

    public BigDecimal getUsedepartmentnumber() {
        return usedepartmentnumber;
    }

    public void setUsedepartmentnumber(BigDecimal usedepartmentnumber) {
        this.usedepartmentnumber = usedepartmentnumber;
    }

    public BigDecimal getApplynumber() {
        return applynumber;
    }

    public void setApplynumber(BigDecimal applynumber) {
        this.applynumber = applynumber;
    }

    public String getAccordingtocrowd() {
        return accordingtocrowd;
    }

    public void setAccordingtocrowd(String accordingtocrowd) {
        this.accordingtocrowd = accordingtocrowd;
    }

    public String getDockingpeople() {
        return dockingpeople;
    }

    public void setDockingpeople(String dockingpeople) {
        this.dockingpeople = dockingpeople;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getDesigntype() {
        return designtype;
    }

    public void setDesigntype(String designtype) {
        this.designtype = designtype;
    }

    public String getMarketingsubordinatetype() {
        return marketingsubordinatetype;
    }

    public void setMarketingsubordinatetype(String marketingsubordinatetype) {
        this.marketingsubordinatetype = marketingsubordinatetype;
    }

    public String getIsredo() {
        return isredo;
    }

    public void setIsredo(String isredo) {
        this.isredo = isredo;
    }

    public String getPropagandalinetype() {
        return propagandalinetype;
    }

    public void setPropagandalinetype(String propagandalinetype) {
        this.propagandalinetype = propagandalinetype;
    }

    public String getPropagandabustype() {
        return propagandabustype;
    }

    public void setPropagandabustype(String propagandabustype) {
        this.propagandabustype = propagandabustype;
    }

    public String getPropagandaindustrytype() {
        return propagandaindustrytype;
    }

    public void setPropagandaindustrytype(String propagandaindustrytype) {
        this.propagandaindustrytype = propagandaindustrytype;
    }

    public String getPropagandaairtype() {
        return propagandaairtype;
    }

    public void setPropagandaairtype(String propagandaairtype) {
        this.propagandaairtype = propagandaairtype;
    }

    public String getFromcity() {
        return fromcity;
    }

    public void setFromcity(String fromcity) {
        this.fromcity = fromcity;
    }

    public String getTocity() {
        return tocity;
    }

    public void setTocity(String tocity) {
        this.tocity = tocity;
    }

    public String getDeliverytime() {
        return deliverytime;
    }

    public void setDeliverytime(String deliverytime) {
        this.deliverytime = deliverytime;
    }

    public String getActivitystarttime() {
        return F_Constants.getDateyyyyMMdd(activitystarttime);
    }

    public void setActivitystarttime(Date activitystarttime) {
        this.activitystarttime = activitystarttime;
    }

    public String getActivityendtime() {
        return F_Constants.getDateyyyyMMdd(activityendtime);
    }

    public void setActivityendtime(Date activityendtime) {
        this.activityendtime = activityendtime;
    }

    public String getPropagandatheme() {
        return propagandatheme;
    }

    public void setPropagandatheme(String propagandatheme) {
        this.propagandatheme = propagandatheme;
    }

    public String getFirsttarget() {
        return firsttarget;
    }

    public void setFirsttarget(String firsttarget) {
        this.firsttarget = firsttarget;
    }

    public String getSecondtarget() {
        return secondtarget;
    }

    public void setSecondtarget(String secondtarget) {
        this.secondtarget = secondtarget;
    }

    public String getThirdtarget() {
        return thirdtarget;
    }

    public void setThirdtarget(String thirdtarget) {
        this.thirdtarget = thirdtarget;
    }

    public String getRegionin() {
        return regionin;
    }

    public void setRegionin(String regionin) {
        this.regionin = regionin;
    }

    public String getConductscommunity() {
        return conductscommunity;
    }

    public void setConductscommunity(String conductscommunity) {
        this.conductscommunity = conductscommunity;
    }

    public String getReason() {
        return F_Constants.chageNull(reason);
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getMarkingtype() {
    
        return markingtype;
    }

    public void setMarkingtype(String markingtype) {
    
        this.markingtype = markingtype;
    }

    public String getCurrentnode() {
    
        return currentnode;
    }

    public void setCurrentnode(String currentnode) {
    
        this.currentnode = currentnode;
    }
    
}
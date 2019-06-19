package com.deppon.montal.model;

import java.math.BigDecimal;
import java.util.Date;

import com.deppon.montal.conf.F_Constants;

public class OaNomalClaim {
    private BigDecimal processinstid;

    private String applypersoncode;

    private String clueuserid;

    private String transportorerrorcode;

    private String insuredunits;

    private String contactphone;

    private String haultype;

    private String receivingdept;

    private String startingstation;

    private String goodsname;

    private String goodsattribute;

    private String insuredamount;

    private String targetdept;

    private Date sendingdate;

    private Date dangerdate;

    private String area;

    private String claimstype;

    private String offsettypt;

    private String casereporter;

    private String reportdept;

    private Date reportdate;

    private String handler;

    private Date handledate;

    private String othercost;

    private String claimamount;

    private String responsibiledept;

    private String normalamount;

    private String actualclaimsamount;

    private String tocompanycost;
    
    public static BigDecimal chageNull(BigDecimal str){
	return str == null ? new BigDecimal(0):str;
    }
    
    public BigDecimal getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(BigDecimal processinstid) {
        this.processinstid = processinstid;
    }

    public String getApplypersoncode() {
        return F_Constants.chageNull(applypersoncode);
    }

    public void setApplypersoncode(String applypersoncode) {
        this.applypersoncode = applypersoncode;
    }

    public String getClueuserid() {
        return F_Constants.chageNull(clueuserid);
    }

    public void setClueuserid(String clueuserid) {
        this.clueuserid = clueuserid;
    }

    public String getTransportorerrorcode() {
        return F_Constants.chageNull(transportorerrorcode);
    }

    public void setTransportorerrorcode(String transportorerrorcode) {
        this.transportorerrorcode = transportorerrorcode;
    }

    public String getInsuredunits() {
        return F_Constants.chageNull(insuredunits);
    }

    public void setInsuredunits(String insuredunits) {
        this.insuredunits = insuredunits;
    }

    public String getContactphone() {
        return F_Constants.chageNull(contactphone);
    }

    public void setContactphone(String contactphone) {
        this.contactphone = contactphone;
    }

    public String getHaultype() {
        return F_Constants.chageNull(haultype);
    }

    public void setHaultype(String haultype) {
        this.haultype = haultype;
    }

    public String getReceivingdept() {
        return F_Constants.chageNull(receivingdept);
    }

    public void setReceivingdept(String receivingdept) {
        this.receivingdept = receivingdept;
    }

    public String getStartingstation() {
        return F_Constants.chageNull(startingstation);
    }

    public void setStartingstation(String startingstation) {
        this.startingstation = startingstation;
    }

    public String getGoodsname() {
        return F_Constants.chageNull(goodsname);
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getGoodsattribute() {
        return F_Constants.chageNull(goodsattribute);
    }

    public void setGoodsattribute(String goodsattribute) {
        this.goodsattribute = goodsattribute;
    }

    public String getInsuredamount() {
        return F_Constants.chageNull(insuredamount);
    }

    public void setInsuredamount(String insuredamount) {
        this.insuredamount = insuredamount;
    }

    public String getTargetdept() {
        return F_Constants.chageNull(targetdept);
    }

    public void setTargetdept(String targetdept) {
        this.targetdept = targetdept;
    }

    public Date getSendingdate() {
        return sendingdate;
    }

    public void setSendingdate(Date sendingdate) {
        this.sendingdate = sendingdate;
    }

    public Date getDangerdate() {
        return dangerdate;
    }

    public void setDangerdate(Date dangerdate) {
        this.dangerdate = dangerdate;
    }

    public String getArea() {
        return F_Constants.chageNull(area);
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getClaimstype() {
        return F_Constants.chageNull(claimstype);
    }

    public void setClaimstype(String claimstype) {
        this.claimstype = claimstype;
    }

    public String getOffsettypt() {
        return F_Constants.chageNull(offsettypt);
    }

    public void setOffsettypt(String offsettypt) {
        this.offsettypt = offsettypt;
    }

    public String getCasereporter() {
        return F_Constants.chageNull(casereporter);
    }

    public void setCasereporter(String casereporter) {
        this.casereporter = casereporter;
    }

    public String getReportdept() {
        return F_Constants.chageNull(reportdept);
    }

    public void setReportdept(String reportdept) {
        this.reportdept = reportdept;
    }

    public Date getReportdate() {
        return reportdate;
    }

    public void setReportdate(Date reportdate) {
        this.reportdate = reportdate;
    }

    public String getHandler() {
        return F_Constants.chageNull(handler);
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public Date getHandledate() {
        return handledate;
    }

    public void setHandledate(Date handledate) {
        this.handledate = handledate;
    }

    public String getOthercost() {
        return F_Constants.chageNull(othercost);
    }

    public void setOthercost(String othercost) {
        this.othercost = othercost;
    }

    public String getClaimamount() {
        return F_Constants.chageNull(claimamount);
    }

    public void setClaimamount(String claimamount) {
        this.claimamount = claimamount;
    }

    public String getResponsibiledept() {
        return F_Constants.chageNull(responsibiledept);
    }

    public void setResponsibiledept(String responsibiledept) {
        this.responsibiledept = responsibiledept;
    }

    public String getNormalamount() {
        return F_Constants.chageNull(normalamount);
    }

    public void setNormalamount(String normalamount) {
        this.normalamount = normalamount;
    }

    public String getActualclaimsamount() {
        return F_Constants.chageNull(actualclaimsamount);
    }

    public void setActualclaimsamount(String actualclaimsamount) {
        this.actualclaimsamount = actualclaimsamount;
    }

    public String getTocompanycost() {
        return F_Constants.chageNull(tocompanycost);
    }

    public void setTocompanycost(String tocompanycost) {
        this.tocompanycost = tocompanycost;
    }
}
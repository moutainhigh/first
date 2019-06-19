//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.5-2 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2014.08.11 时间 03:39:59 PM CST 
//


package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

public class ApprovalInfo {

    protected String applyno;
//    @XmlSchemaType(name = "dateTime")
    protected String approvedate;
    protected String approveno;
    protected String approver;
    protected String approvever;
    protected String busino;
    protected String currentactivitydefid;
    protected String currentactivitydefname;
    protected String duty;
    protected String isagree;
    protected String iseffective;
    protected String nextactivitydefid;
    protected String nextactivitydefname;
    protected long processinstid;
//    @XmlSchemaType(name = "dateTime")
    protected String starttime;
    protected String userid;
    protected WfWorkItem workItem;
    protected long workitemid;

    /**
     * 获取applyno属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyno() {
        return applyno;
    }

    /**
     * 设置applyno属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyno(String value) {
        this.applyno = value;
    }

    /**
     * 获取approvedate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public String getApprovedate() {
        return approvedate;
    }

    /**
     * 设置approvedate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setApprovedate(String value) {
        this.approvedate = value;
    }

    /**
     * 获取approveno属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproveno() {
        return approveno;
    }

    /**
     * 设置approveno属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproveno(String value) {
        this.approveno = value;
    }

    /**
     * 获取approver属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApprover() {
        return approver;
    }

    /**
     * 设置approver属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApprover(String value) {
        this.approver = value;
    }

    /**
     * 获取approvever属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApprovever() {
        return approvever;
    }

    /**
     * 设置approvever属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApprovever(String value) {
        this.approvever = value;
    }

    /**
     * 获取busino属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusino() {
        return busino;
    }

    /**
     * 设置busino属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusino(String value) {
        this.busino = value;
    }

    /**
     * 获取currentactivitydefid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentactivitydefid() {
        return currentactivitydefid;
    }

    /**
     * 设置currentactivitydefid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentactivitydefid(String value) {
        this.currentactivitydefid = value;
    }

    /**
     * 获取currentactivitydefname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentactivitydefname() {
        return currentactivitydefname;
    }

    /**
     * 设置currentactivitydefname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentactivitydefname(String value) {
        this.currentactivitydefname = value;
    }

    /**
     * 获取duty属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDuty() {
        return duty;
    }

    /**
     * 设置duty属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDuty(String value) {
        this.duty = value;
    }

    /**
     * 获取isagree属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsagree() {
        return isagree;
    }

    /**
     * 设置isagree属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsagree(String value) {
        this.isagree = value;
    }

    /**
     * 获取iseffective属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIseffective() {
        return iseffective;
    }

    /**
     * 设置iseffective属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIseffective(String value) {
        this.iseffective = value;
    }

    /**
     * 获取nextactivitydefid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNextactivitydefid() {
        return nextactivitydefid;
    }

    /**
     * 设置nextactivitydefid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNextactivitydefid(String value) {
        this.nextactivitydefid = value;
    }

    /**
     * 获取nextactivitydefname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNextactivitydefname() {
        return nextactivitydefname;
    }

    /**
     * 设置nextactivitydefname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNextactivitydefname(String value) {
        this.nextactivitydefname = value;
    }

    /**
     * 获取processinstid属性的值。
     * 
     */
    public long getProcessinstid() {
        return processinstid;
    }

    /**
     * 设置processinstid属性的值。
     * 
     */
    public void setProcessinstid(long value) {
        this.processinstid = value;
    }

    /**
     * 获取starttime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public String getStarttime() {
        return starttime;
    }

    /**
     * 设置starttime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStarttime(String value) {
        this.starttime = value;
    }

    /**
     * 获取userid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置userid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserid(String value) {
        this.userid = value;
    }

    /**
     * 获取workItem属性的值。
     * 
     * @return
     *     possible object is
     *     {@link WfWorkItem }
     *     
     */
    public WfWorkItem getWorkItem() {
        return workItem;
    }

    /**
     * 设置workItem属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link WfWorkItem }
     *     
     */
    public void setWorkItem(WfWorkItem value) {
        this.workItem = value;
    }

    /**
     * 获取workitemid属性的值。
     * 
     */
    public long getWorkitemid() {
        return workitemid;
    }

    /**
     * 设置workitemid属性的值。
     * 
     */
    public void setWorkitemid(long value) {
        this.workitemid = value;
    }

}

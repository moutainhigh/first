
package com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for approvalInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="approvalInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="applyno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="approvedate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="approveno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="approver" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="approvever" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="busino" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currentactivitydefid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currentactivitydefname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="duty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isagree" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="iseffective" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nextactivitydefid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nextactivitydefname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="processinstid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="starttime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="userid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="workItem" type="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}wfWorkItem" minOccurs="0"/>
 *         &lt;element name="workitemid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "approvalInfo", propOrder = {
    "applyno",
    "approvedate",
    "approveno",
    "approver",
    "approvever",
    "busino",
    "currentactivitydefid",
    "currentactivitydefname",
    "duty",
    "isagree",
    "iseffective",
    "nextactivitydefid",
    "nextactivitydefname",
    "processinstid",
    "starttime",
    "userid",
    "workItem",
    "workitemid"
})
public class ApprovalInfo {

    protected String applyno;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar approvedate;
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
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar starttime;
    protected String userid;
    protected WfWorkItem workItem;
    protected long workitemid;

    /**
     * Gets the value of the applyno property.
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
     * Sets the value of the applyno property.
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
     * Gets the value of the approvedate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getApprovedate() {
        return approvedate;
    }

    /**
     * Sets the value of the approvedate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setApprovedate(XMLGregorianCalendar value) {
        this.approvedate = value;
    }

    /**
     * Gets the value of the approveno property.
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
     * Sets the value of the approveno property.
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
     * Gets the value of the approver property.
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
     * Sets the value of the approver property.
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
     * Gets the value of the approvever property.
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
     * Sets the value of the approvever property.
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
     * Gets the value of the busino property.
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
     * Sets the value of the busino property.
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
     * Gets the value of the currentactivitydefid property.
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
     * Sets the value of the currentactivitydefid property.
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
     * Gets the value of the currentactivitydefname property.
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
     * Sets the value of the currentactivitydefname property.
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
     * Gets the value of the duty property.
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
     * Sets the value of the duty property.
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
     * Gets the value of the isagree property.
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
     * Sets the value of the isagree property.
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
     * Gets the value of the iseffective property.
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
     * Sets the value of the iseffective property.
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
     * Gets the value of the nextactivitydefid property.
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
     * Sets the value of the nextactivitydefid property.
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
     * Gets the value of the nextactivitydefname property.
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
     * Sets the value of the nextactivitydefname property.
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
     * Gets the value of the processinstid property.
     * 
     */
    public long getProcessinstid() {
        return processinstid;
    }

    /**
     * Sets the value of the processinstid property.
     * 
     */
    public void setProcessinstid(long value) {
        this.processinstid = value;
    }

    /**
     * Gets the value of the starttime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStarttime() {
        return starttime;
    }

    /**
     * Sets the value of the starttime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStarttime(XMLGregorianCalendar value) {
        this.starttime = value;
    }

    /**
     * Gets the value of the userid property.
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
     * Sets the value of the userid property.
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
     * Gets the value of the workItem property.
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
     * Sets the value of the workItem property.
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
     * Gets the value of the workitemid property.
     * 
     */
    public long getWorkitemid() {
        return workitemid;
    }

    /**
     * Sets the value of the workitemid property.
     * 
     */
    public void setWorkitemid(long value) {
        this.workitemid = value;
    }

}

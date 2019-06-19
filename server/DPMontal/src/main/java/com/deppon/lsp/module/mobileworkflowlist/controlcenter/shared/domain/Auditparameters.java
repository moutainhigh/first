
package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for auditparameters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="auditparameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="auditAdvise" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="decisionState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="docId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="docNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="empCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="empName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wfInstanceId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="wfState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wfWorkItemId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="TargetDefinitionDTO")  
@XmlType(name = "auditparameters1", propOrder = {
    "auditAdvise",
    "decisionState",
    "docId",
    "docNo",
    "empCode",
    "empName",
    "wfInstanceId",
    "wfState",
    "wfWorkItemId"
})
public class Auditparameters {

    protected String auditAdvise;
    protected String decisionState;
    protected String docId;
    protected String docNo;
    protected String empCode;
    protected String empName;
    protected long wfInstanceId;
    protected String wfState;
    protected long wfWorkItemId;

    /**
     * Gets the value of the auditAdvise property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuditAdvise() {
        return auditAdvise;
    }

    /**
     * Sets the value of the auditAdvise property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuditAdvise(String value) {
        this.auditAdvise = value;
    }

    /**
     * Gets the value of the decisionState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDecisionState() {
        return decisionState;
    }

    /**
     * Sets the value of the decisionState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDecisionState(String value) {
        this.decisionState = value;
    }

    /**
     * Gets the value of the docId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocId() {
        return docId;
    }

    /**
     * Sets the value of the docId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocId(String value) {
        this.docId = value;
    }

    /**
     * Gets the value of the docNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocNo() {
        return docNo;
    }

    /**
     * Sets the value of the docNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocNo(String value) {
        this.docNo = value;
    }

    /**
     * Gets the value of the empCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpCode() {
        return empCode;
    }

    /**
     * Sets the value of the empCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpCode(String value) {
        this.empCode = value;
    }

    /**
     * Gets the value of the empName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * Sets the value of the empName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpName(String value) {
        this.empName = value;
    }

    /**
     * Gets the value of the wfInstanceId property.
     * 
     */
    public long getWfInstanceId() {
        return wfInstanceId;
    }

    /**
     * Sets the value of the wfInstanceId property.
     * 
     */
    public void setWfInstanceId(long value) {
        this.wfInstanceId = value;
    }

    /**
     * Gets the value of the wfState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWfState() {
        return wfState;
    }

    /**
     * Sets the value of the wfState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWfState(String value) {
        this.wfState = value;
    }

    /**
     * Gets the value of the wfWorkItemId property.
     * 
     */
    public long getWfWorkItemId() {
        return wfWorkItemId;
    }

    /**
     * Sets the value of the wfWorkItemId property.
     * 
     */
    public void setWfWorkItemId(long value) {
        this.wfWorkItemId = value;
    }

}

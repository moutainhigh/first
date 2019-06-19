
package com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.shared.domain;

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
 *         &lt;element name="approvedate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="approver" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="approverPosition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="approvever" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isagree" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "approvedate",
    "approver",
    "approverPosition",
    "approvever",
    "isagree"
})
public class ApprovalInfo {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar approvedate;
    protected String approver;
    protected String approverPosition;
    protected String approvever;
    protected String isagree;

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
     * Gets the value of the approverPosition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproverPosition() {
        return approverPosition;
    }

    /**
     * Sets the value of the approverPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproverPosition(String value) {
        this.approverPosition = value;
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

}

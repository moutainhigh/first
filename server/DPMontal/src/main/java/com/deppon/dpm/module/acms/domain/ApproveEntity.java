package com.deppon.dpm.module.acms.domain;

import javax.xml.datatype.XMLGregorianCalendar;
public class ApproveEntity {
	//审批时间
    protected XMLGregorianCalendar approveDate;
    //审批人
    protected String approver;
    protected String approverPosition;
    //审批结果
    protected String approveDesition;
    //审批意见
    protected String approveOpinion;

    /**
     * Gets the value of the approveDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getApproveDate() {
        return approveDate;
    }

    /**
     * Sets the value of the approveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setApproveDate(XMLGregorianCalendar value) {
        this.approveDate = value;
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
     * Gets the value of the approveDesition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproveDesition() {
        return approveDesition;
    }

    /**
     * Sets the value of the approveDesition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproveDesition(String value) {
        this.approveDesition = value;
    }

    /**
     * Gets the value of the approveOpinion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproveOpinion() {
        return approveOpinion;
    }

    /**
     * Sets the value of the approveOpinion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproveOpinion(String value) {
        this.approveOpinion = value;
    }

}

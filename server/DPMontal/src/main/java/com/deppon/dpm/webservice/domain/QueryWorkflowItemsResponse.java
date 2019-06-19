
package com.deppon.dpm.webservice.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for QueryWorkflowItemsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QueryWorkflowItemsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IsSucess" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="failReason" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="workflowItems" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QueryWorkflowItemsResponse", propOrder = {
    "isSucess",
    "failReason",
    "workflowItems"
})
public class QueryWorkflowItemsResponse {

    @XmlElement(name = "IsSucess")
    protected boolean isSucess;
    @XmlElement(required = true)
    protected String failReason;
    protected int workflowItems;

    /**
     * Gets the value of the isSucess property.
     * 
     */
    public boolean isIsSucess() {
        return isSucess;
    }

    /**
     * Sets the value of the isSucess property.
     * 
     */
    public void setIsSucess(boolean value) {
        this.isSucess = value;
    }

    /**
     * Gets the value of the failReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFailReason() {
        return failReason;
    }

    /**
     * Sets the value of the failReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFailReason(String value) {
        this.failReason = value;
    }

    /**
     * Gets the value of the workflowItems property.
     * 
     */
    public int getWorkflowItems() {
        return workflowItems;
    }

    /**
     * Sets the value of the workflowItems property.
     * 
     */
    public void setWorkflowItems(int value) {
        this.workflowItems = value;
    }

}

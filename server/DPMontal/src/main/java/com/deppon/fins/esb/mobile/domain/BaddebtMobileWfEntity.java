
package com.deppon.fins.esb.mobile.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * ҵ���໵����Ϣ
 * 
 * <p>BaddebtMobileWfEntity complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="BaddebtMobileWfEntity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="workflowName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customercode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customername" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="badamount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reason" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reasontypename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="discription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="errorcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="wayInfoPojo" type="{http://www.deppon.com/fins/esb/mobile/domain/}WayInfoPojo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="duty" type="{http://www.deppon.com/fins/esb/mobile/domain/}Duty" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaddebtMobileWfEntity", propOrder = {
    "workflowName",
    "customercode",
    "customername",
    "badamount",
    "reason",
    "reasontypename",
    "discription",
    "errorcode",
    "wayInfoPojo",
    "duty"
})
public class BaddebtMobileWfEntity {

    @XmlElement(required = true)
    protected String workflowName;
    @XmlElement(required = true)
    protected String customercode;
    @XmlElement(required = true)
    protected String customername;
    @XmlElement(required = true)
    protected String badamount;
    @XmlElement(required = true)
    protected String reason;
    @XmlElement(required = true)
    protected String reasontypename;
    @XmlElement(required = true)
    protected String discription;
    @XmlElement(required = true)
    protected String errorcode;
    protected List<WayInfoPojo> wayInfoPojo;
    protected List<Duty> duty;

    /**
     * ��ȡworkflowName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkflowName() {
        return workflowName;
    }

    /**
     * ����workflowName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkflowName(String value) {
        this.workflowName = value;
    }

    /**
     * ��ȡcustomercode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomercode() {
        return customercode;
    }

    /**
     * ����customercode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomercode(String value) {
        this.customercode = value;
    }

    /**
     * ��ȡcustomername���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomername() {
        return customername;
    }

    /**
     * ����customername���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomername(String value) {
        this.customername = value;
    }

    /**
     * ��ȡbadamount���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBadamount() {
        return badamount;
    }

    /**
     * ����badamount���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBadamount(String value) {
        this.badamount = value;
    }

    /**
     * ��ȡreason���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReason() {
        return reason;
    }

    /**
     * ����reason���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReason(String value) {
        this.reason = value;
    }

    /**
     * ��ȡreasontypename���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReasontypename() {
        return reasontypename;
    }

    /**
     * ����reasontypename���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReasontypename(String value) {
        this.reasontypename = value;
    }

    /**
     * ��ȡdiscription���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscription() {
        return discription;
    }

    /**
     * ����discription���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscription(String value) {
        this.discription = value;
    }

    /**
     * ��ȡerrorcode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorcode() {
        return errorcode;
    }

    /**
     * ����errorcode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorcode(String value) {
        this.errorcode = value;
    }

    /**
     * Gets the value of the wayInfoPojo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wayInfoPojo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWayInfoPojo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WayInfoPojo }
     * 
     * 
     */
    public List<WayInfoPojo> getWayInfoPojo() {
        if (wayInfoPojo == null) {
            wayInfoPojo = new ArrayList<WayInfoPojo>();
        }
        return this.wayInfoPojo;
    }

    /**
     * Gets the value of the duty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the duty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDuty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Duty }
     * 
     * 
     */
    public List<Duty> getDuty() {
        if (duty == null) {
            duty = new ArrayList<Duty>();
        }
        return this.duty;
    }

}

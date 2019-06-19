
package com.deppon.montal.module.crm.damin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OverpayInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OverpayInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="crateUserName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="transType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="waybillNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="overpayAmount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="realAmount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="recoverYszk" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deptAccount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="divisionName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="overpayReason" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OverpayInfo", propOrder = {
    "crateUserName",
    "transType",
    "waybillNumber",
    "overpayAmount",
    "realAmount",
    "recoverYszk",
    "deptAccount",
    "divisionName",
    "overpayReason"
})
public class OverpayInfo {
	/**
	 * 申请人
	 */
    @XmlElement(required = true)
    protected String crateUserName;
    /**
     * 运输类型
     */
    @XmlElement(required = true)
    protected String transType;
    /**
     * 多赔单号
     */
    @XmlElement(required = true)
    protected String waybillNumber;
    /**
     * 多赔金额
     */
    @XmlElement(required = true)
    protected String overpayAmount;
    /**
     * 合计理赔金额
     */
    @XmlElement(required = true)
    protected String realAmount;
    /**
     * 应收账款是否收回
     */
    @XmlElement(required = true)
    protected String recoverYszk;
    /**
     * 部门会计
     */
    @XmlElement(required = true)
    protected String deptAccount;
    /**
     * 所属事业部
     */
    @XmlElement(required = true)
    protected String divisionName;
    /**
     * 申请事由
     */
    @XmlElement(required = true)
    protected String overpayReason;

    /**
     * Gets the value of the crateUserName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrateUserName() {
        return crateUserName;
    }

    /**
     * Sets the value of the crateUserName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrateUserName(String value) {
        this.crateUserName = value;
    }

    /**
     * Gets the value of the transType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransType() {
        return transType;
    }

    /**
     * Sets the value of the transType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransType(String value) {
        this.transType = value;
    }

    /**
     * Gets the value of the waybillNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaybillNumber() {
        return waybillNumber;
    }

    /**
     * Sets the value of the waybillNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaybillNumber(String value) {
        this.waybillNumber = value;
    }

    /**
     * Gets the value of the overpayAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOverpayAmount() {
        return overpayAmount;
    }

    /**
     * Sets the value of the overpayAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOverpayAmount(String value) {
        this.overpayAmount = value;
    }

    /**
     * Gets the value of the realAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRealAmount() {
        return realAmount;
    }

    /**
     * Sets the value of the realAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRealAmount(String value) {
        this.realAmount = value;
    }

    /**
     * Gets the value of the recoverYszk property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecoverYszk() {
        return recoverYszk;
    }

    /**
     * Sets the value of the recoverYszk property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecoverYszk(String value) {
        this.recoverYszk = value;
    }

    /**
     * Gets the value of the deptAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeptAccount() {
        return deptAccount;
    }

    /**
     * Sets the value of the deptAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeptAccount(String value) {
        this.deptAccount = value;
    }

    /**
     * Gets the value of the divisionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDivisionName() {
        return divisionName;
    }

    /**
     * Sets the value of the divisionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDivisionName(String value) {
        this.divisionName = value;
    }

    /**
     * Gets the value of the overpayReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOverpayReason() {
        return overpayReason;
    }

    /**
     * Sets the value of the overpayReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOverpayReason(String value) {
        this.overpayReason = value;
    }

}


package com.deppon.fins.esb.mobile.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>UnBaddebtMobileWfEntity complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="UnBaddebtMobileWfEntity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="workflowName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="badBillTypeName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="depositName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="badBillMoney" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="errorcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reasonForBadBill" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "UnBaddebtMobileWfEntity", propOrder = {
    "workflowName",
    "badBillType",
    "badBillTypeName",
    "depositName",
    "badBillMoney",
    "errorcode",
    "reasonForBadBill",
    "depositTypeName",
    "codeNum",
    "startDate",
    "endDate",
    "duty"
})
public class UnBaddebtMobileWfEntity {

    @XmlElement(required = true)
    protected String workflowName;
    @XmlElement(required = true)
    protected String badBillType;
    @XmlElement(required = true)
    protected String badBillTypeName;
    @XmlElement(required = true)
    protected String depositName;
    @XmlElement(required = true)
    protected String badBillMoney;
    @XmlElement(required = true)
    protected String errorcode;
    @XmlElement(required = true)
    protected String reasonForBadBill;
    @XmlElement(required = true)
    protected String depositTypeName;
    @XmlElement(required = true)
    protected String codeNum;
    @XmlElement(required = true)
    protected String startDate;
    @XmlElement(required = true)
    protected String endDate;
    protected List<Duty> duty;

  /**
   * 坏账类型code
   * @description
   * @create 徐倩
   * @date 2014-5-6  
   * @return
   */
    public String getBadBillType() {
		return badBillType;
	}

	public void setBadBillType(String badBillType) {
		this.badBillType = badBillType;
	}

	/**
     * 押金起始日期
     * @description
     * @create 徐倩
     * @date 2014-5-6  
     * @return
     */
    public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
/**
 * 押金结束日期
 * @description
 * @create 徐倩
 * @date 2014-5-6  
 * @return
 */
	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
     * 押金类型名称
     * @description
     * @create 徐倩
     * @date 2014-5-5  
     * @return
     */
    public String getDepositTypeName() {
		return depositTypeName;
	}

	public void setDepositTypeName(String depositTypeName) {
		this.depositTypeName = depositTypeName;
	}
	/**
	 * 押金编码AND借支编码
	 * @description
	 * @create 徐倩
	 * @date 2014-5-5  
	 * @return
	 */
	public String getCodeNum() {
		return codeNum;
	}

	public void setCodeNum(String codeNum) {
		this.codeNum = codeNum;
	}

	/**
     * 获取workflowName属性的值。
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
     * 设置workflowName属性的值。
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
     * 获取badBillTypeName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBadBillTypeName() {
        return badBillTypeName;
    }

    /**
     * 设置badBillTypeName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBadBillTypeName(String value) {
        this.badBillTypeName = value;
    }

    /**
     * 获取depositName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepositName() {
        return depositName;
    }

    /**
     * 设置depositName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepositName(String value) {
        this.depositName = value;
    }

    /**
     * 获取badBillMoney属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBadBillMoney() {
        return badBillMoney;
    }

    /**
     * 设置badBillMoney属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBadBillMoney(String value) {
        this.badBillMoney = value;
    }

    /**
     * 获取errorcode属性的值。
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
     * 设置errorcode属性的值。
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
     * 获取reasonForBadBill属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReasonForBadBill() {
        return reasonForBadBill;
    }

    /**
     * 设置reasonForBadBill属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReasonForBadBill(String value) {
        this.reasonForBadBill = value;
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

	public void setDuty(List<Duty> duty) {
		this.duty = duty;
	}

}

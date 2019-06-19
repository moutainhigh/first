//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.5-2 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2014.04.19 时间 02:35:22 PM CST 
//


package com.deppon.nhr.module.remote.dpm.shared.domain.workflow;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>transferInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="transferInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="applypsncode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applypsnname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applytype" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="positionlevel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="enterprisepersonneldept" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="areapersonneldeptname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="afterdept" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="afterposition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="beforeposition" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="beforedept" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="addpersonno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="backoriginno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reason" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isvaraddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="t_isrelegation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deptnature" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ismanagertrain" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="istelhand" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="afteruser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="money" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transferInfo", propOrder = {
    "applypsncode",
    "applypsnname",
    "applytype",
    "positionlevel",
    "enterprisepersonneldept",
    "areapersonneldeptname",
    "afterdept",
    "afterposition",
    "beforeposition",
    "beforedept",
    "addpersonno",
    "backoriginno",
    "reason",
    "isvaraddress",
    "tIsrelegation",
    "deptnature",
    "ismanagertrain",
    "phone",
    "istelhand",
    "afteruser",
    "money",
    "applydate",
    "wfno",
    "idcard",
    "groupdef1"
})
public class TransferInfo
    implements Serializable
{

    private final static long serialVersionUID = 11082011L;
    @XmlElement(required = true)
    protected String applypsncode;
    @XmlElement(required = true)
    protected String applypsnname;
    @XmlElement(required = true)
    protected String applytype;
    @XmlElement(required = true)
    protected String positionlevel;
    protected String enterprisepersonneldept;
    @XmlElement(required = true)
    protected String areapersonneldeptname;
    protected String afterdept;
    protected String afterposition;
    @XmlElement(required = true)
    protected String beforeposition;
    @XmlElement(required = true)
    protected String beforedept;
    protected String addpersonno;
    protected String backoriginno;
    @XmlElement(required = true)
    protected String reason;
    protected String isvaraddress;
    @XmlElement(name = "t_isrelegation")
    protected String tIsrelegation;
    protected String deptnature;
    protected String ismanagertrain;
    protected String phone;
    protected String istelhand;
    protected String afteruser;
    protected BigDecimal money;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected Date applydate;
    @XmlElement(required = true)
    protected String wfno;
    @XmlElement(required = true)
    protected String idcard;
    @XmlElement(required = true)
    protected String groupdef1;

    public String gettIsrelegation() {
		return tIsrelegation;
	}

	public void settIsrelegation(String tIsrelegation) {
		this.tIsrelegation = tIsrelegation;
	}

	public Date getApplydate() {
		return applydate;
	}

	public void setApplydate(Date applydate) {
		this.applydate = applydate;
	}

	public String getWfno() {
		return wfno;
	}

	public void setWfno(String wfno) {
		this.wfno = wfno;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getGroupdef1() {
		return groupdef1;
	}

	public void setGroupdef1(String groupdef1) {
		this.groupdef1 = groupdef1;
	}

	/**
     * 获取applypsncode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplypsncode() {
        return applypsncode;
    }

    /**
     * 设置applypsncode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplypsncode(String value) {
        this.applypsncode = value;
    }

    /**
     * 获取applypsnname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplypsnname() {
        return applypsnname;
    }

    /**
     * 设置applypsnname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplypsnname(String value) {
        this.applypsnname = value;
    }

    /**
     * 获取applytype属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplytype() {
        return applytype;
    }

    /**
     * 设置applytype属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplytype(String value) {
        this.applytype = value;
    }

    /**
     * 获取positionlevel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPositionlevel() {
        return positionlevel;
    }

    /**
     * 设置positionlevel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPositionlevel(String value) {
        this.positionlevel = value;
    }

    /**
     * 获取enterprisepersonneldept属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnterprisepersonneldept() {
        return enterprisepersonneldept;
    }

    /**
     * 设置enterprisepersonneldept属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnterprisepersonneldept(String value) {
        this.enterprisepersonneldept = value;
    }

    /**
     * 获取areapersonneldeptname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreapersonneldeptname() {
        return areapersonneldeptname;
    }

    /**
     * 设置areapersonneldeptname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreapersonneldeptname(String value) {
        this.areapersonneldeptname = value;
    }

    /**
     * 获取afterdept属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAfterdept() {
        return afterdept;
    }

    /**
     * 设置afterdept属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAfterdept(String value) {
        this.afterdept = value;
    }

    /**
     * 获取afterposition属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAfterposition() {
        return afterposition;
    }

    /**
     * 设置afterposition属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAfterposition(String value) {
        this.afterposition = value;
    }

    /**
     * 获取beforeposition属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeforeposition() {
        return beforeposition;
    }

    /**
     * 设置beforeposition属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeforeposition(String value) {
        this.beforeposition = value;
    }

    /**
     * 获取beforedept属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeforedept() {
        return beforedept;
    }

    /**
     * 设置beforedept属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeforedept(String value) {
        this.beforedept = value;
    }

    /**
     * 获取addpersonno属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddpersonno() {
        return addpersonno;
    }

    /**
     * 设置addpersonno属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddpersonno(String value) {
        this.addpersonno = value;
    }

    /**
     * 获取backoriginno属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBackoriginno() {
        return backoriginno;
    }

    /**
     * 设置backoriginno属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBackoriginno(String value) {
        this.backoriginno = value;
    }

    /**
     * 获取reason属性的值。
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
     * 设置reason属性的值。
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
     * 获取isvaraddress属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsvaraddress() {
        return isvaraddress;
    }

    /**
     * 设置isvaraddress属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsvaraddress(String value) {
        this.isvaraddress = value;
    }

    /**
     * 获取tIsrelegation属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTIsrelegation() {
        return tIsrelegation;
    }

    /**
     * 设置tIsrelegation属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTIsrelegation(String value) {
        this.tIsrelegation = value;
    }

    /**
     * 获取deptnature属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeptnature() {
        return deptnature;
    }

    /**
     * 设置deptnature属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeptnature(String value) {
        this.deptnature = value;
    }

    /**
     * 获取ismanagertrain属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsmanagertrain() {
        return ismanagertrain;
    }

    /**
     * 设置ismanagertrain属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsmanagertrain(String value) {
        this.ismanagertrain = value;
    }

    /**
     * 获取phone属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置phone属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhone(String value) {
        this.phone = value;
    }

    /**
     * 获取istelhand属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIstelhand() {
        return istelhand;
    }

    /**
     * 设置istelhand属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIstelhand(String value) {
        this.istelhand = value;
    }

    /**
     * 获取afteruser属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAfteruser() {
        return afteruser;
    }

    /**
     * 设置afteruser属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAfteruser(String value) {
        this.afteruser = value;
    }

    /**
     * 获取money属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * 设置money属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMoney(BigDecimal value) {
        this.money = value;
    }

}

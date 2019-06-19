//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.5-2 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2014.04.19 时间 09:17:43 AM CST 
//


package com.deppon.nhr.module.remote.dpm.shared.domain.workflow;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>originInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="originInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="applypsncode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applypsnname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="positionlevel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="t_ispersonorcompany" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="areapersonneldeptname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="enterprisepersonneldeptname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="t_nativespace" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="beforeposition" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="beforedept" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="t_nowposduretime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="t_wanttoplace" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reason" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="t_lastsixmark" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="t_isrelegation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "originInfo", propOrder = {
    "applypsncode",
    "applypsnname",
    "positionlevel",
    "tIspersonorcompany",
    "areapersonneldeptname",
    "enterprisepersonneldeptname",
    "tNativespace",
    "beforeposition",
    "beforedept",
    "tNowposduretime",
    "tWanttoplace",
    "reason",
    "tLastsixmark",
    "tIsrelegation",
    "applydate",
    "wfno",
    "t_lastsixcompetency"
})
public class OriginInfo
    implements Serializable
{

    private final static long serialVersionUID = 11082011L;
    @XmlElement(required = true)
    protected String applypsncode;
    @XmlElement(required = true)
    protected String applypsnname;
    @XmlElement(required = true)
    protected String positionlevel;
    @XmlElement(name = "t_ispersonorcompany", required = true)
    protected String tIspersonorcompany;
    @XmlElement(required = true)
    protected String areapersonneldeptname;
    @XmlElement(required = true)
    protected String enterprisepersonneldeptname;
    @XmlElement(name = "t_nativespace", required = true)
    protected String tNativespace;
    @XmlElement(required = true)
    protected String beforeposition;
    @XmlElement(required = true)
    protected String beforedept;
    @XmlElement(name = "t_nowposduretime", required = true)
    protected String tNowposduretime;
    @XmlElement(name = "t_wanttoplace", required = true)
    protected String tWanttoplace;
    @XmlElement(required = true)
    protected String reason;
    @XmlElement(name = "t_lastsixmark", required = true)
    protected String tLastsixmark;
    @XmlElement(name = "t_isrelegation", required = true)
    protected String tIsrelegation;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected Date applydate;
    @XmlElement(required = true)
    protected String wfno;
    @XmlElement(required = true)
    protected String t_lastsixcompetency;

    public String gettIspersonorcompany() {
		return tIspersonorcompany;
	}

	public void settIspersonorcompany(String tIspersonorcompany) {
		this.tIspersonorcompany = tIspersonorcompany;
	}

	public String gettNativespace() {
		return tNativespace;
	}

	public void settNativespace(String tNativespace) {
		this.tNativespace = tNativespace;
	}

	public String gettNowposduretime() {
		return tNowposduretime;
	}

	public void settNowposduretime(String tNowposduretime) {
		this.tNowposduretime = tNowposduretime;
	}

	public String gettWanttoplace() {
		return tWanttoplace;
	}

	public void settWanttoplace(String tWanttoplace) {
		this.tWanttoplace = tWanttoplace;
	}

	public String gettLastsixmark() {
		return tLastsixmark;
	}

	public void settLastsixmark(String tLastsixmark) {
		this.tLastsixmark = tLastsixmark;
	}

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

	public String getT_lastsixcompetency() {
		return t_lastsixcompetency;
	}

	public void setT_lastsixcompetency(String t_lastsixcompetency) {
		this.t_lastsixcompetency = t_lastsixcompetency;
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
     * 获取tIspersonorcompany属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTIspersonorcompany() {
        return tIspersonorcompany;
    }

    /**
     * 设置tIspersonorcompany属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTIspersonorcompany(String value) {
        this.tIspersonorcompany = value;
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
     * 获取enterprisepersonneldeptname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnterprisepersonneldeptname() {
        return enterprisepersonneldeptname;
    }

    /**
     * 设置enterprisepersonneldeptname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnterprisepersonneldeptname(String value) {
        this.enterprisepersonneldeptname = value;
    }

    /**
     * 获取tNativespace属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTNativespace() {
        return tNativespace;
    }

    /**
     * 设置tNativespace属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTNativespace(String value) {
        this.tNativespace = value;
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
     * 获取tNowposduretime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTNowposduretime() {
        return tNowposduretime;
    }

    /**
     * 设置tNowposduretime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTNowposduretime(String value) {
        this.tNowposduretime = value;
    }

    /**
     * 获取tWanttoplace属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTWanttoplace() {
        return tWanttoplace;
    }

    /**
     * 设置tWanttoplace属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTWanttoplace(String value) {
        this.tWanttoplace = value;
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
     * 获取tLastsixmark属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTLastsixmark() {
        return tLastsixmark;
    }

    /**
     * 设置tLastsixmark属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTLastsixmark(String value) {
        this.tLastsixmark = value;
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

}

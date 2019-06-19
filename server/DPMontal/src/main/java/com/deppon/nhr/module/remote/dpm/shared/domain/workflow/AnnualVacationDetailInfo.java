//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.5-2 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2014.05.17 时间 03:19:34 PM CST 
//


package com.deppon.nhr.module.remote.dpm.shared.domain.workflow;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>annualVacationDetailInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="annualVacationDetailInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="casualLeave" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sickLeave" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="annualLeave" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="marriageLeave" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bereavementLeave" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="maternityLeave" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nurseLeave" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="injuryLeave" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="seizedLeave" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "annualVacationDetailInfo", propOrder = {
    "casualLeave",
    "sickLeave",
    "annualLeave",
    "marriageLeave",
    "bereavementLeave",
    "maternityLeave",
    "nurseLeave",
    "injuryLeave",
    "seizedLeave"
})
public class AnnualVacationDetailInfo
    implements Serializable
{

    private final static long serialVersionUID = 11082011L;
    //事假
    @XmlElement(required = true)
    protected String casualLeave;
    //病假
    @XmlElement(required = true)
    protected String sickLeave;
    //年假
    @XmlElement(required = true)
    protected String annualLeave;
    //婚假
    @XmlElement(required = true)
    protected String marriageLeave;
    //丧假
    @XmlElement(required = true)
    protected String bereavementLeave;
    //产假
    @XmlElement(required = true)
    protected String maternityLeave;
    //看护假
    @XmlElement(required = true)
    protected String nurseLeave;
    //工伤假
    @XmlElement(required = true)
    protected String injuryLeave;
    //产检假
    @XmlElement(required = true)
    protected String seizedLeave;

    /**
     * 获取casualLeave属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCasualLeave() {
        return casualLeave;
    }

    /**
     * 设置casualLeave属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCasualLeave(String value) {
        this.casualLeave = value;
    }

    /**
     * 获取sickLeave属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSickLeave() {
        return sickLeave;
    }

    /**
     * 设置sickLeave属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSickLeave(String value) {
        this.sickLeave = value;
    }

    /**
     * 获取annualLeave属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnualLeave() {
        return annualLeave;
    }

    /**
     * 设置annualLeave属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnualLeave(String value) {
        this.annualLeave = value;
    }

    /**
     * 获取marriageLeave属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarriageLeave() {
        return marriageLeave;
    }

    /**
     * 设置marriageLeave属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarriageLeave(String value) {
        this.marriageLeave = value;
    }

    /**
     * 获取bereavementLeave属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBereavementLeave() {
        return bereavementLeave;
    }

    /**
     * 设置bereavementLeave属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBereavementLeave(String value) {
        this.bereavementLeave = value;
    }

    /**
     * 获取maternityLeave属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaternityLeave() {
        return maternityLeave;
    }

    /**
     * 设置maternityLeave属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaternityLeave(String value) {
        this.maternityLeave = value;
    }

    /**
     * 获取nurseLeave属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNurseLeave() {
        return nurseLeave;
    }

    /**
     * 设置nurseLeave属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNurseLeave(String value) {
        this.nurseLeave = value;
    }

    /**
     * 获取injuryLeave属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInjuryLeave() {
        return injuryLeave;
    }

    /**
     * 设置injuryLeave属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInjuryLeave(String value) {
        this.injuryLeave = value;
    }

    /**
     * 获取seizedLeave属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeizedLeave() {
        return seizedLeave;
    }

    /**
     * 设置seizedLeave属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeizedLeave(String value) {
        this.seizedLeave = value;
    }

}

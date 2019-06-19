
package com.deppon.wdgh.inteface.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>ApproveInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ApproveInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="applyTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="applyPersonCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applyResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applyAdvise" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApproveInfo", propOrder = {
    "applyTime",
    "applyPersonCode",
    "applyResult",
    "applyAdvise"
})
public class ApproveInfo {

    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar applyTime;
    @XmlElement(required = true)
    protected String applyPersonCode;
    @XmlElement(required = true)
    protected String applyResult;
    @XmlElement(required = true)
    protected String applyAdvise;

    /**
     * 获取applyTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getApplyTime() {
        return applyTime;
    }

    /**
     * 设置applyTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setApplyTime(XMLGregorianCalendar value) {
        this.applyTime = value;
    }

    /**
     * 获取applyPersonCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyPersonCode() {
        return applyPersonCode;
    }

    /**
     * 设置applyPersonCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyPersonCode(String value) {
        this.applyPersonCode = value;
    }

    /**
     * 获取applyResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyResult() {
        return applyResult;
    }

    /**
     * 设置applyResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyResult(String value) {
        this.applyResult = value;
    }

    /**
     * 获取applyAdvise属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyAdvise() {
        return applyAdvise;
    }

    /**
     * 设置applyAdvise属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyAdvise(String value) {
        this.applyAdvise = value;
    }

}

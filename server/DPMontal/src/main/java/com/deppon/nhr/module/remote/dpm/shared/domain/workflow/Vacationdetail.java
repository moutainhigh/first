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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>vacationdetail complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="vacationdetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vacationperiod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vacationdays" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vacationdetail", propOrder = {
    "vacationperiod",
    "vacationdays"
})
public class Vacationdetail
    implements Serializable
{

    private final static long serialVersionUID = 11082011L;
    //假期年月
    protected String vacationperiod;
    //假期天数
    protected String vacationdays;

    /**
     * 获取vacationperiod属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVacationperiod() {
        return vacationperiod;
    }

    /**
     * 设置vacationperiod属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVacationperiod(String value) {
        this.vacationperiod = value;
    }

    /**
     * 获取vacationdays属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVacationdays() {
        return vacationdays;
    }

    /**
     * 设置vacationdays属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVacationdays(String value) {
        this.vacationdays = value;
    }

}

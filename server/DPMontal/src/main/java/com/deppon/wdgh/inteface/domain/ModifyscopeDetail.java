
package com.deppon.wdgh.inteface.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>modifyscopeDetail complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="modifyscopeDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="childDeptName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pickupSelf" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deliver" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="childPickupScope" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="childDeliverScope" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modifyscopeDetail", propOrder = {
    "childDeptName",
    "pickupSelf",
    "deliver",
    "childPickupScope",
    "childDeliverScope"
})
public class ModifyscopeDetail {

    @XmlElement(required = true)
    protected String childDeptName;
    @XmlElement(required = true)
    protected String pickupSelf;
    @XmlElement(required = true)
    protected String deliver;
    @XmlElement(required = true)
    protected String childPickupScope;
    @XmlElement(required = true)
    protected String childDeliverScope;

    /**
     * 获取childDeptName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildDeptName() {
        return childDeptName;
    }

    /**
     * 设置childDeptName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildDeptName(String value) {
        this.childDeptName = value;
    }

    /**
     * 获取pickupSelf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPickupSelf() {
        return pickupSelf;
    }

    /**
     * 设置pickupSelf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPickupSelf(String value) {
        this.pickupSelf = value;
    }

    /**
     * 获取deliver属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliver() {
        return deliver;
    }

    /**
     * 设置deliver属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliver(String value) {
        this.deliver = value;
    }

    /**
     * 获取childPickupScope属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildPickupScope() {
        return childPickupScope;
    }

    /**
     * 设置childPickupScope属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildPickupScope(String value) {
        this.childPickupScope = value;
    }

    /**
     * 获取childDeliverScope属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildDeliverScope() {
        return childDeliverScope;
    }

    /**
     * 设置childDeliverScope属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildDeliverScope(String value) {
        this.childDeliverScope = value;
    }

}

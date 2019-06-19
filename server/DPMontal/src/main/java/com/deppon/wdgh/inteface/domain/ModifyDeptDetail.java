
package com.deppon.wdgh.inteface.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>modifyDeptDetail complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="modifyDeptDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deptName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="modifyType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="beforeContent" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="afterContent" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modifyDeptDetail", propOrder = {
    "deptName",
    "modifyType",
    "beforeContent",
    "afterContent"
})
public class ModifyDeptDetail {

    @XmlElement(required = true)
    protected String deptName;
    @XmlElement(required = true)
    protected String modifyType;
    @XmlElement(required = true)
    protected String beforeContent;
    @XmlElement(required = true)
    protected String afterContent;

    /**
     * 获取deptName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 设置deptName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeptName(String value) {
        this.deptName = value;
    }

    /**
     * 获取modifyType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModifyType() {
        return modifyType;
    }

    /**
     * 设置modifyType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModifyType(String value) {
        this.modifyType = value;
    }

    /**
     * 获取beforeContent属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeforeContent() {
        return beforeContent;
    }

    /**
     * 设置beforeContent属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeforeContent(String value) {
        this.beforeContent = value;
    }

    /**
     * 获取afterContent属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAfterContent() {
        return afterContent;
    }

    /**
     * 设置afterContent属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAfterContent(String value) {
        this.afterContent = value;
    }

}

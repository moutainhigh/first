//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.5-2 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2014.04.21 时间 11:15:59 AM CST 
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
 * <p>approvalDetail complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="approvalDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="approvaldate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="approver" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applyno" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isagree" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="approvever" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="currentactivitydefname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "approvalDetail", propOrder = {
    "approvaldate",
    "approver",
    "applyno",
    "isagree",
    "approvever",
    "currentactivitydefname"
})
public class ApprovalDetail
    implements Serializable
{

    private final static long serialVersionUID = 11082011L;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected Date approvaldate;
    @XmlElement(required = true)
    protected String approver;
    @XmlElement(required = true)
    protected String applyno;
    @XmlElement(required = true)
    protected String isagree;
    @XmlElement(required = true)
    protected String approvever;
    @XmlElement(required = true)
    protected String currentactivitydefname;

    /**
     * 获取approvaldate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getApprovaldate() {
        return approvaldate;
    }

    /**
     * 设置approvaldate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApprovaldate(Date value) {
        this.approvaldate = value;
    }

    /**
     * 获取approver属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApprover() {
        return approver;
    }

    /**
     * 设置approver属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApprover(String value) {
        this.approver = value;
    }

    /**
     * 获取applyno属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyno() {
        return applyno;
    }

    /**
     * 设置applyno属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyno(String value) {
        this.applyno = value;
    }

    /**
     * 获取isagree属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsagree() {
        return isagree;
    }

    /**
     * 设置isagree属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsagree(String value) {
        this.isagree = value;
    }

    /**
     * 获取approvever属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApprovever() {
        return approvever;
    }

    /**
     * 设置approvever属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApprovever(String value) {
        this.approvever = value;
    }

    /**
     * 获取currentactivitydefname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentactivitydefname() {
        return currentactivitydefname;
    }

    /**
     * 设置currentactivitydefname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentactivitydefname(String value) {
        this.currentactivitydefname = value;
    }

}

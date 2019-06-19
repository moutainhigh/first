//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.5-2 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2014.08.11 时间 03:39:59 PM CST 
//


package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>auditparameters complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="auditparameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="auditAdvise" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="decisionState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="docId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="docNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="empCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="empName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wfInstanceId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="wfState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wfWorkItemId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "auditparameters", propOrder = {
    "auditAdvise",
    "decisionState",
    "docId",
    "docNo",
    "empCode",
    "empName",
    "wfInstanceId",
    "wfState",
    "wfWorkItemId"
})
public class Auditparameters {

    protected String auditAdvise;//审批意见
    protected String decisionState;//shenpi决策
    protected String docId;//业务单据号
    protected String docNo;
    protected String empCode;//审批人工号
    protected String empName;//审批人姓名
    protected long wfInstanceId;//工作流号
    protected String wfState;//活动定义名称
    protected long wfWorkItemId;//工作项ID

    /**
     * 获取auditAdvise属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuditAdvise() {
        return auditAdvise;
    }

    /**
     * 设置auditAdvise属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuditAdvise(String value) {
        this.auditAdvise = value;
    }

    /**
     * 获取decisionState属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDecisionState() {
        return decisionState;
    }

    /**
     * 设置decisionState属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDecisionState(String value) {
        this.decisionState = value;
    }

    /**
     * 获取docId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocId() {
        return docId;
    }

    /**
     * 设置docId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocId(String value) {
        this.docId = value;
    }

    /**
     * 获取docNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocNo() {
        return docNo;
    }

    /**
     * 设置docNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocNo(String value) {
        this.docNo = value;
    }

    /**
     * 获取empCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpCode() {
        return empCode;
    }

    /**
     * 设置empCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpCode(String value) {
        this.empCode = value;
    }

    /**
     * 获取empName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * 设置empName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpName(String value) {
        this.empName = value;
    }

    /**
     * 获取wfInstanceId属性的值。
     * 
     */
    public long getWfInstanceId() {
        return wfInstanceId;
    }

    /**
     * 设置wfInstanceId属性的值。
     * 
     */
    public void setWfInstanceId(long value) {
        this.wfInstanceId = value;
    }

    /**
     * 获取wfState属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWfState() {
        return wfState;
    }

    /**
     * 设置wfState属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWfState(String value) {
        this.wfState = value;
    }

    /**
     * 获取wfWorkItemId属性的值。
     * 
     */
    public long getWfWorkItemId() {
        return wfWorkItemId;
    }

    /**
     * 设置wfWorkItemId属性的值。
     * 
     */
    public void setWfWorkItemId(long value) {
        this.wfWorkItemId = value;
    }

}

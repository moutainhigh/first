//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.5-2 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2014.04.21 时间 11:07:53 AM CST 
//


package com.deppon.nhr.module.remote.dpm.shared.domain.workflow;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.deppon.montal.util.InitDataServlet;


/**
 * <p>queryWorkflowInfoRequest complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="queryWorkflowInfoRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="empCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="empName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="workFlowType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="workFlowNum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queryWorkflowInfoRequest", propOrder = {
    "empCode",
    "empName",
    "workFlowType",
    "workFlowNum"
})
public class QueryWorkflowInfoRequest
    implements Serializable
{

    private final static long serialVersionUID = 11082011L;
    @XmlElement(required = true)
    protected String empCode;
    @XmlElement(required = true)
    protected String empName;
    @XmlElement(required = true)
    protected String workFlowType;
    @XmlElement(required = true)
    protected String workFlowNum;
    public QueryWorkflowInfoRequest(){}
    public QueryWorkflowInfoRequest(String empCode,String empName,String flowtype,String workFlowNum){
    	String hr_positiveApplication =InitDataServlet.getValue("hr_positiveApplication");
    	String hr_addEmpApply = InitDataServlet.getValue("hr_addEmpApply");
    	String hr_returnDomicileOfOrigin = InitDataServlet.getValue("hr_returnDomicileOfOrigin");
    	String hr_employeeTransactionApply = InitDataServlet.getValue("hr_employeeTransactionApply");
    	String hr_leaveDaysOff = InitDataServlet.getValue("hr_leaveDaysOff");
    	this.empCode = empCode;
    	this.empName = empName;
    	this.workFlowNum = workFlowNum;
    	if(hr_positiveApplication.equals(flowtype)) {
        	this.workFlowType = "104";
		}else if(hr_addEmpApply.equals(flowtype)) {
			this.workFlowType = "102";
		}else if(hr_returnDomicileOfOrigin.equals(flowtype)) {
			this.workFlowType = "106";
		}else if(hr_employeeTransactionApply.equals(flowtype)) {
			this.workFlowType = "107";
		}else if(hr_leaveDaysOff.equals(flowtype)) {
			this.workFlowType = "103";
		}
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
     * 获取workFlowType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkFlowType() {
        return workFlowType;
    }

    /**
     * 设置workFlowType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkFlowType(String value) {
        this.workFlowType = value;
    }

    /**
     * 获取workFlowNum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkFlowNum() {
        return workFlowNum;
    }

    /**
     * 设置workFlowNum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkFlowNum(String value) {
        this.workFlowNum = value;
    }

}

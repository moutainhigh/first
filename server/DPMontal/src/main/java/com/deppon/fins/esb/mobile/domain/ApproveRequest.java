
package com.deppon.fins.esb.mobile.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * �������
 * 
 * <p>ApproveRequest complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ApproveRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="workflowid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="workItemId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="busino" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="approveResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="approveOption" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="empCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="empName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApproveRequest", propOrder = {
    "workflowid",
    "workItemId",
    "busino",
    "approveResult",
    "approveOption",
    "empCode",
    "empName"
})
public class ApproveRequest {

    @XmlElement(required = true)
    protected String workflowid;
    @XmlElement(required = true)
    protected String workItemId;
    @XmlElement(required = true)
    protected String busino;
    @XmlElement(required = true)
    protected String approveResult;
    @XmlElement(required = true)
    protected String approveOption;
    @XmlElement(required = true)
    protected String empCode;
    @XmlElement(required = true)
    protected String empName;
    
    public ApproveRequest(){}
    public ApproveRequest(String workflowid,String workItemId,String busino,String approveResult,String approveOption,String empCode,String empName){
    	this.workflowid = workflowid;
    	this.workItemId = workItemId;
    	this.busino = busino;
    	this.approveResult = approveResult;
    	this.approveOption = approveOption;
    	this.empCode = empCode;
    	this.empName = empName;
    }

    /**
     * ��ȡworkflowid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkflowid() {
        return workflowid;
    }

    /**
     * ����workflowid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkflowid(String value) {
        this.workflowid = value;
    }

    /**
     * ��ȡworkItemId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkItemId() {
        return workItemId;
    }

    /**
     * ����workItemId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkItemId(String value) {
        this.workItemId = value;
    }

    /**
     * ��ȡbusino���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusino() {
        return busino;
    }

    /**
     * ����busino���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusino(String value) {
        this.busino = value;
    }

    /**
     * ��ȡapproveResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproveResult() {
        return approveResult;
    }

    /**
     * ����approveResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproveResult(String value) {
        this.approveResult = value;
    }

    /**
     * ��ȡapproveOption���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproveOption() {
        return approveOption;
    }

    /**
     * ����approveOption���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproveOption(String value) {
        this.approveOption = value;
    }

    /**
     * ��ȡempCode���Ե�ֵ��
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
     * ����empCode���Ե�ֵ��
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
     * ��ȡempName���Ե�ֵ��
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
     * ����empName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpName(String value) {
        this.empName = value;
    }

}

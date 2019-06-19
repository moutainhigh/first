
package com.deppon.fins.esb.mobile.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  ��ʼ���������
 * 
 * <p>InitWorkFlowViewDataRequest complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="InitWorkFlowViewDataRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="workflowid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="busino" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "InitWorkFlowViewDataRequest", propOrder = {
    "workflowid",
    "busino",
    "empCode",
    "empName"
})
public class InitWorkFlowViewDataRequest {

    @XmlElement(required = true)
    protected String workflowid;
    @XmlElement(required = true)
    protected String busino;
    @XmlElement(required = true)
    protected String empCode;
    @XmlElement(required = true)
    protected String empName;
    
    public InitWorkFlowViewDataRequest(){}
    
    public InitWorkFlowViewDataRequest(String workflowid,String busino,String empCode,String empName){
    	this.workflowid = workflowid;
    	this.busino = busino;
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

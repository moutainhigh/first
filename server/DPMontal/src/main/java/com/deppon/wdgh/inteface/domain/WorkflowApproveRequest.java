
package com.deppon.wdgh.inteface.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <pre>
 * &lt;complexType name="WorkflowApproveRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="busino" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="processDefName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="approveOperateType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="approveOpinion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="approverCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="approverName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="workItemId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="processInstId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkflowApproveRequest", propOrder = {
    "busino",
    "processDefName",
    "approveOperateType",
    "approveOpinion",
    "approverCode",
    "approverName",
    "workItemId",
    "processInstId"
})
public class WorkflowApproveRequest {

    @XmlElement(required = true)
    protected String busino;
    @XmlElement(required = true)
    protected String processDefName;
    @XmlElement(required = true)
    protected String approveOperateType;
    @XmlElement(required = true)
    protected String approveOpinion;
    @XmlElement(required = true)
    protected String approverCode;
    @XmlElement(required = true)
    protected String approverName;
    @XmlElement(required = true)
    protected String workItemId;
    @XmlElement(required = true)
    protected String processInstId;
    
    public WorkflowApproveRequest(){}
    
    public WorkflowApproveRequest(String busino,String processDefName,String approveOperateType,
    		String approveOpinion,String approverCode,String approverName,String workItemId,String processInstId){
    	this.busino = busino;
    	this.processDefName = processDefName;
    	this.approveOperateType = approveOperateType;
    	this.approveOpinion = approveOpinion;
    	this.approverCode = approverCode;
    	this.approverName = approverName;
    	this.workItemId = workItemId;
    	this.processInstId = processInstId;
    }

    /**
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusino() {
        return busino;
    }

    /**
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusino(String value) {
        this.busino = value;
    }

    /**
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessDefName() {
        return processDefName;
    }

    /**
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessDefName(String value) {
        this.processDefName = value;
    }

    /**
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproveOperateType() {
        return approveOperateType;
    }

    /**
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproveOperateType(String value) {
        this.approveOperateType = value;
    }

    /**
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproveOpinion() {
        return approveOpinion;
    }

    /**
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproveOpinion(String value) {
        this.approveOpinion = value;
    }

    /**
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproverCode() {
        return approverCode;
    }

    /**
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproverCode(String value) {
        this.approverCode = value;
    }

    /**
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproverName() {
        return approverName;
    }

    /**
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproverName(String value) {
        this.approverName = value;
    }

    /**
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkItemId() {
        return workItemId;
    }

    /**
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkItemId(String value) {
        this.workItemId = value;
    }

    /**
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessInstId() {
        return processInstId;
    }

    /**
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessInstId(String value) {
        this.processInstId = value;
    }

}

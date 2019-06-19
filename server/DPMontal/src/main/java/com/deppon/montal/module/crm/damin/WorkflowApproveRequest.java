
package com.deppon.montal.module.crm.damin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 审批意见
 * 
 * <p>Java class for WorkflowApproveRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WorkflowApproveRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Busino" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="processDefName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="approveOperateType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="approveOpinion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="approverCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="workItemId" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="processInstId" type="{http://www.w3.org/2001/XMLSchema}float"/>
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
    "workItemId",
    "processInstId"
})
public class WorkflowApproveRequest {
	//业务单据号
    @XmlElement(name = "Busino", required = true)
    protected String busino;
    //流程定义名称
    @XmlElement(required = true)
    protected String processDefName;
    //决策
    @XmlElement(required = true)
    protected String approveOperateType;
    //审批意见
    @XmlElement(required = true)
    protected String approveOpinion;
    //审批人工号
    @XmlElement(required = true)
    protected String approverCode;
    //工作项ID
    protected double workItemId;
    //工作流号
    protected float processInstId;
    
    public WorkflowApproveRequest(){
    	
    }
    public WorkflowApproveRequest(String busino, String processDefName,
 			String approveOperateType, String approveOpinion,
 			String approverCode, double workItemId, float processInstId) {
 		super();
 		this.busino = busino;
 		this.processDefName = processDefName;
 		this.approveOperateType = approveOperateType;
 		this.approveOpinion = approveOpinion;
 		this.approverCode = approverCode;
 		this.workItemId = workItemId;
 		this.processInstId = processInstId;
 	}

    /**
     * Gets the value of the busino property.
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
     * Sets the value of the busino property.
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
     * Gets the value of the processDefName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessDefName() {
        return processDefName;
    }

    /**
     * Sets the value of the processDefName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessDefName(String value) {
        this.processDefName = value;
    }

    /**
     * Gets the value of the approveOperateType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproveOperateType() {
        return approveOperateType;
    }

    /**
     * Sets the value of the approveOperateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproveOperateType(String value) {
        this.approveOperateType = value;
    }

    /**
     * Gets the value of the approveOpinion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproveOpinion() {
        return approveOpinion;
    }

    /**
     * Sets the value of the approveOpinion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproveOpinion(String value) {
        this.approveOpinion = value;
    }

    /**
     * Gets the value of the approverCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproverCode() {
        return approverCode;
    }

    /**
     * Sets the value of the approverCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproverCode(String value) {
        this.approverCode = value;
    }

    /**
     * Gets the value of the workItemId property.
     * 
     */
    public double getWorkItemId() {
        return workItemId;
    }

    /**
     * Sets the value of the workItemId property.
     * 
     */
    public void setWorkItemId(double value) {
        this.workItemId = value;
    }

    /**
     * Gets the value of the processInstId property.
     * 
     */
    public float getProcessInstId() {
        return processInstId;
    }

    /**
     * Sets the value of the processInstId property.
     * 
     */
    public void setProcessInstId(float value) {
        this.processInstId = value;
    }

}

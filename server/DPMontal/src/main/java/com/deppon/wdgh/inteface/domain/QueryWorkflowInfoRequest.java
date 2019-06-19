
package com.deppon.wdgh.inteface.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <pre>
 * &lt;complexType name="QueryWorkflowInfoRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="busiNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="processDefName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="processInstId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="approverCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="approverName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QueryWorkflowInfoRequest", propOrder = {
    "busiNo",
    "processDefName",
    "processInstId",
    "approverCode",
    "approverName"
})
public class QueryWorkflowInfoRequest {

    @XmlElement(required = true)
    protected String busiNo;
    @XmlElement(required = true)
    protected String processDefName;
    protected int processInstId;
    @XmlElement(required = true)
    protected String approverCode;
    @XmlElement(required = true)
    protected String approverName;
    
    public QueryWorkflowInfoRequest(){}
    
    public QueryWorkflowInfoRequest(String busiNo,String processDefName,int processInstId,String approverCode,String approverName){
    	this.busiNo = busiNo;
    	this.processDefName = processDefName;
    	this.processInstId = processInstId;
    	this.approverCode = approverCode;
    	this.approverName = approverName;
    }

    /**
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusiNo() {
        return busiNo;
    }

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusiNo(String value) {
        this.busiNo = value;
    }

    /**
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
     * 
     */
    public int getProcessInstId() {
        return processInstId;
    }

    /**
     * 
     */
    public void setProcessInstId(int value) {
        this.processInstId = value;
    }

    /**
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
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproverName() {
        return approverName;
    }

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproverName(String value) {
        this.approverName = value;
    }

}

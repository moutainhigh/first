
package com.deppon.montal.module.crm.damin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for QueryWorkflowInfoRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QueryWorkflowInfoRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="busiNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="processDefName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="processInstId" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "QueryWorkflowInfoRequest", propOrder = {
    "busiNo",
    "processDefName",
    "processInstId",
    "empCode",
    "empName"
})
public class QueryWorkflowInfoRequest {

    @XmlElement(required = true)
    protected String busiNo;
    @XmlElement(required = true)
    protected String processDefName;
    protected int processInstId;
    @XmlElement(required = true)
    protected String empCode;
    @XmlElement(required = true)
    protected String empName;
    public QueryWorkflowInfoRequest(){
    	
    }
    
    public QueryWorkflowInfoRequest(String busiNo, String processDefName,
			int processInstId, String empCode, String empName) {
		this.busiNo = busiNo;
		this.processDefName = processDefName;
		this.processInstId = processInstId;
		this.empCode = empCode;
		this.empName = empName;
	}
    /**
     * Gets the value of the busiNo property.
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
     * Sets the value of the busiNo property.
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
     * Gets the value of the processInstId property.
     * 
     */
    public int getProcessInstId() {
        return processInstId;
    }

    /**
     * Sets the value of the processInstId property.
     * 
     */
    public void setProcessInstId(int value) {
        this.processInstId = value;
    }

    /**
     * Gets the value of the empCode property.
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
     * Sets the value of the empCode property.
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
     * Gets the value of the empName property.
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
     * Sets the value of the empName property.
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

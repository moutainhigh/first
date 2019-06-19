package com.deppon.dpm.module.acms.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SyncWorkflowinfoRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SyncWorkflowinfoRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="processDefName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="busino" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SyncWorkflowinfoRequest", propOrder = {
	"empCode",
	"empName",
    "processDefName",
    "busino",
    "processInstId"
})
public class SyncWorkflowinfoRequest {

	@XmlElement(required = true)
	protected String empCode;
	@XmlElement(required = true)
	protected String empName;
    @XmlElement(required = true)
    protected String processDefName;
    @XmlElement(required = true)
    protected String busino;
    @XmlElement(required = true)
    protected long processInstId;
    
    public SyncWorkflowinfoRequest() {
		super();
	}
	public SyncWorkflowinfoRequest(String empCode, String empName,
			String processDefName, String busino, long processInstId) {
		super();
		this.empCode = empCode;
		this.empName = empName;
		this.processDefName = processDefName;
		this.busino = busino;
		this.processInstId = processInstId;
	}
	/**
     * 
     * 
     * <pre>
     *
     * </pre>
     * @return
     */
    public String getEmpCode() {
		return empCode;
	}
    /**
     * 
     * 
     * <pre>
     *
     * </pre>
     * @param empCode
     */
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	/**
	 * 
	 * 
	 * <pre>
	 *
	 * </pre>
	 * @return
	 */
	public String getEmpName() {
		return empName;
	}
	/**
	 * 
	 * 
	 * <pre>
	 *
	 * </pre>
	 * @param empName
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
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
     * 
     * 
     * <pre>
     *
     * </pre>
     * @return
     */
	public long getProcessInstId() {
		return processInstId;
	}
	/**
	 * 
	 * 
	 * <pre>
	 *
	 * </pre>
	 * @param processInstId
	 */
	public void setProcessInstId(long processInstId) {
		this.processInstId = processInstId;
	}
}

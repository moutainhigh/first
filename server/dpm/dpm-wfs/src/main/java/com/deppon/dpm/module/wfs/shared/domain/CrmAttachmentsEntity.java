//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.5-2 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2014.08.11 时间 03:39:59 PM CST 
//


package com.deppon.dpm.module.wfs.shared.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>crmAttachmentsData complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="crmAttachmentsData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="workFlowId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="workFlowName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="attachmentsName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="savePath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "crmAttachmentsData", propOrder = {
    "workFlowId",
    "workFlowName",
    "attachmentsName",
    "savePath"
})
public class CrmAttachmentsEntity {

    protected String workFlowId;
    protected String workFlowName;
    protected String attachmentsName;
    protected String savePath;

    public CrmAttachmentsEntity(String workFlowId, String workFlowName,
			String attachmentsName, String savePath) {
		super();
		this.workFlowId = workFlowId;
		this.workFlowName = workFlowName;
		this.attachmentsName = attachmentsName;
		this.savePath = savePath;
	}

	public CrmAttachmentsEntity() {
		super();
	}

	/**
     * 获取workFlowId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkFlowId() {
		return workFlowId;
	}

	/**
     * 设置workFlowId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setWorkFlowId(String value) {
		this.workFlowId = value;
	}

    /**
     * 获取workFlowName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkFlowName() {
        return workFlowName;
    }

    /**
     * 设置workFlowName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkFlowName(String value) {
        this.workFlowName = value;
    }

    /**
     * 获取attachmentsName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttachmentsName() {
		return attachmentsName;
	}
    
    /**
     * 设置attachmentsName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttachmentsName(String value) {
		this.attachmentsName = value;
	}
    
    /**
     * 获取savePath属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getSavePath() {
		return savePath;
	}
	
	/**
     * 设置savePath属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setSavePath(String value) {
		this.savePath = value;
	}
	
}

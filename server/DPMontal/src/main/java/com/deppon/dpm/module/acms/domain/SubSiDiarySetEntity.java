package com.deppon.dpm.module.acms.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SubSiDiarySetEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubSiDiarySetEntity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="applyCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="subCompany" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="area" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="financeDep" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="compenSation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="matterTeam" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="updateType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="changeBefore" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="changeAfter" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reason" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fileList" type="{http://www.deppon.com/acms/inteface/workflow/domain}Attachment" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="approveList" type="{http://www.deppon.com/acms/inteface/workflow/domain}ApproveEntity" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubSiDiarySetEntity", propOrder = {
    "applyCode",
    "applyName",
    "type",
    "subCompany",
    "area",
    "financeDep",
    "compenSation",
    "matterTeam",
    "updateType",
    "changeBefore",
    "changeAfter",
    "reason",
    "fileList",
    "approveList"
})
public class SubSiDiarySetEntity {
	//申请人工号
    @XmlElement(required = true)
    protected String applyCode;
    //申请人
    @XmlElement(required = true)
    protected String applyName;
    //申请类别
    @XmlElement(required = true)
    protected String type;
    //子公司名称
    @XmlElement(required = true)
    protected String subCompany;
    //所属区域
    @XmlElement(required = true)
    protected String area;
    //所属财务部
    @XmlElement(required = true)
    protected String financeDep;
    //所属公共事务组
    @XmlElement(required = true)
    protected String compenSation;
    //所属薪酬组
    @XmlElement(required = true)
    protected String matterTeam;
    //修改类型
    @XmlElement(required = true)
    protected String updateType;
    
        
    //变更前内容
    @XmlElement(required = true)
    protected String changeBefore;
    //变更后内容
    @XmlElement(required = true)
    protected String changeAfter;
    
    //申请事由
    @XmlElement(required = true)
    protected String reason;
    //附件
    protected List<Attachment> fileList;
    //审批意见
    @XmlElement(required = true)
    protected List<ApproveEntity> approveList;

    /**
     * Gets the value of the applyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyCode() {
        return applyCode;
    }

    /**
     * Sets the value of the applyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyCode(String value) {
        this.applyCode = value;
    }

    /**
     * Gets the value of the applyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyName() {
        return applyName;
    }

    /**
     * Sets the value of the applyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyName(String value) {
        this.applyName = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the subCompany property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubCompany() {
        return subCompany;
    }

    /**
     * Sets the value of the subCompany property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubCompany(String value) {
        this.subCompany = value;
    }

    /**
     * Gets the value of the area property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArea() {
        return area;
    }

    /**
     * Sets the value of the area property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArea(String value) {
        this.area = value;
    }

    /**
     * Gets the value of the financeDep property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinanceDep() {
        return financeDep;
    }

    /**
     * Sets the value of the financeDep property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinanceDep(String value) {
        this.financeDep = value;
    }

    /**
     * Gets the value of the compenSation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompenSation() {
        return compenSation;
    }

    /**
     * Sets the value of the compenSation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompenSation(String value) {
        this.compenSation = value;
    }

    /**
     * Gets the value of the matterTeam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatterTeam() {
        return matterTeam;
    }

    /**
     * Sets the value of the matterTeam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatterTeam(String value) {
        this.matterTeam = value;
    }

    /**
     * Gets the value of the updateType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdateType() {
        return updateType;
    }

    /**
     * Sets the value of the updateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdateType(String value) {
        this.updateType = value;
    }
    /**
     * Gets the value of the changeBefore property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChangeBefore() {
		return changeBefore;
	}
    /**
     * Sets the value of the changeBefore property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setChangeBefore(String changeBefore) {
		this.changeBefore = changeBefore;
	}
	 /**
     * Gets the value of the changeAfter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getChangeAfter() {
		return changeAfter;
	}
	  /**
     * Sets the value of the changeAfter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setChangeAfter(String changeAfter) {
		this.changeAfter = changeAfter;
	}

	/**
     * Gets the value of the reason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets the value of the reason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReason(String value) {
        this.reason = value;
    }

    /**
     * Gets the value of the fileList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fileList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFileList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Attachment }
     * 
     * 
     */
    public List<Attachment> getFileList() {
        if (fileList == null) {
            fileList = new ArrayList<Attachment>();
        }
        return this.fileList;
    }
    /**
     * 
     * 
     * <pre>
     *
     * </pre>
     * @param fileList
     */
    public void setFileList(List<Attachment> fileList) {
    	this.fileList = fileList;
    }
    /**
     * Gets the value of the approveList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the approveList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApproveList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ApproveEntity }
     * 
     * 
     */
    public List<ApproveEntity> getApproveList() {
        if (approveList == null) {
            approveList = new ArrayList<ApproveEntity>();
        }
        return this.approveList;
    }
	/**
     * 
     * 
     * <pre>
     *
     * </pre>
     * @param approveList
     */
	public void setApproveList(List<ApproveEntity> approveList) {
		this.approveList = approveList;
	}
}

package com.deppon.dpm.module.acms.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * ��˾����
 * 
 * <p>Java class for CompanyFillChangeEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CompanyFillChangeEntity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="applyType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applyCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="companyType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="companyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="salesDeptName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="changeType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="licenseType" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "CompanyFillChangeEntity", propOrder = {
    "applyType",
    "applyCode",
    "applyName",
    "companyType",
    "companyName",
    "salesDeptName",
    "changeType",
    "licenseType",
    "changeBefore",
    "changeAfter",
    "reason",
    "fileList",
    "approveList"
})
public class CompanyFillChangeEntity {

	//申请类型
    @XmlElement(required = true)
    protected String applyType;
    //申请人工号
    @XmlElement(required = true)
    protected String applyCode;
    //申请人
    @XmlElement(required = true)
    protected String applyName;
    //公司类型
    @XmlElement(required = true)
    protected String companyType;
    //公司名称
    @XmlElement(required = true)
    protected String companyName;
    //营业部名称
    @XmlElement(required = true)
    protected String salesDeptName;
    //变更类型
    @XmlElement(required = true)
    protected String changeType;
    //补办证照
    @XmlElement(required = true)
    protected String licenseType;
    //修改之前
    @XmlElement(required = true)
    protected String changeBefore;
    //修改之后
    @XmlElement(required = true)
    protected String changeAfter;
    //申请事由
    @XmlElement(required = true)
    protected String reason;
    //附件
    protected List<Attachment> fileList;
    //审批记录
    @XmlElement(required = true)
    protected List<ApproveEntity> approveList;

    /**
     * Gets the value of the applyType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyType() {
        return applyType;
    }

    /**
     * Sets the value of the applyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyType(String value) {
        this.applyType = value;
    }

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
     * Gets the value of the companyType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyType() {
        return companyType;
    }

    /**
     * Sets the value of the companyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyType(String value) {
        this.companyType = value;
    }

    /**
     * Gets the value of the companyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets the value of the companyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyName(String value) {
        this.companyName = value;
    }

    /**
     * Gets the value of the salesDeptName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSalesDeptName() {
        return salesDeptName;
    }

    /**
     * Sets the value of the salesDeptName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSalesDeptName(String value) {
        this.salesDeptName = value;
    }

    /**
     * Gets the value of the changeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChangeType() {
        return changeType;
    }

    /**
     * Sets the value of the changeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChangeType(String value) {
        this.changeType = value;
    }

    /**
     * Gets the value of the licenseType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicenseType() {
        return licenseType;
    }

    /**
     * Sets the value of the licenseType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicenseType(String value) {
        this.licenseType = value;
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
    public void setChangeBefore(String value) {
        this.changeBefore = value;
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
    public void setChangeAfter(String value) {
        this.changeAfter = value;
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

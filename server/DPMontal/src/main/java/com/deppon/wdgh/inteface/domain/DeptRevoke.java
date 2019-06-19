
package com.deppon.wdgh.inteface.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>deptRevoke complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="deptRevoke">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createUserName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="createPostion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="createOrgName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reversedDeptName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reversedTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="businessDivsionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="personnelDepartmentCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="financeDeptCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="permanentAssetsOffice" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="businessLicenseName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="businessLicenseNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="taxregNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="taxregIssueDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="contractStartTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="contractEndTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="stallPledgeAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="transferFee" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="latestRentTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="latestRentAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="outstandingFees" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="workflowNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isIndependentAccout" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reason" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deptRevoke", propOrder = {
    "createUserName",
    "createPostion",
    "createOrgName",
    "reversedDeptName",
    "reversedTime",
    "businessDivsionCode",
    "personnelDepartmentCode",
    "financeDeptCode",
    "permanentAssetsOffice",
    "businessLicenseName",
    "businessLicenseNo",
    "taxregNo",
    "taxregIssueDate",
    "contractStartTime",
    "contractEndTime",
    "stallPledgeAmount",
    "transferFee",
    "latestRentTime",
    "latestRentAmount",
    "outstandingFees",
    "workflowNo",
    "isIndependentAccout",
    "reason"
})
public class DeptRevoke {

    @XmlElement(required = true)
    protected String createUserName;
    @XmlElement(required = true)
    protected String createPostion;
    @XmlElement(required = true)
    protected String createOrgName;
    @XmlElement(required = true)
    protected String reversedDeptName;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar reversedTime;
    @XmlElement(required = true)
    protected String businessDivsionCode;
    @XmlElement(required = true)
    protected String personnelDepartmentCode;
    @XmlElement(required = true)
    protected String financeDeptCode;
    @XmlElement(required = true)
    protected String permanentAssetsOffice;
    @XmlElement(required = true)
    protected String businessLicenseName;
    @XmlElement(required = true)
    protected String businessLicenseNo;
    @XmlElement(required = true)
    protected String taxregNo;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar taxregIssueDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar contractStartTime;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar contractEndTime;
    protected double stallPledgeAmount;
    protected double transferFee;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar latestRentTime;
    protected double latestRentAmount;
    protected double outstandingFees;
    @XmlElement(required = true)
    protected String workflowNo;
    @XmlElement(required = true)
    protected String isIndependentAccout;
    @XmlElement(required = true)
    protected String reason;

    /**
     * 获取createUserName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 设置createUserName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateUserName(String value) {
        this.createUserName = value;
    }

    /**
     * 获取createPostion属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatePostion() {
        return createPostion;
    }

    /**
     * 设置createPostion属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatePostion(String value) {
        this.createPostion = value;
    }

    /**
     * 获取createOrgName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateOrgName() {
        return createOrgName;
    }

    /**
     * 设置createOrgName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateOrgName(String value) {
        this.createOrgName = value;
    }

    /**
     * 获取reversedDeptName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReversedDeptName() {
        return reversedDeptName;
    }

    /**
     * 设置reversedDeptName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReversedDeptName(String value) {
        this.reversedDeptName = value;
    }

    /**
     * 获取reversedTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReversedTime() {
        return reversedTime;
    }

    /**
     * 设置reversedTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReversedTime(XMLGregorianCalendar value) {
        this.reversedTime = value;
    }

    /**
     * 获取businessDivsionCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessDivsionCode() {
        return businessDivsionCode;
    }

    /**
     * 设置businessDivsionCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessDivsionCode(String value) {
        this.businessDivsionCode = value;
    }

    /**
     * 获取personnelDepartmentCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonnelDepartmentCode() {
        return personnelDepartmentCode;
    }

    /**
     * 设置personnelDepartmentCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonnelDepartmentCode(String value) {
        this.personnelDepartmentCode = value;
    }

    /**
     * 获取financeDeptCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinanceDeptCode() {
        return financeDeptCode;
    }

    /**
     * 设置financeDeptCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinanceDeptCode(String value) {
        this.financeDeptCode = value;
    }

    /**
     * 获取permanentAssetsOffice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPermanentAssetsOffice() {
        return permanentAssetsOffice;
    }

    /**
     * 设置permanentAssetsOffice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPermanentAssetsOffice(String value) {
        this.permanentAssetsOffice = value;
    }

    /**
     * 获取businessLicenseName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessLicenseName() {
        return businessLicenseName;
    }

    /**
     * 设置businessLicenseName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessLicenseName(String value) {
        this.businessLicenseName = value;
    }

    /**
     * 获取businessLicenseNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessLicenseNo() {
        return businessLicenseNo;
    }

    /**
     * 设置businessLicenseNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessLicenseNo(String value) {
        this.businessLicenseNo = value;
    }

    /**
     * 获取taxregNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxregNo() {
        return taxregNo;
    }

    /**
     * 设置taxregNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxregNo(String value) {
        this.taxregNo = value;
    }

    /**
     * 获取taxregIssueDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTaxregIssueDate() {
        return taxregIssueDate;
    }

    /**
     * 设置taxregIssueDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTaxregIssueDate(XMLGregorianCalendar value) {
        this.taxregIssueDate = value;
    }

    /**
     * 获取contractStartTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getContractStartTime() {
        return contractStartTime;
    }

    /**
     * 设置contractStartTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setContractStartTime(XMLGregorianCalendar value) {
        this.contractStartTime = value;
    }

    /**
     * 获取contractEndTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getContractEndTime() {
        return contractEndTime;
    }

    /**
     * 设置contractEndTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setContractEndTime(XMLGregorianCalendar value) {
        this.contractEndTime = value;
    }

    /**
     * 获取stallPledgeAmount属性的值。
     * 
     */
    public double getStallPledgeAmount() {
        return stallPledgeAmount;
    }

    /**
     * 设置stallPledgeAmount属性的值。
     * 
     */
    public void setStallPledgeAmount(double value) {
        this.stallPledgeAmount = value;
    }

    /**
     * 获取transferFee属性的值。
     * 
     */
    public double getTransferFee() {
        return transferFee;
    }

    /**
     * 设置transferFee属性的值。
     * 
     */
    public void setTransferFee(double value) {
        this.transferFee = value;
    }

    /**
     * 获取latestRentTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLatestRentTime() {
        return latestRentTime;
    }

    /**
     * 设置latestRentTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLatestRentTime(XMLGregorianCalendar value) {
        this.latestRentTime = value;
    }

    /**
     * 获取latestRentAmount属性的值。
     * 
     */
    public double getLatestRentAmount() {
        return latestRentAmount;
    }

    /**
     * 设置latestRentAmount属性的值。
     * 
     */
    public void setLatestRentAmount(double value) {
        this.latestRentAmount = value;
    }

    /**
     * 获取outstandingFees属性的值。
     * 
     */
    public double getOutstandingFees() {
        return outstandingFees;
    }

    /**
     * 设置outstandingFees属性的值。
     * 
     */
    public void setOutstandingFees(double value) {
        this.outstandingFees = value;
    }

    /**
     * 获取workflowNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkflowNo() {
        return workflowNo;
    }

    /**
     * 设置workflowNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkflowNo(String value) {
        this.workflowNo = value;
    }

    /**
     * 获取isIndependentAccout属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsIndependentAccout() {
        return isIndependentAccout;
    }

    /**
     * 设置isIndependentAccout属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsIndependentAccout(String value) {
        this.isIndependentAccout = value;
    }

    /**
     * 获取reason属性的值。
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
     * 设置reason属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReason(String value) {
        this.reason = value;
    }
}
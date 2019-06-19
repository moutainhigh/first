
package com.deppon.wdgh.inteface.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <pre>
 * &lt;complexType name="NewPointInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createUserName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="createOrgName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isSingledeptCity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rentcontractWorkflowno" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newDeptWorkflowNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newDeptName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="processingTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="contractStartTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="contractEndTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="businessDivsionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="personnelDepartmentCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="materialReleaseOffice" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="materialReleaseDest" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="regionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lmsProjectNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reason" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 新点信息提交申请
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NewPointInfo", propOrder = {
    "createUserName",
    "createOrgName",
    "isSingledeptCity",
    "rentcontractWorkflowno",
    "newDeptWorkflowNo",
    "newDeptName",
    "processingTime",
    "contractStartTime",
    "contractEndTime",
    "businessDivsionCode",
    "personnelDepartmentCode",
    "materialReleaseOffice",
    "materialReleaseDest",
    "regionCode",
    "lmsProjectNo",
    "reason"
})
public class NewPointInfo {

	//申请人姓名
    @XmlElement(required = true)
    protected String createUserName;
    //申请人所在部门
    @XmlElement(required = true)
    protected String createOrgName;
    //是否单点城市
    @XmlElement(required = true)
    protected String isSingledeptCity;
    //商铺租赁合同工作流号
    @XmlElement(required = true)
    protected String rentcontractWorkflowno;
    //新点开设申请工作流号
    @XmlElement(required = true)
    protected String newDeptWorkflowNo;
    //新营业部名称
    @XmlElement(required = true)
    protected String newDeptName;
    //办证时间
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar processingTime;
    //合同开始时间
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar contractStartTime;
    //合同结束时间
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar contractEndTime;
    //所属事业部
    @XmlElement(required = true)
    protected String businessDivsionCode;
    //所属人事部
    @XmlElement(required = true)
    protected String personnelDepartmentCode;
    //物料发放办公室
    @XmlElement(required = true)
    protected String materialReleaseOffice;
    //物料目的发放站
    @XmlElement(required = true)
    protected String materialReleaseDest;
    //区域
    @XmlElement(required = true)
    protected String regionCode;
    //LMS工程项目编号
    @XmlElement(required = true)
    protected String lmsProjectNo;
    //申请事由
    @XmlElement(required = true)
    protected String reason;

    /**
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
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsSingledeptCity() {
        return isSingledeptCity;
    }

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsSingledeptCity(String value) {
        this.isSingledeptCity = value;
    }

    /**
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRentcontractWorkflowno() {
        return rentcontractWorkflowno;
    }

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRentcontractWorkflowno(String value) {
        this.rentcontractWorkflowno = value;
    }

    /**
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewDeptWorkflowNo() {
        return newDeptWorkflowNo;
    }

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewDeptWorkflowNo(String value) {
        this.newDeptWorkflowNo = value;
    }

    /**
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewDeptName() {
        return newDeptName;
    }

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewDeptName(String value) {
        this.newDeptName = value;
    }

    /**
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getProcessingTime() {
        return processingTime;
    }

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setProcessingTime(XMLGregorianCalendar value) {
        this.processingTime = value;
    }

    /**
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
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaterialReleaseOffice() {
        return materialReleaseOffice;
    }

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaterialReleaseOffice(String value) {
        this.materialReleaseOffice = value;
    }

    /**
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaterialReleaseDest() {
        return materialReleaseDest;
    }

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaterialReleaseDest(String value) {
        this.materialReleaseDest = value;
    }

    /**
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegionCode() {
        return regionCode;
    }

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegionCode(String value) {
        this.regionCode = value;
    }

    /**
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLmsProjectNo() {
        return lmsProjectNo;
    }

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLmsProjectNo(String value) {
        this.lmsProjectNo = value;
    }

    /**
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

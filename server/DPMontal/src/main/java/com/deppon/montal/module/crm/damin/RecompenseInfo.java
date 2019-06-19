
package com.deppon.montal.module.crm.damin;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import com.deppon.montal.util.FormatUtil;


/**
 * <p>Java class for RecompenseInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RecompenseInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="transportOrErrorCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="haulType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="startingStation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="insuredUnits" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contactPhone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="receivingDept" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="goodsName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="goodsAttribute" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="insuredAmount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="targetDept" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sendingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="dangerDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="area" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="claimsType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="offsetType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="caseReporterName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reportDeptName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reportDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="handler" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="handleDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="claimAmount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="normalAmount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="actualClaimsAmount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="toCompanyCost" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IssueItemDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ResponsibleDept" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="otherCost" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="awardItems" type="{http://www.deppon.com/crm/inteface/dpm/domain/}AwardItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="deptCharges" type="{http://www.deppon.com/crm/inteface/dpm/domain/}DeptCharge" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecompenseInfo", propOrder = {
    "transportOrErrorCode",
    "haulType",
    "startingStation",
    "insuredUnits",
    "contactPhone",
    "receivingDept",
    "goodsName",
    "goodsAttribute",
    "insuredAmount",
    "targetDept",
    "sendingDate",
    "dangerDate",
    "area",
    "claimsType",
    "offsetType",
    "caseReporterName",
    "reportDeptName",
    "reportDate",
    "handler",
    "handleDate",
    "claimAmount",
    "normalAmount",
    "actualClaimsAmount",
    "toCompanyCost",
    "issueItemDesc",
    "responsibleDept",
    "otherCost",
    "awardItems",
    "deptCharges"
})
public class RecompenseInfo {

    @XmlElement(required = true)
    protected String transportOrErrorCode;
    @XmlElement(required = true)
    protected String haulType;
    @XmlElement(required = true)
    protected String startingStation;
    @XmlElement(required = true)
    protected String insuredUnits;
    @XmlElement(required = true)
    protected String contactPhone;
    @XmlElement(required = true)
    protected String receivingDept;
    @XmlElement(required = true)
    protected String goodsName;
    @XmlElement(required = true)
    protected String goodsAttribute;
    @XmlElement(required = true)
    protected String insuredAmount;
    @XmlElement(required = true)
    protected String targetDept;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar sendingDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dangerDate;
    @XmlElement(required = true)
    protected String area;
    @XmlElement(required = true)
    protected String claimsType;
    @XmlElement(required = true)
    protected String offsetType;
    @XmlElement(required = true)
    protected String caseReporterName;
    @XmlElement(required = true)
    protected String reportDeptName;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar reportDate;
    @XmlElement(required = true)
    protected String handler;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar handleDate;
    @XmlElement(required = true)
    protected String claimAmount;
    @XmlElement(required = true)
    protected String normalAmount;
    @XmlElement(required = true)
    protected String actualClaimsAmount;
    @XmlElement(required = true)
    protected String toCompanyCost;
    @XmlElement(name = "IssueItemDesc", required = true)
    protected String issueItemDesc;
    @XmlElement(name = "ResponsibleDept", required = true)
    protected String responsibleDept;
    //费用说明
    @XmlElement(required = true)
    protected String otherCost;
    protected List<AwardItem> awardItems;
    protected List<DeptCharge> deptCharges;

    /**
     * Gets the value of the transportOrErrorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransportOrErrorCode() {
        return transportOrErrorCode;
    }

    /**
     * Sets the value of the transportOrErrorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransportOrErrorCode(String value) {
        this.transportOrErrorCode = value;
    }

    /**
     * Gets the value of the haulType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHaulType() {
        return haulType;
    }

    /**
     * Sets the value of the haulType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHaulType(String value) {
        this.haulType = value;
    }

    /**
     * Gets the value of the startingStation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartingStation() {
        return startingStation;
    }

    /**
     * Sets the value of the startingStation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartingStation(String value) {
        this.startingStation = value;
    }

    /**
     * Gets the value of the insuredUnits property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInsuredUnits() {
        return insuredUnits;
    }

    /**
     * Sets the value of the insuredUnits property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInsuredUnits(String value) {
        this.insuredUnits = value;
    }

    /**
     * Gets the value of the contactPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * Sets the value of the contactPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactPhone(String value) {
        this.contactPhone = value;
    }

    /**
     * Gets the value of the receivingDept property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceivingDept() {
        return receivingDept;
    }

    /**
     * Sets the value of the receivingDept property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceivingDept(String value) {
        this.receivingDept = value;
    }

    /**
     * Gets the value of the goodsName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * Sets the value of the goodsName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGoodsName(String value) {
        this.goodsName = value;
    }

    /**
     * Gets the value of the goodsAttribute property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGoodsAttribute() {
        return goodsAttribute;
    }

    /**
     * Sets the value of the goodsAttribute property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGoodsAttribute(String value) {
        this.goodsAttribute = value;
    }

    /**
     * Gets the value of the insuredAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInsuredAmount() {
        return insuredAmount;
    }

    /**
     * Sets the value of the insuredAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInsuredAmount(String value) {
        this.insuredAmount = value;
    }

    /**
     * Gets the value of the targetDept property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetDept() {
        return targetDept;
    }

    /**
     * Sets the value of the targetDept property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetDept(String value) {
        this.targetDept = value;
    }

    /**
     * Gets the value of the sendingDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSendingDate() {
        return sendingDate;
    }
    
    public String getSendingDateStr(){
    	return FormatUtil.formatDate(sendingDate,"yyyy-MM-dd");
    }

    /**
     * Sets the value of the sendingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSendingDate(XMLGregorianCalendar value) {
        this.sendingDate = value;
    }

    /**
     * Gets the value of the dangerDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDangerDate() {
        return dangerDate;
    }
    
    public String getDangerDateStr() {
        return FormatUtil.formatDate(dangerDate,"yyyy-MM-dd");
    }

    /**
     * Sets the value of the dangerDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDangerDate(XMLGregorianCalendar value) {
        this.dangerDate = value;
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
     * Gets the value of the claimsType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaimsType() {
        return claimsType;
    }

    /**
     * Sets the value of the claimsType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaimsType(String value) {
        this.claimsType = value;
    }

    /**
     * Gets the value of the offsetType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOffsetType() {
        return offsetType;
    }

    /**
     * Sets the value of the offsetType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOffsetType(String value) {
        this.offsetType = value;
    }

    /**
     * Gets the value of the caseReporterName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseReporterName() {
        return caseReporterName;
    }

    /**
     * Sets the value of the caseReporterName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseReporterName(String value) {
        this.caseReporterName = value;
    }

    /**
     * Gets the value of the reportDeptName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportDeptName() {
        return reportDeptName;
    }

    /**
     * Sets the value of the reportDeptName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportDeptName(String value) {
        this.reportDeptName = value;
    }

    /**
     * Gets the value of the reportDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReportDate() {
        return reportDate;
    }

    public String getReportDateStr(){
    	return FormatUtil.formatDate(reportDate,"yyyy-MM-dd HH:mm:ss");
    }
    
    /**
     * Sets the value of the reportDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReportDate(XMLGregorianCalendar value) {
        this.reportDate = value;
    }

    /**
     * Gets the value of the handler property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHandler() {
        return handler;
    }

    /**
     * Sets the value of the handler property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHandler(String value) {
        this.handler = value;
    }

    /**
     * Gets the value of the handleDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getHandleDate() {
        return handleDate;
    }
    
    public String getHandleDateStr(){
    	return FormatUtil.formatDate(handleDate,"yyyy-MM-dd HH:mm:ss");
    }

    /**
     * Sets the value of the handleDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setHandleDate(XMLGregorianCalendar value) {
        this.handleDate = value;
    }

    /**
     * Gets the value of the claimAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaimAmount() {
        return claimAmount;
    }

    /**
     * Sets the value of the claimAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaimAmount(String value) {
        this.claimAmount = value;
    }

    /**
     * Gets the value of the normalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNormalAmount() {
        return normalAmount;
    }

    /**
     * Sets the value of the normalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNormalAmount(String value) {
        this.normalAmount = value;
    }

    /**
     * Gets the value of the actualClaimsAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActualClaimsAmount() {
        return actualClaimsAmount;
    }

    /**
     * Sets the value of the actualClaimsAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActualClaimsAmount(String value) {
        this.actualClaimsAmount = value;
    }

    /**
     * Gets the value of the toCompanyCost property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToCompanyCost() {
        return toCompanyCost;
    }
    
    /**
     * Sets the value of the toCompanyCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToCompanyCost(String value) {
        this.toCompanyCost = value;
    }

    /**
     * Gets the value of the issueItemDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssueItemDesc() {
        return issueItemDesc;
    }

    /**
     * Sets the value of the issueItemDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssueItemDesc(String value) {
        this.issueItemDesc = value;
    }

    /**
     * Gets the value of the responsibleDept property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponsibleDept() {
        return responsibleDept;
    }

    /**
     * Sets the value of the responsibleDept property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponsibleDept(String value) {
        this.responsibleDept = value;
    }

    /**
     * Gets the value of the otherCost property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtherCost() {
        return otherCost;
    }

    /**
     * Sets the value of the otherCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtherCost(String value) {
        this.otherCost = value;
    }
    
    /**
     * Gets the value of the awardItems property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the awardItems property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAwardItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AwardItem }
     * 
     * 
     */
    public List<AwardItem> getAwardItems() {
        if (awardItems == null) {
            awardItems = new ArrayList<AwardItem>();
        }
        return this.awardItems;
    }

    /**
     * Gets the value of the deptCharges property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deptCharges property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeptCharges().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DeptCharge }
     * 
     * 
     */
    public List<DeptCharge> getDeptCharges() {
        if (deptCharges == null) {
            deptCharges = new ArrayList<DeptCharge>();
        }
        return this.deptCharges;
    }

}

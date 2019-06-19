
package com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for planDesignEntryEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="planDesignEntryEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}baseEntity">
 *       &lt;sequence>
 *         &lt;element name="cfalreadyShipment" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="cfappbalance" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="cfapplyReasons" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfattribute" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfbatchNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfcarModel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfclothingType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfconfigurationNumber" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="cfcontact" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfdeparproper" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfdepartmentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfentryTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="cfexportNumber" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="cfgender" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfgongHaowuId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfissueTyep" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfissueconArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cflicenceType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfmaterialName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfmaterialNum" type="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}materialEntity" minOccurs="0"/>
 *         &lt;element name="cfmaterialNumId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfmaterialTypes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfnames" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cforiginalPostName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfoutBoundNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfpostNameId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfpurorderunit" type="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}purChaseInfo" minOccurs="0"/>
 *         &lt;element name="cfpurorderunitid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfquantity" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="cfreferenceAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="cfreferencePrice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="cfregistrationLoan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfregistrationSites" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfrelationMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfremake" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfscrapApplication" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfsecurityContacti" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfshouldPlace" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="cfsignAmount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="cfspecifications" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfstartingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="cfsubordinateDivis" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfteamcontactId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfunit" type="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}measureUnit" minOccurs="0"/>
 *         &lt;element name="cfunitId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfuseDepartment" type="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}adminOrgUnit" minOccurs="0"/>
 *         &lt;element name="cfuseDepartmentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ffactNumber" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="fid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fmaterialMent" type="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}materialAttEntity" minOccurs="0"/>
 *         &lt;element name="fmaterialMentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fparentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fparentNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fprojectBudget" type="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}budgeItemsEntity" minOccurs="0"/>
 *         &lt;element name="fprojectBudgetId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fseq" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ftransferNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "planDesignEntryEntity", propOrder = {
    "cfalreadyShipment",
    "cfappbalance",
    "cfapplyReasons",
    "cfattribute",
    "cfbatchNum",
    "cfcarModel",
    "cfclothingType",
    "cfconfigurationNumber",
    "cfcontact",
    "cfdeparproper",
    "cfdepartmentId",
    "cfentryTime",
    "cfexportNumber",
    "cfgender",
    "cfgongHaowuId",
    "cfissueTyep",
    "cfissueconArea",
    "cflicenceType",
    "cfmaterialName",
    "cfmaterialNum",
    "cfmaterialNumId",
    "cfmaterialTypes",
    "cfnames",
    "cforiginalPostName",
    "cfoutBoundNum",
    "cfpostNameId",
    "cfpurorderunit",
    "cfpurorderunitid",
    "cfquantity",
    "cfreferenceAmount",
    "cfreferencePrice",
    "cfregistrationLoan",
    "cfregistrationSites",
    "cfrelationMethod",
    "cfremake",
    "cfscrapApplication",
    "cfsecurityContacti",
    "cfshouldPlace",
    "cfsignAmount",
    "cfspecifications",
    "cfstartingDate",
    "cfsubordinateDivis",
    "cfteamcontactId",
    "cfunit",
    "cfunitId",
    "cfuseDepartment",
    "cfuseDepartmentId",
    "ffactNumber",
    "fid",
    "fmaterialMent",
    "fmaterialMentId",
    "fparentId",
    "fparentNumber",
    "fprojectBudget",
    "fprojectBudgetId",
    "fseq",
    "ftransferNum"
})
public class PlanDesignEntryEntity
    extends BaseEntity
{

    protected Long cfalreadyShipment;
    protected Long cfappbalance;
    protected String cfapplyReasons;
    protected String cfattribute;
    protected String cfbatchNum;
    protected String cfcarModel;
    protected String cfclothingType;
    protected Long cfconfigurationNumber;
    protected String cfcontact;
    protected String cfdeparproper;
    protected String cfdepartmentId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar cfentryTime;
    protected Long cfexportNumber;
    protected String cfgender;
    protected String cfgongHaowuId;
    protected String cfissueTyep;
    protected String cfissueconArea;
    protected String cflicenceType;
    protected String cfmaterialName;
    protected MaterialEntity cfmaterialNum;
    protected String cfmaterialNumId;
    protected String cfmaterialTypes;
    protected String cfnames;
    protected String cforiginalPostName;
    protected String cfoutBoundNum;
    protected String cfpostNameId;
    protected PurChaseInfo cfpurorderunit;
    protected String cfpurorderunitid;
    protected BigDecimal cfquantity;
    protected BigDecimal cfreferenceAmount;
    protected BigDecimal cfreferencePrice;
    protected String cfregistrationLoan;
    protected String cfregistrationSites;
    protected String cfrelationMethod;
    protected String cfremake;
    protected String cfscrapApplication;
    protected String cfsecurityContacti;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar cfshouldPlace;
    protected Long cfsignAmount;
    protected String cfspecifications;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar cfstartingDate;
    protected String cfsubordinateDivis;
    protected String cfteamcontactId;
    protected MeasureUnit cfunit;
    protected String cfunitId;
    protected AdminOrgUnit cfuseDepartment;
    protected String cfuseDepartmentId;
    protected Long ffactNumber;
    protected String fid;
    protected MaterialAttEntity fmaterialMent;
    protected String fmaterialMentId;
    protected String fparentId;
    protected String fparentNumber;
    protected BudgeItemsEntity fprojectBudget;
    protected String fprojectBudgetId;
    protected Long fseq;
    protected Long ftransferNum;

    /**
     * Gets the value of the cfalreadyShipment property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCfalreadyShipment() {
        return cfalreadyShipment;
    }

    /**
     * Sets the value of the cfalreadyShipment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCfalreadyShipment(Long value) {
        this.cfalreadyShipment = value;
    }

    /**
     * Gets the value of the cfappbalance property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCfappbalance() {
        return cfappbalance;
    }

    /**
     * Sets the value of the cfappbalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCfappbalance(Long value) {
        this.cfappbalance = value;
    }

    /**
     * Gets the value of the cfapplyReasons property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfapplyReasons() {
        return cfapplyReasons;
    }

    /**
     * Sets the value of the cfapplyReasons property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfapplyReasons(String value) {
        this.cfapplyReasons = value;
    }

    /**
     * Gets the value of the cfattribute property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfattribute() {
        return cfattribute == null ? "" : cfattribute;
    }

    /**
     * Sets the value of the cfattribute property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfattribute(String value) {
        this.cfattribute = value;
    }

    /**
     * Gets the value of the cfbatchNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfbatchNum() {
        return cfbatchNum;
    }

    /**
     * Sets the value of the cfbatchNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfbatchNum(String value) {
        this.cfbatchNum = value;
    }

    /**
     * Gets the value of the cfcarModel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfcarModel() {
        return cfcarModel;
    }

    /**
     * Sets the value of the cfcarModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfcarModel(String value) {
        this.cfcarModel = value;
    }

    /**
     * Gets the value of the cfclothingType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfclothingType() {
        return cfclothingType;
    }

    /**
     * Sets the value of the cfclothingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfclothingType(String value) {
        this.cfclothingType = value;
    }

    /**
     * Gets the value of the cfconfigurationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCfconfigurationNumber() {
        return cfconfigurationNumber;
    }

    /**
     * Sets the value of the cfconfigurationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCfconfigurationNumber(Long value) {
        this.cfconfigurationNumber = value;
    }

    /**
     * Gets the value of the cfcontact property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfcontact() {
        return cfcontact;
    }

    /**
     * Sets the value of the cfcontact property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfcontact(String value) {
        this.cfcontact = value;
    }

    /**
     * Gets the value of the cfdeparproper property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfdeparproper() {
        return cfdeparproper;
    }

    /**
     * Sets the value of the cfdeparproper property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfdeparproper(String value) {
        this.cfdeparproper = value;
    }

    /**
     * Gets the value of the cfdepartmentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfdepartmentId() {
        return cfdepartmentId;
    }

    /**
     * Sets the value of the cfdepartmentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfdepartmentId(String value) {
        this.cfdepartmentId = value;
    }

    /**
     * Gets the value of the cfentryTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCfentryTime() {
        return cfentryTime;
    }

    /**
     * Sets the value of the cfentryTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCfentryTime(XMLGregorianCalendar value) {
        this.cfentryTime = value;
    }

    /**
     * Gets the value of the cfexportNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCfexportNumber() {
        return cfexportNumber;
    }

    /**
     * Sets the value of the cfexportNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCfexportNumber(Long value) {
        this.cfexportNumber = value;
    }

    /**
     * Gets the value of the cfgender property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfgender() {
        return cfgender;
    }

    /**
     * Sets the value of the cfgender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfgender(String value) {
        this.cfgender = value;
    }

    /**
     * Gets the value of the cfgongHaowuId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfgongHaowuId() {
        return cfgongHaowuId;
    }

    /**
     * Sets the value of the cfgongHaowuId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfgongHaowuId(String value) {
        this.cfgongHaowuId = value;
    }

    /**
     * Gets the value of the cfissueTyep property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfissueTyep() {
        return cfissueTyep;
    }

    /**
     * Sets the value of the cfissueTyep property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfissueTyep(String value) {
        this.cfissueTyep = value;
    }

    /**
     * Gets the value of the cfissueconArea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfissueconArea() {
        return cfissueconArea;
    }

    /**
     * Sets the value of the cfissueconArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfissueconArea(String value) {
        this.cfissueconArea = value;
    }

    /**
     * Gets the value of the cflicenceType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCflicenceType() {
        return cflicenceType;
    }

    /**
     * Sets the value of the cflicenceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCflicenceType(String value) {
        this.cflicenceType = value;
    }

    /**
     * Gets the value of the cfmaterialName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfmaterialName() {
        return cfmaterialName;
    }

    /**
     * Sets the value of the cfmaterialName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfmaterialName(String value) {
        this.cfmaterialName = value;
    }

    /**
     * Gets the value of the cfmaterialNum property.
     * 
     * @return
     *     possible object is
     *     {@link MaterialEntity }
     *     
     */
    public MaterialEntity getCfmaterialNum() {
        return cfmaterialNum;
    }

    /**
     * Sets the value of the cfmaterialNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaterialEntity }
     *     
     */
    public void setCfmaterialNum(MaterialEntity value) {
        this.cfmaterialNum = value;
    }

    /**
     * Gets the value of the cfmaterialNumId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfmaterialNumId() {
    	if (cfmaterialNumId == null) {
    		cfmaterialNumId = "";
    	}
        return cfmaterialNumId;
    }

    /**
     * Sets the value of the cfmaterialNumId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfmaterialNumId(String value) {
        this.cfmaterialNumId = value;
    }

    /**
     * Gets the value of the cfmaterialTypes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfmaterialTypes() {
        return cfmaterialTypes;
    }

    /**
     * Sets the value of the cfmaterialTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfmaterialTypes(String value) {
        this.cfmaterialTypes = value;
    }

    /**
     * Gets the value of the cfnames property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfnames() {
        return cfnames;
    }

    /**
     * Sets the value of the cfnames property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfnames(String value) {
        this.cfnames = value;
    }

    /**
     * Gets the value of the cforiginalPostName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCforiginalPostName() {
        return cforiginalPostName;
    }

    /**
     * Sets the value of the cforiginalPostName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCforiginalPostName(String value) {
        this.cforiginalPostName = value;
    }

    /**
     * Gets the value of the cfoutBoundNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfoutBoundNum() {
        return cfoutBoundNum;
    }

    /**
     * Sets the value of the cfoutBoundNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfoutBoundNum(String value) {
        this.cfoutBoundNum = value;
    }

    /**
     * Gets the value of the cfpostNameId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfpostNameId() {
        return cfpostNameId;
    }

    /**
     * Sets the value of the cfpostNameId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfpostNameId(String value) {
        this.cfpostNameId = value;
    }

    /**
     * Gets the value of the cfpurorderunit property.
     * 
     * @return
     *     possible object is
     *     {@link PurChaseInfo }
     *     
     */
    public PurChaseInfo getCfpurorderunit() {
        return cfpurorderunit == null ? new PurChaseInfo() : cfpurorderunit;
    }

    /**
     * Sets the value of the cfpurorderunit property.
     * 
     * @param value
     *     allowed object is
     *     {@link PurChaseInfo }
     *     
     */
    public void setCfpurorderunit(PurChaseInfo value) {
        this.cfpurorderunit = value;
    }

    /**
     * Gets the value of the cfpurorderunitid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfpurorderunitid() {
        return cfpurorderunitid;
    }

    /**
     * Sets the value of the cfpurorderunitid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfpurorderunitid(String value) {
        this.cfpurorderunitid = value;
    }

    /**
     * Gets the value of the cfquantity property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCfquantity() {
        return cfquantity;
    }
    public String getCfquantityStr() {
    	if (cfquantity == null) {
    		return "";
    	}
        return cfquantity + "";
    }
    /**
     * Sets the value of the cfquantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCfquantity(BigDecimal value) {
        this.cfquantity = value;
    }

    /**
     * Gets the value of the cfreferenceAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCfreferenceAmount() {
        return cfreferenceAmount;
    }
    public String getCfreferenceAmountStr() {
    	if (cfreferenceAmount == null) {
    		return "";
    	}
        return cfreferenceAmount + "";
    }
    /**
     * Sets the value of the cfreferenceAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCfreferenceAmount(BigDecimal value) {
        this.cfreferenceAmount = value;
    }

    /**
     * Gets the value of the cfreferencePrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCfreferencePrice() {
        return cfreferencePrice;
    }
    public String getCfreferencePriceStr() {
    	if (cfreferencePrice == null) {
    		return "";
    	}
        return cfreferencePrice + "";
    }

    /**
     * Sets the value of the cfreferencePrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCfreferencePrice(BigDecimal value) {
        this.cfreferencePrice = value;
    }

    /**
     * Gets the value of the cfregistrationLoan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfregistrationLoan() {
        return cfregistrationLoan;
    }

    /**
     * Sets the value of the cfregistrationLoan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfregistrationLoan(String value) {
        this.cfregistrationLoan = value;
    }

    /**
     * Gets the value of the cfregistrationSites property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfregistrationSites() {
        return cfregistrationSites;
    }

    /**
     * Sets the value of the cfregistrationSites property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfregistrationSites(String value) {
        this.cfregistrationSites = value;
    }

    /**
     * Gets the value of the cfrelationMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfrelationMethod() {
        return cfrelationMethod;
    }

    /**
     * Sets the value of the cfrelationMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfrelationMethod(String value) {
        this.cfrelationMethod = value;
    }

    /**
     * Gets the value of the cfremake property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfremake() {
        return cfremake == null ? "" : cfremake;
    }

    /**
     * Sets the value of the cfremake property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfremake(String value) {
        this.cfremake = value;
    }

    /**
     * Gets the value of the cfscrapApplication property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfscrapApplication() {
        return cfscrapApplication;
    }

    /**
     * Sets the value of the cfscrapApplication property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfscrapApplication(String value) {
        this.cfscrapApplication = value;
    }

    /**
     * Gets the value of the cfsecurityContacti property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfsecurityContacti() {
        return cfsecurityContacti;
    }

    /**
     * Sets the value of the cfsecurityContacti property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfsecurityContacti(String value) {
        this.cfsecurityContacti = value;
    }

    /**
     * Gets the value of the cfshouldPlace property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCfshouldPlace() {
        return cfshouldPlace;
    }

    /**
     * Sets the value of the cfshouldPlace property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCfshouldPlace(XMLGregorianCalendar value) {
        this.cfshouldPlace = value;
    }

    /**
     * Gets the value of the cfsignAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCfsignAmount() {
    	if (cfsignAmount == null) {
    		
    	}
        return cfsignAmount;
    }
    public String getCfsignAmountStr() {
    	if (cfsignAmount == null) {
    		return "";
    	}
        return cfsignAmount + "";
    }

    /**
     * Sets the value of the cfsignAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCfsignAmount(Long value) {
        this.cfsignAmount = value;
    }

    /**
     * Gets the value of the cfspecifications property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfspecifications() {
        return cfspecifications;
    }

    /**
     * Sets the value of the cfspecifications property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfspecifications(String value) {
        this.cfspecifications = value;
    }

    /**
     * Gets the value of the cfstartingDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCfstartingDate() {
        return cfstartingDate;
    }

    /**
     * Sets the value of the cfstartingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCfstartingDate(XMLGregorianCalendar value) {
        this.cfstartingDate = value;
    }

    /**
     * Gets the value of the cfsubordinateDivis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfsubordinateDivis() {
        return cfsubordinateDivis;
    }

    /**
     * Sets the value of the cfsubordinateDivis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfsubordinateDivis(String value) {
        this.cfsubordinateDivis = value;
    }

    /**
     * Gets the value of the cfteamcontactId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfteamcontactId() {
        return cfteamcontactId;
    }

    /**
     * Sets the value of the cfteamcontactId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfteamcontactId(String value) {
        this.cfteamcontactId = value;
    }

    /**
     * Gets the value of the cfunit property.
     * 
     * @return
     *     possible object is
     *     {@link MeasureUnit }
     *     
     */
    public MeasureUnit getCfunit() {
    	if (cfunit == null) {
    		cfunit = new MeasureUnit();
    	}
        return cfunit;
    }

    /**
     * Sets the value of the cfunit property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureUnit }
     *     
     */
    public void setCfunit(MeasureUnit value) {
        this.cfunit = value;
    }

    /**
     * Gets the value of the cfunitId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfunitId() {
        return cfunitId;
    }

    /**
     * Sets the value of the cfunitId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfunitId(String value) {
        this.cfunitId = value;
    }

    /**
     * Gets the value of the cfuseDepartment property.
     * 
     * @return
     *     possible object is
     *     {@link AdminOrgUnit }
     *     
     */
    public AdminOrgUnit getCfuseDepartment() {
    	if (cfuseDepartment == null) {
    		cfuseDepartment = new AdminOrgUnit();
    	}
        return cfuseDepartment;
    }

    /**
     * Sets the value of the cfuseDepartment property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdminOrgUnit }
     *     
     */
    public void setCfuseDepartment(AdminOrgUnit value) {
        this.cfuseDepartment = value;
    }

    /**
     * Gets the value of the cfuseDepartmentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfuseDepartmentId() {
        return cfuseDepartmentId;
    }

    /**
     * Sets the value of the cfuseDepartmentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfuseDepartmentId(String value) {
        this.cfuseDepartmentId = value;
    }

    /**
     * Gets the value of the ffactNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFfactNumber() {
        return ffactNumber;
    }

    /**
     * Sets the value of the ffactNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFfactNumber(Long value) {
        this.ffactNumber = value;
    }

    /**
     * Gets the value of the fid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFid() {
        return fid;
    }

    /**
     * Sets the value of the fid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFid(String value) {
        this.fid = value;
    }

    /**
     * Gets the value of the fmaterialMent property.
     * 
     * @return
     *     possible object is
     *     {@link MaterialAttEntity }
     *     
     */
    public MaterialAttEntity getFmaterialMent() {
        return fmaterialMent == null ? new MaterialAttEntity() : fmaterialMent;
    }

    /**
     * Sets the value of the fmaterialMent property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaterialAttEntity }
     *     
     */
    public void setFmaterialMent(MaterialAttEntity value) {
        this.fmaterialMent = value;
    }

    /**
     * Gets the value of the fmaterialMentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFmaterialMentId() {
        return fmaterialMentId;
    }

    /**
     * Sets the value of the fmaterialMentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFmaterialMentId(String value) {
        this.fmaterialMentId = value;
    }

    /**
     * Gets the value of the fparentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFparentId() {
        return fparentId;
    }

    /**
     * Sets the value of the fparentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFparentId(String value) {
        this.fparentId = value;
    }

    /**
     * Gets the value of the fparentNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFparentNumber() {
        return fparentNumber;
    }

    /**
     * Sets the value of the fparentNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFparentNumber(String value) {
        this.fparentNumber = value;
    }

    /**
     * Gets the value of the fprojectBudget property.
     * 
     * @return
     *     possible object is
     *     {@link BudgeItemsEntity }
     *     
     */
    public BudgeItemsEntity getFprojectBudget() {
        return fprojectBudget==null?fprojectBudget = new BudgeItemsEntity():fprojectBudget;
    }

    /**
     * Sets the value of the fprojectBudget property.
     * 
     * @param value
     *     allowed object is
     *     {@link BudgeItemsEntity }
     *     
     */
    public void setFprojectBudget(BudgeItemsEntity value) {
        this.fprojectBudget = value;
    }

    /**
     * Gets the value of the fprojectBudgetId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFprojectBudgetId() {
        return fprojectBudgetId;
    }

    /**
     * Sets the value of the fprojectBudgetId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFprojectBudgetId(String value) {
        this.fprojectBudgetId = value;
    }

    /**
     * Gets the value of the fseq property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFseq() {
        return fseq;
    }

    /**
     * Sets the value of the fseq property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFseq(Long value) {
        this.fseq = value;
    }

    /**
     * Gets the value of the ftransferNum property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFtransferNum() {
        return ftransferNum;
    }

    /**
     * Sets the value of the ftransferNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFtransferNum(Long value) {
        this.ftransferNum = value;
    }

}

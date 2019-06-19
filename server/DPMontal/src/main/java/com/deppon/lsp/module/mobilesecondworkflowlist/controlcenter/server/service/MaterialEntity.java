
package com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for materialEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="materialEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}baseEntity">
 *       &lt;sequence>
 *         &lt;element name="alias" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="applyReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="attriId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="attriname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="baseUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="baseUnitid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="billType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="buyNumber" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="cfBaseNum" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="cfMaterialNumId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfdugeitemnumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfexportNumber" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="cfmaterialName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfmaterialTypes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfremark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfsignAmount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="cfspecifications" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfsubordsubsidiary" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="companyOrgId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="companyOrgName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="controlUnitId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="controlUnitName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fmaterialattid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fnumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fseq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isLikeSearch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mainPanelKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="materialPhoto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mattype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mattypefid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="meterialtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="meterialtypeid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="model" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mttID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numberAry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderPrice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="orgID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="purChaseOrg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="purchasedate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="referencePrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="scrapApplyNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="simpleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stockBudgeItemsId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stockBudgeItemsName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stockBudgeItemsNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unitfid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "materialEntity", propOrder = {
    "alias",
    "amount",
    "applyReason",
    "attriId",
    "attriname",
    "baseUnit",
    "baseUnitid",
    "billType",
    "buyNumber",
    "cfBaseNum",
    "cfMaterialNumId",
    "cfdugeitemnumber",
    "cfexportNumber",
    "cfmaterialName",
    "cfmaterialTypes",
    "cfremark",
    "cfsignAmount",
    "cfspecifications",
    "cfsubordsubsidiary",
    "companyOrgId",
    "companyOrgName",
    "controlUnitId",
    "controlUnitName",
    "fid",
    "fmaterialattid",
    "fnumber",
    "fseq",
    "isLikeSearch",
    "mainPanelKey",
    "materialPhoto",
    "mattype",
    "mattypefid",
    "meterialtype",
    "meterialtypeid",
    "model",
    "mttID",
    "name",
    "number",
    "numberAry",
    "orderPrice",
    "orgID",
    "price",
    "purChaseOrg",
    "purchasedate",
    "referencePrice",
    "scrapApplyNumber",
    "simpleName",
    "stockBudgeItemsId",
    "stockBudgeItemsName",
    "stockBudgeItemsNumber",
    "unitfid"
})
public class MaterialEntity
    extends BaseEntity
{

    protected String alias;
    protected BigDecimal amount;
    protected String applyReason;
    protected String attriId;
    protected String attriname;
    protected String baseUnit;
    protected String baseUnitid;
    protected String billType;
    protected BigDecimal buyNumber;
    protected BigDecimal cfBaseNum;
    protected String cfMaterialNumId;
    protected String cfdugeitemnumber;
    protected Long cfexportNumber;
    protected String cfmaterialName;
    protected String cfmaterialTypes;
    protected String cfremark;
    protected Long cfsignAmount;
    protected String cfspecifications;
    protected String cfsubordsubsidiary;
    protected String companyOrgId;
    protected String companyOrgName;
    protected String controlUnitId;
    protected String controlUnitName;
    protected String fid;
    protected String fmaterialattid;
    protected String fnumber;
    protected String fseq;
    protected String isLikeSearch;
    protected String mainPanelKey;
    protected String materialPhoto;
    protected String mattype;
    protected String mattypefid;
    protected String meterialtype;
    protected String meterialtypeid;
    protected String model;
    protected String mttID;
    protected String name;
    protected String number;
    protected String numberAry;
    protected BigDecimal orderPrice;
    protected String orgID;
    protected BigDecimal price;
    protected String purChaseOrg;
    protected BigDecimal purchasedate;
    protected String referencePrice;
    protected String scrapApplyNumber;
    protected String simpleName;
    protected String stockBudgeItemsId;
    protected String stockBudgeItemsName;
    protected String stockBudgeItemsNumber;
    protected String unitfid;

    /**
     * Gets the value of the alias property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Sets the value of the alias property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlias(String value) {
        this.alias = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

    /**
     * Gets the value of the applyReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyReason() {
        return applyReason;
    }

    /**
     * Sets the value of the applyReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyReason(String value) {
        this.applyReason = value;
    }

    /**
     * Gets the value of the attriId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttriId() {
        return attriId;
    }

    /**
     * Sets the value of the attriId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttriId(String value) {
        this.attriId = value;
    }

    /**
     * Gets the value of the attriname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttriname() {
        return attriname;
    }

    /**
     * Sets the value of the attriname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttriname(String value) {
        this.attriname = value;
    }

    /**
     * Gets the value of the baseUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseUnit() {
        return baseUnit;
    }

    /**
     * Sets the value of the baseUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseUnit(String value) {
        this.baseUnit = value;
    }

    /**
     * Gets the value of the baseUnitid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseUnitid() {
        return baseUnitid;
    }

    /**
     * Sets the value of the baseUnitid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseUnitid(String value) {
        this.baseUnitid = value;
    }

    /**
     * Gets the value of the billType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillType() {
        return billType;
    }

    /**
     * Sets the value of the billType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillType(String value) {
        this.billType = value;
    }

    /**
     * Gets the value of the buyNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBuyNumber() {
        return buyNumber;
    }

    /**
     * Sets the value of the buyNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBuyNumber(BigDecimal value) {
        this.buyNumber = value;
    }

    /**
     * Gets the value of the cfBaseNum property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCfBaseNum() {
        return cfBaseNum;
    }

    /**
     * Sets the value of the cfBaseNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCfBaseNum(BigDecimal value) {
        this.cfBaseNum = value;
    }

    /**
     * Gets the value of the cfMaterialNumId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfMaterialNumId() {
        return cfMaterialNumId;
    }

    /**
     * Sets the value of the cfMaterialNumId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfMaterialNumId(String value) {
        this.cfMaterialNumId = value;
    }

    /**
     * Gets the value of the cfdugeitemnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfdugeitemnumber() {
        return cfdugeitemnumber;
    }

    /**
     * Sets the value of the cfdugeitemnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfdugeitemnumber(String value) {
        this.cfdugeitemnumber = value;
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
     * Gets the value of the cfremark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfremark() {
        return cfremark;
    }

    /**
     * Sets the value of the cfremark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfremark(String value) {
        this.cfremark = value;
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
        return cfsignAmount;
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
     * Gets the value of the cfsubordsubsidiary property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfsubordsubsidiary() {
        return cfsubordsubsidiary;
    }

    /**
     * Sets the value of the cfsubordsubsidiary property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfsubordsubsidiary(String value) {
        this.cfsubordsubsidiary = value;
    }

    /**
     * Gets the value of the companyOrgId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyOrgId() {
        return companyOrgId;
    }

    /**
     * Sets the value of the companyOrgId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyOrgId(String value) {
        this.companyOrgId = value;
    }

    /**
     * Gets the value of the companyOrgName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyOrgName() {
        return companyOrgName;
    }

    /**
     * Sets the value of the companyOrgName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyOrgName(String value) {
        this.companyOrgName = value;
    }

    /**
     * Gets the value of the controlUnitId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getControlUnitId() {
        return controlUnitId;
    }

    /**
     * Sets the value of the controlUnitId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setControlUnitId(String value) {
        this.controlUnitId = value;
    }

    /**
     * Gets the value of the controlUnitName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getControlUnitName() {
        return controlUnitName;
    }

    /**
     * Sets the value of the controlUnitName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setControlUnitName(String value) {
        this.controlUnitName = value;
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
     * Gets the value of the fmaterialattid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFmaterialattid() {
        return fmaterialattid;
    }

    /**
     * Sets the value of the fmaterialattid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFmaterialattid(String value) {
        this.fmaterialattid = value;
    }

    /**
     * Gets the value of the fnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFnumber() {
        return fnumber;
    }

    /**
     * Sets the value of the fnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFnumber(String value) {
        this.fnumber = value;
    }

    /**
     * Gets the value of the fseq property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFseq() {
        return fseq;
    }

    /**
     * Sets the value of the fseq property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFseq(String value) {
        this.fseq = value;
    }

    /**
     * Gets the value of the isLikeSearch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsLikeSearch() {
        return isLikeSearch;
    }

    /**
     * Sets the value of the isLikeSearch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsLikeSearch(String value) {
        this.isLikeSearch = value;
    }

    /**
     * Gets the value of the mainPanelKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMainPanelKey() {
        return mainPanelKey;
    }

    /**
     * Sets the value of the mainPanelKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMainPanelKey(String value) {
        this.mainPanelKey = value;
    }

    /**
     * Gets the value of the materialPhoto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaterialPhoto() {
        return materialPhoto;
    }

    /**
     * Sets the value of the materialPhoto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaterialPhoto(String value) {
        this.materialPhoto = value;
    }

    /**
     * Gets the value of the mattype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMattype() {
        return mattype;
    }

    /**
     * Sets the value of the mattype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMattype(String value) {
        this.mattype = value;
    }

    /**
     * Gets the value of the mattypefid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMattypefid() {
        return mattypefid;
    }

    /**
     * Sets the value of the mattypefid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMattypefid(String value) {
        this.mattypefid = value;
    }

    /**
     * Gets the value of the meterialtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeterialtype() {
        return meterialtype;
    }

    /**
     * Sets the value of the meterialtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeterialtype(String value) {
        this.meterialtype = value;
    }

    /**
     * Gets the value of the meterialtypeid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeterialtypeid() {
        return meterialtypeid;
    }

    /**
     * Sets the value of the meterialtypeid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeterialtypeid(String value) {
        this.meterialtypeid = value;
    }

    /**
     * Gets the value of the model property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModel(String value) {
        this.model = value;
    }

    /**
     * Gets the value of the mttID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMttID() {
        return mttID;
    }

    /**
     * Sets the value of the mttID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMttID(String value) {
        this.mttID = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * Gets the value of the numberAry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberAry() {
        return numberAry;
    }

    /**
     * Sets the value of the numberAry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberAry(String value) {
        this.numberAry = value;
    }

    /**
     * Gets the value of the orderPrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    /**
     * Sets the value of the orderPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOrderPrice(BigDecimal value) {
        this.orderPrice = value;
    }

    /**
     * Gets the value of the orgID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgID() {
        return orgID;
    }

    /**
     * Sets the value of the orgID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgID(String value) {
        this.orgID = value;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrice(BigDecimal value) {
        this.price = value;
    }

    /**
     * Gets the value of the purChaseOrg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurChaseOrg() {
        return purChaseOrg;
    }

    /**
     * Sets the value of the purChaseOrg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurChaseOrg(String value) {
        this.purChaseOrg = value;
    }

    /**
     * Gets the value of the purchasedate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPurchasedate() {
        return purchasedate;
    }

    /**
     * Sets the value of the purchasedate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPurchasedate(BigDecimal value) {
        this.purchasedate = value;
    }

    /**
     * Gets the value of the referencePrice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferencePrice() {
        return referencePrice;
    }

    /**
     * Sets the value of the referencePrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferencePrice(String value) {
        this.referencePrice = value;
    }

    /**
     * Gets the value of the scrapApplyNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScrapApplyNumber() {
        return scrapApplyNumber;
    }

    /**
     * Sets the value of the scrapApplyNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScrapApplyNumber(String value) {
        this.scrapApplyNumber = value;
    }

    /**
     * Gets the value of the simpleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSimpleName() {
        return simpleName;
    }

    /**
     * Sets the value of the simpleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSimpleName(String value) {
        this.simpleName = value;
    }

    /**
     * Gets the value of the stockBudgeItemsId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStockBudgeItemsId() {
        return stockBudgeItemsId;
    }

    /**
     * Sets the value of the stockBudgeItemsId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStockBudgeItemsId(String value) {
        this.stockBudgeItemsId = value;
    }

    /**
     * Gets the value of the stockBudgeItemsName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStockBudgeItemsName() {
        return stockBudgeItemsName;
    }

    /**
     * Sets the value of the stockBudgeItemsName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStockBudgeItemsName(String value) {
        this.stockBudgeItemsName = value;
    }

    /**
     * Gets the value of the stockBudgeItemsNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStockBudgeItemsNumber() {
        return stockBudgeItemsNumber;
    }

    /**
     * Sets the value of the stockBudgeItemsNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStockBudgeItemsNumber(String value) {
        this.stockBudgeItemsNumber = value;
    }

    /**
     * Gets the value of the unitfid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitfid() {
        return unitfid;
    }

    /**
     * Sets the value of the unitfid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitfid(String value) {
        this.unitfid = value;
    }

}


package com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.deppon.montal.util.FormatUtil;


/**
 * <p>Java class for journalizeData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="journalizeData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="applyReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="attriId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="attriname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="baseUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="buyNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cfMaterialNumId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfexportNumber" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="cfmaterialName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfmaterialTypes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfremark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfsignAmount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="cfspecifications" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="companyOrgId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="companyOrgName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fnumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ftransferNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="orgID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="purChaseOrg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="scrapApplyNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stockBudgeItemsId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stockBudgeItemsName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stockBudgeItemsNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unitfid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "journalizeData", propOrder = {
    "amount",
    "applyReason",
    "attriId",
    "attriname",
    "baseUnit",
    "buyNumber",
    "cfMaterialNumId",
    "cfexportNumber",
    "cfmaterialName",
    "cfmaterialTypes",
    "cfremark",
    "cfsignAmount",
    "cfspecifications",
    "companyOrgId",
    "companyOrgName",
    "fid",
    "fnumber",
    "ftransferNum",
    "orgID",
    "price",
    "purChaseOrg",
    "scrapApplyNumber",
    "stockBudgeItemsId",
    "stockBudgeItemsName",
    "stockBudgeItemsNumber",
    "unitfid"
})
public class JournalizeData {

    protected BigDecimal amount;
    protected String applyReason;
    protected String attriId;
    protected String attriname;
    protected String baseUnit;
    protected int buyNumber;
    protected String cfMaterialNumId;
    protected Long cfexportNumber;
    protected String cfmaterialName;
    protected String cfmaterialTypes;
    protected String cfremark;
    protected Long cfsignAmount;
    protected String cfspecifications;
    protected String companyOrgId;
    protected String companyOrgName;
    protected String fid;
    protected String fnumber;
    protected Long ftransferNum;
    protected String orgID;
    protected BigDecimal price;
    protected String purChaseOrg;
    protected String scrapApplyNumber;
    protected String stockBudgeItemsId;
    protected String stockBudgeItemsName;
    protected String stockBudgeItemsNumber;
    protected String unitfid;

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
    public String getAmountStr() {
        return FormatUtil.formatMoneyStr(amount);
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
    	if (attriId == null) {
    		attriId = "";
    	}
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
    	if (attriname == null) {
    		attriname = "";
    	}
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
    	if (baseUnit == null) {
    		baseUnit = "";
    	}
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
     * Gets the value of the buyNumber property.
     * 
     */
    public int getBuyNumber() {
        return buyNumber;
    }

    /**
     * Sets the value of the buyNumber property.
     * 
     */
    public void setBuyNumber(int value) {
        this.buyNumber = value;
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
    public String getCfexportNumberStr() {
        return cfexportNumber == null ? "" : cfexportNumber + "";
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
    	if (cfmaterialName == null) {
    		cfmaterialName = "";
    	}
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
    	if (cfmaterialTypes == null) {
    		cfmaterialTypes = "";
    	}
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
        return cfremark == null ? "" : cfremark + "";
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
    public String getCfsignAmountStr() {
        return cfsignAmount == null ? "" : (cfsignAmount + "");
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
    	if (cfspecifications == null) {
    		cfspecifications = "";
    	}
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
        return companyOrgName == null ? "" : companyOrgName;
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
     * Gets the value of the fnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFnumber() {
    	if (fnumber == null) {
    		fnumber = "";
    	}
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

    public String getFtransferNumStr() {
        return ftransferNum == null ? "" : ftransferNum + "";
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

    public String getPriceStr() {
        return FormatUtil.formatMoneyStr(price);
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
        return purChaseOrg == null ? "":purChaseOrg;
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
    	if (stockBudgeItemsName == null) {
    		stockBudgeItemsName = "";
    	}
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

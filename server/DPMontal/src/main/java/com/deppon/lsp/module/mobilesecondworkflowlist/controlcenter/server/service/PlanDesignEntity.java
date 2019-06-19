
package com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import com.deppon.montal.util.FormatUtil;


/**
 * <p>Java class for planDesignEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="planDesignEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}baseEntity">
 *       &lt;sequence>
 *         &lt;element name="cfaddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfapplicant" type="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}person" minOccurs="0"/>
 *         &lt;element name="cfapplicantId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfapplicantdeps" type="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}adminOrgUnit" minOccurs="0"/>
 *         &lt;element name="cfapplicantdepsId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfapplicationMethods" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfauditTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="cfbimudf0058" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfcandidPointStan" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="cfcapitaAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="cfcarDepartmType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfchangeRepleni" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="cfclaimNumbers" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfcurrencyId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfdeliveryDepart" type="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}adminOrgUnit" minOccurs="0"/>
 *         &lt;element name="cfdeliveryDepartme" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfexpenseBeaDepart" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cffunifiedapp" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="cfisDesignCls" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="cfmaterialBelongId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfmistakesNumbers" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfpersonCount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfphone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfpurOrderUnitId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfremake" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfstate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfsubOrdSubsiDiary" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfsubOrdSubsiDiaryName" type="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}adminOrgUnit" minOccurs="0"/>
 *         &lt;element name="cfsubOrdSubsiId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfsubOrdinateWareh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cftotalApplyAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="cftype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cfunplanPurchases" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="cfwarehousezz" type="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}storageEntity" minOccurs="0"/>
 *         &lt;element name="cfwarehousezzId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deptName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deptStandCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fauditorId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fbizDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fcompanyId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fcontrolUnitId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fcostCenter" type="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}adminOrgUnit" minOccurs="0"/>
 *         &lt;element name="fcostCenterId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fcostCenterLastId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fcreatOrgId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fcreateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fcreatorId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fdescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ffivouchered" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="fgcneedLsit" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="fgfneedList" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="fhandlerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fhasEffected" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="fid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fisPur" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="fisl" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="flastUpdateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="flastUpdateUserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fneedType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fnumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fproName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fproNumberId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fsonNeedList" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="fsourceBillId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fsourceFunction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fswcNeedList" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ftickedOrgId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "planDesignEntity", propOrder = {
    "cfaddress",
    "cfapplicant",
    "cfapplicantId",
    "cfapplicantdeps",
    "cfapplicantdepsId",
    "cfapplicationMethods",
    "cfauditTime",
    "cfbimudf0058",
    "cfcandidPointStan",
    "cfcapitaAmount",
    "cfcarDepartmType",
    "cfchangeRepleni",
    "cfclaimNumbers",
    "cfcurrencyId",
    "cfdeliveryDepart",
    "cfdeliveryDepartme",
    "cfexpenseBeaDepart",
    "cffunifiedapp",
    "cfisDesignCls",
    "cfmaterialBelongId",
    "cfmistakesNumbers",
    "cfpersonCount",
    "cfphone",
    "cfpurOrderUnitId",
    "cfremake",
    "cfstate",
    "cfsubOrdSubsiDiary",
    "cfsubOrdSubsiDiaryName",
    "cfsubOrdSubsiId",
    "cfsubOrdinateWareh",
    "cftotalApplyAmount",
    "cftype",
    "cfunplanPurchases",
    "cfwarehousezz",
    "cfwarehousezzId",
    "deptName",
    "deptStandCode",
    "fauditorId",
    "fbizDate",
    "fcompanyId",
    "fcontrolUnitId",
    "fcostCenter",
    "fcostCenterId",
    "fcostCenterLastId",
    "fcreatOrgId",
    "fcreateTime",
    "fcreatorId",
    "fdescription",
    "ffivouchered",
    "fgcneedLsit",
    "fgfneedList",
    "fhandlerId",
    "fhasEffected",
    "fid",
    "fisPur",
    "fisl",
    "flastUpdateTime",
    "flastUpdateUserId",
    "fneedType",
    "fnumber",
    "fproName",
    "fproNumberId",
    "fsonNeedList",
    "fsourceBillId",
    "fsourceFunction",
    "fswcNeedList",
    "ftickedOrgId",
    "userCode",
    "userName"
})
public class PlanDesignEntity
    extends BaseEntity
{

    protected String cfaddress;
    protected Person cfapplicant;
    protected String cfapplicantId;
    protected AdminOrgUnit cfapplicantdeps;
    protected String cfapplicantdepsId;
    protected String cfapplicationMethods;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar cfauditTime;
    protected String cfbimudf0058;
    protected Long cfcandidPointStan;
    protected BigDecimal cfcapitaAmount;
    protected String cfcarDepartmType;
    protected Long cfchangeRepleni;
    protected String cfclaimNumbers;
    protected String cfcurrencyId;
    protected AdminOrgUnit cfdeliveryDepart;
    protected String cfdeliveryDepartme;
    protected String cfexpenseBeaDepart;
    protected Long cffunifiedapp;
    protected Long cfisDesignCls;
    protected String cfmaterialBelongId;
    protected String cfmistakesNumbers;
    protected String cfpersonCount;
    protected String cfphone;
    protected String cfpurOrderUnitId;
    protected String cfremake;
    protected String cfstate;
    protected String cfsubOrdSubsiDiary;
    protected AdminOrgUnit cfsubOrdSubsiDiaryName;
    protected String cfsubOrdSubsiId;
    protected String cfsubOrdinateWareh;
    protected BigDecimal cftotalApplyAmount;
    protected String cftype;
    protected Long cfunplanPurchases;
    protected StorageEntity cfwarehousezz;
    protected String cfwarehousezzId;
    protected String deptName;
    protected String deptStandCode;
    protected String fauditorId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fbizDate;
    protected String fcompanyId;
    protected String fcontrolUnitId;
    protected AdminOrgUnit fcostCenter;
    protected String fcostCenterId;
    protected String fcostCenterLastId;
    protected String fcreatOrgId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fcreateTime;
    protected String fcreatorId;
    protected String fdescription;
    protected Long ffivouchered;
    protected Long fgcneedLsit;
    protected Long fgfneedList;
    protected String fhandlerId;
    protected Long fhasEffected;
    protected String fid;
    protected Long fisPur;
    protected Long fisl;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar flastUpdateTime;
    protected String flastUpdateUserId;
    protected String fneedType;
    protected String fnumber;
    protected String fproName;
    protected String fproNumberId;
    protected Long fsonNeedList;
    protected String fsourceBillId;
    protected String fsourceFunction;
    protected Long fswcNeedList;
    protected String ftickedOrgId;
    protected String userCode;
    protected String userName;

    /**
     * Gets the value of the cfaddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfaddress() {
    	if (cfaddress == null) {
    		cfaddress = "";
    	}
        return cfaddress;
    }

    /**
     * Sets the value of the cfaddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfaddress(String value) {
        this.cfaddress = value;
    }

    /**
     * Gets the value of the cfapplicant property.
     * 
     * @return
     *     possible object is
     *     {@link Person }
     *     
     */
    public Person getCfapplicant() {
    	if (cfapplicant == null) {
    		cfapplicant = new Person();
    	}
        return cfapplicant;
    }

    /**
     * Sets the value of the cfapplicant property.
     * 
     * @param value
     *     allowed object is
     *     {@link Person }
     *     
     */
    public void setCfapplicant(Person value) {
        this.cfapplicant = value;
    }

    /**
     * Gets the value of the cfapplicantId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfapplicantId() {
        return cfapplicantId;
    }

    /**
     * Sets the value of the cfapplicantId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfapplicantId(String value) {
        this.cfapplicantId = value;
    }

    /**
     * Gets the value of the cfapplicantdeps property.
     * 
     * @return
     *     possible object is
     *     {@link AdminOrgUnit }
     *     
     */
    public AdminOrgUnit getCfapplicantdeps() {
    	if (cfapplicantdeps == null) {
    		cfapplicantdeps = new AdminOrgUnit();
    	}
        return cfapplicantdeps;
    }

    /**
     * Sets the value of the cfapplicantdeps property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdminOrgUnit }
     *     
     */
    public void setCfapplicantdeps(AdminOrgUnit value) {
        this.cfapplicantdeps = value;
    }

    /**
     * Gets the value of the cfapplicantdepsId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfapplicantdepsId() {
        return cfapplicantdepsId;
    }

    /**
     * Sets the value of the cfapplicantdepsId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfapplicantdepsId(String value) {
        this.cfapplicantdepsId = value;
    }

    /**
     * Gets the value of the cfapplicationMethods property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfapplicationMethods() {
        return cfapplicationMethods;
    }

    /**
     * Sets the value of the cfapplicationMethods property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfapplicationMethods(String value) {
        this.cfapplicationMethods = value;
    }

    /**
     * Gets the value of the cfauditTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCfauditTime() {
        return cfauditTime;
    }

    /**
     * Sets the value of the cfauditTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCfauditTime(XMLGregorianCalendar value) {
        this.cfauditTime = value;
    }

    /**
     * Gets the value of the cfbimudf0058 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfbimudf0058() {
        return cfbimudf0058;
    }

    /**
     * Sets the value of the cfbimudf0058 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfbimudf0058(String value) {
        this.cfbimudf0058 = value;
    }

    /**
     * Gets the value of the cfcandidPointStan property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCfcandidPointStan() {
        return cfcandidPointStan;
    }

    /**
     * Sets the value of the cfcandidPointStan property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCfcandidPointStan(Long value) {
        this.cfcandidPointStan = value;
    }

    /**
     * Gets the value of the cfcapitaAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCfcapitaAmount() {
        return cfcapitaAmount;
    }

    /**
     * Sets the value of the cfcapitaAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCfcapitaAmount(BigDecimal value) {
        this.cfcapitaAmount = value;
    }

    /**
     * Gets the value of the cfcarDepartmType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfcarDepartmType() {
        return cfcarDepartmType;
    }

    /**
     * Sets the value of the cfcarDepartmType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfcarDepartmType(String value) {
        this.cfcarDepartmType = value;
    }

    /**
     * Gets the value of the cfchangeRepleni property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCfchangeRepleni() {
        return cfchangeRepleni;
    }

    /**
     * Sets the value of the cfchangeRepleni property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCfchangeRepleni(Long value) {
        this.cfchangeRepleni = value;
    }

    /**
     * Gets the value of the cfclaimNumbers property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfclaimNumbers() {
        return cfclaimNumbers;
    }

    /**
     * Sets the value of the cfclaimNumbers property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfclaimNumbers(String value) {
        this.cfclaimNumbers = value;
    }

    /**
     * Gets the value of the cfcurrencyId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfcurrencyId() {
        return cfcurrencyId;
    }

    /**
     * Sets the value of the cfcurrencyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfcurrencyId(String value) {
        this.cfcurrencyId = value;
    }

    /**
     * Gets the value of the cfdeliveryDepart property.
     * 
     * @return
     *     possible object is
     *     {@link AdminOrgUnit }
     *     
     */
    public AdminOrgUnit getCfdeliveryDepart() {
    	if (cfdeliveryDepart == null) {
    		cfdeliveryDepart = new AdminOrgUnit();
    	}
        return cfdeliveryDepart;
    }

    /**
     * Sets the value of the cfdeliveryDepart property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdminOrgUnit }
     *     
     */
    public void setCfdeliveryDepart(AdminOrgUnit value) {
        this.cfdeliveryDepart = value;
    }

    /**
     * Gets the value of the cfdeliveryDepartme property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfdeliveryDepartme() {
        return cfdeliveryDepartme;
    }

    /**
     * Sets the value of the cfdeliveryDepartme property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfdeliveryDepartme(String value) {
        this.cfdeliveryDepartme = value;
    }

    /**
     * Gets the value of the cfexpenseBeaDepart property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfexpenseBeaDepart() {
        return cfexpenseBeaDepart;
    }

    /**
     * Sets the value of the cfexpenseBeaDepart property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfexpenseBeaDepart(String value) {
        this.cfexpenseBeaDepart = value;
    }

    /**
     * Gets the value of the cffunifiedapp property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCffunifiedapp() {
        return cffunifiedapp;
    }

    /**
     * Sets the value of the cffunifiedapp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCffunifiedapp(Long value) {
        this.cffunifiedapp = value;
    }

    /**
     * Gets the value of the cfisDesignCls property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCfisDesignCls() {
        return cfisDesignCls;
    }

    /**
     * Sets the value of the cfisDesignCls property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCfisDesignCls(Long value) {
        this.cfisDesignCls = value;
    }

    /**
     * Gets the value of the cfmaterialBelongId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfmaterialBelongId() {
        return cfmaterialBelongId;
    }

    /**
     * Sets the value of the cfmaterialBelongId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfmaterialBelongId(String value) {
        this.cfmaterialBelongId = value;
    }

    /**
     * Gets the value of the cfmistakesNumbers property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfmistakesNumbers() {
        return cfmistakesNumbers;
    }

    /**
     * Sets the value of the cfmistakesNumbers property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfmistakesNumbers(String value) {
        this.cfmistakesNumbers = value;
    }

    /**
     * Gets the value of the cfpersonCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfpersonCount() {
        return cfpersonCount;
    }

    /**
     * Sets the value of the cfpersonCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfpersonCount(String value) {
        this.cfpersonCount = value;
    }

    /**
     * Gets the value of the cfphone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfphone() {
    	if (cfphone == null) {
    		cfphone = "";
    	}
        return cfphone;
    }

    /**
     * Sets the value of the cfphone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfphone(String value) {
        this.cfphone = value;
    }

    /**
     * Gets the value of the cfpurOrderUnitId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfpurOrderUnitId() {
        return cfpurOrderUnitId;
    }

    /**
     * Sets the value of the cfpurOrderUnitId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfpurOrderUnitId(String value) {
        this.cfpurOrderUnitId = value;
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
        return cfremake;
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
     * Gets the value of the cfstate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfstate() {
    	if (cfstate == null) {
    		cfstate = "";
    	}
        return cfstate;
    }

    /**
     * Sets the value of the cfstate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfstate(String value) {
        this.cfstate = value;
    }

    /**
     * Gets the value of the cfsubOrdSubsiDiary property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfsubOrdSubsiDiary() {
        return cfsubOrdSubsiDiary;
    }

    /**
     * Sets the value of the cfsubOrdSubsiDiary property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfsubOrdSubsiDiary(String value) {
        this.cfsubOrdSubsiDiary = value;
    }

    /**
     * Gets the value of the cfsubOrdSubsiDiaryName property.
     * 
     * @return
     *     possible object is
     *     {@link AdminOrgUnit }
     *     
     */
    public AdminOrgUnit getCfsubOrdSubsiDiaryName() {
    	if (cfsubOrdSubsiDiaryName == null) {
    		cfsubOrdSubsiDiaryName = new AdminOrgUnit();
    	}
        return cfsubOrdSubsiDiaryName;
    }

    /**
     * Sets the value of the cfsubOrdSubsiDiaryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdminOrgUnit }
     *     
     */
    public void setCfsubOrdSubsiDiaryName(AdminOrgUnit value) {
        this.cfsubOrdSubsiDiaryName = value;
    }

    /**
     * Gets the value of the cfsubOrdSubsiId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfsubOrdSubsiId() {
        return cfsubOrdSubsiId;
    }

    /**
     * Sets the value of the cfsubOrdSubsiId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfsubOrdSubsiId(String value) {
        this.cfsubOrdSubsiId = value;
    }

    /**
     * Gets the value of the cfsubOrdinateWareh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfsubOrdinateWareh() {
        return cfsubOrdinateWareh;
    }

    /**
     * Sets the value of the cfsubOrdinateWareh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfsubOrdinateWareh(String value) {
        this.cfsubOrdinateWareh = value;
    }

    /**
     * Gets the value of the cftotalApplyAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCftotalApplyAmount() {
    	
        return cftotalApplyAmount;
    }

    public String getCftotalApplyAmountStr() {
    	return FormatUtil.formatMoney(cftotalApplyAmount);
    }
    /**
     * Sets the value of the cftotalApplyAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCftotalApplyAmount(BigDecimal value) {
        this.cftotalApplyAmount = value;
    }

    /**
     * Gets the value of the cftype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCftype() {
        return cftype;
    }

    /**
     * Sets the value of the cftype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCftype(String value) {
        this.cftype = value;
    }

    /**
     * Gets the value of the cfunplanPurchases property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCfunplanPurchases() {
        return cfunplanPurchases;
    }

    /**
     * Sets the value of the cfunplanPurchases property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCfunplanPurchases(Long value) {
        this.cfunplanPurchases = value;
    }

    /**
     * Gets the value of the cfwarehousezz property.
     * 
     * @return
     *     possible object is
     *     {@link StorageEntity }
     *     
     */
    public StorageEntity getCfwarehousezz() {
    	if (cfwarehousezz == null) {
    		cfwarehousezz = new StorageEntity();
    	}
        return cfwarehousezz;
    }

    /**
     * Sets the value of the cfwarehousezz property.
     * 
     * @param value
     *     allowed object is
     *     {@link StorageEntity }
     *     
     */
    public void setCfwarehousezz(StorageEntity value) {
        this.cfwarehousezz = value;
    }

    /**
     * Gets the value of the cfwarehousezzId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfwarehousezzId() {
        return cfwarehousezzId;
    }

    /**
     * Sets the value of the cfwarehousezzId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfwarehousezzId(String value) {
        this.cfwarehousezzId = value;
    }

    /**
     * Gets the value of the deptName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * Sets the value of the deptName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeptName(String value) {
        this.deptName = value;
    }

    /**
     * Gets the value of the deptStandCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeptStandCode() {
        return deptStandCode;
    }

    /**
     * Sets the value of the deptStandCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeptStandCode(String value) {
        this.deptStandCode = value;
    }

    /**
     * Gets the value of the fauditorId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFauditorId() {
        return fauditorId;
    }

    /**
     * Sets the value of the fauditorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFauditorId(String value) {
        this.fauditorId = value;
    }

    /**
     * Gets the value of the fbizDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFbizDate() {
        return fbizDate;
    }
    public String getFbizDateStr() {
        return FormatUtil.formatDate(fbizDate, "yyyy-MM-dd HH:mm:ss");
    }
    /**
     * Sets the value of the fbizDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFbizDate(XMLGregorianCalendar value) {
        this.fbizDate = value;
    }

    /**
     * Gets the value of the fcompanyId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFcompanyId() {
        return fcompanyId;
    }

    /**
     * Sets the value of the fcompanyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFcompanyId(String value) {
        this.fcompanyId = value;
    }

    /**
     * Gets the value of the fcontrolUnitId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFcontrolUnitId() {
        return fcontrolUnitId;
    }

    /**
     * Sets the value of the fcontrolUnitId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFcontrolUnitId(String value) {
        this.fcontrolUnitId = value;
    }

    /**
     * Gets the value of the fcostCenter property.
     * 
     * @return
     *     possible object is
     *     {@link AdminOrgUnit }
     *     
     */
    public AdminOrgUnit getFcostCenter() {
    	if (fcostCenter == null) {
    		fcostCenter = new AdminOrgUnit();
    	}
        return fcostCenter;
    }

    /**
     * Sets the value of the fcostCenter property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdminOrgUnit }
     *     
     */
    public void setFcostCenter(AdminOrgUnit value) {
        this.fcostCenter = value;
    }

    /**
     * Gets the value of the fcostCenterId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFcostCenterId() {
        return fcostCenterId;
    }

    /**
     * Sets the value of the fcostCenterId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFcostCenterId(String value) {
        this.fcostCenterId = value;
    }

    /**
     * Gets the value of the fcostCenterLastId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFcostCenterLastId() {
        return fcostCenterLastId;
    }

    /**
     * Sets the value of the fcostCenterLastId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFcostCenterLastId(String value) {
        this.fcostCenterLastId = value;
    }

    /**
     * Gets the value of the fcreatOrgId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFcreatOrgId() {
        return fcreatOrgId;
    }

    /**
     * Sets the value of the fcreatOrgId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFcreatOrgId(String value) {
        this.fcreatOrgId = value;
    }

    /**
     * Gets the value of the fcreateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFcreateTime() {
        return fcreateTime;
    }

    /**
     * Sets the value of the fcreateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFcreateTime(XMLGregorianCalendar value) {
        this.fcreateTime = value;
    }

    /**
     * Gets the value of the fcreatorId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFcreatorId() {
        return fcreatorId;
    }

    /**
     * Sets the value of the fcreatorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFcreatorId(String value) {
        this.fcreatorId = value;
    }

    /**
     * Gets the value of the fdescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFdescription() {
        return fdescription;
    }

    /**
     * Sets the value of the fdescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFdescription(String value) {
        this.fdescription = value;
    }

    /**
     * Gets the value of the ffivouchered property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFfivouchered() {
        return ffivouchered;
    }

    /**
     * Sets the value of the ffivouchered property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFfivouchered(Long value) {
        this.ffivouchered = value;
    }

    /**
     * Gets the value of the fgcneedLsit property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFgcneedLsit() {
        return fgcneedLsit;
    }

    /**
     * Sets the value of the fgcneedLsit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFgcneedLsit(Long value) {
        this.fgcneedLsit = value;
    }

    /**
     * Gets the value of the fgfneedList property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFgfneedList() {
        return fgfneedList;
    }

    /**
     * Sets the value of the fgfneedList property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFgfneedList(Long value) {
        this.fgfneedList = value;
    }

    /**
     * Gets the value of the fhandlerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFhandlerId() {
        return fhandlerId;
    }

    /**
     * Sets the value of the fhandlerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFhandlerId(String value) {
        this.fhandlerId = value;
    }

    /**
     * Gets the value of the fhasEffected property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFhasEffected() {
        return fhasEffected;
    }

    /**
     * Sets the value of the fhasEffected property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFhasEffected(Long value) {
        this.fhasEffected = value;
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
     * Gets the value of the fisPur property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFisPur() {
        return fisPur;
    }

    /**
     * Sets the value of the fisPur property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFisPur(Long value) {
        this.fisPur = value;
    }

    /**
     * Gets the value of the fisl property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFisl() {
        return fisl;
    }

    /**
     * Sets the value of the fisl property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFisl(Long value) {
        this.fisl = value;
    }

    /**
     * Gets the value of the flastUpdateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFlastUpdateTime() {
        return flastUpdateTime;
    }

    /**
     * Sets the value of the flastUpdateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFlastUpdateTime(XMLGregorianCalendar value) {
        this.flastUpdateTime = value;
    }

    /**
     * Gets the value of the flastUpdateUserId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlastUpdateUserId() {
        return flastUpdateUserId;
    }

    /**
     * Sets the value of the flastUpdateUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlastUpdateUserId(String value) {
        this.flastUpdateUserId = value;
    }

    /**
     * Gets the value of the fneedType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFneedType() {
        return fneedType;
    }

    /**
     * Sets the value of the fneedType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFneedType(String value) {
        this.fneedType = value;
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
     * Gets the value of the fproName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFproName() {
        return fproName;
    }

    /**
     * Sets the value of the fproName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFproName(String value) {
        this.fproName = value;
    }

    /**
     * Gets the value of the fproNumberId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFproNumberId() {
        return fproNumberId;
    }

    /**
     * Sets the value of the fproNumberId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFproNumberId(String value) {
        this.fproNumberId = value;
    }

    /**
     * Gets the value of the fsonNeedList property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFsonNeedList() {
        return fsonNeedList;
    }

    /**
     * Sets the value of the fsonNeedList property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFsonNeedList(Long value) {
        this.fsonNeedList = value;
    }

    /**
     * Gets the value of the fsourceBillId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFsourceBillId() {
        return fsourceBillId;
    }

    /**
     * Sets the value of the fsourceBillId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFsourceBillId(String value) {
        this.fsourceBillId = value;
    }

    /**
     * Gets the value of the fsourceFunction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFsourceFunction() {
        return fsourceFunction;
    }

    /**
     * Sets the value of the fsourceFunction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFsourceFunction(String value) {
        this.fsourceFunction = value;
    }

    /**
     * Gets the value of the fswcNeedList property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFswcNeedList() {
        return fswcNeedList;
    }

    /**
     * Sets the value of the fswcNeedList property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFswcNeedList(Long value) {
        this.fswcNeedList = value;
    }

    /**
     * Gets the value of the ftickedOrgId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFtickedOrgId() {
        return ftickedOrgId;
    }

    /**
     * Sets the value of the ftickedOrgId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFtickedOrgId(String value) {
        this.ftickedOrgId = value;
    }

    /**
     * Gets the value of the userCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * Sets the value of the userCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserCode(String value) {
        this.userCode = value;
    }

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

}

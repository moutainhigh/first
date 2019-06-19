
package com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import com.deppon.montal.util.FormatUtil;


/**
 * <p>Java class for projectSourceEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="projectSourceEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}baseEntity">
 *       &lt;sequence>
 *         &lt;element name="applyDeptId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="applyDeptName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="applyPersonName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="applyPersonNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deptName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deptStandCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fappliedmatterid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fappliedmatteridname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fapplitypeid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fapplitypeidname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fauditorid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fbizdate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fbudgetamount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="fcomquali" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fconstructiontypei" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fconstructiontypeiname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fcontactpersonid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fcontactpersonidname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fcontrolunitid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fcreateorgid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fcreatetime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fcreatorid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fdescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fexpdelitime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fexpectendtime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ffivouchered" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="fhandlerid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fhaseffected" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="fid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flastupdatetime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="flastupdateuserid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fmeasurearea" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="fnumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fotherrequire" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fprojectadd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fprojectcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fprojectlevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fprojectlevelname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fprojectname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fprojectnumberid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fprojecttpye" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fprojecttpyename" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fqualityrequire" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fregistcapital" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="frequestsno" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="fsourcebillid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fsourcefunction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fstaffproawards" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fstate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fstrategy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ftechrequire" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fteleno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fvolumecodid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fvolumecodidnum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="projectcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "projectSourceEntity", propOrder = {
    "applyDeptId",
    "applyDeptName",
    "applyPersonName",
    "applyPersonNo",
    "deptName",
    "deptStandCode",
    "fappliedmatterid",
    "fappliedmatteridname",
    "fapplitypeid",
    "fapplitypeidname",
    "fauditorid",
    "fbizdate",
    "fbudgetamount",
    "fcomquali",
    "fconstructiontypei",
    "fconstructiontypeiname",
    "fcontactpersonid",
    "fcontactpersonidname",
    "fcontrolunitid",
    "fcreateorgid",
    "fcreatetime",
    "fcreatorid",
    "fdescription",
    "fexpdelitime",
    "fexpectendtime",
    "ffivouchered",
    "fhandlerid",
    "fhaseffected",
    "fid",
    "flastupdatetime",
    "flastupdateuserid",
    "fmeasurearea",
    "fnumber",
    "fotherrequire",
    "fprojectadd",
    "fprojectcode",
    "fprojectlevel",
    "fprojectlevelname",
    "fprojectname",
    "fprojectnumberid",
    "fprojecttpye",
    "fprojecttpyename",
    "fqualityrequire",
    "fregistcapital",
    "frequestsno",
    "fsourcebillid",
    "fsourcefunction",
    "fstaffproawards",
    "fstate",
    "fstrategy",
    "ftechrequire",
    "fteleno",
    "fvolumecodid",
    "fvolumecodidnum",
    "projectcode",
    "userCode",
    "userName"
})
public class ProjectSourceEntity
    extends BaseEntity
{

    protected String applyDeptId;
    protected String applyDeptName;
    protected String applyPersonName;
    protected String applyPersonNo;
    protected String deptName;
    protected String deptStandCode;
    protected String fappliedmatterid;
    protected String fappliedmatteridname;
    protected String fapplitypeid;
    protected String fapplitypeidname;
    protected String fauditorid;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fbizdate;
    protected BigDecimal fbudgetamount;
    protected String fcomquali;
    protected String fconstructiontypei;
    protected String fconstructiontypeiname;
    protected String fcontactpersonid;
    protected String fcontactpersonidname;
    protected String fcontrolunitid;
    protected String fcreateorgid;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fcreatetime;
    protected String fcreatorid;
    protected String fdescription;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fexpdelitime;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fexpectendtime;
    protected Integer ffivouchered;
    protected String fhandlerid;
    protected Integer fhaseffected;
    protected String fid;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar flastupdatetime;
    protected String flastupdateuserid;
    protected BigDecimal fmeasurearea;
    protected String fnumber;
    protected String fotherrequire;
    protected String fprojectadd;
    protected String fprojectcode;
    protected String fprojectlevel;
    protected String fprojectlevelname;
    protected String fprojectname;
    protected String fprojectnumberid;
    protected String fprojecttpye;
    protected String fprojecttpyename;
    protected String fqualityrequire;
    protected BigDecimal fregistcapital;
    protected Integer frequestsno;
    protected String fsourcebillid;
    protected String fsourcefunction;
    protected String fstaffproawards;
    protected String fstate;
    protected String fstrategy;
    protected String ftechrequire;
    protected String fteleno;
    protected String fvolumecodid;
    protected String fvolumecodidnum;
    protected String projectcode;
    protected String userCode;
    protected String userName;

    /**
     * Gets the value of the applyDeptId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyDeptId() {
        return applyDeptId;
    }

    /**
     * Sets the value of the applyDeptId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyDeptId(String value) {
        this.applyDeptId = value;
    }

    /**
     * Gets the value of the applyDeptName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyDeptName() {
        return applyDeptName == null ? "":applyDeptName;
    }

    /**
     * Sets the value of the applyDeptName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyDeptName(String value) {
        this.applyDeptName = value;
    }

    /**
     * Gets the value of the applyPersonName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyPersonName() {
        return applyPersonName == null ? "":applyPersonName;
    }

    /**
     * Sets the value of the applyPersonName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyPersonName(String value) {
        this.applyPersonName = value;
    }

    /**
     * Gets the value of the applyPersonNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyPersonNo() {
        return applyPersonNo;
    }

    /**
     * Sets the value of the applyPersonNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyPersonNo(String value) {
        this.applyPersonNo = value;
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
     * Gets the value of the fappliedmatterid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFappliedmatterid() {
        return fappliedmatterid;
    }

    /**
     * Sets the value of the fappliedmatterid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFappliedmatterid(String value) {
        this.fappliedmatterid = value;
    }

    /**
     * Gets the value of the fappliedmatteridname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFappliedmatteridname() {
        return fappliedmatteridname == null ? "" : fappliedmatteridname;
    }

    /**
     * Sets the value of the fappliedmatteridname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFappliedmatteridname(String value) {
        this.fappliedmatteridname = value;
    }

    /**
     * Gets the value of the fapplitypeid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFapplitypeid() {
        return fapplitypeid;
    }

    /**
     * Sets the value of the fapplitypeid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFapplitypeid(String value) {
        this.fapplitypeid = value;
    }

    /**
     * Gets the value of the fapplitypeidname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFapplitypeidname() {
        return fapplitypeidname == null ? "" : fapplitypeidname;
    }

    /**
     * Sets the value of the fapplitypeidname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFapplitypeidname(String value) {
        this.fapplitypeidname = value;
    }

    /**
     * Gets the value of the fauditorid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFauditorid() {
        return fauditorid;
    }

    /**
     * Sets the value of the fauditorid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFauditorid(String value) {
        this.fauditorid = value;
    }

    /**
     * Gets the value of the fbizdate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFbizdate() {
        return fbizdate;
    }
    public String getFbizdateStr() {
        return FormatUtil.formatDate(fbizdate, "yyyy-MM-dd");
    }
    /**
     * Sets the value of the fbizdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFbizdate(XMLGregorianCalendar value) {
        this.fbizdate = value;
    }

    /**
     * Gets the value of the fbudgetamount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFbudgetamount() {
        return fbudgetamount;
    }

    public String getFbudgetamountStr() {
    	if (fbudgetamount == null) {
    		return "";
    	}
        return fbudgetamount + "";
    }
    /**
     * Sets the value of the fbudgetamount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFbudgetamount(BigDecimal value) {
        this.fbudgetamount = value;
    }

    /**
     * Gets the value of the fcomquali property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFcomquali() {
        return fcomquali == null ? "" : fcomquali;
    }

    /**
     * Sets the value of the fcomquali property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFcomquali(String value) {
        this.fcomquali = value;
    }

    /**
     * Gets the value of the fconstructiontypei property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFconstructiontypei() {
        return fconstructiontypei;
    }

    /**
     * Sets the value of the fconstructiontypei property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFconstructiontypei(String value) {
        this.fconstructiontypei = value;
    }

    /**
     * Gets the value of the fconstructiontypeiname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFconstructiontypeiname() {
        return fconstructiontypeiname == null ? "" : fconstructiontypeiname;
    }

    /**
     * Sets the value of the fconstructiontypeiname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFconstructiontypeiname(String value) {
        this.fconstructiontypeiname = value;
    }

    /**
     * Gets the value of the fcontactpersonid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFcontactpersonid() {
        return fcontactpersonid;
    }

    /**
     * Sets the value of the fcontactpersonid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFcontactpersonid(String value) {
        this.fcontactpersonid = value;
    }

    /**
     * Gets the value of the fcontactpersonidname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFcontactpersonidname() {
        return fcontactpersonidname == null ? "" : fcontactpersonidname;
    }

    /**
     * Sets the value of the fcontactpersonidname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFcontactpersonidname(String value) {
        this.fcontactpersonidname = value;
    }

    /**
     * Gets the value of the fcontrolunitid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFcontrolunitid() {
        return fcontrolunitid;
    }

    /**
     * Sets the value of the fcontrolunitid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFcontrolunitid(String value) {
        this.fcontrolunitid = value;
    }

    /**
     * Gets the value of the fcreateorgid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFcreateorgid() {
        return fcreateorgid;
    }

    /**
     * Sets the value of the fcreateorgid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFcreateorgid(String value) {
        this.fcreateorgid = value;
    }

    /**
     * Gets the value of the fcreatetime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFcreatetime() {
        return fcreatetime;
    }
    public String getFcreatetimeStr() {
        return FormatUtil.formatDate(fcreatetime, "yyyy-MM-dd");
    }
    /**
     * Sets the value of the fcreatetime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFcreatetime(XMLGregorianCalendar value) {
        this.fcreatetime = value;
    }

    /**
     * Gets the value of the fcreatorid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFcreatorid() {
        return fcreatorid;
    }

    /**
     * Sets the value of the fcreatorid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFcreatorid(String value) {
        this.fcreatorid = value;
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
     * Gets the value of the fexpdelitime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFexpdelitime() {
        return fexpdelitime;
    }
    public String getFexpdelitimeStr() {
        return FormatUtil.formatDate(fexpdelitime, "yyyy-MM-dd");
    }

    /**
     * Sets the value of the fexpdelitime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFexpdelitime(XMLGregorianCalendar value) {
        this.fexpdelitime = value;
    }

    /**
     * Gets the value of the fexpectendtime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFexpectendtime() {
        return fexpectendtime;
    }
    
    public String getFexpectendtimeStr() {
        return FormatUtil.formatDate(fexpectendtime, "yyyy-MM-dd");
    }


    /**
     * Sets the value of the fexpectendtime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFexpectendtime(XMLGregorianCalendar value) {
        this.fexpectendtime = value;
    }

    /**
     * Gets the value of the ffivouchered property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFfivouchered() {
        return ffivouchered;
    }

    /**
     * Sets the value of the ffivouchered property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFfivouchered(Integer value) {
        this.ffivouchered = value;
    }

    /**
     * Gets the value of the fhandlerid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFhandlerid() {
        return fhandlerid;
    }

    /**
     * Sets the value of the fhandlerid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFhandlerid(String value) {
        this.fhandlerid = value;
    }

    /**
     * Gets the value of the fhaseffected property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFhaseffected() {
        return fhaseffected;
    }

    /**
     * Sets the value of the fhaseffected property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFhaseffected(Integer value) {
        this.fhaseffected = value;
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
     * Gets the value of the flastupdatetime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFlastupdatetime() {
        return flastupdatetime;
    }

    /**
     * Sets the value of the flastupdatetime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFlastupdatetime(XMLGregorianCalendar value) {
        this.flastupdatetime = value;
    }

    /**
     * Gets the value of the flastupdateuserid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlastupdateuserid() {
        return flastupdateuserid;
    }

    /**
     * Sets the value of the flastupdateuserid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlastupdateuserid(String value) {
        this.flastupdateuserid = value;
    }

    /**
     * Gets the value of the fmeasurearea property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFmeasurearea() {
        return fmeasurearea;
    }
    public String getFmeasureareaStr() {
    	if (fmeasurearea == null) {
    		return "";
    	}
        return fmeasurearea + "";
    }

    /**
     * Sets the value of the fmeasurearea property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFmeasurearea(BigDecimal value) {
        this.fmeasurearea = value;
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
        return fnumber == null ? "" :fnumber;
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
     * Gets the value of the fotherrequire property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFotherrequire() {
        return fotherrequire == null ? "" : fotherrequire;
    }

    /**
     * Sets the value of the fotherrequire property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFotherrequire(String value) {
        this.fotherrequire = value;
    }

    /**
     * Gets the value of the fprojectadd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFprojectadd() {
        return fprojectadd  == null ? "" : fprojectadd;
    }

    /**
     * Sets the value of the fprojectadd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFprojectadd(String value) {
        this.fprojectadd = value;
    }

    /**
     * Gets the value of the fprojectcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFprojectcode() {
        return fprojectcode == null ? "" : fprojectcode;
    }

    /**
     * Sets the value of the fprojectcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFprojectcode(String value) {
        this.fprojectcode = value;
    }

    /**
     * Gets the value of the fprojectlevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFprojectlevel() {
        return fprojectlevel;
    }

    /**
     * Sets the value of the fprojectlevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFprojectlevel(String value) {
        this.fprojectlevel = value;
    }

    /**
     * Gets the value of the fprojectlevelname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFprojectlevelname() {
        return fprojectlevelname == null ? "" : fprojectlevelname;
    }

    /**
     * Sets the value of the fprojectlevelname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFprojectlevelname(String value) {
        this.fprojectlevelname = value;
    }

    /**
     * Gets the value of the fprojectname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFprojectname() {
        return fprojectname == null ? "" : fprojectname;
    }

    /**
     * Sets the value of the fprojectname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFprojectname(String value) {
        this.fprojectname = value;
    }

    /**
     * Gets the value of the fprojectnumberid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFprojectnumberid() {
        return fprojectnumberid;
    }

    /**
     * Sets the value of the fprojectnumberid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFprojectnumberid(String value) {
        this.fprojectnumberid = value;
    }

    /**
     * Gets the value of the fprojecttpye property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFprojecttpye() {
        return fprojecttpye == null ? "" : fprojecttpye;
    }

    /**
     * Sets the value of the fprojecttpye property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFprojecttpye(String value) {
        this.fprojecttpye = value;
    }

    /**
     * Gets the value of the fprojecttpyename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFprojecttpyename() {
        return fprojecttpyename == null ? "" : fprojecttpyename;
    }

    /**
     * Sets the value of the fprojecttpyename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFprojecttpyename(String value) {
        this.fprojecttpyename = value;
    }

    /**
     * Gets the value of the fqualityrequire property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFqualityrequire() {
        return fqualityrequire == null ? "" : fqualityrequire;
    }

    /**
     * Sets the value of the fqualityrequire property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFqualityrequire(String value) {
        this.fqualityrequire = value;
    }

    /**
     * Gets the value of the fregistcapital property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFregistcapital() {
        return fregistcapital;
    }
    public String getFregistcapitalStr() {
        return FormatUtil.formatMoney(fregistcapital);
    }

    /**
     * Sets the value of the fregistcapital property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFregistcapital(BigDecimal value) {
        this.fregistcapital = value;
    }

    /**
     * Gets the value of the frequestsno property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFrequestsno() {
        return frequestsno;
    }
    public String getFrequestsnoStr() {
    	if (frequestsno == null) {
    		return "";
    	}
        return frequestsno + "";
    }

    /**
     * Sets the value of the frequestsno property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFrequestsno(Integer value) {
        this.frequestsno = value;
    }

    /**
     * Gets the value of the fsourcebillid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFsourcebillid() {
        return fsourcebillid;
    }

    /**
     * Sets the value of the fsourcebillid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFsourcebillid(String value) {
        this.fsourcebillid = value;
    }

    /**
     * Gets the value of the fsourcefunction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFsourcefunction() {
        return fsourcefunction;
    }

    /**
     * Sets the value of the fsourcefunction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFsourcefunction(String value) {
        this.fsourcefunction = value;
    }

    /**
     * Gets the value of the fstaffproawards property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFstaffproawards() {
        return fstaffproawards == null ? "" : fstaffproawards;
    }

    /**
     * Sets the value of the fstaffproawards property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFstaffproawards(String value) {
        this.fstaffproawards = value;
    }

    /**
     * Gets the value of the fstate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFstate() {
        return fstate;
    }

    /**
     * Sets the value of the fstate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFstate(String value) {
        this.fstate = value;
    }

    /**
     * Gets the value of the fstrategy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFstrategy() {
        return fstrategy;
    }

    /**
     * Sets the value of the fstrategy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFstrategy(String value) {
        this.fstrategy = value;
    }

    /**
     * Gets the value of the ftechrequire property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFtechrequire() {
        return ftechrequire == null ? "" : ftechrequire;
    }

    /**
     * Sets the value of the ftechrequire property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFtechrequire(String value) {
        this.ftechrequire = value;
    }

    /**
     * Gets the value of the fteleno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFteleno() {
        return fteleno == null ? "" : fteleno;
    }

    /**
     * Sets the value of the fteleno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFteleno(String value) {
        this.fteleno = value;
    }

    /**
     * Gets the value of the fvolumecodid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFvolumecodid() {
        return fvolumecodid;
    }

    /**
     * Sets the value of the fvolumecodid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFvolumecodid(String value) {
        this.fvolumecodid = value;
    }

    /**
     * Gets the value of the fvolumecodidnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFvolumecodidnum() {
        return fvolumecodidnum == null ? "" : fvolumecodidnum;
    }

    /**
     * Sets the value of the fvolumecodidnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFvolumecodidnum(String value) {
        this.fvolumecodidnum = value;
    }

    /**
     * Gets the value of the projectcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProjectcode() {
    	if (projectcode == null) {
    		projectcode = "";
    	}
        return projectcode;
    }

    /**
     * Sets the value of the projectcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProjectcode(String value) {
        this.projectcode = value;
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

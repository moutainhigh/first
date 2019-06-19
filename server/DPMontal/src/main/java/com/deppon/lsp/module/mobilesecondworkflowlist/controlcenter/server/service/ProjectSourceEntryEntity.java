
package com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for projectSourceEntryEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="projectSourceEntryEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}baseEntity">
 *       &lt;sequence>
 *         &lt;element name="famount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="fcomment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fgoodscoding" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fitemnameid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fitemnameidname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fitemtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fparentid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fprodspecifi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fseq" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="funit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "projectSourceEntryEntity", propOrder = {
    "famount",
    "fcomment",
    "fgoodscoding",
    "fid",
    "fitemnameid",
    "fitemnameidname",
    "fitemtype",
    "fparentid",
    "fprodspecifi",
    "fseq",
    "funit"
})
public class ProjectSourceEntryEntity
    extends BaseEntity
{

    protected BigDecimal famount;
    protected String fcomment;
    protected String fgoodscoding;
    protected String fid;
    protected String fitemnameid;
    protected String fitemnameidname;
    protected String fitemtype;
    protected String fparentid;
    protected String fprodspecifi;
    protected Integer fseq;
    protected String funit;

    /**
     * Gets the value of the famount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFamount() {
        return famount;
    }
    
    public String getFamountStr() {
    	if (famount == null) {
    		return "";
    	}
        return famount + "";
    }

    /**
     * Sets the value of the famount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFamount(BigDecimal value) {
        this.famount = value;
    }

    /**
     * Gets the value of the fcomment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFcomment() {
        return fcomment == null ? "" : fcomment;
    }

    /**
     * Sets the value of the fcomment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFcomment(String value) {
        this.fcomment = value;
    }

    /**
     * Gets the value of the fgoodscoding property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFgoodscoding() {
        return fgoodscoding == null ? "" : fgoodscoding;
    }

    /**
     * Sets the value of the fgoodscoding property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFgoodscoding(String value) {
        this.fgoodscoding = value;
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
     * Gets the value of the fitemnameid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFitemnameid() {
        return fitemnameid;
    }

    /**
     * Sets the value of the fitemnameid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFitemnameid(String value) {
        this.fitemnameid = value;
    }

    /**
     * Gets the value of the fitemnameidname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFitemnameidname() {
        return fitemnameidname == null ? "" : fitemnameidname;
    }

    /**
     * Sets the value of the fitemnameidname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFitemnameidname(String value) {
        this.fitemnameidname = value;
    }

    /**
     * Gets the value of the fitemtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFitemtype() {
        return fitemtype == null ? "" : fitemtype;
    }

    /**
     * Sets the value of the fitemtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFitemtype(String value) {
        this.fitemtype = value;
    }

    /**
     * Gets the value of the fparentid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFparentid() {
        return fparentid;
    }

    /**
     * Sets the value of the fparentid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFparentid(String value) {
        this.fparentid = value;
    }

    /**
     * Gets the value of the fprodspecifi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFprodspecifi() {
        return fprodspecifi == null ? "" : fprodspecifi;
    }

    /**
     * Sets the value of the fprodspecifi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFprodspecifi(String value) {
        this.fprodspecifi = value;
    }

    /**
     * Gets the value of the fseq property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFseq() {
        return fseq;
    }

    /**
     * Sets the value of the fseq property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFseq(Integer value) {
        this.fseq = value;
    }

    /**
     * Gets the value of the funit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFunit() {
        return funit == null ? "" : funit;
    }

    /**
     * Sets the value of the funit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFunit(String value) {
        this.funit = value;
    }

}


package com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for materialAttEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="materialAttEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}baseEntity">
 *       &lt;sequence>
 *         &lt;element name="controlUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="createTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="creatorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descSimpleChinese" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descTraChinese" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fdemandtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastUpdatTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="lastUpdateUsername" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nameChinese" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="npname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="simpleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="traChinese" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "materialAttEntity", propOrder = {
    "controlUnit",
    "createTime",
    "creatorName",
    "descSimpleChinese",
    "descTraChinese",
    "descname",
    "fdemandtype",
    "lastUpdatTime",
    "lastUpdateUsername",
    "nameChinese",
    "npname",
    "number",
    "simpleName",
    "traChinese"
})
public class MaterialAttEntity
    extends BaseEntity
{

    protected String controlUnit;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createTime;
    protected String creatorName;
    protected String descSimpleChinese;
    protected String descTraChinese;
    protected String descname;
    protected String fdemandtype;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdatTime;
    protected String lastUpdateUsername;
    protected String nameChinese;
    protected String npname;
    protected String number;
    protected String simpleName;
    protected String traChinese;

    /**
     * Gets the value of the controlUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getControlUnit() {
        return controlUnit;
    }

    /**
     * Sets the value of the controlUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setControlUnit(String value) {
        this.controlUnit = value;
    }

    /**
     * Gets the value of the createTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreateTime() {
        return createTime;
    }

    /**
     * Sets the value of the createTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreateTime(XMLGregorianCalendar value) {
        this.createTime = value;
    }

    /**
     * Gets the value of the creatorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatorName() {
        return creatorName == null ? "" : creatorName;
    }

    /**
     * Sets the value of the creatorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatorName(String value) {
        this.creatorName = value;
    }

    /**
     * Gets the value of the descSimpleChinese property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescSimpleChinese() {
        return descSimpleChinese;
    }

    /**
     * Sets the value of the descSimpleChinese property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescSimpleChinese(String value) {
        this.descSimpleChinese = value;
    }

    /**
     * Gets the value of the descTraChinese property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescTraChinese() {
        return descTraChinese;
    }

    /**
     * Sets the value of the descTraChinese property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescTraChinese(String value) {
        this.descTraChinese = value;
    }

    /**
     * Gets the value of the descname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescname() {
        return descname;
    }

    /**
     * Sets the value of the descname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescname(String value) {
        this.descname = value;
    }

    /**
     * Gets the value of the fdemandtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFdemandtype() {
        return fdemandtype;
    }

    /**
     * Sets the value of the fdemandtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFdemandtype(String value) {
        this.fdemandtype = value;
    }

    /**
     * Gets the value of the lastUpdatTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastUpdatTime() {
        return lastUpdatTime;
    }

    /**
     * Sets the value of the lastUpdatTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastUpdatTime(XMLGregorianCalendar value) {
        this.lastUpdatTime = value;
    }

    /**
     * Gets the value of the lastUpdateUsername property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastUpdateUsername() {
        return lastUpdateUsername;
    }

    /**
     * Sets the value of the lastUpdateUsername property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastUpdateUsername(String value) {
        this.lastUpdateUsername = value;
    }

    /**
     * Gets the value of the nameChinese property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameChinese() {
        return nameChinese == null ? "" : nameChinese;
    }

    /**
     * Sets the value of the nameChinese property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameChinese(String value) {
        this.nameChinese = value;
    }

    /**
     * Gets the value of the npname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNpname() {
        return npname;
    }

    /**
     * Sets the value of the npname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNpname(String value) {
        this.npname = value;
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
     * Gets the value of the traChinese property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTraChinese() {
        return traChinese;
    }

    /**
     * Sets the value of the traChinese property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTraChinese(String value) {
        this.traChinese = value;
    }

}


package com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for measureUnit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="measureUnit">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}baseEntity">
 *       &lt;sequence>
 *         &lt;element name="coefficient" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="groupunit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isbaseunit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "measureUnit", propOrder = {
    "coefficient",
    "groupunit",
    "isbaseunit",
    "name",
    "number"
})
public class MeasureUnit
    extends BaseEntity
{

    protected float coefficient;
    protected String groupunit;
    protected String isbaseunit;
    protected String name;
    protected String number;

    /**
     * Gets the value of the coefficient property.
     * 
     */
    public float getCoefficient() {
        return coefficient;
    }

    /**
     * Sets the value of the coefficient property.
     * 
     */
    public void setCoefficient(float value) {
        this.coefficient = value;
    }

    /**
     * Gets the value of the groupunit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupunit() {
        return groupunit;
    }

    /**
     * Sets the value of the groupunit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupunit(String value) {
        this.groupunit = value;
    }

    /**
     * Gets the value of the isbaseunit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsbaseunit() {
        return isbaseunit;
    }

    /**
     * Sets the value of the isbaseunit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsbaseunit(String value) {
        this.isbaseunit = value;
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
    	if (name == null) {
    		name = "";
    	}
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

}

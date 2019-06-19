
package com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for planDesignApplyVo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="planDesignApplyVo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="planDesignEntity" type="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}planDesignEntity" minOccurs="0"/>
 *         &lt;element name="planDesignEntryEntity" type="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}planDesignEntryEntity" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "planDesignApplyVo", propOrder = {
    "planDesignEntity",
    "planDesignEntryEntity"
})
public class PlanDesignApplyVo {

    protected PlanDesignEntity planDesignEntity;
    @XmlElement(nillable = true)
    protected List<PlanDesignEntryEntity> planDesignEntryEntity;

    /**
     * Gets the value of the planDesignEntity property.
     * 
     * @return
     *     possible object is
     *     {@link PlanDesignEntity }
     *     
     */
    public PlanDesignEntity getPlanDesignEntity() {
        return planDesignEntity;
    }

    /**
     * Sets the value of the planDesignEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlanDesignEntity }
     *     
     */
    public void setPlanDesignEntity(PlanDesignEntity value) {
        this.planDesignEntity = value;
    }

    /**
     * Gets the value of the planDesignEntryEntity property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the planDesignEntryEntity property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlanDesignEntryEntity().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PlanDesignEntryEntity }
     * 
     * 
     */
    public List<PlanDesignEntryEntity> getPlanDesignEntryEntity() {
        if (planDesignEntryEntity == null) {
            planDesignEntryEntity = new ArrayList<PlanDesignEntryEntity>();
        }
        return this.planDesignEntryEntity;
    }

}

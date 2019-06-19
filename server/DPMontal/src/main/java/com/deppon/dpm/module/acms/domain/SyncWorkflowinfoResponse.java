package com.deppon.dpm.module.acms.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SyncWorkflowinfoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SyncWorkflowinfoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SubSiDiarySetEntity" type="{http://www.deppon.com/acms/inteface/workflow/domain}SubSiDiarySetEntity"/>
 *         &lt;element name="CompanyFillChangeEntity" type="{http://www.deppon.com/acms/inteface/workflow/domain}CompanyFillChangeEntity"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SyncWorkflowinfoResponse", propOrder = {
    "subSiDiarySetEntity",
    "companyFillChangeEntity"
})
public class SyncWorkflowinfoResponse {
	//子公司设立、变更及注销申请
    @XmlElement(name = "SubSiDiarySetEntity", required = true)
    protected SubSiDiarySetEntity subSiDiarySetEntity;
    //证照补办及分公司变更申请 
    @XmlElement(name = "CompanyFillChangeEntity", required = true)
    protected CompanyFillChangeEntity companyFillChangeEntity;

    /**
     * Gets the value of the subSiDiarySetEntity property.
     * 
     * @return
     *     possible object is
     *     {@link SubSiDiarySetEntity }
     *     
     */
    public SubSiDiarySetEntity getSubSiDiarySetEntity() {
        return subSiDiarySetEntity;
    }

    /**
     * Sets the value of the subSiDiarySetEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubSiDiarySetEntity }
     *     
     */
    public void setSubSiDiarySetEntity(SubSiDiarySetEntity value) {
        this.subSiDiarySetEntity = value;
    }

    /**
     * Gets the value of the companyFillChangeEntity property.
     * 
     * @return
     *     possible object is
     *     {@link CompanyFillChangeEntity }
     *     
     */
    public CompanyFillChangeEntity getCompanyFillChangeEntity() {
        return companyFillChangeEntity;
    }

    /**
     * Sets the value of the companyFillChangeEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyFillChangeEntity }
     *     
     */
    public void setCompanyFillChangeEntity(CompanyFillChangeEntity value) {
        this.companyFillChangeEntity = value;
    }

}

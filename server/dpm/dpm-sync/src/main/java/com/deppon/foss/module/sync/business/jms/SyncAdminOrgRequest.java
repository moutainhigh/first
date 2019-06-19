//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.09.03 at 08:31:08 上午 CST 
//


package com.deppon.foss.module.sync.business.jms;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				UUMS发送至业务系统行政组织数据，由UUMS负责统一维护公司行政组织信息；
 * 			
 * 
 * <p>Java class for SyncAdminOrgRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SyncAdminOrgRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adminOrgInfo" type="{http://www.deppon.com/uums/inteface/domain/usermanagement}AdminOrgInfo" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SyncAdminOrgRequest", propOrder = {
    "adminOrgInfo"
})
public class SyncAdminOrgRequest {

    @XmlElement(required = true)
    protected List<AdminOrgInfo> adminOrgInfo;

    /**
     * Gets the value of the adminOrgInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adminOrgInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdminOrgInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdminOrgInfo }
     * 
     * 
     */
    public List<AdminOrgInfo> getAdminOrgInfo() {
        if (adminOrgInfo == null) {
            adminOrgInfo = new ArrayList<AdminOrgInfo>();
        }
        return this.adminOrgInfo;
    }

	public void setAdminOrgInfo(List<AdminOrgInfo> adminOrgInfo) {
		this.adminOrgInfo = adminOrgInfo;
	}
    
    

}

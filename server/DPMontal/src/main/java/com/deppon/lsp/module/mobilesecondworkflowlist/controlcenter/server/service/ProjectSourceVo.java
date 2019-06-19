
package com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for projectSourceVo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="projectSourceVo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="billlist" type="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}projectSourceEntity" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="entryList" type="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}projectSourceEntryEntity" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "projectSourceVo", propOrder = {
    "billlist",
    "entryList"
})
public class ProjectSourceVo {

    @XmlElement(nillable = true)
    protected List<ProjectSourceEntity> billlist;
    @XmlElement(nillable = true)
    protected List<ProjectSourceEntryEntity> entryList;

    /**
     * Gets the value of the billlist property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the billlist property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBilllist().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProjectSourceEntity }
     * 
     * 
     */
    public List<ProjectSourceEntity> getBilllist() {
        if (billlist == null) {
            billlist = new ArrayList<ProjectSourceEntity>();
        }
        return this.billlist;
    }

    /**
     * Gets the value of the entryList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entryList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntryList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProjectSourceEntryEntity }
     * 
     * 
     */
    public List<ProjectSourceEntryEntity> getEntryList() {
        if (entryList == null) {
            entryList = new ArrayList<ProjectSourceEntryEntity>();
        }
        return this.entryList;
    }

}

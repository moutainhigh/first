
package com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dailysuppliesVo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dailysuppliesVo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="journalizeDataList" type="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}journalizeData" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="receiptData" type="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}receiptData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dailysuppliesVo", propOrder = {
    "journalizeDataList",
    "receiptData"
})
public class DailysuppliesVo {

    @XmlElement(nillable = true)
    protected List<JournalizeData> journalizeDataList;
    protected ReceiptData receiptData;

    /**
     * Gets the value of the journalizeDataList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the journalizeDataList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJournalizeDataList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JournalizeData }
     * 
     * 
     */
    public List<JournalizeData> getJournalizeDataList() {
        if (journalizeDataList == null) {
            journalizeDataList = new ArrayList<JournalizeData>();
        }
        return this.journalizeDataList;
    }

    /**
     * Gets the value of the receiptData property.
     * 
     * @return
     *     possible object is
     *     {@link ReceiptData }
     *     
     */
    public ReceiptData getReceiptData() {
        return receiptData;
    }

    /**
     * Sets the value of the receiptData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReceiptData }
     *     
     */
    public void setReceiptData(ReceiptData value) {
        this.receiptData = value;
    }

}

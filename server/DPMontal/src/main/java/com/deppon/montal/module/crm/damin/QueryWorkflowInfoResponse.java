
package com.deppon.montal.module.crm.damin;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 会否成功
 * 
 * <p>Java class for QueryWorkflowInfoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QueryWorkflowInfoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contractinfo" type="{http://www.deppon.com/crm/inteface/dpm/domain/}ContractInfo"/>
 *         &lt;element name="IsSucess" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="failReason" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="overPayInfo" type="{http://www.deppon.com/crm/inteface/dpm/domain/}OverpayInfo"/>
 *         &lt;element name="recompenseInfo" type="{http://www.deppon.com/crm/inteface/dpm/domain/}RecompenseInfo"/>
 *         &lt;element name="approvalInfo" type="{http://www.deppon.com/crm/inteface/dpm/domain/}ApprovalInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="fileInfo" type="{http://www.deppon.com/crm/inteface/dpm/domain/}FileInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QueryWorkflowInfoResponse", propOrder = {
    "contractinfo",
    "isSucess",
    "failReason",
    "overPayInfo",
    "recompenseInfo",
    "approvalInfo",
    "fileInfo"
})
public class QueryWorkflowInfoResponse {

    @XmlElement(required = true)
    protected ContractInfo contractinfo;
    @XmlElement(name = "IsSucess")
    protected boolean isSucess;
    @XmlElement(required = true)
    protected String failReason;
    @XmlElement(required = true)
    protected OverpayInfo overPayInfo;
    @XmlElement(required = true)
    protected RecompenseInfo recompenseInfo;
    protected List<ApprovalInfo> approvalInfo;
    protected List<FileInfo> fileInfo;

    /**
     * Gets the value of the contractinfo property.
     * 
     * @return
     *     possible object is
     *     {@link ContractInfo }
     *     
     */
    public ContractInfo getContractinfo() {
        return contractinfo;
    }

    /**
     * Sets the value of the contractinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractInfo }
     *     
     */
    public void setContractinfo(ContractInfo value) {
        this.contractinfo = value;
    }

    /**
     * Gets the value of the isSucess property.
     * 
     */
    public boolean isIsSucess() {
        return isSucess;
    }

    /**
     * Sets the value of the isSucess property.
     * 
     */
    public void setIsSucess(boolean value) {
        this.isSucess = value;
    }

    /**
     * Gets the value of the failReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFailReason() {
        return failReason;
    }

    /**
     * Sets the value of the failReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFailReason(String value) {
        this.failReason = value;
    }

    /**
     * Gets the value of the overPayInfo property.
     * 
     * @return
     *     possible object is
     *     {@link OverpayInfo }
     *     
     */
    public OverpayInfo getOverPayInfo() {
        return overPayInfo;
    }

    /**
     * Sets the value of the overPayInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link OverpayInfo }
     *     
     */
    public void setOverPayInfo(OverpayInfo value) {
        this.overPayInfo = value;
    }

    /**
     * Gets the value of the recompenseInfo property.
     * 
     * @return
     *     possible object is
     *     {@link RecompenseInfo }
     *     
     */
    public RecompenseInfo getRecompenseInfo() {
        return recompenseInfo;
    }

    /**
     * Sets the value of the recompenseInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecompenseInfo }
     *     
     */
    public void setRecompenseInfo(RecompenseInfo value) {
        this.recompenseInfo = value;
    }

    /**
     * Gets the value of the approvalInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the approvalInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApprovalInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ApprovalInfo }
     * 
     * 
     */
    public List<ApprovalInfo> getApprovalInfo() {
        if (approvalInfo == null) {
            approvalInfo = new ArrayList<ApprovalInfo>();
        }
        return this.approvalInfo;
    }

    /**
     * Gets the value of the fileInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fileInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFileInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FileInfo }
     * 
     * 
     */
    public List<FileInfo> getFileInfo() {
        if (fileInfo == null) {
            fileInfo = new ArrayList<FileInfo>();
        }
        return this.fileInfo;
    }

}

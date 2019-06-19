
package com.deppon.wdgh.inteface.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <pre>
 * &lt;complexType name="QueryWorkflowInfoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="newPointDept" type="{http://www.deppon.com/wdgh/inteface/domain/}newPointDept"/>
 *         &lt;element name="NewPointInfo" type="{http://www.deppon.com/wdgh/inteface/domain/}NewPointInfo"/>
 *         &lt;element name="deptInfoModify" type="{http://www.deppon.com/wdgh/inteface/domain/}deptInfoModify"/>
 *         &lt;element name="deptRent" type="{http://www.deppon.com/wdgh/inteface/domain/}deptRent"/>
 *         &lt;element name="modifyscope" type="{http://www.deppon.com/wdgh/inteface/domain/}modifyscope"/>
 *         &lt;element name="deptRevoke" type="{http://www.deppon.com/wdgh/inteface/domain/}deptRevoke"/>
 *         &lt;element name="IsSucess" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="failReason" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="uploadInfos" type="{http://www.deppon.com/wdgh/inteface/domain/}UploadInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="approveInfo" type="{http://www.deppon.com/wdgh/inteface/domain/}ApproveInfo" maxOccurs="unbounded" minOccurs="0"/>
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
    "newPointDept",
    "newPointInfo",
    "deptInfoModify",
    "deptRent",
    "modifyscope",
    "deptRevoke",
    "isSucess",
    "failReason",
    "uploadInfos",
    "approveInfo"
})
public class QueryWorkflowInfoResponse {

    @XmlElement(required = true)
    protected NewPointDept newPointDept;
    @XmlElement(name = "NewPointInfo", required = true)
    protected NewPointInfo newPointInfo;
    //营业部信息更改申请
    @XmlElement(required = true)
    protected DeptInfoModify deptInfoModify;
    //转租/扩租/退租申请工作流
    @XmlElement(required = true)
    protected DeptRent deptRent;
    @XmlElement(required = true)
    protected Modifyscope modifyscope;
    @XmlElement(required = true)
    protected DeptRevoke deptRevoke;
    @XmlElement(name = "IsSucess", required = true)
    protected String isSucess;
    @XmlElement(required = true)
    protected String failReason;
    protected List<UploadInfo> uploadInfos;
    protected List<ApproveInfo> approveInfo;

    /**
     * 
     * @return
     *     possible object is
     *     {@link NewPointDept }
     *     
     */
    public NewPointDept getNewPointDept() {
        return newPointDept;
    }

    /**
     * @param value
     *     allowed object is
     *     {@link NewPointDept }
     *     
     */
    public void setNewPointDept(NewPointDept value) {
        this.newPointDept = value;
    }

    /**
     * @return
     *     possible object is
     *     {@link NewPointInfo }
     *     
     */
    public NewPointInfo getNewPointInfo() {
        return newPointInfo;
    }

    /**
     * @param value
     *     allowed object is
     *     {@link NewPointInfo }
     *     
     */
    public void setNewPointInfo(NewPointInfo value) {
        this.newPointInfo = value;
    }

    /**
     * @return
     *     possible object is
     *     {@link DeptInfoModify }
     *     
     */
    public DeptInfoModify getDeptInfoModify() {
        return deptInfoModify;
    }

    /**
     * @param value
     *     allowed object is
     *     {@link DeptInfoModify }
     *     
     */
    public void setDeptInfoModify(DeptInfoModify value) {
        this.deptInfoModify = value;
    }

    /**
     * @return
     *     possible object is
     *     {@link DeptRent }
     *     
     */
    public DeptRent getDeptRent() {
        return deptRent;
    }

    /**
     * @param value
     *     allowed object is
     *     {@link DeptRent }
     *     
     */
    public void setDeptRent(DeptRent value) {
        this.deptRent = value;
    }

    /**
     * @return
     *     possible object is
     *     {@link Modifyscope }
     *     
     */
    public Modifyscope getModifyscope() {
        return modifyscope;
    }

    /**
     * @param value
     *     allowed object is
     *     {@link Modifyscope }
     *     
     */
    public void setModifyscope(Modifyscope value) {
        this.modifyscope = value;
    }

    /**
     * @return
     *     possible object is
     *     {@link DeptRevoke }
     *     
     */
    public DeptRevoke getDeptRevoke() {
        return deptRevoke;
    }

    /**
     * @param value
     *     allowed object is
     *     {@link DeptRevoke }
     *     
     */
    public void setDeptRevoke(DeptRevoke value) {
        this.deptRevoke = value;
    }

    /**
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsSucess() {
        return isSucess;
    }

    /**
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsSucess(String value) {
        this.isSucess = value;
    }

    /**
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFailReason() {
        return failReason;
    }

    /**
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFailReason(String value) {
        this.failReason = value;
    }

    /**
     * Gets the value of the uploadInfos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the uploadInfos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUploadInfos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UploadInfo }
     * 
     * 
     */
    public List<UploadInfo> getUploadInfos() {
        if (uploadInfos == null) {
            uploadInfos = new ArrayList<UploadInfo>();
        }
        return this.uploadInfos;
    }

    /**
     * Gets the value of the approveInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the approveInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApproveInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ApproveInfo }
     * 
     * 
     */
    public List<ApproveInfo> getApproveInfo() {
        if (approveInfo == null) {
            approveInfo = new ArrayList<ApproveInfo>();
        }
        return this.approveInfo;
    }

}

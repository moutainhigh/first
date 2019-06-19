//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.5-2 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2014.05.17 时间 03:19:34 PM CST 
//


package com.deppon.nhr.module.remote.dpm.shared.domain.workflow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>queryWorkflowInfoResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="queryWorkflowInfoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="positiveInfo" type="{http://www.deppon.com/nhr/module/remote/dpm/shared/domain/workFlow}positiveInfo" minOccurs="0"/>
 *         &lt;element name="recruiterInfo" type="{http://www.deppon.com/nhr/module/remote/dpm/shared/domain/workFlow}recruiterInfo" minOccurs="0"/>
 *         &lt;element name="originInfo" type="{http://www.deppon.com/nhr/module/remote/dpm/shared/domain/workFlow}originInfo" minOccurs="0"/>
 *         &lt;element name="transferInfo" type="{http://www.deppon.com/nhr/module/remote/dpm/shared/domain/workFlow}transferInfo" minOccurs="0"/>
 *         &lt;element name="vacationInfo" type="{http://www.deppon.com/nhr/module/remote/dpm/shared/domain/workFlow}vacationInfo" minOccurs="0"/>
 *         &lt;element name="files" type="{http://www.deppon.com/nhr/module/remote/dpm/shared/domain/workFlow}fileInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="approvalList" type="{http://www.deppon.com/nhr/module/remote/dpm/shared/domain/workFlow}approvalDetail" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queryWorkflowInfoResponse", propOrder = {
    "positiveInfo",
    "recruiterInfo",
    "originInfo",
    "transferInfo",
    "vacationInfo",
    "files",
    "approvalList"
})
public class QueryWorkflowInfoResponse
    implements Serializable
{

    private final static long serialVersionUID = 11082011L;
    //转正工作流明细
    protected PositiveInfo positiveInfo;
    protected RecruiterInfo recruiterInfo;
    protected OriginInfo originInfo;
    protected TransferInfo transferInfo;
    protected VacationInfo vacationInfo;
    protected List<FileInfo> files;
    protected List<ApprovalDetail> approvalList;

    /**
     * 获取positiveInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PositiveInfo }
     *     
     */
    public PositiveInfo getPositiveInfo() {
        return positiveInfo;
    }

    /**
     * 设置positiveInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PositiveInfo }
     *     
     */
    public void setPositiveInfo(PositiveInfo value) {
        this.positiveInfo = value;
    }

    /**
     * 获取recruiterInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link RecruiterInfo }
     *     
     */
    public RecruiterInfo getRecruiterInfo() {
        return recruiterInfo;
    }

    /**
     * 设置recruiterInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RecruiterInfo }
     *     
     */
    public void setRecruiterInfo(RecruiterInfo value) {
        this.recruiterInfo = value;
    }

    /**
     * 获取originInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OriginInfo }
     *     
     */
    public OriginInfo getOriginInfo() {
        return originInfo;
    }

    /**
     * 设置originInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OriginInfo }
     *     
     */
    public void setOriginInfo(OriginInfo value) {
        this.originInfo = value;
    }

    /**
     * 获取transferInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TransferInfo }
     *     
     */
    public TransferInfo getTransferInfo() {
        return transferInfo;
    }

    /**
     * 设置transferInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TransferInfo }
     *     
     */
    public void setTransferInfo(TransferInfo value) {
        this.transferInfo = value;
    }

    /**
     * 获取vacationInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link VacationInfo }
     *     
     */
    public VacationInfo getVacationInfo() {
        return vacationInfo;
    }

    /**
     * 设置vacationInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link VacationInfo }
     *     
     */
    public void setVacationInfo(VacationInfo value) {
        this.vacationInfo = value;
    }

    /**
     * Gets the value of the files property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the files property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFiles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FileInfo }
     * 
     * 
     */
    public List<FileInfo> getFiles() {
        if (files == null) {
            files = new ArrayList<FileInfo>();
        }
        return this.files;
    }

    /**
     * Gets the value of the approvalList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the approvalList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApprovalList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ApprovalDetail }
     * 
     * 
     */
    public List<ApprovalDetail> getApprovalList() {
        if (approvalList == null) {
            approvalList = new ArrayList<ApprovalDetail>();
        }
        return this.approvalList;
    }

}

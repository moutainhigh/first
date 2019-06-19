//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.5-2 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2014.08.11 时间 03:39:59 PM CST 
//


package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>comUtil complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="comUtil">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="approvalInfoList" type="{}approvalInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="attachList" type="{}attachEntity" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="items" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "comUtil", propOrder = {
    "approvalInfoList",
    "attachList",
    "items"
})
public class ComUtil<T> {

    @XmlElement(nillable = true)
    protected List<ApprovalInfo> approvalInfoList;
    @XmlElement(nillable = true)
    protected List<AttachEntity> attachList;
    protected T items;

    /**
     * Gets the value of the approvalInfoList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the approvalInfoList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApprovalInfoList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ApprovalInfo }
     * 
     * 
     */
    public List<ApprovalInfo> getApprovalInfoList() {
        if (approvalInfoList == null) {
            approvalInfoList = new ArrayList<ApprovalInfo>();
        }
        return this.approvalInfoList;
    }

    /**
     * Gets the value of the attachList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttachEntity }
     * 
     * 
     */
    public List<AttachEntity> getAttachList() {
        if (attachList == null) {
            attachList = new ArrayList<AttachEntity>();
        }
        return this.attachList;
    }

    /**
     * 获取items属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public T getItems() {
        return items;
    }

    /**
     * 设置items属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setItems(T value) {
        this.items = value;
    }

	public void setApprovalInfoList(List<ApprovalInfo> approvalInfoList) {
		this.approvalInfoList = approvalInfoList;
	}

	public void setAttachList(List<AttachEntity> attachList) {
		this.attachList = attachList;
	}
}

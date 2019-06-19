//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.5-2 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2014.04.19 时间 09:17:43 AM CST 
//


package com.deppon.nhr.module.remote.dpm.shared.domain.workflow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>recruiterInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="recruiterInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="applypsncode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="wfno" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applypsnname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hrdeptname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="recruitertypename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applyreason" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="totalcount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="recInfoList" type="{http://www.deppon.com/nhr/module/remote/dpm/shared/domain/workFlow}recInfoList" maxOccurs="unbounded"/>
 *         &lt;element name="workflowInfo" type="{http://www.deppon.com/nhr/module/remote/dpm/shared/domain/workFlow}workflowInfo" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recruiterInfo", propOrder = {
    "applypsncode",
    "wfno",
    "applypsnname",
    "hrdeptname",
    "recruitertypename",
    "applyreason",
    "totalcount",
    "recInfoList",
    "workflowInfo"
})
public class RecruiterInfo
implements Serializable
{
	 private final static long serialVersionUID = 11082011L;
	//申请人工号
    @XmlElement(required = true)
    protected String applypsncode;
    //工作流号
    @XmlElement(required = true)
    protected String wfno;
    @XmlElement(required = true)
    //申请人姓名
    protected String applypsnname;
    //当地人事部名称
    @XmlElement(required = true)
    protected String hrdeptname;
    //补员性质
    @XmlElement(required = true)
    protected String recruitertypename;
    //申请事由
    @XmlElement(required = true)
    protected String applyreason;
    //增补员总人数
    protected int totalcount;
    //增补员明细
    @XmlElement(required = true)
    protected List<RecInfoList> recInfoList;
    //大区缺口情况
    @XmlElement(required = true)
    protected List<WorkflowInfo> workflowInfo;

    /**
     * 获取applypsncode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplypsncode() {
        return applypsncode;
    }

    /**
     * 设置applypsncode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplypsncode(String value) {
        this.applypsncode = value;
    }

    /**
     * 获取wfno属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWfno() {
        return wfno;
    }

    /**
     * 设置wfno属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWfno(String value) {
        this.wfno = value;
    }

    /**
     * 获取applypsnname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplypsnname() {
        return applypsnname;
    }

    /**
     * 设置applypsnname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplypsnname(String value) {
        this.applypsnname = value;
    }

    /**
     * 获取hrdeptname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHrdeptname() {
        return hrdeptname;
    }

    /**
     * 设置hrdeptname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHrdeptname(String value) {
        this.hrdeptname = value;
    }

    /**
     * 获取recruitertypename属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecruitertypename() {
        return recruitertypename;
    }

    /**
     * 设置recruitertypename属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecruitertypename(String value) {
        this.recruitertypename = value;
    }

    /**
     * 获取applyreason属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyreason() {
        return applyreason;
    }

    /**
     * 设置applyreason属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyreason(String value) {
        this.applyreason = value;
    }

    /**
     * 获取totalcount属性的值。
     * 
     */
    public int getTotalcount() {
        return totalcount;
    }

    /**
     * 设置totalcount属性的值。
     * 
     */
    public void setTotalcount(int value) {
        this.totalcount = value;
    }

    /**
     * Gets the value of the recInfoList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recInfoList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecInfoList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RecInfoList }
     * 
     * 
     */
    public List<RecInfoList> getRecInfoList() {
        if (recInfoList == null) {
            recInfoList = new ArrayList<RecInfoList>();
        }
        return this.recInfoList;
    }

    /**
     * Gets the value of the workflowInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the workflowInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWorkflowInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WorkflowInfo }
     * 
     * 
     */
    public List<WorkflowInfo> getWorkflowInfo() {
        if (workflowInfo == null) {
            workflowInfo = new ArrayList<WorkflowInfo>();
        }
        return this.workflowInfo;
    }

}

//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.5-2 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2014.04.19 时间 09:17:43 AM CST 
//


package com.deppon.nhr.module.remote.dpm.shared.domain.workflow;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>positiveInfo complex type的 Java 类。
 * 转正工作流明细
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="positiveInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wfno" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applypsncode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applypsnname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="position" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="indate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="applydate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="docnumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="appdeptname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jobtype" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isAttendtrain" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hrdeptname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="passdate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="culture" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="typing" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="profknowledge" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="experience" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="suggestions" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="evaluation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="appreason" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "positiveInfo", propOrder = {
    "wfno",
    "applypsncode",
    "applypsnname",
    "position",
    "indate",
    "applydate",
    "docnumber",
    "appdeptname",
    "jobtype",
    "isAttendtrain",
    "hrdeptname",
    "passdate",
    "culture",
    "typing",
    "profknowledge",
    "experience",
    "suggestions",
    "evaluation",
    "appreason",
    "billing",
    "score",
    "linkads"
})
public class PositiveInfo
    implements Serializable
{

    private final static long serialVersionUID = 11082011L;
    //申请单编码
    @XmlElement(required = true)
    protected String wfno;
    //申请人工号
    @XmlElement(required = true)
    protected String applypsncode;
    //申请人姓名
    @XmlElement(required = true)
    protected String applypsnname;
    //申请人职位
    @XmlElement(required = true)
    protected String position;
    //入职日期
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected Date indate;
    //申请日期
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected Date applydate;
    //身份证号
    @XmlElement(required = true)
    protected String docnumber;
    //申请人部门
    @XmlElement(required = true)
    protected String appdeptname;
    //工作岗位
    @XmlElement(required = true)
    protected String jobtype;
    //是否参加新员工培训(Y:是 N:否)
    @XmlElement(required = true)
    protected String isAttendtrain;
    //所属人事部
    @XmlElement(required = true)
    protected String hrdeptname;
    //考试通过日期
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected Date passdate;
    //企业文化
    protected String culture;
    //打字
    @XmlElement(required = true)
    protected String typing;
    //专业知识
    protected String profknowledge;
    //心得体会
    @XmlElement(required = true)
    protected String experience;
    //对部门、同事、领导的建议
    @XmlElement(required = true)
    protected String suggestions;
    //部门同事评价
    @XmlElement(required = true)
    protected String evaluation;
    //申请原因
    @XmlElement(required = true)
    protected String appreason;
    //开单
    @XmlElement(required = true)
    protected String billing;
    //素质评分
	@XmlElement(required = true)
    protected String score;
	//素质评分链接
    @XmlElement(required = true)
    protected String linkads;

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
     * 获取position属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置position属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosition(String value) {
        this.position = value;
    }

    /**
     * 获取indate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getIndate() {
        return indate;
    }

    /**
     * 设置indate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndate(Date value) {
        this.indate = value;
    }

    /**
     * 获取applydate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getApplydate() {
        return applydate;
    }

    /**
     * 设置applydate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplydate(Date value) {
        this.applydate = value;
    }

    /**
     * 获取docnumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocnumber() {
        return docnumber;
    }

    /**
     * 设置docnumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocnumber(String value) {
        this.docnumber = value;
    }

    /**
     * 获取appdeptname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppdeptname() {
        return appdeptname;
    }

    /**
     * 设置appdeptname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppdeptname(String value) {
        this.appdeptname = value;
    }

    /**
     * 获取jobtype属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobtype() {
        return jobtype;
    }

    /**
     * 设置jobtype属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobtype(String value) {
        this.jobtype = value;
    }

    /**
     * 获取isAttendtrain属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsAttendtrain() {
        return isAttendtrain;
    }

    /**
     * 设置isAttendtrain属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsAttendtrain(String value) {
        this.isAttendtrain = value;
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
     * 获取passdate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getPassdate() {
        return passdate;
    }

    /**
     * 设置passdate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassdate(Date value) {
        this.passdate = value;
    }

    /**
     * 获取culture属性的值。
     * 
     */
    public String getCulture() {
        return culture;
    }

    /**
     * 设置culture属性的值。
     * 
     */
    public void setCulture(String value) {
        this.culture = value;
    }

    /**
     * 获取typing属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTyping() {
        return typing;
    }

    /**
     * 设置typing属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTyping(String value) {
        this.typing = value;
    }

    /**
     * 获取profknowledge属性的值。
     * 
     */
    public String getProfknowledge() {
        return profknowledge;
    }

    /**
     * 设置profknowledge属性的值。
     * 
     */
    public void setProfknowledge(String value) {
        this.profknowledge = value;
    }

    /**
     * 获取experience属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExperience() {
        return experience;
    }

    /**
     * 设置experience属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExperience(String value) {
        this.experience = value;
    }

    /**
     * 获取suggestions属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuggestions() {
        return suggestions;
    }

    /**
     * 设置suggestions属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuggestions(String value) {
        this.suggestions = value;
    }

    /**
     * 获取evaluation属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvaluation() {
        return evaluation;
    }

    /**
     * 设置evaluation属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvaluation(String value) {
        this.evaluation = value;
    }

    /**
     * 获取appreason属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppreason() {
        return appreason;
    }

    /**
     * 设置appreason属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppreason(String value) {
        this.appreason = value;
    }

	public String getBilling() {
		return billing;
	}

	public void setBilling(String billing) {
		this.billing = billing;
	}
    /**
     * Gets the value of the score property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScore() {
        return score;
    }

    /**
     * Sets the value of the score property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScore(String value) {
        this.score = value;
    }

    /**
     * Gets the value of the linkads property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkads() {
        return linkads;
    }

    /**
     * Sets the value of the linkads property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkads(String value) {
        this.linkads = value;
    }

}

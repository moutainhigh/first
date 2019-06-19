//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.5-2 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2014.05.17 时间 03:19:34 PM CST 
//


package com.deppon.nhr.module.remote.dpm.shared.domain.workflow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>vacationInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="vacationInfo">
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
 *         &lt;element name="annualVacationDetailInfo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applydeptname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hrdeptname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applytype" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applytypeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vacationclass" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="weddingday" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="begindate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="enddate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="vacationdays" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="handovername" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vacationwokflowno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="extraworkdays" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vacationdetails" type="{http://www.deppon.com/nhr/module/remote/dpm/shared/domain/workFlow}vacationdetail" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="applyreason" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vacationInfo", propOrder = {
    "wfno",
    "applypsncode",
    "applypsnname",
    "position",
    "indate",
    "applydate",
    "docnumber",
    "annualVacationDetailInfo",
    "applydeptname",
    "hrdeptname",
    "applytype",
    "applytypeCode",
    "vacationclass",
    "weddingday",
    "begindate",
    "enddate",
    "vacationdays",
    "handovername",
    "vacationwokflowno",
    "extraworkdays",
    "vacationdetails",
    "applyreason"
})
public class VacationInfo
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
    //本年度已休假明细
    @XmlElement(required = true)
    protected String annualVacationDetailInfo;
    //所属部门
    @XmlElement(required = true)
    protected String applydeptname;
    //所属区域
    @XmlElement(required = true)
    protected String hrdeptname;
    //申请类型
    @XmlElement(required = true)
    protected String applytype;
    //请假、销假类型
    @XmlElement(required = true)
    protected String applytypeCode;
    //请假、销假类型编码
    @XmlElement(required = true)
    protected String vacationclass;
    //结婚日期
    @XmlSchemaType(name = "dateTime")
    protected Date weddingday;
    //请假、销假开始日期
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected Date begindate;
    //请假、销假结束日期
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected Date enddate;
    //请假、调休、销假天数
    @XmlElement(required = true)
    protected String vacationdays;
    //工作交接人
    @XmlElement(required = true)
    protected String handovername;
    //请假、加班工作流号
    protected String vacationwokflowno;
    //加班天数
    protected String extraworkdays;
    //假期明细
    protected List<Vacationdetail> vacationdetails;
    //申请事由
    @XmlElement(required = true)
    protected String applyreason;

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
     * 获取annualVacationDetailInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnualVacationDetailInfo() {
        return annualVacationDetailInfo;
    }

    /**
     * 设置annualVacationDetailInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *      {@link String }
     *     
     */
    public void setAnnualVacationDetailInfo(String value) {
        this.annualVacationDetailInfo = value;
    }

    /**
     * 获取applydeptname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplydeptname() {
        return applydeptname;
    }

    /**
     * 设置applydeptname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplydeptname(String value) {
        this.applydeptname = value;
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
     * 获取applytype属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplytype() {
        return applytype;
    }

    /**
     * 设置applytype属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplytype(String value) {
        this.applytype = value;
    }
    /**
     * 获取applytypeCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplytypeCode() {
        return applytypeCode;
    }

    /**
     * 设置applytypeCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplytypeCode(String value) {
        this.applytypeCode = value;
    }
    /**
     * 获取vacationclass属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVacationclass() {
        return vacationclass;
    }

    /**
     * 设置vacationclass属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVacationclass(String value) {
        this.vacationclass = value;
    }

    /**
     * 获取weddingday属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getWeddingday() {
        return weddingday;
    }

    /**
     * 设置weddingday属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWeddingday(Date value) {
        this.weddingday = value;
    }

    /**
     * 获取begindate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getBegindate() {
        return begindate;
    }

    /**
     * 设置begindate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBegindate(Date value) {
        this.begindate = value;
    }

    /**
     * 获取enddate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getEnddate() {
        return enddate;
    }

    /**
     * 设置enddate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnddate(Date value) {
        this.enddate = value;
    }

    /**
     * 获取vacationdays属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVacationdays() {
        return vacationdays;
    }

    /**
     * 设置vacationdays属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVacationdays(String value) {
        this.vacationdays = value;
    }

    /**
     * 获取handovername属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHandovername() {
        return handovername;
    }

    /**
     * 设置handovername属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHandovername(String value) {
        this.handovername = value;
    }

    /**
     * 获取vacationwokflowno属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVacationwokflowno() {
        return vacationwokflowno;
    }

    /**
     * 设置vacationwokflowno属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVacationwokflowno(String value) {
        this.vacationwokflowno = value;
    }

    /**
     * 获取extraworkdays属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtraworkdays() {
        return extraworkdays;
    }

    /**
     * 设置extraworkdays属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtraworkdays(String value) {
        this.extraworkdays = value;
    }

    /**
     * Gets the value of the vacationdetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vacationdetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVacationdetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Vacationdetail }
     * 
     * 
     */
    public List<Vacationdetail> getVacationdetails() {
        if (vacationdetails == null) {
            vacationdetails = new ArrayList<Vacationdetail>();
        }
        return this.vacationdetails;
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

}

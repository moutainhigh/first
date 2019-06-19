//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.5-2 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2014.04.19 时间 09:17:43 AM CST 
//
package com.deppon.nhr.module.remote.dpm.shared.domain.workflow;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>recInfoList complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="recInfoList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arrangeposname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="wfno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="departmentType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="usedeptname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="peravgnum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="workline" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="posname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="worktype" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="worklongtime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="recruiterreason" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="popcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mannum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="womannum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="recruiternum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recInfoList", propOrder = {
    "arrangeposname",
    "wfno",
    "departmentType",
    "usedeptname",
    "peravgnum",
    "workline",
    "posname",
    "worktype",
    "worklongtime",
    "recruiterreason",
    "popcode",
    "mannum",
    "womannum",
    "recruiternum"
})
public class RecInfoList
implements Serializable
{
	
	private final static long serialVersionUID = 11082011L;
	//安排职位名称
	@XmlElement(required = true)
    protected String arrangeposname;
	 //异动工作流号
    protected String wfno;
    //部门性质
    @XmlElement(required = true)
    protected String departmentType;
    //用人部门
    @XmlElement(required = true)
    protected String usedeptname;
    //人均货量
    @XmlElement(required = true)
    protected String peravgnum;
    //线路
    @XmlElement(required = true)
    protected String workline;
    //岗位类别
    @XmlElement(required = true)
    protected String posname;
    //上班类型
    @XmlElement(required = true)
    protected String worktype;
    //上班时长
    protected int worklongtime;
    @XmlElement(required = true)
    //增补员原因
    protected String recruiterreason;
    @XmlElement(required = true)
    //弹出编码
    protected String popcode;
    //人数（男）
    protected int mannum;
    //人数（女）
    protected int womannum;
    //增补员人数
    protected int recruiternum;

    /**
     * 获取arrangeposname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArrangeposname() {
        return arrangeposname;
    }

    /**
     * 设置arrangeposname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArrangeposname(String value) {
        this.arrangeposname = value;
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
     * 获取departmentType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartmentType() {
        return departmentType;
    }

    /**
     * 设置departmentType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartmentType(String value) {
        this.departmentType = value;
    }

    /**
     * 获取usedeptname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsedeptname() {
        return usedeptname;
    }

    /**
     * 设置usedeptname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsedeptname(String value) {
        this.usedeptname = value;
    }

    /**
     * 获取peravgnum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeravgnum() {
        return peravgnum;
    }

    /**
     * 设置peravgnum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeravgnum(String value) {
        this.peravgnum = value;
    }

    /**
     * 获取workline属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkline() {
        return workline;
    }

    /**
     * 设置workline属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkline(String value) {
        this.workline = value;
    }

    /**
     * 获取posname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosname() {
        return posname;
    }

    /**
     * 设置posname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosname(String value) {
        this.posname = value;
    }

    /**
     * 获取worktype属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorktype() {
        return worktype;
    }

    /**
     * 设置worktype属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorktype(String value) {
        this.worktype = value;
    }

    /**
     * 获取worklongtime属性的值。
     * 
     */
    public int getWorklongtime() {
        return worklongtime;
    }

    /**
     * 设置worklongtime属性的值。
     * 
     */
    public void setWorklongtime(int value) {
        this.worklongtime = value;
    }

    /**
     * 获取recruiterreason属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecruiterreason() {
        return recruiterreason;
    }

    /**
     * 设置recruiterreason属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecruiterreason(String value) {
        this.recruiterreason = value;
    }

    /**
     * 获取popcode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPopcode() {
        return popcode;
    }

    /**
     * 设置popcode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPopcode(String value) {
        this.popcode = value;
    }

    /**
     * 获取mannum属性的值。
     * 
     */
    public int getMannum() {
        return mannum;
    }

    /**
     * 设置mannum属性的值。
     * 
     */
    public void setMannum(int value) {
        this.mannum = value;
    }

    /**
     * 获取womannum属性的值。
     * 
     */
    public int getWomannum() {
        return womannum;
    }

    /**
     * 设置womannum属性的值。
     * 
     */
    public void setWomannum(int value) {
        this.womannum = value;
    }

    /**
     * 获取recruiternum属性的值。
     * 
     */
    public int getRecruiternum() {
        return recruiternum;
    }

    /**
     * 设置recruiternum属性的值。
     * 
     */
    public void setRecruiternum(int value) {
        this.recruiternum = value;
    }

}

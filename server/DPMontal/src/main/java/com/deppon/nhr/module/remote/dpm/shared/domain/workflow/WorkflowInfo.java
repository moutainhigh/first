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
 * <p>workflowInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="workflowInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deptType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="areaName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="budgetNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nowNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="needNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="allowNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "workflowInfo", propOrder = {
    "deptType",
    "areaName",
    "comment",
    "budgetNum",
    "nowNum",
    "needNum",
    "allowNum"
})
public class WorkflowInfo
implements Serializable
{
	private final static long serialVersionUID = 11082011L;
	//部门性质
	@XmlElement(required = true)
    protected String deptType;
	 //部门所属大区名称
    @XmlElement(required = true)
    protected String areaName;
    //备注
    @XmlElement(required = true)
    protected String comment;
    //预算人数
    protected int budgetNum;
    //现有人数
    protected int nowNum;
    //缺口人数
    protected int needNum;
    //可补员人数
    protected int allowNum;

    /**
     * 获取deptType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeptType() {
        return deptType;
    }

    /**
     * 设置deptType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeptType(String value) {
        this.deptType = value;
    }

    /**
     * 获取areaName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 设置areaName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaName(String value) {
        this.areaName = value;
    }

    /**
     * 获取comment属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置comment属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

    /**
     * 获取budgetNum属性的值。
     * 
     */
    public int getBudgetNum() {
        return budgetNum;
    }

    /**
     * 设置budgetNum属性的值。
     * 
     */
    public void setBudgetNum(int value) {
        this.budgetNum = value;
    }

    /**
     * 获取nowNum属性的值。
     * 
     */
    public int getNowNum() {
        return nowNum;
    }

    /**
     * 设置nowNum属性的值。
     * 
     */
    public void setNowNum(int value) {
        this.nowNum = value;
    }

    /**
     * 获取needNum属性的值。
     * 
     */
    public int getNeedNum() {
        return needNum;
    }

    /**
     * 设置needNum属性的值。
     * 
     */
    public void setNeedNum(int value) {
        this.needNum = value;
    }

    /**
     * 获取allowNum属性的值。
     * 
     */
    public int getAllowNum() {
        return allowNum;
    }

    /**
     * 设置allowNum属性的值。
     * 
     */
    public void setAllowNum(int value) {
        this.allowNum = value;
    }

}

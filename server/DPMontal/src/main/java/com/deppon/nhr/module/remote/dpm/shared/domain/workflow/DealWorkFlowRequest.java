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

import com.deppon.montal.util.InitDataServlet;


/**
 * <p>dealWorkFlowRequest complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="dealWorkFlowRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="workitemid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="decision" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="opinion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="busino" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="backnode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="activityinstid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dealEmpCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dealEmpName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="wfState" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="workFlowType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="spareFieldOne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="spareFieldTwo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="spareFieldThree" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="spareFieldFour" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dealWorkFlowRequest", propOrder = {
    "workitemid",
    "decision",
    "opinion",
    "busino",
    "backnode",
    "activityinstid",
    "dealEmpCode",
    "dealEmpName",
    "wfState",
    "workFlowType",
    "spareFieldOne",
    "spareFieldTwo",
    "spareFieldThree",
    "spareFieldFour"
})
public class DealWorkFlowRequest
    implements Serializable
{

    private final static long serialVersionUID = 11082011L;
    //工作项id
    @XmlElement(required = true)
    protected String workitemid;
    //意见:	同意agree ；不同意disagree; 回退sendback
    @XmlElement(required = true)
    protected String decision;
    //决策:	审批意见
    @XmlElement(required = true)
    protected String opinion;
    //业务编码
    @XmlElement(required = true)
    protected String busino;
    //回退节点
    @XmlElement(required = true)
    protected String backnode;
    //流程实例id
    @XmlElement(required = true)
    protected String activityinstid;
    //审批人工号
    @XmlElement(required = true)
    protected String dealEmpCode;
    //审批人姓名
    @XmlElement(required = true)
    protected String dealEmpName;
    //当前节点：	活动定义id
    @XmlElement(required = true)
    protected String wfState;
    //工作流类型
    @XmlElement(required = true)
    protected String workFlowType;
    protected String spareFieldOne;
    protected String spareFieldTwo;
    protected String spareFieldThree;
    protected String spareFieldFour;
    
    public DealWorkFlowRequest(){}
    

    public DealWorkFlowRequest(String workitemid, String decision,
			String opinion, String busino, String backnode,
			String activityinstid, String dealEmpCode, String dealEmpName,
			String wfState,String processDefName) {
    	String hr_positiveApplication =InitDataServlet.getValue("hr_positiveApplication");
    	String hr_addEmpApply = InitDataServlet.getValue("hr_addEmpApply");
    	String hr_returnDomicileOfOrigin = InitDataServlet.getValue("hr_returnDomicileOfOrigin");
    	String hr_employeeTransactionApply = InitDataServlet.getValue("hr_employeeTransactionApply");
		String hr_leaveDaysOff = InitDataServlet.getValue("hr_leaveDaysOff");
    	this.workitemid = workitemid;
		this.decision = decision;
		this.opinion = opinion;
		this.busino = busino;
		this.backnode = backnode;
		this.activityinstid = activityinstid;
		this.dealEmpCode = dealEmpCode;
		this.dealEmpName = dealEmpName;
		this.wfState = wfState;	
		if(hr_positiveApplication.equals(processDefName)) {
        	this.workFlowType = "104";
		}else if(hr_addEmpApply.equals(processDefName)) {
			this.workFlowType = "102";
		}else if(hr_returnDomicileOfOrigin.equals(processDefName)) {
			this.workFlowType = "106";
		}else if(hr_employeeTransactionApply.equals(processDefName)) {
			this.workFlowType = "107";
		}else if(hr_leaveDaysOff.equals(processDefName)) {
			this.workFlowType = "103";
		}
	}


	/**
     * 获取workitemid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkitemid() {
        return workitemid;
    }

    /**
     * 设置workitemid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkitemid(String value) {
        this.workitemid = value;
    }

    /**
     * 获取decision属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDecision() {
        return decision;
    }

    /**
     * 设置decision属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDecision(String value) {
        this.decision = value;
    }

    /**
     * 获取opinion属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpinion() {
        return opinion;
    }

    /**
     * 设置opinion属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpinion(String value) {
        this.opinion = value;
    }

    /**
     * 获取busino属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusino() {
        return busino;
    }

    /**
     * 设置busino属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusino(String value) {
        this.busino = value;
    }

    /**
     * 获取backnode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBacknode() {
        return backnode;
    }

    /**
     * 设置backnode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBacknode(String value) {
        this.backnode = value;
    }

    /**
     * 获取activityinstid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivityinstid() {
        return activityinstid;
    }

    /**
     * 设置activityinstid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityinstid(String value) {
        this.activityinstid = value;
    }

    /**
     * 获取dealEmpCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDealEmpCode() {
        return dealEmpCode;
    }

    /**
     * 设置dealEmpCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDealEmpCode(String value) {
        this.dealEmpCode = value;
    }

    /**
     * 获取dealEmpName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDealEmpName() {
        return dealEmpName;
    }

    /**
     * 设置dealEmpName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDealEmpName(String value) {
        this.dealEmpName = value;
    }

    /**
     * 获取wfState属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWfState() {
        return wfState;
    }

    /**
     * 设置wfState属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWfState(String value) {
        this.wfState = value;
    }

    /**
     * 获取workFlowType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkFlowType() {
        return workFlowType;
    }

    /**
     * 设置workFlowType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkFlowType(String value) {
        this.workFlowType = value;
    }

    /**
     * 获取spareFieldOne属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpareFieldOne() {
        return spareFieldOne;
    }

    /**
     * 设置spareFieldOne属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpareFieldOne(String value) {
        this.spareFieldOne = value;
    }

    /**
     * 获取spareFieldTwo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpareFieldTwo() {
        return spareFieldTwo;
    }

    /**
     * 设置spareFieldTwo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpareFieldTwo(String value) {
        this.spareFieldTwo = value;
    }

    /**
     * 获取spareFieldThree属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpareFieldThree() {
        return spareFieldThree;
    }

    /**
     * 设置spareFieldThree属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpareFieldThree(String value) {
        this.spareFieldThree = value;
    }

    /**
     * 获取spareFieldFour属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpareFieldFour() {
        return spareFieldFour;
    }

    /**
     * 设置spareFieldFour属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpareFieldFour(String value) {
        this.spareFieldFour = value;
    }

}

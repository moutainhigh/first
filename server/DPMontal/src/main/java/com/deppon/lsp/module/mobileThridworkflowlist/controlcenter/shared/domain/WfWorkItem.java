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
 * <p>wfWorkItem complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="wfWorkItem">
 *   &lt;complexContent>
 *     &lt;extension base="{}wfUserObject">
 *       &lt;sequence>
 *         &lt;element name="actionMask" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="actionURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="activityDefID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="activityInstID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="activityInstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="allowAgent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="assistant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="assistantName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bizObject">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="entry" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *                             &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="bizState" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="catalogName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="catalogUUID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="createTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currentState" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dealOpinion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dealResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="finalTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isTimeOut" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="limitNum" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="limitNumDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partiName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="participant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="participants" type="{}wfParticipant" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="priority" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="processChName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="processDefID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="processDefName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="processInstID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="processInstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remindTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rootProcInstID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="startTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statesList" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timeOutNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="timeOutNumDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="urlType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="workItemDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="workItemID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="workItemName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="workItemType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wfWorkItem", propOrder = {
    "actionMask",
    "actionURL",
    "activityDefID",
    "activityInstID",
    "activityInstName",
    "allowAgent",
    "assistant",
    "assistantName",
    "bizObject",
    "bizState",
    "catalogName",
    "catalogUUID",
    "createTime",
    "currentState",
    "dealOpinion",
    "dealResult",
    "endTime",
    "finalTime",
    "isTimeOut",
    "limitNum",
    "limitNumDesc",
    "partiName",
    "participant",
    "participants",
    "priority",
    "processChName",
    "processDefID",
    "processDefName",
    "processInstID",
    "processInstName",
    "remindTime",
    "rootProcInstID",
    "startTime",
    "statesList",
    "timeOutNum",
    "timeOutNumDesc",
    "urlType",
    "workItemDesc",
    "workItemID",
    "workItemName",
    "workItemType"
})
public class WfWorkItem
    extends WfUserObject
{

    protected String actionMask;
    protected String actionURL;
    protected String activityDefID;
    protected long activityInstID;
    protected String activityInstName;
    protected String allowAgent;
    protected String assistant;
    protected String assistantName;
    @XmlElement(required = true)
    protected WfWorkItem.BizObject bizObject;
    protected int bizState;
    protected String catalogName;
    protected String catalogUUID;
    protected String createTime;
    protected int currentState;
    protected String dealOpinion;
    protected String dealResult;
    protected String endTime;
    protected String finalTime;
    protected String isTimeOut;
    protected long limitNum;
    protected String limitNumDesc;
    protected String partiName;
    protected String participant;
    @XmlElement(nillable = true)
    protected List<WfParticipant> participants;
    protected int priority;
    protected String processChName;
    protected long processDefID;
    protected String processDefName;
    protected long processInstID;
    protected String processInstName;
    protected String remindTime;
    protected long rootProcInstID;
    protected String startTime;
    protected String statesList;
    protected int timeOutNum;
    protected String timeOutNumDesc;
    protected String urlType;
    protected String workItemDesc;
    protected long workItemID;
    protected String workItemName;
    protected String workItemType;

    /**
     * 获取actionMask属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionMask() {
        return actionMask;
    }

    /**
     * 设置actionMask属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionMask(String value) {
        this.actionMask = value;
    }

    /**
     * 获取actionURL属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionURL() {
        return actionURL;
    }

    /**
     * 设置actionURL属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionURL(String value) {
        this.actionURL = value;
    }

    /**
     * 获取activityDefID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivityDefID() {
        return activityDefID;
    }

    /**
     * 设置activityDefID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityDefID(String value) {
        this.activityDefID = value;
    }

    /**
     * 获取activityInstID属性的值。
     * 
     */
    public long getActivityInstID() {
        return activityInstID;
    }

    /**
     * 设置activityInstID属性的值。
     * 
     */
    public void setActivityInstID(long value) {
        this.activityInstID = value;
    }

    /**
     * 获取activityInstName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivityInstName() {
        return activityInstName;
    }

    /**
     * 设置activityInstName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityInstName(String value) {
        this.activityInstName = value;
    }

    /**
     * 获取allowAgent属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAllowAgent() {
        return allowAgent;
    }

    /**
     * 设置allowAgent属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAllowAgent(String value) {
        this.allowAgent = value;
    }

    /**
     * 获取assistant属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssistant() {
        return assistant;
    }

    /**
     * 设置assistant属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssistant(String value) {
        this.assistant = value;
    }

    /**
     * 获取assistantName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssistantName() {
        return assistantName;
    }

    /**
     * 设置assistantName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssistantName(String value) {
        this.assistantName = value;
    }

    /**
     * 获取bizObject属性的值。
     * 
     * @return
     *     possible object is
     *     {@link WfWorkItem.BizObject }
     *     
     */
    public WfWorkItem.BizObject getBizObject() {
        return bizObject;
    }

    /**
     * 设置bizObject属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link WfWorkItem.BizObject }
     *     
     */
    public void setBizObject(WfWorkItem.BizObject value) {
        this.bizObject = value;
    }

    /**
     * 获取bizState属性的值。
     * 
     */
    public int getBizState() {
        return bizState;
    }

    /**
     * 设置bizState属性的值。
     * 
     */
    public void setBizState(int value) {
        this.bizState = value;
    }

    /**
     * 获取catalogName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCatalogName() {
        return catalogName;
    }

    /**
     * 设置catalogName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCatalogName(String value) {
        this.catalogName = value;
    }

    /**
     * 获取catalogUUID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCatalogUUID() {
        return catalogUUID;
    }

    /**
     * 设置catalogUUID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCatalogUUID(String value) {
        this.catalogUUID = value;
    }

    /**
     * 获取createTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置createTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateTime(String value) {
        this.createTime = value;
    }

    /**
     * 获取currentState属性的值。
     * 
     */
    public int getCurrentState() {
        return currentState;
    }

    /**
     * 设置currentState属性的值。
     * 
     */
    public void setCurrentState(int value) {
        this.currentState = value;
    }

    /**
     * 获取dealOpinion属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDealOpinion() {
        return dealOpinion;
    }

    /**
     * 设置dealOpinion属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDealOpinion(String value) {
        this.dealOpinion = value;
    }

    /**
     * 获取dealResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDealResult() {
        return dealResult;
    }

    /**
     * 设置dealResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDealResult(String value) {
        this.dealResult = value;
    }

    /**
     * 获取endTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置endTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndTime(String value) {
        this.endTime = value;
    }

    /**
     * 获取finalTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinalTime() {
        return finalTime;
    }

    /**
     * 设置finalTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinalTime(String value) {
        this.finalTime = value;
    }

    /**
     * 获取isTimeOut属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsTimeOut() {
        return isTimeOut;
    }

    /**
     * 设置isTimeOut属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsTimeOut(String value) {
        this.isTimeOut = value;
    }

    /**
     * 获取limitNum属性的值。
     * 
     */
    public long getLimitNum() {
        return limitNum;
    }

    /**
     * 设置limitNum属性的值。
     * 
     */
    public void setLimitNum(long value) {
        this.limitNum = value;
    }

    /**
     * 获取limitNumDesc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLimitNumDesc() {
        return limitNumDesc;
    }

    /**
     * 设置limitNumDesc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLimitNumDesc(String value) {
        this.limitNumDesc = value;
    }

    /**
     * 获取partiName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartiName() {
        return partiName;
    }

    /**
     * 设置partiName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartiName(String value) {
        this.partiName = value;
    }

    /**
     * 获取participant属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParticipant() {
        return participant;
    }

    /**
     * 设置participant属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParticipant(String value) {
        this.participant = value;
    }

    /**
     * Gets the value of the participants property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the participants property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParticipants().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WfParticipant }
     * 
     * 
     */
    public List<WfParticipant> getParticipants() {
        if (participants == null) {
            participants = new ArrayList<WfParticipant>();
        }
        return this.participants;
    }

    /**
     * 获取priority属性的值。
     * 
     */
    public int getPriority() {
        return priority;
    }

    /**
     * 设置priority属性的值。
     * 
     */
    public void setPriority(int value) {
        this.priority = value;
    }

    /**
     * 获取processChName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessChName() {
        return processChName;
    }

    /**
     * 设置processChName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessChName(String value) {
        this.processChName = value;
    }

    /**
     * 获取processDefID属性的值。
     * 
     */
    public long getProcessDefID() {
        return processDefID;
    }

    /**
     * 设置processDefID属性的值。
     * 
     */
    public void setProcessDefID(long value) {
        this.processDefID = value;
    }

    /**
     * 获取processDefName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessDefName() {
        return processDefName;
    }

    /**
     * 设置processDefName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessDefName(String value) {
        this.processDefName = value;
    }

    /**
     * 获取processInstID属性的值。
     * 
     */
    public long getProcessInstID() {
        return processInstID;
    }

    /**
     * 设置processInstID属性的值。
     * 
     */
    public void setProcessInstID(long value) {
        this.processInstID = value;
    }

    /**
     * 获取processInstName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessInstName() {
        return processInstName;
    }

    /**
     * 设置processInstName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessInstName(String value) {
        this.processInstName = value;
    }

    /**
     * 获取remindTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemindTime() {
        return remindTime;
    }

    /**
     * 设置remindTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemindTime(String value) {
        this.remindTime = value;
    }

    /**
     * 获取rootProcInstID属性的值。
     * 
     */
    public long getRootProcInstID() {
        return rootProcInstID;
    }

    /**
     * 设置rootProcInstID属性的值。
     * 
     */
    public void setRootProcInstID(long value) {
        this.rootProcInstID = value;
    }

    /**
     * 获取startTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置startTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartTime(String value) {
        this.startTime = value;
    }

    /**
     * 获取statesList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatesList() {
        return statesList;
    }

    /**
     * 设置statesList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatesList(String value) {
        this.statesList = value;
    }

    /**
     * 获取timeOutNum属性的值。
     * 
     */
    public int getTimeOutNum() {
        return timeOutNum;
    }

    /**
     * 设置timeOutNum属性的值。
     * 
     */
    public void setTimeOutNum(int value) {
        this.timeOutNum = value;
    }

    /**
     * 获取timeOutNumDesc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeOutNumDesc() {
        return timeOutNumDesc;
    }

    /**
     * 设置timeOutNumDesc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeOutNumDesc(String value) {
        this.timeOutNumDesc = value;
    }

    /**
     * 获取urlType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlType() {
        return urlType;
    }

    /**
     * 设置urlType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlType(String value) {
        this.urlType = value;
    }

    /**
     * 获取workItemDesc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkItemDesc() {
        return workItemDesc;
    }

    /**
     * 设置workItemDesc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkItemDesc(String value) {
        this.workItemDesc = value;
    }

    /**
     * 获取workItemID属性的值。
     * 
     */
    public long getWorkItemID() {
        return workItemID;
    }

    /**
     * 设置workItemID属性的值。
     * 
     */
    public void setWorkItemID(long value) {
        this.workItemID = value;
    }

    /**
     * 获取workItemName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkItemName() {
        return workItemName;
    }

    /**
     * 设置workItemName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkItemName(String value) {
        this.workItemName = value;
    }

    /**
     * 获取workItemType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkItemType() {
        return workItemType;
    }

    /**
     * 设置workItemType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkItemType(String value) {
        this.workItemType = value;
    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="entry" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *                   &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "entry"
    })
    public static class BizObject {

        protected List<WfWorkItem.BizObject.Entry> entry;

        /**
         * Gets the value of the entry property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the entry property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEntry().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link WfWorkItem.BizObject.Entry }
         * 
         * 
         */
        public List<WfWorkItem.BizObject.Entry> getEntry() {
            if (entry == null) {
                entry = new ArrayList<WfWorkItem.BizObject.Entry>();
            }
            return this.entry;
        }


        /**
         * <p>anonymous complex type的 Java 类。
         * 
         * <p>以下模式片段指定包含在此类中的预期内容。
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
         *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "key",
            "value"
        })
        public static class Entry {

            protected Object key;
            protected Object value;

            /**
             * 获取key属性的值。
             * 
             * @return
             *     possible object is
             *     {@link Object }
             *     
             */
            public Object getKey() {
                return key;
            }

            /**
             * 设置key属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link Object }
             *     
             */
            public void setKey(Object value) {
                this.key = value;
            }

            /**
             * 获取value属性的值。
             * 
             * @return
             *     possible object is
             *     {@link Object }
             *     
             */
            public Object getValue() {
                return value;
            }

            /**
             * 设置value属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link Object }
             *     
             */
            public void setValue(Object value) {
                this.value = value;
            }

        }

    }

}

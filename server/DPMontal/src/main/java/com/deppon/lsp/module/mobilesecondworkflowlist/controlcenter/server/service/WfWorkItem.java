
package com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wfWorkItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wfWorkItem">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}wfUserObject">
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
 *         &lt;element name="participants" type="{http://www.deppon.com/lsp/module/mobilesecondworkflowlist/controlcenter/server/service}wfParticipant" maxOccurs="unbounded" minOccurs="0"/>
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
     * Gets the value of the actionMask property.
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
     * Sets the value of the actionMask property.
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
     * Gets the value of the actionURL property.
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
     * Sets the value of the actionURL property.
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
     * Gets the value of the activityDefID property.
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
     * Sets the value of the activityDefID property.
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
     * Gets the value of the activityInstID property.
     * 
     */
    public long getActivityInstID() {
        return activityInstID;
    }

    /**
     * Sets the value of the activityInstID property.
     * 
     */
    public void setActivityInstID(long value) {
        this.activityInstID = value;
    }

    /**
     * Gets the value of the activityInstName property.
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
     * Sets the value of the activityInstName property.
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
     * Gets the value of the allowAgent property.
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
     * Sets the value of the allowAgent property.
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
     * Gets the value of the assistant property.
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
     * Sets the value of the assistant property.
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
     * Gets the value of the assistantName property.
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
     * Sets the value of the assistantName property.
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
     * Gets the value of the bizObject property.
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
     * Sets the value of the bizObject property.
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
     * Gets the value of the bizState property.
     * 
     */
    public int getBizState() {
        return bizState;
    }

    /**
     * Sets the value of the bizState property.
     * 
     */
    public void setBizState(int value) {
        this.bizState = value;
    }

    /**
     * Gets the value of the catalogName property.
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
     * Sets the value of the catalogName property.
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
     * Gets the value of the catalogUUID property.
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
     * Sets the value of the catalogUUID property.
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
     * Gets the value of the createTime property.
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
     * Sets the value of the createTime property.
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
     * Gets the value of the currentState property.
     * 
     */
    public int getCurrentState() {
        return currentState;
    }

    /**
     * Sets the value of the currentState property.
     * 
     */
    public void setCurrentState(int value) {
        this.currentState = value;
    }

    /**
     * Gets the value of the dealOpinion property.
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
     * Sets the value of the dealOpinion property.
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
     * Gets the value of the dealResult property.
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
     * Sets the value of the dealResult property.
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
     * Gets the value of the endTime property.
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
     * Sets the value of the endTime property.
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
     * Gets the value of the finalTime property.
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
     * Sets the value of the finalTime property.
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
     * Gets the value of the isTimeOut property.
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
     * Sets the value of the isTimeOut property.
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
     * Gets the value of the limitNum property.
     * 
     */
    public long getLimitNum() {
        return limitNum;
    }

    /**
     * Sets the value of the limitNum property.
     * 
     */
    public void setLimitNum(long value) {
        this.limitNum = value;
    }

    /**
     * Gets the value of the limitNumDesc property.
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
     * Sets the value of the limitNumDesc property.
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
     * Gets the value of the partiName property.
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
     * Sets the value of the partiName property.
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
     * Gets the value of the participant property.
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
     * Sets the value of the participant property.
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
     * Gets the value of the priority property.
     * 
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     */
    public void setPriority(int value) {
        this.priority = value;
    }

    /**
     * Gets the value of the processChName property.
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
     * Sets the value of the processChName property.
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
     * Gets the value of the processDefID property.
     * 
     */
    public long getProcessDefID() {
        return processDefID;
    }

    /**
     * Sets the value of the processDefID property.
     * 
     */
    public void setProcessDefID(long value) {
        this.processDefID = value;
    }

    /**
     * Gets the value of the processDefName property.
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
     * Sets the value of the processDefName property.
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
     * Gets the value of the processInstID property.
     * 
     */
    public long getProcessInstID() {
        return processInstID;
    }

    /**
     * Sets the value of the processInstID property.
     * 
     */
    public void setProcessInstID(long value) {
        this.processInstID = value;
    }

    /**
     * Gets the value of the processInstName property.
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
     * Sets the value of the processInstName property.
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
     * Gets the value of the remindTime property.
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
     * Sets the value of the remindTime property.
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
     * Gets the value of the rootProcInstID property.
     * 
     */
    public long getRootProcInstID() {
        return rootProcInstID;
    }

    /**
     * Sets the value of the rootProcInstID property.
     * 
     */
    public void setRootProcInstID(long value) {
        this.rootProcInstID = value;
    }

    /**
     * Gets the value of the startTime property.
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
     * Sets the value of the startTime property.
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
     * Gets the value of the statesList property.
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
     * Sets the value of the statesList property.
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
     * Gets the value of the timeOutNum property.
     * 
     */
    public int getTimeOutNum() {
        return timeOutNum;
    }

    /**
     * Sets the value of the timeOutNum property.
     * 
     */
    public void setTimeOutNum(int value) {
        this.timeOutNum = value;
    }

    /**
     * Gets the value of the timeOutNumDesc property.
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
     * Sets the value of the timeOutNumDesc property.
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
     * Gets the value of the urlType property.
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
     * Sets the value of the urlType property.
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
     * Gets the value of the workItemDesc property.
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
     * Sets the value of the workItemDesc property.
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
     * Gets the value of the workItemID property.
     * 
     */
    public long getWorkItemID() {
        return workItemID;
    }

    /**
     * Sets the value of the workItemID property.
     * 
     */
    public void setWorkItemID(long value) {
        this.workItemID = value;
    }

    /**
     * Gets the value of the workItemName property.
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
     * Sets the value of the workItemName property.
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
     * Gets the value of the workItemType property.
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
     * Sets the value of the workItemType property.
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
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
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
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
             * Gets the value of the key property.
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
             * Sets the value of the key property.
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
             * Gets the value of the value property.
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
             * Sets the value of the value property.
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

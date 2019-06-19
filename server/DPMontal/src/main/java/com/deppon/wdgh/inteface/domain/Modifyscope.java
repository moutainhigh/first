
package com.deppon.wdgh.inteface.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>modifyscope complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="modifyscope">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createUser" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="appType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newDeptWorkflowNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deptAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deptArea" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="warehouseArea" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="telFax" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="openTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="deptName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pickupSelf" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deliver" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pickupScope" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deliverScope" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="transferCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="singlePieceLimitkg" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="singleBillLimitkg" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="singlePieceLimitvol" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="singleBillLimitvol" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="last3monthSaturation" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="last2monthSaturation" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="last1monthSaturation" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="lastmonthArriveVolume" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="deptType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="changeDept" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="canleTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="reason" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="modifyscopeDetail" type="{http://www.deppon.com/wdgh/inteface/domain/}modifyscopeDetail" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modifyscope", propOrder = {
    "createUser",
    "appType",
    "newDeptWorkflowNo",
    "deptAddress",
    "deptArea",
    "warehouseArea",
    "telFax",
    "openTime",
    "deptName",
    "pickupSelf",
    "deliver",
    "pickupScope",
    "deliverScope",
    "transferCode",
    "singlePieceLimitkg",
    "singleBillLimitkg",
    "singlePieceLimitvol",
    "singleBillLimitvol",
    "last3MonthSaturation",
    "last2MonthSaturation",
    "last1MonthSaturation",
    "lastmonthArriveVolume",
    "deptType",
    "changeDept",
    "canleTime",
    "reason",
    "modifyscopeDetail"
})
public class Modifyscope {

    @XmlElement(required = true)
    protected String createUser;
    @XmlElement(required = true)
    protected String appType;
    @XmlElement(required = true)
    protected String newDeptWorkflowNo;
    @XmlElement(required = true)
    protected String deptAddress;
    protected double deptArea;
    protected double warehouseArea;
    @XmlElement(required = true)
    protected String telFax;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar openTime;
    @XmlElement(required = true)
    protected String deptName;
    @XmlElement(required = true)
    protected String pickupSelf;
    @XmlElement(required = true)
    protected String deliver;
    @XmlElement(required = true)
    protected String pickupScope;
    @XmlElement(required = true)
    protected String deliverScope;
    @XmlElement(required = true)
    protected String transferCode;
    protected double singlePieceLimitkg;
    protected double singleBillLimitkg;
    protected double singlePieceLimitvol;
    protected double singleBillLimitvol;
    @XmlElement(name = "last3monthSaturation")
    protected double last3MonthSaturation;
    @XmlElement(name = "last2monthSaturation")
    protected double last2MonthSaturation;
    @XmlElement(name = "last1monthSaturation")
    protected double last1MonthSaturation;
    protected double lastmonthArriveVolume;
    @XmlElement(required = true)
    protected String deptType;
    @XmlElement(required = true)
    protected String changeDept;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar canleTime;
    @XmlElement(required = true)
    protected String reason;
    protected List<ModifyscopeDetail> modifyscopeDetail;

    /**
     * 获取createUser属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置createUser属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateUser(String value) {
        this.createUser = value;
    }

    /**
     * 获取appType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppType() {
        return appType;
    }

    /**
     * 设置appType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppType(String value) {
        this.appType = value;
    }

    /**
     * 获取newDeptWorkflowNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewDeptWorkflowNo() {
        return newDeptWorkflowNo;
    }

    /**
     * 设置newDeptWorkflowNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewDeptWorkflowNo(String value) {
        this.newDeptWorkflowNo = value;
    }

    /**
     * 获取deptAddress属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeptAddress() {
        return deptAddress;
    }

    /**
     * 设置deptAddress属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeptAddress(String value) {
        this.deptAddress = value;
    }

    /**
     * 获取deptArea属性的值。
     * 
     */
    public double getDeptArea() {
        return deptArea;
    }

    /**
     * 设置deptArea属性的值。
     * 
     */
    public void setDeptArea(double value) {
        this.deptArea = value;
    }

    /**
     * 获取warehouseArea属性的值。
     * 
     */
    public double getWarehouseArea() {
        return warehouseArea;
    }

    /**
     * 设置warehouseArea属性的值。
     * 
     */
    public void setWarehouseArea(double value) {
        this.warehouseArea = value;
    }

    /**
     * 获取telFax属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelFax() {
        return telFax;
    }

    /**
     * 设置telFax属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelFax(String value) {
        this.telFax = value;
    }

    /**
     * 获取openTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOpenTime() {
        return openTime;
    }

    /**
     * 设置openTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOpenTime(XMLGregorianCalendar value) {
        this.openTime = value;
    }

    /**
     * 获取deptName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 设置deptName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeptName(String value) {
        this.deptName = value;
    }

    /**
     * 获取pickupSelf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPickupSelf() {
        return pickupSelf;
    }

    /**
     * 设置pickupSelf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPickupSelf(String value) {
        this.pickupSelf = value;
    }

    /**
     * 获取deliver属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliver() {
        return deliver;
    }

    /**
     * 设置deliver属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliver(String value) {
        this.deliver = value;
    }

    /**
     * 获取pickupScope属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPickupScope() {
        return pickupScope;
    }

    /**
     * 设置pickupScope属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPickupScope(String value) {
        this.pickupScope = value;
    }

    /**
     * 获取deliverScope属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliverScope() {
        return deliverScope;
    }

    /**
     * 设置deliverScope属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliverScope(String value) {
        this.deliverScope = value;
    }

    /**
     * 获取transferCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransferCode() {
        return transferCode;
    }

    /**
     * 设置transferCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransferCode(String value) {
        this.transferCode = value;
    }

    /**
     * 获取singlePieceLimitkg属性的值。
     * 
     */
    public double getSinglePieceLimitkg() {
        return singlePieceLimitkg;
    }

    /**
     * 设置singlePieceLimitkg属性的值。
     * 
     */
    public void setSinglePieceLimitkg(double value) {
        this.singlePieceLimitkg = value;
    }

    /**
     * 获取singleBillLimitkg属性的值。
     * 
     */
    public double getSingleBillLimitkg() {
        return singleBillLimitkg;
    }

    /**
     * 设置singleBillLimitkg属性的值。
     * 
     */
    public void setSingleBillLimitkg(double value) {
        this.singleBillLimitkg = value;
    }

    /**
     * 获取singlePieceLimitvol属性的值。
     * 
     */
    public double getSinglePieceLimitvol() {
        return singlePieceLimitvol;
    }

    /**
     * 设置singlePieceLimitvol属性的值。
     * 
     */
    public void setSinglePieceLimitvol(double value) {
        this.singlePieceLimitvol = value;
    }

    /**
     * 获取singleBillLimitvol属性的值。
     * 
     */
    public double getSingleBillLimitvol() {
        return singleBillLimitvol;
    }

    /**
     * 设置singleBillLimitvol属性的值。
     * 
     */
    public void setSingleBillLimitvol(double value) {
        this.singleBillLimitvol = value;
    }

    /**
     * 获取last3MonthSaturation属性的值。
     * 
     */
    public double getLast3MonthSaturation() {
        return last3MonthSaturation;
    }

    /**
     * 设置last3MonthSaturation属性的值。
     * 
     */
    public void setLast3MonthSaturation(double value) {
        this.last3MonthSaturation = value;
    }

    /**
     * 获取last2MonthSaturation属性的值。
     * 
     */
    public double getLast2MonthSaturation() {
        return last2MonthSaturation;
    }

    /**
     * 设置last2MonthSaturation属性的值。
     * 
     */
    public void setLast2MonthSaturation(double value) {
        this.last2MonthSaturation = value;
    }

    /**
     * 获取last1MonthSaturation属性的值。
     * 
     */
    public double getLast1MonthSaturation() {
        return last1MonthSaturation;
    }

    /**
     * 设置last1MonthSaturation属性的值。
     * 
     */
    public void setLast1MonthSaturation(double value) {
        this.last1MonthSaturation = value;
    }

    /**
     * 获取lastmonthArriveVolume属性的值。
     * 
     */
    public double getLastmonthArriveVolume() {
        return lastmonthArriveVolume;
    }

    /**
     * 设置lastmonthArriveVolume属性的值。
     * 
     */
    public void setLastmonthArriveVolume(double value) {
        this.lastmonthArriveVolume = value;
    }

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
     * 获取changeDept属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChangeDept() {
        return changeDept;
    }

    /**
     * 设置changeDept属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChangeDept(String value) {
        this.changeDept = value;
    }

    /**
     * 获取canleTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCanleTime() {
        return canleTime;
    }

    /**
     * 设置canleTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCanleTime(XMLGregorianCalendar value) {
        this.canleTime = value;
    }

    /**
     * 获取reason属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置reason属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReason(String value) {
        this.reason = value;
    }

    /**
     * Gets the value of the modifyscopeDetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the modifyscopeDetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModifyscopeDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ModifyscopeDetail }
     * 
     * 
     */
    public List<ModifyscopeDetail> getModifyscopeDetail() {
        if (modifyscopeDetail == null) {
            modifyscopeDetail = new ArrayList<ModifyscopeDetail>();
        }
        return this.modifyscopeDetail;
    }
}
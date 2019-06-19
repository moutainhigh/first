
package com.deppon.wdgh.inteface.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>newPointDept complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="newPointDept">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createUserName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="newDeptType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="currentDeptName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deptManagerName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deptType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lookStartTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="originDeptName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deptPhone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deliverDeptAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stallPledgeAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="stallGroundfloorArea" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="stallsRooms" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="contractArea" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="stallFloor" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="stallRentPeriod" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="companyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="transferFee" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="rentPaymentTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rentPerUnitarea" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="isStation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stallRentAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="isCanhandleCretificate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rentPaymentType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lookTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="isSatisfy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isFocusReceive" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="departureLocateScore" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="arriveLocateScore" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="marketingScore" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reason" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="businessName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bigRegionName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="smallRegionName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="provinceName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cityName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="countyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="planDeptName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "newPointDept", propOrder = {
    "createUserName",
    "newDeptType",
    "currentDeptName",
    "deptManagerName",
    "deptType",
    "lookStartTime",
    "originDeptName",
    "deptPhone",
    "deliverDeptAddress",
    "stallPledgeAmount",
    "stallGroundfloorArea",
    "stallsRooms",
    "contractArea",
    "stallFloor",
    "stallRentPeriod",
    "companyName",
    "transferFee",
    "rentPaymentTime",
    "rentPerUnitarea",
    "isStation",
    "stallRentAmount",
    "isCanhandleCretificate",
    "rentPaymentType",
    "lookTime",
    "isSatisfy",
    "isFocusReceive",
    "departureLocateScore",
    "arriveLocateScore",
    "marketingScore",
    "reason",
    "businessName",
    "bigRegionName",
    "smallRegionName",
    "provinceName",
    "cityName",
    "countyName",
    "planDeptName"
})
public class NewPointDept {

    @XmlElement(required = true)
    protected String createUserName;
    @XmlElement(required = true)
    protected String newDeptType;
    @XmlElement(required = true)
    protected String currentDeptName;
    @XmlElement(required = true)
    protected String deptManagerName;
    @XmlElement(required = true)
    protected String deptType;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lookStartTime;
    @XmlElement(required = true)
    protected String originDeptName;
    @XmlElement(required = true)
    protected String deptPhone;
    @XmlElement(required = true)
    protected String deliverDeptAddress;
    protected double stallPledgeAmount;
    protected double stallGroundfloorArea;
    protected int stallsRooms;
    protected double contractArea;
    protected int stallFloor;
    protected int stallRentPeriod;
    @XmlElement(required = true)
    protected String companyName;
    protected double transferFee;
    @XmlElement(required = true)
    protected String rentPaymentTime;
    protected double rentPerUnitarea;
    @XmlElement(required = true)
    protected String isStation;
    protected double stallRentAmount;
    @XmlElement(required = true)
    protected String isCanhandleCretificate;
    @XmlElement(required = true)
    protected String rentPaymentType;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lookTime;
    @XmlElement(required = true)
    protected String isSatisfy;
    @XmlElement(required = true)
    protected String isFocusReceive;
    protected double departureLocateScore;
    protected double arriveLocateScore;
    @XmlElement(required = true)
    protected String marketingScore;
    @XmlElement(required = true)
    protected String reason;
    @XmlElement(required = true)
    protected String businessName;
    @XmlElement(required = true)
    protected String bigRegionName;
    @XmlElement(required = true)
    protected String smallRegionName;
    @XmlElement(required = true)
    protected String provinceName;
    @XmlElement(required = true)
    protected String cityName;
    @XmlElement(required = true)
    protected String countyName;
    @XmlElement(required = true)
    protected String planDeptName;

    /**
     * 获取createUserName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 设置createUserName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateUserName(String value) {
        this.createUserName = value;
    }

    /**
     * 获取newDeptType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewDeptType() {
        return newDeptType;
    }

    /**
     * 设置newDeptType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewDeptType(String value) {
        this.newDeptType = value;
    }

    /**
     * 获取currentDeptName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentDeptName() {
        return currentDeptName;
    }

    /**
     * 设置currentDeptName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentDeptName(String value) {
        this.currentDeptName = value;
    }

    /**
     * 获取deptManagerName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeptManagerName() {
        return deptManagerName;
    }

    /**
     * 设置deptManagerName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeptManagerName(String value) {
        this.deptManagerName = value;
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
     * 获取lookStartTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLookStartTime() {
        return lookStartTime;
    }

    /**
     * 设置lookStartTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLookStartTime(XMLGregorianCalendar value) {
        this.lookStartTime = value;
    }

    /**
     * 获取originDeptName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginDeptName() {
        return originDeptName;
    }

    /**
     * 设置originDeptName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginDeptName(String value) {
        this.originDeptName = value;
    }

    /**
     * 获取deptPhone属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeptPhone() {
        return deptPhone;
    }

    /**
     * 设置deptPhone属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeptPhone(String value) {
        this.deptPhone = value;
    }

    /**
     * 获取deliverDeptAddress属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliverDeptAddress() {
        return deliverDeptAddress;
    }

    /**
     * 设置deliverDeptAddress属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliverDeptAddress(String value) {
        this.deliverDeptAddress = value;
    }

    /**
     * 获取stallPledgeAmount属性的值。
     * 
     */
    public double getStallPledgeAmount() {
        return stallPledgeAmount;
    }

    /**
     * 设置stallPledgeAmount属性的值。
     * 
     */
    public void setStallPledgeAmount(double value) {
        this.stallPledgeAmount = value;
    }

    /**
     * 获取stallGroundfloorArea属性的值。
     * 
     */
    public double getStallGroundfloorArea() {
        return stallGroundfloorArea;
    }

    /**
     * 设置stallGroundfloorArea属性的值。
     * 
     */
    public void setStallGroundfloorArea(double value) {
        this.stallGroundfloorArea = value;
    }

    /**
     * 获取stallsRooms属性的值。
     * 
     */
    public int getStallsRooms() {
        return stallsRooms;
    }

    /**
     * 设置stallsRooms属性的值。
     * 
     */
    public void setStallsRooms(int value) {
        this.stallsRooms = value;
    }

    /**
     * 获取contractArea属性的值。
     * 
     */
    public double getContractArea() {
        return contractArea;
    }

    /**
     * 设置contractArea属性的值。
     * 
     */
    public void setContractArea(double value) {
        this.contractArea = value;
    }

    /**
     * 获取stallFloor属性的值。
     * 
     */
    public int getStallFloor() {
        return stallFloor;
    }

    /**
     * 设置stallFloor属性的值。
     * 
     */
    public void setStallFloor(int value) {
        this.stallFloor = value;
    }

    /**
     * 获取stallRentPeriod属性的值。
     * 
     */
    public int getStallRentPeriod() {
        return stallRentPeriod;
    }

    /**
     * 设置stallRentPeriod属性的值。
     * 
     */
    public void setStallRentPeriod(int value) {
        this.stallRentPeriod = value;
    }

    /**
     * 获取companyName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置companyName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyName(String value) {
        this.companyName = value;
    }

    /**
     * 获取transferFee属性的值。
     * 
     */
    public double getTransferFee() {
        return transferFee;
    }

    /**
     * 设置transferFee属性的值。
     * 
     */
    public void setTransferFee(double value) {
        this.transferFee = value;
    }

    /**
     * 获取rentPaymentTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRentPaymentTime() {
        return rentPaymentTime;
    }

    /**
     * 设置rentPaymentTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRentPaymentTime(String value) {
        this.rentPaymentTime = value;
    }

    /**
     * 获取rentPerUnitarea属性的值。
     * 
     */
    public double getRentPerUnitarea() {
        return rentPerUnitarea;
    }

    /**
     * 设置rentPerUnitarea属性的值。
     * 
     */
    public void setRentPerUnitarea(double value) {
        this.rentPerUnitarea = value;
    }

    /**
     * 获取isStation属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsStation() {
        return isStation;
    }

    /**
     * 设置isStation属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsStation(String value) {
        this.isStation = value;
    }

    /**
     * 获取stallRentAmount属性的值。
     * 
     */
    public double getStallRentAmount() {
        return stallRentAmount;
    }

    /**
     * 设置stallRentAmount属性的值。
     * 
     */
    public void setStallRentAmount(double value) {
        this.stallRentAmount = value;
    }

    /**
     * 获取isCanhandleCretificate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsCanhandleCretificate() {
        return isCanhandleCretificate;
    }

    /**
     * 设置isCanhandleCretificate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsCanhandleCretificate(String value) {
        this.isCanhandleCretificate = value;
    }

    /**
     * 获取rentPaymentType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRentPaymentType() {
        return rentPaymentType;
    }

    /**
     * 设置rentPaymentType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRentPaymentType(String value) {
        this.rentPaymentType = value;
    }

    /**
     * 获取lookTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLookTime() {
        return lookTime;
    }

    /**
     * 设置lookTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLookTime(XMLGregorianCalendar value) {
        this.lookTime = value;
    }

    /**
     * 获取isSatisfy属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsSatisfy() {
        return isSatisfy;
    }

    /**
     * 设置isSatisfy属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsSatisfy(String value) {
        this.isSatisfy = value;
    }

    /**
     * 获取isFocusReceive属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsFocusReceive() {
        return isFocusReceive;
    }

    /**
     * 设置isFocusReceive属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsFocusReceive(String value) {
        this.isFocusReceive = value;
    }

    /**
     * 获取departureLocateScore属性的值。
     * 
     */
    public double getDepartureLocateScore() {
        return departureLocateScore;
    }

    /**
     * 设置departureLocateScore属性的值。
     * 
     */
    public void setDepartureLocateScore(double value) {
        this.departureLocateScore = value;
    }

    /**
     * 获取arriveLocateScore属性的值。
     * 
     */
    public double getArriveLocateScore() {
        return arriveLocateScore;
    }

    /**
     * 设置arriveLocateScore属性的值。
     * 
     */
    public void setArriveLocateScore(double value) {
        this.arriveLocateScore = value;
    }

    /**
     * 获取marketingScore属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarketingScore() {
        return marketingScore;
    }

    /**
     * 设置marketingScore属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarketingScore(String value) {
        this.marketingScore = value;
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
     * 获取businessName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessName() {
        return businessName;
    }

    /**
     * 设置businessName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessName(String value) {
        this.businessName = value;
    }

    /**
     * 获取bigRegionName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBigRegionName() {
        return bigRegionName;
    }

    /**
     * 设置bigRegionName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBigRegionName(String value) {
        this.bigRegionName = value;
    }

    /**
     * 获取smallRegionName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmallRegionName() {
        return smallRegionName;
    }

    /**
     * 设置smallRegionName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmallRegionName(String value) {
        this.smallRegionName = value;
    }

    /**
     * 获取provinceName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * 设置provinceName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvinceName(String value) {
        this.provinceName = value;
    }

    /**
     * 获取cityName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * 设置cityName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityName(String value) {
        this.cityName = value;
    }

    /**
     * 获取countyName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountyName() {
        return countyName;
    }

    /**
     * 设置countyName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountyName(String value) {
        this.countyName = value;
    }

    /**
     * 获取planDeptName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanDeptName() {
        return planDeptName;
    }

    /**
     * 设置planDeptName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanDeptName(String value) {
        this.planDeptName = value;
    }

}
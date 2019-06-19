
package com.deppon.wdgh.inteface.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <pre>
 * &lt;complexType name="deptRent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createUser" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deptName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="appType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="businessDivsionName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bigRegionName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="negotiator" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="negotiatorCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="leader" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="leaderCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="parentLeader" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="parentLeaderCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="transferTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="changedStallFloor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="originRentArea" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="transferArea" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="originRent" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="transferRent" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="originRentPerarea" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="transferRentPerarea" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="changedStallArea" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="changedRentAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="changedRentamountPerarea" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="originStallRooms" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="stallPledgeAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="transferFee" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="isRedecorated" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reason" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="expandArea" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="expandRentamount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="expandTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="expandRentamountPerarea" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deptRent", propOrder = {
    "createUser",
    "deptName",
    "appType",
    "businessDivsionName",
    "bigRegionName",
    "negotiator",
    "negotiatorCode",
    "leader",
    "leaderCode",
    "parentLeader",
    "parentLeaderCode",
    "transferTime",
    "changedStallFloor",
    "originRentArea",
    "transferArea",
    "originRent",
    "transferRent",
    "originRentPerarea",
    "transferRentPerarea",
    "changedStallArea",
    "changedRentAmount",
    "changedRentamountPerarea",
    "originStallRooms",
    "stallPledgeAmount",
    "transferFee",
    "isRedecorated",
    "reason",
    "expandArea",
    "expandRentamount",
    "expandTime",
    "expandRentamountPerarea"
})
public class DeptRent {

	//申请人姓名
    @XmlElement(required = true)
    protected String createUser;
    //部门名称
    @XmlElement(required = true)
    protected String deptName;
    //申请类型
    @XmlElement(required = true)
    protected String appType;
    //事业部名称
    @XmlElement(required = true)
    protected String businessDivsionName;
    //大区名称
    @XmlElement(required = true)
    protected String bigRegionName;
    //谈判人
    @XmlElement(required = true)
    protected String negotiator;
    //谈判人工号
    @XmlElement(required = true)
    protected String negotiatorCode;
    //谈判人上级领导
    @XmlElement(required = true)
    protected String leader;
    //谈判人上级领导工号
    @XmlElement(required = true)
    protected String leaderCode;
    //谈判人上上级领导
    @XmlElement(required = true)
    protected String parentLeader;
    //谈判人上上级领导工号
    @XmlElement(required = true)
    protected String parentLeaderCode;
    protected int transferTime;
    @XmlElement(required = true)
    protected String changedStallFloor;
    //部门原租用面积（平米）
    protected double originRentArea;
    protected double transferArea;
    //部门原租金（元/月）
    protected double originRent;
    protected double transferRent;
    protected double originRentPerarea;
    protected double transferRentPerarea;
    protected double changedStallArea;
    protected double changedRentAmount;
    protected double changedRentamountPerarea;
    protected int originStallRooms;
    protected double stallPledgeAmount;
    protected double transferFee;
    @XmlElement(required = true)
    protected String isRedecorated;
    @XmlElement(required = true)
    protected String reason;
    protected double expandArea;
    protected double expandRentamount;
    protected int expandTime;
    protected double expandRentamountPerarea;

    /**
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
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessDivsionName() {
        return businessDivsionName;
    }

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessDivsionName(String value) {
        this.businessDivsionName = value;
    }

    /**
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
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNegotiator() {
        return negotiator;
    }

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNegotiator(String value) {
        this.negotiator = value;
    }

    /**
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNegotiatorCode() {
        return negotiatorCode;
    }

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNegotiatorCode(String value) {
        this.negotiatorCode = value;
    }

    /**
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLeader() {
        return leader;
    }

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLeader(String value) {
        this.leader = value;
    }

    /**
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLeaderCode() {
        return leaderCode;
    }

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLeaderCode(String value) {
        this.leaderCode = value;
    }

    /**
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentLeader() {
        return parentLeader;
    }

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentLeader(String value) {
        this.parentLeader = value;
    }

    /**
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentLeaderCode() {
        return parentLeaderCode;
    }

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentLeaderCode(String value) {
        this.parentLeaderCode = value;
    }

    /**
     * 
     */
    public int getTransferTime() {
        return transferTime;
    }

    /**
     * 
     */
    public void setTransferTime(int value) {
        this.transferTime = value;
    }

    /**
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChangedStallFloor() {
        return changedStallFloor;
    }

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChangedStallFloor(String value) {
        this.changedStallFloor = value;
    }

    /**
     * 
     */
    public double getOriginRentArea() {
        return originRentArea;
    }

    /**
     * 
     */
    public void setOriginRentArea(double value) {
        this.originRentArea = value;
    }

    /**
     * 
     */
    public double getTransferArea() {
        return transferArea;
    }

    /**
     * 
     */
    public void setTransferArea(double value) {
        this.transferArea = value;
    }

    /**
     * 
     */
    public double getOriginRent() {
        return originRent;
    }

    /**
     * 
     */
    public void setOriginRent(double value) {
        this.originRent = value;
    }

    /**
     * 
     */
    public double getTransferRent() {
        return transferRent;
    }

    /**
     * 
     */
    public void setTransferRent(double value) {
        this.transferRent = value;
    }

    /**
     * 
     */
    public double getOriginRentPerarea() {
        return originRentPerarea;
    }

    /**
     * 
     */
    public void setOriginRentPerarea(double value) {
        this.originRentPerarea = value;
    }

    /**
     * 
     */
    public double getTransferRentPerarea() {
        return transferRentPerarea;
    }

    /**
     * 
     */
    public void setTransferRentPerarea(double value) {
        this.transferRentPerarea = value;
    }

    /**
     * 
     */
    public double getChangedStallArea() {
        return changedStallArea;
    }

    /**
     * 
     */
    public void setChangedStallArea(double value) {
        this.changedStallArea = value;
    }

    /**
     * 
     */
    public double getChangedRentAmount() {
        return changedRentAmount;
    }

    /**
     * 
     */
    public void setChangedRentAmount(double value) {
        this.changedRentAmount = value;
    }

    /**
     * 
     */
    public double getChangedRentamountPerarea() {
        return changedRentamountPerarea;
    }

    /**
     * 
     */
    public void setChangedRentamountPerarea(double value) {
        this.changedRentamountPerarea = value;
    }

    /**
     * 
     */
    public int getOriginStallRooms() {
        return originStallRooms;
    }

    /**
     * 
     */
    public void setOriginStallRooms(int value) {
        this.originStallRooms = value;
    }

    /**
     * 
     */
    public double getStallPledgeAmount() {
        return stallPledgeAmount;
    }

    /**
     * 
     */
    public void setStallPledgeAmount(double value) {
        this.stallPledgeAmount = value;
    }

    /**
     * 
     */
    public double getTransferFee() {
        return transferFee;
    }

    /**
     * 
     */
    public void setTransferFee(double value) {
        this.transferFee = value;
    }

    /**
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsRedecorated() {
        return isRedecorated;
    }

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsRedecorated(String value) {
        this.isRedecorated = value;
    }

    /**
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
     * 
     */
    public double getExpandArea() {
        return expandArea;
    }

    /**
     * 
     */
    public void setExpandArea(double value) {
        this.expandArea = value;
    }

    /**
     * 
     */
    public double getExpandRentamount() {
        return expandRentamount;
    }

    /**
     * 
     */
    public void setExpandRentamount(double value) {
        this.expandRentamount = value;
    }

    /**
     * 
     */
    public int getExpandTime() {
        return expandTime;
    }

    /**
     * 
     */
    public void setExpandTime(int value) {
        this.expandTime = value;
    }

    /**
     * 
     */
    public double getExpandRentamountPerarea() {
        return expandRentamountPerarea;
    }

    /**
     * 
     */
    public void setExpandRentamountPerarea(double value) {
        this.expandRentamountPerarea = value;
    }

}

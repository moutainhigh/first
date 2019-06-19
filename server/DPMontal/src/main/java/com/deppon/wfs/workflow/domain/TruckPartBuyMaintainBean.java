package com.deppon.wfs.workflow.domain;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 货车配件采购维修保养申请
 * @author Work Flow System
 * @Date 2013-12-24 13:46:01
 */
 
public class TruckPartBuyMaintainBean extends Entity {
	
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 1L;
	
	/** 
	* 表的主键,业务表的编号 
	*/
	private String busino;
	
	/** 
	* 流程实例id 
	*/
	private Long processinstid;
	
	/** 
	* 所属区域 
	*/
	private String area;
	
	/** 
	* 所属区域名称 
	*/
	private String areaName;
	
	/** 
	* 车牌号 
	*/
	private String carNumber;
	
	/** 
	* 申请类型 
	*/
	private String category;
	
	/** 
	* 报销费用 
	*/
	private BigDecimal money;
	
	/** 
	* 申请事由 
	*/
	private String applyReason;
	
	/** 
	* 申请人工号 
	*/
	private String applyPersonId;
	
	/** 
	* 申请人姓名 
	*/
	private String applyPersonName;
	
	/** 
	* 车辆类型 
	*/
	private String truckType;
	
	/** 
	* 修改时间 
	*/
	private Date modifyTime;
	
	/** 
	* 创建时间 
	*/
	private Date createTime;
	
	/** 
	* 业务状态,1表示存在，0逻辑删除 
	*/
	private String isseffective;
	
	/** 
	* 备用字段 
	*/
	private Long spareField1;
	
	/** 
	* 备用字段 
	*/
	private String spareField2;
	
	/** 
	* 备用字段 
	*/
	private String spareField3;

	/**
	 * @return the busino
	 */
	public String getBusino() {
		return busino;
	}

	/**
	 * @param busino the busino to set
	 */
	public void setBusino(String busino) {
		this.busino = busino;
	}

	/**
	 * @return the processinstid
	 */
	public Long getProcessinstid() {
		return processinstid;
	}

	/**
	 * @param processinstid the processinstid to set
	 */
	public void setProcessinstid(Long processinstid) {
		this.processinstid = processinstid;
	}

	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * @return the areaName
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * @param areaName the areaName to set
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * @return the carNumber
	 */
	public String getCarNumber() {
		return carNumber;
	}

	/**
	 * @param carNumber the carNumber to set
	 */
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the money
	 */
	public BigDecimal getMoney() {
		return money;
	}

	/**
	 * @param money the money to set
	 */
	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	/**
	 * @return the applyReason
	 */
	public String getApplyReason() {
		return applyReason;
	}

	/**
	 * @param applyReason the applyReason to set
	 */
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}

	/**
	 * @return the applyPersonId
	 */
	public String getApplyPersonId() {
		return applyPersonId;
	}

	/**
	 * @param applyPersonId the applyPersonId to set
	 */
	public void setApplyPersonId(String applyPersonId) {
		this.applyPersonId = applyPersonId;
	}

	/**
	 * @return the applyPersonName
	 */
	public String getApplyPersonName() {
		return applyPersonName;
	}

	/**
	 * @param applyPersonName the applyPersonName to set
	 */
	public void setApplyPersonName(String applyPersonName) {
		this.applyPersonName = applyPersonName;
	}

	/**
	 * @return the truckType
	 */
	public String getTruckType() {
		return truckType;
	}

	/**
	 * @param truckType the truckType to set
	 */
	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}

	/**
	 * @return the modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * @param modifyTime the modifyTime to set
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the isseffective
	 */
	public String getIsseffective() {
		return isseffective;
	}

	/**
	 * @param isseffective the isseffective to set
	 */
	public void setIsseffective(String isseffective) {
		this.isseffective = isseffective;
	}

	/**
	 * @return the spareField1
	 */
	public Long getSpareField1() {
		return spareField1;
	}

	/**
	 * @param spareField1 the spareField1 to set
	 */
	public void setSpareField1(Long spareField1) {
		this.spareField1 = spareField1;
	}

	/**
	 * @return the spareField2
	 */
	public String getSpareField2() {
		return spareField2;
	}

	/**
	 * @param spareField2 the spareField2 to set
	 */
	public void setSpareField2(String spareField2) {
		this.spareField2 = spareField2;
	}

	/**
	 * @return the spareField3
	 */
	public String getSpareField3() {
		return spareField3;
	}

	/**
	 * @param spareField3 the spareField3 to set
	 */
	public void setSpareField3(String spareField3) {
		this.spareField3 = spareField3;
	}
}

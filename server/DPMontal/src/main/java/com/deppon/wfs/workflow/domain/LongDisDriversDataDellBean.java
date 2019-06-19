package com.deppon.wfs.workflow.domain;

import java.util.Date;

/**
 * 长途司机时效减免申请分录表Bean
 * @author wuguiping
 * @Date 2013-12-25 17:59:11
 */
 
public class LongDisDriversDataDellBean extends Entity {
	
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 1L;
	
	/** 
	* 分录表的主键 
	*/
	private String tableId;
	
	/** 
	* 业务表的编码 
	*/
	private String busino;
	
	/** 
	* 申请减免类型 
	*/
	private String applyBreaksType;
	
	/** 
	* 发车日期 
	*/
	private Date startDate;
	
	/** 
	* 超时时长 
	*/
	private String timeoutValue;
	
	/** 
	* 运行线路 
	*/
	private String runningRoute;
	
	/** 
	* 车牌号 
	*/
	private String licensePlateNumber;
	
	/** 
	* 驾驶员 
	*/
	private String driver;
	
	/** 
	* 出发地 
	*/
	private String origin;
	
	/** 
	* 到达地 
	*/
	private String destination;
	
	/** 
	* 创建时间 
	*/
	private Date createTime;
	
	/** 
	* 修改时间 
	*/
	private Date modifyTime;
	
	/** 
	* 是否有效 
	*/
	private String isseffective;
	
	/** 
	* 备用字段1 
	*/
	private Long spareField1;
	
	/** 
	* 备用字段2 
	*/
	private String spareField2;
	
	/** 
	* 备用字段3 
	*/
	private String spareField3;
	
	
	/**
	* 获取 主键.
	*
	* @return 主键.
	*/
	public String getTableId() {
		return tableId;
	}

	/**
	* 设置 主键.
	*
	* @param 主键.
	*/
	public void setTableId(String tableId) {
		this.tableId = tableId;
	}
	
	/**
	* 获取 业务编码.
	*
	* @return 业务编码.
	*/
	public String getBusino() {
		return busino;
	}

	/**
	* 设置 业务编码.
	*
	* @param 业务编码.
	*/
	public void setBusino(String busino) {
		this.busino = busino;
	}
	
	/**
	* 获取 申请减免类型.
	*
	* @return 申请减免类型.
	*/
	public String getApplyBreaksType() {
		return applyBreaksType;
	}

	/**
	* 设置 申请减免类型.
	*
	* @param 申请减免类型.
	*/
	public void setApplyBreaksType(String applyBreaksType) {
		this.applyBreaksType = applyBreaksType;
	}
	
	/**
	* 获取 发车日期.
	*
	* @return 发车日期.
	*/
	public Date getStartDate() {
		return startDate;
	}

	/**
	* 设置 发车日期.
	*
	* @param 发车日期.
	*/
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	/**
	* 获取 超时时长.
	*
	* @return 超时时长.
	*/
	public String getTimeoutValue() {
		return timeoutValue;
	}

	/**
	* 设置 超时时长.
	*
	* @param 超时时长.
	*/
	public void setTimeoutValue(String timeoutValue) {
		this.timeoutValue = timeoutValue;
	}
	
	/**
	* 获取 运行线路.
	*
	* @return 运行线路.
	*/
	public String getRunningRoute() {
		return runningRoute;
	}

	/**
	* 设置 运行线路.
	*
	* @param 运行线路.
	*/
	public void setRunningRoute(String runningRoute) {
		this.runningRoute = runningRoute;
	}
	
	/**
	* 获取 车牌号.
	*
	* @return 车牌号.
	*/
	public String getLicensePlateNumber() {
		return licensePlateNumber;
	}

	/**
	* 设置 车牌号.
	*
	* @param 车牌号.
	*/
	public void setLicensePlateNumber(String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}
	
	/**
	* 获取 驾驶员.
	*
	* @return 驾驶员.
	*/
	public String getDriver() {
		return driver;
	}

	/**
	* 设置 驾驶员.
	*
	* @param 驾驶员.
	*/
	public void setDriver(String driver) {
		this.driver = driver;
	}
	
	/**
	* 获取 出发地.
	*
	* @return 出发地.
	*/
	public String getOrigin() {
		return origin;
	}

	/**
	* 设置 出发地.
	*
	* @param 出发地.
	*/
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	/**
	* 获取 到达地.
	*
	* @return 到达地.
	*/
	public String getDestination() {
		return destination;
	}

	/**
	* 设置 到达地.
	*
	* @param 到达地.
	*/
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	/**
	* 获取 创建时间.
	*
	* @return 创建时间.
	*/
	public Date getCreateTime() {
		return createTime;
	}

	/**
	* 设置 创建时间.
	*
	* @param 创建时间.
	*/
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	* 获取 修改时间.
	*
	* @return 修改时间.
	*/
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	* 设置 修改时间.
	*
	* @param 修改时间.
	*/
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	/**
	* 获取 是否有效.
	*
	* @return 是否有效.
	*/
	public String getIsseffective() {
		return isseffective;
	}

	/**
	* 设置 是否有效.
	*
	* @param 是否有效.
	*/
	public void setIsseffective(String isseffective) {
		this.isseffective = isseffective;
	}
	
	/**
	* 获取 备用字段1.
	*
	* @return 备用字段1.
	*/
	public Long getSpareField1() {
		return spareField1;
	}

	/**
	* 设置 备用字段1.
	*
	* @param 备用字段1.
	*/
	public void setSpareField1(Long spareField1) {
		this.spareField1 = spareField1;
	}
	
	/**
	* 获取 备用字段2.
	*
	* @return 备用字段2.
	*/
	public String getSpareField2() {
		return spareField2;
	}

	/**
	* 设置 备用字段2.
	*
	* @param 备用字段2.
	*/
	public void setSpareField2(String spareField2) {
		this.spareField2 = spareField2;
	}
	
	/**
	* 获取 备用字段3.
	*
	* @return 备用字段3.
	*/
	public String getSpareField3() {
		return spareField3;
	}

	/**
	* 设置 备用字段3.
	*
	* @param 备用字段3.
	*/
	public void setSpareField3(String spareField3) {
		this.spareField3 = spareField3;
	}
	

}

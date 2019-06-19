/*
 * 
 */
package com.deppon.wfs.workflow.domain;

import java.util.Date;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * 补考勤申请实体Bean.
 *
 * @author Work Flow System
 * @Date 2013-11-14 15:43:18
 */
 
public class RepairAttendance extends Entity {
	
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 1L;
	
	/** 补考勤子表. */
	private List<RepairAttendanceDetails> repairDetails;
	
	/** 表的主键,业务表的编号. */
	private String busino;
	
	/** 流程实例id. */
	private Long processinstid;
	
	/** 申请人姓名. */
	private String applyPersonName;
	
	/** 申请人工号. */
	private String applyPersonId;
	
	/** 所属区域标杆编码. */
	private String area;
	
	/** 所属区域名称. */
	private String areaName;
	
	/** 申请事由. */
	private String applyReason;
	
	/** 修改时间. */
	private Date modifyTime;
	
	/** 创建时间. */
	private Date createTime;
	
	/** 业务状态,1表示存在，0逻辑删除. */
	private Long isseffective;
	
	/** 备用字段. */
	private Long spareField1;
	
	/** 备用字段. */
	private String spareField2;
	
	/** 备用字段. */
	private String spareField3;
	
	
	/**
	* 获得 表的主键,业务表的编号.
	*
	* @return 表的主键,业务表的编号.
	*/
	public String getBusino() {
		return busino;
	}

	/**
	 * 设置 表的主键,业务表的编号.
	 *
	 * @param busino the new busino
	 */
	public void setBusino(String busino) {
		this.busino = busino;
	}
	
	/**
	* 获得 流程实例id.
	*
	* @return 流程实例id.
	*/
	public Long getProcessinstid() {
		return processinstid;
	}

	/**
	 * 设置 流程实例id.
	 *
	 * @param processinstid the new processinstid
	 */
	public void setProcessinstid(Long processinstid) {
		this.processinstid = processinstid;
	}
	
	/**
	* 获得 申请人姓名.
	*
	* @return 申请人姓名.
	*/
	public String getApplyPersonName() {
		return applyPersonName;
	}

	/**
	 * 设置 申请人姓名.
	 *
	 * @param applyPersonName the new applyPersonName
	 */
	public void setApplyPersonName(String applypersonname) {
		this.applyPersonName = applypersonname;
	}
	
	/**
	* 获得 申请人工号.
	*
	* @return 申请人工号.
	*/
	public String getApplyPersonId() {
		return applyPersonId;
	}

	/**
	 * 设置 申请人工号.
	 *
	 * @param applyPersonId the new applyPersonId
	 */
	public void setApplyPersonId(String applypersonid) {
		this.applyPersonId = applypersonid;
	}
	
	/**
	* 获得 所属区域标杆编码.
	*
	* @return 所属区域标杆编码.
	*/
	public String getArea() {
		return area;
	}

	/**
	 * 设置 所属区域标杆编码.
	 *
	 * @param area the new area
	 */
	public void setArea(String area) {
		this.area = area;
	}
	
	/**
	* 获得 所属区域名称.
	*
	* @return 所属区域名称.
	*/
	public String getAreaName() {
		return areaName;
	}

	/**
	 * 设置 所属区域名称.
	 *
	 * @param areaName the new area name
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	/**
	* 获得 申请事由.
	*
	* @return 申请事由.
	*/
	public String getApplyReason() {
		return applyReason;
	}

	/**
	 * 设置 申请事由.
	 *
	 * @param applyReason the new apply reason
	 */
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}
	
	/**
	* 获得 修改时间.
	*
	* @return 修改时间.
	*/
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * 设置 修改时间.
	 *
	 * @param modifyTime the new modify time
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	/**
	* 获得 创建时间.
	*
	* @return 创建时间.
	*/
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置 创建时间.
	 *
	 * @param createTime the new creates the time
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	* 获得 业务状态,1表示存在，0逻辑删除.
	*
	* @return 业务状态,1表示存在，0逻辑删除.
	*/
	public Long getIsseffective() {
		return isseffective;
	}

	/**
	 * 设置 业务状态,1表示存在，0逻辑删除.
	 *
	 * @param isseffective the new isseffective
	 */
	public void setIsseffective(Long isseffective) {
		this.isseffective = isseffective;
	}
	
	/**
	* 获得 备用字段.
	*
	* @return 备用字段.
	*/
	public Long getSpareField1() {
		return spareField1;
	}

	/**
	 * 设置 备用字段.
	 *
	 * @param spareField1 the new spare field1
	 */
	public void setSpareField1(Long spareField1) {
		this.spareField1 = spareField1;
	}
	
	/**
	* 获得 备用字段.
	*
	* @return 备用字段.
	*/
	public String getSpareField2() {
		return spareField2;
	}

	/**
	 * 设置 备用字段.
	 *
	 * @param spareField2 the new spare field2
	 */
	public void setSpareField2(String spareField2) {
		this.spareField2 = spareField2;
	}
	
	/**
	* 获得 备用字段.
	*
	* @return 备用字段.
	*/
	public String getSpareField3() {
		return spareField3;
	}

	/**
	 * 设置 备用字段.
	 *
	 * @param spareField3 the new spare field3
	 */
	public void setSpareField3(String spareField3) {
		this.spareField3 = spareField3;
	}

	/**
	 * Gets the repair details.
	 *
	 * @return the repair details
	 */
	public List<RepairAttendanceDetails> getRepairDetails() {
		return repairDetails;
	}

	/**
	 * Sets the repair details.
	 *
	 * @param repairDetails the new repair details
	 */
	public void setRepairDetails(List<RepairAttendanceDetails> repairDetails) {
		this.repairDetails = repairDetails;
	}

}

package com.deppon.wfs.workflow.domain;

import java.util.Date;

/**
 * 补考勤申请详情实体Bean
 * @author Work Flow System
 * @Date 2013-11-14 15:44:37
 */
 
public class RepairAttendanceDetails extends Entity {
	
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 1L;
	
	/** 
	* 表的主键 
	*/
	private String tableId;
	
	/** 
	* 业务表的编号 
	*/
	private String busino;
	
	/** 
	* 补考勤人员姓名 
	*/
	private String attendancepersonname;
	
	/** 
	* 补考勤人员所在部门 
	*/
	private String departmentName;
	
	/** 
	* 补考勤时间 
	*/
	private Date repairTime;
	
	/** 
	* 补考勤类型 
	*/
	private String attendanceType;
	
	/** 
	* 补考勤原因 
	*/
	private String attendanceReason;
	
	/** 
	* 证明人姓名 
	*/
	private String confirmName;
	
	/** 
	* 创建时间 
	*/
	private Date createTime;
	
	/** 
	* 业务状态,1表示存在，0逻辑删除 
	*/
	private Long isseffective;
	
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
	*    修改时间 
	*/
	private Date modifyTime;
	
	
	/**
	* 鑾峰彇 表的主键.
	*
	* @return 表的主键.
	*/
	public String getTableId() {
		return tableId;
	}

	/**
	* 璁剧疆 表的主键.
	*
	* @param 表的主键.
	*/
	public void setTableId(String tableid) {
		this.tableId = tableid;
	}
	
	/**
	* 鑾峰彇 业务表的编号.
	*
	* @return 业务表的编号.
	*/
	public String getBusino() {
		return busino;
	}

	/**
	* 璁剧疆 业务表的编号.
	*
	* @param 业务表的编号.
	*/
	public void setBusino(String busino) {
		this.busino = busino;
	}
	
	/**
	* 鑾峰彇 补考勤人员姓名.
	*
	* @return 补考勤人员姓名.
	*/
	public String getAttendancepersonname() {
		return attendancepersonname;
	}

	/**
	* 璁剧疆 补考勤人员姓名.
	*
	* @param 补考勤人员姓名.
	*/
	public void setAttendancepersonname(String attendancepersonname) {
		this.attendancepersonname = attendancepersonname;
	}
	
	/**
	* 鑾峰彇 补考勤人员所在部门.
	*
	* @return 补考勤人员所在部门.
	*/
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	* 璁剧疆 补考勤人员所在部门.
	*
	* @param 补考勤人员所在部门.
	*/
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	/**
	* 鑾峰彇 补考勤时间.
	*
	* @return 补考勤时间.
	*/
	public Date getRepairTime() {
		return repairTime;
	}

	/**
	* 璁剧疆 补考勤时间.
	*
	* @param 补考勤时间.
	*/
	public void setRepairTime(Date repairTime) {
		this.repairTime = repairTime;
	}
	
	/**
	* 鑾峰彇 补考勤类型.
	*
	* @return 补考勤类型.
	*/
	public String getAttendanceType() {
		return attendanceType;
	}

	/**
	* 璁剧疆 补考勤类型.
	*
	* @param 补考勤类型.
	*/
	public void setAttendanceType(String attendanceType) {
		this.attendanceType = attendanceType;
	}
	
	/**
	* 鑾峰彇 补考勤原因.
	*
	* @return 补考勤原因.
	*/
	public String getAttendanceReason() {
		return attendanceReason;
	}

	/**
	* 璁剧疆 补考勤原因.
	*
	* @param 补考勤原因.
	*/
	public void setAttendanceReason(String attendanceReason) {
		this.attendanceReason = attendanceReason;
	}
	
	/**
	* 鑾峰彇 证明人姓名.
	*
	* @return 证明人姓名.
	*/
	public String getConfirmName() {
		return confirmName;
	}

	/**
	* 璁剧疆 证明人姓名.
	*
	* @param 证明人姓名.
	*/
	public void setConfirmName(String confirmName) {
		this.confirmName = confirmName;
	}
	
	/**
	* 鑾峰彇 创建时间.
	*
	* @return 创建时间.
	*/
	public Date getCreateTime() {
		return createTime;
	}

	/**
	* 璁剧疆 创建时间.
	*
	* @param 创建时间.
	*/
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	* 鑾峰彇 业务状态,1表示存在，0逻辑删除.
	*
	* @return 业务状态,1表示存在，0逻辑删除.
	*/
	public Long getIsseffective() {
		return isseffective;
	}

	/**
	* 璁剧疆 业务状态,1表示存在，0逻辑删除.
	*
	* @param 业务状态,1表示存在，0逻辑删除.
	*/
	public void setIsseffective(Long isseffective) {
		this.isseffective = isseffective;
	}
	
	/**
	* 鑾峰彇 备用字段.
	*
	* @return 备用字段.
	*/
	public Long getSpareField1() {
		return spareField1;
	}

	/**
	* 璁剧疆 备用字段.
	*
	* @param 备用字段.
	*/
	public void setSpareField1(Long spareField1) {
		this.spareField1 = spareField1;
	}
	
	/**
	* 鑾峰彇 备用字段.
	*
	* @return 备用字段.
	*/
	public String getSpareField2() {
		return spareField2;
	}

	/**
	* 璁剧疆 备用字段.
	*
	* @param 备用字段.
	*/
	public void setSpareField2(String spareField2) {
		this.spareField2 = spareField2;
	}
	
	/**
	* 鑾峰彇 备用字段.
	*
	* @return 备用字段.
	*/
	public String getSpareField3() {
		return spareField3;
	}

	/**
	* 璁剧疆 备用字段.
	*
	* @param 备用字段.
	*/
	public void setSpareField3(String spareField3) {
		this.spareField3 = spareField3;
	}
	
	/**
	* 鑾峰彇    修改时间.
	*
	* @return    修改时间.
	*/
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	* 璁剧疆    修改时间.
	*
	* @param    修改时间.
	*/
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	

}

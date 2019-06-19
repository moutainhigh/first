package com.deppon.wfs.workflow.domain;

import java.util.Date;

/**
 * 场地找点申请
 * @author Work Flow System
 * @Date 2014-01-09 13:54:44
 */
 
public class SiteFindPointsBean extends Entity {
	
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 5463602752185251859L;

	/** 
	* 主键 
	*/
	private String busino;
	
	/** 
	* 流程实例ID 
	*/
	private Long processinstid;
	
	/** 
	* 申请人姓名 
	*/
	private String applyPersonName;
	
	/** 
	* 申请人工号 
	*/
	private String applyPersonId;
	
	/** 
	* 所属部门 
	*/
	private String deptName;
	
	/** 
	* 所属部门编码 
	*/
	private String deptCode;
	
	/** 
	* 所属事业部编码 
	*/
	private String divisionCode;
	
	/** 
	* 申请事由 
	*/
	private String applyReason;
	
	/** 
	* 创建时间 
	*/
	private Date createTime;
	
	/** 
	* 修改时间 
	*/
	private Date modifyTime;
	
	/** 
	* 业务状态，是否有效（1-有效 0-无效） 
	*/
	private String isEffective;
	
	/** 
	* 备注1 
	*/
	private Long reserve1;
	
	/** 
	* 备注2 
	*/
	private String reserve2;
	
	/** 
	* 备注3 
	*/
	private String reserve3;
	
	/** 
	* 申请人empid(老数据)
	*/
	private Long empid;
	
	/** 
	* 场地要求(老数据)
	*/
	private String siterequire;
	
	/** 
	* 所属区域(老数据)
	*/
	private String area;
	
	/**
	* 获取申请人empid(老数据).
	*
	* @return 申请人empid(老数据).
	*/
	public Long getEmpid() {
		return empid;
	}


	/**
	* 设置 申请人empid(老数据).
	*
	* @param 申请人empid(老数据).
	*/
	public void setEmpid(Long empid) {
		this.empid = empid;
	}

	/**
	* 获取 场地要求(老数据).
	*
	* @return 场地要求(老数据).
	*/
	public String getSiterequire() {
		return siterequire;
	}


	/**
	* 设置 场地要求(老数据).
	*
	* @param 场地要求(老数据).
	*/
	public void setSiterequire(String siterequire) {
		this.siterequire = siterequire;
	}

	/**
	* 获取所属区域(迁移的老数据).
	*
	* @return 所属区域(迁移的老数据).
	*/
	public String getArea() {
		return area;
	}


	/**
	* 设置所属区域(迁移的老数据).
	*
	* @param 所属区域(迁移的老数据).
	*/
	public void setArea(String area) {
		this.area = area;
	}
	
	/**
	* 获取 主键.
	*
	* @return 主键.
	*/
	public String getBusino() {
		return busino;
	}

	/**
	* 设置 主键.
	*
	* @param 主键.
	*/
	public void setBusino(String busino) {
		this.busino = busino;
	}
	
	/**
	* 获取 流程实例ID.
	*
	* @return 流程实例ID.
	*/
	public Long getProcessinstid() {
		return processinstid;
	}

	/**
	* 设置 流程实例ID.
	*
	* @param 流程实例ID.
	*/
	public void setProcessinstid(Long processinstid) {
		this.processinstid = processinstid;
	}
	
	/**
	* 获取 申请人姓名.
	*
	* @return 申请人姓名.
	*/
	public String getApplyPersonName() {
		return applyPersonName;
	}

	/**
	* 设置 申请人姓名.
	*
	* @param 申请人姓名.
	*/
	public void setApplyPersonName(String applyPersonName) {
		this.applyPersonName = applyPersonName;
	}
	
	/**
	* 获取 申请人工号.
	*
	* @return 申请人工号.
	*/
	public String getApplyPersonId() {
		return applyPersonId;
	}

	/**
	* 设置 申请人工号.
	*
	* @param 申请人工号.
	*/
	public void setApplyPersonId(String applyPersonId) {
		this.applyPersonId = applyPersonId;
	}
	
	/**
	* 获取 所属部门.
	*
	* @return 所属部门.
	*/
	public String getDeptName() {
		return deptName;
	}

	/**
	* 设置 所属部门.
	*
	* @param 所属部门.
	*/
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	/**
	* 获取 所属部门编码.
	*
	* @return 所属部门编码.
	*/
	public String getDeptCode() {
		return deptCode;
	}

	/**
	* 设置 所属部门编码.
	*
	* @param 所属部门编码.
	*/
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	
	/**
	* 获取 所属事业部编码.
	*
	* @return 所属事业部编码.
	*/
	public String getDivisionCode() {
		return divisionCode;
	}

	/**
	* 设置 所属事业部编码.
	*
	* @param 所属事业部编码.
	*/
	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}
	
	/**
	* 获取 申请事由.
	*
	* @return 申请事由.
	*/
	public String getApplyReason() {
		return applyReason;
	}

	/**
	* 设置 申请事由.
	*
	* @param 申请事由.
	*/
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
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
	* 获取 业务状态，是否有效（1-有效 0-无效）.
	*
	* @return 业务状态，是否有效（1-有效 0-无效）.
	*/
	public String getIsEffective() {
		return isEffective;
	}

	/**
	* 设置 业务状态，是否有效（1-有效 0-无效）.
	*
	* @param 业务状态，是否有效（1-有效 0-无效）.
	*/
	public void setIsEffective(String isEffective) {
		this.isEffective = isEffective;
	}
	
	/**
	* 获取 备注1.
	*
	* @return 备注1.
	*/
	public Long getReserve1() {
		return reserve1;
	}

	/**
	* 设置 备注1.
	*
	* @param 备注1.
	*/
	public void setReserve1(Long reserve1) {
		this.reserve1 = reserve1;
	}
	
	/**
	* 获取 备注2.
	*
	* @return 备注2.
	*/
	public String getReserve2() {
		return reserve2;
	}

	/**
	* 设置 备注2.
	*
	* @param 备注2.
	*/
	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}
	
	/**
	* 获取 备注3.
	*
	* @return 备注3.
	*/
	public String getReserve3() {
		return reserve3;
	}

	/**
	* 设置 备注3.
	*
	* @param 备注3.
	*/
	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3;
	}
}

package com.deppon.wfs.workflow.domain;

import java.util.Date;

/**
 * 考核数据提交申请
 * @author wuguiping
 * @Date 2014-01-13 15:13:50
 */
 
public class InspectionDataSubmitBean extends Entity {
	
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 1L;
	
	/** 
	* 业务编码 
	*/
	private String busino;
	
	/** 
	* 工作流序号 
	*/
	private Long processinstid;
	
	/** 
	* 申请人EMPID 
	*/
	private Long applyPersonEmpid;
	
	/** 
	* 申请人 
	*/
	private String applyPersonName;
	
	/** 
	* 申请人工号 
	*/
	private String applyPersonId;
	
	/** 
	* 所在部门 
	*/
	private String applyDept;
	
	/** 
	* 所在部门ID 
	*/
	private String applyDeptId;
	
	/** 
	* 提供数据给 
	*/
	private String target;
	
	/** 
	* 人事部区域 
	*/
	private String area;
	
	/** 
	* 申请事由 
	*/
	private String reason;
	
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
	* 获取 工作流序号.
	*
	* @return 工作流序号.
	*/
	public Long getProcessinstid() {
		return processinstid;
	}

	/**
	* 设置 工作流序号.
	*
	* @param 工作流序号.
	*/
	public void setProcessinstid(Long processinstid) {
		this.processinstid = processinstid;
	}
	
	/**
	* 获取 申请人EMPID.
	*
	* @return 申请人EMPID.
	*/
	public Long getApplyPersonEmpid() {
		return applyPersonEmpid;
	}

	/**
	* 设置 申请人EMPID.
	*
	* @param 申请人EMPID.
	*/
	public void setApplyPersonEmpid(Long applyPersonEmpid) {
		this.applyPersonEmpid = applyPersonEmpid;
	}
	
	/**
	* 获取 申请人.
	*
	* @return 申请人.
	*/
	public String getApplyPersonName() {
		return applyPersonName;
	}

	/**
	* 设置 申请人.
	*
	* @param 申请人.
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
	* 获取 所在部门.
	*
	* @return 所在部门.
	*/
	public String getApplyDept() {
		return applyDept;
	}

	/**
	* 设置 所在部门.
	*
	* @param 所在部门.
	*/
	public void setApplyDept(String applyDept) {
		this.applyDept = applyDept;
	}
	
	/**
	* 获取 所在部门ID.
	*
	* @return 所在部门ID.
	*/
	public String getApplyDeptId() {
		return applyDeptId;
	}

	/**
	* 设置 所在部门ID.
	*
	* @param 所在部门ID.
	*/
	public void setApplyDeptId(String applyDeptId) {
		this.applyDeptId = applyDeptId;
	}
	
	/**
	* 获取提供数据给.
	*
	* @return 提供数据给.
	*/
	public String getTarget() {
		return target;
	}

	/**
	* 设置 提供数据给.
	*
	* @param 提供数据给.
	*/
	public void setTarget(String target) {
		this.target = target;
	}
	
	/**
	* 获取 人事部区域.
	*
	* @return 人事部区域.
	*/
	public String getArea() {
		return area;
	}

	/**
	* 设置 人事部区域.
	*
	* @param 人事部区域.
	*/
	public void setArea(String area) {
		this.area = area;
	}
	
	/**
	* 获取 申请事由.
	*
	* @return 申请事由.
	*/
	public String getReason() {
		return reason;
	}

	/**
	* 设置 申请事由.
	*
	* @param 申请事由.
	*/
	public void setReason(String reason) {
		this.reason = reason;
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

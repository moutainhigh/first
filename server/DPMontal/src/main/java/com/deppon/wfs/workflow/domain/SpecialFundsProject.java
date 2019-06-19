package com.deppon.wfs.workflow.domain;

import java.util.Date;

/**
 * 专项费用立项bean
 * @author 何玲菠
 * @Date 2013-10-17 16:33:05
 */
 
public class SpecialFundsProject extends Entity{
	
	/** 
	* The Constant serialVersionUID. 
	*/
	
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	/** 
	* 主键ID 
	*/
	private String busino;
	
	/** 
	* 流程实例的id 
	*/
	private Long processinstid;
	
	/** 
	* 起草人工号 
	*/
	private String applyPersonId;
	
	/** 
	* 起草人姓名 
	*/
	private String applyPersonName;
	
	/** 
	* 申请人工号 
	*/
	private String applyId;
	
	/** 
	* 申请人姓名 
	*/
	private String applyName;
	
	/** 
	* 申请人部门 
	*/
	private String applyDepartment;
	
	/** 
	* 申请人empid 
	*/
	private String empId;
	
	/** 
	* 申请事由 
	*/
	private String reason;


	/** 
	* 所属子公司 
	*/
	private String subCompany;
	
	/** 
	* 所属大区 
	*/
	private String area;
	
	/** 
	* 类型 
	*/
	private String wType;
	
	/** 
	* 工作流修改时间 
	*/
	private Date modifyTime;
	
	/** 
	* 工作流创建时间 
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
	* 获取 主键ID.
	*
	* @return 主键ID.
	*/
	public String getBusino() {
		return busino;
	}

	/**
	* 设置 主键ID.
	*
	* @param 主键ID.
	*/
	public void setBusino(String busino) {
		this.busino = busino;
	}
	
	/**
	* 获取 流程实例的id.
	*
	* @return 流程实例的id.
	*/
	public Long getProcessinstid() {
		return processinstid;
	}

	/**
	* 设置 流程实例的id.
	*
	* @param 流程实例的id.
	*/
	public void setProcessinstid(Long processinstid) {
		this.processinstid = processinstid;
	}
	
	/**
	* 获取 申请人工号.
	*
	* @return 申请人工号.
	*/
	public String getApplyId() {
		return applyId;
	}

	
	/**
	* 获取 起草人工号.
	*
	* @return 起草人工号.
	*/
	public String getApplyPersonId() {
		return applyPersonId;
	}
	
	/**
	* 设置 起草人工号.
	*
	* @param 起草人工号.
	*/
	public void setApplyPersonId(String applyPersonId) {
		this.applyPersonId = applyPersonId;
	}
	
	/**
	* 获取 起草人姓名.
	*
	* @return 起草人姓名.
	*/
	public String getApplyPersonName() {
		return applyPersonName;
	}

	/**
	* 设置 起草人姓名.
	*
	* @param 起草人姓名.
	*/
	public void setApplyPersonName(String applyPersonName) {
		this.applyPersonName = applyPersonName;
	}

	public String getwType() {
		return wType;
	}

	public void setwType(String wType) {
		this.wType = wType;
	}

	/**
	* 设置 申请人工号.
	*
	* @param 申请人工号.
	*/
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	
	/**
	* 获取 申请人姓名.
	*
	* @return 申请人姓名.
	*/
	public String getApplyName() {
		return applyName;
	}

	/**
	* 设置 申请人姓名.
	*
	* @param 申请人姓名.
	*/
	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}
	
	/**
	* 获取 申请人部门.
	*
	* @return 申请人部门.
	*/
	public String getApplyDepartment() {
		return applyDepartment;
	}

	/**
	* 设置 申请人部门.
	*
	* @param 申请人部门.
	*/
	public void setApplyDepartment(String applyDepartment) {
		this.applyDepartment = applyDepartment;
	}
	
	/**
	* 获取 申请人empid.
	*
	* @return 申请人empid.
	*/
	public String getEmpId() {
		return empId;
	}

	/**
	* 设置 申请人empid.
	*
	* @param 申请人empid.
	*/
	public void setEmpId(String empId) {
		this.empId = empId;
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
	* 获取 所属子公司.
	*
	* @return 所属子公司.
	*/
	public String getSubCompany() {
		return subCompany;
	}

	/**
	* 设置 所属子公司.
	*
	* @param 所属子公司.
	*/
	public void setSubCompany(String subCompany) {
		this.subCompany = subCompany;
	}
	
	/**
	* 获取 所属大区.
	*
	* @return 所属大区.
	*/
	public String getArea() {
		return area;
	}

	/**
	* 设置 所属大区.
	*
	* @param 所属大区.
	*/
	public void setArea(String area) {
		this.area = area;
	}
	
	/**
	* 获取 类型.
	*
	* @return 类型.
	*/
	public String getWType() {
		return wType;
	}

	/**
	* 设置 类型.
	*
	* @param 类型.
	*/
	public void setWType(String wType) {
		this.wType = wType;
	}
	
	/**
	* 获取 工作流修改时间.
	*
	* @return 工作流修改时间.
	*/
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	* 设置 工作流修改时间.
	*
	* @param 工作流修改时间.
	*/
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	/**
	* 获取 工作流创建时间.
	*
	* @return 工作流创建时间.
	*/
	public Date getCreateTime() {
		return createTime;
	}

	/**
	* 设置 工作流创建时间.
	*
	* @param 工作流创建时间.
	*/
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	* 获取 业务状态,1表示存在，0逻辑删除.
	*
	* @return 业务状态,1表示存在，0逻辑删除.
	*/
	public String getIsseffective() {
		return isseffective;
	}

	/**
	* 设置 业务状态,1表示存在，0逻辑删除.
	*
	* @param 业务状态,1表示存在，0逻辑删除.
	*/
	public void setIsseffective(String isseffective) {
		this.isseffective = isseffective;
	}
	
	/**
	* 获取 备用字段.
	*
	* @return 备用字段.
	*/
	public Long getSpareField1() {
		return spareField1;
	}

	/**
	* 设置 备用字段.
	*
	* @param 备用字段.
	*/
	public void setSpareField1(Long spareField1) {
		this.spareField1 = spareField1;
	}
	
	/**
	* 获取 备用字段.
	*
	* @return 备用字段.
	*/
	public String getSpareField2() {
		return spareField2;
	}

	/**
	* 设置 备用字段.
	*
	* @param 备用字段.
	*/
	public void setSpareField2(String spareField2) {
		this.spareField2 = spareField2;
	}
	
	/**
	* 获取 备用字段.
	*
	* @return 备用字段.
	*/
	public String getSpareField3() {
		return spareField3;
	}

	/**
	* 设置 备用字段.
	*
	* @param 备用字段.
	*/
	public void setSpareField3(String spareField3) {
		this.spareField3 = spareField3;
	}
	

}

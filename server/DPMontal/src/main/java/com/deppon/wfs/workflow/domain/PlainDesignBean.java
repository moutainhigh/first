package com.deppon.wfs.workflow.domain;

import java.util.Date;

/**
 * 企划设计制作申请Bean
 * @author 关波
 * @Date 2014-01-09 21:45:19
 */
 
public class PlainDesignBean extends Entity {
	
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 1L;
	
	/** 
	* 业务表主键 
	*/
	private String busino;
	
	/** 
	* 流程实例号 
	*/
	private Long processinstid;
	
	/** 
	* 申请事由 
	*/
	private String reason;
	
	/** 
	* 申请人工号 
	*/
	private String applyPersonId;
	
	/** 
	* 申请人姓名 
	*/
	private String applyPersonName;
	
	/** 
	* 老表有的字段，新工作流不使用 
	*/
	private String empId;
	
	/** 
	* 老表的字段，新工作流不使用 
	*/
	private String marketing;
	
	/** 
	* 老表的字段，新工作流不使用 
	*/
	private String design;
	
	/** 
	* 申请人所在部门 
	*/
	private String userOrg;
	
	/** 
	* 申请类型（审批环节中添加的字段，用来在判断流向） 
	*/
	private String applyType;
	
	/** 
	* 所属事业部，老表存的业务字典，新工作流不使用 
	*/
	private String area;
	
	/** 
	* 业务数据创建时间 
	*/
	private Date modifyTime;
	
	/** 
	* 业务数据修改时间 
	*/
	private Date createTime;
	
	/** 
	* 业务状态，1表示正在使用，0表示逻辑删除 
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
	* 获取 业务表主键.
	*
	* @return 业务表主键.
	*/
	public String getBusino() {
		return busino;
	}

	/**
	* 设置 业务表主键.
	*
	* @param 业务表主键.
	*/
	public void setBusino(String busino) {
		this.busino = busino;
	}
	
	/**
	* 获取 流程实例号.
	*
	* @return 流程实例号.
	*/
	public Long getProcessinstid() {
		return processinstid;
	}

	/**
	* 设置 流程实例号.
	*
	* @param 流程实例号.
	*/
	public void setProcessinstid(Long processinstid) {
		this.processinstid = processinstid;
	}
	
	/**
	* 获取 申请事由.
	*
	* @return 申请事由.
	*/
	public String getReason() {
		if (reason == null) {
			reason = "";
		}
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
	* 获取 老表有的字段，新工作流不使用.
	*
	* @return 老表有的字段，新工作流不使用.
	*/
	public String getEmpId() {
		return empId;
	}

	/**
	* 设置 老表有的字段，新工作流不使用.
	*
	* @param 老表有的字段，新工作流不使用.
	*/
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	/**
	* 获取 老表的字段，新工作流不使用.
	*
	* @return 老表的字段，新工作流不使用.
	*/
	public String getMarketing() {
		return marketing;
	}

	/**
	* 设置 老表的字段，新工作流不使用.
	*
	* @param 老表的字段，新工作流不使用.
	*/
	public void setMarketing(String marketing) {
		this.marketing = marketing;
	}
	
	/**
	* 获取 老表的字段，新工作流不使用.
	*
	* @return 老表的字段，新工作流不使用.
	*/
	public String getDesign() {
		return design;
	}

	/**
	* 设置 老表的字段，新工作流不使用.
	*
	* @param 老表的字段，新工作流不使用.
	*/
	public void setDesign(String design) {
		this.design = design;
	}
	
	/**
	* 获取 申请人所在部门.
	*
	* @return 申请人所在部门.
	*/
	public String getUserOrg() {
		return userOrg;
	}

	/**
	* 设置 申请人所在部门.
	*
	* @param 申请人所在部门.
	*/
	public void setUserOrg(String userOrg) {
		this.userOrg = userOrg;
	}
	
	/**
	* 获取 申请类型（审批环节中添加的字段，用来在判断流向）.
	*
	* @return 申请类型（审批环节中添加的字段，用来在判断流向）.
	*/
	public String getApplyType() {
		return applyType;
	}

	/**
	* 设置 申请类型（审批环节中添加的字段，用来在判断流向）.
	*
	* @param 申请类型（审批环节中添加的字段，用来在判断流向）.
	*/
	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}
	
	/**
	* 获取 所属事业部，老表存的业务字典，新工作流不使用.
	*
	* @return 所属事业部，老表存的业务字典，新工作流不使用.
	*/
	public String getArea() {
		return area;
	}

	/**
	* 设置 所属事业部，老表存的业务字典，新工作流不使用.
	*
	* @param 所属事业部，老表存的业务字典，新工作流不使用.
	*/
	public void setArea(String area) {
		this.area = area;
	}
	
	/**
	* 获取 业务数据创建时间.
	*
	* @return 业务数据创建时间.
	*/
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	* 设置 业务数据创建时间.
	*
	* @param 业务数据创建时间.
	*/
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	/**
	* 获取 业务数据修改时间.
	*
	* @return 业务数据修改时间.
	*/
	public Date getCreateTime() {
		return createTime;
	}

	/**
	* 设置 业务数据修改时间.
	*
	* @param 业务数据修改时间.
	*/
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	* 获取 业务状态，1表示正在使用，0表示逻辑删除.
	*
	* @return 业务状态，1表示正在使用，0表示逻辑删除.
	*/
	public String getIsseffective() {
		return isseffective;
	}

	/**
	* 设置 业务状态，1表示正在使用，0表示逻辑删除.
	*
	* @param 业务状态，1表示正在使用，0表示逻辑删除.
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

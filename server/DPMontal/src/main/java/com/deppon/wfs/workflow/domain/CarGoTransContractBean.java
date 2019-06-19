package com.deppon.wfs.workflow.domain;

import java.util.Date;

/**
 * 整车货物运输合同实体Bean
 * @author meng tianxiang
 * @Date 2013-11-26 14:41:35
 */
 
public class CarGoTransContractBean extends Entity {
	
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
	* 申请人 
	*/
	private String applyPersonName;
	
	/** 
	* 申请人工号 
	*/
	private String applyPersonId;
	
	/** 
	* 创建时间 
	*/
	private Date createTime;
	
	/** 
	* 修改时间 
	*/
	private Date modifyTime;
	
	/** 
	* 备用字段1 
	*/
	private String spareField1;
	
	/** 
	* 备用字段2 
	*/
	private String spareField2;
	
	/** 
	* 是否有效 
	*/
	private String isseffective;
	
	/** 
	* 备用字段3 
	*/
	private Long spareField3;
	
	/** 
	* 所属区域(同旧表) 
	*/
	private String area;
	
	/** 
	* 客户名称 
	*/
	private String clientName;
	
	/** 
	* 所属子公司(同旧表) 
	*/
	private String subsidiary;
	
	/** 
	* 申请事由(同旧表) 
	*/
	private String reason;
	
	/**
	 * 所属区域标杆编码
	 */
	private String areaSyscode;
	
	
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
	* 获取 备用字段1.
	*
	* @return 备用字段1.
	*/
	public String getSpareField1() {
		return spareField1;
	}

	/**
	* 设置 备用字段1.
	*
	* @param 备用字段1.
	*/
	public void setSpareField1(String spareField1) {
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
	* 获取 备用字段3.
	*
	* @return 备用字段3.
	*/
	public Long getSpareField3() {
		return spareField3;
	}

	/**
	* 设置 备用字段3.
	*
	* @param 备用字段3.
	*/
	public void setSpareField3(Long spareField3) {
		this.spareField3 = spareField3;
	}
	
	/**
	* 获取 所属区域(同旧表).
	*
	* @return 所属区域(同旧表).
	*/
	public String getArea() {
		return area;
	}

	/**
	* 设置 所属区域(同旧表).
	*
	* @param 所属区域(同旧表).
	*/
	public void setArea(String area) {
		this.area = area;
	}
	
	/**
	* 获取 客户名称.
	*
	* @return 客户名称.
	*/
	public String getClientName() {
		return clientName;
	}

	/**
	* 设置 客户名称.
	*
	* @param 客户名称.
	*/
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	/**
	* 获取 所属子公司(同旧表).
	*
	* @return 所属子公司(同旧表).
	*/
	public String getSubsidiary() {
		return subsidiary;
	}

	/**
	* 设置 所属子公司(同旧表).
	*
	* @param 所属子公司(同旧表).
	*/
	public void setSubsidiary(String subsidiary) {
		this.subsidiary = subsidiary;
	}
	
	/**
	* 获取 申请事由(同旧表).
	*
	* @return 申请事由(同旧表).
	*/
	public String getReason() {
		return reason;
	}

	/**
	* 设置 申请事由(同旧表).
	*
	* @param 申请事由(同旧表).
	*/
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	* 获取 所属区域标杆编码.
	*
	* @return 所属区域标杆编码.
	*/
	public String getAreaSyscode() {
		return areaSyscode;
	}

	/**
	* 设置 所属区域标杆编码.
	*
	* @param 所属区域标杆编码.
	*/
	public void setAreaSyscode(String areaSyscode) {
		this.areaSyscode = areaSyscode;
	}
	
}

package com.deppon.wfs.workflow.domain;

import java.util.Date;

/**
 * 价格调整申请实体Bean
 * @author meng tianxiang
 * @Date 2014-01-07 18:47:49
 */
 
public class AdjustPriceBean extends Entity {
	
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
	* 是否有效 
	*/
	private String isseffective;
	
	/** 
	* 申请事由 
	*/
	private String applyReason;
	
	/** 
	* 备用字段1 
	*/
	private String spareField1;
	
	/** 
	* 备用字段2 
	*/
	private String spareField2;
	
	/** 
	* 备用字段3 
	*/
	private Long spareField3;
	
	/** 
	* 调价类型 
	*/
	private String adjustType;
	
	/** 
	* 调价类型编码(同旧表REGULATEPRICETYPE) 
	*/
	private String adjustTypeCode;
	
	/** 
	* 所属事业部 
	*/
	private String belongDivision;
	
	/** 
	* 所属事业部标杆编码(同旧表REGULATEPRICEAREA) 
	*/
	private String belongDivisionSyscode;
	
	/** 
	* 是否为产品与价格管理部总监(同旧表，用于迁移) 
	*/
	private String checkDeptManager;
	
	
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
	* 获取 调价类型.
	*
	* @return 调价类型.
	*/
	public String getAdjustType() {
		return adjustType;
	}

	/**
	* 设置 调价类型.
	*
	* @param 调价类型.
	*/
	public void setAdjustType(String adjustType) {
		this.adjustType = adjustType;
	}
	
	/**
	* 获取 调价类型编码(同旧表REGULATEPRICETYPE).
	*
	* @return 调价类型编码(同旧表REGULATEPRICETYPE).
	*/
	public String getAdjustTypeCode() {
		return adjustTypeCode;
	}

	/**
	* 设置 调价类型编码(同旧表REGULATEPRICETYPE).
	*
	* @param 调价类型编码(同旧表REGULATEPRICETYPE).
	*/
	public void setAdjustTypeCode(String adjustTypeCode) {
		this.adjustTypeCode = adjustTypeCode;
	}
	
	/**
	* 获取 所属事业部.
	*
	* @return 所属事业部.
	*/
	public String getBelongDivision() {
		return belongDivision;
	}

	/**
	* 设置 所属事业部.
	*
	* @param 所属事业部.
	*/
	public void setBelongDivision(String belongDivision) {
		this.belongDivision = belongDivision;
	}
	
	/**
	* 获取 所属事业部标杆编码(同旧表REGULATEPRICEAREA).
	*
	* @return 所属事业部标杆编码(同旧表REGULATEPRICEAREA).
	*/
	public String getBelongDivisionSyscode() {
		return belongDivisionSyscode;
	}

	/**
	* 设置 所属事业部标杆编码(同旧表REGULATEPRICEAREA).
	*
	* @param 所属事业部标杆编码(同旧表REGULATEPRICEAREA).
	*/
	public void setBelongDivisionSyscode(String belongDivisionSyscode) {
		this.belongDivisionSyscode = belongDivisionSyscode;
	}
	
	/**
	* 获取 是否为产品与价格管理部总监(同旧表，用于迁移).
	*
	* @return 是否为产品与价格管理部总监(同旧表，用于迁移).
	*/
	public String getCheckDeptManager() {
		return checkDeptManager;
	}

	/**
	* 设置 是否为产品与价格管理部总监(同旧表，用于迁移).
	*
	* @param 是否为产品与价格管理部总监(同旧表，用于迁移).
	*/
	public void setCheckDeptManager(String checkDeptManager) {
		this.checkDeptManager = checkDeptManager;
	}
	

}

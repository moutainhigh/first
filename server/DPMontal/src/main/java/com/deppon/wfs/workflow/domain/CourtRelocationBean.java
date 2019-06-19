package com.deppon.wfs.workflow.domain;

import java.util.Date;
 
public class CourtRelocationBean extends Entity {
	
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
	* 申请人部门(同旧表USERDEPT) 
	*/
	private String applyPersonDept;
	
	/** 
	* 所属事业部 
	*/
	private String belongDivision;
	
	/** 
	* 所属事业部标杆编码 
	*/
	private String belongDivisionSyscode;
	
	/** 
	* 资源协调类型 
	*/
	private String coordinationType;
	
	/** 
	* 资源协调类型编码 
	*/
	private String coordinationTypeCode;
	
	/** 
	* 是否枢纽 
	*/
	private String isHub;
	
	/** 
	* 是否枢纽编码 
	*/
	private String isHubCode;
	
	/** 
	* 搬迁日期 
	*/
	private Date relocationDate;
	
	/** 
	* 场地租赁/转租合同工作流号 
	*/
	private String contractProcessinstid;
	
	/** 
	* 场地类型(仅供迁移)
	*/
	private String courtType;
	
	/** 
	* 场地名称(仅供迁移)
	*/
	private String courtName;
	
	/** 
	* 合同签订时间(仅供迁移)
	*/
	private Date signTime;
	
	/** 
	* 搬迁时间(仅供迁移)
	*/
	private Date relocationTime;
	
	/** 
	* 场地面积(仅供迁移)
	*/
	private String courtArea;
	
	/** 
	* 货台面积(仅供迁移)
	*/
	private String platformArea;
	
	/** 
	* 所属人事部(仅供迁移)
	*/
	private String area;
	
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
	* 获取 申请人部门(同旧表USERDEPT).
	*
	* @return 申请人部门(同旧表USERDEPT).
	*/
	public String getApplyPersonDept() {
		return applyPersonDept;
	}

	/**
	* 设置 申请人部门(同旧表USERDEPT).
	*
	* @param 申请人部门(同旧表USERDEPT).
	*/
	public void setApplyPersonDept(String applyPersonDept) {
		this.applyPersonDept = applyPersonDept;
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
	* 获取 所属事业部标杆编码.
	*
	* @return 所属事业部标杆编码.
	*/
	public String getBelongDivisionSyscode() {
		return belongDivisionSyscode;
	}

	/**
	* 设置 所属事业部标杆编码.
	*
	* @param 所属事业部标杆编码.
	*/
	public void setBelongDivisionSyscode(String belongDivisionSyscode) {
		this.belongDivisionSyscode = belongDivisionSyscode;
	}
	
	/**
	* 获取 资源协调类型.
	*
	* @return 资源协调类型.
	*/
	public String getCoordinationType() {
		return coordinationType;
	}

	/**
	* 设置 资源协调类型.
	*
	* @param 资源协调类型.
	*/
	public void setCoordinationType(String coordinationType) {
		this.coordinationType = coordinationType;
	}
	
	/**
	* 获取 资源协调类型编码.
	*
	* @return 资源协调类型编码.
	*/
	public String getCoordinationTypeCode() {
		return coordinationTypeCode;
	}

	/**
	* 设置 资源协调类型编码.
	*
	* @param 资源协调类型编码.
	*/
	public void setCoordinationTypeCode(String coordinationTypeCode) {
		this.coordinationTypeCode = coordinationTypeCode;
	}
	
	/**
	* 获取 是否枢纽.
	*
	* @return 是否枢纽.
	*/
	public String getIsHub() {
		return isHub;
	}

	/**
	* 设置 是否枢纽.
	*
	* @param 是否枢纽.
	*/
	public void setIsHub(String isHub) {
		this.isHub = isHub;
	}
	
	/**
	* 获取 是否枢纽编码.
	*
	* @return 是否枢纽编码.
	*/
	public String getIsHubCode() {
		return isHubCode;
	}

	/**
	* 设置 是否枢纽编码.
	*
	* @param 是否枢纽编码.
	*/
	public void setIsHubCode(String isHubCode) {
		this.isHubCode = isHubCode;
	}

	/**
	* 获取 搬迁日期.
	*
	* @return 搬迁日期.
	*/
	public Date getRelocationDate() {
		return relocationDate;
	}

	/**
	* 设置 搬迁日期.
	*
	* @param  搬迁日期.
	*/
	public void setRelocationDate(Date relocationDate) {
		this.relocationDate = relocationDate;
	}

	/**
	* 获取 场地租赁/转租合同工作流号.
	*
	* @return 场地租赁/转租合同工作流号.
	*/
	public String getContractProcessinstid() {
		return contractProcessinstid;
	}

	/**
	* 设置 场地租赁/转租合同工作流号.
	*
	* @param 场地租赁/转租合同工作流号.
	*/
	public void setContractProcessinstid(String contractProcessinstid) {
		this.contractProcessinstid = contractProcessinstid;
	}

	/**
	* 获取场地类型(不需要，仅供迁移).
	*
	* @return 场地类型(不需要，仅供迁移).
	*/
	public String getCourtType() {
		return courtType;
	}

	/**
	* 设置 场地类型(不需要，仅供迁移).
	*
	* @param 场地类型(不需要，仅供迁移).
	*/
	public void setCourtType(String courtType) {
		this.courtType = courtType;
	}

	/**
	* 获取场地名称(不需要，仅供迁移).
	*
	* @return 场地名称(不需要，仅供迁移).
	*/
	public String getCourtName() {
		return courtName;
	}

	/**
	* 设置 场地名称(不需要，仅供迁移).
	*
	* @param 场地名称(不需要，仅供迁移).
	*/
	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}

	/**
	* 获取合同签订时间(不需要，仅供迁移).
	*
	* @return 合同签订时间(不需要，仅供迁移).
	*/
	public Date getSignTime() {
		return signTime;
	}

	/**
	* 设置 合同签订时间(不需要，仅供迁移).
	*
	* @param 合同签订时间(不需要，仅供迁移).
	*/
	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}

	/**
	* 获取搬迁时间(不需要，仅供迁移).
	*
	* @return 搬迁时间(不需要，仅供迁移).
	*/
	public Date getRelocationTime() {
		return relocationTime;
	}

	/**
	* 设置 搬迁时间(不需要，仅供迁移).
	*
	* @param 搬迁时间(不需要，仅供迁移).
	*/
	public void setRelocationTime(Date relocationTime) {
		this.relocationTime = relocationTime;
	}

	/**
	* 获取场地面积(不需要，仅供迁移).
	*
	* @return 场地面积(不需要，仅供迁移).
	*/
	public String getCourtArea() {
		return courtArea;
	}

	/**
	* 设置 场地面积(不需要，仅供迁移).
	*
	* @param 场地面积(不需要，仅供迁移).
	*/
	public void setCourtArea(String courtArea) {
		this.courtArea = courtArea;
	}

	/**
	* 获取货台面积(不需要，仅供迁移).
	*
	* @return 货台面积(不需要，仅供迁移).
	*/
	public String getPlatformArea() {
		return platformArea;
	}

	/**
	* 设置 货台面积(不需要，仅供迁移).
	*
	* @param 货台面积(不需要，仅供迁移).
	*/
	public void setPlatformArea(String platformArea) {
		this.platformArea = platformArea;
	}

	/**
	* 获取所属人事部(不需要，仅供迁移).
	*
	* @return 所属人事部(不需要，仅供迁移).
	*/
	public String getArea() {
		return area;
	}

	/**
	* 设置 所属人事部(不需要，仅供迁移).
	*
	* @param 所属人事部(不需要，仅供迁移).
	*/
	public void setArea(String area) {
		this.area = area;
	}

}

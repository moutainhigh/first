package com.deppon.wfs.workflow.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @title: LegalSignBean 
 * @description： 法定代表人/负责人签字申请实体Bean
 * @author： wuyaqing
 * @date： 2013年11月26日 下午12:15:08
 */
/**
 * 命名空间
 */
public class LegalSignBean implements Serializable {
	
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 963172504049590587L;
	
	/** 
	 * 法定代表人/负责人签字申请签字资料分录信息
	 */
	private List<SignDataBean> dataCells;
	
	/** 
	 * 法定代表人/负责人签字申请签字资料分录信息的json字符串
	 */
	private String legalSignDataCells;

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
	 * 区域公共事业部
	 */
	private String divisionName;
	
	/**
	 * 区域公共事业部编码
	 */
	private String divisionCode;
	
	/**
	 * 区域公共事务组
	 */
	private String groupName;
	
	/**
	 * 区域公共事务组编码
	 */
	private String groupCode;
	
	/**
	 * 区域公共事务小组
	 */
	private String teamName;
	
	/**
	 * 区域公共事务小组编码
	 */
	private String teamCode;
	
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
	* 职位 
	*/
	private String position;
	
	/** 
	* 申请人所在部门 
	*/
	private String appDept;
	
	/** 
	* 部门编码 
	*/
	private String appDeptCode;
	
	/** 
	* 签字人 
	*/
	private String signName;
	
	/** 
	* 签字人工号 
	*/
	private String signCode;
	
	/** 
	* 签字人身份 
	*/
	private String signIdentity;
	
	/** 
	* 是否涉及财务信息披露 
	*/
	private String isDisclosure;
	
	/** 
	* 数据来源部门 
	*/
	private String datasourceDept;
	
	/** 
	* 工作流号 
	*/
	private Long workflowNo;
	
	/** 
	* 申请事由 
	*/
	private String applyReason;
	
	/**
	 * 获取法定代表人/负责人签字申请签字资料分录信息
	 *
	 * @return dataCells
	 */
	public List<SignDataBean> getDataCells() {
		return dataCells;
	}

	/**
	 * 设置法定代表人/负责人签字申请签字资料分录信息
	 *
	 * @param dataCells the new dataCells
	 */
	public void setDataCells(List<SignDataBean> dataCells) {
		this.dataCells = dataCells;
	}
	
	/**
	 * 获取法定代表人/负责人签字申请签字资料分录信息的json字符串
	 *
	 * @return legalSignDataCells
	 */
	public String getLegalSignDataCells() {
		return legalSignDataCells;
	}

	/**
	 * 设置法定代表人/负责人签字申请签字资料分录信息的json字符串
	 *
	 * @param legalSignDataCells the new legalSignDataCells
	 */
	public void setLegalSignDataCells(String legalSignDataCells) {
		this.legalSignDataCells = legalSignDataCells;
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
	* 获取 职位.
	*
	* @return 职位.
	*/
	public String getPosition() {
		return position;
	}

	/**
	* 设置 职位.
	*
	* @param 职位.
	*/
	public void setPosition(String position) {
		this.position = position;
	}
	
	/**
	* 获取 申请人所在部门.
	*
	* @return 申请人所在部门.
	*/
	public String getAppDept() {
		return appDept;
	}

	/**
	* 设置 申请人所在部门.
	*
	* @param 申请人所在部门.
	*/
	public void setAppDept(String appDept) {
		this.appDept = appDept;
	}
	
	/**
	* 获取 部门编码.
	*
	* @return 部门编码.
	*/
	public String getAppDeptCode() {
		return appDeptCode;
	}

	/**
	* 设置 部门编码.
	*
	* @param 部门编码.
	*/
	public void setAppDeptCode(String appDeptCode) {
		this.appDeptCode = appDeptCode;
	}
	
	/**
	* 获取 签字人.
	*
	* @return 签字人.
	*/
	public String getSignName() {
		return signName;
	}

	/**
	* 设置 签字人.
	*
	* @param 签字人.
	*/
	public void setSignName(String signName) {
		this.signName = signName;
	}
	
	/**
	* 获取 签字人工号.
	*
	* @return 签字人工号.
	*/
	public String getSignCode() {
		return signCode;
	}

	/**
	* 设置 签字人工号.
	*
	* @param 签字人工号.
	*/
	public void setSignCode(String signCode) {
		this.signCode = signCode;
	}
	
	/**
	* 获取 签字人身份.
	*
	* @return 签字人身份.
	*/
	public String getSignIdentity() {
		return signIdentity;
	}

	/**
	* 设置 签字人身份.
	*
	* @param 签字人身份.
	*/
	public void setSignIdentity(String signIdentity) {
		this.signIdentity = signIdentity;
	}
	
	/**
	* 获取 是否涉及财务信息披露.
	*
	* @return 是否涉及财务信息披露.
	*/
	public String getIsDisclosure() {
		return isDisclosure;
	}

	/**
	* 设置 是否涉及财务信息披露.
	*
	* @param 是否涉及财务信息披露.
	*/
	public void setIsDisclosure(String isDisclosure) {
		this.isDisclosure = isDisclosure;
	}
	
	/**
	* 获取 数据来源部门.
	*
	* @return 数据来源部门.
	*/
	public String getDatasourceDept() {
		return datasourceDept;
	}

	/**
	* 设置 数据来源部门.
	*
	* @param 数据来源部门.
	*/
	public void setDatasourceDept(String datasourceDept) {
		this.datasourceDept = datasourceDept;
	}
	
	/**
	* 获取 工作流号.
	*
	* @return 工作流号.
	*/
	public Long getWorkflowNo() {
		return workflowNo;
	}

	/**
	* 设置 工作流号.
	*
	* @param 工作流号.
	*/
	public void setWorkflowNo(Long workflowNo) {
		this.workflowNo = workflowNo;
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
	* 获取 申请事由.
	*
	* @return 申请事由.
	*/
	public String getDivisionName() {
		return divisionName;
	}

	/**
	* 设置 申请事由.
	*
	* @param 申请事由.
	*/
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	/**
	* 获取 区域公共事业部.
	*
	* @return 区域公共事业部.
	*/
	public String getDivisionCode() {
		return divisionCode;
	}

	/**
	* 设置 区域公共事业部编码.
	*
	* @param 区域公共事业部编码.
	*/
	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}

	/**
	* 获取 区域公共事务组.
	*
	* @return 区域公共事务组.
	*/
	public String getGroupName() {
		return groupName;
	}

	/**
	* 设置 区域公共事务组.
	*
	* @param 区域公共事务组.
	*/
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	* 获取 区域公共事务组编码.
	*
	* @return 区域公共事务组编码.
	*/
	public String getGroupCode() {
		return groupCode;
	}

	/**
	* 设置 区域公共事务组编码.
	*
	* @param 区域公共事务组编码.
	*/
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	/**
	* 获取 区域公共事务小组.
	*
	* @return 区域公共事务小组.
	*/
	public String getTeamName() {
		return teamName;
	}

	/**
	* 设置 区域公共事务小组.
	*
	* @param 区域公共事务小组.
	*/
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/**
	* 获取 区域公共事务小组编码.
	*
	* @return 区域公共事务小组编码.
	*/
	public String getTeamCode() {
		return teamCode;
	}

	/**
	* 设置 区域公共事务小组编码.
	*
	* @param 区域公共事务小组编码.
	*/
	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}
	
}

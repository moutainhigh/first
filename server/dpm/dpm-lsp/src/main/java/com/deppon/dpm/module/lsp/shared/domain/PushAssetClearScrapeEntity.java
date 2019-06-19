package com.deppon.dpm.module.lsp.shared.domain;

import java.util.List;

/**
 * @author 268101 不知道谁写的实体，让哥来注释，我也不知道啥意思
 */
public class PushAssetClearScrapeEntity {

	// 流程ID信息
	private String docNo;
	// 单据编号
	private String fnumber;
	// 工作流名称
	private String tpName;
	// 资产编码
	private String assetCoding;
	// 备注--对应申请事由
	private String remark;
	// 资产所属部门
	private String department;
	// 管理编码
	private String managementCode;
	// 资产名称
	private String fixedAssetsName;
	// 资产使用状态
	private String useStatus;
	// 卡片所在子公司
	private String belongCompany;

	// 审批人集合
	private List<Auditor> auditorList;
	// 起草人工号
	private String applicantCode;
	// 起早人姓名
	private String applicant;
	// 审批人
	private String auditor;
	// 到达此节点的时间
	private long beginAuditDate;

	/**
	 * @Fields state 审批工作流节点：0：倒数第二个 1：倒数第一个
	 */
	private String state;

	/**
	 * @return 流程ID信息
	 */
	public String getDocNo() {
		return docNo;
	}

	/**
	 * @param docNo 流程ID信息
	 */
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	/**
	 * @return 单据编号
	 */
	public String getFnumber() {
		return fnumber;
	}

	/**
	 * @param fnumber 单据编号
	 */
	public void setFnumber(String fnumber) {
		this.fnumber = fnumber;
	}

	/**
	 * @return 工作流名称
	 */
	public String getTpName() {
		return tpName;
	}

	/**
	 * @param tpName 工作流名称
	 */
	public void setTpName(String tpName) {
		this.tpName = tpName;
	}

	/**
	 * @return 资产编码
	 */
	public String getAssetCoding() {
		return assetCoding;
	}

	/**
	 * @param assetCoding 资产编码
	 */
	public void setAssetCoding(String assetCoding) {
		this.assetCoding = assetCoding;
	}

	/**
	 * @return 备注--对应申请事由
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark 备注--对应申请事由
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return 资产所属部门
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department 资产所属部门
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return 管理编码
	 */
	public String getManagementCode() {
		return managementCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @param managementCode 管理编码
	 */
	public void setManagementCode(String managementCode) {
		this.managementCode = managementCode;
	}

	/**
	 * @return 资产名称
	 */
	public String getFixedAssetsName() {
		return fixedAssetsName;
	}

	/**
	 * @param fixedAssetsName 资产名称
	 */
	public void setFixedAssetsName(String fixedAssetsName) {
		this.fixedAssetsName = fixedAssetsName;
	}

	/**
	 * @return 卡片所在子公司
	 */
	public String getBelongCompany() {
		return belongCompany;
	}

	/**
	 * @param belongCompany 卡片所在子公司
	 */
	public void setBelongCompany(String belongCompany) {
		this.belongCompany = belongCompany;
	}

	public String getUseStatus() {
		return useStatus;
	}

	public void setUseStatus(String useStatus) {
		this.useStatus = useStatus;
	}

	public String getApplicantCode() {
		return applicantCode;
	}

	public void setApplicantCode(String applicantCode) {
		this.applicantCode = applicantCode;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public List<Auditor> getAuditorList() {
		return auditorList;
	}

	public void setAuditorList(List<Auditor> auditorList) {
		this.auditorList = auditorList;
	}

	public String getAuditor() {
		return auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	public long getBeginAuditDate() {
		return beginAuditDate;
	}

	public void setBeginAuditDate(long beginAuditDate) {
		this.beginAuditDate = beginAuditDate;
	}

}

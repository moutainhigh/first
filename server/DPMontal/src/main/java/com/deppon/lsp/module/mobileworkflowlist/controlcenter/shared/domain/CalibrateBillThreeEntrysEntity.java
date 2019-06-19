package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 
 * 定标单定标结果信息分录实体
 * 
 * 
 * @author wangmingzhao
 * @date 2014-2-25 下午3:11:41
 * @since
 * @version
 */
public class CalibrateBillThreeEntrysEntity extends BaseEntity{

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	 */  
	 
	private static final long serialVersionUID = -6613365060002269743L;
	/**
	 * 供应商编码
	 */
	private String supplierNumber;
	/**
	 * 供应商名称
	 */
	private String supplierName;
	/**
	 * 商务标排名
	 */
	private long businessRank;
	/**
	 * 技术标排名
	 */
	private long technologyRank;
	/**
	 * 综合排名
	 */
	private long rank;
	/**
	 * 综合得分
	 */
	private double scores;
	/**
	 * 配额类型
	 */
	private String type;
	/**
	 * 配额（%）	
	 */
	private String quota;
	/**
	 * 配额说明
	 */
	private String quptaDescription;
	/**
	 * 审批结论
	 */
	private String auditConclusion;
	/**
	 * 评标结果
	 */
	private String result;
	/**
	 * 审批意见
	 */
	private String auditOpinion;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 物品信息分录ID
	 */
	private String parentId;
	/**
	 *
	 * @return the supplierNumber
	 *
	 */
	public String getSupplierNumber() {
		return supplierNumber;
	}
	/**
	 *
	 * @param supplierNumber the supplierNumber to set
	 *
	 */
	public void setSupplierNumber(String supplierNumber) {
		this.supplierNumber = supplierNumber;
	}
	/**
	 *
	 * @return the supplierName
	 *
	 */
	public String getSupplierName() {
		return supplierName;
	}
	/**
	 *
	 * @param supplierName the supplierName to set
	 *
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	/**
	 *
	 * @return the businessRank
	 *
	 */
	public long getBusinessRank() {
		return businessRank;
	}
	/**
	 *
	 * @param businessRank the businessRank to set
	 *
	 */
	public void setBusinessRank(long businessRank) {
		this.businessRank = businessRank;
	}
	/**
	 *
	 * @return the technologyRank
	 *
	 */
	public long getTechnologyRank() {
		return technologyRank;
	}
	/**
	 *
	 * @param technologyRank the technologyRank to set
	 *
	 */
	public void setTechnologyRank(long technologyRank) {
		this.technologyRank = technologyRank;
	}
	/**
	 *
	 * @return the rank
	 *
	 */
	public long getRank() {
		return rank;
	}
	/**
	 *
	 * @param rank the rank to set
	 *
	 */
	public void setRank(long rank) {
		this.rank = rank;
	}
	/**
	 *
	 * @return the scores
	 *
	 */
	public double getScores() {
		return scores;
	}
	/**
	 *
	 * @param scores the scores to set
	 *
	 */
	public void setScores(double scores) {
		this.scores = scores;
	}
	/**
	 *
	 * @return the type
	 *
	 */
	public String getType() {
		return type;
	}
	/**
	 *
	 * @param type the type to set
	 *
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 *
	 * @return the quota
	 *
	 */
	public String getQuota() {
		return quota;
	}
	/**
	 *
	 * @param quota the quota to set
	 *
	 */
	public void setQuota(String quota) {
		this.quota = quota;
	}
	/**
	 *
	 * @return the quptaDescription
	 *
	 */
	public String getQuptaDescription() {
		return quptaDescription;
	}
	/**
	 *
	 * @param quptaDescription the quptaDescription to set
	 *
	 */
	public void setQuptaDescription(String quptaDescription) {
		this.quptaDescription = quptaDescription;
	}
	/**
	 *
	 * @return the auditConclusion
	 *
	 */
	public String getAuditConclusion() {
		return auditConclusion;
	}
	/**
	 *
	 * @param auditConclusion the auditConclusion to set
	 *
	 */
	public void setAuditConclusion(String auditConclusion) {
		this.auditConclusion = auditConclusion;
	}
	/**
	 *
	 * @return the result
	 *
	 */
	public String getResult() {
		return result;
	}
	/**
	 *
	 * @param result the result to set
	 *
	 */
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 *
	 * @return the auditOpinion
	 *
	 */
	public String getAuditOpinion() {
		return auditOpinion;
	}
	/**
	 *
	 * @param auditOpinion the auditOpinion to set
	 *
	 */
	public void setAuditOpinion(String auditOpinion) {
		this.auditOpinion = auditOpinion;
	}
	/**
	 *
	 * @return the remark
	 *
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 *
	 * @param remark the remark to set
	 *
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 *
	 * @return the parentId
	 *
	 */
	public String getParentId() {
		return parentId;
	}
	/**
	 *
	 * @param parentId the parentId to set
	 *
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	
}

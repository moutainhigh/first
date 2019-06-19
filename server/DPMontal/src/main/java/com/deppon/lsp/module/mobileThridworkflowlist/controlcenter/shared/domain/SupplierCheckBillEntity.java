package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import java.math.BigDecimal;

import com.deppon.foss.framework.entity.BaseEntity;

public class SupplierCheckBillEntity extends BaseEntity{

	/**
	 * 供应商考核信息实体类
	 */
	private static final long serialVersionUID = -7126174420156161913L;
	
	/**
	 * 单据分录序列号
	 */
	private String seq;
	
	/**
	 * 主键FID
	 */
	private String fid;
	
	/**
	 * 明细信息对应的主键ID
	 */
	private String parentId;
	
	/**
	 * 得分权重（%）
	 */
	private BigDecimal scoreWeight;
	
	/**
	 * 评分
	 */
	private BigDecimal scored;
	
	/**
	 * 考核细则
	 */
	private String checkDetail;
	
	/**
	 * 考核项目ID
	 */
	private String checkProjectId;
	
	//考核项目名称
	private String checkProjectName;

	
	//将BigDecimal类型转换为String类型
	//得分权重
	private String scoreWeightDto;

	// 评分
	private String scoredDto;
	/**
	 * @return  the checkProjectName
	 */
	public String getCheckProjectName() {
		return checkProjectName;
	}

	/**
	 * @param checkProjectName the checkProjectName to set
	 */
	public void setCheckProjectName(String checkProjectName) {
		this.checkProjectName = checkProjectName;
	}

	/**
	 * @return  the seq
	 */
	public String getSeq() {
		return seq;
	}

	/**
	 * @param seq the seq to set
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}

	/**
	 * @return  the fid
	 */
	public String getFid() {
		return fid;
	}

	/**
	 * @param fid the fid to set
	 */
	public void setFid(String fid) {
		this.fid = fid;
	}

	/**
	 * @return  the parentId
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return  the scoreWeight
	 */
	public BigDecimal getScoreWeight() {
		return scoreWeight;
	}

	/**
	 * @param scoreWeight the scoreWeight to set
	 */
	public void setScoreWeight(BigDecimal scoreWeight) {
		this.scoreWeight = scoreWeight;
	}

	/**
	 * @return  the scored
	 */
	public BigDecimal getScored() {
		return scored;
	}

	/**
	 * @param scored the scored to set
	 */
	public void setScored(BigDecimal scored) {
		this.scored = scored;
	}

	/**
	 * @return  the checkDetail
	 */
	public String getCheckDetail() {
		return checkDetail;
	}

	/**
	 * @param checkDetail the checkDetail to set
	 */
	public void setCheckDetail(String checkDetail) {
		this.checkDetail = checkDetail;
	}

	/**
	 * @return  the checkProjectId
	 */
	public String getCheckProjectId() {
		return checkProjectId;
	}

	/**
	 * @param checkProjectId the checkProjectId to set
	 */
	public void setCheckProjectId(String checkProjectId) {
		this.checkProjectId = checkProjectId;
	}

	/**
	 * @author huangzibin
	 * @date 2014-8-24 上午10:05:02 
	 */
	public String getScoreWeightDto() {
		return scoreWeightDto;
	}

	/**
	 * @param scoreWeightDto the scoreWeightDto to set
	 * @author huangzibin
	 * @date 2014-8-24 上午10:05:02 
	 */
	public void setScoreWeightDto(String scoreWeightDto) {
		this.scoreWeightDto = scoreWeightDto;
	}

	/**
	 * @author huangzibin
	 * @date 2014-8-24 上午10:05:02 
	 */
	public String getScoredDto() {
		return scoredDto;
	}

	/**
	 * @param scoredDto the scoredDto to set
	 * @author huangzibin
	 * @date 2014-8-24 上午10:05:02 
	 */
	public void setScoredDto(String scoredDto) {
		this.scoredDto = scoredDto;
	}

}

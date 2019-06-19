package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;


import java.math.BigDecimal;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 *<pre>
 *功能:工程项目预算调整单-非施工类预算实体类
 *作者：蒋小洋
 *日期：2013-12-12下午2:49:20
 *</pre>
 */
public class ProjectBudgeNoConstructEntity  extends BaseEntity{
	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -7712439259690501768L;

	/**
	 * 主键FID
	 */
	private String fid;
	
	/**
	 * 单据分录序列号
	 */
	private Long seq;
	
	/**
	 * 对应外键
	 */
	private String parentId;
	
	/**
	 * 单据分录序列号
	 */
	private Long cfSeq;
	
	/**
	 * 预算项目名称
	 */
	private String butItemNameId;
	
	/**
	 * 预算项目类型
	 */
	private String chargeTypeId;
	
	/**
	 * 比例%
	 */
	private BigDecimal ratio;
	
	/**
	 * 金额
	 */
	private BigDecimal amount;
	
	//预算项目名称
	private String projectName;
	//预算项目类型
	private String budtupe;
	
	//将BigDecimal转换为String类型。
	/**
	 * 比例%
	 */
	private String ratioDto;
	
	/**
	 * 金额
	 */
	private String amountDto;

	public String getRatioDto() {
		return ratioDto;
	}

	public void setRatioDto(String ratioDto) {
		this.ratioDto = ratioDto;
	}

	public String getAmountDto() {
		return amountDto;
	}

	public void setAmountDto(String amountDto) {
		this.amountDto = amountDto;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the budtupe
	 */
	public String getBudtupe() {
		return budtupe;
	}

	/**
	 * @param budtupe the budtupe to set
	 */
	public void setBudtupe(String budtupe) {
		this.budtupe = budtupe;
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
	 * @return  the seq
	 */
	public Long getSeq() {
		return seq;
	}

	/**
	 * @param seq the seq to set
	 */
	public void setSeq(Long seq) {
		this.seq = seq;
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
	 * @return  the cfSeq
	 */
	public Long getCfSeq() {
		return cfSeq;
	}

	/**
	 * @param cfSeq the cfSeq to set
	 */
	public void setCfSeq(Long cfSeq) {
		this.cfSeq = cfSeq;
	}

	/**
	 * @return  the butItemNameId
	 */
	public String getButItemNameId() {
		return butItemNameId;
	}

	/**
	 * @param butItemNameId the butItemNameId to set
	 */
	public void setButItemNameId(String butItemNameId) {
		this.butItemNameId = butItemNameId;
	}

	/**
	 * @return  the chargeTypeId
	 */
	public String getChargeTypeId() {
		return chargeTypeId;
	}

	/**
	 * @param chargeTypeId the chargeTypeId to set
	 */
	public void setChargeTypeId(String chargeTypeId) {
		this.chargeTypeId = chargeTypeId;
	}

	/**
	 * @return  the ratio
	 */
	public BigDecimal getRatio() {
		return ratio;
	}

	/**
	 * @param ratio the ratio to set
	 */
	public void setRatio(BigDecimal ratio) {
		this.ratio = ratio;
	}

	/**
	 * @return  the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
}

package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 *<pre>
 *功能:供应商处置单实体类
 *作者：蒋小洋
 *日期：2013-11-5下午2:43:02
 *</pre>
 */
public class SupplierDisposalEntity  extends BaseEntity{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 3761432153737187001L;
	
	/**
	 * 创建者
	 */
	private String creatorId;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 最后修改者
	 */
	private String lastUpdateUserId;
	
	/**
	 * 最后修改时间
	 */
	private Date lastUpdateTime;
	
	/**
	 * 控制单元
	 */
	private String controlUnitId;
	
	/**
	 * 单据编号
	 */
	private String number;
	
	/**
	 * 业务日期
	 */
	private Date bizDate;
	
	/**
	 * 经手人
	 */
	private String handlerId;
	
	/**
	 * 参考信息
	 */
	private String description;
	
	/**
	 * 是否曾经生效
	 */
	private Long hasEffected;
	
	/**
	 * 审核人
	 */
	private String auditorId;
	
	/**
	 * 原始单据ID
	 */
	private String sourceBillId;
	
	/**
	 * 来源功能
	 */
	private String sourceFunction;
	
	/**
	 * 主键FID
	 */
	private String fid;
	
	/**
	 * 是否生成凭证
	 */
	private Long fivouchered;
	
	/**
	 * 供应商编码
	 */
	private String supplierNumberId;
	
	/**
	 * 供应商名称
	 */
	private String supplierName;
	
	/**
	 * 单据状态
	 */
	private String billsState;
	
	/**
	 * 考核人
	 */
	private String surveyPeople;
	
	/**
	 * 违规说明
	 */
	private String violationDesc;
	
	/**
	 * 罚款金额（元）
	 */
	private BigDecimal fines;
	
	/**
	 * 引述合同条款
	 */
	private String contractProvision;
	
	/**
	 * 公函内容
	 */
	private String lettersContent;
	
	/**
	 * 考核周期
	 */
	private String surveyCycleId;
	
	/**
	 * 年份
	 */
	private String years;
	
	/**
	 * 供应商状态
	 */
	private int supplierStatus;
	
	/**
	 * 考核单号
	 */
	private String surveyNumberId;
	
	/**
	 * 审核时间
	 */
	private Date auditDate;
	
	/**
	 * 评语
	 */
	private String comment;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 加权得分
	 */
	private BigDecimal score;
	
	//创建人
	private String creatorName;
	//供应商编码
	private String supplierNumber;
	//考核单号
	private String surveyNumber;
	//考核周期
	private String surveyCycle;
	//供应商状态
	private String supplierStatu;
	
	//将BigDecimal类型转换为String类型映射
	//罚款金额
	private String finesDto;
	
	//加权得分
	private String scoreDto;
	
	/**
	 * @return  the supplierStatu
	 */
	public String getSupplierStatu() {
		return supplierStatu;
	}

	/**
	 * @param supplierStatu the supplierStatu to set
	 */
	public void setSupplierStatu(String supplierStatu) {
		this.supplierStatu = supplierStatu;
	}

	/**
	 * @return  the creatorName
	 */
	public String getCreatorName() {
		return creatorName;
	}

	/**
	 * @param creatorName the creatorName to set
	 */
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	/**
	 * @return  the supplierNumber
	 */
	public String getSupplierNumber() {
		return supplierNumber;
	}

	/**
	 * @param supplierNumber the supplierNumber to set
	 */
	public void setSupplierNumber(String supplierNumber) {
		this.supplierNumber = supplierNumber;
	}

	/**
	 * @return  the surveyNumber
	 */
	public String getSurveyNumber() {
		return surveyNumber;
	}

	/**
	 * @param surveyNumber the surveyNumber to set
	 */
	public void setSurveyNumber(String surveyNumber) {
		this.surveyNumber = surveyNumber;
	}

	/**
	 * @return  the surveyCycle
	 */
	public String getSurveyCycle() {
		return surveyCycle;
	}

	/**
	 * @param surveyCycle the surveyCycle to set
	 */
	public void setSurveyCycle(String surveyCycle) {
		this.surveyCycle = surveyCycle;
	}

	/**
	 * @return  the supplierNumberId
	 */
	public String getSupplierNumberId() {
		return supplierNumberId;
	}

	/**
	 * @param supplierNumberId the supplierNumberId to set
	 */
	public void setSupplierNumberId(String supplierNumberId) {
		this.supplierNumberId = supplierNumberId;
	}

	/**
	 * @return  the supplierName
	 */
	public String getSupplierName() {
		return supplierName;
	}

	/**
	 * @param supplierName the supplierName to set
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	/**
	 * @return  the billsState
	 */
	public String getBillsState() {
		return billsState;
	}

	/**
	 * @param billsState the billsState to set
	 */
	public void setBillsState(String billsState) {
		this.billsState = billsState;
	}

	/**
	 * @return  the surveyPeople
	 */
	public String getSurveyPeople() {
		return surveyPeople;
	}

	/**
	 * @param surveyPeople the surveyPeople to set
	 */
	public void setSurveyPeople(String surveyPeople) {
		this.surveyPeople = surveyPeople;
	}

	/**
	 * @return  the violationDesc
	 */
	public String getViolationDesc() {
		return violationDesc;
	}

	/**
	 * @param violationDesc the violationDesc to set
	 */
	public void setViolationDesc(String violationDesc) {
		this.violationDesc = violationDesc;
	}

	/**
	 * @return  the fines
	 */
	public BigDecimal getFines() {
		return fines;
	}

	/**
	 * @param fines the fines to set
	 */
	public void setFines(BigDecimal fines) {
		this.fines = fines;
	}

	/**
	 * @return  the contractProvision
	 */
	public String getContractProvision() {
		return contractProvision;
	}

	/**
	 * @param contractProvision the contractProvision to set
	 */
	public void setContractProvision(String contractProvision) {
		this.contractProvision = contractProvision;
	}

	/**
	 * @return  the lettersContent
	 */
	public String getLettersContent() {
		return lettersContent;
	}

	/**
	 * @param lettersContent the lettersContent to set
	 */
	public void setLettersContent(String lettersContent) {
		this.lettersContent = lettersContent;
	}

	/**
	 * @return  the surveyCycleId
	 */
	public String getSurveyCycleId() {
		return surveyCycleId;
	}

	/**
	 * @param surveyCycleId the surveyCycleId to set
	 */
	public void setSurveyCycleId(String surveyCycleId) {
		this.surveyCycleId = surveyCycleId;
	}

	/**
	 * @return  the years
	 */
	public String getYears() {
		return years;
	}

	/**
	 * @param years the years to set
	 */
	public void setYears(String years) {
		this.years = years;
	}

	/**
	 * @return  the supplierStatus
	 */
	public int getSupplierStatus() {
		return supplierStatus;
	}

	/**
	 * @param supplierStatus the supplierStatus to set
	 */
	public void setSupplierStatus(int supplierStatus) {
		this.supplierStatus = supplierStatus;
	}

	/**
	 * @return  the auditDate
	 */
	public Date getAuditDate() {
		return auditDate;
	}

	/**
	 * @param auditDate the auditDate to set
	 */
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	/**
	 * @return  the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return  the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return  the score
	 */
	public BigDecimal getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(BigDecimal score) {
		this.score = score;
	}

	/**
	 * @return  the creatorId
	 */
	public String getCreatorId() {
		return creatorId;
	}

	/**
	 * @param creatorId the creatorId to set
	 */
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	/**
	 * @return  the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return  the lastUpdateUserId
	 */
	public String getLastUpdateUserId() {
		return lastUpdateUserId;
	}

	/**
	 * @param lastUpdateUserId the lastUpdateUserId to set
	 */
	public void setLastUpdateUserId(String lastUpdateUserId) {
		this.lastUpdateUserId = lastUpdateUserId;
	}

	/**
	 * @return  the lastUpdateTime
	 */
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	/**
	 * @param lastUpdateTime the lastUpdateTime to set
	 */
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	/**
	 * @return  the controlUnitId
	 */
	public String getControlUnitId() {
		return controlUnitId;
	}

	/**
	 * @param controlUnitId the controlUnitId to set
	 */
	public void setControlUnitId(String controlUnitId) {
		this.controlUnitId = controlUnitId;
	}

	/**
	 * @return  the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return  the bizDate
	 */
	public Date getBizDate() {
		return bizDate;
	}

	/**
	 * @param bizDate the bizDate to set
	 */
	public void setBizDate(Date bizDate) {
		this.bizDate = bizDate;
	}

	/**
	 * @return  the handlerId
	 */
	public String getHandlerId() {
		return handlerId;
	}

	/**
	 * @param handlerId the handlerId to set
	 */
	public void setHandlerId(String handlerId) {
		this.handlerId = handlerId;
	}

	/**
	 * @return  the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return  the hasEffected
	 */
	public Long getHasEffected() {
		return hasEffected;
	}

	/**
	 * @param hasEffected the hasEffected to set
	 */
	public void setHasEffected(Long hasEffected) {
		this.hasEffected = hasEffected;
	}

	/**
	 * @return  the auditorId
	 */
	public String getAuditorId() {
		return auditorId;
	}

	/**
	 * @param auditorId the auditorId to set
	 */
	public void setAuditorId(String auditorId) {
		this.auditorId = auditorId;
	}

	/**
	 * @return  the sourceBillId
	 */
	public String getSourceBillId() {
		return sourceBillId;
	}

	/**
	 * @param sourceBillId the sourceBillId to set
	 */
	public void setSourceBillId(String sourceBillId) {
		this.sourceBillId = sourceBillId;
	}

	/**
	 * @return  the sourceFunction
	 */
	public String getSourceFunction() {
		return sourceFunction;
	}

	/**
	 * @param sourceFunction the sourceFunction to set
	 */
	public void setSourceFunction(String sourceFunction) {
		this.sourceFunction = sourceFunction;
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
	 * @return  the fivouchered
	 */
	public Long getFivouchered() {
		return fivouchered;
	}

	/**
	 * @param fivouchered the fivouchered to set
	 */
	public void setFivouchered(Long fivouchered) {
		this.fivouchered = fivouchered;
	}

	/**
	 * @return  the surveyNumberId
	 */
	public String getSurveyNumberId() {
		return surveyNumberId;
	}

	/**
	 * @param surveyNumberId the surveyNumberId to set
	 */
	public void setSurveyNumberId(String surveyNumberId) {
		this.surveyNumberId = surveyNumberId;
	}

	/**
	 * @author huangzibin
	 * @date 2014-8-24 上午9:38:16 
	 */
	public String getFinesDto() {
		return finesDto;
	}

	/**
	 * @param finesDto the finesDto to set
	 * @author huangzibin
	 * @date 2014-8-24 上午9:38:17 
	 */
	public void setFinesDto(String finesDto) {
		this.finesDto = finesDto;
	}

	/**
	 * @author huangzibin
	 * @date 2014-8-24 上午9:38:17 
	 */
	public String getScoreDto() {
		return scoreDto;
	}

	/**
	 * @param scoreDto the scoreDto to set
	 * @author huangzibin
	 * @date 2014-8-24 上午9:38:17 
	 */
	public void setScoreDto(String scoreDto) {
		this.scoreDto = scoreDto;
	}

}

package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 *<pre>
 *功能:供应商考核单实体类
 *作者：蒋小洋
 *日期：2013-11-4上午8:57:21
 *</pre>
 */
public class SupplierCheckEntity  extends BaseEntity{

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
	 * 考核细则模版名称
	 */
	private String checkDetailName;
	
	/**
	 * 供应商编码
	 */
	private String supplierNumberId;
	
	/**
	 * 供应商名称
	 */
	private String supplierName;
	
	/**
	 * 考核周期
	 */
	private String checkCycId;
	
	/**
	 * 加权得分（100分制）
	 */
	private BigDecimal checkScore;
	
	/**
	 * 单据状态
	 */
	private String state;
	
	/**
	 * 年份
	 */
	private String checkDate;
	
	/**
	 * 考核细则模版编号
	 */
	private String checkDetailNumId;
	
	/**
	 * 考核人
	 */
	private String checkPersonId;
	
	/**
	 * 评语
	 */
	private String comment;
	
	//创建者
	private String creatorName;
	//供应商编码
	private String supplierNumber;
	//考核细则模版编号
	private String checkDetailNumName;
	//考核周期
	private String checkCycName;

	
	//将BigDecimal类型转换为String类型映射
	//加权得分
	private String checkScoreDto;
	/**
	 * @return  the checkDetailNumName
	 */
	public String getCheckDetailNumName() {
		return checkDetailNumName;
	}

	/**
	 * @param checkDetailNumName the checkDetailNumName to set
	 */
	public void setCheckDetailNumName(String checkDetailNumName) {
		this.checkDetailNumName = checkDetailNumName;
	}

	/**
	 * @return  the checkCycName
	 */
	public String getCheckCycName() {
		return checkCycName;
	}

	/**
	 * @param checkCycName the checkCycName to set
	 */
	public void setCheckCycName(String checkCycName) {
		this.checkCycName = checkCycName;
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
	 * @return  the checkDetailName
	 */
	public String getCheckDetailName() {
		return checkDetailName;
	}

	/**
	 * @param checkDetailName the checkDetailName to set
	 */
	public void setCheckDetailName(String checkDetailName) {
		this.checkDetailName = checkDetailName;
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
	 * @return  the checkCycId
	 */
	public String getCheckCycId() {
		return checkCycId;
	}

	/**
	 * @param checkCycId the checkCycId to set
	 */
	public void setCheckCycId(String checkCycId) {
		this.checkCycId = checkCycId;
	}

	/**
	 * @return  the checkScore
	 */
	public BigDecimal getCheckScore() {
		return checkScore;
	}

	/**
	 * @param checkScore the checkScore to set
	 */
	public void setCheckScore(BigDecimal checkScore) {
		this.checkScore = checkScore;
	}

	/**
	 * @return  the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return  the checkDate
	 */
	public String getCheckDate() {
		return checkDate;
	}

	/**
	 * @param checkDate the checkDate to set
	 */
	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	/**
	 * @return  the checkDetailNumId
	 */
	public String getCheckDetailNumId() {
		return checkDetailNumId;
	}

	/**
	 * @param checkDetailNumId the checkDetailNumId to set
	 */
	public void setCheckDetailNumId(String checkDetailNumId) {
		this.checkDetailNumId = checkDetailNumId;
	}

	/**
	 * @return  the checkPersonId
	 */
	public String getCheckPersonId() {
		return checkPersonId;
	}

	/**
	 * @param checkPersonId the checkPersonId to set
	 */
	public void setCheckPersonId(String checkPersonId) {
		this.checkPersonId = checkPersonId;
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
	 * @author huangzibin
	 * @date 2014-8-24 上午9:55:11 
	 */
	public String getCheckScoreDto() {
		return checkScoreDto;
	}

	/**
	 * @param checkScoreDto the checkScoreDto to set
	 * @author huangzibin
	 * @date 2014-8-24 上午9:55:11 
	 */
	public void setCheckScoreDto(String checkScoreDto) {
		this.checkScoreDto = checkScoreDto;
	}
	

}

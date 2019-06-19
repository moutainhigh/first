package com.deppon.wfs.workflow.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 学车申请工作流实体Bean
 * @author Work Flow System
 * @Date 2013-12-26 19:49:23
 */
 
public class LearnCarBean extends Entity {
	
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
	* 当地办公室名称 
	*/
	private String localOfficeName;
	
	/** 
	* 总裁办公室标杆编码(DP08626) 
	*/
	private String headerOfficeSyscode;
	
	/** 
	* 分区办公室标杆编码(同旧表的LOCALOFFICE) 
	*/
	private String segmentOfficeSyscode;
	
	/** 
	* 享受福利原因(同旧表字段) 
	*/
	private String welfareReason;
	
	/** 
	* 转正工作流号 
	*/
	private String formalWorkflowId;
	
	/** 
	* 储干区域 
	*/
	private String cadreArea;
	
	/** 
	* 第几届储干 
	*/
	private String cadreTime;
	
	/** 
	* 储干名次 
	*/
	private String cadreRank;
	
	/** 
	* 报名日期(同旧表) 
	*/
	private Date enrollDate;
	
	/** 
	* 学车费用总金额(同旧表) 
	*/
	private BigDecimal feeAmount;
	
	/** 
	* 驾校名称(同旧表) 
	*/
	private String dschoolName;
	
	/** 
	* 驾校电话(同旧表) 
	*/
	private String dschoolTel;
	
	/** 
	* 申请事由(同旧表) 
	*/
	private String reason;
	
	/** 
	* 享受福利原因业务字典编码 
	*/
	private String welfareReasonCode;
	
	/** 
	* 学车报名工作流号(仅供数据迁移) 
	*/
	private Long lcarApplyNo;
	
	/** 
	* 学车报名日期(仅供数据迁移)
	*/
	private String lcarEnrollDate;
	
	/** 
	* 初次领证日期(仅供数据迁移)
	*/
	private String getCardDate;
	
	/** 
	* 发证地点(仅供数据迁移) 
	*/
	private String getCardPlace;
	
	/** 
	* 准驾车型(仅供数据迁移) 
	*/
	private String carType;
	
	/** 
	* 驾驶证号(仅供数据迁移) 
	*/
	private String cardNum;
	
	/** 
	* 申请类别(仅供数据迁移) 
	*/
	private String applyType;
	
	/** 
	* 储干名称(仅供数据迁移)
	*/
	private String cadreName;
	
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
	* 获取 当地办公室名称.
	*
	* @return 当地办公室名称.
	*/
	public String getLocalOfficeName() {
		return localOfficeName;
	}

	/**
	* 设置 当地办公室名称.
	*
	* @param 当地办公室名称.
	*/
	public void setLocalOfficeName(String localOfficeName) {
		this.localOfficeName = localOfficeName;
	}
	
	/**
	* 获取 总裁办公室名称.
	*
	* @return 总裁办公室名称.
	*/
	public String getHeaderOfficeSyscode() {
		return headerOfficeSyscode;
	}

	/**
	* 设置 分区办公室名称.
	*
	* @return 分区办公室名称.
	*/
	public void setHeaderOfficeSyscode(String headerOfficeSyscode) {
		this.headerOfficeSyscode = headerOfficeSyscode;
	}

	/**
	* 获取 分区办公室名称.
	*
	* @return 分区办公室名称.
	*/
	public String getSegmentOfficeSyscode() {
		return segmentOfficeSyscode;
	}

	/**
	* 设置  分区办公室名称.
	*
	* @return 分区办公室名称.
	*/
	public void setSegmentOfficeSyscode(String segmentOfficeSyscode) {
		this.segmentOfficeSyscode = segmentOfficeSyscode;
	}

	/**
	* 获取 享受福利原因(同旧表字段).
	*
	* @return 享受福利原因(同旧表字段).
	*/
	public String getWelfareReason() {
		return welfareReason;
	}

	/**
	* 设置 享受福利原因(同旧表字段).
	*
	* @param 享受福利原因(同旧表字段).
	*/
	public void setWelfareReason(String welfareReason) {
		this.welfareReason = welfareReason;
	}
	
	/**
	* 获取 转正工作流号.
	*
	* @return 转正工作流号.
	*/
	public String getFormalWorkflowId() {
		return formalWorkflowId;
	}

	/**
	* 设置 转正工作流号.
	*
	* @param 转正工作流号.
	*/
	public void setFormalWorkflowId(String formalWorkflowId) {
		this.formalWorkflowId = formalWorkflowId;
	}
	
	/**
	* 获取 储干区域.
	*
	* @return 储干区域.
	*/
	public String getCadreArea() {
		return cadreArea;
	}

	/**
	* 设置 储干区域.
	*
	* @param 储干区域.
	*/
	public void setCadreArea(String cadreArea) {
		this.cadreArea = cadreArea;
	}
	
	/**
	* 获取 第几届储干.
	*
	* @return 第几届储干.
	*/
	public String getCadreTime() {
		return cadreTime;
	}

	/**
	* 设置 第几届储干.
	*
	* @param 第几届储干.
	*/
	public void setCadreTime(String cadreTime) {
		this.cadreTime = cadreTime;
	}
	
	/**
	* 获取 储干名次.
	*
	* @return 储干名次.
	*/
	public String getCadreRank() {
		return cadreRank;
	}

	/**
	* 设置 储干名次.
	*
	* @param 储干名次.
	*/
	public void setCadreRank(String cadreRank) {
		this.cadreRank = cadreRank;
	}
	
	/**
	* 获取 报名日期(同旧表).
	*
	* @return 报名日期(同旧表).
	*/
	public Date getEnrollDate() {
		return enrollDate;
	}

	/**
	* 设置 报名日期(同旧表).
	*
	* @param 报名日期(同旧表).
	*/
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	
	/**
	* 获取 学车费用总金额(同旧表).
	*
	* @return 学车费用总金额(同旧表).
	*/
	public BigDecimal getFeeAmount() {
		return feeAmount;
	}

	/**
	* 设置 学车费用总金额(同旧表).
	*
	* @param 学车费用总金额(同旧表).
	*/
	public void setFeeAmount(BigDecimal feeAmount) {
		this.feeAmount = feeAmount;
	}
	
	/**
	* 获取 驾校名称(同旧表).
	*
	* @return 驾校名称(同旧表).
	*/
	public String getDschoolName() {
		return dschoolName;
	}

	/**
	* 设置 驾校名称(同旧表).
	*
	* @param 驾校名称(同旧表).
	*/
	public void setDschoolName(String dschoolName) {
		this.dschoolName = dschoolName;
	}
	
	/**
	* 获取 驾校电话(同旧表).
	*
	* @return 驾校电话(同旧表).
	*/
	public String getDschoolTel() {
		return dschoolTel;
	}

	/**
	* 设置 驾校电话(同旧表).
	*
	* @param 驾校电话(同旧表).
	*/
	public void setDschoolTel(String dschoolTel) {
		this.dschoolTel = dschoolTel;
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
	* 获取 享受福利原因业务字典编码.
	*
	* @return 享受福利原因业务字典编码.
	*/
	public String getWelfareReasonCode() {
		return welfareReasonCode;
	}

	/**
	* 设置 享受福利原因业务字典编码.
	*
	* @param 享受福利原因业务字典编码.
	*/
	public void setWelfareReasonCode(String welfareReasonCode) {
		this.welfareReasonCode = welfareReasonCode;
	}

	/**
	* 获取 学车报名工作流号(仅供数据迁移).
	*
	* @return 学车报名工作流号(仅供数据迁移).
	*/
	public Long getLcarApplyNo() {
		return lcarApplyNo;
	}

	/**
	* 设置  学车报名工作流号(仅供数据迁移).
	*
	* @param 学车报名工作流号(仅供数据迁移).
	*/
	public void setLcarApplyNo(Long lcarApplyNo) {
		this.lcarApplyNo = lcarApplyNo;
	}

	/**
	* 获取 学车报名日期(仅供数据迁移).
	*
	* @return 学车报名日期(仅供数据迁移).
	*/
	public String getLcarEnrollDate() {
		return lcarEnrollDate;
	}

	/**
	* 设置  学车报名日期(仅供数据迁移).
	*
	* @param 学车报名日期(仅供数据迁移).
	*/
	public void setLcarEnrollDate(String lcarEnrollDate) {
		this.lcarEnrollDate = lcarEnrollDate;
	}

	/**
	* 获取 初次领证日期(仅供数据迁移).
	*
	* @return 初次领证日期(仅供数据迁移).
	*/
	public String getGetCardDate() {
		return getCardDate;
	}

	/**
	* 设置 初次领证日期(仅供数据迁移).
	*
	* @param 初次领证日期(仅供数据迁移).
	*/
	public void setGetCardDate(String getCardDate) {
		this.getCardDate = getCardDate;
	}

	/**
	* 获取 发证地点(仅供数据迁移).
	*
	* @return 发证地点(仅供数据迁移).
	*/
	public String getGetCardPlace() {
		return getCardPlace;
	}

	/**
	* 设置 发证地点(仅供数据迁移).
	*
	* @param 发证地点(仅供数据迁移).
	*/
	public void setGetCardPlace(String getCardPlace) {
		this.getCardPlace = getCardPlace;
	}

	/**
	* 获取 准驾车型(仅供数据迁移).
	*
	* @return 准驾车型(仅供数据迁移).
	*/
	public String getCarType() {
		return carType;
	}

	/**
	* 设置 准驾车型(仅供数据迁移).
	*
	* @param 准驾车型(仅供数据迁移).
	*/
	public void setCarType(String carType) {
		this.carType = carType;
	}

	/**
	* 获取 驾驶证号(仅供数据迁移).
	*
	* @return 驾驶证号(仅供数据迁移).
	*/
	public String getCardNum() {
		return cardNum;
	}

	/**
	* 设置 驾驶证号(仅供数据迁移).
	*
	* @param 驾驶证号(仅供数据迁移).
	*/
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	/**
	* 获取 申请类别(仅供数据迁移).
	*
	* @return 申请类别(仅供数据迁移).
	*/
	public String getApplyType() {
		return applyType;
	}

	/**
	* 设置 申请类别(仅供数据迁移).
	*
	* @param 申请类别(仅供数据迁移).
	*/
	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}

	/**
	* 获取 储干名称(仅供数据迁移).
	*
	* @return 储干名称(仅供数据迁移).
	*/
	public String getCadreName() {
		return cadreName;
	}

	/**
	* 设置 储干名称(仅供数据迁移).
	*
	* @param 储干名称(仅供数据迁移).
	*/
	public void setCadreName(String cadreName) {
		this.cadreName = cadreName;
	}
	
}

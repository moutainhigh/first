package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;


import java.math.BigDecimal;

import com.deppon.foss.framework.entity.BaseEntity;
import com.deppon.lsp.module.mobilesecondworkflowlist.controlcenter.server.service.MeasureUnit;
/**
 * 
 * 作者（修改人）：YangMing
 * 修改时间：2013-9-4 上午10:47:44
 * 描述：工程项目申请单车辆配套明细分录实体
 * 更新记录：
 */
public class ProjectApplyE2Entity extends BaseEntity {

	/**
	 * TODO（用一句话描述这个变量表示什么）
	 */
	private static final long serialVersionUID = 8600612733206885455L;
	/* 分录行id */
	private String fid;
	/* 序号 */
	private String fseq;
	/* 父表id */
	private String fparentID;
	/* 序号 */
	private String cfseq;
	/* 今年 */
	private BigDecimal cfthisYear;
	/* 明年 */
	private BigDecimal cfnextYear;
	/* 后年 */
	private BigDecimal cfendYear;
	/* 备注 */
	private String cfremark;
	/* 车型ID */
	private String cfprojectID;
	/* 车型名称 */
	private DemandProject cfproject;
	/* 计量单位ID */
	private String funitsID;
	/* 计量单位名称 */
	private MeasureUnit funits;
	/* 分录标识 */
	private String finPut;
	/* 父表number */
	private String fparentName;
	
	
	
	/****************************************新加字段为BigDecimal对应的转换**************************/
	/* 今年 */
	private String cfthisYearDto;
	/* 明年 */
	private String cfnextYearDto;
	/* 后年 */
	private String cfendYearDto;
	
	
	/**
	 * 
	 * 描述： 父表number 
	 * @author yangming
	 * @date 2013-9-27 上午9:41:56
	 * @return
	 * 更新记录：
	 */
	public String getFparentName() {
		return fparentName;
	}
	/**
	 * 
	 * 描述： 父表number 
	 * @author yangming
	 * @date 2013-9-27 上午9:42:13
	 * @param fparentName
	 * 更新记录：
	 */
	public void setFparentName(String fparentName) {
		this.fparentName = fparentName;
	}
	/**
	 * 
	 * 描述： 序号 
	 * @author yangming
	 * @date 2013-9-27 上午9:42:13
	 * @param fparentName
	 * 更新记录：
	 */
	public String getCfseq() {
		return cfseq;
	}
	/**
	 * 
	 * 描述： 序号 
	 * @author yangming
	 * @date 2013-9-27 上午9:42:13
	 * @param fparentName
	 * 更新记录：
	 */
	public void setCfseq(String cfseq) {
		this.cfseq = cfseq;
	}
	/**
	 * 
	 * 描述： 车型名称
	 * @author yangming
	 * @date 2013-9-27 上午9:46:57
	 * @return
	 * 更新记录：
	 */
	public DemandProject getCfproject() {
		return cfproject;
	}
	/**
	 * 
	 * 描述： 车型名称
	 * @author yangming
	 * @date 2013-9-27 上午9:46:57
	 * @return
	 * 更新记录：
	 */
	public void setCfproject(DemandProject cfproject) {
		this.cfproject = cfproject;
	}
	/**
	 * 
	 * 描述： fid
	 * @author yangming
	 * @date 2013-9-27 上午9:46:57
	 * @return
	 * 更新记录：
	 */
	public String getFid() {
		return fid;
	}
	/**
	 * 
	 * 描述： fid setter
	 * @author yangming
	 * @date 2013-9-27 上午9:46:57
	 * @return
	 * 更新记录：
	 */
	public void setFid(String fid) {
		this.fid = fid;
	}
	/**
	 * 
	 * 描述： 序号
	 * @author yangming
	 * @date 2013-9-27 上午9:47:32
	 * @return
	 * 更新记录：
	 */
	public String getFseq() {
		return fseq;
	}
	/**
	 * 
	 * 描述： 序号
	 * @author yangming
	 * @date 2013-9-27 上午9:47:32
	 * @return
	 * 更新记录：
	 */
	public void setFseq(String fseq) {
		this.fseq = fseq;
	}
	/**
	 * 
	 * 描述： 表头id
	 * @author yangming
	 * @date 2013-9-27 上午9:47:32
	 * @return
	 * 更新记录：
	 */
	public String getFparentID() {
		return fparentID;
	}
	/**
	 * 
	 * 描述： 表头id
	 * @author yangming
	 * @date 2013-9-27 上午9:47:32
	 * @return
	 * 更新记录：
	 */
	public void setFparentID(String fparentID) {
		this.fparentID = fparentID;
	}
	/**
	 * 
	 * 描述： 今年
	 * @author yangming
	 * @date 2013-9-27 上午9:47:32
	 * @return
	 * 更新记录：
	 */
	public BigDecimal getCfthisYear() {
		return cfthisYear;
	}
	/**
	 * 
	 * 描述： 今年 setter
	 * @author yangming
	 * @date 2013-9-27 上午9:47:32
	 * @return
	 * 更新记录：
	 */
	public void setCfthisYear(BigDecimal cfthisYear) {
		this.cfthisYear = cfthisYear;
	}
	/**
	 * 
	 * 描述： 明年 getter
	 * @author yangming
	 * @date 2013-9-27 上午9:47:32
	 * @return
	 * 更新记录：
	 */
	public BigDecimal getCfnextYear() {
		return cfnextYear;
	}
	/**
	 * 
	 * 描述： 明年 setter
	 * @author yangming
	 * @date 2013-9-27 上午9:47:32
	 * @return
	 * 更新记录：
	 */
	public void setCfnextYear(BigDecimal cfnextYear) {
		this.cfnextYear = cfnextYear;
	}
	/**
	 * 
	 * 描述： 后年getter
	 * @author yangming
	 * @date 2013-9-27 上午9:49:58
	 * @return
	 * 更新记录：
	 */
	public BigDecimal getCfendYear() {
		return cfendYear;
	}
	/**
	 * 
	 * 描述： 后年setter
	 * @author yangming
	 * @date 2013-9-27 上午9:50:17
	 * @param cfendYear
	 * 更新记录：
	 */
	public void setCfendYear(BigDecimal cfendYear) {
		this.cfendYear = cfendYear;
	}
	/**
	 * 
	 * 描述： 备注
	 * @author yangming
	 * @date 2013-9-27 上午9:50:30
	 * @return
	 * 更新记录：
	 */
	public String getCfremark() {
		return cfremark;
	}
	/**
	 * 
	 * 描述： 备注
	 * @author yangming
	 * @date 2013-9-27 上午9:50:30
	 * @return
	 * 更新记录：
	 */
	public void setCfremark(String cfremark) {
		this.cfremark = cfremark;
	}
	/**
	 * 
	 * 描述： 车型ID
	 * @author yangming
	 * @date 2013-9-27 上午9:50:53
	 * @return
	 * 更新记录：
	 */
	public String getCfprojectID() {
		return cfprojectID;
	}
	/**
	 * 
	 * 描述： 车型ID setter
	 * @author yangming
	 * @date 2013-9-27 上午9:50:53
	 * @return
	 * 更新记录：
	 */
	public void setCfprojectID(String cfprojectID) {
		this.cfprojectID = cfprojectID;
	}
	/**
	 * 
	 * 描述： 计量单位ID
	 * @author yangming
	 * @date 2013-9-27 上午9:51:43
	 * @return
	 * 更新记录：
	 */
	public String getFunitsID() {
		return funitsID;
	}
	/**
	 * 
	 * 描述：计量单位ID 
	 * @author yangming
	 * @date 2013-9-27 上午9:51:48
	 * @param funitsID
	 * 更新记录：
	 */
	public void setFunitsID(String funitsID) {
		this.funitsID = funitsID;
	}
	/**
	 * 
	 * 描述： 预留字段
	 * @author yangming
	 * @date 2013-9-27 上午9:51:56
	 * @return
	 * 更新记录：
	 */
	public String getFinPut() {
		return finPut;
	}
	/**
	 * 
	 * 描述： 预留字段
	 * @author yangming
	 * @date 2013-9-27 上午9:51:56
	 * @return
	 * 更新记录：
	 */
	public void setFinPut(String finPut) {
		this.finPut = finPut;
	}
	/**
	 * 
	 * 描述：计量单位名称 
	 * @author yangming
	 * @date 2013-9-27 上午9:52:30
	 * @return
	 * 更新记录：
	 */
	public MeasureUnit getFunits() {
		return funits;
	}
	/**
	 * 
	 * 描述： 计量单位名称 
	 * @author yangming
	 * @date 2013-9-27 上午9:52:54
	 * @param funits
	 * 更新记录：
	 */
	public void setFunits(MeasureUnit funits) {
		this.funits = funits;
	}
	public String getCfthisYearDto() {
		return cfthisYearDto;
	}
	public void setCfthisYearDto(String cfthisYearDto) {
		this.cfthisYearDto = cfthisYearDto;
	}
	public String getCfnextYearDto() {
		return cfnextYearDto;
	}
	public void setCfnextYearDto(String cfnextYearDto) {
		this.cfnextYearDto = cfnextYearDto;
	}
	public String getCfendYearDto() {
		return cfendYearDto;
	}
	public void setCfendYearDto(String cfendYearDto) {
		this.cfendYearDto = cfendYearDto;
	}
	
}

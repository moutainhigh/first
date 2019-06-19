package com.deppon.wfs.workflow.domain;

import java.util.Date;

/**
 * 文件发布申请实体Bean
 * @author meng tianxiang 
 * @Date 2014-05-06 10:44:15
 */
 
public class FilePublishBean extends Entity {
	
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
	* 责任部门 
	*/
	private String responDepart;
	
	/** 
	* 责任者 
	*/
	private String responPeople;
	
	/** 
	* 效力状态 
	*/
	private String effectState;
	
	/** 
	* 效力状态编码 
	*/
	private String effectStateCode;
	
	/** 
	* 页数 
	*/
	private Long countPage;
	
	/** 
	* 申请类别 
	*/
	private String applyType;
	
	/** 
	* 文件类别 
	*/
	private String fileType;
	
	/** 
	* 任免类型 
	*/
	private String appointedType;
	
	/** 
	* 任免类型编码 
	*/
	private String appointedTypeCode;
	
	/** 
	* 被任免人所在事业部 
	*/
	private String division;
	
	/** 
	* 被任免人所在事业部标杆编码 
	*/
	private String divisionSyscode;
	
	/** 
	* 文件使用范围 
	*/
	private String fileScope;
	
	/** 
	* 文件使用范围编码 
	*/
	private String fileScopeCode;
	
	/** 
	* 文件编号 
	*/
	private String fileCode;
	
	/** 
	* 文件标题 
	*/
	private String fileTitle;
	
	/** 
	* 文件摘要 
	*/
	private String fileAbstract;
	
	/** 
	* 文件生效日期 
	*/
	private Date effectDate;
	
	/** 
	* 文件过期日期 
	*/
	private Date expiredDate;
	
	/** 
	* 申请事由 
	*/
	private String applyReason;
	
	/** 
	* 下个审批人 
	*/
	private String nextapproal;
	
	/** 
	* 发文申请通过时间 
	*/
	private Date agreedate;
	
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
	* 获取 责任部门.
	*
	* @return 责任部门.
	*/
	public String getResponDepart() {
		return responDepart;
	}

	/**
	* 设置 责任部门.
	*
	* @param 责任部门.
	*/
	public void setResponDepart(String responDepart) {
		this.responDepart = responDepart;
	}
	
	/**
	* 获取 责任者.
	*
	* @return 责任者.
	*/
	public String getResponPeople() {
		return responPeople;
	}

	/**
	* 设置 责任者.
	*
	* @param 责任者.
	*/
	public void setResponPeople(String responPeople) {
		this.responPeople = responPeople;
	}
	
	/**
	* 获取 效力状态.
	*
	* @return 效力状态.
	*/
	public String getEffectState() {
		return effectState;
	}

	/**
	* 设置 效力状态.
	*
	* @param 效力状态.
	*/
	public void setEffectState(String effectState) {
		this.effectState = effectState;
	}
	
	/**
	* 获取 效力状态编码.
	*
	* @return 效力状态编码.
	*/
	public String getEffectStateCode() {
		return effectStateCode;
	}

	/**
	* 设置 效力状态编码.
	*
	* @param 效力状态编码.
	*/
	public void setEffectStateCode(String effectStateCode) {
		this.effectStateCode = effectStateCode;
	}
	
	/**
	* 获取 页数.
	*
	* @return 页数.
	*/
	public Long getCountPage() {
		return countPage;
	}

	/**
	* 设置 页数.
	*
	* @param 页数.
	*/
	public void setCountPage(Long countPage) {
		this.countPage = countPage;
	}
	
	/**
	* 获取 申请类别.
	*
	* @return 申请类别.
	*/
	public String getApplyType() {
		return applyType;
	}

	/**
	* 设置 申请类别.
	*
	* @param 申请类别.
	*/
	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}
	
	/**
	* 获取 文件类别.
	*
	* @return 文件类别.
	*/
	public String getFileType() {
		return fileType;
	}

	/**
	* 设置 文件类别.
	*
	* @param 文件类别.
	*/
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	/**
	* 获取 任免类型.
	*
	* @return 任免类型.
	*/
	public String getAppointedType() {
		return appointedType;
	}

	/**
	* 设置 任免类型.
	*
	* @param 任免类型.
	*/
	public void setAppointedType(String appointedType) {
		this.appointedType = appointedType;
	}
	
	/**
	* 获取 任免类型编码.
	*
	* @return 任免类型编码.
	*/
	public String getAppointedTypeCode() {
		return appointedTypeCode;
	}

	/**
	* 设置 任免类型编码.
	*
	* @param 任免类型编码.
	*/
	public void setAppointedTypeCode(String appointedTypeCode) {
		this.appointedTypeCode = appointedTypeCode;
	}
	
	/**
	* 获取 被任免人所在事业部.
	*
	* @return 被任免人所在事业部.
	*/
	public String getDivision() {
		return division;
	}

	/**
	* 设置 被任免人所在事业部.
	*
	* @param 被任免人所在事业部.
	*/
	public void setDivision(String division) {
		this.division = division;
	}
	
	/**
	* 获取 被任免人所在事业部标杆编码.
	*
	* @return 被任免人所在事业部标杆编码.
	*/
	public String getDivisionSyscode() {
		return divisionSyscode;
	}

	/**
	* 设置 被任免人所在事业部标杆编码.
	*
	* @param 被任免人所在事业部标杆编码.
	*/
	public void setDivisionSyscode(String divisionSyscode) {
		this.divisionSyscode = divisionSyscode;
	}
	
	/**
	* 获取 文件使用范围.
	*
	* @return 文件使用范围.
	*/
	public String getFileScope() {
		return fileScope;
	}

	/**
	* 设置 文件使用范围.
	*
	* @param 文件使用范围.
	*/
	public void setFileScope(String fileScope) {
		this.fileScope = fileScope;
	}
	
	/**
	* 获取 文件使用范围编码.
	*
	* @return 文件使用范围编码.
	*/
	public String getFileScopeCode() {
		return fileScopeCode;
	}

	/**
	* 设置 文件使用范围编码.
	*
	* @param 文件使用范围编码.
	*/
	public void setFileScopeCode(String fileScopeCode) {
		this.fileScopeCode = fileScopeCode;
	}
	
	/**
	* 获取 文件编号.
	*
	* @return 文件编号.
	*/
	public String getFileCode() {
		return fileCode;
	}

	/**
	* 设置 文件编号.
	*
	* @param 文件编号.
	*/
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	
	/**
	* 获取 文件标题.
	*
	* @return 文件标题.
	*/
	public String getFileTitle() {
		return fileTitle;
	}

	/**
	* 设置 文件标题.
	*
	* @param 文件标题.
	*/
	public void setFileTitle(String fileTitle) {
		this.fileTitle = fileTitle;
	}
	
	/**
	* 获取 文件摘要.
	*
	* @return 文件摘要.
	*/
	public String getFileAbstract() {
		return fileAbstract;
	}

	/**
	* 设置 文件摘要.
	*
	* @param 文件摘要.
	*/
	public void setFileAbstract(String fileAbstract) {
		this.fileAbstract = fileAbstract;
	}
	
	/**
	* 获取 文件生效日期.
	*
	* @return 文件生效日期.
	*/
	public Date getEffectDate() {
		return effectDate;
	}

	/**
	* 设置 文件生效日期.
	*
	* @param 文件生效日期.
	*/
	public void setEffectDate(Date effectDate) {
		this.effectDate = effectDate;
	}
	
	/**
	* 获取 文件过期日期.
	*
	* @return 文件过期日期.
	*/
	public Date getExpiredDate() {
		return expiredDate;
	}

	/**
	* 设置 文件过期日期.
	*
	* @param 文件过期日期.
	*/
	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
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
	* 获取 下个审批人.
	*
	* @return 下个审批人.
	*/
	public String getNextapproal() {
		return nextapproal;
	}

	/**
	* 设置 下个审批人.
	*
	* @param 下个审批人.
	*/
	public void setNextapproal(String nextapproal) {
		this.nextapproal = nextapproal;
	}
	
	/**
	* 获取 发文申请通过时间.
	*
	* @return 发文申请通过时间.
	*/
	public Date getAgreedate() {
		return agreedate;
	}

	/**
	* 设置 发文申请通过时间.
	*
	* @param 发文申请通过时间.
	*/
	public void setAgreedate(Date agreedate) {
		this.agreedate = agreedate;
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
	

}

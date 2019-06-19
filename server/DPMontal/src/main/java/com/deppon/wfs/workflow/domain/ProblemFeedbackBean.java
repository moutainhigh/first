package com.deppon.wfs.workflow.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 一线问题反馈申请实例类
 * @author Work Flow System
 * @Date 2014-04-10 17:15:00
 */
 
public class ProblemFeedbackBean extends Entity implements Serializable{
	
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 1L;
	
	private Long processinstid;
	
	/** 
	* 业务编码 
	*/
	private String busino;
	
	/** 
	* 申请人工号 
	*/
	private String applyPersonId;
	
	/** 
	* 申请人姓名 
	*/
	private String applyPersonName;
	
	/** 
	* 所属部门 
	*/
	private String department;
	
	/** 
	* 所属事业部 
	*/
	private String division;
	
	/** 
	* 所属经营本部 
	*/
	private String operateDept;
	
	/** 
	* 问题类型 
	*/
	private String problemType;
	
	/** 
	* 问题内容 
	*/
	private String problemContent;
	
	/** 
	* 申请时间 
	*/
	private Date applyDate;
	
	/** 
	* 责任部门 
	*/
	private String responsibDepart;
	
	/** 
	* 预计完成时间 
	*/
	private Date completeDate;
	
	/** 
	* 预计完成时间字符串
	*/
	private String completeDateStr;
	
	/** 
	* 满意度得分 
	*/
	private Long satisfaction;
	
	public Long getProcessinstid() {
		return processinstid;
	}
	
	public void setProcessinstid(Long processinstid) {
		this.processinstid = processinstid;
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
	* 获取 申请人姓名.
	*
	* @return 申请人姓名.
	*/
	public String getApplyPersonName() {
		return applyPersonName;
	}

	/**
	* 设置 申请人姓名.
	*
	* @param 申请人姓名.
	*/
	public void setApplyPersonName(String applyPersonName) {
		this.applyPersonName = applyPersonName;
	}
	
	/**
	* 获取 所属部门.
	*
	* @return 所属部门.
	*/
	public String getDepartment() {
		return department;
	}

	/**
	* 设置 所属部门.
	*
	* @param 所属部门.
	*/
	public void setDepartment(String department) {
		this.department = department;
	}
	
	/**
	* 获取 所属事业部.
	*
	* @return 所属事业部.
	*/
	public String getDivision() {
		return division;
	}

	/**
	* 设置 所属事业部.
	*
	* @param 所属事业部.
	*/
	public void setDivision(String division) {
		this.division = division;
	}
	
	/**
	* 获取 所属经营本部.
	*
	* @return 所属经营本部.
	*/
	public String getOperateDept() {
		return operateDept;
	}

	/**
	* 设置 所属经营本部.
	*
	* @param 所属经营本部.
	*/
	public void setOperateDept(String operateDept) {
		this.operateDept = operateDept;
	}
	
	/**
	* 获取 问题类型.
	*
	* @return 问题类型.
	*/
	public String getProblemType() {
		return problemType;
	}

	/**
	* 设置 问题类型.
	*
	* @param 问题类型.
	*/
	public void setProblemType(String problemType) {
		this.problemType = problemType;
	}
	
	/**
	* 获取 问题内容.
	*
	* @return 问题内容.
	*/
	public String getProblemContent() {
		return problemContent;
	}

	/**
	* 设置 问题内容.
	*
	* @param 问题内容.
	*/
	public void setProblemContent(String problemContent) {
		this.problemContent = problemContent;
	}
	
	/**
	* 获取 申请时间.
	*
	* @return 申请时间.
	*/
	public Date getApplyDate() {
		return applyDate;
	}

	/**
	* 设置 申请时间.
	*
	* @param 申请时间.
	*/
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	
	/**
	* 获取 责任部门.
	*
	* @return 责任部门.
	*/
	public String getResponsibDepart() {
		return responsibDepart;
	}

	/**
	* 设置 责任部门.
	*
	* @param 责任部门.
	*/
	public void setResponsibDepart(String responsibDepart) {
		this.responsibDepart = responsibDepart;
	}
	
	/**
	* 获取 预计完成时间.
	*
	* @return 预计完成时间.
	*/
	public Date getCompleteDate() {
		return completeDate;
	}

	/**
	* 设置 预计完成时间.
	*
	* @param 预计完成时间.
	*/
	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
		if(completeDate != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			this.completeDateStr = sdf.format(completeDate);
		}
	}
	
	/**
	* 设置 预计完成时间字符串.
	*
	* @param 预计完成时间字符串.
	*/
	public void setCompleteDateStr(String completeDateStr) {
		this.completeDateStr = completeDateStr;
	}
	
	/**
	* 获取 预计完成时间字符串.
	*
	* @param 预计完成时间字符串.
	*/
	public String getCompleteDateStr() {
		return completeDateStr;
	}
	
	/**
	* 获取 满意度得分.
	*
	* @return 满意度得分.
	*/
	public Long getSatisfaction() {
		return satisfaction;
	}

	/**
	* 设置 满意度得分.
	*
	* @param 满意度得分.
	*/
	public void setSatisfaction(Long satisfaction) {
		this.satisfaction = satisfaction;
	}
	

}

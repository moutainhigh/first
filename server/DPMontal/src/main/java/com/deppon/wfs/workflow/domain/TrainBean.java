package com.deppon.wfs.workflow.domain;

import java.util.Date;
/**
 * 
 * 培训需求或变更申请
 * @author Work Flow System
 * @Date 2013-10-21 13:52:07
 */
 
public class TrainBean extends Entity{
	
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 1L;
	
	/** 
	* 业务编号，主键 
	*/
	private String busino;
	/** 
	* 申请人 
	*/
	private String applyPersonName;
	/** 
	* 申请人工号  
	*/
	private String applyPersonId;
	/** 
	* 申请人部门 
	*/
	private String applyDeptName;
	/**
	 * 申请类型
	 */
	private String applyType;
	/** 
	* 培训开始时间  
	*/
	private Date beginTrainDate;
	/** 
	* 培训结束时间 
	*/
	private Date endTrainDate;
	/** 
	* 培训类型 
	*/
	private String trainType;
	/** 
	* 所属培训组 
	*/
	private String trainGroup;
	/** 
	* 预计培训人数 
	*/
	private String expectedNum;
	/** 
	* 培训对象 
	*/
	private String trainObjects;
	/** 
	* 意向讲师姓名(费用预算金额)  
	*/
	private String lecturerName;
	/** 
	* 是否有顾问参加(讲师资源是否充足)  
	*/
	private String isconsultant;
	/** 
	* 培训课程和目标 
	*/
	private String trainSubjects;
	/** 
	* PMO立项 
	*/
	private String pmoProject;
	/** 
	* 培训名称 
	*/
	private String trainName;
	/** 
	* 变更类型 
	*/
	private String changeType;
	/** 
	* 培训需求申请工作流号 
	*/
	private String trainRequestProcessinstid;
	/** 
	* 变更原因 
	*/
	private String changeReason;
	/** 
	* 变更内容 
	*/
	private String changeContent;
	/** 
	* 变更影响 
	*/
	private String changeEffect;
	/** 
	* 解决方案 
	*/
	private String solution;
	/** 
	* 是否有效,1:有效 0:无效 
	*/
	private String isseffective;
	/** 
	* 工作流号 
	*/
	private Long processinstid;
	/** 
	* 起草时间 
	*/
	private Date draftDate;
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
	* 鑾峰彇 业务编号，主键.
	*
	* @return 业务编号，主键.
	*/
	public String getBusino() {
		return busino;
	}

	/**
	* 璁剧疆 业务编号，主键.
	*
	* @param 业务编号，主键.
	*/
	public void setBusino(String busino) {
		this.busino = busino;
	}
	/**
	* 鑾峰彇 申请人.
	*
	* @return 申请人.
	*/
	public String getApplyPersonName() {
		return applyPersonName;
	}

	/**
	* 璁剧疆 申请人.
	*
	* @param 申请人.
	*/
	public void setApplyPersonName(String applyPersonName) {
		this.applyPersonName = applyPersonName;
	}
	/**
	* 鑾峰彇 申请人工号 .
	*
	* @return 申请人工号 .
	*/
	public String getApplyPersonId() {
		return applyPersonId;
	}

	/**
	* 璁剧疆 申请人工号 .
	*
	* @param 申请人工号 .
	*/
	public void setApplyPersonId(String applyPersonId) {
		this.applyPersonId = applyPersonId;
	}
	/**
	* 鑾峰彇 申请人部门.
	*
	* @return 申请人部门.
	*/
	public String getApplyDeptName() {
		return applyDeptName;
	}

	/**
	* 璁剧疆 申请人部门.
	*
	* @param 申请人部门.
	*/
	public void setApplyDeptName(String applyDeptName) {
		this.applyDeptName = applyDeptName;
	}
	/**
	* 鑾峰彇 培训开始时间 .
	*
	* @return 培训开始时间 .
	*/
	public Date getBeginTrainDate() {
		return beginTrainDate;
	}

	/**
	* 璁剧疆 培训开始时间 .
	*
	* @param 培训开始时间 .
	*/
	public void setBeginTrainDate(Date beginTrainDate) {
		this.beginTrainDate = beginTrainDate;
	}
	/**
	* 鑾峰彇 培训结束时间.
	*
	* @return 培训结束时间.
	*/
	public Date getEndTrainDate() {
		return endTrainDate;
	}

	/**
	* 璁剧疆 培训结束时间.
	*
	* @param 培训结束时间.
	*/
	public void setEndTrainDate(Date endTrainDate) {
		this.endTrainDate = endTrainDate;
	}
	/**
	* 鑾峰彇 培训类型.
	*
	* @return 培训类型.
	*/
	public String getTrainType() {
		return trainType;
	}

	/**
	* 璁剧疆 培训类型.
	*
	* @param 培训类型.
	*/
	public void setTrainType(String trainType) {
		this.trainType = trainType;
	}
	/**
	* 鑾峰彇 所属培训组.
	*
	* @return 所属培训组.
	*/
	public String getTrainGroup() {
		return trainGroup;
	}

	/**
	* 璁剧疆 所属培训组.
	*
	* @param 所属培训组.
	*/
	public void setTrainGroup(String trainGroup) {
		this.trainGroup = trainGroup;
	}
	/**
	* 鑾峰彇 预计培训人数.
	*
	* @return 预计培训人数.
	*/
	public String getExpectedNum() {
		return expectedNum;
	}

	/**
	* 璁剧疆 预计培训人数.
	*
	* @param 预计培训人数.
	*/
	public void setExpectedNum(String expectedNum) {
		this.expectedNum = expectedNum;
	}
	/**
	* 鑾峰彇 培训对象.
	*
	* @return 培训对象.
	*/
	public String getTrainObjects() {
		return trainObjects;
	}

	/**
	* 璁剧疆 培训对象.
	*
	* @param 培训对象.
	*/
	public void setTrainObjects(String trainObjects) {
		this.trainObjects = trainObjects;
	}
	/**
	* 鑾峰彇 意向讲师姓名(费用预算金额) .
	*
	* @return 意向讲师姓名(费用预算金额) .
	*/
	public String getLecturerName() {
		return lecturerName;
	}

	/**
	* 璁剧疆 意向讲师姓名(费用预算金额) .
	*
	* @param 意向讲师姓名(费用预算金额) .
	*/
	public void setLecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}
	/**
	* 鑾峰彇 是否有顾问参加(讲师资源是否充足) .
	*
	* @return 是否有顾问参加(讲师资源是否充足) .
	*/
	public String getIsconsultant() {
		return isconsultant;
	}

	/**
	* 璁剧疆 是否有顾问参加(讲师资源是否充足) .
	*
	* @param 是否有顾问参加(讲师资源是否充足) .
	*/
	public void setIsconsultant(String isconsultant) {
		this.isconsultant = isconsultant;
	}
	/**
	* 鑾峰彇 培训课程和目标.
	*
	* @return 培训课程和目标.
	*/
	public String getTrainSubjects() {
		return trainSubjects;
	}

	/**
	* 璁剧疆 培训课程和目标.
	*
	* @param 培训课程和目标.
	*/
	public void setTrainSubjects(String trainSubjects) {
		this.trainSubjects = trainSubjects;
	}
	/**
	* 鑾峰彇 PMO立项.
	*
	* @return PMO立项.
	*/
	public String getPmoProject() {
		return pmoProject;
	}

	/**
	* 璁剧疆 PMO立项.
	*
	* @param PMO立项.
	*/
	public void setPmoProject(String pmoProject) {
		this.pmoProject = pmoProject;
	}
	/**
	* 鑾峰彇 培训名称.
	*
	* @return 培训名称.
	*/
	public String getTrainName() {
		return trainName;
	}

	/**
	* 璁剧疆 培训名称.
	*
	* @param 培训名称.
	*/
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	/**
	* 鑾峰彇 变更类型.
	*
	* @return 变更类型.
	*/
	public String getChangeType() {
		return changeType;
	}

	/**
	* 璁剧疆 变更类型.
	*
	* @param 变更类型.
	*/
	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}
	/**
	* 鑾峰彇 培训需求申请工作流号.
	*
	* @return 培训需求申请工作流号.
	*/
	public String getTrainRequestProcessinstid() {
		return trainRequestProcessinstid;
	}

	/**
	* 璁剧疆 培训需求申请工作流号.
	*
	* @param 培训需求申请工作流号.
	*/
	public void setTrainRequestProcessinstid(String trainRequestProcessinstid) {
		this.trainRequestProcessinstid = trainRequestProcessinstid;
	}
	/**
	* 鑾峰彇 变更原因.
	*
	* @return 变更原因.
	*/
	public String getChangeReason() {
		return changeReason;
	}

	/**
	* 璁剧疆 变更原因.
	*
	* @param 变更原因.
	*/
	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}
	/**
	* 鑾峰彇 变更内容.
	*
	* @return 变更内容.
	*/
	public String getChangeContent() {
		return changeContent;
	}

	/**
	* 璁剧疆 变更内容.
	*
	* @param 变更内容.
	*/
	public void setChangeContent(String changeContent) {
		this.changeContent = changeContent;
	}
	/**
	* 鑾峰彇 变更影响.
	*
	* @return 变更影响.
	*/
	public String getChangeEffect() {
		return changeEffect;
	}

	/**
	* 璁剧疆 变更影响.
	*
	* @param 变更影响.
	*/
	public void setChangeEffect(String changeEffect) {
		this.changeEffect = changeEffect;
	}
	/**
	* 鑾峰彇 解决方案.
	*
	* @return 解决方案.
	*/
	public String getSolution() {
		return solution;
	}

	/**
	* 璁剧疆 解决方案.
	*
	* @param 解决方案.
	*/
	public void setSolution(String solution) {
		this.solution = solution;
	}
	/**
	* 鑾峰彇 是否有效,1:有效 0:无效.
	*
	* @return 是否有效,1:有效 0:无效.
	*/
	public String getIsseffective() {
		return isseffective;
	}

	/**
	* 璁剧疆 是否有效,1:有效 0:无效.
	*
	* @param 是否有效,1:有效 0:无效.
	*/
	public void setIsseffective(String isseffective) {
		this.isseffective = isseffective;
	}
	/**
	* 鑾峰彇 工作流号.
	*
	* @return 工作流号.
	*/
	public Long getProcessinstid() {
		return processinstid;
	}

	/**
	* 璁剧疆 工作流号.
	*
	* @param 工作流号.
	*/
	public void setProcessinstid(Long processinstid) {
		this.processinstid = processinstid;
	}
	/**
	* 鑾峰彇 起草时间.
	*
	* @return 起草时间.
	*/
	public Date getDraftDate() {
		return draftDate;
	}

	/**
	* 璁剧疆 起草时间.
	*
	* @param 起草时间.
	*/
	public void setDraftDate(Date draftDate) {
		this.draftDate = draftDate;
	}
	/**
	* 鑾峰彇 创建时间.
	*
	* @return 创建时间.
	*/
	public Date getCreateTime() {
		return createTime;
	}

	/**
	* 璁剧疆 创建时间.
	*
	* @param 创建时间.
	*/
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	* 鑾峰彇 修改时间.
	*
	* @return 修改时间.
	*/
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	* 璁剧疆 修改时间.
	*
	* @param 修改时间.
	*/
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	* 鑾峰彇 备用字段1.
	*
	* @return 备用字段1.
	*/
	public String getSpareField1() {
		return spareField1;
	}

	/**
	* 璁剧疆 备用字段1.
	*
	* @param 备用字段1.
	*/
	public void setSpareField1(String spareField1) {
		this.spareField1 = spareField1;
	}
	/**
	* 鑾峰彇 备用字段2.
	*
	* @return 备用字段2.
	*/
	public String getSpareField2() {
		return spareField2;
	}

	/**
	* 璁剧疆 备用字段2.
	*
	* @param 备用字段2.
	*/
	public void setSpareField2(String spareField2) {
		this.spareField2 = spareField2;
	}
	/**
	* @MethodName: getApplyType 
	* @description : 
	* @author：caibingbing 
	* @date： 2013-10-22 下午2:52:56
	* @return String
	 */
	public String getApplyType() {
		return applyType;
	}
	/**
	 * 
	* @MethodName: setApplyType 
	* @description : 
	* @author：caibingbing 
	* @date： 2013-10-22 下午2:53:02
	* @param applyType void
	 */
	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}

}

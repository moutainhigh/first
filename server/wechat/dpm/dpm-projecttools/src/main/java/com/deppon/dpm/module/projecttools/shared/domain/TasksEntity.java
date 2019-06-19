package com.deppon.dpm.module.projecttools.shared.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.deppon.foss.framework.entity.BaseEntity;

public class TasksEntity extends BaseEntity {
	
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int taskId;
	//任务类别 （项目类任务：1    管理事务类任务：2    日常需求类任务：3      常规工作类任务：4）
	private int taskCategoryId;
	private String taskCategory;
	//任务名称
	private String taskName;
	//任务类型 -- 项目类任务(需求任务:1、开发任务:2、测试任务:3、版本规划任务:4、问题风险任务:5、其他任务:6)
	//-- 事务类任务(常规类:7、评审类:8、学习类:9、研究类:10、会议类:11、循环类:12、其它:13)
	private int taskTypeId;
	private String taskType;
	//项目编号
	private int taskProjectId;
	//项目编码
	private String projectCode;
	//项目名称
	private String taskProjectName;
	//项目类型
	private String taskProjectType;
	//任务分配者
	private String taskOwnerId;
	private String taskOwerName;
	//任务处理者
	private String taskProcesserId;
	private String taskProcesserName;
	//任务处理者邮箱  分配任务时进行邮件提醒
	private String taskProcesserEmail;
	//任务完成进度
	private int taskPercentComplete;
	//父任务名称
    private String parentTaskName;
    //父任务id
    private int parentTaskId;
    //最上级父任务id
    private int taskTopParentId;
    //交付物名称
    private String taskDeliverable;
    //计划开始时间
    private Date taskStartTime;
    //计划开始时间
    private String taskstartTime;
    //计划结束时间
    private Date taskEndTime;
    //计划结束时间
    private String taskendTime;
    //父任务计划工时（H）
    private BigDecimal duration;
    //计划工时（H）
    private BigDecimal taskDuration;
    //子任务计划工时之和
    private BigDecimal taskSumDuration;
    //任务经验值
    private int taskExperience;
    //功能点
    private int taskPoint;
    //实际功能点
    private int taskRealPoint;
    //任务描述
    private String taskDesc;
    //任务状态
    private String taskStatus;
    //难度系数
    private int taskDifficulty;
    //开发语言
    private String taskDevelopLanguage;
    //开发语言id
    private int taskDevelopLanguageId;
    //是否是里程碑(0:否;1:是)
    private int taskIsLandmarker;
    //是否需要审核(0:不需要;1:需要)
    private int taskIsCheck;
    //任务层级
    private int taskLevel;
    //循环周期
    private int taskLoopCycle;
    //用户需求Code
    private String userDemandCode;
    //用户需求ID
    private String userDemandId;
    /**
	 * @return the userDemandCode
	 */
	public String getUserDemandCode() {
		return userDemandCode;
	}
	/**
	 * @param userDemandCode the userDemandCode to set
	 */
	public void setUserDemandCode(String userDemandCode) {
		this.userDemandCode = userDemandCode;
	}
	//需求类别
    private String demandCategory;
    private String userDemand;
    //系统需求ID名称
    private String sysDemandId;
    //private String sysdemandcode
    //版本号
    private String version;
    //附件
    private List<FileEntity> filesList;
  //系统需求ID
    private int sysDemand;
  //修改原因
    private String changeReason;
    // 任务查询新增问题风险字段
    private String riskId;
	
    /**
     * get
     * @return
     */
	public String getRiskId() {
		return riskId;
	}
	/**
	 * set
	 * @param riskId
	 */
	public void setRiskId(String riskId) {
		this.riskId = riskId;
	}
	/**
	 * @return the changeReason
	 */
	public String getChangeReason() {
		return changeReason;
	}
	/**
	 * @param changeReason
	 */
	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}
	/**
	 * @return the projectCode
	 */
	public String getProjectCode() {
		return projectCode;
	}
	/**
	 * @param projectCode the projectCode to set
	 */
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	/**
	 * @return the sysDemand
	 */
	public int getSysDemand() {
		return sysDemand;
	}
	/**
	 * @param sysDemand the sysDemand to set
	 */
	public void setSysDemand(int sysDemand) {
		this.sysDemand = sysDemand;
	}
	/**
	 * @return the taskProcesserEmail
	 */
	public String getTaskProcesserEmail() {
		return taskProcesserEmail;
	}
	/**
	 * @param taskProcesserEmail
	 */
	public void setTaskProcesserEmail(String taskProcesserEmail) {
		this.taskProcesserEmail = taskProcesserEmail;
	}
	/**
	 * @return the taskTopParentId
	 */
	public int getTaskTopParentId() {
		return taskTopParentId;
	}
	/**
	 * @param taskTopParentId
	 */
	public void setTaskTopParentId(int taskTopParentId) {
		this.taskTopParentId = taskTopParentId;
	}
	/**
	 * @return the taskSumDuration
	 */
	public BigDecimal getTaskSumDuration() {
		return taskSumDuration;
	}
	/**
	 * @param taskSumDuration
	 */
	public void setTaskSumDuration(BigDecimal taskSumDuration) {
		this.taskSumDuration = taskSumDuration;
	}
	/**
	 * @return the taskLoopCycle
	 */
	public int getTaskLoopCycle() {
		return taskLoopCycle;
	}
	/**
	 * @param taskLoopCycle
	 */
	public void setTaskLoopCycle(int taskLoopCycle) {
		this.taskLoopCycle = taskLoopCycle;
	}
	/**
	 * @return the taskLevel
	 */
	public int getTaskLevel() {
		return taskLevel;
	}
	/**
	 * @param taskLevel
	 */
	public void setTaskLevel(int taskLevel) {
		this.taskLevel = taskLevel;
	}
	/**
	 * @return the taskstartTime
	 */
	public String getTaskstartTime() {
		return taskstartTime;
	}
	/**
	 * @param taskstartTime
	 */
	public void setTaskstartTime(String taskstartTime) {
		this.taskstartTime = taskstartTime;
	}
	/**
	 * @return the taskendTime
	 */
	public String getTaskendTime() {
		return taskendTime;
	}
	/**
	 * @param taskendTime
	 */
	public void setTaskendTime(String taskendTime) {
		this.taskendTime = taskendTime;
	}
	/**
	 * @return the parentTaskId
	 */
	public int getParentTaskId() {
		return parentTaskId;
	}
	/**
	 * @param parentTaskId
	 */
	public void setParentTaskId(int parentTaskId) {
		this.parentTaskId = parentTaskId;
	}
	/**
	 * @return the taskDevelopLanguageId
	 */
	public int getTaskDevelopLanguageId() {
		return taskDevelopLanguageId;
	}
	/**
	 * @param taskDevelopLanguageId
	 */
	public void setTaskDevelopLanguageId(int taskDevelopLanguageId) {
		this.taskDevelopLanguageId = taskDevelopLanguageId;
	}
	/**
	 * @return the taskId
	 */
	public int getTaskId() {
		return taskId;
	}
	/**
	 * @param taskId
	 */
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	/**
	 * @return the taskCategoryId
	 */
	public int getTaskCategoryId() {
		return taskCategoryId;
	}
	/**
	 * @param taskCategoryId
	 */
	public void setTaskCategoryId(int taskCategoryId) {
		this.taskCategoryId = taskCategoryId;
	}
	/**
	 * @return the taskCategory
	 */
	public String getTaskCategory() {
		return taskCategory;
	}
	/**
	 * @param taskCategory
	 */
	public void setTaskCategory(String taskCategory) {
		this.taskCategory = taskCategory;
	}
	/**
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}
	/**
	 * @param taskName
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	/**
	 * @return the taskTypeId
	 */
	public int getTaskTypeId() {
		return taskTypeId;
	}
	/**
	 * @param taskTypeId
	 */
	public void setTaskTypeId(int taskTypeId) {
		this.taskTypeId = taskTypeId;
	}
	/**
	 * @return the taskType
	 */
	public String getTaskType() {
		return taskType;
	}
	/**
	 * @param taskType
	 */
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	/**
	 * @return the taskProjectId
	 */
	public int getTaskProjectId() {
		return taskProjectId;
	}
	/**
	 * @param taskProjectId
	 */
	public void setTaskProjectId(int taskProjectId) {
		this.taskProjectId = taskProjectId;
	}
	/**
	 * @return the taskProjectName
	 */
	public String getTaskProjectName() {
		return taskProjectName;
	}
	/**
	 * @param taskProjectName
	 */
	public void setTaskProjectName(String taskProjectName) {
		this.taskProjectName = taskProjectName;
	}
	/**
	 * @return the taskProjectType
	 */
	public String getTaskProjectType() {
		return taskProjectType;
	}
	/**
	 * @param taskProjectType
	 */
	public void setTaskProjectType(String taskProjectType) {
		this.taskProjectType = taskProjectType;
	}
	/**
	 * @return the taskOwnerId
	 */
	public String getTaskOwnerId() {
		return taskOwnerId;
	}
	/**
	 * @param taskOwnerId
	 */
	public void setTaskOwnerId(String taskOwnerId) {
		this.taskOwnerId = taskOwnerId;
	}
	/**
	 * @return the taskOwerName
	 */
	public String getTaskOwerName() {
		return taskOwerName;
	}
	/**
	 * @param taskOwerName
	 */
	public void setTaskOwerName(String taskOwerName) {
		this.taskOwerName = taskOwerName;
	}
	/**
	 * @return the taskProcesserId
	 */
	public String getTaskProcesserId() {
		return taskProcesserId;
	}
	/**
	 * @param taskProcesserId
	 */
	public void setTaskProcesserId(String taskProcesserId) {
		this.taskProcesserId = taskProcesserId;
	}
	/**
	 * @return the taskProcesserName
	 */
	public String getTaskProcesserName() {
		return taskProcesserName;
	}
	/**
	 * @param taskProcesserName
	 */
	public void setTaskProcesserName(String taskProcesserName) {
		this.taskProcesserName = taskProcesserName;
	}
	/**
	 * @return the taskPercentComplete
	 */
	public int getTaskPercentComplete() {
		return taskPercentComplete;
	}
	/**
	 * @param taskPercentComplete
	 */
	public void setTaskPercentComplete(int taskPercentComplete) {
		this.taskPercentComplete = taskPercentComplete;
	}
	/**
	 * @return the parentTaskName
	 */
	public String getParentTaskName() {
		return parentTaskName;
	}
	/**
	 * @param parentTaskName
	 */
	public void setParentTaskName(String parentTaskName) {
		this.parentTaskName = parentTaskName;
	}
	/**
	 * @return the taskDeliverable
	 */
	public String getTaskDeliverable() {
		return taskDeliverable;
	}
	/**
	 * @param taskDeliverable
	 */
	public void setTaskDeliverable(String taskDeliverable) {
		this.taskDeliverable = taskDeliverable;
	}
	/**
	 * @return the taskStartTime
	 */
	public Date getTaskStartTime() {
		return taskStartTime;
	}
	/**
	 * @param taskStartTime
	 */
	public void setTaskStartTime(Date taskStartTime) {
		this.taskStartTime = taskStartTime;
	}
	/**
	 * @return the taskEndTime
	 */
	public Date getTaskEndTime() {
		return taskEndTime;
	}
	/**
	 * @param taskEndTime
	 */
	public void setTaskEndTime(Date taskEndTime) {
		this.taskEndTime = taskEndTime;
	}
	/**
	 * @return the taskDuration
	 */
	public BigDecimal getTaskDuration() {
		return taskDuration;
	}
	/**
	 * @param taskDuration
	 */
	public void setTaskDuration(BigDecimal taskDuration) {
		this.taskDuration = taskDuration;
	}
	/**
	 * @return the taskExperience
	 */
	public int getTaskExperience() {
		return taskExperience;
	}
	/**
	 * @param taskExperience
	 */
	public void setTaskExperience(int taskExperience) {
		this.taskExperience = taskExperience;
	}
	/**
	 * @return the taskPoint
	 */
	public int getTaskPoint() {
		return taskPoint;
	}
	/**
	 * @param taskPoint
	 */
	public void setTaskPoint(int taskPoint) {
		this.taskPoint = taskPoint;
	}
	/**
	 * @return the taskRealPoint
	 */
	public int getTaskRealPoint() {
		return taskRealPoint;
	}
	/**
	 * @param taskRealPoint
	 */
	public void setTaskRealPoint(int taskRealPoint) {
		this.taskRealPoint = taskRealPoint;
	}
	/**
	 * @return the taskDesc
	 */
	public String getTaskDesc() {
		return taskDesc;
	}
	/**
	 * @param taskDesc
	 */
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	/**
	 * @return the taskStatus
	 */
	public String getTaskStatus() {
		return taskStatus;
	}
	/**
	 * @param taskStatus
	 */
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	/**
	 * @return the taskDifficulty
	 */
	public int getTaskDifficulty() {
		return taskDifficulty;
	}
	/**
	 * @param taskDifficulty
	 */
	public void setTaskDifficulty(int taskDifficulty) {
		this.taskDifficulty = taskDifficulty;
	}
	/**
	 * @return the taskDevelopLanguage
	 */
	public String getTaskDevelopLanguage() {
		return taskDevelopLanguage;
	}
	/**
	 * @param taskDevelopLanguage
	 */
	public void setTaskDevelopLanguage(String taskDevelopLanguage) {
		this.taskDevelopLanguage = taskDevelopLanguage;
	}
	/**
	 * @return the taskIsLandmarker
	 */
	public int getTaskIsLandmarker() {
		return taskIsLandmarker;
	}
	/**
	 * @param taskIsLandmarker
	 */
	public void setTaskIsLandmarker(int taskIsLandmarker) {
		this.taskIsLandmarker = taskIsLandmarker;
	}
	/**
	 * @return the taskIsCheck
	 */
	public int getTaskIsCheck() {
		return taskIsCheck;
	}
	/**
	 * @param taskIsCheck
	 */
	public void setTaskIsCheck(int taskIsCheck) {
		this.taskIsCheck = taskIsCheck;
	}
	/**
	 * @return the userDemandId
	 */
	public String getUserDemandId() {
		return userDemandId;
	}
	/**
	 * @param userDemandId
	 */
	public void setUserDemandId(String userDemandId) {
		this.userDemandId = userDemandId;
	}
	/**
	 * @return the userDemand
	 */
	public String getUserDemand() {
		return userDemand;
	}
	/**
	 * @param userDemand
	 */
	public void setUserDemand(String userDemand) {
		this.userDemand = userDemand;
	}
	/**
	 * @return the sysDemandId
	 */
	public String getSysDemandId() {
		return sysDemandId;
	}
	/**
	 * @param sysDemandId
	 */
	public void setSysDemandId(String sysDemandId) {
		this.sysDemandId = sysDemandId;
	}
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * @param version
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * @return the filesList
	 */
	public List<FileEntity> getFilesList() {
		return filesList;
	}
	/**
	 * @param filesList
	 */
	public void setFilesList(List<FileEntity> filesList) {
		this.filesList = filesList;
	}
	/**
	 * @return the demandCategory
	 */
	public String getDemandCategory() {
		return demandCategory;
	}
	/**
	 * @param demandCategory the demandCategory to set
	 */
	public void setDemandCategory(String demandCategory) {
		this.demandCategory = demandCategory;
	}
	/**
	 * @return the duration
	 */
	public BigDecimal getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(BigDecimal duration) {
		this.duration = duration;
	}
	
}
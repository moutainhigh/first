package com.deppon.dpm.module.projecttools.shared.domain;

import java.util.Date;
import java.util.List;

/**
 * 
* @title: TaskLogEntity 
* @description：任务跟踪日志实体类
* @date： 2014年8月8日 上午10:27:03
 */
public class TaskLogEntity {
    //
	private int id;
    //已工作小时数
    private float workedHour;
    //日志描述
    private String desc;
    //通知邮箱
    private String email;
    
    //任务编号
    private int taskId;
    //实际进度
    private int percentComplete;
    //日志创建时间
    private Date createTime;
    //审核记录ID
    private int checkLogid;
    //是否需要审核(0:不需要;1:需要)
    private int taskIscheck;
    //任务实际功能点
    private int realPoint;
    
    //附件
    private List<FileEntity> filesList;
    
    //处理人
    private String empcode;

	/**
	 * @return the empcode
	 */
	public String getEmpcode() {
		return empcode;
	}

	/**
	 * @param empcode
	 */
	public void setEmpcode(String empcode) {
		this.empcode = empcode;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the workedHour
	 */
	public float getWorkedHour() {
		return workedHour;
	}

	/**
	 * @param workedHour
	 */
	public void setWorkedHour(float workedHour) {
		this.workedHour = workedHour;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * @return the percentComplete
	 */
	public int getPercentComplete() {
		return percentComplete;
	}

	/**
	 * @param percentComplete
	 */
	public void setPercentComplete(int percentComplete) {
		this.percentComplete = percentComplete;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the checkLogid
	 */
	public int getCheckLogid() {
		return checkLogid;
	}

	/**
	 * @param checkLogid
	 */
	public void setCheckLogid(int checkLogid) {
		this.checkLogid = checkLogid;
	}

	/**
	 * @return the taskIscheck
	 */
	public int getTaskIscheck() {
		return taskIscheck;
	}

	/**
	 * @param taskIscheck
	 */
	public void setTaskIscheck(int taskIscheck) {
		this.taskIscheck = taskIscheck;
	}

	/**
	 * @return the realPoint
	 */
	public int getRealPoint() {
		return realPoint;
	}

	/**
	 * @param realPoint
	 */
	public void setRealPoint(int realPoint) {
		this.realPoint = realPoint;
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
    
}

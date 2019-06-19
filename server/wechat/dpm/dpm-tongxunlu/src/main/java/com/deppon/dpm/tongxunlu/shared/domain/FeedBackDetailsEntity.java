package com.deppon.dpm.tongxunlu.shared.domain;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 页面展示实体类
 * 
 * @author 231586
 * 
 */
public class FeedBackDetailsEntity {
	/**
	 * 意见反馈id
	 */
	private int id;
	/**
	 * 意见反馈
	 */
	private int feedBackId;
	/**
	 * 工号
	 */
	private String empCode;
	/**
	 * 反馈人
	 */
	private String empName;
	/**
	 * 反馈内容
	 */
	private String content = "";
	/**
	 * 对应附件名称
	 */
	private String fileName = "";
	/**
	 * 电话号码
	 */
	private String mobileno = "";
	/**
	 * 反馈时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date submitTime;
	/**
	 * 处理状态
	 */
	private String executeStatus;
	/**
	 * 处理人
	 */
	private String executePerson = "";
	/**
	 * 处理人电话号码
	 */
	private String executeMobile = "";
	/**
	 * 迭代安排
	 */
	private String plan = "";
	/**
	 * 备注(处理意见)
	 */
	private String PS = "";
	/**
	 * 设备类型
	 */
	private String osType = "";
	/**
	 * 问题类型
	 */
	private String type = "";

	/**
	 * 是否解决 0解决 1未解决 默认未解决
	 */
	private String isSolve;

	/**
	 * 标题(常见问题)
	 */
	private String title = "";
	
	/**
	 * 回复内容
	 */
	private String reply = "";

	/**
	 * get
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * set
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getEmpCode() {
		return empCode;
	}

	/**
	 * set
	 * 
	 * @param empCode
	 */
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * set
	 * 
	 * @param empName
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getContent() {
		return content;
	}

	/**
	 * set
	 * 
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * set
	 * 
	 * @param fileName
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Date getSubmitTime() {
		return submitTime;
	}

	/**
	 * set
	 * 
	 * @param submitTime
	 */
	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getExecuteStatus() {
		return executeStatus;
	}

	/**
	 * set
	 * 
	 * @param executeStatus
	 */
	public void setExecuteStatus(String executeStatus) {
		this.executeStatus = executeStatus;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getExecutePerson() {
		return executePerson;
	}

	/**
	 * set
	 * 
	 * @param executePerson
	 */
	public void setExecutePerson(String executePerson) {
		this.executePerson = executePerson;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getPlan() {
		return plan;
	}

	/**
	 * set
	 * 
	 * @param plan
	 */
	public void setPlan(String plan) {
		this.plan = plan;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getPS() {
		return PS;
	}

	/**
	 * set
	 * 
	 * @param pS
	 */
	public void setPS(String pS) {
		PS = pS;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getOsType() {
		return osType;
	}

	/**
	 * set
	 * 
	 * @param osType
	 */
	public void setOsType(String osType) {
		this.osType = osType;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * set
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getIsSolve() {
		return isSolve;
	}

	/**
	 * set
	 * 
	 * @param isSolve
	 */
	public void setIsSolve(String isSolve) {
		this.isSolve = isSolve;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * set
	 * 
	 * @param isSolve
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * get
	 * @return
	 */
	public int getFeedBackId() {
		return feedBackId;
	}

	/**
	 * set
	 * @param feedBackId
	 */
	public void setFeedBackId(int feedBackId) {
		this.feedBackId = feedBackId;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	/**
	 * get
	 * @return
	 */
	public String getReply() {
		return reply;
	}

	/**
	 * set
	 * @param reply
	 */
	public void setReply(String reply) {
		this.reply = reply;
	}

	/**
	 * get
	 * @return
	 */
	public String getExecuteMobile() {
		return executeMobile;
	}

	/**
	 * set
	 * @param executeMobile
	 */
	public void setExecuteMobile(String executeMobile) {
		this.executeMobile = executeMobile;
	}
}

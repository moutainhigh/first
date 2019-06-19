/*package com.deppon.dpm.uums.server.domain;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

*//**
 * 我的任务实体类
 * 
 * @author 245968
 * 
 *//*
public class Task implements Serializable {

	private static final long serialVersionUID = -805895418064263875L;

	*//**
	 * 自增id
	 *//*
	private int id;
	*//**
	 * 优先级 0 低优先级 1 中等优先级 2 高级优先级
	 *//*
	private String priority;

	*//**
	 * 标题
	 *//*
	private String title;

	*//**
	 * 当前指派人
	 *//*
	private String currentUserId;

	*//**
	 * 任务创建时间
	 *//*
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	*//**
	 * 任务起始日期
	 *//*
	@JSONField(format = "yyyy-MM-dd")
	private Date startDate;

	*//**
	 * 任务结束日期
	 *//*
	@JSONField(format = "yyyy-MM-dd")
	private Date endDate;

	*//**
	 * 任务是否完成 0 未完成 1完成
	 *//*
	private String finish="0";

	*//**
	 * 任务是否逻辑删除 0 未删除 1 删除
	 *//*
	private String logicalDelete="0";

	*//**
	 * 任务的详细内容
	 *//*
	private String content;

	*//**
	 * 上传的文件附件
	 *//*
	private File[] files;

	*//**
	 * 上传的文件附件名称
	 *//*
	private String[] filesFileName;

	*//**
	 * 上传附件的路径
	 *//*
	private String path;

	*//**
	 * 创建人
	 *//*
	private String createUserId;

	*//**
	 * 第一指派人
	 *//*
	private String originUserId;

	*//**
	 * 第二指派人
	 *//*
	private String secondUserId;

	private String showDate;

	 以下四项不保存到数据库 
	private String createUserName;

	private String originUserName;

	private String secondUserName;

	private String currentUserName;

	public String getCurrentUserName() {
		return currentUserName;
	}

	public void setCurrentUserName(String currentUserName) {
		this.currentUserName = currentUserName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getFinish() {
		return finish;
	}

	public void setFinish(String finish) {
		this.finish = finish;
	}

	public String getLogicalDelete() {
		return logicalDelete;
	}

	public void setLogicalDelete(String logicalDelete) {
		this.logicalDelete = logicalDelete;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getOriginUserName() {
		return originUserName;
	}

	public void setOriginUserName(String originUserName) {
		this.originUserName = originUserName;
	}

	public String getSecondUserName() {
		return secondUserName;
	}

	public void setSecondUserName(String secondUserName) {
		this.secondUserName = secondUserName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public File[] getFiles() {
		return files;
	}

	public void setFiles(File[] files) {
		this.files = files;
	}

	public String getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserId(String currentUserId) {
		this.currentUserId = currentUserId;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getOriginUserId() {
		return originUserId;
	}

	public void setOriginUserId(String originUserId) {
		this.originUserId = originUserId;
	}

	public String getSecondUserId() {
		return secondUserId;
	}

	public void setSecondUserId(String secondUserId) {
		this.secondUserId = secondUserId;
	}

	public String getShowDate() {
		return showDate;
	}

	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}

	public String[] getFilesFileName() {
		return filesFileName;
	}

	public void setFilesFileName(String[] filesFileName) {
		this.filesFileName = filesFileName;
	}

}
*/
package com.deppon.dpm.module.common.shared.domain;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 评论实体
 * 
 * @author 231586
 * @date 2015-08-28
 */
public class AwardDetailEntity extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5774077723124435604L;

	/**
	 * 唯一标示id
	 */
	private String id;

	/**
	 * 对应文章ID
	 */
	private String articleID;
	/**
	 * 发送人
	 */
	private String userId;
	/**
	 * 发送人姓名
	 */
	private String empName;
	/**
	 * 接收人
	 */
	private String toUserId;
	/**
	 * 发送内容
	 */
	private String sendContent;
	/**
	 * 发送时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date sendTime;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 职位信息
	 */
	private String jobName;
	/**
	 * 个人头像
	 */
	private String pictPath;
	/**
	 * 性别
	 */
	private String gender;

	/**
	 * get
	 * 
	 * @return
	 */
	public String getArticleID() {
		return articleID;
	}

	/**
	 * set
	 * 
	 * @param articleID
	 */
	public void setArticleID(String articleID) {
		this.articleID = articleID;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * set
	 * 
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getToUserId() {
		return toUserId;
	}

	/**
	 * set
	 * 
	 * @param toUserId
	 */
	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getSendContent() {
		return sendContent;
	}

	/**
	 * set
	 * 
	 * @param sendContent
	 */
	public void setSendContent(String sendContent) {
		this.sendContent = sendContent;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Date getSendTime() {
		return sendTime;
	}

	/**
	 * set
	 * 
	 * @param sendTime
	 */
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * set
	 * 
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
	public String getJobName() {
		return jobName;
	}

	/**
	 * set
	 * 
	 * @param jobName
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getPictPath() {
		return pictPath;
	}

	/**
	 * set
	 * 
	 * @param picPath
	 */
	public void setPictPath(String pictPath) {
		this.pictPath = pictPath;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * set
	 * 
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * get
	 */
	public String getId() {
		return id;
	}

	/**
	 * set
	 */
	public void setId(String id) {
		this.id = id;
	}

}

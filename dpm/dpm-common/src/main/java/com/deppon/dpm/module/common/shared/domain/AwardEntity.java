package com.deppon.dpm.module.common.shared.domain;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.deppon.foss.framework.entity.BaseEntity;

/**
 * @date 2015-08-28
 * @author 231586 悬赏实体
 * 
 */
public class AwardEntity extends BaseEntity {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8660084278163187786L;
	/**
	 * 发布文ID
	 */
	private String articleID;
	/**
	 * 发布人
	 */
	private String publisher;
	/**
	 * 发布人邮箱
	 */
	private String publisherEmail;
	/**
	 * 招聘职位
	 */
	private String recruitPosition;
	/**
	 * 发布时间
	 */
	@JSONField(format = "yyyy-MM-dd")
	private Date publishTime;
	/**
	 * 阅读量
	 */
	private int readingQuantity;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 是否有奖金
	 */
	private boolean hasAward;
	/**
	 * 奖金数量
	 */
	private String reward;
	/**
	 * 创建时间
	 */
	@JSONField(format = "yyyy-MM-dd")
	private Date createTime;
	/**
	 * 联系人
	 */
	private String contactPerson;
	/**
	 * 联系人联系方式
	 */
	private String contactPhone;
	/**
	 * 回复类
	 */
	private AwardDetailEntity awardDetailEntity;

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
	public String getPublisher() {
		return publisher;
	}

	/**
	 * set
	 * 
	 * @param publisher
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getPublisherEmail() {
		return publisherEmail;
	}

	/**
	 * set
	 * 
	 * @param publisherEmail
	 */
	public void setPublisherEmail(String publisherEmail) {
		this.publisherEmail = publisherEmail;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getRecruitPosition() {
		return recruitPosition;
	}

	/**
	 * set
	 * 
	 * @param recruitPosition
	 */
	public void setRecruitPosition(String recruitPosition) {
		this.recruitPosition = recruitPosition;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Date getPublishTime() {
		return publishTime;
	}

	/**
	 * set
	 * 
	 * @param publishTime
	 */
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getReadingQuantity() {
		return readingQuantity;
	}

	/**
	 * set
	 * 
	 * @param readingQuantity
	 */
	public void setReadingQuantity(int readingQuantity) {
		this.readingQuantity = readingQuantity;
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
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * is
	 * 
	 * @return
	 */
	public boolean isHasAward() {
		return hasAward;
	}

	/**
	 * set
	 * 
	 * @param hasAward
	 */
	public void setHasAward(boolean hasAward) {
		this.hasAward = hasAward;
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
	public AwardDetailEntity getAwardDetailEntity() {
		return awardDetailEntity;
	}

	/**
	 * set
	 * 
	 * @param awardDetailEntity
	 */
	public void setAwardDetailEntity(AwardDetailEntity awardDetailEntity) {
		this.awardDetailEntity = awardDetailEntity;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getReward() {
		return reward;
	}

	/**
	 * set
	 * 
	 * @param reward
	 */
	public void setReward(String reward) {
		this.reward = reward;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getContactPerson() {
		return contactPerson;
	}

	/**
	 * set
	 * 
	 * @param contactPerson
	 */
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getContactPhone() {
		return contactPhone;
	}

	/**
	 * set
	 * 
	 * @param contactPhone
	 */
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
}

package com.deppon.dpm.module.announce.shared.domain;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.deppon.foss.framework.entity.BaseEntity;

public class NormalQuestionEntity extends BaseEntity {

	private static final long serialVersionUID = -8804365740240460999L;

	/**
	 * 标题
	 */
	private String title;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 问题类型
	 */
	private String questionType;
	/**
	 * 创建时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
	 * get
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * set
	 * @param createTime
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * get
	 * @return
	 */
	public String getContent() {
		return content;
	}

	/**
	 * set
	 * @param createTime
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * get
	 * @return
	 */
	public String getQuestionType() {
		return questionType;
	}

	/**
	 * set
	 * @param createTime
	 */
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	/**
	 * get
	 * @return
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * set
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}

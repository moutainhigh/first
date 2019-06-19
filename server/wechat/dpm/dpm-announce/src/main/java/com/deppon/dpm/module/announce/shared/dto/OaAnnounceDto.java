/**
 * Entity开发规范
 * 1.必须继承com.deppon.foss.framework.entity.BaseEntity
 * 2.类名必须以Entity结尾
 * 3.必须生成serialVersionUID
 * 4.建议属性名称与数据库字段命名规则一致
 */
package com.deppon.dpm.module.announce.shared.dto;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSON;

/**
 * @since 公告表实体
 * @author 045925
 * 
 */
public class OaAnnounceDto implements Serializable {
	/**
	 * @Fields serialVersionUID : 公告实体serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * OA原ID
	 */
	private String id;
	/**
	 * 发布时间
	 */
	private Date publishTime;
	/**
	 * 正文
	 */
	private String content;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 正文图片
	 */
	private String conImg;
	/**
	 * 滚动图片
	 */
	private String scrollImg;
	/**
	 * 状态
	 */
	private String optState;
	/**
	 * 公告类型
	 */
	private String type;

	/**
	 * get
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * set
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
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
	public String getConImg() {
		return conImg;
	}

	/**
	 * set
	 * 
	 * @param conImg
	 */
	public void setConImg(String conImg) {
		this.conImg = conImg;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getScrollImg() {
		return scrollImg;
	}

	/**
	 * set
	 * 
	 * @param scrollImg
	 */
	public void setScrollImg(String scrollImg) {
		this.scrollImg = scrollImg;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getOptState() {
		return optState;
	}

	/**
	 * set
	 * 
	 * @param optState
	 */
	public void setOptState(String optState) {
		this.optState = optState;
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
	 * toString
	 */
	public String toString() {
		return JSON.toJSONString(this);
	}
}
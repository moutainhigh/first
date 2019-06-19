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
import java.util.List;

/**
 * 公告表实体
 * 
 * @author 045925
 * 
 */
public class AnnounceDto implements Serializable {
	/**
	 * @Fields serialVersionUID : 公告实体serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 公告ID
	 */
	private String id;
	/**
	 * 操作类型(READ:阅读;COLLECTION:收藏;PRIASE:点赞)
	 */
	private String optType;
	/**
	 * 公告类型(ANNOUNCE:任免公告;NEWS:动态新闻;LEADER_NOTES:高管随笔)
	 */
	private String type;
	/**
	 * 标题名称
	 */
	private String title;
	/**
	 * 发布开始时间
	 */
	private Date startTime;
	/**
	 * 发布结束时间
	 */
	private Date endTime;
	/**
	 * 工号
	 */
	private String userId;
	/**
	 * 筛选公告ID集合
	 */
	private List<String> announceList;
	/**
	 * 公告详细分类
	 */
	private String detailType;

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
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * set
	 * 
	 * @param startTime
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * set
	 * 
	 * @param endTime
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

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
	public String getOptType() {
		return optType;
	}

	/**
	 * set
	 * 
	 * @param optType
	 */
	public void setOptType(String optType) {
		this.optType = optType;
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
	public List<String> getAnnounceList() {
		return announceList;
	}

	/**
	 * set
	 * 
	 * @param announceList
	 */
	public void setAnnounceList(List<String> announceList) {
		this.announceList = announceList;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getDetailType() {
		return detailType;
	}

	/**
	 * set
	 * 
	 * @param detailType
	 */
	public void setDetailType(String detailType) {
		this.detailType = detailType;
	}

}
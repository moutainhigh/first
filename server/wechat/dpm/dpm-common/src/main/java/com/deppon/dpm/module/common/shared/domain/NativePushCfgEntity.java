package com.deppon.dpm.module.common.shared.domain;

import java.util.Date;

/**
 * 本地推送配置实体类
 * @author 292502
 *
 */
public class NativePushCfgEntity {
	
	// id
	private Integer id;
	
	// 应用编号
	private Integer appId;
	
	// 应用名称
	private String appName;
	
	// 推送条件
	private String pushCondition;
	
	// 标题
	private String title;
	
	// 链接地址
	private String linkAddr;
	
	// 内容
	private String content;
	
	// 是否进入消息中心
	private Boolean intoMsg;
	
	// 推送时间
	private Date pushTime;
	
	// 是否即时推送
	private Boolean intime;
	
	// 状态  1：可用，2：不可用
	private Boolean status;
	
	// 创建时间
	private Date createTime;

	// 更新时间
	private Date updateTime;
	
	/**分页属性**/
	private int page;
	
	private int rows;
	
	// getter
	public Integer getId() {
		return id;
	}

	// setter
	public void setId(Integer id) {
		this.id = id;
	}

	// getter
	public Integer getAppId() {
		return appId;
	}

	// setter
	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	// getter
	public String getAppName() {
		return appName;
	}

	// setter
	public void setAppName(String appName) {
		this.appName = appName;
	}

	// getter
	public String getPushCondition() {
		return pushCondition;
	}

	// setter
	public void setPushCondition(String pushCondition) {
		this.pushCondition = pushCondition;
	}

	// getter
	public Boolean getStatus() {
		return status;
	}

	// setter
	public void setStatus(Boolean status) {
		this.status = status;
	}

	// getter
	public Date getCreateTime() {
		return createTime;
	}

	// setter
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	// getter
	public Date getUpdateTime() {
		return updateTime;
	}

	// setter
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	// getter
	public int getPage() {
		return page;
	}

	// setter
	public void setPage(int page) {
		this.page = page;
	}

	// getter
	public int getRows() {
		return rows;
	}

	// setter
	public void setRows(int rows) {
		this.rows = rows;
	}

	// getter
	public String getTitle() {
		return title;
	}

	// setter
	public void setTitle(String title) {
		this.title = title;
	}

	// getter
	public String getLinkAddr() {
		return linkAddr;
	}

	// setter
	public void setLinkAddr(String linkAddr) {
		this.linkAddr = linkAddr;
	}

	// getter
	public String getContent() {
		return content;
	}

	// setter
	public void setContent(String content) {
		this.content = content;
	}

	// getter
	public Boolean getIntoMsg() {
		return intoMsg;
	}

	// setter
	public void setIntoMsg(Boolean intoMsg) {
		this.intoMsg = intoMsg;
	}

	// getter
	public Date getPushTime() {
		return pushTime;
	}

	// setter
	public void setPushTime(Date pushTime) {
		this.pushTime = pushTime;
	}

	// getter
	public Boolean getIntime() {
		return intime;
	}

	// setter
	public void setIntime(Boolean intime) {
		this.intime = intime;
	}

}

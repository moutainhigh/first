package com.deppon.dpm.module.main.shared.domain;


public class NoticeCenterIsTop {
     
	//每条通知的唯一id
	private String id;
	//通知类型id
	private String type;
	//发布人/起草人
	private String userId;
	//创建时间
	private String createTime;
	//创建时间
	private String updateTime;
	//是否置顶
	private String isTop;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getIsTop() {
		return isTop;
	}
	public void setIsTop(String isTop) {
		this.isTop = isTop;
	}
	@Override
	public String toString() {
		return "NoticeCenterIsTop [id=" + id + ", type=" + type + ", userId="
				+ userId + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", isTop=" + isTop + "]";
	}
	
	
	
	
	
	
	
}

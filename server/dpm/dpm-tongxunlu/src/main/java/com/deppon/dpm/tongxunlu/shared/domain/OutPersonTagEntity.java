package com.deppon.dpm.tongxunlu.shared.domain;

import java.util.Date;

/**
 * 延伸类
 * 
 * @author 231586
 * 
 */
public class OutPersonTagEntity {
	/**
	 * id
	 */
	private int id;
	
	/**
	 * 公司名称
	 */
	private String tag;
	/**
	/**
	 * 创建人工号
	 */
	private String userId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "OutPersonTagEntity [id=" + id + ", tag=" + tag + ", userId="
				+ userId + ", createTime=" + createTime + ", updateTime="
				+ updateTime + "]";
	}
	
	
	
	
}

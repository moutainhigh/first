package com.deppon.dpm.tongxunlu.shared.domain;

import java.util.Date;

/**
 * 消息中心实体
 */
public class JpushMsgCentreEntity {
	// id
	private Integer id;
	
	// 推送条件key 0：工号，1：层级，2：岗位，3：部门
	private Integer pushConditionKey;

	// 推送条件value
	private String pushConditionVal;
	
	// 消息标题
	private String alert;
	
	// 消息内容
	private String content;
	
	// 链接类型 0：无链接 1：外部链接 2：内部链接
	private Integer linkType;
	
	// 链接地址
	private String linkAddr;
	
	// 链接参数
	private String extras;
	
	// 推送时间
	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPushConditionKey() {
		return pushConditionKey;
	}

	public void setPushConditionKey(Integer pushConditionKey) {
		this.pushConditionKey = pushConditionKey;
	}

	public String getPushConditionVal() {
		return pushConditionVal;
	}

	public void setPushConditionVal(String pushConditionVal) {
		this.pushConditionVal = pushConditionVal;
	}

	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLinkType() {
		return linkType;
	}

	public void setLinkType(Integer linkType) {
		this.linkType = linkType;
	}

	public String getLinkAddr() {
		return linkAddr;
	}

	public void setLinkAddr(String linkAddr) {
		this.linkAddr = linkAddr;
	}

	public String getExtras() {
		return extras;
	}

	public void setExtras(String extras) {
		this.extras = extras;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "JpushMsgCentreEntity [pushConditionKey=" + pushConditionKey
				+ ", pushConditionVal=" + pushConditionVal + ", alert=" + alert
				+ ", content=" + content + ", linkType=" + linkType
				+ ", linkAddr=" + linkAddr + ", extras=" + extras
				+ ", createTime=" + createTime + "]";
	}

}

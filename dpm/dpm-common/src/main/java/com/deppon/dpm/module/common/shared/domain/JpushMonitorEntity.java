package com.deppon.dpm.module.common.shared.domain;

import java.util.Date;

public class JpushMonitorEntity {

	// id
	private Integer id;
	
	// 产品线
	private String appKey;
	
	// 推送结果  true/false
	private Boolean pushResult;
	
	// 推送人员数量
	private Integer count;
	
	// 推送人员工号 
	private String userIds;
	
	// 消息弹出内容
	private String alert;
	
	// 小题内容
	private String content;
	
	// 是否进入消息中心 true/false
	private Boolean intoMC;
	
	// 是否是ECC true/false
	private Boolean isEcc;
	
	// 链接类型 0：无链接  1：外部链接 2：内部链接
	private Integer linktype;
	
	// 链接地址
	private String linkaddr;
	
	// 链接资源所需参数
	private String extras;
	
	// 开始推送时间
	private Date startTime;
	
	// 结束推送时间
	private Date endTime;
	
	private Date createTime;
	
	public JpushMonitorEntity() {
		super();
	}
	
	public JpushMonitorEntity(String appKey, String userIds, String alert,
			String content, Boolean intoMC, Boolean isEcc, Integer linktype,
			String linkaddr, String extras) {
		super();
		this.appKey = appKey;
		this.userIds = userIds;
		this.alert = alert;
		this.content = content;
		this.intoMC = intoMC;
		this.isEcc = isEcc;
		this.linktype = linktype;
		this.linkaddr = linkaddr;
		this.extras = extras;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public Boolean getPushResult() {
		return pushResult;
	}

	public void setPushResult(Boolean pushResult) {
		this.pushResult = pushResult;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getUserIds() {
		return userIds;
	}

	public void setUserIds(String userIds) {
		this.userIds = userIds;
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

	public Boolean getIntoMC() {
		return intoMC;
	}

	public void setIntoMC(Boolean intoMC) {
		this.intoMC = intoMC;
	}

	public Boolean getIsEcc() {
		return isEcc;
	}

	public void setIsEcc(Boolean isEcc) {
		this.isEcc = isEcc;
	}

	public Integer getLinktype() {
		return linktype;
	}

	public void setLinktype(Integer linktype) {
		this.linktype = linktype;
	}

	public String getLinkaddr() {
		return linkaddr;
	}

	public void setLinkaddr(String linkaddr) {
		this.linkaddr = linkaddr;
	}

	public String getExtras() {
		return extras;
	}

	public void setExtras(String extras) {
		this.extras = extras;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "JpushMonitorEntity [appKey=" + appKey + ", pushResult="
				+ pushResult + ", count=" + count + ", userIds=" + userIds
				+ ", alert=" + alert + ", content=" + content + ", intoMC="
				+ intoMC + ", isEcc=" + isEcc + ", linktype=" + linktype
				+ ", linkaddr=" + linkaddr + ", extras=" + extras
				+ ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
}

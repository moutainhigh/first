package com.deppon.dpm.module.common.shared.vo;

import java.util.HashMap;
import java.util.Map;

public class JPushParam {
	
	private String appKey;

	// 推送的用户ids，用,分隔
	private String userIds;
	
	// 消息弹出的内容
	private String alert;
	
	// 消息内容
	private String content;
	
	// 是否进入消息中心 0:不是 1：是
	private boolean intoMC;
	
	// 是否是德邦e站的消息  0:不是 1:是
	private boolean isEcc;
	
	// 是否来自Pda
	/*private boolean isPda;*/

	// 推送条件  osType（机型），joblevel（层级），jobname（岗位），orgIds（本部）
	private String pushConditionKey;
	
	private String pushConditionValue;
	
	// 链接类型 0：无链接  1：外部链接  2：内部链接 3:消息反馈 4:意见反馈 5：Pda
	private int linktype;
	
	// 链接地址
	private String linkaddr;
	
	// 其他产品线的扩展字段
	private Map<String,String> extras = new HashMap<String,String>();

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

	public boolean getIntoMC() {
		return intoMC;
	}

	public void setIntoMC(boolean intoMC) {
		this.intoMC = intoMC;
	}

	public boolean getIsEcc() {
		return isEcc;
	}

	public void setIsEcc(boolean isEcc) {
		this.isEcc = isEcc;
	}
	
	/*public boolean getIsPda() {
		return isPda;
	}

	public void setIsPda(boolean isPda) {
		this.isPda = isPda;
	}*/

	public String getPushConditionKey() {
		return pushConditionKey;
	}

	public void setPushConditionKey(String pushConditionKey) {
		this.pushConditionKey = pushConditionKey;
	}

	public String getPushConditionValue() {
		return pushConditionValue;
	}

	public void setPushConditionValue(String pushConditionValue) {
		this.pushConditionValue = pushConditionValue;
	}
	
	public int getLinktype() {
		return linktype;
	}

	public void setLinktype(int linktype) {
		this.linktype = linktype;
	}

	public String getLinkaddr() {
		return linkaddr;
	}

	public void setLinkaddr(String linkaddr) {
		this.linkaddr = linkaddr;
	}
	
	public Map<String, String> getExtras() {
		return extras;
	}

	public void setExtras(Map<String, String> extras) {
		this.extras = extras;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	@Override
	public String toString() {
		return "JPushParam [appKey=" + appKey + ", userIds=" + userIds
				+ ", alert=" + alert + ", content=" + content + ", intoMC="
				+ intoMC + ", isEcc=" + isEcc + ", pushConditionKey="
				+ pushConditionKey + ", pushConditionValue="
				+ pushConditionValue + ", linktype=" + linktype + ", linkaddr="
				+ linkaddr + ", extras=" + extras + "]";
	}
	
}

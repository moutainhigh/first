package com.deppon.dpm.module.common.shared.domain;

import java.util.Date;

/**
 * 副总呼叫监控实体
 */
public class LeaderCallMonitorEntity {

	private Integer id;
	
	private String leaderUserId; // 副总工号
	
	private String targetUserId; // 呼叫人或被呼叫人工号
	
	private int callType; // 呼叫类型  0：呼出 1：呼入
	
	private Date createTime;
	
	/***非数据库映射字段***/
	private String params; // 被呼叫人工号
	
	public LeaderCallMonitorEntity() {
		super();
	}
	
	public LeaderCallMonitorEntity(String leaderUserId, String targetUserId,
			int callType, Date createTime) {
		super();
		this.leaderUserId = leaderUserId;
		this.targetUserId = targetUserId;
		this.callType = callType;
		this.createTime = createTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLeaderUserId() {
		return leaderUserId;
	}

	public void setLeaderUserId(String leaderUserId) {
		this.leaderUserId = leaderUserId;
	}

	public String getTargetUserId() {
		return targetUserId;
	}

	public void setTargetUserId(String targetUserId) {
		this.targetUserId = targetUserId;
	}

	public int getCallType() {
		return callType;
	}

	public void setCallType(int callType) {
		this.callType = callType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}
	
}

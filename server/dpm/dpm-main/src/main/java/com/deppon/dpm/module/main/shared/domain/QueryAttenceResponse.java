package com.deppon.dpm.module.main.shared.domain;

public class QueryAttenceResponse {

//	private static final long serialVersionUID=1L;
	/**
	 * 全国打卡
	 * 操作类型1/移动端打卡 【add】2/移动端查询打卡记录【query】3/查询补考勤工作流【queryfill】
	 */
	private String operateType;
	//处理结果   0成功   1 失败
	private String result;
	//失败原因
	private String reason;
	
	//自动打卡新增字段  2016-07-11
	private String punchKey;
	
	//获得类型
	public String getOperateType() {
		return operateType;
	}
	//设置类型
	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}
	//获得处理结果
	public String getResult() {
		return result;
	}
	//设置处理结果
	public void setResult(String result) {
		this.result = result;
	}
	//获得失败原因
	public String getReason() {
		return reason;
	}
	//设置失败原因
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * @return the punchKey
	 */
	public String getPunchKey() {
		return punchKey;
	}
	/**
	 * @param punchKey the punchKey to set
	 */
	public void setPunchKey(String punchKey) {
		this.punchKey = punchKey;
	}
	
	
	
}

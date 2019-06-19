package com.deppon.dpm.module.wechat.shared.dto;

public class JobDto {
	/**
	 * media_id
	 */
	private String media_id;
	/**
	 * jobid
	 */
	private String jobid;
	/**
	 * 类型 0：全量更新部门   1：增量更新员工  2:获取Token时出错
	 */
	private String type;
	/**
	 * 错误码  0表示成功  其它表示失败，可以去官方查找对应错误信息
	 */
	private String errcode;

	/**
	 * 创建时间
	 */
	private String createTime;
	
	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	public String getJobid() {
		return jobid;
	}
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	
	
}

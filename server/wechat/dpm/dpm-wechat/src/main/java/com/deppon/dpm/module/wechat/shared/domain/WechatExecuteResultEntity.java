package com.deppon.dpm.module.wechat.shared.domain;
/**
 * 企业微信同步信息结果实体
 * @author 276344
 *
 */
public class WechatExecuteResultEntity {
	
	private String media_id;
	private String jobid;
	//0：部门  1:员工  2:获取Token出错
	private String type;
	private String errcode;
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
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}

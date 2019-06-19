package com.deppon.dpm.module.anps.shared.domain;
/**
 * 创建群缚 岗位信息  从数据库里读
 * @author 276344
 *
 */
public class NoticeJobEntity {
	/**
	 * 岗位人数
	 */
	private Integer num;
	/**
	 * 岗位名称
	 */
	private String jobName;
	/**
	 * 创建时间
	 */
	private String createDate;
	/**
	 * 排序 值越小越靠前
	 */
	private String sort;
	
	
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getOrder() {
		return sort;
	}
	public void setOrder(String sort) {
		this.sort = sort;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	
}

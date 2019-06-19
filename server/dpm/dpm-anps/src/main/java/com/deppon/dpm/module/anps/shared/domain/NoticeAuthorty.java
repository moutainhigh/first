package com.deppon.dpm.module.anps.shared.domain;

import java.util.Date;

/**
 * @date 2015-08-26
 * @author 231586 公告权限实体类
 * 
 */
public class NoticeAuthorty {
	//id
	private Integer id;
	// 员工号
	private String employeeCode;
	// 公文发送类型
	private Integer noticeSendType;	
	// 创建时间
	private Date createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public Integer getNoticeSendType() {
		return noticeSendType;
	}
	public void setNoticeSendType(Integer noticeSendType) {
		this.noticeSendType = noticeSendType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}			
	
	
}

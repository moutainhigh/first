package com.deppon.dpm.tongxunlu.shared.domain;

import java.util.Date;

/**
 * 延伸类
 * 
 * @author 231586
 * 
 */
public class OutPersonEntity {
	/**
	 * id
	 */
	private int id;
	/**
	 * 手机号
	 */
	private String mobileNo;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 工号
	 */
	private String staffId;
	/**
	 * 部门
	 */
	private String dpmDept;
	/**
	 * 项目
	 */
	private String dpmProject;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 性别
	 */
	private String gendar;
	
	/**
	 * 手机号
	 */
	private String remark;
	
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
	 * 公司
	 */
	private String company;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	
	
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getDpmDept() {
		return dpmDept;
	}
	public void setDpmDept(String dpmDept) {
		this.dpmDept = dpmDept;
	}
	public String getDpmProject() {
		return dpmProject;
	}
	public void setDpmProject(String dpmProject) {
		this.dpmProject = dpmProject;
	}
	public String getGendar() {
		return gendar;
	}
	public void setGendar(String gendar) {
		this.gendar = gendar;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
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
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "OutPersonEntity [id=" + id + ", mobileNo=" + mobileNo
				+ ", name=" + name
				+ ",tag=" + tag + ",company=" + company + ",remark=" + remark + ", userId=" + userId + ", createTime="
				+ createTime + ", updateTime=" + updateTime + "]";
	}
	
	
	
	
	
	
}

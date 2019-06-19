package com.deppon.dpm.module.management.shared.domain;

/**
 * @author 274858
 *  预定管理管理员实体
 */
public class ReserveAdminEntity {

	private String id;
	/**
	 * 工号
	 */
	private String userNo;
	/**
	 * 姓名
	 */
	private String userName;
	/**
	 * 部门名称
	 */
	private String depName;
	/**
	 * 电话号码
	 */
	private String phone;
	/**
	 * 创建人工号
	 */
	private String createUserNo;
	/**
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 工号
	 * @return
	 */
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	/**
	 * 姓名
	 * @return
	 */
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 部门名称
	 * @return
	 */
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	/**
	 * 电话号码
	 * @return
	 */
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 创建人工号
	 * @return
	 */
	public String getCreateUserNo() {
		return createUserNo;
	}
	public void setCreateUserNo(String createUserNo) {
		this.createUserNo = createUserNo;
	}
	/**
	 * 重写
	 * @return
	 */
	@Override
	public String toString() {
		return "ReserveAdminEntity [id=" + id + ", userNo=" + userNo
				+ ", userName=" + userName + ", depName=" + depName
				+ ", phone=" + phone + ", createUserNo=" + createUserNo + "]";
	}
	
	
	
	
}

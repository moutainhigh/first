package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
/**
 * <p>寄快递实体类<p>
 * @author 袁中华
 * @date 2015 9.9
 */ 
public class SendParcelSendEntity implements Serializable {
	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 收发室主键ID
	 */
	private int id;
	/**
	 * 快递公司
	 */
	private String sendCompany;
	/**
	 * 快递电话
	 */
	private String sendPhone;
	/**
	 * 快递人姓名
	 */
	private String sendName;
	/**
	 * 图面CODE
	 */
	private  String  photoCode;
	/**
	 *执行方法
	 */
	private String ManageCode;
//	private int ManageCode;
//	
//	
//	public int getManageCode() {
//		return ManageCode;
//	}
//	public void setManageCode(int manageCode) {
//		ManageCode = manageCode;
//	}
	
	public String getManageCode() {
		return ManageCode;
	}
	public void setManageCode(String manageCode) {
		ManageCode = manageCode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSendCompany() {
		return sendCompany;
	}
	public void setSendCompany(String sendCompany) {
		this.sendCompany = sendCompany;
	}
	public String getSendPhone() {
		return sendPhone;
	}
	public void setSendPhone(String sendPhone) {
		this.sendPhone = sendPhone;
	}
	public String getSendName() {
		return sendName;
	}
	public void setSendName(String sendName) {
		this.sendName = sendName;
	}
	public String getPhotoCode() {
		return photoCode;
	}
	public void setPhotoCode(String photoCode) {
		this.photoCode = photoCode;
	}
     
	 
}

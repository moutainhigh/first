package com.deppon.dpm.module.common.shared.domain;

/**
 * 短信发送日志记录实体
 * 
 */
public class VisitorSmsSendInfo {

	/**
	 * 短信接收号码
	 */
	private String smsPhone;
	/**
	 * 短信内容
	 */
	private String smsContent;
	/**
	 * 短信发送状态，1：成功，0.失败
	 */
	private int smsStatus;
	/**
	 * 备注
	 */
	private String remark;

	/**
	 * get
	 * 
	 * @return
	 */
	public String getSmsPhone() {
		return smsPhone;
	}

	/**
	 * set
	 * 
	 * @param smsPhone
	 */
	public void setSmsPhone(String smsPhone) {
		this.smsPhone = smsPhone;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getSmsContent() {
		return smsContent;
	}

	/**
	 * set
	 * 
	 * @param smsContent
	 */
	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getSmsStatus() {
		return smsStatus;
	}

	/**
	 * set
	 * 
	 * @param smsStatus
	 */
	public void setSmsStatus(int smsStatus) {
		this.smsStatus = smsStatus;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * set
	 * 
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

}

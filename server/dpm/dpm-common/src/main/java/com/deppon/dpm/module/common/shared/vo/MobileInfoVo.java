package com.deppon.dpm.module.common.shared.vo;

import java.util.Date;

/**
 * 登录人手机信息
 * @author 491275
 *
 */
public class MobileInfoVo {
	
	private String empCode; //工号
	
	private String msgImei; //设备号
	
	private String msgAndroidid; //  安卓ID
	
	private String msgModel; // 手机型号
	
	private String msgPhonenum; // 手机号
	
	private String msgSubscriberid; // SIM卡唯一的用户ID
	
	private String msgSimserialnumber; // SIM卡序列号
	
	private String msgBasebandstring; // 手机基带版本
	
	private String msgMacaddress; // 手机mac地址
	
	private String msgContactphonenumber; // 手机部分联系人
	
	private Date createTime;  //创建时间

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getMsgImei() {
		return msgImei;
	}

	public void setMsgImei(String msgImei) {
		this.msgImei = msgImei;
	}

	public String getMsgAndroidid() {
		return msgAndroidid;
	}

	public void setMsgAndroidid(String msgAndroidid) {
		this.msgAndroidid = msgAndroidid;
	}

	public String getMsgModel() {
		return msgModel;
	}

	public void setMsgModel(String msgModel) {
		this.msgModel = msgModel;
	}

	public String getMsgPhonenum() {
		return msgPhonenum;
	}

	public void setMsgPhonenum(String msgPhonenum) {
		this.msgPhonenum = msgPhonenum;
	}

	public String getMsgSubscriberid() {
		return msgSubscriberid;
	}

	public void setMsgSubscriberid(String msgSubscriberid) {
		this.msgSubscriberid = msgSubscriberid;
	}

	public String getMsgSimserialnumber() {
		return msgSimserialnumber;
	}

	public void setMsgSimserialnumber(String msgSimserialnumber) {
		this.msgSimserialnumber = msgSimserialnumber;
	}

	public String getMsgBasebandstring() {
		return msgBasebandstring;
	}

	public void setMsgBasebandstring(String msgBasebandstring) {
		this.msgBasebandstring = msgBasebandstring;
	}

	public String getMsgMacaddress() {
		return msgMacaddress;
	}

	public void setMsgMacaddress(String msgMacaddress) {
		this.msgMacaddress = msgMacaddress;
	}

	public String getMsgContactphonenumber() {
		return msgContactphonenumber;
	}

	public void setMsgContactphonenumber(String msgContactphonenumber) {
		this.msgContactphonenumber = msgContactphonenumber;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	
	

}

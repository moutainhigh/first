package com.deppon.dpm.doc.server.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @description
 * @version 1.0
 * @author cbb
 * @update 2012-10-20 下午5:43:30
 */
public class SmsInfo implements Serializable {
	
	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = 502553723350839131L;
	/**
	 * 电话号码
	 */
	private String mobile;
	/**
	 * 内容
	 */
	private String msgContent;
	/**
	 * 发送部门
	 */
	private String sendDept;
	/**
	 * 发送人
	 */
	private String sender;
	/**
	 * 业务类型
	 */
	private String msgType;
	/**
	 * 系统来源
	 */
	private String msgSource;
	/**
	 * 唯一标识
	 */
	private String unionId;
	/**
	 * 单号
	 */
	private String waybillNo;
	/**
	 * 服务类型(1、短信、2、语音、3、短信语音)
	 */
	private String serviceType;
	/**
	 * 最晚发送时间
	 */
	private Timestamp latestSendTime;
	/**
	 * 发送时间
	 */
	private Timestamp sendTime;
	/**
	 * 标准是否重复发送的状态(0 未重复发送，1重复发送)
	 */
	private int repeatState;

	/**
	 * get
	 * 
	 * @return
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * set
	 * 
	 * @param mobile
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getMsgContent() {
		return msgContent;
	}

	/**
	 * set
	 * 
	 * @param msgContent
	 */
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getSendDept() {
		return sendDept;
	}

	/**
	 * set
	 * 
	 * @param sendDept
	 */
	public void setSendDept(String sendDept) {
		this.sendDept = sendDept;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * set
	 * 
	 * @param sender
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getMsgType() {
		return msgType;
	}

	/**
	 * set
	 * 
	 * @param msgType
	 */
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getMsgSource() {
		return msgSource;
	}

	/**
	 * set
	 * 
	 * @param msgSource
	 */
	public void setMsgSource(String msgSource) {
		this.msgSource = msgSource;
	}

	/**
	 * set
	 * 
	 * @param unionId
	 */
	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getUnionId() {
		return unionId;
	}

	/**
	 * set
	 * 
	 * @param waybillNo
	 */
	public void setWaybillNo(String waybillNo) {
		this.waybillNo = waybillNo;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getWaybillNo() {
		return waybillNo;
	}

	/**
	 * set
	 * 
	 * @param serviceType
	 */
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getServiceType() {
		return serviceType;
	}

	/**
	 * set
	 * 
	 * @param sendTime
	 */
	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Timestamp getSendTime() {
		return sendTime;
	}

	/**
	 * set
	 * 
	 * @param latestSendTime
	 */
	public void setLatestSendTime(Timestamp latestSendTime) {
		this.latestSendTime = latestSendTime;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public Timestamp getLatestSendTime() {
		return latestSendTime;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getRepeatState() {
		return repeatState;
	}

	/**
	 * set
	 * 
	 * @param repeatState
	 */
	public void setRepeatState(int repeatState) {
		this.repeatState = repeatState;
	}
	
	@Override
	public String toString() {
		return "SmsInfo [mobile=" + mobile + ", msgContent=" + msgContent
				+ ", sendDept=" + sendDept + ", sender=" + sender
				+ ", msgType=" + msgType + ", msgSource=" + msgSource
				+ ", unionId=" + unionId + ", waybillNo=" + waybillNo
				+ ", serviceType=" + serviceType + ", latestSendTime="
				+ latestSendTime + ", sendTime=" + sendTime + ", repeatState="
				+ repeatState + "]";
	}
}

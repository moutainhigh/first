package com.deppon.dpm.login.server.vo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class ClientMessEntity implements Serializable {

	private static final long serialVersionUID = -5705689196206154568L;

    /**
     * 发送类型 1，短信(001) 2，企业微信(010) 4，微信公众号(100) 3，(短信+企业微信)(011) 5，(短信+微信公众号)(101)
     */
	private Integer sendType;
    /**
     * 系统来源
     */
	private String msgSource;

    /**
     * 业务类型
     */
	private String msgType;

    /**
     * 密文
     */
	private String dataDigest;

    /**
     *  消息体
     */
	private List<UmpDetail> umpDetails = new LinkedList<UmpDetail>();

	public Integer getSendType() {
		return sendType;
	}

	public void setSendType(Integer sendType) {
		this.sendType = sendType;
	}

	public String getMsgSource() {
		return msgSource;
	}

	public void setMsgSource(String msgSource) {
		this.msgSource = msgSource;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getDataDigest() {
		return dataDigest;
	}

	public void setDataDigest(String dataDigest) {
		this.dataDigest = dataDigest;
	}

	public List<UmpDetail> getUmpDetails() {
		return umpDetails;
	}

	public void setUmpDetails(List<UmpDetail> umpDetails) {
		this.umpDetails = umpDetails;
	}

	@Override
	public String toString() {
		return "ClientMessEntity [sendType=" + sendType + ", msgSource=" + msgSource + ", msgType=" + msgType
				+ ", dataDigest=" + dataDigest + ", umpDetails=" + umpDetails + "]";
	}

}

package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
/**
 * 工程勘测提交记录关系
 * @author 293888
 *
 */
public class ProcSurveySubmit implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private int id;
	
	/**
	 * 检查表Id
	 */
	private int checkId;
	
	/**
	 * 基础表
	 */
	private int msgId;
	/**
	 * 主键
	 * @return
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 检查表Id
	 * @return
	 */
	public int getCheckId() {
		return checkId;
	}

	public void setCheckId(int checkId) {
		this.checkId = checkId;
	}
	/**
	 * 基础表
	 * @return
	 */
	public int getMsgId() {
		return msgId;
	}

	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}
	
	
	
}

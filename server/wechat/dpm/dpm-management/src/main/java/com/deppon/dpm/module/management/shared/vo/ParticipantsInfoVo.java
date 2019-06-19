package com.deppon.dpm.module.management.shared.vo;

import java.io.Serializable;
/**
 * 封装报名者信息
 * @author 293888
 *
 */
public class ParticipantsInfoVo implements Serializable{

	/**
	 * 序列
	 */
	private static final long serialVersionUID = 1L;
	//报名者工号
	private String origNo;	
	//报名者姓名
	private String origName;
	//报名者电话
	private String origTel;
	/**
	 * 报名者工号
	 * @return
	 */
	public String getOrigNo() {
		return origNo;
	}

	public void setOrigNo(String origNo) {
		this.origNo = origNo;
	}
	/**
	 * 报名者姓名
	 * @return
	 */
	public String getOrigName() {
		return origName;
	}

	public void setOrigName(String origName) {
		this.origName = origName;
	}
	/**
	 * 报名者电话
	 * @return
	 */
	public String getOrigTel() {
		return origTel;
	}

	public void setOrigTel(String origTel) {
		this.origTel = origTel;
	}
	
	
}

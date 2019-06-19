package com.deppon.dpm.tongxunlu.shared.domain;

import java.io.Serializable;

/**
 * 页面展示实体类
 * 
 * @author 231586
 * 
 */
public class FeedBackHxRecordEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2155934502468325921L;

	/**
	 * 意见反馈id
	 */
	private int id;
	
	/**
	 * 工号
	 */
	private String empcode;
	
	/**
	 * 反馈内容
	 */
	private String content = "";
	
	/**
	 * 问题类型
	 */
	private String type = "";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpcode() {
		return empcode;
	}

	public void setEmpcode(String empcode) {
		this.empcode = empcode;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}

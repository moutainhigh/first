package com.deppon.dpm.doc.server.vo;

import java.io.Serializable;

/**
 * 推送消息VO
 * @author gwl
 *
 */

public class PushMessageVO implements Serializable {

	/**
	 * 构造方法
	 */
	public PushMessageVO(){ 
		super();
	}
	
	private static final long serialVersionUID = 1L;
	/*  主键	  */
	private Integer id ;
	/*  部门	  */
	private Integer dept ;
	/*	消息 	*/
	private String message ;
	/*  状态	  */
	private String state ;
	/*  时间	  */
	private String savetime ;
	/*  用户 编码	  */
	private String userid ;
	/*  消息title  */
	private String msgtitle ;
	
	//订单号
	private String billno;
	
	//异常违规
	private String abnormalrule;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the dept
	 */
	public Integer getDept() {
		return dept;
	}
	/**
	 * @param dept the dept to set
	 */
	public void setDept(Integer dept) {
		this.dept = dept;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the savetime
	 */
	public String getSavetime() {
		return savetime;
	}
	/**
	 * @param savetime the savetime to set
	 */
	public void setSavetime(String savetime) {
		this.savetime = savetime;
	}
	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * @return the msgtitle
	 */
	public String getMsgtitle() {
		return msgtitle;
	}
	/**
	 * @param msgtitle the msgtitle to set
	 */
	public void setMsgtitle(String msgtitle) {
		this.msgtitle = msgtitle;
	}
	public String getBillno() {
		return billno;
	}
	public void setBillno(String billno) {
		this.billno = billno;
	}
	public String getAbnormalrule() {
		return abnormalrule;
	}
	public void setAbnormalrule(String abnormalrule) {
		this.abnormalrule = abnormalrule;
	}
	
	
	
}

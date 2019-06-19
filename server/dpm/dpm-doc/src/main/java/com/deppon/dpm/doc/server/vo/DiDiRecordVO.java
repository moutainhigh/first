package com.deppon.dpm.doc.server.vo;

import java.io.Serializable;

/**
 * 备案记录表
 * @author 
 *
 */
public class DiDiRecordVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DiDiRecordVO(){
		super();
	}
	//备案人ID
	private String userId ;//
	//备案人
	private String userName ;
	//备案部门
	private String dept ;
	//用户头像
	private String userPic ;
	//备案时间
	private String recordtime ;
	//备案类型
	private String recordtype ;
	//打车时间
	private String taxidate ;
	//出发地
	private String fromName ;
	//目的地
	private String toName ;
	//金额
	private String amount ;
	//备案截图
	private String recordpic ;
	//备案状态0待审核1审核通过2不通过
	private String recordstate ;
	//批复意见
	private String comment ;
	//用车备注
	private String carremark;
	//用车是由
	private String remark;
	//主键
	private String id ;
	//图片拆分数组
	private String[] recordpicArray;
	
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the dept
	 */
	public String getDept() {
		return dept;
	}
	/**
	 * @param dept the dept to set
	 */
	public void setDept(String dept) {
		this.dept = dept;
	}
	/**
	 * @return the recordtime
	 */
	public String getRecordtime() {
		return recordtime;
	}
	/**
	 * @param recordtime the recordtime to set
	 */
	public void setRecordtime(String recordtime) {
		this.recordtime = recordtime;
	}
	/**
	 * @return the recordtype
	 */
	public String getRecordtype() {
		return recordtype;
	}
	/**
	 * @param recordtype the recordtype to set
	 */
	public void setRecordtype(String recordtype) {
		this.recordtype = recordtype;
	}
	/**
	 * @return the taxidate
	 */
	public String getTaxidate() {
		return taxidate;
	}
	/**
	 * @param taxidate the taxidate to set
	 */
	public void setTaxidate(String taxidate) {
		this.taxidate = taxidate;
	}
	/**
	 * @return the fromName
	 */
	public String getFromName() {
		return fromName;
	}
	/**
	 * @param fromName the fromName to set
	 */
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	/**
	 * @return the toName
	 */
	public String getToName() {
		return toName;
	}
	/**
	 * @param toName the toName to set
	 */
	public void setToName(String toName) {
		this.toName = toName;
	}
	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	/**
	 * @return the recordpic
	 */
	public String getRecordpic() {
		return recordpic;
	}
	/**
	 * @param recordpic the recordpic to set
	 */
	public void setRecordpic(String recordpic) {
		this.recordpic = recordpic;
	}
	/**
	 * @return the recordstate
	 */
	public String getRecordstate() {
		return recordstate;
	}
	/**
	 * @param recordstate the recordstate to set
	 */
	public void setRecordstate(String recordstate) {
		this.recordstate = recordstate;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the carremark
	 */
	public String getCarremark() {
		return carremark;
	}
	/**
	 * @param carremark the carremark to set
	 */
	public void setCarremark(String carremark) {
		this.carremark = carremark;
	}
	
	public String[] getRecordpicArray() {
		return recordpicArray;
	}
	public void setRecordpicArray(String[] recordpicArray) {
		this.recordpicArray = recordpicArray;
	}
	/**
	 * @return the userPic
	 */
	public String getUserPic() {
		return userPic;
	}
	/**
	 * @param userPic the userPic to set
	 */
	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
} 

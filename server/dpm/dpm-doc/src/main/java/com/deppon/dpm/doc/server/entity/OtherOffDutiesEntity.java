package com.deppon.dpm.doc.server.entity;

public class OtherOffDutiesEntity {
	/**
	 * 构造方法
	 */
	public OtherOffDutiesEntity(){
		super();
	}
	//主键
	private String id ;
	//用户ID
	private String userId ;//
	//用户姓名
	private String userName ;
	//所属部门
	private String dept ;
	//备案时间
	private String recordtime ;
	//用户头像
	private String userPic ;
	//订单号
	private String orderId;
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
	//审核状态（2因公，1因私,0未审核）
	private String recordstate ;
	//批复意见
	private String comment ;
	//用车备注（其他公务审核）
	private String carremark;
	//用车是由（其他公务）
	private String remark;
	//自定义项
	private String def1;
	//自定义项
	private String def2;
	//自定义项
	private String def3;
	//自定义项
	private String def4;
	//自定义项
	private String def5;
	//图片拆分数组
	private String[] recordpicArray;
	
	//直属上级工号
	private String leadernum;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @return the dept
	 */
	public String getDept() {
		return dept;
	}
	/**
	 * @return the recordtime
	 */
	public String getRecordtime() {
		return recordtime;
	}
	/**
	 * @return the userPic
	 */
	public String getUserPic() {
		return userPic;
	}
	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}
	/**
	 * @return the taxidate
	 */
	public String getTaxidate() {
		return taxidate;
	}
	/**
	 * @return the fromName
	 */
	public String getFromName() {
		return fromName;
	}
	/**
	 * @return the toName
	 */
	public String getToName() {
		return toName;
	}
	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}
	/**
	 * @return the recordpic
	 */
	public String getRecordpic() {
		return recordpic;
	}
	/**
	 * @return the recordstate
	 */
	public String getRecordstate() {
		return recordstate;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @return the carremark
	 */
	public String getCarremark() {
		return carremark;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @return the def1
	 */
	public String getDef1() {
		return def1;
	}
	/**
	 * @return the def2
	 */
	public String getDef2() {
		return def2;
	}
	/**
	 * @return the def3
	 */
	public String getDef3() {
		return def3;
	}
	/**
	 * @return the def4
	 */
	public String getDef4() {
		return def4;
	}
	/**
	 * @return the def5
	 */
	public String getDef5() {
		return def5;
	}
	/**
	 * @return the recordpicArray
	 */
	public String[] getRecordpicArray() {
		return recordpicArray;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @param dept the dept to set
	 */
	public void setDept(String dept) {
		this.dept = dept;
	}
	/**
	 * @param recordtime the recordtime to set
	 */
	public void setRecordtime(String recordtime) {
		this.recordtime = recordtime;
	}
	/**
	 * @param userPic the userPic to set
	 */
	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * @param taxidate the taxidate to set
	 */
	public void setTaxidate(String taxidate) {
		this.taxidate = taxidate;
	}
	/**
	 * @param fromName the fromName to set
	 */
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	/**
	 * @param toName the toName to set
	 */
	public void setToName(String toName) {
		this.toName = toName;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	/**
	 * @param recordpic the recordpic to set
	 */
	public void setRecordpic(String recordpic) {
		this.recordpic = recordpic;
	}
	/**
	 * @param recordstate the recordstate to set
	 */
	public void setRecordstate(String recordstate) {
		this.recordstate = recordstate;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * @param carremark the carremark to set
	 */
	public void setCarremark(String carremark) {
		this.carremark = carremark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @param def1 the def1 to set
	 */
	public void setDef1(String def1) {
		this.def1 = def1;
	}
	/**
	 * @param def2 the def2 to set
	 */
	public void setDef2(String def2) {
		this.def2 = def2;
	}
	/**
	 * @param def3 the def3 to set
	 */
	public void setDef3(String def3) {
		this.def3 = def3;
	}
	/**
	 * @param def4 the def4 to set
	 */
	public void setDef4(String def4) {
		this.def4 = def4;
	}
	/**
	 * @param def5 the def5 to set
	 */
	public void setDef5(String def5) {
		this.def5 = def5;
	}
	/**
	 * @param recordpicArray the recordpicArray to set
	 */
	public void setRecordpicArray(String[] recordpicArray) {
		this.recordpicArray = recordpicArray;
	}
	/**
	 * @return the leadernum
	 */
	public String getLeadernum() {
		return leadernum;
	}
	/**
	 * @param leadernum the leadernum to set
	 */
	public void setLeadernum(String leadernum) {
		this.leadernum = leadernum;
	}
	
}

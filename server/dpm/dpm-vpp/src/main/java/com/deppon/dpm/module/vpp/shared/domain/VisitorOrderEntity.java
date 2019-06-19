package com.deppon.dpm.module.vpp.shared.domain;

import java.util.List;


/**
 * 访客预约实体
 *  个人预约：
 *  {"type":"0","innerCode":"000001","innerName":"张三",
 *      "vlist":[{"visitorSex":0,"visitorName":"李四"}]}
	团队预约：
	{"type":"1","innerCode":"000001","innerName":"张三","company":"博慧佳有限公司","remark":"访客机会议,带一台访客机设备","thing":"1",
	  "visitorDate":"2017-04-18 10:30","vlist":[{"visitorSex":0,"visitorName":"李四"},{"visitorSex":0,"visitorName":"王五"}]}

 */
public class VisitorOrderEntity {
	/**
	 * 访客类型  0个人 1团队
	 */
	private String type;
	/**
	 * 被访人编号
	 */
	private String innerCode;
	/**
	 * 被访人姓名
	 */
	private String innerName;
	/**
	 * 访客单位
	 */
	private String company;
	/**
	 * 到访日期
	 */
	private String visitorDate;
	/**
	 * 事由  1会议、 2来访、 3送货、 4培训、 5入职、 6面试、 0其他
	 */
	private String thing;
	/**
	 * 其他信息
	 */
	private String remark;
	/**
	 * 访客信息
	 */
	private List<VisitorEntity> vlist;
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the innerCode
	 */
	public String getInnerCode() {
		return innerCode;
	}
	/**
	 * @param innerCode the innerCode to set
	 */
	public void setInnerCode(String innerCode) {
		this.innerCode = innerCode;
	}
	/**
	 * @return the innerName
	 */
	public String getInnerName() {
		return innerName;
	}
	/**
	 * @param innerName the innerName to set
	 */
	public void setInnerName(String innerName) {
		this.innerName = innerName;
	}
	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * @return the visitorDate
	 */
	public String getVisitorDate() {
		return visitorDate;
	}
	/**
	 * @param visitorDate the visitorDate to set
	 */
	public void setVisitorDate(String visitorDate) {
		this.visitorDate = visitorDate;
	}
	/**
	 * @return the thing
	 */
	public String getThing() {
		return thing;
	}
	/**
	 * @param thing the thing to set
	 */
	public void setThing(String thing) {
		this.thing = thing;
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
	/**
	 * @return the vlist
	 */
	public List<VisitorEntity> getVlist() {
		return vlist;
	}
	/**
	 * @param vlist the vlist to set
	 */
	public void setVlist(List<VisitorEntity> vlist) {
		this.vlist = vlist;
	}
	
}

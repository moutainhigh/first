package com.deppon.dpm.store.server.entity;

import java.math.BigDecimal;
import java.util.List;

/**
 * 查询考评详情实体类
 * 
 * @author RY
 * @date 2018年6月5日11:40:43
 */
public class QueryAppraisal {
	// 模块id
	private Integer modid;
	// 得分
	private BigDecimal grade;
	// 说明
	private String markinfo;
	// 图片地址
	private String photo;
	//反馈内容
	private String feedbackinfo;
	//反馈图片
	private String picpath;
	//反馈图片数组
	private List<String> piclist;
	//模块名称
	private String modname;
	//模块说明
	private String modinfo;
	//二级模块名称
	private String secondmodname;
	/**
	 * 
	 * @return
	 */
	public List<String> getPiclist() {
		return piclist;
	}
	/**
	 * 
	 * @param piclist
	 */
	public void setPiclist(List<String> piclist) {
		this.piclist = piclist;
	}
	/**
	 * 
	 * @return
	 */
	public String getFeedbackinfo() {
		return feedbackinfo;
	}
	/**
	 * 
	 * @param feedbackinfo
	 */
	public void setFeedbackinfo(String feedbackinfo) {
		this.feedbackinfo = feedbackinfo;
	}
	/**
	 * 
	 * @return
	 */
	public String getPicpath() {
		return picpath;
	}
	/**
	 * 
	 * @param picpath
	 */
	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
	/**
	 * 
	 * @return
	 */

	public BigDecimal getGrade() {
		return grade;
	}
	/**
	 * 
	 * @param grade
	 */
	public void setGrade(BigDecimal grade) {
		this.grade = grade;
	}
	/**
	 * 
	 * @return
	 */
	public String getMarkinfo() {
		return markinfo;
	}

	/**
	 * 
	 * @param markinfo
	 */
	public void setMarkinfo(String markinfo) {
		this.markinfo = markinfo;
	}

	/**
	 * 
	 * @return
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * 
	 * @param photo
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	/**
	 * 
	 * @return
	 */
	public String getModname() {
		return modname;
	}
	/**
	 * 
	 * @param modname
	 */
	public void setModname(String modname) {
		this.modname = modname;
	}
	/**
	 * 
	 * @return
	 */
	public String getModinfo() {
		return modinfo;
	}
	/**
	 * 
	 * @param modinfo
	 */
	public void setModinfo(String modinfo) {
		this.modinfo = modinfo;
	}
	/**
	 * 
	 * @return
	 */
	public Integer getModid() {
		return modid;
	}
	/**
	 * 
	 * @param modid
	 */
	public void setModid(Integer modid) {
		this.modid = modid;
	}
	/**
	 * 
	 * @return
	 */
	public String getSecondmodname() {
		return secondmodname;
	}
	/**
	 * 
	 * @param secondmodname
	 */
	public void setSecondmodname(String secondmodname) {
		this.secondmodname = secondmodname;
	}
}

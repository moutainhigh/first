package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
/**
 * 工程勘测图片
 * @author 293888
 *
 */
public class ProcSurveyPhoto implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	private String id;
	
	/**
	 * 检查id
	 */
	private String checkId;
	
	/**
	 * 创建时间
	 */
	private String createDate;
	
	/**
	 * 创建人
	 */
	private String createNo;
	
	/**
	 * 是否达到开点要求
	 * 0,达到，1未达到
	 */
	private String mark;
	
	/**
	 * 备注
	 */
	private String note;
	
	/**
	 * 图片1
	 */
	private String photo1;
	
	/**
	 * 图片2
	 */
	private String photo2;
	
	/**
	 * 图片3
	 */
	private String photo3;
	
	/**
	 * 图片4
	 */
	private String photo4;
	
	/**
	 * 图片5
	 */
	private String photo5;

	/**
	 * 主键id
	 * @return
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 检查表id
	 * @return
	 */
	public String getCheckId() {
		return checkId;
	}
	
	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}
	/**
	 * 创建时间
	 * @return
	 */
	public String getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	/**
	 * 创建人 
	 * @return
	 */
	public String getCreateNo() {
		return createNo;
	}

	public void setCreateNo(String createNo) {
		this.createNo = createNo;
	}
	/**
	 * 是否达到开点要求
	 * @return
	 */
	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}
	/**
	 * 备注
	 * @return
	 */
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * 图片1
	 * @return
	 */
	public String getPhoto1() {
		return photo1;
	}

	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}
	/**
	 * 图片2
	 * @return
	 */
	public String getPhoto2() {
		return photo2;
	}

	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}
	/**
	 * 图片3
	 * @return
	 */
	public String getPhoto3() {
		return photo3;
	}

	public void setPhoto3(String photo3) {
		this.photo3 = photo3;
	}
	/**
	 * 图片4
	 * @return
	 */
	public String getPhoto4() {
		return photo4;
	}

	public void setPhoto4(String photo4) {
		this.photo4 = photo4;
	}
	/**
	 * 图片5
	 * @return
	 */
	public String getPhoto5() {
		return photo5;
	}

	public void setPhoto5(String photo5) {
		this.photo5 = photo5;
	}
	
	
}

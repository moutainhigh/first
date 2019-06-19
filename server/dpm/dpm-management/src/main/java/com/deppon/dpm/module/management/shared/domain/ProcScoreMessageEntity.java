package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;

/**
 * 评分详细表
 * 
 * @author Administrator
 * 
 */
public class ProcScoreMessageEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 评分详细表
	 */
	private String id;

	/**
	 * 工程打分id
	 */
	private String userScoreid;

	/**
	 * 照片1
	 */
	private String photo;

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
	 * 扣分项目(可多选)
	 */
	private String damageReason;

	/**
	 * 损坏原因
	 */
	private String deductSproject;

	/**
	 * 维修事项(可多选)
	 */
	private String serviceItems;

	/* set和get方法 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            主键id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return 工程打分id
	 */
	public String getUserScoreid() {
		return userScoreid;
	}

	/**
	 * @param userScoreid
	 *            工程打分id
	 */
	public void setUserScoreid(String userScoreid) {
		this.userScoreid = userScoreid;
	}

	/**
	 * @return 照片1
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo
	 *            照片1
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return 照片2
	 */
	public String getPhoto2() {
		return photo2;
	}

	/**
	 * @param photo2
	 *            照片2
	 */
	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}

	/**
	 * @return 照片3
	 */
	public String getPhoto3() {
		return photo3;
	}

	/**
	 * @param photo3
	 *            照片3
	 */
	public void setPhoto3(String photo3) {
		this.photo3 = photo3;
	}

	/**
	 * @return 照片4
	 */
	public String getPhoto4() {
		return photo4;
	}

	/**
	 * @param photo4
	 *            照片4
	 */
	public void setPhoto4(String photo4) {
		this.photo4 = photo4;
	}

	/**
	 * @return 照片5
	 */
	public String getPhoto5() {
		return photo5;
	}

	/**
	 * @param photo5
	 *            照片5
	 */
	public void setPhoto5(String photo5) {
		this.photo5 = photo5;
	}

	/**
	 * @return 扣分项目(可多选)
	 */
	public String getDamageReason() {
		return damageReason;
	}

	/**
	 * @param damageReason
	 *            扣分项目(可多选)
	 */
	public void setDamageReason(String damageReason) {
		this.damageReason = damageReason;
	}

	/**
	 * @return 损坏原因
	 */
	public String getDeductSproject() {
		return deductSproject;
	}

	/**
	 * @param deductSproject
	 *            损坏原因
	 */
	public void setDeductSproject(String deductSproject) {
		this.deductSproject = deductSproject;
	}

	/**
	 * @return 维修事项(可多选)
	 */
	public String getServiceItems() {
		return serviceItems;
	}

	/**
	 * @param serviceItems
	 *            维修事项(可多选)
	 */
	public void setServiceItems(String serviceItems) {
		this.serviceItems = serviceItems;
	}

}

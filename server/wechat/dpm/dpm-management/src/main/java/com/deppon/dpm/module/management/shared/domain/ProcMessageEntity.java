package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;

/**
 *  评分详细表 实时数据
 * @author 袁中华
 * @date 2015.7.15
 */
public class ProcMessageEntity implements Serializable{
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 评分详细表ID
	 */
	private String id;
	/**
	 * 工程打分ID
	 */
	private String userScoreid;
	
	/**
	 * @return 图片
	 */
	public String getPhoto2() {
		return photo2;
	}
	/**
	 * @param photo2 图片
	 */
	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}
	/**
	 * @return 图片
	 */
	public String getPhoto3() {
		return photo3;
	}
	/**
	 * @param photo3 图片
	 */
	public void setPhoto3(String photo3) {
		this.photo3 = photo3;
	}
	/**
	 * @return 图片
	 */
	public String getPhoto4() {
		return photo4;
	}
	/**
	 * @param photo4 图片
	 */
	public void setPhoto4(String photo4) {
		this.photo4 = photo4;
	}
	/**
	 * @return 图片
	 */
	public String getPhoto5() {
		return photo5;
	}
	/**
	 * @param photo5 图片
	 */
	public void setPhoto5(String photo5) {
		this.photo5 = photo5;
	}
	/**
	 * @return 损坏原因
	 */
	public String getDamageReason() {
		return damageReason;
	}
	/**
	 * @param damageReason 损坏原因
	 */
	public void setDamageReason(String damageReason) {
		this.damageReason = damageReason;
	}
	/**
	 * @return  扣分项目
	 */
	public String getDeductSProject() {
		return deductSProject;
	}
	/**
	 * @param deductSProject  扣分项目
	 */
	public void setDeductSProject(String deductSProject) {
		this.deductSProject = deductSProject;
	}
	/**
	 * @return 维修事项
	 */
	public String getServiceItems() {
		return serviceItems;
	}
	/**
	 * @param serviceItems 维修事项
	 */
	public void setServiceItems(String serviceItems) {
		this.serviceItems = serviceItems;
	}
	/**
	 * 图片
	 */
	private String photo;
	/**
	 * 图片
	 */
	private String photo2;
	/**
	 * 图片
	 */
	private String photo3;
	/**
	 *  图片
	 */
	private String photo4;
	/**
	 * 图片
	 */
	private String photo5;
	/**
	 * 损坏原因
	 */
	private String damageReason;
	/**
	 * 扣分项目
	 */
	private String deductSProject;
	/**
	 * 维修事项
	 */
	private String serviceItems;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserScoreid() {
		return userScoreid;
	}
	public void setUserScoreid(String userScoreid) {
		this.userScoreid = userScoreid;
	}

	/**
	 * @return 维修事项
	 */
	public String getPhoto() {
		return photo;
	}
	/**
	 * @param photo 维修事项
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

}

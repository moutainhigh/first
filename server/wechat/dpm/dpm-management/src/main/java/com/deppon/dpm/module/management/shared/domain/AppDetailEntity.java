package com.deppon.dpm.module.management.shared.domain;
/**
 * 应用详情实体类
 * 
 * @author 491275
 *
 */
public class AppDetailEntity {
	
	/**
	 * 应用详情id
	 */
	private int id;
	/**
	 * 应用商店对应id
	 */
	private int appstoreId;
	/**
	 * 应用名称
	 */
	private String appName;
	/**
	 * 应用介绍
	 */
	private String appIntroduce;
	/**
	 * 详细信息
	 */
	private String detailMessage;
	/**
	 * APP图片
	 */
	private String appPhoto;
	/**
	 * 评论数
	 */
	private int commentCount;
	/**
	 * 总评分
	 */
	private Double totalScore;
	/**
	 * 新特性
	 */
	private String newFeature;

	/**
	 * 下载数
	 */
	private int downloadCount;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAppstoreId() {
		return appstoreId;
	}
	public void setAppstoreId(int appstoreId) {
		this.appstoreId = appstoreId;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppIntroduce() {
		return appIntroduce;
	}
	public void setAppIntroduce(String appIntroduce) {
		this.appIntroduce = appIntroduce;
	}
	public String getDetailMessage() {
		return detailMessage;
	}
	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}
	public String getAppPhoto() {
		return appPhoto;
	}
	public void setAppPhoto(String appPhoto) {
		this.appPhoto = appPhoto;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public Double getTotalScope() {
		return totalScore;
	}
	public void setTotalScope(Double totalScore) {
		this.totalScore = totalScore;
	}
	public int getDownloadCount() {
		return downloadCount;
	}
	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}
	public String getNewFeature() {
		return newFeature;
	}
	public void setNewFeature(String newFeature) {
		this.newFeature = newFeature;
	}
	@Override
	public String toString() {
		return "AppDetailEntity [id=" + id + ", appstoreId=" + appstoreId
				+ ", appName=" + appName + ", appIntroduce=" + appIntroduce
				+ ", detailMessage=" + detailMessage + ", appPhoto=" + appPhoto
				+ ", commentCount=" + commentCount + ", totalScope="
				+ totalScore + ", newFeature=" + newFeature
				+ ", downloadCount=" + downloadCount + "]";
	}
}

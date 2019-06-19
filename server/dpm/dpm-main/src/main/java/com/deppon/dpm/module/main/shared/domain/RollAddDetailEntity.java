package com.deppon.dpm.module.main.shared.domain;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
/**
 * 广告详情表
 * @author 500612
 *
 */
public class RollAddDetailEntity {

	// 广告id
	private int id;
	// 广告标题
	private String adTitle;
	// 广告内容
	private String adContent;
	// 组织
	private String adOrgName;
	// 公众号类型
	private String appType;
	// 广告图片
	private String adPhoto;
	// 正文图片
	private List<ImageUrl> contentImages;
	// 正文图片String
	private String contentImage;
	// 广告视频
	private String videoUrl;
	// 正文图片
	private List<VideoUrl> videosUrls;
	
	// 视频缩悦图
	private String videoImage;
	// 视频缩悦图String
	private List<ImageUrl> videoImages;
	//tiaozhundizhi 
	private String extraLink;
	//是否外部链接 
	private int isExtraLink;
	//是否有帮帮权限 
	private Boolean hasBBBPermission;

	// 创建时间
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	// 更新时间
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	
	// 创建时间
	private String startTime;
    
	
	public Boolean getHasBBBPermission() {
		return hasBBBPermission;
	}


	public void setHasBBBPermission(Boolean hasBBBPermission) {
		this.hasBBBPermission = hasBBBPermission;
	}


	public int getIsExtraLink() {
		return isExtraLink;
	}


	public void setIsExtraLink(int isExtraLink) {
		this.isExtraLink = isExtraLink;
	}


	public String getExtraLink() {
		return extraLink;
	}


	public void setExtraLink(String extraLink) {
		this.extraLink = extraLink;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAdTitle() {
		return adTitle;
	}


	public void setAdTitle(String adTitle) {
		this.adTitle = adTitle;
	}


	public String getAdContent() {
		return adContent;
	}


	public void setAdContent(String adContent) {
		this.adContent = adContent;
	}


	public String getAdOrgName() {
		return adOrgName;
	}


	public void setAdOrgName(String adOrgName) {
		this.adOrgName = adOrgName;
	}


	public String getAdPhoto() {
		return adPhoto;
	}


	public void setAdPhoto(String adPhoto) {
		this.adPhoto = adPhoto;
	}


	public List<ImageUrl> getContentImages() {
		return contentImages;
	}


	public void setContentImages(List<ImageUrl> contentImages) {
		this.contentImages = contentImages;
	}


	public String getContentImage() {
		return contentImage;
	}


	public void setContentImage(String contentImage) {
		this.contentImage = contentImage;
	}

	public String getVideoUrl() {
		return videoUrl;
	}


	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public List<VideoUrl> getVideosUrls() {
		return videosUrls;
	}

	public void setVideosUrls(List<VideoUrl> videosUrls) {
		this.videosUrls = videosUrls;
	}

	public String getVideoImage() {
		return videoImage;
	}

	public void setVideoImage(String videoImage) {
		this.videoImage = videoImage;
	}

	public List<ImageUrl> getVideoImages() {
		return videoImages;
	}

	public void setVideoImages(List<ImageUrl> videoImages) {
		this.videoImages = videoImages;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getAppType() {
		return appType;
	}


	public void setAppType(String appType) {
		this.appType = appType;
	}

	@Override
	public String toString() {
		return "RollAddDetailEntity [id=" + id + ", adTitle=" + adTitle
				+ ", adContent=" + adContent + ", adOrgName=" + adOrgName
				+ ", appType=" + appType + ", adPhoto=" + adPhoto
				+ ", contentImages=" + contentImages + ", contentImage="
				+ contentImage + ", videoUrl=" + videoUrl + ", videosUrls="
				+ videosUrls + ", videoImage=" + videoImage + ", videoImages="
				+ videoImages + ", extraLink=" + extraLink + ", isExtraLink="
				+ isExtraLink + ", hasBBBPermission=" + hasBBBPermission
				+ ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", startTime=" + startTime + "]";
	}


	
}

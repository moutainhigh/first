/**
 * 
 */
package com.deppon.dpm.module.common.server.service.impl;

/**
 * @author zzwjrl
 * @since 2015-03-25 统一获取图像存储地址
 */
public class PhotoAddressService {
	/**
	 * 通讯录头像
	 */
	private String headPortraitAddress;
	/**
	 * 任务图片
	 */
	private String taskPhotoAddress;
	/**
	 * 意见反馈地址
	 */
	private String feedBackAddress;
	/**
	 * 配置页地址
	 */
	private String welcomeAddress;

	/**
	 * 磁盘上的ip和端口
	 */
	private String serverHostPort;
	/**
	 * 应用详情地址
	 */
	private String appDetailAddress;

	/**
	 * get
	 * 
	 * @return
	 */
	public String getHeadPortraitAddress() {
		return headPortraitAddress;
	}

	/**
	 * set
	 * 
	 * @param headPortraitAddress
	 */
	public void setHeadPortraitAddress(String headPortraitAddress) {
		this.headPortraitAddress = headPortraitAddress;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getTaskPhotoAddress() {
		return taskPhotoAddress;
	}

	/**
	 * set
	 * 
	 * @param taskPhotoAddress
	 */
	public void setTaskPhotoAddress(String taskPhotoAddress) {
		this.taskPhotoAddress = taskPhotoAddress;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getFeedBackAddress() {
		return feedBackAddress;
	}

	/**
	 * set
	 * 
	 * @param feedBackAddress
	 */
	public void setFeedBackAddress(String feedBackAddress) {
		this.feedBackAddress = feedBackAddress;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getWelcomeAddress() {
		return welcomeAddress;
	}

	/**
	 * set
	 * 
	 * @param welcomeAddress
	 */
	public void setWelcomeAddress(String welcomeAddress) {
		this.welcomeAddress = welcomeAddress;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getServerHostPort() {
		return serverHostPort;
	}

	/**
	 * set
	 * 
	 * @param serverHostPort
	 */
	public void setServerHostPort(String serverHostPort) {
		this.serverHostPort = serverHostPort;
	}
    /**
     * get
     * @return
     */
	public String getAppDetailAddress() {
		return appDetailAddress;
	}
    /**
     * set
     * @param appDetailAddress
     */
	public void setAppDetailAddress(String appDetailAddress) {
		this.appDetailAddress = appDetailAddress;
	}

}

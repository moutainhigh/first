package com.deppon.dpm.module.common.shared.vo;

import java.io.File;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.shared.domain.AppAutoRefreshControlEntity;

/**
 * 应用商店实体
 */
public class ApplyStore {

	/**
	 * 
	 * 1 邮箱 2 固定资产 3 IT服务台 4 班车 5 日程 6 差旅助手 7 运营安全 8 人才选拔 9 移动crm 10 项目管理工具 11
	 * 工程巡检 12 快递可视化EXPRESS_VISUALIZE 13我的工资 14工程管理 PROJECT_MANAGE
	 * 
	 * 有三个固定的（请审批，BI，德邦e站）不在商店展示
	 * 
	 */
	/**
	 * 对应的数据库apply_stroe的id
	 */
	private int appId;
	
	/**
	 * 应用状态 on/off
	 */
	private String status;
	
	/**
	 * 是否对合伙人开放
	 */
	private Boolean partnerPermission;

	/**
	 * 下载数量
	 */
	private int count;
	
	/**
	 * 应用大小
	 */
	private String size;
	
	/**
	 * 是否自动更新
	 */
	private Boolean autoUpdate;

	/**
	 * 有没有下载
	 */
	private boolean open = false;

	/**
	 * 应用状态，1：未安装；2：已安装；3：更新
	 */
	private int appType = 1;

	/**
	 * 英文名称
	 */
	private String enName;

	/**
	 * 中文名称
	 */
	private String cnName;

	/**
	 * 简介
	 */
	private String summary;

	/**
	 * 是否显示new
	 */
	@SuppressWarnings("unused")
	private String displayNew;

	/**
	 * 创建时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
	 * 是否属于应用商店应用，0：不是，1：是
	 */
	private String defaultApp;

	/**
	 * 是否需要更新资源，0：不需要，1：需要
	 */
	private String hasResources;

	/**
	 * APP应用对应最新版本号
	 */
	private String versionType;

	/**
	 * app内容提要
	 */
	private String appContent;

	/**
	 * app图片 多个附件以@AS@P分割
	 */
	private String appFile;
	
	/**
	 * app图片数组
	 * 为前台使用
	 */
	private List<String> appFileList;

	/**
	 * app星级
	 */
	private String appStars;

	/**
	 * 评论人数
	 */
	private String appraiseCount;

	/**
	 * 应用评论列表
	 */
	private List<ApplyStoreAppraise> appraiseList;

	/**
	 * 用户评论应用次数
	 */
	private String appraiseNum;

	/**
	 * 应用图片 pc端上传使用
	 */
	private File appFile1;
	/**
	 * 应用图片名称 pc端上传使用
	 */
	private String appFile1FileName;
	/**
	 * 应用图片 pc端上传使用
	 */
	private File appFile2;
	/**
	 * 应用图片名称 pc端上传使用
	 */
	private String appFile2FileName;
	/**
	 * 应用图片 pc端上传使用
	 */
	private File appFile3;
	/**
	 * 应用图片名称 pc端上传使用
	 */
	private String appFile3FileName;
	/**
	 * 应用图片Url pc端展示使用
	 */
	private String appFileUrl1;
	/**
	 * 应用图片Url pc端展示使用
	 */
	private String appFileUrl2;
	/**
	 * 应用图片Url pc端展示使用
	 */
	private String appFileUrl3;
	/**
	 * 应用默认排序
	 */
	private Integer appOrder;
	/**
	 * 应用上线的ios版本
	 */
	private String iosAppVersion;
	/**
	 * 应用上线的android版本
	 */
	private String androidAppVersion;
	
	/***自动更新控制***/
	private List<AppAutoRefreshControlEntity>  appAutoRefreshControlList;
	
	/**
	 * 应用下载地址
	 */
	private String downloadUrl;
	
	/**
	 * 应用下载地址来源 0：后台  1：天畅
	 */
	private int downloadLine;
	
	/**
	 * get
	 * 
	 * @return
	 */
	public int getAppId() {
		return appId;
	}

	/**
	 * set
	 * 
	 * @param appId
	 */
	public void setAppId(int appId) {
		this.appId = appId;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getCount() {
		return count;
	}

	/**
	 * set
	 * 
	 * @param count
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * is
	 * 
	 * @return
	 */
	public boolean isOpen() {
		return open;
	}

	/**
	 * set
	 * 
	 * @param open
	 */
	public void setOpen(boolean open) {
		this.open = open;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getEnName() {
		return enName;
	}

	/**
	 * set
	 * 
	 * @param enName
	 */
	public void setEnName(String enName) {
		this.enName = enName;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getCnName() {
		return cnName;
	}

	/**
	 * set
	 * 
	 * @param cnName
	 */
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * set
	 * 
	 * @param summary
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * 七天之内显示新
	 * 
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * set
	 * 
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getDisplayNew() {
		if (createTime == null) {
			return "false";
		}
		boolean flag = new Date().getTime() - createTime.getTime() > MagicNumber.NUM7 * MagicNumber.NUM24 * MagicNumber.NUM3600 * MagicNumber.NUM1000;
		return flag ? "false" : "true";
	}

	/**
	 * set
	 * 
	 * @param displayNew
	 */
	public void setDisplayNew(String displayNew) {
		this.displayNew = displayNew;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getVersionType() {
		return versionType;
	}

	/**
	 * set
	 * 
	 * @param versionType
	 */
	public void setVersionType(String versionType) {
		this.versionType = versionType;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getAppType() {
		return appType;
	}

	/**
	 * set
	 * 
	 * @param appType
	 */
	public void setAppType(int appType) {
		this.appType = appType;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getDefaultApp() {
		return defaultApp;
	}

	/**
	 * set
	 * 
	 * @param defaultApp
	 */
	public void setDefaultApp(String defaultApp) {
		this.defaultApp = defaultApp;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getHasResources() {
		return hasResources;
	}

	/**
	 * set
	 * 
	 * @param hasResources
	 */
	public void setHasResources(String hasResources) {
		this.hasResources = hasResources;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getAppContent() {
		return appContent;
	}

	/**
	 * set
	 * 
	 * @param appContent
	 */
	public void setAppContent(String appContent) {
		this.appContent = appContent;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getAppFile() {
		return appFile;
	}

	/**
	 * set
	 * 
	 * @param appFile
	 */
	public void setAppFile(String appFile) {
		this.appFile = appFile;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getAppStars() {
		return appStars;
	}

	/**
	 * set
	 * 
	 * @param appStars
	 */
	public void setAppStars(String appStars) {
		this.appStars = appStars;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getAppraiseCount() {
		return appraiseCount;
	}

	/**
	 * set
	 * 
	 * @param appraiseCount
	 */
	public void setAppraiseCount(String appraiseCount) {
		this.appraiseCount = appraiseCount;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public List<ApplyStoreAppraise> getAppraiseList() {
		return appraiseList;
	}

	/**
	 * set
	 * 
	 * @param appraiseList
	 */
	public void setAppraiseList(List<ApplyStoreAppraise> appraiseList) {
		this.appraiseList = appraiseList;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getAppraiseNum() {
		return appraiseNum;
	}

	/**
	 * set
	 * 
	 * @param appraiseNum
	 */
	public void setAppraiseNum(String appraiseNum) {
		this.appraiseNum = appraiseNum;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public File getAppFile1() {
		return appFile1;
	}

	/**
	 * set
	 * 
	 * @param appFile1
	 */
	public void setAppFile1(File appFile1) {
		this.appFile1 = appFile1;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public File getAppFile2() {
		return appFile2;
	}

	/**
	 * set
	 * 
	 * @param appFile2
	 */
	public void setAppFile2(File appFile2) {
		this.appFile2 = appFile2;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public File getAppFile3() {
		return appFile3;
	}

	/**
	 * set
	 * 
	 * @param appFile3
	 */
	public void setAppFile3(File appFile3) {
		this.appFile3 = appFile3;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getAppFileUrl1() {
		return appFileUrl1;
	}

	/**
	 * set
	 * 
	 * @param appFileUrl1
	 */
	public void setAppFileUrl1(String appFileUrl1) {
		this.appFileUrl1 = appFileUrl1;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getAppFileUrl2() {
		return appFileUrl2;
	}

	/**
	 * set
	 * 
	 * @param appFileUrl2
	 */
	public void setAppFileUrl2(String appFileUrl2) {
		this.appFileUrl2 = appFileUrl2;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getAppFileUrl3() {
		return appFileUrl3;
	}

	/**
	 * set
	 * 
	 * @param appFileUrl3
	 */
	public void setAppFileUrl3(String appFileUrl3) {
		this.appFileUrl3 = appFileUrl3;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getAppFile1FileName() {
		return appFile1FileName;
	}

	/**
	 * set
	 * 
	 * @param appFile1FileName
	 */
	public void setAppFile1FileName(String appFile1FileName) {
		this.appFile1FileName = appFile1FileName;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getAppFile2FileName() {
		return appFile2FileName;
	}

	/**
	 * set
	 * 
	 * @param appFile2FileName
	 */
	public void setAppFile2FileName(String appFile2FileName) {
		this.appFile2FileName = appFile2FileName;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getAppFile3FileName() {
		return appFile3FileName;
	}

	/**
	 * set
	 * 
	 * @param appFile3FileName
	 */
	public void setAppFile3FileName(String appFile3FileName) {
		this.appFile3FileName = appFile3FileName;
	}

	/**
	 * get
	 * @return
	 */
	public List<String> getAppFileList() {
		return appFileList;
	}

	/**
	 * set
	 * @param appFileList
	 */
	public void setAppFileList(List<String> appFileList) {
		this.appFileList = appFileList;
	}

	/**
	 * getter
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * setter
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * getter
	 */
	public Boolean getPartnerPermission() {
		return partnerPermission;
	}

	/**
	 * setter
	 */
	public void setPartnerPermission(Boolean partnerPermission) {
		this.partnerPermission = partnerPermission;
	}

	/**
	 * getter
	 */
	public String getSize() {
		return size;
	}

	/**
	 * setter
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * getter
	 */
	public Boolean getAutoUpdate() {
		return autoUpdate;
	}

	/**
	 * setter
	 */
	public void setAutoUpdate(Boolean autoUpdate) {
		this.autoUpdate = autoUpdate;
	}

	/**
	 * getter
	 */
	public Integer getAppOrder() {
		return appOrder;
	}

	/**
	 * setter
	 */
	public void setAppOrder(Integer appOrder) {
		this.appOrder = appOrder;
	}

	public String getIosAppVersion() {
		return iosAppVersion;
	}

	public void setIosAppVersion(String iosAppVersion) {
		this.iosAppVersion = iosAppVersion;
	}

	public String getAndroidAppVersion() {
		return androidAppVersion;
	}

	public void setAndroidAppVersion(String androidAppVersion) {
		this.androidAppVersion = androidAppVersion;
	}
	
	public List<AppAutoRefreshControlEntity> getAppAutoRefreshControlList() {
		return appAutoRefreshControlList;
	}

	public void setAppAutoRefreshControlList(
			List<AppAutoRefreshControlEntity> appAutoRefreshControlList) {
		this.appAutoRefreshControlList = appAutoRefreshControlList;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public int getDownloadLine() {
		return downloadLine;
	}

	public void setDownloadLine(int downloadLine) {
		this.downloadLine = downloadLine;
	}
	
}

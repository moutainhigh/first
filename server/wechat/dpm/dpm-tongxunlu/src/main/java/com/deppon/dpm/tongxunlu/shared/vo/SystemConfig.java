package com.deppon.dpm.tongxunlu.shared.vo;

/**
 * 系统版本确认
 */
public class SystemConfig {
	/**
	 * 安卓版本
	 */
	private String androidVersion;
	/**
	 * 苹果版本
	 */
	private String iphoneVersion;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 是否强制更新
	 */
	private String iphoneForce;
	/**
	 * 是否强制更新
	 */
	private String androidForce;
	/**
	 * 安卓更新地址
	 */
	private String androidUrl;
	/**
	 * iphone更新地址
	 */
	private String iphoneUrl;
	/**
	 * 最近一次同步时间
	 */
	private String lastsyndate;
	/**
	 * 是否同步成功
	 */
	private String synSuccessed;
	/**
	 * 主键ID
	 */
	private int id;

	/**
	 * get
	 * 
	 * @return
	 */
	public String getIphoneForce() {
		return iphoneForce;
	}

	/**
	 * set
	 * 
	 * @param iphoneForce
	 */
	public void setIphoneForce(String iphoneForce) {
		this.iphoneForce = iphoneForce;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getAndroidForce() {
		return androidForce;
	}

	/**
	 * set
	 * 
	 * @param androidForce
	 */
	public void setAndroidForce(String androidForce) {
		this.androidForce = androidForce;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getContent() {
		return content;
	}

	/**
	 * set
	 * 
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getAndroidVersion() {
		return androidVersion;
	}

	/**
	 * set
	 * 
	 * @param androidVersion
	 */
	public void setAndroidVersion(String androidVersion) {
		this.androidVersion = androidVersion;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getIphoneVersion() {
		return iphoneVersion;
	}

	/**
	 * set
	 * 
	 * @param iphoneVersion
	 */
	public void setIphoneVersion(String iphoneVersion) {
		this.iphoneVersion = iphoneVersion;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getAndroidUrl() {
		return androidUrl;
	}

	/**
	 * set
	 * 
	 * @param androidUrl
	 */
	public void setAndroidUrl(String androidUrl) {
		this.androidUrl = androidUrl;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getIphoneUrl() {
		return iphoneUrl;
	}

	/**
	 * set
	 * 
	 * @param iphoneUrl
	 */
	public void setIphoneUrl(String iphoneUrl) {
		this.iphoneUrl = iphoneUrl;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getLastsyndate() {
		return lastsyndate;
	}

	/**
	 * set
	 * 
	 * @param lastsyndate
	 */
	public void setLastsyndate(String lastsyndate) {
		this.lastsyndate = lastsyndate;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getSynSuccessed() {
		return synSuccessed;
	}

	/**
	 * set
	 * 
	 * @param synSuccessed
	 */
	public void setSynSuccessed(String synSuccessed) {
		this.synSuccessed = synSuccessed;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * set
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
}

package com.deppon.dpm.uums.server.domain;

import java.io.Serializable;
import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 角色entity对象
 * 
 */
public class VersionEntity extends BaseEntity implements Serializable {
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = -3967231350438328890L;
	/**
	 * id
	 */
	private int vid;
	/**
	 * 版本
	 */
	private String version;
	/**
	 * 版本对应更新url
	 */
	private String url;
	/**
	 * 系统名称
	 */
	private String appName;
	/**
	 * 更新内容
	 */
	private String content;
	/**
	 * 是否强制
	 */
	private String rforce;
	/**
	 * 设备类型
	 */
	private String osType;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * get
	 * 
	 * @return
	 */
	public int getVid() {
		return vid;
	}

	/**
	 * set
	 * 
	 * @param vid
	 */
	public void setVid(int vid) {
		this.vid = vid;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * set
	 * 
	 * @param version
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * set
	 * 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getAppName() {
		return appName;
	}
	
	/**
	 * setter
	 * @param appName
	 */
	public void setAppName(String appName) {
		this.appName = appName;
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
	public String getRforce() {
		return rforce;
	}

	/**
	 * set
	 * 
	 * @param rforce
	 */
	public void setRforce(String rforce) {
		this.rforce = rforce;
	}

	/**
	 * set
	 * 
	 * @return
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * getter
	 * @return
	 */
	public String getOsType() {
		return osType;
	}

	/**
	 * setter
	 * @param osType
	 */
	public void setOsType(String osType) {
		this.osType = osType;
	}

	/**
	 * getter
	 * @return
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * setter
	 * @param updateTime
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
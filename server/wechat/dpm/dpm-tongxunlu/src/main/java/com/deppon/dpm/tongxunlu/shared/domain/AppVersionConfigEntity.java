/**
 * 
 */
package com.deppon.dpm.tongxunlu.shared.domain;

import java.util.Date;

/** 
 * @ClassName: AppVersionConfigEntity 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author yuyongxiang-134019-yuyongxiang@deppon.com
 * @date 2014年8月12日 下午5:11:01 
 *  
 */
public class AppVersionConfigEntity {
	/**
	 * 主键(自增长)
	 */
	private Integer id;
	/**
	 * 版本号
	 */
	private String version;
	/**
	 * 下载地址
	 */
	private String url;
	/**
	 * 项目名称
	 */
	private String appName;
	/**
	 * 升级了哪些内容
	 */
	private String content;
	/**
	 * 是否强制更新 0 :否 1:是,默认0
	 */
	private String force;
	/**
	 * APP的操作系统
	 */
	private String OsType;
	/**
	 * 当前数据的更新时间(或者创建时间)
	 * PS: 当前字段不建议自动设置值,本字段会自动根据sql语句的执行状态自动修改数据的时间
	 */
	private Date updateTime;
	/** 
	 * @return id 
	 */
	public Integer getId() {
		return id;
	}
	/** 
	 * @param id 要设置的 id 
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/** 
	 * @return version 
	 */
	public String getVersion() {
		return version;
	}
	/** 
	 * @param version 要设置的 version 
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/** 
	 * @return url 
	 */
	public String getUrl() {
		return url;
	}
	/** 
	 * @param url 要设置的 url 
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/** 
	 * @return appName 
	 */
	public String getAppName() {
		return appName;
	}
	/** 
	 * @param appName 要设置的 appName 
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}
	/** 
	 * @return content 
	 */
	public String getContent() {
		return content;
	}
	/** 
	 * @param content 要设置的 content 
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/** 
	 * @return force 
	 */
	public String getForce() {
		return force;
	}
	/** 
	 * @param force 要设置的 force 
	 */
	public void setForce(String force) {
		this.force = force;
	}
	/** 
	 * @return osType 
	 */
	public String getOsType() {
		return OsType;
	}
	/** 
	 * @param osType 要设置的 osType 
	 */
	public void setOsType(String osType) {
		OsType = osType;
	}
	/** 
	 * @return updateTime 
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/** 
	 * @param updateTime 要设置的 updateTime 
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}

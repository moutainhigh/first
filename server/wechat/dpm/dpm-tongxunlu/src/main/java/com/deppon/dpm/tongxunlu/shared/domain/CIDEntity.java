package com.deppon.dpm.tongxunlu.shared.domain;

import java.util.Date;

import com.deppon.dpm.module.common.shared.domain.BaseEntity;

public class CIDEntity extends BaseEntity {

	private Integer id;

	// 系统类型 android/iphone
	private String osType;

	// 手机号
	private String iphoneNo;

	// 下载路径
	private String downloadUrl;

	// 上一次更新时间
	private Date prevUpdateTime;
	
	// android是否打开来电显示权限 1:显示，0：不显示
	private String authority;
	
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getIphoneNo() {
		return iphoneNo;
	}

	public void setIphoneNo(String iphoneNo) {
		this.iphoneNo = iphoneNo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public Date getPrevUpdateTime() {
		return prevUpdateTime;
	}

	public void setPrevUpdateTime(Date prevUpdateTime) {
		this.prevUpdateTime = prevUpdateTime;
	}

}

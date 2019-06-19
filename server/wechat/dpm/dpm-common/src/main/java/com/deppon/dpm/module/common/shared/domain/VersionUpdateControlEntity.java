package com.deppon.dpm.module.common.shared.domain;

import java.util.Date;

/**
 * 系统版本更新权限控制实体类
 *
 */
public class VersionUpdateControlEntity {
	
	// 主键id
	private Integer id;
	
	// 包名
	private String packageName;
	
	// 文件名
	private String fileName;
	
	// 文件路径
	private String filePath;
	
	// 加载状态
	private String loadStatus;
	
	// 配置类型
	private String configType;
	
	// 更新时间
	private Date updateTime;
	
	// 上传时间
	private Date createTime;

	// getter
	public Integer getId() {
		return id;
	}

	// setter
	public void setId(Integer id) {
		this.id = id;
	}

	// getter
	public String getFileName() {
		return fileName;
	}

	// setter
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	// getter
	public String getFilePath() {
		return filePath;
	}

	// setter
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	// getter
	public String getLoadStatus() {
		return loadStatus;
	}

	// setter
	public void setLoadStatus(String loadStatus) {
		this.loadStatus = loadStatus;
	}

	// getter
	public Date getUpdateTime() {
		return updateTime;
	}

	// setter
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	// getter
	public Date getCreateTime() {
		return createTime;
	}

	// setter
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	// getter
	public String getPackageName() {
		return packageName;
	}

	// setter
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	// getter
	public String getConfigType() {
		return configType;
	}

	// setter
	public void setConfigType(String configType) {
		this.configType = configType;
	}
	
}

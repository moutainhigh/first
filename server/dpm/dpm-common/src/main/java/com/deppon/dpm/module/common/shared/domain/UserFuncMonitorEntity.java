package com.deppon.dpm.module.common.shared.domain;

import java.util.Date;

/**
 * 用户模块异常监控实体
 */
public class UserFuncMonitorEntity {

	// id
	private Integer id;
	
	// userId
	private String userId;
	
	// 路径
	private String path;
	
	// 该路径下是否存在文件
	private Boolean exist;
	
	// 创建时间
	private Date createTime;
	
	// 上传时间
	private Date updateTime;
	
	/*****分页属性******/
	private int page;
	
	private int rows;
	
	// getter
	public int getPage() {
		return page;
	}

	// setter
	public void setPage(int page) {
		this.page = page;
	}

	// getter
	public int getRows() {
		return rows;
	}

	// setter
	public void setRows(int rows) {
		this.rows = rows;
	}
	/***************/

	// getter
	public Integer getId() {
		return id;
	}

	// setter
	public void setId(Integer id) {
		this.id = id;
	}

	// getter
	public String getUserId() {
		return userId;
	}

	// setter
	public void setUserId(String userId) {
		this.userId = userId;
	}

	// getter
	public String getPath() {
		return path;
	}

	// setter
	public void setPath(String path) {
		this.path = path;
	}

	// getter
	public Boolean getExist() {
		return exist;
	}

	// setter
	public void setExist(Boolean exist) {
		this.exist = exist;
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
	public Date getUpdateTime() {
		return updateTime;
	}

	// setter
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}

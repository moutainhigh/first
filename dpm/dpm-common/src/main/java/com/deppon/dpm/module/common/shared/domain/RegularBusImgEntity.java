package com.deppon.dpm.module.common.shared.domain;

import java.util.Date;

/**
 * 班车服务图片实体
 */
public class RegularBusImgEntity {
	
	private Integer id;

	// 图片类型：上班、下班
	private Integer type;
	
	// 图片路径
	private String imgUrl;
	
	private Date createTime;
	
	private Date updateTime;

	/*******分页参数*******/
	private int page;
	
	private int rows;
	
	private int start;
	
	public int getStart() {
		if(page != 0) {
			start = (page -1) * this.getRows();
		}
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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
	
}

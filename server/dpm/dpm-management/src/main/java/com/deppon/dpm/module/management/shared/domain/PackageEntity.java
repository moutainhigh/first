package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;

/**
 * 
 * @author 王亚男
 * 包裹信息
 */
public class PackageEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5051401425879211816L;
	
	/**
	 * 主键ID(唯一)
	 */
	private Long typeId;
	
	/**
	 * 名称
	 */
	private String name;

	/**
	 * getter
	 * @return
	 */
	public Long getTypeId() {
		return typeId;
	}

	/**
	 * setter
	 * @param typeId
	 */
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	/**
	 * getter
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * setter
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
}

package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;

/**
 * @author ccf ProIocBeanEntity 类
 * 
 */
public class ProIocBeanEntity implements Serializable {
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键id
	 */
	private int id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 编码
	 */
	private String cord;

	/**
	 * @return 主键id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            主键id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return 名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return 编码
	 */
	public String getCord() {
		return cord;
	}

	/**
	 * @param cord
	 *            编码
	 */
	public void setCord(String cord) {
		this.cord = cord;
	}

	// 构造方法
	@Override
	public String toString() {
		return "ProIocBeanEntity [id=" + id + ", name=" + name + ", cord="
				+ cord + "]";
	}

}

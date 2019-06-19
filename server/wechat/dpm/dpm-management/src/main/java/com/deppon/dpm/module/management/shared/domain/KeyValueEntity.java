package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 268101 键值实体
 *
 */
public class KeyValueEntity implements Serializable {

	/**
	 *  序列化
	 */
	private static final long serialVersionUID = -4049177380230243278L;
	
	/**
	 * 构造方法
	 */
	public KeyValueEntity(){}
	
	/**
	 * 值
	 */
	private String value;
	/**
	 * 包裹录入信息list
	 */
	private List<ParcelEntity> list = new ArrayList<ParcelEntity>();
	/**
	 * @return 值
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value 值
	 */
	public void setValue(String value) {
		this.value = value;
	}
	public List<ParcelEntity> getList() {
		return list;
	}
	public void setList(List<ParcelEntity> list) {
		this.list = list;
	}

}

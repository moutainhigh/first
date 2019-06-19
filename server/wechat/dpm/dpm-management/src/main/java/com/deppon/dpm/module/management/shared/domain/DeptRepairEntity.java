package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 部门实体类
 * 
 */
public class DeptRepairEntity implements Serializable {
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -4548903800560914808L;

	/**
	 * 返回成功标志位
	 */
	private int isSuccess;

	/**
	 * 信息
	 */
	private String message;
	/**
	 * DepartEntity 集合
	 */
	private List<DepartEntity> data = new ArrayList<DepartEntity>();
	/**
	 * 总数
	 */
	private int count;

	/**
	 * @return 返回成功标志位
	 */
	public int getIsSuccess() {
		return isSuccess;
	}

	/**
	 * @param isSuccess 返回成功标志位
	 */
	public void setIsSuccess(int isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getMessage() {
		return message;
	}

	/**
	 * @param message 信息
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return  DepartEntity 集合
	 */
	public List<DepartEntity> getData() {
		return data;
	}

	/**
	 * @param data  DepartEntity 集合
	 */
	public void setData(List<DepartEntity> data) {
		this.data = data;
	}

	/**
	 * @return 总数
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count 总数
	 */
	public void setCount(int count) {
		this.count = count;
	}

}

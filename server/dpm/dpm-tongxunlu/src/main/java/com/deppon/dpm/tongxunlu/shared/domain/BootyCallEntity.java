package com.deppon.dpm.tongxunlu.shared.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 约吧实体类
 * 
 * @date 2015-09-14
 * @author 231586
 * 
 */
public class BootyCallEntity extends BaseEntity {

	private static final long serialVersionUID = -9009590520154691802L;
	// 工号
	private String userId;
	// 约会类型
	private String dataType;
	// 约会地点
	private String dataAddress;
	// 对象工号
	private String dataEmpCode;
	// 要求的性别
	private String dataGender;
	// 约会时间
	@JSONField(format = "yyyy-MM-dd HH:mm")
	private String dataTime;
	// 限定人数
	private int dataLimitNum;
	// 约会主题
	private String dataSubject;
	// 创建时间
	@JSONField(format = "yyyy-MM-dd HH:mm")
	private String dataCreateTime;

	// get
	public String getUserId() {
		return userId;
	}

	// set
	public void setUserId(String userId) {
		this.userId = userId;
	}

	// getter
	public String getDataType() {
		return dataType;
	}
	
	// setter
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	// getter
	public String getDataAddress() {
		return dataAddress;
	}

	// setter
	public void setDataAddress(String dataAddress) {
		this.dataAddress = dataAddress;
	}

	// getter
	public String getDataEmpCode() {
		return dataEmpCode;
	}

	// setter
	public void setDataEmpCode(String dataEmpCode) {
		this.dataEmpCode = dataEmpCode;
	}

	// getter
	public String getDataGender() {
		return dataGender;
	}

	// setter
	public void setDataGender(String dataGender) {
		this.dataGender = dataGender;
	}

	// getter
	public String getDataTime() {
		return dataTime;
	}

	// setter
	public void setDataTime(String dataTime) {
		this.dataTime = dataTime;
	}

	// getter
	public int getDataLimitNum() {
		return dataLimitNum;
	}

	// setter
	public void setDataLimitNum(int dataLimitNum) {
		this.dataLimitNum = dataLimitNum;
	}

	// getter
	public String getDataSubject() {
		return dataSubject;
	}

	// setter
	public void setDataSubject(String dataSubject) {
		this.dataSubject = dataSubject;
	}

	// getter
	public String getDataCreateTime() {
		return dataCreateTime;
	}

	// setter
	public void setDataCreateTime(String dataCreateTime) {
		this.dataCreateTime = dataCreateTime;
	}
}

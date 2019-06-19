package com.deppon.dpm.tongxunlu.shared.domain;

/**
 * 热线电话实体类
 * @author 231586
 *
 */
public class HotLine {

	// 热线id
	private int hotLineId;
	// 热线名称
	private String name;
	// 号码
	private String phone;

	// get
	public String getName() {
		return name;
	}

	// set
	public void setName(String name) {
		this.name = name;
	}

	// get
	public String getPhone() {
		return phone;
	}

	// set
	public void setPhone(String phone) {
		this.phone = phone;
	}

	// get
	public int getHotLineId() {
		return hotLineId;
	}

	// set
	public void setHotLineId(int hotLineId) {
		this.hotLineId = hotLineId;
	}

}

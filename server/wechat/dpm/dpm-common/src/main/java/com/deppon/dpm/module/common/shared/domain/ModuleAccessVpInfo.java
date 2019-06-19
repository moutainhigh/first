package com.deppon.dpm.module.common.shared.domain;

/**
 * vp访问详情info
 * 
 */
public class ModuleAccessVpInfo {

	/**
	 * vp编号
	 */
	private String vpCode;
	/**
	 * vp访问次数
	 */
	private String frequency;
	/**
	 * vp闪退时间
	 */
	private String occurTime;
	/**
	 * 模块访问时间
	 */
	private String accessTime;

	public String getAccessTime() {
		return accessTime;
	}

	public void setAccessTime(String accessTime) {
		this.accessTime = accessTime;
	}

	public String getOccurTime() {
		return occurTime;
	}

	public void setOccurTime(String occurTime) {
		this.occurTime = occurTime;
	}

	public String getVpCode() {
		return vpCode;
	}

	public void setVpCode(String vpCode) {
		this.vpCode = vpCode;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

}

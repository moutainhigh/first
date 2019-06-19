package com.deppon.dpm.module.common.shared.domain;

/**
 * 监控ACTION访问详细信息
 * 
 */
public class MonitorActionInfo {

	/**
	 * action地址
	 */
	private String actionUrl;
	/**
	 * 执行时长
	 */
	private String duration;
	/**
	 * 操作人
	 */
	private String empCode;
	/**
	 * 请求参数
	 */
	private String reqParameter;
	/**
	 * 返回参数
	 */
	private String resParameter;
	/**
	 * 备注
	 */
	private String remark;

	/**
	 * get
	 */
	public String getActionUrl() {
		return actionUrl;
	}

	/**
	 * set
	 * @param actionUrl
	 */
	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}

	/**
	 * get
	 * @return
	 */
	public String getDuration() {
		return duration;
	}

	/**
	 * set
	 * @param duration
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}

	/**
	 * get
	 * @return
	 */
	public String getEmpCode() {
		return empCode;
	}

	/**
	 * set
	 * @param empCode
	 */
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	/**
	 * get
	 * @return
	 */
	public String getReqParameter() {
		return reqParameter;
	}

	/**
	 * set
	 * @param reqParameter
	 */
	public void setReqParameter(String reqParameter) {
		this.reqParameter = reqParameter;
	}

	/**
	 * get
	 * @return
	 */
	public String getResParameter() {
		return resParameter;
	}

	/**
	 * set
	 * @param resParameter
	 */
	public void setResParameter(String resParameter) {
		this.resParameter = resParameter;
	}

	/**
	 * get
	 * @return
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * set
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

}

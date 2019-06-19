package com.deppon.dpm.module.wfs.shared.vo;

/**
 * crm 工作流查询明细详情 参数
 */
public class QueryParamVo {
	// 工作流编号
	private String workitemid;
	// 工号
	private String empCode;
	// 审批人姓名
	private String empName;
	// 工作流号
	private String busino;
	// 流程定义名称
	private String processName;

	/**
	 * @return the workitemid
	 */
	public String getWorkitemid() {
		return workitemid;
	}

	/**
	 * @param workitemid
	 *            the workitemid to set
	 */
	public void setWorkitemid(String workitemid) {
		this.workitemid = workitemid;
	}

	/**
	 * @return the empCode
	 */
	public String getEmpCode() {
		return empCode;
	}

	/**
	 * @param empCode
	 *            the empCode to set
	 */
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName
	 *            the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the busino
	 */
	public String getBusino() {
		return busino;
	}

	/**
	 * @param busino
	 *            the busino to set
	 */
	public void setBusino(String busino) {
		this.busino = busino;
	}

	/**
	 * @return the processName
	 */
	public String getProcessName() {
		return processName;
	}

	/**
	 * @param processName
	 *            the processName to set
	 */
	public void setProcessName(String processName) {
		this.processName = processName;
	}

}

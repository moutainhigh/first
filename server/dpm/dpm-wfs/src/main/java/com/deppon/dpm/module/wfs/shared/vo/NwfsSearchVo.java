package com.deppon.dpm.module.wfs.shared.vo;
/**
 * 工作流搜索接收前端参数
 * @author 276344
 *
 */
public class NwfsSearchVo {
	/**
	 * 当前页 （必传 否则报空指针异常）
	 */
	private String pageNo;
	/**
	 * 开始时间  （必传 否则查不到数据）
	 */
	private String startTime;
	/**
	 * 结束时间 （必传 否则查不到数据）
	 */
	private String endTime;
	/**
	 * 系统编码（必传 否则查不到数据）  查询所有系统工作流需传("") 不能传null
	 */
	private String sysCode;
	/**
	 * 工作流名称
	 */
	private String wfsName;
	/**
	 * 工作流号
	 */
	private String wfsMark;
	/**
	 * 工作流状态  按工作流状态搜索  未提交：0  ，已提交：1，  批准：2，归档：3，     审批中：4
	 */
	private String wfsStatus;
	/**
	 * 起草人姓名
	 */
	private String creatorName;
	/**
	 * 起草人工号
	 */
	private String creatorId;
	
	/**
	 * set
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	/**
	 * set
	 * @param startTime
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * set
	 * @param endTime
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * set
	 * @param sysCode
	 */
	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}
	/**
	 * set
	 * @param wfsName
	 */
	public void setWfsName(String wfsName) {
		this.wfsName = wfsName;
	}
	/**
	 * set
	 * @param wfsMark
	 */
	public void setWfsMark(String wfsMark) {
		this.wfsMark = wfsMark;
	}
	/**
	 * set
	 * @param wfsStatus
	 */
	public void setWfsStatus(String wfsStatus) {
		this.wfsStatus = wfsStatus;
	}
	/**
	 * set
	 * @param creatorName
	 */
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	/**
	 * set
	 * @param creatorId
	 */
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	/**
	 * get
	 * @return
	 */
	public String getPageNo() {
		return pageNo;
	}
	/**
	 * get
	 * @return
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * get
	 * @return
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * get
	 * @return
	 */
	public String getSysCode() {
		return sysCode;
	}
	/**
	 * get
	 * @return
	 */
	public String getWfsName() {
		return wfsName;
	}
	/**
	 * get
	 * @return
	 */
	public String getWfsMark() {
		return wfsMark;
	}
	/**
	 * get
	 * @return
	 */
	public String getWfsStatus() {
		return wfsStatus;
	}
	/**
	 * get
	 * @return
	 */
	public String getCreatorName() {
		return creatorName;
	}
	/**
	 * get
	 * @return
	 */
	public String getCreatorId() {
		return creatorId;
	}
	
	
	
	
}

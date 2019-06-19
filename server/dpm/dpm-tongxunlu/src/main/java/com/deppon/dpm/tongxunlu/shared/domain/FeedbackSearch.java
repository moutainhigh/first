package com.deppon.dpm.tongxunlu.shared.domain;

/**
 * 意见反馈，PC端查询条件
 * 
 */
public class FeedbackSearch {

	/**
	 * 工号
	 */
	private String searchCode;
	/**
	 * 姓名
	 */
	private String searchName;
	/**
	 * 内容
	 */
	private String searchContent;
	/**
	 * 处理状态
	 */
	private String searchStatus;
	/**
	 * 提交开始时间
	 */
	private String searchBeginTime;
	/**
	 * 提交结束时间
	 */
	private String searchEndTime;
	/**
	 * 设备类型
	 */
	private String searchOsType;
	/**
	 * 问题类型
	 */
	private String searchType;
	/**
	 * 是否解决
	 */
	private String searchIsSolve;

	/**
	 * get
	 * 
	 * @return
	 */
	public String getSearchCode() {
		return searchCode;
	}

	/**
	 * set
	 * 
	 * @param searchCode
	 */
	public void setSearchCode(String searchCode) {
		this.searchCode = searchCode;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getSearchName() {
		return searchName;
	}

	/**
	 * set
	 * 
	 * @param searchName
	 */
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getSearchContent() {
		return searchContent;
	}

	/**
	 * set
	 * 
	 * @param searchContent
	 */
	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getSearchStatus() {
		return searchStatus;
	}

	/**
	 * set
	 * 
	 * @param searchStatus
	 */
	public void setSearchStatus(String searchStatus) {
		this.searchStatus = searchStatus;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getSearchBeginTime() {
		return searchBeginTime;
	}

	/**
	 * set
	 * 
	 * @param searchBeginTime
	 */
	public void setSearchBeginTime(String searchBeginTime) {
		this.searchBeginTime = searchBeginTime;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getSearchEndTime() {
		return searchEndTime;
	}

	/**
	 * set
	 * 
	 * @param searchEndTime
	 */
	public void setSearchEndTime(String searchEndTime) {
		this.searchEndTime = searchEndTime;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getSearchOsType() {
		return searchOsType;
	}

	/**
	 * set
	 * 
	 * @param searchOsType
	 */
	public void setSearchOsType(String searchOsType) {
		this.searchOsType = searchOsType;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getSearchType() {
		return searchType;
	}

	/**
	 * set
	 * 
	 * @param searchType
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getSearchIsSolve() {
		return searchIsSolve;
	}

	/**
	 * set
	 * 
	 * @param searchIsSolve
	 */
	public void setSearchIsSolve(String searchIsSolve) {
		this.searchIsSolve = searchIsSolve;
	}

}

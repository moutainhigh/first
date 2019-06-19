package com.deppon.dpm.module.wfs.shared.vo;

/**
 * NHR人员选择器查询参数
 * 
 */
public class NhrQueryParamVo {

	/**
	 * 申请人工号
	 */
	private String applypsncode;
	/**
	 * 查询工号
	 */
	private String queryCode;
	/**
	 * 查询姓名
	 */
	private String queryName;
	/**
	 * 当前页码
	 */
	private static final int pageNo = 1;
	/**
	 * 每页显示记录条数
	 */
	private static final int pageSize = 10;
	/**
	 * 查询类型
	 * 1：申请人员岗位为P类
	 * 2：审批人员岗位为M类，但岗位层级不为C、D
	 * 3：审批人员岗位为M类，且岗位层级为D
	 * 4：审批人员岗位为M类，且岗位层级为C
	 */
	private int queryType;
	/**
	 * 岗位层级
	 */
	private String jobLevel;
	
	/**
	 * get
	 * @return
	 */
	public String getJobLevel() {
		return jobLevel;
	}

	/**
	 * set
	 * @param jobLevel
	 */
	public void setJobLevel(String jobLevel) {
		this.jobLevel = jobLevel;
	}

	/**
	 * get
	 * @return
	 */
	public int getQueryType() {
		return queryType;
	}

	/**
	 * set
	 * @param queryType
	 */
	public void setQueryType(int queryType) {
		this.queryType = queryType;
	}

	/**
	 * get
	 * @return
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * set
	 * @param pageNo
	 */
	/*public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}*/
	

	public int getPageSize() {
		return pageSize;
	}

	/*public  void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}*/

	public static int getPageno() {
		return pageNo;
	}

	public static int getPagesize() {
		return pageSize;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getApplypsncode() {
		return applypsncode;
	}

	/**
	 * set
	 * 
	 * @param applypsncode
	 */
	public void setApplypsncode(String applypsncode) {
		this.applypsncode = applypsncode;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getQueryCode() {
		return queryCode;
	}

	/**
	 * set
	 * 
	 * @param queryCode
	 */
	public void setQueryCode(String queryCode) {
		this.queryCode = queryCode;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getQueryName() {
		return queryName;
	}

	/**
	 * set
	 * 
	 * @param queryName
	 */
	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}

}

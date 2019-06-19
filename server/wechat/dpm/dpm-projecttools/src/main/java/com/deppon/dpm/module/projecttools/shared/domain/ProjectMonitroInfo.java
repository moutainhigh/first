/**
 * 
 */
package com.deppon.dpm.module.projecttools.shared.domain;

/**
 * 数据实体类数据
 * @author 石学钢
 * 2015-9-16
 */
public class ProjectMonitroInfo {
	//用户ID
	private String userId;
	
	//监控类型
	///0项目列表 1收藏 2部门查询 3详情 4周状态  5会议纪要 6报表(工时) 
	//7报表(需求上线) 8报表(需求点均) 9报表(功能点) 10报表(进度成本) 
	//11任务查询 12我的任务 13新增 14审核   15年度规划  16任务新建
	private String type;
	
	//部门条件
	private String details;
	
	//备用1 
	private String spare1;
	
	//备用2
	private String spare2;
	
	//备用3
	private String spare3;

	/**
	 * userId
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * type
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * details
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * spare1
	 * @return the spare1
	 */
	public String getSpare1() {
		return spare1;
	}

	/**
	 * @param spare1 the spare1 to set
	 */
	public void setSpare1(String spare1) {
		this.spare1 = spare1;
	}

	/**
	 * spare2
	 * @return the spare2
	 */
	public String getSpare2() {
		return spare2;
	}

	/**
	 * @param spare2 the spare2 to set
	 */
	public void setSpare2(String spare2) {
		this.spare2 = spare2;
	}

	/**
	 * spare3
	 * @return the spare3
	 */
	public String getSpare3() {
		return spare3;
	}

	/**
	 * @param spare3 the spare3 to set
	 */
	public void setSpare3(String spare3) {
		this.spare3 = spare3;
	}

	
}

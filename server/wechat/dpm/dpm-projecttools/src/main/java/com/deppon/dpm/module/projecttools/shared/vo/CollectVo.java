package com.deppon.dpm.module.projecttools.shared.vo;

/**
 * 我的关注 收藏实体
 * @author gcl
 *
 */
public class CollectVo {
	//收藏人工号
	private String userCode;
	//项目管理编号
	private String dppmCode;
	//是否收藏 0否 1是
	private int isCollect;
	/**
	 * @return the userCode
	 */
	public String getUserCode() {
		return userCode;
	}
	/**
	 * @param userCode
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	/**
	 * @return the dppmCode
	 */
	public String getDppmCode() {
		return dppmCode;
	}
	/**
	 * @param dppmCode
	 */
	public void setDppmCode(String dppmCode) {
		this.dppmCode = dppmCode;
	}
	/**
	 * @return the isCollect
	 */
	public int getIsCollect() {
		return isCollect;
	}
	/**
	 * @param isCollect
	 */
	public void setIsCollect(int isCollect) {
		this.isCollect = isCollect;
	}
	
	
}

package com.deppon.dpm.store.server.entity;
/**
 * 查询所有模块信息entity
 * @author RY
 *
 */
public class QueryModInfo {
	//一级模块id
	private Integer firstmodid;
	//一级模块名称
	private String firstmodname;
	//secondmodid
	private Integer secondmodid;
	//二级模块名称
	private String secondmodname;
	//二级模块总分
	private Integer checkgrade;
	//一级模块总分
	private Integer checkallgrade;
	//二级模块说明
	private String modinfo;
	/**
	 * 
	 * @return
	 */
	public Integer getCheckallgrade() {
		return checkallgrade;
	}
	/**
	 * 
	 * @param checkallgrade
	 */
	public void setCheckallgrade(Integer checkallgrade) {
		this.checkallgrade = checkallgrade;
	}
	/**
	 * 
	 * @return
	 */
	public String getFirstmodname() {
		return firstmodname;
	}
	/**
	 * 
	 * @param firstmodname
	 */
	public void setFirstmodname(String firstmodname) {
		this.firstmodname = firstmodname;
	}
	/**
	 * 
	 * @return
	 */
	public String getSecondmodname() {
		return secondmodname;
	}
	/**
	 * 
	 * @param secondmodname
	 */
	public void setSecondmodname(String secondmodname) {
		this.secondmodname = secondmodname;
	}
	/**
	 * 
	 * @return
	 */
	public Integer getCheckgrade() {
		return checkgrade;
	}
	/**
	 * 
	 * @param checkgrade
	 */
	public void setCheckgrade(Integer checkgrade) {
		this.checkgrade = checkgrade;
	}
	/**
	 * 
	 * @return
	 */
	public Integer getFirstmodid() {
		return firstmodid;
	}
	/**
	 * 
	 * @param firstmodid
	 */
	public void setFirstmodid(Integer firstmodid) {
		this.firstmodid = firstmodid;
	}
	/**
	 * 
	 * @return
	 */
	public Integer getSecondmodid() {
		return secondmodid;
	}
	/**
	 * 
	 * @param secondmodid
	 */
	public void setSecondmodid(Integer secondmodid) {
		this.secondmodid = secondmodid;
	}
	/**
	 * 
	 * @return
	 */
	public String getModinfo() {
		return modinfo;
	}
	/**
	 * 
	 * @param modinfo
	 */
	public void setModinfo(String modinfo) {
		this.modinfo = modinfo;
	}
}

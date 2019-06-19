package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import java.util.List;

public class ProjectDesignVo {
	//工程项目设计单表头信息查询
	private Projectdesign billList;
	//工程项目设计单设计明细分录（基础资料分录）信息查询
	private List<ProjectdesignentryVo> entryList;
	//工程项目设计单概算情况分录（辅助资料分录）信息查询
	private List<ProjectdesignassentryVo> assEntryList;
	//工程项目设计单会审记录单分录（其他资料分录）信息查询
	private List<ProjectdesignotherentryEntity> otherEntryList;
	/**
	 * @return the otherEntryList
	 */
	public List<ProjectdesignotherentryEntity> getOtherEntryList() {
		return otherEntryList;
	}
	/**
	 * @param otherEntryList the otherEntryList to set
	 */
	public void setOtherEntryList(List<ProjectdesignotherentryEntity> otherEntryList) {
		this.otherEntryList = otherEntryList;
	}
	/**
	 * @return the billList
	 */
	public Projectdesign getBillList() {
		return billList;
	}
	/**
	 * @param billList the billList to set
	 */
	public void setBillList(Projectdesign billList) {
		this.billList = billList;
	}
	/**
	 * @return the entryList
	 */
	public List<ProjectdesignentryVo> getEntryList() {
		return entryList;
	}
	/**
	 * @param entryList the entryList to set
	 */
	public void setEntryList(List<ProjectdesignentryVo> entryList) {
		this.entryList = entryList;
	}
	/**
	 * @return the assEntryList
	 */
	public List<ProjectdesignassentryVo> getAssEntryList() {
		return assEntryList;
	}
	/**
	 * @param assEntryList the assEntryList to set
	 */
	public void setAssEntryList(List<ProjectdesignassentryVo> assEntryList) {
		this.assEntryList = assEntryList;
	}
	
	/**
	 * @return 返回 billList属性的值
	 * @date 2014-8-5 下午6:10:35
	 * @author huangzibin
	 */

	
	
	
	
	
	
	

}

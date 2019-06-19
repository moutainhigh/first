package com.deppon.dpm.module.management.server.service;

/**
 * 详细页面的显示
 * 
 * @author 274858
 * 
 */
public interface IProcCheckFindScoreShowService {
	/*
	 * <!--获取初次、最终验收明细查询-->
	 * 
	 * @see com.deppon.dpm.module.management.server.
	 * service.IProcCheckFindScoreShowService# getHisScoreFind(java.lang.String)
	 */
	public String getHisScoreFind(String str) throws Exception;

	/*
	 * 统计扣分总数和扣分项
	 * 
	 * @see com.deppon.dpm.module.management.server.service.
	 * IProcCheckFindScoreShowService#getCountScore(java.lang.String)
	 */
	public String getCountScore(String str) throws Exception;

	/*
	 * 查询明细信息 (non-Javadoc)
	 * 
	 * @see com.deppon.dpm.module.management.server.service.
	 * IProcCheckFindScoreShowService#getFindListView(java.lang.String)
	 */
	public String getFindListView(String str) throws Exception;
	// public String setProcCheckSave(String str) throws Exception;

}

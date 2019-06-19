package com.deppon.montal.common.service;

import java.util.List;
import java.util.Map;

public interface ISelectorService {
	//查询总的结果集合
	List<Map<String,String>> queryList(Map<String, String> reqPara);
	//查询记录数
	int queryCount(Map<String, String> reqPara);
	/**
	 * 
	* @MethodName: queryOrgFinasyscode 
	* @description : 查询部门下属机构
	* @author：caibingbing 
	* @date： 2014-8-6 下午8:32:12
	* @param reqPara
	* @return String
	 */
	String queryOrgFinasyscode(Map<String, String> reqPara);
}

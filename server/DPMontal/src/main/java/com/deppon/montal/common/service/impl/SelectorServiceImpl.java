package com.deppon.montal.common.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.montal.common.dao.SelectDao;
import com.deppon.montal.common.service.ISelectorService;

public class SelectorServiceImpl implements ISelectorService {
	private SelectDao selectDao = new SelectDao();
	@Override
	public List<Map<String, String>> queryList(Map<String, String> reqPara) {
		Map<String,String> params = handelParams(reqPara);
		List<Map<String, String>> list = selectDao.queryList(params);
		return list;
	}

	@Override
	public int queryCount(Map<String, String> reqPara) {
		Map<String,String> params = handelParams(reqPara);
		int totalCount = selectDao.queryCount(params);
		return totalCount;
	}

	private Map<String,String> handelParams(Map<String, String> reqPara){
		Map<String,String> params = new HashMap<String, String>();
		params.put("selectorType", reqPara.get("selectorType"));
		params.put("empNameQuery", reqPara.get("empNameQuery"));
		params.put("empCodeQuery", reqPara.get("empCodeQuery"));
		params.put("deptNameQuery", reqPara.get("deptNameQuery"));
		params.put("deptCodeQuery", reqPara.get("deptCodeQuery"));
		params.put("finasyscodeQuery", reqPara.get("finasyscodeQuery"));
		//开始页面。和结束页面在这里计算一下子然后再次传递给dao
		Integer page = Integer.parseInt(reqPara.get("page"));
		Integer limit = Integer.parseInt(reqPara.get("limit"));
		params.put("startPage", (page - 1) * limit + "");
		params.put("endPage", page * limit + "");
		return params;
	}
	/**
	 * 
	* @MethodName: queryOrgFinasyscode 
	* @description : 查询部门下属机构
	* @author：caibingbing 
	* @date： 2014-8-6 下午8:32:12
	* @param reqPara
	* @return String
	 */
	@Override
	public String queryOrgFinasyscode(Map<String, String> reqPara) {
		String sunFinasyscode = null;
		String finasysCode = reqPara.get("finasyscodeQuery");
		if(finasysCode != null && finasysCode != ""){
			sunFinasyscode = selectDao.querySunOrg(finasysCode);
		}
		return sunFinasyscode;
	}
}

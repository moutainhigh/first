package com.deppon.dpm.module.management.server.service;

import java.util.Map;

/**
 * 工程维修信息service层.
 * @author 曹嵩
 * <p>时间:2015.9.29</p>
 */
public interface IProcMaintenanceInfoListService {

	/**得到工程维修list数据
	 * @param pageNum 分页 多少行
	 * @param pageSize 第几页
	 * @param userNo 工号
	 * @return 工程维修list数据
	 */
	public Map<String, Object> getProcMainList(int pageNum,int pageSize,String userNo);
}

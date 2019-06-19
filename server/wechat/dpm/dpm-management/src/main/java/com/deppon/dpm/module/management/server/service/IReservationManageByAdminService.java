package com.deppon.dpm.module.management.server.service;

import java.util.Map;

/**
 * 管理员查询已预订信息service层接口.
 * @author 曹嵩
 * <p>2015.10.21</p>
 */
public interface IReservationManageByAdminService {

	/**
	 * 查询所有的已预订信息.
	 * @param areaName 楼层区域名称
	 * @param siteMark 预定类型标志（0羽毛球室，1瑜伽室）
	 */
	public Map<String, Object> getReservationManagList(String areaName,int siteMark,String searchTime);
}

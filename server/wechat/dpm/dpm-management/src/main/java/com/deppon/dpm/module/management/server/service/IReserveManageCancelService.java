package com.deppon.dpm.module.management.server.service;


/**
 * 预订管理羽毛球和瑜伽室的取消预订和提前结束service接口.
 * @author 曹嵩
 * <p>时间:2015.10.20</p>
 */
public interface IReserveManageCancelService {

	/**
	 * 修改状态并且修改当前时间根据id.
	 * @param status 状态0 –预定 1-取消预定 2-提前结束预定
	 * @param id 编号
	 */
	public int updateState(int status,int id);
}

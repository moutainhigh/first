package com.deppon.dpm.module.management.server.service;



public interface IMapAddressService {

	/**
	 * 根据经纬度获取最近部门信息
	 * @param x
	 * @param y
	 * @return
	 */
	public String getNameInfoByXY(String x,String y);
	
}

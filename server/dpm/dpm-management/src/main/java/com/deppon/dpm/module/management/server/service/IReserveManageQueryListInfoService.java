package com.deppon.dpm.module.management.server.service;

import java.text.ParseException;

import com.deppon.foss.framework.exception.BusinessException;

public interface IReserveManageQueryListInfoService {

	/**<p>Description:查询羽毛球瑜伽室详细列表</p>
	 * 羽毛球场空闲的时间查询场地
	        瑜伽室空闲的时间查询场地
	 * @param str
	 * @return
	 * @throws BusinessException
	 */
	public String querySiteLeisureList(String str) throws ParseException;
	/**
	 * 查询场地信息
	 * @return
	 * @throws BusinessException
	 */
	public String querySiteInfo(String str) throws BusinessException;
	
	/**具体房间的详细预定信息
	 * @param str
	 * @return
	 * @throws BusinessException
	 */
	public String querySiteDateList(String str) throws ParseException;
	/**查询管理员
	 * @param str
	 * @return
	 * @throws BusinessException
	 */
	public String queryAdmin() throws BusinessException;
	/**
	 * 保存管理员
	 * @param str
	 * @return
	 * @throws BusinessException
	 */
	public String saveAdminInfo(String str) throws BusinessException;
	/**
	 * delete管理员
	 * @param str
	 * @return
	 * @throws BusinessException
	 */
	public String deleteAdminInfo(String str) throws BusinessException;
	
}

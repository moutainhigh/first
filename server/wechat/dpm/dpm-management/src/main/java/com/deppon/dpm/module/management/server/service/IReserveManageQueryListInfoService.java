package com.deppon.dpm.module.management.server.service;

public interface IReserveManageQueryListInfoService {

	/**<p>Description:查询羽毛球瑜伽室详细列表</p>
	 * 羽毛球场空闲的时间查询场地
	        瑜伽室空闲的时间查询场地
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public String querySiteLeisureList(String str) throws Exception;
	/**
	 * 查询场地信息
	 * @return
	 * @throws Exception
	 */
	public String querySiteInfo(String str) throws Exception;
	
	/**具体房间的详细预定信息
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public String querySiteDateList(String str) throws Exception;
	/**查询管理员
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public String queryAdmin() throws Exception;
	/**
	 * 保存管理员
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public String saveAdminInfo(String str) throws Exception;
	/**
	 * delete管理员
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public String deleteAdminInfo(String str) throws Exception;
	
}

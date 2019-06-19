package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.ReserveAdminEntity;
import com.deppon.dpm.module.management.shared.domain.ReserveRecordEntity;

/**
 * @author 274858
 *
 */
public interface IReserveManageQueryListInfoDao {

	/**
	 * <p>Description:查询羽毛球瑜伽室详细列表</p>
	 * 羽毛球场空闲时间查询场地
	        瑜伽室空闲时间查询场地
	 * @param parBean
	 * @return
	 * @throws Exception
	 */
	public List<ReserveRecordEntity> querySiteLeisureList(ReserveRecordEntity parBean) throws Exception;
	/**
	 * 场地查询
	 * @param siteMark
	 * @return
	 * @throws Exception
	 */
	public List<ReserveRecordEntity> querySiteInfo(int siteMark) throws Exception;
	/**
	 * 查询某个场地的详细预定信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<ReserveRecordEntity> querySiteDateList(ReserveRecordEntity parBean) throws Exception; 
	/**
	 * 查询管理员信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<ReserveAdminEntity> queryAdmin() throws Exception; 
	/**
	 * 保存管理员信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int saveAdminInfo(ReserveAdminEntity parBean) throws Exception; 
	/**
	 * delte管理员信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteAdminInfo(String id) throws Exception; 
	/**
	 * 超级管理员检验
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int checkSuperAdmin(String userNo) throws Exception; 
	/**
	 * 检验是否存在改账户
	 * @param userNo
	 * @return
	 * @throws Exception
	 */
	public int queryAdminInfo(String userNo) throws Exception; 
	
} 
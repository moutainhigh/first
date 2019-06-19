package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.ReserveAdminEntity;
import com.deppon.dpm.module.management.shared.domain.ReserveRecordEntity;
import com.deppon.foss.framework.exception.BusinessException;

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
	 * @throws BusinessException
	 */
	public List<ReserveRecordEntity> querySiteLeisureList(ReserveRecordEntity parBean) throws BusinessException;
	/**
	 * 场地查询
	 * @param siteMark
	 * @return
	 * @throws BusinessException
	 */
	public List<ReserveRecordEntity> querySiteInfo(int siteMark) throws BusinessException;
	/**
	 * 查询某个场地的详细预定信息
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public List<ReserveRecordEntity> querySiteDateList(ReserveRecordEntity parBean) throws BusinessException; 
	/**
	 * 查询管理员信息
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public List<ReserveAdminEntity> queryAdmin() throws BusinessException; 
	/**
	 * 保存管理员信息
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public int saveAdminInfo(ReserveAdminEntity parBean) throws BusinessException; 
	/**
	 * delte管理员信息
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public int deleteAdminInfo(String id) throws BusinessException; 
	/**
	 * 超级管理员检验
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public int checkSuperAdmin(String userNo) throws BusinessException; 
	/**
	 * 检验是否存在改账户
	 * @param userNo
	 * @return
	 * @throws BusinessException
	 */
	public int queryAdminInfo(String userNo) throws BusinessException; 
	
} 
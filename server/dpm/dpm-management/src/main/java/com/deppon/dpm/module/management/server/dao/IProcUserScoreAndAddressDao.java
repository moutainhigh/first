package com.deppon.dpm.module.management.server.dao;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.ProcUserScoreAndAddressEntity;
import com.deppon.foss.framework.exception.BusinessException;

/**
 * 提交显示所有0分项dao层接口
 * @author 曹嵩
 * @date 2015.7.29
 */
public interface IProcUserScoreAndAddressDao {
	
	/**
	 * 得到功能栏代码值
	 * @param pusaae
	 * @return 功能代码值
	 * @throws BusinessException
	 */
	public List<ProcUserScoreAndAddressEntity> getProType(ProcUserScoreAndAddressEntity pusaae) throws BusinessException;
	
	/**
	 * 得到所有的0分项信息
	 * @param pusaae
	 * @return 所有0分项信息
	 * @throws BusinessException
	 */
	public List<ProcUserScoreAndAddressEntity> getProcUserScoreAndAddress(ProcUserScoreAndAddressEntity pusaae) throws BusinessException;
	
	/**
	 * 得到检查的门店总数
	 * @param pusaae
	 * @return 检查门店总数
	 * @throws BusinessException
	 */
	public int getCountStore() throws BusinessException;
	
	/**
	 * 得到这一项门店不合格总数
	 * @param pusaae
	 * @return 门店不合格总数
	 * @throws BusinessException
	 */
	public int getCountScopeId(ProcUserScoreAndAddressEntity pusaae) throws BusinessException;
}

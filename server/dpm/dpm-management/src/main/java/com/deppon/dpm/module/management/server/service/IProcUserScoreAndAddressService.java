package com.deppon.dpm.module.management.server.service;

import java.util.List;

import com.deppon.dpm.module.management.shared.domain.ProcUserScoreAndAddressEntity;
import com.deppon.foss.framework.exception.BusinessException;


/**
 * 提交显示所有0分项service层接口.
 * @author 曹嵩
 * 2015.7.30
 */
public interface IProcUserScoreAndAddressService {

	/**
	 * 组装所有0分项显示信息.
	 * @return list集合
	 * @throws BusinessException
	 */
	public List<ProcUserScoreAndAddressEntity> getProcUserScoreAndAddressInfo(String userNo,String proAdress) throws BusinessException;
}

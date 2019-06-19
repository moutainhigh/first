package com.deppon.dpm.module.fssc.server.service;

import java.util.List;

import com.deppon.dpm.module.fssc.shared.domain.PriorApplicationEntity;
import com.deppon.dpm.module.fssc.shared.domain.TheoneObjEntity;
import com.deppon.foss.framework.exception.BusinessException;

/**
 * Services层接口
 * @author JFfeng
 */
public interface IThingBeforeApplyService {
	/**
	 * 根据员工工号查询所有需要的数据信息
	 * @param applyEmpNo
	 */
	public List<TheoneObjEntity> queryAllInfo(String applyEmpNo) throws BusinessException;
	
	/**
	 * 根据单据编号查询出明细的详细信息
	 * @param claimNo
	 */
	public PriorApplicationEntity queryXiangxiInfo(String claimNo);
	
}

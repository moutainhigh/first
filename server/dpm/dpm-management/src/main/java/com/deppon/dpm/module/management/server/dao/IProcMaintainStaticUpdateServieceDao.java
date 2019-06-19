package com.deppon.dpm.module.management.server.dao;

import com.deppon.dpm.module.management.shared.domain.ProcMaintainEntity;
import com.deppon.foss.framework.exception.BusinessException;

/**
 * @author 274858
 *  工程维修退回、已审核DAO
 */
public interface IProcMaintainStaticUpdateServieceDao {
    /*
     * 状态更新方法
     */
	public int updateStatus(ProcMaintainEntity parBean) throws BusinessException;
	/*
	 * 工程管理和验收 权限控制
	 */
	public int managerCheck(String userNo) throws BusinessException;
	/*
	 * 工程维修 权限控制
	 */
	public int maintainRight(String userNo) throws BusinessException;
	
	
	
}

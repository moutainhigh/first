package com.deppon.dpm.module.management.server.dao;

import java.util.Map;

import com.deppon.dpm.module.management.shared.domain.ProcMaintainEntity;

/**
 * 工程维修DAO
 * @author 王亚男
 *
 */
public interface IProcMaintainMessageDao {

	/**
	 * 获取工程维修数据
	 * @param id
	 * @return
	 */
	public ProcMaintainEntity getProcMaintainEntityById(int id);
	
	/**
	 * 修改对应的单号信息
	 * @param map -  
	 * @param is id and bill 
	 * @return
	 */
	public int updateBillById(Map<String, Object> map);
	
	/**
	 * 
	 * @param userNo
	 * @return
	 */
	public ProcMaintainEntity selectMaintain(String userNo);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public int updateApprovalMark(int id);
	
	/**
	 * 保存维修信息
	 * @param entity
	 * @return
	 */
	public int saveProcMain(ProcMaintainEntity entity);
	
}

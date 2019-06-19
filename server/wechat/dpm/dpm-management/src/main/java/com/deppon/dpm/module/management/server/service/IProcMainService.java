package com.deppon.dpm.module.management.server.service;

import com.deppon.dpm.module.management.shared.domain.DeptRepairEntity;
import com.deppon.dpm.module.management.shared.domain.ProNameEntity;
import com.deppon.dpm.module.management.shared.domain.ProcMaintainEntity;
import com.deppon.dpm.module.management.shared.vo.ResultVO;

/**
 * 
 * @author 王亚男
 *
 */
public interface IProcMainService {
	
	/**
	 * 提交接口
	 * @param entity
	 * @return
	 * @throws Exception 
	 */
	public ResultVO<Object> postMessage(ProcMaintainEntity entity) throws Exception;
	
	/**
	 * 获取项目信息接口
	 * @param proName
	 * @return
	 */
	public DeptRepairEntity getDeptMessageFromPC(String proName);
	
	public ResultVO<ProNameEntity> getProList();
	
}

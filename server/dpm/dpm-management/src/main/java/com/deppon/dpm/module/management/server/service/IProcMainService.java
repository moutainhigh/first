package com.deppon.dpm.module.management.server.service;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.deppon.dpm.module.management.shared.domain.DeptRepairEntity;
import com.deppon.dpm.module.management.shared.domain.ProNameEntity;
import com.deppon.dpm.module.management.shared.domain.ProcMaintainEntity;
import com.deppon.dpm.module.management.shared.vo.ResultVO;
import com.deppon.foss.framework.exception.BusinessException;

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
	 * @throws BusinessException 
	 * @throws IOException 
	 * @throws HttpException 
	 */
	public ResultVO<Object> postMessage(ProcMaintainEntity entity) throws BusinessException, HttpException, IOException;
	
	/**
	 * 获取项目信息接口
	 * @param proName
	 * @return
	 * @throws IOException 
	 * @throws HttpException 
	 */
	public DeptRepairEntity getDeptMessageFromPC(String proName) throws HttpException, IOException;
	
	public ResultVO<ProNameEntity> getProList() throws HttpException, IOException;
	
}

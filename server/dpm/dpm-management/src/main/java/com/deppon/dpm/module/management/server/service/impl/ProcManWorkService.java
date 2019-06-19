package com.deppon.dpm.module.management.server.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.deppon.dpm.module.common.server.service.IMonitorCountInfoService;
import com.deppon.dpm.module.common.server.util.Constants;
import com.deppon.dpm.module.management.server.dao.IProcManWorkDao;
import com.deppon.dpm.module.management.server.service.IProcMainService;
import com.deppon.dpm.module.management.server.service.IProcManWorkService;
import com.deppon.dpm.module.management.shared.domain.ProcMaintainEntity;
import com.deppon.dpm.module.management.shared.vo.ResultVO;

/**   
* @Description: 工程维修
* @author 268087 张广波
* @date 2015-11-16 下午2:18:04 
* @version V1.0 
*/
public class ProcManWorkService implements IProcManWorkService {
	private Logger logger =LoggerFactory.getLogger(ProcManWorkService.class);
	/** 
	* @Fields workDao 工程维修操作dao
	*/ 
	private IProcManWorkDao workDao;
	
	private IProcMainService repairService;
	
	/**
	 * 记录提交响应时长
	 */
	private IMonitorCountInfoService monitorCountInfoService;

	/** 
	* @Description: 获取数据监控service
	* @author 268087 张广波
	* @date 2015-11-16 下午5:21:17 
	*  @return 
	*/
	public IMonitorCountInfoService getMonitorCountInfoService() {
		return monitorCountInfoService;
	}

	/** 
	* @Description: 设置数据监控service
	* @author 268087 张广波
	* @date 2015-11-16 下午5:21:35 
	*  @param monitorCountInfoService 
	*/
	public void setMonitorCountInfoService(
			IMonitorCountInfoService monitorCountInfoService) {
		this.monitorCountInfoService = monitorCountInfoService;
	}

	/** 检查是否有重复的暂存数据
	 * @param userNo
	 * @return
	 * @see com.deppon.dpm.module.management.server.service.IProcManWorkService#checkIsRepMan(java.lang.String)
	 */
	public int checkIsRepMan(String userNo) {
		return workDao.checkIsRepMan(userNo);
	}

	/** list 列表查询 申请详情
	 * @param pid
	 * @return
	 * @see com.deppon.dpm.module.management.server.service.IProcManWorkService#queryForList(java.lang.String)
	 */
	public ProcMaintainEntity queryForList(String pid) {
		return workDao.queryForList(pid);
	}

	/** 初次保存暂存数据
	 * @param maintainEntity
	 * @param retMap
	 * @return
	 * @see com.deppon.dpm.module.management.server.service.IProcManWorkService#saveProcMan(com.deppon.dpm.module.management.shared.domain.ProcMaintainEntity, java.util.HashMap)
	 */
	
	public Map<String, Object>  saveProcMan(ProcMaintainEntity maintainEntity,HashMap<String, Object> retMap) {
		// 开始时间
		Date startDate = new Date(); 
		maintainEntity.setCreateDate(new Date());
		maintainEntity.setUpdateDate(new Date());
		try{
//			Connection con = 
			//Savepoint
/*			int retInt =  workDao.saveProcMan(maintainEntity);
			if (retInt>0) {
				
				*/
			logger.info("保存 ! 开始调用service 向PC端传送 数据");
			ResultVO<Object> resultVO = this.repairService.postMessage(maintainEntity);
			if(!resultVO.isResultFlag()){
				retMap.put("resultFlag",false);
				retMap.put("failureReason",resultVO.getMessage());
			}
			logger.info("调用service 向PC端传送 数据end");
			// 结束时间
			Date endDate = new Date(); 
			monitorCountInfoService.saveMonitorCountInfo(
			maintainEntity.getUserNo(), startDate, endDate,Constants.PROCMAINTENANCE_ISSUBMIT);
		/*	}
			else{
				retMap.put("resultFlag",false);
				retMap.put("failureReason","保存失败!");
			}*/
			retMap.put("resultFlag",true);
			retMap.put("failureReason","保存成功!");
		}catch (Exception e) {
			logger.info("出现异常事物回滚!");
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			retMap.put("resultFlag",false);
			retMap.put("failureReason","保存失败!");
		}
		return retMap;
	}

	/** 实时更新暂存数据 或 修改申请信息
	 * @param maintainEntity
	 * @param retMap
	 * @return
	 * @see com.deppon.dpm.module.management.server.service.IProcManWorkService#updateProcMan(com.deppon.dpm.module.management.shared.domain.ProcMaintainEntity, java.util.HashMap)
	 */
	
	public Map<String, Object>  updateProcMan(ProcMaintainEntity maintainEntity,HashMap<String, Object> retMap) {
		// 开始时间
		Date startDate = new Date(); 
		maintainEntity.setUpdateDate(new Date());
		try{
			int retInt =  workDao.updateProcMan(maintainEntity);
			if (retInt>0) {
				retMap.put("resultFlag",true);
				retMap.put("failureReason","更新成功!");
				logger.info("更新 ! 开始调用service 向PC端传送 数据");
				ResultVO<Object> resultVO = this.repairService.postMessage(maintainEntity);
				if(!resultVO.isResultFlag()){
					retMap.put("resultFlag",false);
					retMap.put("failureReason",resultVO.getMessage());
				}
				logger.info("调用service 向PC端传送 数据end");
				// 结束时间
				Date endDate = new Date(); 
				monitorCountInfoService.saveMonitorCountInfo(
						maintainEntity.getUserNo(), startDate, endDate,
						Constants.PROCMAINTENANCE_ISSUBMIT);
			}
			else{
				retMap.put("resultFlag",false);
				retMap.put("failureReason","更新失败!");
			}
		}catch (Exception e) {
			logger.info("出现异常事物回滚!");
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			retMap.put("resultFlag",false);
			retMap.put("failureReason","保存失败!");
		}
		return retMap;
	}
	
	
	/** 工程勘测-更新勘测单状态
	 * @param paramHashMap
	 * @return
	 * @see com.deppon.dpm.module.management.server.service.IProcManWorkService#updateSurveyState(java.util.HashMap)
	 */
	public int updateSurveyState(HashMap<String, String> paramHashMap) {
		return workDao.updateSurveyState(paramHashMap);
	}
	
	/** 
	* @Description: 获取操作dao
	* @author 268087 张广波
	* @date 2015-11-17 上午8:30:41 
	*  @return 
	*/
	public IProcManWorkDao getWorkDao() {
		return workDao;
	}
	/** 
	* @Description: 设置操作dao
	* @author 268087 张广波
	* @date 2015-11-17 上午8:30:55 
	*  @param workDao 
	*/
	public void setWorkDao(IProcManWorkDao workDao) {
		this.workDao = workDao;
	}
	public IProcMainService getRepairService() {
		return repairService;
	}
	public void setRepairService(IProcMainService repairService) {
		this.repairService = repairService;
	}	
	
}

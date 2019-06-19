package com.deppon.dpm.module.common.server.dao;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.common.shared.domain.ModuleAccessVpInfo;
import com.deppon.dpm.module.common.shared.domain.MonitorActionInfo;
import com.deppon.dpm.module.common.shared.vo.ModuleAccessVo;

/**
 * 监控Action详细信息Dao接口
 *
 */
public interface IMonitorActionInfoDao {

	/**
	 * 保存action执行详细信息
	 * 
	 * @param entity
	 */
	public int saveActionInfo(MonitorActionInfo entity);
	
	/**
	 * 获取需要监控的用户List
	 * 
	 * @return
	 */
	public List<String> queryMonitorEmpCodeList();
	
	/**
	 * 根据条件查询在区间中的访问模块次数
	 * 
	 * @return
	 */
	public Map<String,String> queryModuleAccessNum(ModuleAccessVo vo);
	
	/**
	 * 根据条件查询在区间中的vp访问模块次数信息
	 * 
	 * @return
	 */
	public List<ModuleAccessVpInfo> queryModuleAccessVpList(ModuleAccessVo vo);
	
	/**
	 * 根据条件查询在区间中的vp闪退详细信息
	 * 
	 * @return
	 */
	public List<ModuleAccessVpInfo> queryModuleAccessVpBreakdownList(ModuleAccessVo vo);
	
	/**
	 * 根据条件查询VP用户访问模块的时间明细
	 * 
	 * @return
	 */
	public List<ModuleAccessVpInfo> queryModuleAccessVpInfoList(ModuleAccessVo vo);
}

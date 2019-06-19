package com.deppon.dpm.module.common.server.dao.impl;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.common.server.dao.IMonitorActionInfoDao;
import com.deppon.dpm.module.common.shared.domain.ModuleAccessVpInfo;
import com.deppon.dpm.module.common.shared.domain.MonitorActionInfo;
import com.deppon.dpm.module.common.shared.vo.ModuleAccessVo;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 监控action执行详细信息Dao实现类
 * 
 */
public class MonitorActionInfoDaoImpl extends iBatis3DaoImpl implements
		IMonitorActionInfoDao {

	private static final String NAME_SPACE = "com.deppon.dpm.module.common.server.dao.monitoractioninfo.";

	/**
	 * 保存action执行详细信息
	 * 
	 * @param entity
	 */
	@Override
	public int saveActionInfo(MonitorActionInfo entity) {
		return this.getSqlSession().insert(NAME_SPACE + "insert", entity);
	}
	
	/**
	 * 获取需要监控的用户List
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> queryMonitorEmpCodeList(){
		return this.getSqlSession().selectList(NAME_SPACE + "queryMonitorEmpCodeList");
	}
	
	/**
	 * 根据条件查询在区间中的访问模块次数
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String,String> queryModuleAccessNum(ModuleAccessVo vo){
		// 查询数据
		Map<String,String> map = (Map<String,String>)this.getSqlSession().selectOne(NAME_SPACE+"queryModuleAccessNum",vo);
		// 返回
		return map;
	}
	
	/**
	 * 根据条件查询在区间中的vp访问模块次数信息
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ModuleAccessVpInfo> queryModuleAccessVpList(ModuleAccessVo vo){
		// 查询返回
		return this.getSqlSession().selectList(NAME_SPACE + "queryModuleAccessVpList",vo);
	}
	
	/**
	 * 根据条件查询在区间中的vp闪退详细信息
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ModuleAccessVpInfo> queryModuleAccessVpBreakdownList(ModuleAccessVo vo){
		// 查询返回
		return this.getSqlSession().selectList(NAME_SPACE + "queryModuleAccessVpBreakdownList",vo);
	}
	
	/**
	 * 根据条件查询VP用户访问模块的时间明细
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ModuleAccessVpInfo> queryModuleAccessVpInfoList(ModuleAccessVo vo){
		// 查询返回
		return this.getSqlSession().selectList(NAME_SPACE + "queryModuleAccessVpInfoList",vo);
	}
}

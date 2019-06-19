package com.deppon.dpm.module.management.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.management.server.dao.IProcMaintenanceInfoListDao;
import com.deppon.dpm.module.management.shared.domain.ProcMaintainEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
/**
 * 工程维修信息dao层实现方法.
 * @author 曹嵩
 * <p>时间:2015.9.29</p>
 */
public class ProcMaintenanceInfoListDao extends iBatis3DaoImpl implements
		IProcMaintenanceInfoListDao {
	
	private final String mapperNameSpace = "com.deppon.dpm.module.management.server.dao.procMaintenanceInfoList";
	/**
	 * 分页显示工程维修详情.
	 * @param pageNum 当前页面
	 * @param pageSize 页面显示多少条数据
	 * @param userNo 员工工号
	 * @return 工程维修信息list集合
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ProcMaintainEntity> getProcMainList(int pageNum, int pageSize,
			String userNo) {
		//map 
		Map<String,Object> params = new HashMap<String, Object>();
		//分页实现
		params.put("pageStart", (pageNum-1)*pageSize);
		//分页实现
		params.put("pageSize", pageSize);
		//工号
		params.put("userNo", userNo);
		//返回数据
		return this.getSqlSession().selectList(mapperNameSpace+".getList",params);
	}
	/**
	 * 获取工程维修信息共有多少条数据.
	 * @param userNo 员工工号
	 * @return 多少条数据
	 */
	@Override
	public int getCount(String userNo) {
		return (Integer) this.getSqlSession().selectOne(mapperNameSpace+".getCount", userNo);
	}
	/**
	 * 根据单号查询工号.
	 * @param bill 单号
	 * @return 工号
	 */
	@Override
	public String getUserNo(String bill) {
		return (String) this.getSqlSession().selectOne(mapperNameSpace+".getUserNo", bill);
	}

}

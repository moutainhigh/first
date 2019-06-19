package com.deppon.dpm.doc.server.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.deppon.dpm.doc.server.dao.IPersonIDDao;
import com.deppon.dpm.doc.server.entity.HxMsmSwitchEntity;
import com.deppon.dpm.doc.server.entity.LoadRecordEntity;
import com.deppon.dpm.module.common.shared.vo.EmployeeEntity;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 根据员工号查询人员身份信息dao实现类
 * @author wanc
 * 20171128
 */
public class PersonIDDao extends iBatis3DaoImpl implements IPersonIDDao{

	// 名称空间
	private static final String NAME_SPACE="com.deppon.dpm.doc.server.domain.EmployeeEntity.";
	
	/**
	 * 构造方法
	 */
	public PersonIDDao () {
		super();
	}
	
	/**
	 * 根据员工号查询人员身份信息
	 */
	@Override
	public EmployeeEntity queryPersonIDByID(String userId) {
		
		// 调用数据库查询方法
		Object objentity = getSqlSession().selectOne(NAME_SPACE+"queryEntityByUserId",userId);
//		EmployeeEntity empentity = getSqlSession().selectOne(userId);
		if (objentity != null) {
			return (EmployeeEntity) objentity;
		}
		return null;
	}
    /**
	 * 获取登录校验记录
	 */
	public LoadRecordEntity getloadRecord(String userId, String deviceId){
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("userId", userId);
		map.put("deviceId", deviceId);
		return (LoadRecordEntity)getSqlSession().selectOne(NAME_SPACE + "getloadRecord", map);
	}
	
	/**
	 * 欢行登陆校验新增记录
	 */
    public int addloadRecord(String userId, String deviceId, String loginTime){
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("userId", userId);
		map.put("deviceId", deviceId);
		map.put("loginTime", loginTime);
		return getSqlSession().insert(NAME_SPACE + "addloadRecord", map);
	}
    
    /**
	 * 根据工号查询员工信息
	 */
	public EmployeeEntity getEmpInfo(String userId){
		
		return (EmployeeEntity) this.getSqlSession().selectOne(NAME_SPACE + "getEmpInfo", 
				userId);
	}

	@Override
	public HxMsmSwitchEntity getHxMsmSwitch(String userId) {
		return (HxMsmSwitchEntity) getSqlSession().selectOne(NAME_SPACE + "getHxMsmSwitch", userId);
	}

	@Override
	public int updateHxMsmSwitch(String userId,String state) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("userId", userId);
		map.put("state", state);
		return getSqlSession().update(NAME_SPACE + "updateHxMsmSwitch", map);
	}

	@Override
	public int insertHxMsmSwitch(String userId) {
		return getSqlSession().insert(NAME_SPACE + "insertHxMsmSwitch", userId);
	}

}

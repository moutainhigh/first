package com.deppon.dpm.doc.server.dao;

import com.deppon.dpm.doc.server.entity.HxMsmSwitchEntity;
import com.deppon.dpm.doc.server.entity.LoadRecordEntity;
import com.deppon.dpm.module.common.shared.vo.EmployeeEntity;

/**
 * 根据员工号查询人员身份信息dao接口
 * @author wanc
 * 20171128
 */
public interface IPersonIDDao {

	/**
	 * 根据员工号查询人员身份信息
	 * @param userId
	 * @return
	 */
	public EmployeeEntity queryPersonIDByID(String userId);
    /**
	 * 获取登录校验记录
	 * @param userId
	 * @param deviceId
	 * @return
	 */
	public LoadRecordEntity getloadRecord(String userId, String deviceId);
	/**
	 * 欢行登陆校验新增记录
	 * @param userId
	 * @param deviceId
	 * @param loginTime
	 * @return
	 */
	public int addloadRecord(String userId, String deviceId, String loginTime);
	/**
	 * 查询员工信息
	 * @param userId
	 * @return
	 */
	public EmployeeEntity getEmpInfo(String userId);
	
	//根据工号查询欢行短信开关
	public HxMsmSwitchEntity getHxMsmSwitch(String userId);
	
	//根据工号更新欢行短信开关
	public int updateHxMsmSwitch(String userId,String state);
	
	//插入欢行短信开关
	public int insertHxMsmSwitch(String userId); 
}

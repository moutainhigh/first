package com.deppon.dpm.doc.server.service;

import com.deppon.dpm.doc.server.entity.HxMsmSwitchEntity;
import com.deppon.dpm.doc.server.entity.LoadRecordEntity;
import com.deppon.dpm.module.common.shared.vo.EmployeeEntity;

/**
 * 人员信息查询服务service
 * @author wanc
 * 20171116
 */
public interface IPersonIDService {
	
	/**
	 * 根据员工号查询员工身份信息
	 * @param userId
	 * @return
	 */
	public EmployeeEntity queryPersonIDByID(String userId);
    /**
	 * 判断是否需要短信校验
	 * @param userId
	 * @param deviceId
	 * @return
	 */
	public LoadRecordEntity getloadRecord(String userId, String deviceId);
	/**
	 * 新增登陆记录
	 * @param userId
	 * @param deviceId
	 * @return
	 */
	public int addloadRecord(String userId, String deviceId);
	/**
	 * 判断是否vp用户
	 * @param userId
	 * @param deviceId
	 * @return
	 */
	public boolean isSeniorLeader(String userId);
	
	//根据工号查询欢行短信开关
	public HxMsmSwitchEntity getHxMsmSwitch(String userId);
	
	//根据工号更新欢行短信开关
	public int updateHxMsmSwitch(String userId,String state);
	
	//插入欢行短信开关
	public int insertHxMsmSwitch(String userId); 
	
}

package com.deppon.dpm.doc.server.service;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.common.shared.vo.EmployeeEntity;


public interface IPersonalCenterService {
	
	/**
	 * 查询
	 * @param PersonalCenter
	 * @return
	 */
	public EmployeeEntity queryPersonIDByID(String userId);
	/**
	 * 查询是否有重复手机号
	 * @param userTel
	 * @return
	 */
    public List<String> getTelCount(String userTel);
	/**
	 * 更新
	 * @param PersonalCenter
	 * @return
	 */
	public int update(String userId,String userTel);
	/**
	 * 新增
	 * @param PersonalCenter
	 * @return
	 */
	public int insert(String userId,String userTel);
	
	public int batchInsertPersonalC(List<String> list);
	
	public int OperationPersonalc(String userId,String userTel);
	
	public int insertOaTel(String userId);
	
	public String getOaTel(String userId);
	
	public List<String> queryLeaveEmployees(String date);
	
	public int getTotalCount(String userId,String userTel);
	
	public List<Map<String,Object>> getPersonalContacts(String userId,String userTel,int beginNum);
	
}

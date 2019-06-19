package com.deppon.dpm.doc.server.dao;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.common.shared.vo.EmployeeEntity;

/**滴滴个人中心
 * @author 
 *
 */
public interface IPersonalCenterDao {
	/**
	 * 更新
	 * @param PersonalCenter
	 * @return
	 */
	public int update(String userId,String userTel);
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
	 * 新增
	 * @param PersonalCenter
	 * @return
	 */
	public int insert(String userId,String userTel);
	public int batchInsertPersonalC(List<String> list);
	/**
	 * 新增oa手机号
	 * @param userId
	 * @return
	 */
	public int insertOaTel(String userId);
	
	public String getOaTel(String userId);
	
	public List<String> queryLeaveEmployees(String date);
	
	public int getTotalCount(String userId,String userTel);
	
	public List<Map<String,Object>> getPersonalContacts(String userId,String userTel,int beginNum);
	
}

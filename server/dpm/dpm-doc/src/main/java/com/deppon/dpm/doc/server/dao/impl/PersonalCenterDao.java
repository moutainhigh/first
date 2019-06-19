package com.deppon.dpm.doc.server.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deppon.dpm.doc.server.dao.IPersonalCenterDao;
import com.deppon.dpm.module.common.shared.vo.EmployeeEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 个人中心功能调用接口
 * 
 * @author gwl
 *
 */
public class PersonalCenterDao extends iBatis3DaoImpl  implements IPersonalCenterDao{
	
	private static final String NAME_SPACE="com.deppon.dpm.doc.server.domain.EmployeeEntity.";
	
	/**
	 * 查询
	 * @author Administrator
	 *
	 */
	@Override
	public EmployeeEntity queryPersonIDByID(String userId) {
		Object objentity = getSqlSession().selectOne(NAME_SPACE+"queryPersonalCByUserId",userId);
//		EmployeeEntity empentity = getSqlSession().selectOne(userId);
		if (objentity != null) {
			return (EmployeeEntity) objentity;
		}
		return null;
	}
	
	/**
	 * 查询是否有重复手机号
	 * @param userTel
	 * @return
	 */
    @SuppressWarnings("unchecked")
	public List<String> getTelCount(String userTel){
		
		return (List<String>) this.getSqlSession().selectList(NAME_SPACE+"getTelCount",userTel);
	}
    
    /**
     * 查询前一天离职人员的工号
     * @param date String yyyy-mm-dd
     * @return 
     */
    @SuppressWarnings("unchecked")
	public List<String> queryLeaveEmployees(String date){
    	return (List<String>) this.getSqlSession().selectList(NAME_SPACE+"queryLeaveEmployees",date);
    }
	
	/**
	 * 更新
	 * @author Administrator
	 *
	 */
	@Override
	public int update(String userId,String userTel) {
		Map<String,String> map = new HashMap<String,String>();
    	map.put("userId", userId);
    	map.put("userTel", userTel);
		return this.getSqlSession().update(NAME_SPACE+"updatePersonalC",map);
	}
	
	/**
	 * 新增
	 * @author Administrator
	 *
	 */
	@Override
	public int insert(String userId,String userTel) {
		Map<String,String> map = new HashMap<String,String>();
    	map.put("userId", userId);
    	map.put("userTel", userTel);
		return this.getSqlSession().insert(NAME_SPACE+"insertPersonalC",map);
	}
	
	public int batchInsertPersonalC(List<String> list){
		return this.getSqlSession().insert(NAME_SPACE+"batchInsertPersonalC",list);
	}
	
	/**
	 * 添加oa手机号为欢行手机号
	 * @param userId
	 * @return
	 */
	public int insertOaTel(String userId){
		
		return this.getSqlSession().insert(NAME_SPACE+"insertOaTel",userId);
	}
	
	/**
	 * 添加oa手机号为欢行手机号
	 * @param userId
	 * @return
	 */
	public String getOaTel(String userId){
		
		return (String) this.getSqlSession().selectOne(NAME_SPACE+"getOaTel",userId);
	}
	
	public int getTotalCount(String userId,String userTel){
		Map<String,String> map = new HashMap<String,String>();
    	map.put("userId", userId);
    	map.put("userTel", userTel);
		return (int) this.getSqlSession().selectOne(NAME_SPACE+"getTotalCount",map);
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> getPersonalContacts(String userId,String userTel,int beginNum){
		Map<String,Object> map = new HashMap<String,Object>();
    	map.put("userId", userId);
    	map.put("userTel", userTel);
    	map.put("beginNum", beginNum);
		return (List<Map<String,Object>>)this.getSqlSession().selectList(NAME_SPACE+"getPersonalContacts",map);
	}
}

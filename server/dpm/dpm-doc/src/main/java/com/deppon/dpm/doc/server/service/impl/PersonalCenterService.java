package com.deppon.dpm.doc.server.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.doc.server.dao.IPersonalCenterDao;
import com.deppon.dpm.doc.server.service.IPersonalCenterService;
import com.deppon.dpm.module.common.shared.vo.EmployeeEntity;

/**
 * 个人中心功能调用接口
 * 
 * @author gwl
 * 
 */

public class PersonalCenterService implements IPersonalCenterService {
	private static final Logger LOG = LoggerFactory
			.getLogger(PersonalCenterService.class);
	private IPersonalCenterDao personalCenterDao;

	/*
	 * 构造方法
	 */
	public PersonalCenterService() {
		super();
	}

	/*
	 * 根据userId返回个人信息
	 */
	@Override
	public EmployeeEntity queryPersonIDByID(String userId) {
		return personalCenterDao.queryPersonIDByID(userId);
	}
	
	/*
	 * 查询是否有重复手机号
	 */
    public List<String> getTelCount(String userTel){
    	
    	return personalCenterDao.getTelCount(userTel);
    }

	/*
	 * 根据userId更新个人信息
	 */
	@Override
	public int update(String userId, String userTel) {
		return personalCenterDao.update(userId, userTel);
	}

	/*
	 * 新增个人信息
	 */
	@Override
	public int insert(String userId, String userTel) {
		return personalCenterDao.insert(userId, userTel);
	}
	
	@Override
	public int insertOaTel(String userId){
		return personalCenterDao.insertOaTel(userId);
	}

	/*
	 * getPersonalCenterDao
	 */
	public IPersonalCenterDao getPersonalCenterDao() {
		return personalCenterDao;
	}

	/*
	 * setPersonalCenterDao
	 */
	public void setPersonalCenterDao(IPersonalCenterDao personalCenterDao) {
		this.personalCenterDao = personalCenterDao;
	}

	public int OperationPersonalc(String userId, String userTel) {
		int aa = 0;

		if (userId == null || userId.length() < 1 || userTel == null
				|| userTel.length() < 1) {
			LOG.debug("新增或更新个人信息异常，传参不正确》》》》》》》》");
		} else {
			// 调用接口查询方法根据ID查询电话号码并返回
			/*EmployeeEntity empentity = queryPersonIDByID(userId);
			if (empentity == null) {
				aa = insert(userId, userTel);
			} else {
				// String qeyuserTel = empentity.getMobileNo();
				// 调用接口update方法根据ID更新电话信息
				aa = update(userId, userTel);
			}*/
			//改为每次修改 新增一条数据
			aa = insert(userId, userTel);
		}
		return aa;

	}
	
	public int batchInsertPersonalC(List<String> list){
		return personalCenterDao.batchInsertPersonalC(list);
	}
	
	public List<String> queryLeaveEmployees(String date){
		return personalCenterDao.queryLeaveEmployees(date);
	}
	
	
	public String getOaTel(String userId){
		return personalCenterDao.getOaTel(userId);
	}
	
	public int getTotalCount(String userId,String userTel){
		return personalCenterDao.getTotalCount(userId,userTel);
	}
	
	public List<Map<String,Object>> getPersonalContacts(String userId,String userTel,int beginNum){
		return personalCenterDao.getPersonalContacts(userId,userTel,beginNum);
	}

}

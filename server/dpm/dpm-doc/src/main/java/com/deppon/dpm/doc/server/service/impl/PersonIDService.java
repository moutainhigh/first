package com.deppon.dpm.doc.server.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.deppon.dpm.doc.server.dao.IPersonIDDao;
import com.deppon.dpm.doc.server.entity.HxMsmSwitchEntity;
import com.deppon.dpm.doc.server.entity.LoadRecordEntity;
import com.deppon.dpm.doc.server.service.IPersonIDService;
import com.deppon.dpm.module.common.shared.vo.EmployeeEntity;

/**
 * 人员信息查询服务实现类
 * @author wanc
 * 20171116
 */
public class PersonIDService implements IPersonIDService{

	// 注入dao层引用接口
	private IPersonIDDao personiddao;
	
	/**
	 * 构造方法
	 */
	public PersonIDService (){
		super();
	}
	
	/**
	 * 根据员工号查询员工身份信息
	 */
	@Override
	public EmployeeEntity queryPersonIDByID(String userId) {
		return personiddao.queryPersonIDByID(userId);
	}
	
    /**
	 * 判断是否需要短信校验
	 * @param userId
	 * @param deviceId
	 * @return
	 */
	public LoadRecordEntity getloadRecord(String userId, String deviceId){
		LoadRecordEntity lrEntity = personiddao.getloadRecord(userId, deviceId);
		if(lrEntity != null && lrEntity.getId() > 0){
			if(!lrEntity.getUserId().equals(userId)){
				//工号不一致
				lrEntity.setDistinct(1);
			}else if(!lrEntity.getDeviceId().equals(deviceId)){
				//设备号不一致
				lrEntity.setDistinct(2);
			}else{
				//工号设备号都一致，无需短信验证
				lrEntity.setDistinct(0);
			}
		}else{
			//首次进入 存储当前登录信息
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date dt = new Date();   
		    String loginTime = sdf.format(dt);
			int res = personiddao.addloadRecord(userId, deviceId, loginTime);
			lrEntity = new LoadRecordEntity();
			lrEntity.setDistinct(4);	
			lrEntity.setUserId(userId);
			lrEntity.setDeviceId(deviceId);
		}
		return lrEntity;
	}
	
    /**
	 * 新增登陆记录
	 * @param userId
	 * @param deviceId
	 * @return
	 */
	public int addloadRecord(String userId, String deviceId){

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dt = new Date();   
		String loginTime = sdf.format(dt);
		
		int res = personiddao.addloadRecord(userId, deviceId, loginTime);

		return res;
	}

    /**
	 * 判断是否vp用户
	 * @param userId
	 * @param deviceId
	 * @return
	 */
	public boolean isSeniorLeader(String userId){
		EmployeeEntity empVo = personiddao.getEmpInfo(userId);
		boolean isSeniorLeader = false;
		if(empVo != null)
		isSeniorLeader =  (empVo.getJobLevel().compareTo("10") != -1 && empVo.getJobGroups().equals("管理族群"))||
	            empVo.getJobName().contains("秘书") || empVo.getJobName().contains("总裁助理");
		return isSeniorLeader;
	}
	
	/**
	 *  通过spring注入值
	 * @param personiddao
	 */
	public void setPersoniddao(IPersonIDDao personiddao) {
		this.personiddao = personiddao;
	}

	@Override
	public HxMsmSwitchEntity getHxMsmSwitch(String userId) {
		return personiddao.getHxMsmSwitch(userId);
	}

	@Override
	public int updateHxMsmSwitch(String userId,String state) {
		return personiddao.updateHxMsmSwitch(userId,state);
	}

	@Override
	public int insertHxMsmSwitch(String userId) {
		return personiddao.insertHxMsmSwitch(userId);
	}
	
	
	
}

package com.deppon.dpm.module.main.server.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.doc.server.dao.IDiDiPointDao;
import com.deppon.dpm.doc.server.service.IDiDiPointService;
import com.deppon.dpm.doc.server.vo.DiDiPointVo;
import com.deppon.dpm.module.main.server.dao.IMessagePointDao;
import com.deppon.dpm.module.main.server.service.IMessagePointService;
import com.deppon.dpm.module.main.shared.domain.MessagePointVo;

public class MessagePointService implements IMessagePointService {
	
	private static final Logger LOG = LoggerFactory.getLogger(MessagePointService.class);
	
	private IMessagePointDao messagePointDao;
	
	/*
	 * 查询提示
	 */
	public MessagePointVo getPoint(String appId){
		
		return messagePointDao.getPoint(appId);
	}
	
	/*
	 * 查询已添加的提示
	 */
	public List<MessagePointVo> getAllPoint(int start,int pageSize){
		
		return messagePointDao.getAllPoint(start,pageSize);
	}
	
	/*
	 * 添加提示
	 */
	public int insertPoint(MessagePointVo pointVo){
		
		return messagePointDao.insertPoint(pointVo);
	}
	
	/*
	 * 查询条数
	 */
	public int getCount(){
		
		return messagePointDao.getCount();
	}
	
	/*
	 * 更新状态
	 */
	public int updateState(int pointId){
		
		return messagePointDao.updateState(pointId);
	}

	public IMessagePointDao getMessagePointDao() {
		return messagePointDao;
	}

	public void setMessagePointDao(IMessagePointDao messagePointDao) {
		this.messagePointDao = messagePointDao;
	}
	
	
	

	
	

}

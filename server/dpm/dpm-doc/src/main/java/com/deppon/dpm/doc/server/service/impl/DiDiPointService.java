package com.deppon.dpm.doc.server.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.doc.server.dao.IDiDiPointDao;
import com.deppon.dpm.doc.server.service.IDiDiPointService;
import com.deppon.dpm.doc.server.vo.DiDiPointVo;

public class DiDiPointService implements IDiDiPointService {
	
	private static final Logger LOG = LoggerFactory.getLogger(DiDiPointService.class);
	
	private IDiDiPointDao didiPointDao;
	
	/*
	 * 查询提示
	 */
	public DiDiPointVo getPoint(){
		
		return didiPointDao.getPoint();
	}
	
	/*
	 * 查询已添加的提示
	 */
	public List<DiDiPointVo> getAllPoint(int start,int pageSize){
		
		return didiPointDao.getAllPoint(start,pageSize);
	}
	
	/*
	 * 添加提示
	 */
	public int insertPoint(DiDiPointVo pointVo){
		
		return didiPointDao.insertPoint(pointVo);
	}
	
	/*
	 * 查询条数
	 */
	public int getCount(){
		
		return didiPointDao.getCount();
	}
	
	/*
	 * 更新状态
	 */
	public int updateState(int pointId){
		
		return didiPointDao.updateState(pointId);
	}
	
	
	

	public IDiDiPointDao getDidiPointDao() {
		return didiPointDao;
	}

	public void setDidiPointDao(IDiDiPointDao didiPointDao) {
		this.didiPointDao = didiPointDao;
	}
	

}

package com.deppon.dpm.doc.server.service.impl;

import java.util.List;

import com.deppon.dpm.doc.server.dao.IDepositorDao;
import com.deppon.dpm.doc.server.service.IDepositorService;
import com.deppon.dpm.doc.server.vo.DidiBankCardVO;

public class DepositorService implements IDepositorService{
	
	//注入公款存户的Dao
	private IDepositorDao depositorDao;
	
	public IDepositorDao getDepositorDao() {
		return depositorDao;
	}


	public void setDepositorDao(IDepositorDao depositorDao) {
		this.depositorDao = depositorDao;
	}

	
	/**
	 * 新增对公账号
	 */
	@Override
	public int insertAccount(DidiBankCardVO didiBankCardvo) {		
		return depositorDao.insertAccount(didiBankCardvo);
	}
	
	/**
	 * 根据部门名称查询对公账号
	 */
	@Override
	public List<DidiBankCardVO> queryByDeptName(String orgName) {
		return depositorDao.queryByDeptName(orgName);
	}

	/**
	 * 删除对公账号
	 */

	@Override
	public int delete(String id) {
		return depositorDao.delete(id);
	}


	@Override
	public int query(String employeeno) {
		return depositorDao.query(employeeno);
	}


	@Override
	public String queryById(String id) {
		return depositorDao.queryById(id);
	}


	@Override
	public String queryByUserid(String userId) {
		return depositorDao.queryByUserid(userId);
	}
	
}

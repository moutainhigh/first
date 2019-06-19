package com.deppon.dpm.doc.server.dao;

import java.util.List;

import com.deppon.dpm.doc.server.vo.DidiBankCardVO;

public interface IDepositorDao {
	/**
	 * 新增对公账号
	 * @param didiBankCardvo
	 * @return
	 */
	int insertAccount(DidiBankCardVO didiBankCardvo);
	/**
	 * 根据部门名称查询对公账号
	 * @param orgName
	 * @return
	 */
	List<DidiBankCardVO> queryByDeptName(String orgName);
	
	/**
	 * 根据id删除账号
	 * 
	 */
	public int delete(String id);
	
	/*
	 * 根据工号查询员工每天公款存户打车次数
	 * */
	public int query(String employeeno);

	public String queryById(String id);
	
	public String queryByUserid(String userId);
}

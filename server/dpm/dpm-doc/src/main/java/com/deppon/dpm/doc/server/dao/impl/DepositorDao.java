package com.deppon.dpm.doc.server.dao.impl;

import java.util.List;

import com.deppon.dpm.doc.server.dao.IDepositorDao;
import com.deppon.dpm.doc.server.vo.DidiBankCardVO;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class DepositorDao extends iBatis3DaoImpl implements IDepositorDao{
	
	private static final String NAME_SPACE="com.deppon.dpm.doc.server.dao.DidiBankCardDAO";
	
	/**
	 * 新增对公账号
	 * @author lvdf
	 */
	@Override
	public int insertAccount(DidiBankCardVO didiBankCardvo) {	
		try {
			int a=this.getSqlSession().insert(NAME_SPACE+".insertAccount", didiBankCardvo);
			return a;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 根据部门名称查询对公账号
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DidiBankCardVO> queryByDeptName(String orgName) {
		return this.getSqlSession().selectList(NAME_SPACE+".queryByDeptName", orgName);
	}

	@Override
	public int delete(String id) {
		return this.getSqlSession().delete(NAME_SPACE+".deletebyid", id);
	}

	@Override
	public int query(String employeeno) {
		return (Integer) this.getSqlSession().selectOne(NAME_SPACE+".query",employeeno);
	}

	@Override
	public String queryById(String id) {
		return (String) this.getSqlSession().selectOne(NAME_SPACE+".queryById",id);
	}

	@Override
	public String queryByUserid(String userId) {
		
		return (String) this.getSqlSession().selectOne(NAME_SPACE+".queryByUserid",userId);
	}

}

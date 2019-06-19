package com.deppon.dpm.module.management.server.dao.impl;

import java.util.List;

import com.deppon.dpm.module.management.server.dao.IStandardTableDao;
import com.deppon.dpm.module.management.shared.domain.StandardTableEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * @author 王亚男
 * 验收明细基础信息表同步
 */
public class StandardTableDao extends iBatis3DaoImpl 
implements IStandardTableDao {
	
	private String mapperNameSpace = "com.deppon.dpm.module.management.server.dao.procCheckStandard";

	/**
	 * 批量插入基础数据信息
	 * @param list
	 */
	@Override
	public void insertTable(List<StandardTableEntity> list) {
		this.getSqlSession().insert(mapperNameSpace+".insertTable",list);
	}

	
	/**
	 * 查询验收明细基础信息是否存在
	 * @param standCode
	 * @return
	 */
	@Override
	public int hasStandardCheck(String standardCode) {
		// TODO Auto-generated method stub
		return (Integer) this.getSqlSession().selectOne(mapperNameSpace+".hasStandardCheck", standardCode);
	}
	
	
	/**
	 * 查询所有明细信息
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<StandardTableEntity> getStandardAll() {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(mapperNameSpace+".getList");
	}
	

	/**
	 * 批量修改验收明细基础信息
	 * @param list
	 */
	@Override
	public int updateTable(List<StandardTableEntity> list) {
		// TODO Auto-generated method stub
		return this.getSqlSession().update(mapperNameSpace+".updateTable", list);
	}

	/**
	 * 批量删除验收明细基础信息
	 * @param list
	 * @return
	 */
	@Override
	public int deleteStandardInfo(List<StandardTableEntity> list) {
		// TODO Auto-generated method stub
		return this.getSqlSession().update(mapperNameSpace+".deleteStandardInfo", list);
	}

	/**
	 * 根据区域信息查询 验收明细信息
	 * @param navCode
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<StandardTableEntity> getStandardListByNavCode(String navCode) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(mapperNameSpace+".getListByNavCode", navCode);
	}

}

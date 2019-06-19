package com.deppon.dpm.module.management.server.dao.impl;

import java.util.Map;

import com.deppon.dpm.module.management.server.dao.IProcMaintainMessageDao;
import com.deppon.dpm.module.management.shared.domain.ProcMaintainEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 
 * @author 王亚男
 * 工程维修dao
 *
 */
public class ProcMaintainMessageDao extends iBatis3DaoImpl implements IProcMaintainMessageDao {

	String nameSpace = "com.deppon.dpm.module.management.server.dao.procMaintainMessage";
	
	String workNameSpace = "com.deppon.dpm.module.management.server.dao.manWorkSet";
	
	/**
	 * 获取工程维修数据
	 * @param id
	 * @return
	 */
	public ProcMaintainEntity getProcMaintainEntityById(int id) {
		return (ProcMaintainEntity) this.getSqlSession().selectOne(nameSpace+".getMaintain", id);
	}

	/**
	 * 修改对应的单号信息
	 * @param map -  
	 * @param is id and bill 
	 * @return
	 */
	public int updateBillById(Map<String, Object> map) {
		return this.getSqlSession().update(nameSpace+".updateBillById", map);
	}
	

	/**
	 * @param userNo
	 * @return
	 */
	public ProcMaintainEntity selectMaintain(String userNo) {
		return (ProcMaintainEntity)this.getSqlSession().selectOne(workNameSpace+".queryForBtn", userNo);
	}

	/**
	 * @param id
	 * @return
	 */
	public int updateApprovalMark(int id) {
		return this.getSqlSession().update(nameSpace+".updateApprovalMarkById", id);
	}

	/**
	 * 保存维修信息
	 * @param entity
	 * @return
	 */
	public int saveProcMain(ProcMaintainEntity entity) {
		return this.getSqlSession().insert(nameSpace+".saveMainInfo", entity);
	}

}

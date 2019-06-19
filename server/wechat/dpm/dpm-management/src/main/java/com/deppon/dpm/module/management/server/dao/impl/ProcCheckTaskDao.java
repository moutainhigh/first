package com.deppon.dpm.module.management.server.dao.impl;

import com.deppon.dpm.module.management.server.dao.IProcCheckTaskDao;
import com.deppon.dpm.module.management.shared.domain.ProcCheckTaskEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class ProcCheckTaskDao  extends iBatis3DaoImpl implements IProcCheckTaskDao {
	String nameSpace = "com.deppon.dpm.module.management.server.dao.manWorkSet";
	/** 
	* @Description: 保存验收任务
	* @author 268087 张广波
	* @date 2015-8-12 上午11:00:33 
	*  @param checkTaskEntity
	*  @return 
	*/
	public int saveCheckTask(ProcCheckTaskEntity checkTaskEntity) {
		return this.getSqlSession().insert(nameSpace+".saveCheckTask", checkTaskEntity);
	}

	/** 
	* @Description: 根据当前登录人工号查询验收任务数量
	* @author 268087 张广波
	* @date 2015-8-14 下午3:39:14 
	*  @param empNo
	*  @return 
	*/
	public int queryTaskCount(String empNo) {		
		return (Integer)this.getSqlSession().selectOne(nameSpace+".selectTaskNumByEmpNo", empNo);
	}
	
	/** 
	* @Description: 校验项目编号是否重复
	* @author 268087 张广波
	* @date 2015-8-27 上午9:13:21 
	*  @param deptCode
	*  @return 
	*/
	public int checkDeptCode(String deptCode) {
		int retInt = 0;
		retInt = (Integer)this.getSqlSession().selectOne(nameSpace+".checkDeptCode", deptCode);
		return retInt;
	}
	
	
	/** 
	* @Description: 如果状态为0的验收任务，直接修改信息
	* @author 268087 张广波
	* @date 2015-9-6 下午5:23:19 
	*  @param deptCode
	*  @return 
	*/
	public int checkDeptCodeZero(String deptCode) {
		int retInt = 0;
		retInt = (Integer)this.getSqlSession().selectOne(nameSpace+".checkDeptCodeZero", deptCode);
		return retInt;
	}
	
	/** 
	* @Description: 更新验收任务
	* @author 268087 张广波
	* @date 2015-9-6 下午5:24:12 
	*  @param checkTaskEntity
	*  @return 
	*/
	public int updateCheckTask(ProcCheckTaskEntity checkTaskEntity) {
		return this.getSqlSession().insert(nameSpace+".updateCheckTask", checkTaskEntity);
	}
	
}

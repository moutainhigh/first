package com.deppon.dpm.module.management.server.dao.impl;

import java.util.HashMap;
import java.util.List;

import com.deppon.dpm.module.management.server.dao.IReserveManWorkDao;
import com.deppon.dpm.module.management.shared.vo.ReserveManWorkVO;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

public class ReserveManWorkDao extends iBatis3DaoImpl  implements IReserveManWorkDao {
	String namespace = "com.deppon.dpm.module.management.server.dao.manWorkSet";
	/** 
	* @Description: 根据当前工号，组织架构编码判断当前传入工号的员工是否是管理员
	* @author 268087 张广波
	* @date 2015-10-20 下午2:09:02 
	*  @param userNo  传入的工号
	*  @param orgCode 传入要判断的组织架构编码
	*  @return 
	*/
	public int checkIsAdmByOrgCode(HashMap<String, String> paramHashMap){
		return (Integer)getSqlSession().selectOne(namespace+".checkIsAdmByOrgCode", paramHashMap);
	}
	
	/** 
	* @Description: 根据查询条件查询当前工号预订列表
	* @author 268087 张广波
	* @date 2015-10-21 上午11:29:00 
	*  @param paramHashMap
	*  @return 
	*/
	public List<ReserveManWorkVO> queryResList(HashMap<String, String> paramHashMap){
		return getSqlSession().selectList(namespace+".queryResList", paramHashMap);
	}
}

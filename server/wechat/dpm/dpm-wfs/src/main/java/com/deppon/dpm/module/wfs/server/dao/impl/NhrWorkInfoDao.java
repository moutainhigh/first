package com.deppon.dpm.module.wfs.server.dao.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.deppon.dpm.module.wfs.server.dao.INhrWorkInfoDao;
import com.deppon.dpm.module.wfs.shared.domain.nhr.NhrQueryUserInfo;
import com.deppon.dpm.module.wfs.shared.vo.NhrQueryParamVo;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * Dao接口实现类
 * 
 */
public class NhrWorkInfoDao extends iBatis3DaoImpl implements INhrWorkInfoDao {

	/**
	 * 命名空间
	 */
	public static final String NAMESPACE = "com.deppon.dpm.module.wfs.server.dao.workitems.";

	/**
	 * 分页查询人员信息
	 * 
	 * @param paramVo
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<NhrQueryUserInfo> queryUserInfoWithPage(NhrQueryParamVo paramVo) {
		// 分页
		RowBounds bounds = new RowBounds((paramVo.getPageNo() - 1) * paramVo.getPageSize(), paramVo.getPageSize());
		// 查询数据
		return getSqlSession().selectList(NAMESPACE + "queryUserInfoWithPage",paramVo, bounds);
	}

}

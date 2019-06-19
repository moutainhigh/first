package com.deppon.dpm.module.wfs.server.dao;

import java.util.List;

import com.deppon.dpm.module.wfs.shared.domain.nhr.NhrQueryUserInfo;
import com.deppon.dpm.module.wfs.shared.vo.NhrQueryParamVo;

/**
 * Dao接口
 *
 */
public interface INhrWorkInfoDao {

	/**
	 * 分页查询人员信息
	 * 
	 * @param paramVo
	 * @return
	 */
	public List<NhrQueryUserInfo> queryUserInfoWithPage(NhrQueryParamVo paramVo);
	
}

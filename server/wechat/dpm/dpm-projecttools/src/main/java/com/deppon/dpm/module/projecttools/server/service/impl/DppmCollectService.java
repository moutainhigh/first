package com.deppon.dpm.module.projecttools.server.service.impl;

import com.deppon.dpm.module.projecttools.server.dao.IDppmCollectDao;
import com.deppon.dpm.module.projecttools.server.service.IDppmCollectService;
import com.deppon.dpm.module.projecttools.shared.vo.CollectVo;
/**
 * 项目管理 我的关注 service
 * @author gcl
 */
public class DppmCollectService implements IDppmCollectService {
	// 引入 dao层
	private IDppmCollectDao dao;
	
	/**
	 *  收藏
	 *  @param vo 收藏信息vo
	 *  @throws Exception
	 */
	@Override
	public int dppmCollect(CollectVo vo) throws Exception {
		// 调用 收藏方法
        return this.dao.dppmCollect(vo);
	}

	/**
	 * @param dao
	 */
	public void setDao(IDppmCollectDao dao) {
		this.dao = dao;
	}
	
}

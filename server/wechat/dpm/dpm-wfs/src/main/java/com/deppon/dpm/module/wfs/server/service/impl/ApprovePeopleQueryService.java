package com.deppon.dpm.module.wfs.server.service.impl;

import java.util.List;

import com.deppon.dpm.module.wfs.server.dao.IApprovePeopleQueryDao;
import com.deppon.dpm.module.wfs.server.service.IApprovePeopleQueryService;
import com.deppon.dpm.module.wfs.shared.domain.ApprovePeopleInfo;

/**
 * <p>ClassName: 下一个审批人查询</p>
 * <p>Description: TODO</p>
 * <p>Author: 石学钢</p>
 * <p>Date: 2015-8-26</p>
 */
public class ApprovePeopleQueryService implements IApprovePeopleQueryService{
	/**审批人查询dao*/
	private IApprovePeopleQueryDao queryDao;
	/** 
	 * @return String 下一个审批人
	 */
	@Override
	public List<ApprovePeopleInfo> approvePeopleQeury(String processinstId) {
		return queryDao.approveQeury(processinstId);
	}
	public void setQueryDao(IApprovePeopleQueryDao queryDao) {
		this.queryDao = queryDao;
	}

}

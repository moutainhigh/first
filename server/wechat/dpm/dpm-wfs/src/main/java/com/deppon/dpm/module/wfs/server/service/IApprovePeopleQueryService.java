package com.deppon.dpm.module.wfs.server.service;

import java.util.List;

import com.deppon.dpm.module.wfs.shared.domain.ApprovePeopleInfo;

public interface IApprovePeopleQueryService {
	public List<ApprovePeopleInfo> approvePeopleQeury(String processinstId);
}

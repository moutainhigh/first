package com.deppon.dpm.module.wfs.server.dao;

import java.util.List;

import com.deppon.dpm.module.wfs.shared.domain.ApprovePeopleInfo;

public interface IApprovePeopleQueryDao {
    public List<ApprovePeopleInfo> approveQeury(String processinstId);
}

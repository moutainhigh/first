package com.deppon.dpm.module.wfs.server.service;

import com.deppon.dpm.module.wfs.shared.domain.acms.AcmsApproveParam;
import com.deppon.dpm.module.wfs.shared.domain.acms.WorkflowinfoRequest;



public interface IAcmsWorkInfoService {

	public String queryWorkInfo(WorkflowinfoRequest workfinfo);
	public String approveWorkInfo(AcmsApproveParam audit);
}

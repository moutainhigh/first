package com.deppon.dpm.module.wfs.server.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.wfs.server.service.IAcmsWorkInfoService;
import com.deppon.dpm.module.wfs.server.util.RestfulUtil;
import com.deppon.dpm.module.wfs.shared.domain.acms.AcmsApproveParam;
import com.deppon.dpm.module.wfs.shared.domain.acms.WorkflowinfoRequest;

public class AcmsWorkInfoService implements IAcmsWorkInfoService {

	private static Logger logger  = LoggerFactory.getLogger(AcmsWorkInfoService.class);
    //服务端查询接口地址
	private String query;
	//服务端审批接口地址
	private String approve;
	
	
		/**
		 * 工作流查询
		 * */
		@Override
		public String queryWorkInfo(WorkflowinfoRequest workfinfo) {
			logger.info("acms query url is :" + this.query);
			return RestfulUtil.querylmsInfo(this.query,workfinfo);
		}
		
       /**
        * 工作流审批
        * */
		@Override
		public String approveWorkInfo(AcmsApproveParam param) {
			logger.info("acms approve url is:--------"+this.approve);
			return RestfulUtil.querylmsInfo(this.approve,param);
		}

	
	/**
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}
	/**
	 * @param query the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
	}
	/**
	 * @return the approve
	 */
	public String getApprove() {
		return approve;
	}
	/**
	 * @param approve the approve to set
	 */
	public void setApprove(String approve) {
		this.approve = approve;
	}
	
	
}

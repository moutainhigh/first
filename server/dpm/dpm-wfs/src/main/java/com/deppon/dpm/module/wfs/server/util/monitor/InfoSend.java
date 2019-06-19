package com.deppon.dpm.module.wfs.server.util.monitor;

import java.util.List;

import com.deppon.dpm.module.news.server.service.ITpushNewsService;
import com.deppon.dpm.module.news.shared.domain.NewsCenterEntity;
import com.deppon.dpm.module.wfs.server.service.IApprovePeopleQueryService;
import com.deppon.dpm.module.wfs.server.util.WorkFlowUtils;
import com.deppon.dpm.module.wfs.shared.domain.ApprovePeopleInfo;
import com.deppon.dpm.module.wfs.util.Constants;


/**
 * <p>ClassName: 线程审批信息推送</p>
 * <p>Description: TODO</p>
 * <p>Author: 石学钢</p>
 * <p>Date: 2015-8-11</p>
 */
public class InfoSend implements Runnable{
	public IApprovePeopleQueryService approveService;
	public ITpushNewsService tpushNewsService;
	public String processinstid;
	@Override
	public void run() {
        
            try {
				// 向下一个审批人推送审批信息
				List<ApprovePeopleInfo> peopleInfos = approveService
				        .approvePeopleQeury(processinstid);
				NewsCenterEntity newsEntity = new NewsCenterEntity("工作流审批", Constants.CONSTANT_SIX, 1,
				        0, "你有一条工作流需要审批!");
				String nextApproveUsers = WorkFlowUtils
				        .getApproveUsers(peopleInfos);
				if (!"".equals(nextApproveUsers)) {
				    tpushNewsService.pushUserNews(nextApproveUsers, "工作流审批",
				            "你有一条工作流需要审批!", newsEntity);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
        
	}
}

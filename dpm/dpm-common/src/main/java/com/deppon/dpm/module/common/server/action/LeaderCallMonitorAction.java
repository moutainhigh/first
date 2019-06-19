package com.deppon.dpm.module.common.server.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.service.ILeaderCallMonitorService;
import com.deppon.dpm.module.common.shared.domain.LeaderCallMonitorEntity;
import com.opensymphony.xwork2.ModelDriven;

public class LeaderCallMonitorAction extends BaseAction implements ModelDriven<LeaderCallMonitorEntity>{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LoggerFactory.getLogger(LeaderCallMonitorAction.class);
	
	private LeaderCallMonitorEntity entity = new LeaderCallMonitorEntity();
	
	private ILeaderCallMonitorService leaderCallMonitorService;
	
	@Override
	public LeaderCallMonitorEntity getModel() {
		return entity;
	}

	/**
	 * 监控副总电话被呼入呼出的记录
	 */
	public void save () {
		int type = 0;
		try {
			leaderCallMonitorService.save(entity);
			type = 1;
		} catch (Exception e) {
			LOG.error("保存副总呼叫监控信息出错!!! params = " + entity.getParams() ,e);
		}
		writeToPage(type);
	}

	public void setLeaderCallMonitorService(
			ILeaderCallMonitorService leaderCallMonitorService) {
		this.leaderCallMonitorService = leaderCallMonitorService;
	}
	
}

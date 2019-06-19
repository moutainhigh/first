package com.deppon.dpm.module.common.server.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.deppon.dpm.module.common.server.dao.ILeaderCallMonitorDao;
import com.deppon.dpm.module.common.server.service.ILeaderCallMonitorService;
import com.deppon.dpm.module.common.shared.domain.LeaderCallMonitorEntity;
import com.deppon.foss.framework.exception.BusinessException;

public class LeaderCallMonitorService implements ILeaderCallMonitorService{
	
	private ILeaderCallMonitorDao leaderCallMonitorDao;
	
	private static final List<String> LEADERLIST = new ArrayList<String>();
	
	static {
		LEADERLIST.add("10");
		LEADERLIST.add("C");
		LEADERLIST.add("D");
	}
	public static final int NUMBER_OF_THREE = 3;
	public static final int NUMBER_OF_FOUR = 4;

	@Override
	public void save(LeaderCallMonitorEntity entity) {
		
		String params = entity.getParams();
		if(StringUtils.isBlank(params)) {
			throw new BusinessException();
		}
		
		String[] split = params.split(",");
		for (String str : split) {
			String[] callInfoArr = str.split("\\|");
			String callFromCode = callInfoArr[0];
			String callFromLevel = callInfoArr[1];
			String callToCode = callInfoArr[2];
			String callToLevel = callInfoArr[NUMBER_OF_THREE];
			String callTime = callInfoArr[NUMBER_OF_FOUR];
			Date date = new Date(Long.parseLong(callTime));
			// 打电话两方都是副总，需要插入2条监控信息
			if(LEADERLIST.contains(callFromLevel)) {
				// 呼出
				this.packageAndSave(callFromCode, callToCode, 0, date);
				
				if(LEADERLIST.contains(callToLevel)) {
					// 呼入
					this.packageAndSave(callToCode, callFromCode, 1, date);
				}
			} 
			
			// 打电话的人不是副总，被呼叫的是副总
			else if(LEADERLIST.contains(callToLevel)) {
	
				// 呼入
				this.packageAndSave(callToCode, callFromCode, 1, date);
			}
			
		}
		
	}
	
	private void packageAndSave (String leaderCode, String targetCode, int callType, Date createTime) {
		
		LeaderCallMonitorEntity monitorEntity = new LeaderCallMonitorEntity(leaderCode,targetCode,callType,createTime);
		
		leaderCallMonitorDao.save(monitorEntity); 
	}

	public void setLeaderCallMonitorDao(ILeaderCallMonitorDao leaderCallMonitorDao) {
		this.leaderCallMonitorDao = leaderCallMonitorDao;
	}

}

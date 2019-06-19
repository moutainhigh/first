package com.deppon.dpm.module.common.server.action;

import java.util.List;

import com.deppon.dpm.module.common.server.service.IDataMonitorForTongjiService;
import com.deppon.dpm.module.common.shared.domain.DataMonitorForTongjiEntity;
import com.opensymphony.xwork2.ModelDriven;

public class DataMonitorForTongjiAction extends BaseAction implements ModelDriven<DataMonitorForTongjiEntity>{
	
	// 传递参数的实体
	private DataMonitorForTongjiEntity dataMonitorForTongjiEntity = new DataMonitorForTongjiEntity();
	
	// 注入service
	private IDataMonitorForTongjiService dataMonitorForTongjiService;
	
	// 复写的方法
	@Override
	public DataMonitorForTongjiEntity getModel() {
		// 返回实例
		return dataMonitorForTongjiEntity;
	}

	// 条件查询
	public String queryDataMonitor(){
		// 查询
		List<DataMonitorForTongjiEntity> list = dataMonitorForTongjiService.queryByCondition(getModel());
		// 返回
		writeToPage(list);
		return NONE;
	}

	// setter
	public void setDataMonitorForTongjiService(
			IDataMonitorForTongjiService dataMonitorForTongjiService) {
		this.dataMonitorForTongjiService = dataMonitorForTongjiService;
	}

}

package com.deppon.dpm.module.common.test.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.module.common.server.service.IDataMonitorForTongjiService;
import com.deppon.dpm.module.common.shared.domain.DataMonitorForTongjiEntity;
import com.deppon.dpm.module.common.test.BaseTestCase;

public class DataMonitorForTongjiServiceImplTest extends BaseTestCase{
	
	@Autowired
	private IDataMonitorForTongjiService dataMonitorForTongjiService;

	@Test
	public void testQueryByCondition() throws ParseException {
		DataMonitorForTongjiEntity entity = new DataMonitorForTongjiEntity();
		entity.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-05-12 08:00:00"));
		entity.setEndTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-05-0 17:30:00"));
		entity.setJoblevel("10");
		dataMonitorForTongjiService.queryByCondition(entity);
	}

}

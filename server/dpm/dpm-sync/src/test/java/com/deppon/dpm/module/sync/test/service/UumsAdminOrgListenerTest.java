package com.deppon.dpm.module.sync.test.service;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.foss.module.sync.business.jms.MdmOrgInfo;
import com.deppon.foss.module.sync.business.jms.SendMdmOrgRequest;
import com.deppon.foss.module.sync.business.server.UumsAdminOrgListener;

public class UumsAdminOrgListenerTest extends TestCase {

	/**
	 * spring应用容器
	 */
	protected ApplicationContext appContext;

	private UumsAdminOrgListener uumsAdminOrgListener;

	@Before
	protected void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext(
				"com/deppon/dpm/module/sync/test/META-INF/spring.xml");
		uumsAdminOrgListener = (UumsAdminOrgListener) appContext
				.getBean("uumsAdminOrgListener");
	}
	
	@Test
	public void test() throws Exception {
		SendMdmOrgRequest req = new SendMdmOrgRequest(); ;
		List<MdmOrgInfo> adminOrgInfoList = new ArrayList<MdmOrgInfo>();
		// uums组织实体信息
		MdmOrgInfo info = new MdmOrgInfo();
		//测试数据
		// 华东营运办公室 473938
		info.setOrgId(473938);
		info.setOrgCode("W0000002248");
		info.setOrgName("华东营运办公室");
		info.setOrgLevel(0);
		info.setParentOrgId(473898);
		info.setOrgAddress("12312312");
		info.setOrgZipCode(null);
		info.setOrgManager("028270");
		info.setOrgPhone(null);
		info.setOrgEmail(null);
		info.setParentOrgCode("DIP");
		info.setParentOrgName(null);
		info.setOrgBenchmarkCode("DP20563");
		info.setBeginTime("2015-10-28 12:12:12 000000");
		adminOrgInfoList.add(info);
		req.setAdminOrgInfoList(adminOrgInfoList);
		//调用组织信息同步接口
		uumsAdminOrgListener.process(req);
		uumsAdminOrgListener.getTongxunLuService();
	}
	
}

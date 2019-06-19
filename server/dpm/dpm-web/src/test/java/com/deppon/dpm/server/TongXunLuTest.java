//package com.deppon.dpm.server;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.ServletContext;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import com.deppon.dpm.server.base.TestHelper;
//import com.deppon.dpm.tongxunlu.server.dao.IOmConfigDao;
//import com.deppon.dpm.tongxunlu.server.service.impl.PushService;
//import com.deppon.dpm.tongxunlu.server.service.impl.QuartzJob;
//import com.deppon.dpm.tongxunlu.shared.domain.OmConfigEntity;
//import com.deppon.dpm.tongxunlu.shared.dto.OmConfigQueryDto;
//import com.deppon.foss.framework.server.deploy.struts.ModuleManager;
//import com.deppon.foss.framework.server.web.filter.FrameworkFilter;
//
//public class TongXunLuTest{
//	
//	private PushService jpushService;
//	private QuartzJob quartzJob;
////	private TongxunluAction tongxunluAction;
//	private IOmConfigDao omConfigDao;
//	
//	@Before
//	public void init(){
////		jpushService = (PushService) TestHelper.get().appContext.getBean("jpushService");
////		quartzJob = (QuartzJob) TestHelper.get().appContext.getBean("quartzJob");
////		tongxunluAction = (TongxunluAction) TestHelper.get().appContext.getBean("jpushService");
//		omConfigDao = (IOmConfigDao) TestHelper.get().appContext.getBean("omConfigDao");
//	}
//	
//	
//	@Test
//	public void testSendNotification(){
//		String sysCode = "dpm";
//		String content = "测试";
//		Map<String,Object> extras = new HashMap<String,Object>();
//		extras.put("type", "3");
////		jpushService.sendNotification(sysCode, content, extras);
//	}
//	
//	@Test
//	public void testWork(){
//		quartzJob.work();   
//		try {
//			Thread.sleep(100000);
//		} catch (InterruptedException e) {
//			
//			e.printStackTrace(); 
//			
//		}
//	}
//	
//	@Test
//	public void testHotDeploy(){
//		OmConfigQueryDto omConfigEntity = new OmConfigQueryDto();
//		omConfigEntity.setSynSuccess(true);
//		omConfigDao.queryOmConfigEntityByEntity(omConfigEntity, 0, 3);
//	}
//	
//
//}

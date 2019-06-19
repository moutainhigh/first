package com.deppon.dpm.module.management.server.service.test;

import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.management.server.service.ISendParcelWorkService;
import com.deppon.dpm.module.management.server.unit.test.JunitTest;
import com.deppon.dpm.module.management.shared.vo.EmpVO;
import com.deppon.dpm.module.management.shared.vo.ParcelListVO;

public class SendParcelWorkServiceTest  extends JunitTest {
	/** 
	* @Fields sendParcelWorkService 收发室接口
	*/ 
	private ISendParcelWorkService sendParcelWorkService;
	
	private ApplicationContext context;
	
	@Before
	public void setUp() throws Exception{
		context = new ClassPathXmlApplicationContext("com/deppon/dpm/module/management/test/META-INF/spring.xml");
		sendParcelWorkService = (ISendParcelWorkService)context.getBean("parcelService");
	}
	
	@Test
	public void updateNotice(){
		String content = "123";
		int retInt = sendParcelWorkService.updateNotice(content);
	}
	
	@Test
	public void queryParcelList(){
		ParcelListVO parcelListVO = new ParcelListVO();
		parcelListVO.setUserNo("074115");
		List<ParcelListVO> parcelListVOs = sendParcelWorkService.queryParcelList(parcelListVO);
	}
	
	@Test
	public void queryNotice(){
		String noticeCotent = sendParcelWorkService.queryNotice();
		System.out.println("通告内容==》"+noticeCotent);
	}
	
	@Test
	public void checkIsSendAdm(){
		String empCode="076691";
		int retInt = sendParcelWorkService.checkIsSendAdm(empCode);
		System.out.println("=======retInt的值=>"+retInt);
	}
	
	@Test
	public void queryEmpInfoList(){
		EmpVO empVO = new EmpVO();
		empVO.setEmpCode("076691");
		List<EmpVO> vos =  sendParcelWorkService.queryEmpInfoList(empVO);
	}
	
	@Test
	public void saveParcelAct(){
		
		
		
		String str= "{\"userName\":\"ccf\",\"userNo\":268101,\"packageId\":2}";
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		sendParcelWorkService.saveParcelAct(str, retMap);
	}
	
	
	public ISendParcelWorkService getSendParcelWorkService() {
		return sendParcelWorkService;
	}

	public void setSendParcelWorkService(
			ISendParcelWorkService sendParcelWorkService) {
		this.sendParcelWorkService = sendParcelWorkService;
	}

	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}
}

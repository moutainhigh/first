package com.deppon.dpm.module.sync.test.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.foss.module.sync.business.jms.MdmEmpInfo;
import com.deppon.foss.module.sync.business.jms.SendMdmEmpRequest;
import com.deppon.foss.module.sync.business.server.UumsEmployeeListenner;

public class UumsEmployeeListennerTest extends TestCase {
	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext;
	private UumsEmployeeListenner uumsEmployeeListenner;
	
	@Override
	protected void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/module/sync/test/META-INF/spring.xml");
		uumsEmployeeListenner = (UumsEmployeeListenner)appContext.getBean("uumsEmployeeListenner");
	}
	
	@Test
	public void test() throws Exception {
		SendMdmEmpRequest request = new SendMdmEmpRequest();
		List<MdmEmpInfo> employeeInfoList = new ArrayList<MdmEmpInfo>();
		// uums人员实体信息
		MdmEmpInfo info = new MdmEmpInfo();
		// 测试数据
		// 035015 张冬冬
//		info.setEmployeeChangeId(employeeChangeId);
		info.setEmpCode("035015");
		info.setEmpName("张冬冬");
		info.setGender(1);
		info.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("1988-01-14"));
		info.setStatus(1);
		info.setDocNumber("341226198801146916");
		info.setInDate(new SimpleDateFormat("yyyy-MM-dd").parse("2009-10-29"));
		info.setOfficeEmail("zhangdongdong@deppon.com");
		info.setMobile("15040528275");
		info.setPersonalEmail("zhangdongdong@deppon.com");
		info.setDeptId("469620");
		info.setPosition("快递员");
		info.setJobGroups("销售族群");
		info.setJobLevel("04");
		info.setJobSequence("营业部销售序列");
		info.setJobDuty("1.负责车辆安全检查、6S等工作");
		info.setHomeTel("12312");
		info.setOfficeTel("12312");
		info.setHomeAddress("homeAddress");
		
		employeeInfoList.add(info);
		request.setEmployeeInfoList(employeeInfoList);
		// 调用同步人员信息接口
		uumsEmployeeListenner.process(request);
		uumsEmployeeListenner.getTongxunLuService();
	}
}

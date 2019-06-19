package com.deppon.dpm.doc.server.service;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.doc.server.service.impl.DepositorService;
import com.deppon.dpm.doc.server.vo.DidiBankCardVO;

/**
 * 预算暂用实现类
 * @author wanc
 * 20171128
 */
public class DepositorServiceTest extends TestCase {

	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;

	/**
	 * service
	 */
	private DepositorService DepositorService;
	/*
	 * (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/doc/test/server/META-INF/spring.xml");
		DepositorService = (DepositorService) appContext.getBean("DepositorService");
	}
	/*
	 * testinsert
	 */
	@Test
	public void testinsertAccount() {
		DidiBankCardVO didiBankCardvo = new DidiBankCardVO();
		DepositorService.insertAccount(didiBankCardvo);
	}
	@Test
	public void testqueryByDeptName() {
		DepositorService.queryByDeptName("");
	}
}

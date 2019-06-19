package com.deppon.dpm.doc.server.service;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.doc.server.entity.OccupyBudgetRquestEntity;
import com.deppon.dpm.doc.server.service.impl.OccupyBudgetService;

/**
 * 预算暂用实现类
 * @author wanc
 * 20171128
 */
public class OccupyBudgetServiceTest extends TestCase {

	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;

	/**
	 * service
	 */
	private OccupyBudgetService occupyBudgetService;
	/*
	 * (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/doc/test/server/META-INF/spring.xml");
		occupyBudgetService = (OccupyBudgetService) appContext.getBean("occupyBudgetService");
	}
	/*
	 * testupdateBudget
	 */
	@Test
	public void testupdateBudget(){
		OccupyBudgetRquestEntity rqentity = new OccupyBudgetRquestEntity();
		rqentity.setBusinessId("1");
		occupyBudgetService.updateBudget(rqentity);
	}
}

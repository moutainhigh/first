package com.deppon.dpm.doc.server.service;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.doc.server.entity.DidiCityEntity;
import com.deppon.dpm.doc.server.service.impl.DidiCitiesService;

public class DidiCitiesServiceTest extends TestCase{
	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;
	
	private DidiCitiesService didiCitiesService;
	/*
	 * (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/doc/test/server/META-INF/spring.xml");
		didiCitiesService = (DidiCitiesService) appContext.getBean("didiCitiesService");
	}
	/*
	 * insert
	 */
	@Test
	public void testinsert() {
		DidiCityEntity aa = new DidiCityEntity();
		aa.setCityid(110120);
		aa.setName("人民大会堂");
//		aa.setId(110);
		didiCitiesService.insert(aa);
	}
	/*
	 * update
	 */
//	@Test
//	public void testupdate() {
//		DidiCityEntity aa = new DidiCityEntity();
//		aa.setCityid(110120);
//		aa.setName("人民大会");
//		aa.setId(371);
//		didiCitiesDao.update(aa);
//	}
	/*
	 * delete
	 */
	@Test
	public void testdelete() {
		DidiCityEntity aa = new DidiCityEntity();
		didiCitiesService.delete(aa);
	}
	/*
	 * delete
	 */
	@Test
	public void testdeleteBatch() {
		didiCitiesService.deleteBatch("");
	}

}

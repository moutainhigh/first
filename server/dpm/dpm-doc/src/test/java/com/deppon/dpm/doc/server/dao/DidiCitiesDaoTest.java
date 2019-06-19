package com.deppon.dpm.doc.server.dao;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.doc.server.dao.impl.DidiCitiesDao;
import com.deppon.dpm.doc.server.entity.DidiCityEntity;

public class DidiCitiesDaoTest extends TestCase{
	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;
	
	private DidiCitiesDao didiCitiesDao;
	/*
	 * (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext("com/deppon/dpm/doc/test/server/META-INF/spring.xml");
		didiCitiesDao = (DidiCitiesDao) appContext.getBean("didiCitiesDao");
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
		didiCitiesDao.insert(aa);
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
		didiCitiesDao.delete(aa);
	}
	/*
	 * delete
	 */
	@Test
	public void testdeleteBatch() {
		didiCitiesDao.deleteBatch("");
	}

}

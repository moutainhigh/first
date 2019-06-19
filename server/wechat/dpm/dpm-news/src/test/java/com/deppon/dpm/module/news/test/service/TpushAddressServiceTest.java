package com.deppon.dpm.module.news.test.service;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.news.server.service.impl.TpushAddressService;

public class TpushAddressServiceTest extends TestCase {

	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;
	/**
	 * 消息推送地址
	 */
	private TpushAddressService tpushAddressService;

	@Override
	protected void setUp() throws Exception {
		// 实例化spring 应用容器
		appContext = new ClassPathXmlApplicationContext(
				"com/deppon/dpm/module/news/test/META-INF/spring.xml");
		// 获取tpushAddressService实例
		tpushAddressService = (TpushAddressService) appContext
				.getBean("tpushAddressService");
	}

	@Test
	public void testtgetTpushAddress() throws Exception {
		// tpush地址
		String tpushAddress = tpushAddressService.getTpushAddress();
		// 打印
		System.out.println(tpushAddress);
	}

	@Test
	public void testgetTpushAppKey() throws Exception {
		// tpush appKey
		String tpushAppKey = tpushAddressService.getTpushAppKey();
		// 打印
		System.out.println(tpushAppKey);
	}

	@Test
	public void testgetTpushMasterSercret() throws Exception {
		// tpush密钥
		String tpushMasterSercret = tpushAddressService.getTpushMasterSercret();
		// 打印
		System.out.println(tpushMasterSercret);
	}

	@Test
	public void testgetTpushTimeLive() throws Exception {
		// 消息存活时间
		String tpushTimeLive = tpushAddressService.getTpushTimeLive();
		// 打印
		System.out.println(tpushTimeLive);
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public TpushAddressService getTpushAddressService() {
		return tpushAddressService;
	}

	/**
	 * set
	 * 
	 * @param tpushAddressService
	 */
	public void setTpushAddressService(TpushAddressService tpushAddressService) {
		this.tpushAddressService = tpushAddressService;
	}

}

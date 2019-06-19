package com.deppon.dpm.module.news.test.service;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.module.news.server.service.impl.TpushNewsService;
import com.deppon.dpm.module.news.shared.domain.NewsCenterEntity;
import com.deppon.dpm.module.news.shared.domain.PushMessage;

public class TpushNewsServiceTest extends TestCase {

	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;

	/**
	 * 消息推送service
	 */
	private TpushNewsService tpushNewsService;

	/**
	 * 执行测试方法之前调用
	 */
	@Before
	protected void setUp() throws Exception {
		// 实例化spring 应用容器
		appContext = new ClassPathXmlApplicationContext(
				"com/deppon/dpm/module/news/test/META-INF/spring.xml");
		// 获取tpushNewsService实例
		tpushNewsService = (TpushNewsService) appContext
				.getBean("tpushNewsService");
	}

	/**
	 * 获取推送信息
	 * */
	@Test
	public void testgetMessage() throws Exception {
		// 推送信息id
		String messageId = "fca415a5-8b61-4187-adc1-13af5f0f710e";
		// 根据推送信息ID获取推送信息
		PushMessage query = (PushMessage) tpushNewsService
				.getMessage(messageId);
		// 获取推送信息正文
		String content = query.getContent();
		// 打印信息内容
		System.out.println("testgetMessage::" + content);

	}

	/**
	 * 对指定工号进行消息推送
	 * */
	@Test
	public void testpushUserNews() throws Exception {
		// 接收推送消息员工
		String empCode = "231586";
		// 标题
		String title = "哇哈哈哈哇哈哈哈哇哈哈哈哇哈哈哈哇哇哈哈哈哇哈哈哈哇哈哈哈哇哈哈哈哈哈哈哇哈哈哈哇哈哈哈哇哈"
				+ "哈哈哇哈哈哈哇哈哈哈哇哈哈哈哇哈哈哈哇哈哈哇哇哈哈哈哇哈哈哈哈哈哈哇哈哈哈哈哇哈哈哈哇哈哈哈哇哈哈哈";
		// 正文内容
		String content = "1231312313123131231312313123131231312313123131"
				+ "231312313123131231312313123131231312313123131231312313123"
				+ "13123131231312313123131231312313123131231312313123131231312"
				+ "3131231312313123131231312313123131231312313";
		// 应用编号
		String a = "1";
		// 推送类型<br>
		int b = 2;
		// 是否显示小红点，0 显示，1 不显示
		int c = 0;
		// 是否是消息中心， 0 是消息中心 ， 1 是应用
		int d = 0;
		// 超链接
		String e = "www.baidu.com";
		// 推送信息Entity
		NewsCenterEntity newsCenterEntity = new NewsCenterEntity(a, b, c, d, e,
				title);
		// 调用接口
		String result = tpushNewsService.pushUserNews(empCode, title, content,
				newsCenterEntity);
		// 接口反馈内容
		System.out.println("testpushUserNews::" + result);
	}

	/**
	 * 对所有用户进行推送
	 */
	@Test
	public void testpushAllUserNew() throws Exception {
		// 标题
		String title = "哇哈哈哈哇哈哈哈哇哈哈哈哇哈哈哈哇哇哈哈哈哇哈哈哈哇哈哈哈哇哈哈哈哈哈哈哇哈哈哈哇哈哈哈哇哈"
				+ "哈哈哇哈哈哈哇哈哈哈哇哈哈哈哇哈哈哈哇哈哈哇哇哈哈哈哇哈哈哈哈哈哈哇哈哈哈哈哇哈哈哈哇哈哈哈哇哈哈哈";
		// 正文内容
		String content = "1231312313123131231312313123131231312313123131"
				+ "231312313123131231312313123131231312313123131231312313123"
				+ "13123131231312313123131231312313123131231312313123131231312"
				+ "3131231312313123131231312313123131231312313";
		// 应用编号
		String a = "1";
		// 推送类型<br>
		int b = 2;
		// 是否显示小红点，0 显示，1 不显示
		int c = 0;
		// 是否是消息中心， 0 是消息中心 ， 1 是应用
		int d = 0;
		// 超链接
		String e = "www.baidu.com";
		// 推送信息Entity
		NewsCenterEntity newsCenterEntity = new NewsCenterEntity(a, b, c, d, e,
				title);
		// 调用接口
		tpushNewsService.pushAllUserNew(title, content, newsCenterEntity);
	}

	/**
	 * 如果用户安装了该应用，则返回true
	 * 
	 * @throws Exception
	 */
	@Test
	public void testIsSend() throws Exception {
		// 员工工号
		String empCode = "231586";
		for (int i = 0; i < 22; i++) {
			// 推送类型
			int type = i;
			// 返回值
			boolean result = tpushNewsService.isSend(empCode, type);
			System.out.println(result);
		}
	}

	/**
	 * test
	 * 
	 * @throws Exception
	 */
	@Test
	public void test() throws Exception {
		tpushNewsService.getUrl();
		tpushNewsService.getTpushAddressService();
		tpushNewsService.getJdbcTemplate();
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public TpushNewsService getTpushNewsService() {
		return tpushNewsService;
	}

	/**
	 * set
	 * 
	 * @param tpushNewsService
	 */
	public void setTpushNewsService(TpushNewsService tpushNewsService) {
		this.tpushNewsService = tpushNewsService;
	}

}

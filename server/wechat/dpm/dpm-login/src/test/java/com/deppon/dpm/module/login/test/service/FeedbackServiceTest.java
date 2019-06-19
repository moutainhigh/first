package com.deppon.dpm.module.login.test.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deppon.dpm.login.server.service.FeedbackService;
import com.deppon.dpm.tongxunlu.shared.domain.FeedBackDetailsEntity;
import com.deppon.dpm.tongxunlu.shared.domain.FeedbackSearch;

public class FeedbackServiceTest extends TestCase {

	/**
	 * spring 应用容器
	 */
	protected ApplicationContext appContext = null;

	/**
	 * 意见反馈service
	 */
	private FeedbackService feedbackService;

	@Override
	protected void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext(
				"com/deppon/dpm/login/test/META-INF/spring.xml");
		feedbackService = (FeedbackService) appContext
				.getBean("feedbackService");
	}

	@Test
	public void test() throws Exception {
		feedbackService.getPhotoAddressService();
		feedbackService.getFeedbackDao();
		feedbackService.getNormalQuestionDao();
	}
	
	@Test
	public void testfeedback() throws Exception {
		String content = "意见反馈1111111";
		String userId = "231586";
		String osType = "iOS";
		String type = "邮箱";
		// 意见反馈保存
		feedbackService.feedback(null, null, content, userId, osType, type);
	}

	@Test
	public void testgetFeedbackDetails() throws Exception {
		int start = 0;
		int pageSize = 20;
		// 获取意见反馈列表
		List<FeedBackDetailsEntity> list = feedbackService.getFeedbackDetails(
				start, pageSize,new FeedbackSearch());
	}

	@Test
	public void testfeedBackCount() throws Exception {
		// 意见反馈数量
		int count = feedbackService.feedBackCount(new FeedbackSearch());
	}

	@Test
	public void testupdateFeedback() throws Exception {
		// 1087
		FeedBackDetailsEntity feedBackDetailsEntity = new FeedBackDetailsEntity();
		feedBackDetailsEntity.setContent("意见反馈22222");
		feedBackDetailsEntity.setType("日程");
		feedBackDetailsEntity.setId(1087);
		// 更新意见反馈
		String result = feedbackService.updateFeedback(feedBackDetailsEntity);
	}

	@Test
	public void testgetSubmitTimeById() throws Exception {
		int id = 1087;
		// 获取提交时间
		Date date = feedbackService.getSubmitTimeById(id);
	}

	@Test
	public void testgetFeedbackByEmpcode() throws Exception {
		int start = 0;
		int pageSize = 20;
		String empCode = "231586";
		// 获取意见反馈列表
		Map<String, List<FeedBackDetailsEntity>> map = feedbackService
				.getFeedbackByEmpcode(start, pageSize, empCode);
	}

}

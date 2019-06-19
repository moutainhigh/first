package com.deppon.dpm.module.common.test.service;

import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.module.common.server.interceptor.LoginInterceptor;
import com.deppon.dpm.module.common.server.service.IAwardService;
import com.deppon.dpm.module.common.shared.domain.AwardDetailEntity;
import com.deppon.dpm.module.common.shared.domain.AwardEntity;
import com.deppon.dpm.module.common.test.BaseTestCase;

public class AwardServiceTest extends BaseTestCase{
	
	@Autowired
	private IAwardService awardService;
	
	@Test
	public void test(){
		LoginInterceptor loginInterceptor = new LoginInterceptor();
		loginInterceptor.getJdbcTemplate();
	}
	
	@Test
	public void testGetAwardList(){
		List<AwardEntity> list = awardService.getAwardList(0, 10);
		System.out.println(list.size());
	}
	
	@Test
	public void testGetAwardDetail(){
		List<AwardDetailEntity> list = awardService.getAwardDetail("article1", 0, 10);
		System.out.println(list.size());
	}
	
	@Test
	public void testInsertReply(){
		AwardDetailEntity entity = new AwardDetailEntity();
		entity.setArticleID("article7");
		entity.setUserId("292520");
		entity.setToUserId("高端人才招聘组");
		entity.setSendContent("嘻嘻嘻嘻");
		int i = awardService.insertReply(entity);
		System.out.println(i);
		
	}
	
	@Test
	public void testInsertRecord(){
		String articleID = "article7";
		String userId = "292520";
		int i = awardService.insertRecord(articleID, userId);
		System.out.println(i);
	}
	
	@Test
	public void testSetReadingQuantityById(){
		String articleID = "article4";
		int i = awardService.setReadingQuantityById(articleID);
		System.out.println(i);
	}
	
	@Test
	public void testInsertAward(){
		AwardEntity entity = new AwardEntity();
		entity.setArticleID(UUID.randomUUID().toString());
		entity.setPublisher("移动办公开发组");
		entity.setPublisherEmail("peter@depponmail.com");
		entity.setRecruitPosition("HTML5开发工程师招聘");
		entity.setTitle("HTML5开发工程师招聘");
		entity.setContent("1、掌握各类前端技术，如XHTML/XML/CSS/，了解WEB标准化、性能优化方法，了解可用性、可访问性和安全性");
		entity.setHasAward(true);
		entity.setReward("500-5000元");
		entity.setContactPerson("候广澎");
		entity.setContactPhone("13953128015");
		int i = awardService.insertAward(entity);
		System.out.println(i);
	}
	
	@Test
	public void testDeleteAward(){
		AwardEntity entity = new AwardEntity();
		entity.setArticleID("article5");
		int i = awardService.deleteAward(entity);
		System.out.println(i);
	}
	
	@Test
	public void testUpdateAward(){
		AwardEntity entity = new AwardEntity();
		entity.setArticleID("article4");
		entity.setTitle("招聘移动开发高级工程师");
		int i = awardService.updateAward(entity);
		System.out.println(i);
	}
	
	@Test
	public void testGetAwardEntity(){
		AwardEntity entity = new AwardEntity();
		entity.setArticleID("article4");
		AwardEntity awardEntity = awardService.getAwardEntity(entity);
		System.out.println(awardEntity);
	}

}

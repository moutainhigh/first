package com.deppon.dpm.module.announce.test.service;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.module.announce.server.dao.IDpmExpressDao;
import com.deppon.dpm.module.announce.server.service.IDpmExpressService;
import com.deppon.dpm.module.announce.shared.domain.DpmExpress;
import com.deppon.dpm.module.announce.test.BaseTestCase;

public class ExpressServiceTest extends BaseTestCase{
	
	@Autowired
	private IDpmExpressService dpmExpressService;
	
	@Autowired
	private IDpmExpressDao iDpmExpressDao;
	
	@Test
	public void syncFromOa(){
		
		DpmExpress entity = new DpmExpress();
		//发布时间
		entity.setLearnDate(new Date());
		//事业部聚焦标题
		entity.setQuoContent("挥洒青春 运输陈村");
		//事业部名称
		entity.setDivisionName("IT事业部");
		//今日聚焦标题
		entity.setTaTitle("案例学习");
		//今日聚焦标题内容
		entity.setTaTitleContent("有责死亡事故学习");
		//今日聚焦内容
		entity.setTaContent("夜间行车要提高警惕，降低车速，拉大跟车距离，谨慎变道、超车！");
		//今日聚焦学习状态
		entity.setTaStatus(0);
		//专业知识标题
		entity.setBuTitle("文件学习");
		//专业知识标题内容
		entity.setBuTitleContent("采购物资异常反馈平台解读");
		//专业知识内容
		entity.setBuContent("为了更好的帮助处于麻烦中的您，向您提供异常物资反馈渠道，能真正意义上解决");
		//专业知识学习状态
		entity.setBuStatus(0);
		//案例焦点学习标题
		entity.setJiaoTitle("审计类");
		//案例焦点标题内容
		entity.setJiaoTitleContent("车辆保养");
		//案例焦点学习内容
		entity.setJiaoContent("过核对某车队2014年8月至2015年1月的车辆保养计划发现，" +
				"其保养计划存在有些车辆的保养周期少于公司规定周期。如：车辆川AD4Z49保养周期为10000公里，" +
				"偏差允许10%，");
		//案例焦点学习状态
		entity.setJiaoStatus(1);
		//是否学习完成
		entity.setFinishLearn(0);
		//早安快递类型
		entity.setMorningType("班车司机晨会");
		
		dpmExpressService.syncFromOa(entity);
	}
	
	@Test
	public void getExpressById(){
		
		String userId = "275309";
		int id = 479;
		String morningType = "班车司机晨会";
		DpmExpress express = dpmExpressService.getExpressById(userId, id, morningType);
		System.out.println(express);
	}
	
	@Test
	public void getHistory(){
		String userId = "000001";
		String morningType = "班车司机晨会";
		List<DpmExpress> history = dpmExpressService.getHistory(userId, morningType);
		for (DpmExpress dpmExpress : history) {
			System.out.println(dpmExpress);
		}
	}
	
	@Test
	public void study(){
		String userId = "000001";
		int id = 459;
		int part = 3;
		dpmExpressService.study(userId, id, part);
	}
	
	@Test
	public void getExpressToday(){
		String userId = "116250";
		String morningType = "班车司机晨会";
		DpmExpress expressToday = dpmExpressService.getExpressToday(userId, morningType);
		System.out.println(expressToday);
	}

}

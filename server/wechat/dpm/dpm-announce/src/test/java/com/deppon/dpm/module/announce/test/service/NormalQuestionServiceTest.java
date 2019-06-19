package com.deppon.dpm.module.announce.test.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.module.announce.server.dao.INormalQuestionDao;
import com.deppon.dpm.module.announce.server.service.INormalQuestionService;
import com.deppon.dpm.module.announce.shared.domain.NormalQuestionEntity;
import com.deppon.dpm.module.announce.test.BaseTestCase;

public class NormalQuestionServiceTest extends BaseTestCase{
	
	@Autowired
	private INormalQuestionService normalQuestionService;
	
	private INormalQuestionDao normalQuestionDao;
	
	@Test
	public void getNormalQuestion(){
		List<NormalQuestionEntity> list = normalQuestionService.getNormalQuestion();
		for (NormalQuestionEntity normalQuestionEntity : list) {
			System.out.println(normalQuestionEntity);
		}
	}

}

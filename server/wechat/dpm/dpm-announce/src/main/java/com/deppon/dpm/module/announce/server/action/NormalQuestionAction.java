package com.deppon.dpm.module.announce.server.action;

import java.util.ArrayList;
import java.util.List;

import com.deppon.dpm.module.announce.server.service.INormalQuestionService;
import com.deppon.dpm.module.announce.shared.domain.NormalQuestionEntity;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;

/**
 * 常见问题接口
 * 
 * @author 231586
 * 
 */
public class NormalQuestionAction extends BaseAction {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6817460155000540775L;
	/**
	 * set injection
	 */
	private INormalQuestionService normalQuestionService;

	@CookieNotCheckedRequired
	public void getNormalQuestions() {
		// 结果集
		Result<List<NormalQuestionEntity>> result = new Result<List<NormalQuestionEntity>>();
		// 查询到的结果
		List<NormalQuestionEntity> normalQuestions = new ArrayList<NormalQuestionEntity>();
		try {
			// 查询结果
			normalQuestions = normalQuestionService.getNormalQuestion();
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_NO);
		}
		// count
		result.setCount(normalQuestions.size());
		// data
		result.setData(normalQuestions);
		// 返回
		writeToPage(result);
	}

	/**
	 * set
	 * 
	 * @param normalQuestionService
	 */
	public void setNormalQuestionService(INormalQuestionService normalQuestionService) {
		this.normalQuestionService = normalQuestionService;
	}
}

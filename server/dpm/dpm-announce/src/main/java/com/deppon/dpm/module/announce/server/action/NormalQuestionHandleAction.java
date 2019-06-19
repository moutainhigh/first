package com.deppon.dpm.module.announce.server.action;

import java.util.ArrayList;
import java.util.List;

import com.deppon.dpm.module.announce.server.service.INormalQuestionHandleService;
import com.deppon.dpm.module.announce.shared.domain.NormalQuestionHandleEntity;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.tongxunlu.server.util.Constants;
//import com.lowagie.text.List;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;

/**
 * 常见问题处理人接口
 * @author 276344
 *
 */
public class NormalQuestionHandleAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * service
	 */
	private INormalQuestionHandleService normalQuestionHandleService;
	@CookieNotCheckedRequired
	public void getNormalQuestionHandle() {
		//结果集
		Result<List<NormalQuestionHandleEntity>> result = new Result<List<NormalQuestionHandleEntity>>();
		//查询到的结果
		List<NormalQuestionHandleEntity> normalQuestionHandle = new ArrayList<NormalQuestionHandleEntity>();
		try {
			//查询结果 
			normalQuestionHandle = normalQuestionHandleService.getNormalQuestionHandle();
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
		result.setCount(normalQuestionHandle.size());
		// data
		result.setData(normalQuestionHandle);
		// 返回
		writeToPage(result);
	}
	
	/**
	 * get
	 * @return
	 */
	public INormalQuestionHandleService getNormalQuestionHandleService() {
		return normalQuestionHandleService;
	}
	/**
	 * set
	 * @param normalQuestionHandleService
	 */
	public void setNormalQuestionHandleService(
			INormalQuestionHandleService normalQuestionHandleService) {
		this.normalQuestionHandleService = normalQuestionHandleService;
	}

}

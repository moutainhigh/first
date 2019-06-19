package com.deppon.dpm.module.management.server.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.management.server.service.IMainPageService;
import com.deppon.dpm.tongxunlu.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.util.Constants;

public class MainPageAction extends BaseAction{

	/**
	 * 日志
	 */
	private static Logger logger  = LoggerFactory.getLogger(MainPageAction.class);
	private static final long serialVersionUID = 1L;
	
	private IMainPageService mainPageService;
	

	/**
	 * 查询每个人所拥有的卡片信息
	 */
	public void cardDetail(){
		this.solveCrossDomain();
		//结果集
		Result<String> result = new Result<String>();
		String cards = "";
		try {
			cards = mainPageService.cardDetailByUserId(userId);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// TODO: handle exception
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("获取卡片信息异常:" + e);
			e.printStackTrace();
			logger.error("获取卡片信息异常:" + e.toString());
		}
		// count
		result.setCount(1);
		// data
		result.setData(cards);
		// 返回
		writeToPage(result);
		
	}
	
	/*public void noticeCenter(){
		this.solveCrossDomain();
		//结果集
		List<NoticeCenterEntity> nclist = new ArrayList<NoticeCenterEntity>();
		
		
	}*/
	
	
	/**
	 * 解决H5跨域
	 */
	public void solveCrossDomain(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
	}

	public IMainPageService getMainPageService() {
		return mainPageService;
	}

	public void setMainPageService(IMainPageService mainPageService) {
		this.mainPageService = mainPageService;
	}
	
	
	

}

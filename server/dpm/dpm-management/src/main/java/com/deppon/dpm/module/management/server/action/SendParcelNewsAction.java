package com.deppon.dpm.module.management.server.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.service.ISendParcelNewsService;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * @author 268101 收发室消息推送action
 * 
 */
public class SendParcelNewsAction extends BaseAction {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(SendParcelNewsAction.class);

	/**
	 * sendParcelNewsService
	 */
	private ISendParcelNewsService sendParcelNewsService;

	/**
	 * 工号
	 */
	private String userNo;
    //userNo get set
	public String getUserNo() {
		return userNo;
	}
	//userNo get set
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
    // service 注入方法
	public void setSendParcelNewsService(
			ISendParcelNewsService sendParcelNewsService) {
		this.sendParcelNewsService = sendParcelNewsService;
	}

	/**
	 * 得到未发送的消息数据
	 */
	public void getNews() {

		// 设置页面响应实体
		String res = "";
		HttpServletResponse response = ServletActionContext.getResponse();

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		try {
			logger.info("进入消息推送action>>>>>>>>>>>>>>>>>>");
			Map<String, Object> mapData = new HashMap<String, Object>();
			// 先判断工号是否为空
			if (!StringUtil.isEmpty(userNo)) {
				logger.info("推送的工号为:>>>>>>>>>>>>"+userNo);
				//得到数据
				res = sendParcelNewsService.getPushNews(userNo);

			}
			else{
				//给予标志位
				mapData.put("errorCode", 1);
				//如果没有数据，则为空
				mapData.put("data", "");
				//转json格式
				res = JsonUtil.mapToJsonString(mapData);
			}
        
		} catch (Exception ce) {
			logger.info("发送消息出现异常>>>>>>>>>");
			
		}
		//写入数据
		writeToPage(response, res);

	}

}

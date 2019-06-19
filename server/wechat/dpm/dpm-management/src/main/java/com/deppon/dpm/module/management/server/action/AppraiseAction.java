package com.deppon.dpm.module.management.server.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.service.IAppraiseService;
import com.deppon.dpm.module.management.shared.domain.AppraiseEntity;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * @author 268101 AppraiseAction
 *
 */
public class AppraiseAction extends BaseAction {
	
	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(AppraiseAction.class);
	
	/****/
	private static final long serialVersionUID = 1L;
	
	/**
	 * appraiseService 接口
	 */
	IAppraiseService appraiseService;
	public void setAppraiseService(IAppraiseService appraiseService) {
		this.appraiseService = appraiseService;
	}

	/**
	 * 评价提交
	 */
	public void commitAppraise(){
		//跨域请求
		HttpServletRequest requst = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		String resInfo = StringUtil.EMPTY_STRING;
		String orderCode = StringUtil.EMPTY_STRING;
		BufferedReader bu = null;
		//判断是否是post请求
		if ("POST".equals(requst.getMethod())) {
			try {
				bu = ServletActionContext.getRequest().getReader();
				//得到页面传过来的josn
				String strJson = com.deppon.dpm.module.common.server.util.StringUtil
						.bufferString(bu);

				logger.info("client post commitAppraise paramter is : " + strJson);
                //进行转实体
				AppraiseEntity requestParam = JsonUtil.jsonToEntity(
						strJson, AppraiseEntity.class);
				//得到 orderCode 参数
				orderCode = requestParam.getOrderCode();
		
				// 提交更新PC和移动端状态
				resInfo = appraiseService.appraiseCommit(requestParam);
				//判断是否为null
				if (StringUtil.isEmpty(resInfo)) {
					//put 数据
					retMap.put("orderCode", orderCode);
					//put 数据
					retMap.put("isSuccess", "N");
					//put 数据
					retMap.put("errMessage", "提交评价服务端出现错误！原因：返回结果为空。");
					logger.info("提交评价服务端出现错误！原因：返回结果为空。");
				} else {
					//判断是否是 isSuccess
					if (!JsonUtil.isExistKey(resInfo, "isSuccess")) {
						//put 数据
						retMap.put("orderCode", orderCode);
						//put 数据
						retMap.put("isSuccess", "N");
						//put 数据
						retMap.put("errMessage", "提交评价服务端出现错误！");
						logger.info("提交评价服务端出现错误！原因：" + resInfo);
					}
				}
			} catch (Exception e) {
				//捕获异常
				retMap.put("orderCode", orderCode);
				retMap.put("isSuccess", "N");
				retMap.put("errMessage", "提交评价出现异常！");
				
				logger.info("提交评价出现异常!", e);
			}finally{
				//关闭
				if(bu != null){
					try {
						bu.close();
					} catch (IOException e) {
						logger.info("BufferedReader close is exception!");
					}
				}
			}
			
			if (!retMap.isEmpty()) {
				resInfo = JsonUtil.mapToJsonString(retMap);
			}
		}
		
		logger.info("commitAppraise response data is : " + resInfo);
		
		//请求权限设置
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		//写入数据
		writeToPage(response, resInfo);
	}
}

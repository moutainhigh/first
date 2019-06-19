package com.deppon.dpm.module.management.server.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.ws.rs.core.Response;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.management.server.dao.IAppraiseDao;
import com.deppon.dpm.module.management.server.service.IAppraiseService;
import com.deppon.dpm.module.management.shared.domain.AppraiseEntity;
import com.deppon.dpm.module.management.shared.domain.EvaluationOrderRequest;
import com.deppon.dpm.module.news.server.service.ITpushNewsService;
import com.deppon.dpm.module.news.shared.domain.NewsCenterEntity;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * IT上报评价服务
 * @author 251624
 *
 */
public class AppraiseService implements IAppraiseService {
	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(AppraiseService.class);
	
	/***push*/
	ITpushNewsService tpushNewsService;
	public void setTpushNewsService(ITpushNewsService tpushNewsService) {
		this.tpushNewsService = tpushNewsService;
	}

	/** Dao*/
	IAppraiseDao appraiseDao;
	public void setAppraiseDao(IAppraiseDao appraiseDao) {
		this.appraiseDao = appraiseDao;
	}

	/*** 评价提交的ESB地址*/
	String appraiseUrl;
	public void setAppraiseUrl(String appraiseUrl) {
		this.appraiseUrl = appraiseUrl;
	}
	
	
	String queryCountUrl;
	public void setQueryCountUrl(String queryCountUrl) {
		this.queryCountUrl = queryCountUrl;
	}

	/**
	 * 评价提交
	 * @throws IOException 
	 * @throws HttpException 
	 */
	@Override
	public String appraiseCommit(AppraiseEntity requestParam)
		   throws HttpException, IOException {

		// 更新移动端的评价状态
		int status = appraiseDao.updateAppraiseStatus(requestParam);

		if (status > 0) {
			logger.info("移动端评价状态更新成功！");
		} else {
			logger.info("事件/问题 【" + requestParam.getOrderCode() + "】在移动端数据不存在！");
		}

		// 插入监控数据
		appraiseDao.insertAppraiseMonitor(requestParam);

		// 查询待确认数据件数
//		int count = appraiseDao.selectAppraiseCount(requestParam
//				.getCurrentUserCode());
		//ccf去掉这段代码
		/*if (count == 0) {
			// 推送消除红点
			// TODO:05/22推送消除和推送通知的数据有什么不同
		}*/

		// 请求PC端更改状态
		EvaluationOrderRequest param = JsonUtil.jsonToEntity(
				JsonUtil.beanToJsonString(requestParam),
				EvaluationOrderRequest.class);
		//返回结果集
		return requestClient(param, appraiseUrl, "ESB_APP2ESB_EVENT_EVALUATION_INFO");
	}
	
	/**
	 * 状态确认
	 */
	@Override
	public Response confirm(String param) {
		//新new一个map
		Map<String, String> retMap = new HashMap<String, String>();
		
		logger.info("confirm paramter is: " + param);
		try {
			//将json字符串参数转为实体对象
			AppraiseEntity requestParam = JsonUtil.jsonToEntity(param,
					AppraiseEntity.class);
			//判断事件编号是否为空
			if (StringUtil.isEmpty(requestParam.getOrderCode())) {
				retMap.put("isSuccess", "N");
				retMap.put("errorMsg", "事件编号不能为空！");
				logger.info("待确认状态实体没有事件编号！");
			}

			//判断申请人工号是否为空
			if (StringUtil.isEmpty(requestParam.getCurrentUserCode())) {
				retMap.put("isSuccess", "N");
				retMap.put("errorMsg", "申请人工号不能为空！");
				logger.info("待确认状态实体申请人工号！");
			}
			
			//如果没有错误信息，都符合确认状态的条件
			if (retMap.isEmpty()) {
				// 插入DB
				int status = appraiseDao.insertAppraiseInfo(requestParam);
				//判断status
				if (status > 0) {
					logger.info("待确认状态实体保存成功！");

					// 推送消息
//					NewsCenterEntity nce = new NewsCenterEntity();
//					nce.setApplicationId(DpmConstants.IT_SERVICE_PLATFORM);
//					nce.setTaskId(requestParam.getOrderCode());
//					nce.setActive(DpmConstants.YES);
//					nce.setContent("");
//					nce.setIsTxtNews(DpmConstants.NO);

//					tpushNewsService.pushUserNews(
//							requestParam.getCurrentUserCode(), "你有一个待确认事件",
//							DpmConstants.IT_SERVICE_PLATFORM_NAME, nce);
					// 推送消息
					NewsCenterEntity nce = new NewsCenterEntity(
							requestParam.getOrderCode(), MagicNumber.NUM4, 0, 1, "IT服务台");
					//推送消息
					tpushNewsService.pushUserNews(
							requestParam.getCurrentUserCode(), "你有一个待确认事件",
							"IT服务台", nce);
					//put 数据
					retMap.put("isSuccess", "Y");
					//put 数据
					retMap.put("errorMsg", "");

					logger.info("数据处理成功！");
				} else {
					//put 数据
					retMap.put("isSuccess", "N");
					//put 数据
					retMap.put("errorMsg", "数据保存失败！");

					logger.info("数据保存失败！");
				}
			}
		} catch (Exception ex) {
			//异常处理
			retMap.put("isSuccess", "N");
			retMap.put("errorMsg", "数据处理异常！");
            //日志打印
			logger.info("待确认数据处理异常！", ex);
		}

		// 返回
		return Response.ok(JsonUtil.mapToJsonString(retMap)).header("ESB-ResultCode", 1).build();
	}

	/**
	 * request请求
	 * @param param
	 * @param esbServiceCode
	 * @return
	 * @throws IOException 
	 * @throws HttpException 
	 * @throws Exception
	 */
	String requestClient(Object obj, String url, String esbServiceCode)
			throws BusinessException, HttpException, IOException {
		HttpClient hc = new HttpClient();

		// 设置编码格式
		hc.getParams().setContentCharset("UTF-8");

		// 设置超时时间
		HttpConnectionManagerParams managerParams = hc
				.getHttpConnectionManager().getParams();

		// 设置连接超时时间(单位毫秒)
		managerParams.setConnectionTimeout(MagicNumber.NUM60000);

		// 设置读数据超时时间(单位毫秒)
		managerParams.setSoTimeout(MagicNumber.NUM30000);
		Protocol myhttps = new Protocol("https",
				new MySSLProtocolSocketFactory(), MagicNumber.NUM443);
		Protocol.registerProtocol("https", myhttps);

		// header设置
		Map<String, String> map = new HashMap<String, String>();
		map.put("version", "1.0");
		map.put("Content-Type", "application/json;charset=UTF-8");
		map.put("esbServiceCode", esbServiceCode);
		map.put("requestId", UUID.randomUUID().toString());
		map.put("sourceSystem", "DPM");

		// 参数设置
		String paramJson = JsonUtil.beanToJsonString(obj);
		String headerJson = JsonUtil.mapToJsonString(map);

		RequestEntity entity = new StringRequestEntity(paramJson,
				"application/json", "UTF-8");
		PostMethod post = new PostMethod(url);
		post.setRequestEntity(entity);
		post.addRequestHeader("Content-Type", "application/json;charset=UTF-8");
		post.addRequestHeader("requestHeaders", headerJson);

		logger.info("post url ==========>" + url);
		logger.info("post paramter ==========>" + paramJson);
		logger.info("post header ==========>" + headerJson);

		// 执行postMethod
		hc.executeMethod(post);
        //得到结果集
		String result = post.getResponseBodyAsString();
		logger.info(" response status : " + post.getStatusCode());
		logger.info(esbServiceCode + " response data : " + result);
        //返回结果集
		return result;
	}
}

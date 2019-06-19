package com.deppon.dpm.module.management.server.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.ws.rs.core.Response;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.ar.bamp.common.util.DateUtil;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.dao.IProcRecordDao;
import com.deppon.dpm.module.management.server.service.IProcRecordService;
import com.deppon.dpm.module.management.shared.domain.EntriesEntity;
import com.deppon.dpm.module.management.shared.domain.ProcCheckPCEntity;
import com.deppon.dpm.module.management.shared.domain.ProcCheckTaskEntity;
import com.deppon.dpm.module.management.shared.domain.TaskCheckEntity;
import com.deppon.dpm.module.management.shared.domain.TaskSubmitEntity;
import com.deppon.dpm.module.management.util.Constants;

/**
 * 验收记录查询相关
 * @author 王亚男
 *
 */

public class ProcRecordService implements IProcRecordService {
	
	/**
	 * 日志
	 */
	private Logger logger = LoggerFactory.getLogger(ProcRecordService.class);
	
	/**
	 * toPcUrl 到pc端地址
	 */
	private String toPcUrl;
	
	/**
	 * procRecordDao 接口
	 */
	private IProcRecordDao procRecordDao;
	
	/**
	 * proCheckESBCode esb的code
	 */
	private String proCheckESBCode;
	/**
	 * 分页查询任务记录数
	 */
	@Override
	public List<ProcCheckTaskEntity> getCheckTaskPage(int pageNum, int pageSize,String deptName,String userId) {
		//返回数据
		return this.procRecordDao.getTaskList(pageNum, pageSize,deptName,userId);
	}
	
	/**
	 * 推送任务总数
	 * @return
	 */
	@Override
	public int getCount(String deptName,String userId) {
		//返回推送任务总数
		return this.procRecordDao.getCount(deptName,userId);
	}
	
	/**
	 * 向PC推送数据 最终提交
	 * @param number 项目编码
	 * @return JONS TaskSubmitEntity
	 */
	@Override
	public String getTaskToPC(String number) {	
		try{
			//得到系统时间
			//Long time1 = System.currentTimeMillis();
			Date date = new Date();
			//查询数据
			TaskSubmitEntity entity = this.getTaskSubmitEntity(number);
			//时间格式的转换
			String dateStr = DateUtil.getFormatDateTime(date, DateUtil.DateTimeFormatString);
			//得到系统时间
			//Long time2 = System.currentTimeMillis();
			//logger.info("select data pass time is :"+(time2-time1)/1000L+"/s");
			//塞入数据
			entity.setAcceptanceTime(dateStr);
			//塞入数据
			entity.setIsSuccess(1);
			//json转换
			String json = JsonUtil.beanToJsonString(entity);
			//推送数据  提交给PC端
			JSONObject re = httpPostWithJSON(toPcUrl,json,proCheckESBCode);
			//得到系统时间
			//Long time3 = System.currentTimeMillis();
			//logger.info("post data to PC, pass time is :"+(time3-time2)/1000L+"/s");
			logger.info("PC端返回结果："+re);
			//判断是否包含isSuccess
			if(re.containsKey("isSuccess")){
				if((Integer)re.get("isSuccess")==1){
					//成功提交给PC端
					//修改最终状态
					this.procRecordDao.updateLastTime(date,number);
					//修改历史纪录状态
					this.procRecordDao.updateRecordStatus(number);
					return "{\"resultFlag\":true,\"message\":\"提交数据数据成功!\"}";
				}else{
					return "{\"resultFlag\":false,\"failureReason\":\"" +re.getString("message")+
							"!\"}";
				}
			}else{
				logger.info("返回结果没有遵守协议:返回结果为:"+re);
				return "{\"resultFlag\":false,\"failureReason\":\"返回结果没有遵守相应字段协议,未找到对应字段 isSuccess !\"}";
			}
		}catch (Exception e) {
			//捕获异常
			logger.info("提交给PC端数据出现异常");
			e.printStackTrace();
			return "{\"resultFlag\":false,\"failureReason\":\"提交给PC端数据出现异常!\"}";
		}	
	}

	/**
	 * 将数据提交给PC端
	 * @param toPcUrl
	 * @param json
	 * @param esbServerCode
	 * @return
	 * @throws IOException 
	 */
	private JSONObject httpPostWithJSON(String toPcUrl,String json,String esbServiceCode) throws IOException {
        //logger.info("toPcUrl:"+toPcUrl+";json:"+json);
		HttpClient hc = new HttpClient();

		// 设置编码格式
		hc.getParams().setContentCharset("UTF-8");

		// 设置超时时间
		HttpConnectionManagerParams managerParams = hc
				.getHttpConnectionManager().getParams();

		// 设置连接超时时间(单位毫秒)
		managerParams.setConnectionTimeout(Constants.PROC_TIME);

		// 设置读数据超时时间(单位毫秒)
		managerParams.setSoTimeout(Constants.PROC_TIME);
		Protocol myhttps = new Protocol("https",
				new MySSLProtocolSocketFactory(), Constants.HTTP_PROTOCOL);
		Protocol.registerProtocol("https", myhttps);

		// header设置
		Map<String, String> map = new HashMap<String, String>();
		map.put("version", "1.0");
		map.put("Content-Type", "application/json;charset=UTF-8");
		map.put("esbServiceCode", esbServiceCode);
		map.put("requestId", UUID.randomUUID().toString());
		map.put("sourceSystem", "DPM");
		//将Map转换为JSONString
		String headerJson = JsonUtil.mapToJsonString(map);
        //设置编码格式
		RequestEntity entity = new StringRequestEntity(json,
				"application/json", "UTF-8");
		PostMethod post = new PostMethod(toPcUrl);
		post.setRequestEntity(entity);
		post.addRequestHeader("Content-Type", "application/json;charset=UTF-8");
		post.addRequestHeader("requestHeaders", headerJson);

		logger.info("post url ==========>" + toPcUrl);
		//logger.info("post paramter 往PC端传入的参数是 ==========>" + json);
		logger.info("post header ==========>" + headerJson);

		// 执行postMethod
		hc.executeMethod(post);

		String result = post.getResponseBodyAsString();
		//转成JSONObject
		JSONObject response = JSONObject.fromObject(result);

		logger.info(" response status : " + post.getStatusCode());
		logger.info(esbServiceCode + " response data : " + result);
		logger.info("response:"+response);
		//返回数据
		return response;
	}

	/**
	 * PC端向移动端请求数据 task
	 * @param json 项目编码
	 * @return JONS TaskSubmitEntity
	 */
	@Override
	public Response getTaskForPC(String json) {
		//new 一个新的对象
		TaskSubmitEntity entity = new TaskSubmitEntity();
		try{
			logger.info("PC端向移动端请求数据 task;json is -->"+json+"<--");
			//json转实体对象
			TaskCheckEntity taskCheckEntity = JsonUtil.jsonToEntity(json, TaskCheckEntity.class);
			//得到deptCode
			String number = taskCheckEntity.getDeptCode();
			//查询任务是否存在
			int flag = this.procRecordDao.hasTask(taskCheckEntity.getDeptCode());
			//查询任务是否存在
			if(flag>0){
				logger.info("有任务数据,推送任务信息");
				//查询项目编号是否已经提交给PC端
				int yes = this.procRecordDao.getTaskStatus(number);
				//判断
				if(yes>0){
					//有任务数据,且已经提交
					logger.info("且数据已经提交");
					entity = this.getTaskSubmitEntity(number);
					entity.setIsSuccess(1);//设置状态标识位  				
				}else{
					//有任务数据,但没有最终提交给PC端
					logger.info("但是数据没有提交");
					entity.setIsSuccess(2);
				}	
			}else{
				logger.info("没有任务数据----》没有任务数据,请保存任务信息");
				entity.setIsSuccess(0);
			}
			//转json
			String jsonStr = JsonUtil.beanToJsonString(entity);
			//返回数据
			return Response.ok(jsonStr).header("ESB-ResultCode", "1").build();
			/*response.addHeader("ESB-ResultCode", "1");
			return JsonUtil.beanToJsonString(entity);*/
		}catch (Exception e) {
			//捕获异常
			e.printStackTrace();
			logger.info("PC端向移动端请求数据  明细信息出现错误  has Error");
			entity.setIsSuccess(Constants.PROC_TEN);
			String jsonStr = JsonUtil.beanToJsonString(entity);
			return Response.ok(jsonStr).header("ESB-ResultCode", "1").build();
			/*response.addHeader("ESB-ResultCode", "1");
			return JsonUtil.beanToJsonString(entity);*/
		}
	}
	
	/**
	 * 根据项目编码得到要推送数据 明细信息
	 * @param number 项目编码
	 * @return TaskSubmitEntity
	 */
	@Override
	public TaskSubmitEntity getTaskSubmitEntity(String number) {
		//new 一个新的对象
		TaskSubmitEntity entity = new TaskSubmitEntity();
		try{
			//根据项目编码获得扣分详细
			List<ProcCheckPCEntity> list = this.procRecordDao.getProcCheckList(number);
			//获得初次更新时间
			Date firstTime = this.procRecordDao.getFirstUpdateTime(number);
			if(firstTime != null){
				//时间格式转换
				String firstTimeStr = DateUtil.getFormatDateTime(firstTime, DateUtil.DateTimeFormatString);
				entity.setFirstAcceptanceTime(firstTimeStr);
			}
			//获得每次提交的总分
			int firstScore = this.procRecordDao.getScoreFirstOrLast(1,number);
			//获得每次提交的总分
			int lastScore = this.procRecordDao.getScoreFirstOrLast(2,number);
			//塞入数据
			entity.setNumber(number);
			//塞入数据
			entity.setPointsTotal(lastScore);
			//塞入数据
			entity.setFirstPointsTotal(firstScore);
			//new 一个新的hashmap
			Map<String, String> entriesMap = new HashMap<String, String>();
			//循环数据
			for(ProcCheckPCEntity pc : list){
				//判断工号是否为null
				if(StringUtils.isNotEmpty(pc.getUserNo())){
					entity.setAcceptancePeople(pc.getUserNo());
				}
				if(!entriesMap.containsKey(pc.getOrigItemCode())){
					EntriesEntity en = new EntriesEntity();
					//塞入数据
					en.setPart(pc.getNavCode());
					//塞入数据
					en.setPartName(pc.getNavName());
					//塞入数据
					en.setMatter(pc.getOrigItemCode());
					//塞入数据
					en.setMatterName(pc.getOrigItemName());
					//塞入数据
					en.setAcceptancePoint(pc.getScore());
					//塞入数据
					en.setComment(pc.getOpinion());
					//塞入数据
					entity.getEntries().add(en);
					//塞入数据
					entriesMap.put(pc.getOrigItemCode(), pc.getOrigItemCode());
				}
				entity.addPcInfo(pc);
			}
		}catch (Exception e) {
			logger.info("组装数据出错.... has error");
			e.printStackTrace();
		}
		//返回数据
		return entity;
	}

	/**
	 * @return procRecordDao
	 */
	public IProcRecordDao getProcRecordDao() {
		return procRecordDao;
	}
	public void setProcRecordDao(IProcRecordDao procRecordDao) {
		this.procRecordDao = procRecordDao;
	}
	/**
	 * @return toPcUrl
	 */
	public String getToPcUrl() {
		return toPcUrl;
	}
	public void setToPcUrl(String toPcUrl) {
		this.toPcUrl = toPcUrl;
	}
	/**
	 * @return proCheckESBCode
	 */
	public String getProCheckESBCode() {
		return proCheckESBCode;
	}
	public void setProCheckESBCode(String proCheckESBCode) {
		this.proCheckESBCode = proCheckESBCode;
	}
	

}

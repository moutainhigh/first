package com.deppon.dpm.module.projecttools.server.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.login.server.vo.LoginResult;
import com.deppon.dpm.module.common.server.service.impl.RedisService;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.common.server.util.MySSLProtocolSocketFactory;
import com.deppon.dpm.module.projecttools.server.dao.IDppmReportDao;
import com.deppon.dpm.module.projecttools.server.dao.IDppmTaskDao;
import com.deppon.dpm.module.projecttools.server.service.IDppmReportService;
import com.deppon.dpm.tongxunlu.shared.domain.EmployeeEntity;
/**
 * 报表管理  
 * 任务工时上报、需求上线时效、需求点均成本 service
 * @author gcl
 */
public class DppmReportService implements IDppmReportService {
	private static Logger logger = LoggerFactory.getLogger(DppmReportService.class);
	
	private IDppmReportDao dao;
	private IDppmTaskDao dppmTaskDao;
	
	//任务工时上报 接口地址
	private String timeuri;
	//任务工时上报(最近一周) 接口地址
	private String weekuri;
	//需求上线时效  接口地址
	private String onlineuri;
	//需求点均成本 接口地址
	private String pointuri;
	//需求点均成本(最近一年) 接口地址
	private String yearuri;
	//功能点完成率 接口地址
	private String rateuri;
	
	//项目进度成本 接口地址 9.12
	private String costuri;
	
	//报表权限 访问人员
	private String powerUser;
	
	// 注入
	private RedisService loginRedisService;
	
	/**
	 * 任务工时上报查询
	 * @return
	 */
	public String taskTimeReport(String userId,String date) {
//		this.timeuri="http://10.224.226.150:8081/dppm/ws/dppmWorkReport/queryWorkReport";
		//获得用户级别
//		Object rstLogin = DpmCacheManager.getWfs(userId);
//		Result<LoginResult> login = (Result<LoginResult>) rstLogin;
//		EmployeeEntity e = login.getData().getUserEntity().getEmployee();
		String jobLevel = null;
		try {
			String loginInfoStr = loginRedisService.get(RedisService.DPM_LOGIN_LOGININFO_KEY + userId);
			LoginResult loginResult = JSON.parseObject(loginInfoStr, LoginResult.class);
			EmployeeEntity e = loginResult.getUserEntity().getEmployee();
			jobLevel = e.getJobLevel();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String level = "";
		// 判断当前审批人是否band9以上  C D 总裁 副总裁
		if (jobLevel != null && !jobLevel.equals("") && (jobLevel.equals("C") || jobLevel.equals("D") || Integer.parseInt(jobLevel) > 9)){
			//查询 企业发展办公室 全部数据  高级总监直管
			level = "0";
		} 
		int deptLevel = this.dao.queryJobLevel(userId);
		if(deptLevel > 0) {
			level = deptLevel + "";
		}
		String json = "{\"startDate\":\"" + userId + "\",\"endDate\":\"" + date + "\",\"yearMonth\":\"" + level + "\"}";
		logger.info("dppm taskTimeReport url is :" + this.timeuri + "--json:" + json);
		return restfulWork(this.timeuri,"ESB_DPM2ESB_WORKHOURS_REPORT_FORM", json);
	}
	/**
	 * 任务工时上报(最近一周工时上报)查询
	 * @return
	 */
	public String taskWeekReport(String userId,String date) {
		//获得用户级别
//		Object rstLogin = DpmCacheManager.getWfs(userId);
//		Result<LoginResult> login = (Result<LoginResult>) rstLogin;
//		EmployeeEntity e = login.getData().getUserEntity().getEmployee();
		String jobLevel = null;
		try {
			String loginInfoStr = loginRedisService.get(RedisService.DPM_LOGIN_LOGININFO_KEY + userId);
			LoginResult loginResult = JSON.parseObject(loginInfoStr, LoginResult.class);
			EmployeeEntity e = loginResult.getUserEntity().getEmployee();
			jobLevel = e.getJobLevel();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String level = "";
		// 判断当前审批人是否band9以上  C D 总裁 副总裁
		if (jobLevel != null && !jobLevel.equals("") && (jobLevel.equals("C") || jobLevel.equals("D") || Integer.parseInt(jobLevel) > 9)){
			//查询 企业发展办公室 全部数据  高级总监直管
			level = "0";
		} 
		int deptLevel = this.dao.queryJobLevel(userId);
		if(deptLevel > 0) {
			level = deptLevel + "";
		}
		String json = "{\"startDate\":\"" + userId + "\",\"endDate\":\"" + date + "\",\"yearMonth\":\"" + level + "\"}";
		logger.info("dppm taskWeekReport url is :" + this.weekuri + "--json:" + json);
		return restfulWork(this.weekuri,"ESB_DPM2ESB_WORK_HOUSE_REPORT_DIAGRAM", json);
	}
	/**
	 * 需求上线时效
	 * @param bdate 开始日期
	 * @param edate 结束日期
	 * @return
	 */
	public String demandOnlineAging(String bdate,String edate) {
//		this.onlineuri="http://192.168.20.207:80/dppm/ws/dppmOnlineAging/queryOnlineAging";
		logger.info("dppm demandOnlineAging url is :" + this.onlineuri);
		String json = "{\"startDate\":\"" + bdate + "\",\"endDate\":\"" + edate + "\"}";
		return restfulWork(this.onlineuri,"ESB_DPM2ESB_DEMAND_MANAGEMENT_ONLINE_REPORT", json);
	}
	/**
	 * 需求点击成本
	 * @param bdate 开始日期
	 * @param edate 结束日期
	 * @return
	 */
	public String demandPointMoney(String bdate,String edate) {
		logger.info("dppm demandPointMoney url is :" + this.pointuri);
		String json = "{\"querydatestart\":\"" + bdate + "\",\"querydatesend\":\"" + edate + "\"}";
		return restfulWork(this.pointuri,"ESB_DPM2ESB_DAIL_DEMAND_POINT_AVG_COST_REPORT", json);
	}
	/**
	 * 需求点击成本 (最近一年整体点均成本)
	 * @return
	 */
	public String demandPointAging() {
//		this.yearuri = "http://192.168.67.12:8580/esb2/rs/ESB_DPM2ESB_POINT_AVG_COST_DIAGRAM";
		logger.info("dppm demandPointAgingToMonth url is :" + this.yearuri);
//		String json = "{\"d\":\"d\"}";
		return restfulWork(this.yearuri,"ESB_DPM2ESB_POINT_AVG_COST_DIAGRAM", "");
	}
	/**
	 * 功能点完成率（日常需求人均功能点数）
	 * 2015-08-27
	 * @param bdate 起始日期
	 * @param edate 结束日期
	 * @param date 月
	 * @return
	 */
	public String funcCompleteRate(String bdate,String edate,String date) {
		logger.info("dppm funcCompleteRate url is :" + this.rateuri);
		String json = "{\"startDate\":\"" + bdate + "\",\"endDate\":\"" + edate + "\",\"yearMonth\":\"" + date + "\"}";
		return restfulWork(this.rateuri,"ESB_DPM2ESB_FUNCTION_COMPLETION_RATE_REPORT", json);
	}
	/**
	 * 项目进度成本    9.12
	 * @param json 搜索条件
	 * @return
	 */
	public String projectCostQuery(String json) {
		logger.info("dppm projectCostQuery url is :" + this.costuri);
		return restfulWork(this.costuri,"ESB_DPM2ESB_PROJECT_SCHEDULE_COST", json);
	}
	/**
	 * 项目进度成本高级搜索默认加载数据字典数据
	 * 项目类型，项目级别，所属本部
	 * @return
	 */
	public String proTypeQuery() {
		return this.dao.proTypeQuery();
	}
	/**
	 * 项目进度成本 高级搜索  按名称模糊搜索 项目名称，承接部门
	 * @param type 搜索类型
	 * @param name 搜索条件
	 * @return
	 */
	public String proDeptQuery(int type, String name) {
		return this.dao.proDeptQuery(type, name);
	}
	/**
	 * 权限判断
	 * @param userId 用户工号
	 * @return
	 */
	public String powerReport(String userId) throws Exception {
		// 定义map 变量
		Map<String, Object> map = new HashMap<String, Object>();
		//先判断 有读取报表权限的固定用户
		int power = 0; 
		if(this.isPower(userId, powerUser)) {
			power = 1;
		}else{
			power = this.dao.powerReport(userId);
		}
		map.put("reportPower", power);
		//获取需要审核的任务数
        int count = dppmTaskDao.getTaskCommitCount(userId);
        //需要审核的任务数
        map.put("commitCount", count);
        return JsonUtil.mapToJsonString(map);
	}
	/**
	 * restful 客户端公共方法
	 * @param uri  esb接口地址
	 * @param esbCode 服务编码
	 * @param json 输入参数
	 * @return
	 */
	public String restfulWork(String uri,String esbCode, String json) {
		String responseBody = null;
		try {
			HttpClient httpClient = new HttpClient();

			// 设置编码格式
			httpClient.getParams().setContentCharset("UTF-8");
			// 设置超时时间
			HttpConnectionManagerParams managerParams = httpClient
					.getHttpConnectionManager().getParams();

			// 设置连接超时时间(单位毫秒)
			managerParams.setConnectionTimeout(200000);
			// 设置读数据超时时间(单位毫秒)
			managerParams.setSoTimeout(180000);
			Protocol myhttps = new Protocol("https",
					new MySSLProtocolSocketFactory(), 443);
			Protocol.registerProtocol("https", myhttps);
			// 构造PostMethod的实例
			PostMethod postMethod = new PostMethod(uri);

			Map<String, String> map = new HashMap<String, String>();
			map.put("version", "1.0");
			map.put("Content-Type", "application/json;charset=UTF-8");
			map.put("esbServiceCode", esbCode);
			map.put("requestId", UUID.randomUUID().toString());
			map.put("sourceSystem", "DPM");

			logger.info("dppm request param is :" + json);
			RequestEntity entity = new StringRequestEntity(json,
					"application/json", "UTF-8");
			postMethod.setRequestEntity(entity);
			postMethod.addRequestHeader("Content-Type",
					"application/json;charset=UTF-8");
			postMethod.addRequestHeader("requestHeaders",
					JSONObject.toJSONString(map));
			// 执行postMethod
			httpClient.executeMethod(postMethod);
			responseBody = postMethod.getResponseBodyAsString();
		} catch (Exception e) {
			responseBody = e.getMessage();
			e.printStackTrace();
		}
		logger.info("dppm response return is:" + responseBody);
		return responseBody;
	}
	/**
	 * kPi数据统计 
	 * 0：项目管理 6：报表管理 11：任务管理 15：年度规划
	 * @param date 统计日期---统计日期默认为昨天
	 * @return
	 */
	public String queryKpi(String date) {
		return this.dao.queryKpi(date);
	}
	/**
	 * 是否有权限
	 * @param userId 当前用户
	 * @param jobNumber 有权限的工号集合
	 * @return
	 */
	public boolean isPower(String userId,String jobNumber){
		String a[]=jobNumber.split(",");
		for(String number:a){
			if(number.trim().equals(userId.trim())){
				return true;
			}
		}
		return false;
	}
	/**
	 * @param dao
	 */
	public void setDao(IDppmReportDao dao) {
		this.dao = dao;
	}
	/**
	 * @param timeuri
	 */
	public void setTimeuri(String timeuri) {
		this.timeuri = timeuri;
	}
	/**
	 * @param weekuri
	 */
	public void setWeekuri(String weekuri) {
		this.weekuri = weekuri;
	}
	/**
	 * @param onlineuri
	 */
	public void setOnlineuri(String onlineuri) {
		this.onlineuri = onlineuri;
	}
	/**
	 * @param pointuri
	 */
	public void setPointuri(String pointuri) {
		this.pointuri = pointuri;
	}
	/**
	 * @param yearuri
	 */
	public void setYearuri(String yearuri) {
		this.yearuri = yearuri;
	}
	/**
	 * @param rateuri
	 */
	public void setRateuri(String rateuri) {
		this.rateuri = rateuri;
	}
	/**
	 * @param costuri
	 */
	public void setCosturi(String costuri) {
		this.costuri = costuri;
	}
	/**
	 * @param powerUser
	 */
	public void setPowerUser(String powerUser) {
		this.powerUser = powerUser;
	}
	/**
	 * @param dppmTaskDao
	 */
	public void setDppmTaskDao(IDppmTaskDao dppmTaskDao) {
		this.dppmTaskDao = dppmTaskDao;
	}
	
	/**
	 * setter
	 */
	public void setLoginRedisService(RedisService loginRedisService) {
		this.loginRedisService = loginRedisService;
	}
	
}

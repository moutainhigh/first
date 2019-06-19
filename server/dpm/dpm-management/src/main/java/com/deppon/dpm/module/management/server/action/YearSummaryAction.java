package com.deppon.dpm.module.management.server.action;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.service.impl.RedisService;
import com.deppon.dpm.module.common.server.util.ParamUtils;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.management.server.service.IYearSummaryService;
import com.deppon.dpm.module.management.shared.domain.YearSummaryEntity;
import com.deppon.dpm.tongxunlu.server.service.ITongxunLuService;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;

/**
 * 2017年度总结
 * @author 276344
 *
 */


public class YearSummaryAction extends BaseAction{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger  = LoggerFactory.getLogger(YearSummaryAction.class);
	private IYearSummaryService summaryService;
	/**
	 * RedisService
	 */
	private RedisService loginRedisService;
	
	/**
	 * 服务接口.
	 */
	private ITongxunLuService tongxunLuService;
	
	private String status;
	private String url;
	
	@CookieNotCheckedRequired
	public void summary(){
		//localhost:8080/dpm/dpm-management/yearSummary_summary.action
		this.solveCrossDomain();
		Result<YearSummaryEntity> result = new Result<YearSummaryEntity>();
		YearSummaryEntity entity = new YearSummaryEntity();
		try {
			entity = summaryService.getSummaryByEmpcode(userId);

			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("查询：" + userId + "的年度总结出错 原因为：" + e.toString());
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("请求异常:" + e);
		}
		// count
		result.setCount(1);
		// data
		result.setData(entity);
		// 返回
		writeToPage(result);
	}
	
	/**
	 * 18年度总结
	 */
	@CookieNotCheckedRequired
	public void yearSummary(){
		//localhost:8080/dpm/dpm-management/yearSummary_summary.action
		this.solveCrossDomain();
		Result<YearSummaryEntity> result = new Result<YearSummaryEntity>();
		YearSummaryEntity entity = new YearSummaryEntity();
		String da=null;
		
		try {
			if(ParamUtils.checkUserId(userId)){
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				// errorMessage
				result.setErrorMessage("工号错误，不符合规范");
				writeToPage(result);
				return;
			}
			EmployeeVO emp = new EmployeeVO();
			emp.setEmpCode(userId);
			List<EmployeeVO> searchEmp = tongxunLuService.searchEmp(emp, 0, 0);
			if(null!=searchEmp){
			  da=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(searchEmp.get(0).getInDate());
			}
			if(da.startsWith("2019-")){
				result.setErrorCode(2);
				// errorMessage
				result.setErrorMessage("2019年以后入职的没有2018年总结");
				writeToPage(result);
				return;
			}
			entity = summaryService.getYearSummary(userId);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("查询：" + userId + "的年度总结出错 原因为：" + e.toString());
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("请求异常:" + e);
		}
		// count
		result.setCount(1);
		// data
		result.setData(entity);
		// 返回
		writeToPage(result);
	}
	
	/**
	 * 控制年度总结权限
	 */
	@CookieNotCheckedRequired
	public void summaryJurisdiction(){
		//localhost:8080/dpm/dpm-management/yearSummary_summary.action
		String jurisdiction = null;
		String url = null;
		Map<String, Object> map = new HashMap<String, Object>();
		this.solveCrossDomain();
		Result<Object> result = new Result<Object>();
		try {
			jurisdiction = loginRedisService.get(RedisService.DPM_JURISDICTION_KEY);
			if (null == jurisdiction) {
				jurisdiction = "off";
			}else if (jurisdiction.equals("on")) {
				if(null==userId){
					jurisdiction = "on";
				}else{
					EmployeeVO emp = new EmployeeVO();
					emp.setEmpCode(userId);
					List<EmployeeVO> searchEmp = tongxunLuService.searchEmp(emp, 0,
							0);
					if (null != searchEmp) {
						if (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(
								searchEmp.get(0).getInDate()).startsWith("2019-")) {
							jurisdiction = "off";
						}
					}
				}
			}
			
			url = loginRedisService.get(RedisService.DPM_JURISDICTION_URL);
			if (null == url) {
				url = "";
			}
			map.put("url", url);
			map.put("jurisdiction", jurisdiction);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("查询：" + userId + "的年度总结出错 原因为：" + e.toString());
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("请求异常:" + e);
		}
		// count
		result.setCount(1);
		// data
		result.setData(map);
		// 返回
		writeToPage(result);
	}
	
	
	/**
	 * 控制年度总结权限
	 */
	public void setJurisdiction(){
		//localhost:8080/dpm/dpm-management/yearSummary_summary.action
		
		this.solveCrossDomain();
		Result<String> result = new Result<String>();
		try {
			 loginRedisService.set(RedisService.DPM_JURISDICTION_KEY,status);
			 loginRedisService.set(RedisService.DPM_JURISDICTION_URL,url);

			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("查询：" + userId + "的年度总结出错 原因为：" + e.toString());
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("请求异常:" + e);
		}
		// count
		//result.setCount(0);
		// data
		result.setData("设置成功");
		// 返回
		writeToPage(result);
	}
	
	
	/**
	 * 获取离职人员入职日期
	 */
	@CookieNotCheckedRequired
	public void leavePunch(){
		//localhost:8080/dpm/dpm-management/yearSummary_summary.action
		this.solveCrossDomain();
		Result<EmployeeVO> result = new Result<EmployeeVO>();
		EmployeeVO entity = new EmployeeVO();
		
		try {
			entity = summaryService.getLeaveEmpcode(userId);
			
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("查询：" + userId + "的年度总结出错 原因为：" + e.toString());
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("请求异常:" + e);
		}
		// count
		result.setCount(1);
		// data
		result.setData(entity);
		// 返回
		writeToPage(result);
	}
	
	/**
	 * 解决H5跨域
	 */
	public void solveCrossDomain(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
	}

	public void setSummaryService(IYearSummaryService summaryService) {
		this.summaryService = summaryService;
	}

	public RedisService getLoginRedisService() {
		return loginRedisService;
	}

	public void setLoginRedisService(RedisService loginRedisService) {
		this.loginRedisService = loginRedisService;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ITongxunLuService getTongxunLuService() {
		return tongxunLuService;
	}

	public void setTongxunLuService(ITongxunLuService tongxunLuService) {
		this.tongxunLuService = tongxunLuService;
	}
	
	
}

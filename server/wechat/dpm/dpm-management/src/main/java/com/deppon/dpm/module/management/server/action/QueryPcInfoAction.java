package com.deppon.dpm.module.management.server.action;

import java.io.BufferedReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.management.server.service.IQueryPcInfoService;
import com.deppon.dpm.module.management.shared.domain.ServeOriginatorsInfoEntity;
import com.deppon.dpm.module.management.shared.vo.PcDetailInfoVo;
/**
 * 拼车查询Action
 * @author 293888
 *
 */
public class QueryPcInfoAction extends BaseAction {

	/**
	 * 序列
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 日志
	 */
	Logger log = LoggerFactory.getLogger(QueryPcInfoAction.class);
	
	/**
	 * 拼车Service 
	 */
	IQueryPcInfoService queryPcInfoService;

	/**
	 * 拼车类型
	 */
	private String origType;

	/**
	 * 工号
	 */
	private String origNo;

	/**
	 * 列表id
	 */
	private String id;
	
	/**
	 * 拼车Service 
	 * @return 拼车Service
	 */
	public IQueryPcInfoService getQueryPcInfoService() {
		return queryPcInfoService;
	}

	public void setQueryPcInfoService(IQueryPcInfoService queryPcInfoService) {
		this.queryPcInfoService = queryPcInfoService;
	}

	/**
	 * 拼车类型
	 * @return 拼车类型
	 */
	public String getOrigType() {
		return origType;
	}

	public void setOrigType(String origType) {
		this.origType = origType;
	}
	
	/**
	 * 工号
	 * @return 工号
	 */
	public String getOrigNo() {
		return origNo;
	}

	public void setOrigNo(String origNo) {
		this.origNo = origNo;
	}
	
	/**
	 * 列表id
	 * @return
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 首页显示
	 */
	public void queryPcListByType() {
		//String res = "{\"resultFlag\":false,\"failureReason\":\"获取信息失败\"}";
		List<ServeOriginatorsInfoEntity> newList = new ArrayList<ServeOriginatorsInfoEntity>();// 用来存放时间转换后的list集合
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		HttpServletResponse response = null;
		response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		BufferedReader bu = null;
		//用来接收前台数据
		String str = "";
		Result<List<ServeOriginatorsInfoEntity>> result = null;
		try {
			result = new Result<List<ServeOriginatorsInfoEntity>>();
			bu = ServletActionContext.getRequest().getReader();
			// 得到页面传来的参数
			str = com.deppon.dpm.module.common.server.util.StringUtil
					.bufferString(bu);
			@SuppressWarnings("static-access")
			JSONObject json = new JSONObject().parseObject(str);
			//非空判断json
			if(null != json){
				
			
			origType = json.getString("origType");
			String pageSize = json.getString("pageSize");
			String pageNum = json.getString("pageNum");
			String startProvinceCode = json.getString("startProvinceCode");
			String keyWord = json.getString("keyWord");
			int carType = json.getIntValue("carType");
			int payType = json.getIntValue("payType");
			//分页判断
			if (StringUtils.isEmpty(pageSize)) {
				result.setErrorMessage("没有参数传入  pageSize");
			} else {
				if (StringUtils.isEmpty(pageNum)) {
					pageNum = "1";
				}

				if ("".equals(keyWord)) {
					keyWord = null;
				}

				int pageNumInt = Integer.parseInt(pageNum) - 1;

				if (pageNumInt < 0) {
					pageNumInt = 0;
				}

				int pageSizeInt = Integer.parseInt(pageSize);
				//获得数据
				List<ServeOriginatorsInfoEntity> list = queryPcInfoService
						.queryPCListByType(pageNumInt, pageSizeInt, origType, startProvinceCode, keyWord,carType,payType);
				
				if (null!=list &&list.size() > 0) {
					for (ServeOriginatorsInfoEntity temp : list) {

						//设置总记录数
						temp.setPartNum(queryPcInfoService.getPeoCount(String
								.valueOf(temp.getId())));
						
						//格式化时间
						if (null != temp.getStartTime()) {
							temp.setStartDate(sdf.format(temp.getStartTime()));
						}
						//时间校验
						if (null != temp.getCreateTime()) {
							temp.setCreateDate(sdf.format(temp.getCreateTime()));
						}
						//时间校验
						if (null != temp.getPartTime()) {
							temp.setPartDate(sdf.format(temp.getPartTime()));
						}
						//时间校验
						if (null != temp.getUpdateTime()) {
							temp.setUpdateDate(sdf.format(temp.getUpdateTime()));
						}
						
						if(null == temp.getOrigImg()){
							temp.setOrigImg("");
						}
						
						newList.add(temp);
					}
					int num = queryPcInfoService.getCount(origType,
							startProvinceCode, keyWord,carType,payType);
					result.setCount(num);
					result.setData(newList);
				} else {
					result.setData(null);
				}
			}
			}
		} catch (Exception e) {
			//异常处理
			log.debug("系统异常，获取信息失败！", e);
		}
		writeToPage(response, result);

	}

	/**
	 * 我发起显示
	 */
	public void queryPCListByOrgiNo() {
		// String res = "{\"resultFlag\":false,\"failureReason\":\"获取信息失败\"}";
		List<ServeOriginatorsInfoEntity> newList = new ArrayList<ServeOriginatorsInfoEntity>();// 用来存放时间转换后的list集合
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		HttpServletResponse response = null;
		response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		BufferedReader bu = null;
		Result<List<ServeOriginatorsInfoEntity>> result = null;
		//用来接收前台数据
		String str = "";
		try {
			result = new Result<List<ServeOriginatorsInfoEntity>>();
			bu = ServletActionContext.getRequest().getReader();
			// 得到页面传来的参数
			str = com.deppon.dpm.module.common.server.util.StringUtil
					.bufferString(bu);
			@SuppressWarnings("static-access")
			JSONObject json = new JSONObject().parseObject(str);
			//非空判断so
			if(null != json){
			//工号
			origNo = json.getString("origNo");
			//类型
			String typePc = json.getString("typePc");
			List<ServeOriginatorsInfoEntity> list = null;
			result.setData(null);
			result.setCount(0);
			//我发起，我参与判断
			if (null != typePc && !"".equals(typePc)) {
				//我发起
				if ("0".equals(typePc)) {
					list = queryPcInfoService.queryPCListByOrgiNo(origNo);
				}
				//我参与
				if ("1".equals(typePc)) {
					list = queryPcInfoService.queryPCListById(origNo);
				}

				if (null!=list &&list.size() > 0) {
					for (ServeOriginatorsInfoEntity temp : list) {
						//设置记录总数
						temp.setPartNum(queryPcInfoService.getPeoCount(String
								.valueOf(temp.getId())));
						//时间校验
						if (null != temp.getStartTime()) {
							temp.setStartDate(sdf.format(temp.getStartTime()));
						}
						//时间校验
						if (null != temp.getCreateTime()) {
							temp.setCreateDate(sdf.format(temp.getCreateTime()));
						}
						//时间校验
						if (null != temp.getPartTime()) {
							temp.setPartDate(sdf.format(temp.getPartTime()));
						}
						//时间校验
						if (null != temp.getUpdateTime()) {
							temp.setUpdateDate(sdf.format(temp.getUpdateTime()));
						}

						newList.add(temp);
					}
					result.setCount(list.size());
					result.setData(newList);
				} 
			}
			}
		} catch (Exception e) {
			//异常处理
			log.debug("系统异常，获取信息失败！", e);
			e.printStackTrace();
			
		}
		writeToPage(response, result);

	}

	/**
	 * 详情显示
	 */
	public void queryPCDetailById() {
		String res = "{\"resultFlag\":false,\"failureReason\":\"获取信息失败\"}";
		// 用来存放时间转换后的list集合
		//List<ServeOriginatorsInfoEntity> newList = new ArrayList<ServeOriginatorsInfoEntity>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		HttpServletResponse response = null;
		response = ServletActionContext.getResponse();
		// 设置页面响应实体
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		BufferedReader bu = null;
		
		String str = "";
		try {
			bu = ServletActionContext.getRequest().getReader();
			// 得到页面传来的参数
			str = com.deppon.dpm.module.common.server.util.StringUtil
					.bufferString(bu);
			@SuppressWarnings("static-access")
			JSONObject json = new JSONObject().parseObject(str);
			//非空判断
			if(null != json){
			id = json.getString("id");
			//获得数据
			PcDetailInfoVo vo = queryPcInfoService.queryPCDetailById(id);
			if (null != vo) {
				ServeOriginatorsInfoEntity temp = vo
						.getServeOriginatorsInfoEntity();
				//非空验证
				if (null != temp) {

					//根据vo
					temp.setPartNum(queryPcInfoService.getPeoCount(String
							.valueOf(temp.getId())));
					//格式化时间
					if (null != temp.getStartTime()) {
						temp.setStartDate(sdf.format(temp.getStartTime()));
					}
					//时间校验
					if (null != temp.getCreateTime()) {
						temp.setCreateDate(sdf.format(temp.getCreateTime()));
					}
					//时间校验
					if (null != temp.getPartTime()) {
						temp.setPartDate(sdf.format(temp.getPartTime()));
					}
					//时间校验
					if (null != temp.getUpdateTime()) {
						temp.setUpdateDate(sdf.format(temp.getUpdateTime()));
					}
					//封装vo对象
					vo.setServeOriginatorsInfoEntity(temp);
					vo.setResultFlag(true);
				}
				res = JsonUtil.beanToJsonString(vo);
			} else {
				res = "{\"resultFlag\":false,\"failureReason\":\"数据异常\"}";
			}
			}
		} catch (Exception e) {
			//异常处理
			log.debug("系统异常，获取信息失败！", e);
			e.printStackTrace();
		}
		writeToPage(response, res);

	}

}

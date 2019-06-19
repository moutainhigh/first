package com.deppon.dpm.module.common.server.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.module.common.server.dao.IMonitorActionInfoDao;
import com.deppon.dpm.module.common.shared.domain.ModuleAccessVpInfo;
import com.deppon.dpm.module.common.shared.vo.ModuleAccessVo;
import com.deppon.dpm.module.common.shared.vo.Result;

/**
 * 模块访问数据查询接口
 * 
 */
@Path("/info")
public class ModuleAccessService {
	// 日志
	private static final Logger LOG = LoggerFactory
			.getLogger(ModuleAccessService.class);

	/**
	 * monitorActionInfoDao
	 */
	private IMonitorActionInfoDao monitorActionInfoDao;

	/******* 移动BI调用的访问次数查询接口 *********/
	@Path("queryNumber")
	// 接收参数类型
	@Consumes(MediaType.APPLICATION_JSON)
	// 返回参数类型
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public Object queryModuleAccessNum(String content) {
		// 返回结果集定义
		Result<Object> result = new Result<Object>();
		long start = System.currentTimeMillis();
		LOG.info("移动BI调用的访问次数查询请求参数：" + content);
		try {
			// 空判断
			if (StringUtils.isEmpty(content)) {
				result.setErrorCode(1);
				result.setResult("查询参数内容为空！");
				LOG.info("移动BI调用的访问次数查询为空：" + content);
				// 返回结果
				return resultToResponse(result);
			}
			// json转换
			ModuleAccessVo vo = JSON.parseObject(content, ModuleAccessVo.class);
			// 空判断
			if (vo == null) {
				result.setErrorCode(1);
				result.setResult("查询参数Json转换出错！");
				LOG.info("移动BI调用的访问次数查询参数Json转换出错：" + content);
				// 返回结果
				return resultToResponse(result);
			}
			// 处理参数
			int status = dealParm(vo);
			if (status == 0) {
				result.setErrorCode(1);
				result.setResult("查询参数时间有误，请确认！");
				LOG.info("移动BI调用的访问次数查询参数处理出错：" + content);
				// 返回结果
				return resultToResponse(result);
			}
			// 处理查询结果集
			dealResult(result,vo);
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(1);
			// result
			result.setResult("移动BI调用的访问次数查询失败！");
			LOG.info("移动BI调用的访问次数查询失败" + e.getMessage());
		}
		long end = System.currentTimeMillis();
		LOG.info("移动BI调用访问次数查询接口用时>>>>" + (end - start) + "ms");
		// 响应
		return resultToResponse(result);
	}
	
	/**
	 * 处理查询结果集
	 * 
	 * @param result
	 * @param vo
	 */
	private void dealResult(Result<Object> result,ModuleAccessVo vo){
		// 返回结果集
		HashMap<String,Object> map = new HashMap<String,Object>();
		// 根据条件查询用户在区间中的访问模块次数
		if("1".equals(vo.getType())){
			Map<String,String> numMap = monitorActionInfoDao.queryModuleAccessNum(vo);
			map.put("empNum", numMap.get("empNum"));
			map.put("frequency", numMap.get("frequency"));
		} else if("2".equals(vo.getType())){
			// 根据条件查询在区间中的VP访问模块次数信息
			List<ModuleAccessVpInfo> vpList = monitorActionInfoDao.queryModuleAccessVpList(vo);
			map.put("vpList", vpList == null ? new ArrayList<ModuleAccessVpInfo>() : vpList);
		} else if("3".equals(vo.getType())){
			// 根据条件查询在区间中的vp闪退详细信息
			List<ModuleAccessVpInfo> vpBreakdownList = monitorActionInfoDao.queryModuleAccessVpBreakdownList(vo);
			map.put("vpBreakdownList", vpBreakdownList == null ? new ArrayList<ModuleAccessVpInfo>() : vpBreakdownList);
		} else if("4".equals(vo.getType())){
			// 根据条件查询VP用户访问模块的时间明细
			List<ModuleAccessVpInfo> vpInfoList = monitorActionInfoDao.queryModuleAccessVpInfoList(vo);
			map.put("vpInfoList", vpInfoList == null ? new ArrayList<ModuleAccessVpInfo>() : vpInfoList);
		}
		result.setData(map);
	}

	/**
	 * 处理参数
	 * 
	 * @param vo
	 */
	private int dealParm(ModuleAccessVo vo) {
		int status = 0;
		// 模块类型
		if (StringUtils.isEmpty(vo.getMonitorType())) {
			// 移动BI
			vo.setMonitorType("5");
		}
		try {
			// 时间处理
			if (StringUtils.isNotEmpty(vo.getDateFormat())
					&& StringUtils.isNotEmpty(vo.getBeginDate())
					&& StringUtils.isNotEmpty(vo.getEndDate())) {
				SimpleDateFormat sdf = new SimpleDateFormat(vo.getDateFormat());
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// 时间格式化
				vo.setBeginDate(sdf1.format(sdf.parse(vo.getBeginDate())));
				vo.setEndDate(sdf1.format(sdf.parse(vo.getEndDate())));
				status = 1;
			}
		} catch (ParseException e) {
			LOG.info("移动BI调用的访问次数查询时间处理出错" + e.getMessage());
		}
		// 返回
		return status;
	}

	/**
	 * 封装数据返回给response
	 * 
	 * @param result
	 * @return
	 */
	private Response resultToResponse(Result<Object> result) {
		// 即如果返回
		return Response
				.ok()
				// json返回
				.entity(JSON.toJSONString(result))
				// 头消息类型
				.header(HttpHeaders.CONTENT_TYPE,
						MediaType.APPLICATION_JSON + ";charset=UTF-8")
				// 跨域请求处理
				.header("Access-Control-Allow-Origin", "*").build();
	}

	/**
	 * set
	 * 
	 * @param monitorActionInfoDao
	 */
	public void setMonitorActionInfoDao(
			IMonitorActionInfoDao monitorActionInfoDao) {
		this.monitorActionInfoDao = monitorActionInfoDao;
	}
}

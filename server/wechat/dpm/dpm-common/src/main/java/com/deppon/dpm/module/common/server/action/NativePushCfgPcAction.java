package com.deppon.dpm.module.common.server.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.service.INativePushCfgService;
import com.deppon.dpm.module.common.server.util.HttpUtil;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.server.util.ThreadLocalUtil;
import com.deppon.dpm.module.common.shared.domain.NativePushCfgEntity;
import com.deppon.dpm.module.common.shared.vo.LoginResult;
import com.deppon.dpm.module.common.shared.vo.NativePushInfo;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 本地推送配置Action
 */
public class NativePushCfgPcAction extends BaseAction implements ModelDriven<NativePushCfgEntity>{
	
	// 日志
	private static final Logger LOG = LoggerFactory.getLogger(NativePushCfgPcAction.class);
	
	// 构造实体
	private NativePushCfgEntity entity = new NativePushCfgEntity();
	
	// service
	private INativePushCfgService nativePushCfgService;
	
	// 请求人事的生日推送信息的URL
	private String birthdayPushInfoUrl;

	// getModel
	public NativePushCfgEntity getModel() {
		return entity;
	}
	
	// 查询所有需要推送的配置信息
	public void queryAll(){
		// 结果集
		Result<List<NativePushCfgEntity>> result = new Result<List<NativePushCfgEntity>>();
		// 兼容android版本的标示符
		boolean flag = false;
		String osType = null;
		String appVersion = null;
		try {
			LoginResult loginResult = ThreadLocalUtil.getThreadLocal();
			osType = loginResult.getOsType();
			appVersion = loginResult.getAppVersion();
			Integer version = Integer.parseInt(appVersion.replace(".", ""));
			if("android".equals(osType) && version < MagicNumber.NUM379){
				flag = true;
			}
		} catch (Exception e) {
			LOG.error("请求本地推送配置信息判断版本兼容出错>>>>params={userId="+userId+"osType="+osType+",appVersion="+appVersion+"}");
		}
		
		String joblevel = null;
		String orgName = null;
		try {
			// 获取参数
			HttpServletRequest request = ServletActionContext.getRequest();
			joblevel = request.getParameter("joblevel");
			orgName =request.getParameter("orgName");
			
			// 日志
			LOG.info("请求本地推送配置信息开始>>>>params={userId="+userId+",joblevel="+joblevel+",orgName="+orgName+"}");
			// 查询所有有效的推送配置信息
			List<NativePushCfgEntity> list = nativePushCfgService.queryUsableAll();
			
			List<NativePushCfgEntity> needs = new ArrayList<NativePushCfgEntity>();
			// 请求接口的参数
			String jsonParams = "{\"empCode\":\"" + userId + "\"}";
			
			for (NativePushCfgEntity nativePushCfgEntity : list) {
						
				if(flag){
					// android版本在3.7.9之前，则跳过（因为3.7.8安卓只做了补考勤的本地提示）
					continue;
				}
				
				String pushCondition = nativePushCfgEntity.getPushCondition();
				if("ALL".equals(pushCondition)){
					// 全员推送
					needs.add(nativePushCfgEntity);
				} else {
					JSONObject jsonObject = JSON.parseObject(pushCondition);
					String joblevelStr = jsonObject.getString("JOBLEVEL");
					if(StringUtils.isNotEmpty(joblevelStr)){
						// 条件为级别
						List<String> joblevelList = Arrays.asList(joblevelStr.split(","));
						if(joblevelList.contains(joblevel)){
							needs.add(nativePushCfgEntity);
						}
					} else {
						// 条件为部门
						List<String> orgNameList = Arrays.asList(jsonObject.getString("ORG").split(","));
						if(orgNameList.contains(orgName)){
							needs.add(nativePushCfgEntity);
						}
					}
				}
			}
			
			/***请求生日和补考勤排版推送信息接口**/
			String responseStr = null;
			try {
				// 请求人事生日推送和补考勤排版推送接口获取生日推送的信息
				responseStr = HttpUtil.doPostJson(birthdayPushInfoUrl, jsonParams);
				if(StringUtils.isNotEmpty(responseStr)){
					List<NativePushInfo> parseArray = JSON.parseArray(responseStr,NativePushInfo.class);
					for (NativePushInfo nativePushInfo : parseArray) {
						if("true".equals(nativePushInfo.getResult())){
							NativePushCfgEntity nativePushEntity = new NativePushCfgEntity();
							nativePushEntity.setContent(nativePushInfo.getReason());
							nativePushEntity.setIntime(true);
							nativePushEntity.setTitle(nativePushInfo.getTitle());
							needs.add(nativePushEntity);
						}
					}
				}
			} catch (Exception e) {
				LOG.error("本地推送请求人事生日推送和补考勤排版信息接口出错！！userId=" + userId + ",responseStr=" + responseStr,e);
			}
			
			// 设置返回数据
			result.setErrorCode(0);
			result.setCount(needs.size());
			result.setData(needs);
		} catch (Exception e) {
			// 错误返回数据
			result.setErrorCode(MagicNumber.NUM1);
			result.setCount(0);
			// 日志
			LOG.error("请求本地推送配置信息出错！！" +
					"params={userId="+userId+",joblevel="+joblevel+",orgName="+orgName+"}",e);
		}
		// 返回
		writeToPage(result);
	}
	
	
	// 分页查询
	public void list() {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			// 当前页
			int page = entity.getPage();
			// 每页条数
			int rows = entity.getRows();
			int start = 0;
			if(page != 0) {
				start = (page -1) * rows;
			}
			// 查询
			List<NativePushCfgEntity> list = nativePushCfgService.list(start,rows);
			// 总条数
			long count = nativePushCfgService.queryCount();
			result.put("total", count);
			result.put("rows", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回
		writeToPage(result);
	}
	
	// 修改或保存
	public void saveOrUpdate() {
		try {
			if(entity.getId() != null) {
				// 修改
				nativePushCfgService.update(entity);
			} else {
				// 保存
				entity.setCreateTime(new Date());
				entity.setUpdateTime(entity.getCreateTime());
				entity.setStatus(true);
				nativePushCfgService.save(entity);
			}
			writeToPage("{\"success\":true}");
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeToPage("{\"success\":false}");
	}
	
	// 根据id删除
	public void delete() {
		try {
			String ids = ServletActionContext.getRequest().getParameter("ids");
			nativePushCfgService.deleteByIds(ids);
			writeToPage("{\"success\":true}");
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeToPage("{\"success\":false}");
	}
	
	// 根据部门名称查询推送的部门信息
	public void queryOrgByName() {
		String orgName = ServletActionContext.getRequest().getParameter("orgName");
		List<Map<String,String>> list = nativePushCfgService.queryOrgByName(orgName);
		writeToPage(list);
	}

	// setter
	public void setNativePushCfgService(INativePushCfgService nativePushCfgService) {
		this.nativePushCfgService = nativePushCfgService;
	}

	// setter
	public void setBirthdayPushInfoUrl(String birthdayPushInfoUrl) {
		this.birthdayPushInfoUrl = birthdayPushInfoUrl;
	}
	
}

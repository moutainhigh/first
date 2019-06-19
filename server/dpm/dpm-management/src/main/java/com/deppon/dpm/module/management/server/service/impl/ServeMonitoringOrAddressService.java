package com.deppon.dpm.module.management.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.dao.IServeMonitoringOrAddressDao;
import com.deppon.dpm.module.management.server.service.IServeMonitoringOrAddressService;
import com.deppon.dpm.module.management.shared.domain.ServeAddressBean;
import com.deppon.foss.framework.exception.BusinessException;
/**
 * 监控保存和地址查询
 * 
 * @author 274858
 * 
 */
public class ServeMonitoringOrAddressService implements
		IServeMonitoringOrAddressService {

	/**
	 * 日志
	 */
	Logger log = LoggerFactory.getLogger(ServeMonitoringOrAddressService.class);
	//serveMonitoringOrAddressDao 
	public IServeMonitoringOrAddressDao serveMonitoringOrAddressDao;
	//注入serveMonitoringOrAddressDao
	public void setServeMonitoringOrAddressDao(
			IServeMonitoringOrAddressDao serveMonitoringOrAddressDao) {
		this.serveMonitoringOrAddressDao = serveMonitoringOrAddressDao;
	}
	/*
	 * 地址查询 (non-Javadoc)
	 * 
	 * @see
	 * com.deppon.dpm.module.management.server.dao.IServeMonitoringOrAddressDao
	 * #queryAddressNationwide()
	 */
	@Override
	public String queryAddressNationwide() throws BusinessException {
	    String res = "{\"resultFlag\":false,\"failureReason\":\"查询列表失败\"}";
	    //地址查询得到list数据
		List<ServeAddressBean> addressList = serveMonitoringOrAddressDao.queryAddressNationwide();
		//解析省市
		List<ServeAddressBean> resList = parseAddressBean(addressList);
		res = "{\"infoList\":";
		//进行组装字符串
		res += JsonUtil.beanToJsonString(resList);
		res +="}";
		log.info("返回信息res="+res);
		
		//返回结果集
		return res;
	}

	/**
	 * 解析省市归类
	 * @param addressList
	 * @return
	 */
	private List<ServeAddressBean> parseAddressBean(
			List<ServeAddressBean> addressList) {
		//Map<String,List<ServeAddressBean>> cacheMap = new HashMap<String,List<ServeAddressBean>>();
		List<ServeAddressBean> resList = new ArrayList<ServeAddressBean>();
		//重组字符
		for(ServeAddressBean bean:addressList){
			String district = bean.getDegree();
			if(district != null && "DISTRICT_PROVINCE".equals(district)){
				//挑出省
				resList.add(bean);
			}
		}
		//for循环判断省市
		for(ServeAddressBean bean:addressList){
			String city = bean.getDegree();
			//挑出市
			if(city != null && "CITY".equals(city)){
				String parCode = bean.getParCode();
				int tab = -1;
				for(ServeAddressBean resBean:resList){
					//找出对应的省
					if(parCode !=null && parCode.equals(resBean.getCode())){
						//塞入省中的集合中
						List<ServeAddressBean> cityList = resBean.getBeanList();
						if(cityList != null && cityList.size()>0){
							cityList.add(bean);
						}else{
							List<ServeAddressBean> newList = new ArrayList<ServeAddressBean>();
							newList.add(bean);
							resBean.setBeanList(newList);
						}
						
						tab = 1;
						break;
					}
					
				}
				//没有找到对应的省,直接方法省的记录中
				if(tab == -1){
					resList.add(bean);
				}
				
			}
			
		}
		//返回结果集
		return resList;
	}
	

	/*
	 * 数据监控
	 * INSERT INTO
			COLLECT_COUNTINFO(USERID,START_TIME,END_TIME,TYPE)
		values(#{userId,jdbcType=VARCHAR},#{startTime,jdbcType=TIMESTAMP}
			,#{endTime,jdbcType=TIMESTAMP},#{type,jdbcType=INTEGER})
			(non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.service.IServeMonitoringOrAddressService#saveMonitoring(java.lang.String)
	 */
	@Override
	public String saveMonitoring(String str) throws BusinessException {
		String res = "{\"resultFlag\":false,\"failureReason\":\"监控点保存失败！\"}";
		JSONObject json = JSONObject.parseObject(str);
		log.info("页面传过来的参数为:" + json);
		//工号
		String userNo = json.getString("userNo") == null ? "":json.getString("userNo").trim();
		//监控点
		int type = json.getInteger("type") == null ? -1:json.getInteger("type");
		if("".equals(userNo) || type<0){
			return "{\"resultFlag\":false,\"failureReason\":\"传入的参数错误！\"}"; 
		}
		ServeAddressBean parBean = new ServeAddressBean();
		parBean.setUserNo(userNo);
		parBean.setType(type);
		int resNub = serveMonitoringOrAddressDao.saveMonitoring(parBean);
		if(resNub>0){
			res = "{\"resultFlag\":true,\"failureReason\":\"监控点保存成功！\"}";
		}
		return res;
	}

	/* 工程勘测小红点
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.service.IServeMonitoringOrAddressService#queryProcTask(java.lang.String)
	 */
	@Override
	public String queryProcTask(String str) throws BusinessException {
		String res = "{\"resultFlag\":false,\"failureReason\":\"对不起，您没有任务数量！\"}";
		JSONObject json = JSONObject.parseObject(str);
		log.info("页面传过来的参数为:" + json);
		//工号
		String userNo = json.getString("userNo") == null ? "":json.getString("userNo").trim();
		//判断非null
		if(userNo == null || "".equals(userNo.trim())){
			return "{\"resultFlag\":false,\"failureReason\":\"你传入的工号为空！\"}"; 
		}
		//插入数据
		int resTask = serveMonitoringOrAddressDao.queryProcTask(userNo);
		if(resTask>0){
			res = "{\"resultFlag\":true,\"failureReason\":"+resTask+"}";
		}
		//返回结果集
		return res;
	}

	/* 拼车小红点  
	 * 0==没有值，1==有值
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.service.IServeMonitoringOrAddressService#queryServeTask(java.lang.String)
	 */
	@Override
	public String queryServeTask(String userNo) throws BusinessException {
		String res = "{\"count\":0,\"errorCode\":0}";
		//JSONObject json = JSONObject.parseObject(str);
		//log.info("页面传过来的参数为:" + json);
		//工号
		//String userNo = json.getString("userNo") == null ? "":json.getString("userNo").trim();
		if(userNo == null || "".equals(userNo.trim())){
			return "{\"count\":0,\"errorCode\":1}"; 
		}
		//拼车小红点
		int resTask = serveMonitoringOrAddressDao.queryServeTask(userNo);
		//判断是否成功保存
		if(resTask>0){
			res = "{\"count\":1,\"errorCode\":0}";
			serveMonitoringOrAddressDao.updateServeTask(userNo);//失败还是不做处理吧		
		}
		//返回结果集
		return res;
	}
	
	
	
}

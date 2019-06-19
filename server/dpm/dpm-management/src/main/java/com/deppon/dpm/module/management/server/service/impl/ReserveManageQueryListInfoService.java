package com.deppon.dpm.module.management.server.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.dao.IReserveManageQueryListInfoDao;
import com.deppon.dpm.module.management.server.service.IReserveManageQueryListInfoService;
import com.deppon.dpm.module.management.shared.domain.ReserveAdminEntity;
import com.deppon.dpm.module.management.shared.domain.ReserveRecordEntity;
import com.deppon.foss.framework.exception.BusinessException;

/**
 * @author 274858
 *  羽毛球场空闲时间查询场地
	瑜伽室空闲时间查询场地
	管理员羽毛球场当天预订详细接口
	管理员瑜伽室当天预订详细接口

 */
public class ReserveManageQueryListInfoService implements
		IReserveManageQueryListInfoService {

	/**
	 * 日志
	 */
	Logger log = LoggerFactory.getLogger(ReserveManageQueryListInfoService.class);
	private IReserveManageQueryListInfoDao reserveManageQueryListInfoDao;
	
	
	public IReserveManageQueryListInfoDao getReserveManageQueryListInfoDao() {
		return reserveManageQueryListInfoDao;
	}

	public void setReserveManageQueryListInfoDao(
			IReserveManageQueryListInfoDao reserveManageQueryListInfoDao) {
		this.reserveManageQueryListInfoDao = reserveManageQueryListInfoDao;
	}

	/**
	 * <p>Description:查询羽毛球瑜伽室详细列表</p>
	 * 羽毛球场空闲时间查询场地
	        瑜伽室空闲时间查询场地
	 * @throws ParseException 
	 */
	@Override
	public String querySiteLeisureList(String str) throws ParseException{
		String res = "{\"resultFlag\":false,\"failureReason\":\"查询列表失败\"}";
		//时间格式校验标志
		boolean tabDate = false;
		//参数获取转变为实体类
		ReserveRecordEntity parBean = setParameter(str);
		ReserveRecordEntity parNewBean = new ReserveRecordEntity();
		try {
			//时间格式处理
			parNewBean = parseDate(parBean);
		} catch (BusinessException e) {
			tabDate = true;
			e.printStackTrace();
		}
		if(tabDate){
			return "{\"resultFlag\":false,\"failureReason\":\"传入的参数时间，格式异常！\"}";
		}
		/*
		 * log.info("roomCode"+roomCode);
			log.info("areaCode"+areaCode);
			log.info("siteMark:"+siteMark);
			
		
		 */
		int siteMark = parNewBean.getSiteMark();
        if(!(siteMark == 0 || siteMark == 1)){
        	return "{\"resultFlag\":false,\"failureReason\":\"传入的参数siteMark(预定类型)值不正确！您传入的值siteMark="+siteMark+"不正确\"}";
        }
		String areaCode = parNewBean.getAreaCode();
		if("".equals(areaCode)){
			return "{\"resultFlag\":false,\"failureReason\":\"传入的参数areaCode（楼层区域）为空！\"}";
		}
		String roomCode = parNewBean.getRoomCode();
		if("".equals(roomCode)){
			return "{\"resultFlag\":false,\"failureReason\":\"传入的参数roomCode（场地或房间号）为空！\"}";
		}
		
		List<ReserveRecordEntity> siteList = reserveManageQueryListInfoDao.querySiteLeisureList(parNewBean);
		
		//解析时间
		Collection<ReserveRecordEntity> newSiteList = parseDate(siteList);
		if(newSiteList == null || newSiteList.size()<=0){
			return "{\"resultFlag\":false,\"failureReason\":\"对不起，查询数据失败！\"}";
		}
		
		res = "{\"infoList\":";
		res += JsonUtil.beanToJsonString(newSiteList);
		res +="}";
		log.info("返回信息res="+res);
		return res;
	}
	
	/**
	 * 解析空闲时间
	 * @param siteList
	 * @return
	 */
	private Collection<ReserveRecordEntity>parseDate(
			List<ReserveRecordEntity> siteList) {
		//List<ReserveRecordEntity> newSiteList = new ArrayList<ReserveRecordEntity>();
		Map<String,ReserveRecordEntity> mapTab = new HashMap<String,ReserveRecordEntity>(); 
		for(ReserveRecordEntity siteBean:siteList){
			//获取房间code
			String roomCode = siteBean.getRoomCode();
			//获取开始时间
			String startTimeStr = siteBean.getStartTimeStr();
			//是否存在该门店
			if(mapTab.containsKey(roomCode)){
				//先取出map数据
				ReserveRecordEntity oldBean = mapTab.get(roomCode);
				
				//检查是否存在空闲时间
				if(startTimeStr != null && !"".equals(startTimeStr)){
					//获取时间段list
					List<ReserveRecordEntity> dateList = oldBean.getDateList();
					ReserveRecordEntity dateBean = new ReserveRecordEntity();
					dateBean.setStartTimeStr(siteBean.getStartTimeStr());
					dateBean.setEndTimeStr(siteBean.getEndTimeStr());
					dateList.add(dateBean);
					
				}
				
			}else{
				//不包含
				//检查是否存在空闲时间
				if(startTimeStr != null && !"".equals(startTimeStr)){
					//获取时间段list
					List<ReserveRecordEntity> newList = new ArrayList<ReserveRecordEntity>();
					ReserveRecordEntity dateBean = new ReserveRecordEntity();
					dateBean.setStartTimeStr(siteBean.getStartTimeStr());
					dateBean.setEndTimeStr(siteBean.getEndTimeStr());
					newList.add(dateBean);
					siteBean.setDateList(newList);
				}
				siteBean.setStartTimeStr(null);//序列化时去脏数据
				siteBean.setEndTimeStr(null);//序列化时去脏数据
				mapTab.put(roomCode,siteBean);
			}
			
		}
		
		//取出map
		List<ReserveRecordEntity> newSiteCllo = new ArrayList<ReserveRecordEntity>(mapTab.values());
		
		
		try{
			Collections.sort(newSiteCllo);
		}catch(BusinessException e){
			log.info("newSiteCllo排序异常");
			e.printStackTrace();
		}
		
		
		return newSiteCllo; 
	}

	/**
	 * 时间格式处理
	 * @param parBean
	 * @return
	 * @throws ParseException 
	 */
	private ReserveRecordEntity parseDate(ReserveRecordEntity parBean) throws BusinessException, ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		/*String startTimeStr = parBean.getStartTimeStr().trim();//HH:mm
		String endTimeStr = parBean.getEndTimeStr().trim();//HH:mm
*/		String dateStr = parBean.getDateStr();//yyyy-MM-dd
        //简单时间格式校验
        String regex = "20\\d{2}-((0[1-9])|(1[0-2]))-((0[1-9])|(1[0-9])|(2[0-9])|(3[0-1]))"; 		
        if(!dateStr.matches(regex)){
        	log.info("传入的参数时间格式异常！");
        	throw new BusinessException();
        }
		Date startTime = format.parse(dateStr);
        parBean.setStartTime(startTime);
		return parBean;
	}
	/*
	 * 参数获取转变为实体类
	 */
	private ReserveRecordEntity setParameter(String str) {
		JSONObject json = JSONObject.parseObject(str);
		log.info("页面传过来的参数为:" + json);
		
		// 楼层区域code
		String areaCode = json.getString("areaCode") == null ? "":json.getString("areaCode").trim();
		// 预定类型标志
		int siteMark = json.getInteger("siteMark") == null ? -1:json.getIntValue("siteMark");
		//年月日
		String dateStr = json.getString("dateStr") == null ? "":json.getString("dateStr").trim();
		log.info("areaCode"+areaCode);
		log.info("siteMark:"+siteMark);
		log.info("dateStr:"+dateStr);
		ReserveRecordEntity parBean = new ReserveRecordEntity();
		parBean.setAreaCode(areaCode);
		parBean.setSiteMark(siteMark);
		parBean.setDateStr(dateStr);
		
		return parBean;
	}

	/* (non-Javadoc)
	 * 查询场地信息
	 * @see com.deppon.dpm.module.management.server.service.IReserveManageQueryListInfoService#querySiteInfo()
	 */
	@Override
	public String querySiteInfo(String str) throws BusinessException {
		String res = "{\"resultFlag\":false,\"failureReason\":\"查询列表失败\"}";
		JSONObject json = JSONObject.parseObject(str);
		log.info("页面传过来的参数为:" + json);
		// 预定类型标志
		int siteMark = json.getInteger("siteMark") == null ? -1:json.getIntValue("siteMark");
		if(!(siteMark == 0 || siteMark == 1)){
			log.info("{\"resultFlag\":false,\"failureReason\":\"传入的参数siteMark(预定类型)值不正确！您传入的值siteMark="+siteMark+"不正确\"}");
        	return "{\"resultFlag\":false,\"failureReason\":\"传入的参数siteMark(预定类型)值不正确！您传入的值siteMark="+siteMark+"不正确\"}";
		}	
		List<ReserveRecordEntity> siteInfo = reserveManageQueryListInfoDao.querySiteInfo(siteMark);
		res = "{\"infoList\":";
		res += JsonUtil.beanToJsonString(siteInfo);
		res +="}";
		log.info("返回信息res="+res);
		return res;
	}

	/* 查询某个场地的详细预定信息
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.service.IReserveManageQueryListInfoService#querySiteDateList(java.lang.String)
	 */
	@Override
	public String querySiteDateList(String str) throws ParseException {
		String res = "{\"resultFlag\":false,\"failureReason\":\"查询列表失败\"}";
		JSONObject json = JSONObject.parseObject(str);
		log.info("页面传过来的参数为:" + json);
		int id = json.getInteger("id") == null ? -1:json.getIntValue("id");
		String dateStr = json.getString("dateStr") == null ? "":json.getString("dateStr").trim();
		//简单时间格式校验
        String regex = "20\\d{2}-((0[1-9])|(1[0-2]))-((0[1-9])|(1[0-9])|(2[0-9])|(3[0-1]))"; 		
        if(!dateStr.matches(regex)){
        	return "{\"resultFlag\":false,\"failureReason\":\"传入的参数dateStr(时间)格式不正确！您传入的值dateStr="+dateStr+"不正确\"}";
        }
		if(id < 0){
			log.info("{'resultFlag':false,'failureReason':'传入的参数id(房间记录主键)值不正确！您传入的值id="+id+"不正确'}");
        	return "{\"resultFlag\":false,\"failureReason\":\"传入的参数id(房间记录主键)值不正确！您传入的值id="+id+"不正确\"}";
		}
		 ReserveRecordEntity parBean = setParBeanSiteDate(id,dateStr);
		
		List<ReserveRecordEntity> siteInfo = reserveManageQueryListInfoDao.querySiteDateList(parBean);
		//提前结束预定
		for(ReserveRecordEntity bean:siteInfo){
			int status = bean.getStatus();
			if(status == 2){
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
				bean.setEndTimeStr(format.format(bean.getUpdateTime()));
			}
		}
		
		
		res = "{\"infoList\":";
		res += JsonUtil.beanToJsonString(siteInfo);
		res +="}";
		log.info("返回信息res="+res);
		return res;
	}

	/**
	 * 设置dao参数
	 * @param id
	 * @param dateStr
	 * @return
	 * @throws BusinessException
	 * @throws ParseException 
	 */
	private ReserveRecordEntity setParBeanSiteDate(int id, String dateStr) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		ReserveRecordEntity parBean = new ReserveRecordEntity();
		parBean.setId(id);
		parBean.setStartTime(format.parse(dateStr));
		
		return parBean;
	}

	/* 查询管理员
	 * @see com.deppon.dpm.module.management.server.service.IReserveManageQueryListInfoService#queryAdmin()
	 */
	@Override
	public String queryAdmin() throws BusinessException {
		String res = "{\"resultFlag\":false,\"failureReason\":\"查询列表失败\"}";
		List<ReserveAdminEntity> resultList = reserveManageQueryListInfoDao.queryAdmin();
		res = "{\"infoList\":";
		res += JsonUtil.beanToJsonString(resultList);
		res +="}";
		log.info("返回信息res="+res);
		return res;
	}

	/* 保存管理员信息
	 * @see com.deppon.dpm.module.management.server.service.IReserveManageQueryListInfoService#saveAdminInfo(java.lang.String)
	 */
	@Override
	public String saveAdminInfo(String str) throws BusinessException {
		String res = "{\"resultFlag\":false,\"failureReason\":\"查询列表失败\",\"resTab\":0}";
		
		ReserveAdminEntity parBean = parseParameter(str);
		//参数检验
		if(checkParameter(parBean)){
			return "{\"resultFlag\":false,\"failureReason\":\"传入的参数为空\",\"resTab\":1}";
		}
		//超级管理员判断
		if(!checkSuperAdmin(parBean.getCreateUserNo())){
			return "{\"resultFlag\":false,\"failureReason\":\"您没有保存管理员的权限!\",\"resTab\":2}";
		}
		//去重复
		int repeatTab = reserveManageQueryListInfoDao.queryAdminInfo(parBean.getUserNo());
		if(repeatTab > 0){
			return "{\"resultFlag\":false,\"failureReason\":\"该管理员已经存在!\",\"resTab\":3}";
		}
		
		int resTab = reserveManageQueryListInfoDao.saveAdminInfo(parBean);
		
		if(resTab > 0){
			res = "{\"resultFlag\":true,\"failureReason\":\"恭喜您，保存数据成功\",\"id\":\""+parBean.getId()+"\"}";
		}
		return res;
	}

	/**
	 * 检验参数
	 * @param parBean
	 * @return
	 */
	private boolean checkParameter(ReserveAdminEntity parBean) {
		String userNo = parBean.getUserNo();
		String userName = parBean.getUserName();
		String createUserNo = parBean.getCreateUserNo();
		if("".equals(userNo) || "".equals(userName) || "".equals(createUserNo)){
			return true;
		}
		return false;
	}

	/**
	 * 解析传过来的参数
	 * @param str
	 * @return
	 */
	private ReserveAdminEntity parseParameter(String str) {

		JSONObject json = JSONObject.parseObject(str);
		log.info("页面传过来的参数为:" + json);
		
		String userNo = json.getString("userNo") == null ? "":json.getString("userNo").trim();
		String userName = json.getString("userName") == null ? "":json.getString("userName").trim();
		String depName = json.getString("depName") == null ? "":json.getString("depName").trim();
		String phone = json.getString("phone") == null ? "":json.getString("phone").trim();
		String createUserNo = json.getString("createUserNo") == null ? "":json.getString("createUserNo").trim();	
		
		ReserveAdminEntity parBean = new ReserveAdminEntity();
		parBean.setId(getUUID());
		parBean.setUserNo(userNo);
		parBean.setUserName(userName);
		parBean.setDepName(depName);
		parBean.setPhone(phone);
		parBean.setCreateUserNo(createUserNo);
		return parBean;
	}
	/**
	 * 生成UUID
	 * @param ProcCheckScoreEntity
	 */
	private String getUUID(){
		String id= UUID.randomUUID().toString();
		return id;
	}
	/* 
	 * 删除管理员信息
	 * @see com.deppon.dpm.module.management.server.service.IReserveManageQueryListInfoService#deleteAdminInfo(java.lang.String)
	 */
	@Override
	public String deleteAdminInfo(String str) throws BusinessException {
		String res = "{\"resultFlag\":false,\"failureReason\":\"对不起，数据操作失败\"}";
		JSONObject json = JSONObject.parseObject(str);
		log.info("页面传过来的参数为:" + json);
		String id = json.getString("id") == null ? "":json.getString("id").trim();	
		String createUserNo = json.getString("createUserNo") == null ? "":json.getString("createUserNo").trim();	
		if("".equals(id) || "".equals(createUserNo)){
			return "{\"resultFlag\":false,\"failureReason\":\"传入的参数为空\"}";
		}
		if(!checkSuperAdmin(createUserNo)){
			return "{\"resultFlag\":false,\"failureReason\":\"您没有删除管理员的权限!\"}";
		}
		int resTab = reserveManageQueryListInfoDao.deleteAdminInfo(id);
		if(resTab > 0){
			res = "{\"resultFlag\":true,\"failureReason\":\"恭喜您，您的数据操作成功\"}";
		}
		return res;
	}

	
	/**
	 * 校验超级管理员
	 * @param userNo
	 * @return
	 */
	public boolean checkSuperAdmin(String userNo) throws BusinessException{
		
		int res = reserveManageQueryListInfoDao.checkSuperAdmin(userNo);
		log.info("超级管理员："+res);
		return res>0 ? true:false;
	}
}

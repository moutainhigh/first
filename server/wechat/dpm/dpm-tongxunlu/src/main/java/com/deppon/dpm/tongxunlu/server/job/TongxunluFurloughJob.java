package com.deppon.dpm.tongxunlu.server.job;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.service.impl.RedisService;
import com.deppon.dpm.module.common.server.util.CommonConstant;
import com.deppon.dpm.module.common.server.util.HttpUtil;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.shared.domain.EmpFurloughInfoEntity;
import com.deppon.dpm.tongxunlu.server.service.ITongxunLuService;

public class TongxunluFurloughJob {
	
	private static final Logger LOG = LoggerFactory.getLogger(TongxunluFurloughJob.class);
	
	private RedisService redisService;
	
	private String tongxunluFurloughInfoUrl;
	
	// tongxunLuService
	private ITongxunLuService tongxunLuService;
	
	private static final DateFormat DAY_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	private static final DateFormat TIME_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private static final String TONGXUNLU_FURLOUGH_SETUP_TIME_KEY = "DPM_TONGXUNLU_FURLOUGH_SETUP_TIME";
	
	/**
	 * 从NHR获取通讯录休假信息的任务（每小时一次）
	 */
	public void execute() {
		LOG.info("TongxunluFurloughJob.execute执行了......" + TIME_DATE_FORMAT.format(new Date()));
		String result = null;
		try {
			// 先从redis获取上一次存入redis的时间，如果距离当前时间超过1小时就从nhr拉取数据
			String setupTimeStr = redisService.get(TONGXUNLU_FURLOUGH_SETUP_TIME_KEY);
			if(!this.isCanExecute(setupTimeStr)) {
				return;
			}
			// 从NHR拉休假信息
			long startTime = System.currentTimeMillis();
			result = HttpUtil.doPostJson(tongxunluFurloughInfoUrl, "{}");
			long endTime = System.currentTimeMillis();
			LOG.info("从NHR获取所有休假信息用时：" + (endTime - startTime));
			LOG.info("从NHR获取所有休假信息结果为：" + result);
			// 解析result，封装对象
			// "{\"flag\":1,\"data\":\"000001|3|123234,116250|1|061825\"}"
			JSONObject jsonObject = JSON.parseObject(result);
			if(jsonObject.getBooleanValue("flag")) {
				// 休假信息的格式：工号|假期类型,工号|假期类型   例如：000001|2,000002|3
				/*List<String> list = JSON.parseArray(jsonObject.getString("data"),String.class);
				for (String str : list) {
					String[] furloughInfo = str.split("\\|");
					cacheData.put(furloughInfo[0], furloughInfo[1]);
				}*/
				// 获取休假信息
				String[] strs = jsonObject.getString("data").split(",");
				// 缓存数据集合
				Map<String,EmpFurloughInfoEntity> cacheData = new HashMap<String,EmpFurloughInfoEntity>();
				// 工号/姓名map
				//Map<String,String> usersMap = getUsersMap();
				// 休假信息对象
				for (String str : strs) {
					EmpFurloughInfoEntity empFurInfo = new EmpFurloughInfoEntity();
					String[] furloughInfo = str.split("\\|");
					if(furloughInfo.length == 3 && StringUtils.isNotEmpty(furloughInfo[2])){
						// 休假类型
						empFurInfo.setFurloughType(Integer.valueOf(StringUtils.isEmpty(furloughInfo[1])?"0":furloughInfo[1]));
						// 交接人工号
						empFurInfo.setHandoverEmpCode(furloughInfo[2]);
						// 获取根据工号获取缓存中的用户名称 不需要名字
						//empFurInfo.setHandoverEmpName(getUserNameByCode(furloughInfo[2], usersMap));
						// 数据入集合
						cacheData.put(furloughInfo[0], empFurInfo);
					}
				}
				// 存入休假数据
				redisService.batchSet(cacheData, this.getExpire());
				
				// 设置时间标记
				redisService.set(TONGXUNLU_FURLOUGH_SETUP_TIME_KEY, System.currentTimeMillis() + "");
			}
		} catch (Exception e) {
			LOG.error("定时获取所有休假信息出错!!!  result：" + result, e); 
		}
	}
	
	/**
	 * 根据工号从缓存中获取姓名
	 * 
	 * @param userCode
	 * @param usersMap
	 * @return
	 */
	private String getUserNameByCode(String userCode,Map<String,String> usersMap){
		String userName = usersMap.get(userCode);
		if(StringUtils.isEmpty(userName)&&StringUtils.isEmpty(userCode)){
			tongxunLuService.queryUserMap(userCode, usersMap);
			// 将工号姓名map放入缓存中
			redisService.set(CommonConstant.REDIS_KEY_EMPCODEANDEMPNAME_MAP, JSON.toJSONString(usersMap), MagicNumber.NUM15000);
		}
		// 返回
		return StringUtils.isNotEmpty(usersMap.get(userCode)) ? usersMap.get(userCode) : "";
	}
	
	/**
	 * 获取缓存中的所有工号姓名Map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Map<String,String> getUsersMap(){
		// 工号/姓名map
		Map<String,String> usersMap = new HashMap<String,String>();
		try {
			// 缓存数据集合
			String users = redisService.get(CommonConstant.REDIS_KEY_EMPCODEANDEMPNAME_MAP);
			// 缓存中无数据重新获取
			if(StringUtils.isEmpty(users)){
				tongxunLuService.queryUserMap(null, usersMap);
				// 将工号姓名map放入缓存中
				redisService.set(CommonConstant.REDIS_KEY_EMPCODEANDEMPNAME_MAP, JSON.toJSONString(usersMap), MagicNumber.NUM15000);
			} else{
				// 类型转换
				usersMap = JSON.parseObject(users, new HashMap<String,String>().getClass());
			}
		} catch(Exception e){
			LOG.error("获取工号姓名map出错!!! ",e); 
		}
		// 返回
		return usersMap;
	}
	
	// 判断是否可以执行
	private boolean isCanExecute(String setupTimeStr) {
		if(StringUtils.isEmpty(setupTimeStr)) {
			return true;
		}
		long setupTime = Long.parseLong(setupTimeStr);
		long currentTime = System.currentTimeMillis();
		if((currentTime - setupTime) / 1000 >= MagicNumber.NUM3600) {
			return true;
		}
		return false;
	}
	
	private int getExpire() throws ParseException {
		String dayTimeStr = DAY_DATE_FORMAT.format(new Date());
		String destroyTimeStr = dayTimeStr + " 23:59:00";
		long currentTime = System.currentTimeMillis();
		Calendar calendar = Calendar.getInstance();  
		calendar.setTime(TIME_DATE_FORMAT.parse(destroyTimeStr));
		long destroyTime = calendar.getTimeInMillis();
		return (int) ((destroyTime - currentTime) / MagicNumber.NUM1000);
	}

	public void setRedisService(RedisService redisService) {
		this.redisService = redisService;
	}

	public void setTongxunluFurloughInfoUrl(String tongxunluFurloughInfoUrl) {
		this.tongxunluFurloughInfoUrl = tongxunluFurloughInfoUrl;
	}

	/**
	 * set
	 */
	public void setTongxunLuService(ITongxunLuService tongxunLuService) {
		this.tongxunLuService = tongxunLuService;
	}
	
}

package com.deppon.montal.util.redis.service.impl;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;

import com.deppon.montal.conf.F_Constants;
import com.deppon.montal.util.IHttpClient;
import com.deppon.montal.util.InitDataServlet;
import com.deppon.montal.util.NetUtil;
import com.deppon.montal.util.redis.service.IRoleJobnameRedis;
import com.deppon.montal.util.redis.util.JedisUtil;

public class RoleJobnameService implements IRoleJobnameRedis {

	private static Logger logger = null;
	private static String UUurl = null;
	static {
		logger = Logger.getLogger(RoleJobnameService.class);
		UUurl = InitDataServlet.getValue("UU_VeriPerm_URL");
	}
	/**
	 * //验证权限
	 */
	@Override
	public boolean validateLoginRole(String userId, String jobName) {
		logger.info("----->开始进行权限验证...");
		Jedis jedis = JedisUtil.createJedis();
		boolean b = false;
		try{
//			String allName = jedis.hget(JedisConstant.DPMONTAL_DPMON_ROLE_JOBNAME + "ALL","jobName");
//			logger.info("【RoleJobnameService---->validateLoginRole--->权限验证--->从缓存中获取职位名称】 allName = " + allName);
//			String jName = jedis.hget(JedisConstant.DPMONTAL_DPMON_ROLE_JOBNAME + jobName, "jobName");
//			logger.info("【RoleJobnameService---->validateLoginRole--->权限验证--->从缓存中获取职位名称】 jobName = " + jName);
//			Map<String,String> userMap = jedis.hgetAll(JedisConstant.DPMONTAL_DPMON_EMPLOYEE + userId);
//			
//			logger.info("【RoleJobnameService---->validateLoginRole--->根据职位获取用户信息】:" + userMap);
//			
//			if(userMap != null && userMap.size() > 0){
//				b = true;
//			}else if(allName != null || jName !=null){
//				b = true;
//			}else{
//				b = false;
//			}
//			userId = "T83936";
			IHttpClient httpClient = NetUtil.fetchHttpClient();
			httpClient.setRequestURL(UUurl+"&userCode="+ userId);
			httpClient.send(null);
			ByteArrayOutputStream out = httpClient.getOutputStream();
			
			String result = out.toString();
			if("{}".equals(result) || result == null)
				return false;
			Map<String, Object> map = parseJsonToMap(result);
			//登录权限列表
			List<String> roleList = (List) map.get("roleCodes");
			for(String role:roleList){
				//工作流模块权限
				if(F_Constants.COMPETENCE_CODE.equals(role)){
					b = true;
					break;
				}
			}
			//拥有Web工作流权限
//			result = result.substring(result.indexOf("DPM001"), result.indexOf("DPM001")+6);
//			if("DPM001" .equals(result));
//			b = true;
			logger.info("权限验证的结果：b = " + b);
			
		}catch(Exception ex){
			JedisUtil.returnBrokenResource(jedis);
			logger.info("[RoleJobnameService validateLoginRole]" + ex.getMessage());
			ex.printStackTrace();
		}finally{
			JedisUtil.releaseJedis(jedis);
		}
	
		return b;
	}
	
	public static Map<String, Object> parseJsonToMap(String json){
		    JSONObject jsonObj = JSONObject.fromObject(json);
		    Map<String, Object> map = new HashMap<String, Object>();
		    for(Object k : jsonObj.keySet()){
		        Object v = jsonObj.get(k);
		        //如果内层还是数组的话，继续解析
//		        if(v instanceof JSONArray){
//		            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//		            Iterator<JSONObject> it = ((JSONArray)v).iterator();
//		            while(it.hasNext()){
//		                JSONObject json2 = it.next();
//		                list.add(parseJsonToMap(json2.toString())); 
//		            }
//		            map.put(k.toString(), list);
//		        } else {
		            map.put(k.toString(), v);
//		        }
		    }
		    return map;
		}

}
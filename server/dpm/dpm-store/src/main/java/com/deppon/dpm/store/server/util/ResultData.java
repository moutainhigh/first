package com.deppon.dpm.store.server.util;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author RY
 *
 */
public class ResultData {
		private static String success="成功";//success
		private static String error="失败";//error 
		/**
		 * 
		 * @param object
		 * @return
		 */
		public static JSONObject success(Object object){
			JSONObject json = new JSONObject();//json
				json.put("data", object);//data
				json.put("msg", success);//msg
				json.put("code", 200);//code
				//返回
			return json;
		}
		/**
		 * 
		 * @param object
		 * @return
		 */
		public static JSONObject error(Object object){
			JSONObject json = new JSONObject();//json
			json.put("data", object);//date
			json.put("msg", error);//msg
			json.put("code", 500);//code
			//返回
			return json;
		}
}

package com.deppon.dpm.sendMsg.TaskService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import com.deppon.dpm.sendMsg.listener.JpushTaskListenner;
import com.deppon.montal.util.FormatUtil;
import com.deppon.montal.util.InitDataServlet;

public class SendMsgTaskUtil {

	private static Logger logger = Logger.getLogger(SendMsgTaskUtil.class);
		//	public static ServerResult getOrgByChildern(int root,String loginUser,String tk) throws Exception { 
		//		return request(Constant.DPM_HOST
		//				+ "/dpm/tongxunlu_getChildByOrg.action?id=" + root
		//				+ "&userId="+loginUser+"&token="+tk, null);
		//	}

	public static String getBase64(String val) throws NoSuchAlgorithmException {
		if (val == null)
			return null;
		byte[] result = Base64.encodeBase64(val.getBytes());
		return new String(result);
	}

	/**
	 * 按条件搜索.
	 * 
	 * @param isEmp
	 * @param content
	 * @param start
	 * @return
	 * @throws Exception
	 */
//	public static ServerResults search(boolean isEmp, String content, int start,String loginUser,String tk)
//			throws Exception { 
//		return requestArr(
//				Constant.DPM_HOST
//						+ "/dpm/tongxunlu_search.action?searchName="
//						+ content
//						+ "&userId="+loginUser+"&token="+tk+"&searchType="
//						+ (isEmp ? "1" : "2") + "&start=" + start
//						+ "&pageSize=50", null);
//	}

	/**
	 * 将手机注册到jpush服务器.
	 * 
	 * @param businoId
	 *            业务号
	 * @return
	 * @throws Exception
	 */
//	public static String regiestJpush(String businoId,String loginUser,String tk) throws Exception { 
//		JpushTokenResult result = requestToken(
//				Constant.DPM_HOST
//						+ "/dpm/jpush_setTagAndAlias.action?userId="+loginUser+"&token="+tk
//						+ "&SysCode=dpm&deviceType=android&businoId="
//						+ businoId, null);
//		if (result.getErrorCode() >= 0) {
//			return result.getData();
//		} else
//			return "-1";
//	}

	/**
	 * 查询人员详情
	 * 
	 * @param empID
	 * @return
	 * @throws Exception
	 */
//	public static ServerResult getEmpDetail(String empID,String loginUser,String tk) throws Exception { 
//		return request(Constant.DPM_HOST + "/dpm/tongxunlu_getEmpDetail.action?id="
//				+ empID
//				+ "&userId="+loginUser+"&token="+tk, null);
//	}

//	private static JpushTokenResult requestToken(String url, String auth)
//			throws Exception {
//		// 得到url请求.
//		System.out.println("请求的url" + url);
//
//		DefaultHttpClient httpclient = new DefaultHttpClient();
//		try {
//			HttpPost httpost = new HttpPost(url);
//			if (auth != null)
//				httpost.addHeader("auth", auth);
//			HttpResponse response = httpclient.execute(httpost);
//			HttpEntity entity = response.getEntity();
//			BufferedReader br = new BufferedReader(new InputStreamReader(
//					entity.getContent(), "GBK"));
//			String str = br.readLine();
//			// 如果没有登录成功，就弹出提示信息.
//			JpushTokenResult result = (JpushTokenResult) JSON.parseObject(str,
//					JpushTokenResult.class);
//			return result;
//		} catch (Exception e) {
//			throw e;
//		} finally {
//			// 关闭连接.
//			httpclient.getConnectionManager().shutdown();
//		}
//	}
//	private static ServerResults requestArr(String url, String auth)
//			throws Exception {
//		System.out.println("请求的url" + url);
//		// 得到url请求.
//		DefaultHttpClient httpclient = new DefaultHttpClient();
//		try {
//			HttpPost httpost = new HttpPost(url);
//			if (auth != null)
//				httpost.addHeader("auth", auth);
//			HttpResponse response = httpclient.execute(httpost);
//			HttpEntity entity = response.getEntity();
//			BufferedReader br = new BufferedReader(new InputStreamReader(
//					entity.getContent(), "GBK"));
//			// 如果没有登录成功，就弹出提示信息.
//			ServerResults result = (ServerResults) JSON.parseObject(
//					br.readLine(), ServerResults.class);
//			return result;
//		} catch (Exception e) {
//			throw e;
//		} finally {
//			// 关闭连接.
//			httpclient.getConnectionManager().shutdown();
//		}
//	}

//	private static ServerResult request(String url, String auth)
//			throws Exception {
//		// 得到url请求.
//		System.out.println("请求的url" + url);
//
//		DefaultHttpClient httpclient = new DefaultHttpClient();
//		try {
//			HttpPost httpost = new HttpPost(url);
//			if (auth != null)
//				httpost.addHeader("auth", auth);
//			HttpResponse response = httpclient.execute(httpost);
//			HttpEntity entity = response.getEntity();
//			BufferedReader br = new BufferedReader(new InputStreamReader(
//					entity.getContent(), "GBK"));
//			String str = br.readLine();
//			// 如果没有登录成功，就弹出提示信息.
//			ServerResult result = (ServerResult) JSON.parseObject(str,
//					ServerResult.class);
//			return result;
//		} catch (Exception e) {
//			throw e;
//		} finally {
//			// 关闭连接.
//			httpclient.getConnectionManager().shutdown();
//		}
//	}
  

	public static String encryptBASE64(String key) throws Exception {
		// String base64String = "whuang123";
		byte[] result = Base64.encodeBase64(key.getBytes());
		return new String(result);
	}

	private static final char HEX_DIGITS[] = { '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	public static String toHexString(byte[] b) { // String to byte
		StringBuilder sb = new StringBuilder(b.length * 2);
		for (int i = 0; i < b.length; i++) {
			sb.append(HEX_DIGITS[(b[i] & 0xf0) >>> 4]);
			sb.append(HEX_DIGITS[b[i] & 0x0f]);
		}
		return sb.toString();
	}

	public static String getMD5(String s) throws NoSuchAlgorithmException {
			// Create MD5 Hash
			MessageDigest digest = java.security.MessageDigest
					.getInstance("MD5");
			digest.update(s.getBytes());
			byte messageDigest[] = digest.digest();

			return toHexString(messageDigest);
	}
	/**
	 * 
	* @MethodName: parseUsersJson 
	* @description : 消息推送结果集json解析
	* @author：caibingbing 
	* @date： 2014-6-24 上午8:38:40
	* @param json
	* @return List
	 */
	@SuppressWarnings({ "deprecation", "unused", "unchecked", "rawtypes" })
	public static List parseUsersJson(String json){
//		json = "{\"count\":0,\"data\":[\"130126\",\"028194\",\"010076\",\"143091\",\"070818\",\"070818\",\"130123\",\"143091\"],\"errorCode\":0}";
		List users = null;
		JSONObject jsonObject = JSONObject.fromObject(json);  
        Map<String, Object> mapJson = JSONObject.fromObject(jsonObject);  
        JSONArray str = (JSONArray) mapJson.get("data");
        Integer count = (Integer) mapJson.get("count");
        Integer errorCode = (Integer) mapJson.get("errorCode");
        if(str != null){
        	users = JSONArray.toList(str);
        }
        return users;
	}
	public static void main(String[] args) throws ParseException {
//		parseUsersJson("{}");
//		validTimeTask();
	}
	/**
	 * 
	* @MethodName: validTimeTask 
	* @description : 校验是否执行定时任务,并计算上次推送时间
	* @author：caibingbing 
	* @date： 2014-6-26 上午10:09:31
	* @return boolean
	 * @throws ParseException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map validTimeTask() throws ParseException {
		Map map = new HashMap();
		//查询新增工作流的开始 结束时间
		Date fromDate = null;
		Date endTime = null;
		//设置是否为当前时间点，判断是否可以推送消息
		boolean isTime = false;
		
		//当前小时
		Calendar c = Calendar.getInstance();
		int currentHour = c.get(Calendar.HOUR_OF_DAY);
		int currentMinute = c.get(Calendar.MINUTE);
		/**
		 * sendMsg.Time.type = hour:1
		 * ##########消息推送时间 	 allDay&&      timePoint&&9:14:16
			sendMsgTime=allDay&&0:1:2:3:4:5:6:7:8:9:10:11:12:13:14:15:16:17:18:19:20:21:22:23
			##########消息推送定时任务时间 1小时  60*60*1000
			sendMsg.Time.space = 3600000
			##########消息推送开始时间  小时: 1h   minute:5  分钟:5分钟
			sendMsg.Time.type = hour:1
		 * */
		String timeType = InitDataServlet.getValue("sendMsg.Time.type");
		if(timeType==null||"".equals(timeType)){
			timeType = "minute:"+JpushTaskListenner.INTERVAL;
			logger.warn("未取到sendMsg.Time.type 默认为minute:"+JpushTaskListenner.INTERVAL);
		}
		String[] timeTypes = timeType.split(":");
		//按小时推送
		
		if("hour".equals(timeTypes[0])){
			/**查询新增待办结束时间*/
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			endTime = calendar.getTime();
			map.put("endTime", FormatUtil.formatDate(endTime, "yyyy-MM-dd HH:mm:ss"));
			
			//查询property文件配置的定时  并切割
			String taskTime = InitDataServlet.getValue("sendMsgTime");
			String[] taskTimes = taskTime.split("&&");
			String taskTimeType = taskTimes[0];
			if("allDay".equals(taskTimeType)){
				//整点定时全天推送 
				//定时推送 间隔小时数
				int hourSplit = Integer.parseInt(timeTypes[1]);
				c.set(Calendar.HOUR_OF_DAY, currentHour - hourSplit);
				c.set(Calendar.MINUTE, 0);
				c.set(Calendar.SECOND, 0);
				//起始时间
				map.put("fromDate", FormatUtil.formatDate(c.getTime(), "yyyy-MM-dd HH:mm:ss"));
				map.put("isTime", true);
			}else if("timePoint".equals(taskTimeType)){
				//整点定时  定点推送
				String[] times = taskTimes[1].split(":");
				//对设置的定点小时 排序
				times = sortArray(times);
				
				//遍历检验当前时间是否是配置的时间节点
				String hour = Integer.toString(currentHour);
				for(int i = 0;i<times.length;i++){
					if(hour.equals(times[i])){
						int diverTime = 0;
						isTime = true;
						//
						if(i == 0){
							//第一个参数
							//时间间隔 当前时间--- 昨天  最后一个时间点
							diverTime = (Integer.parseInt(times[times.length-1])-Integer.parseInt(times[i]))-24;
						}else{
							diverTime = Integer.parseInt(times[i-1])-Integer.parseInt(times[i]);
						}
						c.add(Calendar.HOUR,diverTime);
						c.set(Calendar.MINUTE, 0);
						c.set(Calendar.SECOND, 0);
						fromDate=c.getTime();
						map.put("fromDate", FormatUtil.formatDate(fromDate, "yyyy-MM-dd HH:mm:ss"));
					}
				}
				map.put("isTime", isTime);
			}
		}else if("minute".equals(timeTypes[0])){
			/**查询新增待办结束时间*/
			Calendar calendar = Calendar.getInstance();
//			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			endTime = calendar.getTime();
			map.put("endTime", FormatUtil.formatDate(endTime, "yyyy-MM-dd HH:mm:ss"));
			
			//按分钟推送
			int mintueSplit = Integer.parseInt(timeTypes[1]);
			c.set(Calendar.MINUTE, currentMinute-mintueSplit);
			c.set(Calendar.SECOND, 0);
			//起始时间
			map.put("fromDate", FormatUtil.formatDate(c.getTime(), "yyyy-MM-dd HH:mm:ss"));
			map.put("isTime", true);
		}
		
		return map;
	}
	/**
	 * 
	* @MethodName: sortArray 
	* @description : 从小到大  数组排序 
	* @author：caibingbing 
	* @date： 2014-6-26 下午2:47:30
	* @param strs
	* @return String[]
	 */
	public static String[] sortArray(String[] strs){
		if(strs == null || strs.length <= 1){
			return strs;
		}
		for(int i=0;i<strs.length;i++){
			int si = Integer.parseInt(strs[i]);
			for(int k = i+1;k<strs.length;k++){
				int sk = Integer.parseInt(strs[k]);
				if(si > sk){
					//排序交换
					int temp = si;
					si = sk;
					sk = temp;
					strs[i] = si + "";
					strs[k] = sk + "";
				}
			}
		}
		return strs;
	}
}

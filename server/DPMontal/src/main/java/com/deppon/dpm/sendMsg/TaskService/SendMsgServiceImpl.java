package com.deppon.dpm.sendMsg.TaskService;

import java.io.ByteArrayOutputStream;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.deppon.montal.login.service.SQLManager;
import com.deppon.montal.login.service.UserLoginService;
import com.deppon.montal.util.ConnectionManager;
import com.deppon.montal.util.IHttpClient;
import com.deppon.montal.util.InitDataServlet;
import com.deppon.montal.util.NetUtil;

public class SendMsgServiceImpl {
	private Logger logger = Logger.getLogger(SendMsgServiceImpl.class);
	/**
	 * 
	* @MethodName: queryPendNumByuserId 
	* @description : 根据人员工号 查询某一时间段中 人员新增待办数
	* @author：caibingbing 
	* @date： 2014-6-23 上午10:04:45
	* @param userid 人员工号
	 * @param fromDate 查询待办的时间节点
	 * @param endTime 
	* @return List<Map<String,String>>
	 * @throws SQLException ,ParseException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public List<Map> queryPendNumByuserId(String userid, String fromDate, String endTime) throws ParseException, SQLException {
		//测试数据
//		fromDate = "2006-12-10";
//		userid = "'105784','070818','051880','000120','000020'";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Map map = null;
		//新增待办信息
		List<Map> pendList = new ArrayList();
		//处理员工工号
		StringBuffer sb = new StringBuffer();
		//查询待办总数对象
		UserLoginService userLoginService = new UserLoginService();
		String sql = SQLManager.getPendingNUM(userid,fromDate,endTime);
		try {
			conn = ConnectionManager.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			//遍历结果集 人员 以及对应的待办数量
			while(rs.next()){
				map = new HashMap();
				String userCode = rs.getString("PARTICIPANT");
				String num = rs.getString("NUM");
				map.put("userCode", userCode);
				map.put("num", num);
				//标识该用户消息推送是否成功    用于后续判断   默认失败
				map.put("sendMsgResult", false);
				//查询当前拥有新增工作流用户的待办总数
//				String total = userLoginService.getWorkFlowCountByUserId(userCode, "");
//				map.put("sum", Integer.parseInt(total));
				//人员 待办数量  存入list集合中
				pendList.add(map);
				//新增待办工作流 人员工号拼接
				sb.append("'" + userCode + "',");
			}
		} catch (SQLException e) {
			logger.info("查询人员待办数目异常，人员工号:["+userid+"] 时间节点:"+fromDate+" 异常信息：" + e.getMessage(), e);
			throw new SQLException("查询人员待办数目异常，人员工号:["+userid+"] 时间节点:"+fromDate+" 异常信息：" + e.getMessage(), e);
		} finally{
			//关闭连接
			ConnectionManager.closeAll(conn, stmt, rs);
		}
		
		//拥有新增待办工作流的用户工号处理
		String users = sb.toString();
		if(users != null && !"".equals(users)){
			users = users.substring(0, users.length()-1);
			pendList = queryWFCount(users,pendList);
		}else{
			users = "''";
		}
		
		return pendList;
	}
	/**
	 * 
	* @MethodName: queryWFCount 
	* @description : 
	* @author：caibingbing 
	* @date： 2014-8-25 下午12:37:23
	* @param users
	* @param pendList
	* @return
	* @throws SQLException List<Map>
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map> queryWFCount(String users, List<Map> pendList) throws SQLException{
		//异常处理
		StringBuffer strbuf = new StringBuffer();
		//查询新增待办工作流的人员 总待办数
		Map<String, String> allPendWFCount = getWorkFlowAllCount(users);
		
		if(allPendWFCount != null){
			//遍历人员新增待办集合  获取其总待办数
			for(int i=0;i<pendList.size();i++){
				Map pendMap = pendList.get(i);
				//拥有新增待办wf 人员工号
				String userCode = (String) pendMap.get("userCode");
				//待办总数
				String allWfCount = allPendWFCount.get(userCode);
				strbuf.append("【"+userCode + ":" + allWfCount+"】");
				if(allWfCount != null && allWfCount != ""){
					pendMap.put("sum", Integer.parseInt(allWfCount));
				}
//				pendList.add(i,pendMap);
				pendList.set(i, pendMap);
			}
		}
		logger.info(strbuf.toString());
		return pendList;
	}
	/**
	*
	* @MethodName: getWorkFlowAllCount 
	* @description : 查询人员总待办数量
	* @author：caibingbing 
	* @date： 2014-8-25 上午11:37:00
	* @param users 
	* @return
	* @throws SQLException Map
	 */
	private Map<String, String> getWorkFlowAllCount(String users) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Map<String, String> map = new HashMap<String, String>();;
		String sql = SQLManager.queryAllWFCount(users);
		
		try {
			conn = ConnectionManager.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			//遍历结果集 人员 以及对应的待办数量
			while(rs.next()){
				
				String userCode = rs.getString("PARTICIPANT");
				String sum = rs.getString("NUM");
				map.put(userCode, sum);
			}
		} catch (SQLException e) {
			logger.info("查询人员总待办数异常，人员工号:["+users+"] 异常信息：" + e.getMessage(), e);
			throw new SQLException("查询人员总待办数异常，人员工号:["+users+"] 异常信息：" + e.getMessage(), e);
		} finally{
			//关闭连接
			ConnectionManager.closeAll(conn, stmt, rs);
		}
		return map;
	}
	/**
	 * 
	* @throws Exception 
	 * @MethodName: sendMsgByUserid 
	* @description : 用户新增待办消息推送
	* @author：caibingbing 
	* @param userid 新增待办工作流用户工号
	* @param num  新增待办数
	* @param sum  拥有新增用户待办总数
	* @date： 2014-6-23 上午11:19:48 void
	 */
	public void sendMsgByUserid(String userid,String num,int sum) throws Exception{
		//工号md5加密  base64加密
		String base64;
		try {
			base64 = SendMsgTaskUtil.getBase64(userid);
		} catch (NoSuchAlgorithmException e) {
			logger.info("工号base64加密异常，当前工号:"+userid +"  异常信息：" +e.getMessage(), e);
			throw new NoSuchAlgorithmException("工号base64加密异常，当前工号:"+userid +"  异常信息：" +e.getMessage(), e);
		}
		String useridMd5;
		try {
			useridMd5 = SendMsgTaskUtil.getMD5(base64);
		} catch (NoSuchAlgorithmException e) {
			logger.info("MD5加密异常，当前工号：" + userid +"  异常信息：" +e.getMessage(),e);
			throw new NoSuchAlgorithmException("MD5加密异常，当前工号：" + userid +"  异常信息：" +e.getMessage(),e);
		}
		//用户待办消息推送接口地址
		String url = InitDataServlet.getValue("pend_SendMsg_URL");
		String content = "温馨提示：您新增"+num+"条待办工作流";
//		content = new String(content.getBytes("UTF-8"),"ISO-8859-1");
		//消息推送参数
		String parm = "?userId="+userid+"&token="+useridMd5+"&sysCode=dpm&content="+content+"&sum="+sum+"&toUser="+userid+"";
		
		logger.info("消息推送地址参数:"+url+parm);
		//工号加密
		ByteArrayOutputStream out = null;
		//消息传输
		IHttpClient httpClient = NetUtil.fetchHttpClient();
		httpClient.setRequestURL(url+parm);
		httpClient.send(null);
		out = httpClient.getOutputStream();
		
		if(out != null){
			String result = out.toString();
			logger.info("用户【"+userid+"】,新增待办数：【"+num+"】,待办总数:【"+sum+"】,消息推送结果："+result);
		}else{
			logger.info("用户【"+userid+"】,新增待办数：【"+num+"】,待办总数:【"+sum+"】,消息推送：失败");
			throw new Exception("用户【"+userid+"】,新增待办数：【"+num+"】,待办总数:【"+sum+"】,消息推送：失败");
		}
		
	}
	/**
	 * 
	* @return 
	 * @MethodName: queryAllUserCode 
	* @description : 查询消息推送权限用户工号
	* @author：caibingbing 
	* @date： 2014-6-23 下午1:53:33 void
	 */
	@SuppressWarnings("rawtypes")
	public List queryAllUserCode() {
		List users = null;
		//查询推送用户工号URL
		String url = InitDataServlet.getValue("Query_SendMsg_User");
		logger.info("查询消息推送权限用户信息URL:"+url);
		//http接口调用
		ByteArrayOutputStream out = null;
		try {
			IHttpClient httpClient = NetUtil.fetchHttpClient();
			httpClient.setRequestURL(url);
			httpClient.send(null);
			out = httpClient.getOutputStream();
		} catch (Exception e1) {
			logger.info("查询消息推送权限用户信息异常，异常信息:"+e1.getMessage(), e1);
		}
		
		String result = null;
		if(out != null){
			//返回结果
			result = out.toString();
			logger.info("获取消息推送用户信息结果: "+result+"");
		}else{
			logger.info("获取消息推送用户信息: 失败");
			result = "{}";
		}
		//返回结果解析
		try {
			users = SendMsgTaskUtil.parseUsersJson(result);
		} catch (Exception e) {
			logger.info("返回结果集解析异常。结果集：" + result, e);
		}
		return users;
	}

	/**
	 * 
	* @MethodName: parseUsers 
	* @description : 
	* @author：caibingbing 
	* @date： 2014-6-26 上午9:24:29
	* @param users
	* @return String
	 */
	@SuppressWarnings("rawtypes")
	public String parseUsers(List users) {
		//解析人员工号
		int userSize = users == null?0:users.size();
		StringBuffer userBuf = new StringBuffer();
		for(int i=0;i<userSize;i++){
			userBuf.append("'"+users.get(i)+"'");
			userBuf.append(",");
		}
		String userStr = userBuf.toString();
		if(!"".equals(userStr)){
			userStr = userStr.substring(0, userStr.length()-1);
		}else{
			userStr = userBuf.append("''").toString();
		}
		return userStr;
	}
	/**
	 * 
	* @MethodName: sendPendMsg 
	* @description : 发送待办消息
	* @author：caibingbing 
	* @date： 2014-6-26 上午9:43:47
	* @param pendNumList void
	* @param sendCount 最多推送次数
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void sendPendMsg(List<Map> pendNumList,int sendCount) {
		//异常工号推送次数  最多3次
//		int sendCount = 3;
		String failUserID = "";
		if(sendCount > 0){
			//遍历循环 推送待办消息
			int size = pendNumList == null?0:pendNumList.size();
			for(int i=0;i<size;i++){
				//人员新增待办数
				Map map = pendNumList.get(i);
				//该用户的待办消息是否推送成功
				boolean sendMsg = (Boolean) map.get("sendMsgResult");
				//推送成功，继续下移用户推送
				if(sendMsg == true){
					continue;
				}
				//用户工号 以及 待办工作流数
				String userid = (String) map.get("userCode");
				String num = (String) map.get("num");

				try {
					int sum  = 0;
					//判断sum是不是为空，发现生产环境有空的问题，在此进行判断
					try {
					String sumStr = String.valueOf(map.get("sum"));
					if("".equals(sumStr)||sumStr==null){
						sum = Integer.parseInt(num);
					}
					} catch (Exception e) {
						e.printStackTrace();
					}
					if(sum==0){
						try {
							sum = (Integer) map.get("sum");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					sendMsgByUserid(userid, num,sum);
				} catch (NoSuchAlgorithmException e) {
					//推送异常的工号
					failUserID = userid + " " + failUserID;
					continue;
				}catch (Exception e) {
					e.printStackTrace();
					//推送异常的工号
					failUserID = userid + " " + failUserID;
					continue;
				}
				//标识该用户消息已推送成功
				map.put("sendMsgResult", true);
				pendNumList.set(i,map);
			}
			//异常工号重新推送 
//			if(!"".equals(failUserID) && sendCount != 0){
//				sendCount--;
//				sendPendMsg(pendNumList,sendCount);
//			}
		}
	}
}

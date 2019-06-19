package com.deppon.dpm.doc.server.action;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.deppon.dpm.doc.server.cache.LocalCache;
import com.deppon.dpm.doc.server.entity.AbnormalOrderEntity;
import com.deppon.dpm.doc.server.entity.DDOrderRequestEntity;
import com.deppon.dpm.doc.server.entity.DidiOrderEntity;
import com.deppon.dpm.doc.server.entity.DidiTicketEntity;
import com.deppon.dpm.doc.server.entity.OccupyBudgetRquestEntity;
import com.deppon.dpm.doc.server.entity.OtherOffDutiesEntity;
import com.deppon.dpm.doc.server.service.IAddMessageService;
import com.deppon.dpm.doc.server.service.IDidiOrderService;
import com.deppon.dpm.doc.server.service.IDidiTicketService;
import com.deppon.dpm.doc.server.service.IDoubtfulExAuditService;
import com.deppon.dpm.doc.server.service.IOccupyBudgetService;
import com.deppon.dpm.doc.server.service.IOtherOffDutiesService;
import com.deppon.dpm.doc.server.service.ISendWechartOfficialService;
import com.deppon.dpm.doc.server.util.DESHelper;
import com.deppon.dpm.doc.server.util.HttpClientUtil;
import com.deppon.dpm.doc.server.util.MD5Sign;
import com.deppon.dpm.doc.server.util.OrderSubStatus;
import com.deppon.dpm.doc.server.vo.DidiOrderDetailVO;
import com.deppon.dpm.doc.server.vo.DidiTicketItemVO;
import com.deppon.dpm.doc.server.vo.DidiTicketResultVO;
import com.deppon.dpm.doc.server.vo.DidiTicketVO;
import com.deppon.dpm.doc.server.vo.OrderVO;
import com.deppon.dpm.doc.server.vo.PriceVO;
import com.deppon.dpm.doc.server.vo.PushMessageVO;
import com.deppon.dpm.doc.server.vo.Reassign_InfoVO;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.service.impl.RedisService;
import com.deppon.dpm.module.common.server.util.ParamUtils;
import com.deppon.dpm.module.common.shared.vo.JPushParam;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.tongxunlu.server.service.IExternalMethodService;
import com.deppon.dpm.tongxunlu.server.service.IJPushNewService;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
import com.sensorsdata.analytics.javasdk.SensorsAnalytics;

/**
 * 滴滴订单回调
 * 
 * @author Administrator
 * 
 */

public class OrderStatusAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory
			.getLogger(OrderStatusAction.class);
	/**
	 * 滴滴订单服务
	 */
	private IDidiOrderService didiOrderService;
	/**
	 * 更新预算服务
	 */
	private IOccupyBudgetService occupyBudgetService;
	/**
	 * 发单Ticket服务
	 */
	private IDidiTicketService didiTicketService;

	private RedisService redisService;
	/**
	 * 滴滴client_id
	 */
	private String didi_client_id;
	/**
	 * 滴滴client_secret
	 */
	private String didi_client_secret;
	/**
	 * 滴滴key
	 */
	private String didi_key;
	/**
	 * 滴滴公共电话
	 */
	private String didi_pubiphone;
	/**
	 * 滴滴的接口地址
	 */
	private String didi_didiurl;
	/**
	 * 滴滴的订单详情地址
	 */
	private String didi_didiorderurl;

	/**
	 * 根据工号或姓名查找该人员信息,直属上级
	 * 
	 */
	private IOtherOffDutiesService otherOffDutiesService;
	
	private String backAmount; 
	
	private IExternalMethodService externalMethodService;
	//疑似异常审核新增数据
	private IDoubtfulExAuditService doubtfulExAuditService;
	//对接企业微信发送消息
	private ISendWechartOfficialService sendWechartOfficialService;
	
	
	
	private String phone;

	/**
	 *构造方法
	 */
	public OrderStatusAction(){
		super();
	}
	
	// 申请应用时分配的AppKey(同授权认证)
	private String client_id;
	// 订单id
	private long  order_id;
	
	// 订单id
	private long  neworder_id;
	/**
	 * 通知类型: 1-订单中间状态流转 2-订单终态通知 3-支付确认通知 4-订单退款通知 5-订单改价通知 6-客服关单通知
	 */
	private int notify_type;
	// 通知说明
	private String notify_desc;
	// 当前时间戳
	private int timestamp;
	// 签名
	private String sign;
	private LocalCache localCache = LocalCache.getInStance();  
	 // 缓存创建时间  
	public static final int CACHEMILLIS = 1700000;

	// 推送消息服务
	private IJPushNewService jPushNewService;

	private IAddMessageService addmessageservice ;
	private String month;
	private String day;
	private String hour;
	private String deptCode;
	
	//人力离职工作流状态接口
	private String dismissStateUrl;
		
		
	// 从神策分析获取的数据接收的 URL
	/*final String SA_SERVER_URL = 
			"http://39.105.252.204:8106/sa?project=default";
	// 使用 Debug 模式，并且导入 Debug 模式下所发送的数据 
	final boolean SA_WRITE_DATA = true;

	// 使用 DebugConsumer 初始化 SensorsAnalytics
	final SensorsAnalytics sa = new SensorsAnalytics(
			new SensorsAnalytics.DebugConsumer(SA_SERVER_URL, SA_WRITE_DATA)); */
		
		
    /**
     * 滴滴授权接口
     */
	@SuppressWarnings("unchecked")
	public Map<String,Object> sendAuthorize() {
		// 授权认证
		logger.info("调用滴滴授权认证开始>>>>>>>>>");
		String authorizeurl = didi_didiorderurl + "Auth/authorize";
		HashMap<String, Object> map = new HashMap<String, Object>();
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			map.put("client_id", didi_client_id);
			map.put("client_secret", didi_client_secret);
			map.put("grant_type", "client_credentials");
			map.put("phone", didi_pubiphone);
			map.put("timestamp", System.currentTimeMillis());
			String sign = MD5Sign.sign(map, didi_key);
			map.put("sign", sign);
			String orderdatail = HttpClientUtil.httpPost(authorizeurl,
					JSON.toJSONString(map,
							SerializerFeature.WriteNullStringAsEmpty));
			logger.info("调用滴滴授权认证结束>>>>>>>>>");
			Map<String,Object> map1 = JSON.parseObject(orderdatail, Map.class);
			return map1;
		} catch (Exception e) {
			logger.info("调用滴滴授权认证出现异常>>>>>>>>>" + e.getMessage());
			resultMap.put("errno", 1);
			resultMap.put("errmsg", "调用滴滴授权认证出现异常>>>>>>>>>" + e.getMessage());
			return resultMap;
		}
	}
	
	@CookieNotCheckedRequired
	public void queryInfo(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 订单详情
		String orderdetailurl = didi_didiorderurl
				+ "order/Detail/getOrderDetail";
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			if(localCache.getLocalCache("access_token")==null){
				Map<String,Object> map1 = sendAuthorize();
				if(map1.get("errno")==null){
					localCache.setLocalCache("access_token", CACHEMILLIS, (String)map1.get("access_token"));
				}else{
					writeToPage(map1);
					return;
				}
			}
			logger.info("didi_查询滴滴订单详情接口access_token>>>>>>>>>"+localCache.getLocalCache("access_token"));
			long time = System.currentTimeMillis();
			map.put("client_id", didi_client_id);
			map.put("access_token", localCache.getLocalCache("access_token"));
			map.put("timestamp", time);
			map.put("order_id", order_id);
			String sign = MD5Sign.sign(map, didi_key);
			String param = "client_id=" + didi_client_id + "&access_token="
					+ localCache.getLocalCache("access_token") + "&timestamp=" + time
					+ "&order_id=" + order_id + "&sign=" + sign;
			logger.info("didi_查询滴滴订单详情>>>>>>>>>获取订单详情");
			String orderdatail = HttpClientUtil.sendGet(orderdetailurl,
					param);
			DidiTicketResultVO didiResultVO = JSON.parseObject(orderdatail, DidiTicketResultVO.class);
			logger.info("didi_查询滴滴订单详情>>>>>>>>>返回参数"+orderdatail);
			writeToPage(didiResultVO);
		}catch (Exception e) {
			logger.info("didi_查询滴滴订单详情出现异常>>>>>>>>>" + e.getMessage());
			resultMap.put("errno", 1);
			resultMap.put("errmsg", "查询滴滴订单详情出现异常>>>>>>>>>" + e.getMessage());
			writeToPage(resultMap);
		}

	}
	
	//查询滴滴预估里程
	private int queryDistance(DidiOrderDetailVO didiorderdetailvo){
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 预估里程
		String orderdistanceurl = didi_didiorderurl
			+ "common/Estimate/getFeature";
		try{
		   logger.info("didi_查询滴滴预估里程接口access_token>>>>>>>>>"+localCache.getLocalCache("access_token"));
		   long time = System.currentTimeMillis();
		   map.put("client_id", didi_client_id);
		   map.put("access_token", localCache.getLocalCache("access_token"));
		   map.put("timestamp", time);
		   map.put("order_id", order_id);
		   
		   float flat = didiorderdetailvo.getFlat();
		   float flng = didiorderdetailvo.getFlng();
		   float tlat = didiorderdetailvo.getTlat();
		   float tlng = didiorderdetailvo.getTlng();
		   int city = didiorderdetailvo.getCity();
		   int require_level = didiorderdetailvo.getRequire_level();
		   int rule=301;
		   if(require_level==600||require_level==900){
		    rule = 301;
		   }else if(require_level==100||require_level==400||require_level==200){
		    rule = 201;
		   }
		   map.put("flat", flat);
		   map.put("flng", flng);
		   map.put("tlat", tlat);
		   map.put("tlng", tlng);
		   map.put("city", city);
		   map.put("rule", rule);
		   String sign = MD5Sign.sign(map, didi_key);
		   String param = "client_id=" + didi_client_id + "&access_token="
		     + localCache.getLocalCache("access_token") + "&timestamp=" + time
		     + "&order_id=" + order_id + "&sign=" + sign+ "&flat=" +flat + "&flng="+flng+ "&tlat=" +tlat
		     + "&tlng=" +tlng+ "&city=" +city+ "&rule="+ rule;
		   
		   logger.info("didi_查询滴滴预估里程>>>>>>>>>获取预估里程");
		   String distance = HttpClientUtil.sendGet(orderdistanceurl,param);
		   JSONObject json = JSONObject.parseObject(distance);
		   int dist = json.getJSONObject("data").getIntValue("dist");
		   return dist;
		}catch (Exception e) {
		   logger.info("didi_查询滴滴预估里程出现异常>>>>>>>>>" + e.getMessage());
		   return 0;
		}
	}
	/**
	 * 查询滴滴订单详情
	 */
	@SuppressWarnings("unchecked")
	@CookieNotCheckedRequired
	public void queryOrderInfo(){
		logger.info("didi_查询滴滴订单详情开始>>>>>>>>>");
		
		logger.info("开始获取滴滴发单申请》》》》》》》》》》》");
		logger.info("组装滴滴发单申请VO开始》》》》》》》》》》》");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("errno", 0);
		resultMap.put("errmsg", "SUCCESS");
		String result = "";
		//获取手机号
		DidiOrderEntity entity = new DidiOrderEntity();
		entity.setBillno(order_id+"");
		DidiOrderEntity entity1 = null;
		entity1 = didiOrderService.find(entity);
		
		try {
			DidiTicketItemVO itemvo = new DidiTicketItemVO();
			itemvo.setClient_id(didi_client_id);
			itemvo.setClient_secret(didi_client_secret);// 申请应用时分配的client_secret
			itemvo.setMaster_phone(didi_pubiphone);// 管理员手机号（作为统一叫车人）
			itemvo.setPassenger_phone(phone);
			if(entity1 != null && entity1.getPhone() != null){
				itemvo.setPassenger_phone(entity1.getPhone());// 乘客手机号(当前用户)
			}
			itemvo.setAuth_type(0);// 授权类型：0-非发单（无发单权限）；1-发单（有发单权限及其他所有权限）
			itemvo.setOrder_id(order_id+"".trim());// 滴滴订单ID（传该值，跳转到指定订单详情页面；不传值，则进入个人中心通用页面） 
			
			String data = DESHelper.encrypt(JSON.toJSONString(itemvo,
					SerializerFeature.WriteNullStringAsEmpty), didi_key
					.substring(0, 8));
			DidiTicketVO vo = new DidiTicketVO();
			vo.setClient_id(didi_client_id);
			vo.setData_encode(data);
			logger.info("组装滴滴发单申请VO结束》》》》》》》》》》》");
			// IHttpClient httpClient = NetUtil.fetchHttpClient();
			String url = didi_didiurl + "ticket/fetch";
			String json = JSON.toJSONString(vo,
					SerializerFeature.WriteNullStringAsEmpty);
			Pattern p = Pattern.compile("\r|\n");
			Matcher m = p.matcher(json);
			json = m.replaceAll("");
			logger.info("组装滴滴发单申请请求参数》》》》》》》》》》》" + json);
			result = HttpClientUtil.httpPost(url, json);
			DidiTicketResultVO resultvo = JSON.parseObject(result,
					DidiTicketResultVO.class);
			Map<String, Object> map = JSON.parseObject(resultvo.getData()
					.toString(), Map.class);
			String webapp = "https://open.es.xiaojukeji.com/webapp/entry?client_id="
					+ didi_client_id + "&ticket=" + map.get("ticket");
			resultMap.put("url", webapp);
		} catch (Exception e) {
//			resultMap.put("url", result);
			resultMap.put("errno", 1);
			resultMap.put("errmsg", e.getMessage());
		}
		writeToPage(resultMap);
	}
	
	
	/**
	 * 滴滴订单回调接口
	 */
	@CookieNotCheckedRequired
	public void sendOrderStatus() {
//		HttpServletRequest request = ServletActionContext.getRequest();
//		if (request.getMethod() == "POST") {
			logger.info("滴滴订单回调接口开始>>>>>>>>>");
			
			// 先返回成功给滴滴方
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("errno", 0);
			resultMap.put("errmsg", "SUCCESS");
			writeToPage(resultMap);
			backString();
			// 处理德邦内部逻辑
			runable();
			
			
//		}
	}
	
	/**
	 * 预算通知改为已推送状态
	 */
	@CookieNotCheckedRequired
	public void updatePushStatus() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		// 结果集
		Result<String> result = new Result<String>();
		int res = 0;
		try {
			res = addmessageservice.updatePushStatus(month, day, hour, deptCode);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("预算通知改为已推送状态异常:" + e);
			e.printStackTrace();
			logger.error("预算通知改为已推送状态异常:" + e.toString());
		}
		// data
		result.setData("预算通知改为已推送状态结果：" + res);
		// 返回
		writeToPage(result);
	}

	/**
	 * @param didiOrderService the didiOrderService to set
	 */
	public void setDidiOrderService(IDidiOrderService didiOrderService) {
		this.didiOrderService = didiOrderService;
	}
	/**
	 * @param client_id
	 */
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	/**
	 * @return the redisService
	 */
	public RedisService getRedisService() {
		return redisService;
	}
	/**
	 * @param redisService the redisService to set
	 */
	public void setRedisService(RedisService redisService) {
		this.redisService = redisService;
	}
	/**
	 * 
	 * @param order_id
	 */
	public void setOrder_id(long  order_id) {
		this.order_id = order_id;
	}
	/**
	 * 
	 * @param notify_type
	 */
	public void setNotify_type(int notify_type) {
		this.notify_type = notify_type;
	}
	/**
	 * 
	 * @param notify_desc
	 */
	public void setNotify_desc(String notify_desc) {
		this.notify_desc = notify_desc;
	}
	/**
	 * 
	 * @param timestamp
	 */
	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * 
	 * @param sign
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}
	/**
	 * 
	 * @return
	 */
	public String getDidi_client_id() {
		return didi_client_id;
	}
	/**
	 * 
	 * @param didi_client_id
	 */
	public void setDidi_client_id(String didi_client_id) {
		this.didi_client_id = didi_client_id;
	}
	/**
	 * 
	 * @return
	 */
	public String getDidi_client_secret() {
		return didi_client_secret;
	}
	/**
	 * 
	 * @param didi_client_secret
	 */
	public void setDidi_client_secret(String didi_client_secret) {
		this.didi_client_secret = didi_client_secret;
	}
	/**
	 * 
	 * @return
	 */
	public String getDidi_key() {
		return didi_key;
	}
	/**
	 * 
	 * @param didi_key
	 */
	public void setDidi_key(String didi_key) {
		this.didi_key = didi_key;
	}
	/**
	 * 
	 * @return
	 */
	public String getDidi_pubiphone() {
		return didi_pubiphone;
	}
	/**
	 * 
	 * @param didi_pubiphone
	 */
	public void setDidi_pubiphone(String didi_pubiphone) {
		this.didi_pubiphone = didi_pubiphone;
	}
	/**
	 * 
	 * @return
	 */
	public String getDidi_didiurl() {
		return didi_didiurl;
	}
	/**
	 * 
	 * @param didi_didiurl
	 */
	public void setDidi_didiurl(String didi_didiurl) {
		this.didi_didiurl = didi_didiurl;
	}
	/**
	 * 
	 * @return
	 */
	public String getDidi_didiorderurl() {
		return didi_didiorderurl;
	}
	/**
	 * 
	 * @param didi_didiorderurl
	 */
	public void setDidi_didiorderurl(String didi_didiorderurl) {
		this.didi_didiorderurl = didi_didiorderurl;
	}
	/**
	 * 
	 * @return
	 */
	public IDidiOrderService getDidiOrderService() {
		return didiOrderService;
	}
	/**
	 * 
	 * @return
	 */
	public String getClient_id() {
		return client_id;
	}
	/**
	 * 
	 * @return
	 */
	public long getOrder_id() {
		return order_id;
	}
	/**
	 * 
	 * @return
	 */
	public int getNotify_type() {
		return notify_type;
	}
	/**
	 * 
	 * @return
	 */
	public String getNotify_desc() {
		return notify_desc;
	}
	/**
	 * 
	 * @return
	 */
	public int getTimestamp() {
		return timestamp;
	}
	/**
	 * 
	 * @return
	 */
	public String getSign() {
		return sign;
	}
	/**
	 * 
	 * @return
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 
	 * @return
	 */
	public IOccupyBudgetService getOccupyBudgetService() {
		return occupyBudgetService;
	}
	/**
	 * 
	 * @param occupyBudgetService
	 */
	public void setOccupyBudgetService(IOccupyBudgetService occupyBudgetService) {
		this.occupyBudgetService = occupyBudgetService;
	}
	/**
	 * 
	 * @return
	 */
	public IDidiTicketService getDidiTicketService() {
		return didiTicketService;
	}
	/**
	 * 
	 * @param didiTicketService
	 */
	public void setDidiTicketService(IDidiTicketService didiTicketService) {
		this.didiTicketService = didiTicketService;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void runable() {
		Result<Object> result = new Result<Object>();//修漏洞添加
		logger.info("滴滴订单回调didiorder-start"+order_id);
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 新的订单详情接口
		String orderdetailurl = "https://api.es.xiaojukeji.com/v2/"
				+ "order/Detail/getOrderDetail";

		Map<String, Object> resultMap = new HashMap<String, Object>();
		DidiOrderEntity entity = new DidiOrderEntity();
		
		try {
			if(localCache.getLocalCache("access_token")==null){
				Map<String,Object> map1 = sendAuthorize();
				if(map1.get("errno")==null){
					localCache.setLocalCache("access_token", CACHEMILLIS, (String)map1.get("access_token"));
				}else{
					logger.error("调用滴滴授权认证出现异常>>>>>>>>>" + map1.toString());
//					writeToPage(map1);
					return;
				}
			}
			logger.info("滴滴订单回调接口access_token>>>>>>>>>"+localCache.getLocalCache("access_token"));
			long time = System.currentTimeMillis();
			map.put("client_id", didi_client_id);
			map.put("access_token", localCache.getLocalCache("access_token"));
			map.put("timestamp", time);
			map.put("order_id", order_id);
			String sign = MD5Sign.sign(map, didi_key);
			String param = "client_id=" + didi_client_id + "&access_token="
					+ localCache.getLocalCache("access_token") + "&timestamp=" + time
					+ "&order_id=" + order_id + "&sign=" + sign;
			logger.info(order_id+"滴滴订单回调接口>>>>>>>>>获取订单详情:"+param);
			String orderdatail = HttpClientUtil.sendGet(orderdetailurl, 
					param);
			logger.info(order_id+"滴滴订单详情接口>>>>>>>>>返回参数:"+orderdatail);
			if (orderdatail == null || "".equals(orderdatail)) {
//				resultMap.put("errno", 1);
//				resultMap.put("errmsg", "没有获取到订单id" + order_id + "信息");
				logger.error("滴滴订单详情接口>>>>>>>>>" + "没有获取到订单id" + order_id + "信息");
//				writeToPage(resultMap);
				return;
			}
			Map jsonmap = (Map) JSONObject.parse(orderdatail);
			logger.info("获取订单返款信息开始>>>>>>>>>>>>>>>>>>");
			Object stringData = jsonmap.get("data");
			if(stringData != null){
				Map dataMap = (Map) JSONObject.parse(stringData.toString());
				Object priceObj = dataMap.get("price");
				if(priceObj != null){
					Map priceMap = (Map) JSONObject.parse(priceObj.toString());
					JSONArray detailObj = (JSONArray) priceMap.get("detail");
					if(detailObj != null){
						for(int i = 0; i < detailObj.size(); i++){
							String subjecti = ((JSONObject)detailObj.get(i)).getString("type");//
							if("refund_price".equals(subjecti)){
								backAmount = ((JSONObject)detailObj.get(i)).getString("amount");//
							}
						}
					}
					
				}
			}
			DidiTicketResultVO didiResultVO = JSON.parseObject(orderdatail, DidiTicketResultVO.class);
			if(didiResultVO.getErrno()!=0){
//				writeToPage(didiResultVO);
				logger.error("滴滴订单详情接口err>>>>>>>>>" + orderdatail);
				return;
			}
			OrderVO orderVO =  JSON.parseObject(didiResultVO.getData().toString(), OrderVO.class);
			DidiOrderDetailVO didiorderdetailvo = orderVO.getOrder();
			
			int dist = queryDistance(didiorderdetailvo);
			
			
			PriceVO priceVO = orderVO.getPrice();
			entity.setBillno(order_id+"");
			
			String id="";
			Reassign_InfoVO reassign_info = didiorderdetailvo.getReassign_info(); 
			if(!"0".equals(reassign_info.getLatest_order_id())){
				id = reassign_info.getLatest_order_id();
			}else{
				id = order_id+"";
			}
			logger.info("滴滴订单回调接口>>>>>>>>>更新id"+id);
			Map<String,Object> map1 = new HashMap<String, Object>();
			if(didiorderdetailvo.getCallback_info()!=null&&!"".equals(didiorderdetailvo.getCallback_info())){
				map1 = JSON.parseObject(didiorderdetailvo.getCallback_info().toString() , Map.class);
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = sdf.parse(didiorderdetailvo.getOrder_time());
			logger.info("滴滴订单回调接口>>>>>>>>>保存订单详情");
			
			// 用户的 Distinct Id
			String distinctId = (String)map1.get("userId");	
			//解决漏洞问题，验证工号
			if(ParamUtils.checkUserId(distinctId)){
				   result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				   // errorMessage
				   result.setErrorMessage("工号错误，不符合规范");
				   writeToPage(result);
				   return;
				  }
			
			Map<String, Object> properties = new HashMap<String, Object>();
			
			DidiOrderEntity entity1 = null;
			entity1 = didiOrderService.find(entity);
			if(entity1 == null){
				entity.setBillno(reassign_info.getInit_order_id());
				entity1 = didiOrderService.find(entity);
			}
			if(entity1 == null){
				entity.setBillno(reassign_info.getLatest_order_id());
				entity1 = didiOrderService.find(entity);
			}
			if(entity1 == null){
				entity.setBillno(reassign_info.getNext_order_id());
				entity1 = didiOrderService.find(entity);
			}
			if(entity1 == null){
				entity.setBillno(reassign_info.getPre_order_id());
				entity1 = didiOrderService.find(entity);
			}
			if (entity1 == null) {
				DidiTicketEntity diditicketentity = new DidiTicketEntity();
				diditicketentity.setOrderId(order_id+"");//init_order_id
				DidiTicketEntity diditicketentity1 = didiTicketService.find(diditicketentity);
				if(diditicketentity1 == null || "".equals(diditicketentity1)){
					diditicketentity.setOrderId(reassign_info.getInit_order_id());//init_order_id
					diditicketentity1 = didiTicketService.find(diditicketentity);
				}
				entity.setBillno(id);//行程单号
				entity.setName(diditicketentity1.getUsername());//姓名
				//entity.setEmployeeno((String)map1.get("userId"));//工号
				entity.setEmployeeno(distinctId);
				entity.setModels(didiorderdetailvo.getRequire_level()+"");//车型
				entity.setFromName(didiorderdetailvo.getStart_name()+"/"+didiorderdetailvo.getStart_address());//出发地
				entity.setToName(didiorderdetailvo.getEnd_name()+"/"+didiorderdetailvo.getEnd_address());//目的地
				entity.setTaxidate(didiorderdetailvo.getOrder_time());//打车日期
				entity.setBoardingtime(didiorderdetailvo.getBegin_charge_time());//上车时间
				entity.setOfftime(didiorderdetailvo.getFinish_time());//下车时间
				entity.setOrderstatus(didiorderdetailvo.getStatus());//单号状态
				entity.setSub_status(didiorderdetailvo.getSub_status());//订单详细状态码
				entity.setNormalDistance(didiorderdetailvo.getNormal_distance());//打车总里程
				entity.setTotalPrice(priceVO.getTotal_price());//费用
				entity.setDept(diditicketentity1.getDept());//部门
				entity.setCompany(diditicketentity1.getCompany());//公司
				entity.setFinancedept(diditicketentity1.getFinancedept());//所属财务部
				entity.setBudgetratio("");//预算完成比
				entity.setTimeschedule("");//时间进度
				entity.setRemark((String)map1.get("remark"));//用车事由
				entity.setRemarkinfo(diditicketentity1.getRemarkinfo());//用车事由详细
				entity.setEstimateprice(priceVO.getEstimate_price());//预估价
				
				entity.setEstimateDistance(Integer.toString(dist));//预估里程
				
				entity.setIs_carpool(didiorderdetailvo.getIs_carpool());//是否拼车
				entity.setIs_carpool_success(didiorderdetailvo.getIs_carpool_success());//是否拼车成功
				
				//add by gwl 20180302
				entity.setCustomname(diditicketentity1.getCustomname());//客户名称：customname
				entity.setCustomtel(diditicketentity1.getCustomtel());//客户手机号：customtel
				entity.setCustomcode(diditicketentity1.getCustomcode());//客户编码：customcode
				entity.setMeetingname(diditicketentity1.getMeetingname());//日程会议名称：meetingname
				entity.setFrommanagercode(diditicketentity1.getFrommanagercode());//出发部门负责人工号：frommanagercode
				entity.setFrommanagername(diditicketentity1.getFrommanagername());//出发部门负责人姓名：frommanagername
				entity.setTomanagercode(diditicketentity1.getTomanagercode());//目的部门负责人工号：tomanagercode
				entity.setTomanagername(diditicketentity1.getTomanagername());//目的部门负责人姓名：tomanagername
				entity.setAuditorcode(diditicketentity1.getAuditorcode());//其他公务审核人工号：auditorcode
				entity.setJoblevel(diditicketentity1.getJoblevel());//其他公务审核人jibie
				entity.setAuditorname(diditicketentity1.getAuditorname());//其他公务审核人姓名：auditorname
				entity.setNewmeetingname(diditicketentity1.getNewmeetingname());
				entity.setNewmeetingstart(diditicketentity1.getNewmeetingstart());
				entity.setNewmeetingend(diditicketentity1.getNewmeetingend());
				entity.setPhone(diditicketentity1.getUsertel());
				entity.setRefundamount(backAmount);
				

				/*//订单id
				properties.put("trip_orderID", order_id);
				//订单金额
				properties.put("trip_order_amount", priceVO.getTotal_price());
				//用车事由
				properties.put("trip_reason", (String)map1.get("remark"));
				//是否通过（是否已支付）
				properties.put("if_pass", false);
				if(didiorderdetailvo.getSub_status() == 7000){
					properties.put("if_pass", true);
				}							
				//是否需要领导审批
				properties.put("if_need_review", false);*/
				
//				//新增会议推送直属上级
//				if(diditicketentity1.getNewmeetingname() != null
//						&& !("".equals(diditicketentity1.getNewmeetingname()))
//						&& !("null".equals(diditicketentity1.getTomanagercode()))
//						){
//					List<String> userIdList = new ArrayList<String>();
//					EmployeeVO employee = externalMethodService.getLeaderInfo(diditicketentity1.getUserid());
//					if(employee != null){
//						userIdList.add(employee.getEmpCode());//用户头像
//					}
//					String fromspace = didiorderdetailvo.getStart_name()+"/"+didiorderdetailvo.getStart_address();
//					String tospace = didiorderdetailvo.getEnd_name()+"/"+didiorderdetailvo.getEnd_address();
//					sendMsgForMeeting(userIdList,diditicketentity1.getUsername(),didiorderdetailvo.getOrder_time(),fromspace,tospace);
//				}
				
//				//如果跨区办公，增加部门领导人发送消息功能
//				if(diditicketentity1.getFrommanagercode() != null 
//						&& diditicketentity1.getTomanagercode() != null
//						&& !("".equals(diditicketentity1.getTomanagercode()))
//						&& !("".equals(diditicketentity1.getFrommanagercode()))
//						&& !("null".equals(diditicketentity1.getTomanagercode()))
//						&& !("null".equals(diditicketentity1.getFrommanagercode()))){
//					List<String> userIdList = new ArrayList<String>();
//					userIdList.add(diditicketentity1.getFrommanagercode());
//					userIdList.add(diditicketentity1.getTomanagercode());
//					String fromspace = didiorderdetailvo.getStart_name()+"/"+didiorderdetailvo.getStart_address();
//					String tospace = didiorderdetailvo.getEnd_name()+"/"+didiorderdetailvo.getEnd_address();
//					sendMessageByuserId(userIdList,diditicketentity1.getUsername(),didiorderdetailvo.getOrder_time(),fromspace,tospace);
//				}
//				//如果其他公务，增加部门领导人发送消息功能
//				if(diditicketentity1.getAuditorcode() != null
//						&& !("".equals(diditicketentity1.getAuditorcode()))
//						&&!("null".equals(diditicketentity1.getAuditorcode()))
//						){
//					List<String> userIdList = new ArrayList<String>();
//					userIdList.add(diditicketentity1.getAuditorcode());
//					String fromspace = didiorderdetailvo.getStart_name()+"/"+didiorderdetailvo.getStart_address();
//					String tospace = didiorderdetailvo.getEnd_name()+"/"+didiorderdetailvo.getEnd_address();
//					sendMessageOther(userIdList,diditicketentity1.getUsername(),didiorderdetailvo.getOrder_time(),fromspace,tospace);
//				}
				
				entity.setBankcardnum(diditicketentity1.getBankcardnum());//银行卡号：bankcardnum
				entity.setUserheadpic(diditicketentity1.getUserheadpic());//用户头像
				entity.setDeparturetime(didiorderdetailvo.getDeparture_time());//出发时间
				
				entity.setTravelWorkflowNo(diditicketentity1.getTravelWorkflowNo());
				//end by gwl
				
				// 添加try-catch语句，处理因为网络延时问题，造成的重复插入问题
				try{
					didiOrderService.insert(entity);
					diditicketentity1.setFlag(1);//已处理
					didiTicketService.update(diditicketentity1);
				}catch(Exception ex){
					// 如果是重复问题，应该进行更新处理
					logger.error("滴滴订单回调接口>>>>>>>>>id"+id+"处理因网络延迟造成重复插入的问题开始");
					entity1 = didiOrderService.find(entity);
					if (entity1 == null) {
						logger.error("滴滴订单回调接口>>>>>>>>>id"+id+"根据订单号查询订单出现异常");
					}else{
						if (entity1.getSub_status().equals("6101")
								||entity1.getSub_status().equals("6102")
								||entity1.getSub_status().equals("6103")
								||entity1.getSub_status().equals("6104")
								||entity1.getSub_status().equals("6105")
								||entity1.getSub_status().equals("7000")) {// 库中本身已经处于关闭状态的订单不予处理
							
						}else {
							entity1.setBillno(id);//行程单号
							entity1.setModels(didiorderdetailvo.getRequire_level()+"");//车型
							entity1.setFromName(didiorderdetailvo.getStart_name()+"/"+didiorderdetailvo.getStart_address());//出发地
							entity1.setToName(didiorderdetailvo.getEnd_name()+"/"+didiorderdetailvo.getEnd_address());//目的地
							entity1.setTaxidate(didiorderdetailvo.getOrder_time());//打车日期
							entity1.setBoardingtime(didiorderdetailvo.getBegin_charge_time());//上车时间
							entity1.setOfftime(didiorderdetailvo.getFinish_time());//下车时间
							entity1.setOrderstatus(didiorderdetailvo.getStatus());//单号状态
							entity1.setSub_status(didiorderdetailvo.getSub_status());//订单详细状态码
							entity1.setNormalDistance(didiorderdetailvo.getNormal_distance());//打车总里程
							entity1.setTotalPrice(priceVO.getTotal_price());//费用
							entity1.setEstimateprice(priceVO.getEstimate_price());//预估价
							
							entity1.setEstimateDistance(Integer.toString(dist));//预估里程
							
							entity1.setIs_carpool(didiorderdetailvo.getIs_carpool());//是否拼车
							entity1.setIs_carpool_success(didiorderdetailvo.getIs_carpool_success());//是否拼车成功
							 					
							
							/*//制造测试数据
							entity1.setNormalDistance(Integer.toString(10));//打车总里程
							entity1.setEstimateDistance(Integer.toString(3000));//预估里程
							entity1.setTotalPrice(130);//费用
							entity1.setEstimateprice(100);//预估价
*/							
							entity1.setBudgetratio("");//预算完成比
							entity1.setTimeschedule("");//时间进度
							didiOrderService.update(entity1);
						}
					}
					logger.error("滴滴订单回调接口>>>>>>>>>id"+id+"处理因网络延迟造成重复插入的问题结束");
				}
				
			} else {
				if (entity1.getSub_status().equals("6101")
						||entity1.getSub_status().equals("6102")
						||entity1.getSub_status().equals("6103")
						||entity1.getSub_status().equals("6104")
						||entity1.getSub_status().equals("6105")
						||entity1.getSub_status().equals("7000")) {// 库中本身已经处于关闭状态的订单不予处理
					
				}else {
					entity1.setBillno(id);//行程单号
					entity1.setModels(didiorderdetailvo.getRequire_level()+"");//车型
					entity1.setFromName(didiorderdetailvo.getStart_name()+"/"+didiorderdetailvo.getStart_address());//出发地
					entity1.setToName(didiorderdetailvo.getEnd_name()+"/"+didiorderdetailvo.getEnd_address());//目的地
					entity1.setTaxidate(didiorderdetailvo.getOrder_time());//打车日期
					entity1.setBoardingtime(didiorderdetailvo.getBegin_charge_time());//上车时间
					entity1.setOfftime(didiorderdetailvo.getFinish_time());//下车时间
					entity1.setOrderstatus(didiorderdetailvo.getStatus());//单号状态
					entity1.setSub_status(didiorderdetailvo.getSub_status());//订单详细状态码
					entity1.setNormalDistance(didiorderdetailvo.getNormal_distance());//打车总里程
					entity1.setTotalPrice(priceVO.getTotal_price());//费用
					entity1.setEstimateprice(priceVO.getEstimate_price());//预估价
					
					entity1.setEstimateDistance(Integer.toString(dist));//预估里程
					
					entity1.setIs_carpool(didiorderdetailvo.getIs_carpool());//是否拼车
					entity1.setIs_carpool_success(didiorderdetailvo.getIs_carpool_success());//是否拼车成功
									
					
					//制造测试数据
					/*entity1.setNormalDistance(Integer.toString(10));//打车总里程
					entity1.setEstimateDistance(Integer.toString(3000));//预估里程
					entity1.setTotalPrice(130);//费用
					entity1.setEstimateprice(100);//预估价
*/					
					entity1.setBudgetratio("");//预算完成比
					entity1.setTimeschedule("");//时间进度			
					//司机信息
					entity1.setDriveName(didiorderdetailvo.getDriver_name()); //司机称呼
					entity1.setDriverPhoneReal(didiorderdetailvo.getDriver_phone_real());//司机真实手机号
					entity1.setDriverCarType(didiorderdetailvo.getDriver_car_type());//司机车型
					entity1.setDriverCard(didiorderdetailvo.getDriver_card());//司机车牌
					entity1.setDriverLevel(didiorderdetailvo.getDriver_level());//司机星级
					entity1.setDlng(didiorderdetailvo.getDlng());//司机当前实时经度
					entity1.setDlat(didiorderdetailvo.getDlat());//司机当前实时维度
					didiOrderService.update(entity1);
				}
			}
			
			final SensorsAnalytics sa = new SensorsAnalytics(
				     new SensorsAnalytics.ConcurrentLoggingConsumer("/dpmfile/data/sa/access.log"));
			//订单id
			properties.put("trip_orderID", order_id);
			//订单金额
			properties.put("trip_order_amount", priceVO.getTotal_price());
			//用车事由
			properties.put("trip_reason", (String)map1.get("remark"));
			//是否通过（是否已支付）
			properties.put("if_pass", false);
			if(didiorderdetailvo.getSub_status() == 7000){
				properties.put("if_pass", true);
			}							
			//是否需要领导审批
			properties.put("if_need_review", false);
			
			
			logger.info("滴滴订单回调接口>>>>>>>>>超时订单id"+id);
			if(didiorderdetailvo.getStatus()==311){//订单超时
				DDOrderRequestEntity ddorderrequestentity = new DDOrderRequestEntity();
				ddorderrequestentity.setBillno(id);
				ddorderrequestentity.setName(entity1.getName());
				ddorderrequestentity.setEmployeeno(entity1.getEmployeeno());
				ddorderrequestentity.setModels(entity1.getModels());
				ddorderrequestentity.setFromName(entity1.getFromName());
				ddorderrequestentity.setToName(entity1.getToName());
				ddorderrequestentity.setTaxidate(entity1.getTaxidate());
				ddorderrequestentity.setBoardingtime(entity1.getBoardingtime());
				ddorderrequestentity.setOfftime(entity1.getOfftime());
				ddorderrequestentity.setOrderstatus(entity1.getOrderstatus());
				ddorderrequestentity.setSub_status(entity1.getSub_status());
				ddorderrequestentity.setNormalDistance(entity1.getNormalDistance());
				ddorderrequestentity.setTotalPrice(new BigDecimal(priceVO.getTotal_price()));
				ddorderrequestentity.setDept(entity1.getDept());
				ddorderrequestentity.setFinancedept(entity1.getFinancedept());
				ddorderrequestentity.setEstimateAmount(new BigDecimal(entity1.getEstimateprice()));
				occupyBudgetService.noRespCertif(ddorderrequestentity);
			}
			logger.info("滴滴订单回调接口>>>>>>>>>结束订单详情");
			if (new BigDecimal(priceVO.getTotal_price()).compareTo(BigDecimal.ZERO) != 0) {
				OccupyBudgetRquestEntity budget = new OccupyBudgetRquestEntity();
				budget.setBusinessId(id);
				budget.setEmpCode(distinctId);
				budget.setAmount(new BigDecimal(priceVO.getTotal_price()));
				budget.setBusinessStartTime(date);
				occupyBudgetService.updateBudget(budget);
				occupyBudgetService.pushMessageMethord(budget);
				try{
					
					//新增会议推送直属上级
					if(entity1.getNewmeetingname() != null
							&& !("".equals(entity1.getNewmeetingname()))
							&& !("null".equals(entity1.getTomanagercode()))
							){
						List<String> userIdList = new ArrayList<String>();
						EmployeeVO employee = externalMethodService.getLeaderInfo(entity1.getEmployeeno());
						if(employee != null){
							userIdList.add(employee.getEmpCode());//用户头像
						}
						String fromspace = didiorderdetailvo.getStart_name()+"/"+didiorderdetailvo.getStart_address();
						String tospace = didiorderdetailvo.getEnd_name()+"/"+didiorderdetailvo.getEnd_address();
						sendMsgForMeeting(userIdList,entity1.getName(),didiorderdetailvo.getOrder_time(),fromspace,tospace);
					}
					
					//如果跨区办公，增加部门领导人发送消息功能
					if(entity1.getFrommanagercode() != null 
							&& entity1.getTomanagercode() != null
							&& !("".equals(entity1.getTomanagercode()))
							&& !("".equals(entity1.getFrommanagercode()))
							&& !("null".equals(entity1.getTomanagercode()))
							&& !("null".equals(entity1.getFrommanagercode()))){
						List<String> userIdList = new ArrayList<String>();
						userIdList.add(entity1.getFrommanagercode());
						userIdList.add(entity1.getTomanagercode());
						String fromspace = didiorderdetailvo.getStart_name()+"/"+didiorderdetailvo.getStart_address();
						String tospace = didiorderdetailvo.getEnd_name()+"/"+didiorderdetailvo.getEnd_address();
						sendMessageByuserId(userIdList,entity1.getName(),didiorderdetailvo.getOrder_time(),fromspace,tospace);
					}
					
					//如果其他公务，增加部门领导人发送消息功能
					if(entity1.getAuditorcode() != null
							&& !("".equals(entity1.getAuditorcode()))
							&&!("null".equals(entity1.getAuditorcode()))
							&& (Integer.valueOf(entity1.getJoblevel()==null?"0":entity1.getJoblevel())<10)
							){
						List<String> userIdList = new ArrayList<String>();
						userIdList.add(entity1.getAuditorcode());
						String fromspace = didiorderdetailvo.getStart_name()+"/"+didiorderdetailvo.getStart_address();
						String tospace = didiorderdetailvo.getEnd_name()+"/"+didiorderdetailvo.getEnd_address();
						String billno =entity1.getBillno();
						sendMessageOther(userIdList,entity1.getName(),didiorderdetailvo.getOrder_time(),fromspace,tospace,billno);
					}
					/*
					//是否为待审核状态
					boolean isAuditOrder = false;
					EnumSet<OrderSubStatus> auditSet = OrderSubStatus.AUDIT_SET;
					for (OrderSubStatus orderSubStatus : auditSet) {
						if(orderSubStatus.getCode().intValue() == entity1.getSub_status().intValue()){
							isAuditOrder = true;
							break;
						}
					}
					logger.info("订单"+entity1.getBillno()+"的是否需要审核:"+isAuditOrder);
					*/
					logger.info("新增其他公务审核方法>>>>>>>>>>>>>>>>>>>>>>>>>>>");
					if(distinctId!= null
							&& !("".equals(entity1.getAuditorname()))
							&&!("null".equals(entity1.getAuditorname()))
							&& (Integer.valueOf(entity1.getJoblevel()==null?"0":entity1.getJoblevel())<10)
							){
						int intother = insertOtherEntity(entity1);
						//是否需要领导审批
						properties.put("if_need_review", true);
						logger.info("新增其他公务审核方法结束>>>>>>>>>>>>>>>>>>>>>>>>>>>",intother);
						resultMap.put("insertotherentity", intother);	
					}
					//打车单公里费用 
					float singleKm = (entity1.getTotalPrice())/(Float.parseFloat(entity1.getNormalDistance()));//
					//判断打车时间 时长 < 5min 或 > 3h ；
					String boardingtime = entity1.getBoardingtime();//上车时间
					String offtime = entity1.getOfftime();//下车时间
					
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Long beginL = format.parse(boardingtime).getTime();
					Long endL = format.parse(offtime).getTime();
//					Long day = (endL - beginL)/86400000;
					Long hour = (endL - beginL)/3600000;
					Long min = (endL - beginL)/60000;

					Boolean isornot = false;
					String formtoname = entity1.getFromName() + entity1.getToName();
					if(formtoname.contains("酒店") || formtoname.contains("KTV") || formtoname.contains("洗浴")){
						isornot = true;
					}
					//判断 含酒店、洗浴、KTV等关键字
					if(!((String)map1.get("remark")).equals("差旅") && (entity1.getTotalPrice()>=200 || Float.parseFloat(entity1.getNormalDistance())<=1 || singleKm>=7 || 
							(entity1.getTotalPrice()-entity1.getEstimateprice())>=50 || hour>=3 || min<=5 || isornot == true
							)){
						int interror = insertDoubtfulAuditEntity(entity1,singleKm,isornot,hour,min);
						//是否需要领导审批
						properties.put("if_need_review", true);
						logger.info("新增疑似异常审核方法结束>>>>>>>>>>>>>>>>>>>>>>>>>>>",interror);
						resultMap.put("insertotherentity", interror);
						
					}
					
					//判断离职工作流为待审批状态
					String str = HttpClientUtil.httpPost(dismissStateUrl,distinctId);
					JSONObject json = JSONObject.parseObject(str);
					String s = (String) json.get("AUDITSTATECODE");
					if("2".equals(s)||"3".equals(s)||"4".equals(s)){
						int interror = insertDoubtfulAuditEntity(entity1,singleKm,false,hour,min);
						//是否需要领导审批
						properties.put("if_need_review", true);
						logger.info(distinctId+"新增疑似异常审核方法结束>>>>>>>>>>>>>>>>>>>>>>>>>>>",str);
						logger.info("新增疑似异常审核方法结束>>>>>>>>>>>>>>>>>>>>>>>>>>>",interror);
						resultMap.put("insertotherentity", interror);
					}
					
					//判断排班状态加入疑似异常审核
					//11 ‘旷’,19 ‘产’,23 ‘产检’,20 ‘婚’
					String stateResult = doubtfulExAuditService.queryScheduleState(distinctId);
					if("11".equals(stateResult)||"19".equals(stateResult)||"23".equals(stateResult)||"20".equals(stateResult)){
						int interror = insertDoubtfulAuditEntity(entity1,singleKm,false,hour,min);
						//是否需要领导审批
						properties.put("if_need_review", true);
						logger.info("新增疑似异常审核方法结束>>>>>>>>>>>>>>>>>>>>>>>>>>>",interror);
						resultMap.put("insertotherentity", interror);
					}
					
					//前一次打车结束时间跟后一次打车时间间隔在10分钟以内加入疑似异常审核
					//根据工号查询上次打车记录
					DidiOrderEntity lastOrder = didiOrderService.selectLastOrder(distinctId);
					String lastOfftime = lastOrder.getOfftime();
					String thisBoardingtime = entity1.getBoardingtime();
					boolean b = false;
					if(!"".equals(thisBoardingtime)){
						SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Date d1 = sdf1.parse(lastOfftime);
						Date d2 = sdf1.parse(thisBoardingtime);
						if(d2.getTime()-d1.getTime()<=600000){
							b=true;
						}
					}
					if(b==true){
						int interror = insertDoubtfulAuditEntity(entity1,singleKm,false,hour,min);
						//是否需要领导审批
						properties.put("if_need_review", true);
						logger.info("新增疑似异常审核方法结束>>>>>>>>>>>>>>>>>>>>>>>>>>>",interror);
						resultMap.put("insertotherentity", interror);
					}
					
					//实际里程超过预估里程5公里以上加入异常单
					if((Integer.parseInt(entity1.getNormalDistance())*1000-Integer.parseInt(entity1.getEstimateDistance())>=5000)){
						int interror = insertDoubtfulAuditEntity(entity1,singleKm,false,hour,min);
						//是否需要领导审批
						properties.put("if_need_review", true);
						logger.info("新增疑似异常审核方法结束>>>>>>>>>>>>>>>>>>>>>>>>>>>",interror);
						resultMap.put("insertotherentity", interror);
					}
					
					//参加会议加入疑似异常审核
					if(entity1.getMeetingname() != null && entity1.getNewmeetingname() != null 
							&& !entity1.getNewmeetingname().trim().equals("") && !entity1.getNewmeetingstart().equals("Invalid date")){
						logger.info("参加会议加入疑似异常审核>>>>>>>>>>>>>>>>>>>>>>>>>>>",distinctId);
						logger.info("Meetingname:" + entity1.getNewmeetingname());
						logger.info("Newmeetingname:" + entity1.getNewmeetingname() + "--" +!entity1.getNewmeetingname().trim().equals(""));
						logger.info("Newmeetingstart:" + entity1.getNewmeetingstart() + "--" + !entity1.getNewmeetingstart().equals("Invalid date"));
						int meetingcheck = insertDoubtfulAuditEntity(entity1,singleKm,false,hour,min);
						logger.info("参加会议加入疑似异常审核结束>>>>>>>>>>>>>>>>>>>>>>>>>>>",meetingcheck);
					}
					
					// 记录用户浏览商品事件
					sa.track(distinctId, true, "app_pay_trip_order", properties);
					// 刷新一下，让埋点数据落到指定目录文件中
				    sa.flush();
					
				}catch(Exception e1){
					logger.error("推单出现异常>>>>>>>>>" + e1.getMessage());
				}
							
			}
//			if(notify_type==2){//订单已经支付完成，调用预算接口扣除预算
//				
//			}
			// 程序结束前，停止神策分析 SDK 所有服务
		    sa.shutdown();
			
			resultMap.put("errno", 0);
			resultMap.put("errmsg", "SUCCESS");
//			writeToPage(resultMap);
		} catch (Exception e) {
			logger.error(order_id+"滴滴订单回调出现异常>>>>>>>>>" + e.getMessage());
			resultMap.put("errno", 1);
			resultMap.put("errmsg", "滴滴订单回调出现异常>>>>>>>>>" + e.getMessage());
//			writeToPage(resultMap);
		}
		logger.info("滴滴订单回调didiorder-end"+order_id);
	}
	
	
	public IJPushNewService getjPushNewService() {
		return jPushNewService;
	}
	public void setjPushNewService(IJPushNewService jPushNewService) {
		this.jPushNewService = jPushNewService;
	}

	/**
	 * @return the addmessageservice
	 */
	public IAddMessageService getAddmessageservice() {
		return addmessageservice;
	}
	/**
	 * @param addmessageservice the addmessageservice to set
	 */
	public void setAddmessageservice(IAddMessageService addmessageservice) {
		this.addmessageservice = addmessageservice;
	}
	/**
	 * 跨区办公，消息提示
	 * @param userIdList
	 * @param userName
	 * @param billno 
	 */
	public void sendMessageByuserId(List<String> userIdList,String userName,String taxidate,String from,String tospace){
		//根据工号推送预算临近预警提示消息
		StringBuffer codestr = new StringBuffer();
		for (String code : userIdList) {
			codestr.append(code+",");
		}
		//推送消息
		JPushParam param = new JPushParam();
		param.setAlert("您好，收到"+userName+"跨区办公打车消息.时间："+taxidate+"， 出发地："+from+"， 目的地："+tospace+".");// 消息弹出的内容
		param.setContent("您好，收到"+userName+"跨区办公打车消息.时间："+taxidate+"， 出发地："+from+"， 目的地："+tospace+".");
		param.setUserIds(codestr.substring(0, codestr.length()-1));
		// 链接类型 0：无链接 1：外部链接 2：内部链接 3:消息反馈 4:意见反馈
		param.setLinktype(2);
		param.getExtras().put("toNews", "true");
		param.setLinkaddr("app_package/doc/index.html");
		try {
			List<PushMessageVO>  addVOList = new ArrayList<PushMessageVO>();
			for(String temp : userIdList){
				PushMessageVO pushmessagevo = new PushMessageVO();
				pushmessagevo.setDept(Integer.valueOf("123"));
				pushmessagevo.setUserid(temp);
				pushmessagevo.setState("0");
				pushmessagevo.setMessage("您好，收到"+userName+"跨区办公打车消息.时间："+taxidate+"， 出发地："+from+"， 目的地："+tospace+".");// 消息弹出的内容
				pushmessagevo.setMsgtitle("跨区办公");
				addVOList.add(pushmessagevo);
				String str = sendWechartOfficialService.sendWechartOfficial("跨区办公："+"您好，收到"+userName+"跨区办公打车消息.时间："+taxidate+"， 出发地："+from+"， 目的地："+tospace+".",temp);
				logger.info("您好，收到"+userName+"跨区办公打车消息.时间："+taxidate+"， 出发地："+from+"， 目的地："+tospace+"."+temp);
				logger.info("企业微信发送结果>>>>>>" + str);
			}
			addmessageservice.insertRemind(addVOList);
			
			//jPushNewService.pushByUserIds(param);
		} catch (Exception e) {
			logger.info("滴滴跨区办公推送消息异常>>>>>>>>>" + e.getMessage());
		}
	}
	
	
	/**
	 * 参加会议消息通知
	 * @param userIdList
	 * @param userName
	 * @param billno 
	 */
	public void sendMsgForMeeting(List<String> userIdList,String userName,String taxidate,String from,String tospace){
		//根据工号推送预算临近预警提示消息
		StringBuffer codestr = new StringBuffer();
		for (String code : userIdList) {
			codestr.append(code+",");
		}
		//推送消息
		JPushParam param = new JPushParam();
		param.setAlert("您好，员工"+userName+"于"+taxidate+"时间参加会议用车（无系统日程），请知晓");// 消息弹出的内容
		param.setContent("您好，员工"+userName+"于"+taxidate+"时间参加会议用车（无系统日程），请知晓");
		param.setUserIds(codestr.substring(0, codestr.length()-1));
		// 链接类型 0：无链接 1：外部链接 2：内部链接 3:消息反馈 4:意见反馈
		param.setLinktype(2);
		param.getExtras().put("toNews", "true");
		param.setLinkaddr("app_package/doc/index.html");
		try {
			List<PushMessageVO>  addVOList = new ArrayList<PushMessageVO>();
			for(String temp : userIdList){
				PushMessageVO pushmessagevo = new PushMessageVO();
				pushmessagevo.setDept(Integer.valueOf("123"));
				pushmessagevo.setUserid(temp);
				pushmessagevo.setState("0");
				pushmessagevo.setMessage("您好，员工"+userName+"于"+taxidate+"时间参加会议用车（无系统日程），请知晓");// 消息弹出的内容
				pushmessagevo.setMsgtitle("参加会议通知");
				addVOList.add(pushmessagevo);
				String str = sendWechartOfficialService.sendWechartOfficial("参加会议通知："+"您好，员工"+userName+"于"+taxidate+"时间参加会议用车（无系统日程），请知晓",temp);
				logger.info("您好，员工"+userName+"于"+taxidate+"时间参加会议用车（无系统日程），请知晓"+temp);
				logger.info("企业微信发送结果>>>>>>" + str);
			}
			
			addmessageservice.insertRemind(addVOList);
			
			//jPushNewService.pushByUserIds(param);
		} catch (Exception e) {
			logger.info("滴滴其他公务推送消息异常>>>>>>>>>" + e.getMessage());
		}
	}
	
	
	/**
	 * 其他公务发消息提醒
	 * @param userIdList
	 * @param userName
	 * @param billno 
	 */
	public void sendMessageOther(List<String> userIdList,String userName,String taxidate,String from,String tospace,String billno){
		
		/**
		 * =============================查看消息是否已经推送，生成则不需要重复推送==============================================
		 */
		String msgContent ="您好，收到"+userName+"其他公务打车消息。时间："+taxidate+"， 出发地："+from+"， 目的地："+tospace+"，请审核。"+"订单号："+billno;
		List<PushMessageVO> list = addmessageservice.queryMsgByContent(msgContent);
		if(list!=null&&list.size()>0){
			return;
		}
		//===============================查看消息是否已经推送，生成则不需要重复推送================================================
		
		//根据工号推送预算临近预警提示消息
		StringBuffer codestr = new StringBuffer();
		for (String code : userIdList) {
			codestr.append(code+",");
		}
		//推送消息
		JPushParam param = new JPushParam();
		param.setAlert(msgContent);// 消息弹出的内容
		param.setContent(msgContent);
		param.setUserIds(codestr.substring(0, codestr.length()-1));
		// 链接类型 0：无链接 1：外部链接 2：内部链接 3:消息反馈 4:意见反馈
		param.setLinktype(2);
		param.getExtras().put("toNews", "true");
		param.setLinkaddr("app_package/doc/index.html");
		try {
			List<PushMessageVO>  addVOList = new ArrayList<PushMessageVO>();
			for(String temp : userIdList){
				PushMessageVO pushmessagevo = new PushMessageVO();
				pushmessagevo.setDept(Integer.valueOf("123"));
				pushmessagevo.setUserid(temp);
				pushmessagevo.setState("0");
				pushmessagevo.setMessage(msgContent);// 消息弹出的内容
				pushmessagevo.setMsgtitle("其他公务订单审核通知：");
				addVOList.add(pushmessagevo);
				String str = sendWechartOfficialService.sendWechartOfficial("其他公务订单审核通知："+msgContent,temp);
				logger.info(msgContent+temp);
				logger.info("企业微信发送结果>>>>>>" + str);
			}
			
			addmessageservice.insertRemind(addVOList);
			
			//jPushNewService.pushByUserIds(param);
		} catch (Exception e) {
			logger.info("滴滴其他公务推送消息异常>>>>>>>>>" + e.getMessage());
		}
	}
	/**
	 * 新增其他公务审核
	 */
	public int insertOtherEntity(DidiOrderEntity entity1){
		logger.info(" 新增其他公务审核开始>>>>>>>>>");
		OtherOffDutiesEntity otherEntity = new OtherOffDutiesEntity();
		otherEntity.setUserId(entity1.getEmployeeno());//用户ID
		otherEntity.setUserName(entity1.getName());//用户姓名
		logger.info(" 新增其他公务审核：调用获取用户头像接口>>>>>>>>>");
		List<EmployeeVO> employeeList = externalMethodService.getEmpInfolist(entity1.getEmployeeno());
		logger.info(" 新增其他公务审核：调用获取用户头像接口>>>>>>>>>完成",employeeList);
		if(employeeList != null && employeeList.size()>0){
			otherEntity.setUserPic(employeeList.get(0).getHeadPhoto());//用户头像
		}
		
		if(entity1.getDept().equals("任职资格服务组")){
			otherEntity.setLeadernum("106154");//直属上级工号
			otherEntity.setDef3("张欢");
		}else{
			logger.info(" 新增其他公务审核：调用获取直属上级userId>>>>>>>>>");
			EmployeeVO evo = externalMethodService.getLeaderInfo(entity1.getEmployeeno());
			logger.info(" 新增其他公务审核：调用获取直属上级userId完成>>>>>>>>>",evo);
			if(evo != null){
				otherEntity.setLeadernum(evo.getEmpCode());//直属上级工号
				otherEntity.setDef3(evo.getEmpName());
			}
		}
		
		otherEntity.setDept(entity1.getDept());//所属部门
		logger.info(" 新增其他公务审核：组装VO>>>>>>>>>");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ufdate = sdf.format(System.currentTimeMillis());
		otherEntity.setRecordtime(ufdate);//备案时间
		otherEntity.setOrderId(entity1.getBillno());//订单号
		otherEntity.setTaxidate(entity1.getTaxidate());//打车时间
		otherEntity.setFromName(entity1.getFromName());//出发地
		otherEntity.setToName(entity1.getToName());//目的地
		otherEntity.setAmount(String.valueOf(entity1.getTotalPrice()));//金额
//		otherEntity.setRecordpic(recordpic);//备案截图,//图片拆分数组private String[] recordpicArray;
		otherEntity.setRecordstate("0");//审核状态（2因公，1因私,0未审核）
		otherEntity.setDef1(entity1.getNormalDistance()==null?"0":entity1.getNormalDistance());//打车总里程
		otherEntity.setComment("");//批复意见
		otherEntity.setCarremark(entity1.getRemarkinfo());//用车备注（其他公务审核）
		otherEntity.setRemark("其他公务");//用车是由（其他公务）
		logger.info(" 新增其他公务审核>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		int other = otherOffDutiesService.insertOtherMethod(otherEntity);
		logger.info(" 新增其他公务审核结束>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>",other);
		return other;
	}
	
	/**
	 * 新增异常审核
	 */
	public int insertDoubtfulAuditEntity(DidiOrderEntity entity1 , float singleKm , Boolean isornot , Long hour , Long min){
		logger.info(" 新增疑似异常审核开始>>>>>>>>>");
		AbnormalOrderEntity aoentity = new AbnormalOrderEntity();
		int aoe =-1;
		try {
			EmployeeVO empVo = externalMethodService.getEmpInfo(entity1.getEmployeeno());
		      //异常审核不包括band10及以上
		      boolean isSeniorLeader =  (empVo.getJobLevel().compareTo("10") != -1 && empVo.getJobGroups().equals("管理族群"))||
		                           empVo.getJobName().contains("秘书") || empVo.getJobName().contains("总裁助理");
		   if(isSeniorLeader == false){
			
			aoentity.setUserId(entity1.getEmployeeno());//用户ID
			aoentity.setUserName(entity1.getName());//用户姓名
			logger.info(" 新增疑似异常审核：调用获取用户头像接口>>>>>>>>>");
			List<EmployeeVO> employeeList = externalMethodService.getEmpInfolist(entity1.getEmployeeno());
			logger.info(" 新增疑似异常审核：调用获取用户头像接口>>>>>>>>>完成",employeeList);
			if(employeeList != null && employeeList.size()>0){
				aoentity.setUserPic(employeeList.get(0).getHeadPhoto());//用户头像
			}
			logger.info(" 新增疑似异常审核：调用获取直属上级userId>>>>>>>>>");
			EmployeeVO evo = externalMethodService.getLeaderInfo(entity1.getEmployeeno());
			logger.info(" 新增疑似异常审核：调用获取直属上级userId完成>>>>>>>>>",evo);
			if(evo != null){
				aoentity.setLeadernum(evo.getEmpCode());//直属上级工号
				aoentity.setDef3(evo.getEmpName());
			}
			if(entity1.getDept().equals("任职资格服务组")){
				aoentity.setLeadernum("106154");//直属上级工号
				aoentity.setDef3("张欢");
			}
			
			
			//查询排班状态添加异常通知
			String stateResult = doubtfulExAuditService.queryScheduleState(entity1.getEmployeeno());
			//查询离职状态工作流添加异常通知
			String dismissState = HttpClientUtil.httpPost(dismissStateUrl,entity1.getEmployeeno());
			JSONObject json = JSONObject.parseObject(dismissState);
			String s = (String) json.get("AUDITSTATECODE");
			
			//前一次打车结束时间跟后一次打车时间间隔在10分钟以内加入疑似异常审核
			//根据工号查询上次打车记录
			DidiOrderEntity lastOrder = didiOrderService.selectLastOrder(entity1.getEmployeeno());
			String lastOfftime = lastOrder.getOfftime();
			String thisBoardingtime = entity1.getBoardingtime();
			boolean b = false;
			if(!"".equals(thisBoardingtime)){
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date d1 = sdf1.parse(lastOfftime);
				Date d2 = sdf1.parse(thisBoardingtime);
				if(d2.getTime()-d1.getTime()<=600000){
					b=true;
				}
			}
			
			
			String aa = "";
			if(entity1.getTotalPrice()>=200){
				aa = aa+"打车大于200元,";
			}
			if(Float.parseFloat(entity1.getNormalDistance())<=1){
				aa = aa+"打车小于1公里,";
			}
			if(singleKm>=7){
				aa = aa+"单公里费用大于7元,";
			}
			if((entity1.getTotalPrice()-entity1.getEstimateprice())>=(entity1.getEstimateprice()*0.2)){
				aa = aa+"实际金额超过预估价的20%,";
			}
			if(isornot == true){
				aa = aa+"含酒店、洗浴、KTV等关键字,";
			}
			if(hour >= 3){
				aa = aa+"打车时长大于3小时,";
			}
			if(min <= 5){
				aa = aa+"打车时长小于5分钟,";
			}if("11".equals(stateResult)||"19".equals(stateResult)||"23".equals(stateResult)||"20".equals(stateResult)){
				aa = aa+"排班状态为：'旷'或'产'或'产检'或'婚',";
			}if("2".equals(s)||"3".equals(s)||"4".equals(s)){
				aa = aa+"离职工作流为审批中或已办结,";
			}if(b==true){
				aa = aa +"前一次打车结束时间跟后一次打车时间间隔在10分钟以内为异常单,";
			}if((Integer.parseInt(entity1.getNormalDistance())*1000-Integer.parseInt(entity1.getEstimateDistance())>=5000)){
				aa = aa +"实际里程超过预估里程5公里以上为异常单,";
			}
			
			aoentity.setErrorrule(aa.substring(0, aa.length()-1));
			
			aoentity.setDept(entity1.getDept());//所属部门
			logger.info(" 新增疑似异常审核：组装VO>>>>>>>>>");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String ufdate = sdf.format(System.currentTimeMillis());
			aoentity.setRecordtime(ufdate);//备案时间
			aoentity.setOrderId(entity1.getBillno());//订单号
			aoentity.setTaxidate(entity1.getTaxidate());//打车时间
			aoentity.setFromName(entity1.getFromName());//出发地
			aoentity.setToName(entity1.getToName());//目的地
			aoentity.setAmount(String.valueOf(entity1.getTotalPrice()));//金额
	//		otherEntity.setRecordpic(recordpic);//备案截图,//图片拆分数组private String[] recordpicArray;
			aoentity.setRecordstate("0");//审核状态（2因公，1因私,0未审核）
			aoentity.setComment("");//批复意见(反馈是由)
			aoentity.setDef1(entity1.getNormalDistance()==null?"0":entity1.getNormalDistance());//打车总里程
			aoentity.setCarremark(entity1.getRemarkinfo());//用车备注（其他公务审核）
			aoentity.setRemark(entity1.getRemark());//用车是由（其他公务）
			aoentity.setMeetingPic(entity1.getMeetingname());//会议图片
			logger.info(" 新增疑似异常审核>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			aoe = doubtfulExAuditService.insertExceptionMethod(aoentity);
			logger.info(" 新增疑似异常审核结束>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>",aoe);
			
			//推送消息
			StringBuffer codestr = new StringBuffer();
			codestr.append(aoentity.getLeadernum());
//			List<String> userIdList = new ArrayList<String>();
//			userIdList.add(aoentity.getLeadernum());
//			for (String code : userIdList) {
//				codestr.append(code+",");
//			}
			//推送消息
			JPushParam param = new JPushParam();
			param.setAlert("您好，员工"+entity1.getName()+"于"+ufdate+"，"+entity1.getRemark()+"用车，系统识别为疑似违规单据，请审核。"+"订单号为:"+entity1.getBillno());// 消息弹出的内容
			param.setContent("您好，员工"+entity1.getName()+"于"+ufdate+"，"+entity1.getRemark()+"用车，系统识别为疑似违规单据，请审核。"+"订单号为:"+entity1.getBillno());
			param.setUserIds(aoentity.getLeadernum());
			// 链接类型 0：无链接 1：外部链接 2：内部链接 3:消息反馈 4:意见反馈
			param.setLinktype(2);
			param.getExtras().put("toNews", "true");
			param.setLinkaddr("app_package/doc/index.html");
			
			StringBuffer codestr1 = new StringBuffer();
			codestr1.append(entity1.getEmployeeno());
			JPushParam paramuser = new JPushParam();
			paramuser.setAlert("您好，您于"+ufdate+""+entity1.getRemark()+"用车，系统识别为疑似违规单据，请联系直属领导反馈。"+"订单号为:"+entity1.getBillno());// 消息弹出的内容
			paramuser.setContent("您好，您于"+ufdate+""+entity1.getRemark()+"用车，系统识别为疑似违规单据，请联系直属领导反馈。"+"订单号为:"+entity1.getBillno());
			paramuser.setUserIds(entity1.getEmployeeno());
			// 链接类型 0：无链接 1：外部链接 2：内部链接 3:消息反馈 4:意见反馈
			paramuser.setLinktype(2);
			paramuser.getExtras().put("toNews", "true");
			paramuser.setLinkaddr("app_package/doc/index.html");
			
			
			List<PushMessageVO>  addVOList1 = new ArrayList<PushMessageVO>();
			PushMessageVO pushmessagevo1 = new PushMessageVO();
			pushmessagevo1.setDept(1);
			pushmessagevo1.setUserid(aoentity.getLeadernum());
			pushmessagevo1.setState("0");
			pushmessagevo1.setMessage("您好，员工"+entity1.getName()+"于"+ufdate+"，"+entity1.getRemark()+"用车，系统识别为疑似违规单据，请审核。"+"订单号为:"+entity1.getBillno());// 消息弹出的内容
			pushmessagevo1.setMsgtitle("疑似违规打车订单审核通知");
			pushmessagevo1.setBillno(entity1.getBillno()); //订单号
			pushmessagevo1.setAbnormalrule(aa.substring(0, aa.length()-1));//异常规则
			addVOList1.add(pushmessagevo1);
			
			
			List<PushMessageVO>  addVOList = new ArrayList<PushMessageVO>();
			PushMessageVO pushmessagevo = new PushMessageVO();
			pushmessagevo.setDept(1);
			pushmessagevo.setUserid(entity1.getEmployeeno());
			pushmessagevo.setState("0");
			pushmessagevo.setMessage("您好，您于"+ufdate+""+entity1.getRemark()+"用车，系统识别为疑似违规单据，请联系直属领导反馈。"+"订单号为:"+entity1.getBillno());// 消息弹出的内容
			pushmessagevo.setMsgtitle("疑似违规打车订单通知");
			pushmessagevo.setBillno(entity1.getBillno()); //订单号
			pushmessagevo.setAbnormalrule(aa.substring(0, aa.length()-1));//异常规则
			addVOList.add(pushmessagevo);
			
			logger.info(" 异常订单推送领导,员工，及新增消息>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>",aoe);
			addmessageservice.insertRemind(addVOList);
			addmessageservice.insertRemind(addVOList1);
			//jPushNewService.pushByUserIds(param);
			//jPushNewService.pushByUserIds(paramuser);
			String str = sendWechartOfficialService.sendWechartOfficial("疑似违规打车订单审核通知："+aa.substring(0, aa.length()-1)+"您好，员工"+entity1.getName()+"于"+ufdate+"，"+entity1.getRemark()+"用车，系统识别为疑似违规单据，请审核。"+"订单号为:"+entity1.getBillno(),aoentity.getLeadernum());
			logger.info("疑似违规打车订单通知："+aa.substring(0, aa.length()-1)+"。"+"您好，员工"+entity1.getName()+"于"+ufdate+"，"+entity1.getRemark()+"用车，系统识别为疑似违规单据，请审核。"+"订单号为:"+entity1.getBillno()+aoentity.getLeadernum());
			logger.info("企业微信发送结果>>>>>>" + str);
			String str2 = sendWechartOfficialService.sendWechartOfficial("疑似违规打车订单通知："+aa.substring(0, aa.length()-1)+"您好，您于"+ufdate+""+entity1.getRemark()+"用车，系统识别为疑似违规单据，请联系直属领导反馈。"+"订单号为:"+entity1.getBillno(),entity1.getEmployeeno());
			logger.info("疑似违规打车订单通知："+aa.substring(0, aa.length()-1)+"。"+"您好，您于"+ufdate+""+entity1.getRemark()+"用车，系统识别为疑似违规单据，请联系直属领导反馈。"+"订单号为:"+entity1.getBillno()+entity1.getEmployeeno());
			logger.info("企业微信发送结果>>>>>>" + str2);
			logger.info(" 异常订单推送领导,员工，及新增消息结束>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>",aoe);
		   }
		} catch (Exception e) {
			logger.info(" 异常订单推送功能异常>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>",e.getMessage());
		} 
				
		return aoe;
		
	}
	/**
	 * @return the externalMethodService
	 */
	public IExternalMethodService getExternalMethodService() {
		return externalMethodService;
	}
	/**
	 * @param externalMethodService the externalMethodService to set
	 */
	public void setExternalMethodService(
			IExternalMethodService externalMethodService) {
		this.externalMethodService = externalMethodService;
	}
	public IOtherOffDutiesService getOtherOffDutiesService() {
		return otherOffDutiesService;
	}
	public void setOtherOffDutiesService(IOtherOffDutiesService otherOffDutiesService) {
		this.otherOffDutiesService = otherOffDutiesService;
	}
	/**
	 * @return the doubtfulExAuditService
	 */
	public IDoubtfulExAuditService getDoubtfulExAuditService() {
		return doubtfulExAuditService;
	}
	/**
	 * @param doubtfulExAuditService the doubtfulExAuditService to set
	 */
	public void setDoubtfulExAuditService(
			IDoubtfulExAuditService doubtfulExAuditService) {
		this.doubtfulExAuditService = doubtfulExAuditService;
	}
	
	/**
	 * @return the neworder_id
	 */
	public long getNeworder_id() {
		return neworder_id;
	}
	/**
	 * @param neworder_id the neworder_id to set
	 */
	public void setNeworder_id(long neworder_id) {
		this.neworder_id = neworder_id;
	}
	@CookieNotCheckedRequired
	public void backString(){
		List<DidiTicketEntity> entityList = didiTicketService.queryByFlag(userId);
		logger.info(" 订单个人出发回调失效的订单>>>>>>>>>>>>>>>>>",entityList);
		if(entityList != null){
			for(DidiTicketEntity temp : entityList){
				setOrder_id(Long.valueOf(temp.getOrderId()));
				runable();
			}
		}
	}
	
	@CookieNotCheckedRequired
	public void deleteOrder(){
		JSONObject jonum = new JSONObject();
		DidiOrderEntity entity = new DidiOrderEntity();
		entity.setBillno(order_id+"");
		DidiOrderEntity entity1 = didiOrderService.find(entity);
		didiOrderService.deleteBatch(entity1.getId()+"");
		jonum.put("msg", "success");
		writeToPage(jonum);
	}
	
	@CookieNotCheckedRequired
	public void orderTimeOutMethord(){
		JSONObject jonum = new JSONObject();
		DidiOrderEntity entity = new DidiOrderEntity();
		DidiOrderEntity entity1 = null;
		entity.setBillno(order_id+"");
		entity1 = didiOrderService.find(entity);
		String id="";
		id = order_id+"";
		logger.info("返回超时订单信息开始>>>>>>>>>>>>>>>>>",id);
		if(entity1 != null && entity1.getSub_status()==3101){//订单超时
			DDOrderRequestEntity ddorderrequestentity = new DDOrderRequestEntity();
			ddorderrequestentity.setBillno(id);
			ddorderrequestentity.setName(entity1.getName());
			ddorderrequestentity.setEmployeeno(entity1.getEmployeeno());
			ddorderrequestentity.setModels(entity1.getModels());
			ddorderrequestentity.setFromName(entity1.getFromName());
			ddorderrequestentity.setToName(entity1.getToName());
			ddorderrequestentity.setTaxidate(entity1.getTaxidate());
			ddorderrequestentity.setBoardingtime(entity1.getBoardingtime());
			ddorderrequestentity.setOfftime(entity1.getOfftime());
			ddorderrequestentity.setOrderstatus(entity1.getOrderstatus());
			ddorderrequestentity.setSub_status(entity1.getSub_status());
			ddorderrequestentity.setNormalDistance(entity1.getNormalDistance());
			ddorderrequestentity.setTotalPrice(new BigDecimal(entity1.getBillno()));
			ddorderrequestentity.setDept(entity1.getDept());
			ddorderrequestentity.setFinancedept(entity1.getFinancedept());
			ddorderrequestentity.setEstimateAmount(new BigDecimal(entity1.getEstimateprice()));
			logger.info("超时订单信息>>>>>>>>>>>>>>>>>",ddorderrequestentity);
			occupyBudgetService.noRespCertif(ddorderrequestentity);
			jonum.put("id", id);
			jonum.put("msg", "success");
			jonum.put("return", "操作成功");
		}else{
			jonum.put("msg", "success");
			jonum.put("return", "不是超时订单或数据库无此单号记录");
		}
		writeToPage(jonum);
	}
	
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public ISendWechartOfficialService getSendWechartOfficialService() {
		return sendWechartOfficialService;
	}

	public void setSendWechartOfficialService(
			ISendWechartOfficialService sendWechartOfficialService) {
		this.sendWechartOfficialService = sendWechartOfficialService;
	}

	public String getDismissStateUrl() {
		return dismissStateUrl;
	}

	public void setDismissStateUrl(String dismissStateUrl) {
		this.dismissStateUrl = dismissStateUrl;
	}

	
	
}

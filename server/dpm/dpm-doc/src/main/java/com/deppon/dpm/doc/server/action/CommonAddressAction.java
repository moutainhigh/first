package com.deppon.dpm.doc.server.action;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.deppon.dpm.doc.server.service.ICommonAddressService;
import com.deppon.dpm.doc.server.util.DESHelper;
import com.deppon.dpm.doc.server.util.HttpClientUtil;
import com.deppon.dpm.doc.server.vo.DidiTicketItemVO;
import com.deppon.dpm.doc.server.vo.DidiTicketResultVO;
import com.deppon.dpm.doc.server.vo.DidiTicketVO;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;

/**
 * @ClassName:CommonAddressAction
 * @Desciption:TODO
 * @author 吕德富
 * @date:2018年3月23日15:33:40
 */
public class CommonAddressAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6772852618467562293L;
	/**
	 * 
	 */
	private static final Logger logger = LoggerFactory.getLogger(CommonAddressAction.class);
	/**
	 * 构造方法
	 */
	public CommonAddressAction() {
		
	}	
	
	/**
	 * 注入service
	 */
	private ICommonAddressService commonAddressService;
	
	/**
	 * 滴滴client_id
	 */
	private String didi_client_id;
	
	/**
	 * 滴滴client_secret
	 */
	private String didi_client_secret;
	
	/**
	 * 滴滴的接口地址
	 */
	private String didi_didiurl;
	
	/**
	 * 滴滴公共电话
	 */
	private String didi_pubiphone;
	
	/**
	 * 滴滴key
	 */
	private String didi_key;
	
	private String phone;

	
	
	/**
	 * @Desciption:TODO(查询常用地址)
	 * @date:2018年3月23日15:51:49
	 * @author 吕德富
	 */
	@CookieNotCheckedRequired
	public void queryAddress(){
		logger.info("didi_查询滴滴常用地址开始>>>>>>>>>");
		logger.info("开始获取滴滴常用地址》》》》》》》》》》》");
		logger.info("组装获取地址VO开始》》》》》》》》》》》");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("errno", 0);
		resultMap.put("errmsg", "SUCCESS");
		String result = "";
		try {
			DidiTicketItemVO itemvo = new DidiTicketItemVO();
			itemvo.setClient_id(didi_client_id);
			itemvo.setClient_secret(didi_client_secret);// 申请应用时分配的client_secret
			itemvo.setMaster_phone(didi_pubiphone);// 管理员手机号（作为统一叫车人）
			itemvo.setPassenger_phone(phone);// 乘客手机号(当前用户)
			itemvo.setAuth_type(0);// 授权类型：0-非发单（无发单权限）；1-发单（有发单权限及其他所有权限）	
			String data = DESHelper.encrypt(JSON.toJSONString(itemvo,
					SerializerFeature.WriteNullStringAsEmpty), didi_key
					.substring(0, 8));
			DidiTicketVO vo = new DidiTicketVO();
			vo.setClient_id(didi_client_id);
			vo.setData_encode(data);
			logger.info("组装获取地址VO结束》》》》》》》》》》》");
			// IHttpClient httpClient = NetUtil.fetchHttpClient();
			String url = didi_didiurl + "ticket/fetch";
			String json = JSON.toJSONString(vo,
					SerializerFeature.WriteNullStringAsEmpty);
			Pattern p = Pattern.compile("\r|\n");
			Matcher m = p.matcher(json);
			json = m.replaceAll("");
			logger.info("组装滴滴常用地址请求参数》》》》》》》》》》》" + json);
			
			result = HttpClientUtil.httpPost(url, json);
			DidiTicketResultVO resultvo = JSON.parseObject(result,DidiTicketResultVO.class);
			Map<String, Object> map = JSON.parseObject(resultvo.getData().toString(), Map.class);
			/*String webapp = "open.es.xiaojukeji.com/webapp/home/commonAddr/home?client_id="
					+ didi_client_id + "&ticket=" + map.get("ticket");*/
			String webapp = "open.es.xiaojukeji.com/webapp/home/index?"
					+ "ticket=" + map.get("ticket") + "&client_id=" + didi_client_id + "&jumpPage=commonAddr&errpage=0";
			resultMap.put("url", webapp);
		} catch (Exception e) {
//			resultMap.put("url", result);
			resultMap.put("errno", 1);
			resultMap.put("errmsg", e.getMessage());
		}
		writeToPage(resultMap);
	}

	public String getDidi_client_id() {
		return didi_client_id;
	}

	public void setDidi_client_id(String didi_client_id) {
		this.didi_client_id = didi_client_id;
	}

	public String getDidi_didiurl() {
		return didi_didiurl;
	}

	public void setDidi_didiurl(String didi_didiurl) {
		this.didi_didiurl = didi_didiurl;
	}

	public String getDidi_client_secret() {
		return didi_client_secret;
	}

	public void setDidi_client_secret(String didi_client_secret) {
		this.didi_client_secret = didi_client_secret;
	}

	public String getDidi_pubiphone() {
		return didi_pubiphone;
	}

	public void setDidi_pubiphone(String didi_pubiphone) {
		this.didi_pubiphone = didi_pubiphone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public ICommonAddressService getCommonAddressService() {
		return commonAddressService;
	}

	public void setCommonAddressService(ICommonAddressService commonAddressService) {
		this.commonAddressService = commonAddressService;
	}

	public String getDidi_key() {
		return didi_key;
	}

	public void setDidi_key(String didi_key) {
		this.didi_key = didi_key;
	}
}

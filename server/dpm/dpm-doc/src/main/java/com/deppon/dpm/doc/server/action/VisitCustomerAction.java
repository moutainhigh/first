package com.deppon.dpm.doc.server.action;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.deppon.dpm.doc.server.entity.Customer2DphxRequestEntity;
import com.deppon.dpm.doc.server.service.IVisitCustomerService;
import com.deppon.dpm.doc.server.util.HttpClientUtil;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
/**
 * @className:VisitCustomerAction
 * @author lvdf
 * @date:2018年3月6日16:35:46
 * @Desciption:TODO(拜访客户接口)
 */
public class VisitCustomerAction extends BaseAction{

	
	private static final long serialVersionUID = -1736732639378451048L;
	
	//老用户电话
	private String phoneNumber;
	
	//注入客户service
	private IVisitCustomerService visitCustomerService;

	//员工信息CRM接口地址
	private String employeeUrl;

	//新客户姓名
	private String userName;
	
	/**
	 * @Desciption:TODOD(老客户拜访,调用CRM接口)
	 * @date:2018年3月7日13:51:14
	 * @author lvdf
	 */
	public void  visitOldCustomer(){
		JSONObject jsonObject = new JSONObject();
		if(StringUtils.isNotEmpty(phoneNumber)){
			//请求参数实体
			Customer2DphxRequestEntity queryEntity = new Customer2DphxRequestEntity();
			queryEntity.setTel(phoneNumber);	
			try {
				//转成json字符串
				String json = JSON.toJSONString(queryEntity,SerializerFeature.WriteNullStringAsEmpty);
				// 替换掉特殊字符
				Pattern p1 = Pattern.compile("\r|\n");
				Matcher m1 = p1.matcher(json);
				json = m1.replaceAll("");
				String queryresults = HttpClientUtil.httpPost(employeeUrl,json);
				//得到返回参数实体
//				Customer2DphxResponseEntity customer2DphxResponseEntity = JSON.parseObject(queryresults, Customer2DphxResponseEntity.class);
				JSONObject result = JSONObject.parseObject(queryresults).getJSONObject("iMember");
				jsonObject.put("result", result);
				writeToPage(jsonObject);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			jsonObject.put("msg", "电话号不能为空");
		}
	}
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public IVisitCustomerService getVisitCustomerService() {
		return visitCustomerService;
	}


	public void setVisitCustomerService(IVisitCustomerService visitCustomerService) {
		this.visitCustomerService = visitCustomerService;
	}


	public String getEmployeeUrl() {
		return employeeUrl;
	}


	public void setEmployeeUrl(String employeeUrl) {
		this.employeeUrl = employeeUrl;
	}




	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}
}

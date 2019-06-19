package com.deppon.dpm.doc.server.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.doc.server.service.IPersonalCenterService;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.service.impl.RedisService;
import com.deppon.dpm.module.common.server.util.ParamUtils;
import com.deppon.dpm.module.common.shared.vo.EmployeeEntity;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.vo.Result;

/**
 * 个人中心
 * 
 * @author gwl
 * 
 */

public class PersonalCenterAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory
			.getLogger(PersonalCenterAction.class);
	private IPersonalCenterService personalCenterService;
	private String userTel;
	private RedisService redisService;
	/**
	 * 验证码
	 */
	private String smsCode;

	/**
	 * 构造方法
	 */
	public PersonalCenterAction() {
		super();
	}

	/**
	 * 个人中心查询个人信息
	 */
	public void getQueryTel() {
		JSONObject jsonObject = new JSONObject(); 
		
		if (userId == null || userId.length() < 1 || ParamUtils.checkUserId(userId)) {// 工号为空或者格式错误
			jsonObject.put("msg", "0");// 返回信息，0为失败，1为成功
			jsonObject.put("usertel", "0");// usertel为空，返回0
			LOG.info(userId+"查询个人信息异常，传参不正确》》》》》》》》"+jsonObject.toString());
			writeToPage(jsonObject);
			return;
		} else {
			// 调用接口查询方法根据ID查询电话号码并返回
			EmployeeEntity empentity = personalCenterService.queryPersonIDByID(userId);
			if (empentity != null && !"".equals(empentity.getMobileNo().trim())) {
				String usertel = empentity.getMobileNo();
				if (usertel != null) {
					//查询绑定了相同手机号的工号
					List<String> telUser = personalCenterService.getTelCount(usertel);
					if(telUser.size() > 1){
						//遍历工号，看该手机号是否是该工号在使用的手机号
						for(String tuserid : telUser){
							if(!tuserid.equals(userId)){//如果存在不同于当前工号的工号
								EmployeeEntity emp = personalCenterService.queryPersonIDByID(tuserid);
								if(emp.getMobileNo().equals(usertel)){
									jsonObject.put("msg", "2");
									jsonObject.put("usertel", usertel.toString());
									LOG.info(userId+"个人中心查询个人信息getQueryTel:"+jsonObject.toJSONString());
									writeToPage(jsonObject);
									return;
								}
							}
						}
						jsonObject.put("msg", "1");
						jsonObject.put("usertel", usertel.toString());
					}else{
						jsonObject.put("msg", "1");
						jsonObject.put("usertel", usertel.toString());
					}
				} else {
					jsonObject.put("msg", "0");
					jsonObject.put("usertel", "0");
				}
			} else {//如果根据工号查询不到欢行绑定的手机号，就查询OA手机号
				String tel = personalCenterService.getOaTel(userId);
				if(tel != null && tel.length() != 0){
					personalCenterService.insert(userId, tel);
					jsonObject.put("usertel", tel);
				}else{//如果OA手机号也没有，则默认设置为10000000000
					personalCenterService.insert(userId, "10000000000");
					jsonObject.put("usertel", "10000000000");
				}
				jsonObject.put("msg", "1");
			}
		}
		LOG.info(userId+"个人中心查询个人信息getQueryTel:"+jsonObject.toJSONString());
		// 返回页面数据
		writeToPage(jsonObject);
	}

	// /**
	// * 新增个人信息
	// */
	// @CookieNotCheckedRequired
	// public void addPersonalc() {
	// JSONObject jsonObject = new JSONObject();
	// if (userId == null || userId.length() < 1) {// 参数为空
	// jsonObject.put("msg", "0");// 返回信息，0为失败，1为成功
	// } else {
	// //调用接口新增方法根据新增个人信息
	// int aa = personalCenterService.insert(userId,userTel);
	// if(aa ==1){
	// jsonObject.put("msg", "1");// 成功
	// }else{
	// jsonObject.put("msg", "0");// 失敗
	// }
	// }
	// // 返回页面数据
	// writeToPage(jsonObject);
	// LOG.debug("success");
	// // outMessage(jsonObject);
	// }

	/**
	 * 更新个人信息
	 */
	@CookieNotCheckedRequired
	public void OperationPersonalc() {
		
		Result<Object> result = new Result<Object>();//修漏洞添加
		if(ParamUtils.checkUserId(userId)){
			   result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			   // errorMessage
			   result.setErrorMessage("工号错误，不符合规范");
			   writeToPage(result);
			   return;
			  }
		
		JSONObject jsonObject = new JSONObject();
		String code = redisService.get(RedisService.DPM_SMS_DIDI_DOC_KEY+userTel);
		if(code==null){
			jsonObject.put("error", "1");//
			jsonObject.put("msg", "验证码已过期，请重新获取");// 失败
			writeToPage(jsonObject);
			return;
		}
		if(!smsCode.equals(code)){
			jsonObject.put("error", "1");//
			jsonObject.put("msg", "验证码错误");// 失败
			writeToPage(jsonObject);
			return;
		}
//		boolean flag = validSms();
//		if(!flag){
//			jsonObject.put("error", "1");//
//			jsonObject.put("msg", "验证码错误");// 失败
//			writeToPage(jsonObject);
//			return;
//		}
		int aa = personalCenterService.OperationPersonalc(userId, userTel);
		if (aa == 1) {
			jsonObject.put("error", "0");// 成功
			jsonObject.put("msg", "1");// 成功
		} else {
			LOG.debug("更新个人信息异常》》》》》》》》");
			jsonObject.put("error", "1");//
			jsonObject.put("msg", "验证码错误");// 失败
		}
		// 返回页面数据
		writeToPage(jsonObject);
		LOG.debug("操作个人信息success");
	}
	/**
	 * 更新个人信息
	 */
	@CookieNotCheckedRequired
	public void OperationPersonalc1() {
		JSONObject jsonObject = new JSONObject();
		
		Result<Object> result = new Result<Object>();//修漏洞添加
		if(ParamUtils.checkUserId(userId)){
		   result.setErrorCode(Constants.ACTION_RESULT_ERROR);
		   // errorMessage
		   result.setErrorMessage("工号错误，不符合规范");
		   writeToPage(result);
		   return;
		}
		//----------2019-04-10 requirement start-----------------
		//添加输入电话号码校验，以及提示重复人工号
		if(userTel == null || !userTel.matches("^\\d{11}$")){
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("电话号码格式错误,请重新输入!");
			writeToPage(result);
			return;
		}
		//给原来的号码设置为10000000000不用校验重复
		if(!"1000000000".equalsIgnoreCase(userTel)){
			List<String> userIds = personalCenterService.getTelCount(userTel);
			if(userIds != null){
				userIds.removeAll(Arrays.asList(userId));
				if(!userIds.isEmpty()){
					List<String> tempUsers = new ArrayList<String>();
					for (int i = 0; i < userIds.size(); i++) {
						if(!userId.equalsIgnoreCase(userIds.get(i))){
							EmployeeEntity entity = personalCenterService.queryPersonIDByID(userIds.get(i));
							if(userTel != null && entity != null && userTel.equalsIgnoreCase(entity.getMobileNo())){
								tempUsers.add(userIds.get(i));
							}
						}
					}
					if(!tempUsers.isEmpty()){
						StringBuilder users = new StringBuilder();
						for (int i = 0; i < tempUsers.size(); i++) {
							users.append(tempUsers.get(i));
							if(tempUsers.size() <= 1 || i==tempUsers.size()-1){
								continue;
							}
							users.append(",");
						}
						result.setErrorCode(Constants.ACTION_RESULT_ERROR);
						// errorMessage
						result.setErrorMessage("该电话号码"+userTel+"重复!(相关工号:"+users.toString()+")");
						writeToPage(result);
						return;
					}
				}
			}
		}
		//-----------------2019-04-10 requirement end------------------
		int aa = personalCenterService.OperationPersonalc(userId, userTel);
		if (aa == 1) {
			jsonObject.put("errorCode", "0");// 成功
			jsonObject.put("msg", "1");// 成功
		} else {
			LOG.debug("更新个人信息异常》》》》》》》》");
			jsonObject.put("errorCode", "1");//
			jsonObject.put("msg", "0");// 失败
		}
		// 返回页面数据
		writeToPage(jsonObject);
		LOG.debug("操作个人信息success");
	}
	/**
	 * 获取短信验证码,德邦内部的短信服务器
	 */
	public boolean validSms() {
		// 定义返回类型
		String code = redisService.get(RedisService.DPM_SMS_DIDI_DOC_KEY+userTel);
		if(smsCode.equals(code)){
			return true;
		}else{
			return false;
		}
	}
	
	@CookieNotCheckedRequired
	public void getPersonalContacts(){
		int beginNum = getRecordIndex();
		int totalCount = personalCenterService.getTotalCount(userId,userTel);
		List<Map<String,Object>> list = personalCenterService.getPersonalContacts(userId, userTel,beginNum);
		JSONObject jonum = new JSONObject();
		if(list == null){
			//失败400
			jonum.put("code", 400);
			jonum.put("msg", "null");
			jonum.put("reruestVOlist", 0);
		}else{
			//成功传200
			jonum.put("code", 200);
			jonum.put("msg", "success");
			jonum.put("errorCode", 0);	
			jonum.put("totalnum", totalCount);//返回总页数
			jonum.put("List", list);
		}
		writeToPage(jonum);
	}
	
	private int pageNum;
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	/**
	 * 当前页首条在数据库里的位置
	 * @return
	 */
	public int getRecordIndex() {
		return (pageNum - 1) * 10;
	}
	
	public void setPersonalCenterService(
			IPersonalCenterService personalCenterService) {
		this.personalCenterService = personalCenterService;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	/**
	 * @return the redisService
	 */
	public RedisService getRedisService() {
		return redisService;
	}

	/**
	 * @return the smsCode
	 */
	public String getSmsCode() {
		return smsCode;
	}

	/**
	 * @param redisService the redisService to set
	 */
	public void setRedisService(RedisService redisService) {
		this.redisService = redisService;
	}

	/**
	 * @param smsCode the smsCode to set
	 */
	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}

}

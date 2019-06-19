package com.deppon.dpm.login.server.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import Decoder.BASE64Encoder;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.uums.module.dubbo.server.service.IBasePasswordDubboService;
import com.deppon.uums.module.dubbo.shared.domain.DubboResponseObj;

/**
 * 修改登录密码
 * @author 276344
 *
 */
public class ModifyLoginPasswordService implements IModifyLoginPasswordService {
	
	/**
	 * 日志
	 */
	private static Logger logger  = LoggerFactory.getLogger(ModifyLoginPasswordService.class);
	
	@Autowired
	private IBasePasswordDubboService passwordService;
	/**
	 * 发送验证码
	 * post
	 * http://192.168.68.117:8080/dpm/v1/modifyLoginPassword/send
	 * {"userId":"276344"}
	 */
	@Override
	public Response sendMsm(String request) {
		// TODO Auto-generated method stub
		Result<String> result = new Result<String>();
		try {
			
			String jsonStr = URLDecoder.decode(request.replaceAll("\ufeff", ""),"utf-8");
			//发送短信
			String sendCode = this.send(jsonStr);
			if (sendCode.equals("0")) {
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				result.setErrorMessage("用户不存在");
			}else if (sendCode.equals("1")){
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				result.setErrorMessage("发送成功");
			}else if (sendCode.equals("2")){
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				result.setErrorMessage("发送失败");
			}else if (sendCode.equals("3")){
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				result.setErrorMessage("系统中无用户电话号码");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("modifyPasswordSendError:" + e.toString());
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			result.setErrorMessage(e.toString());	
		}
		result.setCount(1);
		return resultToResponse(result);
	}

	//发送短信
	private String send(String jsonStr){
		JSONObject obj = JSONObject.fromObject(jsonStr);
		//工号
		String userId = obj.getString("userId");
		//因测试环境无法发短信 所以暂时用微信替代  微信：WX  短信：SMS
		DubboResponseObj<Map<String,Object>> result = passwordService.sendMsm("SMS", userId);
		//返回状态   0:用户不存在  1:发送成功 2:发送失败 3:系统中无用户电话号码
		String statusCode = result.getStatusCode();
		System.out.println(statusCode);
		return statusCode;
	}
	
	/**
	 * 修改密码
	 */
	@Override
	public Response modifyPassword(String request) {
		// TODO Auto-generated method stub
		Result<String> result = new Result<String>();
		try {
			String jsonStr = URLDecoder.decode(request.replaceAll("\ufeff", ""),"utf-8");
			//修改密码
			String resultCode = this.modify(jsonStr);
			if (resultCode.equals("100")) {
				result.setErrorCode(Constants.ACTION_RESULT_SUC);
				result.setErrorMessage("修改成功");
			}else if (resultCode.equals("200")){
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				result.setErrorMessage("修改失败");
			}else if (resultCode.equals("300")){
				result.setErrorCode(Constants.ACTION_RESULT_ERROR);
				result.setErrorMessage("密码不符合规则");
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.error("modifyPasswordError:" + e.toString());
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			result.setErrorMessage(e.toString());	
		}
		result.setCount(1);
		return resultToResponse(result);
	}
	
	/**
	 * 修改密码
	 * post
	 * http://192.168.68.117:8080/dpm/v1/modifyLoginPassword/modify
	 * {"userId":"276344","newPassword":"aaaaaa","code":"1234656"}
	 */
	private String modify(String jsonStr) throws UnsupportedEncodingException{

		JSONObject obj = JSONObject.fromObject(jsonStr);
		
		Map<String, String> params = new HashMap<String, String>();
		//系统名称
		String sysName = "DPM";
		//工号
		String userId = obj.getString("userId");
		//新密码 加密的
		String newPassword  = obj.getString("newPassword");
		if(!this.judgePasswordRule(newPassword)){
			return "300";
		}
		newPassword = this.encrypt(newPassword);
		//验证码
		String code = obj.getString("code");
		params.put("sysName", sysName);
		params.put("empcode", userId);
		params.put("newPassword", newPassword);
		params.put("code", code);
		
		
		DubboResponseObj<Map<String,Object>> result = passwordService.updatePassword(params);
		//返回状态 ：100：成功 200：失败
		String statusCode = result.getStatusCode();
		return statusCode;
	}
	
	/**
	 * 密码判断规则  复杂度
	 * @param psw
	 * @return
	 */
	private boolean judgePasswordRule(String psw){
		
		
		//6-16位的可以由！@#%*._以及字母和数字组合(不区分先后顺序)注：可以为6位纯数字或者6位字母或者符号组成。
		//判断密码是否包含数字：包含返回1，不包含返回0
		//int ii = psw.matches("^[a-zA-Z0-9_!@#%*.]{6,16}$") ? 1 : 0;

		//与oa密码规则一至
		//int jj = psw.matches("^(?:(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^A-Za-z0-9]))[a-zA-Z0-9_!@#%*.]{6,20}$") ? 1 : 0;
		
		if (psw.matches("^(?:(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^A-Za-z0-9]))[a-zA-Z0-9@$^!~,.*]{6,20}$")) {
			return true;
		}
		return false;
	}
	
	/**
	 * 封装数据返回给response
	 */
	private Response resultToResponse(Result<String> result) {
		// 即如果返回
		return Response
				.ok()
				// json返回
				.entity(JSON.toJSONString(result))
				// 头消息类型
				.header(HttpHeaders.CONTENT_TYPE,
						MediaType.APPLICATION_JSON + ";charset=UTF-8")
				// 跨域请求处理
				.header("Access-Control-Allow-Origin", "*").build();
	}
	
	/**
	 * UUMS-NEW
	 * 新的密码加密方式 
	 * @param param
	 * @return
	 * @throws UnsupportedEncodingException
	 * 得引入对应jar包 maven依赖sun.misc.BASE64Decoder
	 */
	public static String encrypt(String param) throws UnsupportedEncodingException{
		MessageDigest digest = null;
		String result = null;
		if(param == null){
			return null;
		}
		
		try {
			digest = MessageDigest.getInstance("MD5");
			result = new String(new BASE64Encoder().encode(digest.digest(param.getBytes("UTF-8"))));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}

}

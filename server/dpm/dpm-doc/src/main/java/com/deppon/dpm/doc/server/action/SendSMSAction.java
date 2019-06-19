package com.deppon.dpm.doc.server.action;

import java.io.StringWriter;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang.StringUtils;
import org.apache.cxf.common.util.Base64Utility;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.doc.server.entity.SmsInfo;
import com.deppon.dpm.doc.server.service.IPersonIDService;
import com.deppon.dpm.module.common.server.action.AppToUseTimeMonitorAction;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.service.impl.RedisService;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.management.server.service.IEmailService;
import com.deppon.dpm.module.management.shared.domain.MailSenderInfo;
import com.deppon.dpm.tongxunlu.server.service.IExternalMethodService;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
import com.deppon.dpm.tongxunlu.shared.vo.Result;

/**
 * 发送短信验证码按钮类
 * @author wanc
 * 20171204
 */
public class SendSMSAction extends BaseAction{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	
	
	/**
	 * log
	 */
	private static final Logger LOG = LoggerFactory.getLogger(AppToUseTimeMonitorAction.class);
	/**
	 * 手机号
	 */
	private String phoneno;
	
	/**
	 * 短信服务器地址
	 */
	private String smsUrl;
	/**
	 * 业务类型
	 */
	private String smsMsgType;
	/**
	 * 系统来源
	 */
	private String smsSource;
	private String smsEncrypt;
	private String userId;
	private RedisService redisService;
	
	private String isNewPhone;

	
	public String getIsNewPhone() {
		return isNewPhone;
	}
	public void setIsNewPhone(String isNewPhone) {
		this.isNewPhone = isNewPhone;
	}
	/**
	 * emailService 注入
	 */
	private IEmailService emailService;
	//直属上级信息
	private IExternalMethodService externalMethodService;
	
	//个人信息
	//根据工号查询人员信息
	private IPersonIDService personIDService;
	/**
	 * 发送短信验证码
	 */
	public void sendSMS(){
		// 定义返回类型
		Result<Object> result = new Result<Object>();
		LOG.info("didi_短信验证码校验处理开始");
		LOG.info("didi_发送短信电话"+phoneno);
		// 手机号为空
		if (StringUtils.isEmpty(phoneno)) {
			// 404
			result.setErrorCode(404);
			// 提示信息
			result.setErrorMessage("手机号码为空");
			// 返回前端
			writeToPage(result);
			// 跳出
			return;
		}
		// 正则表达式
		Pattern p = Pattern.compile("\\d{11}");
		// 匹配字段
		Matcher m = p.matcher(phoneno.trim());
		// 不匹配
		if (!m.matches()) {
			// 500
			result.setErrorCode(500);
			// 提示信息
			result.setErrorMessage("手机号码格式不正确");
			// 返回前端
			writeToPage(result);
			// 跳出
			return;
		}
		try {
//			//校验验证是否有效61秒，防止恶意发送短信
//			if(redisService.get(RedisService.DPM_SMS_DIDI_DOC_KEY+phoneno)!=null){
//				result.setErrorCode(500);
//				// 提示信息
//				result.setErrorMessage("短信已发送");
//				writeToPage(result);
//				return;
//			}
			// 发送短信
			LOG.info("didi_短信验证码phoneno:"+phoneno+",didi_短信验证码url:"+smsUrl+",didi_短信验证码smsMsgType:"+smsMsgType
					+",didi_短信验证码smsSource:"+smsSource+",didi_短信验证码smsEncrypt:"+smsEncrypt);
			String code = getValidateCode();//验证码
			redisService.set(RedisService.DPM_SMS_DIDI_DOC_KEY+phoneno, code, 300);
			String sendMessage = null;
			//发送验证码到直属上级邮箱
			List<EmployeeVO> employeeList = externalMethodService.getEmpInfolist(userId);
			MailSenderInfo info = new MailSenderInfo();
//			EmployeeEntity empentity = personalCenterService.queryPersonIDByID(userId);
			if(employeeList != null &&employeeList.size()>0){
				info.setContent("领导好，贵部"+employeeList.get(0).getEmpName()+"（工号："+userId+"）正在修改欢行账号，验证码："+code+"，验证码5分钟内有效，请知晓");
				info.setSubject("德邦欢行账号验证");
			}
//			List<String> toSendAdd = new ArrayList<String>();
			EmployeeVO evo = externalMethodService.getLeaderInfo(userId);
			if(evo != null){
//				toSendAdd.add(evo.getEmailUserName());
//				info.setToAddress(toSendAdd);
//				File file = null;
				if(isNewPhone.equals("false")){
					//发送直属上级邮箱
//					com.deppon.dpm.module.common.shared.vo.Result<Object> resultEmail = emailService.sendEmail(info,userId, file);
//					if(resultEmail.getErrorCode() != 0){
//						resultEmail.setErrorMessage(String.valueOf(resultEmail.getData()));
//						writeToPage(JSON.toJSONString(resultEmail));
//						return;
//					}
					//发送短信
					sendMessage = sendMessage(phoneno, smsUrl,smsMsgType, smsSource, smsEncrypt,code);
				}else{
					//发送短信
					sendMessage = sendMessage(phoneno, smsUrl,smsMsgType, smsSource, smsEncrypt,code);
				}
			}else{
				sendMessage ="验证码发送失败";
			}
			LOG.info("didi_短信验证码发送到"+phoneno+"的结果:"+sendMessage);
			// 前端信息返回
			writeToPage(sendMessage);
		} catch (Exception e) {
			// 错误信息
			LOG.error("didi_短信验证码发送到"+phoneno+"程序错误"+e.getMessage());
			result.setErrorCode(10);
			result.setErrorMessage("didi_短信验证码程序错误"+e.getMessage());
			
		}
		// 前端返回
		writeToPage(result);
	}
	/**
	 * 获取随机数（验证码）
	 * 
	 * @return
	 */
	private static String getValidateCode() {
		// 创建Random对象
		Random random = new Random();
		// 随机生成随机数
		int value = random.nextInt(MagicNumber.NUM899999) + MagicNumber.NUM100000;
		// 返回随机数
		return String.valueOf(value);
	}

	
	/**
	 * 发送短信消息
	 * 
	 * @param phone
	 * @param url
	 * @param msgType
	 * @param msgSource
	 * @param smsEncrypt
	 * @return
	 * @throws Exception
	 */
	public  String sendMessage(String phone, String url, String msgType,
			String msgSource, String smsEncrypt,String code) throws Exception {
		// 创建post方法实例
		PostMethod postMethod = new PostMethod(url);
		// 创建Smsinfo对象
		SmsInfo info = new SmsInfo();
		// 手机号
		info.setMobile(phone);
		// 短信内容
		info.setMsgContent("本次验证码为：" + code
				+ "，验证码有效时间为一分钟");
		// 业务类型
		info.setMsgType(msgType);
		// 系统来源
		info.setMsgSource(msgSource);
		// 唯一标识
		info.setUnionId("YWLX" + UUID.randomUUID().toString());
		// 发送时间
		info.setSendTime(new Timestamp(new Date().getTime()));
		// 服务类型(1、短信、2、语音、3、短信语音)
		info.setServiceType("1");
		// 创建list
		List<SmsInfo> list = new ArrayList<SmsInfo>();
		LOG.info("didi_短信验证码vo"+phone+":"+info.toString());
		// 赋值list
		list.add(info);
		// 创建objectMapper
		ObjectMapper mapper = new ObjectMapper();
		// 创建StringWriter
		StringWriter stringWriter = new StringWriter();
		// 赋值stringWriter
		mapper.writeValue(stringWriter, list);
		// MD5加密
		MessageDigest digestss = MessageDigest.getInstance("MD5");
		String digest = Base64Utility
				.encode(digestss.digest(smsEncrypt.getBytes("UTF-8")));
		// 定义编码类型
		postMethod.getParams().setContentCharset("UTF-8");
		// 将表单的值放入到post方法中
		postMethod.setRequestBody(new NameValuePair[] {
				new NameValuePair("data_digest", digest),
				new NameValuePair("smsInfo", stringWriter.getBuffer()
						.toString()) });
		// 创建httpClient
		HttpClient httpClient = new HttpClient();
		// 使用httpClient发送post请求
		httpClient.executeMethod(postMethod);
		// 创建Result
		Result<Object> result = new Result<Object>();
		// 获取返回值
		String bodyAsString = postMethod.getResponseBodyAsString();
		// 获取resultCode
		String resultCode = (String) JSON.parseObject(bodyAsString).get(
				"resultCode");
		// 返回值赋值到result中
		result.setErrorMessage(bodyAsString);
		// 判断resultCode是否为1000
		if ("1000".equals(resultCode)) {
			// 验证码
			result.setData(true);
		}
		// 赋值result
		result.setErrorCode(Integer.parseInt(resultCode));
		// json转换
		return JSON.toJSONString(result);
	}


	public String getPhoneno() {
		return phoneno;
	}


	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}


	public String getSmsUrl() {
		return smsUrl;
	}


	public void setSmsUrl(String smsUrl) {
		this.smsUrl = smsUrl;
	}


	public String getSmsMsgType() {
		return smsMsgType;
	}


	public void setSmsMsgType(String smsMsgType) {
		this.smsMsgType = smsMsgType;
	}


	public String getSmsSource() {
		return smsSource;
	}


	public void setSmsSource(String smsSource) {
		this.smsSource = smsSource;
	}


	public String getSmsEncrypt() {
		return smsEncrypt;
	}


	public void setSmsEncrypt(String smsEncrypt) {
		this.smsEncrypt = smsEncrypt;
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
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId 要设置的 userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return emailService
	 */
	public IEmailService getEmailService() {
		return emailService;
	}
	/**
	 * @return externalMethodService
	 */
	public IExternalMethodService getExternalMethodService() {
		return externalMethodService;
	}
	/**
	 * @return personIDService
	 */
	public IPersonIDService getPersonIDService() {
		return personIDService;
	}
	/**
	 * @param emailService 要设置的 emailService
	 */
	public void setEmailService(IEmailService emailService) {
		this.emailService = emailService;
	}
	/**
	 * @param externalMethodService 要设置的 externalMethodService
	 */
	public void setExternalMethodService(IExternalMethodService externalMethodService) {
		this.externalMethodService = externalMethodService;
	}
	/**
	 * @param personIDService 要设置的 personIDService
	 */
	public void setPersonIDService(IPersonIDService personIDService) {
		this.personIDService = personIDService;
	}

}

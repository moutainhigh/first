package com.deppon.dpm.login.server.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.login.server.util.SmsSendUtil;
import com.deppon.dpm.module.common.server.dao.IVisitorSmsSendLogDao;
import com.deppon.dpm.module.common.server.util.DESede;
import com.deppon.dpm.module.common.server.util.MagicNumber;
import com.deppon.dpm.module.common.shared.domain.VisitorSmsSendInfo;
import com.deppon.dpm.module.common.shared.vo.Result;

/**
 * 访客系统短信发送接口
 * 
 */
@Path("/visitor")
public class VisitorSmsSendService {

	private static final Logger LOG = LoggerFactory.getLogger(VisitorSmsSendService.class);
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
	/**
	 * 短信秘钥
	 */
	private String smsEncrypt;
	/**
	 * visitorSmsSendLogDao
	 */
	private IVisitorSmsSendLogDao visitorSmsSendLogDao;

	// 请求类型
	@POST
	// 请求地址
	@Path("message")
	// 返回参数类型
	@Produces(MediaType.APPLICATION_JSON)
	public Object sendMessage(String content) {
		// 返回结果集定义
		Result<Object> result = new Result<Object>();
		LOG.info("访客系统短信发送请求参数："+content+"---地址---"+smsUrl);
		// 记录成功条数
		int num = 0;
		// 失败的手机号
		List<String> failList = new ArrayList<String>();
		try {
			// 空判断
			if (StringUtils.isEmpty(content)){
				result.setErrorCode(1);
				result.setResult("短信参数内容为空！");
				LOG.info("访客系统短信参数内容为空："+content);
				// 返回结果
				return resultToResponse(result);
			}
			// 根据密钥解密
			String jsonContent = DESede.decryptContent(content);
			if(jsonContent == null){
				result.setErrorCode(1);
				result.setResult("短信参数解密出错！");
				LOG.info("访客系统短信解密出错："+content);
				// 返回结果
				return resultToResponse(result);
			} 
			// json转换
			List<VisitorSmsSendInfo> list = JSON.parseArray(jsonContent, VisitorSmsSendInfo.class);
			// 空判断
			if (list == null){
				result.setErrorCode(1);
				result.setResult("短信参数Json转换出错!");
				LOG.info("短信参数Json转换出错："+content);
				// 返回结果
				return resultToResponse(result);
			}
			// 短信发送数据处理
			for (VisitorSmsSendInfo info : list) {
				// 保存日志
				VisitorSmsSendInfo infoLog = new VisitorSmsSendInfo();
				int status = 0;
				try {
					// 参数验证
					if(StringUtils.isNotEmpty(info.getSmsPhone())){
						// 正则表达式
						Pattern p = Pattern.compile("\\d{11}");
						// 匹配字段
						Matcher m = p.matcher(info.getSmsPhone().trim());
						if (m.matches()&&StringUtils.isNotEmpty(info.getSmsContent())) {
							// 发送短信
							status = SmsSendUtil.sendVisitorMessage(info.getSmsContent(), info.getSmsPhone(), smsUrl, smsMsgType, smsSource, smsEncrypt);
						}
					}
				} catch (Exception e) {
					LOG.info("访客系统短信-"+JSON.toJSONString(info)+"-发送失败:"+e.getMessage());
				}
				// 保存日志
				infoLog.setSmsPhone(info.getSmsPhone());
				infoLog.setSmsContent(info.getSmsContent());
				infoLog.setSmsStatus(status);
				visitorSmsSendLogDao.saveSmsSendLog(infoLog);
				// 记录成功条数
				if(status == 1){
					num++;
				}else{
					failList.add(info.getSmsPhone());
				}
			}
			result.setCount(num);
			result.setData(failList);
			if(list.size() == num)
				result.setResult("短信发送成功！");
		} catch (Exception e) {
			// 异常保存日志
			VisitorSmsSendInfo infoLog = new VisitorSmsSendInfo();
			infoLog.setSmsContent(dealParm(content,MagicNumber.NUM1800));
			// 记录成功条数
			infoLog.setSmsStatus(num);
			// 失败的手机号
			String failStr = JSON.toJSONString(failList);
			infoLog.setRemark(dealParm(failStr,MagicNumber.NUM200));
			visitorSmsSendLogDao.saveSmsSendLog(infoLog);
			
			// errorCode
			result.setErrorCode(1);
			// result
			result.setResult("短信发送失败！");
			LOG.info("访客系统短信发送失败"+e.getMessage());
		}
		LOG.info("访客系统短信发送接口调用结束");
		// 返回结果
		return resultToResponse(result);
	}
	
	/**
	 * 长度切割
	 * 
	 * @param parm
	 * @param length
	 * @return
	 */
	private String dealParm(String parm,int length){
		if(parm!=null && parm.length() > length){
			parm = parm.substring(0, length);
		}
		// 返回
		return parm;
	}

	/**
	 * 封装数据返回给response
	 */
	private Response resultToResponse(Result<Object> result) {
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
	 * set
	 * @param smsUrl
	 */
	public void setSmsUrl(String smsUrl) {
		this.smsUrl = smsUrl;
	}

	/**
	 * set
	 * @param smsMsgType
	 */
	public void setSmsMsgType(String smsMsgType) {
		this.smsMsgType = smsMsgType;
	}

	/**
	 * set
	 * @param smsSource
	 */
	public void setSmsSource(String smsSource) {
		this.smsSource = smsSource;
	}

	/**
	 * set
	 * @param smsEncrypt
	 */
	public void setSmsEncrypt(String smsEncrypt) {
		this.smsEncrypt = smsEncrypt;
	}

	/**
	 * set
	 * @param visitorSmsSendLogDao
	 */
	public void setVisitorSmsSendLogDao(IVisitorSmsSendLogDao visitorSmsSendLogDao) {
		this.visitorSmsSendLogDao = visitorSmsSendLogDao;
	}

}

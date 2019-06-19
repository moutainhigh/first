package com.deppon.dpm.module.management.server.service.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.service.impl.MySSLProtocolSocketFactory;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.dao.IMailReceiveSendFunctionDao;
import com.deppon.dpm.module.management.server.service.IMailReceiveSendFunctionService;
import com.deppon.dpm.module.management.server.service.ISendReceiveRoomMessNotificationService;
import com.deppon.dpm.module.management.shared.domain.MailReceiveSendFunctionEntity;
import com.deppon.dpm.module.management.shared.domain.MailReceiveSendToPCEntity;
import com.deppon.dpm.module.management.util.Constants;
import com.deppon.foss.framework.exception.BusinessException;

/**
* @ClassName: MailReceiveSendFunctionService
* @Description: MailReceiveSendFunctionService
* @author A18ccms a18ccms_gmail_com
* @date 2016-4-8 下午3:43:15
* 
*/

public class MailReceiveSendFunctionService implements IMailReceiveSendFunctionService{

	/**
	 * 日志
	 */
	Logger log = LoggerFactory.getLogger(MailReceiveSendFunctionService.class);
	//dao层
	private IMailReceiveSendFunctionDao mailReceiveSendFunctionDao;
    //更数据到PC端的地址
	public String mailRecSenUrl;
	//sendReceiveRoomMessNotificationService
    private ISendReceiveRoomMessNotificationService sendReceiveRoomMessNotificationService;
    //get set
	public void setSendReceiveRoomMessNotificationService(
			ISendReceiveRoomMessNotificationService sendReceiveRoomMessNotificationService) {
		this.sendReceiveRoomMessNotificationService = sendReceiveRoomMessNotificationService;
	}
	//get set
	public void setMailRecSenUrl(String mailRecSenUrl) {
		this.mailRecSenUrl = mailRecSenUrl;
	}
	//get set
	public void setMailReceiveSendFunctionDao(
			IMailReceiveSendFunctionDao mailReceiveSendFunctionDao) {
		this.mailReceiveSendFunctionDao = mailReceiveSendFunctionDao;
	}


	/* 更新为签收、拒收状态
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.service.IMailReceiveSendFunctionService#updateRacState(java.lang.String)
	 */
	@Override
	public String updateRecInfo(String str) throws BusinessException, HttpException, IOException {
        
        JSONObject json = JSONObject.parseObject(str);
		log.info("页面传过来的参数为:" + json);
        //代收人领取(1)或自己(0)
		int postStatus = json.getIntValue("postStatus");
		// 包裹状态   签收（1）拒收（2）
		int parcelState = json.getIntValue("parcelState");
		// 用户工号
		String userNo = json.getString("userNo") == null ? "":json.getString("userNo").trim();
		// 用户工号
		String userName = json.getString("userName") == null ? "":json.getString("userName").trim();
		// 包裹id
		long packageId = json.getLongValue("packageId");
		
		//非空判断		
		if(!(parcelState  == 2 || parcelState == 1) ||
				!(postStatus == 0 || postStatus == 1)){
			return "{\"resultFlag\":false,\"failureReason\":\"传入的参数为空或者状态值错误！\"}";
		}
		
		if("".equals(userNo) || "".equals("userName") || packageId<0){
			return "{\"resultFlag\":false,\"failureReason\":\"传入的参数为空！\"}";
		}
		//具体更新方法
		return updateRecState(postStatus,parcelState,userNo,userName,packageId);
	}

	/**
	 * 更新状态 逻辑处理方法
	 * @param parcelState
	 * @param postStatus
	 * @param userNo
	 * @param userName
	 * @param packageId
	 * @return 
	 * @throws BusinessException
	 */
	
	private String updateRecState(int postStatus,int parcelState,String userNo,String userName,long packageId) throws BusinessException, HttpException, IOException {
		int result = -1;
		//更新数据库里的参数
		MailReceiveSendFunctionEntity parBean = new MailReceiveSendFunctionEntity();
		parBean.setPackagesId(packageId);
		parBean.setParcelState(parcelState);
		parBean.setUserNo(userNo);
		parBean.setUserName(userName);
		parBean.setPostStatus(postStatus);
		//toPC参数
		MailReceiveSendToPCEntity parBeanPC = new MailReceiveSendToPCEntity();
		parBeanPC.setPackagesId(packageId);
		parBeanPC.setPersonCode(userNo);
		parBeanPC.setPersonName(userName);
		parBeanPC.setState(parcelState);
		
		
		
		List<MailReceiveSendFunctionEntity> parList = new ArrayList<MailReceiveSendFunctionEntity>();
		parList.add(parBean);
		//往pc推数据
		MailReceiveSendFunctionEntity resultBean = toPcUpdateInfo(parBeanPC);
			
		if(resultBean != null){
		
			if(resultBean.getStatus() > 0){//成功 resultBean.getStatus()==1
				
				//更新本地数据库
				if(parcelState == 1){
					//签收
					//log.info("");
					result = mailReceiveSendFunctionDao.updatePackageNativeRec(parBean);
				}else{
					//拒收
					result = mailReceiveSendFunctionDao.updatePackageOut(parList);
					
				}
				
			}else{//失败 resultBean.getStatus()==0
				if(resultBean.getStatus() == -1){
					mailReceiveSendFunctionDao.updatePackageNativeRec(parBean);
				}
				return "{\"resultFlag\":false,\"failureReason\":\"往PC端更新状态失败!失败原因："+resultBean.getMessage()+"\"}";
			}
			
		}else{
			//pc推送消息失败
			return "{\"resultFlag\":false,\"failureReason\":\"往PC端更新状态失败!\"}";
		}
		//判断result	
		if(result > 0){
			//long a = System.currentTimeMillis();
			log.info("<<<<<<"+"收发室保存消息通知开始");
			try{
				String content = "";
				if(parcelState ==1){
					content = "你的包裹已经被签收，如有疑问，请及时联系收发室，谢谢！";
				}else{
					content = "你的包裹已经拒收，如有疑问，请及时联系收发室，谢谢！";
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String statusTime = format.format(new Date());
				sendReceiveRoomMessNotificationService.saveMesssageToDB(userNo, content, parcelState,statusTime);
			}catch(BusinessException e){
				//捕获异常
				log.info("收发室消息通知保存异常！");
				e.printStackTrace();
			}
			log.info("<<<<<<"+"收发室保存通知结束");
			//log.info("<<<end<<<"+System.currentTimeMillis()+":"+(System.currentTimeMillis()-a));
			return "{\"resultFlag\":true,\"failureReason\":\"恭喜您,本次操作成功！\"}";
		}
		//返回结果
		return "{\"resultFlag\":false,\"failureReason\":\"对不起，本次操作失败,原因：更新本地数据库状态失败\"}";
	}

	/** 往PC端推送数据
	 * @param parBeanPC
	 * @return
	 */
	private MailReceiveSendFunctionEntity toPcUpdateInfo(MailReceiveSendToPCEntity parBeanPC) throws BusinessException, HttpException, IOException{
		Map<String,Object> parMap = new HashMap<String,Object>();
		List<MailReceiveSendToPCEntity> parList = new ArrayList<MailReceiveSendToPCEntity>();
		parList.add(parBeanPC);
		parMap.put("LISTINFO",parList);
		parMap.put("STATE",parBeanPC.getState());
		log.info("《《《《《《pc联调开始《《《《《《");
		//http://10.224.72.106:8081/noa/ws/noaPress/queryPress
		//mailRecSenUrl = "http://10.224.72.106:8081/noa/ws/noaPress/queryPress";
        log.info("mailRecSenUrl"+mailRecSenUrl);
	    String resultStr = requestClient(parMap,mailRecSenUrl,"ESB_DPM2ESB_PARCELSTATUS_RECEIVE2NOA");
	   //String resultStr = "{\"map\":{\"message\":\"success\",\"status\":1}}";
		log.info("<<<<<<<<<pc联调结束<<<<<<<<<");
		log.info("pc端返回参数为："+resultStr);
		JSONObject json = JSONObject.parseObject(resultStr);
		log.info("页面传过来的参数为:" + json);
		//得到resultmap
		String resultmap = json.getString("map");
		//非空的判断
		if(resultmap == null || "".equals(resultmap)){
			return null;
		}
		//json转java对象
		MailReceiveSendFunctionEntity resultBean = JsonUtil.jsonToEntity(resultmap,MailReceiveSendFunctionEntity.class);
        //返回结果
		return resultBean;
	}
	
	/**
	 * <p>
	 * Description:获取Http的客户端
	 * </p>
	 * 
	 * @param param
	 * @param url
	 * @param esbServiceCode
	 * @return
	 * @throws BusinessException
	 * @throws IOException 
	 * @throws HttpException 
	 */
	public String requestClient(Map<String, Object> param, String url,
			String esbServiceCode) throws BusinessException, HttpException, IOException {
		HttpClient hc = new HttpClient();

		// 设置编码格式
		hc.getParams().setContentCharset("UTF-8");

		// 设置超时时间
		HttpConnectionManagerParams managerParams = hc
				.getHttpConnectionManager().getParams();

		// 设置连接超时时间(单位毫秒)
		managerParams.setConnectionTimeout(Constants.HTTP_CON_TIMEOUT);

		// 设置读数据超时时间(单位毫秒)
		managerParams.setSoTimeout(Constants.HTTP_SO_TIMEOUT);
		Protocol myhttps = new Protocol("https",
				new MySSLProtocolSocketFactory(),Constants.HTTP_PROTOCOL);
		Protocol.registerProtocol("https", myhttps);

		// header设置
		Map<String, String> map = new HashMap<String, String>();
		map.put("version", "1.0");
		//编码的设置
		map.put("Content-Type", "application/json;charset=UTF-8");
		map.put("esbServiceCode", esbServiceCode);
		map.put("requestId", UUID.randomUUID().toString());
		map.put("sourceSystem", "DPM");

		// 参数设置
		String paramJson = JsonUtil.mapToJsonString(param);
		String headerJson = JsonUtil.mapToJsonString(map);

		RequestEntity entity = new StringRequestEntity(paramJson,
				"application/json", "UTF-8");
		PostMethod post = new PostMethod(url);
		post.setRequestEntity(entity);
		post.addRequestHeader("Content-Type", "application/json;charset=UTF-8");
		post.addRequestHeader("requestHeaders", headerJson);
        //日志的打印
		log.info("post url ==========>" + url);
		log.info("post paramter ==========>" + param);
		log.info("post header ==========>" + headerJson);

		// 执行postMethod
		hc.executeMethod(post);
        //得到result
		String result = post.getResponseBodyAsString();
		log.info(esbServiceCode + " response data : " + result);
        //返回结果集
		return result;
	}
}

package com.deppon.dpm.module.management.server.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.dao.IMailReceiveSendFunctionDao;
import com.deppon.dpm.module.management.server.service.IMailReceiveSendServiceFunctionService;
import com.deppon.dpm.module.management.server.service.ISendReceiveRoomMessNotificationService;
import com.deppon.dpm.module.management.shared.domain.MailReceiveSendFunctionEntity;
import com.deppon.dpm.module.management.util.Constants;
import com.deppon.foss.framework.exception.BusinessException;

/**
 * @author 274858
 * 
 * 
 *  收发室服务
 */
public class MailReceiveSendServiceFunctionService implements IMailReceiveSendServiceFunctionService{

	/**
	 * 
	 * 日志
	 */
	Logger log = LoggerFactory.getLogger(MailReceiveSendFunctionService.class);
	/**
	 * 
	 * dao层
	 */
	private IMailReceiveSendFunctionDao mailReceiveSendFunctionDao;
	/**
	 * 
	 * 
	 * 消息
	 */
	private ISendReceiveRoomMessNotificationService sendReceiveRoomMessNotificationService;
    
	/**
	 * 
	 * 
	 * @param sendReceiveRoomMessNotificationService
	 */
	public void setSendReceiveRoomMessNotificationService(
			ISendReceiveRoomMessNotificationService sendReceiveRoomMessNotificationService) {
		this.sendReceiveRoomMessNotificationService = sendReceiveRoomMessNotificationService;
	}

	/**
	 * 
	 * 
	 * @param mailReceiveSendFunctionDao
	 */
	public void setMailReceiveSendFunctionDao(
			IMailReceiveSendFunctionDao mailReceiveSendFunctionDao) {
		this.mailReceiveSendFunctionDao = mailReceiveSendFunctionDao;
	}
	
	/**
	 * 
	 * 
	 * 
	 * @return
	 */
	public IMailReceiveSendFunctionDao getMailReceiveSendFunctionDao() {
		return mailReceiveSendFunctionDao;
	}

	/* (non-Javadoc)
	 * //状态值     库存中（0），已签收（1），已拒收（2），已注销（3） ,催领（4）
	 
	 * 
	 * 
	 * 
	 * 
	 * @see com.deppon.dpm.module.management.server.service.IMailReceiveSendServiceFunctionService#updateRecSendState(java.lang.String)
	 */
	@Override
	public Response updateRecSendState(String json) {
		int state = -1;//状态值     库存中（0），已签收（1），已拒收（2），已注销（3） ,催领（4）
	    //更新参数
		List<MailReceiveSendFunctionEntity> parList = new ArrayList<MailReceiveSendFunctionEntity>();
		String re =  "{\"status\":0,\"message\":\"系统异常，更新失败\"}";
		try{
			//json = "{\'LISTINFO\':[{\'packagesId\':123456789,\'personCode\':\'sadfsdaf\',\'personName\':\'sdfdsaf\',\'state\':1}],\'STATE\':1}";
			/*System.out.println("1");*/
			log.info("服务器接受的数据为："+json);
			if(json == null || "".equals(json)){
				re =  "{\"status\":0,\"message\":\"您传入的参数为空\"}";
				return Response.ok(re).header("ESB-ResultCode", "1").build();
			}
			//获取状态
			JSONObject parJson = JSONObject.parseObject(json);
			state = parJson.getIntValue("STATE");
			log.info("状态值(STATE)为："+state);
			if(state<1 || state >Constants.MailRecSen_Corporal){
				re =  "{\"status\":0,\"message\":\"传入的状态值(STATE)只能为1到4，您传入的是"+state+"\"}";
				return Response.ok(re).header("ESB-ResultCode", "1").build();
			}
			//获取参数
			String strList =  parJson.getString("LISTINFO");
			log.info("参数集合(strList)为："+strList);
			if("".equals(strList)){
				re =  "{\"status\":0,\"message\":\"传入的参数集合(strList)为空\"}";
				return Response.ok(re).header("ESB-ResultCode", "1").build();
			}	
		    //反序列化
			parList = JsonUtil.jsonToList(strList,
					MailReceiveSendFunctionEntity.class);
			if(parList.size()<=0){
				re =  "{\"status\":0,\"message\":\"传入的参数为空,反系列化失败\"}";
				return Response.ok(re).header("ESB-ResultCode", "1").build();
			}
			//动作判断,执行不同的功能
			re = checkState(state,parList);
            
            
			/*for(MailReceiveSendFunctionEntity bean:list1){
				System.out.println(bean.toString());
			}
			System.out.println("2");*/
			
			//String re = "{\"status\":1,\"message\":\"Synchronous data success\"}";
			return Response.ok(re).header("ESB-ResultCode", "1").build();
		}catch(Exception e){
			log.error("系统异常，更新失败",e);
			e.printStackTrace();
		}
		
		return Response.ok(re).header("ESB-ResultCode", "1").build();
	}

	
	/**
	 * 动作判断 
	 * @param state
	 * @param parList
	 * @return re
	 * @throws Exception 
	 */
	
	private String checkState(int state,
			List<MailReceiveSendFunctionEntity> parList) throws BusinessException {
		
		//已签收（1）
		if(state==Constants.MailRecSen_Received){
			/*MailReceiveSendFunctionEntity parBean = parList.get(0);
			if(parBean != null){
				result = mailReceiveSendFunctionDao.updatePackageRec(parBean);
				log.info("签收result="+result);
			}*/
			//根据包裹id查询工号
			List<MailReceiveSendFunctionEntity> hisList = mailReceiveSendFunctionDao.selectPackageRec(parList);
	        if(hisList == null || hisList.size()<=0){
	        	log.info("{\"status\":0,\"message\":\"传入的包裹id在数据库没有数据\"}");
	        	return "{\"status\":0,\"message\":\"传入的包裹id在数据库没有数据\"}";
	        }
			boolean resBoolean = updateRecState(parList,hisList);
			log.info("已签收resBoolean:"+resBoolean);
			if(resBoolean){
				//推消息
				toReceived(parList);
        		
				return "{\"status\":1,\"message\":\"数据更新成功\"}";
			}
		    
		}
        
		
		//已拒收（2）
        if(state==Constants.MailRecSen_Logout){
        	int res = mailReceiveSendFunctionDao.updatePackageOut(parList);
        	log.info("已拒收(res)："+res);
        	if(res > 0){
        		/*SendReceiveRoomMessNotificationService mesgSend = 
        				new SendReceiveRoomMessNotificationService();
    			mesgSend.judgmentMessage(parList.get(0).getPackagesId());*/
        		//推消息
        		toMailrecsenLogout(parList);
        		return "{\"status\":1,\"message\":\"数据更新成功\"}";
        	}
		}
        
		//已注销（3） 
        if(state==Constants.MailRecSen_Reject){
        	int res = mailReceiveSendFunctionDao.updatePackageReject(parList);
        	log.info("已注销(res)："+res);
        	if(res > 0){
        		/*SendReceiveRoomMessNotificationService mesgSend = 
        				new SendReceiveRoomMessNotificationService();
    			mesgSend.judgmentMessage(parList.get(0).getPackagesId());*/
        		//推消息
        		toMailRecSenReject(parList);
        		return "{\"status\":1,\"message\":\"数据更新成功\"}";
        	}
		}
        //催领（4）
        if(state==Constants.MailRecSen_Corporal){
        	int res = mailReceiveSendFunctionDao.updatePackageCorporal(parList);
        	log.info("催领(res)："+res);
        	if(res > 0){
        		
        		//推消息
                toMailRecSenCorportal(parList);
                return "{\"status\":1,\"message\":\"数据更新成功\"}";
        	}
		}
        return "{\"status\":0,\"message\":\"数据更新失败\"}";
	}

	public void toMailRecSenCorportal(
			List<MailReceiveSendFunctionEntity> parList) {
		for(MailReceiveSendFunctionEntity parBean:parList){
			log.info("<<<<<<"+"收发室保存消息通知开始");
			try{
				
				sendReceiveRoomMessNotificationService.saveMesssageToDBCorporal(parBean.getPackagesId());
			}catch(Exception e){
				log.info("收发室消息通知保存异常！");
				e.printStackTrace();
			}
			log.info("<<<<<<"+"收发室保存通知结束");
		}
	}

	public void toMailRecSenReject(List<MailReceiveSendFunctionEntity> parList) {
		for(MailReceiveSendFunctionEntity parBean:parList){
			log.info("<<<<<<"+"收发室保存消息通知开始");
			try{
				String content = "你的包裹已经被注销，如有疑问，请及时联系收发室，谢谢！";
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String statusTime = format.format(new Date());
				sendReceiveRoomMessNotificationService.saveMesssageToDB(parBean.getPersonCode(), content,Constants.MailRecSen_Reject,statusTime);
			}catch(Exception e){
				log.info("收发室消息通知保存异常！");
				e.printStackTrace();
			}
			log.info("<<<<<<"+"收发室保存通知结束");
		}
	}

	public void toMailrecsenLogout(List<MailReceiveSendFunctionEntity> parList) {
		for(MailReceiveSendFunctionEntity parBean:parList){
			
			log.info("<<<<<<"+"收发室保存消息通知开始");
			try{
				String content = "你的包裹已经被拒收，如有疑问，请及时联系收发室，谢谢！";
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String statusTime = format.format(new Date());
				sendReceiveRoomMessNotificationService.saveMesssageToDB(parBean.getPersonCode(), content,Constants.MailRecSen_Logout,statusTime);
			}catch(Exception e){
				log.info("收发室消息通知保存异常！");
				e.printStackTrace();
			}
			log.info("<<<<<<"+"收发室保存通知结束");

			
		}
	}

	public void toReceived(List<MailReceiveSendFunctionEntity> parList) {
		for(MailReceiveSendFunctionEntity parBean:parList){
			
			log.info("<<<<<<"+"收发室保存消息通知开始");
			try{
				String content = "你的包裹已经被签收，如有疑问，请及时联系收发室，谢谢！";
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String statusTime = format.format(new Date());
				sendReceiveRoomMessNotificationService.saveMesssageToDB(parBean.getPersonCode(), content,1,statusTime);
			}catch(Exception e){
				log.info("收发室消息通知保存异常！");
				e.printStackTrace();
			}
			log.info("<<<<<<"+"收发室保存通知结束");
			
			
		}
	}

	/**
	 * 具体签收方法
	 * @param parList
	 * @return
	 */
	private boolean updateRecState(List<MailReceiveSendFunctionEntity> parList,
			List<MailReceiveSendFunctionEntity> hisList) throws BusinessException{
		//自己签收
		List<MailReceiveSendFunctionEntity> oneself = new ArrayList<MailReceiveSendFunctionEntity>();
		//代签
		List<MailReceiveSendFunctionEntity> unOneself = new ArrayList<MailReceiveSendFunctionEntity>();
		
		
		for(MailReceiveSendFunctionEntity parBean:parList){
			
		    //获取工号和包裹id
        	long packId = parBean.getPackagesId();
        	String parUserNo = parBean.getPersonCode().trim();
        	//循环历史数据
        	for(MailReceiveSendFunctionEntity hisBean:hisList){
        		long hisPckId = hisBean.getPackagesId();
        		//寻找参数id和历史id
        		if(packId == hisPckId){
        			//判断工号是否相等
        			if(parUserNo != null && !"".equals(parUserNo) 
        					&& parUserNo.equals(hisBean.getPersonCode().trim())){
        				oneself.add(parBean);//自己签收
        			}else{
        				unOneself.add(parBean);//别人签收
        			}
        			
        			break;
        		}
        	}
        	
        }
		int resOneself = -1;
		int resUnself = -1;
		log.info("oneself.size()="+oneself.size());
		log.info("unOneself.size()="+unOneself.size());
		//SendReceiveRoomMessNotificationService mesgSend = new SendReceiveRoomMessNotificationService();
		if(oneself.size()>0){
			//更新为签收状态
			resOneself = mailReceiveSendFunctionDao.updatePackageRec(oneself);
			log.info("resOneself:"+resOneself);
		}
		if(unOneself.size()>0){
			//更新为签收状态
			int resUnState = mailReceiveSendFunctionDao.updateUnOneself(unOneself);
			log.info("resUnState:"+resUnState);
			if(resUnState>0){
				//插入代签收人
				resUnself = mailReceiveSendFunctionDao.insertUnUser(unOneself);
				log.info("resUnself:"+resUnself);
			}
		
		}
		/*if(resOneself > 0 || resUnself > 0){
			//推消息
    		SendReceiveRoomMessNotificationService msgSend = 
    				new SendReceiveRoomMessNotificationService();
			msgSend.judgmentMessage(parList.get(0).getPackagesId());
			return true;
		}else{
			return false;
		}*/
		return (resOneself > 0 || resUnself > 0) ? true:false;
				
	}

	
}

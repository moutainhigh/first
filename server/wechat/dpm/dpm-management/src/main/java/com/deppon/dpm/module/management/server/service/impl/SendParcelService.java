package com.deppon.dpm.module.management.server.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.deppon.ar.bamp.common.util.DateUtil;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.dao.ISendParcelDao;
import com.deppon.dpm.module.management.server.service.ISendParcelService;
import com.deppon.dpm.module.management.server.service.ISendReceiveRoomMessNotificationService;
import com.deppon.dpm.module.management.shared.domain.ParcelDataEntity;
import com.deppon.dpm.module.management.shared.domain.ParcelEntity;

/**
 * 
 * @author 王亚男
 *
 */
public class SendParcelService implements ISendParcelService {
    //dao 的注入
	private ISendParcelDao sendParcelDao;
	//sendReceiveRoomMessNotificationService
	private ISendReceiveRoomMessNotificationService sendReceiveRoomMessNotificationService;
	//日志
	private static Logger logger = Logger.getLogger(SendParcelService.class);
	
	/**
	 * 服务器接口实现,接收包裹信息
	 */
	
	public Response sendParcelData(String json) {
		logger.info("PC 端推送包裹录入数据；data"+json);
		try{
			//查询已存在的所有包裹ID(未领取状态的包裹所有ID)
			List<Long> listReuslt = this.sendParcelDao.selectAllPackagesIdsList();
			//声明insertList
			List<ParcelDataEntity> insertList = new ArrayList<ParcelDataEntity>();
			//声明list
			List<ParcelDataEntity> list = new ArrayList<ParcelDataEntity>();
			try{
				//转换为list
				list = JsonUtil.jsonToList(json, ParcelDataEntity.class);
			}catch (Exception e) {
				//捕获异常
				String re = "{\"status\":0,\"message\":\"解析PC传送消息失败\"}";
				logger.info("sendParcelData--解析PC传送消息-包裹录入数据-失败; json is "+json);
				return Response.ok(re).header("ESB-ResultCode", "1").build();
			}
			boolean flag = true;
			//返回重复的ID信息
			List<Long> ids = new ArrayList<Long>();
			Map<Long,Long> map = null;
			//循环判断
			for(Long data : listReuslt){
				if(map == null){
					map = new HashMap<Long, Long>();
				}
				//map中put数据
				map.put(data, data);
			}
			//判断map是否非Null
			if(map != null){
				//过滤重复的未领取包裹
				for(ParcelDataEntity data : list){
					Long id = data.getPackagesId();
					if(!map.containsKey(id)){
						insertList.add(data);
					}else{
						flag = false;
						ids.add(id);
					}
				}
			}else{
				insertList = list;
			}
			//判断insertList是否有值
			if(insertList.size()>0){
				//插入数据
				this.sendParcelDao.insertSendPraceList(insertList);
			}
			//调用消息通知
			if(insertList.size()>0){
				//循环insertList
				for(ParcelDataEntity enDataEntity : insertList){
					logger.info("调用消息通知  packageId is "+enDataEntity.getPackagesId());
					try{
						//声明时间
						Date now = new Date();
						//得到时间
						String nowDate = DateUtil.getFormatDateTime(now, DateUtil.DateTimeFormatString);
						//保存包裹信息
						this.sendReceiveRoomMessNotificationService.saveMesssageToDB(enDataEntity.getPersonCode(),"您有一个包裹,请及时到收发室领取!",0,nowDate);
						//this.sendReceiveRoomMessNotificationService.judgmentMessage(enDataEntity.getPackagesId());
					}catch (Exception e) {
						//捕获异常
						e.printStackTrace();
						logger.info("调用消息通知  packageId is "+enDataEntity.getPackagesId()+"失败");
					}
				}
			}
			//声明一个变量
			String re = "";
			//判断
			if(flag){
				re = "{\"status\":1,\"message\":\"同步数据成功！\"}";
			}else{
				String idStr = JsonUtil.listToJsonString(ids);
				re = "{\"status\":1,\"message\":\"同步数据成功！,但是这些包裹已经存在:(ids)\",\"ids\":\"" +idStr+
						"\"}";
			}
			logger.info("返回结果:"+re);
			//返回数据
			return Response.ok(re).header("ESB-ResultCode", "1").build();
		}catch (Exception e) {
			//捕获异常
			e.printStackTrace();
			String re = "{\"status\":0,\"message\":\"同步数据失败\"}";
			logger.info("返回结果:"+re);
			return Response.ok(re).header("ESB-ResultCode", "1").build();
		}
	}

	/**
	 * @param userNo 用户工号
	 * @return
	 */
	public List<ParcelEntity> getParcelList(String userNo) {
		return this.sendParcelDao.getAllPackagesInfoPage(userNo);
	}
	
	//sendParcelDao 的注入
	public ISendParcelDao getSendParcelDao() {
		return sendParcelDao;
	}
	//sendParcelDao 的注入
	public void setSendParcelDao(ISendParcelDao sendParcelDao) {
		this.sendParcelDao = sendParcelDao;
	}

	/**
	 * 获取用户未签收总条数（包含代签）
	 * @param userNo 用户工号
	 * @return
	 */
	public int getPageCount(String userNo) {
		return this.sendParcelDao.getPageCount(userNo);
	}
    //sendReceiveRoomMessNotificationService get set
	public ISendReceiveRoomMessNotificationService getSendReceiveRoomMessNotificationService() {
		return sendReceiveRoomMessNotificationService;
	}
	 //sendReceiveRoomMessNotificationService get set
	public void setSendReceiveRoomMessNotificationService(
			ISendReceiveRoomMessNotificationService sendReceiveRoomMessNotificationService) {
		this.sendReceiveRoomMessNotificationService = sendReceiveRoomMessNotificationService;
	}
	
}


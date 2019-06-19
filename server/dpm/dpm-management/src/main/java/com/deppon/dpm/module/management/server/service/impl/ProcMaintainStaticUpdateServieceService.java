package com.deppon.dpm.module.management.server.service.impl;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.management.server.dao.IProcMaintainStaticUpdateServieceDao;
import com.deppon.dpm.module.management.server.service.IProcMaintainStaticUpdateServieceService;
import com.deppon.dpm.module.management.server.service.IProcMaintenanceMessageService;
import com.deppon.dpm.module.management.shared.domain.ProcMaintainEntity;
import com.deppon.dpm.module.management.util.Constants;
import com.deppon.foss.framework.exception.BusinessException;

/**工程维修 退回、已审核  服务器
 * @author 274858
 *
 */
public class ProcMaintainStaticUpdateServieceService implements IProcMaintainStaticUpdateServieceService{
    //dao层
	private IProcMaintainStaticUpdateServieceDao procMaintainStaticUpdateServieceDao;
	//消息通知
	private IProcMaintenanceMessageService procMaintenanceMessageService;
	
	
	public IProcMaintenanceMessageService getProcMaintenanceMessageService() {
		return procMaintenanceMessageService;
	}
	public void setProcMaintenanceMessageService(
			IProcMaintenanceMessageService procMaintenanceMessageService) {
		this.procMaintenanceMessageService = procMaintenanceMessageService;
	}
	
	public IProcMaintainStaticUpdateServieceDao getProcMaintainStaticUpdateServieceDao() {
		return procMaintainStaticUpdateServieceDao;
	}
	public void setProcMaintainStaticUpdateServieceDao(
			IProcMaintainStaticUpdateServieceDao procMaintainStaticUpdateServieceDao) {
		this.procMaintainStaticUpdateServieceDao = procMaintainStaticUpdateServieceDao;
	}
	/**
	 * 日志
	 */
	Logger log = LoggerFactory.getLogger(ProcMaintainStaticUpdateServieceService.class);
	/* 
	 * 审批标志位（-1==退回，0==审核中，1==已审核，2==暂存）
	 * 退回||已审批||自行维修||
		PC端推送数据 客户端
		数据格式：
		{
			"status":, 		//-1===退回，0===审核中（这个不需要传送,是APP表示的状态，最好是两边一						样），1===已审核
			"message":,		//
			"bill":，		//单号
			"self":			//0---非自行维修;1---自行维修;（）
		}
		
		APP接收PC端数 服务端 返回
		{
			"isSuccess":, 		//状态 0-（表示PC出现异常,或者有操作失败）;1-（业务逻辑完成）	
			"message":		//
		}
		}
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.service.IProcMaintainStaticUpdateServieceService#updateRecSendState(java.lang.String)
	 */
	@Override
	public Response updateRecSendState(String json) {
		String re =  "{\"status\":0,\"message\":\"系统异常，更新失败\"}";
		//json = "{'status':-1,'message':'这个不需要传送,是APP表示的状态','bill':'5656556864','self':0}";
		try{
			
			log.info("服务器接受的数据为："+json);
			if(json == null || "".equals(json)){
				re =  "{\"status\":0,\"message\":\"您传入的参数为空\"}";
				return Response.ok(re).header("ESB-ResultCode", "1").build();
			}
			//获取状态 -1===退回，0===审核中，1===已审核
			JSONObject parJson = JSONObject.parseObject(json);
			//状态
			int status = parJson.getInteger("status") == null ? Constants.PROC_MAINTAIN_STATUS:parJson.getInteger("status");
			//信息
			String message = parJson.getString("message") == null ? "":parJson.getString("message").trim();
			//单号
			String bill = parJson.getString("bill") == null ? "":parJson.getString("bill").trim();
			//是否自行维修
			int self = parJson.getInteger("self") == null ? 0:parJson.getInteger("self") ;
			// 所属工程部
			String department = parJson.getString("department") == null ? "":parJson.getString("department").trim();
			
			if(status > 1 || status < -1){
				
				re = "{\"isSuccess\":0,\"message\":\"传入的参数status不对\"}";
				return Response.ok(re).header("ESB-ResultCode", "1").build();
			}
			
			if("".equals(bill)){
				
				re = "{\"isSuccess\":0,\"message\":\"传入的参数bill不对\"}";
				return Response.ok(re).header("ESB-ResultCode", "1").build();
			}
			
			if(!(self == 0 || self == 1)){
				re = "{\"isSuccess\":0,\"message\":\"传入的参数self不对\"}";
				return Response.ok(re).header("ESB-ResultCode", "1").build();
			}
			
			log.info("status:"+status);
			log.info("message:"+message);
			log.info("bill:"+bill);
			log.info("self:"+self);
			log.info("department:"+department);
			
		    re = updateStatus(status,message,bill,self,department);
		   
			//String re = "{\"status\":1,\"message\":\"Synchronous data success\"}";
			return Response.ok(re).header("ESB-ResultCode", "1").build();
		}catch(Exception e){
			log.error("系统异常，更新失败",e);
			e.printStackTrace();
		}
		
		return Response.ok(re).header("ESB-ResultCode", "1").build();
	}
	/**
	 * 更新状态
	 * @param status
	 * @param message
	 * @param bill
	 * @param self
	 * @return
	 */
	private String updateStatus(int status, String message, String bill,
			int self,String department) throws BusinessException{
		ProcMaintainEntity parBean = new ProcMaintainEntity();
		parBean.setSelf(self);
		parBean.setApprovalMark(status);
		parBean.setBill(bill);
		parBean.setDepartment(department);
		int res = procMaintainStaticUpdateServieceDao.updateStatus(parBean);
		if(res > 0){
			 /*
			  * 自行维修消息通知
			  */
			try{
				procMaintenanceMessageService.getProcMainMessage(self, bill, status);
			}catch(Exception e){
				log.info("消息推送异常");
				e.printStackTrace();
			}
			 
			return "{\"isSuccess\":1,\"message\":\"更新状态成功\"}";
		}
		return "{\"isSuccess\":0,\"message\":\"更新状态失败\"}";
	}

}

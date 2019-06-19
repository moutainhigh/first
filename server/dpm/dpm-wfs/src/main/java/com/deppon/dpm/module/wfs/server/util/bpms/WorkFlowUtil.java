package com.deppon.dpm.module.wfs.server.util.bpms;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.bpms.module.shared.domain.ApprovalInfo;
import com.deppon.bpmsapi.module.client.api.IDpBpmsClientFacade;
import com.deppon.bpmsapi.module.client.domain.BpmsOperateInfo;
import com.deppon.bpmsapi.module.client.domain.WorkItemInfo;
import com.deppon.bpmsapi.module.client.util.BPMSConstant;
import com.deppon.dpm.module.wfs.server.service.impl.DppmWorkInfoService;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ApprovelEntity;

/**
* 工作流操作工具类
* @title: WorkFlowUtil 
* @author： lihai
* @date： 2014-7-3 下午01:22:57
 */
public class WorkFlowUtil {
	//日志
	private static Logger logger = LoggerFactory.getLogger(DppmWorkInfoService.class);
	
	/**
	 * <p>获取审批信息</p> 
	 * @author 106140
	 * @date 2014-12-26 上午10:47:40
	 * @param processinstId 工作流号 
	 * @param empCode 审批人工号
	 * @param empName 姓名
	 * @return
	 * @throws Exception
	 * @see
	 */
	public static List<ApprovalInfo> getApprovalInfo(long processinstId, String empCode, String empName)  {
		//调用工作流API取到已处理的工作流单号
    	IDpBpmsClientFacade clientFacade = BPSClientFactory.getClient(empCode, empName);
    	
    	List<ApprovalInfo> approvalInfos = clientFacade.queryApprovalInfoByProcessInstID(processinstId);
    	return approvalInfos;
	}
	/**
	* 审批工作流
	* @methodName: approvalWorkFlow 
	* @author：lihai
	* @date： 2014-7-3 下午04:15:14
	* @param dpBpmsClientFacade
	* @param approvelEntity
	* @return boolean
	 */
	public static boolean approvalWorkFlow(IDpBpmsClientFacade dpBpmsClientFacade,ApprovelEntity approvelEntity)  {
		boolean isSuccess = false;
//		try {
			// 无回退
//			if("2".equals(approvelEntity.getIsAgree())){
				//回退操作，回退到起草人
//				isSuccess = rollBack(dpBpmsClientFacade, approvelEntity, new String[]{"Drafter"});
//			}else{
				BpmsOperateInfo operateInfo = new BpmsOperateInfo();
				//设置审批结果
				//0,同意
				operateInfo.setOperateType(Integer.valueOf(approvelEntity.getIsAgree()) == 0 ? BPMSConstant.APPROVE_OPERATETYPE_AGREE : BPMSConstant.APPROVE_OPERATETYPE_DISAGREE);
				//设置审批意见
				operateInfo.setApproveOpinion(approvelEntity.getApproveOpinion());
				//设置审批时间
				operateInfo.setOperateDate(new Date());
				isSuccess = dpBpmsClientFacade.send(approvelEntity.getWorkItemId(),approvelEntity.getProcessinstid(), operateInfo, null);
				logger.info("调用bpms审批工作流审批结果：processinstid" + approvelEntity.getProcessinstid() + "--" + isSuccess );
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return isSuccess;
	}
	/**
	 * 
	* @MethodName: queryRuningWorkItems 
	* @description : 查询当前运行着的工作项以及审批人信息
	* @author：caibingbing 
	* @date： 2014-9-30 下午1:50:06
	* @param processinstid 工作流号
	* @return String
	 */
	public static String queryRuningWorkItems(long processinstid,IDpBpmsClientFacade dpBpmsClientFacade){
		//调用引擎api查询当前活动着的工作项
		WorkItemInfo[] infos =  dpBpmsClientFacade.getRuningWorkItems(processinstid, null);
		
		StringBuffer sbff = new StringBuffer();
		String activityDefid = "";
		long activityInstID = 0l;
		long workItemID = 0l;
		long processInstId = 0l;
		sbff.append("\"participant\":\""); 
		
		//拼接 下一审批人信息 以及下一活动节点信息
		int size = infos == null?0:infos.length;
		if(size != 0) {
			for(int i = 0 ; i < size; i++) {
				if(i == size-1) {
					sbff.append(infos[i].getParticipant() + "\"");
					workItemID = infos[i].getWorkItemID();
					activityInstID = infos[i].getActivityInstID();
					activityDefid = infos[i].getActivityDefID();
					processInstId = infos[i].getProcessInstId();
				} else {
					sbff.append(infos[i].getParticipant() + "#");
				}
			}
		} else {
			sbff.append("\"");
		}
		sbff.append(",");
		sbff.append("\"activityDefid\":\"" + activityDefid + "\",\"activityInstID\":" + activityInstID + ",\"workItemID\":" + workItemID+",\"processInstId\":" + processInstId);
		
		//判断工作流是否审批结束 0:未结束   1:结束
		if(size != 0) {
			sbff.append(",\"isOver\":0");
		} else {
			sbff.append(",\"isOver\":1");
		}
		logger.info("下个审批人信息及审批是否: processinstid" + processinstid + "--" + sbff.toString() +"--------------");
		return sbff.toString();
	} 
}

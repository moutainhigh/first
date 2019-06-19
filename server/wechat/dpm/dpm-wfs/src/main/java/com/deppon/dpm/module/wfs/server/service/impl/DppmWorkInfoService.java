package com.deppon.dpm.module.wfs.server.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.bpms.module.shared.domain.ApprovalInfo;
import com.deppon.bpmsapi.module.client.api.IDpBpmsClientFacade;
import com.deppon.bpmsapi.module.client.domain.WorkItemInfo;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.projecttools.server.service.ITaskLogService;
import com.deppon.dpm.module.projecttools.server.util.TaskMonitor;
import com.deppon.dpm.module.wfs.server.dao.IDppmChangeCheckDao;
import com.deppon.dpm.module.wfs.server.dao.IDppmWorkInfoDao;
import com.deppon.dpm.module.wfs.server.service.IDppmWorkInfoService;
import com.deppon.dpm.module.wfs.server.util.RestfulUtil;
import com.deppon.dpm.module.wfs.server.util.bpms.BPSClientFactory;
import com.deppon.dpm.module.wfs.server.util.bpms.WorkFlowUtil;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ApprovelEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ChangeCheckEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ChangeEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ClosingCheckTypeEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ClosingIndexEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ClosingIsPassEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ClosingOrgInfoEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.FileUploadEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ProjectClosingEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ProjectEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ProjectFallGroundEntity;

/**
 * 
 * dppm 工作流Service
 * version:V1.0
 * @author 195406 高春玲
 * @date 2015-9-28 
 **/
public class DppmWorkInfoService implements IDppmWorkInfoService {
	//日志
	private Logger logger = LoggerFactory.getLogger(DppmWorkInfoService.class);
    
	//注入 dao
	private IDppmWorkInfoDao dao;
	// 项目变更 dao
	private IDppmChangeCheckDao changeDao;
	// 任务日志 service
	private ITaskLogService tasklogService;
	//主机地址
	private String dppmHost;
    /**
     * 获得项目结项工作流详情
     * 根据工作流号获得工作流详情
     * @param busino 
     * @param empCode
     * @param empName
     * @return 
     */
	public String projClosingDetail(String busino, String empCode, String empName) {
		ProjectClosingEntity entity = new ProjectClosingEntity();
		try{
			// 获得项目结项详情
			entity = this.dao.projClosingDetail(busino);
			
			//附件列表
			List<FileUploadEntity> fileList = this.dao.fileList(busino);
			entity.setFileList(fileList);
			
			//审批信息
			List<ApprovalInfo> approvalInfoList = WorkFlowUtil.getApprovalInfo(entity.getProcessintId(),empCode,empName);
			//设置审批记录
			entity.setApprovalInfoList(approvalInfoList);
			
			////通过业务编号获取指标相关信息
			List<ClosingIndexEntity> closingIndexList = this.dao.closingIndexList(busino);
			entity.setClosingIndexList(closingIndexList);
			
			//设置验收模块集合
			List<ClosingCheckTypeEntity> closingCheckTypeList = this.dao.closingCheckTypeList(busino);
			entity.setClosingCheckTypeList(closingCheckTypeList);
			
			//设置验收类型
			if(closingCheckTypeList != null && closingCheckTypeList.size() > 0) {
				entity.setCheckType(closingCheckTypeList.get(0).getCheckType());
			}
			
			////设置结项是否通过
			entity.setClosingIsPassEntity(this.dao.closingIsPassInfo(busino));
			
			//验收组织信息
			entity.setClosingOrgInfoEntity(this.dao.closingOrgInfoEntity(busino));
		} catch (Exception e) {
			entity.setError("获得项目结项工作流详情失败");
			this.logger.info("获得项目结项工作流详情 error:" + e.getMessage());
			e.printStackTrace();
		}
		return JsonUtil.beanToJsonString(entity);
	}
	/**
	 * 审批项目结项工作流
	 * @param entity 结项实体
	 * @param empCode
     * @param empName
	 * @return
	 */
	public String approvalProjClosing(String str,String empCode,String empName) {
		String issuccess = "0";
		try {
			// 转换为工作流实体
			ProjectClosingEntity entity = JSONObject.parseObject(str,
					ProjectClosingEntity.class);
			////获取填写的组织信息
			ClosingOrgInfoEntity closingOrgInfoEntity = entity.getClosingOrgInfoEntity();
			//获取填写的指标信息
			List<ClosingIndexEntity> closingIndexList = entity.getClosingIndexList();
			//获取填写的结项是否通过
			ClosingIsPassEntity closingIsPassEntity = entity.getClosingIsPassEntity();
			//获取填写的验收类型
			List<ClosingCheckTypeEntity> closingCheckTypeList = entity.getClosingCheckTypeList();
			//审批信息
			ApprovelEntity approvelEntity = entity.getApprovelEntity();
			// 审批通过时
			if(approvelEntity.getIsAgree().equals("0")) {
				//将审批页面填写的组织信息插入数据库
				if(closingOrgInfoEntity != null && closingOrgInfoEntity.getManagerName() != null && !closingOrgInfoEntity.getManagerName().equals("")){
					this.dao.insertClosingOrgInfo(closingOrgInfoEntity);
				}
				// 将指标信息插入数据库
				if(closingIndexList != null && closingIndexList.size()>0) {
					this.dao.insertClosingIndex(closingIndexList);
				}
				//将结项是否通过信息插入数据库
				if(closingIsPassEntity != null && closingIsPassEntity.getIspass() != null && !closingIsPassEntity.getIspass().equals("")) {
					this.dao.insertChosingIsPass(closingIsPassEntity);
				}
				//将结项验收类型插入数据库
				if(closingCheckTypeList != null && closingCheckTypeList.size() > 0) {
					this.dao.insertClosingCheckType(closingCheckTypeList);
				}
			}
			
			IDpBpmsClientFacade dpBpmsClientFacade = BPSClientFactory.getClient(empCode, empName);
			//审批工作流
			boolean isSuccess = WorkFlowUtil.approvalWorkFlow(dpBpmsClientFacade, approvelEntity);
			//如果成功，修改状态
			if(isSuccess) {
				issuccess = "1";
				//修改业务表状态
				this.updateProjectClosing(approvelEntity,dpBpmsClientFacade,closingIsPassEntity);
			}
		} catch (Exception e) {
			issuccess = "审批项目结项工作流报错:" + e.getMessage();
			this.logger.info("审批项目结项工作流报错 error:" + e.getMessage());
			e.printStackTrace();
		}
		return issuccess;
	}
	/**
	 * 审批工作流
	 * //修改业务表状态
	 * @param approvelEntity 审批实体
	 * @param clientFacade bpms客户端
	 * @param closingIsPassEntity 结项是否通过
	 * @throws Exception
	 * @see
	 */
	public void updateProjectClosing(ApprovelEntity approvelEntity,IDpBpmsClientFacade clientFacade,
			ClosingIsPassEntity closingIsPassEntity) throws Exception {

		//获取运行中的工作项
		WorkItemInfo[] wis = clientFacade.getRuningWorkItems(approvelEntity.getProcessinstid(), null);
		ProjectClosingEntity projectClosingEntity = new ProjectClosingEntity();
		//设置工作流号
		projectClosingEntity.setProcessintId(approvelEntity.getProcessinstid());
		//审批类型
		String option = approvelEntity.getIsAgree();
		boolean isLastApprove = (wis == null || wis.length == 0);
		if (isLastApprove && option.equals("0")) {
			// 同意
			projectClosingEntity.setAppcondition("已通过");
		} else if (isLastApprove && option.equals("1")) {
			// 不同意
			projectClosingEntity.setAppcondition("不通过");
		} else {
			// 审批中
			projectClosingEntity.setAppcondition("审批中");
		}
		//活动定义ID
		String activityDefId = approvelEntity.getActivityDefId();
		if((activityDefId.equals("manualActivity2") && !approvelEntity.getActivityinstid().equals("研发型")) || activityDefId.equals("manualActivity3")){
			if(option.equals("0")){
				//同意
				projectClosingEntity.setCheckCondition("已通过");
			}else{
				//不通过
				projectClosingEntity.setCheckCondition("不通过");
			}
		}
		//修改状态
		this.dao.updateProjectClosing(projectClosingEntity);
		
		//修改项目状态
		if(closingIsPassEntity != null && closingIsPassEntity.getIspass() != null && !closingIsPassEntity.getIspass().equals("")){
			if(activityDefId.equals("manualActivity6") && option.equals("0") && closingIsPassEntity.getIspass().equals("是")){
				//根据业务编号获取项目的projectCode
				ProjectClosingEntity proClosingEntity = this.dao.projClosingDetail(approvelEntity.getBusino());
				//通过projectCode修改项目状态
				if(proClosingEntity != null){
					this.dao.updateProStatusByProCode(proClosingEntity.getProCode());
				}
			}
		}
		
	}

	//////////////////////////////
	//项目落地
	/**
     * 根据业务编号获得项目落地详情
     * @param busino 
     * @param empCode
     * @param empName
     * @return
     */
    public String projFallGroundDetail(String busino,String empCode,String empName) {
    	ProjectFallGroundEntity entity = new ProjectFallGroundEntity();
    	try {
    		//根据业务编号获得项目落地
    		entity = this.dao.projFallGroundDetail(busino);
    		//获得附件列表
    		List<FileUploadEntity> fileList = this.dao.fileList(busino);
			entity.setFileList(fileList);
    		
    		//根据工作流号 调用 bpms 客户端获得审批记录
    		//审批信息
			List<ApprovalInfo> approvalInfoList = WorkFlowUtil.getApprovalInfo(entity.getProcessintId(),empCode,empName);
			//设置审批记录`
			entity.setApprovalInfoList(approvalInfoList);
    	} catch (Exception e) {
    		if(entity == null ) {
    			entity = new ProjectFallGroundEntity();
    		}
    		entity.setError("查询项目落地详情失败");
    		this.logger.info("查询项目落地详情失败 error:" + e.getMessage());
    		e.printStackTrace();
    	}
    	
    	return JsonUtil.beanToJsonString(entity);
    }
    /**
	 * 审批落地结项工作流
	 * @param entity 落地实体
	 * @param empCode
     * @param empName
	 * @return
	 */
	public String approvalProjFallGround(String str,String empCode,String empName) {
		String issuccess = "0";
		try {
			// 转换为工作流实体
			ProjectFallGroundEntity entity = JSONObject.parseObject(str,
					ProjectFallGroundEntity.class);
			//审批信息
			ApprovelEntity approvelEntity = entity.getApprovelEntity();
			
			IDpBpmsClientFacade dpBpmsClientFacade = BPSClientFactory.getClient(empCode, empName);
			//审批工作流
			boolean isSuccess = WorkFlowUtil.approvalWorkFlow(dpBpmsClientFacade, approvelEntity);
			//如果成功，修改状态
			if(isSuccess) {
				issuccess = "1";
				//修改业务表状态
				this.updateProjectFallGround(approvelEntity,dpBpmsClientFacade);
			}
		} catch (Exception e) {
			issuccess = "审批项目落地工作流报错:" + e.getMessage();
			this.logger.info("审批项目落地工作流报错 error:" + e.getMessage());
			e.printStackTrace();
		}
		return issuccess;
	}
	/**
	 * 修改状态
	 * @param approvelEntity
	 * @param clientFacade
	 * @see
	 */
	public void updateProjectFallGround(ApprovelEntity approvelEntity,IDpBpmsClientFacade clientFacade)
			throws Exception {

		//获取运行中的工作项
		WorkItemInfo[] wis = clientFacade.getRuningWorkItems(approvelEntity.getProcessinstid(), null);
		ProjectFallGroundEntity projectFallGroundEntity = new ProjectFallGroundEntity();
		//设置工作流号
		projectFallGroundEntity.setProcessintId(approvelEntity.getProcessinstid());
		String option = approvelEntity.getIsAgree();
		boolean isLastApprove = (wis == null || wis.length == 0);
		if (isLastApprove && option.equals("0")) {
			// 同意
			projectFallGroundEntity.setAppcondition("已通过");
		} else if (isLastApprove && option.equals("1")) {
			// 不同意
			projectFallGroundEntity.setAppcondition("不通过");
		} else {
			// 审批中
			projectFallGroundEntity.setAppcondition("审批中");
		}

		//修改
		this.dao.updateProjFallGround(projectFallGroundEntity);
		
	}
	
	////项目新建 查询
	/**
	 * 项目新建查询
	 * @param wfsid 工作流号
	 * @param empCode  审批人工号
	 * @param empName
	 * @return
	 */
	public String queryProjectInfo(String wfsid,String empCode,String empName) {
		// 初始化 map
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			//根据工作流号获得项目信息
			map = this.dao.queryProjectInfo(wfsid);
			//审批信息
			List<ApprovalInfo> approvalInfoList = WorkFlowUtil.getApprovalInfo(Long.parseLong(wfsid),empCode,empName);
			//设置审批记录
			map.put("approvalInfoList", approvalInfoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JsonUtil.beanToJsonString(map);
	}
	/**
	 * 项目新增工作流审批
	 * @param str 审批记录
	 * @param empCode
     * @param empName
	 * @return
	 */
	public String approveProjInfo(String str,String empCode,String empName) {
		String issuccess = "0";
		try {
			// 转换为工作流实体
			ProjectEntity entity = JSONObject.parseObject(str,
					ProjectEntity.class);
			//审批信息
			ApprovelEntity approvelEntity = entity.getApprovelEntity();
//			if(approvelEntity.getActivityDefId() != null && "projectSponsor".equals(approvelEntity.getActivityDefId())){
//				empCode = "sysadmin";
//				empName = "系统管理员";
//			}
			IDpBpmsClientFacade dpBpmsClientFacade = BPSClientFactory.getClient(empCode, empName);
			//审批工作流
			boolean isSuccess = WorkFlowUtil.approvalWorkFlow(dpBpmsClientFacade, approvelEntity);
			
			//如果成功，添加 dppm 审批记录 和下个审批人信息
			if(isSuccess) {
				issuccess = "1";
				//添加dppm表记录
				this.addcheckRecords(entity,dpBpmsClientFacade,empCode);
			}
		} catch (Exception e) {
			issuccess = "审批项目新建工作流报错:" + e.getMessage();
			this.logger.info("审批项目新建工作流报错 error:" + e.getMessage());
			e.printStackTrace();
		}
		return issuccess;
	}
	/**
	 * 添加 dppm 审批记录 和下个审批人信息
	 * @param entity
	 * @param dpBpmsClientFacade
	 * @param empCode
	 */
	public void addcheckRecords(ProjectEntity entity,IDpBpmsClientFacade dpBpmsClientFacade,String empCode) {
		//获得下个审批人信息
		String str = WorkFlowUtil.queryRuningWorkItems(entity.getApprovelEntity().getProcessinstid(), dpBpmsClientFacade);
//		String str = "\"participant\":\"202157|200635|091221\",\"activityDefid\":\"\",\"activityInstID\":0,\"workItemID\":0,\"processInstId\":0,\"isOver\":0";
		str = "{" + str + "}";
		
		//下个审批人
		String s = JsonUtil.jsonGetValueBykey(str,"participant");
		// 是否审批结束 0:未结束   1:结束
		String s2 = JsonUtil.jsonGetValueBykey(str,"isOver");
		entity.setWfsIsOver(Integer.parseInt(s2));
		entity.setNextEmpCode(s);
		ApprovelEntity ap = entity.getApprovelEntity();
		ap.setActivityDefId(JsonUtil.jsonGetValueBykey(str,"activityDefid"));// 下个节点
		ap.setActivityinstid(JsonUtil.jsonGetValueBykey(str,"activityInstID"));
		ap.setWorkItemId(Long.valueOf(JsonUtil.jsonGetValueBykey(str,"workItemID")));
		this.dao.approveProjInfo(entity, empCode);
	}
	/**
	 * 项目变更审核信息获得
	 * @param wfsid 工作流号
	 * @return
	 */
	public String queryChangeCheckInfo(String wfsid,String empCode,String empName) {
		// 初始化 map
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			//根据工作流号获得项目信息
			map = this.changeDao.queryChangeCheckInfo(wfsid);
			//审批信息
			List<ApprovalInfo> approvalInfoList = WorkFlowUtil.getApprovalInfo(Long.parseLong(wfsid),empCode,empName);
			//设置审批记录
			map.put("approvalInfoList", approvalInfoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JsonUtil.beanToJsonString(map);
	}
	/**
	 * 项目变更工作流审批
	 * @param str 审批记录
	 * @param empCode
     * @param empName
	 * @return
	 */
	public String approveProjChange(String str,String empCode,String empName) {
		String issuccess = "0";
		try {
			// 转换为工作流实体
			ChangeCheckEntity entity = JSONObject.parseObject(str,
					ChangeCheckEntity.class);
			//审批信息
			ApprovelEntity approvelEntity = entity.getApprovelEntity();
			IDpBpmsClientFacade dpBpmsClientFacade = BPSClientFactory.getClient(empCode, empName);
			//审批工作流
			boolean isSuccess = WorkFlowUtil.approvalWorkFlow(dpBpmsClientFacade, approvelEntity);
			
			//如果成功，则执行业操作（修改业务状态）
			if(isSuccess) {
				issuccess = "1";
				this.logger.info("审批成功后，修改表数据：processId:" + approvelEntity.getProcessinstid() + ",empCode:" + empCode + ", isAgree:" + approvelEntity.getIsAgree());
				doAfterApproval(dpBpmsClientFacade, approvelEntity, entity);
			}
		} catch (Exception e) {
			issuccess = "审批项目变更工作流报错:" + e.getMessage();
			this.logger.info("审批项目变更工作流报错 error:" + e.getMessage());
			e.printStackTrace();
		}
		return issuccess;
	}
	/**
	 * 
	 * 审批成功后执行业务逻辑
	 * @param client
	 * @param approvelEntity
	 * @param changeCheckEntity
	 * @see
	 */
	private void doAfterApproval(IDpBpmsClientFacade client, 
			ApprovelEntity approvelEntity, ChangeCheckEntity changeCheckEntity) throws Exception {
		ChangeEntity changeEntity = new ChangeEntity();
		Integer option = Integer.valueOf(approvelEntity.getIsAgree());
		// 工作流号
		changeEntity.setProcessId(approvelEntity.getProcessinstid());
		//变更审核人
		changeEntity.setChangeReviewer(changeCheckEntity.getChangeReviewer());
		// 根据工作流号获得审核信息
		changeCheckEntity = this.changeDao.querychangeCheck(approvelEntity.getProcessinstid());
		//变更id
		changeEntity.setChangeId(changeCheckEntity.getChangeId());
		//变更类型
		changeEntity.setChangeState(changeCheckEntity.getChangeState());
		//如果审批同意
		if(option == 0) {
//			if(changeCheckEntity != null) {
				//判断是否是最后一个审核人
				WorkItemInfo[] wis = client.getRuningWorkItems(approvelEntity.getProcessinstid(), null);
				boolean isLastApprove = (wis == null || wis.length == 0);
				this.logger.info("审批同意：获得审核信息---是否是最后一个审批人：" + isLastApprove);
				//当是最后一个审批人审批时 设置审批状态为 3 其他的设为审批中 5
				if(isLastApprove) {
					//当是最后一个审核人时 审批状态 3：审批结束
					changeEntity.setAuditState(3);
					//审批同意后把变更信息同步到正式数据
					//变更类型（1是年度规划变更，2是项目变更）
					this.logger.info("审批同意：获得审核信息---变更类型：" + (changeCheckEntity.getChangeType() == 1 ? "年度规划变更" : "项目变更"));
					if(changeCheckEntity.getChangeType() == 1) {
						//将变更后的数据更新到正式数据
						updateAnnualPlanFromTempToFormal(
								changeCheckEntity.getOldAiId(), changeCheckEntity.getNewAiId(), 
								changeCheckEntity.getProjectType(), changeCheckEntity.getChangeState());
						//变更成功后修改版本号
						editGhVersion(changeCheckEntity.getGhVersion());
						//变更成功后把临时表数据删除
						int[] aiIds = {changeCheckEntity.getNewAiId()};
						this.changeDao.delTempYearPlan(aiIds);
					}
					if(changeCheckEntity.getChangeType() == 2) {
						if(changeCheckEntity.getProjectStatus() == 4) { //项目状态变为终止
							//项目状态变为已终止，对应的任务也要终止
							this.logger.info("项目变更：oldAiId:" + changeCheckEntity.getOldAiId() + "--项目状态projectStatus:4,变为已终止，对应的任务也要终止");
							this.changeDao.terminateTask(changeCheckEntity.getOldAiId());
						} else {
							//将变更后的数据更新到正式数据
							updateProjectFromTempToFormal(changeCheckEntity.getOldAiId(), changeCheckEntity.getNewAiId());
							//审批同意后 变更内容为里程碑、关键节点或结项时间系统自动发邮件至项目组织中所有的执行个人
							mailToExecutor(changeCheckEntity.getNewAiId(), changeCheckEntity.getChangeId(), 
									changeCheckEntity.getProjectName());
						}
					}
				} else {
					changeEntity.setAuditState(5);
				}
//			} else {
//				changeEntity.setAuditState(5);
//			}
		} else {
			changeEntity.setAuditState(4);
		}
		//修改审核状态
		this.changeDao.updateChange(changeEntity);
	}
	
	/**
	 * 审批同意后 变更内容为里程碑、关键节点或结项时间系统自动发邮件至项目组织中所有的执行个人</p> 
	 * @param newAiId
	 * @param changeId
	 * @param projectName
	 * @see
	 */
	private void mailToExecutor(Integer newAiId, Integer changeId, String projectName) {
		//查询是否需要发邮件(是否涉及里程碑、关键节点或结项时间的变更)
		Integer result = this.changeDao.checkIsSendMail(changeId);
		if(result > 0) { //涉及里程碑、关键节点或结项时间的变更
			List<String> retmail = this.changeDao.getOrgsPersonEmails(newAiId);
			if(retmail.size() > 0) {
				String[] mails = new String[retmail.size()];
				for(int i = 0; i < retmail.size(); i++) {
					mails[i] = retmail.get(i);
				}
				//String[] mailstest = {"gaomengran@deppon.com", "denghanchao@deppon.com"};
				String subject = projectName + "项目的里程碑、关键节点或结项时间变更任务调整通知";
				String html = projectName + "项目的里程碑、关键节点或结项时间已变更，请及时根据最新的时间调整项目任务！";
				try {
					//新增日志成功 异步调用发送邮件到提醒人
					TaskMonitor tm = new TaskMonitor();
					// 设置service
					tm.service = this.tasklogService;
					// 设置 收件人
					tm.toEmail = mails;
					tm.title = subject;
					tm.info = html;
					// 创建线程
					Thread t = new Thread(tm);
					// 启动线程
					t.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 
	 * <p>将变更后的数据更新到正式数据(项目)</p> 
	 * @author 150970
	 * @date 2014年12月16日 下午3:11:14
	 * @param oldAiId
	 * @param newAiId
	 * @see
	 */
	public void updateProjectFromTempToFormal(Integer oldAiId, Integer newAiId) {
		this.logger.info("项目变更：将变更后的数据更新到正式数据-----oldAiId:" + oldAiId + ",newAiId:" + newAiId);
		this.changeDao.updateProjInfo(newAiId, oldAiId);
		//调用存储过程来更新项目的其他信息
		this.logger.info("项目变更：调用存储过程来更新项目的其他信息 pro_change_pm_success -----oldAiId:" + oldAiId + ",newAiId:" + newAiId);
		this.changeDao.updateProjOtherInfo(oldAiId, newAiId);
	}
	/**
	 * 将变更后的数据更新到正式数据(年度规划)
	 * @author 195406
	 * @param oldAiId
	 * @param newAiId
	 * @param ghType
	 * @param changeState
	 * @see
	 */
	private void updateAnnualPlanFromTempToFormal(Integer oldAiId, Integer newAiId,
			Integer ghType, Integer changeState) throws Exception {
		if(changeState == 1) { //新增-执行插入操作（复制表数据）
			this.logger.info("---------------年度规划新增-dotp_gh_project_change--" + newAiId);
			this.changeDao.insertYearPlanProj(newAiId);
		} else if(changeState == 2) {//修改
			//年度规划项目实体类
			this.logger.info("---------------年度规划修改-dotp_gh_project_change--newAiId" + newAiId + " ---oldAiId:" + oldAiId +" --ghType:" + ghType);
			this.changeDao.updateTempYearPlan(newAiId, oldAiId,ghType);
		} if(changeState == 3) {//删除原数据
			this.changeDao.delYearPlan(oldAiId);
		}
	}
	/**
	 * 
	 * 变更成功后修改版本号
	 * @author 195406
	 * @date 2015.11.4
	 * @param ghVersion 
	 */
	public void editGhVersion(String ghVersion) {
		String v = ghVersion.substring(ghVersion.lastIndexOf("v") + 1, ghVersion.lastIndexOf("."));
		String tail = ghVersion.substring(ghVersion.lastIndexOf("."));
		int num = Integer.parseInt(v) + 1;
		String newGhVersion = ghVersion.substring(0, ghVersion.lastIndexOf("v") + 1) + num + tail;
		Map<String, String> params = new HashMap<String, String>();
		params.put("ghVersion", ghVersion);
		params.put("newGhVersion", newGhVersion);
		this.changeDao.updateProjVersion(ghVersion, newGhVersion);
	}
	
	/**
	 * 查询
	 * @param url
	 * @param param
	 * @return
	 */
	@Override
	public String queryWf(String url,String param) {
		this.logger.info("项目结项工作流查询======> url:" + url + ",param:" + param);
		return RestfulUtil.restfulWork(this.dppmHost + url, "", param, "dppm");
	}
	
	/**
	 * 审批
	 * @param url
	 * @param param
	 * @return
	 */
	@Override
	public String approveWf(String url,String param) {
		// TODO Auto-generated method stub
		return RestfulUtil.restfulWork(this.dppmHost + url, "", param, "dppm");
	}
	
	/**
	 * @param dao
	 */
	public void setDao(IDppmWorkInfoDao dao) {
		this.dao = dao;
	}
	/**
	 * @param changeDao
	 */
	public void setChangeDao(IDppmChangeCheckDao changeDao) {
		this.changeDao = changeDao;
	}
	/**
	 * @param tasklogService
	 */
	public void setTasklogService(ITaskLogService tasklogService) {
		this.tasklogService = tasklogService;
	}
	/**
	 * dppmHost
	 * @param dppmHost
	 */
	public void setDppmHost(String dppmHost) {
		this.dppmHost = dppmHost;
	}
}

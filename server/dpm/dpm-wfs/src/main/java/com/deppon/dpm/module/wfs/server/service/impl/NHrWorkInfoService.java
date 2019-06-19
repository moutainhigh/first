package com.deppon.dpm.module.wfs.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jpush.api.utils.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.util.PropertiesUtil;
import com.deppon.dpm.module.wfs.server.dao.INhrWorkInfoDao;
import com.deppon.dpm.module.wfs.server.service.INHrWorkInfoService;
import com.deppon.dpm.module.wfs.server.util.RestfulUtil;
import com.deppon.dpm.module.wfs.shared.domain.nhr.ApproveParam;
import com.deppon.dpm.module.wfs.shared.domain.nhr.NhrQueryUserInfo;
import com.deppon.dpm.module.wfs.shared.domain.nhr.QueryLeaveParams;
import com.deppon.dpm.module.wfs.shared.domain.nhr.QueryParam;
import com.deppon.dpm.module.wfs.shared.vo.NhrQueryParamVo;
import com.deppon.dpm.module.wfs.util.Constants;

/**
 * hr人力工作流Service
 * version:V1.0,author:195406 高春玲,date:2015-5-7 下午1:45:08
 * @author 195406 高春玲
 * @date 2015-5-7 下午1:45:08
 **/
public class NHrWorkInfoService implements INHrWorkInfoService {

	private static Logger logger  = LoggerFactory.getLogger(NHrWorkInfoService.class);
    //服务端 查询接口地址
	private String uri;
	//服务端 审批接口地址
	private String uriA;
	//esb 查询 服务编码
	private String esbCodeQ;
	//esb 审批 服务编码
	private String esbCodeA;
	// nhrWorkInfoDao
	private INhrWorkInfoDao nhrWorkInfoDao;
	
    /**
     * 工作流查询  根据请求参数 调用服务端地址 获得工作流详情
     */
	@Override
	public String queryWorkInfo(QueryParam query) {
		logger.info("nhr querywfs url is :" + this.uri + "---------" + this.esbCodeQ);
		
		query.setWorkFlowType(queryWorkType(query.getWorkFlowType()));
		String json = JSONObject.toJSONString(query);
		// http://localhost:8081/nhr/ws/dpmrs/queryByWorkFlowEntity
		return RestfulUtil.restfulWork(this.uri, this.esbCodeQ, json, "nhr");
	}
	 /**
     * 离职申请 工作流查询  根据请求参数 调用服务端地址 获得工作流详情
     */
	@Override
	public String queryLeaveWorkInfo(QueryLeaveParams queryLeave) {
		logger.info("nhr querywfs url is :" + this.uri + "---------" + this.esbCodeQ);
		
		queryLeave.setWorkFlowType(queryWorkType(queryLeave.getWorkFlowType()));
		String json = JSONObject.toJSONString(queryLeave);
		// http://localhost:8081/nhr/ws/dpmrs/queryByWorkFlowEntity
		return RestfulUtil.restfulWork(this.uri, this.esbCodeQ, json, "nhr");
	}
	
    /**
     * 工作流审批  根据请求参数审批信息 执行审批操作
     */
	@Override
	public String approveWorkInfo(ApproveParam audit) {
		logger.info("nhr approvewfs url is :" + this.uriA + "----uriA-----" + this.esbCodeA);
		audit.setWorkFlowType(queryWorkType(audit.getWorkFlowType()));
		String json = JSONObject.toJSONString(audit);
		// http://localhost:8081/nhr/ws/dpmrs/dealWorkFlow
		return RestfulUtil.restfulWork(this.uriA, this.esbCodeA, json, "nhr");
	}
    /**
     * 根据工作流流程定义id 设置工作流类型
     * @param flowtype 工作流引擎定义id
     * @return
     * getKeyValue 取properties配置文件的地址
     */
	private String queryWorkType(String flowtype) {
		String hrOvertimePayApply = PropertiesUtil.getKeyValue("hr_overtimePayApply");// 加班
		String hrRepairAttendance = PropertiesUtil.getKeyValue("hr_repairAttendance");// 补考勤
		String hrEmployeeTransactionApply=PropertiesUtil.getKeyValue("hr_employeeTransactionApply");//异动调动申请
		String hrReturnDomicileOfOrigin=PropertiesUtil.getKeyValue("hr_returnDomicileOfOrigin");//回原籍申请
		String hrPositiveApplication=PropertiesUtil.getKeyValue("hr_positiveApplication");//转正申请
		String hrAddEmpApply=PropertiesUtil.getKeyValue("hr_addEmpApply");//增补员申请
		String hrLeaveDaysOff=PropertiesUtil.getKeyValue("hr_leaveDaysOff");//请假/调休申请
		String hrTrainLeave=PropertiesUtil.getKeyValue("hr_trainLeave");//培训请假
		String hrResignation=PropertiesUtil.getKeyValue("hr_resignation");//离职
		String hrCertificate=PropertiesUtil.getKeyValue("hr_certificate");//收入/工作证明申请
		String hrDrRecruiterAffection=PropertiesUtil.getKeyValue("hr_drRecruiterAffection");//博士增补员
		String workFlowType = "";
		if (hrOvertimePayApply.equals(flowtype)) {
			workFlowType = "105";// 加班
		} else if (hrRepairAttendance.equals(flowtype)) {
			workFlowType = "101";// 补考勤
		}else if(hrEmployeeTransactionApply.equals(flowtype)){
			workFlowType = "107";// 异动调动申请
		} else if(hrReturnDomicileOfOrigin.equals(flowtype)){
			workFlowType = "106";// 回原籍申请
		} else if(hrPositiveApplication.equals(flowtype)){
			workFlowType = "104";// 转正申请
		} else if(hrAddEmpApply.equals(flowtype)){
			workFlowType = "102";//增补员申请
		} else if(hrLeaveDaysOff.equals(flowtype)){
			workFlowType = "103";//请假/调休申请
		} else if(hrTrainLeave.equals(flowtype)){
			workFlowType = "116";//培训请假
		}else if(hrResignation.equals(flowtype)){
			workFlowType = "121";//离职
		}else if(hrCertificate.equals(flowtype)){
			workFlowType = "115";//收入/工作证明申请
		}else if(hrDrRecruiterAffection.equals(flowtype)){
			workFlowType = "110";//博士增补员
		}
		logger.info("flowtype======:"+workFlowType);
		return workFlowType;
	}

	/**
	 * NHR工作流，人员选择器，根据族群区分，管理族群属于M，非管理族群属于P
	 * P7异动，直属上级M6，可选择任何等级P类人员交接。
	 * 职能事业群高级总监M9离职/异动，直属上级为高级副总裁D，可选择D及以下人员交接
	 * C>D>10
	 * 
	 * @param paramVo
	 * @param userId
	 * @return
	 */
	public String queryUserInfo(NhrQueryParamVo paramVo,String userId){
		int type = 0;
		// 查询工作流申请人岗位类型
		NhrQueryUserInfo applypsncodeInfo =  queryUserByUserId(paramVo.getApplypsncode());
		if(applypsncodeInfo != null && !"管理族群".equals(applypsncodeInfo.getJobGroups())){
			// P7异动，直属上级M6，可选择任何等级P类人员交接。
			type = 1;
			paramVo.setJobLevel(applypsncodeInfo.getJobLevel());
		} else {
			// 查询当前审批人岗位类型
			NhrQueryUserInfo userInfo =  queryUserByUserId(userId);
			if(userInfo!=null&&StringUtils.isNotEmpty(userInfo.getJobLevel())
					&&"C".equals(userInfo.getJobLevel().toUpperCase())){
				type = Constants.CONSTANT_FOUR;
			}else if(userInfo!=null&&StringUtils.isNotEmpty(userInfo.getJobLevel())
					&&"D".equals(userInfo.getJobLevel().toUpperCase())){
				type = Constants.CONSTANT_THREE;
			}else{
				type = Constants.CONSTANT_TWO;
			}
			if(null!=userInfo){
			paramVo.setJobLevel(userInfo.getJobLevel());
			}
		}
		paramVo.setQueryType(type);
		// 查询数据
		List<NhrQueryUserInfo> list = nhrWorkInfoDao.queryUserInfoWithPage(paramVo);
		// 返回
		return JSONObject.toJSONString(list == null ? new ArrayList<NhrQueryUserInfo>() : list);
	}
	
	/**
	 * 查询人员信息
	 * 
	 * @param userId
	 * @return
	 */
	private NhrQueryUserInfo queryUserByUserId(String userId){
		// 返回结果集
		NhrQueryUserInfo userInfo = null;
		// 查询参数
		NhrQueryParamVo paramVo = new NhrQueryParamVo();
		paramVo.setQueryCode(userId);
		// 查询数据
		List<NhrQueryUserInfo> list = nhrWorkInfoDao.queryUserInfoWithPage(paramVo);
		if(list != null && list.size()>0){
			userInfo = list.get(0);
		}
		return userInfo;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public void setEsbCodeQ(String esbCodeQ) {
		this.esbCodeQ = esbCodeQ;
	}

	public void setEsbCodeA(String esbCodeA) {
		this.esbCodeA = esbCodeA;
	}

	public void setUriA(String uriA) {
		this.uriA = uriA;
	}
	
	public void setNhrWorkInfoDao(INhrWorkInfoDao nhrWorkInfoDao) {
		this.nhrWorkInfoDao = nhrWorkInfoDao;
	}

}

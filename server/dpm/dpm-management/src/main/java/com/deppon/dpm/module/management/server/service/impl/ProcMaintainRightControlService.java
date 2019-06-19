package com.deppon.dpm.module.management.server.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.management.server.dao.IProcMaintainStaticUpdateServieceDao;
import com.deppon.dpm.module.management.server.service.IProcMaintainRightControlService;
import com.deppon.dpm.module.management.util.Constants;
import com.deppon.foss.framework.exception.BusinessException;

/**
 * 工程权限控制
 * @author 274858
 *
 */
public class ProcMaintainRightControlService implements IProcMaintainRightControlService{

	/**
	 * 日志
	 */
	Logger log = LoggerFactory.getLogger(ProcMaintainRightControlService.class);
	
	/*
	 * dao层
	 */
	private IProcMaintainStaticUpdateServieceDao procMaintainStaticUpdateServieceDao;

	


	public IProcMaintainStaticUpdateServieceDao getProcMaintainStaticUpdateServieceDao() {
		return procMaintainStaticUpdateServieceDao;
	}


	public void setProcMaintainStaticUpdateServieceDao(
			IProcMaintainStaticUpdateServieceDao procMaintainStaticUpdateServieceDao) {
		this.procMaintainStaticUpdateServieceDao = procMaintainStaticUpdateServieceDao;
	}


	/* 
	 * 
	 * 工程巡检权限
	 *
		public static final int manager_Right = 1;
		 *
		 * 工程验收权限
		 *
		public static final int check_Right = 2;
		 *
		 * 工程维修权限
		 *
		public static final int maintain_Right = 3;
	 * (non-Javadoc)
	 * @see com.deppon.dpm.module.management.server.service.IProcMaintainRightControlService#checkRightControl(java.lang.String)
	 */
	@Override
	public String checkRightControl(String str) throws BusinessException  {
		String res = "{\"resultFlag\":false,\"failureReason\":\"对不起，您没有该模块的权限！\"}";
		log.info("已经进入ProcCheckFindScoreShowService——getHisScoreFind(String str)");
		JSONObject json = JSONObject.parseObject(str);
		log.info("页面传过来的参数为:" + json);
		//工号
		String userNo = json.getString("userNo") == null ? "":json.getString("userNo").trim();
		//1==巡检  2==验收  3==维修 4==勘测
		int module = json.getInteger("module") == null ? -1:json.getInteger("module");
		
		if("".equals(userNo) || module<1 || module>Constants.Survey_Right){
			return "{\"resultFlag\":false,\"failureReason\":\"传入的参数不对\"}";
		}
		log.info("工号userNo:"+userNo);
        log.info("权限模块module:"+module);
        boolean resTab = checkRight(userNo,module);
		if(resTab){
			res = "{\"resultFlag\":true,\"failureReason\":\"欢迎使用该功能\"}";
		}
		
		return res;
	}


	/**
	 * 分模块判断
	 * @param userNo
	 * @param module
	 * @return
	 * @throws Exception
	 */
	private synchronized boolean checkRight(String userNo, int module) throws BusinessException{
		int resTab = -1;
		//验收 和 巡检
		if(module == Constants.Manager_Right 
						|| module == Constants.Check_Right || module == Constants.Survey_Right){
			/*
			 * 
				# 区域工程支持组 W0000005021
				# 区域工程部 W04000306010102
				# 华东华北区域工程部 W0400030601010202
				# 华南华中区域工程部 W0400030601010203
			              北京工程部 W01130505
			             东北工程部 W010003011018
			             浙江工程部 W010003011021
			             上海工程部 W010003011020
			             深圳工程部 W01130405
			             湖北工程部 W01130605
			             广州工程部 W01130303
			            四川工程部 W030003050104
			            西北工程部 W040003060101020111
			            福建工程部 W010003011019
				
			 */
			resTab = procMaintainStaticUpdateServieceDao.managerCheck(userNo);
		}
				
		//维修
		if(module == Constants.Maintain_Right){
			resTab = procMaintainStaticUpdateServieceDao.maintainRight(userNo);	
		}
		
		return resTab > 0 ? true:false;
		
	}




	
	
	
}



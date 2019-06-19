package com.deppon.dpm.module.management.server.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.dao.IProcCheckTaskDao;
import com.deppon.dpm.module.management.server.service.IProcCheckTaskService;
import com.deppon.dpm.module.management.shared.domain.ProcCheckTaskEntity;
import com.deppon.dpm.module.management.util.Constants;
import com.deppon.dpm.module.news.server.service.impl.TpushNewsService;
import com.deppon.dpm.module.news.shared.domain.NewsCenterEntity;
import com.deppon.foss.framework.shared.util.string.StringUtil;
/**   
* @Description: 工程验收操作service
* @author 268087 张广波
* @date 2016-1-5 下午3:57:49 
* @version V1.0 
*/
public class ProcCheckTaskService implements IProcCheckTaskService {
	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(ProcCheckTaskService.class);	
	/** 
	* @Fields checkTaskDao 工程验收操作dao
	*/ 
	private IProcCheckTaskDao checkTaskDao;
	/** 
	* @Fields tpushNewsService 消息提示操作dao
	*/ 
	@Resource
	private TpushNewsService tpushNewsService;
	/**保存验收任务
	 * @param jsonParam
	 * @return
	 * @see com.deppon.dpm.module.management.server.service.IProcCheckTaskService#saveCheckTask(java.lang.String)
	 */
	
	@Override
	public Response saveCheckTask(String jsonParam) {
		Map<String, String> retMap = new HashMap<String, String>();	
		//判断前台传入的参数是否为空
		if(StringUtil.isEmpty(jsonParam.trim())){
			retMap.put("isSuccess", "N");
			retMap.put("errorMsg", "传入的Json数据不能为空！");
		}
		//校验项目编码、项目名称
		//供应商、验收人工号，验收人名称是否有遗漏
		else if (checkIsParam("deptCode", jsonParam)||checkIsParam("deptName", jsonParam)||checkIsParam("providerName", jsonParam)||checkIsParam("checkEmpNo", jsonParam)||checkIsParam("checkEmpName", jsonParam)) {
			retMap.put("isSuccess", "N");
			retMap.put("errorMsg", "传入的json有参数遗漏！");
			logger.info("传入的json有参数遗漏！");
		}
		else {
			//把参数记录到日志
			logger.info("验收任务接收参数是: " + jsonParam);
			try {
				//根据前端传过来的参数
				ProcCheckTaskEntity checkTaskEntity = JsonUtil.jsonToEntity(jsonParam, ProcCheckTaskEntity.class);
				//设置为0表示营业部店面需要检查
				checkTaskEntity.setBranchIsCheck(0);
				//设置为0表示当前是否在检查
				checkTaskEntity.setIsCurrentCheck(0);
				//更新时间
				checkTaskEntity.setUpdateDate(new Date());
				//当前验收人工号
				checkTaskEntity.setCheckCurrentEmpNo("");
				//备注
				checkTaskEntity.setRemark("");
				if (StringUtil.isEmpty(checkTaskEntity.getDeptCode())) {
					retMap.put("isSuccess", "N");
					retMap.put("errorMsg", "项目编码不能为空！");
					logger.info("项目编码不能为空！");
				}
				else if (checkTaskDao.checkDeptCode(checkTaskEntity.getDeptCode())>=1) {
					//进入这个判断后，isSuccess表示 项目编码已存在，PC端可以正常保存，避免因为pc端删除后重新关联生成验收单存在的死锁情况。
					retMap.put("isSuccess", "Y");		
					//retMap.put("isRepeat","Y");
					retMap.put("errorMsg", "项目编码已存在！");
					logger.info("项目编码已存在！");
				}	
				//校验营业部
				else if (StringUtil.isEmpty(checkTaskEntity.getDeptCode())) {
					retMap.put("isSuccess", "N");
					retMap.put("errorMsg", "营业部不能为空！");
					logger.info("营业部不能为空！");
				}
				//校验供应商
				else if (StringUtil.isEmpty(checkTaskEntity.getProviderName())) {
					retMap.put("isSuccess", "N");
					retMap.put("errorMsg", "供应商不能为空！");
					logger.info("供应商不能为空！");					
				}
				//校验员工号
				else if (StringUtil.isEmpty(checkTaskEntity.getCheckEmpNo())) {
					retMap.put("isSuccess", "N");
					retMap.put("errorMsg", "员工号不能为空！");
					logger.info("员工号不能为空！");
				}
				//校验员工名称
				else if (StringUtil.isEmpty(checkTaskEntity.getCheckEmpName())) {
					retMap.put("isSuccess", "N");
					retMap.put("errorMsg", "员工名称不能为空！");
					logger.info("员工名称不能为空！");
				}
				//校验当前验收任务是否被操作
				else if (checkTaskDao.checkDeptCodeZero(checkTaskEntity.getDeptCode())>=1) {
					//更新验收任务信息
					int retInt = checkTaskDao.updateCheckTask(checkTaskEntity); 
					if (retInt>0) {
						retMap.put("isSuccess", "Y");
						retMap.put("errorMsg", "验收任务更新成功!");
						logger.info("验收任务保存成功!");
						//根据工号来推送消息
						String [] empNos = checkTaskEntity.getCheckEmpNo().split("\\|");
						Constants cons = new Constants();
						//消息推送
						for (int i = 0; i < empNos.length; i++) {
							//实例化消息实体工具类
							NewsCenterEntity newsCenterEntity = new NewsCenterEntity(cons.APP_MARK_A, cons.APP_MARK_B, cons.APP_MARK_C, cons.APP_MARK_D,
									"工程管理"); 
							//放入消息提示内容
							tpushNewsService.pushUserNews(empNos[i], "你有一个验收任务",  "工程验收任务",newsCenterEntity);
							logger.info("工号为"+empNos[i]+"的验收任务更新成功");
						}
					}
					else {
						retMap.put("isSuccess", "N");
						retMap.put("errorMsg", "验收任务保存失败!");
					}
				}
				else {
					//保存验收任务
					int retInt = checkTaskDao.saveCheckTask(checkTaskEntity);
					//如果保存成功
					if (retInt>0) {
						retMap.put("isSuccess", "Y");
						retMap.put("errorMsg", "验收任务保存成功!");
						logger.info("验收任务保存成功!");
						Constants cons = new Constants();
						//根据工号来推送消息
						String [] empNos = checkTaskEntity.getCheckEmpNo().split("\\|");
						for (int i = 0; i < empNos.length; i++) {
							//实例化消息实体工具类
							NewsCenterEntity newsCenterEntity = new NewsCenterEntity(cons.APP_MARK_A, cons.APP_MARK_B, cons.APP_MARK_C, cons.APP_MARK_D,
									"工程管理");
							//放入消息提示内容
							tpushNewsService.pushUserNews(empNos[i], "你有一个验收任务",  "工程验收任务",newsCenterEntity);
							logger.info("工号为"+empNos[i]+"的验收任务插入成功");
						}
					}
					else {
						retMap.put("isSuccess", "N");
						retMap.put("errorMsg", "验收任务保存失败!");
					}
				}				
			} catch (Exception e) {
				retMap.put("isSuccess", "N");
				retMap.put("errorMsg", "验收任务保存失败!");
				//记录错误信息到日志
				logger.info("验收任务保存失败!");
				logger.info("保存验收异常信息："+e.getMessage());
			}			
		}		
		// 返回
		return Response.ok(JsonUtil.mapToJsonString(retMap)).header("ESB-ResultCode", "1").build();		
	}
	
	
	/** (non-Javadoc)
	 * @param empNo
	 * @return
	 * @see 根据当前登录人工号查询验收任务数量
	 */
	public int queryTaskCount(String empNo) {
		int retInt = 0;
		//查询验收任务数量
		retInt = checkTaskDao.queryTaskCount(empNo);
		return retInt;
	}
	
	
	
	/** 
	* @Description: 判断json数据是否包含某个参数
	* @author 268087 张广波
	* @date 2015-8-14 下午3:44:50 
	*  @param checkParam
	*  @param jsonParam
	*  @return 
	*/
	private boolean checkIsParam(String checkParam,String jsonParam){
		boolean flag = true;
		//判断是否包含某个key的参数
		if (jsonParam.indexOf(checkParam)>0) {
			flag = false;
		}
		return flag;
	}

	/** 
	* @Description: 获取操作dao
	* @author 268087 张广波
	* @date 2016-1-5 下午3:59:26 
	*  @return 
	*/
	public IProcCheckTaskDao getCheckTaskDao() {
		return checkTaskDao;
	}

	/** 
	* @Description: 设置操作dao
	* @author 268087 张广波
	* @date 2016-1-5 下午3:59:37 
	*  @param checkTaskDao 
	*/
	public void setCheckTaskDao(IProcCheckTaskDao checkTaskDao) {
		this.checkTaskDao = checkTaskDao;
	}
	
}

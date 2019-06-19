package com.deppon.dpm.module.management.server.service.impl;

import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.management.server.dao.IProcSurveyCheckDao;
import com.deppon.dpm.module.management.server.service.IProcSurveyCheckService;
import com.deppon.dpm.module.management.shared.domain.ProcSurveyCheck;

/**
 * 工程勘测PC端推送APP接口
 * 
 * @author 293888
 * 
 */
public class ProcSurveyCheckService implements IProcSurveyCheckService {

	/**
	 * dao
	 */
	IProcSurveyCheckDao procSurveyCheckDao;

	/**
	 * 日志
	 */
	Logger log = LoggerFactory.getLogger(ProcSurveyCheckService.class);
	/**
	 * 与PC端数据同步接口
	 * 
	 * @param json
	 */
	@Override
	public Response saveprocSurvey(String json) {
		// TODO Auto-generated method stub
		String re = "{\"status\":0,\"message\":\"系统异常，更新失败\"}";
		// json =
		// "{'status':-1,'message':'这个不需要传送,是APP表示的状态','bill':'5656556864','self':0}";
		try {

			log.info("服务器接受的数据为：" + json);
			if (json == null || "".equals(json)) {
				re = "{\"status\":0,\"message\":\"您传入的参数为空\"}";
				return Response.ok(re).header("ESB-ResultCode", "1").build();
			}
			// 获取状态 -1===退回，0===审核中，1===已审核
			JSONObject parJson = JSONObject.parseObject(json);
			// 项目编码
			String checkCode = parJson.getString("projectNumber") == null ? ""
					: parJson.getString("projectNumber").trim();

			// 项目名称
			String checkName = parJson.getString("projectName") == null ? ""
					: parJson.getString("projectName").trim();

			// 设计单号
			String checkNo = parJson.getString("designNumber") == null ? ""
					: parJson.getString("designNumber").trim();

			// 项目类型
			String procStatus = parJson.getString("projectType") == null ? ""
					: parJson.getString("projectType").trim();

			// 勘测人员，以|分割
			String checkUserNo = parJson.getString("checkEmpNo") == null ? ""
					: parJson.getString("checkEmpNo").trim();

			// 项目经理工号
			String principalUserNo = parJson.getString("projectManagerNumber") == null ? ""
					: parJson.getString("projectManagerNumber").trim();

			// 项目经理名称
			String principalName = parJson.getString("projectManagerName") == null ? ""
					: parJson.getString("projectManagerName").trim();

			// 创建人工号
			String createUserNo = parJson.getString("createEmpNo") == null ? ""
					: parJson.getString("createEmpNo").trim();

			//非空校验
			if ("".equals(checkCode)) {

				re = "{\"isSuccess\":0,\"message\":\"传入的参数projectNumber不对\"}";
				return Response.ok(re).header("ESB-ResultCode", "1").build();
			}
			
			//非空校验
			if ("".equals(checkName)) {

				re = "{\"isSuccess\":0,\"message\":\"传入的参数projectName不对\"}";
				return Response.ok(re).header("ESB-ResultCode", "1").build();
			}
			
			//非空校验
			if ("".equals(checkNo)) {

				re = "{\"isSuccess\":0,\"message\":\"传入的参数designNumber不对\"}";
				return Response.ok(re).header("ESB-ResultCode", "1").build();
			}
			
			//非空校验
			if ("".equals(procStatus)) {

				re = "{\"isSuccess\":0,\"message\":\"传入的参数projectType不对\"}";
				return Response.ok(re).header("ESB-ResultCode", "1").build();
			}
			
			//非空校验
			if ("".equals(checkUserNo)) {
                
				re = "{\"isSuccess\":0,\"message\":\"传入的参数checkEmpNo不对\"}";
				//返回结果集
				return Response.ok(re).header("ESB-ResultCode", "1").build();
			}
			
			//非空校验
			if ("".equals(principalUserNo)) {

				re = "{\"isSuccess\":0,\"message\":\"传入的参数projectManagerNumber不对\"}";
				//返回结果集
				return Response.ok(re).header("ESB-ResultCode", "1").build();
			}
			
			//非空校验
			if ("".equals(principalName)) {

				re = "{\"isSuccess\":0,\"message\":\"传入的参数projectManagerName不对\"}";
				//返回结果集
				return Response.ok(re).header("ESB-ResultCode", "1").build();
			}
			
			//非空校验
			if ("".equals(createUserNo)) {

				re = "{\"isSuccess\":0,\"message\":\"传入的参数createEmpNo不对\"}";
				//返回结果集
				return Response.ok(re).header("ESB-ResultCode", "1").build();
			}
			

			// 项目勘测对象
			ProcSurveyCheck procSurveyCheck = new ProcSurveyCheck();
			// 封装对象
			procSurveyCheck.setCheckCode(checkCode);
			//塞入数据
			procSurveyCheck.setCheckName(checkName);
			//塞入数据
			procSurveyCheck.setCheckNo(checkNo);
			//塞入数据
			procSurveyCheck.setProcStatus(procStatus);
			//塞入数据
			procSurveyCheck.setCheckUserNo(checkUserNo);
			procSurveyCheck.setPrincipalName(principalName);
			procSurveyCheck.setPrincipalUserNo(principalUserNo);
			//塞入数据
			procSurveyCheck.setCreateUserNo(createUserNo);
			//时间的塞入
			procSurveyCheck.setCreateDate(new Date());
			//时间的塞入
			procSurveyCheck.setUpdateDate(new Date());
			
			//上面代码处理推送过来的数据
			//下面代码处理业务
			//首先检测重复数据,如果存在则把已存在的失效掉，然后保存，如果不存在直接保存
			List<ProcSurveyCheck> list =   procSurveyCheckDao.getCountByCode(checkName, checkCode);
			if(null!=list && list.size()>0){
				ProcSurveyCheck temp = list.get(0);
				int updflag = procSurveyCheckDao.updSurveyMark(temp.getId());
				if(updflag<1){
					re = "{\"isSuccess\":0,\"message\":\"去除重复数据失败\"}";
					log.error("去除重复数据失败,失败 项目编码："+checkCode);
				}
			}
			//插入数据
			int flag = procSurveyCheckDao.saveprocSurvey(procSurveyCheck);
			//判断数据是否插入成功
			if(flag>0){
				re = "{\"isSuccess\":1,\"message\":\"推送成功\"}";
			}else{
				re = "{\"isSuccess\":0,\"message\":\"推送失败\"}";
			}
			
		} catch (Exception e) {
			//捕获异常
			// TODO: handle exception
			re = "{\"isSuccess\":0,\"message\":\"系统异常，推送失败\"}";
			log.error("系统异常:"+e);
		}
		//返回
		return Response.ok(re).header("ESB-ResultCode", "1").build();
	}
	
	

	/**
	 * dao
	 * 
	 * @return
	 */
	public IProcSurveyCheckDao getProcSurveyCheckDao() {
		return procSurveyCheckDao;
	}
	/**
	 * dao
	 * 
	 * @return
	 */
	public void setProcSurveyCheckDao(IProcSurveyCheckDao procSurveyCheckDao) {
		this.procSurveyCheckDao = procSurveyCheckDao;
	}



	/* 
	 * 查询勘测列表
	 *
	 * @see com.deppon.dpm.module.management.server.service.IProcSurveyCheckService#getProjectList(java.lang.String, java.lang.String)
	 */
	@Override
	public List<ProcSurveyCheck> getProjectList(String userNo, String keyWord)
			throws Exception {
		// TODO Auto-generated method stub
		return procSurveyCheckDao.getProjectList(userNo, keyWord);
	}

}

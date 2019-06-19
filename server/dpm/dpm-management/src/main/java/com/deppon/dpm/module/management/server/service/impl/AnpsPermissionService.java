package com.deppon.dpm.module.management.server.service.impl;

import java.net.URLDecoder;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.module.common.shared.define.DpmConstants;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.management.server.service.IAnpsPermissionService;
import com.deppon.dpm.module.management.server.service.IAppPermissionService;
import com.deppon.dpm.module.management.shared.domain.AppPermissionEntity;
import com.deppon.dpm.tongxunlu.server.dao.IEmployeeDao;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.shared.domain.EmployeeEntity;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;

@Produces("application/json")
@Consumes("application/json")
public class AnpsPermissionService implements IAnpsPermissionService {

	/**
	 * 应用权限表
	 */
	private IAppPermissionService appPermissionService;
	/**
	 * 员工信息service注入
	 */
	private IEmployeeDao employeeDao;
	/**
	 * 日志
	 */
	private static Logger logger  = LoggerFactory.getLogger(AnpsPermissionService.class);
	

	@POST
	@Path("/query")
	public Response isHaveAppPermission(String request) {
		// TODO Auto-generated method stub
		Result<Boolean> result = new Result<Boolean>();
		try {
			String jsonStr = URLDecoder.decode(request.replaceAll("\ufeff", ""),"utf-8");
			JSONObject obj = JSONObject.fromObject(jsonStr);
			String userId = obj.getString("userId");
			// 用以查询
			EmployeeVO vo = new EmployeeVO();
			// 设置查询参数
			vo.setEmpCode(userId);
			// 查询实体
			EmployeeEntity entity = employeeDao.selectOne(vo);
			Boolean hasPermission = this.appPermission(entity, DpmConstants.doc);
			result.setData(hasPermission);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
		} catch (Exception e) {
			// TODO: handle exception
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("请求异常:" + e);
			e.printStackTrace();
			return Response.serverError()
							// json返回
							.entity(e.toString())
							// 头消息类型
							.header(HttpHeaders.CONTENT_TYPE,
							MediaType.APPLICATION_JSON + ";charset=UTF-8")
							// 跨域请求处理
							.header("Access-Control-Allow-Origin", "*").build();
		}
		// count
		result.setCount(1);
		return resultToResponse(result);
	}
	/**
	 * 应用权限控制  true表示有权限 false表示没权限 
	 * @param employee
	 * @param appid
	 * @return
	 */
	private boolean appPermission(EmployeeEntity employee, int appid) {
		try {
			//权限获取
			List<AppPermissionEntity> apps = appPermissionService.getAppPermission(appid);
			if (apps == null || apps.size() == 0) {
				//所有人都有权限
				return true;
			}else {
				//组织序列
				String deptSeq = appPermissionService.getDeptSeqByUserId(employee.getEmpCode());
				for (AppPermissionEntity entity : apps) {
					String orgid = "." + String.valueOf(entity.getOrgid()) + "." ;//组织id
					String userid = entity.getUserid();//工号
					String level = entity.getLevel();//层级
					if (deptSeq.indexOf(orgid) != -1) {
						return true;
					}
					if (employee.getEmpCode().equals(userid)) {
						return true;
					}
					if (level != null) {
						if (level.indexOf(employee.getJobLevel()) != -1) {
							return true;
						}
					}
					/*System.out.println("000000");*/
				}
			}
			return false;
		} catch (Exception e) {
			logger.error("获取应用权限异常 工号：" + employee.getEmpCode() + "应用id:" + String.valueOf(appid) + " 异常原因：" + e);
			return false;
		}
		
	}
	/**
	 * 封装数据返回给response
	 */
	private Response resultToResponse(Result<Boolean> result) {
		// 即如果返回
		return Response
				.ok()
				// json返回
				.entity(JSON.toJSONString(result))
				// 头消息类型
				.header(HttpHeaders.CONTENT_TYPE,
						MediaType.APPLICATION_JSON + ";charset=UTF-8")
				// 跨域请求处理
				.header("Access-Control-Allow-Origin", "*").build();
	}

	
	
	public void setAppPermissionService(IAppPermissionService appPermissionService) {
		this.appPermissionService = appPermissionService;
	}
	public void setEmployeeDao(IEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
}

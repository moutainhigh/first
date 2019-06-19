package com.deppon.dpm.module.management.server.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.shared.define.DpmConstants;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.management.server.service.IAppPermissionService;
import com.deppon.dpm.module.management.server.service.ILocationPermissionService;
import com.deppon.dpm.module.management.shared.domain.AppPermissionEntity;
import com.deppon.dpm.module.management.shared.domain.LocationPermissionEntity;
import com.deppon.dpm.tongxunlu.server.dao.IEmployeeDao;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.domain.EmployeeEntity;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
/**
 * 获取定位权限
 * @author 276344
 *
 */
public class LocationPermissionAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 应用权限表
	 */
	private ILocationPermissionService locationPermissionService;
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
	private static Logger logger  = LoggerFactory.getLogger(LocationPermissionAction.class);
	
	
	public void getLocationPermission(){
		//localhost:8080/dpm/dpm-management/appPermission_isHaveAppPermission.action?userId=276344
		Result<Boolean> result = new Result<Boolean>();
		try {
			// 用以查询
			EmployeeVO vo = new EmployeeVO();
			// 设置查询参数
			vo.setEmpCode(userId);
			// 查询实体
			EmployeeEntity entity = employeeDao.selectOne(vo);
			Boolean hasPermission = this.appPermission(entity);
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
		}
		// count
		result.setCount(1);
		// 返回
		writeToPage(result);

	}   
	
	/**
	 * 应用权限控制  true表示有权限 false表示没权限 
	 * @param employee
	 * @param appid
	 * @return
	 */
	private boolean appPermission(EmployeeEntity employee) {
		try {
			//权限获取
			List<LocationPermissionEntity> locationPermissionList = locationPermissionService.getLocationPermission();
			if (locationPermissionList == null || locationPermissionList.size() == 0) {
				//所有人都有权限
				return false;
			}else {
				//组织序列
				String deptSeq = appPermissionService.getDeptSeqByUserId(employee.getEmpCode());
				for (LocationPermissionEntity entity : locationPermissionList) {
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
			logger.error("获取应用权限异常 工号：" + employee.getEmpCode()  + " 异常原因：" + e);
			return false;
		}
		
	}
	
	
	public ILocationPermissionService getLocationPermissionService() {
		return locationPermissionService;
	}

	public void setLocationPermissionService(
			ILocationPermissionService locationPermissionService) {
		this.locationPermissionService = locationPermissionService;
	}

	public void setEmployeeDao(IEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public void setAppPermissionService(IAppPermissionService appPermissionService) {
		this.appPermissionService = appPermissionService;
	}
	
}

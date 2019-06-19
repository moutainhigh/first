package com.deppon.dpm.doc.server.action;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.doc.server.service.IChoosePersonService;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.service.impl.RedisService;
import com.deppon.dpm.tongxunlu.server.service.IExternalMethodService;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;

/**
 * 选择人员Action
 * 
 * @author lvdf
 * @date 2018年3月3日14:37:33
 */
public class ChoosePersonAction extends BaseAction {

	private static final long serialVersionUID = -4326215964750308168L;
	private static final Logger logger = LoggerFactory
			.getLogger(ChoosePersonAction.class);
	// 人员姓名
	private String employee;
	
	private String mobileno;

	// 人员工号
	// private String userId;

	// 选择人员service
	private IChoosePersonService choosePersonService;

	private IExternalMethodService externalMethodService;
	
	private RedisService redisService;

	/**
	 * 根据工号或姓名查找该人员信息
	 * 
	 * @author lvdf
	 * @date 2018年3月3日15:12:12
	 */
	@CookieNotCheckedRequired
	public void queryOldPerson() {
		JSONObject jonum = new JSONObject();
		List<EmployeeVO> employeeList = new ArrayList<EmployeeVO>();
		logger.info("<<<<<<<<<<<查找人员信息开始>>>>>>>>>>>");
		// if(userName != null){
		// employee = userName;
		employeeList = externalMethodService.getEmpInfolist(employee);
		List<EmployeeVO> newemployeeList = new ArrayList<EmployeeVO>();
		for(EmployeeVO temp : employeeList){
			if("管理族群".equals(temp.getJobGroups())){
				if(temp.getHeadPhoto()==null){
					temp.setHeadPhoto("");
				}
				newemployeeList.add(temp);
			}
		}
		jonum.put("userName", newemployeeList);
		// }else{
		// employee = userId;
		// employeeList = externalMethodService.getEmpInfolist(employee);
		// jonum.put("userCode", employeeList);
		// }
		logger.info("<<<<<<<<<<<查找人员信息结束>>>>>>>>>>>");
		// 返回页面数据
		writeToPage(jonum);
	}

	/**
	 * 获取员工直属上级的信息
	 * 
	 * @author lvdf
	 * @date 2018年3月3日15:12:12
	 */
	public void queryuserSuperior() {
		JSONObject jonum = new JSONObject();
		String empCode = userId;
		logger.info("<<<<<<<<<<<查找员工直属上级开始>>>>>>>>>>>");
		String leaderCode = redisService.get(RedisService.DPM_DOC_LEADER_CODE_KEY + empCode);
		EmployeeVO evo = new EmployeeVO();
		if(leaderCode == null || leaderCode.trim().length() == 0){
			evo = externalMethodService.getLeaderInfo(empCode);	
		}else{
			evo = externalMethodService.getEmpInfo(leaderCode);
		}
		
		//任职资格服务组的审核人为张欢
		EmployeeVO empVo = externalMethodService.getEmpInfo(empCode);
		if(empVo.getOrgId() == 501481){
			evo = externalMethodService.getEmpInfo("106154");
		}
		
		logger.info("<<<<<<<<<<<查找员工直属上级结束>>>>>>>>>>>");
		if(evo != null){
			jonum.put("findmsg", "success");
			jonum.put("auditorname", evo);
		}else{
			jonum.put("findmsg", "没有查询到直属上级数据");
			jonum.put("auditorname", "null");
		}
		// 返回页面数据 empCode
		writeToPage(jonum);
	}

	public IChoosePersonService getChoosePersonService() {
		return choosePersonService;
	}

	public void setChoosePersonService(IChoosePersonService choosePersonService) {
		this.choosePersonService = choosePersonService;
	}
	/**
	 * 拜访客户校验手机号
	 * 
	 */
	@CookieNotCheckedRequired
	public void queryTelByData() {
		
		boolean result = externalMethodService.getSameMobile(mobileno);
		JSONObject jonum = new JSONObject();
		jonum.put("msg", "success");
		jonum.put("result", result);
		// 返回页面数据 empCode
		writeToPage(jonum);
	}

	/**
	 * @return the employee
	 */
	public String getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(String employee) {
		this.employee = employee;
	}

	/**
	 * @return the externalMethodService
	 */
	public IExternalMethodService getExternalMethodService() {
		return externalMethodService;
	}

	/**
	 * @param externalMethodService
	 *            the externalMethodService to set
	 */
	public void setExternalMethodService(
			IExternalMethodService externalMethodService) {
		this.externalMethodService = externalMethodService;
	}

	/**
	 * @return the mobileno
	 */
	public String getMobileno() {
		return mobileno;
	}

	/**
	 * @param mobileno the mobileno to set
	 */
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public RedisService getRedisService() {
		return redisService;
	}

	public void setRedisService(RedisService redisService) {
		this.redisService = redisService;
	}
	
	

}

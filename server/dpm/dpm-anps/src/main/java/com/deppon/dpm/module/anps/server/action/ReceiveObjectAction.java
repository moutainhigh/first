package com.deppon.dpm.module.anps.server.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import com.deppon.dpm.module.anps.server.service.IReceiveObjectService;
import com.deppon.dpm.module.anps.shared.domain.NoticeJobEntity;
import com.deppon.dpm.module.anps.shared.domain.OrganizationEntity;
import com.deppon.dpm.module.anps.shared.domain.ReceiveObjectResult;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.tongxunlu.server.util.Constants;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
/**
 * 公告ACTION
 * @author 276344
 *
 */


public class ReceiveObjectAction extends BaseAction{
	
	//通讯录根据orgid获取子组织信息及人员信息接口
	//   /dpm/tongxunlu_getChildByOrg.action?id=(orgid)&userId=
	private static final long serialVersionUID = 1L;
	//private static Logger logger  = LoggerFactory.getLogger(ReceiveObjectAction.class);
	private IReceiveObjectService receiveService;
	
	//组织id
	private String orgid;
	//岗位名称
	private String jobName; 



	/**
	 * 根据上级组织id查询结果，含有人员列表和子组织机构列表.及岗位列表 
	 */
	/*@CookieNotCheckedRequired
	public void getChildByOrg() {
		this.solveCrossDomain();
		// 接口地址：http://localhost:8080/dpm/dpm-anps/anps_getChildByOrg.action?orgid=10051
		//  加一步 通过工号获取组织号
		Result<ReceiveObjectResult> result = new Result<ReceiveObjectResult>();
		ReceiveObjectResult resultObject = new ReceiveObjectResult();
		// 校验组织id是否合法
		if(StringUtils.isBlank(orgid) || !StringUtils.isNumeric(orgid)){
			result.setErrorCode(Constants.WRONG_REQUEST);
			result.setErrorMessage("传入参数组织id错误：" + orgid);
			writeToPage(result);
			return;
		}
	
		try {
			//根据工号获取组织id
			//String aa = receiveService.getOrgidByEmpCode("116250");
			
			//某个部门下的所有子部门加起来的人数
			Integer num = receiveService.getDepartmentMemberNumByOrgid(orgid);
			
			//该部门下的组织名称（非递归）
			List<OrganizationEntity> orgs = receiveService.getChildOrgInfoByOrgid(orgid);
			//该部门下的员工
			List<EmployeeVO> emps = receiveService.getEmpInfoByOrgid(orgid);
			//按岗位
			List<NoticeJobEntity> jobs = receiveService.getJobList(orgid);
			//人数
			resultObject.setEmpNum(num);
			//组织
			resultObject.setOrgs(orgs);
			//人员
			resultObject.setEmps(emps);
			resultObject.setJobs(jobs);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
			//  添加 头像 及 人数
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("请求异常:" + e);
		}
		// count
		result.setCount(1);
		// data
		result.setData(resultObject);
		// 返回
		writeToPage(result);
	}*/
	
	/**
	 * 公文创建群组时 点击岗位接口
	 */
	/*@CookieNotCheckedRequired
	public void getChildByJob() {
		//接口  http://localhost:8080/dpm/dpm-anps/anps_getChildByJob.action?orgid=104&jobName=快递员
		this.solveCrossDomain();
		//  加一步 通过工号获取组织号
		Result<ReceiveObjectResult> result = new Result<ReceiveObjectResult>();
		ReceiveObjectResult resultObject = new ReceiveObjectResult();
		// 校验组织id是否合法
		if(StringUtils.isBlank(orgid) || !StringUtils.isNumeric(orgid) || StringUtils.isBlank(jobName)){
			result.setErrorCode(Constants.WRONG_REQUEST);
			result.setErrorMessage("传入参数错误" + "orgid:" + orgid + " jobName" + jobName);
			writeToPage(result);
			return;
		}

		try {
			//岗位  下的组织 用 人数
			List<OrganizationEntity> orgs = receiveService.getJobNumber(orgid, jobName);
			
			//岗位下的员工
			List<EmployeeVO> emps = receiveService.getJobEmp(orgid, jobName);
			
			//组织下 xx 岗位员工数
			Integer num = receiveService.jobNum(orgid, jobName);
			
			//人数
			resultObject.setEmpNum(num);
			//组织
			resultObject.setOrgs(orgs);
			//人员
			resultObject.setEmps(emps);
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_SUC);
			// errorMessage
			result.setErrorMessage(Constants.ACTIVE_YES);
			//  添加 头像 及 人数
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			// errorCode
			result.setErrorCode(Constants.ACTION_RESULT_ERROR);
			// errorMessage
			result.setErrorMessage("请求异常:" + e);
		}
		// count
		result.setCount(1);
		// data
		result.setData(resultObject);
		// 返回
		writeToPage(result);
	}*/
	
	/**
	 * 解决H5跨域
	 */
	public void solveCrossDomain(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
	}
	
	
	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	public void setReceiveService(IReceiveObjectService receiveService) {
		this.receiveService = receiveService;
	}

	
	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
}

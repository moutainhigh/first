package com.deppon.dpm.module.wfs.server.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.wfs.server.dao.IDepartmentDao;
import com.deppon.dpm.module.wfs.server.service.IDLspWorkInfoService;
import com.deppon.dpm.module.wfs.server.util.RestfulUtil;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowBusinessData;

/**
 * 
 * 固定资产盘点工作流Service
 * @author 195406 高春玲
 * @date 2015-3-30 下午1:45:08
 **/
public class DLspWorkInfoService implements IDLspWorkInfoService {

	private static Logger logger  = LoggerFactory.getLogger(DLspWorkInfoService.class);
    //服务端查询接口地址
	private String uri;
	//服务端审批接口地址
	private String approvuri;
	//申报部门查询接口地址
	private String departurl;
	//资产查询接口地址
	private String qeuryuri;
	//DAO
	private IDepartmentDao departmentDao;
    /**
	 * @param departmentDao the departmentDao to set
	 */
	public void setDepartmentDao(IDepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	/**
     * 工作流查询  根据请求参数 调用服务端地址 获得工作流详情
     */
	@Override
	public String queryWorkInfo(WorkflowBusinessData workflowInfo) {
		logger.info("dlsp querywfs url is :" + this.uri);
		return RestfulUtil.querylmsInfo(
						this.uri,
						workflowInfo);
	}
	/**
	 * 工作流审批  根据请求参数审批信息 执行审批操作
	 */
	@Override
	public String approveWorkInfo(Object audit){
		logger.info("dlsp approvewfs url is :" + this.approvuri);
		return RestfulUtil.querylmsInfo(
				this.approvuri,
				audit);
	}
	/**
	 * 根据参数模糊查询部门名字
	 * <p>Description: TODO</p>
	 * @param 查询部门的条件
	 * @return 部门名字
	 */
	@Override
	public String departmentQeury(Map<String, String> departmentmap)
			 {
		logger.info("dlsp approvuri url is:" + this.departurl);
		return RestfulUtil.restfulWork(this.departurl, "ESB_APP2ESB_ORGANIZE_NAME_TRANSFER_APP" , JsonUtil.mapToJsonObject(departmentmap).toJSONString(),"dlspDeptQuery");
	}
	/*** 
	 * @author 280769
     * @date 2016-4-22
	 * 资产查询
	 * */
	@Override
	public String assetsQeury(Object json) {
			//打印日志
			logger.info("dlsp queryassets url is:" + this.qeuryuri);
			//给PC端传参数
			return RestfulUtil.querylmsInfo(this.qeuryuri,json);
	}
	/**
	 * @param 根据userId查询部门code
	 * @return 
	 */
	@Override
	public String deptCodeQuery(String userId)  {
		// TODO Auto-generated method stub getEmpList
		return departmentDao.getDeptCode(userId);
	}
	/**
	 * @param uri the uri to set
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}
	/**
	 * @param approvuri the approvuri to set
	 */
	public void setApprovuri(String approvuri) {
		this.approvuri = approvuri;
	}
	/**
	 * @param departurl the departurl to set
	 */
	public void setDeparturl(String departurl) {
		this.departurl = departurl;
	}
	/**
	 * @param qeuryuri the qeuryuri to set
	 */
	public void setQeuryuri(String qeuryuri) {
		this.qeuryuri = qeuryuri;
	}


}

package com.deppon.dpm.module.wfs.server.service.impl;

import java.util.List;
import java.util.Map;

import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.wfs.server.dao.IDepartmentDao;
import com.deppon.dpm.module.wfs.server.service.IDWFSWorkInfoService;
import com.deppon.dpm.module.wfs.server.util.RestfulUtil;
import com.deppon.dpm.module.wfs.shared.domain.DepEntity;
import com.deppon.dpm.module.wfs.shared.domain.EmpEntity;

/**
 * <p>ClassName: 移动办公与服务补救申请处理查询接口Service</p>
 * <p>Description: TODO</p>
 * <p>Author: 石学钢</p>
 * <p>Date: 2015-7-21</p>
 */
public class DWFSWorkInfoService implements IDWFSWorkInfoService{

	// 查询Url
	private String qureyUrl;
	// 审批Url 
	private String approveUrl;
	//部门查询url
	private String departUrl;
	//产品线查询url
	private String noaSystemUrl;
	
	private IDepartmentDao departmentDao;
	
	public void setDepartmentDao(IDepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public void setQureyUrl(String qureyUrl) {
		this.qureyUrl = qureyUrl;
	}

	public void setApproveUrl(String approveUrl) {
		this.approveUrl = approveUrl;
	}
	
	/**
	 * 工作流查询接口
	 */
	@Override
	public String disposeQuery(String json) throws Exception {
		// http://wfs.deppon.com/wfs/webservice/app?_wadl
		// http://192.168.1.103:8881/wfs/webservice/app/queryBusinessInfo
		return RestfulUtil.restfulWork(qureyUrl,"ESB_DPM2ESB_RELASE_APPLY_HANDLE_EXAM_INTF",json,"dwfs");
	}
	
	/**
	 * 工作流审批接口
	 */
	@Override
	public String approval(String mobileWorkApprovalInfo)
			throws Exception {
		// http://192.168.1.103:8881/wfs/webservice/app/approvalMontalWorkFlow
		return RestfulUtil.restfulWork(approveUrl,"ESB_DPM2ESB_RELEASE_APPLY_QUERY_INTF",mobileWorkApprovalInfo,"dwfs");
	}
	/**
	 * 工作流查询接口
	 */
//	@Override
//	public String disposeQuery(String busino,String processDefName,String processInstId) throws Exception {
//		Map<String, String> obj=new HashMap<String, String>();
//		obj.put("processDefName",processDefName);
//		obj.put("busino",busino);
//		obj.put("processInstId",processInstId);
//		logger.info(JsonUtil.mapToJsonObject(obj).toJSONString());
//		return RestfulUtil.restfulWork(qureyUrl,"ESB_DPM2ESB_RELASE_APPLY_HANDLE_EXAM_INTF",JsonUtil.mapToJsonObject(obj).toJSONString(),"dwfs");
//	}
	/**
	 * 根据参数模糊查询部门名字
	 * <p>Description: TODO</p>
	 * @param 查询部门的条件
	 * @return 部门名字
	 */
	@Override
	public String departmentQeury(Map<String, String> departmentmap)
			throws Exception {
		return RestfulUtil.restfulWork(departUrl,"ESB_DPM2ESB_CONTRACT_SIGN_APPLY",JsonUtil.mapToJsonObject(departmentmap).toJSONString(),"dwfsdeptQuery");
	}
	public void setDepartUrl(String departUrl) {
		this.departUrl = departUrl;
	}

    @Override
    public List<DepEntity> getDepList(String text) throws Exception {
        // TODO Auto-generated method stub
        return departmentDao.getOrgList(text);
    }
	/**
	 * @param 合同部门查询
	 * @return 
	 */
	@Override
	public List<EmpEntity> getEmpList(String emp) throws Exception {
		// TODO Auto-generated method stub getEmpList
		return departmentDao.getEmpList(emp);
	}
	/**
	 * @param 产品线查询
	 * @return 
	 */
	@Override
	public String getSystemList(String systemName,String pid) throws Exception {
		if(systemName != null && !systemName.equals("")){
			systemName = systemName.toUpperCase();
		}
		if(pid == null) {
			pid = "";
		}
		String info = "{\"changeEntity\":{\"pId\":\"" + pid + "\",\"splitFlowMenu\":\"" + systemName + "\"},\"pageNo\":\"1\",\"pageSize\":\"100\"}";
		return RestfulUtil.restfulWork(noaSystemUrl,"",info,"noaSystemQuery");
	}

	/**
	 * @param noaSystemUrl the noaSystemUrl to set
	 */
	public void setNoaSystemUrl(String noaSystemUrl) {
		this.noaSystemUrl = noaSystemUrl;
	}
	
}

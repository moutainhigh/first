package com.deppon.dpm.module.anps.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.deppon.dpm.module.anps.server.dao.INoticeSearchDao;
import com.deppon.dpm.module.anps.server.dao.IReceiveObjectDao;
import com.deppon.dpm.module.anps.server.service.INoticeSearchService;
import com.deppon.dpm.module.anps.shared.domain.OrganizationEntity;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;

public class NoticeSearchService implements INoticeSearchService {
	private INoticeSearchDao searchDao;
	private IReceiveObjectDao receiveDao;
	private String webUrl;

	/**
	 * 根据组织名称搜索
	 * 
	 * @param orgName
	 */
	@Override
	public List<OrganizationEntity> getOrgs(String orgName, String orgid) {
		List<OrganizationEntity> orgs = searchDao.getOrgs(orgName, orgid);
		for (OrganizationEntity org : orgs) {
			int ogid = org.getOrgId();
			Integer num = receiveDao.getDepartmentMemberNumByOrgid(String
					.valueOf(ogid));
			org.setEmpNum(num);
		}
		return orgs;
	}

	/**
	 * 根据工号或名字搜
	 * 
	 * @param empCode
	 * @param empName
	 */
	@Override
	public List<EmployeeVO> getEmps(String empCode, String empName,
			String orgid, Integer pageNo) {
		List<EmployeeVO> result = new ArrayList<EmployeeVO>();
		List<EmployeeVO> emps = searchDao.getEmps(empCode, empName, orgid,
				pageNo);
		if (null != emps && emps.size() > 0) {
			for (EmployeeVO emp : emps) {

				emp.setHeadPhoto(getPath(emp));
				result.add(emp);
			}
		}

		return result;
	}

	/**
	 * 根据组织ID搜索部门员工
	 * 
	 * @param orgId
	 */
	@Override
	public List<EmployeeVO> getEmpByOrgId(String orgId) {
		return searchDao.getEmpByOrgId(orgId);

	}

	/**
	 * 查询员工通过岗位
	 */
	@Override
	public List<EmployeeVO> getEmpByJobName(String memberCode, String memberName) {
		return searchDao.getEmpByJobName(memberCode, memberName);

	}

	/**
	 * 根据员工号 获取组织
	 * 
	 * @param memberCode
	 * @param memberName
	 */
	@Override
	public OrganizationEntity getOrgByEmpCode(String userId) {
		return searchDao.getOrgByEmpCode(userId);
	}

	/**
	 * 根据员工号获取员工信息
	 * 
	 * @param memberCode
	 * @param memberName
	 */
	@Override
	public EmployeeVO getEmpByEmpCode(String userId) {
		return searchDao.getEmpByEmpCode(userId);
	}
	/**
	 * 根据部门获取部门信息
	 * 
	 * @param memberCode
	 * @param memberName
	 */
	@Override
	public OrganizationEntity getEmpDetailByOrgId(String orgId) {
		return searchDao.getEmpDetailByOrgId(orgId);
	}

	// 获取头像路径
	public String getPath(EmployeeVO noticeMessage) {
		StringBuffer sb = new StringBuffer();
		sb.append(webUrl + "/" + "dpmfile" + "/");
		sb.append("headPhoto/");
		// 获取文件名
		String path = noticeMessage.getHeadPhoto();
		if (null != path && !path.equals("")) {
			// 拼接文件名
			path = sb.append(path).toString();
		} else {
			path = "";
		}
		return path;
	}

	public void setSearchDao(INoticeSearchDao searchDao) {
		this.searchDao = searchDao;
	}

	public void setReceiveDao(IReceiveObjectDao receiveDao) {
		this.receiveDao = receiveDao;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	

}

package com.deppon.dpm.module.anps.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.deppon.dpm.module.anps.server.dao.IReceiveObjectDao;
import com.deppon.dpm.module.anps.server.service.IReceiveObjectService;
import com.deppon.dpm.module.anps.shared.domain.NoticeJobEntity;
import com.deppon.dpm.module.anps.shared.domain.OrganizationEntity;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;

public class ReceiveObjectService implements IReceiveObjectService {
	private IReceiveObjectDao receiveDao;
	
	private String webUrl;
	
	/**
	 * 根据Orgid获取其下面的所有子组织信息
	 * @return
	 */
	@Override
	public List<OrganizationEntity> getChildOrgInfoByOrgid(String orgid) {
		// TODO Auto-generated method stub
		List<OrganizationEntity> entityList = new ArrayList<OrganizationEntity>();
		List<OrganizationEntity> entitys = receiveDao.getChildOrgInfoByOrgid(orgid);
		for (OrganizationEntity entity : entitys) {
			int id = entity.getOrgId();
			Integer num = receiveDao.getDepartmentMemberNumByOrgid(String.valueOf(id));
			entity.setEmpNum(num);
			if (num != 0) {
				//如果数量为0 则不显示该组织
				entityList.add(entity);
			}
		}
		return entityList;
	}

	/**
	 * 查询组织下面所有员工的信息
	 * @param orgid
	 * @return
	 */
	@Override
	public List<EmployeeVO> getEmpInfoByOrgid(String orgid) {
		// TODO Auto-generated method stub
		List<EmployeeVO> empDetail = new ArrayList<EmployeeVO>();
		List<EmployeeVO> empInfos = receiveDao.getEmpInfoByOrgid(orgid);
		if (null != empInfos && empInfos.size() > 0) {
			for (EmployeeVO empInfo : empInfos) {
				String headPhoto = getPath(empInfo);
				empInfo.setHeadPhoto(headPhoto);
				empDetail.add(empInfo);
			}
		}
		return empDetail;
	}
	
	
	// 获取头像路径
		public String getPath(EmployeeVO noticeMessage) {
			StringBuffer sb = new StringBuffer();
			sb.append(webUrl + "/"+"dpmfile"+"/");
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
	/**
	 * 根据员工工号获取部门id
	 * @param empCode
	 * @return
	 */
	@Override
	public String getOrgidByEmpCode(String empCode) {
		
		return receiveDao.getOrgidByEmpCode(empCode);
	}
	/**
	 * 递归查询组织下所有部门员工的总数
	 * @param orgid
	 * @return
	 */
	@Override
	public Integer getDepartmentMemberNumByOrgid(String orgid) {
		// TODO Auto-generated method stub
		return receiveDao.getDepartmentMemberNumByOrgid(orgid);
	}

    /**
	 * 获取岗位信息
	 * @return
	 */
	@Override
	public List<NoticeJobEntity> getJobList(String orgid) {
		//从这里开始开
		List<NoticeJobEntity> entitys = receiveDao.getJobList(orgid);
		for (NoticeJobEntity entity : entitys) {
			Integer num = receiveDao.getJobNumber(orgid, entity.getJobName());
//			if (num == 0 || num == null) {
//				num = 0;
//			}
			entity.setNum(num);
		}
		return entitys;
	}
	
	/**
	 * xx部门下的所有子部门  岗位为xx 的总人数 
	 * @param orgid 部门id
	 * @param jobName 岗位
	 * @return
	 */
	@Override
	public List<OrganizationEntity> getJobNumber(String orgid, String jobName) {
		List<OrganizationEntity> entityList = new ArrayList<OrganizationEntity>();
		List<OrganizationEntity> entitys = receiveDao.getChildOrgInfoByOrgid(orgid);
		for (OrganizationEntity entity : entitys) {
			int id = entity.getOrgId();
			Integer num = receiveDao.getJobNumber(String.valueOf(id), jobName);
			entity.setEmpNum(num);
			if (num != 0) {
				//如果数量为0 则不显示该组织
				entityList.add(entity);
			}
		}
		return entityList;
	}
	 
	
	/**
	 * 查询xx岗位xx组织所有员工信息
	 * @param orgid
	 * @return
	 */
	@Override
	public List<EmployeeVO> getJobEmp(String orgid, String jobName) {
		// TODO Auto-generated method stub
		return receiveDao.getJobEmp(orgid, jobName);
	}
	/**
	 * xx部门 下 xx 岗位人数
	 * @param orgid
	 * @param jobName
	 * @return
	 */
	@Override
	public Integer jobNum(String orgid, String jobName) {
		return receiveDao.getJobNumber(orgid, jobName);
	}
		
	/**
	 * 获取部门领导
	 * @return
	 */
	@Override
	public List<EmployeeVO> getLeaderEmpInfoByOrgid(String orgid) {
		// TODO Auto-generated method stub
		return receiveDao.getLeaderEmpInfoByOrgid(orgid);
	}
	
	

	@Override
	public List<String> getLeaderEmpByOrgid(String orgid) {
		List<String> userIds = new ArrayList<String>();
		//该部门下的组织名称（非递归）
		List<OrganizationEntity> orgs = this.getChildOrgInfoByOrgid(orgid);
		for (OrganizationEntity org : orgs) {
			
			List<EmployeeVO> empCodes=this.getLeaderEmpInfoByOrgid(String.valueOf(org.getOrgId()));
			if(null!=empCodes&&empCodes.size()>0){
				for (EmployeeVO empCode : empCodes) {
					userIds.add(empCode.getEmpCode());
				}				
			}
		}
		
		//该部门下的员工
		List<EmployeeVO> emps = this.getLeaderEmpInfoByOrgid(orgid);
		if(null!=emps&&emps.size()>0){
		for (EmployeeVO emp : emps) {
			userIds.add(emp.getEmpCode());
		}
		}
		return userIds;	
	}
	
	/**
	 * 根据工号判断是否是领导
	 */
	@Override
	@SuppressWarnings("all")
	public List<String> isLead(String empCode) {
		List<String> isLead = new ArrayList<String>();
		String orgName=receiveDao.getOrgNameByEmpCode(empCode);
		EmployeeVO Leademp=receiveDao.getLeaderEmp(empCode);
		if(null!=Leademp){
			isLead.add("0");
		}else{
			isLead.add("1");
		}
		isLead.add(orgName);
		return isLead;
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

	public IReceiveObjectDao getReceiveDao() {
		return receiveDao;
	}
    
}

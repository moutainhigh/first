///**
// * Project Name:dpm-tongxunlu
// * File Name:SyncBaseDataService.java
// * Package Name:com.deppon.dpm.tongxunlu.server.service
// * Date:2014-8-8上午8:32:22
// * Copyright (c) 2014, chenzhou1025@126.com All Rights Reserved.
// *
//*/
//
//package com.deppon.dpm.tongxunlu.server.service.impl;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.BeanUtils;
//import org.springframework.dao.DataAccessException;
//import org.springframework.jdbc.core.ConnectionCallback;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.deppon.dpm.tongxunlu.server.dao.impl.EmployeeDao;
//import com.deppon.dpm.tongxunlu.server.dao.impl.OrganizationDao;
//import com.deppon.dpm.tongxunlu.server.service.ISyncBaseDataService;
//import com.deppon.dpm.tongxunlu.shared.domain.EmployeeEntity;
//import com.deppon.dpm.tongxunlu.shared.domain.OrganizationEntity;
//import com.deppon.dpm.tongxunlu.shared.vo.BaseSyncInfo;
//import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
//import com.deppon.dpm.tongxunlu.shared.vo.OrganizationVO;
//import com.deppon.dpm.tongxunlu.server.util.Constants;
//
///**
// * ClassName:SyncBaseDataService <br/>
// * Function: TODO ADD FUNCTION. <br/>
// * 
// * Date:     2014-8-8 上午8:32:22 <br/>
// * @author   157229-zxy
// * @version  
// * @since    JDK 1.6
// */
//public class SyncBaseDataService implements ISyncBaseDataService{
//	
//	private final static Logger LOG = LoggerFactory.getLogger(SyncBaseDataService.class);
//	
//	private OrganizationDao orgDao;
//	
//	private EmployeeDao empDao;
//	
//	private JdbcTemplate oaJdbcTemplate;
//	
//	/**
//	 * 数据同步
//	 * @see com.deppon.dpm.tongxunlu.server.service.ISyncBaseDataService#executeDataSync(java.lang.String, java.lang.String)
//	 */
//	@Transactional
//	@Override
//	public BaseSyncInfo executeDataSync(String starttime, String endtime){
//		BaseSyncInfo baseSyncInfo = new BaseSyncInfo();
//		baseSyncInfo.setSyncStatus(Constants.SYNC_STATUS_FAIL);
//		int empSuccessed = empSyn(starttime, endtime, baseSyncInfo);
//		int orgSuccessed = orgSyn(starttime, endtime, baseSyncInfo);
//		//设置状态为同步成功
//		if(empSuccessed == 0 && orgSuccessed == 0)
//			baseSyncInfo.setSyncStatus(Constants.SYNC_STATUS_SUCCESS);
//		//设置警告
//		else if(empSuccessed == 1 || orgSuccessed == 1)
//			baseSyncInfo.setSyncStatus(Constants.SYNC_STATUS_WARN);
//		//设置同步日志
//		StringBuffer sbMsg = new StringBuffer();
//		sbMsg.append("用户新增:" + baseSyncInfo.getEmpInsertCount() + "\n");
//		sbMsg.append("用户修改:" + baseSyncInfo.getEmpUpdateCount() + "\n");
//		sbMsg.append("用户删除:" + baseSyncInfo.getEmpDelCount() + "\n");
//		sbMsg.append("\n\n");
//		sbMsg.append("机构新增:" + baseSyncInfo.getOrgInsertCount() + "\n");
//		sbMsg.append("机构修改:" + baseSyncInfo.getOrgUpdateCount() + "\n");
//		sbMsg.append("机构删除:" + baseSyncInfo.getOrgDelCount() + "\n");
//		baseSyncInfo.addMessageToHeader(sbMsg.toString());
//		return baseSyncInfo;
//	}
//	
//	/**
//	 * 人员同步.
//	 * 
//	 * @param startDate
//	 * @param endDate
//	 */
//	public int empSyn(String startDate, String endDate, BaseSyncInfo baseSyncInfo) {
//		//是否执行成功
//		int successed = 0;
//		List<EmployeeVO> emps = getChangedEmp(startDate, endDate);
//		//删除条数
//		int delCount = 0;
//		//新增条数
//		int insertCount = 0;
//		//修改条数
//		int updateCount = 0;
//		StringBuffer sbFail = new StringBuffer();
//		StringBuffer sbError = new StringBuffer();
//		if (emps != null && emps.size() > 0)
//			for (EmployeeVO vo : emps) {
//				int empId = vo.getEmpId();
//				String changedtype = vo.getLimit() + "";
//				try{
//					int executeFlag = 0;
//					if (Constants.EMP_DELETE_TYPE.equals(changedtype)) {
//						executeFlag = empDao.del(empId);
//						delCount = delCount + executeFlag;
//					} else if (Constants.EMP_INSERT_TYPE.equals(changedtype)) {
//						EmployeeEntity employeeEntity= translateEmployeeEntity(vo);
//						executeFlag = empDao.insert(employeeEntity);
//						insertCount = insertCount + executeFlag;
//					} else if (Constants.EMP_UPDATE_TYPE.equals(changedtype)
//							|| Constants.EMP_UPD_ORG_TYPE.equals(changedtype)) {
//						executeFlag = empDao.update(vo);
//						updateCount = updateCount + executeFlag;
//					}
//					if(executeFlag <= 0){
//						sbFail.append(empId).append(" ");
//						successed = 1;
//					}
//				}catch(Exception e){
//					//记录系统异常
//					LOG.error("人员同步失败", e);
//					sbError.append(empId).append(" ");
//					successed = 1;
//				}
//			}
//		if(sbFail.length() > 0){
//			sbFail.insert(0, "lose empid==>");
//			baseSyncInfo.addMessage(sbFail.toString());
//		}
//		if(sbError.length() > 0){
//			sbError.insert(0, "error empid==>");
//			baseSyncInfo.addMessage(sbError.toString());
//		}
//		baseSyncInfo.setEmpDelCount(delCount);
//		baseSyncInfo.setEmpInsertCount(insertCount);
//		baseSyncInfo.setEmpUpdateCount(updateCount);
//		return successed;
//	}
//	
//	/**
//	 * 测试组织机构同步的代码.
//	 */
//	public int orgSyn(String startDate, String endDate, BaseSyncInfo baseSyncInfo) {
//		//是否执行成功
//		int successed = 0;
//		List<OrganizationVO> orgs = getChangedOrg(startDate, endDate);
//		//删除条数
//		int delCount = 0;
//		//新增条数
//		int insertCount = 0;
//		//修改条数
//		int updateCount = 0;
//		StringBuffer sbFail = new StringBuffer();
//		StringBuffer sbError = new StringBuffer();
//		if (orgs != null && orgs.size() > 0)
//			for (OrganizationVO vo : orgs) {
//				int executeFlag = 0;
//				int orgid = vo.getOrgId();
//				String changedtype = vo.getLimit() + "";
//				try{
//					if (Constants.ORG_DELETE_TYPE.equals(changedtype)) {
//						executeFlag = orgDao.del(orgid);
//						delCount = delCount + executeFlag;
//					} else if (Constants.ORG_INSERT_TYPE.equals(changedtype)) {
//						OrganizationEntity orgEntity = translateOrganizationEntity(vo);
//						executeFlag = orgDao.insert(orgEntity);
//						insertCount = insertCount + executeFlag;
//					} else if (Constants.ORG_UPDATE_TYPE.equals(changedtype)) {
//						executeFlag = orgDao.update(vo);
//						updateCount = updateCount + executeFlag;
//					}
//					if(executeFlag <= 0){
//						sbFail.append(orgid).append(" ");
//						successed = 1;
//					}
//				}catch(Exception e){
//					//记录系统异常
//					LOG.error("机构同步失败", e);
//					sbError.append(orgid).append(" ");
//					successed = 1;
//				}
//			}
//		if(sbFail.length() > 0){
//			sbFail.insert(0, "lose orgid==>");
//			baseSyncInfo.addMessage(sbFail.toString());
//		}
//		if(sbError.length() > 0){
//			sbError.insert(0, "error orgid==>");
//			baseSyncInfo.addMessage(sbError.toString());
//		}
//		baseSyncInfo.setOrgDelCount(delCount);
//		baseSyncInfo.setOrgInsertCount(insertCount);
//		baseSyncInfo.setOrgUpdateCount(updateCount);
//		return successed;
//	}
//	
//	/**
//	 * 查询指定时间间隔的数据变化量.
//	 * 
//	 * @param startTime
//	 * @param endTime
//	 */
//	private List<EmployeeVO> getChangedEmp(final String startTime, final String endTime) {
//		List<EmployeeVO> result = null;
//		result = oaJdbcTemplate.execute(new ConnectionCallback<List<EmployeeVO>>() {
//			@Override
//			public List<EmployeeVO> doInConnection(Connection con)
//					throws SQLException, DataAccessException {
//				List<EmployeeVO> result = new ArrayList<EmployeeVO>();
//				PreparedStatement ps = con
//						.prepareStatement("select empid,EMPCODE ,EMPNAME,to_char(BIRTHDATE,'yyyy-MM-dd'),EMPSTATUS,CARDNO "
//								+ " ,MOBILENO,OEMAIL,JOBNAME,orgid,changedtype,gender from dip_user_changeddata  where changeddate >= to_date(?, 'yyyy-MM-dd hh24:mi:ss') "
//								+ "  and changeddate < to_date(?, 'yyyy-MM-dd  hh24:mi:ss') ORDER BY changeddate ASC");
//				ps.setString(1, startTime);
//				ps.setString(2, endTime);
//				// 逐行循环进行插入到mysql数据库
//				ResultSet rs = ps.executeQuery();
//				EmployeeVO vo = null;
//				while (rs.next()) {
//					int empId = 0, orgid = 0, changedtype = 0;
//					String empCode, empName, empStatus, cardNo, mobilNo, email, jobName,gender = null;
//					Date birthDay = null;
//					vo = new EmployeeVO();
//					empId = rs.getInt(1);
//					empCode = rs.getString(2);
//					empName = rs.getString(3);
//					birthDay = rs.getDate(4);
//					empStatus = rs.getString(5);
//					cardNo = rs.getString(6);
//					mobilNo = rs.getString(7);
//					email = rs.getString(8);
//					jobName = rs.getString(9);
//					orgid = rs.getInt(10);
//					changedtype = rs.getInt(11);
//					gender = rs.getString(12);
//					vo.setEmpId(empId);
//					vo.setEmpCode(empCode);
//					vo.setEmpName(empName);
//					vo.setBirthDate(birthDay);
//					vo.setEmpStatus(empStatus);
//					vo.setCardNo(cardNo);
//					vo.setMobileNo(mobilNo);
//					vo.setEmail(email);
//					vo.setJobName(jobName);
//					vo.setOrgId(orgid);
//					vo.setLimit(changedtype);
//					vo.setGender(gender);
//					result.add(vo);
//				}
//				return result;
//			}
//		});
//		return result;
//		
//		
//		
//		
//		
//		
//		
//		
////		DbPoolConnection dbp;
////		DruidPooledConnection con;
////		EmployeeVO vo = new EmployeeVO();
////		List<EmployeeVO> result = new ArrayList<EmployeeVO>();
////		try {
////			dbp = DbPoolConnection.getInstance();
////			con = dbp.getConnection();
////			PreparedStatement ps = con
////					.prepareStatement("select empid,EMPCODE ,EMPNAME,to_char(BIRTHDATE,'yyyy-MM-dd'),EMPSTATUS,CARDNO "
////							+ " ,MOBILENO,OEMAIL,JOBNAME,orgid,changedtype,gender from dip_user_changeddata  where changeddate >= to_date(?, 'yyyy-MM-dd hh24:mi:ss') "
////							+ "  and changeddate < to_date(?, 'yyyy-MM-dd  hh24:mi:ss') ORDER BY changeddate ASC");
////			ps.setString(1, startTime);
////			ps.setString(2, endTime);
////			// 逐行循环进行插入到mysql数据库
////			ResultSet rs = ps.executeQuery();
////			while (rs.next()) {
////				int empId = 0, orgid = 0, changedtype = 0;
////				String empCode, empName, empStatus, cardNo, mobilNo, email, jobName,gender = null;
////				Date birthDay = null;
////				vo = new EmployeeVO();
////				empId = rs.getInt(1);
////				empCode = rs.getString(2);
////				empName = rs.getString(3);
////				birthDay = rs.getDate(4);
////				empStatus = rs.getString(5);
////				cardNo = rs.getString(6);
////				mobilNo = rs.getString(7);
////				email = rs.getString(8);
////				jobName = rs.getString(9);
////				orgid = rs.getInt(10);
////				changedtype = rs.getInt(11);
////				gender = rs.getString(12);
////				vo.setEmpId(empId);
////				vo.setEmpCode(empCode);
////				vo.setEmpName(empName);
////				vo.setBirthDate(birthDay);
////				vo.setEmpStatus(empStatus);
////				vo.setCardNo(cardNo);
////				vo.setMobileNo(mobilNo);
////				vo.setEmail(email);
////				vo.setJobName(jobName);
////				vo.setOrgId(orgid);
////				vo.setLimit(changedtype);
////				vo.setGender(gender);
////				result.add(vo);
////			}
////			rs.close();
////			ps.close();
////			con.close();
////			dbp = null;
////		} catch (Exception e) {
////			e.printStackTrace();
////		} finally {
////			return result;
////		}
//	}
//
//	/**
//	 * 得到指定时间段变化的组织机构.
//	 * 
//	 * @param startTime
//	 * @param endTime
//	 * @return
//	 */
//	private List<OrganizationVO> getChangedOrg(final String startTime, final String endTime) {
//		List<OrganizationVO> result = null;
//		result = oaJdbcTemplate.execute(new ConnectionCallback<List<OrganizationVO>>() {
//			@Override
//			public List<OrganizationVO> doInConnection(Connection con)
//					throws SQLException, DataAccessException {
//				List<OrganizationVO> result = new ArrayList<OrganizationVO>();
//				PreparedStatement ps = con
//						.prepareStatement("select org.orgid, org.orgcode, org.orgname, org.parentorgid, org.orgaddr,"
//								+ " org.managerid, org.linktel, org.appsyscode, org.finasyscode,changedtype from dip_org_changeddata"
//								+ " org where changeddate >= to_date(?, 'yyyy-MM-dd hh24:mi:ss') "
//								+ "and changeddate < to_date(?, 'yyyy-MM-dd hh24:mi:ss')  ORDER BY changeddate ASC");
//				ps.setString(1, startTime);
//				ps.setString(2, endTime);
//				OrganizationVO org = null;
//				// 逐行循环进行插入到mysql数据库
//				ResultSet rs = ps.executeQuery();
//				while (rs.next()) {
//					int orgid, parentorgid = 0, changedtype = 0;
//					String orgcode, orgname, orgaddr, managerid, linktel, appsyscode, finasyscode = null;
//					org = new OrganizationVO();
//					orgid = rs.getInt(1);
//					orgcode = rs.getString(2);
//					orgname = rs.getString(3);
//					parentorgid = rs.getInt(4);
//					orgaddr = rs.getString(5);
//					managerid = rs.getString(6);
//					linktel = rs.getString(7);
//					appsyscode = rs.getString(8);
//					finasyscode = rs.getString(9);
//					changedtype = rs.getInt(10);
//					org.setOrgId(orgid);
//					org.setOrgCode(orgcode);
//					org.setOrgName(orgname);
//					org.setParentId(parentorgid);
//					org.setOrgAddr(orgaddr);
//					org.setManagerId(managerid);
//					org.setLinkTel(linktel);
//					org.setAppSysCode(appsyscode);
//					org.setFinaSysCode(finasyscode);
//					org.setLimit(changedtype);
//					result.add(org);
//				}
//				return result;
//			}
//		});
//		return result;
//		
//		
//		
//		
////		DbPoolConnection dbp;
////		DruidPooledConnection con;
////		List<OrganizationVO> result = new ArrayList<OrganizationVO>();
////		OrganizationVO org = new OrganizationVO();
////		try {
////			dbp = DbPoolConnection.getInstance();
////			con = dbp.getConnection();
////			PreparedStatement ps = con
////					.prepareStatement("select org.orgid, org.orgcode, org.orgname, org.parentorgid, org.orgaddr,"
////							+ " org.managerid, org.linktel, org.appsyscode, org.finasyscode,changedtype from dip_org_changeddata"
////							+ " org where changeddate >= to_date(?, 'yyyy-MM-dd hh24:mi:ss') "
////							+ "and changeddate < to_date(?, 'yyyy-MM-dd hh24:mi:ss')  ORDER BY changeddate ASC");
////			ps.setString(1, startTime);
////			ps.setString(2, endTime);
////			// 逐行循环进行插入到mysql数据库
////			ResultSet rs = ps.executeQuery();
////			while (rs.next()) {
////				int orgid, parentorgid = 0, changedtype = 0;
////				String orgcode, orgname, orgaddr, managerid, linktel, appsyscode, finasyscode = null;
////				org = new OrganizationVO();
////				orgid = rs.getInt(1);
////				orgcode = rs.getString(2);
////				orgname = rs.getString(3);
////				parentorgid = rs.getInt(4);
////				orgaddr = rs.getString(5);
////				managerid = rs.getString(6);
////				linktel = rs.getString(7);
////				appsyscode = rs.getString(8);
////				finasyscode = rs.getString(9);
////				changedtype = rs.getInt(10);
////				org.setOrgId(orgid);
////				org.setOrgCode(orgcode);
////				org.setOrgName(orgname);
////				org.setParentId(parentorgid);
////				org.setOrgAddr(orgaddr);
////				org.setManagerId(managerid);
////				org.setLinkTel(linktel);
////				org.setAppSysCode(appsyscode);
////				org.setFinaSysCode(finasyscode);
////				org.setLimit(changedtype);
////				result.add(org);
////			}
////			rs.close();
////			ps.close();
////			con.close();
////			dbp = null;
////		} catch (Exception e) {
////			e.printStackTrace();
////		} finally {
////			return result;
////		}
//	}
//	
//	/**
//	 * vo转换成EmployeeEntity
//	 * translateEmployeeEntity: <br/>
//	 * 
//	 * Date:2014-8-8上午10:50:55
//	 * @author 157229-zxy
//	 * @param vo
//	 * @return
//	 * @since JDK 1.6
//	 */
//	public EmployeeEntity translateEmployeeEntity(EmployeeVO vo){
//		EmployeeEntity emp = new EmployeeEntity();
//		BeanUtils.copyProperties(vo, emp);
//		emp.setpEmail(vo.getEmail());
//		return emp;
//	}
//	
//	/**
//	 * vo转换成OrganizationEntity
//	 * translateOrganizationEntity: <br/>
//	 * 
//	 * Date:2014-8-8上午11:23:02
//	 * @author 157229-zxy
//	 * @param vo
//	 * @return
//	 * @since JDK 1.6
//	 */
//	public OrganizationEntity translateOrganizationEntity(OrganizationVO vo){
//		OrganizationEntity org = new OrganizationEntity();
//		BeanUtils.copyProperties(vo, org);
//		org.setParentOrgId(vo.getParentId());
//		return org;
//	}
//	
//	/********************************getter and setter*********************************/
//	
//	public OrganizationDao getOrgDao() {
//		return orgDao;
//	}
//
//	public void setOrgDao(OrganizationDao orgDao) {
//		this.orgDao = orgDao;
//	}
//
//	public EmployeeDao getEmpDao() {
//		return empDao;
//	}
//
//	public void setEmpDao(EmployeeDao empDao) {
//		this.empDao = empDao;
//	}
//
//	public JdbcTemplate getOaJdbcTemplate() {
//		return oaJdbcTemplate;
//	}
//
//	public void setOaJdbcTemplate(JdbcTemplate oaJdbcTemplate) {
//		this.oaJdbcTemplate = oaJdbcTemplate;
//	}
//
//}
//

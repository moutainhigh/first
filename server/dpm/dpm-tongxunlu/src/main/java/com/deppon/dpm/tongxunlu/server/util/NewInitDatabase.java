/**
 * 2015-09-29 改
 * @author 231586
 */
/*package com.deppon.dpm.tongxunlu.server.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;

import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
import com.deppon.dpm.tongxunlu.shared.vo.OrganizationVO;

*//**
 * 进行人员数据和组织机构数据的同步.
 * @author 130126
 *
 *//*
public class NewInitDatabase implements Runnable {
	
	@Autowired
	private JdbcTemplate oaJdbcTemplate;
	
	// 开始的倒数锁.
	CountDownLatch begin = new CountDownLatch(1);
	// 结束的倒数锁
	CountDownLatch end = new CountDownLatch(2);
	ExecutorService exec = Executors.newFixedThreadPool(2);
	Date start = new Date(System.currentTimeMillis());

	public NewInitDatabase() {
		// 查询是否初始化过数据.
		JdbcTemplate jdbcTemplate = (JdbcTemplate) SpringContextUtil
				.getBean("jdbcTemplate");
		// 如果没有生成过同步信息，就执行初始化的步骤
		int ans = jdbcTemplate.queryForInt("select count(1) from om_config");
		//sonar 整改  start变量未使用 
//		Date start = new java.sql.Date(System.currentTimeMillis());
//		System.out.println("初始化插入数据..");
		if (ans == 0) {
			new Thread(this).start();
		}
	}

	@Override
	public void run() {
		try {
			// 先进行职员信息和组织机构信息的同步
			exec.submit(new InitEmployee(begin, end));
			exec.submit(new InitOrganization(begin, end));
			begin.countDown();
			end.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			exec.shutdown();
			// 同步完之后，进行时间信息的记录.
			new Thread(new InitConfig(start)).start();
		}
	}

	*//**
	 * 初始化职员信息的相关数据.
	 * 
	 * @author 130126
	 * 
	 *//*
	private class InitEmployee implements Runnable {
		private CountDownLatch begin;
		// 结束的倒数锁
		private CountDownLatch end;

		public InitEmployee(CountDownLatch begin, CountDownLatch end) {
			this.begin = begin;
			this.end = end;
		}

		@Override
		public void run() {
			//sonar  整改
//			System.out.println("同步职员信息.");
			try {
				begin.await();
				List<EmployeeVO> result = null;
				result = oaJdbcTemplate.execute(new ConnectionCallback<List<EmployeeVO>>() {
					@Override
					public List<EmployeeVO> doInConnection(Connection con)
							throws SQLException, DataAccessException {
						List<EmployeeVO> result = new ArrayList<EmployeeVO>();
						PreparedStatement ps = con
								.prepareStatement("select empid,EMPCODE ,EMPNAME,to_char(BIRTHDATE,'yyyy-MM-dd'),EMPSTATUS,CARDNO "
										+ " ,MOBILENO,OEMAIL,JOBNAME,JOBLEVEL , JOBSEQUENCE,JOBDUTY ,orgid,gender from om_employee  where empstatus='on' ");
						int i = 0;
						EmployeeVO vo = null;
						// 逐行循环进行插入到mysql数据库
						ResultSet rs = ps.executeQuery();
						while (rs.next()) {
							//sonar  整改
//							if ((i++) % 100 == 0)
//								System.out.println("已经同步职员数量:" + i);
							int empId = 0, orgid = 0;
							String empCode, empName, empStatus, cardNo, mobilNo, email, jobName, jobLevel, jobQuence, jobDuty, gender = null;
							Date birthDay = null;
							vo = new EmployeeVO();
							empId = rs.getInt(1);
							empCode = rs.getString(2);
							empName = rs.getString(3);
							birthDay = rs.getDate(4);
							empStatus = rs.getString(5);
							cardNo = rs.getString(6);
							mobilNo = rs.getString(7);
							email = rs.getString(8);
							jobName = rs.getString(9);
							jobLevel = rs.getString(10);
							jobQuence = rs.getString(11);
							jobDuty = rs.getString(12);
							orgid = rs.getInt(13);
							gender = rs.getString(14);
							vo.setEmpId(empId);
							vo.setEmpCode(empCode);
							vo.setEmpName(empName);
							vo.setBirthDate(birthDay);
							vo.setEmpStatus(empStatus);
							vo.setCardNo(cardNo);
							vo.setMobileNo(mobilNo);
							vo.setEmail(email);
							vo.setJobLevel(jobLevel);
							vo.setJobName(jobName);
							vo.setJobDuty(jobDuty);
							vo.setJobSequence(jobQuence);
							vo.setOrgId(orgid);
							vo.setGender(gender);
							addEmployee(vo);
						}
						return result;
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				end.countDown();
			}
			
			
			
			
			
			
//			DbPoolConnection dbp;
//			DruidPooledConnection con;
//			EmployeeVO vo = new EmployeeVO();
//			int i = 0;
//			try {
//				begin.await();
//				dbp = DbPoolConnection.getInstance();
//				con = dbp.getConnection();
//				PreparedStatement ps = con
//						.prepareStatement("select empid,EMPCODE ,EMPNAME,to_char(BIRTHDATE,'yyyy-MM-dd'),EMPSTATUS,CARDNO "
//								+ " ,MOBILENO,OEMAIL,JOBNAME,JOBLEVEL , JOBSEQUENCE,JOBDUTY ,orgid,gender from om_employee  where empstatus='on' ");
//				// 逐行循环进行插入到mysql数据库
//				ResultSet rs = ps.executeQuery();
//				while (rs.next()) {
//					if ((i++) % 100 == 0)
//						System.out.println("已经同步职员数量:" + i);
//					int empId = 0, orgid = 0;
//					String empCode, empName, empStatus, cardNo, mobilNo, email, jobName, jobLevel, jobQuence, jobDuty, gender = null;
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
//					jobLevel = rs.getString(10);
//					jobQuence = rs.getString(11);
//					jobDuty = rs.getString(12);
//					orgid = rs.getInt(13);
//					gender = rs.getString(14);
//					vo.setEmpId(empId);
//					vo.setEmpCode(empCode);
//					vo.setEmpName(empName);
//					vo.setBirthDate(birthDay);
//					vo.setEmpStatus(empStatus);
//					vo.setCardNo(cardNo);
//					vo.setMobileNo(mobilNo);
//					vo.setEmail(email);
//					vo.setJobLevel(jobLevel);
//					vo.setJobName(jobName);
//					vo.setJobDuty(jobDuty);
//					vo.setJobSequence(jobQuence);
//					vo.setOrgId(orgid);
//					vo.setGender(gender);
//					addEmployee(vo);
//				}
//				rs.close();
//				ps.close();
//				con.close();
//				dbp = null;
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				end.countDown();
//			}
		}

	}

	*//**
	 * 进行同步信息的数据初始化.
	 * 
	 * @author 130126
	 * 
	 *//*
	private class InitConfig implements Runnable {
		private Date start;

		public InitConfig(Date start) {
			this.start = start;
		}

		@Override
		public void run() {
			try {
				int orgCount = 0;
				orgCount = oaJdbcTemplate.execute(new ConnectionCallback<Integer>() {
					@Override
					public Integer doInConnection(Connection con)
							throws SQLException, DataAccessException {
						PreparedStatement ps = con
								.prepareStatement("select count(1)   from om_organization org  where exists (select 1 from om_employee emp where emp.orgid = org.orgid) and orgclose='0' ");
						// 逐行循环进行插入到mysql数据库
						ResultSet rs = ps.executeQuery();
						// 逐行循环进行插入到mysql数据库
						rs = ps.executeQuery();
						int orgCount = 0;
						while (rs.next()) {
							orgCount = rs.getInt(1);
						}
						return orgCount;
					}
				});
				
				int empCount = 0;
				empCount = oaJdbcTemplate.execute(new ConnectionCallback<Integer>() {
					@Override
					public Integer doInConnection(Connection con)
							throws SQLException, DataAccessException {
						PreparedStatement ps = con.prepareStatement("select count(1) from   om_employee emp where empstatus='on' ");
						// 逐行循环进行插入到mysql数据库
						ResultSet rs = ps.executeQuery();
						int empCount = 0;
						while (rs.next()) {
							empCount = rs.getInt(1);
						}
						return empCount;
					}
				});
				// 添加同步信息.
				addConfig(start, new Date(System.currentTimeMillis()),
						empCount, orgCount);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
//			DbPoolConnection dbp = DbPoolConnection.getInstance();
//			DruidPooledConnection con;
//			OrganizationVO org = new OrganizationVO();
//			try {
//				con = dbp.getConnection();
//				PreparedStatement ps = con
//						.prepareStatement("select count(1)   from om_organization org  where exists (select 1 from om_employee emp where emp.orgid = org.orgid) and orgclose='0' ");
//				// 逐行循环进行插入到mysql数据库
//				ResultSet rs = ps.executeQuery();
//				// 逐行循环进行插入到mysql数据库
//				rs = ps.executeQuery();
//				int orgCount = 0;
//				while (rs.next()) {
//					orgCount = rs.getInt(1);
//				}
//				rs.close();
//				ps.close();
//				con.close();
//				con = dbp.getConnection();
//				ps = con.prepareStatement("select count(1) from   om_employee emp where empstatus='on' ");
//				// 逐行循环进行插入到mysql数据库
//				rs = ps.executeQuery();
//				int empCount = 0;
//				while (rs.next()) {
//					empCount = rs.getInt(1);
//				}
//				rs.close();
//				ps.close();
//				con.close();
//				dbp = null;
//
//				// 添加同步信息.
//				addConfig(start, new Date(System.currentTimeMillis()),
//						empCount, orgCount);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
		}
	}

	*//**
	 * 转换字符串到int
	 * 
	 * @param str
	 * @return
	 *//*
	private int changeInt(String str) {
		return Integer.parseInt(str);
	}

	*//**
	 * 初始化组织架构的数据.
	 * 
	 * @author 130126
	 * 
	 *//*
	private class InitOrganization implements Runnable {
		private CountDownLatch begin;
		// 结束的倒数锁
		private CountDownLatch end;

		public InitOrganization(CountDownLatch begin, CountDownLatch end) {
			this.begin = begin;
			this.end = end;
		}

		@Override
		public void run() {
			//sonar  整改
//			System.out.println("同步组织机构信息.");
			try {
				begin.await();
				List<EmployeeVO> result = null;
				result = oaJdbcTemplate.execute(new ConnectionCallback<List<EmployeeVO>>() {
					@Override
					public List<EmployeeVO> doInConnection(Connection con)
							throws SQLException, DataAccessException {
						List<EmployeeVO> result = new ArrayList<EmployeeVO>();
						PreparedStatement ps = con
								.prepareStatement("select distinct org.orgid,org.orgcode ,org.orgname,org.orglevel,org.parentorgid,org.orgaddr  "
										+ " ,org.zipcode,org.managerid,org.linktel,org.area , org.remark,org.appsyscode,org.finasyscode from om_organization org,om_employee emp  where emp.orgid=org.orgid  and  org.orgclose='0' ");

						// 逐行循环进行插入到mysql数据库
						int i = 0;
						ResultSet rs = ps.executeQuery();
						OrganizationVO org = null;
						while (rs.next()) {
							//sonar  整改
//							if ((i++) % 100 == 0)
//								System.out.println("已经同步职员数量:" + i);
							int orgid, parentorgid = 0;
							String orgcode, orgname, orglevel, orgaddr, zipcode, managerid, linktel, area, remark, appsyscode, finasyscode = null;
							org = new OrganizationVO();
							orgid = rs.getInt(1);
							orgcode = rs.getString(2);
							orgname = rs.getString(3);
							orglevel = rs.getString(4);
							parentorgid = rs.getInt(5);
							orgaddr = rs.getString(6);
							zipcode = rs.getString(7);
							managerid = rs.getString(8);
							linktel = rs.getString(9);
							area = rs.getString(10);
							remark = rs.getString(11);
							appsyscode = rs.getString(12);
							finasyscode = rs.getString(13);
							org.setOrgId(orgid);
							org.setOrgCode(orgcode);
							org.setOrgName(orgname);
							org.setOrgLevel(changeInt(orglevel));
							org.setParentId(parentorgid);
							org.setOrgAddr(orgaddr);
							org.setZipCode(zipcode);
							org.setManagerId(managerid);
							org.setLinkTel(linktel);
							org.setArea(area);
							org.setRemark(remark);
							org.setAppSysCode(appsyscode);
							org.setFinaSysCode(finasyscode);
							addOrganization(org);
						}
						return result;
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				end.countDown();
			}
			
			
			
			
			
			
			
			
			
			
			
//			DbPoolConnection dbp;
//			DruidPooledConnection con;
//			OrganizationVO org = new OrganizationVO();
//			int i = 0;
//
//			try {
//				begin.await();
//				dbp = DbPoolConnection.getInstance();
//				con = dbp.getConnection();
//				PreparedStatement ps = con
//						.prepareStatement("select distinct org.orgid,org.orgcode ,org.orgname,org.orglevel,org.parentorgid,org.orgaddr  "
//								+ " ,org.zipcode,org.managerid,org.linktel,org.area , org.remark,org.appsyscode,org.finasyscode from om_organization org,om_employee emp  where emp.orgid=org.orgid  and  org.orgclose='0' ");
//
//				// 逐行循环进行插入到mysql数据库
//				ResultSet rs = ps.executeQuery();
//
//				while (rs.next()) {
//					if ((i++) % 100 == 0)
//						System.out.println("已经同步职员数量:" + i);
//					int orgid, parentorgid = 0;
//					String orgcode, orgname, orglevel, orgaddr, zipcode, managerid, linktel, area, remark, appsyscode, finasyscode = null;
//					org = new OrganizationVO();
//					orgid = rs.getInt(1);
//					orgcode = rs.getString(2);
//					orgname = rs.getString(3);
//					orglevel = rs.getString(4);
//					parentorgid = rs.getInt(5);
//					orgaddr = rs.getString(6);
//					zipcode = rs.getString(7);
//					managerid = rs.getString(8);
//					linktel = rs.getString(9);
//					area = rs.getString(10);
//					remark = rs.getString(11);
//					appsyscode = rs.getString(12);
//					finasyscode = rs.getString(13);
//					org.setOrgId(orgid);
//					org.setOrgCode(orgcode);
//					org.setOrgName(orgname);
//					org.setOrgLevel(changeInt(orglevel));
//					org.setParentId(parentorgid);
//					org.setOrgAddr(orgaddr);
//					org.setZipCode(zipcode);
//					org.setManagerId(managerid);
//					org.setLinkTel(linktel);
//					org.setArea(area);
//					org.setRemark(remark);
//					org.setAppSysCode(appsyscode);
//					org.setFinaSysCode(finasyscode);
//					addOrganization(org);
//				}
//				rs.close();
//				ps.close();
//				con.close();
//				dbp = null;
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				end.countDown();
//			}
		}

	}

	*//**
	 * 保存到mysql数据库.
	 * 
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * @param vo1
	 *//*
	public void addEmployee(EmployeeVO vo1) {
		final EmployeeVO vo = vo1;
		JdbcTemplate jdbcTemplate = (JdbcTemplate) SpringContextUtil
				.getBean("jdbcTemplate");
		jdbcTemplate.execute(new ConnectionCallback() {
			@Override
			public Object doInConnection(Connection con) throws SQLException,
					DataAccessException {
				PreparedStatement ps = con
						.prepareStatement("insert into om_employee(empid,EMPCODE ,EMPNAME,BIRTHDATE,EMPSTATUS,CARDNO "
								+ " ,MOBILENO,PEMAIL,JOBNAME,JOBLEVEL , JOBSEQUENCE,jobduty,orgid,gender    ) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				ps.setInt(1, vo.getEmpId());
				ps.setString(2, vo.getEmpCode());
				ps.setString(3, vo.getEmpName());
				ps.setDate(4, (Date) vo.getBirthDate());
				ps.setString(5, vo.getEmpStatus());
				ps.setString(6, vo.getCardNo());
				ps.setString(7, vo.getMobileNo());
				ps.setString(8, vo.getEmail());
				ps.setString(9, vo.getJobName());
				ps.setString(10, vo.getJobLevel());
				ps.setString(11, vo.getJobSequence());
				ps.setString(12, vo.getJobDuty());
				ps.setInt(13, vo.getOrgId());
				ps.setString(14, vo.getGender());
				ps.executeUpdate();
				return null;
			}

		});

	}

	@SuppressWarnings("unchecked")
	private void addOrganization(OrganizationVO vo1) {
		final OrganizationVO vo = vo1;
		JdbcTemplate jdbcTemplate = (JdbcTemplate) SpringContextUtil
				.getBean("jdbcTemplate");
		jdbcTemplate.execute(new ConnectionCallback() {
			@Override
			public Object doInConnection(Connection con) throws SQLException,
					DataAccessException {
				PreparedStatement ps = con
						.prepareStatement("insert into om_organization(orgid,orgcode ,orgname,orglevel,parentorgid,orgaddr "
								+ " ,zipcode,managerid,linktel,area , remark,appsyscode,finasyscode    ) "
								+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
				ps.setInt(1, vo.getOrgId());
				ps.setString(2, vo.getOrgCode());
				ps.setString(3, vo.getOrgName());
				ps.setInt(4, vo.getOrgLevel());
				ps.setInt(5, vo.getParentId());
				ps.setString(6, vo.getOrgAddr());
				ps.setString(7, vo.getZipCode());
				ps.setString(8, vo.getManagerId());
				ps.setString(9, vo.getLinkTel());
				ps.setString(10, vo.getArea());
				ps.setString(11, vo.getRemark());
				ps.setString(12, vo.getAppSysCode());
				ps.setString(13, vo.getFinaSysCode());
				ps.executeUpdate();
				return null;
			}

		});

	}

	private void addConfig(final Date start, final Date end,
			final int empCount, final int orgCount) {
		JdbcTemplate jdbcTemplate = (JdbcTemplate) SpringContextUtil
				.getBean("jdbcTemplate");
		jdbcTemplate.execute(new ConnectionCallback() {

			@Override
			public Object doInConnection(Connection con) throws SQLException,
					DataAccessException {
				PreparedStatement ps = con
						.prepareStatement("insert into om_config( syn_starttime,syn_endtime,emp_num,org_num,syn_startdate) values (?,?,? ,?,?)");
				ps.setTimestamp(1, new java.sql.Timestamp(start.getTime()));
				ps.setTimestamp(2, new java.sql.Timestamp(end.getTime()));
				ps.setInt(3, empCount);
				ps.setInt(4, orgCount);
				ps.setTimestamp(5, new java.sql.Timestamp(start.getTime()));
				ps.executeUpdate();
				return null;
			}

		});

	}

}
*/
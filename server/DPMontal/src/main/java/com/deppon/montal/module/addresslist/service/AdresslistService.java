/**
 * 
 */
package com.deppon.montal.module.addresslist.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.deppon.montal.model.OmEmployee;
import com.deppon.montal.util.ConnectionManager;

/**
 * 通讯录后台交互Service
 * @yin
 */
public class AdresslistService {

	private static Logger logger = Logger.getLogger(AdresslistService.class); 
	
	/**
	 * 分页查询通讯录信息
	 * @param type 查询类别
	 * @param key  关键字
	 * @param pageNum 当前第几页
	 * @return
	 */
	public List<OmEmployee> queryAddresslist(String key,int pageNum){
		
		StringBuffer sqlbuf = new StringBuffer(" select s2.* from (select s1.*,rownum rd from (" +
						   "select emp.empid,emp.userid,emp.empname,emp.jobname,org.orgname"+
	                                           " from om_employee emp,om_organization org"+
	                                           " where emp.empstatus = 'on' and emp.orgid = org.orgid");
		if(null !=key){
			sqlbuf.append(" and (emp.userid like ?");
			sqlbuf.append(" or emp.empname like ?)");
			//sqlbuf.append(" or emp.jobname like '%"+key+"%'");
			//sqlbuf.append(" or org.orgname like '%"+key+"%')");
		}
		//分页支持
		sqlbuf.append(" order by emp.empid)s1 where rownum <=?)s2 where s2.rd>=?");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<OmEmployee> empList = new ArrayList<OmEmployee>();
		
		try {
			conn = ConnectionManager.getConnection();
			stmt = conn.prepareStatement(sqlbuf.toString());
			if(null !=key){
				stmt.setString(1, "%"+key+"%");
				stmt.setString(2, "%"+key+"%");
				stmt.setInt(3, pageNum*8);
				stmt.setInt(4, (pageNum-1)*8+1);
			}else{
				stmt.setInt(1, pageNum*8);
				stmt.setInt(2, (pageNum-1)*8+1);
			}
			rs = stmt.executeQuery();
			while(rs.next()){
				OmEmployee emp = new OmEmployee();
				emp.setEmpId(new BigDecimal(rs.getString("empid")));
				emp.setUserId(rs.getString("userid"));
				emp.setEmpName(rs.getString("empname"));
				emp.setJobName(rs.getString("jobname"));
				emp.setOrgName(rs.getString("orgname"));
				empList.add(emp);
			}
		} catch (NumberFormatException e) {	
			logger.error("数值类型转换报错!"+e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			logger.error("查询通讯录报错!"+e.getMessage());
			e.printStackTrace();
		}finally{
			//关闭连接
			ConnectionManager.closeAll(conn, stmt, rs);
		}
		
		return empList;
	}
	
	/**
	 * 根据empid查询员工信息
	 * @param empid
	 * @return
	 */
	public OmEmployee getEmployeeInfo(long empid){
		
		String sql = " select emp.empid,emp.userid,emp.empname,emp.jobname,emp.gender,emp.mobileno,emp.otel,emp.oemail,emp.orgid,org.orgname,emp.workexp"+
                     " from om_employee emp,om_organization org"+
                     " where emp.empstatus = 'on' and emp.orgid = org.orgid and emp.empid =?";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		OmEmployee emp = null;
		
		try {
			conn = ConnectionManager.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, empid+"");
			rs = stmt.executeQuery();
			if(rs.next()){
				emp = new OmEmployee();
				emp.setEmpId(new BigDecimal(rs.getString("empid")));
				emp.setUserId(rs.getString("userid"));
				emp.setEmpName(rs.getString("empname"));
				emp.setGender(rs.getString("gender"));
				emp.setMobileNo(rs.getString("mobileno"));
				emp.setTelephone(rs.getString("otel"));
				emp.setEmail(rs.getString("oemail"));
				emp.setOrgId(new BigDecimal(rs.getString("orgid")));
				emp.setOrgName(rs.getString("orgname"));
				emp.setJobName(rs.getString("jobname"));
				emp.setWorkExp(rs.getString("workexp"));
			}
		} catch (NumberFormatException e) {	
			logger.error("数值类型转换报错!"+e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			logger.error("查询通讯录报错!"+e.getMessage());
			e.printStackTrace();
		}finally{
			//关闭连接
			ConnectionManager.closeAll(conn, stmt, rs);
		}
		
		return emp;
	}
}

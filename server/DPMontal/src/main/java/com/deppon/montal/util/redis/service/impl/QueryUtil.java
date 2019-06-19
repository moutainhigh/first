package com.deppon.montal.util.redis.service.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.deppon.montal.conf.domain.DictEntry;
import com.deppon.montal.conf.domain.WorkflowInfo;
import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.login.service.SQLManager;
import com.deppon.montal.model.DpmonEmployee;
import com.deppon.montal.model.DpmonRoleJobname;
import com.deppon.montal.util.ConnectionManager;

public class QueryUtil {

	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;
	/**
	 * 查询所有的数据字典数据
	 * @return
	 */
	public static List<DictEntry> queryAllDictEntry(){
		
		List<DictEntry> list = new ArrayList<DictEntry>();
		try{
			conn = ConnectionManager.getConnection();
			pstmt = conn.prepareStatement(SQLManager.QUERY_ALL_DICTENTRY);
			rs = pstmt.executeQuery();
			resultSetHandle(list,rs);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	/**
	 * 将ResultSet转换为List
	 * @param list
	 * @param rs
	 * @param clazz
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	private static void resultSetHandle(List list, ResultSet rs) throws InstantiationException, IllegalAccessException, SQLException {
		if (null == rs)
			return;
		DictEntry t;
		while (rs.next()) {
			t = new DictEntry();
			t.setDictid(rs.getString("dictid"));
			t.setDicttypeid(rs.getString("dicttypeid"));
			t.setDictname(rs.getString("dictname"));
			BigDecimal rank = rs.getBigDecimal("rank");
			t.setRank(rank == null ? 0 : rank.intValue());
			t.setSeqno(rs.getString("seqno"));
			BigDecimal sortno = rs.getBigDecimal("sortno");
			t.setSortno(sortno == null ? 0 : sortno.intValue());
			list.add(t);
		}
	}
	/**
	 * 查询所有的工作流配置信息
	 * @return
	 */
	public static List<WorkflowInfo> queryAllWorkflowInof(){
		
		List<WorkflowInfo> workflowList = new ArrayList<WorkflowInfo>();
		WorkflowInfo workflow = null;
		try{
			conn = ConnectionManager.getConnection();
			pstmt = conn.prepareStatement(SQLManager.QUERY_ALL_DPMONWORKFLOW);
			rs = pstmt.executeQuery();
			while(rs.next()){
				workflow = new WorkflowInfo();
				String id = rs.getString("id");
				String workflowname = rs.getString("workflowname");
				String jspname = rs.getString("jspname");
				Date createtime = rs.getDate("createtime");
				String syscode = rs.getString("syscode");
				String classname = rs.getString("classname");
				String entryProperty = rs.getString("entryProperty");
				
				workflow.setId(id);
				workflow.setCreatetime(createtime);
				workflow.setWorkflowname(workflowname);
				workflow.setSyscode(syscode);
				workflow.setJspname(jspname);
				workflow.setClassName(classname);
				workflow.setEntryProperty(entryProperty);
				workflowList.add(workflow);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return workflowList;
	}
	/**
	 * 查询所有的用户信息
	 * @return
	 */
	public static List<LoginUser> queryAllUsers(){
		
		List<LoginUser> userList = new ArrayList<LoginUser>();
		LoginUser user = null;
		try{
			conn = ConnectionManager.getConnection();
			pstmt = conn.prepareStatement(SQLManager.QUERY_ALL_EMPLOYEE);
			rs = pstmt.executeQuery();
			while(rs.next()){
				user = new LoginUser();
				String userId = rs.getString("userid");
				Long empId = rs.getLong("empId");
				String empName = rs.getString("operatorname");
				String jobName = rs.getString("jobname");
				user.setUserId(userId);
				user.setEmpId(empId);
				user.setEmpName(empName);
				user.setJobName(jobName);
				userList.add(user);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return userList;
	}
	/**
	 * 查询表dpmon_role_jobname的信息
	 */
	public static List<DpmonRoleJobname> queryAllRoleJobname(){
		List<DpmonRoleJobname> rjList = new ArrayList<DpmonRoleJobname>();
		DpmonRoleJobname roleJobname = null;
		try{
			conn = ConnectionManager.getConnection();
			pstmt = conn.prepareStatement(SQLManager.QUERY_ALL_ROLEJOBNAME);
			rs = pstmt.executeQuery();
			while(rs.next()){
				roleJobname = new DpmonRoleJobname();
				roleJobname.setId(rs.getInt("ID"));
				roleJobname.setJobname(rs.getString("JOBNAME"));
				rjList.add(roleJobname);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return rjList;
	}
	/**
	 * 查询表dpmon_employee的信息
	 */
	public static List<DpmonEmployee> queryAllDpmonEmployee(){
		List<DpmonEmployee> empList = new ArrayList<DpmonEmployee>();
		DpmonEmployee employee = null;
		try{
			conn = ConnectionManager.getConnection();
			pstmt = conn.prepareStatement(SQLManager.QUERY_ALL_DPMONEMPLOYEE);
			rs = pstmt.executeQuery();
			while(rs.next()){
				employee = new DpmonEmployee();
				employee.setId(rs.getInt("ID"));
				employee.setUserId(rs.getString("USERID"));
				employee.setUserName(rs.getString("USERNAME"));
				employee.setSyscodes(rs.getString("SYSCODES"));
				empList.add(employee);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return empList;
	}
}

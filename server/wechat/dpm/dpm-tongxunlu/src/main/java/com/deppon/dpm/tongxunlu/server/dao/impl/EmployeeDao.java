package com.deppon.dpm.tongxunlu.server.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.util.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.deppon.dpm.tongxunlu.server.dao.IEmployeeDao;
import com.deppon.dpm.tongxunlu.shared.domain.EmployeeEntity;
import com.deppon.dpm.tongxunlu.shared.vo.EmployeeVO;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 对职员表进行操作的数据库操作类.
 * 
 * @author 130126
 * 
 */
public class EmployeeDao extends iBatis3DaoImpl implements IEmployeeDao {
	/**
	 * spring的jdbc模板
	 */
	private JdbcTemplate template;
	/**
	 * namespace，对应xml文件里面的namespace
	 */
	private static final String NAMESPACE = "com.deppon.dpm.tongxunlu.server.dao.employee.";

	/**
	 * 
	 * TODO 简单描述该方法的实现功能（可选）.
	 * 
	 * @see com.deppon.dpm.tongxunlu.server.dao.IEmployeeDao#insert(com.deppon.dpm.tongxunlu.shared.domain.EmployeeEntity)
	 * @update zxy 20140808 DPM-299 修改
	 */
	@Override
	public int insert(final EmployeeEntity emp) {
		return this.getSqlSession().insert(NAMESPACE + "insert", emp);
	}

	/**
	 * 新增
	 */
	@Override
	public int insert(EmployeeVO vo) {
		// 根据EmployeeVO新增员工信息
		return this.getSqlSession().insert(NAMESPACE + "insertByVo", vo);
	}

	/**
	 * 查询
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<EmployeeVO> query(EmployeeVO emp, int start, int pageSize) {
		// 拼接参数
		emp.setLimit(pageSize);
		emp.setStart(start);
		// 数据库查询返回值
		return this.getSqlSession().selectList(NAMESPACE + "getEmps", emp);
	}
	
	/**
	 * 根据userIds查询人员信息
	 */
	@SuppressWarnings("unchecked")
	public List<EmployeeVO> queryEmpByUserIds(String[] userIdArray) {
		return this.getSqlSession().selectList(NAMESPACE + "queryEmpByUserIds", userIdArray);
	}
	
	/**
	 * 合伙人搜索人员
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeVO> queryForPartner(EmployeeVO emp, int start,
			int pageSize) {
		// 拼接参数
		emp.setLimit(pageSize);
		emp.setStart(start);
		// 数据库查询返回值
		return this.getSqlSession().selectList(NAMESPACE + "getEmpsForPartner", emp);
	}

	/**
	 * 查询个数
	 */
	@Override
	public int querySize(EmployeeVO emp) {
		// 查询数量
		return (Integer) this.getSqlSession().selectOne(
				NAMESPACE + "getEmpsSize", emp);
	}

	/**
	 * 更新
	 */
	@Override
	public int update(EmployeeVO emp) {
		// 更新
		return this.getSqlSession().update(NAMESPACE + "update", emp);
	}

	/**
	 * 删除
	 */
	@Override
	public int del(int empId) {
		// 根据empId删除员工信息，原OA删除机制
		return this.getSqlSession().delete(NAMESPACE + "delete", empId);
	}

	/**
	 * 删除
	 */
	@Override
	public int deleteByEmpcode(String empCode) {
		// 根据工号删除，uums同步机制
		return getSqlSession().delete(NAMESPACE + "deleteByEmpcode", empCode);
	}

	/**
	 * 获取
	 */
	@Override
	public int getEmpByOrgIdCount(String pid) {
		// 定义返回参数
		Map<String, String> m = new HashMap<String, String>();
		// 设置部门id
		m.put("pid", pid);
		// 返回部门下员工人员数
		return (Integer) this.getSqlSession().selectOne(
				NAMESPACE + "getEmpByOrgIdCount", m);
	}

	/**
	 * 查询，屏蔽领导号码
	 */
	@Override
	public EmployeeEntity queryEmployeeByCode(EmployeeVO params) {
		// 根据工号查询员工信息
		EmployeeEntity employeeEntity = (EmployeeEntity) this.getSqlSession()
				.selectOne(NAMESPACE + "queryEmployeeByCode", params);
		// 通讯录领导列表
		List<String> leaderList = getEmpleaderConfig();
		// 判断是否是领导，如是，屏蔽号码
		if (null != employeeEntity &&leaderList.contains(employeeEntity.getEmpCode())) {
			employeeEntity.setMobileNo(null);
		}
		// 返回
		return employeeEntity;
	}
	
	/**
	 * 查询Employee
	 */
	public EmployeeEntity selectOne(EmployeeVO params){
		// 根据工号查询员工信息
		return (EmployeeEntity) this.getSqlSession()
				.selectOne(NAMESPACE + "queryEmployeeByCode", params);
	}

	/**
	 * 更新
	 */
	@Override
	public int updateCallQuntityByEmpId(int empId) {
		// 更新电话匹配数量
		return this.getSqlSession().update(
				NAMESPACE + "updateCallQuntityByEmpId", empId);
	}

	/**
	 * 查询
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> queryPushUser(Map<String, String> map) {
		// 查询推送人员，返回列表数据
		return getSqlSession().selectList(NAMESPACE + "queryPushUser", map);
	}

	/****************** 手势密码 ******************/
	/**
	 * 获取手势密码
	 */
	@Override
	public Map<String, Object> getGustureStatus(String empCode) {
		Map<String, Object> m = new HashMap<String, Object>();
		// 查询对应员工手势密码的状态
		String status = (String) getSqlSession().selectOne(
				NAMESPACE + "getGustureStatus", empCode);
		// 根据工号查询手势密码数量
		String sql = "select count(1) from om_gesture_password where user_id = '"
				+ empCode + "'";
		// 定义返回值
		int count = template.queryForInt(sql);
		m.put("status", status);
		m.put("count", count);
		// 返回拼接参数
		return m;
	}

	/**
	 * 更新手势密码状态
	 */
	@Override
	public int updateGustureStatus(String empCode, String inGustureStatus) {
		Map<String, String> m = new HashMap<String, String>();
		// 拼接条件参数
		m.put("user_id", empCode);
		m.put("gusture_status", inGustureStatus);
		// 更新员工的手势密码状态
		return getSqlSession().update(NAMESPACE + "updateGustureStatus", m);
	}

	/**
	 * 更新手势密码
	 */
	@Override
	public void updateGesturePassword(String userId, String password) {
		Map<String, String> m = new HashMap<String, String>();
		// 拼接条件参数
		m.put("user_id", userId);
		m.put("g_password", password);
		// 更新员工的手势密码
		getSqlSession().update(NAMESPACE + "updateGesturePassword", m);
	}

	/**
	 * 查询手势密码
	 */
	@Override
	public String queryGesturePassword(String userId) {
		// 查询手势密码
		return (String) getSqlSession().selectOne(
				NAMESPACE + "queryGesturePassword", userId);
	}

	/**
	 * 保存
	 */
	@Override
	public void saveGesturePassword(String userId, String password) {
		Map<String, String> m = new HashMap<String, String>();
		// 拼接条件参数
		m.put("user_id", userId);
		m.put("g_password", password);
		// 保存员工的手势密码
		getSqlSession().insert(NAMESPACE + "saveGesturePassword", m);
	}

	/**
	 * 保存状态
	 */
	@Override
	public int saveGustureStatus(String userId, String inGustureStatus) {
		Map<String, String> m = new HashMap<String, String>();
		// 拼接条件参数
		m.put("user_id", userId);
		m.put("gusture_status", inGustureStatus);
		// 保存员工的手势密码状态
		return getSqlSession().insert(NAMESPACE + "saveGustureStatus", m);
	}

	/****************** 手势密码 ******************/
	/**
	 * 获取全部推送
	 */
	@Override
	public List<Map<String, Object>> getAllUser() {
//		// 默认安装登陆过后的人才会有收到推送消息的机会
//		String sql = "select distinct user_code from login_information";
//		// 查询人员信息
//		List<String> queryForList = template.queryForList(sql, String.class);
//		Object userIds = null;
//		// 数量
//		int size = queryForList.size();
//		if (size > 0) {
//			StringBuilder builder = new StringBuilder();
//			for (String agent : queryForList) {
//				// 拼接工号
//				builder.append("'").append(agent).append("',");
//			}
//			String string = builder.toString();
//			// 删除末尾","
//			userIds = string.substring(0, string.length() - 1);
//		}
//		// 根据工号查询员工信息
//		String query = "select a.EMPCODE,a.EMPNAME,a.JOBLEVEL,a.jobname,b.ORGNAME from om_employee a " +
//				"left JOIN om_organization b on a.ORGID =b.ORGID where a.EMPSTATUS = 'on' and a.EMPCODE in ("
//				+ userIds + ")";
		
		//直接推全员
		String query = "select a.EMPCODE,a.EMPNAME,a.JOBLEVEL,a.jobname,b.ORGNAME from om_employee a " +
		"left JOIN om_organization b on a.ORGID =b.ORGID where a.EMPSTATUS = 'on'";
		// 定义返回之类型
		final List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// jdbc模板
		template.query(query, new RowMapper<Map<String, Object>>() {
			@Override
			public Map<String, Object> mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("empcode", rs.getString("empcode"));
				map.put("empname", rs.getString("empname"));
				map.put("joblevel", rs.getString("joblevel"));
				map.put("jobname", rs.getString("jobname"));
				map.put("orgname", rs.getString("orgname"));
				list.add(map);
				return map;
			}
		});
		// 返回信息
		return list;
	}

	/**
	 * 发现(早)
	 */
	@Override
	public int operate(Map<String, String> map) {
		// 定义操作sql语句
		String sql = null;
		// 目标工号
		String desEmpcode = map.get("desEmpcode");
		// 操作类型
		String operateType = map.get("operateType");
		// 确认类型
		String configType = map.get("configType");
		// 点赞
		if ("praise".equals(operateType)) {
			// Y表示确认点赞
			if (null == configType || "Y".equals(configType)) {
				// 点赞数+1
				sql = "UPDATE EMP_PIC SET PRAISENUM=PRAISENUM+1 WHERE EMPCODE = '"
						+ desEmpcode + "'";
				// 取消点赞
			} else if ("N".equals(configType)) {
				// 点赞数-1
				sql = "UPDATE EMP_PIC SET PRAISENUM=PRAISENUM-1 WHERE EMPCODE = '"
						+ desEmpcode + "'";
			}
		}
		// 扔鸡蛋
		if ("debase".equals(operateType)) {
			// Y表示扔鸡蛋
			if (null == configType || "Y".equals(configType)) {
				// 鸡蛋熟+1
				sql = "UPDATE EMP_PIC SET DEBASENUM=DEBASENUM+1 WHERE EMPCODE = '"
						+ desEmpcode + "'";
				// 取消
			} else if ("N".equals(configType)) {
				// -1
				sql = "UPDATE EMP_PIC SET DEBASENUM=DEBASENUM-1 WHERE EMPCODE = '"
						+ desEmpcode + "'";
			}
		}
		// 执行语句
		template.execute(sql);
		// 插入日志表
		return getSqlSession().insert(NAMESPACE + "operate", map);
	}

	/**
	 * 发现(早)
	 */
	@Override
	public Map<String, Object> getCount(String objId) {
		// 获取人员点赞数量等sql
		String sql = "SELECT OE.empCode,OE.empName,OE.jobName,EP.PRAISENUM as praiseNum_of_smile"
				+ ",EP.DEBASENUM as debaseNum_of_smile,EP.PICTPATH AS pictPath,oo.orgName "
				+ "FROM EMP_PIC EP JOIN OM_EMPLOYEE OE ON OE.EMPCODE = EP.EMPCODE " 
				+ "join om_organization oo ON OE.ORGID = oo.ORGID " 
				+ "WHERE OE.EMPSTATUS = 'on' AND EP.EMPCODE = '" + objId + "'";
		// 定义返回类型
		Map<String, Object> queryForMap = null;
		try {
			// 查询
			queryForMap = template.queryForMap(sql);
		} catch (Exception e) {
			queryForMap = new HashMap<String, Object>();
			// 查询不到返回0
			queryForMap.put("PRAISENUM", 0);
			// 查询不到返回0
			queryForMap.put("DEBASENUM", 0);
		}
		// 结果返回
		return queryForMap;
	}

	/**
	 * 发现(早)
	 */
	@Override
	public List<Map<String, Object>> getPersonPics(Map<String, Object> map) {
		// sql语句
		StringBuilder sql = new StringBuilder(
				"SELECT O.EMPCODE as empCode,E.PICTPATH as pictPath,E.PRAISENUM as praiseNum_of_smile,");
		sql.append("E.DEBASENUM as debaseNum_of_smile,O.EMPNAME as empName,O.JOBNAME as jobName,oo.orgName ");
		sql.append("FROM EMP_PIC E JOIN OM_EMPLOYEE O ON E.EMPCODE = O.EMPCODE ");
		sql.append("join om_organization oo ON O.ORGID = oo.ORGID ");
		sql.append("where O.EMPSTATUS = 'on' ");
		if (null != map.get("chooseGender")) {
			sql.append(" AND O.GENDER = '");
			sql.append(map.get("chooseGender").toString());
			sql.append("'");
		}
		sql.append("ORDER BY E.LASTUPDATETIME DESC ");
		sql.append("LIMIT ");
		sql.append(Integer.parseInt(map.get("start").toString()));
		sql.append(",");
		sql.append(Integer.parseInt(map.get("pageSize").toString()));

		// 定义返回类型
		List<Map<String, Object>> result = template
				.queryForList(sql.toString());
		// 返回
		return result;
		// 发现返回结果
		// return getSqlSession().selectList(NAMESPACE + "getPersonPics", map);
	}

	/**
	 * 发现(早)
	 */
	@Override
	public List<Map<String, Object>> getSort(Map<String, String> map) {
		String gender = map.get("gender");
		// 获取排序的sql
		StringBuilder sql = new StringBuilder(
				"select (@rowNO := @rowNo+1) AS rowno,");
		sql.append("a.total,a.EMPCODE as empCode,a.PRAISENUM as praiseNum_of_smile,");
		sql.append("a.DEBASENUM as debaseNum_of_smile,a.PICTPATH as pictPath,a.empName,a.jobName,a.orgName ");
		sql.append("FROM (SELECT ep.PRAISENUM + ep.DEBASENUM as total,ep.empCode,ep.PRAISENUM,");
		sql.append("ep.DEBASENUM,ep.PICTPATH,oe.empName,oe.jobName,oo.orgName FROM emp_pic ep JOIN ");
		sql.append("om_employee oe ON ep.EMPCODE = oe.empCode join om_organization oo ON oe.ORGID = oo.ORGID ");
		sql.append("WHERE oe.empstatus = 'on'");
		// 性别条件
		if (StringUtils.isNotEmpty(gender)) {
			sql.append(" AND oe.gender = '");
			sql.append(gender);
			sql.append("'");
		}
		sql.append(" ORDER BY total DESC LIMIT 0,10) a,(select @rowNO :=0) b");
		// 定义返回类型
		List<Map<String, Object>> resultList = template.queryForList(sql
				.toString());
		// 返回
		return resultList;
	}

	/**
	 * 发现(早)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<String> checkExist(String userId, String objId) {
		// 获取当前时间
		String time = DateUtil.formatDate(new Date(), "yyyy-MM-dd")
				+ " 00:00:00";
		Map<String, String> map = new HashMap<String, String>();
		// 操作人
		map.put("PRAISEEMP", userId);
		// 目的人
		map.put("BEPRAISEDEMP", objId);
		// 时间拼接
		map.put("TIME", time);
		// 返回
		return getSqlSession().selectList(NAMESPACE + "checkExist", map);
	}

	@Override
	public int uumsQuerySize(EmployeeVO vo) {
		// 查询人员的数量，不管empStatus是on还是leave
		String sql = "SELECT COUNT(*) FROM OM_EMPLOYEE WHERE EMPCODE = '"
				+ vo.getEmpCode() + "'";
		// 返回数量
		return template.queryForInt(sql);
	}

	@Override
	public int operateSmile(Map<String, String> map) {
		// 定义操作sql语句
		String sql = null;
		// 目标工号
		String desEmpcode = map.get("desEmpcode");
		// 操作类型
		String operateType = map.get("operateType");
		// 确认类型
		String configType = map.get("configType");
		// 点赞
		if ("praise".equals(operateType)) {
			// Y表示确认点赞
			if (null == configType || "Y".equals(configType)) {
				// +1
				sql = "update emp_pic set praiseNum_of_smile=praiseNum_of_smile+1 where empCode = '"
						+ desEmpcode + "'";
				// N表示取消点赞
			} else if ("N".equals(configType)) {
				// -1
				sql = "update emp_pic set praiseNum_of_smile=praiseNum_of_smile-1 where empCode = '"
						+ desEmpcode + "'";
			}
		}
		// 鸡蛋
		if ("debase".equals(operateType)) {
			// Y表示确认扔鸡蛋
			if (null == configType || "Y".equals(configType)) {
				// +1
				sql = "update emp_pic set debaseNum_of_smile=debaseNum_of_smile+1 where empCode = '"
						+ desEmpcode + "'";
			} else if ("N".equals(configType)) {
				// -1
				sql = "update emp_pic set debaseNum_of_smile=debaseNum_of_smile-1 where empCode = '"
						+ desEmpcode + "'";
			}
		}
		// 执行
		template.execute(sql);
		// 存储日志
		return getSqlSession().insert(NAMESPACE + "operateSmile", map);
	}

	@Override
	public List<Map<String, Object>> getSmilePersonPics(Map<String, Object> map) {
		// 获取最美微笑信息，参数各种拼接
		String sql = "select o.empCode,e.pictPath,e.praiseNum_of_smile,e.debaseNum_of_smile,o.empName,o.jobName,o.gender,e.lastUpdateTime "
				+ "from emp_pic e join om_employee o on e.empCode = o.empCode "
				+ "where o.empStatus = 'on' "
				+ "and o.gender = 'f' "
				+ "and o.jobName in ('营业部经理','营业部副经理','营业员','统计分析员',"
				+ "'中级统计分析员','点部经理','快递仓管员兼收银员','快递仓管员')"
				+ "UNION ALL "
				+ "select o.empCode,e.pictPath,e.praiseNum_of_smile,e.debaseNum_of_smile,o.empName,o.jobName,o.gender,e.lastUpdateTime "
				+ "from emp_pic e join om_employee o on e.empCode = o.empCode "
				+ "where o.empStatus = 'on' "
				+ "and o.gender = 'f' "
				+ "and o.jobName like '%收银员%' "
				+ "UNION ALL "
				+ "select o.empCode,e.pictPath,e.praiseNum_of_smile,e.debaseNum_of_smile,o.empName,o.jobName,o.gender,e.lastUpdateTime "
				+ "from emp_pic e join om_employee o on e.empCode = o.empCode "
				+ "where o.empStatus = 'on' "
				+ "and o.gender = 'f' "
				+ "and o.jobName like '%电叉司机%' "
				+ "UNION ALL "
				+ "select o.empCode,e.pictPath,e.praiseNum_of_smile,e.debaseNum_of_smile,o.empName,o.jobName,o.gender,e.lastUpdateTime "
				+ "from emp_pic e join om_employee o on e.empCode = o.empCode "
				+ "where o.empStatus = 'on' "
				+ "and o.gender = 'f' "
				+ "and o.jobName like '%营销专员%' "
				+ "UNION ALL "
				+ "select o.empCode,e.pictPath,e.praiseNum_of_smile,e.debaseNum_of_smile,o.empName,o.jobName,o.gender,e.lastUpdateTime "
				+ "from emp_pic e join om_employee o on e.empCode = o.empCode "
				+ "where o.empStatus = 'on' "
				+ "and o.gender = 'f' "
				+ "and o.jobName like '%客服%'  "
				+ "UNION ALL "
				+ "select o.empCode,e.pictPath,e.praiseNum_of_smile,e.debaseNum_of_smile,o.empName,o.jobName,o.gender,e.lastUpdateTime "
				+ "from emp_pic e join om_employee o on e.empCode = o.empCode "
				+ "where o.empStatus = 'on' "
				+ "and o.gender = 'f' "
				+ "and o.jobName like '话务'"
				+ "ORDER BY lastUpdateTime desc "
				+ "limit "
				+ Integer.parseInt(map.get("start").toString())
				+ "," + Integer.parseInt(map.get("pageSize").toString());
		// 定义返回类型
		List<Map<String, Object>> result = template.queryForList(sql);
		// 返回
		return result;
	}

	@Override
	public List<Map<String, Object>> getSmileSort() {
		// 最美微笑排行
		String sql = "select (@rowNO := @rowNo+1) AS rowno, "
				+ "a.empCode as empCode,a.praiseNum_of_smile as praiseNum_of_smile, "
				+ "a.debaseNum_of_smile as debaseNum_of_smile,a.pictPath as pictPath, "
				+ "a.empName as empName,a.jobName as jobName,a.gender as gender "
				+ "from ("
				+ "select o.empCode,e.pictPath,e.praiseNum_of_smile,e.debaseNum_of_smile,o.empName,o.jobName,o.gender,e.lastUpdateTime "
				+ "from emp_pic e join om_employee o on e.empCode = o.empCode "
				+ "where o.empStatus = 'on' "
				+ "and o.gender = 'f' "
				+ "and o.jobName in ('营业部经理','营业部副经理','营业员','统计分析员',"
				+ "'中级统计分析员','点部经理','快递仓管员兼收银员','快递仓管员')"
				+ "UNION ALL "
				+ "select o.empCode,e.pictPath,e.praiseNum_of_smile,e.debaseNum_of_smile,o.empName,o.jobName,o.gender,e.lastUpdateTime "
				+ "from emp_pic e join om_employee o on e.empCode = o.empCode "
				+ "where o.empStatus = 'on' "
				+ "and o.gender = 'f' "
				+ "and o.jobName like '%收银员%' "
				+ "UNION ALL "
				+ "select o.empCode,e.pictPath,e.praiseNum_of_smile,e.debaseNum_of_smile,o.empName,o.jobName,o.gender,e.lastUpdateTime "
				+ "from emp_pic e join om_employee o on e.empCode = o.empCode "
				+ "where o.empStatus = 'on' "
				+ "and o.gender = 'f' "
				+ "and o.jobName like '%电叉司机%' "
				+ "UNION ALL "
				+ "select o.empCode,e.pictPath,e.praiseNum_of_smile,e.debaseNum_of_smile,o.empName,o.jobName,o.gender,e.lastUpdateTime "
				+ "from emp_pic e join om_employee o on e.empCode = o.empCode "
				+ "where o.empStatus = 'on' "
				+ "and o.gender = 'f' "
				+ "and o.jobName like '%营销专员%' "
				+ "UNION ALL "
				+ "select o.empCode,e.pictPath,e.praiseNum_of_smile,e.debaseNum_of_smile,o.empName,o.jobName,o.gender,e.lastUpdateTime "
				+ "from emp_pic e join om_employee o on e.empCode = o.empCode "
				+ "where o.empStatus = 'on' "
				+ "and o.gender = 'f' "
				+ "and o.jobName like '%客服%'  "
				+ "UNION ALL "
				+ "select o.empCode,e.pictPath,e.praiseNum_of_smile,e.debaseNum_of_smile,o.empName,o.jobName,o.gender,e.lastUpdateTime "
				+ "from emp_pic e join om_employee o on e.empCode = o.empCode "
				+ "where o.empStatus = 'on' "
				+ "and o.gender = 'f' "
				+ "and o.jobName like '话务'"
				+ "ORDER BY praiseNum_of_smile desc limit 0,30) a, (select @rowNO :=0) b";
		// 定义返回类型
		List<Map<String, Object>> result = template.queryForList(sql);
		// 返回
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<String> checkSmileExist(String userId, String objId) {
		// 获取当前时间
		String time = DateUtil.formatDate(new Date(), "yyyy-MM-dd")
				+ " 00:00:00";
		Map<String, String> map = new HashMap<String, String>();
		// 操作人
		map.put("praiseEmp", userId);
		// 目的人
		map.put("bePraisedEmp", objId);
		// 时间拼接
		map.put("time", time);
		// 返回
		return getSqlSession().selectList(NAMESPACE + "checkSmileExist", map);
	}

	@Override
	public Map<String, Object> getSmileCount(String objId) {
		// 获取最美微笑数量 for安卓
		String sql = "select oe.empCode,oe.empName,oe.jobName,ep.praiseNum_of_smile,ep.debaseNum_of_smile,ep.pictPath "
				+ "as headPhoto from emp_pic ep join om_employee oe on oe.empCode = ep.empCode where "
				+ "oe.empStatus = 'on' and ep.empCode = '" + objId + "'";
		// 定义返回类型
		Map<String, Object> queryForMap = null;
		try {
			// 查询，queryForObject一类的容易报错
			queryForMap = template.queryForMap(sql);
		} catch (Exception e) {
			queryForMap = new HashMap<String, Object>();
			// 出错初始化为0
			queryForMap.put("praiseNum_of_smile", 0);
			// 出错初始化为0
			queryForMap.put("debaseNum_of_smile", 0);
		}
		return queryForMap;
	}

	/**
	 * 通讯录leader列表
	 * 
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<String> getEmpleaderConfig() {
		// 返回结果集
		return getSqlSession().selectList(NAMESPACE + "getEmpleaderConfig");
	}

	/**
	 * 插入通讯录leader信息
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public int insertEmpleaderConfig(Map<String, String> map) {
		// 插入通讯录leader信息
		return getSqlSession().insert(NAMESPACE + "insertEmpleaderConfig", map);
	}

	/**
	 * 删除通讯录leader信息
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public int deleteEmpleaderConfig(String id) {
		// 判断是否为空
		if (StringUtils.isNotEmpty(id)) {
			// 删除通讯录leader信息
			return getSqlSession().delete(NAMESPACE + "deleteEmpleaderConfig",
					id);
		} else {
			return 0;
		}
	}

	/**
	 * 更新通讯录leader信息
	 */
	@Override
	public int updateEmpleaderConfig(Map<String, String> map) {
		// 更新通讯录leader信息
		return getSqlSession().update(NAMESPACE + "updateEmpleaderConfig", map);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeVO> queryAllForCID() {
		return getSqlSession().selectList(NAMESPACE + "queryAllForCID");
	}
	
	/**
	 * 通讯录被搜索的vp用户List
	 * 
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<String> queryMonitorEmpCodeList() {
		List<String> list = getSqlSession().selectList(NAMESPACE + "queryMonitorEmpCodeList");
		// 返回结果集
		return list == null ? new ArrayList<String>():list;
	}

	/**
	 * 保存通讯录搜索vp日志
	 * 
	 * @param map
	 * @return
	 */
	@Override
	public int insertmonitorVpSearch(Map<String, String> map) {
		// 插入通讯录leader信息
		return getSqlSession().insert(NAMESPACE + "insertmonitorVpSearch", map);
	}
	
	// get
	public JdbcTemplate getTemplate() {
		return template;
	}

	// set
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

}

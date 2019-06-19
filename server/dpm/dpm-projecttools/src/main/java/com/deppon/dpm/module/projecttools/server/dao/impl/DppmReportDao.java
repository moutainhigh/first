package com.deppon.dpm.module.projecttools.server.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.module.projecttools.server.dao.IDppmReportDao;
import com.deppon.dpm.module.projecttools.server.util.DateUtil;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 
 * 报表管理  权限判断 dao
 * 
 * @author 195406 高春玲
 * @date 2015-8-24 下午1:45:08
 * @since
 **/
public class DppmReportDao extends iBatis3DaoImpl implements IDppmReportDao {

	/*** 日志*/
	private Logger logger = LoggerFactory.getLogger(DppmReportDao.class);
	
	private JdbcTemplate template;
	private JdbcTemplate oaTemplate;
	// 报表编号   pc端报表对应的菜单名称  根据此字段判断当前用户是否可以查看报表
	private String funcCode;

    /** 
     * 权限判断
     * userId 用户工号
     */
	@Override
	public int powerReport(String userId) {
		//默认 无权限  0 无权限 1 有权限
		int flag = 0;
		// 根据用户在pc端所拥有的菜单 判断是否有报表菜单
		String sql = "select * from (select uf.func_code from dotp_user_func " +
				"uf where uf.user_username = '" + userId + "' " +
            "union  select rf.func_code from dotp_role_func rf where " +
            "rf.role_code in (select dur.role_code from dotp_user_role dur " +
            "where dur.user_username = '" +userId + "' ) union select " +
            "ddf.func_code from dotp_dept_func ddf where ddf.dept_benchmark_code = ( " +
           "select dcs.dept_benchmark_code from dotp_contacts dcs where " +
           "dcs.contact_employee_code = '" + userId + "' ) " +
           " ) f where f.func_code in (" + this.funcCode + ")";
		
		List<String> list = this.template.queryForList(sql, String.class);
		//查询结果集 长度是否大于0 大于0 有权限
		if(list != null && list.size() > 0){
			flag = 1;
		}
		return flag;
	}
	/**
	 * 项目进度成本高级搜索默认加载数据字典数据
	 * 项目类型，项目级别，所属本部
	 * @return
	 */
	public String proTypeQuery() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			//所属本部信息
			String sql = "select value,label from dotp_names where name = 'subsys'";
			//加入本部
			map.put("deptlist", querySql(sql));
			//项目类型信息
			sql = "select value,label from dotp_names where name = 'gh_type'";
			//加入项目类型
			map.put("typelist", querySql(sql));
			//项目级别信息
			sql = "select value,label from dotp_names where name = 'gh_level'";
			//加入项目级别
			map.put("levellist", querySql(sql));
		} catch (Exception e) {
			e.printStackTrace();
		}
		// map 转为 json 字符串 返回
		return JSON.toJSONString(map);
	}
	/**
	 * 项目进度成本 高级搜索  按名称模糊搜索 项目名称，承接部门
	 * @return
	 */
	public String proDeptQuery(int type, String name) {
		// 创建 list集合
		List<String[]> list = new ArrayList<String[]> ();
		try {
			// 定义sql 
			String sql = "";
			// 根据项目名称或承接部门 封装sql
			if(type == 1) { //项目名称搜索
				sql = "select project_code value,proj_name label from dotp_pm_projects where deleted = 0 and proj_name like '%" + name + "%' limit 200 ";
			} else if(type == 2) { //承接部门搜索
				sql = "select dept_benchmark_code value,dept_name label from dotp_departments where dept_name like '%" + name + "%' limit 200 ";
			}
			// sql 查询获得对应集合
			list = querySql(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 转换为字符串
		return JSON.toJSONString(list);
	}
	//公共方法 根据sql 获得列表数据
	public List<String[]> querySql(String sql) {
		return this.template.query(sql,
				new RowMapper<String[]>() {

			@Override
			public String[] mapRow(ResultSet rs, int arg1)
					throws SQLException {
				// 数组
				String[] s = new String[2];
				//字典编码
				s[0] = rs.getString("value");
				//字典名称
				s[1] = rs.getString("label");
				return s;
			}
		});
	}
	
	/**
	 * kPi数据统计 
	 * 0：项目管理 6：报表管理 11：任务管理 15：年度规划
	 * @param date 统计日期---统计日期默认为昨天
	 * @return
	 */
	public static final int NUMBER_OF_FOUR = 4;
	public static final int NUMBER_OF_FIVE = 5;
	public static final int NUMBER_OF_SIX = 6;
	public static final int NUMBER_OF_SEVEN = 7;
	public static final int NUMBER_OF_EIGHT = 8;
	public static final int NUMBER_OF_TEN = 10;
	public static final int NUMBER_OF_ELEVEN = 11;
	public static final int NUMBER_OF_TWELVE = 12;
	public static final int NUMBER_OF_FIFTEEN = 15;
	public static final int NUMBER_OF_17TH = 17;
	public static final int NUMBER_OF_21ST = 21;

	public String queryKpi(String date) {
		Map<String, Object> allmap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		for (int type = 1 ; type <= 2 ; type++){
			map = new HashMap<String, Object>();
			//统计日期前一天各项统计项目的访问人数
			String yest = "";
			//月初结束日期   月初 为1-10 月中为 11-20  月底 21-30
			String month = date.substring(0,NUMBER_OF_SEVEN);
			//月初 起始日期
			String bmonth1 = "",bmonth2 = "";
			//月中
			String mmonth1 = "",mmonth2 = "";
			//月底
			String emonth1 = "",emonth2 = "";
			int day = 0;
			if(date.length() == NUMBER_OF_TEN) {
				yest = DateUtil.queryYesterday(date);
				//当前日期
				day = Integer.parseInt(date.substring(NUMBER_OF_EIGHT,NUMBER_OF_TEN));
				//上周今天访问人数
				map.put("lastweekList", visitKpiNum(DateUtil.queryLastWeek(date),type,1));
				//上周今天访问次数
				map.put("lastweekTime", visitKpiNum(DateUtil.queryLastWeek(date),type,2));
				//最近一周访问人数
				map.put("chartList", kpiChartInWeek(DateUtil.queryBeforeday(date,NUMBER_OF_SIX),date,type));
				//本周活跃用户占比 = 本周活跃在该类型的用户数/本周登陆项目管理的用户数  本周从周日开始算起
				String sunday = DateUtil.queryWeekSunday(date);
				map.put("activeUserWeekList", activeKpiUserInweek(sunday,date,type));
				map.put("loginUserWeekList", loginKpiUserInweek(sunday,date,type));
				
			} else {
				String cudate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
				//当前月
				if(month.equals(cudate.substring(0,NUMBER_OF_SEVEN))) {
					//当前日期
					String cdate = DateUtil.queryBeforeday(cudate, 1);
					day = Integer.parseInt(cdate.substring(NUMBER_OF_EIGHT,NUMBER_OF_TEN));
				} else {
					//其他月 day等于月底30号
					String cdate = DateUtil.queryLastdayOfMonth(month);
					day = Integer.parseInt(cdate.substring(NUMBER_OF_EIGHT,NUMBER_OF_TEN));
				}
				
				//上个月
				yest = DateUtil.queryLastMonth(date);
				//当月访问人数
				map.put("chartList", visitKpiNum(date,type,1));
				
			}
			//统计日期当天各项统计项目的访问人数
			map.put("nowList", visitKpiNum(date,type,1));
			//统计昨天 
			map.put("yestList", visitKpiNum(yest,type,1));
			//当月累积日均访问人数
			map.put("monthList", visitKpiMonth(date,type,1));
			//当日访问次数
			map.put("nowTime", visitKpiNum(date,type,2));
			//前一天访问次数
			map.put("yestTime", visitKpiNum(yest,type,2));
			//当月累积日均访问人数
			map.put("monthTime", visitKpiMonth(date,type,2));
			//月初活跃用户占比   月初活跃在该类型的用户数/月初登陆项目管理的用户数
			//日期大于21号 
			if(day >= NUMBER_OF_21ST) {
				emonth1 = month + "-21";
				emonth2 = month + "-" + day;
				mmonth1 = month + "-11";
				mmonth2 = month + "-20";
				bmonth1 = month + "-01";
				bmonth2 = month + "-10";
			} else if (day >= NUMBER_OF_ELEVEN) {
				mmonth1 = month + "-11";
				mmonth2 = month + "-" + day;
				bmonth1 = month + "-01";
				bmonth2 = month + "-10";
			} else {
				bmonth1 = month + "-01";
				bmonth2 = month + "-" + day;
			}
			////月初活跃用户占比   月初活跃在该类型的用户数/月初登陆项目管理的用户数
			if(bmonth1.length() > 0 ) {
				map.put("activeBeginList", activeKpiUserInweek(bmonth1,bmonth2,type));
				map.put("loginBeginList", loginKpiUserInweek(bmonth1,bmonth2,type));
			}
			////月中活跃用户占比
			if(mmonth1.length() > 0 ) {
				map.put("activeMidList", activeKpiUserInweek(mmonth1,mmonth2,type));
				map.put("loginMidList", loginKpiUserInweek(mmonth1,mmonth2,type));
			}
			//月末活跃用户占比
			if(emonth1.length() > 0 ) {
				map.put("activeEndList", activeKpiUserInweek(emonth1,emonth2,type));
				map.put("loginEndList", loginKpiUserInweek(emonth1,emonth2,type));
			}
			//本月活跃用户占比
			map.put("activeAllList", activeKpiUserInweek(month + "-01",month + "-" + day,type));
			map.put("loginAllList", loginKpiUserInweek(month + "-01",month + "-" + day,type));
		    allmap.put("map" + type, map);
		}
		// 转换为字符串
		return JSON.toJSONString(allmap);
	}
	/**
	 * 公共方法 根据日期统计访问人数
	 * @param date 日期
	 * @param type 人员范围
	 * @param flag 标示
	 * @return
	 */
	public List<Integer[]> visitKpiNum(String date,int type,int flag) {
		// sql
		String sql = "SELECT sum(p.num) num,p.type FROM dotp_pm_project_monitor_kpi p WHERE " +
		" p.type in (0,6,11,15,17) AND p.time LIKE '" + date + "%' " +
		// flag--1人数 2次数  person---1所有用户 2vip用户
		" and p.flag=" + flag + " and p.person=" + type;
		sql += " group by p.type ";
		//执行查询
		return querySqlInt(sql);
	}
	/**
	 * 公共方法 当月累积日均访问人数/当年月均访问次数
	 * @param date 
	 * @param type 1所有用户 2vip用户
	 * @param flag 1人数 2次数 
	 * @return
	 */
	public List<Integer[]> visitKpiMonth(String date,int type,int flag) {
		//当月 天数 或 当年月数
		int num = 0;
		//月 或 年
		String month = "";
		String cdate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		if(date.length() == NUMBER_OF_TEN) {
			this.logger.info("按日统计：---" + date);
			month = date.substring(0,NUMBER_OF_SEVEN);
			//本月
			if(cdate.substring(0,NUMBER_OF_SEVEN).equals(month)) {
				//当天 为天数
				num = Integer.parseInt(cdate.substring(NUMBER_OF_EIGHT,NUMBER_OF_TEN));
			} else {
				// 月的天数
				num = Integer.parseInt(DateUtil.queryLastdayOfMonth(month).substring(NUMBER_OF_EIGHT,NUMBER_OF_TEN));
			}
		} else {
			this.logger.info("按月统计：---" + date);
			month = date.substring(0,NUMBER_OF_FOUR);
			//本年的
			if(cdate.substring(0,NUMBER_OF_FOUR).equals(month)) {
				//当月
				num = Integer.parseInt(cdate.substring(NUMBER_OF_FIVE,NUMBER_OF_SEVEN));
			} else {
				num = NUMBER_OF_TWELVE;
			}
		}
		//sql
		String sql = "SELECT ceil(sum(p.num)/" + num + ") num,p.type FROM dotp_pm_project_monitor_kpi p " +
				" WHERE p.type in (0,6,11,15,17) AND p.time LIKE '" + month + "%' and p.flag=" + flag +
				" and p.person=" + type + " group by p.type ";
		//执行查询
		return querySqlInt(sql);
	}
	/**
	 * 本周活跃用户 从周日开始算起四个类型的用户数
	 * @param sunday
	 * @param date
	 * @param type
	 * @return
	 */
	public List<Integer[]> activeKpiUserInweek(String sunday,String date,int type) {
		//sql
		String sql = "SELECT sum(p.num) num,p.type FROM dotp_pm_project_monitor_kpi p " +
				" WHERE p.type in (0,6,11,15,17) AND p.time between '" + sunday + "' and '" + date + "' " +
				" and p.flag=1 and p.person=" + type + " group by p.type";
		//执行查询
		return querySqlInt(sql);
	}
	/**
	 * 本周登陆项目管理用户 从周日开始算起
	 * @param sunday
	 * @param date
	 * @param type
	 * @return
	 */
	public int loginKpiUserInweek(String sunday,String date,int type) {
		String sql = "select sum(num) from data_monitor_kpi k where k.type=16 and " +
				"time BETWEEN '" + sunday + "' and '" + date + "' and person=" + type;
//		String sql = "select count(*) num from ( SELECT count(*),emp_code FROM data_monitor " +
//				" WHERE monitor_type = 16 and access_time between '" + sunday + "' and '" + date + " 23:59:59' ";
//		if(type == 2) {
//			//vip用户
//			sql += " and emp_code in (select empcode from om_employee where joblevel in ('09','10','C','D'))";
//		}
//		sql += " group by emp_code ) a ";
		return this.oaTemplate.queryForInt(sql);
	}
	/**
	 * 按天 查询最近一周访问人数
	 * @param lastweekdate
	 * @param date
	 * @param type
	 * @return
	 */
	public List<String[]> kpiChartInWeek(String lastweekdate,String date,int type) {
		//0：项目管理 6：报表管理 11：任务管理 15：年度规划
		final List<String[]> list = new ArrayList<String[]>();
		for(int i = NUMBER_OF_SIX ; i >= 0 ; i--) {
			list.add(new String[]{"0",DateUtil.queryBeforeday(date,i),"0"});
		}
		for(int i = NUMBER_OF_SIX ; i >= 0 ; i--) {
			list.add(new String[]{"6",DateUtil.queryBeforeday(date,i),"0"});
		}
		for(int i = NUMBER_OF_SIX ; i >= 0 ; i--) {
			list.add(new String[]{"11",DateUtil.queryBeforeday(date,i),"0"});
		}
		for(int i = NUMBER_OF_SIX ; i >= 0 ; i--) {
			list.add(new String[]{"15",DateUtil.queryBeforeday(date,i),"0"});
		}
		for(int i = NUMBER_OF_SIX ; i >= 0 ; i--) {
			list.add(new String[]{"17",DateUtil.queryBeforeday(date,i),"0"});
		}
		//访问人数sql
		String sql = "SELECT sum(p.num) num,p.type,p.time FROM dotp_pm_project_monitor_kpi p " +
				" WHERE p.type in (0,6,11,15,17) AND p.time between '" + lastweekdate + "' and '" + date + "' " +
				" and p.person=" + type + " and p.flag=1 GROUP BY p.type,p.time ";
		//执行查询
		this.template.query(sql,new RowMapper<String[]>() {
			@Override
			public String[] mapRow(ResultSet rs, int arg1)
					throws SQLException {
				for(int i = 0 ;i < list.size() ; i++) {
					String[] s = list.get(i);
					//类型,日期相等 更新访问量
					if(s[0].equals(rs.getString("type")) && s[1].equals(rs.getString("time"))) {
						s[2] = rs.getString("num");
						list.set(i, s);
						break;
					}
				}
				return null;
			}
		});
		return list;
	}
	//公共方法 根据sql 获得列表数据
	public List<Integer[]> querySqlInt(String sql) {
		//0：项目管理 6：报表管理 11：任务管理 15：年度规划 17:资源计划
		final List<Integer[]> list = new ArrayList<Integer[]>();
		list.add(new Integer[]{0,0});
		list.add(new Integer[]{NUMBER_OF_SIX,0});
		list.add(new Integer[]{NUMBER_OF_ELEVEN,0});
		list.add(new Integer[]{NUMBER_OF_FIFTEEN,0});
		list.add(new Integer[]{NUMBER_OF_17TH,0});
		//执行查询
		this.template.query(sql,new RowMapper<String[]>() {
			@Override
			public String[] mapRow(ResultSet rs, int arg1)
					throws SQLException {
				for(int i = 0 ; i < NUMBER_OF_FIVE ; i++) {
					Integer[] in = list.get(i);
					if(in[0] == rs.getInt("type")) {
						in[1] = rs.getInt("num");
						list.set(i, in);
						break;
					}
				}
//				//项目管理
//				if(rs.getInt("type") == 0) {
//					Integer[] in = list.get(0);
//					in[1] = rs.getInt("num");
//					list.set(0, in);
//				}
//				//报表管理 
//				if(rs.getInt("type") == 6) {
//					Integer[] in = list.get(1);
//					in[1] = rs.getInt("num");
//					list.set(1, in);
//				}
//				//任务管理
//				if(rs.getInt("type") == 11) {
//					Integer[] in = list.get(2);
//					in[1] = rs.getInt("num");
//					list.set(2, in);
//				}
//				//年度规划
//				if(rs.getInt("type") == 15) {
//					Integer[] in = list.get(3);
//					in[1] = rs.getInt("num");
//					list.set(3, in);
//				}
				return null;
			}
		});
		return list;
	}
	/**
	 * 查询用户 级别
	 * @return
	 */
	public int queryJobLevel(String userId) {
		String sql = "select t.dept_level from dotp_taskworkhour_dept t,dotp_departments d " + 
				" where t.dept_code=d.dept_benchmark_code and d.dept_state = 0 " +
				" and d.dept_owner='" + userId + "'";
		List<Integer> list = this.template.queryForList(sql, Integer.class);
		if(list != null && list.size() > 0){
			return list.get(0);
		} else {
			return 0;
		}
	}
	
	public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }
    public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	/**
	 * @param oaTemplate
	 */
	public void setOaTemplate(JdbcTemplate oaTemplate) {
		this.oaTemplate = oaTemplate;
	}
    
	
}

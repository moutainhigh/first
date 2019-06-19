package com.deppon.dpm.module.projecttools.server.dao.impl;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.module.projecttools.server.dao.ICommonDao;
import com.deppon.dpm.module.projecttools.server.util.SqlUtil;
import com.deppon.dpm.module.projecttools.shared.domain.EmployeeEntity;
import com.deppon.dpm.module.projecttools.shared.domain.ProjectInfo;
import com.deppon.dpm.module.projecttools.shared.domain.SysDemandInfoEntity;
import com.deppon.dpm.module.projecttools.shared.domain.TasksEntity;
import com.deppon.dpm.module.projecttools.shared.domain.UserDemandInfoEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 
 * 项目管理 我的关注 dao
 * 
 * @author 195406 高春玲
 * @date 2015-7-27 下午1:45:08
 * @since
 **/
public class CommonDao extends iBatis3DaoImpl implements ICommonDao {
    private static Logger logger = LoggerFactory.getLogger(CommonDao.class);
    //
	private JdbcTemplate template;
	//任务类别 项目类任务时 对应的类别
	private List<String[]> taskType1List;
	//任务类别 管理事务类任务时 对应的类别
	private List<String[]> taskType2List;
	//任务类别 日常需求类任务时 对应的类别
	private List<String[]> taskType3List;
	//任务类别 常规工作类任务时 对应的类别
	private List<String[]> taskType4List;
	/**
	 * 查询人员信息
	 * @param code 工号或者姓名
	 * @param status 项目结项工作流中负责人查询  1
	 * @return
	 */
	public String chooseEmp(String code,int status) {
		//定义 sql
		String sql = "select con.contact_order_by,con.contact_employee_code," +
				" con.Dept_Benchmark_Code,con.contact_status,dept.dept_name,con.contact_email " +
				" from dotp_contacts con left join  dotp_departments dept " +
				" on con.dept_benchmark_code = dept.dept_benchmark_code " +
				" where con.ACTIVE = 0 and ( con.CONTACT_ORDER_BY like '%" + code + "%' " +
				" or con.CONTACT_EMPLOYEE_CODE ='" + code + "')";
	    //项目结项工作流中负责人查询
		if(status == 1) {
	    	sql += " and con.CONTACT_STATUS = 1 ";
	    }
		sql += " limit 500 ";
		logger.info(sql);
		// 根据 sql获得　员工
		List<EmployeeEntity> list = this.template.query(sql, new RowMapper<EmployeeEntity>() {
			@Override
			public EmployeeEntity mapRow(ResultSet rs, int arg1)
						throws SQLException {
					// 创建 员工实体
					EmployeeEntity info = new EmployeeEntity();
					info.setContactOrderBy(rs.getString("contact_order_by"));
					info.setContactEmployeeCode(rs.getString("contact_employee_code"));
					info.setDeptBenchmarkCode(rs.getString("Dept_Benchmark_Code"));
					info.setContactStatus(rs.getString("contact_status"));
					info.setDeptName(rs.getString("dept_name"));
					//邮箱
					info.setContactEmail(rs.getString("contact_email"));
					return info;
				}
			});
		return JSON.toJSONString(list);
	}
	/**
	 * 查询验收模块信息
	 * @return
	 */
	public String checkmodule() {
		//定义 sql
		String sql = "SELECT N.value,n.label FROM DOTP_NAMES N WHERE N.name='checkModule' order by N.value";
		// 根据 sql获得　验收模块
		List<String[]> list = this.template.query(sql, new RowMapper<String[]>() {
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
		return JSON.toJSONString(list);
	}
	/**
	 * 查询任务类别
	 * @return
	 */
	public static final int NUMBER_OF_String = 3;

	public String taskType() {
		// 定义map 变量
		Map<String, Object> map = new HashMap<String, Object>();
		//初始化
		taskType1List = new ArrayList<String[]>();
		//初始化
		taskType2List = new ArrayList<String[]>();
		//初始化
		taskType3List = new ArrayList<String[]>();
		//初始化
		taskType4List = new ArrayList<String[]>();
		//定义 sql
		String sql = "select * from dotp_names tn where tn.name in ('task_type_1','task_type_2','task_type_3','task_type_4')";
		// 根据 sql获得　任务类别
		this.template.query(sql, new RowMapper<String[]>() {
			@Override
			public String[] mapRow(ResultSet rs, int arg1)
					throws SQLException {
				//任务类型
				String name = rs.getString("name");
				// 数组
				String[] s = new String[NUMBER_OF_String];
				//字典编码
				s[0] = rs.getString("value");
				//字典名称
				s[1] = rs.getString("label");
				//任务类型
				s[2] = name;
				if("task_type_1".equals(name)) {
					taskType1List.add(s);
				} else if ("task_type_2".equals(name)) {
					taskType2List.add(s);
				} else if ("task_type_3".equals(name)) {
					taskType3List.add(s);
				} else {
					taskType4List.add(s);
				}
				return s;
			}
		});
		//赋值
		map.put("typeList1", taskType1List);
		//管理事务类
		map.put("typeList2", taskType2List);
		//日常需求类
		map.put("typeList3", taskType3List);
		//常规类工作类
		map.put("typeList4", taskType4List);
		return JSON.toJSONString(map);
	}
	
	/**
	 * 任务新建时   关联的项目选择器  
	 * 查询我的项目数据 ( 项目管理办公室 DP08466, IT项目管理组 DP10556 )
	 * @param userId 当前用户工号
	 * @param projName 搜索的项目名称
	 */
	public String searchProjList(String userId,String projName) {
		//获取部门编号
		String orgnsql = SqlUtil.getdepartmentNumber();
		//执行获取部门编号的sql
		String deptCode = this.template.queryForObject(orgnsql, new String[]{ userId }, String.class);
	    //获得项目列表 sql
//		System.out.println(deptCode+"===========");
		String sql = SqlUtil.searchProjList(userId, deptCode, projName);
		// 根据 sql获得　项目列表
		List<ProjectInfo> list = this.template.query(sql, new RowMapper<ProjectInfo>() {
			@Override
			public ProjectInfo mapRow(ResultSet rs, int arg1)
					throws SQLException {
				//定义变量
				ProjectInfo info = new ProjectInfo();
				//设置项目编号
				info.setProjectCode(rs.getString("project_code"));
				//项目编码
				info.setFaperson(rs.getString("code"));
				//项目名称
				info.setProjectname(rs.getString("proj_name"));
				//年份
				info.setBweek(rs.getString("gh_year"));
				//子系统
				info.setSubsys(rs.getString("subsysname"));
				//子系统名称
//				info.setFaperson(rs.getString("subsysname"));
				//项目类型
				info.setLastweek(rs.getString("ghtype"));
				return info;
			}
		});
		// 集合转化为 json字符串
		return JSON.toJSONString(list);
	}
	/**
	 * 任务新建时   关联的父任务选择器  
	 * 查询当前用户是任务分配者或处理者，根据任务类别或项目名称查询出 任务状态是已分配或者进行中的任务集合
	 * @param userId 当前用户工号
	 * @param projCode 项目编号
	 * @param type 任务类别 项目类任务：1    管理事务类任务：2    日常需求类任务：3      常规工作类任务：4
	 */
	public String searchPtaskList(String userId,String projCode,int type) {
		//初始化sql
		String sql = "select * from dotp_tm_tasks t where " +
				"( t.task_owner_id='" + userId + "' or t.task_processer_id='" + userId + "') " +
				//任务状态为已分配或者进行中
			    "and t.task_is_delete=0 and t.task_category= " + type + " and t.task_status in (2,3) ";
		//项目类任务 时选择父任务要根据项目名称联合搜索
		if (type == 1 && projCode != null && !projCode.equals("")) {
			sql += "and t.task_project=" + projCode;
		}
		// 根据 sql获得　父任务集合
		List<TasksEntity> list = this.template.query(sql, new RowMapper<TasksEntity>() {
			@Override
			public TasksEntity mapRow(ResultSet rs, int arg1)
					throws SQLException {
				//定义 父任务实体
				TasksEntity info = new TasksEntity();
				//设置id
				info.setId(rs.getString("id"));
				//名称
				info.setTaskName(rs.getString("task_name"));
				//任务类型
				info.setTaskTypeId(rs.getInt("task_type"));
				//任务层级
				info.setTaskLevel(rs.getInt("task_level"));
				//任务开始时间
				info.setTaskstartTime(rs.getString("task_start_time"));
				//任务结束时间
				info.setTaskendTime(rs.getString("task_end_time"));
				//-----------子任务工时之和不能大于父任务工时
				//父任务计划工时 
				info.setTaskDuration(rs.getBigDecimal("task_duration"));
				// 获得此父任务对应的子任务工时之和
				String sql = "select case when sum(task_duration) is null then 0 else sum(task_duration)  end task_duration" +
						" from dotp_tm_tasks t where t.task_is_delete=0 and task_parent=" + rs.getInt("id");
				//获得子任务工时之和
				BigDecimal sum = template.queryForObject(sql, BigDecimal.class);
				info.setTaskSumDuration(sum);
				//最上级父任务
				info.setTaskTopParentId(rs.getInt("task_top_parent"));
				//--------------获得最上级任务功能点数
//				sql = "select task_point from dotp_tm_tasks t where t.task_is_delete=0 and id=" + rs.getInt("task_top_parent");
//				//最上级任务功能点数
//				int topPoint = template.queryForInt(sql, Integer.class);
//				info.setTaskTopParentPoint(topPoint);
				return info;
			}
		});
		// 集合转化为 json字符串
		return JSON.toJSONString(list);
	}
	
	/**
	 * 用户需求选择器
	 * 根据需求名称 进行模糊搜素
	 * @param demandName
	 * @return
	 */
	public String searchUserDemand(String demandName) {
		String sql = "select u.demand_id,u.user_demand_code,u.demand_name, " +
				"case when u.demand_category=1 then '需求规划' else 'IT内部需求' end demandcategory, " +
				"case when u.it_demand_type=1 then '日常需求' when u.it_demand_type=2 then " +
				" '配合项目需求' when u.it_demand_type=3 then '项目主需求' else '' " +
				" end itdemand_type,u.demand_create_date,u.dmgh_func_point,u.demand_description from dotp_dev_user_demand_info u " ;
		//根据名称进行模糊搜素
		if(demandName != null && !demandName.equals("")) {
			sql += " where u.demand_name like '%" + demandName + "%'";
		}
		sql += " order by u.user_demand_code desc ";
		// 根据 sql获得　用户需求列表
		List<UserDemandInfoEntity> list = this.template.query(sql, new RowMapper<UserDemandInfoEntity>() {
			@Override
			public UserDemandInfoEntity mapRow(ResultSet rs, int arg1)
					throws SQLException {
				UserDemandInfoEntity info = new UserDemandInfoEntity ();
				info.setDemandId(rs.getLong("demand_id"));
				//设置编号
				info.setDemandCode(rs.getString("user_demand_code"));
				//名称
				info.setDemandName(rs.getString("demand_name"));
				//需求类别
				info.setDemandCategoryVal(rs.getString("demandcategory"));
				//需求类型
				info.setItDemandTypeVal(rs.getString("itdemand_type"));
				//创建时间
				info.setDemandCreateDate(rs.getString("demand_create_date"));
				//功能点数
				info.setDmghFuncPoint(rs.getString("dmgh_func_point"));
				//需求描述
				info.setDemandDesc(rs.getString("demand_description"));
				return info;
			}
		});
		// 集合转化为 json字符串
		return JSON.toJSONString(list);
	}
	/**
	 * 系统需求选择器
	 * 根据需求编号 进行模糊搜素
	 * @param demandCode
	 * @return
	 */
	public String searchSysDemand(String demandCode,String userDemandCode) {
		//初始化查询
		String sql = "select *,(select label from dotp_names s where s.name='demand_type' and s.value=t.demand_type) demandtype," +
				"v.sys_version_code, v.sys_analysis_empcode,v.sys_analysis_empname,d.contact_email,v.version_plan_date," +
				"v.plan_dev_date,v.version_func_point " +
				"from dotp_dev_sys_demand_info t left join dotp_dev_version_info v on v.sysdemandcode=t.sys_demand_code " +
				"left join dotp_contacts d on d.contact_employee_code=v.sys_analysis_empcode and d.active=0  " +
				"where t.user_demand_code='" + userDemandCode + "'";
		//根据需求编号 进行模糊搜素
		if(demandCode != null && !demandCode.equals("")) {
			sql += " and t.sys_demand_code like '%" + demandCode + "%'";
		}
		sql += " order by t.demand_accept_date desc";
		// 根据 sql获得　系统需求列表
		List<SysDemandInfoEntity> list = this.template.query(sql, new RowMapper<SysDemandInfoEntity>() {
			@Override
			public SysDemandInfoEntity mapRow(ResultSet rs, int arg1)
					throws SQLException {
				SysDemandInfoEntity info = new SysDemandInfoEntity ();
				info.setSysdemandid(rs.getLong("sys_demand_id"));
				//设置编号
				info.setSysdemandCode(rs.getString("sys_demand_code"));
				//需求类型
				info.setDemandtypename(rs.getString("demandtype"));
				info.setDemandtype(rs.getString("demand_type"));
				//是否主系统需求 1：是，0：不是
				info.setIsmaindemand(rs.getInt("is_main_demand"));
				//版本号
				info.setSysversion(rs.getString("sys_version_code"));
				//系统分析人员工号
				info.setSysfenxicode(rs.getString("sys_analysis_empcode"));
				//系统分析人员姓名
				info.setSysfenxiname(rs.getString("sys_analysis_empname"));
				//邮箱
				info.setSysfenxiemail(rs.getString("contact_email"));
				//计划开始时间
				info.setPlanbegindate(rs.getString("version_plan_date"));
				//计划结束时间
				info.setPlanenddate(rs.getString("plan_dev_date"));
				info.setFuncPoint(rs.getString("version_func_point"));
				return info;
			}
		});
		// 集合转化为 json字符串
		return JSON.toJSONString(list);
	}
	/**
	 * 任务开发语言
	 * 当任务类型是开发任务时 需要填写开发语言
	 * @return
	 */
	public String searchDevLang() {
		//sql
		String sql = "select * from dotp_names tn where tn.name='task_develop_language' ";
		// 根据 sql获得　任开发语言
		List<String[]> list = this.template.query(sql, new RowMapper<String[]>() {
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
		// 集合转化为 json字符串
		return JSON.toJSONString(list);
	}
	/**
	 * @param template
	 */
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
}

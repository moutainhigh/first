package com.deppon.dpm.module.projecttools.server.dao.impl;

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
import com.deppon.dpm.module.projecttools.server.dao.IYearPlanDao;
import com.deppon.dpm.module.projecttools.server.util.SqlUtil;
import com.deppon.dpm.module.projecttools.shared.domain.AnnualPlanEntity;
import com.deppon.dpm.module.projecttools.shared.domain.AnnualPlanExtra1;
import com.deppon.dpm.module.projecttools.shared.domain.AnnualPlanExtra2;
import com.deppon.dpm.module.projecttools.shared.domain.AnnualPlanExtra3;
import com.deppon.dpm.module.projecttools.shared.domain.AnnualPlanRes1Entity;
import com.deppon.dpm.module.projecttools.shared.domain.AnnualPlanRes2Entity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 
 * 项目管理 年度规划 dao
 * 
 * @author 195406 高春玲
 * @date 2015-10-16 
 * @since
 **/
public class YearPlanDao extends iBatis3DaoImpl implements IYearPlanDao {
	static Logger logger = LoggerFactory.getLogger(YearPlanDao.class);
    //
	private JdbcTemplate oaTemp;
	//
	private JdbcTemplate dppmTemp;
	//战略项目集合
	private List<AnnualPlanEntity> zlList;
	//IT项目集合
	private List<AnnualPlanEntity> itList;

    /**
     * 查询年度规划项目列表
     */
	@Override
    public String projList(String userId) throws Exception {
		// 定义map 变量
		Map<String, Object> map = new HashMap<String, Object>();
        // 获得总裁下辖的本部sql
        String sql = "select orgcode,orgname from om_organization where parentorgid=104 and orgid!=-1 ";
        // 根据 sql获得　部门信息
     	List<String[]> orgList = this.oaTemp.query(sql,
     					new RowMapper<String[]>() {
     		@Override
     		public String[] mapRow(ResultSet rs, int arg1)
     						throws SQLException {
     			// 创建 任务基本信息实体
     			String[] s = new String[2];
     			s[0] = rs.getString("orgcode");
     			s[1] = rs.getString("orgname");
     			return s;
     		}
    	});
        map.put("orgList", orgList);
        //当前用户所在大部门获得
        //获取部门名称
		String orgsql = SqlUtil.getdepartmentNamesql();
		//执行部门名称查询
		String departmentName = this.dppmTemp.queryForObject(orgsql, new String[]{ userId }, String.class);
        map.put("orgName", departmentName);
		//初始化 list
        zlList = new ArrayList<AnnualPlanEntity>();
        itList = new ArrayList<AnnualPlanEntity>();
        /// 查询年度规划 sql
        sql = "select s.*,(select label from dotp_names where name='subsys' and value=s.subsys) subsysname," +
        		"(select label from dotp_names where name='gh_type' and value=s.gh_type) ghtype," +
        		"(select label from dotp_names where name='gh_status' and value=s.gh_status) ghstatus," +
        		"(select Group_concat(dept_name) from dotp_departments where dept_benchmark_code in (" +
        		"select dept_bcode from dotp_gh_project_depts d where d.project_id=s.project_id and " +
        		" d.dept_role=1)) cjdept  from dotp_gh_projects s where s.deleted=0 " +
        		//年度规划项目按版本号降序排列，同版本号按立项时间倒序，同月份立项按录入系统时间倒序排列（与PC端保持一致）
        		"order by s.gh_version desc,s.create_time desc,s.add_time desc ";
        // 根据 sql获得　年度规划列表信息
     	this.dppmTemp.query(sql,
     					new RowMapper<AnnualPlanEntity>() {
     		@Override
     		public AnnualPlanEntity mapRow(ResultSet rs, int arg1)
     						throws SQLException {
     			// 创建 年度规划实体
     			AnnualPlanEntity info = new AnnualPlanEntity();
     			info.setProjectId(rs.getInt("project_id"));
     			//设置所属系统
     			info.setSubsys(rs.getInt("subsys"));
     			//所属系统名称
     			info.setSubsysName(rs.getString("subsysname"));
     			//项目名称
     			info.setGhName(rs.getString("gh_name"));
     			//版本号
     			info.setGhVersion(rs.getString("gh_version"));
     			//项目类型
     			info.setGhType(rs.getInt("gh_type"));
     			//项目类型
     			info.setGhTypeLabel(rs.getString("ghtype"));
     			//项目状态
     			info.setGhStatusLabel(rs.getString("ghstatus"));
     			//承接部门
     			info.setCjDept(rs.getString("cjdept"));
     			//添加战略类项目 3
     			if(rs.getInt("gh_level") == 3) {
     				zlList.add(info);
     			} else {
     				itList.add(info);
     			}
     			return info;
     		}
    	});
     	//添加战略类
     	map.put("zlList", zlList);
     	//添加it类
     	map.put("itList", itList);
        return JSON.toJSONString(map);
    }
    /**
     * 根据项目编号 获得项目规划详情和资源信息
     * @param project_id 项目编号
     * @param gh_type 项目类型
     * @return
     */
	public String projInfo(int project_id,int gh_type) {
		// 定义map 变量
		Map<String, Object> map = new HashMap<String, Object>();
		// 规划详情sql 
		String sql = "select s.*,(select label from dotp_names where name='subsys' and " +
				"value=s.subsys) subsysname,(select label from dotp_names where name='gh_type' " +
				"and value=s.gh_type) ghtype,(select label from dotp_names where name='gh_status' " +
				"and value=s.gh_status) ghstatus,(select label from dotp_names where name='gh_level' " +
				"and value=s.gh_level) ghlevel,(select Group_concat(dept_name) from dotp_departments " +
				//承接部门
				"where dept_benchmark_code in (select dept_bcode from dotp_gh_project_depts d " +
				"where d.project_id=s.project_id and d.dept_role=1)) cjdept ";
		//项目类型 如果为研发型  查询出开发平台等详情
		//研发型时 关联表： dotp_gh_project_extra1    管理咨询型：dotp_gh_project_extra2 基础设施型：dotp_gh_project_extra3
		String extra = "";
		if(gh_type == 1) {
				//系统分析部门
			sql += ",(select Group_concat(dept_name) from dotp_departments where dept_benchmark_code in (" +
					"select dept_bcode from dotp_gh_project_depts d where d.project_id=s.project_id and d.dept_role=11)) xtfxdept ," +
					//开发部门
					"(select Group_concat(dept_name) from dotp_departments where dept_benchmark_code in (" +
					"select dept_bcode from dotp_gh_project_depts d where d.project_id=s.project_id and d.dept_role=5)) kfdept ," +
					//测试部门
					"(select Group_concat(dept_name) from dotp_departments where dept_benchmark_code in (" +
					"select dept_bcode from dotp_gh_project_depts d where d.project_id=s.project_id and d.dept_role=2)) csdept ," +
					//架构部门
					"(select Group_concat(dept_name) from dotp_departments where dept_benchmark_code in (" +
					"select dept_bcode from dotp_gh_project_depts d where d.project_id=s.project_id and d.dept_role=7)) jgdept ," +
					//运维部门
					"(select Group_concat(dept_name) from dotp_departments where dept_benchmark_code in (" +
					"select dept_bcode from dotp_gh_project_depts d where d.project_id=s.project_id and d.dept_role=8)) ywdept," +
					"(select label from dotp_names where name='platforms' and value=t.platforms) platformsname," +
					"(select label from dotp_names where name='implentments' and value=t.implentments) implentname ";
			sql += ",t.* ";
			extra = " left join dotp_gh_project_extra1 t on s.project_id=t.project_id ";
		} else if (gh_type == 2) {
			sql += ",t.* ";
			//管理咨询型
			extra = " left join dotp_gh_project_extra2 t on s.project_id=t.project_id ";
		} else if (gh_type == 3) {
			// 基础设施型
			       ////应用部门
			sql += ",(select Group_concat(dept_name) from dotp_departments where dept_benchmark_code in (" +
					"select dept_bcode from dotp_gh_project_depts d where d.project_id=s.project_id and d.dept_role=10)) yydept ," +
					//数据库部门
					"(select Group_concat(dept_name) from dotp_departments where dept_benchmark_code in (" +
					"select dept_bcode from dotp_gh_project_depts d where d.project_id=s.project_id and d.dept_role=9)) sjkdept ," +
					//基础设施部门
					"(select Group_concat(dept_name) from dotp_departments where dept_benchmark_code in (" +
					"select dept_bcode from dotp_gh_project_depts d where d.project_id=s.project_id and d.dept_role=6)) jcssdept ," +
					//服务部门
					"(select Group_concat(dept_name) from dotp_departments where dept_benchmark_code in (" +
					"select dept_bcode from dotp_gh_project_depts d where d.project_id=s.project_id and d.dept_role=4)) fwdept ," +
					//测试部门
					"(select Group_concat(dept_name) from dotp_departments where dept_benchmark_code in (" +
					"select dept_bcode from dotp_gh_project_depts d where d.project_id=s.project_id and d.dept_role=2)) csdept ," +
					//架构部门
					"(select Group_concat(dept_name) from dotp_departments where dept_benchmark_code in (" +
					"select dept_bcode from dotp_gh_project_depts d where d.project_id=s.project_id and d.dept_role=7)) jgdept ," +
					"(select label from dotp_names where name='implentments' and value=t.implentments) implentname " ;
			sql += ",t.* ";
			extra = " left join dotp_gh_project_extra3 t on s.project_id=t.project_id ";
		}
 
		sql += " from dotp_gh_projects s " + extra + " where s.project_id=" + project_id;
		// 根据 sql获得　规划详情
     	List<AnnualPlanEntity> list = this.dppmTemp.query(sql,
     					new RowMapper<AnnualPlanEntity>() {
     		@Override
     		public AnnualPlanEntity mapRow(ResultSet rs, int arg1)
     						throws SQLException {
     			// 创建 年度规划实体
     			AnnualPlanEntity info = new AnnualPlanEntity();
     			info.setProjectId(rs.getInt("project_id"));
     			//设置所属系统
     			info.setSubsys(rs.getInt("subsys"));
     			//所属系统名称
     			info.setSubsysName(rs.getString("subsysname"));
     			//项目名称
     			info.setGhName(rs.getString("gh_name"));
     			//版本号
     			info.setGhVersion(rs.getString("gh_version"));
     			//项目类型
     			info.setGhType(rs.getInt("gh_type"));
     			//项目类型
     			info.setGhTypeLabel(rs.getString("ghtype"));
     			//项目状态
     			info.setGhStatusLabel(rs.getString("ghstatus"));
     			//项目级别
     			info.setGhLevelLabel(rs.getString("ghlevel"));
     			//年份
     			info.setGhYear(rs.getInt("gh_year"));
     			//承接部门
     			info.setCjDept(rs.getString("cjdept"));
     			info.setCreateTime(rs.getString("create_time"));
     			info.setFinishTime(rs.getString("finish_time"));
     			info.setNeedSpreadname(rs.getInt("need_spread") == 0 ? "否" : "是");
     			info.setStrategicName(rs.getInt("strategic") == 0 ? "否" : "是");
     			info.setNeedMobile(rs.getString("need_mobile"));
     			info.setNeedUi(rs.getString("need_ui"));
     			info.setNeedMobileName(rs.getInt("need_mobile") == 0 ? "否" : "是" );
     			info.setNeedUiName(rs.getInt("need_ui") == 0 ? "否" : "是" );
     			//业务范围
     			info.setSphereOfBusiness(rs.getString("sphere_of_business"));
     			//系统范围
     			info.setSphereOfSys(rs.getString("sphere_of_sys"));
     			int gh_type = rs.getInt("gh_type");
     			if(gh_type == 1) {
     				//研发型
     				//系统分析部门
     				info.setXtfxDept(rs.getString("xtfxdept"));
     				//开发部门
     				info.setKfDept(rs.getString("kfdept"));
     				//测试部门
     				info.setCsDept(rs.getString("csdept"));
     				//架构部门
     				info.setJgDept(rs.getString("jgdept"));
     				//运维部门
     				info.setYwDept(rs.getString("ywdept"));
     				//创建研发型
     				AnnualPlanExtra1 entity = new AnnualPlanExtra1();
     				//功能点
     				entity.setFuncCnt(rs.getInt("func_cnt"));
     				//开发平台
     				entity.setPlatformname(rs.getString("platformsname"));
     				entity.setTechnology(rs.getString("technology"));
     				entity.setImplentName(rs.getString("implentname"));
     				entity.setUserneedFromTime(rs.getString("userneed_from_time"));
     				entity.setUserneedEndTime(rs.getString("userneed_end_time"));
     				entity.setSysneedFromTime(rs.getString("sysneed_from_time"));
     				entity.setSysneedEndTime(rs.getString("sysneed_end_time"));
     				entity.setDevFromTime(rs.getString("dev_from_time"));
     				entity.setDevEndTime(rs.getString("dev_end_time"));
     				entity.setTestFromTime(rs.getString("test_from_time"));
     				entity.setTestEndTime(rs.getString("test_end_time"));
     				entity.setOnlineTime(rs.getString("online_time"));
     				entity.setSpreadFromTime(rs.getString("spread_from_time"));
     				entity.setSpreadEndTime(rs.getString("spread_end_time"));
     				//设置研发型
     				info.setExtra1Entity(entity);
     			} else if (gh_type == 2 ) {
     				//管理咨询型
     				//创建管理咨询型
     				AnnualPlanExtra2 entity = new AnnualPlanExtra2();
     				//项目背景
     				entity.setGhContext(rs.getString("gh_context"));
     				//项目目标
     				entity.setGhObjective(rs.getString("gh_objective"));
     				info.setExtra2Entity(entity);
     			} else if (gh_type == 3) {
     				info.setFwDept(rs.getString("fwdept"));
     				//基础设施部门
     				info.setSjssDept(rs.getString("jcssdept"));
     				//数据库
     				info.setSjkDept(rs.getString("sjkdept"));
     				info.setYyDept(rs.getString("yydept"));
     				//测试部门
     				info.setCsDept(rs.getString("csdept"));
     				//架构部门
     				info.setJgDept(rs.getString("jgdept"));
     				//创建基础设施型
     				AnnualPlanExtra3 entity = new AnnualPlanExtra3();
     				//项目实施方式
     				entity.setImplentName(rs.getString("implentname"));
     				entity.setSysneedFromTime(rs.getString("sysneed_from_time"));
     				entity.setSysneedEndTime(rs.getString("sysneed_end_time"));
     				entity.setApplyEndTime(rs.getString("apply_end_time"));
     				entity.setApplyFromTime(rs.getString("apply_from_time"));
     				entity.setTestEndTime(rs.getString("test_end_time"));
     				entity.setTestFromTime(rs.getString("test_from_time"));
     				entity.setOnlineTime(rs.getString("online_time"));
     				info.setExtra3Entity(entity);
     			}
     			
     			return info;
     		}
     	});
     	// 判断年度规划是否为空
     	if(list != null && list.size() > 0) {
     		map.put("projInfo", list.get(0));
     	}
     	//资源信息 sql
     	// 人员类
     	sql = "select r.*,(select label from dotp_names where name='gh_role' and value=r.emp_role) emprole," +
     			"(select label from dotp_names where name='grade' and value=r.emp_grade) empgrade " +
     			"from dotp_gh_project_res1 r where r.project_id=" + project_id;
     	// 根据 sql获得　人员类
     	List<AnnualPlanRes1Entity> res1list = this.dppmTemp.query(sql,
     					new RowMapper<AnnualPlanRes1Entity>() {
     		@Override
     		public AnnualPlanRes1Entity mapRow(ResultSet rs, int arg1)
     						throws SQLException {
     			// 创建 年度规划人员类实体
     			AnnualPlanRes1Entity info = new AnnualPlanRes1Entity();
     			info.setProjectId(rs.getInt("project_id"));
     			//资源名称
     			info.setEmpRoleLabel(rs.getString("emprole"));
     			//人员职等
     			info.setEmpGradeLabel(rs.getString("empgrade"));
     			info.setGhYear(rs.getInt("gh_year"));
     			//每月人数
     			info.setMonthCnt(rs.getString("month_cnt"));
     			//费用
     			info.setTotalCnt(rs.getLong("total_cnt"));
     			return info;
     		}
     	});
     	//判断人员类 是否为空
//     	if(res1list != null && res1list.size() > 0) {
     		map.put("res1List", res1list);
//     	}
        //人员类 费用合计 sql
     	sql = "select sum(r.total_cnt) totalcnt from   dotp_gh_project_res1 r where r.project_id=" + project_id;
     	List<String> plist = this.dppmTemp.queryForList(sql,String.class);
    	//费用合计默认 0
     	String res1Total = "0";
    	if(plist != null && plist.size() > 0){
    		res1Total = plist.get(0);
    	}
    	map.put("res1Total", res1Total);
     	// 非人员类
     	sql = "select r.*,(select label from dotp_names where name='gh_role' and value=r.cost_for) costfor " +
     			"from dotp_gh_project_res2 r where r.project_id=" + project_id;
     	// 根据 sql获得　非人员类
     	List<AnnualPlanRes2Entity> res2list = this.dppmTemp.query(sql,
     					new RowMapper<AnnualPlanRes2Entity>() {
     		@Override
     		public AnnualPlanRes2Entity mapRow(ResultSet rs, int arg1)
     						throws SQLException {
     			// 创建 年度规划非人员类实体
     			AnnualPlanRes2Entity info = new AnnualPlanRes2Entity();
     			info.setProjectId(rs.getInt("project_id"));
     			//资源名称
     			info.setCostForLabel(rs.getString("costfor"));
     			//费用
     			info.setCostCnt(rs.getLong("cost_cnt"));
     			return info;
     		}
     	});
     	//判断非人员类 是否为空
//     	if(res2list != null && res2list.size() > 0) {
     		map.put("res2List", res2list);
//     	}
     	//人员类 费用合计 sql
        sql = "select sum(r.cost_cnt) totalcnt from   dotp_gh_project_res2 r where r.project_id=" + project_id;
        plist = this.dppmTemp.queryForList(sql,String.class);
        //费用合计默认 0
        String res2Total = "0";
        if(plist != null && plist.size() > 0){
        	res2Total = plist.get(0);
        }
        map.put("res2Total", res2Total);
     	return JSON.toJSONString(map);
	}
	
	/**
	 * @param oaTemp
	 */
	public void setOaTemp(JdbcTemplate oaTemp) {
		this.oaTemp = oaTemp;
	}

	/**
	 * @param dppmTemp
	 */
	public void setDppmTemp(JdbcTemplate dppmTemp) {
		this.dppmTemp = dppmTemp;
	}

	/**
	 * @param zlList
	 */
	public void setZlList(List<AnnualPlanEntity> zlList) {
		this.zlList = zlList;
	}

	/**
	 * @param itList
	 */
	public void setItList(List<AnnualPlanEntity> itList) {
		this.itList = itList;
	}

	
	
}

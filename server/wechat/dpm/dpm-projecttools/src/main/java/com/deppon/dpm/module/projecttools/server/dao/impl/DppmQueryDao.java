package com.deppon.dpm.module.projecttools.server.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.projecttools.server.dao.IDppmQueryDao;
import com.deppon.dpm.module.projecttools.server.util.SqlUtil;
import com.deppon.dpm.module.projecttools.shared.domain.ProDepartmentInfo;
import com.deppon.dpm.module.projecttools.shared.domain.ProjectDeatilInfo;
import com.deppon.dpm.module.projecttools.shared.domain.ProjectInfo;
import com.deppon.dpm.module.projecttools.shared.domain.ProjectMilestoneInfo;
import com.deppon.dpm.module.projecttools.shared.domain.ProjectMinutes;
import com.deppon.dpm.module.projecttools.shared.domain.ProjectMinutesBack;
import com.deppon.dpm.module.projecttools.shared.domain.ProjectResources;
import com.deppon.dpm.module.projecttools.shared.domain.ProjectStrutsInfo;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * <p>ClassName: 项目列表工具</p>
 * <p>Author: 石学钢</p>
 * <p>Date: 2015-7-29</p>
 */
public class DppmQueryDao extends iBatis3DaoImpl implements IDppmQueryDao{
	/*** 日志*/
	Logger logger = LoggerFactory.getLogger(DppmQueryDao.class);
	//3 战略项目   ——12 IT项目
	private static int c_project = 3;
	/**获取JDBC连接*/
	JdbcTemplate template;
	/**战略项目容器*/
	List<ProjectInfo> projectSTinfo;
	/**IT项目容器*/
	List<ProjectInfo> projectITinfo;
	/**项目状态详情容器*/
	Map<String,ProjectStrutsInfo> strutsInfoMap;
	//统计所有的项目数量
	int sum = 0;
	//权限配置工号
	String proJobNumber;
	
	/**
	 * 个人IT、战略项目列表查询
	 * 16.1.7 项目管理办公室 人员进来显示所有
	 * */
	@Override
	public String queryproject(String userId,String jobLevel,boolean isBand,boolean isPmo) {
		//查询权限
		boolean power=isBand;
		//用户ID判断项目管理工具权限表
		String powersql = SqlUtil.getPowerquery();
		//获取返回的查询数量
		int coi = template.queryForObject(powersql, new String[]{userId},Integer.class);
		//判断用户是否拥有查询所有的权限
		power = power || isPmo || coi > 0 ? true : false;
		//I容器
		Map<String, Object> map = new HashMap<String, Object>();
		//收藏项目容器
		Map<String, Object> collectProject = null;
		if(!power){
			//查询收藏列表
			collectProject = queryCollectProject(userId, power+"", "");
			map.put("aItProject", projectITinfo);
			map.put("aStrategyProject", projectSTinfo);
		} else {
			//执行部门名称查询
			String departmentName = "";
			if(isPmo) {
				departmentName = "所有项目";
			} else {
				//获取部门名称
				String orgsql = SqlUtil.getdepartmentNamesql();
				//执行部门名称查询
				departmentName = template.queryForObject(orgsql, new String[]{userId}, String.class);	
			}
			logger.info("orgsql 个人部门查询  ——查询条件" + userId + "部门名称" + departmentName);
			//按个人部门进行查询
			//查询收藏列表
			collectProject = queryCollectProject(userId,power + "", departmentName);
			//查询所有一级部门的名称
			//部门容器
			List<ProDepartmentInfo> infos = new ArrayList<ProDepartmentInfo>();
			//部门和对应项目数目查询语句
			String DepartmentSql = SqlUtil.getDepartmentSql();
			logger.info("所有部门查询——" + DepartmentSql);
			infos = template.query(DepartmentSql, new RowMapper<ProDepartmentInfo>() {
				@Override
				public ProDepartmentInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
					ProDepartmentInfo departmentInfo = new ProDepartmentInfo();
					//部门ID
					departmentInfo.setId(rs.getString("id"));
					//部门名称
					departmentInfo.setName(rs.getString("dname"));
					//部门对你的项目总数
					departmentInfo.setCounts(rs.getInt("counts"));
					//统计项目数量
					sum = departmentInfo.getCounts() + sum;
					return departmentInfo;
				}
			});
			//所有项目
			ProDepartmentInfo department = new ProDepartmentInfo();
			//设置所有项目的key
			department.setId("All");
			//所有项目value
			department.setName("所有项目");
			//所有项目的总数量
			department.setCounts(sum);
			sum = 0;
			infos.add(department);
			//返回当前用户ID部门
			map.put("orgName", departmentName);
			//返回部门列表
			map.put("department", infos);
		}
		//返回收藏列表
		map.putAll(collectProject);
		//返回权限
		map.put("power", power);
		
		return JsonUtil.mapToJsonString(map);
	}

	/** 
	 * TODO 按所属系统查询项目列表
	 * @author 石学钢
	 * 2015-9-24
	 * @see com.deppon.dpm.module.projecttools.server.dao.IDppmQueryDao#queryDepartmentproject(java.lang.String, java.lang.String)
	 */
	@Override
	public Map<String, Object> queryDepartmentproject(String userId, String jobnumber) {
		//战略项目列表	
		projectSTinfo = new ArrayList<ProjectInfo>();
		//IT项目列表
		projectITinfo = new ArrayList<ProjectInfo>();
		//用户的部门
		String jobNuberStr = jobnumber;
		//判断查询的部门
		if(!jobNuberStr.isEmpty() && jobNuberStr.trim().equals("所有项目")){
			jobNuberStr = "1";
		}
		//项目列表查询语句
		String sql = SqlUtil.getQueryproject(2,jobNuberStr);
		logger.info("所属系统项目列表查询语句————#####userId="+userId+"##部门名称="+jobNuberStr);
		//执行项目列表查询
		template.query(sql, new String[]{userId},new RowMapper<String>(){
			@Override
			public String mapRow(ResultSet rs, int arg1) throws SQLException {
				ProjectInfo info = new ProjectInfo();
				//项目编码
				info.setProjectCode(rs.getString("projectCode"));
				//项目名称
				info.setProjectname(rs.getString("projectname"));
				info.setFaperson(rs.getString("faperson"));
				info.setMangerperson(rs.getString("mangerperson"));
				//所属系统
				info.setSubsys(rs.getString("subsys"));
				info.setProjectschedule(rs.getString("projectschedule"));
				//项目状态
				info.setProjectstatue(rs.getString("projectstatue"));
				//上周状态
				info.setBweek(rs.getString("bweek"));
				//这周状态
				info.setLastweek(rs.getString("lastweek"));
				//是否收藏
				info.setIsLoving(rs.getInt("isLoving"));
				info.setOvertaken("overtaken");
				//区分IT/战略项目
				if(rs.getInt("projLevel") == c_project){
					//战略项目
					projectSTinfo.add(info);	
				} else {
					//IT项目
					projectITinfo.add(info);
				}
				return null;
			}
		});
			//IT/战略项目转为JSON
		Map<String, Object> map = new HashMap<String, Object>();
		//添加全部的IT项目
		map.put("aItProject", projectITinfo);
		//添加全部的战略项目
		map.put("aStrategyProject", projectSTinfo);
		
		return map;
	}
	/** 
	 * TODO 按用户ID查询收藏列表
	 * @author 十二刚
	 * 2015-9-24
	 * @see com.deppon.dpm.module.projecttools.server.dao.IDppmQueryDao#queryCollectProject(java.lang.String, java.lang.String, java.lang.String)
	 */
	public Map<String, Object> queryCollectProject(String userId,String power,String jobnumber){
		String sql = null;
		Map<String, Object> departmentMap = null;
		//判断用户查询权限
		if(!power.isEmpty() && power.trim().equals("false")){
			//获取部门编号
			String orgnsql = SqlUtil.getdepartmentNumber();
			//执行获取部门编号的sql
			String departmentNumber = template.queryForObject(orgnsql, new String[]{userId}, String.class);
			//执行个人项目列表查询语句
			sql = SqlUtil.getPowerQueryproject(userId,departmentNumber);
			//拼接sql
			String powerSql = sql + " GROUP BY v.AI_ID  ORDER BY bweek desc,proj_status_seq asc "; //15.11.30 排序：①按本周状态：红黄绿； ②状态：开展中、待开展、中止、已结项；
			sql += " AND t.user_code = ?  GROUP BY v.AI_ID  ORDER BY bweek desc,proj_status_seq asc";
			//战略项目列表
			projectSTinfo = new ArrayList<ProjectInfo>();
			//IT项目列表
			projectITinfo = new ArrayList<ProjectInfo>();	
			//日志打印
			logger.info("个人系统项目查询——" + powerSql);
			//执行查询
			template.query(powerSql, new RowMapper<String>(){
				@Override
				public String mapRow(ResultSet rs, int arg1) throws SQLException {
					ProjectInfo info = new ProjectInfo();
					//项目编码
					info.setProjectCode(rs.getString("projectCode"));
					//项目名称
					info.setProjectname(rs.getString("projectname"));
					info.setFaperson(rs.getString("faperson"));
					info.setMangerperson(rs.getString("mangerperson"));
					//项目所属系统
					info.setSubsys(rs.getString("subsys"));
					info.setProjectschedule(rs.getString("projectschedule"));
					//项目状态
					info.setProjectstatue(rs.getString("projectstatue"));
					info.setBweek(rs.getString("bweek"));
					info.setLastweek(rs.getString("lastweek"));
					//是否收藏
					info.setIsLoving(rs.getInt("isLoving"));
					info.setOvertaken("overtaken");
					//判断战略、IT项目
					if(rs.getInt("projLevel") == c_project){
						//添加战略项目
						projectSTinfo.add(info);	
					} else {
						//添加IT项目
						projectITinfo.add(info);
					}
					return null;
				}
			});
			departmentMap = new HashMap<String, Object>();
			//放入全部项目
			departmentMap.put("aItProject", projectITinfo);
			departmentMap.put("aStrategyProject", projectSTinfo);
		} else {
			//查询 我的收藏
			sql = SqlUtil.getQueryproject(1,"");
			//查询部门下 所有项目
			departmentMap = queryDepartmentproject(userId,jobnumber);
		}
		//战略项目列表
		projectSTinfo = new ArrayList<ProjectInfo>();
		//IT项目列表
		projectITinfo = new ArrayList<ProjectInfo>();	
		//执行查询
		template.query(sql, new String[]{userId},new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet rs, int arg1) throws SQLException {
				ProjectInfo info = new ProjectInfo();
				//项目编码
				info.setProjectCode(rs.getString("projectCode"));
				//项目名称
				info.setProjectname(rs.getString("projectname"));
				info.setFaperson(rs.getString("faperson"));
				info.setMangerperson(rs.getString("mangerperson"));
				//所属系统
				info.setSubsys(rs.getString("subsys"));
				info.setProjectschedule(rs.getString("projectschedule"));
				info.setProjectstatue(rs.getString("projectstatue"));
				//这周状态
				info.setBweek(rs.getString("bweek"));
				//上周状态
				info.setLastweek(rs.getString("lastweek"));
				//收藏状态
				info.setIsLoving(rs.getInt("isLoving"));
				//承接部门
				info.setOvertaken("overtaken");
				if(rs.getInt("projLevel") == c_project){
					//战略项目
					projectSTinfo.add(info);	
				}
				else {
					//IT项目
					projectITinfo.add(info);
				}
				return null;
			}
		});
		//放入收藏项目
		Map<String, Object> map = new HashMap<String, Object>();
		//放入收藏IT项目
		map.put("cItProject", projectITinfo);
		//放入收藏战略项目
		map.put("cStrategyProject", projectSTinfo);
		map.putAll(departmentMap);
		
		return map;
	}
	
	/** 
	 * TODO 项目状态详情查询
	 * @author 石学钢
	 * 2015-9-24
	 * @see com.deppon.dpm.module.projecttools.server.dao.IDppmQueryDao#queryStrutsInfo(java.lang.String)
	 */
	@Override
	public Map<String,ProjectStrutsInfo> queryStrutsInfo(String projectCode) {
		String sql = SqlUtil.getQueryprojectStruts();
		strutsInfoMap = new HashMap<String, ProjectStrutsInfo>();
		//日志打印
		logger.info("项目状态详情查询————" + sql);
		//执行详情查询
		template.query(sql, new String[]{projectCode},new RowMapper<ProjectStrutsInfo>() {

			@Override
			public ProjectStrutsInfo mapRow(ResultSet rs, int arg1) throws SQLException {
				ProjectStrutsInfo info = new ProjectStrutsInfo();
				info.setCurrentstatus(rs.getString("CURRENTSTATUS"));
				info.setModifyperson(rs.getString("MODIFYPERSON"));
				info.setModifypersoncode(rs.getString("MODIFYPERSONCODE"));
				info.setModifypersondept(rs.getString("MODIFYPERSONDEPT"));
				info.setReason(rs.getString("REASON"));
				info.setModifytime(rs.getString("modifytime"));
				//判断这周和上周状态
				if(strutsInfoMap.size() > 0){
					strutsInfoMap.put("lastWeek", info);
				} else {
					strutsInfoMap.put("bWeek", info);
				}
				return null;
			}
		});
		return strutsInfoMap;
	}
	/** 
	 * TODO 项目里程碑、基本详情查询
	 * @author 石学钢
	 * 2015-9-24
	 * @see com.deppon.dpm.module.projecttools.server.dao.IDppmQueryDao#queryProjectDeatil(java.lang.String)
	 */
	@Override
	public Map<String, Object> queryProjectDeatil(String projectCode) {
		//项目基本详情查询语句
		String deatilSql = SqlUtil.getQueryProjectDeatil();
		//项目里程碑查询语句
		String milestoneSql = SqlUtil.getQueryProjectMilestone();
		//项目立项结项时间查询
		String lixiang=SqlUtil.getQueryProjectMilestonee();
		//基本详情信息查询
		logger.info("基本详情查询语句————" + deatilSql);
		ProjectDeatilInfo deatilInfo = template.queryForObject(deatilSql, new String[]{projectCode}, new BeanPropertyRowMapper<ProjectDeatilInfo>(ProjectDeatilInfo.class));
		//里程碑信息查询
		logger.info("里程碑查询语句————" + milestoneSql);
		//项目立项结项时间查询
		logger.info("项目立项结项时间查询语句————" + lixiang);
		List<ProjectMilestoneInfo> milestoneInfo = template.query(milestoneSql, new String[]{projectCode},new RowMapper<ProjectMilestoneInfo>() {
			@Override
			public ProjectMilestoneInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProjectMilestoneInfo info = new ProjectMilestoneInfo();
				//会议纪要ID
				info.setMid(rs.getInt("mid"));
				//里程碑名称
				info.setMsname(rs.getString("msname"));
				//里程碑描述
				info.setMssummary(rs.getString("mssummary"));
				//项目ID
				info.setProjectcode(rs.getString("projectcode"));
				//项目名称
				info.setProjectname(rs.getString("projectname"));
				//项目简介
				info.setProjectprofile(rs.getString("projectprofile"));
				// 时间
				info.setTimepoint(rs.getString("timepoint"));
				//判断里程碑节点是否有会议纪要
				info.setIsmsId(rs.getString("ismsId"));
				return info;
			}
		});
		//项目立项时间查询
		List<ProjectMilestoneInfo> li=template.query(lixiang, new String[]{projectCode},new RowMapper<ProjectMilestoneInfo>() {
			@Override
			public ProjectMilestoneInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProjectMilestoneInfo info = new ProjectMilestoneInfo();
				//给立项时间赋值
				info.setTimepoint(rs.getString("createtime"));
				info.setMsname("立项");
				return info;
			}
		});
		//项目结项时间查询
		List<ProjectMilestoneInfo> lil=template.query(lixiang, new String[]{projectCode},new RowMapper<ProjectMilestoneInfo>() {
			@Override
			public ProjectMilestoneInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProjectMilestoneInfo info = new ProjectMilestoneInfo();
				//给结项时间赋值
				info.setTimepoint(rs.getString("finishtim"));
				info.setMsname("结项");
				return info;
			}
		});
		//定义list
		List<ProjectMilestoneInfo> mi=new ArrayList<ProjectMilestoneInfo>();
		mi.add(li.get(0));
		//循环赋值
		for (ProjectMilestoneInfo pm : milestoneInfo) {
			mi.add(pm);
		}
		mi.add(lil.get(0));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("MiledetailVo", deatilInfo);
//		map.put("MilestoneVo", milestoneInfo);
		map.put("MilestoneVo", mi);
		return map;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	/** 
	 * TODO 任务审核
	 * @author 石学钢
	 * 2015-9-24
	 * @see com.deppon.dpm.module.projecttools.server.dao.IDppmQueryDao#audit(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String audit(String checkStatus, String taskId,String opString) {
		String sql = SqlUtil.getAuditStatusupdate();
		String checklogsql = null;
		String logsql = SqlUtil.getAuditlog();
		//判断用户是否需要审核
		if (checkStatus != null && checkStatus.equals("1")){
			//审核通过
			sql += ",task_percent_complete = ? where id=?";
			template.update(sql, "7", "0", "100", taskId);
			//审核检查日志
			checklogsql = SqlUtil.getAuditChecklog(taskId, opString, 1);
			//插入日志信息
			template.execute(checklogsql);
			//审核成功信息修改
			template.update(logsql, taskId, taskId);
			logger.info("审核提交记录日志  SQL statement" + checklogsql  );
			logger.info("任务表修改  SQL statement" + sql);
			logger.info("审核日志表修改  SQL statement" + logsql + "##tastId=" + taskId);
			// 更新问题风险状态为已关闭
			updateRiskState(taskId);
			return "1";
		} else if (checkStatus != null && checkStatus.equals("2")){
			//审核不通过
			sql += " where id=?";
			template.update(sql, "3", "0", taskId);
			//插入日志信息
			checklogsql = SqlUtil.getAuditChecklog(taskId, opString, 2);
			template.execute(checklogsql);
			//审批失败信息处理
			template.update(logsql, taskId, taskId);
			logger.info("审核提交记录日志  SQL statement" + " [" + checklogsql + "]" );
			logger.info("任务表修改  SQL statement" + " [" + sql + "]");
			logger.info("审核日志表修改  SQL statement" +" [" + logsql + "]" + "##tastId="+taskId);
			
			return "1";
		}
		return null;
	}
	
	/**
	 * 更新问题风险状态为已关闭
	 */
	private void updateRiskState(String taskId){
		// 根据任务id 获取riskid
		String riskId = getRiskIdByTaskId(taskId);
		// 判断是否是问题风险任务
		if(StringUtils.isNotBlank(riskId)){
			// 更新问题风险状态
			String riskSql = SqlUtil.updateRiskState("已关闭","5",riskId);
			// 日志打印
			logger.info(" 更新问题风险状态为已关闭  SQL statement" + riskSql  );
			template.update(riskSql);
		}
	}
	
	/**
	 * 根据任务id 获取riskid
	 * @return
	 */
	public String getRiskIdByTaskId(String taskId) {
		//sql
		String sql = " select t.risk_id from dotp_tm_tasks t where t.task_is_delete = 0 and t.id = " + taskId;
		// 获取可分配工时的sql
		logger.info("根据任务id获取riskid的sql语句————" + sql);
		//执行查询
		String riskId=template.queryForObject(sql,String.class);
		// 返回
		return riskId;
	}
	
	public void setProJobNumber(String proJobNumber) {
		this.proJobNumber = proJobNumber;
	}
	/** 
	 * <p>Title: 会议纪要</p>
	 * <p>Description:查询出会议纪要的数据 </p>
	 * @param msId
	 * @return ProjectMinutes 会议纪要实体类
	 */
	@Override
	public ProjectMinutes queryprojectMinutes(String msId) {
		//会议纪要查询语句
		String minutesSql = SqlUtil.getMilestoneMinutes();
		//代办事项查询语句
		String BackSql = SqlUtil.getMilestoneMinutesBack();
		logger.info("会议纪要查询语句————" + minutesSql);
		//执行查询
		ProjectMinutes projectMinutes = template.queryForObject(minutesSql, new String[]{msId}, new BeanPropertyRowMapper<ProjectMinutes>(ProjectMinutes.class));
		List<ProjectMinutesBack> projectMinutesBacks = template.query(BackSql, new String[]{msId},new RowMapper<ProjectMinutesBack>() {

			@Override
			public ProjectMinutesBack mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProjectMinutesBack projectMinutesBack = new ProjectMinutesBack();
				projectMinutesBack.setBacklogContent(rs.getString("backlog_content"));
				projectMinutesBack.setBacklogDutyman(rs.getString("backlog_dutyman"));
				projectMinutesBack.setFinisheTime(rs.getDate("finishe_time"));
				return projectMinutesBack;
			}
		});
		//返回会议纪要查询结果
		projectMinutes.setProjectMinutesBacks(projectMinutesBacks);
		return projectMinutes;
	}
	/**
	 *  Title:查看项目资源
	 *  @param projectCode
	 *  @return ProjectResources 项目资源实体类
	 *  Author: 280769
	 * 	Date: 2015-9-28
	 * */
	@Override
	public List<ProjectResources> queryProjectResources(String projectCode) {
		//查看项目资源的语句
		String projectSql = SqlUtil.getProjectResources();
		logger.info("查看项目资源的语句————" + projectSql);
		//执行查询
		//		List<ProjectResources> projectResorces =template.queryForObject(projectSql, new String[]{projectCode},new BeanPropertyRowMapper<ProjectResources>(ProjectResources.class));
//		List<ProjectResources> projectResorcesList=template.query(projectSql, new String[]{projectCode},new RowMapper<ProjectResources>(){
		List<ProjectResources> projectResorcesList = this.template.query(projectSql, new String[]{projectCode,projectCode,projectCode},new RowMapper<ProjectResources>(){
			@Override
			public ProjectResources mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				ProjectResources projectResorcess =new ProjectResources();
				projectResorcess.setEmpRole(rs.getString("empRoleName"));
				projectResorcess.setBandCnt(rs.getString("bandCnt"));
				projectResorcess.setManDay(rs.getInt("manDay")/10);
				projectResorcess.setRolePrice(rs.getBigDecimal("roleProce"));
				projectResorcess.setAllProce(rs.getBigDecimal("allProce"));
				projectResorcess.setUnitPrice(rs.getBigDecimal("unitProce"));
				projectResorcess.setCostSummary(rs.getString("costSummary"));
				projectResorcess.setPackPrice(rs.getBigDecimal("packPrice"));
				projectResorcess.setCflag(rs.getString("cflag"));
				return projectResorcess;
			}
			
		});
		//返回项目资源查询结果
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("ProjectResources", projectResorcesList);
		return projectResorcesList;
	}
}
package com.deppon.dpm.module.wfs.server.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.deppon.dpm.module.projecttools.shared.domain.AnnualPlanEntity;
import com.deppon.dpm.module.projecttools.shared.domain.AnnualPlanExtra1;
import com.deppon.dpm.module.projecttools.shared.domain.EmployeeEntity;
import com.deppon.dpm.module.projecttools.shared.domain.FileEntity;
import com.deppon.dpm.module.wfs.server.dao.IDppmChangeCheckDao;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ChangeCheckEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ChangeEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ChangeLogEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ProjectEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 
 * dppm 项目管理 项目变更审批工作流，年度规划路径变更申请工作流 dao
 * 
 * @author 195406 高春玲
 * @date 2015-11-4
 * @since
 **/
public class DppmChangeCheckDao extends iBatis3DaoImpl implements IDppmChangeCheckDao {
    // 
	private JdbcTemplate dppmTemp;
	/**
	 * @param dppmTemp
	 */
	public void setDppmTemp(JdbcTemplate dppmTemp) {
		this.dppmTemp = dppmTemp;
	}
   
	////////////////项目变更审批工作流
	/**
	 * 项目变更审核信息获得
	 * @param wfsid 工作流号
	 * @return
	 */
	public Map<String, Object> queryChangeCheckInfo(String wfsid) {
		// 定义map 变量
		Map<String, Object> map = new HashMap<String, Object>();
		// sql
		String sql = "select v.change_id, v.change_state, v.change_type, v.process_id, v.change_code, "
				+ " v.change_reason, v.create_empname, v.create_empcode,v.change_reviewer,"
				+ " v.audit_state,v.create_time, v.is_delete, v.new_aiid as new_ai_id, v.old_aiid as old_ai_id,"
				+ " v.project_id, v.project_name, v.project_status, v.project_type, v.subsys, "
				+ " v.gh_version, v.pmid1_name, v.initiator_name, v.audit_state_label "
				+ " from v_check_change v where v.process_id = " + wfsid;
		// 根据 sql 获得项目变更审核信息
    	List<ChangeCheckEntity> list = this.dppmTemp.query(sql,
    			new RowMapper<ChangeCheckEntity>(){
    		@Override
			public ChangeCheckEntity mapRow(ResultSet rs, int rowNum)
					throws SQLException {
    			ChangeCheckEntity info = new ChangeCheckEntity();
    			//id
    			info.setChangeId(rs.getInt("change_id"));
    			//变更单号
    			info.setChangeCode(rs.getString("change_code"));
    			//变更状态(1是新增，2是修改，3是删除，4是重大变更，5是一般变更)
    			info.setChangeState(rs.getInt("change_state"));
    			//变更类型（1是年度规划变更，2是项目变更）
    			info.setChangeType(rs.getInt("change_type"));
    			//变更原因
    			info.setChangeReason(rs.getString("change_reason"));
    			//变更评审人
    			info.setChangeReviewer(rs.getString("change_reviewer"));
    			//项目名称
    			info.setProjectName(rs.getString("project_name"));
    			//项目编号
    			info.setProjectId(rs.getInt("project_id"));
    			//项目状态
    			info.setProjectStatus(rs.getInt("project_status"));
    			//变更工作流号
    			info.setProcessId(rs.getLong("process_id"));
    			return info;
    		}
    	});
    	//获得项目变更审核信息
    	if(list != null && list.size() > 0) {
    		ChangeCheckEntity entity = list.get(0);
    		map.put("changeCheckEntity", entity);
    		// 变更状态为修改和删除的 获得变更记录
//    		if(entity.getChangeState() == 2 || entity.getChangeState() == 3) {
    			//变更记录 sql 
    			sql = "select l.id, l.change_id, l.field_desc, l.field_name,l.old_value, "
    					+ "l.new_value, l.create_time, l.oper_type,l.is_delete from dotp_change_log l "
    					+ "left JOIN dotp_change_list c on l.change_id = c.id "
    					+ " LEFT JOIN dotp_gh_projects_change g on c.ai_id = g.project_id and c.change_state = 1 "
    					+ " left join dotp_gh_projects p on c.project_id = p.project_id and " +
    					" (c.change_state = 2 or c.change_state = 3) where l.change_id=" + entity.getChangeId();
    			// 根据 sql 获得项目变更记录信息
    			List<ChangeLogEntity> clist = this.dppmTemp.query(sql,
    					new RowMapper<ChangeLogEntity>(){
    				@Override
    				public ChangeLogEntity mapRow(ResultSet rs, int rowNum)
    						throws SQLException {
    					ChangeLogEntity info = new ChangeLogEntity();
    					info.setLogId(rs.getInt("id"));
    					//changeid
    					info.setChangeId(rs.getInt("change_id"));
    					//变更字段描述
    					info.setFieldDesc(rs.getString("field_desc"));
    					//变更前内容
    					info.setOldValue(rs.getString("old_value"));
    					//变更后内容
    					info.setNewValue(rs.getString("new_value"));
    					return info;
    				}
    			});
    			map.put("changeLogList", clist);
//    		}
    		//附件
    		sql = "select * FROM dotp_attachment U WHERE U.MODULE_ID = " + entity.getChangeId() + " AND U.MODULE = 'dotp_change'";
    		// 根据附件 sql获得 任务对应的附件集合
	    	List<FileEntity> filesList = this.dppmTemp.query(sql,
					new RowMapper<FileEntity>() {

				@Override
				public FileEntity mapRow(ResultSet rs, int arg1)
						throws SQLException {
					// 创建附件实体
					FileEntity info = new FileEntity();
					// 对附件信息 赋值
					info.setFileName(rs.getString("file_name"));
					info.setFileType(rs.getString("file_type"));
					info.setSavePath(rs.getString("save_path"));
					return info;
				}
			});
	    	map.put("fileList", filesList);
    	}
    	return map;
	}
	/**
	 * 根据工作流号获得项目变更审核信息
	 * @param wfsid 工作流号
	 * @return
	 */
	public ChangeCheckEntity querychangeCheck(Long wfsid) {
		//初始化
		ChangeCheckEntity entity = null;
		// sql
		String sql = "select v.change_id, v.change_state, v.change_type, v.process_id, v.change_code, "
				+ " v.change_reason, v.create_empname, v.create_empcode,v.change_reviewer,"
				+ " v.audit_state,v.create_time, v.is_delete, v.new_aiid as new_ai_id, v.old_aiid as old_ai_id,"
				+ " v.project_id, v.project_name, v.project_status, v.project_type, v.subsys, "
				+ " v.gh_version, v.pmid1_name, v.initiator_name, v.audit_state_label "
				+ " from v_check_change v where v.process_id = " + wfsid;
		// 根据 sql 获得项目变更审核信息
		List<ChangeCheckEntity> list = this.dppmTemp.query(sql,
				new RowMapper<ChangeCheckEntity>(){
			@Override
			public ChangeCheckEntity mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				ChangeCheckEntity info = new ChangeCheckEntity();
				//id
				info.setChangeId(rs.getInt("change_id"));
				//变更单号
				info.setChangeCode(rs.getString("change_code"));
				//变更状态(1是新增，2是修改，3是删除，4是重大变更，5是一般变更)
				info.setChangeState(rs.getInt("change_state"));
				//变更类型（1是年度规划变更，2是项目变更）
				info.setChangeType(rs.getInt("change_type"));
				//变更原因
				info.setChangeReason(rs.getString("change_reason"));
				//变更评审人
				info.setChangeReviewer(rs.getString("change_reviewer"));
				//项目名称
				info.setProjectName(rs.getString("project_name"));
				//项目编号
				info.setProjectId(rs.getInt("project_id"));
				//项目状态
				info.setProjectStatus(rs.getInt("project_status"));
				//变更工作流号
				info.setProcessId(rs.getLong("process_id"));
				info.setOldAiId(rs.getInt("old_ai_id"));
				info.setNewAiId(rs.getInt("new_ai_id"));
				info.setProjectType(rs.getInt("project_type"));
				info.setGhVersion(rs.getString("gh_version"));
				return info;
			}
		});
		//获得项目变更审核信息
    	if(list != null && list.size() > 0) {
    		entity = list.get(0);
    	}
    	return entity;
	}
	/**
	 * 审批项目变更成功后，如果是年度规划项目新增，就复制变更的数据到正式库
	 * @param params
	 * @return
	 */
	public int insertYearPlanProj(int aiId) throws Exception {
		//插入sql
		final String sql = "INSERT INTO `dotp_gh_projects` (`gh_name`, `gh_year`, `gh_type`, `gh_level`, `gh_status`,"
				+ "`create_time`, `finish_time`, `commit_time`, `subsys`, `gh_version`, `need_spread`, "
				+ "`strategic`, `sphere_of_business`, `sphere_of_sys`, `add_time`, `deleted`) "
				+ "select `gh_name`, `gh_year`, `gh_type`, `gh_level`, `gh_status`, "
				+ "`create_time`, `finish_time`, `commit_time`, `subsys`, `gh_version`, `need_spread`, "
				+ "`strategic`, `sphere_of_business`, `sphere_of_sys`, `add_time`, `deleted`"
				+ "from `dotp_gh_projects_change` where ai_id = " + aiId;
		this.logger.info("----审批项目变更成功后：年度规划项目新增 --复制变更的数据到正式库-- aiid:" + aiId);
		//执行更新获得主键
		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.dppmTemp.update(new PreparedStatementCreator() {  
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {  
				PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);  
				return ps;
			}
		}, keyHolder);
		//获得主键
		int keyId = keyHolder.getKey().intValue();
		this.logger.info("----审批项目变更成功后：年度规划项目新增 --复制变更的数据到正式库 保存成功后生成的-- projectid:" + keyId);
		//------------插入项目的各项费用
		String vsql = "INSERT INTO `dotp_gh_project_costs` (`project_id`, `total_costs`, `business_cost`, " +
				"`business_cost_mp`,`BI_cost`, `BI_cost_mp`, `develop_cost`, `develop_cost_mp`, `manage_cost`," +
				"`manage_cost_mp`,`consult_cost`, `supplier_cost`, `infrastructure_cost`, `func_cnt`)" +
				"select " + keyId + ", `total_costs`, `business_cost`, `business_cost_mp`,`BI_cost`, " +
				"`BI_cost_mp`, `develop_cost`, `develop_cost_mp`, `manage_cost`,`manage_cost_mp`, " +
				"`consult_cost`, `supplier_cost`, `infrastructure_cost`, `func_cnt` " +
				" from `dotp_gh_project_costs_change` where project_id = " + aiId;
		//执行插入
		int flag = this.dppmTemp.update(vsql);
		this.logger.info("----审批项目变更成功后：年度规划项目新增 --插入项目的各项费用--是否成功：" + flag);
		//----------插入年度规划项目中相关的部门
		vsql = "INSERT INTO `dotp_gh_project_depts` (`project_id`, `dept_bcode`, `dept_role`) " +
				" select " + keyId + ", `dept_bcode`, `dept_role` " +
				" from `dotp_gh_project_depts_change` where project_id = " + aiId ;
		//执行插入
		flag = this.dppmTemp.update(vsql);
		this.logger.info("----审批项目变更成功后：年度规划项目新增 --插入项目的相关的部门--是否成功：" + flag);
		//--------------项目额外信息 - 研发型
		vsql = "INSERT INTO `dotp_gh_project_extra1` " +
				"(`project_id`, `func_cnt`, `platforms`, `technology`, `implentments`,  " +
				"`userneed_from_time`, `userneed_end_time`, `sysneed_from_time`, `sysneed_end_time`,  " +
				"`dev_from_time`, `dev_end_time`, `test_from_time`, `test_end_time`, `online_time`,  " +
				"`spread_from_time`, `spread_end_time`)  " +
				"select " + keyId + ", `func_cnt`, `platforms`, `technology`, `implentments`,  " +
				"`userneed_from_time`, `userneed_end_time`, `sysneed_from_time`, `sysneed_end_time`,  " +
				"`dev_from_time`, `dev_end_time`, `test_from_time`, `test_end_time`, `online_time`,  " +
				"`spread_from_time`, `spread_end_time` from `dotp_gh_project_extra1_change` " +
				"where project_id = " + aiId;
		//执行插入
		flag = this.dppmTemp.update(vsql);
		this.logger.info("----审批项目变更成功后：年度规划项目新增 --插入项目额外信息 - 研发型--是否成功：" + flag);
		//--------------项目额外信息 - 管理咨询型
		vsql = "INSERT INTO `dotp_gh_project_extra2`  " +
				"(`project_id`, `gh_context`, `gh_objective`)  " +
				"select " + keyId + ", `gh_context`, `gh_objective` " +
				"from `dotp_gh_project_extra2_change` where project_id = " + aiId;
		//执行插入
		flag = this.dppmTemp.update(vsql);
		this.logger.info("----审批项目变更成功后：年度规划项目新增 --插入项目额外信息 - 管理咨询型--是否成功：" + flag);
		//--------------项目额外信息 - 基础设施型
		vsql = "INSERT INTO `dotp_gh_project_extra3` " +
				"(`project_id`, `implentments`, `sysneed_from_time`, `sysneed_end_time`,  " +
				"`apply_from_time`, `apply_end_time`, `test_from_time`, `test_end_time`, `online_time`)  " +
				"select " + keyId + ", `implentments`, `sysneed_from_time`, `sysneed_end_time`,  " +
				"`apply_from_time`, `apply_end_time`, `test_from_time`, `test_end_time`, `online_time` " +
				"from `dotp_gh_project_extra3_change`  where project_id = " + aiId;
		//执行插入
		flag = this.dppmTemp.update(vsql);
		this.logger.info("----审批项目变更成功后：年度规划项目新增 --插入项目额外信息 - 基础设施型--是否成功：" + flag);
		vsql = "INSERT INTO `dotp_gh_project_res1`  " +
			"(`project_id`, `emp_role`, `emp_grade`, `gh_year`, `month_cnt`, `total_cnt`)  " +
			"select " + keyId + ", `emp_role`, `emp_grade`, `gh_year`, `month_cnt`, `total_cnt` " +
			"from `dotp_gh_project_res1_change` where project_id = " + aiId;
		//执行插入
		flag = this.dppmTemp.update(vsql);
		this.logger.info("----审批项目变更成功后：年度规划项目新增 --插入项目（资源信息 - 人员类）--是否成功：" + flag);
		vsql = "INSERT INTO `dotp_gh_project_res2` (`project_id`, `cost_for`, `cost_cnt`) " +
				"select " + keyId + ", `cost_for`, `cost_cnt`  " +
				"from `dotp_gh_project_res2_change` where project_id =" + aiId;
		//执行插入
		flag = this.dppmTemp.update(vsql);
		this.logger.info("----审批项目变更成功后：年度规划项目新增 --插入项目（资源信息 - 非人员类）--是否成功：" + flag);
		return keyId;
	}
	/**
	 * 修改年度规划项目表数据
	 * @param aiId
	 * @param oldAiId
	 * @param ghType
	 * @return
	 */
	public int updateTempYearPlan(int aiId,int oldAiId,int ghType) {
//		String sql = "select g.project_id, g.gh_name, gh_year, g.gh_type, g.gh_level, g.gh_status," 
//				+ " g.CREATE_TIME, g.FINISH_TIME, g.SUBSYS, " 
//				+ " FROM_UNIXTIME(g.commit_time, '%Y-%m-%d') AS commit_time," 
//				+ " g.gh_version, g.NEED_SPREAD, g.STRATEGIC,g.SPHERE_OF_BUSINESS, " 
//				+ " g.SPHERE_OF_SYS, g.ADD_TIME, g.DELETEDfrom dotp_gh_projects_change g where g.ai_id =" + aiId;
//		// 根据 sql 获得项目变更审核信息
//		List<AnnualPlanEntity> list = this.dppmTemp.query(sql,
//				new RowMapper<AnnualPlanEntity>(){
//			@Override
//			public AnnualPlanEntity mapRow(ResultSet rs, int rowNum)
//					throws SQLException {
//				AnnualPlanEntity info = new AnnualPlanEntity();
//				return info;
//			}
//		});
		String sql = "update dotp_gh_projects_change set project_id = " + oldAiId + " where ai_id =" + aiId;
		//执行插入
		int flag = this.dppmTemp.update(sql);
		//更新实体
		sql = "select * from dotp_gh_projects_change where ai_id=" + aiId;
//		final int newAiId= aiId;
		final int oldAiIdf = oldAiId;
		// 根据 sql 获得变更的项目信息 进行更新原项目信息
		this.dppmTemp.query(sql,
				new RowMapper<AnnualPlanEntity>(){
			@Override
			public AnnualPlanEntity mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				//修改时 只能修改时间
				String sql = "update dotp_gh_projects set project_id= " + oldAiIdf;
				if(rs.getString("create_time") != null && !rs.getString("create_time").equals("")){
					sql += ",create_time='" + rs.getString("create_time") + "'";
				}
				if(rs.getString("finish_time") != null && !rs.getString("finish_time").equals("")){
					sql += ",finish_time='" + rs.getString("finish_time") + "'";
				}
				sql += " WHERE `project_id`= " + oldAiIdf;
//				System.out.println(sql);
				dppmTemp.update(sql);
				return null;
			}
		});
		
		sql = "select AI_ID, project_id, func_cnt, platforms, technology, implentments, userneed_from_time, "
				+ " userneed_end_time, sysneed_from_time, sysneed_end_time, dev_from_time, dev_end_time, "
				+ " test_from_time, test_end_time, online_time, spread_from_time, spread_end_time " +
				" from dotp_gh_project_extra1_change g where g.project_id =" + aiId;
		
		if(ghType == 1) {
			// 根据 sql 获得项目信息 研发型实体
			this.dppmTemp.query(sql,
					new RowMapper<AnnualPlanExtra1>(){
				@Override
				public AnnualPlanExtra1 mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					String sql = "UPDATE `dotp_gh_project_extra1` set `project_id`= " + oldAiIdf;
					if(rs.getString("userneed_from_time") != null && !rs.getString("userneed_from_time").equals("")) {
						sql += ",`userneed_from_time`='" + rs.getString("userneed_from_time") + "'";
					}
					if(rs.getString("userneed_end_time") != null && !rs.getString("userneed_end_time").equals("")) {
						sql += ",`userneed_end_time`='" + rs.getString("userneed_end_time") + "'";
					}
					if(rs.getString("sysneed_from_time") != null && !rs.getString("sysneed_from_time").equals("")) {
						sql += ",`sysneed_from_time`='" + rs.getString("sysneed_from_time") + "'";
					}
					if(rs.getString("sysneed_end_time") != null && !rs.getString("sysneed_end_time").equals("")) {
						sql += ",`sysneed_end_time`='" + rs.getString("sysneed_end_time") + "'";
					}
					if(rs.getString("dev_from_time") != null && !rs.getString("dev_from_time").equals("")) {
						sql += ",`dev_from_time`='" + rs.getString("dev_from_time") + "'";
					}
					if(rs.getString("dev_end_time") != null && !rs.getString("dev_end_time").equals("")) {
						sql += ",`dev_end_time`='" + rs.getString("dev_end_time") + "'";
					}
					if(rs.getString("test_from_time") != null && !rs.getString("test_from_time").equals("")) {
						sql += ",`test_from_time`='" + rs.getString("test_from_time") + "'";
					}
					if(rs.getString("test_end_time") != null && !rs.getString("test_end_time").equals("")) {
						sql += ",`test_end_time`='" + rs.getString("test_end_time") + "'";
					}
					if(rs.getString("online_time") != null && !rs.getString("online_time").equals("")) {
						sql += ",`online_time`='" + rs.getString("online_time") + "'";
					}
					if(rs.getString("spread_from_time") != null && !rs.getString("spread_from_time").equals("")) {
						sql += ",`spread_from_time`='" + rs.getString("spread_from_time") + "'";
					}
					if(rs.getString("spread_end_time") != null && !rs.getString("spread_end_time").equals("")) {
						sql += ",`spread_end_time`='" + rs.getString("spread_end_time") + "'";
					}
					sql += " WHERE `project_id`= " + oldAiIdf;
					dppmTemp.update(sql);
					return null;
				}
			});
		} else if(ghType == 3) {
			//基础设施型
			sql = "select AI_ID, project_id, implentments, sysneed_from_time, sysneed_end_time," +
					"apply_from_time, apply_end_time, test_from_time, test_end_time, online_time " +
					"from dotp_gh_project_extra3_change where project_id =" + aiId;
			// 根据 sql 获得项目信息 基础设施型实体
			this.dppmTemp.query(sql,
					new RowMapper<AnnualPlanExtra1>(){
				@Override
				public AnnualPlanExtra1 mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					String sql = "UPDATE `dotp_gh_project_extra3` set `project_id`= " + oldAiIdf;
					if(rs.getString("sysneed_from_time") != null && !rs.getString("sysneed_from_time").equals("")) {
						sql += ",`sysneed_from_time`='" + rs.getString("sysneed_from_time") + "'";
					}
					if(rs.getString("sysneed_end_time") != null && !rs.getString("sysneed_end_time").equals("")) {
						sql += ",`sysneed_end_time`='" + rs.getString("sysneed_end_time") + "'";
					}
					if(rs.getString("apply_from_time") != null && !rs.getString("apply_from_time").equals("")) {
						sql += ",`apply_from_time`='" + rs.getString("apply_from_time") + "'";
					}
					if(rs.getString("apply_end_time") != null && !rs.getString("apply_end_time").equals("")) {
						sql += ",`apply_end_time`='" + rs.getString("apply_end_time") + "'";
					}
					if(rs.getString("test_from_time") != null && !rs.getString("test_from_time").equals("")) {
						sql += ",`test_from_time`='" + rs.getString("test_from_time") + "'";
					}
					if(rs.getString("test_end_time") != null && !rs.getString("test_end_time").equals("")) {
						sql += ",`test_end_time`='" + rs.getString("test_end_time") + "'";
					}
					if(rs.getString("test_end_time") != null && !rs.getString("test_end_time").equals("")) {
						sql += ",`test_end_time`='" + rs.getString("test_end_time") + "'";
					}
					if(rs.getString("online_time") != null && !rs.getString("online_time").equals("")) {
						sql += ",`online_time`='" + rs.getString("online_time") + "'";
					}
					sql += " WHERE `project_id`= " + oldAiIdf;
					dppmTemp.update(sql);
					return null;
				}
			});
		}
		return flag;
	}
	/**
	 * 删除年度规划项目信息
	 * @param aiId
	 * @return
	 */
	public int delYearPlan(int aiId) {
		//删除 sql
		String sql = "update dotp_gh_projects set deleted = 1 where project_id =" + aiId;
		//执行更新
		return this.dppmTemp.update(sql);
	}
	/**
	 * 根据版本号
	 * @param version
	 * @param newVersion
	 * @return
	 */
	public int updateProjVersion(String version,String newVersion) {
		//sql
		String sql = "update dotp_gh_projects set gh_version = '" + newVersion + "' where gh_version ='" + version + "'";
		//执行更新
		return this.dppmTemp.update(sql);
	}
	/**
	 * 删除临时表数据
	 * @param aiids
	 * @return
	 */
	public int delTempYearPlan(int[] aiids) {
		//sql
		String sql = "update dotp_gh_projects_change t set t.DELETED = 1 where t.ai_id in (";
		for(int i = 0 ; i < aiids.length ; i++) {
			sql += aiids[i];
			if(i < aiids.length-1) {
				sql += ",";
			}
		}
		sql += ")";
		//执行更新
		return this.dppmTemp.update(sql);
	}
	/**
	 * 项目状态变为已终止，对应的任务也要终止 终止任务
	 * @param projectCode
	 * @return
	 */
	public int terminateTask(int projectCode) {
		//sql
		String sql = "update dotp_tm_tasks set task_status = 5 where task_project = " + projectCode;
		//执行更新
		return this.dppmTemp.update(sql);
	}
	/**
	 * 更新项目信息
	 * @param entity
	 * @return
	 */
	public int updateProjInfo(int newAiId,int oldAiId) {
		//获得新项目信息
		String sql = "select * from dotp_pm_projects p where p.ai_id =" + newAiId;
		final int oldaiid = oldAiId;
		// 根据 sql 获得项目信息
		this.dppmTemp.query(sql,
				new RowMapper<ProjectEntity>(){
			@Override
			public ProjectEntity mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				ProjectEntity newProject = new ProjectEntity();
				//设置aiid 为oldaiid
				newProject.setAiId(oldaiid);
				newProject.setProjectCode(String.valueOf(oldaiid));
				newProject.setDeleted(0);
				//获得项目审批状态
				List<Integer> status = dppmTemp.queryForList(
						"select ea_status from dotp_pm_projects p where p.ai_id = " + oldaiid,
						Integer.class);
				//判断是否存在
				if(status != null && status.size() > 0) {
					//设置审批状态
					newProject.setEaStatus(status.get(0));
				}
				//更新原项目信息为新项目信息
				String vsql = "update dotp_pm_projects set ai_id =" + oldaiid;
				if(rs.getString("proj_name") != null && !rs.getString("proj_name").equals("")) {
					vsql += ",proj_name='" + rs.getString("proj_name") + "'";
				}
				if(rs.getString("short_name") != null && !rs.getString("short_name").equals("")) {
					vsql += ",short_name='" + rs.getString("short_name") + "'";
				}
				vsql += ",proj_status=" + rs.getInt("proj_status");
				vsql += ",ea_status=" + newProject.getEaStatus();
				vsql += ",proj_type=" + rs.getInt("proj_type");
				vsql += ",proj_level=" + rs.getInt("proj_level");
				vsql += ",subsys=" + rs.getInt("subsys");
				vsql += ",strategic=" + rs.getInt("strategic");
				vsql += ",func_cnt=" + rs.getInt("func_cnt");
				vsql += ",implentments=" + rs.getInt("implentments");
				vsql += ",dev_models=" + rs.getInt("dev_models");
				vsql += ",workload=" + rs.getInt("workload");
				vsql += ",total_costs=" + rs.getInt("total_costs");
				vsql += ",deleted=" + newProject.getDeleted();
				if(rs.getString("overtaken") != null && !rs.getString("overtaken").equals("")) {
					vsql += ",overtaken='" + rs.getString("overtaken") + "'";
				}
				if(rs.getString("create_time") != null && !rs.getString("create_time").equals("")) {
					vsql += ",create_time='" + rs.getString("create_time") + "'";
				}
				if(rs.getString("finish_time") != null && !rs.getString("finish_time").equals("")) {
					vsql += ",finish_time='" + rs.getString("finish_time") + "'";
				}
				if(rs.getString("initiator") != null && !rs.getString("initiator").equals("")) {
					vsql += ",initiator='" + rs.getString("initiator") + "'";
				}
				if(rs.getString("consultancy") != null && !rs.getString("consultancy").equals("")) {
					vsql += ",consultancy='" + rs.getString("consultancy") + "'";
				}
				if(rs.getString("code") != null && !rs.getString("code").equals("")) {
					vsql += ",code='" + rs.getString("code") + "'";
				}
				if(rs.getString("sub_pm_id") != null && !rs.getString("sub_pm_id").equals("")) {
					vsql += ",sub_pm_id='" + rs.getString("sub_pm_id") + "'";
				}
				if(rs.getString("sub_launchtime") != null && !rs.getString("sub_launchtime").equals("")) {
					vsql += ",sub_launchtime='" + rs.getString("sub_launchtime") + "'";
				}
				if(rs.getString("pm_id1") != null && !rs.getString("pm_id1").equals("")) {
					vsql += ",pm_id1='" + rs.getString("pm_id1") + "'";
				}
				if(rs.getString("pm_id2") != null && !rs.getString("pm_id2").equals("")) {
					vsql += ",pm_id2='" + rs.getString("pm_id2") + "'";
				}
				if(rs.getString("proj_profile") != null && !rs.getString("proj_profile").equals("")) {
					vsql += ",proj_profile='" + rs.getString("proj_profile") + "'";
				}
				if(rs.getString("curren_ea") != null && !rs.getString("curren_ea").equals("")) {
					vsql += ",curren_ea='" + rs.getString("curren_ea") + "'";
				}
				if(rs.getString("currentstatus") != null && !rs.getString("currentstatus").equals("")) {
					vsql += ",currentstatus='" + rs.getString("currentstatus") + "'";
				}
				vsql += " where ai_id =" + oldaiid;
				//执行更新
				dppmTemp.update(vsql);
				return null;
			}
		});
		return 0;
	}
	/**
	 * 调用存储过程来更新项目的其他信息
	 * @param oldAiId
	 * @param newAiId
	 */
	public void updateProjOtherInfo(int oldAiId,int newAiId) {
		String sql = "{call pro_change_pm_success(" + oldAiId + "," + newAiId + ")}";
		//执行更新
		this.dppmTemp.update(sql);
	}
	/**
	 * 查询是否需要发邮件(是否涉及里程碑、关键节点或结项时间的变更)
	 * @param changeId
	 * @return
	 */
	public int checkIsSendMail(int changeId) {
		 String sql = "select count(1) from dotp_change_log o where o.field_name in " +
		 		"('finish_time', 'milestone0', 'milestone1') and o.change_id = " + changeId;
		//获得
		return this.dppmTemp.queryForInt(sql);
	}
	/**
	 * 获取项目组织中所有的执行个人的邮箱地址
	 * @param aiId
	 * @return
	 */
	public List<String> getOrgsPersonEmails(int aiId) {
		String sql ="select d.contact_email from dotp_contacts d right join	" +
				"(select user_code from dotp_pm_project_org_all where project_code = " + aiId + ") t " +
				"on d.contact_employee_code = t.user_code ";
		//获得邮箱地址
		return this.dppmTemp.queryForList(sql,String.class);
	}
	/**
	 * 修改变更信息
	 * @param entity
	 * @return
	 */
	public int updateChange(ChangeEntity entity) {
		String sql = "update dotp_change_list c set c.id = c.id ";
		//修改原因
		if(entity.getChangeReason() != null && !entity.getChangeReason().equals("")) {
			sql += ",c.CHANGE_REASON ='" + entity.getChangeReason() + "'";
		}
		sql += ",c.change_state =" + entity.getChangeState();
		sql += ",c.audit_state=" + entity.getAuditState();
		sql += ",c.PROCESS_ID =" + entity.getProcessId();
		if(entity.getChangeReviewer() != null && !entity.getChangeReviewer().equals("")) {
			sql += ",c.change_reviewer ='" + entity.getChangeReviewer() + "'";
		}
		sql += " where c.ID = " + entity.getChangeId();
		return this.dppmTemp.update(sql);
	}
	/**
	 * 获取年度规划项目级别 
	 * @param processid
	 * @return
	 */
	public int queryGhLevel(long processid) {
		String sql = "SELECT CASE t.change_type " +
			"WHEN 1 AND t.project_id IS NULL THEN t.gh_level_change " +
			"WHEN 1 AND t.project_id IS NOT NULL THEN t.gh_level " +
			"WHEN 2 THEN t.proj_level END ghLevel FROM ( " +
			"SELECT c.project_id, g.gh_level AS gh_level_change, p.gh_level, m.proj_level, c.change_type " +
			"FROM dotp_change_list c " +
			"LEFT JOIN dotp_gh_projects_change g ON g.project_id = c.ai_id AND c.change_state = 1 and c.change_type = 1 " +
			"LEFT JOIN dotp_gh_projects p ON p.project_id = c.project_id AND (c.change_state = 2 OR change_state = 3)  and c.change_type = 1  " +
			"LEFT JOIN dotp_pm_projects m ON m.AI_ID = c.ai_id AND c.change_type = 2 " +
			"WHERE c.process_id = " + processid + " ) t";
		//获得项目级别
		List<Integer> list = this.dppmTemp.queryForList(sql,Integer.class);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return 0;
	}
	/**
	 * 判断项目是否管理咨询 
	 * @param processid
	 * @return
	 */
	public int queryGhType(long processid) {
		String sql = "SELECT CASE t.change_type " +
				"WHEN 1 AND t.project_id IS NULL THEN t.gh_type_change " +
				"WHEN 1 AND t.project_id IS NOT NULL THEN t.gh_type " +
				"WHEN 2 THEN t.proj_type END ghType FROM ( " +
				"SELECT c.project_id, g.gh_type AS gh_type_change, p.gh_type, m.proj_type, c.change_type " +
				"FROM dotp_change_list c " +
				"LEFT JOIN dotp_gh_projects_change g ON g.project_id = c.ai_id AND c.change_state = 1 and c.change_type = 1 " +
				"LEFT JOIN dotp_gh_projects p ON p.project_id = c.project_id AND (c.change_state = 2 OR change_state = 3)  and c.change_type = 1 " +
				"LEFT JOIN dotp_pm_projects m ON m.AI_ID = c.ai_id AND c.change_type = 2 " +
				"WHERE c.process_id = " + processid + " ) t";
		//获得项目类型
		List<Integer> list = this.dppmTemp.queryForList(sql,Integer.class);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return 0;
	}
	/**
	 * 判断项目是否重大变更
	 * @param processid
	 * @return
	 */
	public int queryChangeState(long processid) {
		String sql = "SELECT c.change_state FROM dotp_change_list c " +
		" WHERE c.change_type = 2 AND c.is_delete = 0 AND c.process_id = " + processid;
		//获得项目类型
		List<Integer> list = this.dppmTemp.queryForList(sql,Integer.class);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return 0;
	}
	/**
	 * 获取项目发起人
	 * @param processid
	 * @return
	 */
	public EmployeeEntity queryProjectSponsor(long processid) {
		String sql = "SELECT t.CONTACT_ORDER_BY AS contactOrderBy, " +
			"t.CONTACT_EMPLOYEE_CODE AS contactEmployeeCode FROM dotp_change_list c, " +
			"dotp_pm_projects p, dotp_contacts t WHERE c.ai_id = p.ai_id " +
		    "AND p.initiator = t.contact_employee_code " +
		    "AND c.process_id = " + processid;
		//获得项目发起人
		List<EmployeeEntity> list = this.dppmTemp.query(sql,
				new RowMapper<EmployeeEntity>(){
			@Override
			public EmployeeEntity mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				EmployeeEntity info = new EmployeeEntity();
				// 工号
				info.setContactEmployeeCode(rs.getString("contactEmployeeCode"));
				// 姓名
				info.setContactOrderBy(rs.getString("contactOrderBy"));
				return info;
			}
		});
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	 
}

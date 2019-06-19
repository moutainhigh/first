package com.deppon.dpm.module.wfs.server.dao.impl;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.deppon.dpm.module.projecttools.shared.domain.FileEntity;
import com.deppon.dpm.module.projecttools.shared.domain.ProjectMilestoneInfo;
import com.deppon.dpm.module.projecttools.shared.domain.ProjectObjectiveEntity;
import com.deppon.dpm.module.projecttools.shared.domain.ProjectOrgEntity;
import com.deppon.dpm.module.projecttools.shared.domain.ProjectResources;
import com.deppon.dpm.module.projecttools.shared.domain.ProjectRiskEntity;
import com.deppon.dpm.module.projecttools.shared.domain.ProjectScopeBusinessEntity;
import com.deppon.dpm.module.projecttools.shared.domain.ProjectScopeDeptEntity;
import com.deppon.dpm.module.projecttools.shared.domain.ProjectScopeSysEntity;
import com.deppon.dpm.module.wfs.server.dao.IDppmWorkInfoDao;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ApprovelEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ClosingCheckTypeEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ClosingIndexEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ClosingIsPassEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ClosingOrgInfoEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.FileUploadEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ProjectClosingEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ProjectEntity;
import com.deppon.dpm.module.wfs.shared.domain.dppm.ProjectFallGroundEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * 
 * dppm 项目管理dao
 * 
 * @author 195406 高春玲
 * @date 2015-9-28 下午1:45:08
 * @since
 **/
public class DppmWorkInfoDao extends iBatis3DaoImpl implements IDppmWorkInfoDao {
    // 
	private JdbcTemplate dppmTemp;
	/**
	 * @param dppmTemp
	 */
	public void setDppmTemp(JdbcTemplate dppmTemp) {
		this.dppmTemp = dppmTemp;
	}
    /**
     * 获得项目结项工作流详情
     * 根据工作流号获得工作流详情
     * @param entity
     * @return
     */
	@Override
	public ProjectClosingEntity projClosingDetail(String busino) {
		// 根据业务单号获得详情 sql
		String sql = "select * from dotp_pm_projectClosing PRO where pro.busino ='" + busino + "'";
		// 执行查询
		List<ProjectClosingEntity> list = this.dppmTemp.query(sql,
				new RowMapper<ProjectClosingEntity>() {
				@Override
				public ProjectClosingEntity mapRow(ResultSet rs, int arg1)
						throws SQLException {
					ProjectClosingEntity info = new ProjectClosingEntity();
					// 业务编号
					info.setBusino(rs.getString("busino"));
					// 工作流号
					info.setProcessintId(rs.getLong("processintid"));
					// 申请工号
					info.setApplyCode(rs.getString("applycode"));
					// 申请姓名
					info.setApplyName(rs.getString("applyname"));
					//项目编码
					info.setProjectCode(rs.getString("PROJECTCODE"));
					//项目名称
					info.setProjectName(rs.getString("PROJECTNAME"));
					//项目类型
					info.setProjectType(rs.getString("PROJECTTYPE"));
					//项目级别
					info.setProjectLevel(rs.getString("PROJECTLEVEL"));
					//项目管理
					info.setProjectManager(rs.getString("PROJECTMANAGER"));
					//申请日期
					info.setApplyDate(rs.getDate("APPLYDATE"));
					// 审批状态
					info.setAppcondition(rs.getString("APPCONDITION"));
					//验收状态
					info.setCheckCondition(rs.getString("CHECKCONDITION"));
					//承接部门
					info.setUndertakeDept(rs.getString("UNDERTAKEDEPT"));
					//是否系统验收
					info.setIsSysCheck(rs.getString("ISSYSCHECK"));
					// 申请原因
					info.setApplyReason(rs.getString("APPLYREASON"));
					//项目经理工号
					info.setManagerCode(rs.getString("MANAGERCODE"));
					//承接部门编码
					info.setUndertakeDeptCode(rs.getString("UNDERTAKEDEPTCODE"));
					//项目编号
					info.setProCode(rs.getString("PROCODE"));
					//
					info.setSpareOne(rs.getString("SPAREONE"));
					info.setSpareTwo(rs.getInt("SPARETWO"));
					info.setSpareThree(rs.getString("SPARETHREE"));
					return info;
				}
		});
		//判断 list是否大于0 获得详情
		if(list != null && list.size() > 0 ) {
			//设置详情
			return list.get(0);
		}
		// 返回
		return null;
	}
	/**
	 * 附件列表
	 * @param busino
	 * @return
	 */
	public List<FileUploadEntity> fileList(String busino) {
		// 定义sql
		String sql = "SELECT U.ID,U.FILE_NAME, U.SAVE_NAME, U.SAVE_PATH, U.FILE_SIZE, " +
				"U.UPLOAD_TIME,U.UPLOAD_EMP, U.FILE_TYPE,U.FILE_ID " +
				"FROM dotp_attachment U WHERE U.MODULE_CODE='" + busino + "'";
		// 执行查询
		List<FileUploadEntity> list = this.dppmTemp.query(sql,
				new RowMapper<FileUploadEntity>() {
			@Override
			public FileUploadEntity mapRow(ResultSet rs, int arg1)
					throws SQLException {
				FileUploadEntity info = new FileUploadEntity();
				// 业务编号
				info.setId(rs.getString("ID"));
				info.setFileName(rs.getString("FILE_NAME"));
				info.setSaveName(rs.getString("SAVE_NAME"));
				info.setSavePath(rs.getString("SAVE_PATH"));
				info.setFileSize(rs.getLong("FILE_SIZE"));
				info.setUploadTime(rs.getDate("UPLOAD_TIME"));
				info.setUploadEmp(rs.getString("UPLOAD_EMP"));
				info.setFileType(rs.getString("FILE_TYPE"));
				info.setFileId(rs.getInt("FILE_ID"));
				return info;
			}
		});
		return list;
	}
	/**
	 * 通过业务编号获取指标相关信息
	 * @param busino 
	 * @return
	 */
	public List<ClosingIndexEntity> closingIndexList(String busino) {
		// 定义sql
		String sql = "select BUSINO,OBJECTIVE,INDICATOR,FORMULA,DEPT_PROVIDER,DEPT_AUDIT, " +
		  "OBJ_STATE,ISSHORTTARGET,QUANTITATIVE,COMPLETEVALUE,COMPLETECONDITION" +
  		" FROM dotp_pm_ClosingIndex where busino = '" + busino + "'";
		// 执行查询
		List<ClosingIndexEntity> list = this.dppmTemp.query(sql,
				new RowMapper<ClosingIndexEntity>() {
			@Override
			public ClosingIndexEntity mapRow(ResultSet rs, int arg1)
					throws SQLException {
				ClosingIndexEntity info = new ClosingIndexEntity();
				// 业务编号
				info.setBusino(rs.getString("BUSINO"));
				//目标指标
				info.setObjective(rs.getString("objective"));
				//指标值
				info.setIndicator(rs.getString("indicator"));
				//量化指标公式
				info.setFormula(rs.getString("formula"));
				//数据提供部门
				info.setDeptProvider(rs.getString("dept_Provider"));
				//数据审核部门
				info.setDeptAudit(rs.getString("dept_Audit"));
				//数据审核阶段
				info.setObjState(rs.getString("obj_State"));
				info.setIsShortTarget(rs.getString("ISSHORTTARGET"));
				info.setQuantitative(rs.getString("QUANTITATIVE"));
				info.setCompleteCondition(rs.getString("COMPLETECONDITION"));
				info.setCompleteValue(rs.getString("COMPLETEVALUE"));
				return info;
			}
		});
		return list;
	}
	/**
	 * 获取验收类型
	 * @param busino 业务单号
	 * @return
	 */
	public List<ClosingCheckTypeEntity> closingCheckTypeList(String busino) {
		// 定义sql
		String sql = "SELECT BUSINO,CHECKMODULE,CHECKTYPE,MANAGERNAME, MANAGERCODE " +
				" FROM dotp_pm_Closingchecktype  where busino = '" + busino + "'";
		// 执行查询
		List<ClosingCheckTypeEntity> list = this.dppmTemp.query(sql,
				new RowMapper<ClosingCheckTypeEntity>() {
			@Override
			public ClosingCheckTypeEntity mapRow(ResultSet rs, int arg1)
					throws SQLException {
				ClosingCheckTypeEntity info = new ClosingCheckTypeEntity();
				//
				info.setBusino(rs.getString("BUSINO"));
				//验收模块
				info.setCheckModule(rs.getString("CHECKMODULE"));
				//验收类型
				info.setCheckType(rs.getString("CHECKTYPE"));
				//负责人
				info.setManagerName(rs.getString("MANAGERNAME"));
				info.setManagerCode(rs.getString("MANAGERCODE"));
				return info;
			}
		});
		return list;
	}
	/**
	 * 结项是否通过
	 * @param busino 业务单号
	 * @return
	 */
    public ClosingIsPassEntity closingIsPassInfo(String busino) {
    	// 定义sql
    	String sql = "select BUSINO,ISPASS,date_format(CLOSINGDATE,'%Y-%m-%d') AS CLOSINGDATE, " +
		  "NOTPASSREASON from dotp_pm_Closingispass where BUSINO='" + busino + "'";
    	// 执行查询
    	List<ClosingIsPassEntity> list = this.dppmTemp.query(sql,
    			new RowMapper<ClosingIsPassEntity>() {
    		@Override
    		public ClosingIsPassEntity mapRow(ResultSet rs, int arg1)
    				throws SQLException {
    			ClosingIsPassEntity info = new ClosingIsPassEntity();
    			//
    			info.setBusino(rs.getString("BUSINO"));
    			info.setIspass(rs.getString("ISPASS"));
    			info.setClosingdate(rs.getDate("CLOSINGDATE"));
    			info.setNotpassreason(rs.getString("NOTPASSREASON"));
    			return info;
    		}
    	});
    	if(list != null && list.size() > 0 ){
    		return list.get(0);
    	}
    	return null;
    }
    /**
     * 验收组织信息
     * @param busino
     * @return
     */
    public ClosingOrgInfoEntity closingOrgInfoEntity(String busino) {
    	//定义sql 
    	String sql = "SELECT BUSINO,CHECKMODULE,CHECKTYPE,MANAGERNAME,MANAGERCODE " +
    			" FROM dotp_pm_ClosingOrgInfo where busino ='" + busino + "'";
    	// 执行查询
    	List<ClosingOrgInfoEntity> list = this.dppmTemp.query(sql,
    			new RowMapper<ClosingOrgInfoEntity>() {
    		@Override
    		public ClosingOrgInfoEntity mapRow(ResultSet rs, int arg1)
    				throws SQLException {
    			ClosingOrgInfoEntity info = new ClosingOrgInfoEntity();
    			//
    			info.setBusino(rs.getString("BUSINO"));
    			info.setCheckModule(rs.getString("CHECKMODULE"));
    			info.setCheckType(rs.getString("CHECKTYPE"));
    			info.setManagerName(rs.getString("MANAGERNAME"));
    			info.setManagerCode(rs.getString("MANAGERCODE"));
    			return info;
    		}
    	});
    	if(list != null && list.size() > 0 ){
    		return list.get(0);
    	}
    	return null;
    }
    /**
     * 审批通过时 保存页面填写的组织信息
     * @param closingOrgInfoEntity
     */
    public void insertClosingOrgInfo(ClosingOrgInfoEntity entity) throws Exception {
    	//定义sql
    	String sql = "INSERT INTO dotp_pm_ClosingOrgInfo (BUSINO,CHECKMODULE,CHECKTYPE," +
				  "MANAGERNAME,MANAGERCODE) values ('" + entity.getBusino() + "','" + entity.getCheckModule() + "'," +
				  "'" + entity.getCheckType() + "','" + entity.getManagerName() + "','" + entity.getManagerCode() + "')";
    	//执行更新
    	this.dppmTemp.update(sql);
    }
    /**
     * 审批通过时 保存页面填写的指标信息
     * @param list
     */
    public void insertClosingIndex(List<ClosingIndexEntity> list) throws Exception {
    	//定义sql
    	String sql = "INSERT INTO dotp_pm_ClosingIndex  (BUSINO, OBJECTIVE,INDICATOR," +
				 " FORMULA,DEPT_PROVIDER,DEPT_AUDIT,OBJ_STATE,ISSHORTTARGET, " +
				 " QUANTITATIVE,COMPLETEVALUE,COMPLETECONDITION,OBJ_ID) values " ;
    	//循环遍历指标信息
    	int i = 0;
		for(ClosingIndexEntity e : list) {
    		sql += "('" + e.getBusino() + "','" + e.getObjective() + "',";
    		sql += "'" + e.getIndicator() + "','" + e.getFormula() + "',";
    		sql += "'" + e.getDeptProvider() + "','" + e.getDeptAudit() + "',";
    		sql += "'" + e.getObjState() + "','" + e.getIsShortTarget() + "',";
    		sql += "'" + e.getQuantitative() + "','" + e.getCompleteValue() + "',";
    		sql += "'" + e.getCompleteCondition() + "'," + e.getObjId() + ")";
    		if(i < list.size()-1){
    			sql +=  ",";
    		} else {
    			sql +=  ";";
    		}
    		i = i + 1;
    	}
		//执行更新
        this.dppmTemp.update(sql);
    }
    /**
     * 审批通过时，插入是否结项通过
     * @param e
     */
    public void insertChosingIsPass(ClosingIsPassEntity e) throws Exception {
    	// 定义sql
    	String sql = "INSERT INTO dotp_pm_Closingispass (BUSINO,ISPASS,CLOSINGDATE," +
    			"NOTPASSREASON) values ('" + e.getBusino() + "','" + e.getIspass() + "'," +
    			"'" + e.getClosingDate() + "','" + e.getNotpassreason() + "')";
    	//执行更新
    	this.dppmTemp.update(sql);
    }
    /**
     * 将结项验收类型插入数据库
     * @param list
     */
    public void insertClosingCheckType(List<ClosingCheckTypeEntity> list) throws Exception {
    	// 定义sql
    	String sql = "INSERT INTO dotp_pm_Closingchecktype ( BUSINO,CHECKMODULE, CHECKTYPE," +
				  "MANAGERNAME, MANAGERCODE) values ";
    	for(ClosingCheckTypeEntity e : list) {
    		sql += "('" + e.getBusino() + "','" + e.getCheckModule() + "',";
    		sql += "'" + e.getCheckType() + "','" + e.getManagerName() + "',";
    		sql += "'" + e.getManagerCode() + "')";
    	}
    	//执行更新
    	this.dppmTemp.update(sql);
    }
    /**
     * 更新状态
     * @param projectClosingEntity
     */
    public void updateProjectClosing(ProjectClosingEntity entity) throws Exception {
    	// 定义sql
    	String sql = "UPDATE dotp_pm_projectClosing set busino=busino ";
    	if(entity.getAppcondition() != null && !entity.getAppcondition().equals("")) {
    		sql += ",appcondition='" + entity.getAppcondition() + "'";
    	}
    	if(entity.getCheckCondition() != null && !entity.getCheckCondition().equals("")) {
    		sql += ",checkCondition='" + entity.getCheckCondition() + "'";
    	}
 		sql += " where processintId = '" + entity.getProcessintId() + "' ";
 		//执行更新
    	this.dppmTemp.update(sql);
    }
    /**
     * 通过projectCode修改项目状态
     * @param proCode
     */
    public void updateProStatusByProCode(String proCode) throws Exception {
    	//定义sql 
    	String sql = " UPDATE DOTP_PM_PROJECTS set PROJ_STATUS = '5' WHERE PROJECT_CODE = '" + proCode + "'";
    	//执行更新
    	this.dppmTemp.update(sql);
    }
    
    
    //////////////////////////////////////////////////////
    //项目落地
    /**
     * 根据业务编号获得项目落地详情
     * @param busino
     * @return
     */
    public ProjectFallGroundEntity projFallGroundDetail(String busino) {
    	//定义 sql
    	String sql = "select * from dotp_pm_projectFallGround where busino='" + busino + "'";
    	// 执行查询
    	List<ProjectFallGroundEntity> list = this.dppmTemp.query(sql,
    			new RowMapper<ProjectFallGroundEntity>() {
    		@Override
    		public ProjectFallGroundEntity mapRow(ResultSet rs, int arg1)
    				throws SQLException {
    			ProjectFallGroundEntity info = new ProjectFallGroundEntity();
    			//业务单号
    			info.setBusino(rs.getString("BUSINO"));
    			//工作流号
    			info.setProcessintId(rs.getLong("PROCESSINTID"));
    			//申请工号
    			info.setApplyCode(rs.getString("APPLYCODE"));
    			//申请姓名
    			info.setApplyName(rs.getString("APPLYNAME"));
    			//项目编码
    			info.setProjectCode(rs.getString("PROJECTCODE"));
    			//项目名称
    			info.setProjectName(rs.getString("PROJECTNAME"));
    			// 项目类型
    			info.setProjectType(rs.getString("PROJECTTYPE"));
    			//项目级别
    			info.setProjectLevel(rs.getString("PROJECTLEVEL"));
    			//项目经理
    			info.setProjectManager(rs.getString("PROJECTMANAGER"));
    			//申请日期
    			info.setApplyDate(rs.getDate("APPLYDATE"));
    			//审批状态
    			info.setAppcondition(rs.getString("APPCONDITION"));
    			//验收状态
    			info.setCheckCondition(rs.getString("CHECKCONDITION"));
    			//承接部门
    			info.setUndertakeDept(rs.getString("UNDERTAKEDEPT"));
    			//结项时间
    			info.setClosingDate(rs.getDate("CLOSINGDATE"));
    			// 结项状态
    			info.setClosingStatus(rs.getString("CLOSINGSTATUS"));
    			// 结项是否通过
    			info.setClosingIsPass(rs.getString("CLOSINGISPASS"));
    			//申请原因
    			info.setApplyReason(rs.getString("APPLYREASON"));
    			//项目经理工号
    			info.setManagerCode(rs.getString("MANAGERCODE"));
    			//承接部门编码
    			info.setUndertakeDeptCode(rs.getString("UNDERTAKEDEPTCODE"));
    			//项目编号
    			info.setProCode(rs.getString("PROCODE"));
    			info.setSpareOne(rs.getString("SPAREONE"));
    			info.setSpareTwo(rs.getInt("SPARETWO"));
    			info.setSpareThree(rs.getString("SPARETHREE"));
    			return info;
    		}
    	});
    	if(list != null && list.size() > 0 ){
    		return list.get(0);
    	}
    	return null;
    }
    /**
     * 更新项目落地状态
     * @param projectClosingEntity
     */
    public void updateProjFallGround(ProjectFallGroundEntity entity) throws Exception {
    	// 定义sql
    	String sql = "UPDATE dotp_pm_projectFallGround set busino=busino ";
    	if(entity.getAppcondition() != null && !entity.getAppcondition().equals("")) {
    		sql += ",appcondition='" + entity.getAppcondition() + "'";
    	}
 		sql += " where processintId = '" + entity.getProcessintId() + "' ";
 		//执行更新
    	this.dppmTemp.update(sql);
    }
    
    ////////////项目新建查询工作流
    /**
  	 * 项目新建查询
  	 * @param workitemid 工作流号
  	 */
    public Map<String, Object> queryProjectInfo(String workitemid) {
    	// 定义map 变量
    	Map<String, Object> map = new HashMap<String, Object>();
    	//定义 项目编号
    	String pcode = "";
    	// 在dppm 中审批记录中根据工作流号 获得项目编号
    	String sql = "select r.project_code from dotp_pm_project_check_records r where r.wfs_id='" + workitemid + "' ";    	
    	List<String> plist = this.dppmTemp.queryForList(sql,String.class);
    	
    	if(plist != null && plist.size() > 0){
    		pcode = plist.get(0);
    	}
    	
    	//项目基本信息   根据项目编号获得项目基本信息 sql
    	sql = "select *,(select label from dotp_names where name=" +
				"'gh_status' and value=p.proj_status) AS projectstatue," + //项目状态
    			//项目类型
				" (select label from dotp_names s where name='gh_type' and s.value=p.proj_type ) projtype," +
    			//项目级别
				"(select label from dotp_names s where name='projectlevel' and s.value=p.proj_level ) projlevel," +
				"(select label from dotp_names s where name='implentments' and s.value=p.implentments ) implentmentsname," +
				"(select label from dotp_names s where name='dev_models' and s.value=p.dev_models ) devmodels," +
				"(select label from dotp_names s where name='subsys' and s.value=p.subsys ) subsysname," +
				"(select contact_order_by from dotp_contacts where contact_employee_code=p.sub_pm_id ) xmjl," +
				"(select contact_order_by from dotp_contacts where contact_employee_code=p.initiator ) initiatorname," +
				"(select contact_order_by from dotp_contacts where contact_employee_code=p.pm_id1 ) pmid1," +
                "(select dept_name from dotp_contacts s,dotp_departments d where " +
                "s.dept_benchmark_code=d.dept_benchmark_code and contact_employee_code=p.initiator ) fqrdept" +
				" from dotp_pm_projects p where project_code='" + pcode + "'";
    	// 执行查询
    	List<ProjectEntity> projlist = this.projinfo(sql);
    	if(projlist != null && projlist.size() > 0) {
    		// 设置 项目信息
    		map.put("projinfo", projlist.get(0));
    	}
    	// 项目目标
    	sql = "select *,(select label from dotp_names s where name='obj_type' and s.value=p.obj_type ) objtype," +
    	      "(select dept_name from dotp_departments where dept_benchmark_code=p.dept_provider) deptprovidername," +
    	      "(select dept_name from dotp_departments where dept_benchmark_code=p.dept_audit) deptauditname," +
    	      "(select dept_name from dotp_departments where dept_benchmark_code=p.overtaken) deptovertakenname" +
    	      " from dotp_pm_project_objective p where project_code='" + pcode + "'";
    	map.put("objective", this.objectiveinfo(sql));
    	// 里程碑
    	sql = "select * from dotp_pm_project_milestone where project_code='" + pcode + "'";
    	map.put("milestone", this.milestoneinfo(sql));
    	//项目组织
    	sql = "select o.*,Case when o.internal='100' THEN (select pm_id2 from dotp_pm_projects where project_code = o.project_code and deleted=0)"+
               " else s.contact_order_by end AS contact_order_by,s.contact_job,s.contact_department,s.contact_employee_level," +
    			"(select leval1_department from dotp_contacts s,dotp_departments d " +
    			"where s.dept_benchmark_code=d.dept_benchmark_code " +
    			"and contact_employee_code=o.user_code) xitong " +
    			"from dotp_pm_project_org_all o left join dotp_contacts s " +
    			" on o.user_code=s.contact_employee_code and s.active=0 " +
    			" where  o.project_code='" + pcode + "'";
    	map.put("orgall", this.orgallinfo(sql));
    	//项目范围 业务范围
    	sql = "select * from dotp_pm_project_scope_business where project_code='" + pcode + "'";
    	map.put("projscopebus", this.scopeBussinessinfo(sql));
    	//项目范围 系统范围
    	sql = "select s.*,(select label from dotp_names where name='SYSTEM_NAME' and value=s.sys_code) sysname from dotp_pm_project_scope_sys s where project_code='" + pcode + "'";
    	map.put("projscopesys", this.scopeSysinfo(sql));
    	//项目范围 涉及部门
    	sql = "select s.dept_bcode,d.dept_name from dotp_pm_project_scope_dept s," +
    			"dotp_departments d where s.dept_bcode=d.dept_benchmark_code " +
    			"and d.dept_state=0 and s.project_code='" + pcode + "'";
    	map.put("projscopedept", this.scopeDeptinfo(sql));
    	//项目资源
		sql="select  d.band_cnt AS bandCnt,m.label AS empRoleName, d.man_day AS manDay,0 As unitProce,"+
			" null AS costSummary,d.role_price AS roleProce,(d.role_price * d.man_day)/10 as allProce, "+
			"0 As packPrice,0 cflag  FROM  dotp_pm_project_res1 d LEFT JOIN dotp_names m  "+
			" ON  m.name = 'gh_role' AND m.`value` = d.emp_role   where "+
			" d.project_code ='" + pcode + "' " +
			" union all SELECT  '' AS bandCnt, d1.man_role AS empRoleName, d1.man_day AS manDay,"+
			" d1.unit_price As unitProce,   null AS costSummary, 0 AS roleProce,"+
			" (d1.man_day * d1.unit_price)/10 AS allProce,  d1.pack_price As packPrice, 1 cflag"+
			" FROM  dotp_pm_project_res2 d1  where d1.project_code  = '" + pcode + "'"+
			" UNION ALL  SELECT   '' AS bandCnt,d2.cost_name AS empRoleName,  0 As manDay, 0 AS unitProce, "+
			" d2.cost_summary AS costSummary, d2.cost_cnt As roleProce, 0 AS allProce,  0 AS packPrice,"+
			" 2  cflag  FROM   dotp_pm_project_res3 d2  where d2.project_code ='" + pcode + "'";
		map.put("ProjectResources",this.queryProjectResources(sql));
		
		//项目风险
    	sql = "select r.project_code,(select s.ms_name from dotp_pm_project_milestone s " +
    			"where s.project_code=r.project_code and s.ms_id=r.milestone) milestonename," +
    			"(select label from dotp_names where name='risk_type' and value=r.risk_type) risktype," +
    			"(select label from dotp_names where name='risk_level' and value=r.risk_level) risklevel," +
    			"r.risk_summary,r.milestone from dotp_pm_project_risk r where r.project_code='" + pcode + "'";
    	map.put("projRiskinfo",this.projRiskinfo(sql));
		return map;
    }
    
    /**
    * 项目新建工作流审批
    * @param entity
    * @param empCode
    */
	public void approveProjInfo(ProjectEntity entity,String empCode) {
		ApprovelEntity ap = entity.getApprovelEntity();
		//是否需要继续审批 0 否 1 是
		int check_status = 0;
		if(entity.getWfsIsOver() == 0 ) {
			//审批未结束 
			check_status = 1;
		}
		//获得上一个审批人
		String sql = "select check_handler from dotp_pm_project_check_records order by check_time desc limit 1";
		//执行查询
		List<String> plist = this.dppmTemp.queryForList(sql,String.class);
    	//初始化上一个审批人
		String checkhandler = "";
    	if(plist != null && plist.size() > 0){
    		checkhandler = plist.get(0);
    	}
		//更新之前的dotp_pm_project_check_records 里面上一个审批人的审批状态为0   此人不继续审批
		sql = "update dotp_pm_project_check_records set check_status=0 where project_code=" + entity.getProjectCode() 
				+ " and check_handler='" + checkhandler + "'";
		// 添加 审批记录 日志 sql
		sql = "INSERT INTO dotp_pm_project_check_records(project_code,check_handler,check_suggestion,check_result,wfs_id," +
				"wfs_activityDefid,wfs_activityInstID,wfs_workItemID,wfs_isOver,check_status) " +
				"values (" + entity.getProjectCode() + ",'" + empCode +  "','"  + ap.getApproveOpinion() + "'," 
				+ ap.getIsAgree() + ",'" + ap.getProcessinstid() + "','" + ap.getActivityDefId() + "','" + ap.getActivityinstid()
				+ "','"+ap.getWorkItemId()+"'," + entity.getWfsIsOver() +"," + check_status + ")";
		//执行sql
		this.dppmTemp.update(sql);
		//存在下一个审批人
		String nextEmpCode = entity.getNextEmpCode();
		if(nextEmpCode != null && !nextEmpCode.equals("")) {
			// 添加下一个审批人 信息 sql
	        sql = "INSERT into dotp_pm_projects_approve_list(wfs_id,wfs_activityDefid,approve_emp) " +
	    			"VALUES" ;
	        //多个审批人
			if(nextEmpCode.indexOf("|") > 0) {
				String[] nes = nextEmpCode.split("\\|");
				for (int i = 0 ; i < nes.length ; i++ ) {
					sql += "('" + ap.getProcessinstid() + "','" + ap.getActivityDefId()+"','" + nes[i] + "')";
					if(i < nes.length - 1) {
						sql += ",";
					}
				}
			} else {
				sql += "('" + ap.getProcessinstid() + "','" + ap.getActivityDefId()+"','" + nextEmpCode + "')";
			}		
	    	//执行sql
	    	this.dppmTemp.update(sql);
		}
		//更新项目审批状态  如果审批结束 更新为结束 0:未结束   1:结束
		int ea_status = 5; // 已同意3   不同意 4  审批中5
		if(entity.getWfsIsOver() == 1 ) {
			//如果审批结束 更新为 审批状态 同意或不同意
			if(ap.getIsAgree() != null && ap.getIsAgree().equals("0")) {
				//同意
				ea_status = 3;
			} else {
				ea_status = 4;
			}
		}
		this.logger.info("当前工作流审批状态：(已同意3   不同意 4  审批中5)" + entity.getProjectCode() + "," + ea_status);
		sql = "update dotp_pm_projects set ea_status =" + ea_status + " where project_code = '" + entity.getProjectCode() + "'";
		//执行sql
    	this.dppmTemp.update(sql);
	}
    
    //获得项目风险
    public List<ProjectRiskEntity> projRiskinfo(String sql) {
    	// 根据 sql 获得项目风险集合
    	return this.dppmTemp.query(sql,
    			new RowMapper<ProjectRiskEntity>(){
    		@Override
			public ProjectRiskEntity mapRow(ResultSet rs, int rowNum)
					throws SQLException {
    			ProjectRiskEntity info = new ProjectRiskEntity();
    			info.setProjectCode(rs.getString("project_code"));
    			//0为其他
    			if(0 == rs.getInt("milestone")) {
//    			 	里程碑名称
        			info.setMilestonename("其他");
    			} else {
//    			 	里程碑名称
        			info.setMilestonename(rs.getString("milestonename"));
    			}
    			// 	风险类型
    			info.setRiskTypename(rs.getString("risktype"));
    			// 	风险级别
    			info.setRiskLevelname(rs.getString("risklevel"));
    			//风险详情
    			info.setRiskSummary(rs.getString("risk_summary"));
    			return info;
    		}
    	});
    }
    
    //获得项目范围 涉及部门
    public List<ProjectScopeDeptEntity> scopeDeptinfo(String sql) {
    	// 根据 sql 获得系统范围集合
    	return this.dppmTemp.query(sql,
    			new RowMapper<ProjectScopeDeptEntity>(){
    		@Override
			public ProjectScopeDeptEntity mapRow(ResultSet rs, int rowNum)
					throws SQLException {
    			ProjectScopeDeptEntity info = new ProjectScopeDeptEntity();
    			info.setDeptBcode(rs.getString("dept_bcode"));
    			info.setDeptName(rs.getString("dept_name"));
    			return info;
    		}
    	});
    }
    
    //获得项目范围 系统范围
    public List<ProjectScopeSysEntity> scopeSysinfo(String sql) {
    	// 根据 sql 获得系统范围集合
    	return this.dppmTemp.query(sql,
    			new RowMapper<ProjectScopeSysEntity>(){
    		@Override
			public ProjectScopeSysEntity mapRow(ResultSet rs, int rowNum)
					throws SQLException {
    			ProjectScopeSysEntity info = new ProjectScopeSysEntity();
    			//系统名称
    			info.setSysName(rs.getString("sysname"));
    			// 	是否主系统
    			info.setIsMain(rs.getInt("is_main"));
    			// 	涉及系统功能
    			info.setSysFunc(rs.getString("sys_func"));
    			return info;
    		}
    	});
    }
    
    //获得项目范围 业务范围
    public List<ProjectScopeBusinessEntity> scopeBussinessinfo(String sql) {
    	// 根据 sql 获得业务范围集合
    	return this.dppmTemp.query(sql,
    			new RowMapper<ProjectScopeBusinessEntity>(){
    		@Override
			public ProjectScopeBusinessEntity mapRow(ResultSet rs, int rowNum)
					throws SQLException {
    			ProjectScopeBusinessEntity info = new ProjectScopeBusinessEntity();
    			//业务模块
    			info.setBizModule(rs.getString("biz_module"));
    			// 	具体内容
    			info.setBizContent(rs.getString("biz_content"));
    			return info;
    		}
    	});
    }
    
    
    //获得项目组织
    public Map<String, Object> orgallinfo(String sql) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	//项目发起人
    	ProjectOrgEntity fqrinfo = new ProjectOrgEntity();
    	//甲方项目经理
    	ProjectOrgEntity jfjlinfo = new ProjectOrgEntity();
    	//乙方项目经理
    	ProjectOrgEntity yfjlinfo = new ProjectOrgEntity();
    	// 执行个人(公司内部)集合
    	List<ProjectOrgEntity> glist = new ArrayList<ProjectOrgEntity>(); 
    	// 执行团队(公司内部) 集合
    	List<ProjectOrgEntity> tlist = new ArrayList<ProjectOrgEntity>(); 
    	// 公司外部 集合
    	List<ProjectOrgEntity> wlist = new ArrayList<ProjectOrgEntity>(); 
    	// 根据 sql 获得项目组织集合
    	List<ProjectOrgEntity> list = this.dppmTemp.query(sql, 
    			new RowMapper<ProjectOrgEntity>(){
    		@Override
			public ProjectOrgEntity mapRow(ResultSet rs, int rowNum)
					throws SQLException {
    			ProjectOrgEntity info = new ProjectOrgEntity();
    			//角色名称
    			info.setRoleName(rs.getString("role_name"));
    			//执行团队名称
    			info.setTeamName(rs.getString("team_name"));
    			// 	姓名
    			info.setUserName(rs.getString("contact_order_by"));
    			//工号
    			info.setUserCode(rs.getString("user_code"));
    			// 	所属系统
    			info.setSubsys(rs.getString("xitong"));
    			//所属部门
    			info.setDepartment(rs.getString("contact_department"));
    			// 	岗位
    			info.setJob(rs.getString("contact_job"));
    			//职等
    			info.setJobLevel(rs.getString("contact_employee_level"));
    			//计划入场时间
    			info.setJoinTime(rs.getDate("join_time"));
    			// 	计划离场时间
    			info.setLeaveTime(rs.getDate("leave_time"));
    			//工作职责
    			info.setDuty(rs.getString("duty"));
    			//掌握技能
    			info.setSkills(rs.getString("skills"));
    			info.setInternal(rs.getInt("internal"));
    			return info;
    		}
    	});
    	//
    	if(list != null && list.size() > 0 ){
    		for(ProjectOrgEntity o : list) {
    			//internal 0 外部人员, 1 内部员工, 101 项目发起人 102 甲方项目经理 100 乙方项目经理
    			if(o.getInternal() == 101) {
    				fqrinfo = o;
    			} else if(o.getInternal() == 102) {
    				jfjlinfo = o;
    			} else if(o.getInternal() == 100) {
    				yfjlinfo = o;
    			} else if(o.getInternal() == 1) {
    				//执行个人
    				if(o.getTeamName() == null || o.getTeamName().equals("")) {
    					glist.add(o);
    				} else {
    					//执行团队
    					tlist.add(o);
    				}
    			} else {
    				//外部人员
    				wlist.add(o);
    			}
    		}
    	}
    	//添加发起人
    	map.put("orgFqrinfo", fqrinfo);
    	//添加甲方项目经理
    	map.put("orgJfjlinfo", jfjlinfo);
    	//添加乙方项目经理
    	map.put("orgYfjlinfo", yfjlinfo);
    	//内部 执行个人
    	map.put("orgGrlist", glist);
    	//内部 执行团队
    	map.put("orgTdlist", tlist);
    	//外部
    	map.put("orgWlist", wlist);
    	return map;
    } 
    
    //获得项目里程碑
    public Map<String, Object> milestoneinfo(String sql) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	// 里程碑设置集合
    	List<ProjectMilestoneInfo> llist = new ArrayList<ProjectMilestoneInfo>(); 
    	// 关键点设置集合
    	List<ProjectMilestoneInfo> glist = new ArrayList<ProjectMilestoneInfo>(); 
    	// 根据 sql 获得里程碑集合
    	List<ProjectMilestoneInfo> list = this.dppmTemp.query(sql, 
    			new RowMapper<ProjectMilestoneInfo>(){
    		@Override
			public ProjectMilestoneInfo mapRow(ResultSet rs, int rowNum)
					throws SQLException {
    			ProjectMilestoneInfo info = new ProjectMilestoneInfo();
    			// 	里程碑名称
    			info.setMsname(rs.getString("ms_name"));
    		 	//里程碑时间
    			info.setTimepoint(rs.getString("time_point"));
    			// 	里程碑节点介绍
    			info.setMssummary(rs.getString("ms_summary"));
    			info.setIskey(rs.getInt("is_key"));
    			return info;
    		}
    	});
    	//
    	if(list != null && list.size() > 0 ){
    		for(ProjectMilestoneInfo o : list) {
    			//1 关键点
    			if(o.getIskey() == 1) {
    				glist.add(o);
    			} else {
    				//里程碑
    				llist.add(o);
    			}
    		}
    	}
    	map.put("mGlist", glist);
    	map.put("mLlist", llist);
    	return map;
    } 
    
    // 获得项目目标信息
    public Map<String, Object> objectiveinfo(String sql) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	// 可量化目标集合
    	List<ProjectObjectiveEntity> klist = new ArrayList<ProjectObjectiveEntity>(); 
    	// 不可量化目标集合
    	List<ProjectObjectiveEntity> blist = new ArrayList<ProjectObjectiveEntity>(); 
    	// 根据 sql 获得目标集合
    	List<ProjectObjectiveEntity> list = this.dppmTemp.query(sql, 
    			new RowMapper<ProjectObjectiveEntity>(){
    		@Override
			public ProjectObjectiveEntity mapRow(ResultSet rs, int rowNum)
					throws SQLException {
    			ProjectObjectiveEntity info = new ProjectObjectiveEntity();
    			//目标指标
    			info.setObjective(rs.getString("objective"));
    			//是否短期目标
    			info.setShortTerm(rs.getInt("short_term") == 1 ? "是" : "否");
    			//目标类型
    			info.setObjType(rs.getInt("obj_type"));
    			info.setObjTypeName(rs.getString("objtype"));
    			// 	指标值
    			info.setIndicator(rs.getString("indicator"));
    			//量化指标公式
    			info.setFormula(rs.getString("formula"));
    			//数据提供部门
    			info.setDeptProvider(rs.getString("deptprovidername"));
    			//是否项目组
    			info.setIsProvDept(rs.getString("pro_group"));
    			//数据审核部门
    			info.setDeptAudit(rs.getString("deptauditname"));
    			//是否项目组
    			info.setIsAuditDept(rs.getString("pro_group1"));
    			//目标承接部门
    			info.setOvertaken(rs.getString("deptovertakenname"));
    			//是否项目组
    			info.setIsTakenDept(rs.getString("pro_group2"));
    			//数据审核阶段
    			info.setObjState(rs.getString("obj_state"));
    			//是否涉及战略指标
    			info.setStrategicName(rs.getInt("strategic") == 1 ? "是" : "否");
    			info.setStrategic(rs.getInt("strategic"));
    			info.setQuantitative(rs.getInt("quantitative"));
    			return info;
    		}
    	});
    	//
    	if(list != null && list.size() > 0 ){
    		for(ProjectObjectiveEntity o : list) {
    			//1 可量变
    			if(o.getQuantitative() == 1) {
    				klist.add(o);
    			} else {
    				//不可量变
    				blist.add(o);
    			}
    		}
    	}
    	map.put("oklist", klist);
    	map.put("oBlist", blist);
    	return map;
    }
    
    // 获得项目基本信息
    public List<ProjectEntity> projinfo(String sql) {
    	return this.dppmTemp.query(sql, new RowMapper<ProjectEntity>(){
    		@Override
			public ProjectEntity mapRow(ResultSet rs, int rowNum)
					throws SQLException {
    			ProjectEntity info = new ProjectEntity();
    			info.setProjectId(rs.getInt("project_id"));
    			info.setProjectCode(rs.getString("project_code"));
    			info.setProjectName(rs.getString("proj_name"));
    			info.setShortName(rs.getString("short_name"));
    			//项目状态
    			info.setProjectStatus(rs.getString("projectstatue"));
    			//项目类型
    			info.setProjectType(rs.getString("projtype"));
    			//项目级别
    			info.setProjectLevel(rs.getString("projlevel"));
    			//项目实施方式
    			info.setImplentments(rs.getString("implentmentsname"));
    			//开发方式
    			info.setDevModels(rs.getString("devmodels"));
    			//功能点
    			info.setFuncCnt(rs.getInt("func_cnt"));
    			//子项目经理
    			info.setSubPmId(rs.getString("xmjl"));
    			//发起人
    			info.setInitiatorName(rs.getString("initiatorname"));
    			//发起部门
    			info.setInitiatorDept(rs.getString("fqrdept"));
    			//项目所属系统
    			info.setSysLabel(rs.getString("subsysname"));
    			//判断是否多个承接部门
    			String overtaken = rs.getString("overtaken");
    			if(overtaken != null && !overtaken.equals("")) {
    				// 有承接部门 定义 sql 进行查询
    				String sql = "select Group_concat(d.dept_name) from dotp_departments d where d.dept_benchmark_code in (";
    				if(overtaken.indexOf(",")>0) {
    					//多个
    					String[] ots = overtaken.split(",");
    					for( int i = 0 ; i < ots.length ; i++) {
    						sql += "'" + ots[i] + "'";
    						if(i < ots.length-1 ) {
    							sql += ",";
    						}
    					}
    				} else {
    					sql += "'" + overtaken + "'";
    				}
    				sql += ")";
    				List<String> plist = dppmTemp.queryForList(sql,String.class);
    		    	
    		    	if(plist != null && plist.size() > 0){
    		    		//承接部门
            			info.setOvertakeName(plist.get(0));
    		    	}
    			} else {
    				//承接部门
        			info.setOvertakeName("");
    			}
    			//承接部门
//    			info.setOvertakeName(rs.getString("overtaken"));
    			//项目经理(甲方) 
    			info.setPmId1Name(rs.getString("pmid1"));
    			//是否有咨询公
    			String consultancy = rs.getString("consultancy");
    			info.setConsultancy(StringUtil.isEmpty(consultancy)?"":consultancy);
    			
    			//立项时间
    			info.setCreateTime(rs.getDate("create_time"));
    			//结项时间
    			info.setFinishTime(rs.getDate("finish_time"));
    			//项目工作量
    			info.setWorkload(rs.getInt("workload"));
    			//项目成本
    			info.setTotalCosts(rs.getInt("total_costs"));
    			//项目简介
    			info.setProjectProfile(rs.getString("proj_profile"));
    			//是否涉及UI
    			info.setNeedUi("1".equals(rs.getString("need_ui"))?"是":"否");
    			//是否移动化
    			info.setNeedMobile("1".equals(rs.getString("need_mobile"))?"是":"否");
    			//项目经理(乙方)
    			info.setPmId2(rs.getString("pm_id2"));
    			
    			// 项目附件 sql
		    	String sql = "select * from dotp_attachment m where m.module='PM_PROJECTS_NEW' and m.module_id=" + rs.getString("project_code");
		    	// 根据附件 sql获得 任务对应的附件集合
		    	List<FileEntity> filesList = dppmTemp.query(sql,
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
		    	// 设置 对应的附件集合
		    	info.setFileList(filesList);
    			return info;
			}
		});
    }
    /**
	 *  Title:查看项目资源
	 *  @param projectCode
	 *  @return ProjectResources 项目资源实体类
	 *  Author: 280769
	 * 	Date: 2015-9-28
	 * */
	public Map<String, Object> queryProjectResources(String sql) {
		//查看项目资源的语句
		//return this.dppmTemp.query(sql, new RowMapper<ProjectResources>()
		List<ProjectResources> projectResorcesList = this.dppmTemp.query(sql, new RowMapper<ProjectResources>(){
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
		//项目资源list甲方
		List<ProjectResources> listJia = new ArrayList<ProjectResources>();
		BigDecimal roleProceJia = new BigDecimal(0);
		//项目资源list乙方
		List<ProjectResources> listYi = new ArrayList<ProjectResources>();
		BigDecimal roleProceYi = new BigDecimal(0);
		BigDecimal roleProceYii = new BigDecimal(0);
		//项目资源list其他
		List<ProjectResources> listQt = new ArrayList<ProjectResources>();
		BigDecimal roleProceQt = new BigDecimal(0);
		for (ProjectResources projectResources : projectResorcesList) {
			String cflag = projectResources.getCflag();
			//判断是甲、乙还是其他的
			//0是甲 1是乙  2是其他
			if("0".equals(cflag)){
				listJia.add(projectResources);
				roleProceJia = roleProceJia.add(projectResources.getRolePrice());
			}else if("1".equals(cflag)){
				if(projectResources.getPackPrice().longValue() > 0){
					roleProceYi = roleProceYi.add(projectResources.getPackPrice());
				}else {
					roleProceYii = roleProceYi.add(projectResources.getAllProce());
				}
				listYi.add(projectResources);
			}else{
				listQt.add(projectResources);
				roleProceQt = roleProceQt.add(projectResources.getRolePrice());
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ProjectResourcesJia", listJia);
		map.put("ProjectResourcesYi", listYi);
		map.put("ProjectResourcesQt", listQt);
		if(roleProceYi.longValue() > 0){
			map.put("allsum", (roleProceJia.add(roleProceYi).add(roleProceQt)));
		}
		else{
			map.put("allsum", (roleProceJia.add(roleProceYii).add(roleProceQt)));
		}
		return map;
	}
    
   
//	public static void main(String[] args) {
//		ProjectCheckEntity entity=new ProjectCheckEntity();
//		String sql="INSERT INTO dotp_pm_project_check_records(project_code,check_handler,check_suggestion,check_result,wfs_id," +
//				"wfs_activityDefid,wfs_activityInstID,wfs_workItemID,wfs_isOver,check_status) " +
//				"values (" + entity.getProjectCode() + ",'" + entity.getCheckHandler() +  "','"  + entity.getCheckSuggestion() + "'," 
//				+ entity.getCheckResult() + ",'" +entity.getWfsId() + "','" +entity.getWfsActivityDefid() + "','" +entity.getWfsActivityInstID()+","
//				+"','"+entity.getWfsWorkItemID()+"',"+entity.getWfsIsOver()+","+entity.getCheckStatus()+",";
//		System.out.println(sql);
//	}

}

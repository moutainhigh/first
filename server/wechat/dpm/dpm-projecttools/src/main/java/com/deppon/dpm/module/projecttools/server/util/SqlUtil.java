package com.deppon.dpm.module.projecttools.server.util;


/**
 * <p>ClassName: 项目管理工具数据库语句</p>
 * <p>Description: TODO</p>
 * <p>Author: 石学钢</p>
 * <p>Date: 2015-7-30</p>
 */
public  class SqlUtil {
	/** 
	 * TODO 查询部门所有项目
	 * @author 石学钢
	 * @param flag 1 查询我的收藏  2查询大部门下的项目
	 * @param deptName 部门名称
	 * 2015-9-24
	 */
	public static String getQueryproject(int flag,String deptName) {
		StringBuffer builder=new StringBuffer();
		builder.append(" SELECT v.project_code projectCode,");
		builder.append("v.proj_name projectname,");
		builder.append("c.contact_order_by faperson,");
		builder.append("d.contact_order_by mangerperson,");
		builder.append("h.label subsys,");
		builder.append(" case when M.task_percent_complete is null then 0 else M.task_percent_complete end  AS projectschedule,");
		builder.append(" st.label AS projectstatue,st.seq AS proj_status_seq,");
		builder.append("CASE WHEN v.proj_status='5' then null when ( SELECT currentstatus FROM");
		builder.append(" dotp_gh_projects_status_change");
		builder.append(" WHERE v.project_code = projectid");  //周状态如果没有修改 默认为项目当前状态 16.1.8
		builder.append(" ORDER BY modifytime DESC LIMIT 0,1 ) is null then v.currentstatus else ( SELECT currentstatus FROM");
		builder.append(" dotp_gh_projects_status_change");
		builder.append(" WHERE v.project_code = projectid");
		builder.append(" ORDER BY modifytime DESC LIMIT 0,1 ) end  AS bweek,");
		builder.append(" CASE WHEN v.proj_status='5' then null when ( SELECT currentstatus	FROM");
		builder.append(" dotp_gh_projects_status_change");
		builder.append(" WHERE	v.project_code = projectid");
		builder.append(" ORDER BY	modifytime DESC	LIMIT 1,1) is null then v.currentstatus else ( SELECT currentstatus	FROM");
		builder.append(" dotp_gh_projects_status_change");
		builder.append(" WHERE	v.project_code = projectid");
		builder.append(" ORDER BY	modifytime DESC	LIMIT 1,1) end AS lastweek,");
		builder.append(" v.overtaken AS overtaken,v.proj_level AS projLevel,");
		builder.append(" (CASE WHEN t.iscollect IS NULL THEN 0 ELSE t.iscollect END) isLoving");
		builder.append(" FROM DOTP_PM_PROJECTS v ");
		builder.append(" LEFT JOIN dotp_contacts c ON v.initiator = c.contact_employee_code");
		builder.append(" LEFT JOIN dotp_contacts d ON v.pm_id1 = d.contact_employee_code");
		builder.append(" LEFT JOIN dotp_names h ON h.name = 'subsys' AND h.value = v.subsys");
		builder.append(" LEFT JOIN dotp_names st ON st.name = 'gh_status' AND st.value = v.proj_status");
		builder.append(" LEFT JOIN DOTP_TM_TASKS M on v.AI_ID = M.TASK_PROJECT and M.task_type=-1");
		builder.append(" LEFT JOIN t_dppm_collect t ON v.project_code = t.dppm_code ");
		// 查询大部门下的项目时 关联收藏表 判断是否输入我的收藏 
		if(flag == 2) {
			builder.append(" AND t.user_code = ? ");
		}
		builder.append(" where v.deleted = 0 and exists (select 1 from DOTP_TM_TASKS where TASK_PROJECT=v.AI_ID and task_is_delete=0 ) ");
		// 查询 我的收藏
		if(flag == 1) {
			builder.append(" AND t.user_code = ? ");
		}
		//大部门查询
		if(flag == 2) {
			if(deptName.trim().equals("1")) {
				builder.append(" AND 1=1 ");
			} else {
				builder.append(" AND h.label ='" + deptName + "'");
			}
		}
		builder.append(" group by v.ai_id ORDER BY bweek desc,proj_status_seq asc ;");
		return	builder.toString();
	}
	/**
	 * TODO 项目状态详情信息查询
	 * @author 石学钢
	 * 2015-9-24
	 */
	public static String getQueryprojectStruts(){
		return  "SELECT "+
				"DATE_FORMAT(modifytime,'%Y-%m-%d %k:%i:%s') modifytime,REASON,MODIFYPERSON,MODIFYPERSONCODE,MODIFYPERSONDEPT,CURRENTSTATUS "+
				"FROM dotp_gh_projects_status_change "+
				"WHERE projectid= ? ORDER BY modifytime desc LIMIT 0,2";
	}
	/**
	 * TODO 项目列表里程碑信息查询
	 * @author 石学钢
	 * 2015-9-24
	 */
	public static String getQueryProjectMilestone(){
		return "SELECT "+
				"m.ms_id mid, "+
				"m.project_code projectcode, "+
				"m.ms_name msname, "+
				"m.time_point timepoint, "+
				"m.ms_summary mssummary, "+
				"p.proj_profile projectprofile, "+
				"p.proj_name projectname, "+
				"p.create_time createtime, "+
				"p.finish_time finishtim, "+
				" case when s.minutes_id  is null then 0 else 1 end ismsId "+
				" FROM "+
				"dotp_pm_project_milestone m "+
				"LEFT JOIN DOTP_PM_PROJECTS p ON m.project_code = p.project_code "+
				" left JOIN dotp_pm_project_milestone_minutes s on m.ms_id=s.ms_id "+
				" WHERE "+
				"m.project_code = ? "+
				"ORDER BY "+
				"time_point ASC ";
	}
	/**
	 * TODO 项目列表里程碑立项 结项查询
	 */
	public static String getQueryProjectMilestonee(){
		return "SELECT "+
				"create_time createtime, "+
				"finish_time finishtim "+
				" FROM "+
				"DOTP_PM_PROJECTS  "+
				" WHERE "+
				"project_code = ?  and deleted=0";
	}
	/**
	 * TODO 项目列表基本详情信息查询
	 * @author 石学钢
	 * 2015-9-24
	 */
	public static String getQueryProjectDeatil(){
		return "SELECT "+
				"p.project_code projectCode, "+
				"p.code  dppmCode ,p.proj_name projectName, "+
				"p.short_name shortName, "+
				"n.label projectType, "+
				"m.label projectLevel, "+
				"j.label devModel, "+
				"k.contact_order_by initator, "+
				"y.contact_order_by porjectManger, "+
				"v.contact_order_by subManger, "+
				"h.label subsys, "+
				"t.dept_name overTaken, "+
				"p.func_cnt func, "+
				"p.proj_profile projectPr "+
				"FROM "+
				"DOTP_PM_PROJECTS p "+
				"LEFT JOIN dotp_names n on n.name=\"gh_type\" and n.`value`=p.proj_type "+
				"LEFT JOIN dotp_names m on m.name=\"gh_level\" and m.`value`=p.proj_level "+
				"LEFT JOIN dotp_names j on j.name=\"dev_models\" and j.`value`=p.dev_models "+
				"LEFT JOIN dotp_contacts k ON k.contact_employee_code=p.initiator "+
				"LEFT JOIN dotp_contacts y ON y.contact_employee_code=p.pm_id1 "+
				"LEFT JOIN dotp_contacts v ON v.contact_employee_code=p.sub_pm_id "+
				"LEFT JOIN dotp_names h ON h.`name`=\"subsys\" and h.`value`=p.subsys "+
				"LEFT JOIN dotp_departments t ON p.overtaken=t.dept_benchmark_code "+
				"WHERE p.project_code = ? ";
	}
	/**项目审核检查日志*/
	public static String getAuditChecklog(String taskid,String check_desc, int check_status ){
		return "insert into dotp_tm_task_check_log(task_id,check_desc,check_time,check_status) values("+taskid+",'"+check_desc+"',"+"NOW()"+","+check_status+")";
	}
	/**项目审核日志*/
	public static String getAuditlog(){
		return "update dotp_tm_task_log a set check_log_id=(select b.id from dotp_tm_task_check_log b where b.task_id=? ORDER BY b.check_time desc limit 0,1),task_is_check=0 where a.task_id=? and task_is_check=1";
	}
	/**项目审核*/
	public static String getAuditStatusupdate(){
		return "update dotp_tm_tasks a set a.task_status=?,task_is_check=? ";
	}
	
	/**项目列表员工查询
	 * *
	 * Id 查询列表的ID 
	 * userId 查询用户收藏的ID
	 */
	public static String getPowerQueryproject(String userId,String jobNumber){
		return "select v.project_code projectCode,v.proj_name projectname,c.contact_order_by " +
				"faperson,d.contact_order_by mangerperson,h.label subsys,case when tt.task_percent_complete is null then 0 else tt.task_percent_complete end  AS projectschedule,(select label from dotp_names where name=" +
				"'gh_status' and value=MAX(v.proj_status)) AS projectstatue,( SELECT seq FROM dotp_names " +
				" WHERE NAME = 'gh_status' AND VALUE = MAX(v.proj_status) " +
				" ) AS proj_status_seq,CASE WHEN v.proj_status='5' then null when (select" +
				" currentstatus from dotp_gh_projects_status_change where v.project_code" +
				"=projectid ORDER BY modifytime desc LIMIT 0,1) is null then v.currentstatus else (select" +
				" currentstatus from dotp_gh_projects_status_change where v.project_code" +
				"=projectid ORDER BY modifytime desc LIMIT 0,1) end as bweek, CASE WHEN v.proj_status='5' then null when (select " +
				"currentstatus from dotp_gh_projects_status_change where v.project_code" +
				"=projectid ORDER BY modifytime desc LIMIT 1,1) is null then v.currentstatus else (select " +
				"currentstatus from dotp_gh_projects_status_change where v.project_code" +
				"=projectid ORDER BY modifytime desc LIMIT 1,1) end as lastweek, " +
				"v.overtaken as overtaken,v.proj_level as projLevel, (case when " +
				"t.iscollect is null then 0 else t.iscollect end ) isLoving from (select" +
				" pro_t.*, name_t.label status_name, name_t2.label ea_status_name,(select" +
				" case when r.project_code is not NULL then '1' else '0' end from " +
				"dotp_pm_project_check_records as r LEFT JOIN dotp_pm_projects_approve_list" +
				" as l on r.wfs_id = l.wfs_id and r.wfs_activityDefid = " +
				"l.wfs_activityDefid where r.check_status = '1' and l.approve_emp " +
				"in ("+userId+", '"+jobNumber+"') and r.project_code = pro_t.project_code) " +
				"need_approve, porg.project_code pcode1,pmo.project_code pcode2," +
				"pm.project_code pcode3,wfs.project_code pcode4,ptype.project_code " +
				"pcode5, gg.project_code pcode6 FROM (SELECT * FROM dotp_pm_projects " +
				"WHERE deleted = 0) pro_t LEFT JOIN dotp_names name_t ON pro_t.proj_status" +
				" = name_t.value AND name_t.name = 'gh_status' LEFT JOIN dotp_names name_t2" +
				" ON pro_t.ea_status = name_t2.value AND name_t2.name = 'ea_status' LEFT " +
				"JOIN ( select porg_user.project_code from dotp_pm_project_org_all " +
				"porg_user where porg_user.user_code = "+userId+" or porg_user.user_code " +
				"in(select tmp.user_code from ( select (case when dd.dept_owner = " +
				"cc.contact_employee_code then mm.dept_owner else dd.dept_owner end) " +
				"as downer, tt.user_code from (select xx.user_code from (select " +
				"oo.user_code as user_code from dotp_pm_project_org_all oo ) xx " +
				"group by xx.user_code) tt left JOIN dotp_contacts cc on " +
				"cc.contact_employee_code = tt.user_code LEFT JOIN dotp_departments " +
				"dd on dd.dept_benchmark_code = cc.dept_benchmark_code left join " +
				"dotp_departments mm on mm.dept_benchmark_code = " +
				"dd.dept_parent_benchmark_code ) tmp where tmp.downer " +
				"is not null and tmp.downer =  "+userId+") group by porg_user.project_code )" +
				" porg ON pro_t.project_code = porg.project_code left join " +
				"( select project_code from dotp_pm_projects mm where mm.pm_id1 in " +
				"( select tmp.user_code from ( select (case when dd.dept_owner " +
				"= cc.contact_employee_code then mm.dept_owner else dd.dept_owner end)" +
				" as downer, tt.user_code from (select pp.pm_id1 as user_code from " +
				"dotp_pm_projects pp group by pp.pm_id1) tt left JOIN dotp_contacts " +
				"cc on cc.contact_employee_code = tt.user_code LEFT JOIN " +
				"dotp_departments dd on dd.dept_benchmark_code = cc.dept_benchmark_code" +
				" left join dotp_departments mm on mm.dept_benchmark_code " +
				"= dd.dept_parent_benchmark_code) tmp where tmp.downer is not" +
				" null and tmp.downer =  "+userId+" ) or mm.initiator in " +
				"(select tmp.user_code from (select (case when dd.dept_owner = " +
				"cc.contact_employee_code then mm.dept_owner else dd.dept_owner end) " +
				"as downer,tt.user_code from (select pp.initiator as user_code from " +
				"dotp_pm_projects pp group by pp.initiator) tt left JOIN dotp_contacts" +
				" cc on cc.contact_employee_code = tt.user_code LEFT " +
				"JOIN dotp_departments dd on dd.dept_benchmark_code = " +
				"cc.dept_benchmark_code left join dotp_departments mm on " +
				"mm.dept_benchmark_code = dd.dept_parent_benchmark_code) " +
				"tmp where tmp.downer is not null and tmp.downer =  "+userId+" )) " +
				"gg  on pro_t.project_code = gg.project_code LEFT JOIN " +
				"( select pro_pmo.project_code from dotp_pm_projects pro_pmo " +
				"where pro_pmo.proj_level = 3 and '"+jobNumber+"' in " +
				"('DP08466','DP00281','DP08711','DP08712','DP09102','DP08829'," +
				"'DP12336','DP13132')) pmo ON pro_t.project_code = " +
				"pmo.project_code LEFT JOIN ( select pro_pmo.project_code from " +
				"dotp_pm_projects pro_pmo where pro_pmo.proj_level <> 3 or " +
				"(pro_pmo.proj_level = 3 and pro_pmo.proj_type = 1) and " +
				"'"+jobNumber+"' = 'DP10556' ) itpm ON pro_t.project_code = " +
				"itpm.project_code LEFT JOIN ( select pro_pm.project_code " +
				"from dotp_pm_projects pro_pm where pro_pm.pm_id1 = "+userId+" " +
				"or pro_pm.initiator = "+userId+" or pro_pm.creator = "+userId+" ) " +
				"pm ON pro_t.project_code = pm.project_code LEFT JOIN ( select " +
				"pro_it.project_code from dotp_pm_projects pro_it where " +
				"pro_it.proj_type in (1, 3) and '"+jobNumber+"' = 'DP10556' ) " +
				"ptype ON pro_t.project_code = ptype.project_code LEFT JOIN " +
				"( select p.project_code from dotp_pm_project_check_records " +
				"as r LEFT JOIN dotp_pm_projects_approve_list as l on r.wfs_id" +
				" = l.wfs_id and r.wfs_activityDefid = l.wfs_activityDefid LEFT " +
				"JOIN dotp_pm_projects as p on r.project_code = p.project_code " +
				"where r.check_status = '1' and l.approve_emp in ("+userId+", '"+jobNumber+"'))" +
				" wfs ON pro_t.project_code = wfs.project_code) v LEFT JOIN " +
				"dotp_contacts c ON v.initiator=c.contact_employee_code LEFT JOIN " +
				"dotp_contacts d ON v.pm_id1=d.contact_employee_code LEFT JOIN " +
				"dotp_names h ON h.`name`=\"subsys\" and h.`value`=v.subsys LEFT " +
				"JOIN t_dppm_collect t on v.project_code=t.dppm_code and " +
				"t.user_code="+userId+" LEFT JOIN DOTP_TM_TASKS tt on tt.task_project=v.project_code and tt.task_type=-1 "+" where v.deleted = 0 " +
				"and ( v.pcode1 is not NULL or v.pcode2 is not NULL or v.pcode3 " +
				"is not NULL or v.pcode4 is not NULL or v.pcode5 is not NULL or " +
				"v.pcode6 is not NULL) " ;
			
	}
	
	   /**
     * 获取个人任务列表的Sql
     * @return
     */
    public static String getMyTaskSql(){
        return "select " +
                "`id` " + 
                ",task_project as projectId " +
                ",task_percent_complete as taskPercentComplete " +
                ",task_category as taskCategory " +
                ",task_name as taskName " +
                ",task_type as taskType " +
                ",task_owner_id as taskOwnerId " +
                ",task_processer_id as taskProcesserId " +
                ",task_start_time as taskStartTime " +
                ",task_end_time as taskEndTime " +
                ",task_duration as taskDuration " +
                ",task_is_leaf as taskIsLeaf " +
                ",task_status as taskStatus " +
                ",task_is_check as taskIsCheck " +
                ",(select contact_order_by from dotp_contacts " +
                "dc where dc.contact_employee_code = taskProcesserId) as taskProcesserName" +
                "from " +
                "dotp_tm_tasks " +
                "where " +
                "task_processer_id = ? " +
                "and task_status in (0,1,2,3,6) " +
                "and task_is_delete = '0' " +
                "order by task_end_time asc";
    }
    /**
     * TODO 查询里程碑会议纪要代办事项
     * @author 石学钢
     * 2015-9-24
     */
    public static String getMilestoneMinutesBack(){
    	StringBuffer buffer=new StringBuffer();
    	buffer.append(" SELECT");
    	buffer.append(" b.backlog_dutyman,");
    	buffer.append("	b.backlog_content,");
    	buffer.append(" b.finishe_time");
    	buffer.append(" FROM");
    	buffer.append(" dotp_pm_project_milestone_minutes_backlog b");
    	buffer.append(" WHERE b.ms_id=? order by b.finishe_time");
    	return buffer.toString();
    }
    /**
     * TODO   查询里程碑会议纪要
     * @author 石学钢
     * 2015-9-24 
     */
    public static String getMilestoneMinutes(){
    	StringBuffer buffer=new StringBuffer();
    	buffer.append("SELECT");
    	buffer.append(" a.ms_id msId,");
    	buffer.append(" a.ms_name msName,");
    	buffer.append(" a.minutes_time minutesTime,");
    	buffer.append(" a.minutes_location minutesLocation,");
    	buffer.append(" a.minutes_moderator minutesModerator,");
    	buffer.append(" a.minutes_recorder minutesRecorder,");
    	buffer.append(" a.minutes_participants minutesParticipants,");
    	buffer.append(" a.minutes_content minutesContent,");
    	buffer.append(" a.minutes_summary minutesSummary");
    	buffer.append(" FROM");
    	buffer.append(" dotp_pm_project_milestone_minutes a ");
    	buffer.append(" where a.ms_id=?");
    	return buffer.toString();
    }
    /**
     * 获取PMO初次加载任务列表
     * @return
     */
    public static String getSearchPmoTaskSql(String emCode){
        StringBuffer sb = new StringBuffer();
        sb.append("select ");
        sb.append("a1.`id`, ");
        sb.append("a1.projectId, ");
        sb.append("a1.taskParent, ");
        sb.append("a1.taskPercentComplete, ");
        sb.append("a1.taskCategory, ");
        sb.append("a1.taskName, ");
        sb.append("a1.taskType, ");
        sb.append("a1.taskOwnerId, ");
        sb.append("a1.taskProcesserId, ");
        sb.append("a1.taskStartTime, ");
        sb.append("a1.taskEndTime, ");
        sb.append("a1.taskDuration, ");
        sb.append("a1.taskIsLeaf, ");
        sb.append("a1.taskStatus, ");
        sb.append("a1.taskIsCheck, ");
        sb.append("dc.contact_order_by as taskProcesserName ");
        sb.append("from ( ");
        sb.append("select "); 
        sb.append(" `id` "); 
        sb.append(",task_project as projectId ");
        sb.append(",task_parent as taskParent ");
        sb.append(",task_percent_complete as taskPercentComplete ");
        sb.append(",task_category as taskCategory "); 
        sb.append(",task_name as taskName "); 
        sb.append(",task_type as taskType ");
        sb.append(",task_owner_id as taskOwnerId ");
        sb.append(",task_processer_id as taskProcesserId "); 
        sb.append(",task_start_time as taskStartTime "); 
        sb.append(",task_end_time as taskEndTime "); 
        sb.append(",task_duration as taskDuration "); 
        sb.append(",task_is_leaf as taskIsLeaf "); 
        sb.append(",task_status as taskStatus ");
        sb.append(",task_is_check as taskIsCheck ");
        sb.append("from dotp_tm_tasks "); 
        sb.append("where task_category = 1 ");  
        sb.append("and task_type = - 1 ");
        sb.append("and task_status in ('0','2','3','6','7') "); 
        sb.append("and task_is_delete = '0' "); 
        sb.append("union ");
        sb.append("select ");
        sb.append(" t1.`id` ");
        sb.append(",t1.task_project as projectId "); 
        sb.append(",t1.task_parent as taskParent ");
        sb.append(",t1.task_percent_complete as taskPercentComplete "); 
        sb.append(",t1.task_category as taskCategory ");
        sb.append(",t1.task_name as taskName ");
        sb.append(",t1.task_type as taskType ");
        sb.append(",t1.task_owner_id as taskOwnerId ");
        sb.append(",t1.task_processer_id as taskProcesserId ");
        sb.append(",t1.task_start_time as taskStartTime ");
        sb.append(",t1.task_end_time as taskEndTime ");
        sb.append(",t1.task_duration as taskDuration ");
        sb.append(",t1.task_is_leaf as taskIsLeaf ");
        sb.append(",t1.task_status as taskStatus ");
        sb.append(",t1.task_is_check as taskIsCheck ");
        sb.append("from ");
        sb.append("dotp_tm_tasks t1 ");
        sb.append("INNER JOIN (select ");
        sb.append("t4.contact_employee_code, ");
        sb.append("t4.contact_order_by ");
        sb.append("from ");
        sb.append("dotp_contacts t4, ");
        sb.append("dotp_departments t5 ");
        sb.append("where ");
        sb.append("t5.dept_owner = '"+ emCode +"' ");
        sb.append("and t4.dept_benchmark_code = t5.dept_benchmark_code ");
        sb.append("union ");
        sb.append("select ");
        sb.append("t7.contact_employee_code, ");
        sb.append("t7.contact_order_by ");
        sb.append("from ");
        sb.append("dotp_contacts t7 ");
        sb.append("where ");
        sb.append("contact_employee_code = '"+ emCode +"') v2 ");
        sb.append("on ");
        sb.append("( t1.task_owner_id = v2.contact_employee_code ");
        sb.append("or t1.task_processer_id = v2.contact_employee_code ) ");
        sb.append("and t1.task_category <> 1  ");
        sb.append("and t1.task_status in ('0','2','3','6','7') ");
        sb.append("and t1.task_is_delete = '0' ");
        sb.append(") a1 ");
        sb.append("left join ");
        sb.append("dotp_contacts dc ");
        sb.append("on a1.taskProcesserId = dc.contact_employee_code ");
        return sb.toString();
    }
    
    /**
     * 获取PMO以外的初次加载任务列表
     * @return
     */
    public static String getSearchNotPmoTaskSql(String emCode){
        StringBuffer sb = new StringBuffer();
        sb.append("select t12.*, ");
        sb.append("t13.contact_order_by AS taskProcesserName ");
        sb.append("from (");
        sb.append("select ");
        sb.append("t1.`id`, ");
        sb.append("t1.task_project AS projectId, ");
        sb.append("t1.task_parent AS taskParent, ");
        sb.append("t1.task_percent_complete AS taskPercentComplete, ");
        sb.append("t1.task_category AS taskCategory, ");
        sb.append("t1.task_name AS taskName, ");
        sb.append("t1.task_type AS taskType, ");
        sb.append("t1.task_owner_id AS taskOwnerId, ");
        sb.append("t1.task_processer_id AS taskProcesserId, ");
        //sb.append("t12.contact_order_by AS taskProcesserName, ");
        sb.append("t1.task_start_time AS taskStartTime, ");
        sb.append("t1.task_end_time AS taskEndTime, ");
        sb.append("t1.task_duration AS taskDuration, ");
        sb.append("t1.task_is_leaf AS taskIsLeaf, ");
        sb.append("t1.task_status AS taskStatus, ");
        sb.append("t1.task_is_check AS taskIsCheck ");
        sb.append("from ");
        sb.append("dotp_tm_tasks t1 ");
        sb.append("INNER JOIN ");
        sb.append("(select ");
        sb.append("t4.contact_employee_code ");
        sb.append("from ");
        sb.append("dotp_contacts t4, ");
        sb.append("dotp_departments t5 ");
        sb.append("where ");
        sb.append("t5.dept_owner = '" + emCode + "' ");
        sb.append("and t4.dept_benchmark_code = t5.dept_benchmark_code ");
        sb.append("union ");
        sb.append("select ");
        sb.append("t7.contact_employee_code ");
        sb.append("from ");
        sb.append("dotp_contacts t7 ");
        sb.append("where ");
        sb.append("contact_employee_code = '" + emCode + "' ) v2 ");
        sb.append("on ");
        sb.append("(t1.task_owner_id = v2.contact_employee_code ");
        sb.append("or t1.task_processer_id = v2.contact_employee_code ) ");
        sb.append("and t1.task_status in ('0','2','3', '6', '7') ");
        sb.append("and t1.task_is_delete = '0' ");
        //sb.append("left join dotp_contacts t12 ON t1.task_processer_id = t12.contact_employee_code ");
        sb.append("union ");
        sb.append("SELECT ");
        sb.append("t8.`id`, ");
        sb.append("t8.task_project AS projectId, ");
        sb.append("t8.task_parent AS taskParent, ");
        sb.append("t8.task_percent_complete AS taskPercentComplete, ");
        sb.append("t8.task_category AS taskCategory, ");
        sb.append("t8.task_name AS taskName, ");
        sb.append("t8.task_type AS taskType, ");
        sb.append("t8.task_owner_id AS taskOwnerId, ");
        sb.append("t8.task_processer_id AS taskProcesserId, ");
        //sb.append("t11.contact_order_by AS taskProcesserName, ");
        sb.append("t8.task_start_time AS taskStartTime, ");
        sb.append("t8.task_end_time AS taskEndTime, ");
        sb.append("t8.task_duration AS taskDuration, ");
        sb.append("t8.task_is_leaf AS taskIsLeaf, ");
        sb.append("t8.task_status AS taskStatus, ");
        sb.append("t8.task_is_check AS taskIsCheck ");
        sb.append("FROM ");
        sb.append("dotp_tm_tasks t8 ");
        sb.append("INNER JOIN ( ");
        sb.append("SELECT ");
        sb.append("t9.`id` ");
        sb.append("FROM ");
        sb.append("dotp_tm_tasks t9 ");
        sb.append("WHERE ");
        sb.append("( ");
        sb.append("t9.task_owner_id = '"+emCode+"' ");
        sb.append("OR t9.task_processer_id = '"+emCode+"') ");
        sb.append("AND t9.task_status IN ('0', '2', '3', '6', '7') ");
        sb.append("AND t9.task_is_delete = '0' ");
        sb.append(") t10 ON t8.task_parent = t10.`id` ");
        //sb.append("LEFT JOIN dotp_contacts t11 ON ");
        //sb.append("t8.task_processer_id = t11.contact_employee_code ");
        sb.append(") t12 ");
        sb.append("LEFT JOIN dotp_contacts t13 ON ");
        sb.append("t12.taskProcesserId = t13.contact_employee_code ");
        sb.append("ORDER BY t12.`id` ");
        return sb.toString();
    }
    
    /**
     * 判断是否是PMO的Sql
     * @return
     */
    public static String getIsPmoSql(String emCode){
        
        StringBuffer sb = new StringBuffer();
        sb.append("select count(*) con from dotp_contacts t, ");
        sb.append("(select dept_benchmark_code from dotp_departments ");
        sb.append("  where dept_sequence like '%.212774.%' and dept_state=0");
        sb.append(") t2 ");
        sb.append(" where t.dept_benchmark_code = t2.dept_benchmark_code ");
        sb.append(" and t.contact_employee_code = '" + emCode + "' and t.contact_status=1");
        
        return sb.toString();
    }
    
    /**
     * 获取参与的项目
     * @param isPmo
     * @return
     */
    public static String getProjectSql(boolean isPmo, String emCode){
        StringBuffer sql = new StringBuffer();
        sql.append("select "); 
        sql.append("aiId, "); 
        sql.append("projectId, "); 
        sql.append("projName, "); 
        sql.append("`code`, ");
        sql.append("projProcesserId, "); 
        sql.append("projStatus, ");
        sql.append("dc.contact_order_by AS projProcesserName, ");
        sql.append("dtt.task_percent_complete AS projPercentComplete ,tt.task_name taskParentName,tt.id taskParentId ");
        sql.append("from (select "); 
        sql.append("dp.ai_id AS aiId, "); 
        sql.append("dt.task_project AS projectId, "); 
        sql.append("dt.`id` AS taskid, "); 
        sql.append("dp.proj_name AS projName, "); 
        sql.append("dp.`code` AS `code`, ");
        sql.append("dp.initiator AS projProcesserId, ");
        sql.append("dp.project_code AS projectCode, ");
        sql.append("dp.proj_status AS projStatus, ");
        sql.append("dt.task_top_parent AS taskTopParent ");
        sql.append("from  ");
        sql.append("dotp_tm_tasks dt, ");
        sql.append("dotp_pm_projects dp, ");
        sql.append("(select "); 
        sql.append("t4.contact_employee_code "); 
        sql.append(",t4.contact_order_by "); 
        sql.append("from ");
        sql.append("dotp_contacts t4, ");
        sql.append("dotp_departments t5 ");
        sql.append("where "); 
        sql.append("t5.dept_owner = '" + emCode + "' "); 
        sql.append("and t4.dept_benchmark_code = t5.dept_benchmark_code ");
        sql.append("union ");
        sql.append("select "); 
        sql.append("t7.contact_employee_code "); 
        sql.append(",t7.contact_order_by "); 
        sql.append("from dotp_contacts t7 ");
        sql.append("where ");
        sql.append("contact_employee_code = '" + emCode + "') v5 ");
        sql.append("where "); 
        sql.append("dt.task_project = dp.ai_id ");
        sql.append("and dt.task_category = 1 ");
        sql.append("and dt.task_status in ('0','2', '3', '6', '7') ");
        sql.append("and dt.task_is_delete = '0' ");
        if(!isPmo){
            sql.append(" and (dt.task_owner_id = v5.contact_employee_code ");
            sql.append(" or dt.task_processer_id = v5.contact_employee_code )");
        }else{
            //PMO能看到所有的项目
            sql.append("and dt.task_parent is null ");
        }
        sql.append("group by dp.ai_id");
        sql.append(") v8 ");
        sql.append("left join dotp_contacts dc on v8.projProcesserId = dc.contact_employee_code ");
        sql.append("left join dotp_tm_tasks dtt ");  
        sql.append("on dtt.task_project = v8.projectCode ");
        sql.append("AND v8.taskTopParent = dtt.`id` ");
        // 获得项目类父任务id
        sql.append("left join dotp_tm_tasks tt on tt.task_project = v8.projectCode and tt.task_type = -1 and tt.task_is_delete = 0 ");
        sql.append("order by v8.aiId ");
        
        return sql.toString();
    }
    
    /**
     * 根据任务Id获取所有子任务
     * @param args
     * @param taskCategory
     * @return
     */
    public static String getSubTaskLis(String param){
        StringBuffer sb = new StringBuffer();
        sb.append("select ");
        sb.append("a1.`id`, ");
        sb.append("a1.projectId, ");
        sb.append("a1.taskParent, ");
        sb.append("a1.taskPercentComplete, ");
        sb.append("a1.taskCategory, ");
        sb.append("a1.taskName, ");
        sb.append("a1.taskType, ");
        sb.append("a1.taskOwnerId, ");
        sb.append("a1.taskProcesserId, ");
        sb.append("a1.taskStartTime, ");
        sb.append("a1.taskEndTime, ");
        sb.append("a1.taskDuration, ");
        sb.append("a1.taskIsLeaf, ");
        sb.append("a1.taskStatus, ");
        sb.append("a1.taskIsCheck, ");
        sb.append("a1.subFlag, ");
        sb.append("dc.contact_order_by as taskProcesserName ");
        sb.append("from ( ");
        sb.append("SELECT ");
        sb.append("`id` ");
        sb.append(",task_project as projectId "); 
        sb.append(",task_parent as taskParent "); 
        sb.append(",task_percent_complete as taskPercentComplete "); 
        sb.append(",task_category as taskCategory ");
        sb.append(",task_name as taskName ");
        sb.append(",task_type as taskType ");
        sb.append(",task_owner_id as taskOwnerId ");
        sb.append(",task_processer_id as taskProcesserId ");
        sb.append(",task_start_time as taskStartTime ");
        sb.append(",task_end_time as taskEndTime ");
        sb.append(",task_duration as taskDuration ");
        sb.append(",task_is_leaf as taskIsLeaf ");
        sb.append(",task_status as taskStatus ");
        sb.append(",task_is_check as taskIsCheck ");
        sb.append(",0 subFlag ");
        sb.append("FROM ");
        sb.append("dotp_tm_tasks ");
        sb.append("WHERE ");
        sb.append("task_parent IN (" + param +") ");
        sb.append("AND task_status IN ('0','2', '3', '6', '7') ");
        sb.append("AND task_is_delete = 0 ");
        sb.append("AND `id` NOT IN (" + param +") ");
        sb.append("union ");
        sb.append("select ");
        sb.append(" t1.`id` as `id` ");
        sb.append(",t1.task_project as projectId "); 
        sb.append(",t1.task_parent as taskParent "); 
        sb.append(",t1.task_percent_complete as taskPercentComplete "); 
        sb.append(",t1.task_category as taskCategory ");
        sb.append(",t1.task_name as taskName ");
        sb.append(",t1.task_type as taskType ");
        sb.append(",t1.task_owner_id as taskOwnerId ");
        sb.append(",t1.task_processer_id as taskProcesserId ");
        sb.append(",t1.task_start_time as taskStartTime ");
        sb.append(",t1.task_end_time as taskEndTime ");
        sb.append(",t1.task_duration as taskDuration ");
        sb.append(",t1.task_is_leaf as taskIsLeaf ");
        sb.append(",t1.task_status as taskStatus ");
        sb.append(",t1.task_is_check as taskIsCheck ");
        sb.append(",1 subFlag ");
        sb.append("from ");
        sb.append("dotp_tm_tasks t1 ");
        sb.append("INNER JOIN ");
        sb.append("( ");
        sb.append("SELECT ");
        sb.append("`id` ");
        sb.append("FROM ");
        sb.append("dotp_tm_tasks ");
        sb.append("WHERE ");
        sb.append("task_parent IN (" + param +") ");
        sb.append("AND task_status IN ('0', '2', '3', '6', '7') ");
        sb.append("AND task_is_delete = 0 ");
        sb.append("AND task_is_leaf = 0 ");
        sb.append("AND `id` NOT IN (" + param +") ");
        sb.append(") v1 ");
        sb.append("ON ");
        sb.append("t1.task_parent = v1.`id` ");
        sb.append("where  ");
        sb.append("t1.task_status IN ('0', '2', '3', '6', '7') ");
        sb.append("AND t1.task_is_delete = 0 ");
        sb.append(") a1 ");
        sb.append("left join ");
        sb.append("dotp_contacts dc ");
        sb.append("on a1.taskProcesserId = dc.contact_employee_code ");
        return sb.toString();
    }
    
    /**
     * 统计需要审核的任务数
     * @return
     */
    public static String getCheckTaskCount(){
        return "select count(*) con from dotp_tm_tasks " +
               "where task_status in (2,6) and task_is_delete = 0 " +
               "and task_owner_id = ? and task_is_leaf = 1";
    }
    
    /**
     * 查询部门成员的任务
     * @param emCode
     * @return
     */
    public static String getDeptMemberTaskSql(String emCode){
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT ");
        sb.append("t3.`id`, ");
        sb.append("t3.task_project AS projectId, ");
        sb.append("t3.task_parent as taskParent, ");
        sb.append("t3.task_percent_complete AS taskPercentComplete, ");
        sb.append("t3.task_category AS taskCategory, ");
        sb.append("t3.task_name AS taskName, ");
        sb.append("t3.task_type AS taskType, ");
        sb.append("t3.task_owner_id AS taskOwnerId, ");
        sb.append("t3.task_processer_id AS taskProcesserId, ");
        sb.append("t3.task_start_time AS taskStartTime, ");
        sb.append("t3.task_end_time AS taskEndTime, ");
        sb.append("t3.task_duration AS taskDuration, ");
        sb.append("t3.task_is_leaf AS taskIsLeaf, ");
        sb.append("t3.task_status AS taskStatus, ");
        sb.append("t3.task_is_check AS taskIsCheck, ");
        sb.append("v2.contact_order_by as taskProcesserName ");
        sb.append("FROM ");
        sb.append("dotp_tm_tasks t3 ");
        sb.append("inner join ");
        sb.append("( ");
        sb.append("select ");
        sb.append("t4.contact_employee_code "); 
        sb.append(",t4.contact_order_by ");
        sb.append("from ");
        sb.append("dotp_contacts t4, ");
        sb.append("dotp_departments t5 ");
        sb.append("where "); 
        sb.append("t5.dept_owner = '"+ emCode +"' "); 
        sb.append("and t4.dept_benchmark_code = t5.dept_benchmark_code ");
        sb.append("and t4.contact_employee_code <> '"+ emCode +"' ");
        sb.append(") v2 ");
        sb.append("on ");
        sb.append("1=1 ");
        sb.append("and ( ");
        sb.append("t3.task_owner_id = v2.contact_employee_code ");
        sb.append("or t3.task_processer_id = v2.contact_employee_code ) ");
        sb.append("where  ");
        sb.append("t3.task_status in ('0', '2', '3', '6', '7') ");
        //sb.append("and t3.task_category in (2,3) ");
        sb.append("and t3.task_is_delete = '0' ");
        sb.append("order by t3.`id` ");
        return sb.toString();
    }
    /**
     * TODO 获取公司的所有一级部门和部门里对应的项目数目
     * @author 石学钢
     * 2015-9-24
     */
    public static String getDepartmentSql(){
    	StringBuffer bf=new StringBuffer();
    	bf.append("SELECT b.dept_benchmark_code id,");
    	bf.append(" b.dept_name dname,");
    	bf.append(" CASE WHEN k.counts IS NULL THEN 0 ELSE k.counts END counts");
    	bf.append(" FROM dotp_departments b");
    	bf.append(" LEFT JOIN ( SELECT COUNT(v.subsys) counts, h.label ");
    	bf.append(" FROM(");
    	bf.append(" SELECT T.subsys ");
    	bf.append(" FROM DOTP_PM_PROJECTS T");
    	bf.append(" where T.deleted = 0 ");
    	bf.append(" and exists (select 1 from DOTP_TM_TASKS where TASK_PROJECT=T.AI_ID ");
    	bf.append(" and task_is_delete=0 and task_is_leaf=1)");
    	bf.append(" ) v");
    	bf.append(" LEFT JOIN dotp_names h ON h.`name` = 'subsys' AND h.`value` = v.subsys");
    	bf.append(" GROUP BY v.subsys");
    	bf.append(" ) k ON k.label = b.dept_name");
    	bf.append(" WHERE b.dept_parent = ( ");
    	bf.append(" SELECT a.dept_id	FROM dotp_departments a");
    	bf.append(" WHERE a.dept_owner = '000001')");
    	bf.append(" and b.dept_state=0 and b.dept_owner is not null and b.dept_owner !=''");
    	return bf.toString();
		//return "select b.dept_benchmark_code id,b.dept_name dname from " +
		//		"dotp_departments b where b.dept_parent=( select a.dept_id" +
		//		" from dotp_departments a where a.dept_owner='000001')";
    }
    /**
     * TODO 获取一级部门的名称
     * @author 石学钢
     * 2015-9-24
     */
    public static String getdepartmentNamesql(){
		 return "select case when count(1)=0 then 0 " +
		 		"when  a.leval1_department is null then " +
		 		"0 else a.leval1_department end leva from " +
		 		"dotp_departments a where a.dept_benchmark_code" +
		 		"=(select b.dept_benchmark_code from dotp_contacts" +
		 		" b where b.contact_employee_code= ? limit 0,1);";
   }
    /**
     * TODO 获取部门编号
     * @author 石学钢
     * 2015-9-24
     */
    public static String getdepartmentNumber(){
    	return "select case when count(1) =0 then 0 when " +
    			"a.dept_benchmark_code is null then 0 else " +
    			"a.dept_benchmark_code end deptcode from " +
    			"dotp_contacts  a WHERE a.contact_employee_code " +
    			"= ?";
    }
    /**
     * TODO 插入数据监控
     * @author 石学钢
     * 2015-9-24
     */
    public static String getMonitroinsertsql(){
		StringBuffer buffer=new StringBuffer();
		buffer.append("INSERT INTO dotp_pm_project_monitor ( ");
		buffer.append(" userId,");
		buffer.append(" type,");
		buffer.append(" details,time");
		buffer.append(" )VALUES");
		buffer.append(" (?,?,?,NOW())");
		return buffer.toString();
    }
    /**
     * TODO 查询配置所有项目管理工具查询权限的任运
     * @author 石学钢
     * 2015-9-24
     */
    public static String getPowerquery(){
    	StringBuffer buffer=new StringBuffer();
    	buffer.append("select count(a.userId) ispower from dotp_pm_project_power a where a.type=0");
    	buffer.append(" and a.startTime< NOW() and a.overTime> now() and isdelete=0 AND a.userId = ?");
    	return buffer.toString();
    }
    /**
     * 	查看项目资源所有的成本
	 *  Author: 280769
	 * 	Date: 2015-9-28
	 * */
    public static String getProjectResources(){
    	StringBuffer buffer=new StringBuffer();
		buffer.append(" select ");
		buffer.append(" d.band_cnt AS bandCnt,");
		buffer.append("  m.label AS empRoleName,");
		buffer.append(" d.man_day AS manDay,");
		buffer.append("  0 As unitProce,");
		buffer.append("  null AS costSummary,");
		buffer.append("d.role_price AS roleProce,");
//		buffer.append(" dotp_pm_project_res1 a");
		buffer.append(" (d.role_price * d.man_day)/10 as allProce, ");
		buffer.append(" 0 As packPrice,");
		buffer.append("  0 cflag ");
		buffer.append(" FROM ");
		buffer.append(" dotp_pm_project_res1 d");
		buffer.append(" LEFT JOIN dotp_names m  ");
		buffer.append(" ON  m.name = 'gh_role'");
		buffer.append(" AND m.`value` = d.emp_role ");
		buffer.append(" where ");
		buffer.append(" d.project_code = ? ");
		buffer.append(" union all");
		buffer.append(" SELECT ");
		buffer.append(" '' AS bandCnt,");
		buffer.append(" d1.man_role AS empRoleName, ");
		buffer.append(" d1.man_day AS manDay,");
		buffer.append(" d1.unit_price As unitProce, ");
		buffer.append("  null AS costSummary,");
		buffer.append(" 0 AS roleProce,");
		buffer.append(" (d1.man_day * d1.unit_price)/10 AS allProce, ");
		buffer.append(" d1.pack_price As packPrice,");
		buffer.append(" 1 cflag");
		buffer.append(" FROM");
		buffer.append(" dotp_pm_project_res2 d1 ");
		buffer.append(" where");
		buffer.append(" d1.project_code  = ? ");
		buffer.append(" UNION ALL");
		buffer.append(" SELECT ");
		buffer.append(" '' AS bandCnt,");
		buffer.append("d2.cost_name AS empRoleName, ");
		buffer.append(" 0 As manDay,");
		buffer.append(" 0 AS unitProce, ");
		buffer.append(" d2.cost_summary AS costSummary,");
		buffer.append(" d2.cost_cnt As roleProce,");
		buffer.append(" 0 AS allProce, ");
		buffer.append(" 0 AS packPrice,");
		buffer.append(" 2  cflag ");
		buffer.append(" FROM ");
		buffer.append(" dotp_pm_project_res3 d2 ");
		buffer.append(" where");
		buffer.append(" d2.project_code = ? ");
		return buffer.toString();
    }
    /**
     * 根据当前用户 和用户部门获得项目列表
     * @param userId
     * @param deptCode
     * @return
     * 2015-10-22 高春玲
     */
    public static String searchProjList(String userId,String deptCode,String projName) {
    	String sql = "select v.*,g.gh_year, " +
    	"(select label from dotp_names n where v.subsys = n.value and n.name='subsys') subsysname, " +
    	"(select label from dotp_names n where v.proj_type = n.value and n.name='gh_type') ghtype " +
    	" from ( " +
			"select pro_t.*, name_t.label status_name, name_t2.label ea_status_name, " +
				" (select case when r.project_code is not NULL then '1' else '0' end " +
						"from dotp_pm_project_check_records as r " +
						"LEFT JOIN dotp_pm_projects_approve_list as l " +
						"	on r.wfs_id = l.wfs_id " +
						" and r.wfs_activityDefid = l.wfs_activityDefid " +
					 "where r.check_status = '1' " +
						" and l.approve_emp in ('" + userId + "', '" + deptCode + "') " +
						" and r.project_code = pro_t.project_code) need_approve, " +
				 "porg.project_code pcode1,pmo.project_code pcode2,pm.project_code pcode3,wfs.project_code pcode4, " +
				"	ptype.project_code pcode5,gg.project_code pcode6 " +
			"FROM (SELECT * FROM dotp_pm_projects WHERE deleted = 0) pro_t " +
			"LEFT JOIN dotp_names name_t " +
			"	ON pro_t.proj_status = name_t.value " +
			"		AND name_t.name = 'gh_status' " +
			"LEFT JOIN dotp_names name_t2 " +
			"	ON pro_t.ea_status = name_t2.value " +
			"		AND name_t2.name = 'ea_status' " +
			"LEFT JOIN ( " +
			"	select porg_user.project_code " +
			"	from dotp_pm_project_org_all porg_user " +
			"	where porg_user.user_code = '" + userId + "' " +
			"	or porg_user.user_code in(select tmp.user_code from ( " +
			"		select (case when dd.dept_owner = cc.contact_employee_code then mm.dept_owner else dd.dept_owner end) as downer, " +
			"			tt.user_code " +
			"			from (select xx.user_code from ( " +
			"				select oo.user_code as user_code from dotp_pm_project_org_all oo " +
			"				) xx group by xx.user_code) tt " +
			"			left JOIN dotp_contacts cc on cc.contact_employee_code = tt.user_code " +
			"			LEFT JOIN dotp_departments dd on dd.dept_benchmark_code = cc.dept_benchmark_code " +
			"			left join dotp_departments mm on mm.dept_benchmark_code = dd.dept_parent_benchmark_code " +
			"		) tmp where tmp.downer is not null and tmp.downer =  '" + userId + "') " +
			"	group by porg_user.project_code " +
			") porg " +
			"	ON pro_t.project_code = porg.project_code " +

	"	left join ( " +
		"		select project_code from dotp_pm_projects mm where mm.pm_id1 in ( " +
		"		select tmp.user_code from ( " +
		"			select (case when dd.dept_owner = cc.contact_employee_code then mm.dept_owner else dd.dept_owner end) as downer, " +
		"				tt.user_code " +
		"				from (select pp.pm_id1 as user_code from dotp_pm_projects pp group by pp.pm_id1) tt " +
		"				left JOIN dotp_contacts cc on cc.contact_employee_code = tt.user_code " +
		"				LEFT JOIN dotp_departments dd on dd.dept_benchmark_code = cc.dept_benchmark_code " +
		"				left join dotp_departments mm on mm.dept_benchmark_code = dd.dept_parent_benchmark_code " +
		"			) tmp where tmp.downer is not null and tmp.downer =  '" + userId + "' " +
		"		) or mm.initiator in ( " +
		"			select tmp.user_code from ( " +
		"			select (case when dd.dept_owner = cc.contact_employee_code then mm.dept_owner else dd.dept_owner end) as downer, " +
		"				tt.user_code " +
		"				from (select pp.initiator as user_code from dotp_pm_projects pp group by pp.initiator) tt " +
		"				left JOIN dotp_contacts cc on cc.contact_employee_code = tt.user_code " +
		"				LEFT JOIN dotp_departments dd on dd.dept_benchmark_code = cc.dept_benchmark_code " +
		"				left join dotp_departments mm on mm.dept_benchmark_code = dd.dept_parent_benchmark_code " +
		"			) tmp where tmp.downer is not null and tmp.downer =  '" + userId + "' " +
		"		) " +
		"	) gg  " +
		"		on pro_t.project_code = gg.project_code " +
		
		"	LEFT JOIN ( " +
		"		select pro_pmo.project_code " +
		"		from dotp_pm_projects pro_pmo " +
		"		where pro_pmo.proj_level = 3 " +
		"			and '" + deptCode + "' in ('DP08466','DP00281','DP08711','DP08712','DP09102','DP08829','DP12336','DP13132') " +
		"	) pmo " +
		"		ON pro_t.project_code = pmo.project_code " +

		"	LEFT JOIN ( " +
		"		select pro_pmo.project_code " +
		"		from dotp_pm_projects pro_pmo " +
		"		where pro_pmo.proj_level <> 3 or (pro_pmo.proj_level = 3 and pro_pmo.proj_type = 1) " +
		"			and '" + deptCode + "' = 'DP10556' " +
		"	) itpm " +
		"		ON pro_t.project_code = itpm.project_code " +

		"	LEFT JOIN ( " +
		"		select pro_pm.project_code " +
		"		from dotp_pm_projects pro_pm " +
		"		where pro_pm.pm_id1 = '" + userId + "' " +
		"			or pro_pm.initiator = '" + userId + "' " +
		"			or pro_pm.creator = '" + userId + "' " +
		"	) pm " +
		"		ON pro_t.project_code = pm.project_code " +

		"	LEFT JOIN ( " +
		"		select pro_it.project_code " +
		"		from dotp_pm_projects pro_it " +
		"		where pro_it.proj_type in (1, 3) " +
		"			and '" + deptCode + "' = 'DP10556' " +
		"	) ptype " +
		"		 ON pro_t.project_code = ptype.project_code " +

		"	LEFT JOIN ( " +
		"		select p.project_code " +
		"		from dotp_pm_project_check_records as r " +
		"		LEFT JOIN dotp_pm_projects_approve_list as l " +
		"			on r.wfs_id = l.wfs_id " +
		"		 and r.wfs_activityDefid = l.wfs_activityDefid " +
		"		LEFT JOIN dotp_pm_projects as p " +
		"			on r.project_code = p.project_code " +
		"		where r.check_status = '1' " +
		"			and l.approve_emp in ('" + userId + "', '" + deptCode + "') " +
		"	) wfs " +
		"		ON pro_t.project_code = wfs.project_code " +
		") v left join dotp_gh_projects g " +
   "  on v.project_id=g.project_id " +
	"	where v.deleted = 0 and ( " +
	"		v.pcode1 is not NULL " +
	"		or v.pcode2 is not NULL " +
	"		or v.pcode3 is not NULL " +
	"		or v.pcode4 is not NULL " +
	"		or v.pcode5 is not NULL " +
	"		or v.pcode6 is not NULL " +
	"	) and g.deleted=0  ";
    	//搜索项目名称
    	if(projName != null && !projName.equals("")) {
    		sql += " and v.proj_name like '%" + projName + "%' ";
    	}
    	sql += " order by v.create_time desc";
    	return sql;
    }
	/**
	 *  2015-11-04
	 *  Title:暂存查询
	 *  @param taskId
	 * */
    public static String getTask(String taskId){
    	StringBuffer buffer=new StringBuffer();
    	buffer.append(" SELECT ");
    	buffer.append(" t.id as id ,");
    	buffer.append(" tn5.label AS task_category_name,");
    	buffer.append(" t.task_category as task_category,");
    	buffer.append(" t.task_name as task_name ,");
    	buffer.append(" t.task_type as task_type ,");
    	buffer.append(" tn6.label as task_develop_language_name,");
    	buffer.append(" dc1.contact_order_by as task_owner_name,");
    	buffer.append(" t.task_loop_cycle as taskLoopCycle,");
    	buffer.append(" t.task_owner_id as task_owner_id,");
    	buffer.append(" dc.contact_order_by as contact_order_by,");
    	buffer.append(" dc.contact_email as taskProcesserEmail,");
    	buffer.append(" t.task_processer_id as task_processer_id ,");
    	buffer.append(" t.task_parent as task_parent,");
    	buffer.append(" t2.task_name as parentTaskName,");
//    	buffer.append(" t2.task_duration as all_child_dur,");
    	buffer.append(" CASE WHEN t.task_parent > 0 THEN ");
    	buffer.append(" ( ");
    	buffer.append(" SELECT t2.task_duration ");
    	buffer.append(" FROM dotp_tm_tasks t2  ");
    	buffer.append(" WHERE t2.id = t.task_parent ");
    	buffer.append(" ) ");
    	buffer.append(" ELSE - 1 ");
    	buffer.append("  END all_child_dur, ");
    	buffer.append(" t2.task_point AS taskRealPoint, ");
    	buffer.append(" t.task_deliverable as task_deliverable,");
    	buffer.append(" t.task_start_time as task_start_time ,");
    	buffer.append(" t.task_end_time as task_end_time,");
    	buffer.append(" t.task_duration as task_duration,");
    	buffer.append(" t.task_desc as task_desc,");
    	buffer.append(" t.task_status as task_status ,");
    	buffer.append(" t.task_create_time as task_create_time,");
    	buffer.append(" t.task_project as task_project,");
    	buffer.append(" t.task_point as task_point,");
    	buffer.append(" t.task_difficulty as task_difficulty,");
    	buffer.append(" t.task_is_landmarker as task_is_landmarker,");
    	buffer.append(" t.task_experience as task_experience,");
    	buffer.append(" t.user_demand_id as user_demand_id,");
    	buffer.append(" tn7.label as demand_category_name,");
    	buffer.append(" td.demand_name as demand_name,");
    	buffer.append(" td.user_demand_code as user_demand_code,");
    	buffer.append(" t.sys_demand_id as sys_demand_id,");
    	buffer.append(" di.sysdemandcode as sysdemandcode,");
    	buffer.append(" di.sys_version_code as sys_version_code,");
     	buffer.append(" ( ");
    	buffer.append(" CASE WHEN t.task_category = 1 THEN tn1.label ");
    	buffer.append(" WHEN t.task_category = 2 THEN tn2.label ");
    	buffer.append(" WHEN t.task_category = 3 THEN tn3.label ");
    	buffer.append(" WHEN t.task_category = 4 THEN tn4.label ");
    	buffer.append("	END ");
    	buffer.append(" ) task_type_name,");
    	buffer.append(" (");
    	buffer.append(" SELECT sum(t3.task_duration) ");
    	buffer.append(" FROM dotp_tm_tasks t3 ");
    	buffer.append(" WHERE ");
    	buffer.append(" t3.task_parent = t.task_parent ");
    	buffer.append(" ) AS taskSumDuration, ");
    	buffer.append("  dp.proj_name as taskProjectName, ");
    	buffer.append("  dp.code as projectCode, ");
    	buffer.append("  tn8.label as taskProjectType, ");
    	buffer.append(" t2.task_start_time as fuStartTime,");
    	buffer.append(" t2.task_end_time as fuEndTime,t.task_level,t.task_top_parent ");
    	// 任务查询新增问题风险字段
    	buffer.append(" ,t.risk_id riskId ");
    	buffer.append(" FROM");
    	buffer.append(" dotp_tm_tasks t");
    	buffer.append(" LEFT JOIN dotp_names tn1 ON tn1. NAME = 'task_type_1' AND tn1.VALUE= t.task_type ");
    	buffer.append(" LEFT JOIN dotp_names tn2 ON tn2. NAME = 'task_type_2' AND tn2.VALUE= t.task_type ");
    	buffer.append(" LEFT JOIN dotp_names tn3 ON tn3. NAME = 'task_type_3' AND tn3.VALUE= t.task_type ");
    	buffer.append(" LEFT JOIN dotp_names tn4 ON tn4. NAME = 'task_type_4' AND tn4.VALUE= t.task_type ");
    	buffer.append(" LEFT JOIN dotp_names tn5 ON tn5. NAME = 'task_category' AND tn5.VALUE= t.task_category ");
    	buffer.append(" LEFT JOIN dotp_names tn6 ON tn6. NAME = 'task_develop_language' AND tn5.VALUE= t.task_develop_language ");
    	buffer.append(" LEFT JOIN dotp_contacts dc ON dc.contact_employee_code = t.task_processer_id ");
    	buffer.append(" LEFT JOIN dotp_contacts dc1 ON dc1.contact_employee_code = t.task_owner_id ");
    	buffer.append(" LEFT JOIN dotp_dev_user_demand_info td ON td.demand_id = t.user_demand_id ");
    	buffer.append(" LEFT JOIN dotp_names tn7 ON tn7. NAME = 'demand_category' AND tn7.VALUE= td.demand_category ");
    	buffer.append(" LEFT JOIN dotp_dev_version_info di ON t.sys_demand_id = di.tid ");
    	buffer.append(" LEFT JOIN dotp_tm_tasks t2 ON t2.id=t.task_parent ");
    	buffer.append(" LEFT JOIN dotp_pm_projects dp on t.task_project=dp.AI_ID  ");
    	buffer.append(" LEFT JOIN dotp_names tn8 on tn8.name='gh_type' and tn8.value=dp.proj_type ");
    	buffer.append(" WHERE");
//    	buffer.append(" t.task_status = 1 AND ");
    	buffer.append("  t.id ="+taskId);
    	return buffer.toString();
    }
    
    
    /**
     * 资源计划部门人员占比(有子部门)
     * @param userId
     * @param date(yyyy-MM)
     * @return
     */
    public static String getDeptResourcesInfoSql(String userId,String date){
        StringBuffer sb=new StringBuffer();
            sb.append("SELECT ");
            sb.append("t3.localDeptSequence AS deptId, ");
            sb.append("t5.dept_benchmark_code AS deptBenchmarkCode, ");
            sb.append("t5.dept_name AS deptName, ");
            sb.append("SUM(t4.dept_all_peo) AS deptAllPeo, ");
            sb.append("SUM(t4.dept_manger_peo) AS deptMangerPeo, ");
            sb.append("SUM(t4.dept_m_pro_peo) AS deptMProPeo, ");
            sb.append("SUM(t4.dept_nom_pro_peo) AS deptNomProPeo, ");
            sb.append("SUM(t4.dept_pro_tasktime) AS deptProTasktime, ");
            sb.append("SUM(t4.dept_dem_tasktime) AS deptDemTasktime, ");
            sb.append("SUM(t4.dept_tran_tasktime) AS deptTranTasktime, ");
            sb.append("SUM(t4.dept_routine_tasktime) AS deptRoutineTasktime, ");
            sb.append("SUM(t4.dept_pro_point) AS deptProPoint, ");
            sb.append("SUM(t4.dept_dem_point) AS deptDemPoint, ");
            sb.append("SUM(t4.dept_tran_point) AS deptTranPoint, ");
            sb.append("SUM(t4.dept_routine_point) AS deptRoutinePoint, ");
            sb.append("SUM(t4.dept_salary_all) AS deptSalaryAll, ");
            sb.append("SUM(t4.dept_salary_m) AS deptSalarym, ");
            sb.append("SUM(t4.dept_salary_m_pro) AS deptSalarymPro, ");
            sb.append("SUM(t4.dept_salary_nom) AS deptSalaryNom, ");
            sb.append("SUM(t4.dept_salary_nom_pro) AS deptSalaryNomPro ");
            sb.append("FROM ");
            sb.append("dotp_dept_peo_and_worktime t4 ");
            sb.append("INNER JOIN ( ");
            sb.append("SELECT ");
            sb.append("@localDeptStrLen := LENGTH(t2.dept_sequence) AS subDeptSequenceLen, ");
            sb.append("@fristStrLen := LOCATE( ");
            sb.append("'.', ");
            sb.append("t1.dept_sequence ,@localDeptStrLen + 1 ");
            sb.append(") fristStrLen, ");
            sb.append("SUBSTRING( ");
            sb.append("t1.dept_sequence ,@localDeptStrLen + 1 ,@fristStrLen - @localDeptStrLen - 1 ");
            sb.append(") AS localDeptSequence, ");
            sb.append("t1.dept_id, ");
            sb.append("t1.dept_benchmark_code, ");
            sb.append("t1.dept_sequence ");
            sb.append("FROM ");
            sb.append("dotp_departments t1 ");
            sb.append("INNER JOIN ( ");
            sb.append("SELECT ");
            sb.append("dept_sequence ");
            sb.append("FROM ");
            sb.append("dotp_departments ");
            sb.append("WHERE ");
            sb.append("dept_owner = '"+ userId +"' ");
            sb.append("AND dept_state = 0 ");
            sb.append(") t2 ON t1.dept_sequence <> t2.dept_sequence ");
            sb.append("AND locate( ");
            sb.append("t2.dept_sequence, ");
            sb.append("t1.dept_sequence ");
            sb.append(") > 0 ");
            sb.append("AND t1.dept_state = 0 ");
            sb.append(") t3 ON t4.dept_benchmark_code = t3.dept_benchmark_code ");
            sb.append("AND t4.dept_sta_date = '" + date + "' ");
            sb.append("LEFT JOIN dotp_departments t5 ON t3.localDeptSequence = t5.dept_id ");
            sb.append("GROUP BY ");
            sb.append("t3.localDeptSequence ");
        return sb.toString();
    }
    
    /**
     * 资源计划部门人员占比(无子部门)
     * @param userId
     * @param date(yyyy-MM)
     * @return
     */
    public static String getPeoResourcesInfoSql(String userId,String date){
        StringBuffer sb= new StringBuffer();
            sb.append("SELECT ");
            sb.append("t3.contact_employee_code AS empCode, ");
            sb.append("t5.task_category AS taskCategory, ");
            sb.append("t3.contact_order_by AS empName, ");
            sb.append("t3.contact_employee_level AS empLevel, ");
            sb.append("ISNULL(t7.user_code) AS inProject, ");
            sb.append("SUM( ");
            sb.append("IF ( ");
            sb.append("ISNULL(t5.task_duration), ");
            sb.append("0, ");
            sb.append("t5.task_duration ");
            sb.append(") ");
            sb.append(") AS taskDuration, ");
            sb.append("SUM( ");
            sb.append("IF ( ");
            sb.append("ISNULL(t5.task_point), ");
            sb.append("0, ");
            sb.append("t5.task_point ");
            sb.append(") ");
            sb.append(") AS taskPoint ");
            sb.append("FROM ");
            sb.append("dotp_contacts t3 ");
            sb.append("INNER JOIN ( ");
            sb.append("SELECT ");
            sb.append("dept_benchmark_code ");
            sb.append("FROM ");
            sb.append("dotp_contacts ");
            sb.append("WHERE ");
            sb.append("contact_employee_code = '" + userId + "' ");
            sb.append(") t4 ON t3.dept_benchmark_code = t4.dept_benchmark_code ");
            sb.append("AND contact_status = 1 ");
            sb.append("LEFT JOIN ( ");
            sb.append("SELECT ");
            sb.append("task_category, ");
            sb.append("task_processer_id, ");
            sb.append("task_duration, ");
            sb.append("IF ( ");
            sb.append("ISNULL(task_point), ");
            sb.append("0, ");
            sb.append("task_point ");
            sb.append(") AS task_point, ");
            sb.append("task_start_time, ");
            sb.append("task_end_time ");
            sb.append("FROM ");
            sb.append("dotp_tm_tasks ");
            sb.append("WHERE ");
            sb.append("task_status IN (2, 3, 5, 6, 7) ");
            sb.append("AND task_is_delete = 0 ");
            sb.append("AND task_category <> - 1 ");
            sb.append("AND task_is_leaf = 1 ");
            sb.append("AND task_start_time >= '"+ date +"-01' ");
            sb.append("AND task_end_time <= last_day('"+ date +"-01') ");
            sb.append(") t5 ON t3.contact_employee_code = t5.task_processer_id ");
            sb.append("LEFT JOIN ( ");
            sb.append("SELECT ");
            sb.append("user_code ");
            sb.append("FROM ");
            sb.append("dotp_pm_project_org_all ");
            sb.append("WHERE ");
            sb.append("join_time <= curdate() ");
            sb.append("AND leave_time >= curdate() ");
            sb.append("AND internal = 1 ");
            sb.append("GROUP BY ");
            sb.append("user_code ");
            sb.append(") t7 ON t3.contact_employee_code = t7.user_code ");
            sb.append("GROUP BY ");
            sb.append("t3.contact_employee_code, ");
            sb.append("t5.task_category ");
        return sb.toString();
    }
    
   /**
    * 根据工号判断有无子部门
    * @param userId
    */
    public static String getSubDeptCount(String userId){
        StringBuffer sb = new StringBuffer();
            sb.append("SELECT ");
            sb.append("count(t1.dept_id) AS isDeptm ");
            sb.append("FROM ");
            sb.append("dotp_departments t1 ");
            sb.append("LEFT JOIN dotp_departments t2 ON t2.dept_parent_benchmark_code = t1.dept_benchmark_code ");
            sb.append("AND t2.dept_state = 0 ");
            sb.append("WHERE ");
            sb.append("t1.dept_owner = " + "'" + userId + "'");
            sb.append("AND t1.dept_state = 0 ");
        return sb.toString();
    }
    
    /**
     * 有UserID查询所属部门对应的统计信息
     * @param userId
     * @return
     */
    public static String getDeptStaInfoSql(String userId,String dateStr){
        StringBuffer sb = new StringBuffer();
            sb.append("SELECT ");
            sb.append("t2.dept_benchmark_code AS deptBenchmarkCode, ");
            sb.append("t2.dept_all_peo AS deptAllPeo, ");
            sb.append("t2.dept_manger_peo AS deptMangerPeo, ");
            sb.append("t2.dept_m_pro_peo AS deptMProPeo, ");
            sb.append("t2.dept_nom_pro_peo AS deptNomProPeo, ");
            sb.append("t2.dept_pro_tasktime AS deptProTasktime, ");
            sb.append("t2.dept_dem_tasktime AS deptDemTasktime, ");
            sb.append("t2.dept_tran_tasktime AS deptTranTasktime, ");
            sb.append("t2.dept_routine_tasktime AS deptRoutineTasktime, ");
            sb.append("t2.dept_pro_point AS deptProPoint, ");
            sb.append("t2.dept_dem_point AS deptDemPoint, ");
            sb.append("t2.dept_tran_point AS deptTranPoint, ");
            sb.append("t2.dept_routine_point AS deptRoutinePoint, ");
            sb.append("t2.dept_salary_all AS deptSalaryAll, ");
            sb.append("t2.dept_salary_m AS deptSalarym, ");
            sb.append("t2.dept_salary_m_pro AS deptSalarymPro, ");
            sb.append("t2.dept_salary_nom AS deptSalaryNom, ");
            sb.append("t2.dept_salary_nom_pro AS deptSalaryNomPro ");
            sb.append("FROM ");
            sb.append("dotp_contacts t1 ");
            sb.append("INNER JOIN dotp_dept_peo_and_worktime t2 ");
            sb.append("ON t1.dept_benchmark_code = t2.dept_benchmark_code ");
            sb.append("WHERE ");
            sb.append("contact_status = 1 ");
            sb.append("AND contact_employee_code = '"+userId+"' ");
            sb.append("AND dept_sta_date = '"+dateStr+"' ");
        return sb.toString();
    }
 
	 /**
	  * 根据项目编码获取问题风险任务可分配工时
	  * 
	  * @param userId
	  * @return
	  */
	 public static String getAssignableHour(String projCode){
		 // sql
	     StringBuffer sb = new StringBuffer();
	         sb.append("SELECT (select task_duration from dotp_tm_tasks ");
	         sb.append("where task_project = " + projCode);
	         sb.append(" and task_type= -1 and task_is_delete = 0) ");
	         sb.append("- (SELECT sum(task_duration) from dotp_tm_tasks where ");
	         sb.append(" task_is_delete=0 and task_parent = ( ");
	         sb.append(" SELECT id from dotp_tm_tasks where task_project = "+ projCode);
	         sb.append(" and task_type= -1 and task_is_delete = 0)) assignableHour from DUAL ");
	     // 返回
	     return sb.toString();
	 }
	 
	/**
	 * 更新风险状态 解决中 or 已关闭
	 * 
	 * @param state
	 * @param stateCode
	 * @param riskId
	 * @return
	 */
	 public static String updateRiskState(String state, String stateCode, String riskId){
		 // sql
	     StringBuffer sb = new StringBuffer();
	         sb.append(" update dotp_risk set state= '" + state +"' ,state_code = " + stateCode);
	         if("5".equals(stateCode)){
	        	 sb.append(" ,finish_date=CURDATE() ");
	         }
	         sb.append(" where id = " + riskId);
	     // 返回
	     return sb.toString();
	 }
    
}

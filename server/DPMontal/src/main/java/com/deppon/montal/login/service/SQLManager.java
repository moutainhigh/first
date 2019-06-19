package com.deppon.montal.login.service; 

import com.deppon.montal.conf.F_Constants;
   /** 
 * @Title: SqlManager.java
 * @Package com.deppon.montal.module.notice.service 
 * @Description: (SQL语句管理类) 
 * @author 廖建雄 
 * @date 2013-2-21 下午3:51:46 
 * @version V1.0 
 */
public class SQLManager {
	
	//查询所有用户的信息
	public static final String QUERY_ALL_EMPLOYEE = "select op.userid,emp.empid, op.operatorname, op.password ,emp.jobname from ac_operator op,om_employee emp where op.userid = emp.userid and emp.empstatus = 'on' order by op.userid";
	//查询所有dpmon_role_jobname
	public static final String QUERY_ALL_ROLEJOBNAME = "select ID,JOBNAME from dpmon_role_jobname rjb";
	//查询所有dpmon_employee
	public static final String QUERY_ALL_DPMONEMPLOYEE = "select ID,USERID,USERNAME,SYSCODES from dpmon_employee emp";
	//查询所有dpmon_workflow
	public static final String QUERY_ALL_DPMONWORKFLOW = "SELECT id, workflowname, syscode,jspname,createtime,classname,entryProperty FROM dipoa.dpmon_workflow  WHERE isdelete = '0'";	
	//查询所有eos_dict_entry
	public static final String QUERY_ALL_DICTENTRY = "select dicttypeid,dictid,dictname,rank,seqno,sortno from dipoa.eos_dict_entry";	
    
	//验证工号和密码
	public static final String PASSWORD_LOGIN_CHECK = ""+
	        " select op.userid,emp.empid, op.operatorname, op.password ,emp.jobname "+
            " from ac_operator op,om_employee emp where op.userid = emp.userid "+
			" and emp.userid = ?";
	
	//验证登陆权限(ALL表示所有人都可以)
    public static final String VALIDATE_LOGIN_ROLE=""+
    		   " select id from dpmon_role_jobname rjb where (rjb.jobname = ? or rjb.jobname = 'ALL')"+
    		   " union all "+
    		   " select id from dpmon_employee demp where demp.userid = ? ";
    		
	
    /**
	//查询代办计数(包含最新的6.6平台)
	public static final String QUERY_WORKFLOW_COUNT =" "+
    		" select sum(taskcount) taskcount from (" +
			" select count(1) taskcount from ( "+
    		" select A.PROCESSINSTID PROCESSINSTID, "+
    		"      B.CREATETIME, "+       
    		"      B.PROCESSINSTNAME, "+
    		"      B.processdefname FLOWTYPE "+
    		" from (select t.*, 0 witype "+
    		"         from WFWORKITEM t "+
    		"        where t.currentstate = 10 "+
    		"          and t.participant = ? "+
    		"       union all "+
    		"       select t.*, 0 witype "+
    		"         from WFWORKITEM t "+
    		"        where t.currentstate = 4 "+
    		"          and ? in (select participantid "+
    		"                             from WFWIParticipant a "+
    		"                            where a.workitemid = t.workitemid)) b "+
    		" inner join OA_APPLYINFO a "+
    		"   on a.processinstid = b.processinstid "+
    		"  and a.condition != 1 "+
    		"  and a.condition != 6 order by B.CREATETIME )s where s.FLOWTYPE in (?)" + 
    		"  union all "+
    		" select count(1) taskcount from ( "+
    		" select A.PROCESSINSTID PROCESSINSTID, "+
    		"      B.CREATETIME, "+       
    		"      B.PROCESSINSTNAME, "+
    		"      B.processdefname FLOWTYPE "+
    		" from (select t.*, 0 witype "+
    		"         from WFWORKITEM@LINK_BPSDB t "+
    		"        where t.currentstate = 10 "+
    		"          and t.participant = ? "+
    		"       union all "+
    		"       select t.*, 0 witype "+
    		"         from WFWORKITEM@LINK_BPSDB t "+
    		"        where t.currentstate = 4 "+
    		"          and ? in (select participantid "+
    		"                             from WFWIParticipant a "+
    		"                            where a.workitemid = t.workitemid)) b "+
    		" inner join t_bpms_applyinfo@LINK_BPSDB a "+
    		"   on a.processinstid = b.processinstid "+
    		"  and a.condition != 1 "+
    		"  and a.condition != 6 order by B.CREATETIME )s where s.FLOWTYPE in (?,?))sb ";
    **/
	//查询代办计数(包含最新的6.6平台)
	public static String getQueryWFCount(String syscodes){
//		if(null == syscodes){
//			syscodes = "DIPOA,FSSC,DLSP,DWFS,ICRM,FINS,INHR";
//		}
		return " select sum(taskcount) taskcount from (" +
				" select count(1) taskcount from ( "+
	    		" select A.PROCESSINSTID PROCESSINSTID, "+
	    		"      B.CREATETIME, "+       
	    		"      B.PROCESSINSTNAME, "+
	    		"      B.processdefname FLOWTYPE "+
	    		" from (select t.*, 0 witype "+
	    		"         from WFWORKITEM t "+
	    		"        where t.currentstate = 10 "+
	    		"          and t.participant = ? "+
	    		"       union all "+
	    		"       select t.*, 0 witype "+
	    		"         from WFWORKITEM t "+
	    		"        where t.currentstate = 4 "+
	    		"          and ? in (select participantid "+
	    		"                             from WFWIParticipant a "+
	    		"                            where a.workitemid = t.workitemid)) b "+
	    		" inner join OA_APPLYINFO a "+
	    		"   on a.processinstid = b.processinstid "+
	    		"  and a.condition != 1 "+
//	    		"  and a.condition != 6 order by B.CREATETIME )s where s.FLOWTYPE in ("+(syscodes.indexOf(F_Constants.DIPOA_WORKFLOW_SYSCODE)==-1?"''":F_Constants.ALL_WORKFLOW_TYPES)+") "+
	    		"  and a.condition != 6 order by B.CREATETIME )s where s.FLOWTYPE in ("+ F_Constants.ALL_WORKFLOW_TYPES +") "+
	    		"  union all "+
	    		" select count(1) taskcount from ( "+
	    		" select A.PROCESSINSTID PROCESSINSTID, "+
	    		"      B.CREATETIME, "+       
	    		"      B.PROCESSINSTNAME, "+
	    		"      B.processdefname FLOWTYPE "+
	    		" from (select t.*, 0 witype "+
	    		"         from WFWORKITEM@LINK_BPSDB t "+
	    		"        where t.currentstate = 10 "+
	    		"          and t.participant = ? "+
	    		"       union all "+
	    		"       select t.*, 0 witype "+
	    		"         from WFWORKITEM@LINK_BPSDB t "+
	    		"        where t.currentstate = 4 "+
	    		"          and ? in (select participantid "+
	    		"                             from WFWIParticipant@LINK_BPSDB a "+
	    		"                            where a.workitemid = t.workitemid)) b "+
	    		" inner join t_bpms_applyinfo@LINK_BPSDB a "+
	    		"   on a.processinstid = b.processinstid "+
	    		"  and a.condition != 1 "+
//	    		"  and a.condition != 6 order by B.CREATETIME )s where s.FLOWTYPE in ("+(syscodes.indexOf(F_Constants.FSSC_WORKFLOW_SYSCODE)==-1?"''":F_Constants.ALL_WORKFLOW_TYPES_FSSC)+
//	    		","+(syscodes.indexOf(F_Constants.DLSP_WORKFLOW_SYSCODE)==-1?"''":F_Constants.ALL_WORKFLOW_TYPES_LSP)+
//	    		","+(syscodes.indexOf(F_Constants.DWFS_WORKFLOW_SYSCODE)==-1?"''":F_Constants.ALL_WORKFLOW_TYPES_DWFS)+
//	    		","+(syscodes.indexOf(F_Constants.CRM_WORKFLOW_SYSCODE)==-1?"''":F_Constants.ALL_WORKFLOW_TYPES_ICRM)+
//	    		"," + (syscodes.indexOf(F_Constants.FIN_SELF_WORKFLOW_SYSCODE) == -1 ? "''" : F_Constants.ALL_WORKFLOW_TYPES_FIN_SELF)+
//	    		"," + (syscodes.indexOf(F_Constants.HR_WORKFLOW_SYSCODE) == -1 ? "''" : F_Constants.ALL_WORKFLOW_TYPES_HR) +
				"  and a.condition != 6 order by B.CREATETIME )s where s.FLOWTYPE in ("+F_Constants.ALL_WORKFLOW_TYPES_FSSC+
				","+ F_Constants.ALL_WORKFLOW_TYPES_LSP +","+ F_Constants.ALL_WORKFLOW_TYPES_DWFS+","+ F_Constants.ALL_WORKFLOW_TYPES_ICRM+
				"," + F_Constants.ALL_WORKFLOW_TYPES_FIN_SELF +"," + F_Constants.ALL_WORKFLOW_TYPES_HR +"," + F_Constants.ALL_WORKFLOW_TYPES_WDGH + "," + F_Constants.ALL_WORKFLOW_TYPES_ACMS + "))sb ";
		}
	
	/***首页显示滚动新闻*/
	public static final String QUERY_ROLLNEWS_SQL =" "+
			" select * from (                                                "+
			" select ggid, lmid, header, file_new_name, v.ckbh               "+
			"  from (select *                                                "+
			"          from (select gg.ggid, gg.lmid,                        "+
			"                       gg.header, gg.savedate, obc.ckbh         "+
			"                  from oa_gg gg                                 "+
			"                  left join (select *                           "+
			"                              from dipoa.oa_bulletin_click obc  "+
			"                             where obc.ckempid = ?) obc         "+
			"                    on gg.ggid = obc.ggid                       "+
			"                 inner join oa_gglm gglm                        "+
			"                    on gg.lmid = gglm.lmid                      "+
			"                 where gg.lmid = 25                             "+
			"                 order by gg.savedate desc)                     "+
			"         where rownum < 10) v                                   "+
			"  left join at_fileupload f                                     "+
			"    on v.ggid = f.relation_id(+)                                "+
			"   and f.group_id = 'rollPaper'                                 "+
			" where f.file_new_name is not null                              "+
			" order by v.savedate desc)s                                     "+
			" where rownum <= ? ";
	
	/**消息推送：查询人员新增待办数量
	 * @param endTime **/
	public static String getPendingNUM(String users,String date, String endTime){
		return "SELECT BB.PARTICIPANT, COUNT(1) AS NUM FROM (" +
				"SELECT PARTICIPANT,PROCESSINSTID,PARTICIPANT AS AGENTTO,T.WORKITEMID,T.ACTIVITYDEFID,T.STARTTIME " +
				"FROM BPSDB.WFWORKITEM T " +
				"WHERE T.CURRENTSTATE = 10 " +
				"AND T.STARTTIME <= to_date('"+endTime+"','yyyy-MM-dd hh24:mi:ss') "+
				"AND T.STARTTIME > to_date('"+date+"','yyyy-MM-dd hh24:mi:ss') "+
				"AND T.ACTIVITYDEFID != 'Drafter' " +
				"AND t.PARTICIPANT IN ("+users+") " +
				"UNION " +
				"SELECT T.PARTICIPANT,T.PROCESSINSTID,M.AGENTTO,T.WORKITEMID,T.ACTIVITYDEFID,T.STARTTIME " +
				"FROM BPSDB.WFWORKITEM T, BPSDB.WFAGENT M " +
				"WHERE T.CURRENTSTATE = 10 " +
				"AND T.PARTICIPANT = M.AGENTFROM " +
				"AND M.STARTTIME < SYSDATE " +
				"AND M.ENDTIME > SYSDATE " +
				"AND T.STARTTIME <= to_date('"+endTime+"','yyyy-MM-dd hh24:mi:ss') "+
				"AND T.STARTTIME > to_date('"+date+"','yyyy-MM-dd hh24:mi:ss') "+
				"AND T.ACTIVITYDEFID != 'Drafter' " +
				"AND m.AGENTTO IN ("+users+") " +
				
				"UNION " +
				"SELECT A.PARTICIPANTID,T.PROCESSINSTID,A.PARTICIPANTID AS AGENTTO,T.WORKITEMID,T.ACTIVITYDEFID,T.STARTTIME " +
				"FROM BPSDB.WFWIPARTICIPANT A, BPSDB.WFWORKITEM T " +
				"WHERE A.WORKITEMID = T.WORKITEMID " +
				"AND T.CURRENTSTATE = 4 AND T.STARTTIME <= to_date('"+endTime+"','yyyy-MM-dd hh24:mi:ss') "+
				"AND T.STARTTIME > to_date('"+date+"','yyyy-MM-dd hh24:mi:ss') "+
				"AND T.ACTIVITYDEFID != 'Drafter' " +
				"AND a.PARTICIPANTID IN ("+users+") " +
				"UNION " +
				"SELECT DISTINCT T.PARTICIPANT,T.PROCESSINSTID,M.AGENTTO,T.WORKITEMID,T.ACTIVITYDEFID,T.STARTTIME " +
				"FROM (SELECT M.AGENTFROM, M.AGENTTO FROM BPSDB.WFAGENT M WHERE M.STARTTIME < SYSDATE AND M.ENDTIME > SYSDATE) M," +
				"(SELECT T.PARTICIPANT,T.PROCESSINSTID,T.WORKITEMID,P.PARTICIPANTID,T.ACTIVITYDEFID,T.STARTTIME " +
				"FROM BPSDB.WFWORKITEM T INNER JOIN BPSDB.WFWIPARTICIPANT P ON T.WORKITEMID = P.WORKITEMID WHERE T.CURRENTSTATE = 4) T " +
				"WHERE M.AGENTFROM = T.PARTICIPANTID " +
				"AND T.STARTTIME <= to_date('"+endTime+"','yyyy-MM-dd hh24:mi:ss') "+
				"AND T.STARTTIME > to_date('"+date+"','yyyy-MM-dd hh24:mi:ss') "+
				"AND T.ACTIVITYDEFID != 'Drafter' " +
				"AND M.AGENTTO IN ("+users+") " +
				") BB GROUP BY BB.PARTICIPANT";
	}
	/**
	 * 
	* @MethodName: queryAllWFCount 
	* @description : 查询移动手机端工作流待办数量
	* @author：caibingbing 
	* @date： 2014-8-25 上午11:14:02
	* @param users
	* @return String
	 */
	public static String queryAllWFCount(String users){
		//添加userId 非空校验 
    	if(users == null || "".equals(users)){
    		System.out.println("==================登录用户工号为空。userid="+users);
    		users = " = ''";
    	}else if(users.indexOf("'") == -1){
    		/**登录 查询人员待办数*/
    		users = " = '"+users+"'";
    	}else{
    		/**查询人员待办总数*/
    		users = " in ("+users+")";
    	}
		
		
		String processdefname = F_Constants.ALL_WORKFLOW_TYPES_FSSC+
				","+ F_Constants.ALL_WORKFLOW_TYPES_LSP +","+ F_Constants.ALL_WORKFLOW_TYPES_DWFS+","+ F_Constants.ALL_WORKFLOW_TYPES_ICRM+
				"," + F_Constants.ALL_WORKFLOW_TYPES_FIN_SELF +"," + F_Constants.ALL_WORKFLOW_TYPES_HR +"," + F_Constants.ALL_WORKFLOW_TYPES_WDGH + "," + F_Constants.ALL_WORKFLOW_TYPES_ACMS;
		String sql = 
		"SELECT BB.PARTICIPANT, COUNT(1) AS NUM " +
		" FROM (SELECT T.PARTICIPANT," +
		" T.PROCESSINSTID," +
		" T.PARTICIPANT AS AGENTTO," +
		" T.WORKITEMID," +
		" T.ACTIVITYDEFID," +
		" T.STARTTIME " +
		" FROM bpsdb.WFWORKITEM T " +
		" inner join bpsdb.t_bpms_applyinfo a on a.processinstid = t.processinstid " +
		" WHERE T.ACTIVITYDEFID != 'Drafter' " +
		" and a.iseffective = 1 " +
		" and a.condition in (2, 3) " +
		" and a.processdefname in ("+ processdefname +") " +
		" AND t.PARTICIPANT "+ users +" " +
		" AND T.CURRENTSTATE = 10 " +
		" UNION " +
		" SELECT A.PARTICIPANTID," +
		" T.PROCESSINSTID," +
		" A.PARTICIPANTID AS AGENTTO," +
		" T.WORKITEMID," +
		" T.ACTIVITYDEFID," +
		" T.STARTTIME " +
		" FROM bpsdb.WFWIPARTICIPANT A, bpsdb.WFWORKITEM T " +
		" inner join bpsdb.t_bpms_applyinfo o on o.processinstid = t.processinstid " +
		"WHERE A.WORKITEMID = T.WORKITEMID " +
		" AND T.ACTIVITYDEFID != 'Drafter' " +
		" AND o.iseffective = 1 " +
		" and o.condition in (2, 3) " +
		" and o.processdefname in ("+ processdefname +") " +
		" AND T.CURRENTSTATE = 4 " +
		" AND a.PARTICIPANTID  "+ users +") BB " +
		"GROUP BY BB.PARTICIPANT";
		return sql;
	}
}


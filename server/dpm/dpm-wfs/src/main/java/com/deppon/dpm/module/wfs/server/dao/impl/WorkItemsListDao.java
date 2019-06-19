package com.deppon.dpm.module.wfs.server.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.deppon.dpm.module.common.server.util.ParamUtils;
import com.deppon.dpm.module.wfs.server.dao.IWorkItemsListDao;
import com.deppon.dpm.module.wfs.server.util.F_Constants;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowInfo;
import com.deppon.dpm.module.wfs.shared.dto.WorkItemsDto;
import com.deppon.dpm.module.wfs.shared.vo.OaWorkItem;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 
 * 工作流列表dao
 * 
 * @author 195406 高春玲
 * @date 2015-3-20 下午1:45:08
 * @since
 **/
public class WorkItemsListDao extends iBatis3DaoImpl implements IWorkItemsListDao {
	private Logger logger = LoggerFactory.getLogger(WorkItemsListDao.class);

	private JdbcTemplate template;

//	public JdbcTemplate getTemplate() {
//		return template;
//	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
    /**
     * 获得工作流列表 
     * 根据当前审批人工号获得审批人自己和代理审批的工作流
     */
	@Override
	public List<OaWorkItem> workitemslist(WorkItemsDto dto) {
		String userId = dto.getUserId();
		if(ParamUtils.checkUserId(userId)){
			logger.error("工号错误，不符合规范");
		}
		//当前审批人代理的审批人工号
		List<String> agentFrom = this.template.queryForList(
				"SELECT t.agentfrom FROM dipoa.wfagent t WHERE t.agentto='"
						+ userId
						+ "' and t.starttime < sysdate and t.endtime > sysdate",
				String.class);
		String userIds = "";
		int size = agentFrom.size();
		if (size > 0) {
			StringBuilder builder = new StringBuilder();
			for (String agent : agentFrom) {
				builder.append("'").append(agent).append("',");
			}
			String string = builder.toString();
			userIds = string.substring(0, string.length() - 1);
		}

		StringBuilder builder = new StringBuilder();

		builder.append("SELECT bb.PROCESSINSTID, bb.CREATETIME,BB.STARTTIME,  bb.DEPARTMENT, bb.APPLER, bb.PROCESSINSTNAME,");
		builder.append("bb.WORKITEMID, bb.BUSINO, bb.FLOWTYPE, bb.ACTIVITYDEFID, bb.ACTIVITYINSTID, bb.SYSCODE,bb.AGENTSTASTUS,d.jspname");
		builder.append(" FROM (SELECT A.PROCESSINSTID PROCESSINSTID,");
		builder.append("A.APPDATE CREATETIME,");
		builder.append("A.DEPARTMENT DEPARTMENT,");
		builder.append("A.APPLER APPLER,");
		builder.append("DECODE(A.SYSCODE,");
		builder.append("'FSSC',");
		builder.append("(B.CATALOGNAME || '-' || B.PROCESSINSTNAME),");
		builder.append("B.PROCESSINSTNAME) PROCESSINSTNAME,");
		builder.append("B.WORKITEMID,");
		builder.append("A.BUSINO,");
		builder.append("B.PROCESSDEFNAME FLOWTYPE,");
		builder.append("B.ACTIVITYDEFID,");
		builder.append("B.ACTIVITYINSTID,");
		builder.append("b.starttime starttime,");
		builder.append("A.SYSCODE,");
		builder.append("CASE WHEN B.PARTICIPANT='" + userId + "'");
		builder.append(" THEN 1 ELSE 0 END AS AGENTSTASTUS");//代理审批 0
		builder.append(" FROM BPSDB.WFWORKITEM B");
		builder.append(" INNER JOIN BPSDB.T_BPMS_APPLYINFO A");
		builder.append(" ON A.PROCESSINSTID = B.PROCESSINSTID");
		builder.append(" WHERE B.ACTIVITYDEFID != 'Drafter'");
		builder.append(" AND A.ISEFFECTIVE = 1");
		builder.append(" AND A.CONDITION IN (2, 3)");
		builder.append(" AND A.PROCESSDEFNAME IN" + " (");
		builder.append(dto.getProcessType());
		builder.append(")");
		if (size > 0) {
			builder.append(" AND (B.PARTICIPANT = '");
			builder.append(userId);
			builder.append("'");
			builder.append(" or B.PARTICIPANT in (");
			builder.append(userIds);
			builder.append("))");
		} else {
			builder.append(" AND B.PARTICIPANT = '");
			builder.append(userId);
			builder.append("'");
		}

		builder.append(" AND B.CURRENTSTATE = 10");
		builder.append(" UNION");
		builder.append(" SELECT A.PROCESSINSTID PROCESSINSTID,");
		builder.append(" A.APPDATE CREATETIME,");
		builder.append(" A.DEPARTMENT DEPARTMENT,");
		builder.append(" A.APPLER APPLER,");
		builder.append(" DECODE(A.SYSCODE,");
		builder.append("'FSSC',");
		builder.append("(B.CATALOGNAME || '-' || B.PROCESSINSTNAME),");
		builder.append("B.PROCESSINSTNAME) PROCESSINSTNAME,");
		builder.append(" B.WORKITEMID,");
		builder.append(" A.BUSINO,");
		builder.append(" B.PROCESSDEFNAME FLOWTYPE,");
		builder.append(" B.ACTIVITYDEFID,");
		builder.append(" B.ACTIVITYINSTID,");
		builder.append("b.starttime starttime,");
		builder.append(" A.SYSCODE,");
		builder.append(" CASE WHEN WI.PARTICIPANTID='" + userId + "'");
		builder.append(" THEN 1 ELSE 0 END AS AGENTSTASTUS");
		builder.append(" FROM BPSDB.WFWIPARTICIPANT WI, BPSDB.WFWORKITEM B");
		builder.append(" INNER JOIN BPSDB.T_BPMS_APPLYINFO A");
		builder.append(" ON A.PROCESSINSTID = B.PROCESSINSTID");
		builder.append(" WHERE WI.WORKITEMID = B.WORKITEMID");
		builder.append(" AND B.ACTIVITYDEFID != 'Drafter'");
		builder.append(" AND A.ISEFFECTIVE = 1");
		builder.append(" AND A.CONDITION IN (2, 3)");
		builder.append(" AND A.PROCESSDEFNAME IN");
		builder.append("(");
		builder.append(dto.getProcessType());
		builder.append(")");
		builder.append(" AND B.CURRENTSTATE = 4");

		// builder.append(" AND WI.PARTICIPANTID = '");
		// builder.append(dto.getUserId());

		if (size > 0) {
			builder.append(" AND (WI.PARTICIPANTID = '");
			builder.append(userId);
			builder.append("'");
			builder.append(" or WI.PARTICIPANTID in (");
			builder.append(userIds);
			builder.append("))");
		} else {
			builder.append(" AND WI.PARTICIPANTID = '");
			builder.append(userId);
			builder.append("'");
		}

		builder.append(") BB left join dipoa.dpmon_workflow d on bb.flowtype=d.workflowname where d.isdelete = 0");
		builder.append(" ORDER BY BB.STARTTIME ASC");
		String sql = builder.toString();

//		logger.info(sql);

		List<OaWorkItem> oaWorkItemList = this.template.query(sql,
				new RowMapper<OaWorkItem>() {

					@Override
					public OaWorkItem mapRow(ResultSet rs, int arg1)
							throws SQLException {
						OaWorkItem info = new OaWorkItem();
						info.setProcessinstid(rs.getBigDecimal("processinstid"));
						info.setProcessinstname(rs.getString("processinstname"));
						info.setCreatetime(rs.getTimestamp("createtime"));
						//流到下个审批人的时间
						info.setStarttime(rs.getTimestamp("starttime"));
						info.setAppler(rs.getString("appler"));
						info.setDepartment(rs.getString("department"));
						info.setFlowtype(rs.getString("flowtype"));
						info.setSyscode(rs.getString("syscode"));
						info.setWorkitemid(rs.getBigDecimal("workitemid"));
						info.setBusino(rs.getString("busino"));
						info.setActivitydefid(rs.getString("activitydefid"));
						info.setActivityinstid(rs
								.getBigDecimal("activityinstid"));
						info.setJspname(rs.getString("jspname"));
						info.setAgentStatus(rs.getString("agentstastus"));
						return info;
					}

				});
		return oaWorkItemList;

	}
	/**
	 * 获取所有移动端迁移审批工作流
	 */
	@Override
	public List<WorkflowInfo> queryAllWorkInfo() {
		/*
		 * return this.getSqlSession().selectList(NAMESPACE +
		 * "queryAllWorkFlow");
		 */
		String sql = "SELECT id, workflowname, syscode,jspname,createtime,classname,entryProperty FROM dipoa.dpmon_workflow  WHERE isdelete = ?";
		List<WorkflowInfo> workInfoList = this.template.query(sql,
				new String[] { "0" }, new RowMapper<WorkflowInfo>() {

					@Override
					public WorkflowInfo mapRow(ResultSet rs, int arg1)
							throws SQLException {
						WorkflowInfo info = new WorkflowInfo();
						info.setId(rs.getString("id"));
						info.setWorkflowname(rs.getString("workflowname"));
						info.setSyscode(rs.getString("syscode"));
						info.setJspname(rs.getString("jspname"));
						info.setCreatetime(rs.getDate("createtime"));
						info.setClassName(rs.getString("classname"));
						info.setEntryProperty(rs.getString("entryProperty"));
						return info;
					}

				});
		this.logger.info(workInfoList.size() + "=============");
		return workInfoList;
	}
    /**
     * 根据工作流流程定义id获得工作流名称 (报错预警使用)
     * 7.1 gcl
     */
	@Override
	public WorkflowInfo queryWorkInfo(String workflowname) {

		String sql = "select w.processchname FROM (SELECT w.processchname,w.processdefname,ROW_NUMBER() OVER (PARTITION BY w.processdefname ORDER BY w.currentstate DESC) RN FROM BPSDB.WFPROCESSDEFINE w ) w WHERE RN=1 AND  W.PROCESSDEFNAME = ?";
		List<WorkflowInfo> workInfoList = template.query(sql, new String[] {workflowname }, new RowMapper<WorkflowInfo>() {

			@Override
			public WorkflowInfo mapRow(ResultSet rs, int arg1)
					throws SQLException {
				WorkflowInfo info = new WorkflowInfo();
				info.setWorkflowname(rs.getString("processchname"));
				return info;
			}
		});
		if (workInfoList != null && workInfoList.size() > 0) {
			return workInfoList.get(0);
		}
		return null;
	}

	public void syncWorkflow() {
		StringBuilder dipoa = new StringBuilder();
		StringBuilder fssc = new StringBuilder();
		StringBuilder lsp = new StringBuilder();
		StringBuilder dwfs = new StringBuilder();
		// CRM系统工作流定义名称
		StringBuilder icrm = new StringBuilder();
		// 财务自助工作流定义名称
		StringBuffer finSelf = new StringBuffer();
		// hr工作流定义名称
		StringBuffer hr = new StringBuffer();
		// wdgh工作流定义名称
		StringBuffer wdgh = new StringBuffer();
		// 证照系统工作流流程定义名称
		StringBuffer acms = new StringBuffer();
		// 项目管理系统工作流流程定义名称
        StringBuffer dppm = new StringBuffer();
		Map<String, String> map = new HashMap<String, String>();
		List<WorkflowInfo> list = queryAllWorkInfo();
		for (WorkflowInfo workflow : list) {
			if (workflow.getSyscode()
					.equals(F_Constants.DIPOA_WORKFLOW_SYSCODE)) {
				dipoa.append(",'" + workflow.getWorkflowname() + "'");
			} else if (workflow.getSyscode().equals(
					F_Constants.FSSC_WORKFLOW_SYSCODE)) {
				fssc.append(",'" + workflow.getWorkflowname() + "'");
			} else if (workflow.getSyscode().equals(
					F_Constants.DLSP_WORKFLOW_SYSCODE)) {
				lsp.append(",'" + workflow.getWorkflowname() + "'");
			} else if (workflow.getSyscode().equals(
					F_Constants.DWFS_WORKFLOW_SYSCODE)) {
				dwfs.append(",'" + workflow.getWorkflowname() + "'");
			} else if (workflow.getSyscode().equals(
					F_Constants.CRM_WORKFLOW_SYSCODE)) {
				// CRM系统
				icrm.append(",'" + workflow.getWorkflowname() + "'");
			} else if (F_Constants.FIN_SELF_WORKFLOW_SYSCODE.equals(workflow
					.getSyscode())) {
				// fin_self财务自助系统
				finSelf.append(",'" + workflow.getWorkflowname() + "'");
			} else if (F_Constants.HR_WORKFLOW_SYSCODE.equals(workflow
					.getSyscode())) {
				// nhr系统
				hr.append(",'" + workflow.getWorkflowname() + "'");
			} else if (F_Constants.WDGH_WORKFLOW_SYSCODE.equals(workflow
					.getSyscode())) {
				// 网点规划系统 WDGH
				wdgh.append(",'" + workflow.getWorkflowname() + "'");
			} else if (F_Constants.ACMS_WORKFLOW_SYSCODE.equals(workflow
					.getSyscode())) {
				// 证照系统系统 ACMS
				acms.append(",'" + workflow.getWorkflowname() + "'");
			}else if(F_Constants.DPPM_WORKFLOW_SYSCODE.equals(workflow
			        .getSyscode())){
			    // 项目管理工具
			    dppm.append(",'" + workflow.getWorkflowname() + "'");
			}

			map.put(workflow.getWorkflowname(), workflow.getJspname());
		}
		F_Constants.ALL_WORKFLOW_TYPES = dipoa.toString().length() > 0 ? dipoa
				.toString().substring(1) : "''";
		F_Constants.ALL_WORKFLOW_TYPES_FSSC = fssc.toString().length() > 0 ? fssc
				.toString().substring(1) : "''";
		F_Constants.ALL_WORKFLOW_TYPES_LSP = lsp.toString().length() > 0 ? lsp
				.toString().substring(1) : "''";
		F_Constants.ALL_WORKFLOW_TYPES = dipoa.toString().length() > 0 ? dipoa
				.toString().substring(1) : "''";
		F_Constants.ALL_WORKFLOW_TYPES_DWFS = dwfs.toString().length() > 0 ? dwfs
				.toString().substring(1) : "''";
		F_Constants.ALL_WORKFLOW_TYPES_ICRM = icrm.toString().length() > 0 ? icrm
				.toString().substring(1) : "''";
		F_Constants.ALL_WORKFLOW_TYPES_FIN_SELF = finSelf.toString().length() > 0 ? finSelf
				.toString().substring(1) : "''";
		F_Constants.ALL_WORKFLOW_TYPES_HR = hr.toString().length() > 0 ? hr
				.toString().substring(1) : "''";
		F_Constants.ALL_WORKFLOW_TYPES_WDGH = wdgh.toString().length() > 0 ? wdgh
				.toString().substring(1) : "''";
		F_Constants.ALL_WORKFLOW_TYPES_ACMS = acms.toString().length() > 0 ? acms
				.toString().substring(1) : "''";
		F_Constants.ALL_WORKFLOW_TYPES_DPPM = dppm.toString().length() > 0 ? dppm
		        .toString().substring(1) : "''";
		F_Constants.WF_FORWARD_MAP = map;
		
	}

    /**
     * 用户ID
     * @param userId
     * @return
     */
	@Override
	public int queryWorkflowItems(String users) {
		String processdefname = F_Constants.ALL_WORKFLOW_TYPES_FSSC + ","
				+ F_Constants.ALL_WORKFLOW_TYPES_LSP + ","
				+ F_Constants.ALL_WORKFLOW_TYPES_DWFS + ","
				+ F_Constants.ALL_WORKFLOW_TYPES_ICRM + ","
				+ F_Constants.ALL_WORKFLOW_TYPES_FIN_SELF + ","
				+ F_Constants.ALL_WORKFLOW_TYPES_HR + ","
				+ F_Constants.ALL_WORKFLOW_TYPES_WDGH + ","
				+ F_Constants.ALL_WORKFLOW_TYPES_ACMS + ","
		        + F_Constants.ALL_WORKFLOW_TYPES_DPPM;
		
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
		
		String sql = "SELECT COUNT(1) AS NUM " +
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
		
//		logger.info("workflow items sql is : " + sql);
		
		int count = 0;
		try{
			count = template.queryForInt(sql);
		}catch(EmptyResultDataAccessException e){
			count = 0;
		}
		return count;
	}
}

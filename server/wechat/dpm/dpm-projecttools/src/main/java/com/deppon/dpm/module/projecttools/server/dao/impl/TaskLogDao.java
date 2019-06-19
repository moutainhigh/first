package com.deppon.dpm.module.projecttools.server.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.alibaba.fastjson.JSON;
import com.deppon.dpm.module.projecttools.server.dao.ITaskLogDao;
import com.deppon.dpm.module.projecttools.server.util.SqlUtil;
import com.deppon.dpm.module.projecttools.shared.domain.FileEntity;
import com.deppon.dpm.module.projecttools.shared.domain.TaskLogEntity;
import com.deppon.dpm.module.projecttools.shared.domain.TasksEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;

/**
 * 
 * 任务管理 任务详情  任务跟踪日志 dao
 * 
 * @author 195406 高春玲
 * @date 2015-8-8 下午1:45:08
 * @since
 **/
public class TaskLogDao extends iBatis3DaoImpl implements ITaskLogDao {
	private static Logger logger = LoggerFactory.getLogger(TaskLogDao.class);

	private JdbcTemplate template;

    /**
     * 任务详情  任务跟踪日志
     * @param taskid 任务编号
     * @return 
     */
	@Override
	public Map<String, Object> queryLog(int taskid) {
		// 定义map 变量
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 根据任务编号获得任务基本信息及任务的附件
			// 定义sql 变量
			String sql = "select t.*,(select tt.task_name from dotp_tm_tasks tt " +
					"where tt.id=t.task_parent) parent_task_name" +
					",c.contact_order_by task_owner_name,c2.contact_order_by task_processer_name ," +
					"ud.demand_name user_demand_name,sd.sys_demand_code sys_demand_name," +
					"ps.proj_name task_project_name,pn.label projectType,tn.label task_category_name," +
					// 任务类型
					"(case t.task_category when 1 then tn1.label when 2 then tn2.label when 3 then tn3.label else tn4.label end ) " +
					"task_type_name,tns.label task_status_name,tnl.label task_develop_language_name," +
					"vi.sys_version_code from dotp_tm_tasks t " +
					"left join dotp_contacts c on c.contact_employee_code=t.task_owner_id and c.contact_status=1 " +
					"left join dotp_contacts c2 on c2.contact_employee_code=t.task_processer_id and c2.contact_status=1 " +
					"left join dotp_dev_user_demand_info ud on ud.demand_id=t.user_demand_id " +
					"left join dotp_dev_sys_demand_info sd on sd.sys_demand_id=t.sys_demand_id " +
					"left join dotp_dev_version_info vi on vi.sysdemandcode=sd.sys_demand_code " +
					"left join dotp_pm_projects ps on ps.project_code=t.task_project " +
					"LEFT JOIN dotp_names pn on pn.name=\"gh_type\" and pn.`value`=ps.proj_type " +
					"left join dotp_names tn on tn.name='task_category' and tn.value=t.task_category " +
					"left join dotp_names tn1 on tn1.name='task_type_1' and tn1.value=t.task_type " +
					"left join dotp_names tn2 on tn2.name='task_type_2' and tn2.value=t.task_type " +
					"left join dotp_names tn3 on tn3.name='task_type_3' and tn3.value=t.task_type " +
					"left join dotp_names tn4 on tn4.name='task_type_4' and tn4.value=t.task_type  " +
					"left join dotp_names tns on tns.name='task_status' and tns.value=t.task_status " +
					"left join dotp_names tnl on tnl.name='task_develop_language' " +
					"and tnl.value=t.task_develop_language where t.id=" + taskid;
			// 根据 sql获得　任务基本信息详情
			List<TasksEntity> taskList = this.template.query(sql,
					new RowMapper<TasksEntity>() {

				@Override
				public TasksEntity mapRow(ResultSet rs, int arg1)
						throws SQLException {
					// 创建 任务基本信息实体
					TasksEntity info = new TasksEntity();
					// 对任务信息 赋值
					info.setTaskId(rs.getInt("id"));
					info.setTaskCategoryId(rs.getInt("task_category"));
					info.setTaskCategory(rs.getString("task_category_name"));
					info.setTaskName(rs.getString("task_name"));
					info.setTaskTypeId(rs.getInt("task_type"));
					info.setTaskType(rs.getString("task_type_name"));
					info.setTaskOwnerId(rs.getString("task_owner_id"));
					info.setTaskProcesserId(rs.getString("task_processer_id"));
					info.setTaskOwerName(rs.getString("task_owner_name"));
					info.setTaskProcesserName(rs.getString("task_processer_name"));
					info.setTaskPercentComplete(rs.getInt("task_percent_complete"));
				    info.setParentTaskName(rs.getString("parent_task_name"));
				    info.setTaskDeliverable(rs.getString("task_deliverable"));
				    info.setTaskStartTime(rs.getDate("task_start_time"));
				    info.setTaskEndTime(rs.getDate("task_end_time"));
				    info.setTaskDuration(rs.getBigDecimal("task_duration"));
				    info.setTaskExperience(rs.getInt("task_experience"));
				    info.setTaskDesc(rs.getString("task_desc"));
				    // 任务状态
				    info.setTaskStatus(rs.getString("task_status_name"));
				    info.setTaskDifficulty(rs.getInt("task_difficulty"));
				    info.setTaskDevelopLanguage(rs.getString("task_develop_language_name"));
				    info.setTaskIsLandmarker(rs.getInt("task_is_landmarker"));
				    info.setTaskIsCheck(rs.getInt("task_is_check"));
				    info.setTaskPoint(rs.getInt("task_point"));
				    info.setTaskRealPoint(rs.getInt("task_real_point"));
				    info.setUserDemand(rs.getString("user_demand_name"));
				    info.setUserDemandId(rs.getString("user_demand_id"));
				    info.setSysDemandId(rs.getString("sys_demand_id"));
				    info.setVersion(rs.getString("sys_version_code"));
				    info.setTaskProjectId(rs.getInt("task_project"));
				    info.setTaskProjectName(rs.getString("task_project_name"));
				    info.setTaskProjectType(rs.getString("projectType"));
				    // 任务附件 sql
			    	String sql = "select * from dotp_attachment m where m.module='TASKS' and m.module_id=" + rs.getInt("id");
			    	// 根据附件 sql获得 任务对应的附件集合
			    	List<FileEntity> filesList = template.query(sql,
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
			    	// 设置 任务中对应的附件集合
			    	info.setFilesList(filesList);
			    	// 返回 info
					return info;
				}
			});
		    
			////根据任务编号获得任务跟踪日志
		    sql = "select * from dotp_tm_task_log l where l.task_id=" + taskid + " order by task_log_create_time desc ";
		    // 获得任务跟踪日志 list集合
		    List<TaskLogEntity> tasklogList = this.template.query(sql,
					new RowMapper<TaskLogEntity>() {

				@Override
				public TaskLogEntity mapRow(ResultSet rs, int arg1)
						throws SQLException {
					// 创建任务跟踪日志实体
					TaskLogEntity info = new TaskLogEntity();
					info.setId(rs.getInt("id"));
					info.setCheckLogid(rs.getInt("check_log_id"));
					info.setCreateTime(rs.getDate("task_log_create_time"));
					info.setDesc(rs.getString("task_log_desc"));
					info.setEmail(rs.getString("task_log_email"));
					info.setPercentComplete(rs.getInt("task_log_percent_complete"));
					info.setTaskId(rs.getInt("task_id"));
					info.setTaskIscheck(rs.getInt("task_is_check"));
					info.setWorkedHour(rs.getFloat("task_log_worked_hour"));
					
				    //任务跟踪日志附件
			    	String sql = "select * from dotp_attachment m where m.module='TASK_TRACK_LOG' and m.module_id="+rs.getInt("id");
			    	// 获得任务跟踪日志附件 list 集合
			    	List<FileEntity> filesList = template.query(sql,
							new RowMapper<FileEntity>() {

						@Override
						public FileEntity mapRow(ResultSet rs, int arg1)
								throws SQLException {
							// 附件实体
							FileEntity info = new FileEntity();
							// 对附件信息赋值
							info.setFileName(rs.getString("file_name"));
							info.setFileType(rs.getString("file_type"));
							info.setSavePath(rs.getString("save_path"));
							// 返回 info
							return info;
						}
					});
			    	//设置任务跟踪日志附件
			    	info.setFilesList(filesList);
					return info;
				}
			});
			//任务基本信息
			map.put("tasklist", taskList);
			//任务跟踪日志信息
			map.put("taskLoglist", tasklogList);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
		
	}
	/**
	 * 新增任务跟踪日志
	 * @param e 日志实体
	 * @return 是否保存成功
	 */
	public int addtasklog(TaskLogEntity e) {
		//是否保存成功标示 0 默认 失败
		int flag = 0;
		try {
			// 更新问题风险状态为解决中
			updateRiskState(e.getTaskId());
			
			//是否需要审核 默认为 0 不需要 
			int is_check = 0;
			// 任务完成进度 》100 时 需要审核 
			if (e.getPercentComplete() >= 100) {
				// 赋值为1 需要审核
				is_check = 1;
			}
			flag = this.template.update("insert into dotp_tm_task_log(task_log_worked_hour,task_log_desc,task_log_email," +
					"task_id,task_log_percent_complete,task_log_create_time,check_log_id,task_is_check,empcode) values(" +
					"" + e.getWorkedHour() + ",'" + e.getDesc() + "','" + e.getEmail() + "'," + e.getTaskId() 
					+ "," + e.getPercentComplete() + ",now(),0," + is_check + ",'" + e.getEmpcode() + "') ");
			//日志保存成功 后更新任务完成进度及 任务状态
			if (flag == 1) {
				String sql = "update dotp_tm_tasks set id=id ";
				//任务状态    已暂存:1、已分配:2、进行中:3、已暂停:4、已停止:5、已提交:6、已完成 7
				//默认任务进行中
				int task_status = 3;
				//任务实际功能点 当完成100%时 需更新实际功能点
				int task_real_point = 0;
				// 完成进度>=100时  赋值任务状态为6 已提交
				if(e.getPercentComplete() >= 100) {
					// 已提交
					task_status = 6;
					// 对任务实际功能点赋值
					task_real_point = e.getRealPoint();
				} else {//未完成时 更新任务进度 完成不更新
					sql += ",task_percent_complete=" + e.getPercentComplete();
				}
				sql += ",task_status=" + task_status + ",task_real_point=" + task_real_point 
						+ ",task_is_check=" + is_check + " where id=" + e.getTaskId();
				logger.info(sql);
				// 执行 更新任务 sql
				flag = this.template.update(sql);
			}
		} catch(Exception ee) {
			ee.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * 更新问题风险状态为解决中
	 */
	private void updateRiskState(int taskId){
		// 获取任务对象 判断是否是问题风险任务
		TasksEntity task = getTaskPercentCompleteByTaskId(taskId);
		// 判断是否是问题风险任务
		// 判断任务完成进度是否为0
		if(task.getTaskPercentComplete() == 0 && StringUtils.isNotBlank(task.getRiskId())){
			// 更新问题风险状态
			String riskSql = SqlUtil.updateRiskState("解决中","4",task.getRiskId());
			// 日志打印
			logger.info(" 更新问题风险状态为已关闭  SQL statement" + riskSql  );
			this.template.update(riskSql);
		}
	}
	
	/**
	 * 根据taskId 获取主任务完成进度与riskid
	 * @return
	 */
	public TasksEntity getTaskPercentCompleteByTaskId(int taskId) {
		//sql
		String sql = " select t.id,t.task_percent_complete,t.risk_id from dotp_tm_tasks t where t.task_is_delete = 0 and t.id = " + taskId;
		// 获取可分配工时的sql
		logger.info("根据任务id获取riskid的sql语句————" + sql);
		//执行查询
		List<TasksEntity> taskList = this.template.query(sql,
				new RowMapper<TasksEntity>() {
			@Override
			public TasksEntity mapRow(ResultSet rs, int arg1)
					throws SQLException {
				// 创建 任务实体
				TasksEntity info = new TasksEntity();
				// 对任务实体信息赋值
				info.setTaskId(rs.getInt("id"));
				info.setTaskPercentComplete(rs.getInt("task_percent_complete"));
				info.setRiskId(rs.getString("risk_id"));
				return info;
			}
		});
		// 任务对象
		TasksEntity task = new TasksEntity();
		if(taskList != null && taskList.size()>0){
			// 赋值
			task = taskList.get(0);
		}
		// 返回
		return task;
	}
	
	/**
	 * 我的待办任务
	 * @param userId 用户工号
	 * @return 我的代办任务列表
	 */
	public String queryMytask(String userId) {
		//任务处理人是自己 并且未完成的没有子任务  或者任务分配人是自己 并且需要自己审核的
		String sql = "select * from ( select *,(select count(1) from dotp_tm_tasks tt where  " +
		//  fcount  查询是否有子任务 
				"tt.task_parent=t.id and tt.task_is_delete = 0 ) fcount" +
				" from dotp_tm_tasks t where " +
				// 任务处理人是自己 并且是不等于 已提交和已完成的和已终止
				"(t.task_processer_id='" + userId + "' and task_status!=7 and task_status!=6 and task_status!=5 and task_status!=1 " +
				// 任务分配人是自己 并且待审核和不是已完成的
				"or t.task_owner_id='" + userId + "' and t.task_is_check=1 and t.task_status!=7 " +
				// 自己暂存的 任务 11.9
				"or t.task_owner_id='" + userId + "' and t.task_status=1) " +
				// 未删除的
				"and t.task_is_delete=0 ) t" +
				// 只获得没有子任务的 或者 待审核的
				" where t.fcount=0 or t.task_is_check=1";
		List<TasksEntity> taskList = this.template.query(sql,
				new RowMapper<TasksEntity>() {

			@Override
			public TasksEntity mapRow(ResultSet rs, int arg1)
					throws SQLException {
				// 创建 任务实体
				TasksEntity info = new TasksEntity();
				// 对任务实体信息赋值
				info.setTaskId(rs.getInt("id"));
				info.setTaskName(rs.getString("task_name"));
				info.setTaskPercentComplete(rs.getInt("task_percent_complete"));
				info.setTaskStartTime(rs.getDate("task_start_time"));
				info.setTaskEndTime(rs.getDate("task_end_time"));
				info.setTaskIsCheck(rs.getInt("task_is_check"));
				info.setTaskStatus(rs.getString("task_status"));
				info.setTaskCategoryId(rs.getInt("task_category"));
				info.setTaskOwnerId(rs.getString("task_owner_id"));
				return info;
			}
		});
		// list 集合转换为json 字符串
		return JSON.toJSONString(taskList);
	}
	/**
	 * 根据任务编号 获得任务名称和任务所属项目名称
	 * @param taskid
	 * @return
	 */
	public TasksEntity queryTaskById(int taskid) {
		TasksEntity t = null;
		// 根据任务编号获得任务基本信息
		String sql = "select t.task_name,t.task_start_time,t.task_end_time, ps.proj_name task_project_name," +
				"c.contact_order_by task_owner_name,c2.contact_order_by task_processer_name from dotp_tm_tasks t " +
			"left join dotp_pm_projects ps on ps.project_code=t.task_project " +
			"left join dotp_contacts c on c.contact_employee_code=t.task_owner_id and c.contact_status=1 " +
			"left join dotp_contacts c2 on c2.contact_employee_code=t.task_processer_id " +
			"and c2.contact_status=1  where t.id=" + taskid;
		List<TasksEntity> taskList = this.template.query(sql,
				new RowMapper<TasksEntity>() {

			@Override
			public TasksEntity mapRow(ResultSet rs, int arg1)
					throws SQLException {
				// 任务实体
				TasksEntity info = new TasksEntity();
				// 任务名称
				info.setTaskName(rs.getString("task_name"));
				// 任务开始时间
				info.setTaskStartTime(rs.getDate("task_start_time"));
				// 任务结束时间
			    info.setTaskEndTime(rs.getDate("task_end_time"));
			    // 项目名称
			    info.setTaskProjectName(rs.getString("task_project_name"));
			    // 任务分配者
			    info.setTaskOwerName(rs.getString("task_owner_name"));
			    // 任务处理人
				info.setTaskProcesserName(rs.getString("task_processer_name"));
			    return info;
			}
		});
		// 判断当前任务编号是否有对应的任务
		if (taskList != null && taskList.size() > 0) {
			// 返回当前任务实体
			t = taskList.get(0);
		}
		return t;
	}
	/**
	 * @param template
	 */
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
}

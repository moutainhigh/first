package com.deppon.dpm.module.projecttools.server.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.projecttools.server.dao.IDppmTaskDao;
import com.deppon.dpm.module.projecttools.server.util.SqlUtil;
import com.deppon.dpm.module.projecttools.shared.domain.TasksEntity;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
import com.deppon.foss.framework.shared.util.string.StringUtil;


/**
 * 任务Dao
 * @author 251624
 *
 */
public class DppmTaskDao extends iBatis3DaoImpl implements IDppmTaskDao {
	/**
	 * 日志
	 */
	private static Logger logger = LoggerFactory.getLogger(DppmTaskDao.class);
	/**
	 * 日期
	 */
	private  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  

	/***/
	private JdbcTemplate dppmTemplate;

	/**项目Map*/
	private Map<String,JSONObject> proMap = null;
	/**子任务Map*/
	private Map<String,JSONObject> subMap = null;
	/**部门成员任务Map*/
	private Map<String,JSONObject> memMap = null;
	/**用来过滤的任务*/
	private List<String> thridSub = null;

	/** 
	 * TODO 判断用户是否是PMO 
	 * @author 毕文兵
	 * 2015-9-24
	 * @see com.deppon.dpm.module.projecttools.server.dao.IDppmTaskDao#isPMOByEmCode(java.lang.String)
	 */
	@Override
	public boolean isPMOByEmCode(String emCode) {
		String sql = SqlUtil.getIsPmoSql(emCode);
		logger.info("判断PMO的Sql===>" + sql);
		int count = dppmTemplate.queryForInt(sql);
		return count > 0 ? true : false;
	}

	/** 
	 * TODO 查询项目关联
	 * @author 毕文兵
	 * 2015-9-24
	 * @see com.deppon.dpm.module.projecttools.server.dao.IDppmTaskDao#getProjectInfoMap(boolean, java.lang.String)
	 */
	@Override
	public Map<String,JSONObject> getProjectInfoMap(boolean isPmo, String emCode)
			throws Exception {
		//获取SQL语句
		String sql = SqlUtil.getProjectSql(isPmo, emCode);
		logger.info("查询关联项目的Sql===>" + sql);
		this.proMap = new HashMap<String, JSONObject>();
		//执行查询语句
		this.dppmTemplate.query(sql, new RowMapper<JSONObject>(){
			@Override
			public JSONObject mapRow(ResultSet rs, int rowNum) throws SQLException {
				JSONObject projectObj = new JSONObject();
				String aiId = rs.getString("aiId");
				//项目ID
				projectObj.put("projectId", rs.getString("projectId"));
				//项目名称
				projectObj.put("projName", rs.getString("projName"));
				//项目Code
				projectObj.put("code", rs.getString("code"));
				//项目key
				projectObj.put("aiId", aiId);
				//处理者工号
				projectObj.put("taskProcesserId", rs.getString("projProcesserId"));
				//任务转态
				projectObj.put("taskStatus", rs.getString("projStatus"));
				//处理者名称
				projectObj.put("taskProcesserName", rs.getString("projProcesserName"));
				//完成百分比
				projectObj.put("taskPercentComplete", rs.getString("projPercentComplete"));
				//付任务ID
				projectObj.put("taskParentId", rs.getString("taskParentId"));
				//父任务名称
				projectObj.put("taskParentName", rs.getString("taskParentName"));
				projectObj.put("isPro", "1");
				proMap.put(aiId, projectObj);
				return projectObj;
			}

		});
		return proMap;
	}

	/** 
	 * TODO 任务查询列表
	 * @author 毕文兵
	 * 2015-9-24
	 * @see com.deppon.dpm.module.projecttools.server.dao.IDppmTaskDao#getTaskList(boolean, java.lang.String)
	 */
	@Override
	public List<JSONObject> getTaskList(boolean isPmo, String emCode)
			throws Exception {
		String sql = "";
		//判断 用户是否拥有PMO权限
		if (isPmo) {
		    //是PMO
			sql = SqlUtil.getSearchPmoTaskSql(emCode);
		} else {
		    //pmo以外
			sql = SqlUtil.getSearchNotPmoTaskSql(emCode);
		}

		logger.info("任务查询列表的Sql===>" + sql);
		/**
		 * 查询任务
		 */
		List<JSONObject> list = this.dppmTemplate.query(sql, new RowMapper<JSONObject>() {
			@Override
			public JSONObject mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				JSONObject projectObj = new JSONObject();
				//任务ID
				projectObj.put("id", rs.getString("id"));
				//项目ID
				projectObj.put("projectId", rs.getString("projectId"));
				//父项目ID
				projectObj.put("taskParent",
						rs.getString("taskParent"));
				//任务完成百分比
				projectObj.put("taskPercentComplete", rs.getString("taskPercentComplete"));
				//任务类别
				projectObj.put("taskCategory",
						rs.getString("taskCategory"));
				//任务名称
				projectObj.put("taskName", rs.getString("taskName"));
				//任务类型
				projectObj.put("taskType", rs.getString("taskType"));
				//处理者id
				projectObj.put("taskProcesserId",
						rs.getString("taskProcesserId"));
				//任务所有者
				projectObj.put("taskOwnerId",
						rs.getString("taskOwnerId"));
				//处理者名称
				projectObj.put("taskProcesserName",
						rs.getString("taskProcesserName"));
				//开始时间
				projectObj.put("taskStartTime",
						stringDateLong(rs.getString("taskStartTime")));
				//结束时间
				projectObj.put("taskEndTime",
						stringDateLong(rs.getString("taskEndTime")));
				//功能点
				projectObj.put("taskDuration",
						rs.getString("taskDuration"));
				//是否有子节点
				projectObj.put("taskIsLeaf", 
						rs.getString("taskIsLeaf"));
				//任务状态
				projectObj.put("taskStatus", 
						rs.getString("taskStatus"));
				projectObj.put("taskIsCheck", 
						rs.getString("taskIsCheck"));
				
				//用于区分项目类中第一层的显示
				projectObj.put("isPro", "0");
				return projectObj;
			}
		});
		return list == null ? new ArrayList<JSONObject>() : list;
	}

	/** 
	 * TODO 查询我的任务
	 * @author 毕文兵
	 * 2015-9-24
	 * @see com.deppon.dpm.module.projecttools.server.dao.IDppmTaskDao#getMyTask(java.lang.String)
	 */
	@Override
	public List<JSONObject> getMyTask(String emCode) throws Exception {
		String sql = SqlUtil.getMyTaskSql();
		logger.info("我的任务查询Sql===>" + sql);
		List<JSONObject> list = this.dppmTemplate.query(sql, new String[] {emCode},
				new RowMapper<JSONObject>() {
			@Override
			public JSONObject mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				JSONObject projectObj = new JSONObject();
				//任务id
				projectObj.put("id", 
						rs.getString("id"));
				//项目类别
				projectObj.put("taskCategory",
						rs.getString("taskCategory"));
				//项目ID
				projectObj.put("projectId", 
						rs.getString("projectId"));
				//任务完成率
				projectObj.put("taskPercentComplete", 
						rs.getString("taskPercentComplete"));
				//任务名称
				projectObj.put("taskName", 
						rs.getString("taskName"));
				//任务类型
				projectObj.put("taskType", 
						rs.getString("taskType"));
				//处理者Id
				projectObj.put("taskProcesserId",
						rs.getString("taskProcesserId"));
				//任务所有者
				projectObj.put("taskOwnerId",
						rs.getString("taskOwnerId"));
				//处理者名称
				projectObj.put("taskProcesserName",
						rs.getString("taskProcesserName"));
				//开始时间
				projectObj.put("taskStartTime",
						stringDateLong(rs.getString("taskStartTime")));
				//结束时间
				projectObj.put("taskEndTime",
						stringDateLong(rs.getString("taskEndTime")));
				//功能点
				projectObj.put("taskDuration",
						rs.getString("taskDuration"));
				//是否有子节点
				projectObj.put("taskIsLeaf", 
						rs.getString("taskIsLeaf"));
				//任务状态
				projectObj.put("taskStatus", 
						rs.getString("taskStatus"));
				projectObj.put("taskIsCheck", 
						rs.getString("taskIsCheck"));
				// TODO Auto-generated method stub
				return projectObj;
			}
		});
		return list == null ? new ArrayList<JSONObject>() : list;
	}

	/** 
	 * TODO 查询子任务
	 * @author 毕文兵
	 * 2015-9-24
	 * @see com.deppon.dpm.module.projecttools.server.dao.IDppmTaskDao#getSubTaskMap(java.lang.String)
	 */
	@Override
	public Map<String,JSONObject> getSubTaskMap(String taskIds) throws Exception {
		String sql  = SqlUtil.getSubTaskLis(taskIds);
		logger.info("子任务查询Sql===>" + sql);
		subMap = new HashMap<String,JSONObject>();
		this.dppmTemplate.query(sql,new RowMapper<JSONObject>() {
			@Override
			public JSONObject mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				JSONObject projectObj = new JSONObject();
				String id = rs.getString("id");
				//任务ID
				projectObj.put("id", id);
				String taskParent = rs.getString("taskParent");
				//付任务ID
				projectObj.put("taskParent",
						taskParent);
				//任务类别
				projectObj.put("taskCategory",
						rs.getString("taskCategory"));
				//项目ID
				projectObj.put("projectId", rs.getString("projectId"));
				//任务完成率
				projectObj.put("taskPercentComplete", 
						rs.getString("taskPercentComplete"));
				//任务名称
				projectObj.put("taskName", 
						rs.getString("taskName"));
				//任务类型
				projectObj.put("taskType", 
						rs.getString("taskType"));
				//任务处理者ID
				projectObj.put("taskProcesserId",
						rs.getString("taskProcesserId"));
				//任务所有者ID
				projectObj.put("taskOwnerId",
						rs.getString("taskOwnerId"));
				//处理者名称
				projectObj.put("taskProcesserName",
						rs.getString("taskProcesserName"));
				//开始时间
				projectObj.put("taskStartTime",
						stringDateLong(rs.getString("taskStartTime")));
				//结束时间
				projectObj.put("taskEndTime",
						stringDateLong(rs.getString("taskEndTime")));
				//功能点
				projectObj.put("taskDuration",
						rs.getString("taskDuration"));
				//是否有子节点
				projectObj.put("taskIsLeaf"
						, rs.getString("taskIsLeaf"));
				//任务转态
				projectObj.put("taskStatus", 
						rs.getString("taskStatus"));
				projectObj.put("taskIsCheck", 
						rs.getString("taskIsCheck"));
				projectObj.put("isPro", "0");
				//判断是不是子任务
				int isSubFlag = rs.getInt("subFlag");
				if(isSubFlag > 0){
					//sql文中已经按subFlag排序,过滤2层以后的任务
					if(subMap.containsKey(taskParent)){
						if(subMap.get(taskParent).containsKey("subTasks")){
							subMap.get(taskParent).getJSONArray("subTasks").add(projectObj);
						}else{
							JSONArray ary = new JSONArray();
							ary.add(projectObj);
							subMap.get(taskParent).put("subTasks", ary);
						}
					}
				}else{
					subMap.put(id, projectObj);
				}

				return projectObj;
			}
		});
		return subMap;
	}


	/** 
	 * TODO 部门成员查询
	 * @author 毕文兵
	 * 2015-9-24
	 * @see com.deppon.dpm.module.projecttools.server.dao.IDppmTaskDao#getDeptMemberTask(java.lang.String)
	 */
	@Override
	public Map<String, JSONObject> getDeptMemberTask(String emCode)
			throws Exception {
		String sql = SqlUtil.getDeptMemberTaskSql(emCode);
		logger.info("部门成员Sql===>" + sql);
		this.memMap = new HashMap<String,JSONObject>();
		this.thridSub = new ArrayList<String>();
		this.dppmTemplate.query(sql,
				new RowMapper<JSONObject>() {
			@Override
			public JSONObject mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				JSONObject projectObj = new JSONObject();
				String taskId = rs.getString("id");
				//任务ID
				projectObj.put("id", taskId);
				//任务类别
				projectObj.put("taskCategory",
						rs.getString("taskCategory"));
				//父任务ID
				String taskParent = rs.getString("taskParent");
				projectObj.put("taskParent",
						taskParent);
				//项目ID
				projectObj.put("projectId", 
						rs.getString("projectId"));
				//任务完成率
				projectObj.put("taskPercentComplete", 
						rs.getString("taskPercentComplete"));
				//任务名称
				projectObj.put("taskName", 
						rs.getString("taskName"));
				//任务类型
				projectObj.put("taskType", 
						rs.getString("taskType"));
				//处理者ID
				projectObj.put("taskProcesserId",
						rs.getString("taskProcesserId"));
				//任务所有者ID
				projectObj.put("taskOwnerId",
						rs.getString("taskOwnerId"));
				//任务处理名称
				projectObj.put("taskProcesserName",
						rs.getString("taskProcesserName"));
				//开始时间
				projectObj.put("taskStartTime",
						stringDateLong(rs.getString("taskStartTime")));
				//结束时间
				projectObj.put("taskEndTime",
						stringDateLong(rs.getString("taskEndTime")));
				//功能点
				projectObj.put("taskDuration",
						rs.getString("taskDuration"));
				//是否有子节点
				projectObj.put("taskIsLeaf", 
						rs.getString("taskIsLeaf"));
				projectObj.put("taskStatus", 
						rs.getString("taskStatus"));
				projectObj.put("taskIsCheck", 
						rs.getString("taskIsCheck"));
				projectObj.put("isPro", "0");
				
				if(StringUtil.isEmpty(taskParent) || "0".equals(taskParent)){
					memMap.put(taskId, projectObj);
				}else{
					/**过滤2层以下的任务*/
					if(!thridSub.contains(taskParent)){
						/**子任务的TaskId一定大于父任务的TaskId，按TaskId排序后,子任务一定在父任务之后**/
						if(memMap.containsKey(taskParent)){
							if(memMap.get(taskParent).containsKey("subTasks")){
								memMap.get(taskParent).getJSONArray("subTasks").add(projectObj);
							}else{
								JSONArray subArr = new JSONArray();
								subArr.add(projectObj);
								thridSub.add(taskId);
								memMap.get(taskParent).put("subTasks", subArr);
							}
						}else{
							memMap.put(taskId, projectObj);
						}
					}
				}
				return projectObj;
			}
		});
		return memMap;
	}

	/** 
	 * TODO 有无待审核和新分配的任务查询
	 * @author 毕文兵
	 * 2015-9-24
	 * @see com.deppon.dpm.module.projecttools.server.dao.IDppmTaskDao#getTaskCommitCount(java.lang.String)
	 */
	@Override
	public int getTaskCommitCount(String emCode) throws Exception {
		String sql  = SqlUtil.getCheckTaskCount();
		logger.info("有无待审核和新分配的任务查询Sql===>" + sql);
		int count = this.dppmTemplate.queryForInt(sql, emCode);
		return count;
	}
	/**
	 * 任务新建
	 * 2015-10-21  高春玲
	 * @param task 任务实体
	 * @return
	 */
	public int addTask(TasksEntity task) throws Exception {
		//主键
		int keyId = 0;
		//对于之前暂存的记录进行重新更新
		if(task.getTaskId() >0 ){
			//执行更新
			keyId = updateTaskSql(task);
		} else {
			//任务新建 初始化sql 
			String sql = "insert into dotp_tm_tasks(task_category,task_name,task_type,task_owner_id," +
					"task_processer_id,task_duration," +
					"task_desc,task_status,task_create_time," + //以上为公共
					"task_is_landmarker";
			// values sql初始化
			String vsql = ") values (" + task.getTaskCategoryId() + ",'" + task.getTaskName() 
					+ "'," + task.getTaskTypeId() + ",'" + task.getTaskOwnerId() + "','" + task.getTaskProcesserId() + "',"
					+ task.getTaskDuration() + ",'" + task.getTaskDesc() + "'," 
					+ task.getTaskStatus() + ",now(),"
				    + task.getTaskIsLandmarker();
			// 开发语言
			if(task.getTaskDevelopLanguageId() != 0) {
				sql += ",task_develop_language";
				vsql += "," + task.getTaskDevelopLanguageId();
			}
			// 经验值
			if(task.getTaskExperience() != 0) {
				sql += ",task_experience";
				vsql += "," + task.getTaskExperience();
			}
			// 功能点
			if(task.getTaskPoint() != 0) {
				sql += ",task_point";
				vsql += "," + task.getTaskPoint();
			}
			// 难度系数
			if(task.getTaskDifficulty() != 0) {
				sql += ",task_difficulty";
				vsql += "," + task.getTaskDifficulty();
			}
			// 循环周期
			if(task.getTaskLoopCycle() != 0) {
				sql += ",task_loop_cycle";
				vsql += "," + task.getTaskLoopCycle();
			}
			// 项目编号
			if(task.getTaskProjectId() != 0) {
				sql += ",task_project";
				vsql += "," + task.getTaskProjectId();
			}
			// 父任务
			if(task.getParentTaskId() != 0) {
				sql += ",task_parent";
				vsql += "," + task.getParentTaskId();
				// 问题风险有子任务情况，需要把父任务的riskid 保存到子任务中
				String riskId = getRiskIdByParentTaskId(task.getParentTaskId());
				// 关联问题风险id
				if(StringUtils.isNotBlank(riskId)) {
					// 赋值
					task.setRiskId(riskId);
				}
			}
			// 交付物
			if(task.getTaskDeliverable() !=null && !task.getTaskDeliverable().equals("")) {
				sql += ",task_deliverable";
				vsql += ",'" + task.getTaskDeliverable() + "'";
			}
			// 用户需求编码
			if(task.getUserDemandId() !=null && !task.getUserDemandId().equals("")){
				sql += ",user_demand_id";
				vsql += "," + task.getUserDemandId();
			}
			// 系统需求编码
			if(task.getSysDemandId() !=null && !task.getSysDemandId().equals("")){
				sql += ",sys_demand_id";
				vsql += "," + task.getSysDemandId();
			}
			//计划开始时间 不为空时 进行保存
			if(task.getTaskstartTime() != null && !task.getTaskstartTime().equals("")) {
				sql += ",task_start_time";
				vsql += ",'" + task.getTaskstartTime() + "'";
			}
			//计划结束时间 不为空时进行保存
			if(task.getTaskendTime() !=null && !task.getTaskendTime().equals("")) {
				sql += ",task_end_time";
				vsql += ",'" + task.getTaskendTime() + "'";
			}
			//如果父任务为空 最高级父任务为id 层级默认为1
			if(task.getTaskTopParentId() != 0) {
				sql += ",task_top_parent,task_level";
				vsql += "," + task.getTaskTopParentId() + "," + task.getTaskLevel();
			}
			// 关联问题风险id
			if(StringUtils.isNotBlank(task.getRiskId())) {
				sql += ",risk_id";
				vsql += "," + task.getRiskId();
			}
			sql = sql + vsql + ")";
//			System.out.println(sql);
			//执行保存
			final String psql = sql;
			//执行更新获得主键
			KeyHolder keyHolder = new GeneratedKeyHolder();
			this.dppmTemplate.update(new PreparedStatementCreator() {  
				public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {  
					PreparedStatement ps = connection.prepareStatement(psql,Statement.RETURN_GENERATED_KEYS);  
					return ps;
				}
			}, keyHolder);
			//获得主键
			keyId = keyHolder.getKey().intValue();
			//保存成功后  如果最高级父任务 为空 0 时 更新task_top_parent 为id
			if(keyId > 0 && task.getTaskTopParentId() == 0) {
				// 更新task_top_parent 为id
				sql = "update dotp_tm_tasks set task_top_parent=" + keyId + ",task_level=1 where id = " + keyId;
				this.dppmTemplate.update(sql);
			}
		}
		//有父任务 更新父任务的 task_is_leaf = 0 12.29
		if(task.getParentTaskId() > 0 && !task.getTaskStatus().equals("1")) {
			String sql = "update dotp_tm_tasks set task_is_leaf=0 where id = " + task.getParentTaskId();
			this.dppmTemplate.update(sql);
		}
		return keyId;
		//判断任务类别   项目类任务：1    管理事务类任务：2    日常需求类任务：3      常规工作类任务：4
//		int cid = task.getTaskCategoryId();
//		if(cid == 1) {
//			//项目类任务
//			sql += ",task_project,task_point,task_difficulty,task_is_landmarker,task_experience,task_develop_language";
//			vsql += "," + task.getTaskProjectId() + "," + task.getTaskPoint() + "," + task.getTaskDifficulty() 
//					+ "," + task.getTaskIsLandmarker() + "," + task.getTaskExperience() + "," + task.getTaskDevelopLanguageId();
//		} else if (cid == 2) {
//			//管理事务类任务   //task_loop_cycle 日常事务类时需要有循环周期
//			sql += ",task_point,task_experience,task_loop_cycle";
//			vsql += "," + task.getTaskPoint() + "," + task.getTaskExperience() + "," + task.getTaskLoopCycle();
//		} else if (cid == 3) {
//			//日常需求类任务
//			sql += ",task_point,task_difficulty,user_demand_id,sys_demand_id,task_experience,task_difficulty";
//			vsql += "," + task.getTaskPoint() + "," + task.getTaskDifficulty() + "," + task.getUserDemandId() + "," + task.getSysDemandId()  
//					+ "," + task.getTaskExperience() + "," + task.getTaskDifficulty();
//		} else if (cid == 4) {
//			//常规工作类任务
//			sql += ",task_experience";
//			vsql += "," + task.getTaskExperience();
//		}
		
	}
	/**
	 * 更新任务 sql
	 * @param task
	 * @return
	 */
	private int updateTaskSql(TasksEntity task) {
		//初始化 任务id
		int keyId = 0;
		//更新 sql
		String sql = "update dotp_tm_tasks set task_category=" + task.getTaskCategoryId() + ",task_name='" + task.getTaskName() + "'"
				+ ",task_type=" + task.getTaskTypeId() + ",task_owner_id='" + task.getTaskOwnerId() + "'"
				+ ",task_processer_id='" + task.getTaskProcesserId() + "'"
				+ ",task_duration=" + task.getTaskDuration()
				+ ",task_desc='" + task.getTaskDesc() + "',task_status=" + task.getTaskStatus() + ",task_create_time=now()"
				+ ",task_is_landmarker=" + task.getTaskIsLandmarker();
		// 开发语言
		if(task.getTaskDevelopLanguageId() != 0) {
			sql += ",task_develop_language=" + task.getTaskDevelopLanguageId();
		}
		// 经验值
		if(task.getTaskExperience() != 0) {
			sql += ",task_experience=" + task.getTaskExperience();
		}
		// 功能点
		if(task.getTaskPoint() != 0) {
			sql += ",task_point=" + task.getTaskPoint();
		}
		// 难度系数
		if(task.getTaskDifficulty() != 0) {
			sql += ",task_difficulty=" + task.getTaskDifficulty();
		}
		// 循环周期
		if(task.getTaskLoopCycle() != 0) {
			sql += ",task_loop_cycle=" + task.getTaskLoopCycle();
		}
		// 项目编号
		if(task.getTaskProjectId() != 0) {
			sql += ",task_project=" + task.getTaskProjectId();
		}
		// 父任务
		if(task.getParentTaskId() != 0) {
			sql += ",task_parent=" + task.getParentTaskId();
		}
		// 交付物
		if(task.getTaskDeliverable() !=null && !task.getTaskDeliverable().equals("")) {
			sql += ",task_deliverable='" + task.getTaskDeliverable() + "'";
		}
		// 用户需求编码
		if(task.getUserDemandId() !=null && !task.getUserDemandId().equals("")){
			sql += ",user_demand_id=" + task.getUserDemandId();
		}
		// 系统需求编码
		if(task.getSysDemandId() !=null && !task.getSysDemandId().equals("")){
			sql += ",sys_demand_id=" + task.getSysDemandId();
		}
		//计划开始时间 不为空时 进行保存
		if(task.getTaskstartTime() != null && !task.getTaskstartTime().equals("")) {
			sql += ",task_start_time='" + task.getTaskstartTime() + "'";
		}
		//计划结束时间 不为空时进行保存
		if(task.getTaskendTime() !=null && !task.getTaskendTime().equals("")) {
			sql += ",task_end_time='" + task.getTaskendTime() + "'";
		}
		//更新时 去掉了父任务 更新最高级父任务 为id
		if(task.getTaskTopParentId() == 0) {
			sql += ",task_top_parent=" + task.getTaskId() + ",task_level=1 ";
		} else {
			sql += ",task_top_parent=" + task.getTaskTopParentId() + ",task_level=" + task.getTaskLevel();
		}
		sql += " where id=" + task.getTaskId();
		//执行更新
		if(this.dppmTemplate.update(sql) == 1) {
			//如果更新成功 返回主键
			keyId = task.getTaskId();
		}
		return keyId;
	}
	/**
	 * 任务更新信息
	 * 2015-11-13 高春玲
	 * @param task
	 * @return
	 */
	public int updateTask(TasksEntity task) {
		//更新任务之前 先获得未更新之前的任务信息
		List<TasksEntity> l = queryTask(task.getTaskId() + "");
		//原任务信息 
		TasksEntity oldTask = null;
		if(l != null && l.size() > 0) {
			oldTask = l.get(0);
		}
		// 更新任务
		int keyId = updateTaskSql(task);
		//更新成功后，保存任务更新记录
		if(keyId > 0) {
			// 拼接任务更新内容
			String detail = "";
			if(oldTask != null) {
				// 任务状态修改
				if(task.getTaskStatus() != null && !task.getTaskStatus().equals(oldTask.getTaskStatus())) {
					detail += ";任务状态:"+ oldTask.getTaskStatus() +"->" + task.getTaskStatus();
				}
				//任务类型
				if(task.getTaskTypeId() != oldTask.getTaskTypeId()) {
					detail += ";任务类型:"+ oldTask.getTaskTypeId() +"->" + task.getTaskTypeId();
				}
				//任务结束时间
				if(task.getTaskendTime() != null && !task.getTaskendTime().equals(sdf.format(oldTask.getTaskEndTime()))) {
					detail += ";任务结束时间:"+ sdf.format(oldTask.getTaskEndTime()) +"->" + task.getTaskendTime();
				}
				//任务开始时间
				if(task.getTaskstartTime() != null && !task.getTaskstartTime().equals(sdf.format(oldTask.getTaskStartTime()))) {
					detail += ";任务开始时间:"+ sdf.format(oldTask.getTaskStartTime()) +"->" + task.getTaskstartTime();
				}
				//处理人
				if(task.getTaskProcesserId() != null && !task.getTaskProcesserId().equals(oldTask.getTaskProcesserId())) {
					detail += ";处理人:"+ oldTask.getTaskProcesserName() +"->" + task.getTaskProcesserName();
				}
				//里程碑 (0:否;1:是)
				if(task.getTaskIsLandmarker() != oldTask.getTaskIsLandmarker()) {
					detail += ";里程碑:"+ (oldTask.getTaskIsLandmarker() == 1 ? "是" : "否") +"->" + (task.getTaskIsLandmarker() == 1 ? "是" : "否");
				}
				//经验值
				if(task.getTaskExperience() != oldTask.getTaskExperience()) {
					detail += ";经验值:"+ oldTask.getTaskExperience() +"->" + task.getTaskExperience();
				}
				//计划工时
				if(task.getTaskDuration().compareTo(oldTask.getTaskDuration()) != 0 ) {
					detail += ";计划工时:"+ oldTask.getTaskDuration() +"->" + task.getTaskDuration();
				}
				//功能点
				if(task.getTaskPoint() != oldTask.getTaskPoint()) {
					detail += ";功能点:"+ oldTask.getTaskPoint() +"->" + task.getTaskPoint();
				}
				//交付物名称
				if(task.getTaskDeliverable() != null && !task.getTaskDeliverable().equals(oldTask.getTaskDeliverable())) {
					detail += ";交付物名称:"+ oldTask.getTaskDeliverable() +"->" + task.getTaskDeliverable();
				}
				//开发语言
				if(task.getTaskDevelopLanguageId() != oldTask.getTaskDevelopLanguageId()) {
					detail += ";开发语言:"+ oldTask.getTaskDevelopLanguage() +"->" + task.getTaskDevelopLanguage();
				}
				//循环周期
				if(task.getTaskLoopCycle() != oldTask.getTaskLoopCycle()) {
					detail += ";循环周期:"+ oldTask.getTaskLoopCycle() +"->" + task.getTaskLoopCycle();
				}
				//难度系数
				if(task.getTaskDifficulty() != oldTask.getTaskDifficulty()) {
					detail += ";难度系数:"+ oldTask.getTaskDifficulty() +"->" + task.getTaskDifficulty();
				}
				//父任务
				if(task.getParentTaskId() != oldTask.getParentTaskId()){
					detail += ";父任务:"+ oldTask.getParentTaskName() +"->" + task.getParentTaskName();
				}
				//用户需求
				if(task.getUserDemandId() != oldTask.getUserDemandId()) {
					detail += ";用户需求:"+ oldTask.getUserDemand() +"->" + task.getUserDemand();
				}
				//系统需求
				if(task.getSysDemand() != oldTask.getSysDemand()) {
					detail += ";系统需求:"+ oldTask.getSysDemandId() +"->" + task.getSysDemandId();
				}
				//任务描述
				if(task.getTaskDesc() != null && !task.getTaskDesc().trim().equals(oldTask.getTaskDesc().trim())) {
					detail += ";任务描述:"+ oldTask.getTaskDesc() +"->" + task.getTaskDesc();
				}
				//去除第一个 ；
				if(detail.length() > 0 ) {
					detail = detail.substring(1);
				} else {
					detail = "无修改任何字段";
				}
			} else {
				detail = "更新之前无任务信息----";
			}
			logger.info("任务修改：更新内容----taskid = " + keyId + "--" + detail);
			//添加修改更新记录
			String sql = "insert into dotp_tm_task_modify_log(task_id,task_mlog_detail,task_mlog_reason,task_mlog_create_time) values (" +
					keyId + ",'" + detail + "','" + task.getChangeReason() + "',now())";
			this.dppmTemplate.update(sql);
			//有父任务 更新父任务的 task_is_leaf = 0 12.29
			if(task.getParentTaskId() > 0 ) {
				sql = "update dotp_tm_tasks set task_is_leaf=0 where id = " + task.getParentTaskId();
				this.dppmTemplate.update(sql);
			}
		}
		return keyId;
	}
    /**
     * 删除任务 修改状态为 1
     * @param taskid
     * @return
     */
	public int delTask(String taskid) {
		//删除sql
		String sql = "update dotp_tm_tasks set task_is_delete=1 where id = " + taskid;
		return this.dppmTemplate.update(sql);
	}
	/**
     * 终止任务 修改状态为 5
     * @param taskid
     * @return
     */
	public int stopTask(String taskid) {
		//删除sql
		String sql = "update dotp_tm_tasks set task_status=5 where id = " + taskid;
		return this.dppmTemplate.update(sql);
	}

	/**
	 * TODO 转换时间格式
	 * @author 毕文兵
	 * 2015-9-24
	 */
	long stringDateLong(String date){
		long time = 0l;
		if(StringUtil.isEmpty(date)){
			return time;
		}
		try {
			time = sdf.parse(date).getTime();
		} catch (ParseException e) {
			logger.info("转换日期时间出现错误 ===> date: " + date);
			time = 0;
		}

		return time;
	}

	/**
	 * 数据库连接
	 * @param dppmTemplate
	 */
	public void setDppmTemplate(JdbcTemplate dppmTemplate) {
		this.dppmTemplate = dppmTemplate;
	}

	/**
	 *  Title:查看暂存任务
	 *  @param taskId  
	 * 	Date: 2015-11-04
	 * */
	@Override
	public List<TasksEntity> queryTask(String taskId) {
		//查看暂存任务的sql
		String taskSql = SqlUtil.getTask(taskId);
		logger.info("查看暂存任务的语句————" + taskSql);
		//执行查询
		List<TasksEntity> taskList=this.dppmTemplate.query(taskSql,new RowMapper<TasksEntity>(){
			@Override
			public TasksEntity mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				TasksEntity task=new TasksEntity();
				//任务类别名称(项目类任务：1    管理事务类任务：2    日常需求类任务：3      常规工作类任务：4)
				task.setTaskCategory(rs.getString("task_category_name"));
				//任务类别ID
				task.setTaskCategoryId(rs.getInt("task_category"));
				//任务名称
				task.setTaskName(rs.getString("task_name"));
				//任务类型名称
				task.setTaskType(rs.getString("task_type_name"));
				//任务类型ID
				task.setTaskTypeId(rs.getInt("task_type"));
				//任务分配者ID
				task.setTaskOwnerId(rs.getString("task_owner_id"));
				//任务分配者名称
				task.setTaskOwerName(rs.getString("task_owner_name"));
				//任务处理者ID
				task.setTaskProcesserId(rs.getString("task_processer_id"));
				//任务处理者名称
				task.setTaskProcesserName(rs.getString("contact_order_by"));
				//任务处理者Email
				task.setTaskProcesserEmail(rs.getString("taskProcesserEmail"));
				//父任务id
				task.setParentTaskId(rs.getInt("task_parent"));
				//父任务名称
				task.setParentTaskName(rs.getString("parentTaskName"));
				//交付物名称
				task.setTaskDeliverable(rs.getString("task_deliverable"));
				 //计划开始时间
				task.setTaskStartTime(rs.getDate("task_start_time"));
				//计划结束时间
				task.setTaskEndTime(rs.getDate("task_end_time"));
				//taskstartTime父计划开始时间
				task.setTaskstartTime(rs.getString("fuStartTime"));
				//taskendTime父计划结束时间
				task.setTaskendTime(rs.getString("fuEndTime"));
				//计划工时（H）
				task.setTaskDuration(rs.getBigDecimal("task_duration"));
				//子计划工时之和（H）
				task.setTaskSumDuration(rs.getBigDecimal("taskSumDuration"));
				//父计划工时（H）
				task.setDuration(rs.getBigDecimal("all_child_dur"));
				//父实际功能点
				task.setTaskRealPoint(rs.getInt("taskRealPoint"));
				//任务描述
				task.setTaskDesc(rs.getString("task_desc"));
				//任务状态
				task.setTaskStatus(rs.getString("task_status"));
				//项目编号
				task.setTaskProjectId(rs.getInt("task_project"));
				//项目名称
				task.setTaskProjectName(rs.getString("taskProjectName"));
				//项目类型
				task.setTaskProjectType(rs.getString("taskProjectType"));
				//项目编码
				task.setProjectCode(rs.getString("projectCode"));
				 //实际功能点
				task.setTaskPoint(rs.getInt("task_point"));
				//难度系数
				task.setTaskDifficulty(rs.getInt("task_difficulty"));
				 //是否是里程碑(0:否;1:是)
				task.setTaskIsLandmarker(rs.getInt("task_is_landmarker"));
				 //开发语言
				task.setTaskDevelopLanguage(rs.getString("task_develop_language_name"));
				//循环周期
				task.setTaskLoopCycle(rs.getInt("taskLoopCycle"));
				//任务经验值
				task.setTaskExperience(rs.getInt("task_experience"));
				//用户需求编码
				task.setUserDemandId(rs.getString("user_demand_id"));
				task.setUserDemandCode(rs.getString("user_demand_code"));
				//用户需求名称
				task.setUserDemand(rs.getString("demand_name"));
				//需求类别
				String demand = rs.getString("demand_category_name");
				String sysDemandid = rs.getString("sysdemandcode");
				String version =rs.getString("sys_version_code");
//				int sysDemand=rs.getInt("sys_demand_id");
				task.setDemandCategory(demand == null ? "":demand);
				//系统需求编码
				task.setSysDemandId(sysDemandid == null ? "":sysDemandid);
				//版本号
				task.setVersion(version == null ? "":version);
				task.setSysDemand(rs.getInt("sys_demand_id"));
				task.setTaskLevel(rs.getInt("task_level"));
				task.setTaskTopParentId(rs.getInt("task_top_parent"));
				// 任务查询新增问题风险字段
				task.setRiskId(rs.getString("riskId"));
//				task.setSysDemand(sysDemand == 0 ? null :sysDemand);
				return task;
			}
		});
		logger.info("taskList is :-----"+taskList.size());
		return taskList;
	}
	
	/** 
	 * 根据项目编码获取问题风险任务可分配工时
	 * 
	 * 2016-03-24
	 */
	@Override
	public String getAssignableHour(String projCode){
		// 获取可分配工时的sql
		String sql  = SqlUtil.getAssignableHour(projCode);
		logger.info("获取问题风险任务可分配工时的语句————" + sql);
		//执行查询
		String assignableHour=this.dppmTemplate.queryForObject(sql,String.class);
		logger.info("assignableHour is :-----"+assignableHour);
		// 返回
		return (StringUtils.isNotBlank(assignableHour)?assignableHour:"0");
	}
	
	/** 
	 * 根据父任务id获取riskId
	 * 
	 * 2016-03-24
	 */
	public String getRiskIdByParentTaskId(int parentTaskId){
		// 获取riskId的sql
		String sql  = "select t.risk_id from dotp_tm_tasks t where t.task_is_delete = 0 and t.id = " + parentTaskId;
		logger.info("获取问题风险 riskId的语句————" + sql);
		//执行查询
		String riskId=this.dppmTemplate.queryForObject(sql,String.class);
		// 返回
		return riskId;
	}

	/**
	 * 更新风险状态
	 */
    @Override
    public int updateRiskStatus(int riskId) {
        String sql  = "update dotp_risk set state = '解决中' where id = " + riskId;
        return this.dppmTemplate.update(sql);
    }
	
	
}

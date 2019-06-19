package com.deppon.dpm.module.projecttools.server.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.projecttools.server.dao.IDppmTaskDao;
import com.deppon.dpm.module.projecttools.server.service.IDppmTaskService;
import com.deppon.dpm.module.projecttools.shared.domain.TasksEntity;
import com.deppon.foss.framework.exception.BusinessException;
import com.deppon.foss.framework.shared.util.string.StringUtil;

/**
 * 
 * @author 251624
 *
 */
public class DppmTaskService implements IDppmTaskService {
    IDppmTaskDao dppmTaskDao;
    private static Logger logger = LoggerFactory.getLogger(DppmTaskService.class);
    @Override
    public Map<String, Object> taskList(String emCode) throws BusinessException {
        
        //判断工号是否是PMO
        boolean isPmo = dppmTaskDao.isPMOByEmCode(emCode);
        
        //查询项目
        Map<String,JSONObject> projectMap = dppmTaskDao.getProjectInfoMap(isPmo, emCode);
        
        //PMO可以看到所有的项目任务，项目任务首次加载任务列表是从最上级任务查找
        List<JSONObject> list = dppmTaskDao.getTaskList(isPmo, emCode);
        
        //项目
        JSONArray arrayPro = new JSONArray();
        //事务
        JSONArray arrayTran = new JSONArray();
        //需求
        JSONArray arrayDemend = new JSONArray();
        //常规
        JSONArray arrayRoutine = new JSONArray();
        
        /**
         * 查询的是员工自己的任务信息
         */
        List<String> filerProTask = new ArrayList<String>();
        Map<String,JSONObject> memMap = new HashMap<String,JSONObject>();
        List<String> thridSub = new ArrayList<String>();
        for (JSONObject jsonObject : list) {
            //任务Id
            String taskId = jsonObject.getString("id");
            //父任务Id
            String taskParent = jsonObject.getString("taskParent");
            if ("1".equals(jsonObject.getString("taskCategory"))
                && projectMap.containsKey(jsonObject.getString("projectId"))) {
                
                // 项目类任务，并且在分配的时候选择对应的项目
                if (!StringUtil.isEmpty(taskParent)) {
                    if (!filerProTask.contains(taskParent)) {
                        if (projectMap.get(jsonObject.getString("projectId"))
                                .containsKey("subTasks")) {
                            projectMap.get(jsonObject.getString("projectId"))
                                    .getJSONArray("subTasks").add(jsonObject);
                        } else {
                            JSONArray subarrayPro = new JSONArray();
                            subarrayPro.add(jsonObject);
                            projectMap.get(jsonObject.getString("projectId"))
                                    .put("subTasks", subarrayPro);
                        }
                    }
                } else {
                    if (projectMap.get(jsonObject.getString("projectId"))
                            .containsKey("subTasks")) {
                        projectMap.get(jsonObject.getString("projectId"))
                                .getJSONArray("subTasks").add(jsonObject);
                    } else {
                        JSONArray subarrayPro = new JSONArray();
                        subarrayPro.add(jsonObject);
                        filerProTask.add(taskId);
                        projectMap.get(jsonObject.getString("projectId")).put(
                                "subTasks", subarrayPro);
                    }
                }

                filerProTask.add(taskId);
            } else {
                if (StringUtil.isEmpty(taskParent) || "0".equals(taskParent)) {
                    memMap.put(taskId, jsonObject);
                } else {
                    /** 过滤2层以下的任务 */
                    if (!thridSub.contains(taskParent)) {
                        /**
                         * 子任务的TaskId一定大于父任务的TaskId，按TaskId排序后,子 任务一定在父任务之后
                         */
                    	//抽取方法
                        setMenMap(memMap, thridSub, jsonObject, taskId,
								taskParent);
                    }
                }
            }
        }
        
        //项目Map->List
        for (JSONObject object : projectMap.values()) {
            arrayPro.add(object);
        }
        
        if(!memMap.isEmpty()){
            for (JSONObject json : memMap.values()) {
                //项目类别
                String taskCategory = json.getString("taskCategory");
                if("1".equals(taskCategory)){
                    arrayPro.add(json);
                }else if("2".equals(taskCategory)){
                    arrayTran.add(json);
                }else if("3".equals(taskCategory)){
                    arrayDemend.add(json);
                }else if("4".equals(taskCategory)){
                    arrayRoutine.add(json);
                }
             }
        }
        
        //获取需要审核的任务数
        int count = dppmTaskDao.getTaskCommitCount(emCode);
        Map<String, Object> ret = new HashMap<String, Object>();
        //项目
        ret.put("projectTask", arrayPro);
        //事务
        ret.put("tranTask", arrayTran);
        //需求
        ret.put("demendTask", arrayDemend);
        //常规
        ret.put("routineTask", arrayRoutine);
        //需要审核的任务数
        ret.put("commitCount", count);
        //是否PMO
        ret.put("isPmo", isPmo);
        return ret;
    }

	private void setMenMap(Map<String, JSONObject> memMap,
			List<String> thridSub, JSONObject jsonObject, String taskId,
			String taskParent) {
		if (memMap.containsKey(taskParent)) {
		    if (memMap.get(taskParent).containsKey("subTasks")) {
		        memMap.get(taskParent).getJSONArray("subTasks")
		                .add(jsonObject);
		    } else {
		        JSONArray subArr = new JSONArray();
		        subArr.add(jsonObject);
		        thridSub.add(taskId);
		        memMap.get(taskParent).put("subTasks", subArr);
		    }
		} else {
		    memMap.put(taskId, jsonObject);
		}
	}
    
    /**
     * 获取一个任务的两层子任务
     * @param taskId
     * @param taskCategory
     * @return
     */
    @Override
    public List<JSONObject> getSubTaskList(String taskIds) throws BusinessException {
        
        Map<String,JSONObject> map = dppmTaskDao.getSubTaskMap(taskIds);
        List<JSONObject> list = new ArrayList<JSONObject>();
        for (JSONObject jsonBject : map.values()) {
            list.add(jsonBject);
        }
        
        return list;
    }
    /**
	 * 任务新建
	 * 2015-10-21  高春玲
	 * @param task 任务实体
	 * @return
	 */
	public int addTask(TasksEntity task) throws BusinessException {
		// TODO 问题风险分配任务，判断是否超挂靠项目的总工时
		int type = judgeRiskTask(task);
		// -1代表超出挂靠项目的总工时
		if(type != -1){
			// 执行任务新建
			type = this.dppmTaskDao.addTask(task);
			
			if(type > 0){
			    //更新问题风险状态
			    String riskId = task.getRiskId();
			    logger.info("风险问题riskId: " + riskId);
			    if(!StringUtil.isEmpty(riskId) && riskId.matches("^[0-9]*$")){
			        int up = this.dppmTaskDao.updateRiskStatus(Integer.parseInt(riskId));
			        logger.info("风险问题状态更新状态为: " + up);
			    }else{
			        logger.info("风险问题状态更新失败！riskId: " + riskId);
			    }
			}
			
		}
		// 返回
		return type;
	}
	/**
	 * 任务新建  
	 * 问题风险任务，总工时判断
	 * 
	 * @param task
	 * @return
	 */
	private int judgeRiskTask(TasksEntity task){
		// 默认值0
		int type = 0;
		// 问题风险id 是否有值
		if(StringUtils.isNotBlank(task.getRiskId())){
			// 项目编码
			int projCode = task.getTaskProjectId();
			// 界面录入计划工时
			BigDecimal duration = task.getTaskDuration();
			// 可分配工时
			String assignableHour = this.dppmTaskDao.getAssignableHour(String.valueOf(projCode));
			// 转换
			BigDecimal assignable=new BigDecimal(assignableHour);
			// 比较工时  -1,0,1
			type = assignable.compareTo(duration);
		}
		// 返回
		return type;
	}
	
	/**
	 * 任务更新信息
	 * 2015-11-13 高春玲
	 * @param task
	 * @return
	 */
	public int updateTask(TasksEntity task) {
		return this.dppmTaskDao.updateTask(task);
	}
	/**
     * 删除任务 修改状态为 1
     * @param taskid
     * @return
     */
	public int delTask(String taskid) {
		return this.dppmTaskDao.delTask(taskid);
	}
	/**
     * 终止任务 修改状态为 5
     * @param taskid
     * @return
     */
	public int stopTask(String taskid) {
		return this.dppmTaskDao.stopTask(taskid);
	}
    @Override
    public List<JSONObject> myTask(String emCode) throws BusinessException {
        return dppmTaskDao.getMyTask(emCode);
    }

    public void setDppmTaskDao(IDppmTaskDao dppmTaskDao) {
        this.dppmTaskDao = dppmTaskDao;
    }
	/**
	 *  2015-11-04
	 *  Title:暂存查询
	 *  @param taskId
	 * */
	@Override
	public String queryTask(String taskId) {
		return JsonUtil.listToJsonString(dppmTaskDao.queryTask(taskId));
	}

}

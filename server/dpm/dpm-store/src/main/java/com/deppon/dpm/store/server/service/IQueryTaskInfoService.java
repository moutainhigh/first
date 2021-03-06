package com.deppon.dpm.store.server.service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.store.server.entity.QueryAppraisal;
import com.deppon.dpm.store.server.entity.QueryModInfo;
import com.deppon.dpm.store.server.entity.QueryTaskInfo;
import com.deppon.dpm.store.server.entity.StoreTaskSublist;
/**
 * @date 2018年6月4日19:22:53
 * @author RY
 *
 */
public interface IQueryTaskInfoService {
	/**
	 * 根据执行id 查询考评结果相关信息
	 */
	QueryTaskInfo queryAppraisalByExeid(Long exeid);
	/**
	 *  根据执行id 查询考评详情
	 */
	List<QueryAppraisal> queryAppraisal(Long exeid);
	/**
	 * 添加反馈
	 */
	boolean insertFeedback(Long exeid,String feedbackinfo,String picpath);
	/**
	 * 查询反馈
	 */
	List<QueryAppraisal> queryFeedback(Long exeid);
	/**
	 * 添加反馈后 修改任务子表状态为已完成,提交时间为当前时间
	 */
	Integer updatesublist(Long exeid,String submittime);
	/**
	 * 根据执行id查询所有主任务下的所有子任务的任务状态和主任务id
	 */
	List<StoreTaskSublist> queryAllTaskStatusByexeid(Long exeid);
	/**
	 * 当子任务都已反馈，根据主任务id来修改主任务状态为已完成，完成时间为当前时间
	 */
	Integer updatetask(Integer taskid,String finishtime);
	/**
	 * 添加模块 
	 */
	Boolean insertmod(String firstmodname,String firstremarks,String secondmodname,String secondremarks);
	/**
	 * 查询所有模块信息
	 */
	List<Map<String,Object>> queryAllModInfo();
	/**
	 * 根据执行id查询营业部负责人工号
	 */
	String querydeptapidByExeid(Long exeid);
	/**
	 * 根据传递查询条件(我创建已完成未完成我执行)查询任务信息  
	 */
	List<QueryTaskInfo> selcetTaskByQueryCondition(Map<String, Object> map);
}

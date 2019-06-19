package com.deppon.montal.util.redis.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import com.deppon.montal.conf.WorkflowListService;
import com.deppon.montal.conf.domain.WorkflowInfo;
import com.deppon.montal.util.redis.util.JedisConstant;
import com.deppon.montal.util.redis.util.JedisUtil;

/**
 * 初始化工作流配置信息
 * @author shangxu
 *
 */
public class InitWorkflowInfo {
private static Logger logger = null;
	
	static{
		logger = Logger.getLogger(InitWorkflowInfo.class);
	}
	/**
	 * 初始化所有的工作流信息，放到redis缓存中
	 */
	public static void initAllWorkflow2Redis() {
		

		logger.info("------------------------------->initAllWorkflow2Redis begin");
		Jedis jedis = JedisUtil.createJedis();
		try{
			List<WorkflowInfo> workflowList = QueryUtil.queryAllWorkflowInof();
			if(workflowList != null && workflowList.size() > 0){
				Pipeline p = jedis.pipelined();
				for(WorkflowInfo workflow : workflowList){
					Map<String, String> map = new HashMap<String, String>();
					String id = workflow.getId();
					String workflowname = workflow.getWorkflowname();
					String jspname = workflow.getJspname();
					Date createtime = workflow.getCreatetime();
					String syscode = workflow.getSyscode();
					map.put("id", id);
					map.put("workflowname", workflowname);
					map.put("jspname", jspname == null ? "" : jspname);
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					map.put("createtime",  df.format(createtime));
					map.put("syscode",  syscode);
					map.put("classname",  workflow.getClassName());
					map.put("entryproperty",  workflow.getEntryProperty());
					p.hmset(JedisConstant.DPMONTAL_DPMON_WORKFLOW + workflowname, map);
				}
				p.sync();
			}
		}catch(Exception ex){
			JedisUtil.returnBrokenResource(jedis);
			logger.info("[InitWorkflowInfo initAllWorkflow2Redis]" + ex.getMessage());
		}finally{
			//return the Jedis instance to the pool
			JedisUtil.releaseJedis(jedis);
		}
		logger.info("------------------------------->initAllWorkflow2Redis over");
	}
	/**
	 * 同步工作流信息
	 */
	public static void synWorkflowInfo(){
		logger.info("开始同步redis缓存中的dpmon_workflow和数据库中的dpmon_workflow一一对应的关系");
		Jedis j = JedisUtil.createJedis();
		List<String> lst = new ArrayList<String>();
		try{
			List<WorkflowInfo> workflowList = QueryUtil.queryAllWorkflowInof();
			if(workflowList != null && workflowList.size() > 0){
				for(WorkflowInfo workflow : workflowList){
					lst.add(workflow.getWorkflowname());
				}
			}
			Set<String> set = j.keys(JedisConstant.DPMONTAL_DPMON_WORKFLOW+"*");
			Iterator<String> it = set.iterator();
			while(it.hasNext()){
				String workflowname = it.next();
				workflowname = workflowname.substring(workflowname.lastIndexOf(":")+1, workflowname.length());
				if(!lst.contains(workflowname)){
					logger.info("redis缓存中被删除的工作流是：" + workflowname);
					j.del(JedisConstant.DPMONTAL_DPMON_WORKFLOW + workflowname);
				}
			}
			WorkflowListService.getInstance().syncWorkflow();
		}catch(Exception ex){
			JedisUtil.returnBrokenResource(j);
			logger.info("[InitWorkflowInfo synWorkflowInfo]" + ex.getMessage());
			ex.printStackTrace();
		}finally{
			JedisUtil.releaseJedis(j);
		}
	}
	/**
	 *  //TODO 获取缓存中所有的工作流信息
	 */
	public static List<WorkflowInfo> getAllWorkflowFromRedis() {
		Jedis jedis = JedisUtil.createJedis();
		List<WorkflowInfo> list = new ArrayList<WorkflowInfo>();
		WorkflowInfo tp = null;
		try{
			Set<String> set = jedis.keys(JedisConstant.DPMONTAL_DPMON_WORKFLOW+"*");
			for(String work:set) {
				logger.info("【InitWorkflowInfo---->getAllWorkflowFromRedis--->获取所有的工作流信息】:" + JedisConstant.DPMONTAL_DPMON_WORKFLOW + work);
				tp = new WorkflowInfo();
				String id = jedis.hget(work, "id");
				String workflowname = jedis.hget(work, "workflowname");
				String jspname = jedis.hget(work, "jspname");
				String syscode = jedis.hget(work, "syscode");
				String createtime = jedis.hget(work, "createtime");
				String className = jedis.hget(work, "classname");
				String entryProperty = jedis.hget(work, "entryproperty");
				tp.setId(id);
				tp.setJspname(jspname);
				tp.setWorkflowname(workflowname);
				tp.setSyscode(syscode);
				tp.setClassName(className);
				tp.setEntryProperty(entryProperty);
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				tp.setCreatetime(df.parse(createtime));
				list.add(tp);
			}
			
		}catch(Exception ex){
			JedisUtil.returnBrokenResource(jedis);
			logger.info("[InitWorkflowInfo getAllWorkflowFromRedis]" + ex.getMessage());
			ex.printStackTrace();
		}finally{
			JedisUtil.releaseJedis(jedis);
		}
		return list;
	}

}

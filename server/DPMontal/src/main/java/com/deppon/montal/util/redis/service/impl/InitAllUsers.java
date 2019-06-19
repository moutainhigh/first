package com.deppon.montal.util.redis.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.model.DpmonEmployee;
import com.deppon.montal.model.DpmonRoleJobname;
import com.deppon.montal.util.redis.util.JedisConstant;
import com.deppon.montal.util.redis.util.JedisUtil;

public class InitAllUsers {

	private static Logger logger = null;
	
	static{
		logger = Logger.getLogger(UserRedisService.class);
	}
	/**
	 * 初始化所有的用户信息，放到redis缓存中
	 */
	public static void initAllUser2Redis() {
		logger.info("------------------------------->initAllUser2Redis begin");
		Jedis jedis = JedisUtil.createJedis();
		try{
			
			List<LoginUser> userList = QueryUtil.queryAllUsers();
			if(userList != null && userList.size() > 0){
				
				Pipeline p = jedis.pipelined();

				for(LoginUser user : userList){
					Map<String,String> userMap = new HashMap<String, String>();
					
					String userId = user.getUserId();
					String empId = user.getEmpId() + "";
					String empName = user.getEmpName();
					String jobName = user.getJobName();
					
					userMap.put("userId", userId);
					userMap.put("empId", empId);
					userMap.put("empName", empName == null ? "" : empName);
					userMap.put("jobName", jobName == null ? "" : jobName);
					
					p.hmset(JedisConstant.DPMONTAL_USER + userId, userMap);
				}
				p.sync();
			}
		}catch(Exception ex){
			JedisUtil.returnBrokenResource(jedis);
			logger.info("[InitAllUsers initAllUser2Redis]" + ex.getMessage());
		}finally{
			//return the Jedis instance to the pool
			JedisUtil.releaseJedis(jedis);
		}
		logger.info("------------------------------->initAllUser2Redis over");
	}
	
	/**
	 * 初始化权限的信息
	 * RoleJobname
	 */
	public static void initAllRoleJobname(){
		logger.info("------------------------------->initAllRoleJobname begin");
		Jedis jedis = JedisUtil.createJedis();
		try{
			List<DpmonRoleJobname> rjList = QueryUtil.queryAllRoleJobname();
			if(rjList != null && rjList.size() > 0){
				Pipeline p = jedis.pipelined();
				for(DpmonRoleJobname rj : rjList){
					Map<String,String> rjMap = new HashMap<String, String>();
					String id = rj.getId() + "";
					String jobName = rj.getJobname();
					rjMap.put("id", id);
					rjMap.put("jobName", jobName == null ? "" : jobName);
					p.hmset(JedisConstant.DPMONTAL_DPMON_ROLE_JOBNAME + jobName, rjMap);
				}
				p.sync();
			}
		}catch(Exception ex){
			JedisUtil.returnBrokenResource(jedis);
			logger.info("[InitAllUsers initAllUser2Redis]" + ex.getMessage());
			ex.printStackTrace();
		}finally{
			//return the Jedis instance to the pool
			JedisUtil.releaseJedis(jedis);
		}
		logger.info("------------------------------->initAllRoleJobname over");
	}
	/**
	 * 初始化权限的信息
	 * dpmon_employee
	 */
	public static void initAllDpmonEmployee(){
		logger.info("----------------------------------->initAllDpmonEmployee begin");
		Jedis jedis = JedisUtil.createJedis();
		try{
			List<DpmonEmployee> empList = QueryUtil.queryAllDpmonEmployee();
			if(empList != null && empList.size()>0){
				Pipeline p = jedis.pipelined();
				for(DpmonEmployee emp : empList){
					Map<String,String> empMap = new HashMap<String, String>();
					String id = emp.getId() + "";
					String userId = emp.getUserId();
					String userName = emp.getUserName();
					String syscodes = emp.getSyscodes();
					empMap.put("id", id);
					empMap.put("userId", userId == null ? "" : userId);
					empMap.put("userName",userName == null ? "" : userName);
					empMap.put("syscodes",syscodes == null ? "" : syscodes);
					p.hmset(JedisConstant.DPMONTAL_DPMON_EMPLOYEE + userId, empMap);
				}
				p.sync();
			}
		}catch(Exception ex){
			JedisUtil.returnBrokenResource(jedis);
			logger.info("[InitAllUsers initAllUser2Redis]" + ex.getMessage());
			ex.printStackTrace();
		}finally{
			//return the Jedis instance to the pool
			JedisUtil.releaseJedis(jedis);
		}
		logger.info("----------------------------------->initAllDpmonEmployee over");
	}
	/**
	 * redis缓存中的employee和role信息要和数据库中的信息同步
	 * 若是数据库汇总删除，redis中对应的也要删除
	 */
	public static void synDpmonEmployee() {
		logger.info("开始同步redis缓存中的employee和数据库中的employee一一对应的关系");
		Jedis j = JedisUtil.createJedis();
		List<String> lst = new ArrayList<String>();
		try{
			List<DpmonEmployee> empList = QueryUtil.queryAllDpmonEmployee();
			if(empList != null && empList.size() > 0){
				for(DpmonEmployee emp : empList){
					lst.add(emp.getUserId());
				}
			}
			Set<String> set = j.keys(JedisConstant.DPMONTAL_DPMON_EMPLOYEE+"*");
			Iterator<String> it = set.iterator();
			while(it.hasNext()){
				String empId = it.next();
				empId = empId.substring(empId.lastIndexOf(":")+1, empId.length());
				if(!lst.contains(empId)){
					logger.info("redis缓存中被删除的用户是：" + empId);
					j.del(JedisConstant.DPMONTAL_DPMON_EMPLOYEE + empId);
				}
			}
		}catch(Exception ex){
			JedisUtil.returnBrokenResource(j);
			logger.info("[InitAllUsers synDpmonEmployee]" + ex.getMessage());
			ex.printStackTrace();
		}finally{
			JedisUtil.releaseJedis(j);
		}
	}
	/**
	 * 同步角色
	 */
	public static void synRole(){
		logger.info("开始同步redis缓存中的role jobname和数据库中的role jobname一一对应的关系");
		Jedis j = JedisUtil.createJedis();
		List<String> lst = new ArrayList<String>();
		try{
			List<DpmonRoleJobname> rjList = QueryUtil.queryAllRoleJobname();
			if(rjList != null && rjList.size() > 0){
				for(DpmonRoleJobname role : rjList){
					lst.add(role.getJobname());
				}
			}
			Set<String> set = j.keys(JedisConstant.DPMONTAL_DPMON_ROLE_JOBNAME + "*");
			Iterator<String> it = set.iterator();
			while(it.hasNext()){
				String jobname = it.next();
				jobname = jobname.substring(jobname.lastIndexOf(":") + 1, jobname.length());
				if(!lst.contains(jobname)){
					logger.info("redis缓存中被删除的角色是：" + jobname);
					j.del(JedisConstant.DPMONTAL_DPMON_ROLE_JOBNAME + jobname);
				}
			}
		}catch(Exception ex){
			JedisUtil.returnBrokenResource(j);
			logger.info("[InitAllUsers synRole]" + ex.getMessage());
			ex.printStackTrace();
		}finally{
			JedisUtil.releaseJedis(j);
		}
	}
}

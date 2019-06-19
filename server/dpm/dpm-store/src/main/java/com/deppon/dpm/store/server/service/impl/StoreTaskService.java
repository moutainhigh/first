package com.deppon.dpm.store.server.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.deppon.dpm.store.server.dao.IStoreDynamicsDao;
import com.deppon.dpm.store.server.dao.IStoreMarkDao;
import com.deppon.dpm.store.server.dao.IStoreTaskDao;
import com.deppon.dpm.store.server.dao.IStoreTaskSublistDao;
import com.deppon.dpm.store.server.entity.StoreDynamics;
import com.deppon.dpm.store.server.entity.StoreMark;
import com.deppon.dpm.store.server.entity.StoreTask;
import com.deppon.dpm.store.server.entity.StoreTaskSublist;
import com.deppon.dpm.store.server.service.IStoreTaskService;
import com.deppon.dpm.store.server.util.IdWorker;
import com.deppon.dpm.store.server.vo.StoreTaskVo;

/**
 * 
 * @author RY
 *
 */
@Transactional
public class StoreTaskService implements IStoreTaskService {
	// dao
	private IStoreTaskDao storeTaskDao;

	/**
	 * 注入任务子表
	 */
	private IStoreTaskSublistDao storeTaskSublistDao;
	
	/**
	 * 注入巡检模块表
	 */
	private IStoreMarkDao storeMarkDao;
	
	/**
	 * 日志
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(StoreTaskService.class);
	
	private final String taskstatus = "待考评";
	
	/**
	 * 
	 * @return
	 */
	public IStoreTaskSublistDao getStoreTaskSublistDao() {
		return storeTaskSublistDao;
	}
	/**
	 * 
	 * @param storeTaskSublistDao
	 */
	public void setStoreTaskSublistDao(IStoreTaskSublistDao storeTaskSublistDao) {
		this.storeTaskSublistDao = storeTaskSublistDao;
	}
	
	/**
	 * 
	 * @return
	 */
	public IStoreTaskDao getStoreTaskDao() {
		return storeTaskDao;
	}

	/**
	 * 
	 * @param storeTaskDao
	 */
	public void setStoreTaskDao(IStoreTaskDao storeTaskDao) {
		this.storeTaskDao = storeTaskDao;
	}

	
	@Override
	public int insertSelective(StoreTask record) {
		// TODO Auto-generated method stub
		StoreTask storeTask = storeTaskDao.insertSelective(record);
		return storeTask !=null ? 1 : 0;
	}
	/**
	 * @author XiaoTian
	 * @param record
	 * @param checkingModule
	 * @param executorDepartment
	 * @return
	 */
	@Override
	public boolean insertTask(StoreTask record, ArrayList<Integer> checkingModule,
			ArrayList<StoreTaskVo> executorDepartment) {
		boolean bool = true;
		try {
			StoreTask storeTask = storeTaskDao.insertSelective(record);
			if (null != storeTask) {
				logger.info("创建任务成功,开始创建营业部任务信息-------------");
				//生成有序的id
		    	int count = executorDepartment.size();
		    	List<Long> longlist = createId(count);
				// 循环添加多个任务子表数据
				List<StoreTaskSublist> storeTaskSublists = new ArrayList<StoreTaskSublist>();
				for (int i = 0; i < count; i++) {
					StoreTaskVo storeTaskVo = executorDepartment.get(i);
					// 实例化任务子类
					StoreTaskSublist storeTaskSublist = new StoreTaskSublist();
					//添加数据
					storeTaskSublist.setExeid(longlist.get(i));
					storeTaskSublist.setTaskid(storeTask.getTaskid());//任务id
					storeTaskSublist.setExeer(storeTaskVo.getExeer());//执行人
					storeTaskSublist.setDeptname(storeTaskVo.getOrgname());//营业部名称
					storeTaskSublist.setTestgrade(new BigDecimal("0.0"));//自检总分
					storeTaskSublist.setDeptlerdername(storeTaskVo.getEmpname());// 营业部负责人名称
					storeTaskSublist.setStarttime(record.getStarttime());//开始时间
					storeTaskSublist.setEndtime(record.getEndtime());//结束时间
					storeTaskSublist.setDeptnum(storeTaskVo.getOrgcode());//营业部编号
					storeTaskSublist.setTaskstatus("待考评");//任务状态
					storeTaskSublist.setExeerid(storeTaskVo.getExeerid());//执行人id
					storeTaskSublist.setDeptapid(storeTaskVo.getEmpcode());//部门负责人id
					storeTaskSublist.setDr(0);//0默认为，显示数据
					storeTaskSublist.setTs(storeTask.getTs());//默认当前时间
					storeTaskSublists.add(storeTaskSublist);
				}
				//批量插入进行插入子任务
				storeTaskSublistDao.insertSelectives(storeTaskSublists);			
				//接收所有模块的值
				List<StoreMark> storeMarkslsit = new ArrayList<StoreMark>();
//				//循环获取执行id放入模块中
				for (StoreTaskSublist storeTaskSublist : storeTaskSublists) {
					for (Integer value : checkingModule) {
						StoreMark storeMark = new StoreMark();
						storeMark.setExeid(storeTaskSublist.getExeid());
						storeMark.setModid(value);
						storeMark.setDr(0);// 0默认为，显示数据
						storeMark.setTs(storeTaskSublist.getTs());// 默认当前时间
						storeMarkslsit.add(storeMark);
					}
				}
				//批量插入模块
				storeMarkDao.insertSelective(storeMarkslsit);
			} else {
				logger.error("创建主任务失败,主任务参数异常-------------");
				bool = false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("创建任务运行时异常,创建任务进行回滚-------------");
			logger.error("创建任务失败-------------");
			bool = false;
			throw new RuntimeException();
		}
		return bool;
	}
	// 根据任务id查询任务子表中 总条数 ，已完成任务数量
		@Override
		public StoreTask selectsublistinfo(Integer taskid) {
			// TODO Auto-generated method stub
			return storeTaskDao.selectsublistinfo(taskid);
		}

	// 根据任务id查询提交时间
	@Override
	public List<String> selectsublistvdef1(Integer taskid) {
		// TODO Auto-generated method stub
		return storeTaskDao.selectsublistvdef1(taskid);
	}
	/**
	 * 
	 * @return
	 */
	public IStoreMarkDao getStoreMarkDao() {
		return storeMarkDao;
	}
	/**
	 * 
	 * @param storeMarkDao
	 */
	public void setStoreMarkDao(IStoreMarkDao storeMarkDao) {
		this.storeMarkDao = storeMarkDao;
	}
	@Override
	public boolean taskUpdate(StoreTask storeTask,ArrayList<Integer> checkingModule,
			ArrayList<StoreTaskVo> executorDepartment) {
		// TODO Auto-generated method stub
		boolean bool = true;
		try {
			logger.info("修改任务 Start---------");
			Map<String, Object> map = new HashMap<String, Object>();
			//主任务id
			map.put("taskid", storeTask.getTaskid());
			//任务状态
			map.put("taskstatus", taskstatus);
			//查询子任务是否有考评
			int countSublist = storeTaskDao.SublistCount(map);
			storeTaskDao.finecreatorcode(storeTask.getTaskid());
			int countTask = storeTaskDao.taskExist(storeTask.getTaskid());
			if(countSublist <= 0 && countTask >=1){
				//修改主任务
				storeTaskDao.taskUpdate(storeTask);
				//查询主任务下所有子任务 Exeid
				List<String> listExeid = storeTaskDao.SelectExeid(storeTask.getTaskid());
				//删除子任务
				storeTaskDao.DeteleSublist(storeTask.getTaskid());
				//删除子任务所有模块
				storeTaskDao.DeteleMark(listExeid);
				//生成有序的id
				int count = executorDepartment.size();
		    	List<Long> longlist = createId(count);
				// 循环添加多个任务子表数据
				List<StoreTaskSublist> storeTaskSublists = new ArrayList<StoreTaskSublist>();
				for (int i = 0; i < count; i++) {
					StoreTaskVo storeTaskVo = executorDepartment.get(i);
					// 实例化任务子类
					StoreTaskSublist storeTaskSublist = new StoreTaskSublist();
					//添加数据
					storeTaskSublist.setExeid(longlist.get(i));
					storeTaskSublist.setTaskid(storeTask.getTaskid());//任务id
					storeTaskSublist.setExeer(storeTaskVo.getExeer());//执行人
					storeTaskSublist.setDeptname(storeTaskVo.getOrgname());//营业部名称
					storeTaskSublist.setTestgrade(new BigDecimal("0.0"));//自检总分
					storeTaskSublist.setDeptlerdername(storeTaskVo.getEmpname());// 营业部负责人名称
					storeTaskSublist.setStarttime(storeTask.getStarttime());//开始时间
					storeTaskSublist.setEndtime(storeTask.getEndtime());//结束时间
					storeTaskSublist.setDeptnum(storeTaskVo.getOrgcode());//营业部编号
					storeTaskSublist.setTaskstatus("待考评");//任务状态
					storeTaskSublist.setExeerid(storeTaskVo.getExeerid());//执行人id
					storeTaskSublist.setDeptapid(storeTaskVo.getEmpcode());//部门负责人id
					storeTaskSublist.setDr(0);//0默认为，显示数据
					storeTaskSublist.setTs(storeTask.getTs());//默认当前时间
					storeTaskSublists.add(storeTaskSublist);
				}
				//批量插入进行插入子任务
				storeTaskSublistDao.insertSelectives(storeTaskSublists);			
				//接收所有模块的值
				List<StoreMark> storeMarkslsit = new ArrayList<StoreMark>();
//				//循环获取执行id放入模块中
				for (StoreTaskSublist storeTaskSublist : storeTaskSublists) {
					for (Integer value : checkingModule) {
						StoreMark storeMark = new StoreMark();
						storeMark.setExeid(storeTaskSublist.getExeid());
						storeMark.setModid(value);
						storeMark.setDr(0);// 0默认为，显示数据
						storeMark.setTs(storeTaskSublist.getTs());// 默认当前时间
						storeMarkslsit.add(storeMark);
					}
				}
				//批量插入模块
				storeMarkDao.insertSelective(storeMarkslsit);
			}else{
				logger.error("修改任务失败 条件不成立-------------");
				throw new RuntimeException();
			}
			logger.info("修改任务 End ---------");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("修改任务运行时异常,修改任务进行回滚-------------");
			logger.error("修改任务失败-------------");
			bool = false;
			throw new RuntimeException();
		}
		return bool;
	}
	
	//生成有序的id
	public List<Long> createId(int count){
		IdWorker idWorker = new IdWorker(1,1);
    	List<Long> longlist = new ArrayList<Long>();
    	for (int i = 0; i < count; i++) {
    		long longs = idWorker.nextId();
    		longlist.add(longs);
		}
    	return longlist;
	}
	
}

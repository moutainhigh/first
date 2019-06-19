package com.deppon.dpm.store.server.service;

import java.util.ArrayList;
import java.util.List;

import com.deppon.dpm.store.server.entity.StoreTask;
import com.deppon.dpm.store.server.vo.StoreTaskVo;

public interface IStoreTaskService {

	int insertSelective(StoreTask record);

	
	/**
	 * @author XiaoTian
	 * @param record
	 * @param checkingModule
	 * @param executorDepartment
	 * @return
	 */
	boolean insertTask(StoreTask record, ArrayList<Integer> checkingModule,
			ArrayList<StoreTaskVo> executorDepartment);
	// 根据任务id查询任务子表中 总条数 ，已完成任务数量
	StoreTask selectsublistinfo(Integer integer);
	/*// 根据用户工号查询任务主表中 任务id 且任务自己为创建人
	List<Integer> selecttaskMCid(String creatorcode, String startTime, String endTime, String taskName);

	// 根据用户工号查询任务主表中 任务id 且任务未完成
	List<Integer> selecttaskUFid(String creatorcode,String taskstatus, String startTime, String endTime, String taskName);

	// 根据用户工号查询任务主表中 任务id 且任务已完成
	List<Integer> selecttaskFNid(String creatorcode,String taskstatus, String startTime, String endTime, String taskName);

	// 根据用户工号查询任务主表中 任务id 且任务自己为执行人
	List<Integer> selecttaskMPid(String creatorcode, String startTime, String endTime, String taskName);

	// 根据任务id查询任务主表中 任务名称，任务截止日期，创建人，任务开始时间
	StoreTask selecttaskinfo(Integer taskid);

	

	// 根据任务id查询动态表 总条数
	StoreTask selectdynamicssum(Integer taskid);*/

	// 根据任务id查询提交时间
	List<String> selectsublistvdef1(Integer integer);
	
	//任务编辑
	boolean taskUpdate(StoreTask storeTask,ArrayList<Integer> checkingModule, ArrayList<StoreTaskVo> executorDepartment);
}

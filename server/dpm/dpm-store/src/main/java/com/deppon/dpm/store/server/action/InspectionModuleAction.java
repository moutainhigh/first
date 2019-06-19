package com.deppon.dpm.store.server.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jpush.api.utils.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.store.server.entity.StoreMark;
import com.deppon.dpm.store.server.entity.StoreTask;
import com.deppon.dpm.store.server.entity.StoreTaskSublist;
import com.deppon.dpm.store.server.service.IInspectionModuleService;
import com.deppon.dpm.store.server.service.IStoreTaskService;
import com.deppon.dpm.store.server.util.OverdueTime;
import com.deppon.dpm.store.server.util.ResultData;
import com.deppon.dpm.tongxunlu.server.service.ISelectAllDeptService;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.domain.SelectAllDeptEntity;

/**
 * @Desciption:TODO(子任务详情,打分)
 * @author: lvdefu
 * @date:2018年5月26日15:16:39
 * @className:InspectionModuleAction
 */
public class InspectionModuleAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = -918153112019898134L;
	/**
	 * 打印日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(InspectionModuleAction.class);
	
	//主任务id
	private String taskId;
	
	//员工号
	private String userId;
	
	//执行任务ID
	private String exeid;
	
	//状态
	private String navmod;
	
	//注入service
	private IInspectionModuleService inspectionModuleService;
	
	//注入通讯录service
	private ISelectAllDeptService selectAllDeptService;
	
	// 查询任务信息service
	private IStoreTaskService storeTaskService;
	
	/**
	 * @deciption:TODO(查询任务详情)
	 * @author lvdefu
	 * @date   2018年5月31日14:52:06
	 * @param  taskId
	 * @param  userId
	 * @return null
	 */
	@SuppressWarnings("all")
	//@CookieNotCheckedRequired
	public void taskDetails(){
		logger.info("查询任务详情开始-------------");
		JSONObject jonum = new JSONObject();
		if(StringUtils.isNotEmpty(taskId) && StringUtils.isNotEmpty(userId)){
			//新建一个listdepart,用来放所有子任务的情况
			List<HashMap<String,Object>> listdepart = new ArrayList<HashMap<String,Object>>();
			//新建一个listInspection,用来放入巡检模块
			List<String> listInspection = new ArrayList<String>();
			//查询主任务
			StoreTask task=inspectionModuleService.querTask(Integer.valueOf(taskId));
			if(task!=null){
				StoreTask StoreTask = new StoreTask();
				StoreTask.setTaskname(task.getTaskname());//主任务名称
				StoreTask.setCreatorname(task.getCreatorname());//创建人姓名  
				StoreTask.setTaskinfo(task.getTaskinfo()); //任务详情
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				StoreTask.setStartTime(formatter.format(task.getStarttime()));//开始时间
				StoreTask.setEndTime(formatter.format(task.getEndtime()));//结束时间
				//调通讯录接口,查询创建人信息
				SelectAllDeptEntity creator = selectAllDeptService.selectdpmAdmin(task.getCreatorcode());
				StoreTask.setOrgName(creator.getOrgname());//组织名称
				StoreTask.setJobname(creator.getJobname());//创建人职位
				//根据任务id获取任务子表内容
				StoreTask sublisttask = storeTaskService.selectsublistinfo(task.getTaskid());
				// 防止空指针
				if (sublisttask != null) {
					// 利用StoreTask中的idef4和idef5存储总条数 ，已完成任务数量
					// vdef5存储结束时间
					// 任务子表中 总条数
					int  denominator = Integer.valueOf(sublisttask.getTaskname());
					// 任务子表 已完成任务数量
					int numerator = Integer.valueOf(sublisttask.getTaskinfo());
					// 获取任务最晚提交时间
					String lastendtime = storeTaskService.selectsublistvdef1((task.getTaskid())).get(0);
					// 定义返回map
					Map<String,String> map = new HashMap<String, String>();
					try {
						//获取当前时间
						Date dt = new  Date();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String currentTime = sdf.format(dt);
						map = OverdueTime.overdue(sdf.format(task.getEndtime()), denominator, numerator, lastendtime==null?currentTime:lastendtime);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//是否逾期
					StoreTask.setIsoverdue(map.get("Isoverdue"));
					//逾期时间
					StoreTask.setOverdueTime(map.get("OverdueTime"));
				}    
				jonum.put("StoreTask", StoreTask);
			}
			//根据主任务taskId去子任务表查询子任务,根据执行人ID分组
			List<StoreTaskSublist> listSubtasks= inspectionModuleService.querySubtasksGroup(Integer.valueOf(taskId));
			if(listSubtasks!=null){
				//第一个子任务的巡检模块(所有子任务的巡检模块都相同)
				List<StoreMark> listModuleNew = inspectionModuleService.queryModule(listSubtasks.get(0).getExeid());
				for (int i = 0; i < listModuleNew.size(); i++) {
					//修改Modid
					listInspection.add(listModuleNew.get(i).getSecondmodname()==null?"":listModuleNew.get(i).getSecondmodname());//拿到巡检模块的名称
				}
				//放入巡检模块到JsonObject
				jonum.put("listInspection", listInspection);
				//循环分组后的子任务拿到所有的执行Id
				ArrayList<String> listExeerId = new ArrayList<String>();
				//查看是否为创建人,创建人可以看全部,执行人只能看自己的
				if(userId.equals(task.getCreatorcode())){
					if("4".equals(navmod)){
						//创建人查自己执行的
						for (int i = 0; i < listSubtasks.size(); i++) {
							//筛选执行人
							if(userId.equals(listSubtasks.get(i).getExeerid())){
								listExeerId.add(listSubtasks.get(i).getExeerid());//放入执行人Id
							}
						}
					}else{
						//创建人查看自己创建的
						for (int i = 0; i < listSubtasks.size(); i++) {
							listExeerId.add(listSubtasks.get(i).getExeerid());//放入执行人Id
						}
					}
				}else{
					//当前用户为执行人
					for (int i = 0; i < listSubtasks.size(); i++) {
						//筛选执行人
						if(userId.equals(listSubtasks.get(i).getExeerid())){
							listExeerId.add(listSubtasks.get(i).getExeerid());//放入执行人Id
						}
					}
				}
				if(listExeerId!=null && listExeerId.size()!=0){
					//循环这个执行人Id
					for (int i = 0; i < listExeerId.size(); i++) {
						List<StoreTaskSublist> listSubtasksNew = inspectionModuleService.querySubtasksByExeerId(listExeerId.get(i),Integer.valueOf(taskId)); //根据执行人Id查询子任务
						//调用通讯录接口查询执行信息,参数为子任务的执行人Id
						SelectAllDeptEntity selectAllDeptEntity = selectAllDeptService.selectdpmAdmin(listSubtasksNew.get(0).getExeerid());
						//新建执行人map,用来放执行人全部信息
						HashMap<String, Object> mapExeer = new HashMap<String,Object>();
						if(selectAllDeptEntity!=null){
							mapExeer.put("exeerName", selectAllDeptEntity.getEmpname()==null?"":selectAllDeptEntity.getEmpname());//执行人姓名
							mapExeer.put("exeerOrgbname",selectAllDeptEntity.getOrgname()==null?"":selectAllDeptEntity.getOrgname());//执行人组织名称
							mapExeer.put("exeerJobname",selectAllDeptEntity.getJobname()==null?"":selectAllDeptEntity.getJobname());//执行人职位
							String exeerPic = selectAllDeptEntity.getPictpath();//执行人头像
							mapExeer.put("exeerPic", exeerPic);//执行人头像
							mapExeer.put("folding", false);//默认打开,不折叠
						}else{
							mapExeer.put("exeerName", "");//执行人姓名
							mapExeer.put("exeerOrgbname",  "");//执行人组织名称
							mapExeer.put("exeerJobname", "");//执行人职位
							mapExeer.put("exeerPic","");//执行人头像
							mapExeer.put("folding", false);//默认打开,不折叠
						}
						int complete=0;//统计已完成状态营业厅的页数
						//新建一个营业部的list,放执行人下子任务信息
						ArrayList listBusiness = new ArrayList();
						//循环该执行人下的子任务
						for (int j = 0; j < listSubtasksNew.size(); j++) {		
							HashMap<String, Object> mapDepart = new HashMap<String,Object>();
							mapDepart.put("exeid", String.valueOf(listSubtasksNew.get(j).getExeid()));//执行id
							mapDepart.put("deptname", listSubtasksNew.get(j).getDeptname()==null?"":listSubtasksNew.get(j).getDeptname());//营业部名称
							mapDepart.put("deptlerdername", listSubtasksNew.get(j).getDeptlerdername()==null?"":listSubtasksNew.get(j).getDeptlerdername());//营业部负责人名称
							//调用通讯录接口查询营业部负责人职位
							SelectAllDeptEntity entity = selectAllDeptService.selectdpmAdmin(listSubtasksNew.get(j).getDeptapid());							
							mapDepart.put("deptApName", entity.getJobname());//营业部负责人职位
							mapDepart.put("taskstatus",listSubtasksNew.get(j).getTaskstatus()==null?"":listSubtasksNew.get(j).getTaskstatus());//子任务状态值
							if("已反馈".equals(listSubtasksNew.get(j).getTaskstatus())){
								//统计已完成的个数
								complete++;
							}
							//子任务营业厅情况放入listbusiness
							listBusiness.add(mapDepart);
							//子任务不为空时,根据子任务的执行id查询巡检模块
							List<StoreMark> listModule = inspectionModuleService.queryModule(listSubtasksNew.get(j).getExeid());
							if(listModule!=null && listModule.size()!=0){
								//每个营业部模块打分list
								ArrayList listMark = new ArrayList();
								for (int k = 0; k < listModule.size(); k++) {
									//放巡检模块 的map
									HashMap<String, Object> mapMark = new HashMap<String,Object>();
									//修改Modid
									mapMark.put("modname", listModule.get(k).getModid()==null?0:listModule.get(k).getSecondmodname());//模块名
									mapMark.put("grade", listModule.get(k).getGrade()==null?"":listModule.get(k).getGrade());//模块得分
									String lable = listModule.get(k).getLabel();
									if(StringUtils.isNotEmpty(lable)){
										String[] lableArray = lable.split(",");
										mapMark.put("label",lableArray);//标签
									}else{
										ArrayList<String> listtemp = new ArrayList<String>();
										mapMark.put("label",listtemp);//标签
									}
									//模块打分情况放入map
									listMark.add(mapMark);
								}
								mapDepart.put("listMark", listMark);	
							}else{
								//每个营业部模块打分list
								ArrayList listMark = new ArrayList();
								mapDepart.put("listMark", listMark);	
							}
						}
						mapExeer.put("complete", complete);//放入已完成个人数
						mapExeer.put("business", listSubtasksNew.size());//放入已完成个人数
						mapExeer.put("listBusiness", listBusiness);//放入营业部信息
						//把map放入listdepart
						listdepart.add(mapExeer);
						jonum.put("listdepart", listdepart);//放入jsonObject
					}
				}else{
					//如果子任务不存在,返回空的list
					List<StoreTaskSublist> listTemp = new ArrayList<StoreTaskSublist>();
					jonum.put("listdepart", listTemp);//各营业部详情
					jonum.put("listInspection", listTemp);//巡检模块
					jonum.put("msg", "改员工下无执行任务");
					logger.info("改员工下无执行任务------------");
				}
			}else{
				//如果子任务不存在,返回空的list
				List<StoreTaskSublist> listTemp = new ArrayList<StoreTaskSublist>();
				jonum.put("listdepart", listTemp);//各营业部详情
				jonum.put("listInspection", listTemp);//巡检模块
				jonum.put("msg", "该主任务不存在子任务");
				logger.info("该主任务不存在子任务------------");
			}
		}else{
			jonum.put("msg", "主任务ID和工号不能为空");
			logger.info("主任务ID和工号不能为空------------");
		}	
		writeToPage(jonum);
	}
	
	/**
	 * 跳转待考评页面
	 * @author lvdefu
	 * @date   2018年7月4日17:04:40
	 * @return
	 */
	@SuppressWarnings("all")
	//@CookieNotCheckedRequired
	public void queryScore(){
		logger.info("跳转待考评页面开始------------");
		JSONObject json = new JSONObject();
		if(StringUtils.isNotEmpty(exeid)){
			//根据执行ID查询巡检模块
			List<StoreMark> list=inspectionModuleService.queryModByExeid(Long.valueOf(exeid));
			if(list!=null){
				HashSet<String> setMod = new HashSet<String>();
				for (int i = 0; i < list.size(); i++) {
					setMod.add(list.get(i).getFirstmodname());
				}
				List<HashMap<String, Object>> listMod = new ArrayList<HashMap<String,Object>>();
				for (String firstModname : setMod) {
					HashMap<String, Object> map = new HashMap<String, Object>();
					List<StoreMark> listModName = new ArrayList<StoreMark>();
					for (int i = 0; i < list.size(); i++) {
						if(firstModname.equals(list.get(i).getFirstmodname())){
							listModName.add(list.get(i));	
							map.put("id", list.get(i).getFirstmodid());
						}
					}
					map.put("modName", firstModname);
					map.put("data", listModName);
					listMod.add(map);
				}
				//根据执行id查询主任务id
				String taskid=inspectionModuleService.queryTaskidByExeid(Long.valueOf(exeid));
				List<Object> listReult = new ArrayList<Object>();
				listReult.add(listMod);
				listReult.add(taskid);
				json=ResultData.success(listReult);
			}else{
				ArrayList<StoreMark> listTemp = new ArrayList<StoreMark>();
				json=ResultData.error(listTemp);
			}
		}else{
			json=ResultData.error("执行任务ID不能为空");
		}
		//返回页面
		writeToPage(json);
	}
	
	/**
	 * get
	 * @return
	 */
	public String getTaskId() {
		return taskId;
	}

	/**
	 * set
	 * @param taskId
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	/**
	 * get
	 * @return inspectionModuleService
	 */
	public IInspectionModuleService getInspectionModuleService(){
		return inspectionModuleService;
	}

	/**
	 * set
	 * @param inspectionModuleService
	 */
	public void setInspectionModuleService(
			IInspectionModuleService inspectionModuleService) {
		this.inspectionModuleService = inspectionModuleService;
	}

	/**
	 * get
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * set
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * get
	 * @return selectAllDeptService
	 */
	public ISelectAllDeptService getSelectAllDeptService() {
		return selectAllDeptService;
	}

	/**
	 * set
	 * @param selectAllDeptService
	 */
	public void setSelectAllDeptService(ISelectAllDeptService selectAllDeptService) {
		this.selectAllDeptService = selectAllDeptService;
	}

	/**
	 * get 
	 * @return exeid
	 */
	public String getExeid() {
		return exeid;
	}

	/**
	 * set
	 * @param exeid
	 */
	public void setExeid(String exeid) {
		this.exeid = exeid;
	}

	/**
	 * get
	 * @return storeTaskService
	 */
	public IStoreTaskService getStoreTaskService() {
		return storeTaskService;
	}

	/**
	 * set 
	 * @param storeTaskService
	 */
	public void setStoreTaskService(IStoreTaskService storeTaskService) {
		this.storeTaskService = storeTaskService;
	}

	/**
	 * get 
	 * @return navmod
	 */
	public String getNavmod() {
		return navmod;
	}

	/**
	 * set
	 * @param navmod
	 */
	public void setNavmod(String navmod) {
		this.navmod = navmod;
	}

}
package com.deppon.dpm.store.server.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.deppon.dpm.store.server.dao.IQueryTaskInfoDao;
import com.deppon.dpm.store.server.dao.IUpdateListDao;
import com.deppon.dpm.store.server.entity.QueryAppraisal;
import com.deppon.dpm.store.server.entity.QueryModInfo;
import com.deppon.dpm.store.server.entity.QueryTaskInfo;
import com.deppon.dpm.store.server.entity.StoreLike;
import com.deppon.dpm.store.server.entity.StoreList;
import com.deppon.dpm.store.server.entity.StoreTask;
import com.deppon.dpm.store.server.entity.StoreTaskSublist;
import com.deppon.dpm.store.server.service.IQueryTaskInfoService;
import com.deppon.dpm.store.server.util.IdWorker;
import com.deppon.dpm.store.server.util.OverdueTime;
import com.deppon.dpm.tongxunlu.server.dao.ISelectAllDeptDao;
import com.deppon.dpm.tongxunlu.server.service.ISelectAllDeptService;
import com.deppon.dpm.tongxunlu.shared.domain.SelectAllDeptEntity;
import com.deppon.dpm.tongxunlu.shared.vo.SelectAllDeptVO;

/**
 * @date 2018年6月4日19:22:53
 * @author RY
 *
 */
@Transactional
public class QueryTaskInfoService implements IQueryTaskInfoService {
	// 注入dao
	private IQueryTaskInfoDao queryTaskInfoDao;
	
	//注入
	private IUpdateListDao updateListDao;
	
	// 注入DAO
	private ISelectAllDeptDao selectAllDeptDao;
	
	//注入
	private ISelectAllDeptService SelectAllDeptService;
	
	/**
	 * 日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(QueryTaskInfoService.class);

	/**
	 * 根据执行id 查询考评结果相关信息
	 */
	@Override
	public QueryTaskInfo queryAppraisalByExeid(Long exeid) {
		// 根据执行id 查询考评结果相关信息
		return queryTaskInfoDao.queryAppraisalByExeid(exeid);
	}

	/**
	 * 根据执行id 查询考评详情
	 */
	@Override
	public List<QueryAppraisal> queryAppraisal(Long exeid) {
		//根据执行id查询考评详情
		List<QueryAppraisal> list = queryTaskInfoDao.queryAppraisal(exeid);
		//非空判断
		if(list!=null){
			//循环list
			for (QueryAppraisal queryAppraisal : list) {
				//将图片地址分隔
				List<String> result = Arrays.asList(queryAppraisal.getPhoto().split("-"));
				//非空判断
				if(result!=null){
					//循环
					for(int i=0;i<result.size();i++){
						//分隔图片地址存储
						result.set(i, result.get(i));
					}
				}
				//存储到list中
				queryAppraisal.setPiclist(result);
			}
		}
		//返回list
		return list;
	}

	/**
	 * 添加反馈
	 */
	@Override
	public boolean insertFeedback(Long exeid, String feedbackinfo,String picpath) {
		// TODO Auto-generated method stub
		// 获取当前时间
		Date date = new Date();
		// 格式化时间年月日时分秒
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 将时间转化为string
		String submittime = df.format(date);
		boolean bool = true;
		try {
			int i = queryTaskInfoDao.insertFeedback(exeid, feedbackinfo,picpath);
			if (i > 0) {
				//添加反馈后修改任务子表状态为已反馈,提交时间为当前时间
				queryTaskInfoDao.updatesublist(exeid, submittime);
				//根据执行id查询所有主任务下的所有子任务的任务状态和主任务id
				List<StoreTaskSublist> list = queryTaskInfoDao.queryAllTaskStatusByexeid(exeid);
				//将主任务id取出，赋值给taskid
				Integer taskid = list.get(0).getTaskid();
				// 循环list查看所有任务是否都是已反馈
				boolean bool1 = CycleJudgment(list);
				//是否所有子任务都变为已反馈
				if(bool1){
					//先查询到这个子任务
					StoreTaskSublist subTask = updateListDao.querySubTaskByExeid(exeid);//子任务
					//查询他的主任务
					StoreTask storeTask= updateListDao.queryTask(subTask.getTaskid());
					//更新榜单数据
					updateStoreList(storeTask,subTask);
				}
				// bool1如果为true
				if (bool1 == true) {
					// 将时间转化为string
					String finishtime = df.format(date);
					// 更新任务主表
					queryTaskInfoDao.updatetask(taskid, finishtime);
				}
			} else {
				//bool=fasle
				bool = false;
			}
		} catch (Exception e) {
			logger.info("添加时异常---------------------");
			// TODO: handle exception
			e.printStackTrace();
			bool = false;
			//运行时异常
			throw new RuntimeException();
			
		}
		//返回bool
		return bool;
	}
	
	/**
	 * 更新榜单数据
	 * @author lvdefu
	 * @date   2018年7月4日11:46:37
	 * @param  storeTask
	 * @param  subTask
	 */
	public void updateStoreList(StoreTask storeTask,StoreTaskSublist subTask){
		try {
			//根据创建人id查询是否为专业部门创建
			SelectAllDeptVO selectAllDeptVO = SelectAllDeptService.selectInfoByEmpCode(storeTask.getCreatorcode());
			String psnLevel = selectAllDeptVO.getPsnlevel();
			//如果是专业部门创建
			if("01".equals(psnLevel)){ 
				//根据最新更新时间查询榜单数据
				ArrayList<StoreList> listNew=updateListDao.queryStoreListByTs();
				//根据子任务的执行id,查询主任务下的全部子任务
				List<StoreTaskSublist> listSubTaskAll=updateListDao.querySubTaskAllByExeid(subTask.getExeid());
				//把相同营业部的算到一起,加到一个set里面去掉重复的营业部id
				HashSet<String> setDept = new HashSet<String>();
				for (int j = 0; j < listSubTaskAll.size(); j++) {
					setDept.add(listSubTaskAll.get(j).getDeptnum());
				}
				BigDecimal grade = new BigDecimal("0.0");//默认分数
				ArrayList<StoreTaskSublist> listSubTaskAllNew = new ArrayList<StoreTaskSublist>();
				//遍历set,相同营业部的分数添加到一起算平均分
				for (String deptNum : setDept) {
					BigDecimal countgradeNum = new BigDecimal("0.0");
					List<StoreTaskSublist> listTemp=updateListDao.querySubTask(deptNum,subTask.getTaskid());
					for (int j = 0; j < listTemp.size(); j++) {
					//	grade+=listTemp.get(j).getTestgrade();
						countgradeNum = countgradeNum.add(grade.add(listTemp.get(j).getTestgrade())) ;
					}
					StoreTaskSublist sts = new StoreTaskSublist();
					sts.setExeid(listTemp.get(0).getExeid());//执行id
					sts.setTaskid(listTemp.get(0).getTaskid());//主任务 id
					sts.setDeptlerdername(listTemp.get(0).getDeptlerdername());//营业部负责人id
					sts.setDeptname(listTemp.get(0).getDeptname());//营业部名称
					sts.setDeptnum(listTemp.get(0).getDeptnum());//营业部编码
					sts.setDeptapid(listTemp.get(0).getDeptapid());//营业部负责人工号
					sts.setTestgrade(countgradeNum.divide(new BigDecimal(String.valueOf(listTemp.size())),2, BigDecimal.ROUND_HALF_DOWN)); //保留两位
					listSubTaskAllNew.add(sts);
					grade = new BigDecimal("0.0");
				}	
				//把原有营业部的数据筛选出去
				for (int j = 0; j < listSubTaskAllNew.size(); j++) {
					for (int k = 0; k < listNew.size(); k++) {
						if(listSubTaskAllNew.get(j).getDeptnum().equals(listNew.get(k).getDeptnum())){
							listNew.remove(listNew.get(k));
						}
					}
				}
				//listNew这次添加的营业部
				if(listNew!=null && listNew.size()!=0){
					for (int j = 0; j < listNew.size(); j++) {
						//查询上一次排名
						String rankIng=updateListDao.queryRanking(listNew.get(j).getDeptnum());//要查询最新时间的排名
						listNew.get(j).setRankingnum(rankIng);
					}
				}
				//把这次增加的营业部信息增加进去
				for (int j = 0; j < listSubTaskAllNew.size(); j++) {
					StoreList storeList = new StoreList();
					storeList.setDeptname(listSubTaskAllNew.get(j).getDeptname());//营业部名称
					storeList.setDeptlerdername(listSubTaskAllNew.get(j).getDeptlerdername());//营业部负责人名称
					storeList.setDeptnum(listSubTaskAllNew.get(j).getDeptnum());//营业部编号
					//调用通讯录接口查询头像
					SelectAllDeptEntity entity = selectAllDeptDao.selectAllDeptByempcode(subTask.getDeptapid());
					if(entity!=null){
						storeList.setDepticon(entity.getPictpath()==null?"":entity.getPictpath());//营业部负责人头像
					}else{
						storeList.setDepticon("");//营业部负责人头像
					}
					storeList.setGrade(listSubTaskAllNew.get(j).getTestgrade());//分数
					storeList.setExeid(subTask.getExeid());//执行id
					//storeList.setTaskstatus("已完成");//改为已完成
					storeList.setDr(0);//是否删除
					//查询上一次排名
					String rankIng=updateListDao.queryRanking(listSubTaskAllNew.get(j).getDeptnum());//要查询最新时间的排名
					storeList.setRankingnum(rankIng); //把上一次排名占时方锐到rankingnum,用于后面计算
					listNew.add(storeList);//添加到listnew
				}
				//根据分数排序
				sortDoubleMethod(listNew);
				//循环设置,主键,排名,升降序,重新设置
				for (int j = 0; j < listNew.size(); j++) {
					listNew.get(j).setRanking(String.valueOf(j+1));//排名
					try {
						Date dt = new Date();//获取date
						SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String updatetime = sf.format(dt);//将时间转为string
						listNew.get(j).setUpdatetime(sf.parse(updatetime));//设置更新时间
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						listNew.get(j).setTs(sdf.parse(updatetime));//设置ts
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(listNew.get(j).getRankingnum()==null){
						listNew.get(j).setRankingnum("0");//rankingNum为空说明上次没有排名,升降序设置为0
					}else{
						//排名计算,上一次排名减去本次排名
						int rankingNew = Integer.valueOf(listNew.get(j).getRankingnum()) - (j+1);
						listNew.get(j).setRankingnum(String.valueOf(rankingNew));//排名升降,正数为上升负数为下降
					}	
				}
				// 批量插入榜单
				updateListDao.insertStoreListAll(listNew);
				// 批量插入点赞表
				ArrayList<StoreLike> listStLike = new ArrayList<StoreLike>();
				// for循环
				for (int j = 0; j < listNew.size(); j++) {
					// 根据营业部编码去点赞表查询,如果该营业部存在则更新下,如果不存在则添加
					StoreLike sl=updateListDao.selectStoreLike(listNew.get(j).getDeptnum());
					// 如果sl==null
					if(sl==null){
						// 只插入不存在的,原来营业部的不动
						StoreLike storeLike = new StoreLike();// new对象
						storeLike.setDeptnum(listNew.get(j).getDeptnum());// 营业部编号
						storeLike.setLikenum(0L);// 点赞
						storeLike.setWarningnum(0L);// 警告
						listStLike.add(storeLike);// 添加到liststlike
					}	
				}
				// 非空判断
				if(listStLike!=null && listStLike.size()!=0){
					// 批量插入的点赞
					updateListDao.insertStoreLikeAll(listStLike);
				}	
			}
		} catch (Exception e) {
			logger.info("插入榜单时异常---------------------");
			logger.info("插入榜单时回滚---------------------");
			//运行时异常回滚
			throw new RuntimeException();
		}
	}
	
	
	

	/**
	 * 查询反馈
	 */
	@Override
	public List<QueryAppraisal> queryFeedback(Long exeid) {
		// 查询反馈
		return queryTaskInfoDao.queryFeedback(exeid);
	}

	/**
	 * 添加反馈后 修改任务子表状态为已完成
	 */
	@Override
	public Integer updatesublist(Long exeid, String submittime) {
		// TODO Auto-generated method stub
		return queryTaskInfoDao.updatesublist(exeid, submittime);
	}

	/**
	 * 根据执行id查询所有主任务下的所有子任务的任务状态和主任务id
	 */
	@Override
	public List<StoreTaskSublist> queryAllTaskStatusByexeid(Long exeid) {
		// 根据执行id查询所有主任务下的所有子任务的任务状态和主任务id
		return queryTaskInfoDao.queryAllTaskStatusByexeid(exeid);
	};

	/**
	 * 当子任务都已反馈，根据主任务id来修改主任务状态为已完成，完成时间为当前时间
	 */
	@Override
	public Integer updatetask(Integer taskid, String finishtime) {
		// 当子任务都已反馈，根据主任务id来修改主任务状态为已完成，完成时间为当前时间
		return queryTaskInfoDao.updatetask(taskid, finishtime);
	}

	/**
	 * 
	 * @return
	 */
	public IQueryTaskInfoDao getQueryTaskInfoDao() {
		return queryTaskInfoDao;
	}

	/**
	 * 
	 * @param queryTaskInfoDao
	 */
	public void setQueryTaskInfoDao(IQueryTaskInfoDao queryTaskInfoDao) {
		this.queryTaskInfoDao = queryTaskInfoDao;
	}

	/**
	 * 循环list查看所有任务是否都是已反馈
	 * 
	 * @param list
	 */
	private boolean CycleJudgment(List<StoreTaskSublist> list) {
		// 定义一个布尔值来帮助判断是否都为 已反馈 状态
		boolean bool = true;
		//for循环list
		for (int i = 0; i < list.size(); i++) {
			if (!"已反馈".equals(list.get(i).getTaskstatus())) {
				bool = false;// 将bool1改为false
				break;// 跳出循环
			}
		}
		//返回bool
		return bool;
	}

	/**
	 * 添加模块 (未完成)
	 */
	@Override
	public Boolean insertmod(String firstmodname, String firstremarks,
			String secondmodname, String secondremarks) {
		// 定义返回字符串
		boolean bool = true;
		// 运行时
		try {
			// 随机数
			IdWorker idWorker = new IdWorker();
			// 转化随机数
			String firstmodid = String.valueOf(idWorker.nextId());
			// int i
			int i = queryTaskInfoDao.insertfirstmod(firstmodid, firstmodname,
					firstremarks);
			// int j
			int j = queryTaskInfoDao.insertsecondmod(firstmodid, secondmodname,
					secondremarks);
			// 如果插入成功
			if (i > 0 && j > 0) {
				//true
				bool = true;
			} else {
				//false
				bool = false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			bool = false;
			// 运行时异常
			throw new RuntimeException();
		}
		// 返回值
		return bool;
	}

	/**
	 * 查询所有模块信息
	 */
	@Override
	public List<Map<String, Object>> queryAllModInfo() {
		// 定义List<JSONObject>
		List<Map<String, Object>> json = new ArrayList<Map<String, Object>>();
		// 查询所有模块信息
		List<QueryModInfo> allModInfo = queryTaskInfoDao.queryAllModInfo();
		// 查询模块表的一级模块名称
		List<QueryModInfo> firstmodnamelist = queryTaskInfoDao
				.queryfirstmodname();
		// 组装数据
		if (allModInfo != null && firstmodnamelist != null) {
			// 循环一级模块名称
			for (int i = 0; i < firstmodnamelist.size(); i++) {
				// 定义json
				Map<String, Object> jonum = new HashMap<String, Object>();
				// 定义一个list存储所有二级模块名称
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				// 循环所有模块信息
				for (int j = 0; j < allModInfo.size(); j++) {
					// 存储数据用map
					Map<String, Object> map = new HashMap<String, Object>();
					// 一级模块名称相等则将二级模块名称添加到list中
					if (allModInfo.get(j).getFirstmodname()
							.equals(firstmodnamelist.get(i).getFirstmodname())) {
						// 添加到map
						map.put("tagname", allModInfo.get(j).getSecondmodname());
						map.put("isShow", false);
						map.put("checkgrade", allModInfo.get(j).getCheckgrade());
						map.put("secondmodid", allModInfo.get(j).getSecondmodid());
						map.put("modinfo",  allModInfo.get(j).getModinfo());
						// 添加到list
						list.add(map);
					}
				}

				// 将一级模块名称存入的title中
				jonum.put("title", firstmodnamelist.get(i).getFirstmodname());
				jonum.put("checkallgrade",firstmodnamelist.get(i).getCheckallgrade());
				// 将list存储list中
				jonum.put("list", list);
				// 添加到json
				json.add(jonum);
			}
		}
		// 返回json
		return json;

	}
	/**
	 * 根据执行id查询营业部负责人工号
	 */
	@Override
	public String querydeptapidByExeid(Long exeid) {
		//  根据执行id查询营业部负责人工号
		String deptapid=queryTaskInfoDao.querydeptapidByExeid(exeid);
		// 非空判断
		if(deptapid!=null&&!"".equals(deptapid)){
		// 返回deptapid
			return deptapid;
		}else{
			// 返回空
			return null;
		}
		
	}
	
	/**
	 * 按照List中的某个Double类型的属性进行排序
	 * @param storeListVos0
	 */
	@SuppressWarnings("unchecked")
	public static void sortDoubleMethod(List<StoreList> storeListVos0){
	    Collections.sort(storeListVos0, new Comparator(){
			@Override
			public int compare(Object o1, Object o2) {
				// 定义
				StoreList list1=(StoreList)o1;
				// 定义
				StoreList list2=(StoreList)o2;
				// 如果
				if(list1.getGrade().doubleValue()>list2.getGrade().doubleValue()){
					// 返回-1
					return -1;
					// 如果
				}else if(list1.getGrade()==list2.getGrade()){
					// 返回0
					return 0;
					// 否则
				}else{
					// 返回1
					return 1;
				}
			}	    	
	    });
	}
	/**
	 * 根据传递查询条件(我创建已完成未完成我执行)查询任务信息  
	 */
	@Override
	public List<QueryTaskInfo> selcetTaskByQueryCondition(Map<String, Object> stringmap) {
		// 格式化时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//查询任务信息
		List<QueryTaskInfo> list=queryTaskInfoDao.selcetTaskByQueryCondition(stringmap);
		if(null!=list&&!list.isEmpty()){
			//循环任务信息
			for (QueryTaskInfo queryTaskInfo : list) {
				// 将string类型的时间转化为date
				Date startime=null;
				Date endtime=null;
				try {
					startime = sdf.parse(queryTaskInfo.getStarttime());
					queryTaskInfo.setStarttime(sdf.format(startime));
					endtime = sdf.parse(queryTaskInfo.getEndtime());
					queryTaskInfo.setEndtime(sdf.format(endtime));
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				//取出工具类的必要参数
				String endtime2 = queryTaskInfo.getEndtime();
				//取出工具类的必要参数
				int denominator = queryTaskInfo.getDenominator();
				//取出工具类的必要参数
				int numerator = queryTaskInfo.getNumerator();
				//取出工具类的必要参数
				String sublistendtime = queryTaskInfo.getSublistendtime();
				//调用计算逾期时间工具类
				try {
					//工具类结果存储map
					Map <String,String> map = new HashMap<String, String>();
					//存储结果
					map = OverdueTime.overdue(endtime2, denominator, numerator, sublistendtime);
					//set结果
					queryTaskInfo.setIsoverdue(map.get("Isoverdue"));
					//set结果
					queryTaskInfo.setOverdueTime(map.get("OverdueTime"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//返回list
		return list;
	}
	/**
	 * 
	 * @return
	 */
	public IUpdateListDao getUpdateListDao() {
		return updateListDao;
	}
	/**
	 * 
	 * @param updateListDao
	 */
	public void setUpdateListDao(IUpdateListDao updateListDao) {
		this.updateListDao = updateListDao;
	}
	/**
	 * 
	 * @return
	 */
	public ISelectAllDeptDao getSelectAllDeptDao() {
		return selectAllDeptDao;
	}
	/**
	 * 
	 * @param selectAllDeptDao
	 */
	public void setSelectAllDeptDao(ISelectAllDeptDao selectAllDeptDao) {
		this.selectAllDeptDao = selectAllDeptDao;
	}

	public ISelectAllDeptService getSelectAllDeptService() {
		return SelectAllDeptService;
	}

	public void setSelectAllDeptService(ISelectAllDeptService selectAllDeptService) {
		SelectAllDeptService = selectAllDeptService;
	}
}
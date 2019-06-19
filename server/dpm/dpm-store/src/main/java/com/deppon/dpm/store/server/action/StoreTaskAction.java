package com.deppon.dpm.store.server.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import com.alibaba.fastjson.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jpush.api.utils.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.store.server.entity.StoreMark;
import com.deppon.dpm.store.server.entity.StoreTask;
import com.deppon.dpm.store.server.result.CodeMsg;
import com.deppon.dpm.store.server.service.IStoreMarkService;
import com.deppon.dpm.store.server.service.IStoreTaskService;
import com.deppon.dpm.store.server.util.IdWorker;
import com.deppon.dpm.store.server.util.JsonToClass;
import com.deppon.dpm.store.server.util.ResultData;
import com.deppon.dpm.store.server.util.UploadPic;
import com.deppon.dpm.store.server.vo.LabelVo;
import com.deppon.dpm.store.server.vo.StoreTaskVo;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;

/**
 * 创建任务 Action
 * 
 * @className:StoreTaskAction
 * @author XiaoTian
 * @date 2018年5月24日18:48:08
 */
@SuppressWarnings("unused")
public class StoreTaskAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6811507640001643033L;
	/**
	 * 创建任务需要参数
	 */
	// 任务名称
	private String taskname;
	// 任务描述
	private String taskinfo;
	// 创建人
	private String creatorname;
	// 任务类型
	private String tasktype;
	// 开始时间
	private String starttime;
	// 结束时间
	private String endtime;
	// 任务状态
	private String taskstatus;
	// 创建人编号
	private String creatorcode;
	// 巡检模块
	private String checkingModule;
	// 执行人部门
	private String executorDepartment;
	// 图片
	private String picture;
	// 执行id
	private String exeid;
	// 主任务id
	private String taskid;
	/**
	 * 任务巡检模块打分需要参数
	 */
	private String storeMark;
	/**
	 * 日志
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(StoreTaskAction.class);
	/**
	 * 注入任务表
	 */
	private IStoreTaskService storeTaskService;

	/**
	 * 注入打分模块
	 */
	private IStoreMarkService storeMarkService;
	/**
	 * 返回错误名称
	 */
	private final String ERROR = "error";
	/**
	 * 返回错误成功
	 */
	private final String SUCCESS = "success";

	/**
	 * 创建任务
	 * 
	 * @author XiaoTian
	 * @date 2018年5月24日18:49:08
	 */
	@SuppressWarnings("all")
	//@CookieNotCheckedRequired
	public void createTask() {
		logger.info("执行createTask()开始校验参数-------------");
		JSONObject jonum = new JSONObject();
		// 开始验证信息是否为空
		if (!isNotEmpty(taskname, taskinfo, starttime, endtime, creatorname,
				taskstatus, creatorcode, executorDepartment, checkingModule)) {
			// 判断前端存储值是否为空
			logger.info("执行createTask()校验参数失败-------------");
			jonum.put(ERROR, CodeMsg.Task_BIND_ERROR);
		} else {
			// 实例化任务类
			StoreTask storeTask = new StoreTask();
			try {
				storeTask.setStarttime(parse(starttime));// starttime 开始时间
				storeTask.setEndtime(parse(endtime));// endtime 结束时间
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				logger.error("创建任务日期转换失败");
				e1.printStackTrace();
			}
			// 添加数据
			storeTask.setTaskname(taskname);// taskname
			storeTask.setTaskinfo(taskinfo);// taskinfo
			storeTask.setCreatorname(creatorname);// taskinfo //创建人
			storeTask.setTasktype(tasktype);// tasktype 任务类型
			storeTask.setTaskstatus("进行中");// taskstatus 任务状态
			storeTask.setCreatorcode(creatorcode);// creatorcode
			storeTask.setDr(0); // 0默认为，显示数据
			storeTask.setTs(new Date());// 默认当前时间
			// 添加任务记录
			try {
				// 将json字符串转换为ArrayList对象
				ArrayList<StoreTaskVo> storeTaskVoslist = (ArrayList<StoreTaskVo>) JsonToClass.Tolist(executorDepartment, StoreTaskVo.class);
				// 将json字符串转换为ArrayList对象
				ArrayList<Integer> stringsarray = (ArrayList<Integer>) JsonToClass.Tolist(checkingModule, Integer.class);
				// 开始添加任务所有信息
				storeTaskService.insertTask(storeTask, stringsarray,storeTaskVoslist);
				jonum.put(SUCCESS, CodeMsg.SUCCESS);
			} catch (ClassCastException e) {
				// TODO: handle exception
				e.printStackTrace();
				logger.error("转换json异常------------");
				jonum.put(ERROR, CodeMsg.Task_JSON_ERROR);
			} catch (Exception e) {
				e.printStackTrace();
				logger.info("创建任务失败-------------");
				jonum.put(ERROR, CodeMsg.Task_ERROR);
			}
		}
		writeToPage(jonum);
	}

	/**
	 * 模块打分
	 * 
	 * @author XiaoTian
	 * @date 2018年5月30日13:48:00
	 * */
	@SuppressWarnings("all")
	//@CookieNotCheckedRequired
	public void createMark() {
		JSONObject jonum = new JSONObject();
		logger.info("模块打分开始-------------");
		if (!isNotEmpty(storeMark, exeid)) {
			jonum.put(ERROR, CodeMsg.Mark_Task_ERROR);
		} else {
			try {
				/**
				 * json对象转换
				 */
				Map<String, Class<LabelVo>> map1 = new HashMap<String, Class<LabelVo>>();
				// json对象里的arraylabel对象需要声明一个Map
				map1.put("arraylabel", LabelVo.class);
				ArrayList<StoreMark> storeMark = (ArrayList<StoreMark>) JsonToClass.Tolist(this.storeMark, StoreMark.class, map1);
				// 循环查询模块是否打分
				int num = storeMarkService.selectList(storeMark);
				if (num == 0) {
					boolean bool = storeMarkService.insertMark(storeMark, exeid);
					// 返回
					jonum.put(SUCCESS, bool ? CodeMsg.SUCCESS : CodeMsg.Mark__ERROR);
				} else {
					// 当前模块有模块已经打分 -------------
					logger.error("当前模块有模块已经打分 -------------");
					jonum.put(SUCCESS, CodeMsg.Mark_JSON_exist);
				}
			} catch (ClassCastException e) {
				// TODO: handle exception
				e.printStackTrace();
				logger.error("转换json异常------------");
				jonum.put(ERROR, CodeMsg.Task_JSON_ERROR);
			} catch (Exception e) {
				// 打分异常,操作失败 -------------
				e.printStackTrace();
				logger.error("打分异常,操作失败 -------------");
				jonum.put(SUCCESS, CodeMsg.Mark__ERROR);
			}
		}
		writeToPage(jonum);
	}

	/**
	 * 定义参数
	 * 
	 * @param picture
	 *            图片json字符串
	 * @param exeid
	 *            必须是 serialVersionUID
	 */
	@SuppressWarnings("all")
	//@CookieNotCheckedRequired
	public void pric() {
		JSONObject jonum = new JSONObject();
		logger.info("图片上传开始-------------");
		if (StringUtils.isEmpty(picture) && exeid.equals(serialVersionUID)) {
			jonum.put(ERROR, CodeMsg.Mark_JSON_pric);
		} else {
			try {
				List<String> pictureString = new ArrayList<String>();
				ArrayList<String> stringsarray = (ArrayList<String>) JsonToClass.Tolist(picture, String.class);
				for (String string : stringsarray) {
					StringBuffer img = new StringBuffer();
					UploadPic uploadPic = new UploadPic();
					String imgName = uploadPic.stringImgSuffix(string);
					img.append(imgName);
					pictureString.add(img.toString());
					UploadPic.Base64ToImage(string, imgName);
				}
				jonum.put("picture", pictureString);
			} catch (Exception e) {
				// TODO: handle exception
				// 打分异常,操作失败 -------------
				e.printStackTrace();
				logger.error("打分异常,操作失败 -------------");
				jonum.put(SUCCESS, CodeMsg.Mark_JSON_pric);
			}
			writeToPage(jonum);
		}
	}

	/**
	 * 任务编辑
	 * 
	 * @author XiaoTian
	 * @date 2018年8月4日9:11:00
	 * */
	@SuppressWarnings("all")
	//@CookieNotCheckedRequired
	public void taskUpdate() {
		JSONObject jonum = new JSONObject();
		logger.info("任务编辑开始-------------");
		if (!isNotEmpty(taskid, executorDepartment, checkingModule)) {
			logger.error("修改主任务失败 参数错误-------------");
			jonum = ResultData.error("修改主任务失败");
		} else {
			StoreTask storeTask = new StoreTask();
			storeTask.setTaskid(Integer.valueOf(taskid));// 任务id
			storeTask.setTaskname(taskname);// 任务名称
			storeTask.setTaskinfo(taskinfo);// 任务描述
			try {
				storeTask.setEndtime(parse(endtime));// 任务结束时间
				storeTask.setStarttime(parse(starttime));// 任务开始时间
				// 将json字符串转换为ArrayList对象
				ArrayList<StoreTaskVo> storeTaskVoslist = (ArrayList<StoreTaskVo>) JsonToClass.Tolist(executorDepartment, StoreTaskVo.class);
				// 将json字符串转换为ArrayList对象
				ArrayList<Integer> stringsarray = (ArrayList<Integer>) JsonToClass.Tolist(checkingModule, Integer.class);
				// 添加任务记录
				storeTaskService.taskUpdate(storeTask, stringsarray,storeTaskVoslist);
				jonum = ResultData.success("任务修改成功");
			} catch (ClassCastException e) {
				// TODO: handle exception
				e.printStackTrace();
				logger.error("转换json异常------------");
				jonum = ResultData.error("转换json异常");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				logger.error("修改主任务时间类型转换失败-------------");
				e.printStackTrace();
				jonum = ResultData.error("修改主任务时间类型转换失败");
			} catch (Exception e){
				logger.error("修改主任务操作失败 -------------");
				jonum = ResultData.error("修改主任务操作失败");
			}
		}
		writeToPage(jonum);
	}

	// 日期转换 String 转换为 Date
	private static Date parse(String time) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date datestarttime = formatter.parse(time);
		return datestarttime;
	}

	// 判断所有值是否为空有一个为空返回fasle
	private static boolean isNotEmpty(String... age) {
		boolean bool = true;
		for (String value : age) {
			if (StringUtils.isEmpty(value)) {
				bool = false;
				break;
			}
		}
		return bool;
	}

	/**
	 * 
	 * @return
	 */
	public IStoreTaskService getStoreTaskService() {
		return storeTaskService;
	}

	/**
	 * 
	 * @param storeTaskService
	 */
	public void setStoreTaskService(IStoreTaskService storeTaskService) {
		this.storeTaskService = storeTaskService;
	}

	/**
	 * 
	 * @return
	 */
	public String getTaskname() {
		return taskname;
	}

	/**
	 * 
	 * @param taskname
	 */
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	/**
	 * 
	 * @return
	 */
	public String getTaskinfo() {
		return taskinfo;
	}

	/**
	 * 
	 * @param taskinfo
	 */
	public void setTaskinfo(String taskinfo) {
		this.taskinfo = taskinfo;
	}

	/**
	 * 
	 * @return
	 */
	public String getCreatorname() {
		return creatorname;
	}

	/**
	 * 
	 * @param creatorname
	 */
	public void setCreatorname(String creatorname) {
		this.creatorname = creatorname;
	}

	/**
	 * 
	 * @return
	 */
	public String getTasktype() {
		return tasktype;
	}

	/**
	 * 
	 * @param tasktype
	 */
	public void setTasktype(String tasktype) {
		this.tasktype = tasktype;
	}

	/**
	 * 
	 * @return
	 */
	public String getStarttime() {
		return starttime;
	}

	/**
	 * 
	 * @param starttime
	 */
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	/**
	 * 
	 * @return
	 */
	public String getEndtime() {
		return endtime;
	}

	/**
	 * 
	 * @param endtime
	 */
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	/**
	 * 
	 * @return
	 */
	public String getTaskstatus() {
		return taskstatus;
	}

	/**
	 * 
	 * @param taskstatus
	 */
	public void setTaskstatus(String taskstatus) {
		this.taskstatus = taskstatus;
	}

	/**
	 * 
	 * @return
	 */
	public String getCheckingModule() {
		return checkingModule;
	}

	/**
	 * 
	 * @param checkingModule
	 */
	public void setCheckingModule(String checkingModule) {
		this.checkingModule = checkingModule;
	}

	/**
	 * 
	 * @return
	 */
	public String getCreatorcode() {
		return creatorcode;
	}

	/**
	 * 
	 * @param creatorcode
	 */
	public void setCreatorcode(String creatorcode) {
		this.creatorcode = creatorcode;
	}

	/**
	 * 
	 * @return
	 */
	public String getExecutorDepartment() {
		return executorDepartment;
	}

	/**
	 * 
	 * @param executorDepartment
	 */
	public void setExecutorDepartment(String executorDepartment) {
		this.executorDepartment = executorDepartment;
	}

	/**
	 * 
	 * @return
	 */
	public String getStoreMark() {
		return storeMark;
	}

	/**
	 * 
	 * @param storeMark
	 */
	public void setStoreMark(String storeMark) {
		this.storeMark = storeMark;
	}

	/**
	 * 
	 * @return
	 */
	public IStoreMarkService getStoreMarkService() {
		return storeMarkService;
	}

	/**
	 * 
	 * @param storeMarkService
	 */
	public void setStoreMarkService(IStoreMarkService storeMarkService) {
		this.storeMarkService = storeMarkService;
	}

	/**
	 * 
	 * @return
	 */
	public String getExeid() {
		return exeid;
	}

	/**
	 * 
	 * @param exeid
	 */
	public void setExeid(String exeid) {
		this.exeid = exeid;
	}

	/**
	 * 
	 * @return
	 */
	public String getPicture() {
		return picture;
	}

	/**
	 * 
	 * @param picture
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}

	/**
	 * 
	 * @return
	 */
	public String getTaskid() {
		return taskid;
	}

	/**
	 * 
	 * @param taskid
	 */
	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}
}

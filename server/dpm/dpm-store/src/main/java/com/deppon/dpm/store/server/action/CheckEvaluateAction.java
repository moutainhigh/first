package com.deppon.dpm.store.server.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cn.jpush.api.utils.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.store.server.entity.StoreTask;
import com.deppon.dpm.store.server.entity.StoreTaskSublist;
import com.deppon.dpm.store.server.result.CheckEvaluateMsg;
import com.deppon.dpm.store.server.service.ICheckEvaluateService;
import com.deppon.dpm.store.server.util.ListPageUtil;
import com.deppon.dpm.tongxunlu.server.service.ISelectAllDeptService;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;
import com.deppon.dpm.tongxunlu.shared.domain.SelectAllDeptEntity;
import com.deppon.dpm.tongxunlu.shared.vo.SelectAllDeptVO;

/**
 * @Desciption:TODO(考核评价)
 * @author lvdefu
 * @date   2018年6月4日10:36:03
 * @className:CheckEvaluateAction
 */
public class CheckEvaluateAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6268368773302680714L;
	
	/**
	 * 打印日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(CheckEvaluateAction.class);
	
	//工号
	private String userId;
	
	//注入考核评价service
	private ICheckEvaluateService CheckEvaluateService;
	
	//注入通讯录service
	private ISelectAllDeptService selectAllDeptService;
	
	//失败返回
	private static final String ERROR = "error";
	
	//成功返回
	private final String SUCCESS = "success";
	
	//当前页
	private int nowPage=1;
	
	//每页条数
	private int pageSize=10;
	
	//营业部名称
	private String deptName;
	
	//deptseq
	private String deptseq;
	
	//级别
	private String psnlevel;

	/**
	 * 查询考核列表
	 */
	@SuppressWarnings("all")
	//@CookieNotCheckedRequired
	public void checkList(){
		logger.info("查询考核列表开始------------");
		JSONObject jonum = new JSONObject();
		if(StringUtils.isNotEmpty(userId) && StringUtils.isNotEmpty(deptseq) && StringUtils.isNotEmpty(psnlevel)){
			ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
			//营业部编号
			ArrayList<String>listBusiness=new ArrayList<String>();
			List<SelectAllDeptVO> listDeptVO = selectAllDeptService.selectAll(userId,deptseq,psnlevel,null,null,null,null);
			//当前登录人是营业部经理时候,需要判断具体为哪个经理，所以需要传入经理的工号
			if("05".equals(psnlevel)){
				listBusiness.add(userId);
			}else{
				listBusiness.add("");
			}
			//放入营业部编号
			if(listDeptVO!=null && listDeptVO.size()!=0){
				for (int i = 0; i < listDeptVO.size(); i++) {
					if(listDeptVO.get(i)!=null){
						listBusiness.add(listDeptVO.get(i).getOrgcode());//放入营业部编号
					}	
				}
			}	
			if(listBusiness!=null && listBusiness.size()!=0){
				String deptaId=listBusiness.get(0);//部门负责人id
				listBusiness.remove(0);
				//根据营业部ID数组查询子任务,根据时间逆排序
				List<StoreTaskSublist> listSubTasks = CheckEvaluateService.querySubTasksByArray(listBusiness,deptaId,deptName);
				if(listSubTasks!=null){
					for (int i = 0; i < listSubTasks.size(); i++) {
						HashMap<String, Object> map = new HashMap<String,Object>();
						//根据主任务ID查询主任务
						StoreTask task = CheckEvaluateService.queryTaskByTaskid(listSubTasks.get(i).getTaskid());
						if(task!=null){
							map.put("taskName", task.getTaskname());//主任务名称
						}else{
							map.put("taskName", "");//主任务名称
						}
						//根据执行人ID查询执行人信息
						SelectAllDeptEntity exeer = selectAllDeptService.selectdpmAdmin(listSubTasks.get(i).getExeerid());//查询执行人信息
						map.put("deptName", listSubTasks.get(i).getDeptname()==null?"":listSubTasks.get(i).getDeptname());//营业部名称
						map.put("testgrade", listSubTasks.get(i).getTestgrade()==null?0:listSubTasks.get(i).getTestgrade());//自检总分
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						map.put("endtime",listSubTasks.get(i).getAppraisaltime()==null?"":formatter.format(listSubTasks.get(i).getAppraisaltime()));//检查时间
						map.put("exeer", listSubTasks.get(i).getExeer()==null?"":listSubTasks.get(i).getExeer());//执行人
						map.put("taskstatus",listSubTasks.get(i).getTaskstatus()==null?"":listSubTasks.get(i).getTaskstatus());//任务状态
						map.put("exeid",listSubTasks.get(i).getExeid()==null?"":String.valueOf(listSubTasks.get(i).getExeid()));//执行id
						map.put("orgName", exeer.getOrgname()==null?"":exeer.getOrgname());//执行人组织名称
						map.put("jobName", exeer.getJobname()==null?"":exeer.getJobname());//执行人组织名称
						list.add(map);
					}
					//调用工具类分页
					ListPageUtil<HashMap<String, Object>> listPageUtil = new ListPageUtil<HashMap<String,Object>>( list, nowPage, pageSize);
					int totalPage = listPageUtil.getTotalPage();//总页数
					//请求的当前页数小于等于总页数,返回分页数据,大于时候返回空数组
					if(nowPage<=totalPage){
						List<HashMap<String, Object>> listNew = listPageUtil.getPagedList();
						jonum.put(SUCCESS, "查询成功");
						jonum.put("list",listNew);
					}else{
						List<HashMap<String, Object>> listNew= new ArrayList<HashMap<String, Object>>();
						jonum.put(SUCCESS, "查询成功");
						jonum.put("list",listNew);
					}
				}else{
					jonum.put(SUCCESS, "查询成功");
					jonum.put("msg", CheckEvaluateMsg.NO_SUBMISSION_ERROR);
					//放入JsonObject
					jonum.put("list", list);
				}	
			}else{
				jonum.put(SUCCESS, "查询成功");
				jonum.put("msg",CheckEvaluateMsg.BUSINESS_ERROR);	
				//放入JsonObject
				jonum.put("list", list);
			}
		}else{
			jonum.put(ERROR, "查询失败");
			jonum.put(ERROR, CheckEvaluateMsg.USERID_ERROR);
		}
		writeToPage(jonum);
		logger.info("查询考核列表结束------------");
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
	 * @return  CheckEvaluateService
	 */
	public ICheckEvaluateService getCheckEvaluateService() {
		return CheckEvaluateService;
	}

	/**
	 * set
	 * @param checkEvaluateService
	 */
	public void setCheckEvaluateService(ICheckEvaluateService checkEvaluateService) {
		CheckEvaluateService = checkEvaluateService;
	}


	/**
	 * get 
	 * @return  selectAllDeptService
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

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public String getDeptName() {
		return deptName;
	}



	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptseq() {
		return deptseq;
	}

	public void setDeptseq(String deptseq) {
		this.deptseq = deptseq;
	}

	public String getPsnlevel() {
		return psnlevel;
	}

	public void setPsnlevel(String psnlevel) {
		this.psnlevel = psnlevel;
	}
}
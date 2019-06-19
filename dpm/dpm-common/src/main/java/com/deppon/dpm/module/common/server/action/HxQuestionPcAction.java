package com.deppon.dpm.module.common.server.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.service.IHxQuestionPcService;
import com.deppon.dpm.module.common.server.util.ServletUtil;

/**
 * 欢行常见问题以及答案 管理
 * 2018-09-07
 */
public class HxQuestionPcAction extends BaseAction{
	
	/**
	 * 序列化id
	 */
	private static final long serialVersionUID = 5447499379440386212L;
	
	/**
	 * 日志
	 */
	private final static Logger LOG = LoggerFactory.getLogger(HxQuestionPcAction.class);
	
	//错误状态码
	private static final int STATUS_500 = 500;
	
	//增加成功状态码
	private static final int STATUS_201 = 201;
	
	//修改成功状态码
	private static final int STATUS_204 = 204;
	
	//问题编号
	private int id;
	
	//问题编号s，以,分隔的字符串
	private String ids;
	
	//跳转的页面类型
	private String pageType;
	
	//操作类型
	private String operation;
	
	//update id
	private int updateid;
	
	//问题名称
	private String question;
	
	//答案
	private String answer;
	
	//当前页
	private int page;
	
	//每页显示条数
	private int rows;
	
	//service
	private IHxQuestionPcService hxQuestionPcService;
	
	/**
	 * 页面跳转
	 */
	public String toPage(){
		return pageType;
	}
	
	/**
	 * 新增app permission信息
	 */
	public void insertOrUpdate(){
		//操作的数据条数
		int i = 0;
		//如果是保存操作
		if("save".equals(operation)){
			try {
				JSONObject hotLine = new JSONObject();
				hotLine.put("question", question);
				hotLine.put("answer", answer);
				//保存数据
				i = hxQuestionPcService.insert(hotLine);
				if( i == 1){
					//保存成功的状态码
					ServletUtil.getResponse().setStatus(STATUS_201);
				}else{
					//保存失败的状态码
					ServletUtil.getResponse().setStatus(STATUS_500);
				}
			} catch (Exception e) {
				//错误状态码
				ServletUtil.getResponse().setStatus(STATUS_500);
				//日志
				LOG.error("新增hot line信息出错>>>>:",e);
			}
		}else if("update".equals(operation)){ //更新操作
			try {
				JSONObject hotLine = new JSONObject();
				hotLine.put("id", updateid);
				hotLine.put("question", question);
				hotLine.put("answer", answer);
				//更新
				i = hxQuestionPcService.update(hotLine);
				if( i == 1){
					//更新成功的状态码
					ServletUtil.getResponse().setStatus(STATUS_204);
				}else{
					//更新失败的状态码
					ServletUtil.getResponse().setStatus(STATUS_500);
				}
			} catch (Exception e) {
				//错误状态码
				ServletUtil.getResponse().setStatus(STATUS_500);
				//日志
				LOG.error("修改hot line信息出错>>>>:",e);
			}
		}else{
			//错误状态码
			ServletUtil.getResponse().setStatus(STATUS_500);
		}
	}
	
	/**
	 * 删除
	 */
	public void delete(){
		// 判断是否为空
		if(StringUtils.isEmpty(ids)){
			//返回500
			ServletActionContext.getResponse().setStatus(STATUS_500);
			return;
		}
		try {
			hxQuestionPcService.deleteByApplyCodes(ids);
			//删除成功返回204
			ServletActionContext.getResponse().setStatus(STATUS_204);
		} catch (Exception e) {
			//出现异常，返回500
			ServletActionContext.getResponse().setStatus(STATUS_500);
		}
	}
	
	/**
	 * 列表
	 */
	public void list(){
		//分页查询起始索引
		int begin = (page - 1) * rows;
		//定义返回的数据列表
		List<Map<String,Object>> list = null;
		try {
			//查询列表数据
			list = hxQuestionPcService.queryList(begin,rows);
		} catch (Exception e) {
			//日志
			LOG.error("查询hot line信息列表出错!!!", e);
		}
		//查询总的数据条数
		long count = hxQuestionPcService.queryCount();
		//需要转为json的数据
		Map<String,Object> map = new HashMap<String,Object>();
		//封装数据
		map.put("rows", list);
		map.put("total", count);
		//写入页面
		writeToPage(map);
	}
	
	//getter
	public int getId() {
		return id;
	}

	//setter
	public void setid(int id) {
		this.id = id;
	}

	//getter
	public String getPageType() {
		return pageType;
	}

	//setter
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

	//getter
	public int getPage() {
		return page;
	}
	
	//setter
	public void setPage(int page) {
		this.page = page;
	}

	//getter
	public int getRows() {
		return rows;
	}

	//setter
	public void setRows(int rows) {
		this.rows = rows;
	}

	//getter
	public String getOperation() {
		return operation;
	}
	
	//setter
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	//getter
	public String getIds() {
		return ids;
	}

	//setter
	public void setIds(String ids) {
		this.ids = ids;
	}
	
	//setter
	public void setHxQuestionPcService(
			IHxQuestionPcService hxQuestionPcService) {
		this.hxQuestionPcService = hxQuestionPcService;
	}

	public int getUpdateid() {
		return updateid;
	}

	public void setUpdateid(int updateid) {
		this.updateid = updateid;
	}
	

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
